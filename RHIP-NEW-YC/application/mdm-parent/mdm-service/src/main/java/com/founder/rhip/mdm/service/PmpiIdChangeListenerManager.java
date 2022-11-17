package com.founder.rhip.mdm.service;

import com.founder.rhip.mdm.entity.Link;
import com.founder.rhip.mdm.service.IPmpiIdChangeListenerManager;
import com.founder.rhip.mdm.service.PmpiIdChangeListener;

import java.util.ArrayList;
import java.util.List;

public class PmpiIdChangeListenerManager implements IPmpiIdChangeListenerManager {
	
	private List<PmpiIdChangeListener> listeners = new ArrayList<PmpiIdChangeListener>();

	public List<PmpiIdChangeListener> getListeners() {
		return listeners;
	}

	public void setListeners(List<PmpiIdChangeListener> listeners) {
		this.listeners = listeners;
	}
	
	public void sendCreateNotify(String pmpiId, List<Link> links) {
		for (PmpiIdChangeListener listener : listeners) {
			listener.create(pmpiId, links);
		}
	}
	
	public void sendUpdateNotify(String pmpiId, List<Link> links) {
		for (PmpiIdChangeListener listener : listeners) {
			listener.update(pmpiId, links);
		}
	}
	
	public void sendDeleteNotify(String pmpiId) {
		for (PmpiIdChangeListener listener : listeners) {
			listener.delete(pmpiId);
		}
	}

}
