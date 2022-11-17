package com.founder.rhip.ehr.entity.basic;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/** 
* @ClassName: Bulletin 
* @Description: 公告类
* @author LJY
* @date 2013-8-1 下午3:48:48 
*  
*/
@Entity
@Table(name="PUB_BULLETIN")
public class Bulletin implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID",columnDefinition="NUMBER|公告标识",length=11,nullable=false)
	private Long id;

	@Column(name="TITLE",columnDefinition="VARCHAR2|标题",length=50,nullable=false)
	private String title;

	@Column(name="CONTENT",columnDefinition="VARCHAR2|内容",length=4000,nullable=false)
	private String content;

	@Column(name="SUBMIT_TIME",columnDefinition="DATE|发布时间",nullable=false)
	private Date submitTime;

	@Column(name="SUBMITOR",columnDefinition="NUMBER|创建人",length=11,nullable=true)
	private Long submitor;

	@Column(name="IS_DELETE",columnDefinition="NUMBER|是否可用",length=1,nullable=true)
	private Integer isDelete;
	

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	
	public Integer getIsDelete() {
		return this.isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}
}