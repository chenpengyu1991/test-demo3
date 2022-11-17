
package com.founder.rhip.whch.xml.entity;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import com.founder.rhip.ehr.entity.women.PrenatalScreenDiagnosis;

@XmlRootElement(name = "root")
public class PrenatalScreenDiagnosisEntity {

	private List<PrenatalScreenDiagnosis> prenatalScreenDiagnosises;

	@XmlElementWrapper(name = "prenatalScreenDiagnosises")
	@XmlElement(name = "prenatalScreenDiagnosis")
	public List<PrenatalScreenDiagnosis> getPrenatalScreenDiagnosises() {
		return prenatalScreenDiagnosises;
	}

	public void setPrenatalScreenDiagnosises(List<PrenatalScreenDiagnosis> prenatalScreenDiagnosises) {
		this.prenatalScreenDiagnosises = prenatalScreenDiagnosises;
	}
}
