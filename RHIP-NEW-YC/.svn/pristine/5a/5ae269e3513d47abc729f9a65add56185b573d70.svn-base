package com.founder.rhip.ehr.service;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.beans.Order;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.ehr.common.EHRConstants;
import com.founder.rhip.ehr.dto.ihm.DoubleVisDTO;
import com.founder.rhip.ehr.entity.basic.PersonInfo;
import com.founder.rhip.ehr.entity.clinic.ReferralInfo;
import com.founder.rhip.ehr.repository.clinic.IReferalRecordDao;
import com.founder.rhip.ehr.repository.clinic.IReferralInfoDao;
import com.founder.rhip.ehr.repository.clinic.IReferralInfoDoubleDao;
import com.founder.rhip.ehr.service.personal.IPlatformService;
import com.founder.rhip.mdm.app.IDictionaryApp;
import com.founder.rhip.mdm.entity.DicItem;
import com.founder.rhip.mdm.entity.Organization;
import com.founder.rhip.mdm.service.IOrganizationService;

@Service("dualReferralService")
public class DualReferralServiceImpl implements IDualReferralService {

	@Resource
	private IReferralInfoDao referralInfoDao;

	@Resource
	private IPlatformService platformService;
	
	@Resource(name = "dictionaryApp")
	private IDictionaryApp dictionaryApp;
	
    @Resource(name = "mdmOrganizationService")
    private IOrganizationService organizationService;
    
    @Resource
    private IReferralInfoDoubleDao referralInfoDoubleDao;
    
    @Resource(name = "referalRecordDao")
    private IReferalRecordDao referalRecordDao;

    

	private String[] deleteProperties = new String[] {"updatePerson", "updateOrgan", "updateTime", "isDelete"};

	private String[] updatePlatformProperties = new String[] {
			"name", "gender", "birthday", "idcard", "phoneNumber", "patownShip", "pastreet", "pahouseNumber"
	};

	@Override
	public PageList<ReferralInfo> getPageList(Page page, Criteria criteria) {
		return referralInfoDao.getPageList(page, criteria.add("integratedData", 0).add("isDelete", 0), new Order("REFERRAL_DATE", false));
	}

	@Override
	public ReferralInfo getReferralInfo(Criteria criteria) {
		return referralInfoDao.get(criteria);
	}

	@Transactional
	@Override
	public int save(ReferralInfo referralInfo) {
		if (referralInfo == null) {
			return 0;
		}
//		updatePlagform(referralInfo);0172323: 【健康档案】新增双向转诊时，会清空身份证号码
		if (referralInfo.getId() == null) {
			//新建
			return referralInfoDao.generatedKey(referralInfo, "ID", null).intValue();
		} else {
			//更新
			return referralInfoDao.update(referralInfo);
		}
	}

	@Override
	public int delete(ReferralInfo referralInfo) {
		referralInfo.setIsDelete(1);
		return referralInfoDao.update(referralInfo, deleteProperties);
	}

	private void updatePlagform(ReferralInfo referralInfo) {
		Long personId = referralInfo.getPersonId();
		PersonInfo personInfo = new PersonInfo();
		personInfo.setId(personId);
		personInfo.setName(referralInfo.getName());
		personInfo.setGender(referralInfo.getGender());
		personInfo.setBirthday(referralInfo.getBirthday());
		personInfo.setIdcard(referralInfo.getIdCard());
		personInfo.setPhoneNumber(referralInfo.getPatientPhone());
		personInfo.setPatownShip(referralInfo.getFatownShip());
		personInfo.setPastreet(referralInfo.getFastreet());
		personInfo.setPahouseNumber(referralInfo.getFahouseNumber());
		personInfo.setUpdateDate(referralInfo.getUpdateTime());
		personInfo.setUpdateName(referralInfo.getUpdatePerson());
		personInfo.setUpdateOrganCode(referralInfo.getUpdateOrgan());
		if (personId == null) {
			//建档
			personInfo.setInputDate(referralInfo.getUpdateTime());
			personInfo.setInputName(referralInfo.getUpdatePerson());
			personInfo.setInputOrganCode(referralInfo.getUpdateOrgan());
			String pid = platformService.createPerson(personInfo, EHRConstants.RETURN_PERSON_ID, false);
			if (StringUtil.isNotEmpty(pid)) {
				referralInfo.setPersonId(Long.parseLong(pid));
			}
		} else {
			//更新档案
			platformService.updatePersonInfo(personInfo, updatePlatformProperties);
		}
	}

	@Override
	public List<ReferralInfo> queryReferralInfoList(Long personId, Date beginDate, Date endDate) {
		Criteria criteria = new Criteria();
		criteria.add("personId", personId);
		if (ObjectUtil.isNotEmpty(beginDate)) {
			if (ObjectUtil.isNotEmpty(endDate)) {
				criteria.add("referralDate", OP.BETWEEN, new Date[]{beginDate, endDate});
			} else {
				criteria.add("referralDate", OP.GE, beginDate);
			}
		}else if (ObjectUtil.isNotEmpty(endDate)) {
			criteria.add("referralDate", OP.LE, endDate);
		}
		return referralInfoDao.getList(criteria.add("integratedData", 0).add("isDelete", 0), new Order("REFERRAL_DATE", false));
	}
	
	@Override
	public List<ReferralInfo> queryReferralInfoList(String pixId, Date beginDate, Date endDate) {
		PersonInfo person = platformService.queryPersonalInfo(pixId);
		if (person == null) {
			return null;
		}
		Long personId = person.getId();
		return queryReferralInfoList(personId, beginDate, endDate);
	}

	@Override
	public List<ReferralInfo> getList(Criteria criteria) {
		return referralInfoDao.getList(criteria);
	}
	
	/**
     * @author wangzhou
     */
    @Override
    public List<DoubleVisDTO> getDoubleVisList(Map<String, String> map){
        String organCode = map.get("organCode");
        String genreCode = map.get("genreCode");
        String superOrganCode = map.get("superOrganCode");
        String gbCode = map.get("gbCode");
        Object[] array = this.getOrganArray(genreCode, organCode, superOrganCode, gbCode);

        String beginDate = map.get("beginDate");
        String endDate = map.get("endDate");
        String filedName = null;
        if("0".equals(genreCode)) //按镇
        {
            filedName = "gbCode";
        }else
        {
            filedName = "orgCode";
        }

        List<DoubleVisDTO> doubleVisDTOs = new ArrayList<>();
        if(array != null && array.length > 0)
        {
            for(int i = 0; i < array.length; i++)
            {
                String strTemp = null;
                if("0".equals(genreCode))//按镇
                {
                    Criteria criteriaTemp = new Criteria("gbCode", array[i]).add("organCode", OP.IS, "NOT NULL").add("genreCode", OP.IN, new String[]{"A100","B100","B200"}).add("status", "1");
                    List<Organization> orgs = organizationService.getOrganizations(criteriaTemp);

                    if (!CollectionUtils.isEmpty(orgs)) {
                        strTemp = Convert2String(orgs, "organCode");
                    }else
                    {
                        strTemp = "'" + array[i] + "'";
                    }
                }else
                {
                    strTemp = String.valueOf(array[i]);
                }
                Criteria criteria = new Criteria(filedName, strTemp).add("beginDate", beginDate).add("endDate", endDate);
                DoubleVisDTO doubleVisDTO = this.getDoubleVisList(criteria, String.valueOf(array[i]));
                doubleVisDTOs.add(doubleVisDTO);
            }
        }

        return doubleVisDTOs;
    }
    
    
    /**
     * @param criteria 查询条件
     * @param orgCode 机构代码
     * @return
     */
    private DoubleVisDTO getDoubleVisList(Criteria criteria, String orgCode) {
        Integer outnum = referralInfoDoubleDao.getOutList(criteria);
        Integer innum = referralInfoDoubleDao.getInList(criteria);
        DoubleVisDTO doubleVisDTO = new DoubleVisDTO();
        doubleVisDTO.setOrgCode(orgCode);
        doubleVisDTO.setOutTransfer(outnum);
        doubleVisDTO.setInTransfer(innum);
        return doubleVisDTO;
    }
    
    private <T> String Convert2String(List<T> list, String fieldName) {
        StringBuilder strB = new StringBuilder();
        if (!CollectionUtils.isEmpty(list))
        {
            Method method;
            try {
                method = list.get(0).getClass().getDeclaredMethod("get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1));
                for (int i = 0; i < list.size(); i++) {
                    if(i == 0)
                    {
                        strB.append("'" + method.invoke(list.get(i)) + "'");
                    }else
                    {
                        strB.append(",").append("'" + method.invoke(list.get(i)) + "'");
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return strB.toString();
    }
    
    
    /**
     * 组装查询条件
     *
     * @return
     */
    private Object[] getOrganArray(String genreCode, String organCode, String superOrganCode, String gbCode) {
        Criteria criteriaTemp = null;
        Object[] array = null;

        // 机构
        if("0".equals(genreCode)) // 按镇
        {
            if (StringUtil.isNotEmpty(gbCode)) {
                array = new Object[]{gbCode};
            } else {
                List<DicItem> dicItems = dictionaryApp.queryDicItem(new Criteria("dic_code", "FS990001").add("parent_code", EHRConstants.FS990001_ROOT));
                if (!CollectionUtils.isEmpty(dicItems)) {
                    array = Convert2Array(dicItems,"itemCode");
                }
            }
        } else if ("A100".equals(genreCode)) // 按市级医院
        {
            criteriaTemp = new Criteria().add("genreCode", "A100");
            if (StringUtil.isNotEmpty(superOrganCode)) {
                criteriaTemp.add("organCode", superOrganCode);
            } else {
                criteriaTemp = criteriaTemp.add("organCode", OP.IS, "NOT NULL");
            }
            criteriaTemp.add("SUBSID","0");
        } else if ("B100".equals(genreCode)) // 按卫生院
        {

            criteriaTemp = new Criteria().add("genreCode", "B100");
            if(StringUtil.isNotEmpty(gbCode))
            {
                criteriaTemp.add("gbCode", gbCode);
            }

            if(StringUtil.isNotEmpty(superOrganCode))
            {
                criteriaTemp.add("organCode", superOrganCode);
            }else
            {
                criteriaTemp = criteriaTemp.add("organCode", OP.IS, "NOT NULL");
            }
        } else if ("B200".equals(genreCode)) // 按社区卫服务站
        {
            criteriaTemp = new Criteria().add("genreCode", "B200");
            if(StringUtil.isNotEmpty(gbCode))
            {
                criteriaTemp = criteriaTemp.add("gbCode", gbCode);
            }

            if(StringUtil.isNotEmpty(superOrganCode))
            {
                criteriaTemp = criteriaTemp.add("parentCode", superOrganCode);
            }

            if(StringUtil.isNotEmpty(organCode))
            {
                criteriaTemp = criteriaTemp.add("organCode", organCode);
            }else
            {
                criteriaTemp = criteriaTemp.add("organCode", OP.IS, "NOT NULL");
            }
        }

        if (null != criteriaTemp) {
            criteriaTemp.add("status", "1");
            List<Organization> orgs = organizationService.getOrganizations(criteriaTemp);

            if (!CollectionUtils.isEmpty(orgs)) {
                array = Convert2Array(orgs, "organCode");
            }
        }

        return array;
    }

    private <T> Object[] Convert2Array(List<T> list, String fieldName) {
        Object[] ta = new Object[list.size()];
        if (CollectionUtils.isEmpty(list))
            return ta;
        Method method;
        try {
            method = list.get(0).getClass().getDeclaredMethod("get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1));
            for (int i = 0; i < list.size(); i++) {
                ta[i] = method.invoke(list.get(i));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ta;
    }
}
