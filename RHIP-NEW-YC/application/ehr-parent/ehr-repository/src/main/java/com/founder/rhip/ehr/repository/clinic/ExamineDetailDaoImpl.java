package com.founder.rhip.ehr.repository.clinic;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.rhip.ehr.entity.clinic.ExamineDetail;
import com.founder.fasf.beans.Criteria;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.util.ObjectUtil;

import javax.annotation.Resource;

/**
 * DAO implement of ExamineDetail
 */
@Repository("examineDetailDao")
public class ExamineDetailDaoImpl extends AbstractDao<ExamineDetail, Long> implements IExamineDetailDao {
    @Resource(name = "msdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;

    private static final String FORMATER = "yyyy/mm/dd";

    /**
     * 获取检验的数据
     *
     * @param dateStr 日期格式必须是yyyy/mm/dd
     * @return
     */
    @Override
    public List<Map<String, Object>> getExamineDetailStatistics(String dateStr) {
        if (ObjectUtil.isNullOrEmpty(dateStr)) {
            throw new IllegalArgumentException("日期不可以为空！");
        }
        String whereSql = " where to_char(gather_date,'%1$s') ='%2$s'";
        StringBuilder sqlBuilder = new StringBuilder("WITH examine AS(select t.hospital_code,t.inspection_item_code,t.prompt,to_char(t.check_date,'yyyy/mm/dd')check_date "
                + " from ms_examine_detail t %1$s and t.inspection_item_code in ('1010030101', '1010020101', '1010190101')),"
                + " up as(select t.hospital_code up_hos_code,t.inspection_item_code up_ins_code,t.check_date up_check_date,count(*)count_up "
                + " from examine t where t.prompt='↑' group by t.hospital_code,t.inspection_item_code,t.check_date),"
                + " down as(select t.hospital_code down_hos_code,t.inspection_item_code down_ins_code,t.check_date down_check_date,count(*)count_down"
                + " from examine t where t.prompt='↓' group by t.hospital_code,t.inspection_item_code,t.check_date),"
                + " nomal as(select t.hospital_code nomal_hos_code,t.inspection_item_code nomal_ins_code,t.check_date nomal_check_date,count(*)count_nomal"
                + " from examine t where t.prompt='0' group by t.hospital_code,t.inspection_item_code,t.check_date)"
                + " select u.*,d.*,n.*,nvl(count_up,0)+nvl(count_down,0)+nvl(count_nomal,0) allc from up u"
                + " full join down d on u.up_hos_code = d.down_hos_code and u.up_ins_code=d.down_ins_code "
                + " and u.up_check_date=d.down_check_date"
                + " full join nomal n on ((u.up_hos_code = n.nomal_hos_code"
                + " and u.up_ins_code=n.nomal_ins_code"
                + " and u.up_check_date=n.nomal_check_date) or (d.down_hos_code = n.nomal_hos_code "
                + " and d.down_ins_code=n.nomal_ins_code"
                + " and d.down_check_date=n.nomal_check_date))");

        whereSql = String.format(whereSql, FORMATER, dateStr);
        String sql = String.format(sqlBuilder.toString(), whereSql);
        return this.getMapList(sql, new Criteria());
    }
}