package com.cloud.network.dao;

import org.apache.cloudstack.api.InternalIdentity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = ("firewall_rules_dcidrs"))
public class FirewallRulesDestCidrsVO implements InternalIdentity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "firewall_rule_id")
    private long firewallRuleId;

    @Column(name = "destination_cidr")
    private String destCidr;

    public FirewallRulesDestCidrsVO(){

    }

    public FirewallRulesDestCidrsVO(long firewallRuleId, String destCidr){
        this.firewallRuleId = firewallRuleId;
        this.destCidr = destCidr;
    }

    public long getFirewallRuleId(){
        return firewallRuleId;
    }

    public String getCidr(){
        return destCidr;
    }

    @Override
    public long getId() {
        return id;
    }
}