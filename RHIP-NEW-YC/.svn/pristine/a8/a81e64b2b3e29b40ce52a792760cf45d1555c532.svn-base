package com.founder.rhip.mdm.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Criterion;
import com.founder.fasf.beans.Record;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.mdm.common.CommonUtil;
import com.founder.rhip.mdm.entity.EntityType;
import com.founder.rhip.mdm.entity.Staff;
import com.founder.rhip.mdm.service.IStaffService;

@Service("staffApp")
public class StaffAppImpl extends MDMBaseApp implements IStaffApp {

	@Resource(name = "mdmStaffService")
	private IStaffService mdmStaffService;
	
	@Resource(name = "dictionaryApp")
	private IDictionaryApp dictionaryApp;

	@Resource(name = "organizationApp")
	private IOrganizationApp organizationApp;

	@Override
	public Staff registStaff(Staff staff) throws CheckException, Exception {
		preProcess(staff);
		// validation
		/*List<String> messageList = new ArrayList<String>();
		Record record = new Record(staff);
		//TODO 银川不校验身份证号
		checkAll(messageList, record, EntityType.STAFF);
		if (ObjectUtil.isNotEmpty(messageList)) {
			throw getCheckException(messageList);
		}*/
		// find old staff
		 Staff oldStaff = new Staff();
        if(staff.getId() != null){
            oldStaff = mdmStaffService.getStaff(staff.getStaffCode());
        }else {
            oldStaff = mdmStaffService.findOldStaff(staff.getOrganCode(), staff.getLocalId());
        }
		// already have this staff, update
		if (oldStaff != null || staff.getId() != null) {
			if (staff.getStaffCode() == null) {
				staff.setStaffCode(oldStaff.getStaffCode());
			}
            staff.setId(oldStaff.getId());
			staff.setSmpiId(oldStaff.getSmpiId());
			return mdmStaffService.updateStaff(staff);
		}
		// insert with SMPI_ID
		/*if (StringUtil.isNotEmpty(staff.getSmpiId())) {
			Staff staffMain = mdmStaffService.createStaffWithSid(staff);
			if (staffMain == null) {
				throw new Exception("不存在该SMPI_ID的人员");
			} else {
				return staffMain;
			}
		}*/
		// pure insert
		Staff staffMain = mdmStaffService.createStaff(staff);
		if (staffMain == null) {
			throw new Exception("创建人员失败");
		}
		return staffMain;
	}

	@Override
	public List<Staff> queryStaff(Criteria criteria) throws CheckException, Exception {
		if (criteria == null) {
			throw new Exception("请提供查询条件");
		}
		// validation
		List<Criterion> ctrs = criteria.getCriteria();
		if (ctrs.size() < 1) {
			throw new Exception("请提供查询条件");
		}
		Record record = new Record();
		List<String> messageList = new ArrayList<String>();
		for (Criterion ctr : ctrs) {
			record.put(ctr.getName(), ctr.getValue());
		}
		//checkCriteria(messageList, criteria, EntityType.STAFF);
		dictionaryCheck(messageList, record, EntityType.STAFF);
		regexCheck(messageList, record, EntityType.STAFF);
		maxLengthCheck(messageList, record, EntityType.STAFF);
		if (ObjectUtil.isNotEmpty(messageList)) {
			throw getCheckException(messageList);
		}
		//query
		List<Staff> staffs = mdmStaffService.getStaffs(criteria);
		return staffs;
	}
	
	public Map<String, String> getDictionary(String dictKey) {
		Map<String, String> dictMap = null;
		if (dictKey.equals("ORGAN_CODE")) {
			dictMap = organizationApp.queryAllOrganizationMap();
		} else {
			dictMap = dictionaryApp.queryDicItemMap(dictKey);
		}
		return dictMap;
	}

	private void preProcess(Staff staff) {
		staff.setUpdateTime(getOperatorTime());
		if (ObjectUtil.isNullOrEmpty(staff.getCpy())) {
			staff.setCpy(CommonUtil.getPinYin(staff.getName()));
		}
	}
}
