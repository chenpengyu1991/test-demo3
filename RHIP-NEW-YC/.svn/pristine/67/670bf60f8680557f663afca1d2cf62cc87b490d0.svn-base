
package com.founder.rhip.ehr.service.basic;

import java.util.List;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.rhip.ehr.entity.basic.Bulletin;

/** 
* @ClassName: IBulletinService 
* @Description: 公告service 
* @author LJY
* @date 2013-8-1 下午4:02:44 
*  
*/
public interface IBulletinService {

	/** 
	* @Title: getBulletinPageList 
	* @Description: 根据分页查询列表
	* @param @param page
	* @param @param criteria
	* @param @return
	* @return PageList<Bulletin>
	* @throws 
	*/
	PageList<Bulletin> getBulletinPageList(Page page, Criteria criteria);

	/** 
	* @Title: saveBulletin 
	* @Description: 保存公告
	* @param @param bulletin
	* @param @return
	* @return Long
	* @throws 
	*/
	Long saveBulletin(Bulletin bulletin);

	/** 
	* @Title: updateBulletin 
	* @Description: 更新公告 
	* @param @param bulletin
	* @param @return
	* @return Integer
	* @throws 
	*/
	Integer updateBulletin(Bulletin bulletin);

	/** 
	* @Title: getBulletinList 
	* @Description: 查询公告
	* @param @param criteria
	* @param @return
	* @return List<Bulletin>
	* @throws 
	*/
	List<Bulletin> getBulletinList(Criteria criteria);

	/** 
	* @Title: getBulletin 
	* @Description: 查询公告
	* @param @param criteria
	* @param @return
	* @return Bulletin
	* @throws 
	*/
	Bulletin getBulletin(Criteria criteria);

	/** 
	* @Title: deleteBulletin 
	* @Description: 删除公告
	* @param @param bulletinId
	* @param @return
	* @return Integer
	* @throws 
	*/
	Integer deleteBulletin(Long bulletinId);
}