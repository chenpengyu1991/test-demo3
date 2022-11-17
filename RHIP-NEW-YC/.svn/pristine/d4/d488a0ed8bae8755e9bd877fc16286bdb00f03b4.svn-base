package com.founder.rhip.ehr.entity.basic;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/** 
* @ClassName: Question 
* @Description: 答疑类
* @author LJY
* @date 2013-8-1 下午3:49:17 
*  
*/
@Entity
@Table(name="PUB_QUESTION")
public class Question implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID",columnDefinition="NUMBER|公告标识",length=11,nullable=false)
	private Long id;

	@Column(name="CONTENT",columnDefinition="VARCHAR2|内容",length=4000,nullable=false)
	private String content;
	
	@Column(name="KEY_WORD",columnDefinition="VARCHAR2|关键词",length=50,nullable=false)
	private String keyWord;
	@Column(name="KEY_WORD_TYPE",columnDefinition="VARCHAR2|类型",length=50,nullable=false)
	private String keyWordType;
	@Column(name="SUBMIT_TIME",columnDefinition="DATE|提问时间",nullable=false)
	private Date submitTime;

	@Column(name="SUBMITOR",columnDefinition="NUMBER|提问人",length=11,nullable=true)
	private Long submitor;
	
	@Column(name="ANSWER",columnDefinition="NUMBER|回答人",length=11,nullable=true)
	private Long answer;
	
	@Column(name="ANSWER_TIME",columnDefinition="DATE|回答时间",nullable=true)
	private Date answerTime;
	
	@Column(name="ANSWER_CONTENT",columnDefinition="VARCHAR2|内容",length=4000,nullable=true)
	private String answerContent;
	
	public String getKeyWordType() {
		return keyWordType;
	}

	public void setKeyWordType(String keyWordType) {
		this.keyWordType = keyWordType;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getSubmitTime() {
		return this.submitTime;
	}

	public void setSubmitTime(Date submitTime) {
		this.submitTime = submitTime;
	}

	public Long getSubmitor() {
		return this.submitor;
	}

	public void setSubmitor(Long submitor) {
		this.submitor = submitor;
	}

	public Long getAnswer() {
		return answer;
	}

	public void setAnswer(Long answer) {
		this.answer = answer;
	}

	public Date getAnswerTime() {
		return answerTime;
	}

	public void setAnswerTime(Date answerTime) {
		this.answerTime = answerTime;
	}

	public String getAnswerContent() {
		return answerContent;
	}

	public void setAnswerContent(String answerContent) {
		this.answerContent = answerContent;
	}

	public String getKeyWord() {
		return keyWord;
	}

	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}

}