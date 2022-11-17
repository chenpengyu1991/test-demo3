package com.founder.rhip.portal.repository;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.repository.SqlBuilder;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.entity.portal.StopDoctor;
import com.founder.rhip.ehr.repository.portal.IHospitalInfoDao;
import com.founder.rhip.ehr.repository.portal.IStopDoctorInfoDao;

/**
 * Created with IntelliJ IDEA.
 * User: zheng_dandan
 * Date: 13-6-17
 * Time: 上午10:02
 * To change this template use File | Settings | File Templates.
 */

@Repository("stopDoctorInfoDao")
public class StopDoctorInfoDaoImpl extends AbstractDao<StopDoctor, Long> implements  IStopDoctorInfoDao {
    @Resource(name = "portaldbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;

    @Autowired
    private IHospitalInfoDao hospitalInfoDao;

    @Override
    public PageList<StopDoctor> getList(Page page, Criteria criteria) {

        StringBuilder sql = new StringBuilder(
                "SELECT SD.ID,OT.DOCTOR_SN,OT.HOSPITAL_CODE,OT.DEPT_SN,SD.STOPING_STATUS,SD.START_DATE,SD.END_DATE,SD.PERIOD,OT.NAME,OT.DEPT_NAME FROM OUT_DOCTOR OT");

        //liuk 2014年7月2日 16:48:34 修正关联条件缺失导致结果变多问题.修改为通过医生编码,科室,和医院编码连接
        sql.append(" LEFT JOIN (SELECT * FROM STOP_DOCTOR WHERE STOPING_STATUS = 1) SD ON SD.DOCTOR_SN = OT.DOCTOR_SN AND SD.HOSPITAL_CODE=OT.HOSPITAL_CODE AND OT.DEPT_SN=SD.DEPT_SN");

        SqlBuilder.buildWhereStatement(StopDoctor.class, sql, criteria);
        String orderStr = " OT.DOCTOR_SN DESC ";
        SqlBuilder.buildOrderStatement(sql,orderStr);

        PageList<Map<String, Object>> maps = this.getPageMapList(page, sql.toString(), criteria);
        PageList<StopDoctor> returnList = new PageList<StopDoctor>();
        returnList.setPage(maps.getPage());
        if(ObjectUtil.isNotEmpty(maps)){
            initListStopDoctor(maps, returnList);
        }
        return returnList;
    }

    private void initListStopDoctor(PageList<Map<String, Object>> maps,PageList<StopDoctor> returnList){
        for (Map<String, Object> map : maps.getList()) {
            StopDoctor stopDoctor = new StopDoctor();
            stopDoctor.setId(ObjectUtil.isNotEmpty(map.get("ID"))?Long.valueOf(map.get("ID").toString()):null);
            stopDoctor.setDoctorSn(ObjectUtil.isNotEmpty(map.get("DOCTOR_SN"))?map.get("DOCTOR_SN").toString():null);
            stopDoctor.setDoctorName(ObjectUtil.isNotEmpty(map.get("NAME"))?map.get("NAME").toString():null);
            stopDoctor.setDeptSn(ObjectUtil.isNotEmpty(map.get("DEPT_SN"))?map.get("DEPT_SN").toString():null);
            stopDoctor.setDeptName(ObjectUtil.isNotEmpty(map.get("DEPT_NAME"))?map.get("DEPT_NAME").toString():null);
            stopDoctor.setHospitalCode(ObjectUtil.isNotEmpty(map.get("HOSPITAL_CODE"))?map.get("HOSPITAL_CODE").toString():null);
            stopDoctor.setStopingStatus(ObjectUtil.isNotEmpty(map.get("STOPING_STATUS"))?map.get("STOPING_STATUS").toString():null);
            stopDoctor.setStartDate(ObjectUtil.isNotEmpty(map.get("START_DATE"))?DateUtil.parseSimpleDate(map.get("START_DATE").toString(),"yyyy-MM-dd"):null);
            stopDoctor.setEndDate(ObjectUtil.isNotEmpty(map.get("END_DATE"))?DateUtil.parseSimpleDate(map.get("END_DATE").toString(),"yyyy-MM-dd"):null);
            stopDoctor.setPeriod(ObjectUtil.isNotEmpty(map.get("PERIOD"))?map.get("PERIOD").toString():null);
            returnList.getList().add(stopDoctor);
        }
    }
}
