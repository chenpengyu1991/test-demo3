package com.founder.rhip.ph.service.vaccine;

import java.util.Date;
import java.util.HashMap;

import com.founder.rhip.ehr.entity.basic.User;
import com.founder.rhip.ehr.entity.control.VaccinationInfo;
import com.founder.rhip.ehr.entity.control.VaccinationMgmt;
import com.founder.rhip.mdm.entity.Organization;
import com.founder.rhip.ph.dto.vaccine.VaccinationDetailsDTO;

/**
 * 
 * @author xu_bin 服务于接种记录 提供接种记录集 / 单个接种记录详细信息 增加 / 修改 / 删除等常用功能
 */
public interface IVaccinationSaveService {

	public static final String VACCINE_RABIES = "1";
	public static final String VACCINE_HEPATITIS = "2";
	public static final String VACCINE_INFLUENZA = "3";
	public static final String VACCINE_PNEUMONIA = "4";
	public static final String VACCINE_GRAY = "5";
	//默认第一个生产厂家名称
	public static final String FISRT_NAME="辽宁成大生物股份有限公司";
	//狂犬病人 免疫球蛋白 默认第一个生产厂家名称
	public static final String M_FISRT_NAME="广东双林生物制药有限公司";
	VaccinationMgmt getDetailsByIdCard(String idCard);
	
	void contineSave(VaccinationInfo vaccineRecord,Organization currentOrg,User currentUser,String comment);

	/** 
	* @Title: saveVaccine 
	* @Description: 保存疫苗
	* @param @param cDCVaccinationDetailsDTO
	* @param @param updateOrg
	* @param @param updateName
	* @return void
	* @throws 
	*/
	void saveVaccine(VaccinationDetailsDTO cDCVaccinationDetailsDTO,String comment);

	/** 
	* @Title: updateVaccine 
	* @Description: 修改疫苗注射
	* @param @param vaccinationDetailsDTO
	* @param @param ehrId
	* @return void
	* @throws 
	*/
	void updateVaccine(VaccinationDetailsDTO vaccinationDetailsDTO, String ehrId,String comment);
	
	/** 
	* @Title: saveVaccine 
	* @Description: 保存疫苗
	* @param @param cDCVaccinationDetailsDTO
	* @param @param updateOrg
	* @param @param updateName
	* @return void
	* @throws 
	*/
	void save(VaccinationDetailsDTO vaccinationDetailsDTO, String comment,String ehrId); 

	/** 
	* @Title: deleteVaccine 
	* @Description: 删除疫苗注射
	* @param @param ehrId
	* @param @param VaccineType
	* @return void
	* @throws 
	*/
	void deleteVaccine(String ehrId, String VaccineType);

	/**
	 * 删除疫苗注射
	 *
	 * @param id
	 * @author Ye jianfei
	 */
	void deleteVaccine(Long id);

	/**
	 * 更新打印类型
	 *
	 * @param ehrId
	 * @param printFlag
	 * @author Ye jianfei
	 */
	public void updatePrintFlag(String ehrId,Integer printFlag);
	
	/**
	 * 获取患者最近一次注射情况，包括是否正规注射
	 *
	 * @param personId
	 * @param hitDate
	 * @return
	 * @author Ye jianfei
	 */
	public HashMap<String,Object> getRabiesVaccine(Long personId,String hitDate);
}
