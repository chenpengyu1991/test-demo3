package com.founder.rhip.ehr.service.statistics.impl;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.common.EHRConstants;
import com.founder.rhip.ehr.dto.TargetDTO;
import com.founder.rhip.ehr.service.statistics.ITargetOrgService;
import com.founder.rhip.mdm.app.IDictionaryApp;
import com.founder.rhip.mdm.app.IOrganizationApp;
import com.founder.rhip.mdm.common.OrgGenreCode;
import com.founder.rhip.mdm.entity.DicItem;
import com.founder.rhip.mdm.entity.Organization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("targetOrgService")
public class TargetOrgServiceImpl implements ITargetOrgService{

	@Autowired
	private IOrganizationApp organizationApp;

	@Autowired
	private IDictionaryApp dictionaryApp;
	
	@Override
	public List<TargetDTO> getTargetDTOs(Integer nextCodeType,Integer codeType,String orgCode,Integer getCenter,String[] targetCodes) {
		if(isSelectNull(codeType)){
			List<String> codeList = getGB();
			List<TargetDTO> targetList = getDTOs(nextCodeType,codeList,targetCodes);
			return targetList;
		}else if(isSelectGB(codeType)){
			List<String> codeList = getCenters(codeType, orgCode);
			List<TargetDTO> targetList = getDTOs(nextCodeType,codeList,targetCodes);
			return targetList;
		}else if(isSelectCenter(codeType)){
			List<String> centerCodeList = getCenters(codeType, orgCode);
			List<String> stationCodeList = getStationCodes(codeType, orgCode);
			List<TargetDTO> centerTargetList = getDTOs(codeType,centerCodeList,targetCodes);
			List<TargetDTO> stationTargetList = getDTOs(nextCodeType,stationCodeList,targetCodes);
			if(getCenter.equals(ITargetOrgService.GET_STATION)){
				return stationTargetList;
			}else if(getCenter.equals(ITargetOrgService.GET_CENTER)){
				return centerTargetList;
			}else if(getCenter.equals(ITargetOrgService.GET_ALL)){
				stationTargetList.addAll(centerTargetList);
				return stationTargetList;
			}
		}else if(isSelectStation(codeType)){
			List<String> codeList = getStationCodes(codeType, orgCode);
			List<TargetDTO> targetList = getDTOs(nextCodeType,codeList,targetCodes);
			return targetList;
		}
		return null;
	}
	
	private List<TargetDTO> getDTOs(Integer nextCodeType,List<String> codeList,String[] targetCodes) {
		List<TargetDTO> targetList = new ArrayList<>();
		for(String code:codeList){
			TargetDTO tDto = new TargetDTO();
			tDto.setCode(code);
			tDto.setType(nextCodeType);
			tDto.setTargetCodes(targetCodes);
			targetList.add(tDto);
		}
		return targetList;
	}
	
	
	@Override
	public List<String> getStationCodes(Integer type,String code){
		Criteria criteria = new Criteria("GENRE_CODE", OrgGenreCode.STATION.getValue());
		if(type.equals(TargetDTO.GB)){
			criteria.add("GB_CODE", code);
		}else if(type.equals(TargetDTO.CENTER)){
			criteria.add(Organization.PARENT_CODE, code);
		}else if(type.equals(TargetDTO.STATION)){
			criteria.add(Organization.ORGAN_CODE, code);
		}else{
			return null;
		}
		List<Organization> orgs = organizationApp.queryOrganization(criteria);
		return codes(orgs);
	}
	
	
	@Override
	public List<String> getCenters(Integer type,String code){
		Criteria criteria = new Criteria("GENRE_CODE", OrgGenreCode.CENTRE.getValue());
		if(type.equals(TargetDTO.GB)){
			criteria.add("GB_CODE", code);
		}else if(type.equals(TargetDTO.CENTER)){
			criteria.add(Organization.ORGAN_CODE, code);
		}else if(type.equals(TargetDTO.STATION)){
			return null;
		}else{
			return null;
		}
		List<Organization> orgs = organizationApp.queryOrganization(criteria);
		return codes(orgs);
	}
	
	//"虞山林场","常熟经济开发区","常熟东南开发区","常熟虞山尚湖旅游度假区","江苏常熟服装城管理委员会";
	private String[] notIn = new String[]{"320581400000","320581401000","320581402000","320581403000","320581404000"};
	
	private List<String> getGB(){
		List<String> codeList = new ArrayList<>();
		Criteria criteria = new Criteria("dic_code", "FS990001").add("parent_code", EHRConstants.FS990001_ROOT);
		/**
		 * 屏蔽目前为空的数据
		 * */
		criteria.add("item_code",OP.NOTIN,notIn);
		List<DicItem> dicItems = dictionaryApp.queryDicItem(criteria);
		for(DicItem dic :dicItems){
			codeList.add(dic.getItemCode());
		}
		return codeList;
	}
	
	/** 
	* @Title: codes 
	* @Description: 获取机构的编码
	* @param @param orgs
	* @param @return
	* @return List<String>
	* @throws 
	*/
	private List<String> codes(List<Organization> orgs){
		List<String> orgCodes = new ArrayList<>();
		if(ObjectUtil.isNotEmpty(orgs)){
			for(Organization o :orgs){
				orgCodes.add(o.getOrganCode());
			}
		}
		return orgCodes;
	}
	
//	/** 
//	* @Title: getNextListOrg 
//	* @Description: 获取下级机构代码
//	* @param @param codeType 机构类型
//	* @param @param orgCode 机构编码
//	* @param @param orgCode 获取到中心
//	* @param @return
//	* @return List<String>
//	* @throws 
//	*/
//	private List<String> getNextListOrg(Integer codeType,String orgCode,Integer getCenter){
//		List<TargetDTO> targetList = new ArrayList<>();
//		
//		List<String> codeList = new ArrayList<>();
//		
//		//未选中镇
//		if(isSelectNull(codeType)){
//			Criteria criteria = new Criteria("dic_code", "FS990001").add("parent_code", EHRConstants.FS990001_ROOT);
//			List<DicItem> dicItems = dictionaryApp.queryDicItem(criteria);
//			for(DicItem dic :dicItems){
//				codeList.add(dic.getItemCode());
//			}
//			return codeList;
//		}
//		//选了镇
//		if(isSelectGB(codeType)){
//			Criteria criteria = new Criteria("GB_CODE", orgCode);
//			criteria.add("GENRE_CODE", OrgGenreCode.CENTRE.getValue());
//			List<Organization> centres = organizationApp.queryOrganization(criteria);
//			for(Organization org :centres){
//				codeList.add(org.getOrganCode());
//			}
//			return codeList;
//		}
//		
//		//选了中心
//		if(isSelectCenter(codeType)){
//			if(getCenter.equals(ITargetOrgService.GET_CENTER)){
//				codeList.add(orgCode);
//				return codeList;
//			}else if(getCenter.equals(ITargetOrgService.GET_STATION)){
//				Criteria criteria = new Criteria("GENRE_CODE", OrgGenreCode.STATION.getValue());
//				criteria.add(Organization.PARENT_CODE, orgCode);
//				List<Organization> centres = organizationApp.queryOrganization(criteria);
//				for(Organization org :centres){
//					codeList.add(org.getOrganCode());
//				}
//				return codeList;
//			}else{
//				
//			}
//		}
//		//选站
//		if(isSelectStation(codeType)){
//			codeList.add(orgCode);
//			return codeList;
//		}
//		return null;
//	}
	
	/** 
	* @Title: isSelectGB 
	* @Description: 选中镇 
	* @param @return
	* @return boolean
	* @throws 
	*/
	private boolean isSelectGB(Integer codeType){
		if(codeType.equals(TargetDTO.GB)){
			return true;
		}
		return false;
	}
	
	private boolean isSelectCenter(Integer codeType){
		if(codeType.equals(TargetDTO.CENTER)){
			return true;
		}
		return false;
	}
	
	private boolean isSelectStation(Integer codeType){
		if(codeType.equals(TargetDTO.STATION)){
			return true;
		}
		return false;
	}
	
	private boolean isSelectNull(Integer codeType){
		if(codeType.equals(TargetDTO.NO_SELECT)){
			return true;
		}
		return false;
	}
}
