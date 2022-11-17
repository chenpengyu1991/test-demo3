package com.founder.rhip.mhm.dto;


import com.founder.rhip.ehr.entity.basic.User;
import com.founder.rhip.ehr.entity.management.mhm.*;
import com.founder.rhip.mdm.entity.Organization;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.List;

public class MhmDrugUseDto implements Serializable {

    private static final long serialVersionUID = 1L;

    /*状态表ID*/
    private Long statusId;
    /*当前操作者*/
    private User currentUser;
    /*当前操作机构*/
    private Organization currentOrg;
    /*基本信息*/
    private MhmBasicsInfo mhmBasicsInfo;
    /*病人类型*/
    private String freeType;

    /*发药登记列表*/
    @Transient
    private List<MhmDrugUse> mhmDrugUseList;
	
	public Long getStatusId() {
		return statusId;
	}
	
	public void setStatusId(Long statusId) {
		this.statusId = statusId;
	}
	
	public User getCurrentUser() {
		return currentUser;
	}
	
	public void setCurrentUser(User currentUser) {
		this.currentUser = currentUser;
	}
	
	public Organization getCurrentOrg() {
		return currentOrg;
	}
	
	public void setCurrentOrg(Organization currentOrg) {
		this.currentOrg = currentOrg;
	}
	
	public MhmBasicsInfo getMhmBasicsInfo() {
		return mhmBasicsInfo;
	}
	
	public void setMhmBasicsInfo(MhmBasicsInfo mhmBasicsInfo) {
		this.mhmBasicsInfo = mhmBasicsInfo;
	}
	
	public String getFreeType() {
		return freeType;
	}
	
	public void setFreeType(String freeType) {
		this.freeType = freeType;
	}
	
	public List<MhmDrugUse> getMhmDrugUseList() {
		return mhmDrugUseList;
	}
	
	public void setMhmDrugUseList(List<MhmDrugUse> mhmDrugUseList) {
		this.mhmDrugUseList = mhmDrugUseList;
	}
}