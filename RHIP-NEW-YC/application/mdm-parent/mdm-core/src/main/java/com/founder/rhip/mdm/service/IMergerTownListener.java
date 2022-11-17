package com.founder.rhip.mdm.service;

public interface IMergerTownListener {

	/**
	 * 乡镇合并
	 * @param newTownCode 合并后的乡镇编码
	 * @param oldTownCode 被合并的乡镇编码
	 */
	public void mergeTown(String newTownCode, String[] oldTownCode);
	
	/**
	 * 镇村关系变化时响应的接口 townCode镇编码 newAddVillageCodes镇中新增加的村
	 * @param townCode
	 * @param newAddVillageCode
	 */
	public void sendTownVillageRelation(String townCode, String[] newAddVillageCodes);
}
