package com.founder.rhip.ncp.service;

import com.founder.fasf.beans.*;
import com.founder.fasf.service.AbstractService;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.ncp.common.NcpConstants;
import com.founder.rhip.ncp.dao.INcpPatientDao;
import com.founder.rhip.ncp.dto.FollowDto;
import com.founder.rhip.ncp.entity.*;
import com.founder.rhip.ncp.repository.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service("ncpFollowService")
public class FollowServiceImpl extends AbstractService implements IFollowService {

    @Resource(name = "ncpFollowListDao")
    IFollowListDao followListDao;

    @Resource(name = "ncpMonitorPlanDao")
    IMonitorPlanDao monitorPlanDao;

    @Resource(name = "ncpMonitorDao")
    IMonitorDao monitorDao;

    @Resource(name = "ncpSymptiomsDao")
    ISymptiomsDao symptiomsDao;

    @Resource(name = "ncpPatientDao")
    INcpPatientDao patientDao;

    @Resource(name = "ncpReexamItemDao")
    IReexaminationItemDao reexamItemDao;

    @Override
    public PageList<FollowDto> searchFollowList(Page page, Criteria criteria) {
//
        return followListDao.searchFollowList(page, criteria);
    }

    @Override
    public List<NcpMonitorPlan> searchFollowupPlanList(Criteria criteria, Order order) {
//            return dMFollowupPlanDao.getList(criteria, order);
        return monitorPlanDao.searchFollowupPlanList(criteria, order);
    }

    @Override
    public NcpMonitor findMonitorById(Long id) {
        NcpMonitor m = monitorDao.get(id);
        NcpReexaminationItem reexmItem = reexamItemDao.get(new Criteria("monitorId", id));
        m.setReexmItem(reexmItem);
        String symptioms = symptiomsDao.findSymptiomsByMonitorid(id.toString());//查询症状
        m.setSymptioms(symptioms);
        return m;
    }

    @Override
    public NcpMonitorPlan findMonitorPlanById(Long id) {
        NcpMonitorPlan m = monitorPlanDao.get(new Criteria("id", id));
        return m;
    }


    @Override
    @Transactional
    public boolean saveMonitor(NcpMonitor m) {
        int r = 0;
        BigDecimal monitorid = null;

        if (m.getId() == null) {
            monitorid = (BigDecimal) monitorDao.generatedKey(m, "ID", null);
            r++;
        } else {
            m.setUpdateTime(new Date());
            r = monitorDao.update(m);
            monitorid = m.getId();
        }
        if (NcpConstants.NCP_MONITOR_TYPE_2.equals(m.getType().toString())) {//保存复查项目
            NcpReexaminationItem item = m.getReexmItem();
            item.setMonitorId(monitorid);
            if (item.getId() == null)
                reexamItemDao.insert(item);
            else
                reexamItemDao.update(item);
            //更新复查状态
            NcpPatient p = new NcpPatient();
            p.setId(Long.valueOf(m.getPatientId().toString()));
            p.setReexamineStatus(NcpConstants.REEXAM_STATUS_1);
            patientDao.update(p, "reexamineStatus");
        }
        if (NcpConstants.NCP_MONITOR_TYPE_3.equals(m.getType().toString())) {//保存下次随访计划

            List<NcpMonitorPlan> planList = new ArrayList<NcpMonitorPlan>();
            Order order = new Order("PLAN_DATE DESC");
            planList = monitorPlanDao.getList(new Criteria("pid", m.getPatientId()).add("type", m.getType()).add("planType", "1"), order);
            if ("add".equals(m.getEditFlag()) && "1".equals(m.getPlanType()) && planList.size() < 4) {//根据上一次计划随访时间，自动生成下次随访时间
                NcpMonitorPlan plan = new NcpMonitorPlan();
                plan.setType(m.getType());
                //下个季度的计划一条且只有一条
                String nextPlanDateStr = DateUtil.convertDateToString(DateUtil.getMonthsLater(planList.get(0).getPlanDate(), 3));
                plan.setPlanDate(DateUtil.parseSimpleDate(nextPlanDateStr, "yyyy/MM/dd"));
                plan.setPid(m.getPatientId());
                plan.setCreateTime(new Date());
                plan.setCardno(m.getCardno());
                plan.setCreateStaffCode(m.getMonitorDoctor());
                //自动产生的随访都属于计划内随访  1:计划内 2:计划外
                plan.setPlanType("1");
                if (monitorid != null)
                    monitorPlanDao.insert(plan);
            }
        }
        if (m.getId() != null) {//更新随访先删除症状表
            symptiomsDao.delete(new Criteria("monitorId", monitorid));
        }
        if (NcpConstants.SYMPTOMFLAG_2.equals(m.getSymptomFlag())) {//有症状
            List<String> listSymStr = m.getCurSymptom();
            List<NcpSymptioms> listSym = new ArrayList<NcpSymptioms>();
            if (listSymStr != null)
                for (String code : listSymStr) {
                    NcpSymptioms sym = new NcpSymptioms();
                    sym.setMonitorId(monitorid);
                    sym.setSymptomCode(code);
                    listSym.add(sym);
                }
            //保存症状表
            symptiomsDao.batchInsert(listSym);
        }
        NcpMonitor hasNewMonitor = monitorDao.get(new Criteria("patientId", m.getPatientId()).add("monitorDate", OP.GT, m.getMonitorDate()));//.add("type",m.getType())
        if (hasNewMonitor == null) {//根据最新日期的监测、随访、复查记录 去更新健康评价
            //更新健康评价状态
            NcpPatient p = new NcpPatient();
            p.setId(Long.valueOf(m.getPatientId().toString()));
            p.setHealthStatus(m.getHealthAssessment().toString());
            /*if (NcpConstants.NCP_MONITOR_TYPE_2.equals(m.getType().toString())) {//复查则需要更新复查状态
                p.setReexamineStatus(NcpConstants.REEXAM_STATUS_1);
                patientDao.update(p, "healthStatus", "reexamineStatus");
            } else*/
            patientDao.update(p, "healthStatus");
        }
        return r > 0 ? true : false;
    }

    @Override
    public boolean saveMonitorPlan(NcpMonitorPlan p) {
        int r = monitorPlanDao.insert(p);
        return r > 0 ? true : false;
    }

    @Override
    public Map<String, Object> searchQuickCnt(Criteria ca) {
        return this.followListDao.searchQuickCnt(ca);
    }
}
