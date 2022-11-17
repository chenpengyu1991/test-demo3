package com.founder.rhip.ehr.service.woman;

import com.founder.fasf.beans.*;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.ehr.entity.women.DeliveryNeonatal;
import com.founder.rhip.ehr.entity.women.DeliveryRecordInfo;
import com.founder.rhip.ehr.repository.women.IDeliveryNeonatalDao;
import com.founder.rhip.ehr.repository.women.IDeliveryRecordInfoDao;
import com.founder.rhip.ehr.service.personal.IPersonRecordMoveService;
import com.founder.rhip.mdm.app.IOrganizationApp;
import com.founder.rhip.mdm.entity.Organization;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Author BaGen
 * @Description:
 * @Date Created in 20:23 2017/3/28.
 */
@Service("deliveryService")
public class DeliveryServiceImpl implements IDeliveryService,IPersonRecordMoveService {

    @Resource(name = "deliveryRecordInfoDao")
    private IDeliveryRecordInfoDao deliveryRecordInfoDao;  //分娩记录信息表

    @Resource(name = "deliveryNeonatalDao")
    private IDeliveryNeonatalDao deliveryNeonatalDao;  //分娩记录新生儿情况
    @Autowired
    private IOrganizationApp organizationApp;

    @Override

    public void saveDelivery( DeliveryRecordInfo deliveryRecordInfo) {
        //新增
        if(ObjectUtil.isNullOrEmpty(deliveryRecordInfo.getId())){
            deliveryRecordInfo.setCreateDate(new Date());
            deliveryRecordInfo.setUpdateDate(new Date());
            deliveryRecordInfoDao.insert(deliveryRecordInfo);
        }else {//更新
            deliveryRecordInfo.setUpdateDate(new Date());
            deliveryRecordInfoDao.update(deliveryRecordInfo);
        }
        //先删除已存在的新生儿信息,再插入最新的新生儿信息
        deliveryNeonatalDao.delete(new Criteria("MOTHER_IDCARD",deliveryRecordInfo.getIdCard()).add("RECORD_NUMBER",deliveryRecordInfo.getRecordNumber()));
        //新增新生儿
        if(ObjectUtil.isNotEmpty(deliveryRecordInfo.getNeonatalList())){
            for(DeliveryNeonatal deliveryNeonatal:deliveryRecordInfo.getNeonatalList()){
                deliveryNeonatal.setMotherIdcard(deliveryRecordInfo.getIdCard());
                deliveryNeonatal.setRecordNumber(deliveryRecordInfo.getRecordNumber());
                deliveryNeonatal.setCreateDate(new Date());
                deliveryNeonatal.setUpdateDate(new Date());
                deliveryNeonatalDao.insert(deliveryNeonatal);
            }
        }

    }

    @Override
    public int deleteDelivery(Long deliveryId) {
        int result = 0;
        if(ObjectUtil.isNullOrEmpty(deliveryId)) {
            return result;
        }
        result = deliveryRecordInfoDao.delete(new Criteria("ID",deliveryId));
        return result;
    }

    @Override
    public DeliveryRecordInfo getDelivery(Criteria criteria) {
        DeliveryRecordInfo deliveryRecordInfo = deliveryRecordInfoDao.get(criteria);
        if(ObjectUtil.isNotEmpty(deliveryRecordInfo)){
            List<DeliveryNeonatal> list =deliveryNeonatalDao.getList(new Criteria("MOTHER_IDCARD",deliveryRecordInfo.getIdCard()).add("RECORD_NUMBER",deliveryRecordInfo.getRecordNumber()), new Order("ID", true));
            deliveryRecordInfo.setNeonatalList(list);
        }
        return deliveryRecordInfo;
    }

    @Override
    public PageList<DeliveryRecordInfo> getDeliveryList(Boolean flg, List<String> orgCodes,Map<String, String> paramMap, Page page, HttpServletRequest request) {
        Criteria ca = new Criteria();
        String name = paramMap.get("name");
        String organCode = paramMap.get("organCode");
        String idCard = paramMap.get("idCard");
        String createDateStar = paramMap.get("createDateStart");
        String createDateEnd = paramMap.get("createDateEnd");
        
        ca.add("IS_DELETE",0);
        if(StringUtil.isNotEmpty(name)){
            ca.add("NAME", OP.LIKE, name);
        }
        if(StringUtil.isNotEmpty(idCard)){
            ca.add("ID_CARD", idCard);
        }
        
        if(flg){
            if(ObjectUtil.isNotEmpty(organCode)){
                ca.add("CREATE_ORGAN_CODE", organCode);
            }else if(ObjectUtil.isNotEmpty(orgCodes)){
                ca.add("CREATE_ORGAN_CODE", OP.IN, orgCodes);
            }
        } else {
            // 建档机构
            if (StringUtils.isNotEmpty(organCode)) {
                ca.add("CREATE_ORGAN_CODE", organCode);
            }else if(ObjectUtil.isNotEmpty(orgCodes)){
                ca.add("CREATE_ORGAN_CODE", OP.IN, orgCodes);
            }
        }

        if(StringUtil.isNotEmpty(createDateStar) || StringUtil.isNotEmpty(createDateEnd) ){
            DateUtil.getCriteriaByDateRange(ca, "DELIVERY_DATE", DateUtil.parseSimpleDate(createDateStar, "yyyy/MM/dd"), DateUtil.parseSimpleDate(createDateEnd, "yyyy/MM/dd"));
        }
        return deliveryRecordInfoDao.getPageList(page, ca, new Order("DELIVERY_DATE DESC, ID", false));
    }

    @Override
    public Integer getLiveBirthsNum(Integer year, Integer quarter, String orgCode) {
        return deliveryRecordInfoDao.getLiveBirthsNum(year,quarter,orgCode);
    }

    @Override
    public List<DeliveryRecordInfo> getDeliveryOrder(Criteria criteria,Order order){
        return deliveryRecordInfoDao.getList(criteria,order);
    }

    @Override
    public List<Map<String,Object>> liveBirthNum(Criteria criteria){
        return deliveryRecordInfoDao.liveBirthNum(criteria);
    }

    //档案迁移,孕产妇健康管理 分娩信息记录
    @Override
    @Transactional
    public void personRecordMove(Long personId, String smpiId,Organization oldOrg, Organization newOrg) {
        Criteria criteria = new Criteria("personId", personId);
        Parameters parameters = new Parameters();
        parameters.add("createOrganCode", newOrg.getOrganCode());
        deliveryRecordInfoDao.update(parameters, criteria);
    }
}
