/**
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 * 
 * This software is the confidential and proprietary information of Founder. You
 * shall not disclose such Confidential Information and shall use it only in
 * accordance with the terms of the agreements you entered into with Founder.
 */

package com.founder.rhip.ehr.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.founder.rhip.ehr.dto.FamilyStatisticDto;
import com.founder.rhip.ehr.repository.basic.*;
import com.founder.rhip.mdm.app.IDictionaryApp;
import com.founder.rhip.mdm.app.IOrganizationApp;
import com.founder.rhip.mdm.common.OrgGenreCode;
import com.founder.rhip.mdm.entity.DicItem;
import com.founder.rhip.mdm.entity.Organization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.beans.Order;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.service.AbstractService;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.common.EHRConstants;
import com.founder.rhip.ehr.dto.FamilyRecordDTO;
import com.founder.rhip.ehr.entity.basic.FamilyCanceledInfo;
import com.founder.rhip.ehr.entity.basic.FamilyHostoiletRelation;
import com.founder.rhip.ehr.entity.basic.FamilyInfo;
import com.founder.rhip.ehr.entity.basic.FamilyPersonRelation;
import com.founder.rhip.ehr.entity.basic.FamilyWaterRelation;
import com.founder.rhip.ehr.entity.basic.PersonInfo;

@Service("familyRecordService")
public class FamilyRecordServiceImpl extends AbstractService implements IFamilyRecordService {

	private static final String ORGCODE = "orgCode";
	private static final String CENTERORGCODE = "centerOrgCode";
	private static final String GBCODE = "gbcode";

	@Resource(name = "familyInfoDao")
	private IFamilyInfoDao familyInfoDao;

	@Resource(name = "familyCanceledDao")
	private IFamilyCanceledDao familyCanceledDao;

	@Resource(name = "familyPersonRelationDao")
	private IFamilyPersonRelationDao familyPersonRelationDao;

	@Resource(name = "familyWaterRelationDao")
	private IFamilyWaterRelationDao familyWaterRelationDao;

	@Resource(name = "familyHostoiletRelationDao")
	private IFamilyHostoiletRelationDao familyHostoiletRelationDao;

	@Resource(name = "personInfoDao")
	private IPersonInfoDao personInxfoDao;

	@Autowired
	private IOrganizationApp organizationApp;

	@Autowired
	private IDictionaryApp dictionaryApp;

	@Resource(name = "populaceDao")
	private IPopulaceDao populaceDao;

	/**
	 * 创建家庭档案
	 * 
	 * @param familyRecord
	 * @return boolean
	 */
	@Transactional
	public String createFamilyRecord(FamilyRecordDTO familyRecord) {
		String flg = null;
		if (null != familyRecord) {
			FamilyRecordDTO familyRecordDTO = (FamilyRecordDTO) familyRecord;

            flg = checkFamilyMem(familyRecordDTO.getFamilyMemberList());   //检查成员
            if(ObjectUtil.isNotEmpty(flg)){
            	return flg;
            }

			FamilyInfo familyInfo = familyRecordDTO.getFamilyInfo();
			
			List<Long> personIds = new ArrayList<>();
			List<FamilyPersonRelation> pi=familyRecordDTO.getFamilyMemberList();
			for(int i=0;i<pi.size();i++){
				personIds.add(pi.get(i).getPersonId());
			}			
			Criteria criteria = new Criteria();
			criteria.add("T1.PERSON_ID", OP.IN, personIds).add("T2.STATUS", OP.NE, 2);
			
			flg = checkAccountNum(familyInfo);    //判断户口号是否已存在
			if(ObjectUtil.isNotEmpty(flg)){
				return flg;
			}
			
			Long fiId = null;
			if (null == familyInfo.getId()) {
				//判断是否已存在家庭档案
				List<FamilyPersonRelation> res=familyPersonRelationDao.getFamilyPersonRelations(criteria);
				if(ObjectUtil.isNotEmpty(res)){
					 flg = "familyNotOnly";
					 return flg;
				}
				fiId = familyInfoDao.generatedKey(familyInfo, "ID", null).longValue();
				familyInfo.setId(fiId);
			} else {
				fiId = familyInfo.getId();
				removeFamilyInfo(fiId);
			}
			/* 更新或新增家庭信息 */
			familyInfoDao.update(familyInfo);
			/* 新增家庭成员信息 */
			createMemberRecord(familyRecordDTO, fiId);
			/* 新增家庭饮用水类型 */
			createWaterRelation(familyRecordDTO, fiId);
			/* 新增家庭户厕类型 */
			createHostoiletRelation(familyRecordDTO, fiId);
			flg = "success";
		}
		return flg;
	}
	
   
	/**
	 * 注消家庭档案
	 * 	
	 */
	@Transactional
	public Integer cancelFamilyRecord(int status, FamilyCanceledInfo familyCanceledInfo) {
		Integer result = 0;
		try {
			// 家庭注销
			result = familyCanceledInfo.getId() != null ? familyCanceledDao.update(familyCanceledInfo) : familyCanceledDao.insert(familyCanceledInfo);
			if (result > 0) {
				Long familyId = Long.valueOf(familyCanceledInfo.getFamilyId());
				setFamilyStatus(status, familyId);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 审核家庭档案
	 * 	
	 */
	@Transactional
	public Integer approveCancelFamily(int status, FamilyCanceledInfo familyCanceledInfo) {
		Integer result = 0;
		try {
			Long familyId = Long.valueOf(familyCanceledInfo.getFamilyId());
			result = setFamilyStatus(status, familyId);
			if (result > 0 && status == 3) {
				familyCanceledDao.update(familyCanceledInfo, "rejectedReason");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	// //修改FaminlyInfo的状态
	private int setFamilyStatus(int status, Long familyId) {
		FamilyInfo familyInfo = new FamilyInfo();
		familyInfo.setId(familyId);
		familyInfo.setStatus(status);
		return familyInfoDao.update(familyInfo, "status");
	}
	@Transactional
	public FamilyCanceledInfo getCancelFamilyRecord(Criteria criteria) {
		return familyCanceledDao.get(criteria);
	}

	/**
	 * 删除家庭档案相关的
	 * 
	 * @param fid
	 */
	@Transactional
	private void removeFamilyInfo(Long fid) {
		familyHostoiletRelationDao.delete(new Criteria("familyId", fid));
		familyWaterRelationDao.delete(new Criteria("familyId", fid));
		familyPersonRelationDao.delete(new Criteria("familyId", fid));
	}

	/**
	 * 获取家庭档案列表
	 * 
	 * @param criteria
	 * @param page
	 * @return FamilyRecordDTO
	 */
	public PageList<FamilyInfo> getFamilyRecord(Page page, Criteria criteria, Order order) {
		PageList<FamilyInfo> plist = familyInfoDao.getPageList(page, criteria,order);
		if (null != plist) {
			List<FamilyInfo> fiList = plist.getList();
			if (null != fiList) {
				for (FamilyInfo fi : fiList) {
					/* 获取成员列表 */
					fi.setFamilyMemberList(familyPersonRelationDao.getList(new Criteria("familyId", fi.getId())));
					/* 获取饮水列表 */
					fi.setFamilyWaterRelationList(familyWaterRelationDao.getList(new Criteria("familyId", fi.getId())));
					/* 获取厕所列表 */
					fi.setFamilyHostoiletRelationList(familyHostoiletRelationDao.getList(new Criteria("familyId", fi.getId())));
				}
			}
			plist.setList(fiList);
		}
		return plist;
	}

	/**
	 * 根据FamilyInfo对象取得家庭档案对象
	 * 
	 * @param familyInfo
	 * @return
	 */
	public FamilyRecordDTO getFamilyRecord(FamilyInfo familyInfo) {
		FamilyRecordDTO dto = new FamilyRecordDTO();
		if (null == familyInfo || null == familyInfo.getId())
			return dto;
		Long fid = familyInfo.getId();
		FamilyPersonRelation familyPersonRelation = new FamilyPersonRelation();
		familyPersonRelation.setFamilyId(fid);
		dto.setFamilyInfo(familyInfoDao.get(new Criteria("id", fid)));
		List<PersonInfo> members = familyPersonRelationDao.getList(familyPersonRelation); // 根据家庭ID取得家庭成员个人列表
		List<FamilyWaterRelation> familyWaterRelations = familyWaterRelationDao.getList(new Criteria("familyId", fid)); // 用水类型列表
		List<FamilyHostoiletRelation> familyHostoiletRelations = familyHostoiletRelationDao.getList(new Criteria("familyId", fid)); // 户厕类型
		if (null != members)
			dto.setMemberList(members);
		if (null != familyWaterRelations)
			dto.setWaterRelationList(familyWaterRelations);
		if (null != familyHostoiletRelations)
			dto.setHostoiletRelationList(familyHostoiletRelations);
		return dto;
	}

	public PageList<PersonInfo> getUnRegRecordPersonList(PersonInfo personInfo,List<Long> ids, Page page,Criteria criteria) {
		return personInxfoDao.getUnRegFamilyPersonList(personInfo, ids, page,criteria);
	}

	/**
	 * 新增家庭成员信息
	 * 
	 * @param familyRecordDTO
	 * @param fiId
	 */
	private void createMemberRecord(FamilyRecordDTO familyRecordDTO, Long fiId) {
		if (null != familyRecordDTO.getFamilyMemberList()) {
			familyRecordDTO.setFamilyRelationWithFamilyId(fiId);
			familyPersonRelationDao.batchInsert(familyRecordDTO.getFamilyMemberList());
		}
	}

	/**
	 * 新增家庭饮用水类型
	 * 
	 * @param familyRecordDTO
	 * @param fiId
	 */
	private void createWaterRelation(FamilyRecordDTO familyRecordDTO, Long fiId) {
		if (null != familyRecordDTO.getWaterRelationList()) {
			familyRecordDTO.setWarterRelationWithFamilyId(fiId);
			familyWaterRelationDao.batchInsert(familyRecordDTO.getWaterRelationList());
		}
	}

	/**
	 * 新增户厕类别
	 * 
	 * @param familyRecordDTO
	 * @param fiId
	 */
	private void createHostoiletRelation(FamilyRecordDTO familyRecordDTO, Long fiId) {
		if (null != familyRecordDTO.getHostoiletRelationList()) {
			familyRecordDTO.setHostoiletRelationWithFamilyId(fiId);
			familyHostoiletRelationDao.batchInsert(familyRecordDTO.getHostoiletRelationList());
		}
	}
	 /**
     * 检查户口号是否唯一
     *
     * @param familyInfo
     */
	private String checkAccountNum(FamilyInfo familyInfo) {		
			String updateAccountNum=familyInfo.getAccountNumber();
			FamilyInfo AccountNumberInfo=familyInfoDao.get(new Criteria("id",familyInfo.getId()));
			if(ObjectUtil.isNotEmpty(AccountNumberInfo)){
				if(!updateAccountNum.equals(AccountNumberInfo.getAccountNumber())){
					if(ObjectUtil.isNotEmpty(familyPersonRelationDao.getList(new Criteria("accountNumber",updateAccountNum)))){
						return "accountNotOnly";
					}				
				}
			}else{
				if(ObjectUtil.isNotEmpty(familyPersonRelationDao.getList(new Criteria("accountNumber",updateAccountNum)))){
					return "accountNotOnly";
				}	
			}
			return null;
	}

    /**
     * 检查家庭成员
     *
     * @param familyPersonRelations
     */
    private String checkFamilyMem(List<FamilyPersonRelation> familyPersonRelations){
    	if(!ObjectUtil.isNotEmpty(familyPersonRelations)){
    		return "noFamilyMember";
    	}
        int FamilyHead=0;
        int FamilyMate=0;
        for	(FamilyPersonRelation  person :familyPersonRelations ) {
            if(EHRConstants.FAMILY_MEMTYPE_HEAD.equals(person.getFamilyMemTypeCode())){
            	FamilyHead++;
            }
            if(EHRConstants.FAMILY_MEMBERS_MATE.equals(person.getFamilyMemTypeCode())){
            	FamilyMate++;
            }
            if (FamilyHead>1 || FamilyMate>1) {
                return "multipleFamilyHeadOrMate";
            }
        }
        if(FamilyHead < 1){
            return "noFamilyHeadError";
        }
        return null;
    }


	@Override
	public List<FamilyCanceledInfo> getFamilies(Criteria criteria, Order order) {
		return familyCanceledDao.getList(criteria, order);
	}

	@Override
	public FamilyInfo getFamilyInfo(Criteria criteria) {
		return familyInfoDao.get(criteria);
	}


	@Override
	public boolean updateFamilyInfo(FamilyInfo familyInfo, String... properties) {
		int flag = familyInfoDao.update(familyInfo, properties);
		return flag == 1 ? true : false;
	}

	@Override
	public List<FamilyStatisticDto> getFamilyDtoList(Criteria criteria) {

		List<FamilyStatisticDto> dsCensusReports = new ArrayList<>();

		// 统计卫生服务站体检进度
		// 统计卫生服务站体检进度
		if (criteria.contains(ORGCODE)) {
			if(criteria.contains("qwgzxCode")) {
				criteria.remove("qwgzxCode");
			}
			if(criteria.contains("month")==false && criteria.contains("year")==true){

				List<FamilyStatisticDto> list = populaceDao.getFamilyStatisticDtoList(criteria, null);
				FamilyStatisticDto dsCensus = null;

				if(ObjectUtil.isNotEmpty(list)){
					dsCensus = list.get(0);
				}

				if(ObjectUtil.isNullOrEmpty(dsCensus)){
					dsCensus=new FamilyStatisticDto();
				}
				dsCensus.setOrgCode(criteria.get(ORGCODE).toString());
				dsCensusReports.add(dsCensus);
			}else{
				if(criteria.contains("qwgzxCode")) {
					criteria.remove("qwgzxCode");
				}
				if (criteria.contains("gbcode")) {
					String gbCode=(String)criteria.get("gbcode");
					criteria.remove("gbcode");
					criteria.add("gbCode",gbCode);
				}
				List<FamilyStatisticDto> list = populaceDao.getFamilyStatisticDtoList(criteria, null);
				FamilyStatisticDto dsCensus = null;

				if(ObjectUtil.isNotEmpty(list)){
					dsCensus = list.get(0);
				}

				if(dsCensus==null){
					dsCensus = new FamilyStatisticDto();
				}
				dsCensus.setOrgCode(criteria.get(ORGCODE).toString());
				dsCensusReports.add(dsCensus);
			}
		} else if (criteria.contains(CENTERORGCODE) && !criteria.contains(ORGCODE)&& !criteria.contains(GBCODE)) { // 统计卫生服务中心体检进度
			//获取卫生服务中心
			if(criteria.contains("qwgzxCode")) {
				criteria.remove("qwgzxCode");
			}
			String organCode = criteria.get(CENTERORGCODE).toString();
			criteria.add(ORGCODE, organCode);

			List<String> organCodeList=new ArrayList<>();
			organCodeList.add(organCode);
			List<Organization> stations = getStation(organCode);
			for (Organization organization1 : stations) {
				organCodeList.add(organization1.getOrganCode());
			}

			if(criteria.contains("month")==true || criteria.contains("year")==false){
				if (criteria.contains("gbcode")) {
					String gbCode=(String)criteria.get("gbcode");
					criteria.remove("gbcode");
					criteria.add("gbCode",gbCode);
				}
			}

			List<FamilyStatisticDto> dsCensusList = populaceDao.getFamilyStatisticDtoList(criteria, organCodeList);
			dsCensusReports.addAll(dsCensusList);
		} else if (criteria.contains(GBCODE)) {
			if(criteria.contains("qwgzxCode")) {
				criteria.remove("qwgzxCode");
			}
			List<Organization> centres = getCentre(String.valueOf(criteria.get(GBCODE)));
			if(criteria.contains(CENTERORGCODE)){
				String organCode = criteria.get(CENTERORGCODE).toString();
				criteria.add(ORGCODE, organCode);

				if(criteria.contains("month")==true || criteria.contains("year")==false){
					if (criteria.contains("gbcode")) {
						String gbCode=(String)criteria.get("gbcode");
						criteria.remove("gbcode");
						criteria.add("gbCode",gbCode);
					}
				}
				List<String> organCodeList=new ArrayList<>();
				organCodeList.add(organCode);
				List<Organization> stations = getStation(organCode);
				for (Organization organization1 : stations) {
					organCodeList.add(organization1.getOrganCode());
				}
				List<FamilyStatisticDto> dsCensusList = populaceDao.getFamilyStatisticDtoList(criteria, organCodeList);
				dsCensusReports.addAll(dsCensusList);
			}else{
				List<String> organCodeList=new ArrayList<>();
				for (Organization organization : centres) {
					organCodeList.add(organization.getOrganCode());
					List<Organization> stations = getStation(organization.getOrganCode());
					for (Organization organization1 : stations) {
						organCodeList.add(organization1.getOrganCode());
					}
				}

				List<FamilyStatisticDto> dsCensusList = populaceDao.getFamilyStatisticDtoList(criteria, organCodeList);
				Map<String, FamilyStatisticDto> map = new HashMap<>();
				for (FamilyStatisticDto census : dsCensusList) {
					map.put(census.getOrgCode(), census);
				}

				for (Organization organization : centres) {
					FamilyStatisticDto census = map.get(organization.getOrganCode());
					if(census == null){
						census = new FamilyStatisticDto();
						census.setOrgCode(organization.getOrganCode());
					}
					List<Organization> stations = getStation(organization.getOrganCode());
					for (Organization organization1 : stations) {
						if(map.get(organization1.getOrganCode()) != null)
							countCensus(census,map.get(organization1.getOrganCode()));
					}
					dsCensusReports.add(census);
				}
			}
		} else {
			if(criteria.contains("qwgzxCode")) {
				criteria.add(GBCODE, criteria.get("qwgzxCode"));
				criteria.remove("qwgzxCode");
				List<Organization> centres = getCentre(String.valueOf(criteria.get(GBCODE)));

				List<String> organCodeList=new ArrayList<>();
				for (Organization organization : centres) {
					organCodeList.add(organization.getOrganCode());
					List<Organization> stations = getStation(organization.getOrganCode());
					for (Organization organization1 : stations) {
						organCodeList.add(organization1.getOrganCode());
					}
				}

				List<FamilyStatisticDto> dsCensusList = populaceDao.getFamilyStatisticDtoList(criteria, organCodeList);
				Map<String, FamilyStatisticDto> map = new HashMap<>();
				for (FamilyStatisticDto census : dsCensusList) {
					map.put(census.getOrgCode(), census);
				}

				for (Organization organization : centres) {
					FamilyStatisticDto census = map.get(organization.getOrganCode());
					if(census == null){
						census = new FamilyStatisticDto();
						census.setOrgCode(organization.getOrganCode());
					}
					List<Organization> stations = getStation(organization.getOrganCode());
					for (Organization organization1 : stations) {
						if(map.get(organization1.getOrganCode()) != null)
							countCensus(census,map.get(organization1.getOrganCode()));
					}
					dsCensusReports.add(census);
				}
				criteria.remove(GBCODE);
			}else{
				Criteria ca = new Criteria("dic_code", "FS990001").add("parent_code",  EHRConstants.FS990001_ROOT);
				List<DicItem> dicItems = dictionaryApp.queryDicItem(ca);
				List<String> organCodeList=new ArrayList<>();
				for (DicItem dicItem : dicItems) {
					criteria.remove(GBCODE);
					criteria.add(GBCODE, dicItem.getItemCode());
					List<Organization> centres = getCentre(String.valueOf(criteria.get(GBCODE)));

					for (Organization organization : centres) {
						organCodeList.add(organization.getOrganCode());
						List<Organization> stations = getStation(organization.getOrganCode());
						for (Organization organization1 : stations) {
							organCodeList.add(organization1.getOrganCode());
						}
					}
				}

				List<FamilyStatisticDto> dsCensusList = populaceDao.getFamilyStatisticDtoList(criteria, organCodeList);
				Map<String, FamilyStatisticDto> map = new HashMap<>();
				for(FamilyStatisticDto census :dsCensusList){
					map.put(census.getOrgCode(), census);
				}

				for (DicItem dicItem : dicItems) {
					criteria.remove(GBCODE);
					criteria.add(GBCODE, dicItem.getItemCode());
					List<Organization> centres = getCentre(String.valueOf(criteria.get(GBCODE)));

					for (Organization organization : centres) {
						FamilyStatisticDto census = map.get(organization.getOrganCode());
						if(census == null){
							census = new FamilyStatisticDto();
							census.setOrgCode(organization.getOrganCode());
						}
						List<Organization> stations = getStation(organization.getOrganCode());
						for (Organization organization1 : stations) {
							if(map.get(organization1.getOrganCode()) != null)
								countCensus(census, map.get(organization1.getOrganCode()));
						}
						dsCensusReports.add(census);
					}
				}
			}
		}
		return dsCensusReports;
	}

	private void countCensus(FamilyStatisticDto census, FamilyStatisticDto doctorSignCensus) {
		census.setFamilyNum(census.getFamilyNum() + doctorSignCensus.getFamilyNum());
		census.setRecordFamilyNum(census.getRecordFamilyNum() + doctorSignCensus.getRecordFamilyNum());
	}

	private List<Organization> getStation(String supOrganCode) {
		List<Organization> stations = new ArrayList<Organization>();

		stations.addAll(organizationApp.queryOrganization(new Criteria(Organization.PARENT_CODE, supOrganCode).add("GENRE_CODE", OrgGenreCode.STATION.getValue())));
		return stations;
	}

	/**
	 * 获取镇下面所有服务服务中心
	 * @param gbCode 镇的编码
	 * @return
	 */
	private List<Organization> getCentre(String gbCode) {
		Criteria criteria = new Criteria();
		if(gbCode.equals("_hospital")){
			criteria.add("GENRE_CODE", OrgGenreCode.HOSPITAL.getValue());
		}else if(gbCode.equals("_other")){
			criteria.add("GENRE_CODE", OrgGenreCode.OTHER.getValue());
		} else if(gbCode.equals(EHRConstants._INFIRMARY)) {
			criteria.add("GENRE_CODE", OrgGenreCode.INFIRMARY.getValue());
		} else if(gbCode.equals(EHRConstants._HEALTHOVERSIGHT)) {
			criteria.add("GENRE_CODE", OrgGenreCode.HEALTH_OVERSIGHT.getValue());
		} else{
			criteria = new Criteria("GB_CODE", gbCode);
			criteria.add("GENRE_CODE", OrgGenreCode.CENTRE.getValue());
		}

		List<Organization> centres = organizationApp.queryOrganization(criteria);
		return centres;
	}
}