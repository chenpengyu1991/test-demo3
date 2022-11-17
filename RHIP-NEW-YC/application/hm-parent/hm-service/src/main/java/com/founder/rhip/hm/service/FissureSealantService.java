package com.founder.rhip.hm.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Order;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.util.DateUtil;
import com.founder.rhip.ehr.dto.FissureSealantReportDTO;
import com.founder.rhip.ehr.entity.pbusiness.student.FissureSealant;
import com.founder.rhip.ehr.entity.pbusiness.student.SchoolStudent;
import com.founder.rhip.ehr.repository.pbusiness.student.IFissureSealantDao;
import com.founder.rhip.ehr.repository.pbusiness.student.ISchoolStudentDao;

@Service("fissureSealantService")
public class FissureSealantService implements IFissureSealantService {
	
	@Resource
	private IFissureSealantDao fissureSealantDao;
	
	@Resource
	//private IStudentInfoDao studentInfoDao;
	private ISchoolStudentDao schoolStudentDao;

	@Override
	//@Transactional
	public int importDatas(List<FissureSealant> dataList) {
		List<FissureSealant> createList = new ArrayList<FissureSealant>();
		List<FissureSealant> updateList = new ArrayList<FissureSealant>();
		for (FissureSealant fs : dataList) {
			String examYear = fs.getExamYear();
			String idcard = fs.getIdcard();
			Criteria criteria = new Criteria("examYear", examYear);
			criteria.add("idcard", idcard);
			FissureSealant dbFS = fissureSealantDao.get(criteria);
			if (dbFS == null) {
				fs.setFissureSealantId(fissureSealantDao.getSequenceNextVal("SEQ_FISSURE_SEALANT", Long.class));
				createList.add(fs);
			} else {
				fs.setFissureSealantId(dbFS.getFissureSealantId());
				updateList.add(fs);
			}
		}
		fissureSealantDao.batchInsert(createList);
		fissureSealantDao.batchUpdate(updateList);
		return dataList.size();
	}
	
	@Override
	public FissureSealantReportDTO report(Date beginDate, Date endDate, String[] schoolCodes) {
		FissureSealantReportDTO resultDto = new FissureSealantReportDTO();
		
		List<Map<String, Object>> reportDataList = fissureSealantDao.report(beginDate, endDate, schoolCodes);
		FissureSealantReportDTO.ReportSchool school = new FissureSealantReportDTO.ReportSchool();
		FissureSealantReportDTO.ReportLine notNativeStudentLine = new FissureSealantReportDTO.ReportLine();
		FissureSealantReportDTO.ReportLine nativeStudentLine = new FissureSealantReportDTO.ReportLine();
		String oldSchool = "";
		String dateStr = DateUtil.toDateString(beginDate, "yyyy");
		for (int index = 0; index < reportDataList.size(); index++) {
			Map<String, Object> reportData = reportDataList.get(index);
			String schoolCode = reportData.get("SCHOOL_CODE").toString();

			if (!oldSchool.equals(schoolCode)) {
				school = new FissureSealantReportDTO.ReportSchool();
				resultDto.addReportLine(school);
				school.setSchoolName(schoolCode);
				Criteria criteria = new Criteria("year", dateStr).add("schoolCode", schoolCode);
				SchoolStudent schoolStudent  = schoolStudentDao.get(criteria);
				if (schoolStudent != null) {
					school.setTotleNumber(schoolStudent.getFsTnumber());
				}
				
				notNativeStudentLine = new FissureSealantReportDTO.ReportLine();
				notNativeStudentLine.setNativeStudent("外地");
				school.addReportLine(notNativeStudentLine);
				
				nativeStudentLine = new FissureSealantReportDTO.ReportLine();
				nativeStudentLine.setNativeStudent("本地");
				school.addReportLine(nativeStudentLine);
				
				oldSchool = schoolCode;
			}

			String nativeStudent = reportData.get("NATIVE_STUDENT").toString();
			if ("1".equals(nativeStudent)) {
				setReportData(nativeStudentLine, reportData);
			} else {
				setReportData(notNativeStudentLine, reportData);
			}
		}
		return resultDto;
	}
/*
	@Override
	public FissureSealantReportDTO report(Date beginDate, Date endDate, String[] schoolCodes) {
		//schoolCodes = new String[] {"3205810002", "3205810001"};
		FissureSealantReportDTO resultDto = new FissureSealantReportDTO();
		
		List<Map<String, Object>> reportDataList = fissureSealantDao.report(beginDate, endDate, schoolCodes);
		FissureSealantReportDTO.ReportSchool school = new FissureSealantReportDTO.ReportSchool();
		FissureSealantReportDTO.ReportClass classes = new FissureSealantReportDTO.ReportClass();
		FissureSealantReportDTO.ReportLine notNativeStudentLine = new FissureSealantReportDTO.ReportLine();
		FissureSealantReportDTO.ReportLine nativeStudentLine = new FissureSealantReportDTO.ReportLine();
		String oldSchool = "";
		String oldClassInfo = "";
		for (int index = 0; index < reportDataList.size(); index++) {
			Map<String, Object> reportData = reportDataList.get(index);
			String schoolCode = reportData.get("SCHOOL_CODE").toString();
			String gradaCode = reportData.get("GRADE_CODE").toString();
			String classCode = reportData.get("CLASS_CODE").toString();

			if (!oldSchool.equals(schoolCode)) {
				school = new FissureSealantReportDTO.ReportSchool();
				resultDto.addReportLine(school);
				school.setSchoolName(schoolCode);
				
				oldSchool = schoolCode;
			}
			
			String classInfo = schoolCode + "," + gradaCode  + "," + classCode;
			if (!oldClassInfo.equals(classInfo)) {
				//计算应该窝沟封闭的学生数
				Criteria criteria = new Criteria("schoolCode", schoolCode);
				criteria.add("gradeCode", gradaCode);
				criteria.add("classCode", classCode);
				int allStudentNumber = studentInfoDao.getCount(criteria, "studentId", Integer.class);
				
				classes = new FissureSealantReportDTO.ReportClass();
				classes.setTotleNumber(allStudentNumber);
				classes.setClassCode(Integer.parseInt(classCode) + "班");
				school.addReportLine(classes);
				
				notNativeStudentLine = new FissureSealantReportDTO.ReportLine();
				notNativeStudentLine.setNativeStudent("外地");
				classes.addReportLine(notNativeStudentLine);
				
				nativeStudentLine = new FissureSealantReportDTO.ReportLine();
				nativeStudentLine.setNativeStudent("本地");
				classes.addReportLine(nativeStudentLine);
				
				oldClassInfo = classInfo;
			}

			String nativeStudent = reportData.get("NATIVE_STUDENT").toString();
			if ("0".equals(nativeStudent)) {
				setReportData(notNativeStudentLine, reportData);
			} else {
				setReportData(nativeStudentLine, reportData);
			}
		}
		return resultDto;
	}
	*/
	
	private void setReportData(FissureSealantReportDTO.ReportLine line, Map<String, Object> fs) {
		String gender = (String)fs.get("GENDER").toString();
		if ("1".equals(gender)) {
			//实际检查的男生数
			line.setCheckMnum(getIntValue(fs,"CHECK_NUMBER"));
			//男生检查牙数
			line.setTeethMnum(getIntValue(fs,"TEETH_NUMBER"));
			//男生龋患人数
			line.setEurodonticusMnum(getIntValue(fs,"HAS_DENTAL_CARIES_NUMBER"));
			//男生龋齿数
			line.setDentalCariesMnum(getIntValue(fs,"DENTAL_CARIES_NUMBER"));
			//男生封闭牙数
			line.setClosedMnum(getIntValue(fs,"CLOSE_NUMBER"));
		} else if ("2".equals(gender)) {
			//实际检查的女生数
			line.setCheckFnum(getIntValue(fs,"CHECK_NUMBER"));
			//女生检查牙数
			line.setTeethFnum(getIntValue(fs,"TEETH_NUMBER"));
			//女生龋患人数
			line.setEurodonticusFnum(getIntValue(fs,"HAS_DENTAL_CARIES_NUMBER"));
			//女生龋齿数
			line.setDentalCariesFnum(getIntValue(fs,"DENTAL_CARIES_NUMBER"));
			//女生封闭牙数
			line.setClosedFnum(getIntValue(fs,"CLOSE_NUMBER"));
		}
	}
	
	private int getIntValue(Map<String, Object> fs, String column) {
		Object value = fs.get(column);
		if (value instanceof BigDecimal) {
			return ((BigDecimal)value).intValue();
		}
		return Integer.parseInt(value.toString());
	}

	@Override
	public PageList<FissureSealant> getExamPageList(Page page, Criteria criteria) {
		return fissureSealantDao.getPageList(page, criteria, new Order("CLOSE_DATE"));
	}
	
	@Override
	public FissureSealant getFissureSealant(Long id) {
		return fissureSealantDao.get(id);
	}
	
	@Override
	public void save(FissureSealant fs) {
		fissureSealantDao.update(fs);
	}
	
	@Override
	public void delete(Long id) {
		fissureSealantDao.delete(id);
	}

}
