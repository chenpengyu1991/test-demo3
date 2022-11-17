package com.founder.rhip.portal.dto;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "response")
@XmlAccessorType(XmlAccessType.FIELD)
public class NewOrderResponse implements Serializable{

	private static final long serialVersionUID = -513687139646536026L;

	private ReturnResult returnresult;
	
	@XmlElement(name = "outputvalues")
	private OutputValues outputvalues;

	public ReturnResult getReturnresult() {
		return returnresult;
	}

	public void setReturnresult(ReturnResult returnresult) {
		this.returnresult = returnresult;
	}

	public OutputValues getOutputValues() {
		return outputvalues;
	}

	public void setOutputValues(OutputValues outputValues) {
		this.outputvalues = outputValues;
	}

	
}
