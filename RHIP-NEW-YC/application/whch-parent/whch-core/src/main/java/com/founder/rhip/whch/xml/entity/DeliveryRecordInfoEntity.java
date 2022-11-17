
package com.founder.rhip.whch.xml.entity;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import com.founder.rhip.ehr.entity.women.DeliveryRecordInfo;

@XmlRootElement(name = "root")
public class DeliveryRecordInfoEntity {

	private List<DeliveryRecordInfo> deliveryRecordInfos;

	@XmlElementWrapper(name = "deliveryRecordInfos")
	@XmlElement(name = "deliveryRecordInfo")
	public List<DeliveryRecordInfo> getDeliveryRecordInfos() {
		return deliveryRecordInfos;
	}

	public void setDeliveryRecordInfos(List<DeliveryRecordInfo> deliveryRecordInfos) {
		this.deliveryRecordInfos = deliveryRecordInfos;
	}
}
