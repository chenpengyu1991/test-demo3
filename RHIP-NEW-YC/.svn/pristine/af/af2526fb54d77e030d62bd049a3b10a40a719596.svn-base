package com.founder.rhip.aop;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * 服务计划同步的请求信息
 *
 * @author wansong
 */
@XmlRootElement(name = "servicePlanSyncRequestInfo")
public class ServicePlanSyncRequestInfo {
	

	private String personIdCard;//居民身份证号  (不可空)
	private String dataSrc;//数据来源， 如： 区域平台=RHIP (不可空)
	private List<YearPlan> yearPlan;// (至少有一条数据)

	static class YearPlan {
		private String planYear; //计划年度
		private String diseaseType; //疾病类型
		private List<DayPlan> dayPlan;//具体的计划信息， 现在的字段有：planDate（计划日期）, content（内容）, remark（备注）

		public String getPlanYear() {
			return planYear;
		}

		public void setPlanYear(String planYear) {
			this.planYear = planYear;
		}

		public String getDiseaseType() {
			return diseaseType;
		}

		public void setDiseaseType(String diseaseType) {
			this.diseaseType = diseaseType;
		}

		public List<DayPlan> getDayPlan() {
			return dayPlan;
		}

		public void setDayPlan(List<DayPlan> dayPlan) {
			this.dayPlan = dayPlan;
		}
	}

	static class DayPlan {
		private String planDate; //计划日
		private String content; //内容
		private String remark; //备注

		public String getPlanDate() {
			return planDate;
		}

		public void setPlanDate(String planDate) {
			this.planDate = planDate;
		}

		public String getContent() {
			return content;
		}

		public void setContent(String content) {
			this.content = content;
		}

		public String getRemark() {
			return remark;
		}

		public void setRemark(String remark) {
			this.remark = remark;
		}
	}


	public String getPersonIdCard() {
		return personIdCard;
	}

	public void setPersonIdCard(String personIdCard) {
		this.personIdCard = personIdCard;
	}

	public String getDataSrc() {
		return dataSrc;
	}

	public void setDataSrc(String dataSrc) {
		this.dataSrc = dataSrc;
	}

	public List<YearPlan> getYearPlan() {
		return yearPlan;
	}

	public void setYearPlan(List<YearPlan> yearPlan) {
		this.yearPlan = yearPlan;
	}
}