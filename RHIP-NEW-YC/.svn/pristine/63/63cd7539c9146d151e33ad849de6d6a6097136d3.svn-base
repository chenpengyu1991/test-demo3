package com.founder.rhip.hsa;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import com.founder.rhip.ehr.entity.hsa.LocationInfo;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "root")
public class LocationsInData {
	@XmlElement(name = "location")
	@XmlElementWrapper(name = "locations")
	private List<LocationInfo> locations;

	public List<LocationInfo> getLocations() {
		return locations;
	}

	public void setLocations(List<LocationInfo> locations) {
		this.locations = locations;
	}
}
