package com.founder.rhip.mdm.service;

import java.util.List;

import com.founder.rhip.mdm.entity.Organization;

public interface IMergerOrganizationListener {

	/**
	 * 站合并（包括同一个中心下和不同中心下）
	 * @param station 合并后的站
	 * @param organList 被合并的站列表
	 */
	public void mergeStation(Organization station, List<Organization> stationList);
	
	/**
	 * 中心合并
	 * @param center  合并后的中心
	 * @param organList 被合并的中心列表
	 */
	public void mergeCenter(Organization center, List<Organization> centerList);
	
	/**
	 * 站转移
	 * @param center 转移后的中心
	 * @param organList 被转移的站列表
	 */
	public void moveStation(Organization center, List<Organization> stationList);
	
	/**
	 * 机构（站）村关系变化时响应的接口 orgCode机构编码 newAddVillageCodes机构中新增加的村
	 * @param orgCode
	 * @param newAddVillageCode
	 */
	public void changeRelationOrgVillage(String orgCode, String[] newAddVillageCodes);
	
}
