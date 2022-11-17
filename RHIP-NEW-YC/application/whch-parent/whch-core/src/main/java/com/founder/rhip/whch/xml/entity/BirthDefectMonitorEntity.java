
package com.founder.rhip.whch.xml.entity;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import com.founder.rhip.ehr.entity.women.BirthDefectMonitor;

@XmlRootElement(name = "root")
public class BirthDefectMonitorEntity {

	private List<BirthDefectMonitor> birthDefectMonitors;

	@XmlElementWrapper(name = "birthDefectMonitors")
	@XmlElement(name = "birthDefectMonitor")
	public List<BirthDefectMonitor> getBirthDefectMonitors() {
		return birthDefectMonitors;
	}

	public void setBirthDefectMonitors(List<BirthDefectMonitor> birthDefectMonitors) {
		this.birthDefectMonitors = birthDefectMonitors;
	}
}
