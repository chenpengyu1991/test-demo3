package com.founder.rhip.ehr.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.entity.basic.OrganizationEnvironmentRelation;
import com.founder.rhip.ehr.entity.basic.OrganizationGarbageRelation;
import com.founder.rhip.ehr.entity.basic.OrganizationWaterRelation;
import com.founder.rhip.ehr.entity.basic.Populace;
import com.founder.rhip.mdm.entity.Organization;

/**
 * Community Info for community user include: populace and organization By Sean
 * Xiyang
 */
public class CommunityInfoDTO  {
	private Integer organizationId;

	private Populace populace;

	private Organization organization;
	
	private String water;//组织用水类型 多个值用‘,’分隔
	
	private List<OrganizationWaterRelation> orgWatersRelations = new ArrayList<OrganizationWaterRelation>();
	
	private String environment; //组织环境状况类型 多个值用‘,’分隔
	
	private List<OrganizationEnvironmentRelation> orgEnvironmentRelations = new ArrayList<OrganizationEnvironmentRelation>();
	
	private String garbage; //组织垃圾回收类型 多个值用‘,’分隔
	
	private BigDecimal economic;
	
	private String oldPeopleHome;
	
	private String school;
	
	private List<OrganizationGarbageRelation> orgGarbageRelations = new ArrayList<OrganizationGarbageRelation>();

	public CommunityInfoDTO(Organization organization, Populace populace) {
		this.organizationId = organization.getOrganId().intValue();
		this.populace = populace;
		this.organization = organization;
		this.setWater(water);
	}

	public CommunityInfoDTO() {
	}

	public Integer getOrganizationId() {
		return organizationId;
	}

	public Populace getPopulace() {
		return populace;
	}

	public Organization getOrganization() {
		return organization;
	}

	public void setPopulace(Populace populace) {
		this.populace = populace;
	}

	/**
	 * Generate populace with the organization
	 * 
	 * @return
	 */
	public Populace toPopulace() {
		if (null == this.populace) {
			return null;
		}
		populace.setOrganizationId(this.getOrganizationId());
		populace.setOrganCode(this.getOrganization().getOrganCode());
		populace.setOrganName(this.getOrganization().getOrganName());
		populace.setCountYear(DateUtil.getCurrentYear());
		return populace;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
		this.organizationId = organization.getOrganId().intValue();
	}

	public String getWater() {
		return water;
	}

	public void setWater(String water) {
		this.water = water;
	}

	public String getEnvironment() {
		return environment;
	}

	public void setEnvironment(String environment) {
		this.environment = environment;
	}

	public String getGarbage() {
		return garbage;
	}

	public void setGarbage(String garbage) {
		this.garbage = garbage;
	}

	public List<OrganizationWaterRelation> getOrgWatersRelations() {
		return orgWatersRelations;
	}

	public void setOrgWatersRelations(
			List<OrganizationWaterRelation> orgWatersRelations) {
		if(ObjectUtil.isNotEmpty(orgWatersRelations)) {
    		StringBuffer str = new StringBuffer();
    		
    		for (OrganizationWaterRelation waterRe : orgWatersRelations) {
    			str.append(waterRe.getWaterCode() + ",");
    		}
    		if (StringUtils.isNotBlank(str.toString())) {
    			this.water = str.toString().substring(0, str.length()-1);
    		}
    	}
		this.orgWatersRelations = orgWatersRelations;
	}

	public List<OrganizationEnvironmentRelation> getOrgEnvironmentRelations() {
		return orgEnvironmentRelations;
	}

	public void setOrgEnvironmentRelations(
			List<OrganizationEnvironmentRelation> orgEnvironmentRelations) {
		if(ObjectUtil.isNotEmpty(orgEnvironmentRelations)) {
    		StringBuffer str = new StringBuffer();
    		
    		for (OrganizationEnvironmentRelation environmentRe : orgEnvironmentRelations) {
    			str.append(environmentRe.getEnvironmentCode() + ",");
    		}
    		if (StringUtils.isNotBlank(str.toString())) {
    			this.environment = str.toString().substring(0, str.length()-1);
    		}
    	}
		this.orgEnvironmentRelations = orgEnvironmentRelations;
	}

	public List<OrganizationGarbageRelation> getOrgGarbageRelations() {
		return orgGarbageRelations;
	}

	public void setOrgGarbageRelations(
			List<OrganizationGarbageRelation> orgGarbageRelations) {
		if(ObjectUtil.isNotEmpty(orgGarbageRelations)) {
    		StringBuffer str = new StringBuffer();
    		
    		for (OrganizationGarbageRelation garbageRe : orgGarbageRelations) {
    			str.append(garbageRe.getGarbageDisposalCode() + ",");
    		}
    		if (StringUtils.isNotBlank(str.toString())) {
    			this.garbage = str.toString().substring(0, str.length()-1);
    		}
    	}
		this.orgGarbageRelations = orgGarbageRelations;
	}

	public BigDecimal getEconomic() {
		return economic;
	}

	public void setEconomic(BigDecimal economic) {
		this.economic = economic;
	}

	public String getOldPeopleHome() {
		return oldPeopleHome;
	}

	public void setOldPeopleHome(String oldPeopleHome) {
		this.oldPeopleHome = oldPeopleHome;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}
	
}
