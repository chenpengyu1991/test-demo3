package com.founder.rhip.ms;

import com.founder.fasf.beans.BeanUtil;
import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.beans.Order;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.BaseWebService;
import com.founder.rhip.ehr.common.EHRConstants;
import com.founder.rhip.ehr.entity.basic.PersonInfo;
import com.founder.rhip.ehr.entity.clinic.*;
import com.founder.rhip.ehr.service.IHealthExaminationService;
import com.founder.rhip.ehr.service.IInpatientDataService;
import com.founder.rhip.ehr.service.IPhysicalExamService;
import com.founder.rhip.ehr.service.ta.IOutpatientInfoService;
import com.founder.rhip.hm.service.IPersonInfoService;
import com.founder.rhip.mdm.entity.Department;
import com.founder.rhip.portal.dto.*;
import com.founder.rhip.portal.service.IMSService;
import com.founder.rhip.portal.service.util.Constants;
import com.founder.rhip.portal.service.util.ValidateUtil;
import com.founder.rhip.portal.service.util.XmlWebserviceForUtil;
import org.apache.commons.lang.StringUtils;
/*import org.springframework.beans.BeanUtils;*/
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.bind.JAXBException;
import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by f on 2016/11/7.
 */
@Service("msWebService")
@WebService(serviceName = "msWebService")
public class MSWebService extends BaseWebService implements IMSWebService {

    private static String FAIL = "0";
    private static String SUCCESS = "1";
    private final static String FORMAT_ERROR = "请求数据格式不正确";

    @Resource
    private IPersonInfoService personInfoService;

    @Resource
    private IOutpatientInfoService outpatientInfoService;

    @Resource
    private IInpatientDataService inpatientDataService;

    @Resource
    private IHealthExaminationService healthExaminationService;

    @Resource
    private IMSService MSService;


    //根据身份证查询门诊摘要信息
    @Override
    @WebMethod
    public String searchOutpatientInfo(String requestXml) {
        QueryReserve queryReserve;
        try {
            //将传参由xml形式转成bean形式
            queryReserve = XmlWebserviceForUtil.parseDataXml(requestXml, QueryReserve.class);
        } catch (Exception e) {
            e.printStackTrace();
            return XmlWebserviceForUtil.returnResult(FAIL, FORMAT_ERROR);
        }
        return MSService.searchOutpatientInfo(queryReserve);
    }


    //根据身份证查询住院信息
    @Override
    @WebMethod
    public String searchInpatientInfo(String requestXml) {
        //将xml形式转为bean形式
        QueryReserve queryReserve = new QueryReserve();
        try {
            queryReserve = XmlWebserviceForUtil.parseDataXml(requestXml, QueryReserve.class);
        } catch (Exception e) {
            e.printStackTrace();
            XmlWebserviceForUtil.returnResult(FAIL, FORMAT_ERROR);
        }
        return MSService.searchInpatientInfo(queryReserve);
    }


    //根据身份证查体检列表
    @Override
    public String getPhysiqueExaList(String requestXml) {
        QueryReserve queryReserve;
        try {
            queryReserve = XmlWebserviceForUtil.parseDataXml(requestXml, QueryReserve.class);//请求参数
        } catch (Exception e) {
            e.printStackTrace();
            return XmlWebserviceForUtil.returnResult(FAIL, FORMAT_ERROR);
        }
        return MSService.getPhysiqueExaList(queryReserve);
    }


    @Override
    public String getPhysiqueExaDetail(String requestXml) {

        //将xml形式转为bean形式
        GetPhyExamDetailReq getPhyExamDetailReq = new GetPhyExamDetailReq();
        try {
            getPhyExamDetailReq = XmlWebserviceForUtil.parseDataXml(requestXml, GetPhyExamDetailReq.class);
        } catch (Exception e) {
            e.printStackTrace();
            XmlWebserviceForUtil.returnResult(FAIL, FORMAT_ERROR);
        }
        return MSService.getPhysiqueExaDetail(getPhyExamDetailReq);
    }

    //根据身份证获取检验列表
    @Override
    public String getExam(String requestXml) {
        QueryReserve queryReserve = new QueryReserve();
        try {
            queryReserve = XmlWebserviceForUtil.parseDataXml(requestXml, QueryReserve.class);
        } catch (Exception e) {
            e.printStackTrace();
            return XmlWebserviceForUtil.returnResult(FAIL, FORMAT_ERROR);
        }
        return MSService.getExam(queryReserve);
    }

    //根据检验列表中的参数 查询检验详情
    @Override
    public String getExamDetail(String requestXml) {
        ExamResponse examResponse = new ExamResponse();
        try {
            examResponse = XmlWebserviceForUtil.parseDataXml(requestXml, ExamResponse.class);
        } catch (Exception e) {
            e.printStackTrace();
            return XmlWebserviceForUtil.returnResult(FAIL, FORMAT_ERROR);
        }
        return MSService.getExamDetail(examResponse);
    }

    /**
     * 根据身份证号查询检查列表
     *
     * @param requestXml
     * @return
     */
    @Override
    public String getStudy(String requestXml) {
        QueryReserve queryReserve = new QueryReserve();
        try {
            queryReserve = XmlWebserviceForUtil.parseDataXml(requestXml, QueryReserve.class);
        } catch (Exception e) {
            e.printStackTrace();
            return XmlWebserviceForUtil.returnResult(FAIL, FORMAT_ERROR);
        }
        return MSService.getStudy(queryReserve);
    }

    /**
     * 根据检查列表参数查询检查详情
     *
     * @param requestXml
     * @return
     */
    @Override
    public String getStudyDetail(String requestXml) {
        StudyResponse studyResponse = new StudyResponse();
        try {
            studyResponse = XmlWebserviceForUtil.parseDataXml(requestXml, StudyResponse.class);
        } catch (Exception e) {
            XmlWebserviceForUtil.returnResult(FAIL, FORMAT_ERROR);
        }
        return MSService.getStudyDetail(studyResponse);
    }

    /**
     * 获取用药信息
     *
     * @param requestXml
     * @return
     */
    @Override
    public String getDrug(String requestXml) {
        QueryReserve queryReserve = new QueryReserve();
        try {
            queryReserve = XmlWebserviceForUtil.parseDataXml(requestXml, QueryReserve.class);
        } catch (Exception e) {
            e.printStackTrace();
            XmlWebserviceForUtil.returnResult(FAIL, FORMAT_ERROR);
        }
        return MSService.getDrug(queryReserve);
    }

    /**
     * 查询床位情况
     *
     * @param requestXml
     * @return
     */
    @Override
    public String getPatientbed(String requestXml) {
        Department department = new Department();
        try {
            department = XmlWebserviceForUtil.parseDataXml(requestXml, Department.class);
        } catch (Exception e) {
            e.printStackTrace();
            XmlWebserviceForUtil.returnResult(FAIL, FORMAT_ERROR);
        }
        return MSService.getPatientbed(department);
    }
}
