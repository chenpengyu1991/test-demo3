package com.founder.rhip.ehr.dto;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.LOP;
import com.founder.fasf.beans.OP;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.ehr.common.EHRConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

/**
 * 规范化管理用
 * 
 * @author liuk
 * 
 */
public class QueryForm implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6628221431801245355L;
	private String name;
	private String idcard;
	private Integer startAge;
	private Integer endAge;
	private String diseaseType;
	private String diseaseStatus;
	private String gender;
	private String followupFlag;
	private Integer isDelete;

	private String yearDt;

	private String doctorCode;

	private String gbcode;
	private String stationOrganCode;
	private String centerOrganCode;
	private String phyExamType;
	private String deleteOrCancel;
	public final static String VIEW_DLELTE = "2";
	public final static String VIEW_CANCEL = "1";

	private String isManagedFlag;
	private Date managedDateStart;
	private Date managedDateEnd;

	private Date followupDateStart;
	private Date followupDateEnd;
	private Integer followupCount;
	private String followupCountCompareType;

	private Date nextFollowupDate;//计划随访时间

    //现住址居委会
    private String paStreet;

    //镇
    private String patownShip;

	public String getDiseaseStatus() {
		return diseaseStatus;
	}

	public String getDiseaseType() {
		return diseaseType;
	}

	public Integer getEndAge() {
		return endAge;
	}

	public String getIdcard() {
		return idcard;
	}

	public String getName() {
		return name;
	}

	public Integer getStartAge() {
		return startAge;
	}

	public void setDiseaseStatus(String diseaseStatus) {
		this.diseaseStatus = diseaseStatus;
	}

	public void setDiseaseType(String diseaseType) {
		this.diseaseType = diseaseType;
	}

	public void setEndAge(Integer endAge) {
		this.endAge = endAge;
	}

	public void setIdcard(String idcard) {
		if (ObjectUtil.NotEmpty(idcard)) {
			idcard = idcard.toUpperCase();
		}
		this.idcard = idcard;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setStartAge(Integer startAge) {
		this.startAge = startAge;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

    public String getPaStreet() {
        return paStreet;
    }

    public void setPaStreet(String paStreet) {
        this.paStreet = paStreet;
    }

    public String getPatownShip() {
        return patownShip;
    }

    public void setPatownShip(String patownShip) {
        this.patownShip = patownShip;
    }

    public Criteria toCriteria(boolean isConvertDiseaseType) {
		Criteria criteria = new Criteria();

		if (StringUtil.isNotEmpty(name)) {
			criteria.add("dmPersonInfo.NAME", OP.LIKE, name);
		}
		if (StringUtil.isNotEmpty(idcard)) {
			criteria.add("dmPersonInfo.IDCARD", idcard);
		}
		if (StringUtil.isNotEmpty(gender)) {
			criteria.add("dmPersonInfo.GENDER", gender);
		}

		if (StringUtil.isNotEmpty(diseaseType)) {
			String[] types = diseaseType.split(",");
			if (types.length > 0) {
				if (isConvertDiseaseType) {
					Criteria disTypeCriteria = new Criteria();
					criteria.add(disTypeCriteria);
					for (String type : types) {
						switch (type) {
							case EHRConstants.DM_HBP_TYPE:
								disTypeCriteria.add(LOP.OR, "hbpFlag", EHRConstants.DM_MANAGED_FLAG);
								break;
							case EHRConstants.DM_DI_TYPE:
								disTypeCriteria.add(LOP.OR, "diFlag", EHRConstants.DM_MANAGED_FLAG);
								break;
							case EHRConstants.DM_CORONARY_TYPE:
								disTypeCriteria.add(LOP.OR, "coronaryFlag", EHRConstants.DM_MANAGED_FLAG);
								break;
							case EHRConstants.DM_TUMOR_TYPE:
								disTypeCriteria.add(LOP.OR, "tumorFlag", EHRConstants.DM_MANAGED_FLAG);
								break;
							case EHRConstants.DM_STROKE_TYPE:
								disTypeCriteria.add(LOP.OR, "strokeFlag", EHRConstants.DM_MANAGED_FLAG);
								break;
						}
					}
				} else {
					criteria.add("dmDiseaseInfo.DIS_TYPE", OP.IN, types);
				}
				if (ObjectUtil.isNotEmpty(isManagedFlag)) {
					String type = types[0];
					switch (type) {
					case EHRConstants.DM_HBP_TYPE:
                        criteria.add("dmDiseaseInfo.HBP_MANAGED_FLAG",isManagedFlag);
						//criteria.add("dmDiseaseInfo.LAST_HBP_PLAN_YEAR", OP.IS, isManagedFlag.equals("1") ? "NOT NULL" : "NULL");
						break;
					case EHRConstants.DM_DI_TYPE:
                        criteria.add("dmDiseaseInfo.DI_MANAGED_FLAG",isManagedFlag);
						//criteria.add("dmDiseaseInfo.LAST_DI_PLAN_YEAR", OP.IS, isManagedFlag.equals("1") ? "NOT NULL" : "NULL");
						break;
					case EHRConstants.DM_CORONARY_TYPE:
						criteria.add("dmDiseaseInfo.CORONARY_MANAGED_FLAG", isManagedFlag);
						break;
					case EHRConstants.DM_TUMOR_TYPE:
						criteria.add("dmDiseaseInfo.TUMOR_MANAGED_FLAG", isManagedFlag);
						break;
					case EHRConstants.DM_STROKE_TYPE:
						criteria.add("dmDiseaseInfo.STROKE_MANAGED_FLAG", isManagedFlag);
						break;
					}
				}

				if (ObjectUtil.isNotEmpty(managedDateStart) || ObjectUtil.isNotEmpty(managedDateEnd)) {
					String type = types[0];
					String column = null;
					switch (type) {
					case EHRConstants.DM_HBP_TYPE:
						column = "dmDiseaseInfo.HBP_MANAGED_DATE";
						break;
					case EHRConstants.DM_DI_TYPE:
						column = "dmDiseaseInfo.DI_MANAGED_DATE";
						break;
					case EHRConstants.DM_CORONARY_TYPE:
						column = "dmDiseaseInfo.CORONARY_MANAGED_DATE";
						break;
					case EHRConstants.DM_TUMOR_TYPE:
						column = "dmDiseaseInfo.TUMOR_MANAGED_DATE";
						break;
					case EHRConstants.DM_STROKE_TYPE:
						column = "dmDiseaseInfo.STROKE_MANAGED_DATE";
						break;
					}

					if (null != column) {
						if (null != managedDateStart && null == managedDateEnd) {
							criteria.add(column, OP.GE, DateUtil.makeTimeToZero(managedDateStart));
						} else if (null == managedDateStart && null != managedDateEnd) {
							criteria.add(column, OP.LE, DateUtil.makeTimeToMax(managedDateEnd));
						}
						if (null != managedDateStart && null != managedDateEnd) {
							criteria.add(column, OP.BETWEEN, new Date[] { DateUtil.makeTimeToZero(managedDateStart), DateUtil.makeTimeToMax(managedDateEnd) });
						}
					}
				}

			}
		}

		if (StringUtil.isNotEmpty(diseaseStatus)) {
			criteria.add("dmDiseaseInfo.STATUS", diseaseStatus);
		}

		if (null != isDelete) {
			criteria.add("dmDiseaseInfo.IS_DELETE", isDelete);
		}

		if (ObjectUtil.isNotEmpty(startAge) && ObjectUtil.isNullOrEmpty(endAge)) {
			criteria.add("birthday", OP.LE, getEndBirthdayByAge());
		} else if (ObjectUtil.isNullOrEmpty(startAge) && ObjectUtil.isNotEmpty(endAge)) {
			criteria.add("birthday", OP.GE, getStartBirthdayByAge());
		} else if (ObjectUtil.isNotEmpty(startAge) && ObjectUtil.isNotEmpty(endAge)) {
			criteria.add("birthday", OP.BETWEEN, new Date[] { getStartBirthdayByAge(), getEndBirthdayByAge() });
		}

		if (ObjectUtil.isNotEmpty(stationOrganCode)) {
			criteria.add("dmDiseaseInfo.CREATE_ORGAN_CODE", stationOrganCode);
		} else if (ObjectUtil.isNotEmpty(centerOrganCode)) {
			criteria.add("dmPersonInfo.CREATE_CENTER_ORGAN_CODE", centerOrganCode);
		} else if (ObjectUtil.isNotEmpty(gbcode)) {
			criteria.add("dmPersonInfo.CREATE_GBCODE", gbcode);
		}

		if (ObjectUtil.isNotEmpty(phyExamType)) {
			int year = DateUtil.getCurrentYear();
			// 待体检
			if ("2".equals(phyExamType)) {
				Criteria dateParam = new Criteria();
				dateParam.add("dmDiseaseInfo.LAST_PHY_EXAMINATION_YEAR", OP.LT, year);
				dateParam.add(LOP.OR, "dmDiseaseInfo.LAST_PHY_EXAMINATION_YEAR", OP.IS, "NULL");
				criteria.add(dateParam);
			} else {
				criteria.add("dmDiseaseInfo.LAST_PHY_EXAMINATION_YEAR", OP.GE, year);
			}
		}

		if(null != yearDt && yearDt != ""){
			criteria.add("dmDiseaseInfo.DI_MANAGED_DATE", OP.BETWEEN, new Date[] { DateUtil.parseDateString(yearDt+""+"/01/01"), DateUtil.parseDateString(yearDt+""+"/12/31")});
		}

        //增加居委会条件
        if(StringUtil.isNotEmpty(paStreet)){
            criteria.add("dmPersonInfo.PASTREET",paStreet);
        }

        //增加镇条件
        if(StringUtil.isNotEmpty(patownShip)){
            criteria.add("dmPersonInfo.PATOWN_SHIP",patownShip);
        }

		return criteria;
	}

    private static Logger logger= LoggerFactory.getLogger(QueryForm.class);
	private Date getStartBirthdayByAge() {
		Calendar beginDate = Calendar.getInstance();
		beginDate.setTime(new Date());
		beginDate.add(Calendar.YEAR, -endAge);
		beginDate.set(Calendar.MONTH, Calendar.JANUARY);
		beginDate.set(Calendar.DAY_OF_MONTH, 1);
		DateUtil.makeTimeToZero(beginDate);
        logger.error(beginDate.toString());
        logger.error(DateUtil.toDateString(beginDate.getTime(), "yyyy/MM/dd HH:mm:ss"));
		return beginDate.getTime();
	}

	private Date getEndBirthdayByAge() {
		Calendar endDate = Calendar.getInstance();
		endDate.setTime(new Date());
		endDate.add(Calendar.YEAR, -startAge);
		endDate.set(Calendar.MONTH, Calendar.DECEMBER);
		endDate.set(Calendar.DAY_OF_MONTH, 31);
		DateUtil.makeTimeToMax(endDate);
        logger.error(endDate.toString());
        logger.error(DateUtil.toDateString(endDate.getTime(), "yyyy/MM/dd HH:mm:ss"));
		return endDate.getTime();
	}

	public String getFollowupFlag() {
		return followupFlag;
	}

	public void setFollowupFlag(String followupFlag) {
		this.followupFlag = followupFlag;
	}

	public String getGbcode() {
		return gbcode;
	}

	public void setGbcode(String gbcode) {
		this.gbcode = gbcode;
	}

	public String getStationOrganCode() {
		return stationOrganCode;
	}

	public void setStationOrganCode(String stationOrganCode) {
		this.stationOrganCode = stationOrganCode;
	}

	public String getCenterOrganCode() {
		return centerOrganCode;
	}

	public void setCenterOrganCode(String centerOrganCode) {
		this.centerOrganCode = centerOrganCode;
	}

	public String getPhyExamType() {
		return phyExamType;
	}

	public void setPhyExamType(String phyExamType) {
		this.phyExamType = phyExamType;
	}

	public Integer getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

	public String getDeleteOrCancel() {
		return deleteOrCancel;
	}

	public void setDeleteOrCancel(String deleteOrCancel) {
		this.deleteOrCancel = deleteOrCancel;
	}

	public String getIsManagedFlag() {
		return isManagedFlag;
	}

	public void setIsManagedFlag(String isManagedFlag) {
		this.isManagedFlag = isManagedFlag;
	}

	public Date getManagedDateStart() {
		return managedDateStart;
	}

	public void setManagedDateStart(Date managedDateStart) {
		this.managedDateStart = managedDateStart;
	}

	public Date getManagedDateEnd() {
		return managedDateEnd;
	}

	public void setManagedDateEnd(Date managedDateEnd) {
		this.managedDateEnd = managedDateEnd;
	}

	public Date getFollowupDateStart() {
		return followupDateStart;
	}

	public void setFollowupDateStart(Date followupDateStart) {
		this.followupDateStart = followupDateStart;
	}

	public Date getFollowupDateEnd() {
		return followupDateEnd;
	}

	public void setFollowupDateEnd(Date followupDateEnd) {
		this.followupDateEnd = followupDateEnd;
	}

	public Integer getFollowupCount() {
		return followupCount;
	}

	public void setFollowupCount(Integer followupCount) {
		this.followupCount = followupCount;
	}

	public String getFollowupCountCompareType() {
		return followupCountCompareType;
	}

	public void setFollowupCountCompareType(String followupCountCompareType) {
		this.followupCountCompareType = followupCountCompareType;
	}

	public String getYearDt() {
		return yearDt;
	}

	public void setYearDt(String yearDt) {
		this.yearDt = yearDt;
	}

	public String getDoctorCode() {
		return doctorCode;
	}

	public void setDoctorCode(String doctorCode) {
		this.doctorCode = doctorCode;
	}

	public Date getNextFollowupDate() {
		return nextFollowupDate;
	}

	public void setNextFollowupDate(Date nextFollowupDate) {
		this.nextFollowupDate = nextFollowupDate;
	}
}
