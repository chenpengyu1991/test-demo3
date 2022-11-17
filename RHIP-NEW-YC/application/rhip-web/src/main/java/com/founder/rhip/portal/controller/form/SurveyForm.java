package com.founder.rhip.portal.controller.form;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.dto.CurrentLoginInfo;
import com.founder.rhip.ehr.entity.portal.SurveyRecord;
import com.founder.rhip.ehr.entity.portal.SurveyItem;
import com.founder.rhip.ehr.entity.portal.SurveyOption;

import org.apache.commons.lang.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SurveyForm {

	private Date startDate;

	private Date endDate;

	private SurveyRecord survey;

	private String organiztionIds;

	private SurveyItem surveyItem;

	private String surveyItemOptions;

	private String[] organizationIdArray;

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public SurveyRecord getSurvey() {
		return survey;
	}

	public void setSurvey(SurveyRecord survey) {
		this.survey = survey;
	}


	public String getOrganiztionIds() {
		return organiztionIds;
	}

	public void setOrganiztionIds(String organiztionIds) {
		this.organiztionIds = organiztionIds;
	}

	public SurveyItem getSurveyItem() {
		return surveyItem;
	}

	public void setSurveyItem(SurveyItem surveyItem) {
		this.surveyItem = surveyItem;
	}

	public String getSurveyItemOptions() {
		return surveyItemOptions;
	}

	public void setSurveyItemOptions(String surveyItemOptions) {
		this.surveyItemOptions = surveyItemOptions;
	}

	/**
	 * update criteria about the submit time for start date and end date
	 * @param crita
	 */
	public void createCriteriaForSurvey(Criteria crita) {

		//for submitTime
		Date startDate = this.getStartDate();
		Date endDate = this.getEndDate();

		SimpleDateFormat dft = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		SimpleDateFormat dftSimple = new SimpleDateFormat("yyyy/MM/dd");
		if(ObjectUtil.isNotEmpty(startDate)){
			String startDateStr = dftSimple.format(startDate);
			String startDateStr1 = startDateStr + " 00:00:00";
			try {
				startDate = dft.parse(startDateStr1);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}

		if(ObjectUtil.isNotEmpty(endDate)){
			String endDateStr = dftSimple.format(endDate);
			String endDateStr1 = endDateStr + " 23:59:59";
			try {
				endDate = dft.parse(endDateStr1);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}

		if (ObjectUtil.isNotEmpty(startDate) && ObjectUtil.isNotEmpty(endDate)) {
			crita.add("submitTime", OP.BETWEEN, new Date[]{startDate,endDate});
		} else {
			if (ObjectUtil.isNotEmpty(startDate)){
				crita.add("submitTime", OP.GE, startDate);
			} else if (ObjectUtil.isNotEmpty(endDate)){
				crita.add("submitTime", OP.LE, endDate);
			}
		}

		if(ObjectUtil.isNullOrEmpty(survey)) return;

		//for title
		if(ObjectUtil.isNotEmpty(this.getSurvey().getTitle())){
			crita.add("title", OP.LIKE, this.getSurvey().getTitle());
		}

		if(ObjectUtil.isNotEmpty(this.getSurvey().getStatus())){
			crita.add("status", this.getSurvey().getStatus());
		}

		//for purpose
		if(ObjectUtil.isNotEmpty(this.getSurvey().getPurpose())){
			crita.add("purpose", OP.LIKE, this.getSurvey().getPurpose());
		}
	}

	/**
	 * get survey to created
	 * @param currentLoginInfo
	 * @return
	 */
	public SurveyRecord getNewSurvey(CurrentLoginInfo currentLoginInfo){
		SurveyRecord survey = new SurveyRecord();
		if(null == currentLoginInfo){
			return null;
		}
		survey.setTitle(this.getSurvey().getTitle());
		survey.setPurpose(this.getSurvey().getPurpose());
		survey.setOrgCode(currentLoginInfo.getOrganization().getOrganCode());
		survey.setUserCode(currentLoginInfo.getUser().getUserCode());
		//TODO
		survey.setStatus("0");
		survey.setSubmitTime(new Date());
		survey.setDirections(this.getSurvey().getDirections());

		List<SurveyItem> newItems = getNewItems();
		if(null == newItems || newItems.isEmpty()){
			return null;
		}
		//set surveyitem
		survey.setItems(newItems);
		return survey;
	}


	/**
	 * get survey item to created
	 * @return
	 */
	private List<SurveyItem> getNewItems() {
		String surveyItemOptions = this.getSurveyItemOptions();
		if(StringUtils.isEmpty(surveyItemOptions)){
			return null;
		}

		List<SurveyItem> surveyItemArr = new ArrayList<SurveyItem>();
		String[] items = StringUtils.split(surveyItemOptions, "%%%");
		for(String itemsOne : items){
			if(StringUtils.isEmpty(itemsOne) || !StringUtils.contains(itemsOne, ";;;")){
				continue;
			}

			String[] itemsOneArr = StringUtils.split(itemsOne, ";;;");
			SurveyItem surveyItem = new SurveyItem();
			String itemDescription = itemsOneArr[0];
			String itemLabelTypeCode = itemsOneArr[1];

			if(itemDescription.length() > 500){
				return null;
			}

			surveyItem.setDescription(itemDescription);
			surveyItem.setLabelTypeCode(itemLabelTypeCode);

			String itemOptions = null;
			if(itemsOneArr.length == 3){
				itemOptions = itemsOneArr[2];
				List<SurveyOption> surveyOptions = getNewOptions(itemOptions);
				if(null == surveyOptions || surveyOptions.isEmpty() ){
					return null;
				}
				surveyItem.setSurveyOptions(getNewOptions(itemOptions));
			}

			surveyItemArr.add(surveyItem);
		}

		return surveyItemArr;
	}

	private List<SurveyOption> getNewOptions(String itemOptions) {
		String[] itemOptionsArr = StringUtils.split(itemOptions, "～～～");
		List<SurveyOption> surveyOptions = new ArrayList<SurveyOption>();
		for(String itemOptinsOne : itemOptionsArr){
			SurveyOption surveyOptionNew = new SurveyOption();
			if(itemOptinsOne.length() > 50){
				return null;
			}
			surveyOptionNew.setItem(itemOptinsOne);
			surveyOptionNew.setIsDefault(0l);
			surveyOptions.add(surveyOptionNew);
		}
		return surveyOptions;
	}

	public String[] getOrganizationIdArray() {
		return organizationIdArray;
	}

	public void setOrganizationIdArray(String[] organizationIdArray) {
		this.organizationIdArray = organizationIdArray;
	}

}
