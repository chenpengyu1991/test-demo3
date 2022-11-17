package com.founder.rhip.ehr.repository.child;

import com.founder.fasf.beans.ClassMetadata;
import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Order;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.entity.child.ChEtbjXmgztz;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * DAO implement of ChEtbjJd
 * 
 */
@Repository("chEtbjXmgztzDaoImpl")
public class ChEtbjXmgztzDaoImpl extends AbstractDao<ChEtbjXmgztz, Long> implements IChEtbjXmgztzDao {

    @Resource(name = "msdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;

    /**
     * 0-6岁儿童项目工作台账
     * @param criteria
     * @param order
     * @return
     */
    @Override
    public List<Map<String, Object>> queryEtbjXmgztzList(Criteria criteria, Order order) {
        return this.getMapList(criteria, order);
    }

    /**
     * 根据查询条件获取0-6岁儿童项目的合计数据
     * @param criteria
     * @return
     */
    @Override
    public Map<String, Object> queryTotalEtbjXmgztzGroupByNf(Criteria criteria) {
        StringBuilder sql = new StringBuilder("select nf, case when count(nf)= 0 then 0 else sum(XQRKS)/count(nf) end XQRKS,--辖区人口数\n" +
                "case when count(nf)= 0 then 0 else max(CSL) end CSL,--出生率\n" +
                "case when count(nf)= 0 then 0 else sum(LSSMBETS)/count(nf) end LSSMBETS,--0-3岁目标儿童数\n" +
                "case when count(nf)= 0 then 0 else sum(LLSMBETS)/count(nf) end LLSMBETS,--0-6岁目标儿童数\n" +
                "case when count(nf)= 0 then null else max(GWMC) end GWMC,--单位名称\n" +
                "case when count(nf)= 0 then null else max(TBR) end TBR,--填报人\n" +
                "case when count(nf)= 0 then null else max(TBRQ) end TBRQ--填报日期\n" +
                "from CH_ETBJ_XMGZTZ ex where 1=1");
        ClassMetadata cMetadata = ClassMetadata.getMetadata(ChEtbjXmgztz.class);
        if(ObjectUtil.isNotEmpty(criteria)) {
            sql.append(" and ");
            sql.append(criteria.toSql(cMetadata, ":", "ex"));
        }
        sql.append(" group by nf");
        return this.getMap(sql.toString(), criteria);
    }
}