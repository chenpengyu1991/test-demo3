package com.founder.rhip.ehr.dto;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.common.EHRConstants;
import com.founder.rhip.ehr.entity.basic.*;
import org.apache.commons.lang.StringUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class FamilyRecordDTO implements Serializable {

	private static final long serialVersionUID = -1320949306351133003L;

	//家庭基本信息
	private FamilyInfo familyInfo;
	
	//家庭成员关系列表
	private List<FamilyPersonRelation> familyMemberList = new ArrayList<FamilyPersonRelation>();
	
	//家庭成员信息列表
	private List<PersonInfo> personInfoList = new ArrayList<PersonInfo>();

	//家庭成员信息列表
	private List<PersonInfo> memberList = new ArrayList<PersonInfo>();

    //家庭用水
    private List<FamilyWaterRelation> waterRelationList = new ArrayList<FamilyWaterRelation>();

    //家庭户厕
    private List<FamilyHostoiletRelation> hostoiletRelationList = new ArrayList<FamilyHostoiletRelation>();

    private String memberLink; //成员姓名

    private String accountNumber; //户口号
	
	private String patownShip; //现住地址一乡(镇、街道办事处)
	
	private String address;

	private String water;//家庭用水类型 多个值用‘,’分隔
	
	private String hostoilet;//家庭户厕类型 多个值用‘,’分隔
	
	public FamilyInfo getFamilyInfo() {
		return familyInfo;
	}

	public void setFamilyInfo(FamilyInfo familyInfo) {
		this.familyInfo = familyInfo;
	}

	public List<FamilyPersonRelation> getFamilyMemberList() {
		return familyMemberList;
	}

	public void setFamilyMemberList(List<FamilyPersonRelation> familyMemberList) {
		this.familyMemberList = familyMemberList;
	}
	
	/**
	 * 给家庭成员实体赋家庭ID
	 * @param id
	 */
	public void setFamilyRelationWithFamilyId(Long id) {
		if (null == id || null == familyMemberList) return;
		for (FamilyPersonRelation fpr : familyMemberList) {
			fpr.setFamilyId(id);
		}
	}
    public void setWarterRelationWithFamilyId(Long id) {
        if (null == id || null == waterRelationList) return;
        for (FamilyWaterRelation fwr : waterRelationList) {
            fwr.setFamilyId(id);
        }
    }

    public void setHostoiletRelationWithFamilyId(Long id) {
        if (null == id || null == hostoiletRelationList) return;
        for (FamilyHostoiletRelation fhr : hostoiletRelationList) {
            fhr.setFamilyId(id);
        }
    }


	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getPatownShip() {
		return patownShip;
	}

	public void setPatownShip(String patownShip) {
		this.patownShip = patownShip;
	}
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public List<PersonInfo> getPersonInfoList() {
		return personInfoList;
	}

	public void setPersonInfoList(List<PersonInfo> personInfoList) {
		this.personInfoList = personInfoList;
	}
	
	public List<PersonInfo> getMemberList() {
		return memberList;
	}

	public void setMemberList(List<PersonInfo> memberList) {
		this.memberList = memberList;
	}

	public void buildCriteria(Criteria ca) {
		if (ObjectUtil.isNotEmpty(this.getAccountNumber())) {
			ca.add("accountNumber", this.accountNumber);
		}
		if (ObjectUtil.isNotEmpty(this.memberLink)) {
			ca.add("memberLink", OP.LIKE, this.memberLink); //成员姓名可以在memberLink字段查询
		}
		if (ObjectUtil.isNotEmpty(this.getPatownShip())) {
			ca.add("patownShip", this.patownShip);
		}
		if (ObjectUtil.isNotEmpty(this.getAddress())) {
			ca.add("ADDRESS", OP.LIKE, this.address);
		}
	}
	
	public void coverMemberTOPersonRelation() {
		if (null != this.memberList && null != this.familyMemberList) {
			StringBuilder memberName = new StringBuilder();
            for (PersonInfo pi : this.memberList) {
                if (null == pi || null == pi.getId()) continue;
				FamilyPersonRelation fpr = new FamilyPersonRelation();
				fpr.setAccountNumber(familyInfo.getAccountNumber());
				fpr.setFamilyMemberName(pi.getName());
				fpr.setFamilyMemIdcard(pi.getIdcard());
				fpr.setFamilyMemManStatus(EHRConstants.FAMILY_MEMBER_STATUS_ABLE);  //成员状
				fpr.setFamilyMemTypeCode(pi.getFamilyMemTypeCode());
				//fpr.setFamilyMemTypeName(pi.getf)  //成员姓名
				fpr.setGbcode(familyInfo.getgBCode());
				if (EHRConstants.FAMILY_HOUSEHOLDER_CODE.equals(pi.getFamilyMemTypeCode())) {
					fpr.setHouseholderFlag(EHRConstants.FAMILY_HOUSEHOLDER_FLAG);//户主
                    familyInfo.setHouseholderName(pi.getName());
                    familyInfo.setHouseholderIdcard(pi.getIdcard());
				}
                memberName.append(pi.getName()+",");
				fpr.setPersonId(pi.getId());
				fpr.setZoneCode(pi.getZoneGBCode());
				familyMemberList.add(fpr);
			}
            familyInfo.setMemberLink(memberName.toString());
		}
	}

    public List<FamilyWaterRelation> getWaterRelationList() {
        return waterRelationList;
    }

    public void setWaterRelationList(List<FamilyWaterRelation> waterRelationList) {
    	if(ObjectUtil.isNotEmpty(waterRelationList)) {
    		StringBuffer str = new StringBuffer();
    		
    		for (FamilyWaterRelation waterRe : waterRelationList) {
    			str.append(waterRe.getWaterCode() + ",");
    		}
    		if (StringUtils.isNotBlank(str.toString())) {
    			this.water = str.toString().substring(0, str.length()-1);
    		}
    		
    	}
        this.waterRelationList = waterRelationList;
    }

    public List<FamilyHostoiletRelation>    getHostoiletRelationList() {
        return hostoiletRelationList;
    }

    public void setHostoiletRelationList(List<FamilyHostoiletRelation> hostoiletRelationList) {
    	if(ObjectUtil.isNotEmpty(hostoiletRelationList)) {
    		StringBuffer str = new StringBuffer();
    		
    		for (FamilyHostoiletRelation hostoiletRe : hostoiletRelationList) {
    			str.append(hostoiletRe.getHastoiletCode() + ",");
    		}
    		if (StringUtils.isNotBlank(str.toString())) {
    			this.hostoilet = str.toString().substring(0, str.length()-1);
    		}
    		
    	}
        this.hostoiletRelationList = hostoiletRelationList;
    }

    public String getMemberLink() {
        return memberLink;
    }

    public void setMemberLink(String memberLink) {
        this.memberLink = memberLink;
    }

	public String getWater() {
		return water;
	}

	public void setWater(String water) {
		this.water = water;
	}

	public String getHostoilet() {
		return hostoilet;
	}

	public void setHostoilet(String hostoilet) {
		this.hostoilet = hostoilet;
	}


    
}