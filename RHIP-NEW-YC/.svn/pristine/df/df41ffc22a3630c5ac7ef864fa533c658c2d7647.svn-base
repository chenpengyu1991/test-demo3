package com.founder.rhip.mdm.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("mergerTownListenerManager")
public class MergerTownListenerManager implements IMergerTownListenerManager {

	@Autowired(required=false)
	private List<IMergerTownListener> mergerTownListeners = new ArrayList<IMergerTownListener>();
	
	@Override
	public void sendMergeTown(String newTownCode, String[] oldTownCode){
		for(IMergerTownListener mergerTownListener : mergerTownListeners) {
			mergerTownListener.mergeTown(newTownCode, oldTownCode);
		}
	}

	@Override
	public void sendTownVillageRelation(String townCode, String[] newAddVillageCodes) {
		for(IMergerTownListener mergerTownListener : mergerTownListeners) {
			mergerTownListener.sendTownVillageRelation(townCode, newAddVillageCodes);
		}
	}

	public List<IMergerTownListener> getMergerTownListeners() {
		return mergerTownListeners;
	}

	public void setMergerTownListeners(List<IMergerTownListener> mergerTownListeners) {
		this.mergerTownListeners = mergerTownListeners;
	}
	
}
