package com.founder.rhip.portal.service;

import java.util.Date;
import java.util.Map;

import com.founder.rhip.ehr.dto.RegisterScheduleDTO;
import com.founder.rhip.ehr.entity.portal.RegisterSchedule;
import com.founder.rhip.ehr.entity.portal.ReserveRegister;

public interface IHospitalReserveAdapter {


	/**
	 * @Title: queryDepartmentList
	 * @Description: 根据医院编号获取所有科室列表
	 * @param hospitalcode
	 * @return Map<String,Object>
	 */
	Map<String,Object> queryDepartmentList();

	/**
	 * @Title: queryDepartmentList
	 * @Description: 根据医院编号获取所有预约列表
	 * @param hospitalcode
	 * @return Map<String,Object>
	 */
	Map<String,Object> querySchduleList(String hospitalcode, Date requestDate, String ampm, 
			String clinicCode, String deptName, String doctorSn, String clinicType);

	/**
	 * @Title: saveReserve
	 * @Description: 根据前台预约数据提交保存预约请求
	 * @param reserveRegister
	 * @return Map<String,Object>
	 */
    Map<String,Object> saveReserve(ReserveRegister reserveRegister);

    /**
     * @Title: cancleReserve
     * @Description: 根据前台预约数据取消预约
     * @param reserveRegister
     * @return Map<String,Object>
     */
    Map<String,Object> cancleReserve(ReserveRegister reserveRegister);

    /***
     * 
    * @Title: selectSchdule 
    * @Description: 选择预约时展示
    * @param @param registerSchedule
    * @param @return  参数说明 
    * @return Map<String,Object>    返回类型 
    * @throws
     */
    Map<String,Object> selectSchdule(RegisterSchedule registerSchedule);

}
