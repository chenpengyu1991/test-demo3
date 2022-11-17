package com.founder.rhip.ehr.entity.message;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "MSG_SENT_INFO")
public class MessageSent implements Serializable {

	private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID", columnDefinition = "NUMBER|消息ID|11|", length = 11, nullable = false)
    private Long id;

    @Column(name = "TITLE", columnDefinition = "VARCHAR2|主题|50|", length = 50, nullable = true)
    private String title;

	@Column(name = "CONTENT", columnDefinition = "VARCHAR2|消息内容|1000|", length = 1000, nullable = true)
	private String content;

	@Column(name = "RECEIVING_UNIT", columnDefinition = "VARCHAR2|接受单位|50|", length = 50, nullable = true)
	private String receivingUnit;

	@Column(name = "CREATE_ORGAN_CODE", columnDefinition = "VARCHAR2|创建机构编码|50|", length = 50, nullable = true)
	private String createOrganCode;

    @Column(name = "CREATE_USER_CODE", columnDefinition = "VARCHAR2|创建操作人|50|", length = 50, nullable = true)
    private String createUserCode;

    @Column(name = "CREATE_DATE", columnDefinition = "DATE|创建时间||", nullable = true)
	private Date createDate;

    @Column(name = "TYPE", columnDefinition = "VARCHAR2|类型(1: alert message 9:突发公共事件提醒)|1|", length = 1, nullable = true)
    private String type;

    @Column(name = "STATUS", columnDefinition = "VARCHAR2|状态(1: 未提醒， 2：已提醒)|1|", length = 1, nullable = true)
    private String status;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getReceivingUnit() {
        return receivingUnit;
    }

    public void setReceivingUnit(String receivingUnit) {
        this.receivingUnit = receivingUnit;
    }

    public String getCreateOrganCode() {
        return createOrganCode;
    }

    public void setCreateOrganCode(String createOrganCode) {
        this.createOrganCode = createOrganCode;
    }

    public String getCreateUserCode() {
        return createUserCode;
    }

    public void setCreateUserCode(String createUserCode) {
        this.createUserCode = createUserCode;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}