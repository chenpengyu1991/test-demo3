/**
 * @Title: ReserveHisServiceImpl.java
 * @Package com.founder.rhip.portal.service
 * @Description:预约和HIS交互的接口
 * @author LJY
 * @date 2013-8-8 下午2:26:34
 * @version V1.0
 */
package com.founder.rhip.portal.service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.ehr.common.IDCardUtil;
import com.founder.rhip.ehr.common.ReserveStauts;
import com.founder.rhip.ehr.entity.portal.OutClinic;
import com.founder.rhip.ehr.entity.portal.RegisterSchedule;
import com.founder.rhip.ehr.entity.portal.ReserveRegister;
import com.founder.rhip.ehr.repository.portal.IHospitalInfoDao;
import com.founder.rhip.ehr.repository.portal.IOutDoctorDao;
import com.founder.rhip.ehr.repository.portal.IReserveRegisterDao;
import com.founder.rhip.portal.dto.GetDeptZY;
import com.founder.rhip.portal.service.util.Axis2Util;
import com.founder.rhip.portal.service.util.Constants;
import com.founder.rhip.portal.service.util.HttpClientUtil;
import com.founder.rhip.portal.service.util.ValidateUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


/**
 * @author bagen
 * @ClassName: chineseMedicineHospitalReserveAdapter
 * @Description: 中医院预约相关接口
 * @date 2016年3月16日
 */
@Service("chineseMedicineHospitalReserveAdapter")
public class ChineseMedicineHospitalReserveAdapter  implements IHospitalReserveAdapter {

    @Autowired
    private IHospitalInfoDao hospitalInfoDao;

    @Autowired
    private IReserveRegisterDao reserveRegisterDao;

    @Autowired
    private IOutDoctorDao outDoctorDao;

    protected static Logger logger = Logger.getLogger(ChineseMedicineHospitalReserveAdapter.class);


    @SuppressWarnings("unchecked")
    @Override
    public Map<String, Object> queryDepartmentList() {
        Map<String, Object> mapResult = new HashMap<String, Object>();
        String url = Constants.QUERY_DEPTMENTS_URL_CMH;
        String result = HttpClientUtil.sendGet(url);
        List<GetDeptZY> departmentListForCMH = new ArrayList<GetDeptZY>();
        try {
            departmentListForCMH = (List<GetDeptZY>) json2List(result, "result", GetDeptZY.class);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        List<OutClinic> queryDepartmentList = new ArrayList<OutClinic>();
        if (ObjectUtil.isNotEmpty(departmentListForCMH)) {
            for (int i = 0; i < departmentListForCMH.size(); i++) {
                OutClinic outClinic = new OutClinic();
                outClinic.setDeptSn(departmentListForCMH.get(i).getDept_code());
                outClinic.setName(departmentListForCMH.get(i).getDept_name());
                queryDepartmentList.add(outClinic);
            }
            mapResult.put(Constants.RESERVE_RET_CODE, Constants.RET_CODE_CORRECT);
            mapResult.put(Constants.RESERVE_RET_MSG, queryDepartmentList);
        } else {
            mapResult.put(Constants.RESERVE_RET_CODE, Constants.RET_CODE_ERROR);
        }
        return mapResult;
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    @Override
    public Map<String, Object> querySchduleList(String hospitalcode, Date requestDate, String ampm,
           String clinicCode, String deptName, String doctorSn, String clinicType) {
        //门户点击医院时加载所有医生
        String getDoctsByDepUrl = Constants.QUERY_DOCTORS_URL_CMH;
        //调用接口方法获取所有医生
        String getDoctsresult = HttpClientUtil.sendGet(getDoctsByDepUrl);
        JSONObject doctsJsonResult = JSONObject.fromObject(getDoctsresult);
        JSONArray doctsJsonResult1 = (JSONArray) (((Map) doctsJsonResult).get("result"));
        Map<String, String> doctorMap = new HashMap<String, String>();
        Map<String, String> docMap = new HashMap<String, String>();
        //循环获取所有的医生
        for (int i = 0; i < doctsJsonResult1.size(); i++) {
            doctorMap = (Map) doctsJsonResult1.get(i);
            docMap.put(doctorMap.get("doctor_id"), doctorMap.get("doctor_name"));
        }
        Map<String, Object> mapResult = new HashMap<String, Object>();
        String requestDateBegin;
        String requestDateEnd;
        if (ObjectUtil.isNotEmpty(requestDate)) {
            requestDateBegin = DateUtil.toDateString(requestDate, "yyyy-MM-dd");//显示预约列表的开始时间
            requestDateEnd = DateUtil.toDateString(requestDate, "yyyy-MM-dd");//显示预约列表结束时间(7天)
        } else {
            requestDateBegin = DateUtil.toDateString(Axis2Util.getDate().get("sDate"), "yyyy-MM-dd");//显示预约列表的开始时间
            requestDateEnd = DateUtil.toDateString(Axis2Util.getDate().get("eDate"), "yyyy-MM-dd");//显示预约列表结束时间(7天)
        }
        StringBuffer getScheduleUrl = new StringBuffer();
        getScheduleUrl.append(Constants.QUERY_RESERVE_URL_CMH + requestDateBegin + "/" + requestDateEnd);
        if (ObjectUtil.isNotEmpty(doctorSn)) {
            getScheduleUrl.append("/" + doctorSn);
        }
        //调用接口获取预约列表
        String getSchedulers = HttpClientUtil.sendGet(getScheduleUrl.toString());
        JSONObject jResult = JSONObject.fromObject(getSchedulers);
        JSONArray jResult1 = (JSONArray) (((Map) jResult).get("result"));
        Map<String, Object> map = new HashMap<String, Object>();
        List<RegisterSchedule> registerScheduleLists = new ArrayList<RegisterSchedule>();
        //循环取得预约列表
        for (int i = 0; i < jResult1.size(); i++) {
            map = (Map) jResult1.get(i);
            String clinicTypeMap = "普通号".equals(map.get("reg_type").toString()) ? "01" : "02";
            if (clinicCode.equals((String) map.get("dept_code")) && StringUtil.isNullOrEmpty(doctorSn)
            		&& (StringUtil.isNullOrEmpty(clinicType)?true:(clinicType.equals(clinicTypeMap)))) {
                //结果转化成需要的门户需要的bean
                RegisterSchedule registerSchedule = this.paraseBean(map, docMap,deptName);
                registerScheduleLists.add(registerSchedule);
            }

            if (clinicCode.equals(map.get("dept_code")) && map.get("doctor_id").equals(doctorSn)) {
                RegisterSchedule registerSchedule = this.paraseBean(map, docMap,deptName);
                registerScheduleLists.add(registerSchedule);
            }
        }
        //没有数据情况
        if (ObjectUtil.isNullOrEmpty(registerScheduleLists)) {
            mapResult.put(Constants.RESERVE_RET_CODE, Constants.RET_CODE_ERROR);
            return mapResult;
        }
        mapResult.put(Constants.RESERVE_RET_CODE, Constants.RET_CODE_CORRECT);
        //显示该医生7天内的所有排班资源信息列表
        if (StringUtil.isNotEmpty(clinicCode) && StringUtil.isNotEmpty(deptName)) {
            ////显示医院7天内有排班资源的医生数量
            mapResult.put(Constants.RESERVE_RET_MSG, Axis2Util.schedulesCombineByConditions(registerScheduleLists));
        } else {
        	mapResult.put(Constants.RESERVE_RET_MSG, registerScheduleLists);
        }
        return mapResult;
    }

    @Override
    public Map<String, Object> saveReserve(ReserveRegister reserveRegister) {
        Map<String, Object> mapResult = new HashMap<String, Object>();
        //判断前台传值
        String validateResult = ValidateUtil.doValidate(reserveRegister, "idcard", "phoneNumber","registerScheduleTimeId", "requestDate", "name");
        //判断必须项
        if(StringUtil.isNotEmpty(validateResult)){
            logger.error(validateResult);
            mapResult.put(Constants.RESERVE_RET_CODE, Constants.RET_CODE_ERROR);
            mapResult.put(Constants.RESERVE_RET_MSG,validateResult);
            return mapResult;
        }
        //请求参数
        Map<String,String> mapRequest = new HashMap<String,String>();
        /*测试*/
//        mapRequest.put("hospital_code","00000011");
//        mapRequest.put("user_id","1234");
        
        /*正式*/
        mapRequest.put("hospital_code","00000004");
        mapRequest.put("user_id","8811");
        mapRequest.put("card_no",reserveRegister.getIdcard());
        mapRequest.put("mobile_num",reserveRegister.getPhoneNumber());
        mapRequest.put("reg_no",reserveRegister.getRegisterScheduleTimeId());
        mapRequest.put("doctor_date", DateUtil.toDateString(reserveRegister.getRequestDate(),"yyyy-MM-dd HH:mm:ss"));
        mapRequest.put("name",reserveRegister.getName());
        JSONObject requsetJSON = JSONObject.fromObject(mapRequest);
        JSONObject respJSON = HttpClientUtil.sendPost(Constants.SAVE_RESERVE_URL_CMH, requsetJSON.toString());
        //获取返回值
        JSONArray res = (JSONArray)(((Map) respJSON).get("data"));
        Map resMap = (Map)res.get(0);
        if("0".equals(resMap.get("ret_code"))){
            //返回异常信息
            String errMsg = ((Map) requsetJSON).get("err").toString();
            mapResult.put(Constants.RESERVE_RET_CODE, Constants.RET_CODE_ERROR);
            mapResult.put(Constants.RESERVE_RET_MSG,errMsg);
            return mapResult;
        }
        //保存预约信息
        reserveRegister.setSearchCode((String)resMap.get("order_id"));//HIS编号 识别号源的唯一标志
        reserveRegister.setSubmitDate(new Date());
        reserveRegister.setGender(IDCardUtil.getGenderByIdCard(reserveRegister.getIdcard()));
        reserveRegister.setBirthday(IDCardUtil.getBirthDateByIdCard(reserveRegister.getIdcard()));
        reserveRegister.setReserverStauts(ReserveStauts.SWDZ.getStauts());//预约标志
        reserveRegister.setRegisterScheduleTimeId("");
        Long id  =reserveRegisterDao.generatedKey(reserveRegister, "ID", null).longValue();
        //保存失败
        if(id == 0 ){
            mapResult.put(Constants.RESERVE_RET_CODE, Constants.RET_CODE_ERROR);
            mapResult.put(Constants.RESERVE_RET_MSG, "预约记录保存失败");
            return mapResult;
        }
        reserveRegister.setId(id);
        //返回成功
        mapResult.put(Constants.RESERVE_RET_CODE, Constants.RET_CODE_CORRECT);
        mapResult.put(Constants.RESERVE_RET_MSG, reserveRegister);
        return mapResult;
    }

    @Override
    public Map<String, Object> cancleReserve(ReserveRegister reserveRegister) {
        Map<String, Object> mapResult = new HashMap<String, Object>();
        //判断前台传值
        String validateResult = ValidateUtil.doValidate(reserveRegister,"searchCode");
        //判断必须项
        if(StringUtil.isNotEmpty(validateResult)){
            logger.error(validateResult);
            mapResult.put(Constants.RESERVE_RET_CODE, Constants.RET_CODE_ERROR);
            mapResult.put(Constants.RESERVE_RET_MSG,validateResult);
            return mapResult;
        }
        //请求参数
        Map<String,String> mapRequest = new HashMap<String,String>();
        /*测试*/
//        mapRequest.put("hospital_code","00000011");
//        mapRequest.put("user_id","1234");
        
        /*正式*/
        mapRequest.put("hospital_code","00000004");
        mapRequest.put("user_id","8811");
        mapRequest.put("order_id",reserveRegister.getSearchCode());
        JSONObject requsetJSON = JSONObject.fromObject(mapRequest);
        JSONObject respJSON = HttpClientUtil.sendPost(Constants.CANCEL_RESERVE_URL_CMH, requsetJSON.toString());
        //获取返回值
        JSONArray res = (JSONArray)(((Map) respJSON).get("data"));
        Map resMap = (Map)res.get(0);
        //取消失败情况
        if("0".equals(resMap.get("ret_code"))){
            //返回异常信息
            String errMsg = ((Map) requsetJSON).get("err").toString();
            mapResult.put(Constants.RESERVE_RET_CODE, Constants.RET_CODE_ERROR);
            mapResult.put(Constants.RESERVE_RET_MSG,errMsg);
            return mapResult;
        }
        mapResult.put(Constants.RESERVE_RET_CODE, Constants.RET_CODE_CORRECT);
        mapResult.put(Constants.RESERVE_RET_MSG,mapResult.get("ret_desc"));
        return mapResult;

    }

    @Override
    public Map<String, Object> selectSchdule(RegisterSchedule registerSchedule) {
        Map<String, Object> mapResult = new HashMap<String, Object>();
        //判断前台传值
        String validateResult = ValidateUtil.doValidate(registerSchedule,"id");
        //判断必须项
        if(StringUtil.isNotEmpty(validateResult)){
            logger.error(validateResult);
            mapResult.put(Constants.RESERVE_RET_CODE, Constants.RET_CODE_ERROR);
            mapResult.put(Constants.RESERVE_RET_MSG,"排班ID不能为空");
            return mapResult;
        }
        //get请求
        StringBuffer getScheduleUrl = new StringBuffer();
        getScheduleUrl.append(Constants.QUERY_RESERVE_URL_CMH +registerSchedule.getId());
        //调用接口获取预约列表
        String getSchedulers = HttpClientUtil.sendGet(getScheduleUrl.toString());
        JSONObject jResult = JSONObject.fromObject(getSchedulers);
        JSONArray jResult1 = (JSONArray) (((Map) jResult).get("result"));
        Map<String, Object> map = (Map<String, Object>) jResult1.get(0);
        int reserveNum = (int) map.get("reg_surplus_num");
        //停诊情况
        List<RegisterSchedule> registerScheduleLists = new ArrayList<RegisterSchedule>();
        String hospitalName = hospitalInfoDao.get(new Criteria("HOSPITAL_NO",Constants.CHINESE_MEDICINE_HOSPITAL).add("IS_DELETE","0")).getHospitalName();
        if(reserveNum == -2 ){//停诊
        	registerSchedule.setReserveStatus("3");
        }else if(reserveNum == 0 ){ //已满
            registerSchedule.setReserveStatus("2");
        }else{//正常情况返回
        	//余号放入相应bean
        	registerSchedule.setReserveStatus("1");
        	registerSchedule.setReserveNum(Long.valueOf(reserveNum));
        }
        //挂号时段的设置
        if("a".equals(registerSchedule.getAmpm())){
        	registerSchedule.setTimeIntervalStart("08:00");
        	registerSchedule.setTimeIntervalEnd("12:00");
        }
        else if("p".equals(registerSchedule.getAmpm())){
        	registerSchedule.setTimeIntervalStart("14:00");
        	registerSchedule.setTimeIntervalEnd("16:00");
        }
        registerSchedule.setHospitalName(hospitalName);
        registerScheduleLists.add(registerSchedule);
        mapResult.put(Constants.RESERVE_RET_CODE, Constants.RET_CODE_CORRECT);
        mapResult.put(Constants.RESERVE_RET_MSG, registerScheduleLists);
        return mapResult;
    }

    /***
     * @param result
     * @param root
     * @return String    返回类型
     * @Title: subJsons
     * @Description: 获取json外层的内部json数据
     */
    private static String subJsons(String result, String root) {
        JSONObject jsonObject = JSONObject.fromObject(result.toString());
        JSONArray data = jsonObject.getJSONArray(root);
        return data.toString();
    }

    /**
     * json数组转成List
     *
     * @param jsonArrayStr
     * @param clazz
     * @return
     */
    @SuppressWarnings({"unchecked"})
    private static List<?> json2List(String jsonArrayStr, String root, @SuppressWarnings("rawtypes") Class clazz) throws IllegalAccessException, InstantiationException {
        String result = subJsons(jsonArrayStr, root);
        @SuppressWarnings("rawtypes")
        List resultList = new ArrayList();
        if (StringUtil.isNullOrEmpty(result)) {
            return resultList;
        }
        JSONArray jsonObjects = JSONArray.fromObject(result);
        for (int i = 0; i < jsonObjects.size(); i++) {
            JSONObject jsonObj = (JSONObject) jsonObjects.get(i);
            Object obj = JSONObject.toBean(jsonObj, clazz);
            if (ObjectUtil.isNotEmpty(obj)) {
                resultList.add(obj);
            }
        }
        return resultList;
    }


    /**
     * 接口获取的数据转换成门户可用的bean
     *
     * @param map
     * @return
     */
    private RegisterSchedule paraseBean(Map<String, Object> map, Map<String, String> docMap, String deptName) {

        RegisterSchedule registerSchedule = new RegisterSchedule();
        registerSchedule.setId(Long.parseLong(map.get("reg_no").toString()));
        registerSchedule.setHospitalCode(Constants.CHINESE_MEDICINE_HOSPITAL);
        registerSchedule.setRequestDate(DateUtil.parseSimpleDate(map.get("clinic_date").toString(), "yyyy-MM-dd"));
        registerSchedule.setAmpm("上午".equals(map.get("time_interval").toString()) ? "a" : "p");
        registerSchedule.setDeptSn(map.get("dept_code").toString());
        registerSchedule.setDeptName(StringUtils.trimToEmpty(deptName));
        registerSchedule.setDoctorSn(map.get("doctor_id").toString());
        //获取医生的姓名
        registerSchedule.setDoctorName(docMap.get(registerSchedule.getDoctorSn()));
        registerSchedule.setClinicType("普通号".equals(map.get("reg_type").toString()) ? "01" : "02");
        registerSchedule.setRegisterFee(Double.valueOf(map.get("reg_cost").toString()));
        registerSchedule.setReserveStatus("-1".equals(map.get("reg_limit_num").toString()) ? "3" : "1");
        return registerSchedule;
    }

}
