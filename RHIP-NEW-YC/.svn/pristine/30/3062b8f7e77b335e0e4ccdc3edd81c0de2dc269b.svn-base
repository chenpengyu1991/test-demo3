package com.founder.rhip.ehr.repository.management.mhm;

import java.util.List;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.repository.IDao;
import com.founder.rhip.ehr.dto.mhm.MhmMoveQueryDto;
import com.founder.rhip.ehr.entity.management.mhm.MhmStatusInfo;
import com.founder.rhip.ehr.dto.mhm.MhmClueQueryDto;
import com.founder.rhip.ehr.dto.mhm.MhmManagementQueryDto;

/**
 * DAO interface of MhmStatusInfo
 * 
 */
public interface IMhmStatusInfoDao extends IDao<MhmStatusInfo,Long> {
	/**
	 * 更新状态表
	 * @param statusInfo
	 * @param cr
	 */	    
	public int updateStatus(MhmStatusInfo statusInfo,Criteria cr);
	/**
	 * 分页查询--规范管理
	 * @param page
	 * @param criteria
	 */		
	public PageList<MhmManagementQueryDto> findManagementList(Page page, Criteria criteria);
	
	/**
	 * 查询--规范管理
	 * @param criteria
	 */		
	public List<MhmManagementQueryDto> findManagementList(Criteria criteria);
	
	/**
	 * 分页查询--线索登记
	 * @param page
	 * @param criteria
	 */		
	public PageList<MhmClueQueryDto> findClueList(Page page, Criteria criteria);
	
	/**
	 * 查询--线索登记
	 * @param criteria
	 */		
	public List<MhmClueQueryDto> findClueList(Criteria criteria);

    /**
     * 分页查询--迁入迁出
     * @param page
     * @param criteria
     * @return
     */
    public PageList<MhmMoveQueryDto> findMoveList(Page page, Criteria criteria);
	/**
     * @Title: getPersonIdCount
     * @Description: 查询
     * @param @param criteria
     * @param @return
     * @return Long
     * @throws
     */
    Long getPersonIdCount(Criteria criteria);

    /**
     * @Title: 为cic提供精神病信息
     * @Description: 查询
     * @param @return
     * @return Long
     * @throws
     */
    List<MhmMoveQueryDto> getMhmInfoForCic();

}