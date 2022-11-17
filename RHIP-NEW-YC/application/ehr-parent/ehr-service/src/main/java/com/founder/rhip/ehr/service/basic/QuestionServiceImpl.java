/**   
* @Title: QuestionServiceImpl.java 
* @Package com.founder.rhip.ehr.service.basic 
* @Description: 答疑类 
* @author LJY
* @date 2013-8-1 下午4:10:49 
* @version V1.0   
*/
package com.founder.rhip.ehr.service.basic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Order;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.rhip.ehr.entity.basic.Question;
import com.founder.rhip.ehr.repository.basic.IQuestionDao;

/** 
 * @ClassName: QuestionServiceImpl 
 * @Description: 答疑类 
 * @author LJY
 * @date 2013-8-1 下午4:10:49 
 *  
 */
@Service("questionService")
public class QuestionServiceImpl implements IQuestionService {

	@Autowired
	private IQuestionDao questionDao;
	
	@Override
	public PageList<Question> getQuestionPageList(Page page,Criteria criteria){
		Order order = new Order("SUBMIT_TIME",false);
		return questionDao.getPageList(page, criteria, order);
	}
	
	@Override
	public Question getQuestion(Criteria criteria){
		return questionDao.get(criteria);
	}
	
	@Override
	public Long save(Question question){
		return questionDao.generatedKey(question, "ID", null).longValue();
	}
	
	@Override
	public Integer update(Question question){
		return questionDao.update(question,"keyWord","content");
	}
	
	@Override
	public Integer answer(Question question){
		return questionDao.update(question,"answer","answerContent","answerTime");
	}
	
	
	@Override 
	public Integer delete(Integer questionId){
		Criteria criteria = new Criteria("id",questionId);
		return questionDao.delete(criteria);
	}
}
