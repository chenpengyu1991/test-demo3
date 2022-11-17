package com.founder.rhip.ehr.entity.clinic;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "MS_READ_HEALTH_RECORD")
public class ReadHealthRecord implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID", columnDefinition = "NUMBER|用户标识|11|", length = 11, nullable = false)
    private Long id;
    
    @Column(name = "PERSON_NAME", columnDefinition = "VARCHAR2|被调阅者姓名||", length = 50, nullable = true)
    private String personName;

    @Column(name = "PERSON_IDCARD", columnDefinition = "VARCHAR2|被调阅者身份证号码||", length = 18, nullable = true)
    private String personIdcard;

    @Column(name = "READER_ORGANCODE", columnDefinition = "VARCHAR2|调阅机构编码||", length = 12, nullable = true)
    private String readerOrgancode;

    @Column(name = "READER_ID", columnDefinition = "NUMBER|调阅者ID||", length = 11, nullable = true)
    private Long readerId;

    @Column(name = "READER_NAME", columnDefinition = "NUMBER|调阅人姓名||", length = 50, nullable = true)
    private String readerName;

    @Column(name = "READ_DATE", columnDefinition = "DATE|调阅时间||", nullable = true)
    private Date readDate;

	@Column(name = "SOURCE", columnDefinition = "NUMBER|调用端来源||", length = 3, nullable = true)
	private String source = "1";

    @Column(name = "IS_DELETE", columnDefinition = "NUMBER||", length = 1, nullable = true)
    private Integer isDelete;

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public String getPersonIdcard() {
		return personIdcard;
	}

	public void setPersonIdcard(String personIdcard) {
		this.personIdcard = personIdcard;
	}

	public String getReaderOrgancode() {
		return readerOrgancode;
	}

	public void setReaderOrgancode(String readerOrgancode) {
		this.readerOrgancode = readerOrgancode;
	}

	public Long getReaderId() {
		return readerId;
	}

	public void setReaderId(Long readerId) {
		this.readerId = readerId;
	}

	public String getReaderName() {
		return readerName;
	}

	public void setReaderName(String readerName) {
		this.readerName = readerName;
	}

	public Date getReadDate() {
		return readDate;
	}

	public void setReadDate(Date readDate) {
		this.readDate = readDate;
	}

	public Integer getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}
}
