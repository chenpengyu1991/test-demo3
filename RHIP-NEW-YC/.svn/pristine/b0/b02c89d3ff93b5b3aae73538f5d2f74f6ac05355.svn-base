package com.founder.rhip.ihm.service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.util.DateUtil;
import com.founder.rhip.ehr.entity.basic.ReportRecord;
import com.founder.rhip.ehr.repository.ihm.ICardMonitoringDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * Created by chen.q on 15-6-4.
 */
@Service("cardMonitoringService")
public class CardMonitoringServiceImpl extends IhmService implements ICardMonitoringService{
   @Resource(name="cardMonitoringDao")
    private ICardMonitoringDao cardMonitoringDao;

    @Override
    public List<Map<String, Object>> getCountReportMapList(Criteria criteria) {
        return cardMonitoringDao.getCountReportMapList(criteria);
    }

    @Override
    public  Map<String,String> getCountReportMap(Criteria criteria) {

        List<Map<String, Object>> reportMapList=cardMonitoringDao.getCountReportMapList(criteria);
       // reportMapList
        Map<String, String> reportMap=new HashMap<String, String>();
   /*     Map<String,List<String>> reportMapl=new HashMap<String,List<String>>();*/
        int i=1;
/*        List<String> orgName = new ArrayList<String>();
        List<String> nua = new ArrayList<String>();
        List<String> nub = new ArrayList<String>();
        List<String> nuc = new ArrayList<String>();*/

        for (Map<String, Object> map : reportMapList) {
     /*       orgName.add(i,map.get("ORGANNAME").toString());
            nua.add(i,map.get("COUNTNUMA").toString());
            nub.add(i,map.get("COUNTNUMB").toString());
            nuc.add(i,map.get("COUNTNUMC").toString());

            reportMapl.put("ORGANNAME",orgName);
            reportMapl.put("COUNTNUMA",nua);
            reportMapl.put("COUNTNUMB",nub);
            reportMapl.put("COUNTNUMC",nuc);*/

            reportMap.put("ORGANNAME"+i,map.get("ORGANNAME").toString());
            reportMap.put("COUNTNUMA"+i,map.get("COUNTNUMA").toString());
            reportMap.put("COUNTNUMB"+i,map.get("COUNTNUMB").toString());
            reportMap.put("COUNTNUMC"+i,map.get("COUNTNUMC").toString());
            i++;
        }
        return reportMap;
    }

}
