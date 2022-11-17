
package com.founder.rhip.ncp.dto;

/**
 * 健康教育报表对象
 *
 * @author GaoFei
 *
 */
public class NcpClassifyReport {

	//管理机构编码
	private String manageOrgCode;

	//管理机构名称
	private String manageOrgName;

	//确诊 县内治疗人数
	private Long insideTreatNum;

	//确诊 县外治疗人数
	private Long outsideTreatNum;

	//疑似人数
	private Long suspectedNum;

	//无症状人数
	private Long asymptomaticNum;

	public String getManageOrgCode() {
		return manageOrgCode;
	}

	public void setManageOrgCode(String manageOrgCode) {
		this.manageOrgCode = manageOrgCode;
	}

	public String getManageOrgName() {
		return manageOrgName;
	}

	public void setManageOrgName(String manageOrgName) {
		this.manageOrgName = manageOrgName;
	}

	public Long getInsideTreatNum() {
		return insideTreatNum;
	}

	public void setInsideTreatNum(Long insideTreatNum) {
		this.insideTreatNum = insideTreatNum;
	}

	public Long getOutsideTreatNum() {
		return outsideTreatNum;
	}

	public void setOutsideTreatNum(Long outsideTreatNum) {
		this.outsideTreatNum = outsideTreatNum;
	}

	public Long getSuspectedNum() {
		return suspectedNum;
	}

	public void setSuspectedNum(Long suspectedNum) {
		this.suspectedNum = suspectedNum;
	}

	public Long getAsymptomaticNum() {
		return asymptomaticNum;
	}

	public void setAsymptomaticNum(Long asymptomaticNum) {
		this.asymptomaticNum = asymptomaticNum;
	}
}
