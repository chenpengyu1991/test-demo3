package com.founder.rhip.mhm.dto;



import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.common.RoleType;
import com.founder.rhip.ehr.entity.basic.PersonInfo;
import com.founder.rhip.ehr.entity.basic.User;
import com.founder.rhip.ehr.entity.management.mhm.MhmBasicsInfo;
import com.founder.rhip.ehr.entity.management.mhm.MhmDiagnosis;
import com.founder.rhip.ehr.entity.management.mhm.MhmOtherInfo;
import com.founder.rhip.ehr.entity.management.mhm.MhmSign;
import com.founder.rhip.mdm.entity.Organization;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;

import javax.persistence.Transient;
import java.io.Serializable;

public class MhmClueDto implements Serializable {

    private static final long serialVersionUID = 1L;

    /*状态表ID*/
    private Long statusId;
    /*事件表ID*/
    private Long eventId;
    /*事件类型*/
    private Integer eventType;   
    /*当前操作者*/
    private User currentUser;
    /*当前操作者所在机构*/
    private  Organization currentOrg;
    /*当前角色*/
    private RoleType roleType;   
    /*患者PIXID*/
    private String pixId;
    /*患者personId*/
    private Long personId;    
    /*状态*/
    private Integer status;
    
    /*基本信息*/
    private MhmBasicsInfo mhmBasicsInfo;
    /*体征表*/
    private MhmSign mhmSign;
    /*诊断治疗表*/
    private MhmDiagnosis mhmDiagnosis;
    /*其他表*/
    private MhmOtherInfo mhmOtherInfo;

    private int logoff;

    /*患者信息*/
    @Transient
    private PersonInfo personInfo;

	public PersonInfo getPersonInfo() throws Exception {
        if(ObjectUtil.isNullOrEmpty(this.personInfo)){
            this.personInfo = new PersonInfo();
            ConvertUtils.register(new DateConverter(null), java.util.Date.class);
            BeanUtils.copyProperties(this.personInfo, this.getMhmBasicsInfo());
            personInfo.setHouseholdType(this.getMhmBasicsInfo().getFloatPopulation());
            //患者ID add by yjf 2014/01/07
            if(ObjectUtil.isNotEmpty(this.personId)){
            	personInfo.setId(this.personId);
            }else{
            	personInfo.setId(null);
            }            
        }
        return personInfo;
    }

	
	public void setPersonInfo(PersonInfo personInfo) {
		this.personInfo = personInfo;
	}

	public Long getStatusId() {
		return statusId;
	}

	public void setStatusId(Long statusId) {
		this.statusId = statusId;
	}

	public Long getEventId() {
		return eventId;
	}

	public void setEventId(Long eventId) {
		this.eventId = eventId;
	}

	public User getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(User currentUser) {
		this.currentUser = currentUser;
	}

	
	public MhmBasicsInfo getMhmBasicsInfo() {
		return mhmBasicsInfo;
	}

	
	public void setMhmBasicsInfo(MhmBasicsInfo mhmBasicsInfo) {
		this.mhmBasicsInfo = mhmBasicsInfo;
	}

	
	public MhmSign getMhmSign() {
		return mhmSign;
	}

	
	public void setMhmSign(MhmSign mhmSign) {
		this.mhmSign = mhmSign;
	}

	
	public MhmDiagnosis getMhmDiagnosis() {
		return mhmDiagnosis;
	}

	
	public void setMhmDiagnosis(MhmDiagnosis mhmDiagnosis) {
		this.mhmDiagnosis = mhmDiagnosis;
	}

	
	public MhmOtherInfo getMhmOtherInfo() {
		return mhmOtherInfo;
	}

	
	public void setMhmOtherInfo(MhmOtherInfo mhmOtherInfo) {
		this.mhmOtherInfo = mhmOtherInfo;
	}

	public RoleType getRoleType() {
		return roleType;
	}

	public void setRoleType(RoleType roleType) {
		this.roleType = roleType;
	}

	public String getPixId() {
		return pixId;
	}

	public void setPixId(String pixId) {
		this.pixId = pixId;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Organization getCurrentOrg() {
		return currentOrg;
	}

	public void setCurrentOrg(Organization currentOrg) {
		this.currentOrg = currentOrg;
	}

	public Integer getEventType() {
		return eventType;
	}

	public void setEventType(Integer eventType) {
		this.eventType = eventType;
	}

    public int getLogoff() {
        return logoff;
    }

    public void setLogoff(int logoff) {
        this.logoff = logoff;
    }


	public Long getPersonId() {
		return personId;
	}


	public void setPersonId(Long personId) {
		this.personId = personId;
	}
}