package com.founder.rhip.portal.service;

import java.util.List;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.rhip.ehr.entity.portal.ReserveRegister;
import com.founder.rhip.ehr.entity.portal.StopDoctor;


/**
 * Created with IntelliJ IDEA.
 * User: zheng_dandan
 * Date: 13-6-19
 * Time: 上午11:00
 * To change this template use File | Settings | File Templates.
 */
public interface IStopDoctorService {
    /**
     * 查询
     * @param page
     * @param criteria
     * @return
     */
    PageList<StopDoctor> getList(Page page, Criteria criteria);

    /**
     * 查询停诊医生未到诊预约记录
     * @param criteria
     * @param page
     * @return
     */
    PageList<ReserveRegister> getUnReserveRegister(StopDoctor stopDoctor, Page page);

    /***
     * 根绝查询结果处理停诊
     * @param criteria
     * @param type
     */
    String  processUnResReg(StopDoctor stopDoctor,String type);

	/**
	 * 查询停诊的医生
	 * @param criteria
	 * @return
	 */
	StopDoctor getStopDoctor(Criteria criteria);
    /**
     * 取消停诊
     * @param cancelId
     * @return
     */
    String cancelStop(Long cancelId);

    /**
     * 处理过期预约记录
     * @return
     */
    void  processOverdue();
    
    
    /**
     * 获取医生的停诊记录
     * @param criteria
     * @return
     */
	List<StopDoctor> getStopDoctorDetails(Criteria criteria);

	/** 
	* @Title: getStopList 
	* @Description: 根据停诊数据，查询停诊医生
	* @param @param stopDoctor
	* @param @return
	* @return List<StopDoctor>
	* @throws 
	*/
	List<StopDoctor> getStopList(StopDoctor stopDoctor);
}
