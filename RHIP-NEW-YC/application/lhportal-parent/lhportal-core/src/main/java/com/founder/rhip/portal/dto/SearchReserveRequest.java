package com.founder.rhip.portal.dto;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.founder.rhip.ehr.entity.portal.ReserveRegister;

@XmlRootElement(name = "root")
@XmlAccessorType(XmlAccessType.FIELD)
public class SearchReserveRequest implements Serializable {
	private static final long serialVersionUID = 2033497929737143942L;

	@XmlElement(name = "reserveRegister")
	private List<ReserveRegister> reserveRegisters;

	public List<ReserveRegister> getReserveRegisters() {
		return reserveRegisters;
	}

	public void setReserveRegisters(List<ReserveRegister> reserveRegisters) {
		this.reserveRegisters = reserveRegisters;
	}
}
