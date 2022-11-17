package com.founder.rhip.portal.dto;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import com.founder.rhip.ehr.entity.portal.OutClinic;

@XmlRootElement(name = "response")
@XmlAccessorType(XmlAccessType.FIELD)
public class GetDeptmentListResponse implements Serializable{
	private static final long serialVersionUID = -1893167872644876493L;
	
	private ReturnResult returnresult;
	
	@XmlElementWrapper(name = "data")
	@XmlElement(name = "data_row")
	private List<DataRow> data_row;

	public ReturnResult getReturnresult() {
		return returnresult;
	}

	public void setReturnresult(ReturnResult returnresult) {
		this.returnresult = returnresult;
	}

	public List<DataRow> getData_row() {
		return data_row;
	}

	public void setData_row(List<DataRow> data_row) {
		this.data_row = data_row;
	}

	
}
