package com.founder.rhip.mdm.service;

import com.founder.fasf.beans.*;
import com.founder.fasf.repository.dialect.Oracle9Dialect;
import com.founder.fasf.util.ArrayUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.ehr.entity.basic.User;
import com.founder.rhip.ehr.repository.basic.HistoryRecorder;
import com.founder.rhip.ehr.repository.basic.IUserDao;
import com.founder.rhip.ehr.repository.basic.IUserRoleDao;
import com.founder.rhip.mdm.common.CheckUtil;
import com.founder.rhip.mdm.common.OperateType;
import com.founder.rhip.mdm.entity.*;
import com.founder.rhip.mdm.repository.IStaffDao;
import com.founder.rhip.mdm.repository.IStaffHonorDao;
import com.founder.rhip.mdm.repository.IStaffMainDao;
import com.founder.rhip.mdm.repository.IStaffOrgDao;
import net.sf.cglib.beans.BeanMap;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.*;
import java.util.Map.Entry;

@Service("mdmStaffService")
public class StaffServiceImpl extends MDMService implements IStaffService, IMergerOrganizationListener {

	@Resource(name = "mdmStaffMainDao")
	private IStaffMainDao staffMainDao;

    @Resource(name = "mdmStaffHonorDao")
    private IStaffHonorDao staffHonorDao;

	@Resource(name = "mdmStaffDao")
	private IStaffDao staffDao;

	@Resource(name = "mdmConfigService")
	private IMDMConfigService mdmConfigService;

	@Resource(name = "mdmStaffOrgDao")
	private IStaffOrgDao staffOrgDao;

	@Resource(name = "ehrUserRoleDao")
	private IUserRoleDao userRoleDao;

	@Resource(name = "ehrUserDao")
	private IUserDao userDao;

	private String[] MAIN_PROPERTIES;

	private String[] STAFF_PROPERTIES;

	private static final String SMPI_ID = "smpiId";
	private static final String STAFF_CODE = "staffCode";
	private static final String ORGAN_CODE = "organCode";
	//private static final String DEPT_CODE = "deptCode";
	private static final String LOCAL_ID = "localId";
	private static final String ID_CARD = "idCard";

	@Transactional
	@Override
	public Staff createStaff(Staff staff) {
		staff.setStatus(1);
		// check STAFF_MAIN
		String idCard = staff.getIdCard();
		Criteria ctr = new Criteria();
		ctr.add(ID_CARD, idCard);
		Staff staffMain = staffMainDao.get(ctr, getMainProp());
		if (staffMain != null) {
			// update staff main
			updateStaffMainInfo(staffMain, staff, null);
			staff.setSmpiId(staffMain.getSmpiId());
		} else {
			// insert staff main
			staffMain = staff;
			String smpiId = String.format("%010d", staffMainDao.getSequenceNextVal("SEQ_MDM_STAFF_MAIN", Long.class));
			staffMain.setSmpiId(smpiId);
			staffMainDao.insert(staffMain, getMainProp());
			staff.setSmpiId(smpiId);
		}
		// insert into STAFF
		String staffCode = Oracle9Dialect.getDialect().getSequenceNextValString("SEQ_MDM_STAFF");
		staff.setStaffCode(staffCode);
		String[] insertProp = ArrayUtil.add(getStaffProp(), "status");
		staffDao.insertWithSeq(staff, "SEQ_MDM_STAFF", insertProp);

        Staff staffTemp = staffDao.get(new Criteria("SMPI_ID", staffMain.getSmpiId()));
        staff.setStaffCode(staffTemp.getStaffCode());
		//个人荣誉
        if (staff.getStaffHonors() != null) {
//        	Staff staffTemp = staffDao.get(new Criteria("SMPI_ID", staffMain.getSmpiId()));
	        for(StaffHonor staffHonor : staff.getStaffHonors()){
	            staffHonor.setSmpiId(staff.getSmpiId());
	            staffHonor.setStaffCode(staffTemp.getStaffCode());
	            staffHonor.setIdCard(staff.getIdCard());
	            staffHonor.setCreateUserName(staff.getUpdatePerson());
	            staffHonor.setCreateDate(new Date());
	        }
	        staffHonorDao.batchInsert(staff.getStaffHonors());
        }
		//医务人员所属机构
		if(ObjectUtil.isNotEmpty(staff.getStaffOrgs())) {
			for(StaffOrg staffOrg : staff.getStaffOrgs()){
				staffOrg.setSmpiId(staffTemp.getSmpiId());
				staffOrg.setStaffCode(staffTemp.getStaffCode());
			}
			staffHonorDao.delete(new Criteria("STAFF_CODE", staffTemp.getStaffCode()));
			staffOrgDao.batchInsert(staff.getStaffOrgs());
		}
		return staff;
	}

	@Transactional
	@Override
	public Staff createStaffWithSid(Staff staff) {
		// find main record
		String smpiId = staff.getSmpiId();
		Criteria ctr = new Criteria();
		ctr.add(SMPI_ID, smpiId);
		Staff staffMain = staffMainDao.get(ctr, getMainProp());
		if (staffMain != null) {
			int rt = staffDao.insertWithSeq(staff, "SEQ_MDM_STAFF", getStaffProp());
			if (rt == 1) {
				updateStaffMainInfo(staffMain, staff, null);
				return staffMain;
			}
		}
		return null;
	}
	
	@Transactional
	@Override
	public void createStaffs(List<Map<String, Object>> staffs) {
		List<Staff> newStaffMainList = new ArrayList<Staff>();
		List<Map<String, Object>> updatedStaffMainList = new ArrayList<Map<String, Object>>();
		List<Map<String, Object>> updatedStaffList = new ArrayList<Map<String, Object>>();
		List<Map<String, Object>> removeList = new ArrayList<Map<String, Object>>();
		for (Map<String, Object> staff : staffs) {
			Criteria criteria = new Criteria();
			criteria.add(ORGAN_CODE, staff.get(ORGAN_CODE));
			criteria.add(LOCAL_ID, staff.get(LOCAL_ID));
			Staff oldStaff = staffDao.get(criteria, getStaffProp());
			if (oldStaff != null) {
				Staff staffMain = staffMainDao.get(new Criteria(SMPI_ID, oldStaff.getSmpiId()), getMainProp());
				Record staffRecord = new Record(new Staff());
				staffRecord.putAll(staff);
				Map<String, Object> changedValue = getChangedValue(
						new Record(staffMain), staffRecord, getMainProp());
				if (ObjectUtil.isNotEmpty(changedValue)) {
					changedValue.put(SMPI_ID, staffMain.getSmpiId());
					updatedStaffMainList.add(changedValue);
				}
				Map<String, Object> changedStaffValue = getChangedValue(
						new Record(oldStaff), staffRecord, getMainProp());
				if (ObjectUtil.isNotEmpty(changedStaffValue)) {
					changedStaffValue.put(STAFF_CODE, oldStaff.getStaffCode());
					updatedStaffList.add(changedStaffValue);
				}
				removeList.add(staff);
			} else {
				// check staff main
				String idCard = (String) staff.get(ID_CARD);
				Criteria ctr = new Criteria();
				ctr.add("idCard", idCard);
				Staff staffMain = staffMainDao.get(ctr, getMainProp());
				String smpiId = null;
				if (staffMain != null) { // there is a main record
					Record staffRecord = new Record(new Staff());
					staffRecord.putAll(staff);
					Map<String, Object> changedValue = getChangedValue(
							new Record(staffMain), staffRecord, getMainProp());
					if (ObjectUtil.isNotEmpty(changedValue)) {
						changedValue.put(SMPI_ID, staffMain.getSmpiId());
						updatedStaffMainList.add(changedValue);
					}
					staff.put(SMPI_ID, staffMain.getSmpiId());
				} else { // no main record
					staffMain = new Staff();
					Record record = new Record(staffMain);
					record.putAll(staff);
					smpiId = String.format("%010d", staffMainDao.getSequenceNextVal("SEQ_MDM_STAFF_MAIN", Long.class));
					staffMain.setSmpiId(smpiId);
					newStaffMainList.add(staffMain);
					staff.put(SMPI_ID, smpiId);
				}
				staff.put(STAFF_CODE, staffDao.getSequenceNextVal("SEQ_MDM_STAFF", Long.class));
			}
		}
		if (ObjectUtil.isNotEmpty(removeList)) {
			for (Map<String, Object> p : removeList) {
				staffs.remove(p);
			}
		}
		staffDao.batchMapInsert(staffs);
		if (ObjectUtil.isNotEmpty(newStaffMainList)) {
			staffMainDao.batchInsert(newStaffMainList, getMainProp());
		}
		if (ObjectUtil.isNotEmpty(updatedStaffMainList)) {
			for (Map<String, Object> changedValue : updatedStaffMainList) {
				staffMainDao.update(changedValue, changedValue.keySet().toArray(new String[] { "" }));
				staffDao.update(changedValue, changedValue.keySet().toArray(new String[] { "" }));
			}
		}
		if (ObjectUtil.isNotEmpty(updatedStaffList)) {
			for (Map<String, Object> changedValue : updatedStaffList) {
				staffDao.update(changedValue, changedValue.keySet().toArray(new String[] { "" }));
			}
		}
	}

	@Override
	@Transactional(value = "transma", rollbackFor = Exception.class)
	public Staff updateStaff(Staff staff) {
		Staff oldStaff = staffDao.get(new Criteria("STAFF_CODE", staff.getStaffCode()));
		// insert oldStaff into STAFF_LOG
		staffDao.insertStaffLog(getStaffProp(), staff.getStaffCode());
		// update staff
		staffDao.update(staff, getStaffProp());
		// update main record
		Staff staffMain = staffMainDao.get(new Criteria(SMPI_ID, staff.getSmpiId()), getMainProp());
		updateStaffMainInfo(staffMain, staff, oldStaff);
		if (staff.getStaffHonors() != null) {
	        staffHonorDao.delete(new Criteria("SMPI_ID",staff.getSmpiId()));
	        staffHonorDao.batchInsert(staff.getStaffHonors());
		}
		if(ObjectUtil.isNotEmpty(staff.getStaffOrgs())) {
			staffOrgDao.delete(new Criteria("STAFF_CODE", staff.getStaffCode()));
			staffOrgDao.batchInsert(staff.getStaffOrgs());
			//编辑时若删除兼职机构 那么需要把相应MDM_USER_ROLE的数据也删除
			List<String> userOrgCodes = new ArrayList<String>();
			for(StaffOrg staffOrg : staff.getStaffOrgs()) {
				userOrgCodes.add(staffOrg.getOrganCode());
			}
			Criteria criteria = new Criteria("organ_code", OP.NOTIN, userOrgCodes);
			User user = userDao.get(new Criteria("staff_code", staff.getStaffCode()));
			if(ObjectUtil.isNotEmpty(user)) {
				criteria.add("user_code", user.getUserCode());
				userRoleDao.delete(criteria);
			}
		}
		return staffMain;
	}

	@Transactional
	@Override
	public Staff updateStaff(List<Map<String, Object>> changedValues) {
		Map<String, Object> cv1 = changedValues.get(0);
		Map<String, Object> cv2 = changedValues.get(1);
		//Long id = (Long) cv1.get("id");
		String staffCode = (String) cv1.get(STAFF_CODE);
		String smpiId = (String) cv1.get(SMPI_ID);
		// insert oldStaff into STAFF_LOG
		staffDao.insertStaffLog(getStaffProp(), staffCode);
		// update staff
		staffDao.update(cv1, cv1.keySet().toArray(new String[] { "" }));
		// update main record
		staffMainDao.update(cv2, cv2.keySet().toArray(new String[] { "" }));
		return staffMainDao.get(new Criteria(SMPI_ID, smpiId), getMainProp());
	}

	@Override
	public int deleteStaff(Criteria criteria) {
		Staff staff = staffDao.get(criteria);
		int rt = 0;
		if (staff == null) {
			return 0;
		} else {
			String smpiId = staff.getSmpiId();
			rt = staffDao.delete(criteria);
			Set<String> checkList = new HashSet<String>();
			checkList.add(smpiId);
			staffMainDao.removeUnusedSmpiId(checkList);
		}
		return rt;
	}

	@Override
	public List<Staff> queryStaff(Criteria criteria) {
		List<Staff> staffs = staffMainDao.getList(criteria, getMainProp());
		if (ObjectUtil.isNullOrEmpty(staffs)) {
			staffs = staffMainDao.queryStaffMain(criteria, getMainProp());
		}
		return staffs;
	}

	@Override
	public PageList<Staff> queryStaff(Page page, Criteria criteria, String... properties) {
		return staffDao.getPageList(page, criteria, properties);
	}

	@Override
	public Staff getStaffMain(String smpiId) {
		return staffMainDao.get(new Criteria(SMPI_ID, smpiId), getMainProp());
	}

	@Override
	public Staff getStaff(String staffCode) {
		if(ObjectUtil.isNullOrEmpty(staffCode)) {
			return null;
		}
		List<StaffHonor> staffHonors = staffHonorDao.getList(new Criteria("STAFF_CODE", staffCode));

		Criteria staffOrgCri = new Criteria("STAFF_CODE", staffCode);
		staffOrgCri.add("is_main", "1");
		List<StaffOrg> staffOrgs = staffOrgDao.getList(staffOrgCri, new Order("organ_code"));
		Staff staff = staffDao.getStaff(new Criteria("s.staff_code", staffCode));

		if(ObjectUtil.isNotEmpty(staff)){
			staff.setStaffHonors(staffHonors);
			staff.setStaffOrgs(staffOrgs);
		}
		return staff;
	}

	/**
	 * 查询医务人员 关联表staff_org
	 * @param page
	 * @param criteria
	 * @return
	 */
	public PageList<Staff> getStaffPageList(Page page, Criteria criteria) {
		PageList<Staff> staffPageList = staffDao.getStaffPageList(page, criteria);
		List<Staff> staffList = staffPageList.getList();
		for(Staff staff : staffList) {
			Criteria staffOrgCri = new Criteria("STAFF_CODE", staff.getStaffCode());
			staff.setStaffOrgs(staffOrgDao.getList(staffOrgCri, new Order("organ_code")));
		}
		return staffPageList;
	}

	/**
	 * 获取医务人员和机构的关系表
	 * @param criteria
	 * @return
	 */
	public List<StaffOrg> getStaffOrgList(Criteria criteria) {
		return staffOrgDao.getList(criteria);
	}

	@Override
	public List<Staff> getStaffs(Criteria criteria) {
		return staffDao.getList(criteria, getStaffProp());
	}

	@Override
	public List<Staff> getLinkStaffs(String smpiId) {
		return staffDao.getList(new Criteria(SMPI_ID, smpiId), getStaffProp());
	}

	@Override
	public PageList<Staff> getStaffLogs(Page page, String staffCode) {
		return staffDao.getStaffLogs(page, staffCode, getStaffProp());
	}

	public PageList<Staff> getPageStaffs(Page page, Criteria criteria){
		return staffDao.getPageList(page, criteria,"SMPI_ID","ID_CARD","NAME","GENDER","MOBILE","STAFF_CODE");
	}
	
	@Override
	public Staff getStaffLog(String staffCode, Long updateTime) {
		Staff staff = staffDao.getStaffLog(staffCode, updateTime, getStaffProp());
		if (staff == null) {
			staff = getStaff(staffCode);
		}
		return staff;
	}

	@Transactional
	@Override
	public int mergeStaff(List<Staff> staffList, String smpiId) {
		Staff staffMain = staffMainDao.get(new Criteria(SMPI_ID, smpiId), getMainProp());
		Set<String> changedStaffMain = new HashSet<String>();
		List<String> staffCodes = new ArrayList<String>();
		List<Map<String, Object>> updateMapList = new ArrayList<Map<String, Object>>();
		List<Map<String, Object>> changedValues = new ArrayList<Map<String, Object>>();
		// store original SMPI_ID, STAFF_CODE
		for (Staff staff : staffList) {
			changedStaffMain.add(staff.getSmpiId());
            staff.setSmpiId(smpiId);
			String staffCode = staff.getStaffCode();
			staffCodes.add(staffCode);
			Map<String, Object> updateMap = new HashMap<String, Object>();
			updateMap.put(SMPI_ID, smpiId);
			updateMap.put(STAFF_CODE, staffCode);
			updateMapList.add(updateMap);
			Map<String, Object> change = getChangedValue(new Record(staffMain), new Record(staff), getMainProp());
			if (ObjectUtil.isNotEmpty(change)) {
				change.put(SMPI_ID, smpiId);
				changedValues.add(change);
			}
		}
		// batch insert into STAFF_LOG
		staffDao.insertStaffLog(getStaffProp(), (String[])staffCodes.toArray(new String[0]));
		// update SMPI_ID in STAFF
		staffDao.batchMapUpdate(updateMapList, SMPI_ID);
		// clean SMPI_ID
		staffMainDao.removeUnusedSmpiId(changedStaffMain);
		//update main record info
		if (ObjectUtil.isNotEmpty(changedValues)) {
			for (Map<String, Object> changedValue : changedValues) {
				staffMainDao.update(changedValue, changedValue.keySet().toArray(new String[] { "" }));
			}
		}
		return staffList.size();
	}

	@Transactional
	@Override
	public int splitStaff(String operator, String... staffCode) {
        Long updateTime = CheckUtil.getOperatorTime();
        if (staffCode == null || staffCode.length == 0) {
            return 0;
        }
        // insert staff log
        staffDao.insertStaffLog(getStaffProp(), staffCode);
        // change smpi_id
        String smpiId = generateSmpiId();
        String oldSmpiId = null;
        List<Map<String, Object>> updateMapList = new ArrayList<>();
        Record staffMain = new Record(new Staff());
        Criteria criteria = new Criteria(STAFF_CODE, OP.IN, staffCode);
        List<Staff> splitStaffs = staffDao.getList(criteria, getStaffProp());
        for (Staff staff : splitStaffs) {
            Map<String, Object> map = new HashMap<>();
            map.put(SMPI_ID, smpiId);
            map.put(STAFF_CODE, staff.getStaffCode());
            map.put("updateTime", updateTime);
            map.put("operateType", OperateType.split.getName());
            map.put("updatePerson", operator);
            updateMapList.add(map);
            if (oldSmpiId == null) {
                oldSmpiId = staff.getSmpiId();
            }
            Map<String, Object> changedValue = getChangedValue(staffMain, new Record(staff), getMainProp());
            staffMain.putAll(changedValue);
        }
        staffMain.put(SMPI_ID, smpiId);

        //do database update
        String[] updateProp = {SMPI_ID, "updateTime", "operateType", "updatePerson"};
        staffDao.batchMapUpdate(updateMapList, updateProp);
        staffMainDao.insert(staffMain.getMap(), getMainProp());
        // update old best record
        updateAfterSplit(oldSmpiId);
        return updateMapList.size();
	}


	@Override
	public Staff findOldStaff(String organCode, String localId) {
		if (StringUtil.isNotEmpty(organCode) && StringUtil.isNotEmpty(localId)) {
			Criteria criteria = new Criteria();
			criteria.add(ORGAN_CODE, organCode);
			criteria.add(LOCAL_ID, localId);
			Staff staff = staffDao.get(criteria, getStaffProp());
			return staff;
		}
		return null;
	}

	@Override
	public Object compareOldStaff(Staff oldStaff, Staff staff) {
		/*SBR下有两个person，P1和P2，SBR为P1的记录
		操作步骤：
		1.更新P2的某个字段，如更新电话号码
		预期结果：
		SBR只更新电话号码*/
		Map<String, Object> mainChanged = getChangedValue(new Record(oldStaff), new Record(staff), getMainProp());
		if (mainChanged.size() > 0) {
			mainChanged.put(SMPI_ID, oldStaff.getSmpiId());
			Map<String, Object> staffChanged = getChangedValue(new Record(oldStaff), new Record(staff), getStaffProp());
			staffChanged.put(SMPI_ID, oldStaff.getSmpiId());
			staffChanged.put(STAFF_CODE, oldStaff.getStaffCode());
			List<Map<String, Object>> changedValues = new ArrayList<Map<String, Object>>();
			changedValues.add(staffChanged);
			changedValues.add(mainChanged);
			return changedValues;
		}
		Criteria criteria = new Criteria(SMPI_ID, oldStaff.getSmpiId());
		Staff staffMain = staffMainDao.get(criteria, getMainProp());
		return staffMain;
	}

	@Transactional
	@Override
	public int updateStatus(String staffCode, Integer status) {
		if (ObjectUtil.isNullOrEmpty(staffCode) && ObjectUtil.isNullOrEmpty(status)) {
			return 0;
		}
		Map<String, Object> value = new HashMap<>();
		value.put("staffCode", staffCode);
		value.put("status", status);
		value.put("operateType", status == 1 ? "启用" : "禁用");
		value.put("updateTime", CheckUtil.getOperatorTime());
		staffDao.insertStaffLog(getStaffProp(), staffCode);
		return staffDao.update(value, value.keySet().toArray(new String[]{""}));
	}

	private void updateStaffMainInfo(Staff staffMain, Staff staff, Staff oldStaff) {
		BeanMap main = BeanMap.create(staffMain);
		Staff compareStaff = oldStaff; //this is for update
		if (compareStaff == null) {
			compareStaff = staffMain;  //this is for create
		}
		Map<String, Object> changedValue = getChangedValue(new Record(compareStaff), new Record(staff), getMainProp());
		if (changedValue.size() > 0) {
			changedValue.put(SMPI_ID, staffMain.getSmpiId());
			Set<Entry<String, Object>> entrySet = changedValue.entrySet();
			for (Entry<String, Object> entry : entrySet) {
				main.put(entry.getKey(), entry.getValue());
			}
			staffMainDao.update(changedValue, changedValue.keySet().toArray(new String[] { "" }));
		}
	}

	private String[] getMainProp() {
		if (MAIN_PROPERTIES == null) {
			MAIN_PROPERTIES = mdmConfigService.getEntityProperties(EntityType.STAFF_MAIN);
		}
		return MAIN_PROPERTIES;
	}

	private String[] getStaffProp() {
		if (STAFF_PROPERTIES == null) {
			STAFF_PROPERTIES = mdmConfigService.getEntityProperties(EntityType.STAFF);
		}
		return STAFF_PROPERTIES;
	}

    private String generateSmpiId() {
        return String.format("%010d", staffMainDao.getSequenceNextVal("SEQ_MDM_STAFF_MAIN", Long.class));
    }

    private void updateAfterSplit(String... smpiId) {
        if (smpiId == null || smpiId.length == 0) {
            return;
        }
        Map<String, Map<String, Object>> updates = new HashMap<>();
        List<Staff> list = staffDao.getList(new Criteria(SMPI_ID, OP.IN, smpiId), new Order("UPDATE_TIME"), getStaffProp());
        for (Staff staff : list) {
            String sid = staff.getSmpiId();
            Record newStaffMain = new Record();
            Map<String, Object> valueMap = updates.get(sid);
            if (valueMap != null) {
                newStaffMain.putAll(valueMap);
            }
            newStaffMain.putAll(getChangedValue(newStaffMain, new Record(staff), getMainProp()));
            updates.put(sid, newStaffMain.getMap());
        }
        List<Map<String, Object>> updateList = new ArrayList<>(updates.values());
        staffMainDao.batchMapUpdate(updateList, getMainProp());
    }

	@Override
	@Transactional
	public void mergeStation(Organization station, List<Organization> stationList) {
		Parameters parameters = new Parameters("organCode", station.getOrganCode());
		List<String> codes = new ArrayList<String>();
		for (Organization organ : stationList) {
			codes.add(organ.getOrganCode());
		}
		Criteria criteria = new Criteria("organCode", OP.IN, codes);
//		HistoryRecorder.record(Staff.class, staffDao, criteria, new String[]{"id", "organCode"});
		staffDao.update(parameters, criteria);
//		HistoryRecorder.record(StaffOrg.class, staffOrgDao, criteria, new String[]{"staffCode", "organCode"});
		//因为MDM_STAFF_ORG中的主键为ORGAN_CODE、staff_code，当医务人员已经在新机构任职，老的机构就可以不用更新了，直接删除
		staffOrgDao.deleteStaffOrg(station.getOrganCode(), codes);
		staffOrgDao.update(parameters, criteria);

		criteria = new Criteria("createOrganCode", OP.IN, codes);
		parameters = new Parameters("createOrganCode", station.getOrganCode());
		parameters.add("createOrganName", station.getOrganName());
		staffOrgDao.update(parameters, criteria);
	}

	@Override
	@Transactional
	public void mergeCenter(Organization center, List<Organization> centerList) {
		Parameters parameters = new Parameters("organCode", center.getOrganCode());
		List<String> codes = new ArrayList<String>();
		for (Organization organ : centerList) {
			codes.add(organ.getOrganCode());
		}
		Criteria criteria = new Criteria("organCode", OP.IN, codes);
//		HistoryRecorder.record(Staff.class, staffDao, criteria, new String[]{"id", "organCode"});
		staffDao.update(parameters, criteria);
//		HistoryRecorder.record(StaffOrg.class, staffOrgDao, criteria, new String[]{"staffCode", "organCode"});
		//因为MDM_STAFF_ORG中的主键为ORGAN_CODE、staff_code，当医务人员已经在新机构任职，老的机构就可以不用更新了，直接删除
		staffOrgDao.deleteStaffOrg(center.getOrganCode(), codes);
		staffOrgDao.update(parameters, criteria);
	}

	@Override
	@Transactional
	public void moveStation(Organization center, List<Organization> stationList) {
		;
	}

	@Override
	public void changeRelationOrgVillage(String orgCode, String[] newAddVillageCodes) {
		// TODO Auto-generated method stub

	}

	/**
	 * 获取各个机构下的医务人员数量
	 * @return
	 */
	@Override
	public Map<String, Long>  getStaffNumByOrg(Criteria criteria) {
		List<Map<String, Object>> mapList = staffDao.getStaffNumByOrg(criteria);
		Map<String, Long> result = new HashMap<String, Long>();
		
		for(Map<String,Object> map : mapList) {
			result.put(String.valueOf(map.get("orgCode")), Long.valueOf(String.valueOf(map.get("count"))));
		}
		return result;
	}

	@Override
	public Staff getStaff(Criteria criteria) {
		return staffDao.get(criteria);
	}

	/**
	 * 返回不存在user表中的staff
	 * @param page
	 * @param criteria
	 * @return
	 */
	@Override
	public PageList<Staff> getStaffPageListsNoInUsers(Page page, Criteria criteria) {
		return staffDao.getStaffPageListsNoInUsers(page, criteria);
	}

	@Override
	public List<Staff> getStaffsByUserCode(String staffCodes[], String userCodes[]) {
		return staffDao.getStaffsByUserCode(staffCodes, userCodes);
	}

	/**
	 * 获取某一个机构下的所有医务人员包括兼职的
	 * @param criteria
	 * @return
	 */
	@Override
	public List<Staff> getAllStaffs(Criteria criteria) {
		return staffDao.getStaffs(criteria);
	}
}
