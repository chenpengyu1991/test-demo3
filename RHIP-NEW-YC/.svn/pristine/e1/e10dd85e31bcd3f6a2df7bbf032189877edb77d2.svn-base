package com.founder.rhip.cpw;

import java.util.Date;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.entity.clinic.ClinicalPathway;
import com.founder.rhip.ehr.repository.clinic.IClinicalPathwayDao;

/**
 * 临床数据管理
 * 
 * @version 1.0, 2014-7-3
 * @author Ye jianfei
 */
@Service("clinicalPathwayService")
public class CpwService implements ICpwService {

	@Resource(name = "clinicalPathwayDao")
	private IClinicalPathwayDao clinicalPathwayDao;
	
	@Override
	@Transactional
	public void uploadCpwData(ClinicalPathway clinicalPathway) {
		if(ObjectUtil.isNotEmpty(clinicalPathway)){
			updateCpw(clinicalPathway);
		}
	}
	

    /**
     * 设置机构、人员相关信息
     *
     * @param clinicalPathway
     * @author Ye jianfei
     */
    private void setBasicInfo(ClinicalPathway clinicalPathway){
    	if(ObjectUtil.isNullOrEmpty(clinicalPathway.getId())){
    		clinicalPathway.setCreateOrg("");
    		clinicalPathway.setCreateUser("");
    		clinicalPathway.setCreateDate(new Date());
    	}
    	clinicalPathway.setUpdateOrg("");
    	clinicalPathway.setUpdateUser("");
    	clinicalPathway.setUpdateDate(new Date());
    }
    
     
    /**
     * 新增或更新临床数据
     *
     * @param clinicalPathway
     * @param properties
     * @author Ye jianfei
     */
    private void updateCpw(ClinicalPathway clinicalPathway,String...properties){
    	if(ObjectUtil.isNotEmpty(clinicalPathway)){
    		setBasicInfo(clinicalPathway);
    		if(ObjectUtil.isNotEmpty(clinicalPathway.getId())){
    			clinicalPathwayDao.update(clinicalPathway, properties);
    		}else{
    			clinicalPathwayDao.insert(clinicalPathway);
    		}
    	}
    }
  
}
