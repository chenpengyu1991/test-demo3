
package com.founder.rhip.whch.xml.entity;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import com.founder.rhip.ehr.entity.child.ChildHealthExamination;

@XmlRootElement(name = "root")
public class ChildHealthExaminationEntity {

	private List<ChildHealthExamination> childHealthExaminations;

	@XmlElementWrapper(name = "childHealthExaminations")
	@XmlElement(name = "childHealthExamination")
	public List<ChildHealthExamination> getChildHealthExaminations() {
		return childHealthExaminations;
	}

	public void setChildHealthExaminations(List<ChildHealthExamination> childHealthExaminations) {
		this.childHealthExaminations = childHealthExaminations;
	}
}
