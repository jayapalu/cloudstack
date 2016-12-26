package com.cloud.network.dao;

import com.cloud.utils.db.DB;
import com.cloud.utils.db.GenericDaoBase;
import com.cloud.utils.db.SearchBuilder;
import com.cloud.utils.db.SearchCriteria;
import com.cloud.utils.db.Transaction;
import com.cloud.utils.db.TransactionCallbackNoReturn;
import com.cloud.utils.db.TransactionStatus;
import org.springframework.stereotype.Component;

import javax.ejb.Local;
import java.util.ArrayList;
import java.util.List;

@Component
@Local(value = FirewallRulesDcidrsDao.class)
public class FirewallRulesDcidrsDaoImpl extends GenericDaoBase<FirewallRulesDestCidrsVO, Long> implements FirewallRulesDcidrsDao {

    protected final SearchBuilder<FirewallRulesDestCidrsVO> cidrsSearch;

    protected FirewallRulesDcidrsDaoImpl(){
        cidrsSearch = createSearchBuilder();
        cidrsSearch.and("firewallRuleId", cidrsSearch.entity().getFirewallRuleId(), SearchCriteria.Op.EQ);
        cidrsSearch.done();

    }

    @Override
    @DB
     public List<String> getDestCidrs(long firewallRuleId){
        SearchCriteria<FirewallRulesDestCidrsVO> sc =cidrsSearch.create();
        sc.setParameters("firewallRuleId", firewallRuleId);

        List<FirewallRulesDestCidrsVO> results = search(sc, null);

        List<String> cidrs = new ArrayList<String>(results.size());
        for (FirewallRulesDestCidrsVO result : results) {
            cidrs.add(result.getCidr());
        }

        return cidrs;
    }

    @Override
    @DB
    public void persist(final long firewallRuleId, final List<String> destCidrs){
        Transaction.execute(new TransactionCallbackNoReturn() {
            @Override
            public void doInTransactionWithoutResult(TransactionStatus status) {
                for(String cidr: destCidrs){
                    FirewallRulesDestCidrsVO vo = new FirewallRulesDestCidrsVO(firewallRuleId, cidr);
                    persist(vo);
                }
            }
        });
    }


}
