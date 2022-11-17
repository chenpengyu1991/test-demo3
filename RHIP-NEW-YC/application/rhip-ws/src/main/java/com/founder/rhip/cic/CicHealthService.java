package com.founder.rhip.cic;

import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Order;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.entity.cic.CicRecord;
import com.founder.rhip.ehr.entity.cic.CicTarget;
import com.founder.rhip.ehr.entity.clinic.ReadHealthRecord;
import com.founder.rhip.ehr.repository.cic.ICicRecordDao;
import com.founder.rhip.ehr.repository.cic.ICicTargetDao;
import com.founder.rhip.ehr.repository.clinic.IReadHealthRecordDao;

/**
 * 基础健康数据查询Service
 * 
 * @version 1.0, 2014-5-9
 * @author Ye jianfei
 */
@Service("cicHealthService")
public class CicHealthService implements ICicHealthService {


	@Resource(name = "cicTargetDao")
	private ICicTargetDao cicTargetDao;

	@Resource(name = "cicRecordDao")
	private ICicRecordDao cicRecordDao;
	
	@Resource(name = "readHealthRecordDao")
	private IReadHealthRecordDao readHealthRecordDao;
	
	/**
	 * 健康数据是否变化，需要比较的字段
	 */
	private static final String[] property = new String[]{"asthmaFlag","heartDiseaseFlag","cardiovascularFlag"
		,"epilepsyFlag","mentalFlag","coagulopathyFlag"
		,"diabetesFlag","glaucomaFlag","heartPacemakerFlag"
		,"irritability","aboCode","rhCode","immunization"};
	/**
	 * 健康数据查询
	 * 1、首先查询CIC_RECORD表，如果WRITE_STATUS=1，且数据没有变化（和CIC_TARGET表中数据进行比较）
	 * 2、如果查询不到该市民的历史查询记录，则从CIC_TARGET表查询，返回健康数据
	 * 3、如果CIC_RECORD表中的“市民卡数据写入标识”为成功，数据有变化，则查询成功，返回健康数据。
	 * 4、如果CIC_RECORD表中的“市民卡数据写入标识”为失败，数据不论有没有变化，则查询成功，返回健康数据。
	 * 5、如果成功查询，则记录查询记录
	 */
	@Override
	@Transactional
	public CicTarget getCicTarget(CicHealthIn cicHealthIn) {
		String flag = CicConstants.HEALTH_FLAG_NONE;;//默认没有查到数据
		insertHealthRecord(cicHealthIn);//写健康档案调阅记录
		String idcard = cicHealthIn.getIdcard();
		CicTarget target = cicTargetDao.get(new Criteria("IDCARD",idcard));
		if(ObjectUtil.isNotEmpty(target)){
			target.setTranscode(cicHealthIn.getTranscode());
			List<CicRecord> records = cicRecordDao.getList(new Criteria("IDCARD",idcard),new Order("CREATE_DATE desc,id desc"));
			flag = CicConstants.HEALTH_FLAG_SUCCESS;//成功查询
			if(ObjectUtil.isNotEmpty(records)){
				CicRecord cicRecord = records.get(0);//历史数据
				if(CicConstants.WRITE_STATUS_SUCCESS.equals(cicRecord.getWriteStatus())){//上次市民卡写入成功
					Set<String> properties = new HashSet<>();
					properties.addAll(Arrays.asList(property));
					if(target.equals(cicRecord, properties)){//数据没有发生变化
						flag = CicConstants.HEALTH_FLAG_NOCHANGE;
					}
				}
			}
			if(CicConstants.HEALTH_FLAG_SUCCESS.equals(flag)){//写入历史记录
				insertRecord(target,cicHealthIn);
			}
			target.setFlag(flag);
		}
		return target;
	}
	
	@Override
	@Transactional
	public boolean saveWriteStatus(CicHealthIn cicHealthIn){
		boolean result = false;
		if(ObjectUtil.isNotEmpty(cicHealthIn)){
			String writeStatus = cicHealthIn.getWriteStatus();
			String idcard = cicHealthIn.getIdcard();
			List<CicRecord> records = cicRecordDao.getList(new Criteria("IDCARD",idcard),new Order("CREATE_DATE desc,id desc"));
			if(ObjectUtil.isNotEmpty(records)){
				CicRecord cicRecord = records.get(0);//历史数据
				cicRecord.setWriteStatus(writeStatus);
				cicRecordDao.update(cicRecord, new String[]{"writeStatus"});//更新市民卡写入状态
				result = true;
			}
		}
		return result;
	}
	/**
	 * 写入查询历史记录
	 *
	 * @param target
	 * @param cicHealthIn
	 * @author Ye jianfei
	 */
	private void insertRecord(CicTarget target,CicHealthIn cicHealthIn){
		if(ObjectUtil.isNotEmpty(target)){
			CicRecord cicRecord = new CicRecord();
            ConvertUtils.register(new DateConverter(null), java.util.Date.class);
            try{
                BeanUtils.copyProperties(cicRecord, target);
                cicRecord.setId(null);
            }catch(Exception e){
                throw new RuntimeException(e);
            }
            cicRecord.setCreateDate(new Date());
            cicRecord.setCreateOrganCode(cicHealthIn.getCreateOrganCode());
            cicRecord.setCreateOrganName(cicHealthIn.getCreateOrganName());
            cicRecord.setCreateUserId(cicHealthIn.getCreateUserId());
            cicRecord.setCreateUserName(cicHealthIn.getCreateUserName());
            cicRecord.setWriteStatus("0");//默认失败
            cicRecordDao.insert(cicRecord);
		}		
	}
	

	/**
	 * 写入调阅健康档案记录
	 *
	 * @param cicHealthIn
	 * @author Ye jianfei
	 */
	private void insertHealthRecord(CicHealthIn cicHealthIn){
		if(ObjectUtil.isNotEmpty(cicHealthIn)){
			ReadHealthRecord record = new ReadHealthRecord();
			record.setIsDelete(0);
			record.setPersonIdcard(cicHealthIn.getIdcard());
			record.setReadDate(new Date());
			record.setReaderName(cicHealthIn.getCreateUserName());
			record.setReaderOrgancode(cicHealthIn.getCreateOrganCode());
			readHealthRecordDao.insert(record);
		}		
	}
}
