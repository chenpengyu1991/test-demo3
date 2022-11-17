package com.founder.rhip.ehr.statisticsdto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 肿瘤月报和季报
 * 
 * @author liuk
 * 
 */
public class TumorMonthSeasonReport implements Serializable {
	private static final long serialVersionUID = -808759672985287139L;
	
	// 肿瘤动态类型
	private Set<String> malignants = new HashSet<>();// 恶性
	private Set<String> nonMalignants = new HashSet<>();// 非恶性
	// 肿瘤结果数据
	private List<Map<String, Object>> reports;

	public Set<String> getMalignants() {
		return malignants;
	}

	public void setMalignants(Set<String> malignants) {
		this.malignants = malignants;
	}

	public Set<String> getNonMalignants() {
		return nonMalignants;
	}

	public void setNonMalignants(Set<String> nonMalignants) {
		this.nonMalignants = nonMalignants;
	}

	public List<Map<String, Object>> getReports() {
		return reports;
	}

	public void setReports(List<Map<String, Object>> reports) {
		this.reports = reports;
	}
}
