/**   
* @Title: BulletinServiceImpl.java 
* @Package com.founder.rhip.ehr.service.basic 
* @Description: 公告类
* @author LJY
* @date 2013-8-1 下午4:09:31 
* @version V1.0   
*/
package com.founder.rhip.ehr.service.basic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Order;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.rhip.ehr.entity.basic.Bulletin;
import com.founder.rhip.ehr.repository.basic.IBulletinDao;

/** 
 * @ClassName: BulletinServiceImpl 
 * @Description: 公告类
 * @author LJY
 * @date 2013-8-1 下午4:09:31 
 *  
 */
@Service("bulletinService")
public class BulletinServiceImpl implements IBulletinService {

	@Autowired
	private IBulletinDao bulletinDao;
	
	@Override
	public PageList<Bulletin> getBulletinPageList(Page page ,Criteria criteria){
		Order order = new Order("SUBMIT_TIME",false);
		return bulletinDao.getPageList(page, criteria,order);
	}
	
	@Override
	public List<Bulletin> getBulletinList(Criteria criteria){
		return bulletinDao.getList(criteria);
	}
	
	@Override
	public Bulletin getBulletin(Criteria criteria){
		return bulletinDao.get(criteria);
	}
	
	@Override
	public Long saveBulletin(Bulletin bulletin){
		return bulletinDao.generatedKey(bulletin, "ID",null).longValue();
	}
	
	@Override
	public Integer updateBulletin(Bulletin bulletin){
		return bulletinDao.update(bulletin,"title","content","isDelete");
	}
	
	@Override
	public Integer deleteBulletin(Long bulletinId){
		return bulletinDao.delete(bulletinId);
	}
}
