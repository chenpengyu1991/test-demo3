package com.founder.rhip.ehr.statisticsdto;

import java.io.Serializable;

public class DmManageAndFollowup implements Serializable{

	private static final long serialVersionUID = 828830138141025393L;
	
	//机构name
	private String organName;
	//机构code
	private String organCode;
	//纳入总数
	private Long intoManageTotal;
	//纳入累计
	private Long intoManageCount;
	//门诊随访数
	private Long outTotal;
	//上门随访数
	private Long visitTotal;
	//电话随访数
	private Long centralTotal;
    //电话随访数
    private Long phoneTotal;
	//随访总数
	private Long total;
	//随访累计
	private Long followupTotal;
	//待访
	private Long waitTotal;
	//过期待访
	private Long expiredTotal;
	//注销合计
	private Long cancelTotal;
	//注销累计
	private Long deleteCount;
	
	public void copyFrom(DmManageAndFollowup from){
		this.cancelTotal=from.getCancelTotal();
		this.outTotal = from.getOutTotal();
		this.visitTotal = from.getVisitTotal();
		this.phoneTotal = from.getPhoneTotal();
        this.centralTotal=from.getCentralTotal();
		this.total = from.getTotal();
		this.followupTotal = from.getFollowupTotal();
	}
	public void copyFollowupStatus(DmManageAndFollowup from){
		this.waitTotal=from.getWaitTotal();
		this.expiredTotal=from.getExpiredTotal();
		this.cancelTotal = from.getCancelTotal();
		this.deleteCount = from.getDeleteCount();
	}
	public void copyIntoStatus(DmManageAndFollowup from){
		this.intoManageCount= from.getIntoManageCount();
		this.intoManageTotal=from.getIntoManageTotal();
	}
	public String getOrganName() {
		return organName;
	}
	public void setOrganName(String organName) {
		this.organName = organName;
	}
	public Long getIntoManageTotal() {
		return intoManageTotal;
	}
	public void setIntoManageTotal(Long intoManageTotal) {
		this.intoManageTotal = intoManageTotal;
	}
	public Long getIntoManageCount() {
		return intoManageCount;
	}
	public void setIntoManageCount(Long intoManageCount) {
		this.intoManageCount = intoManageCount;
	}
	public Long getOutTotal() {
		return outTotal;
	}
	public void setOutTotal(Long outTotal) {
		this.outTotal = outTotal;
	}
	public Long getVisitTotal() {
		return visitTotal;
	}
	public void setVisitTotal(Long visitTotal) {
		this.visitTotal = visitTotal;
	}
	public Long getPhoneTotal() {
		return phoneTotal;
	}
	public void setPhoneTotal(Long phoneTotal) {
		this.phoneTotal = phoneTotal;
	}
	public Long getTotal() {
		return total;
	}
	public void setTotal(Long total) {
		this.total = total;
	}

	public Long getFollowupTotal() {
		return followupTotal;
	}
	public void setFollowupTotal(Long followupTotal) {
		this.followupTotal = followupTotal;
	}
	public Long getWaitTotal() {
		return waitTotal;
	}
	public void setWaitTotal(Long waitTotal) {
		this.waitTotal = waitTotal;
	}
	public Long getExpiredTotal() {
		return expiredTotal;
	}
	public void setExpiredTotal(Long expiredTotal) {
		this.expiredTotal = expiredTotal;
	}
	public Long getCancelTotal() {
		return cancelTotal;
	}
	public void setCancelTotal(Long cancelTotal) {
		this.cancelTotal = cancelTotal;
	}
	public Long getDeleteCount() {
		return deleteCount;
	}
	public void setDeleteCount(Long deleteCount) {
		this.deleteCount = deleteCount;
	}
	public String getOrganCode() {
		return organCode;
	}
	public void setOrganCode(String organCode) {
		this.organCode = organCode;
	}

    public Long getCentralTotal() {
        return centralTotal;
    }

    public void setCentralTotal(Long centralTotal) {
        this.centralTotal = centralTotal;
    }
}
