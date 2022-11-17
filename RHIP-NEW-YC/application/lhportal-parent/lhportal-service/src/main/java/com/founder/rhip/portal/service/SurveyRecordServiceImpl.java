/**
 * copyright Relax4J 2011
 * 
 * @date 2012-02-15
 * @author founder
 * @version V1.0
 * @describe 调查
 */

package com.founder.rhip.portal.service;

import com.founder.fasf.beans.*;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.entity.portal.*;
import com.founder.rhip.ehr.repository.basic.IUserDao;
import com.founder.rhip.ehr.repository.basic.IUserRoleDao;
import com.founder.rhip.ehr.repository.portal.*;
import com.founder.rhip.mdm.repository.IOrganizationDao;
import com.founder.rhip.portal.common.SurveyStatus;
import com.founder.rhip.scheduling.core.Task;
import com.founder.rhip.scheduling.core.TaskBean;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service("surveyRecordService")
@Transactional
@TaskBean(cron = "0 0 5 * * ?", description = "调查问卷定时任务 根据调查日期范围发布或开启调查问卷")

public class SurveyRecordServiceImpl implements ISurveyRecordService,Task {

	@Resource(name = "surveyRecordDao")
	private ISurveyRecordDao surveyDao;

	@Resource(name = "lhsurveyItemDao")
	private ISurveyItemDao surveyItemDao;

	@Resource(name = "lhsurveyOptionDao")
	private ISurveyOptionDao surveyOptionDao;

	@Resource(name = "lhlabelTypeDao")
	private ILabelTypeDao labelTypeDao;

	@Resource(name = "lhpollDao")
	private IPollDao pollDao;

	@Resource(name = "mdmOrganizationDao")
	private IOrganizationDao organizationDao;

	@Resource(name = "ehrUserDao")
	private IUserDao userDao;
	
	@Resource(name = "ehrUserRoleDao")
	private IUserRoleDao userRoleDao;

	@Resource(name = "lhpollOptionDao")
	private IPollOptionDao pollOptionDao;

	@Resource(name = "lhpollTextDao")
	private IPollTextDao pollTextDao;

	/**
	 * 新建调查
	 */
	@Override
	@Transactional
	public Long createSurvey(SurveyRecord survey) {
		Long result = 0l;
		if (null != survey) {
			if(ObjectUtil.isNotEmpty(survey.getId())) {
				result = survey.getId();
				surveyDao.update(survey);
			} else {
				survey.setStatus(SurveyStatus.SAVE.getValue());
				result = surveyDao.generatedKey(survey, "ID",null).longValue();
			}
		}
		return result;
	}

	/**
	 * 更新调查表
	 * 
	 * @param survey
	 * @return int
	 */
	@Override
	public int updateSurvey(SurveyRecord survey) {
		int result = 0;
		if (ObjectUtil.isNotEmpty(survey)) {
			surveyDao.update(survey);
		}
		return result;
	}
	
	@Override
	public int updateSurveyItem(SurveyItem surveyItem, String surveyStatus) {
		int result = 0;
		if (ObjectUtil.isNotEmpty(surveyItem)) {
			if(ObjectUtil.equals(surveyStatus, SurveyStatus.START.getValue())) {
//			更新调查表的状态为开启
				surveyDao.update(new Parameters("status", surveyStatus), new Criteria("id", surveyItem.getSurveyId()));
			}
			surveyItemDao.update(surveyItem);
			if(ObjectUtil.equals("text", surveyItem.getLabelTypeCode())) {
				//若是文本输入框 页面默认有了一个option
				SurveyOption surveyOption = new SurveyOption();
				/*surveyOption.setItemId(surveyItem.getId());
				result += surveyOptionDao.insert(surveyOption);*/
			} else if(ObjectUtil.isNotEmpty(surveyItem.getSurveyOptions())) {
				for(int i = 0; i < surveyItem.getSurveyOptions().size(); i++ ) {
					if(ObjectUtil.isNotEmpty(surveyItem.getSurveyOptions().get(i).getId())) {//保存修改的选项
						SurveyOption surveyOption = new SurveyOption();
						surveyOption.setId(surveyItem.getSurveyOptions().get(i).getId());
						surveyOption.setItem(surveyItem.getSurveyOptions().get(i).getItem());
						surveyOption.setIsDefault(surveyItem.getSurveyOptions().get(i).getIsDefault());
						surveyOption.setItemId(surveyItem.getSurveyOptions().get(i).getItemId());
						surveyOption.setValue(surveyItem.getSurveyOptions().get(i).getValue());
						result += surveyOptionDao.update(surveyOption);
					} else {
						surveyOptionDao.insert(surveyItem.getSurveyOptions().get(i));//修改是新增添加的选项
					}
				}
			}
		}
		return result;
	}

	@Override
	public int createSurveyItemsAndOptions(SurveyItem surveyItem, String surveyStatus) {
		int result = 0;
		if(ObjectUtil.equals(surveyStatus, SurveyStatus.START.getValue())) {
//			更新调查表的状态为开启
			surveyDao.update(new Parameters("status", surveyStatus), new Criteria("id", surveyItem.getSurveyId()));
		}
		Long itemId = surveyItemDao.generatedKey(surveyItem, "ID",null).longValue();
		surveyItem.setId(itemId);

		if(ObjectUtil.equals("text", surveyItem.getLabelTypeCode())) {
			//若是文本输入框 页面默认有了一个option
			SurveyOption surveyOption = new SurveyOption();
			surveyOption.setItemId(itemId);
			surveyOptionDao.delete(new Criteria("ITEM_ID", itemId));
			result += surveyOptionDao.insert(surveyOption);
		} else if(ObjectUtil.isNotEmpty(surveyItem.getSurveyOptions())) {
			result += surveyOptionDao.batchInsert(surveyItem.getSurveyOptions());
		}

		return result;
	}

	@Override
	public int createPoll(Poll poll) {
		int result = 0;
		if(ObjectUtil.isNotEmpty(poll.getPollOptions())) {
			pollOptionDao.batchInsert(poll.getPollOptions());
			result = 1;
		}
		if(ObjectUtil.isNotEmpty(poll.getPollTexts())) {
			pollTextDao.batchInsert(poll.getPollTexts());
			result = 1;
		}
		if(pollDao.insert(poll) > 0)
			result = 1;
		return result;
	}
	
	@Override
	public SurveyRecord getSurvey(Criteria criteria) {
		SurveyRecord survey = new SurveyRecord();
		if(ObjectUtil.isNotEmpty(criteria)) {
			survey = surveyDao.get(criteria);
		}
		return survey;
	}
	
	@Override
	public SurveyItem getSurveyItem(Criteria criteria) {
		SurveyItem surveyItem = new SurveyItem();
		if(ObjectUtil.isNotEmpty(criteria)) {
			surveyItem = surveyItemDao.get(criteria);
			//通过value值来排序，数据库中是以A,B,C,依次排序
			surveyItem.setSurveyOptions(surveyOptionDao.getList(new Criteria("ITEM_ID", criteria.get("id")), new Order("value", true)));
		}
		return surveyItem;
	}
	
	@Override
	public SurveyOption getSurveyOption(Criteria criteria) {
		SurveyOption surveyOption = new SurveyOption();
		if(ObjectUtil.isNotEmpty(criteria)) {
			surveyOption = surveyOptionDao.get(criteria);
		}
		return surveyOption;
	}
	
	@Override
	public int updateStatus(Long surveyId, String status) {
		int result = 0;
		result = surveyDao.update(new Parameters("status", status), new Criteria("id", surveyId));
		return result;
	}

	@Override
	public SurveyRecord getSurvey(Long surveyId) {
		return surveyDao.get(surveyId);
	}

	@Override
	public PageList<SurveyRecord> getSurveyList(Page page, Criteria criteria){
        PageList<SurveyRecord> result = null;
		Order order = new Order("STATUS", true).desc("SUBMIT_TIME");
        if(ObjectUtil.isNotEmpty(page)){
            result = surveyDao.getPageList(page, criteria, order);
        }
        return result;
    }
	
	@Override
	public PageList<SurveyItem> getSurveyItemList(Page page, Criteria criteria, Order order){
        PageList<SurveyItem> result = null;
        if(ObjectUtil.isNotEmpty(page)){
            result = surveyItemDao.getPageList(page, criteria, order);
        }
        return result;
    }
	
	@Override
	public int deleteSurvey(Long surveryId) {
		return surveyDao.delete(new Criteria("id", surveryId));
	}
	
	@Override
	public int deleteSurveyItem(Long surveryItemId) {
		return  surveyItemDao.delete(new Criteria("id", surveryItemId));
	}

	@Override
	public int deleteSurveyOption(Long surveryItemId) {
		return  surveyOptionDao.delete(new Criteria("itemId", surveryItemId));
	}
	
	@Override
	public int deleteOption(Long optionId) {
		return  surveyOptionDao.delete(new Criteria("id", optionId));
	}
	
	@Override
	public int deletePollOption(Long pollId) {
		return  pollOptionDao.delete(new Criteria("pollId", pollId));
	}
	
	@Override
	public int deletePollText(Long itemId) {
		return  pollTextDao.delete(new Criteria("itemId", itemId));
	}
	
	@Override
	public List<SurveyItem> getSurveyItemList(Criteria criteria, Order order) {
		return surveyItemDao.getList(criteria, order);
	}

	@Override
	public List<SurveyOption> getSurveyOptionList(Criteria criteria, Order order) {
		return surveyOptionDao.getList(criteria, order);
	}

	@Override
	public int updateSurveyOption(SurveyOption surveyOption) {
		return surveyOptionDao.update(surveyOption);
	}

	@Override
	public List<PollOption> getPollOptionList(Long itemId) {
		return pollOptionDao.getPollOptionList(itemId);
	}

	@Override
	public Long getOptionCount(Criteria criteria) {
		Long result = 0L;
		if(ObjectUtil.isNotEmpty(criteria)){
			result = pollOptionDao.getCount(criteria, "poll_id", Long.class);
		}
		return result;
	}
	
	@Override
	public List<PollText> getPollTextList(Criteria criteria) {
		List<PollText> result = null;
	            result = pollTextDao.getList(criteria);
	        return result;
	}

	@Override
	public void run(Map<String, Object> data) {
		updateSurveyStatus();
	}

	/**
	 * 根据起始日期 更新调查问卷的状态
	 */
	@Override
	public void updateSurveyStatus() {
		Date nowDate = new Date();

		Criteria criteriaStart = new Criteria();
		DateUtil.getCriteriaByDateRange(criteriaStart, "START_DATE", nowDate, nowDate);
		List<SurveyRecord> startList = surveyDao.getList(new Criteria("status", SurveyStatus.SAVE.getValue()).add(criteriaStart));
		surveyDao.update(new Parameters("status", SurveyStatus.START.getValue()), new Criteria("id", OP.IN, this.getUpdateSurveyIds(startList)));

		Criteria criteriaEnd = new Criteria();
		DateUtil.getCriteriaByDateRange(criteriaEnd, "END_DATE", nowDate, nowDate);
		List<SurveyRecord> endList = surveyDao.getList(new Criteria("status", SurveyStatus.START.getValue()).add(criteriaEnd));

		surveyDao.update(new Parameters("status", SurveyStatus.ENDS.getValue()), new Criteria("id", OP.IN, this.getUpdateSurveyIds(endList)));

	}

	private List<Long> getUpdateSurveyIds(List<SurveyRecord> list) {
		List<Long> idList = new ArrayList<Long>();
		for(SurveyRecord survey : list) {
			idList.add(survey.getId());
		}
		return idList;
	}

	@Override
	public List<SurveyOption> getSurveyOptionsByItemIdLists(Criteria criteria) {
		return surveyOptionDao.getSurveyOptionsByItemIdLists(criteria);
	}

	@Override
	public List<PollOption> getOptionCountLists(Criteria criteria) {
		return pollOptionDao.getOptionCountLists(criteria);
	}

	@Override
	public List<PollOption> optionCountByItemLists(Criteria criteria) {
		return pollOptionDao.optionCountByItemLists(criteria);
	}

	@Override
	public List<PollText> getPollTextLists(Criteria criteria) {
		return pollTextDao.getPollTextLists(criteria);
	}

}