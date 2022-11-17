package com.founder.rhip.mhm.service;

import com.founder.rhip.ehr.common.EHRConstants;
import com.founder.rhip.ehr.dto.mhm.MhmMoveQueryDto;
import com.founder.rhip.ehr.entity.cic.CicTarget;
import com.founder.rhip.ehr.repository.management.mhm.IMhmStatusInfoDao;
import com.founder.rhip.ehr.service.ta.ICicTargetService;
import com.founder.rhip.scheduling.core.Task;
import com.founder.rhip.scheduling.core.TaskBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: Cary
 * Date: 15/5/14
 * Time: 3:01 PM
 * To change this template use File | Settings | File Templates.
 */
@Service("cicMhmSyncService")
@TaskBean(description = "cic市民卡精神病指标")
public class CicSyncService implements Task {

    @Autowired
    private IMhmStatusInfoDao mhmStatusInfoDao;

    @Resource(name = "cicTargetService")
    private ICicTargetService cicTargetService;

    Logger loggger = LoggerFactory.getLogger(this.getClass());

    public void run(Map<String, Object> data) {
        List<MhmMoveQueryDto> persons = mhmStatusInfoDao.getMhmInfoForCic();
        List<CicTarget> personList = new ArrayList<>();
        for (MhmMoveQueryDto tempDto : persons) {
            CicTarget cicTarget = new CicTarget();
            cicTarget.setPersonId(tempDto.getPersonId());
            cicTarget.setIdcard(tempDto.getIdcard());
            cicTarget.setMentalFlag(EHRConstants.CIC_TARGET_FLAG_TRUE);
            personList.add(cicTarget);
        }

        Set<String> properties = new HashSet<String>();
        properties.add("mentalFlag");
        properties.add("idcard");

        for (CicTarget cicTarget : personList) {
            cicTargetService.saveTargetValue(cicTarget, properties);
        }

    }

}
