// Licensed to the Apache Software Foundation (ASF) under one
// or more contributor license agreements.  See the NOTICE file
// distributed with this work for additional information
// regarding copyright ownership.  The ASF licenses this file
// to you under the Apache License, Version 2.0 (the
// "License"); you may not use this file except in compliance
// with the License.  You may obtain a copy of the License at
//
//   http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing,
// software distributed under the License is distributed on an
// "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
// KIND, either express or implied.  See the License for the
// specific language governing permissions and limitations
// under the License.

package com.cloud.upgrade.dao;

import com.cloud.utils.exception.CloudRuntimeException;
import com.cloud.utils.script.Script;
import org.apache.log4j.Logger;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Upgrade4920to41000 implements DbUpgrade {
    final static Logger LOG = Logger.getLogger(Upgrade4920to41000.class);

    @Override
    public String[] getUpgradableVersionRange() {
        return new String[] {"4.9.2.0", "4.10.0.0"};
    }

    @Override
    public String getUpgradedVersion() {
        return "4.10.0.0";
    }

    @Override
    public boolean supportsRollingUpgrade() {
        return false;
    }

    @Override
    public File[] getPrepareScripts() {
        String script = Script.findScript("", "db/schema-4920to41000.sql");
        if (script == null) {
            throw new CloudRuntimeException("Unable to find db/schema-4920to41000.sql");
        }
        return new File[] {new File(script)};
    }

    @Override
    public void performDataMigration(Connection conn) {
        updateSourceCidrs(conn);
    }

    @Override
    public File[] getCleanupScripts() {
        String script = Script.findScript("", "db/schema-4920to41000-cleanup.sql");
        if (script == null) {
            throw new CloudRuntimeException("Unable to find db/schema-4920to41000-cleanup.sql");
        }
        return new File[] {new File(script)};
    }


    private void updateSourceCidrs(Connection conn){
        try(PreparedStatement pstmt = conn.prepareStatement("UPDATE `cloud`.`firewall_rules_cidrs` AS s, (SELECT `networks`.`cidr`, `firewall_rules_cidrs`.`id`, " +
                "`firewall_rules`.`traffic_type` "+
                "FROM `cloud`.`networks`, `cloud`.`firewall_rules`,`cloud`.`firewall_rules_cidrs` WHERE `cloud`.`networks`.`id`=`cloud`.`firewall_rules`.`network_id` " +
                "AND `cloud`.`firewall_rules`.`id` = `cloud`.`firewall_rules_cidrs`.`firewall_rule_id`) AS p " +
                "SET `s`.`source_cidr` = `p`.`cidr` WHERE `s`.`source_cidr`=\"0.0.0.0/0\" AND `s`.`id`=`p`.`id` AND `p`.`traffic_type`=\"Egress\" ;")){
            pstmt.execute();
        }catch (SQLException e) {
            throw new CloudRuntimeException("updateSourceCidrs:Exception:" + e.getMessage(), e);
        }
    }

}
