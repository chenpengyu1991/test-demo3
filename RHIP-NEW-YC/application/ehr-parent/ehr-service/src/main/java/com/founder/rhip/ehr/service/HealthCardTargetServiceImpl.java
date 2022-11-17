package com.founder.rhip.ehr.service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Order;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.ehr.common.EHRConstants;
import com.founder.rhip.ehr.entity.cic.CicCitizenCard;
import com.founder.rhip.ehr.repository.cic.ICicCitizenCardDao;
import com.founder.rhip.mdm.entity.DicItem;
import com.founder.rhip.mdm.entity.Organization;
import com.founder.rhip.mdm.service.IDictionaryService;
import com.founder.rhip.mdm.service.IOrganizationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 市民卡查询统计
 * 
 */
@Service("healthCardTargetService")
public class HealthCardTargetServiceImpl implements IHealthCardTargetService {

	@Resource(name = "cicCitizenCardDao")
	private ICicCitizenCardDao cicCitizenCardDao;
	
	@Resource(name="mdmOrganizationService")
	private IOrganizationService organizationService;
	
	@Resource(name="mdmDictionaryService")
	private IDictionaryService dictionaryService;

	@Override
	public PageList<CicCitizenCard> getCicCitizenCardList(Criteria criteria, Page page){
		return cicCitizenCardDao.getCicCitizenCardList(criteria, page);
	}

    /**
     * 市民卡历史查询
     * @param criteria
     * @param page
     * @return
     */
    @Override
    public PageList<CicCitizenCard> getCicCitizenCardHistory(Criteria criteria, Page page){
        Order order = new Order("UPDATE_DATE", false);
        order.desc("ID");
        return cicCitizenCardDao.getPageList(page, criteria, order);
    }

	@Override
	public List<Map<String, Object>> getCicCitizenCardStatistic(Criteria criteria) {
		String genreCode = (String)criteria.get("genreCode");
        String gbCode = (String)criteria.get("INPUT_GBCODE");
        String superOrganCode = (String)criteria.get("INPUT_CENTER_ORGAN_CODE");
        String organCode = (String)criteria.get("INPUT_ORGAN_CODE");
        List<Map<String, Object>> orgList = getQueryOrgans(genreCode,gbCode,superOrganCode,organCode);
        List<Map<String, Object>> list = cicCitizenCardDao.getCicCitizenCardStatistic(criteria);
        List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
        for(Map<String, Object> mapOrg : orgList){
        	boolean flag = true;
        	for(Map<String, Object> map : list){
            	if(mapOrg.get("ORGAN_CODE").equals(map.get("organCode"))){ 
            		result.add(map);
            		flag = false;
            		break;
            	}
            }
        	if(flag){
        		Map<String, Object> map = new HashMap<String, Object>();
        		map.put("organCode", mapOrg.get("ORGAN_CODE"));
        		map.put("countNormal", 0);
        		map.put("countLoss", 0);
        		map.put("countChange", 0);
        		map.put("countReissue", 0);
        		result.add(map); 
        	}
        }
        Map<String,Object> map = new HashMap<String,Object>();
		map.put("organCode", "合计"); 
		map.put("countNormal", 0);
		map.put("countLoss", 0);
		map.put("countChange", 0);
		map.put("countReissue", 0);
		for(Map<String,Object> townMap : result){
			map.put("countNormal", (Integer)townMap.get("countNormal")+(Integer)map.get("countNormal"));
			map.put("countLoss", (Integer)townMap.get("countLoss")+(Integer)map.get("countLoss"));
			map.put("countChange", (Integer)townMap.get("countChange")+(Integer)map.get("countChange"));
			map.put("countReissue", (Integer)townMap.get("countReissue")+(Integer)map.get("countReissue"));
		}
		result.add(map);
        return result;
	}

	@Override
	public CicCitizenCard getCicCitizenCard(Long id) {
		return cicCitizenCardDao.get(id);
	}
	
	/**
     * 获取要统计的机构
     * @param genreCode
     * @param gbCode
     * @param superOrganCode
     * @param organCode
     * @return
     */
    private List<Map<String,Object>> getQueryOrgans(String genreCode, String gbCode, String superOrganCode, String organCode){
        List<Map<String,Object>> result = new ArrayList<Map<String,Object>>();

        if("A100".equals(genreCode)){
            Criteria criteria = new Criteria("genreCode", "A100");
            criteria.add("status", "1");
            if(StringUtil.isNotEmpty(superOrganCode)){
                criteria.add("organCode", superOrganCode);
            }
            List<Organization> organizations = organizationService.getOrganizations(criteria);
            result = MapOrgans(organizations);
        }
        if("B100".equals(genreCode)){
            Criteria criteria = new Criteria("genreCode", "B100");
            criteria.add("status", "1");
            if(StringUtil.isNotEmpty(gbCode)){
                criteria.add("gbCode", gbCode);
            }
            if(StringUtil.isNotEmpty(superOrganCode)){
                criteria.add("organCode", superOrganCode);
            }
            List<Organization> organizations = organizationService.getOrganizations(criteria);
            result = MapOrgans(organizations);
        }
        if("B200".equals(genreCode)){
            Criteria criteria = new Criteria("genreCode", "B200");
            criteria.add("status", "1");
            if(StringUtil.isNotEmpty(gbCode)){
                criteria.add("gbCode", gbCode);
            }
            if(StringUtil.isNotEmpty(superOrganCode)){
                criteria.add("parentCode", superOrganCode);
            }
            if(StringUtil.isNotEmpty(organCode)){
                criteria.add("organCode", organCode);
            }
            List<Organization> organizations = organizationService.getOrganizations(criteria);
            result = MapOrgans(organizations);
        }if("G2".equals(genreCode)){
            Criteria criteria = new Criteria("genreCode", "G2");
            if(StringUtil.isNotEmpty(gbCode)){
                criteria.add("gbCode", gbCode);
            }
            if(StringUtil.isNotEmpty(superOrganCode)){
                criteria.add("parentCode", superOrganCode);
            }
            if(StringUtil.isNotEmpty(organCode)){
                criteria.add("organCode", organCode);
            }
            List<Organization> organizations = organizationService.getOrganizations(criteria);
            result = MapOrgans(organizations);
        }
        if("0".equals(genreCode)){
            result = getGbCodes(new Criteria("gbCode", gbCode));
        }
        return result;
    }
    
    private List<Map<String,Object>> MapOrgans(List<Organization> organizations){
        List<Map<String,Object>> result = new ArrayList<Map<String,Object>>();
        for(Organization organization : organizations){
            Map orgMap = new HashMap();
            orgMap.put("ORGAN_CODE", organization.getOrganCode());
            result.add(orgMap);
        }
        return result;
    }
    
    /**
     * 获取镇机构列表
     *
     * @param criteria
     * @return
     * @author Cary
     */
    protected List<Map<String,Object>> getGbCodes( Criteria criteria){
        List<Map<String,Object>> result = new ArrayList<Map<String,Object>>();
        Object orgCode = criteria.get("gbCode");
        Criteria dicCa = new Criteria("dic_code", "FS990001").add("parent_code", EHRConstants.FS990001_ROOT);
        dicCa.add("status", "1");
        if(ObjectUtil.isNotEmpty(orgCode)){
            dicCa.add("item_code",orgCode.toString());
        }
        List<DicItem> dicitems = dictionaryService.getDicItems(dicCa);
        if(ObjectUtil.isNotEmpty(dicitems)){
            for(DicItem dicitem:dicitems){
                Map<String,Object> org = new HashMap<String,Object>();
                org.put("ORGAN_CODE", dicitem.getItemCode());
                result.add(org);
            }
        }
        return result;
    }
}
