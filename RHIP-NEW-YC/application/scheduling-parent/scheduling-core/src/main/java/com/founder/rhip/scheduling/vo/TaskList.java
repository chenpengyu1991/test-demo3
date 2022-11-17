package com.founder.rhip.scheduling.vo;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "root")
public class TaskList {
	@XmlElement(name = "task")
	@XmlElementWrapper(name = "tasks")
	private List<JobDetailVo> tasks;

	public List<JobDetailVo> getTasks() {
		return tasks;
	}

	public void setTasks(List<JobDetailVo> tasks) {
		this.tasks = tasks;
	}
}
