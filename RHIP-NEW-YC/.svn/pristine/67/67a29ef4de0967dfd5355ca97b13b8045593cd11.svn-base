package com.founder.rhip.portal;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public interface IReserveWebService {
	
	/** 
	* @Title: updateResource 
	* @Description: 更新预约资源
	* @param @param requestXml
	* @param @return
	* @return String
	* @throws 
	*/
	@WebMethod
	public String updateResource(@WebParam(name = "requestXml") String  requestXml);
	
	/** 
	* @Title: updateResourceByTime 
	* @Description: 更新分时间段的预约资源
	* @param @param requestXml
	* @return String 返回的XML报文
	* @throws 返回异常信息
	*/
	@WebMethod
	public String updateResourceByTime(@WebParam(name = "requestXml") String  requestXml);
	
	
	/** 
	* @Title: queryReserve 
	* @Description: 查询患者预约信息接口
	* @param @param requestXml
	* @param @return
	* @return String
	* @throws 
	*/
	@WebMethod
	public String queryReserve(@WebParam(name = "requestXml") String  requestXml);
	
	/** 
	* @Title: queryReserve 
	* @Description: 查询患者预约信息List
	* @param @param requestXml
	* @param @return
	* @return String
	* @throws 
	*/
	@WebMethod
	public String searchReserve(@WebParam(name = "requestXml") String  requestXml);
	
	
	/** 
	* @Title: cancelReserve 
	* @Description: 取消预约 
	* @param @param requestXml
	* @param @return
	* @return String
	* @throws 
	*/
	@WebMethod
	public String cancelReserve(@WebParam(name = "requestXml") String  requestXml);
	
	/** 
	* @Title: updatePatientStatus 
	* @Description: 更新患者就诊状态接口
	* @param @param requestXml
	* @param @return
	* @return String
	* @throws 
	*/
	@WebMethod
	public String updatePatientStatus(@WebParam(name = "requestXml") String  requestXml);
	
	
	/** 
	* @Title: stopDiagnose 
	* @Description: 医生停诊
	* @param @param requestXml
	* @param @return
	* @return String
	* @throws 
	*/
	@WebMethod
	public String stopDiagnose(@WebParam(name = "requestXml") String  requestXml);
	
	/** 
	* @Title: queryReserve 
	* @Description: 恢复停诊
	* @param @param requestXml
	* @param @return
	* @return String
	* @throws 
	*/
	@WebMethod
	public String renewDiagnose(@WebParam(name = "requestXml") String  requestXml);
	
	/** 
	* @Title: getYYAllDepartmentInfo 
	* @Description: 根据挂号类型，选择科室
	* @param @param requestXml
	* @param @return
	* @return String
	* @throws 
	*/
	@WebMethod
	public String getYYAllDepartmentInfo(@WebParam(name = "requestXml") String  requestXml);


	/** 
	* @Title: getYYDoctorInfo 
	* @Description: 根据科室查询医生 
	* @param @param requestXml
	* @param @return
	* @return String
	* @throws 
	*/
	@WebMethod
	String getYYDoctorInfo(@WebParam(name = "requestXml") String requestXml);


	/** 
	* @Title: getYYDoctorByDepartment 
	* @Description: 根据科室查询医生信息
	* @param @param requestXml
	* @param @return
	* @return String
	* @throws 
	*/
	@WebMethod
	String getYYDoctorByDepartment(@WebParam(name = "requestXml") String requestXml);


	/** 
	* @Title: getYYDoctorByDoctor 
	* @Description: 根据医生查询排班信息
	* @param @param requestXml
	* @param @return
	* @return String
	* @throws 
	*/
	@WebMethod
	String getYYDoctorByDoctor(@WebParam(name = "requestXml") String requestXml);


	/** 
	* @Title: getYYClinicDateByDepartment 
	* @Description: 根据科室查询可预约时间
	* @param @param requestXml
	* @param @return
	* @return String
	* @throws 
	*/
	@WebMethod
	String getYYClinicDateByDepartment(@WebParam(name = "requestXml") String requestXml);


	/** 
	* @Title: getYYAllDepartmentInfo2 
	* @Description: 获取所有的科室
	* @param @param requestXml
	* @param @return
	* @return String
	* @throws 
	*/
	@WebMethod
	String getYYAllDepartmentInfo2(@WebParam(name = "requestXml") String requestXml);


	/** 
	* @Title: getYYDoctorInfo2 
	* @Description: 查询科室排班信息
	* @param @param requestXml
	* @param @return
	* @return String
	* @throws 
	*/
	@WebMethod
	String getYYDoctorInfo2(@WebParam(name = "requestXml") String requestXml);


	/** 
	* @Title: saveYYRegister 
	* @Description: 保存预约
	* @param @param requestXml
	* @param @return
	* @return String
	* @throws 
	*/
	@WebMethod
	String saveYYRegister(@WebParam(name = "requestXml") String requestXml);
	
	/** 
	* @Title: searchReserveByDate 
	* @Description: 根据医院code和预约日期时间段 查询预约信息接口 若预约日期为空则默认取前一天的预约就诊信息
	* @param @param requestXml
	* @param @return
	* @return String
	* @throws 
	*/
	@WebMethod
	public String searchReserveByDate(@WebParam(name = "requestXml") String  requestXml);
	
	/**
	 * 验证健康门户网站账户
	 * @param requestXml
	 * @return
	 */
	@WebMethod
	public String verifyUser(@WebParam(name = "requestXml") String  requestXml);
	
	/**
	 * 创建健康门户网站账户
	 * @param requestXml
	 * @return
	 */
	@WebMethod
	public String createUser(@WebParam(name = "requestXml") String  requestXml);
	
	/**
	 * 创建健康门户网站账户
	 * @param requestXml
	 * @return
	 */
	@WebMethod
	public String modifyPassword(@WebParam(name = "requestXml") String  requestXml);
	
	/**
	 * 查询常用联系人
	 * @param requestXml
	 * @return
	 */
	@WebMethod
	public String searchContacts(@WebParam(name = "requestXml") String  requestXml);
	
	/**
	 * 新增或修改常用联系人
	 * @param requestXml
	 * @return
	 */
	@WebMethod
	public String modifyContacts(@WebParam(name = "requestXml") String  requestXml);
	
	/**
	 * 新增或修改常用联系人
	 * @param requestXml
	 * @return
	 */
	@WebMethod
	public String deleteContacts(@WebParam(name = "requestXml") String  requestXml);
	
	/**
	 * 查询指定医院所有专家信息
	 * @param requestXml
	 * @return
	 */
	@WebMethod
	public String searchExpert(@WebParam(name = "requestXml") String  requestXml);

	/**
	 * 查询用户所有预约包括用户常用联系人的预约
	 * @param requestXml
	 * @return
	 */
	@WebMethod
	public String searchUserReserve(@WebParam(name = "requestXml") String  requestXml);
}
