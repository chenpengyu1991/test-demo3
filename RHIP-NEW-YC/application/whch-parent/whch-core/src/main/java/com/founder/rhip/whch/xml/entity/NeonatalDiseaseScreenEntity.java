package com.founder.rhip.whch.xml.entity;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import com.founder.rhip.ehr.entity.child.NeonatalDiseaseScreen;

@XmlRootElement(name = "root")
public class NeonatalDiseaseScreenEntity {
	
	private List<NeonatalDiseaseScreen> neonatalDiseaseScreens;

	@XmlElementWrapper(name = "neonatalDiseaseScreens")
	@XmlElement(name = "neonatalDiseaseScreen")
	public List<NeonatalDiseaseScreen> getNeonatalDiseaseScreens() {
		return neonatalDiseaseScreens;
	}

	
	public void setNeonatalDiseaseScreens(List<NeonatalDiseaseScreen> neonatalDiseaseScreens) {
		this.neonatalDiseaseScreens = neonatalDiseaseScreens;
	}
	
	
}
