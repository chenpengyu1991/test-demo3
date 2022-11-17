package com.founder.rhip.mdm.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.founder.rhip.mdm.entity.Organization;

@Service("mergerOrgListenerManager")
public class MergerOrganizationListenerManager implements IMergerOrganizationListenerManager {

	@Autowired(required=false)
	private List<IMergerOrganizationListener> mergerListeners = new ArrayList<IMergerOrganizationListener>();

	@Override
	public void notifyMergeStation(Organization station, List<Organization> stationList) {
		for(IMergerOrganizationListener mergerOrgListener: mergerListeners) {
			mergerOrgListener.mergeStation(station, stationList);
		}
	}

	@Override
	public void notifyMergeCenter(Organization center, List<Organization> centerList) {
		for(IMergerOrganizationListener mergerOrgListener: mergerListeners) {
			mergerOrgListener.mergeCenter(center, centerList);
		}
	}

	@Override
	public void notifyMoveStation(Organization center, List<Organization> stationList) {
		for(IMergerOrganizationListener mergerOrgListener: mergerListeners) {
			mergerOrgListener.moveStation(center, stationList);
		}
	}

	@Override
	public void changeRelationOrgVillage(String orgCode, String[] newAddVillageCodes) {
		for(IMergerOrganizationListener mergerOrgListener: mergerListeners) {
			mergerOrgListener.changeRelationOrgVillage(orgCode, newAddVillageCodes);
		}
	}
}
