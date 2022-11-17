package com.founder.rhip.ihm.service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.beans.Parameters;
import com.founder.fasf.service.AbstractService;
import com.founder.rhip.ehr.repository.ihm.IMessageReceivedDao;
import com.founder.rhip.ehr.repository.ihm.IMessageSentDao;
import com.founder.rhip.mdm.entity.Organization;
import com.founder.rhip.mdm.service.IMergerOrganizationListener;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service("msgMergerOrgService")
public class MsgMergerOrgListenerImpl extends AbstractService implements IMergerOrganizationListener {
	
	@Resource(name="messageSentDao")
    IMessageSentDao messageSentDao;
	
	@Resource(name="messageReceivedDao")
    IMessageReceivedDao messageReceivedDao;

	@Override
	public void mergeStation(Organization station, List<Organization> stationList) {
		List<String> stationCodes = new ArrayList<>();
        for (Organization org : stationList) {
            String stationCode = org.getOrganCode();
            stationCodes.add(stationCode);
        }
        //更新数据
        Parameters parameter1 = new Parameters("RECEIVING_UNIT", station.getOrganCode());
        messageSentDao.update(parameter1, new Criteria("RECEIVING_UNIT", OP.IN, stationCodes));
        messageReceivedDao.update(parameter1, new Criteria("RECEIVING_UNIT", OP.IN, stationCodes));
        parameter1 = new Parameters("CREATE_ORGAN_CODE", station.getOrganCode());
        messageSentDao.update(parameter1, new Criteria("CREATE_ORGAN_CODE", OP.IN, stationCodes));
        messageReceivedDao.update(parameter1, new Criteria("CREATE_ORGAN_CODE", OP.IN, stationCodes));
	}

	@Override
	public void mergeCenter(Organization center, List<Organization> centerList) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void moveStation(Organization center, List<Organization> stationList) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void changeRelationOrgVillage(String orgCode, String[] newAddVillageCodes) {
		// TODO Auto-generated method stub
		
	}

}	
