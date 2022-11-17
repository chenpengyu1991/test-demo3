package com.founder.rhip.ehr.dto;

import com.founder.rhip.ehr.entity.ep.SaltSamplingRecord;
import com.founder.rhip.ehr.entity.ep.SaltTestRecord;

import java.util.ArrayList;
import java.util.List;

public class EndemicPreventDTO {

	private List<SaltSamplingRecord> samplingRecords = new ArrayList<>();

	private List<SaltTestRecord> saltTestRecords = new ArrayList<>();

	public List<SaltSamplingRecord> getSamplingRecords() {
		return samplingRecords;
	}

	public void setSamplingRecords(List<SaltSamplingRecord> samplingRecords) {
		this.samplingRecords = samplingRecords;
	}

	public List<SaltTestRecord> getSaltTestRecords() {
		return saltTestRecords;
	}

	public void setSaltTestRecords(List<SaltTestRecord> saltTestRecords) {
		this.saltTestRecords = saltTestRecords;
	}
}
