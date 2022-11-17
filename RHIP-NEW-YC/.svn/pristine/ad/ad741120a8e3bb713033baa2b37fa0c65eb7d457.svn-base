package com.founder.rhip.ehr.repository.child;

import com.founder.fasf.beans.*;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.entity.child.ChEtbjJd;
import com.founder.rhip.ehr.entity.child.WomenChildHealth;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.Map;

/**
 * DAO implement of ChEtbjJd
 * 
 */
@Repository("chEtbjJdDao")
public class ChEtbjJdDaoImpl extends AbstractDao<ChEtbjJd, Long> implements IChEtbjJdDao {
    @Resource(name = "msdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;

    /**
     * 儿童花名册台账
     * @param page
     * @param criteria
     * @param order
     * @return
     */
    @Override
    public PageList<Map<String, Object>> queryChEtbjJdPageList(Page page, Criteria criteria, Order order) {
        StringBuilder sql = new StringBuilder("select rownum as num, r.* from (select * from (\n");
        sql.append("select XM,--姓名\n" +
                "xb,--性别\n" +
                "CSRQ,--出生日期\n" +
                "mqxm,--母亲姓名\n" +
                "xzz,--现住址\n" +
                "ZCJG_MC,--助产机构名称\n" +
                "CZLX_MC,--户籍类型\n" +
                "CZLX_DM,--常住类型代码\n" +
                "MQLXDH,--母亲联系电话\n" +
                "case when EXISTS(select id from CH_ETBJ_XSEFS xs where xs.ETXXBH = jd.ETXXBH) then '是' else '否' end is_fo_shi,\n" +
                "case when EXISTS(select id from CH_ETBJ_JKJCONE one where one.ETXXBH = jd.ETXXBH and ETJKJCYNL_DM='1') then '是' else '否' end is_one_month,\n" +
                "case when EXISTS(select id from CH_ETBJ_JKJCONE one where one.ETXXBH = jd.ETXXBH and ETJKJCYNL_DM='2') then '是' else '否' end is_three_month,\n" +
                "case when EXISTS(select id from CH_ETBJ_JKJCONE one where one.ETXXBH = jd.ETXXBH and ETJKJCYNL_DM='3') then '是' else '否' end is_six_month,\n" +
                "case when EXISTS(select id from CH_ETBJ_JKJCONE one where one.ETXXBH = jd.ETXXBH and ETJKJCYNL_DM='4') then '是' else '否' end is_eight_month,\n" +
                "case when EXISTS(select id from CH_ETBJ_JKJCTWO two where two.ETXXBH = jd.ETXXBH and ETJKJCYNL_DM='5') then '是' else '否' end is_twelve_month,\n" +
                "case when EXISTS(select id from CH_ETBJ_JKJCTWO two where two.ETXXBH = jd.ETXXBH and ETJKJCYNL_DM='6') then '是' else '否' end is_eighteen_month,\n" +
                "case when EXISTS(select id from CH_ETBJ_JKJCTWO two where two.ETXXBH = jd.ETXXBH and ETJKJCYNL_DM='7') then '是' else '否' end is_twenty_four_month,\n" +
                "case when EXISTS(select id from CH_ETBJ_JKJCTWO two where two.ETXXBH = jd.ETXXBH and ETJKJCYNL_DM='8') then '是' else '否' end is_thirty_month,\n" +
                "case when EXISTS(select id from CH_ETBJ_JKJCTHR three where three.ETXXBH = jd.ETXXBH and ETJKJCYNL_DM='9') then '是' else '否' end is_three_year,\n" +
                "case when EXISTS(select id from CH_ETBJ_JKJCTHR three where three.ETXXBH = jd.ETXXBH and ETJKJCYNL_DM='10') then '是' else '否' end is_four_year,\n" +
                "case when EXISTS(select id from CH_ETBJ_JKJCTHR three where three.ETXXBH = jd.ETXXBH and ETJKJCYNL_DM='11') then '是' else '否' end is_five_year,\n" +
                "case when EXISTS(select id from CH_ETBJ_JKJCTHR three where three.ETXXBH = jd.ETXXBH and ETJKJCYNL_DM='12') then '是' else '否' end is_six_year\n" +
                " from CH_ETBJ_JD jd)");
        ClassMetadata cMetadata = ClassMetadata.getMetadata(WomenChildHealth.class);

        if(ObjectUtil.isNotEmpty(criteria.getCriteria())){
            sql.append(" WHERE  ").append(criteria.toSql(cMetadata, ":", ""));
        }
        sql.append(order.toString());
        sql.append(" ) r");
        return this.getPageMapList(page, sql.toString(), criteria);
    }
}