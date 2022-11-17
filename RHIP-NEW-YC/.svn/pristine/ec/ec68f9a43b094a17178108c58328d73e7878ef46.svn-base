package com.founder.rhip.whch.xml.entity;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import com.founder.rhip.ehr.entity.child.NeonatalFamilyVisit;

@XmlRootElement(name = "root")
public class NeonatalFamilyVisitEntity {
	
	private List<NeonatalFamilyVisit> neonatalFamilyVisits;

	
	@XmlElementWrapper(name = "neonatalFamilyVisits")
	@XmlElement(name = "neonatalFamilyVisit")
	public List<NeonatalFamilyVisit> getNeonatalFamilyVisits() {
		return neonatalFamilyVisits;
	}

	
	public void setNeonatalFamilyVisits(List<NeonatalFamilyVisit> neonatalFamilyVisits) {
		this.neonatalFamilyVisits = neonatalFamilyVisits;
	}

	
}
