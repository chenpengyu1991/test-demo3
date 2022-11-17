
package com.founder.rhip.ehr.service.basic;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.rhip.ehr.entity.basic.Question;

/** 
* @ClassName: IQuestionService 
* @Description: 答疑service 
* @author LJY
* @date 2013-8-1 下午4:02:44 
*  
*/
public interface IQuestionService {

	/** 
	* @Title: getQuestionPageList 
	* @Description: 查询答疑列表
	* @param @param page
	* @param @param criteria
	* @param @return
	* @return PageList<Question>
	* @throws 
	*/
	PageList<Question> getQuestionPageList(Page page, Criteria criteria);

	/** 
	* @Title: getQuestion 
	* @Description:  查询答疑
	* @param @param criteria
	* @param @return
	* @return Question
	* @throws 
	*/
	Question getQuestion(Criteria criteria);

	/** 
	* @Title: save 
	* @Description: 保存
	* @param @param question
	* @param @return
	* @return Long
	* @throws 
	*/
	Long save(Question question);

	/** 
	* @Title: update 
	* @Description: 更新
	* @param @param question
	* @param @return
	* @return Integer
	* @throws 
	*/
	Integer update(Question question);

	/** 
	* @Title: delete 
	* @Description: 删除答疑
	* @param @param questionId
	* @param @return
	* @return Integer
	* @throws 
	*/
	Integer delete(Integer questionId);

	/** 
	* @Title: answer 
	* @Description: 解答问题
	* @param @param question
	* @param @return
	* @return Integer
	* @throws 
	*/
	Integer answer(Question question);
}