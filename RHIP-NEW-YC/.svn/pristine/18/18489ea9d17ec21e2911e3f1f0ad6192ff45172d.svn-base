/**
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Founder. 
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with Founder.
 * 传染病上报
 */

package com.founder.rhip.idm.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.service.AbstractService;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.ehr.common.EHRConstants;
import com.founder.rhip.ehr.common.RoleType;
import com.founder.rhip.ehr.entity.basic.PersonInfo;
import com.founder.rhip.ehr.entity.basic.User;
import com.founder.rhip.ehr.entity.control.idm.notifiabledisease.CaseInformation;
import com.founder.rhip.ehr.entity.control.idm.notifiabledisease.GeneralCondition;
import com.founder.rhip.ehr.entity.control.idm.notifiabledisease.IdmApprovalInfo;
import com.founder.rhip.ehr.entity.control.idm.notifiabledisease.IdmReport;
import com.founder.rhip.ehr.entity.control.idm.notifiabledisease.IdmReportDesc;
import com.founder.rhip.ehr.entity.control.idm.notifiabledisease.IdmStatusInfo;
import com.founder.rhip.ehr.entity.control.idm.special.EventInfo;
import com.founder.rhip.ehr.entity.message.MessageSent;
import com.founder.rhip.ehr.repository.control.idm.notifiabledisease.IIdmReportDao;
import com.founder.rhip.ehr.repository.control.idm.notifiabledisease.IIdmReportDescDao;
import com.founder.rhip.ehr.repository.control.idm.notifiabledisease.IIdmStatusInfoDao;
import com.founder.rhip.ehr.repository.control.idm.special.IEventInfoDao;
import com.founder.rhip.ehr.repository.ihm.IMessageSentDao;
import com.founder.rhip.ehr.service.basic.IReportRecordService;
import com.founder.rhip.idm.common.AssignmentStatus;
import com.founder.rhip.idm.common.ReportStatus;
import com.founder.rhip.idm.dto.ReportDto;
import com.founder.rhip.mdm.app.IOrganizationApp;
import com.founder.rhip.mdm.entity.Organization;
import com.founder.rhip.mdm.entity.OrganizationArea;
import com.founder.rhip.mdm.repository.IDicItemDao;
import com.founder.rhip.mdm.repository.IOrganizationAreaDao;
import com.founder.rhip.mdm.service.IPersonService;

@Service("reportService")
public class ReportServiceImpl extends AbstractService implements IReportService {

    private final Logger logger = Logger.getLogger(ReportServiceImpl.class);

    @Resource(name = "idmReportDao")
    private IIdmReportDao idmReportDao;

    @Resource(name = "idmReportDescDao")
    private IIdmReportDescDao idmReportDescDao;

    @Resource(name = "haInterfaceService")
    private IHaInterfaceService haInterfaceService;

    @Resource(name = "idmStatusInfoDao")
    private IIdmStatusInfoDao idmStatusInfoDao;

    @Resource(name = "eventInfoDao")
    private IEventInfoDao eventInfoDao;

    @Resource(name = "approvalService")
    private IApprovalService approvalService;

    @Resource(name = "reportRecordService")
    private IReportRecordService reportRecordService;

    @Resource(name = "organizationApp")
    private IOrganizationApp organizationApp;

    @Resource(name = "messageSentDao")
    private IMessageSentDao messageSentDao;
    
    @Resource(name = "mdmOrganizationAreaDao")
    private IOrganizationAreaDao mdmOrganizationAreaDao;

    @Resource(name = "mdmDicItemDao")
    private IDicItemDao dicItemDao;

    @Resource(name="setupService")
    private ISetupService setupService;

    @Resource(name="mdmPersonService")
    IPersonService personService;
    //暂时不设置个案的疾病（审核之后不分配）(系统无个案，或者有个案屏蔽) 
    private List<String> notDistributeInfectious = new ArrayList<String>(Arrays.asList("2035", "2132", "222",
			"2231", "2232", "2233",
			"2234", "306", "307", "201",
			"308", "205",
			"2035","305","309","225","214","2141","2142","2143","2144",
			 "001", "002", "003", "004", "005", "006", "007", "008", "009"));
    
        
    
    
    
    /**
     * 添加
     *
     * @param reportDto
     * @return int
     * @throws Exception
     */
    @Transactional
    public boolean createReport(ReportDto reportDto, RoleType roleType, User user, long reportRecordId){
        boolean result = false;
        IdmReport reportInfo = reportDto.getReport();
        Long singleId = -1L;
        Integer status = getStatus(roleType, reportInfo);
        //复诊时，记录表状态为3；初诊时，记录表状态为2
        int type = EHRConstants.IDM_FIRST_YES;
        if (ObjectUtil.isNotEmpty(reportInfo)) {
            PersonInfo personInfo = SavePerson(reportInfo);//调用接口新增或更新患者
            //更新PERSON_ID字段 modify 2014/01/07 yjf
            if(ObjectUtil.isNotEmpty(personInfo)){
            	reportInfo.setPersonId(personInfo.getId());
            }
            //retreat:true,表示外部报卡“复治”时（即不走审核）
            if (!ObjectUtil.isNullOrEmpty(reportInfo.getReportStatus()) && reportInfo.getReportStatus() == 0) {
                status = 0;
                type = EHRConstants.IDM_SECOND_NO;
            }

            reportInfo.setReportStatus(status);
            Long idmId = createStatus(reportInfo, personInfo, reportDto.getLogoff(), status);//新增状态表，返回状态表ID

            //添加事件表记录，与专项一致。
            EventInfo eventInfo = new EventInfo();
            eventInfo.setStatusId(idmId);
            eventInfo.setEventId(-1L);
            singleId = eventInfoDao.generatedKey(eventInfo, "ID", null).longValue();
            reportInfo.setIdmId(singleId);
            if(ObjectUtil.isNullOrEmpty(reportInfo.getRecordNumber())) {
                String reportNumber = getReportNumber();
                reportInfo.setRecordNumber(reportNumber);
            }
            idmReportDao.generatedKey(reportInfo, "ID", null).longValue();//新增上报表
            //上报时不记录审批表
            //CreateApproval(reportInfo, "上报", user);
            //往消息提醒表添加记录 2015/06/15
            MessageSent messageSent = new MessageSent();
            messageSent.setCreateDate(new Date());
            messageSent.setReceivingUnit(reportInfo.getFillOrganCode());
            messageSent.setType("1");//传染病
            messageSent.setStatus("1");//未提醒
            messageSent.setTitle("传染病报卡");
            messageSent.setCreateOrganCode(reportInfo.getFillOrganCode());
            messageSentDao.insert(messageSent);
            result = true;
        }

        //成功修改上报记录表状态为：初诊上报
        if (result && reportRecordId != 0) {
        	/*报卡监控，补卡时更新监控状态 modify ye jianfei 20131031*/
        	if(StringUtil.isNotEmpty(reportDto.getReSubmitFlag())){
        		type = EHRConstants.IDM_REPEAT_YES;//补卡已上报
        	}
        	/*报卡监控，补卡时更新监控状态 modify ye jianfei 20131031*/
            result = reportRecordService.update(reportRecordId, reportInfo.getIdmId(), type) > 0 ? true : false;
        }

        //需要填写的到ReportDesc的信息
        IdmReportDesc reportDesc = reportDto.getReportDesc();
        if (ObjectUtil.isNotEmpty(reportDesc)) {
            reportDesc.setIdmId(singleId);
            idmReportDescDao.insert(reportDesc);
        }
        return result;
    }


    /**
     * 分页
     *
     * @param criteria
     * @param page
     * @return PageList<DcInfectionDiseaseReport>
     */
    public PageList<IdmReport> findReport(Criteria criteria, Page page) {
        return idmReportDao.getReportRecord(page, criteria);
    }
    public List<IdmReport> findReport(Criteria criteria) {
        return idmReportDao.getReportRecord(criteria);
    }
    
    public PageList<IdmReport> getReportLists(Page page, Criteria criteria){
    	return idmReportDao.getReportRecordList(page, criteria);
    }
    public List<IdmReport> getReportLists(Criteria criteria){
        return idmReportDao.getReportRecordList(criteria);
    }
    public IdmReport getReport(Criteria criteria){
        return idmReportDao.get(criteria);
    }

    public PageList<IdmReport> getFrList(Criteria criteria, Page page){
        return idmReportDao.getFrList(page, criteria);
    }
    /**
     * 
     */
    public List<Map<String, Object>> getDiseaseStatisticList(Criteria criteria){
        return idmReportDao.getDiseaseStatistic(criteria);
    }

    /**
     * 查看
     *
     * @param id
     * @return IdmReport
     */
    public ReportDto getReport(Integer id) {
        ReportDto reportDto = new ReportDto();
        IdmReport result = null;
        Long singleId = -1L;
        if (ObjectUtil.isNotEmpty(id)) {
            result = idmReportDao.get(id);
            singleId = result.getIdmId();
            Long idmId = eventInfoDao.get(singleId).getStatusId();
            IdmStatusInfo statusInfo = idmStatusInfoDao.get(idmId);
            result.setReportStatus(statusInfo.getReportStatus());
            result.setReportSource(statusInfo.getReportSource());
            /*从健康档案获取人员信息时，判断注销状态。modify yjf 20131010*/
            reportDto.setLogoff(statusInfo.getLogoff());
        }
        IdmReportDesc reportDesc = idmReportDescDao.get(new Criteria("IDM_ID", singleId));
        reportDto.setReport(result);
        
        if (ObjectUtil.isNotEmpty(reportDesc)) {
            reportDto.setReportDesc(reportDesc);
        }
        return reportDto;
    }

    /**
     * 审批
     *
     * @param reportDto
     * @param user
     * @return boolean
     * @throws Exception
     */
    @Transactional
    public boolean approveReport(ReportDto reportDto, User user) throws Exception {
        boolean result = false;
        IdmReport reportInfo = reportDto.getReport();
        IdmReportDesc reportDesc = reportDto.getReportDesc();
        if (ObjectUtil.isNotEmpty(reportInfo)) {
            Integer status = reportInfo.getReportStatus();//获取状态
            PersonInfo person = null;
			/*如果作废则不更新数据*/
            if (!status.equals(ReportStatus.CANCEL.getValue())) {
                person = SavePerson(reportInfo);//调用接口新增或更新患者
                if(ObjectUtil.isNotEmpty(person)){
                	reportInfo.setPersonId(person.getId());
                }
                
                idmReportDao.update(reportInfo);
                idmReportDescDao.update(reportDesc);
            } else {
                idmReportDao.update(reportInfo, new String[]{"backCardCause","deleteContent","deleteContentOther"});
            }
            updateStatus(reportInfo,person,reportDto.getLogoff(), status);//更新状态表
            String updateFlag = reportDto.getReport().getUpdateFlag();
            CreateApproval(reportInfo, "1".equals(updateFlag) ? "更新" : "审批", user);
            //2017-5-2 手足口病 分配的随访单位同个案分配单位一致
            //手足口病用   更新status表的currentUnit
           /* if("311".equals(reportInfo.getInfectiousCode())) {
                Organization org = organizationApp.queryOrganByVillage(reportInfo.getPastreet());
                if(null != org && !StringUtil.isNullOrEmpty(org.getParentCode())){
                    Parameters currentUnit = new Parameters();
                    currentUnit.add("CURRENT_UNIT", StringUtil.isNotEmpty(org.getParentCode())?org.getParentCode():reportInfo.getFillOrganCode());
                    Long singleId = reportInfo.getIdmId();
                    Long idmId = eventInfoDao.get(singleId).getStatusId();
                    idmStatusInfoDao.update(currentUnit, new Criteria("ID",idmId));
                }
            }*/

            result = true;
        }
        return result;
    }

    /**
     * 分配
     *
     * @param idmId
     * @param generalCondition
     * @param statusinfo
     * @param caseInformation
     * @return int
     */
    public int assignReport(String idmId, GeneralCondition generalCondition,
                            IdmStatusInfo statusinfo, CaseInformation caseInformation) {
        // TODO Auto-generated method stub
        return 0;
    }

    /**
     * 新增状态记录
     *
     * @param reportInfo
     * @param personInfo
     * @param logoff
     * @param status
     * @return
     */
    private Long createStatus(IdmReport reportInfo, PersonInfo personInfo, Integer logoff, Integer status) {
        IdmStatusInfo statusInfo = new IdmStatusInfo();
        if(ObjectUtil.isNotEmpty(personInfo)){
        	statusInfo.setPixId(personInfo.getSmpiId());
        	statusInfo.setPersonId(personInfo.getId());
        }
        statusInfo.setType(reportInfo.getInfectiousCode());
        statusInfo.setReportStatus(status);
		/*专项与法定区分字段*/
        statusInfo.setIdmType("1");
        //个案状态未填写
        statusInfo.setCaseStatus("1");
        //随访状态未填写
        statusInfo.setFrStatus("1");
        //采样状态未填写
        statusInfo.setTsStatus("1");
        //该人是否是注销状态：0正常，1注销
        statusInfo.setLogoff(logoff);
        //报卡上报来源
        statusInfo.setReportSource(reportInfo.getReportSource());
        //审核通过，默认分配状态为已分配
        if(ReportStatus.HOSPITAL_VERIFY.getValue().equals(status)){
        	statusInfo.setAssignmentStatus(AssignmentStatus.ASSIGNED.getValue().toString());
        	//设置个案的才分配
        	if(!notDistributeInfectious.contains(reportInfo.getInfectiousCode())){
        		distribute(reportInfo, personInfo, statusInfo);
            }	
        }
       
        //2017-5-2 手足口病 分配的随访单位同个案分配单位一致
        //手足口病用   随访单位(现住址的所在中心不为空时用现住址的所在中心 否则取当前上报单位)
        /*if("311".equals(reportInfo.getInfectiousCode())) {
            Organization org = organizationApp.queryOrganByVillage(reportInfo.getPastreet());
            if(null != org && !StringUtil.isNullOrEmpty(org.getParentCode())){
                statusInfo.setCurrentUnit(StringUtil.isNotEmpty(org.getParentCode())?org.getParentCode():reportInfo.getFillOrganCode());
            }
        }else{
            statusInfo.setCurrentUnit(reportInfo.getFillOrganCode());
        }  */
        return idmStatusInfoDao.generatedKey(statusInfo, "ID", null).longValue();
    }


    /**
     * 更新状态记录及分配
     *
     * @param reportInfo
     * @param personInfo
     * @param logOff
     * @param status
     * @return
     */
    private int updateStatus(IdmReport reportInfo, PersonInfo personInfo, Integer logOff, Integer status) {
        IdmStatusInfo statusInfo = new IdmStatusInfo();
        if (ObjectUtil.isNotEmpty(personInfo)) {
            statusInfo.setPixId(StringUtil.isNotEmpty(personInfo.getSmpiId())?personInfo.getSmpiId():"-1");
            statusInfo.setPersonId(personInfo.getId());
        }
        statusInfo.setType(reportInfo.getInfectiousCode());
        statusInfo.setReportStatus(status);
        statusInfo.setReportSource(reportInfo.getReportSource());
      
        //2016-12-28 功能修改：自动分配至现住址所在站、中心进行个案管理，如果该站、中心无权限管理，则分配至疾控。
        if (ReportStatus.HOSPITAL_VERIFY.getValue().equals(reportInfo.getReportStatus())) {
        	//设置个案的才分配
        	if(!notDistributeInfectious.contains(reportInfo.getInfectiousCode())){
        		distribute(reportInfo, personInfo, statusInfo);
            }	
		}
        /*从健康档案获取人员信息时，判断注销状态。modify yjf 20131010*/
        statusInfo.setLogoff(logOff);
        Long singleId = reportInfo.getIdmId();
        Long idmId = eventInfoDao.get(singleId).getStatusId();
        return idmStatusInfoDao.updateStatus(statusInfo, new Criteria("ID", idmId));
    }
    
	/**
	 * 获取患者ID
	 * @param eventId
	 * @return 患者ID
	 */
	private Long getPersonId(Long eventId) {
		IdmStatusInfo statusInfo = null;
		Long personId = null;
		if(ObjectUtil.isNotEmpty(eventId)){
			Long idmId = eventInfoDao.get(eventId).getStatusId();
			statusInfo = idmStatusInfoDao.get(idmId);
		}
		if(ObjectUtil.isNotEmpty(statusInfo)){
			personId = statusInfo.getPersonId();
		}
		return personId;
	}    

    /**
     * 删除报卡
     *
     * @param idmId
     * @param user
     * @return int
     */
    public int deleteReport(String idmId, User user) {
        int result = 0;
        return result;
    }

    public Object valueFindCode(Criteria criteria, String dicmeta){
        criteria.add("dicCode",dicmeta);
        return dicItemDao.get(criteria).getItemCode();
    }

    /**
     * 批量删除报卡
     *
     * @param user
     * @param idmIds
     * @return int
     */
    public int deleteReport(User user, String... idmIds) {
        int result = 0;
        return result;
    }

    /**
     * 新增审批记录
     *
     * @param reportInfo
     * @return
     */
    private int CreateApproval(IdmReport reportInfo, String Comments, User user) {
        IdmApprovalInfo approvalInfo = new IdmApprovalInfo();
        approvalInfo.setApprovalDate(new Date());
        approvalInfo.setComments(Comments);
        approvalInfo.setIdmId(reportInfo.getIdmId());
        approvalInfo.setStatus(reportInfo.getReportStatus().toString());
        if (!ObjectUtil.isNullOrEmpty(user.getId())) {
            approvalInfo.setUserId(user.getId().toString());
        }
        approvalInfo.setUserName(user.getName());
        return approvalService.createApprovalInfo(approvalInfo);
    }

    /**
     * 保存患者信息
     *
     * @param reportInfo
     * @return
     * @throws Exception
     */
    private PersonInfo SavePerson(IdmReport reportInfo) {
        PersonInfo personInfo = reportInfo.getPersonInfo();
        Long personId = getPersonId(reportInfo.getIdmId());
        personInfo.setId(personId);
        personInfo.setHouseholdType(reportInfo.getInfectedpersonBelong());
        String infectiousCode = reportInfo.getInfectiousCode();
        //淋病、梅毒、艾滋病更新（民族、文化程度、户籍地址）
        boolean moreFields = false;
        if (StringUtil.isNotEmpty(infectiousCode) && "222,2231,2232,2233,2234,2235,202".contains(infectiousCode)) {
            moreFields = true;
        }
        if (moreFields) {
            haInterfaceService.updatePersonInfoForReport(personInfo);
        } else {
        	if(ObjectUtil.isNotEmpty(reportInfo.getOtherIdcard())){
        		
        	}
            haInterfaceService.updatePersonInfo(personInfo);
        }
        return personInfo;
    }

    /**
     * 根据角色判断报卡时应保存的状态
     * 医生：未审核
     * 医院防保科：防保审核
     * 疾控防疫科：疾控审核
     *
     * @param roleType
     * @return
     */
    
    private Integer getStatus(RoleType roleType, IdmReport reportInfo) {
        Integer status = null;
        if(ObjectUtil.equals(EHRConstants.IDM_APPROVED_NO, reportInfo.getApprovalFlg())){
        	//外部报卡中审核状态为未审核；
    		status = ReportStatus.NOT_VERIFY.getValue();
    	} else {
    		 switch (roleType) {
	             case YS:
	                 status = ReportStatus.NOT_VERIFY.getValue();
	                 break;
	             case ZCRB:
	                 status = ReportStatus.NOT_VERIFY.getValue();
	                 break;
	             case ZXCRB:
	                 status = ReportStatus.HOSPITAL_VERIFY.getValue();
	                 break;
	             case JKFYK:
	                 status = ReportStatus.HOSPITAL_VERIFY.getValue();
	                 break;
	             case YYCRB: 
	             	status = ReportStatus.HOSPITAL_VERIFY.getValue();
	                 break;
	             default:
	                 break;
              }
    	}
        return status;
    }
    /*private Integer getStatus(RoleType roleType) {
        Integer status = null;
        switch (roleType) {
            case YS:
                status = ReportStatus.NOT_VERIFY.getValue();
                break;
            case SJYYYS:
                status = ReportStatus.NOT_VERIFY.getValue();
                break;
            case SQZX:
                status = ReportStatus.HOSPITAL_VERIFY.getValue();
                break;
            case FYK:
                status = ReportStatus.HOSPITAL_VERIFY.getValue();
                break;
            case SJYYFBK:
                status = ReportStatus.HOSPITAL_VERIFY.getValue();
                break;
            default:
                break;
        }
        return status;
    }*/


    /**
     * 根据当前日期获取报卡编号
     *
     * @return
     */
    private String getReportNumber() {
        String reportNumber = "320581";

        Date date = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddhhmmss");
        String time = df.format(date);
        Long id = idmReportDao.getCount(new Criteria("RECORD_NUMBER", OP.LIKE, time + "%"), "ID", Long.class);
        if (id > 1) {
            id = id + 1;
        } else {
            id = 1L;
        }
        reportNumber += time;
        reportNumber += String.format("%04d", id);
        return reportNumber;
    }
    /**
     * 自动分配至现住址所在站、中心、疾控
     * @param reportInfo
     * @param personInfo
     * @param statusInfo
     */
    
    private void distribute(IdmReport reportInfo, PersonInfo personInfo, IdmStatusInfo statusInfo) {

		Criteria ca = new Criteria("AREA_CODE",personInfo.getPastreet());
		OrganizationArea organizationArea = mdmOrganizationAreaDao.get(ca);
		Criteria setupCa = new Criteria("infectiousCode", reportInfo.getInfectiousCode());
		//setupCa.add("setYear", OP.EQ, DateUtil.getCurrentYear()); //2017-6-12修改 个案参数设置跟年份无关（不再按照每年设置一次）
		String currentUnit = "";
		if (ObjectUtil.isNotEmpty(organizationArea)) {
            Organization organization = organizationApp.queryOrgan(organizationArea.getOrganizationCode());
            if(organization==null){
                logger.warn("报卡时候所选现住址居委会未关联到对应社区服务中心(MDM_ORGANIZATION_AREA[AREA_CODE="+personInfo.getPastreet()+"]=>MDM_ORGANIZATION[OrganizationCode="+organizationArea.getOrganizationCode()+"])");
                statusInfo.setCurrentUnit(EHRConstants.JK_CODE);
            }else {
                //默认分配至站，没有站则分配至中心
                if (StringUtil.isNotEmpty(organization.getOrganCode()) && setupService.findSetup(setupCa.add("caseOrganCode", organization.getOrganCode())).size() > 0) {
                    statusInfo.setCurrentUnit(organization.getOrganCode());
                } else if (StringUtil.isNotEmpty(organization.getParentCode()) && setupService.findSetup(setupCa.add("caseOrganCode", organization.getParentCode())).size() > 0) {
                    statusInfo.setCurrentUnit(organization.getParentCode());
                } else {
                    statusInfo.setCurrentUnit(EHRConstants.JK_CODE);
                }
            }
			//审核通过，默认分配状态为已分配
			statusInfo.setAssignmentStatus(AssignmentStatus.ASSIGNED.getValue().toString());
		} else {
			statusInfo.setCurrentUnit(EHRConstants.JK_CODE); //自动分配到疾控
			//审核通过，默认分配状态为已分配
			statusInfo.setAssignmentStatus(AssignmentStatus.ASSIGNED.getValue().toString());
		} 
		//个案手动分配后未纳入前，报卡修改，则清空分配至机构
		statusInfo.setAssignedToUnit("");
    }

    /**
     * list
     * @param criteria
     * @return
     */
    public List<IdmReport> findReportTable(Criteria criteria) {
    	 return idmReportDao.getReportRecordTable(criteria);
    }
    
  /*  public List<Map<String, Object>> findExportTableMap(Criteria criteria) {
   	 return idmReportDao.getReportRecordTable(criteria);
   }*/
    /**
     * 按条件查重
     * @param criteria
     * @param page
     * @param conditions
     * @return
     */
    public PageList<IdmReport> getRepeatCasesList(Criteria criteria, Page page, String conditions){
    	return idmReportDao.getRepeatCases(page, criteria, conditions);
    };

    public void createUplodReport(ReportDto reportDto){
        IdmReport reportInfo = reportDto.getReport();
        EventInfo eventInfo = new EventInfo();
        PersonInfo personInfo = new PersonInfo();
        IdmStatusInfo statusInfo = new IdmStatusInfo();
        statusInfo.setIdmType("1");
        //个案状态未填写
        statusInfo.setCaseStatus("1");
        //随访状态未填写
        statusInfo.setFrStatus("1");
        //采样状态未填写
        statusInfo.setTsStatus("1");
        //该人是否是注销状态：0正常，1注销
        statusInfo.setLogoff(0);
        //报卡上报来源
        statusInfo.setReportSource(ObjectUtil.isNullOrEmpty(reportInfo.getReportSource())?"":reportInfo.getReportSource().toString().trim());

        Long idmId =idmStatusInfoDao.generatedKey(statusInfo, "ID", null).longValue();
        eventInfo.setStatusId(idmId);
        eventInfo.setEventId(-1L);
        Long singleId = eventInfoDao.generatedKey(eventInfo, "ID", null).longValue();

        reportInfo.setIdmId(singleId);
        Long resourceId = idmReportDao.generatedKey(reportInfo, "ID", null).longValue();
       reportDto.getReportDesc().setIdmId(resourceId);
       idmReportDescDao.insert(reportDto.getReportDesc());

    }
   
}