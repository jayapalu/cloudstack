package com.cloud.network.dao;

import com.cloud.utils.db.GenericDao;

import java.util.List;

public interface FirewallRulesDcidrsDao extends GenericDao<FirewallRulesDestCidrsVO, Long> {

    void persist(long firewallRuleId, List<String> destCidrs);

    List<String> getDestCidrs(long firewallId);
}