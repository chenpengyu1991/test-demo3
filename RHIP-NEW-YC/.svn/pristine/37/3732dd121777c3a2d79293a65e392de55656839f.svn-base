package com.founder.rhip.ehr.entity.healtheducation;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "HE_COPY")
public class HeCopy implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|数据库唯一编号|11|", length = 11, nullable = true)
	private Integer id;

	@Column(name = "TITLE", columnDefinition = "VARCHAR2|刊（播）出文章题目|100|", length = 100, nullable = true)
	private String title;

	@Column(name = "PUBLISH_DATE", columnDefinition = "DATE|刊（播）日期||", nullable = true)
	private Date publishDate;

	@Column(name = "PUBLISH_ORGAN", columnDefinition = "VARCHAR2|发表单位|10|", length = 10, nullable = true)
	private String publishOrgan;

	@Column(name = "EDITION", columnDefinition = "VARCHAR2|版面|10|", length = 10, nullable = true)
	private String edition;

	@Column(name = "TYPE", columnDefinition = "VARCHAR2|类型|10|", length = 10, nullable = true)
	private String type;

	@Column(name = "AUTHOR", columnDefinition = "VARCHAR2|作者|50|", length = 50, nullable = true)
	private String author;

	@Column(name = "AUTHOR_ORG", columnDefinition = "VARCHAR2|作者所属机构|50|", length = 50, nullable = true)
	private String authorOrg;

	@Column(name = "ATTACHMENT", columnDefinition = "VARCHAR2|附件名|50|", length = 50, nullable = true)
	private String attachment;

	@Column(name = "PLEVEL", columnDefinition = "VARCHAR2|级别|10|", length = 10, nullable = true)
	private String pLevel;

	@Column(name = "MEDIA", columnDefinition = "VARCHAR2|媒体|10|", length = 10, nullable = true)
	private String media;

	@Column(name = "CATEGORY", columnDefinition = "VARCHAR2|类别|10|", length = 10, nullable = true)
	private String category;

	@Column(name = "WORDS", columnDefinition = "NUMBER|字数|11|", length = 11, nullable = true)
	private Integer words;

	@Column(name = "CREATOR", columnDefinition = "VARCHAR2|创建人|50|", length = 50, nullable = true)
	private String creator;

	@Column(name = "CREATE_DATE", columnDefinition = "DATE|创建时间||", nullable = true)
	private Date createDate;

	@Column(name = "CREATE_ORGAN", columnDefinition = "VARCHAR2|创建机构|50|", length = 50, nullable = true)
	private String createOrgan;

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getPublishDate() {
		return this.publishDate;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

	public String getPublishOrgan() {
		return this.publishOrgan;
	}

	public void setPublishOrgan(String publishOrgan) {
		this.publishOrgan = publishOrgan;
	}

	public String getEdition() {
		return this.edition;
	}

	public void setEdition(String edition) {
		this.edition = edition;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getAuthor() {
		return this.author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getAuthorOrg() {
		return this.authorOrg;
	}

	public void setAuthorOrg(String authorOrg) {
		this.authorOrg = authorOrg;
	}

	public String getAttachment() {
		return this.attachment;
	}

	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}

	public String getpLevel() {
		return pLevel;
	}

	public void setpLevel(String pLevel) {
		this.pLevel = pLevel;
	}

	public String getMedia() {
		return this.media;
	}

	public void setMedia(String media) {
		this.media = media;
	}

	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Integer getWords() {
		return this.words;
	}

	public void setWords(Integer words) {
		this.words = words;
	}

	public String getCreator() {
		return this.creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getCreateOrgan() {
		return createOrgan;
	}

	public void setCreateOrgan(String createOrgan) {
		this.createOrgan = createOrgan;
	}
}