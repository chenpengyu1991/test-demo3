package com.founder.rhip.ehr.entity.message;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "MSG_RECEIVED_INFO")
public class ReceivedInfo implements Serializable {

	private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID", columnDefinition = "NUMBER|ID|11|", length = 11, nullable = false)
    private Long id;

	@Column(name = "MESSAGE_ID", columnDefinition = "NUMBER|消息ID|11|", length = 11, nullable = false)
	private String messageId;

    @Column(name = "TITLE", columnDefinition = "VARCHAR2|主题|50|", length = 50, nullable = false)
    private String title;

    @Column(name = "RECEIVING_UNIT", columnDefinition = "VARCHAR2|接受单位|50|", length = 50, nullable = false)
    private String receivingUnit;

	@Column(name = "RECIPIENT", columnDefinition = "VARCHAR2|接收人|50|", length = 50, nullable = false)
	private String recipient;

    @Column(name = "STATUS", columnDefinition = "CHAR|接受状态（0：未结算 1：已接受）|1|", length = 1, nullable = false)
    private String status;

    @Column(name = "CREATE_ORGAN_CODE", columnDefinition = "VARCHAR2|创建操作人|50|", length = 50, nullable = true)
	private String createOrganCode;

    @Column(name = "CREATE_USER_CODE", columnDefinition = "VARCHAR2|创建机构编码|50|", length = 50, nullable = true)
    private String createUserCode;

    @Column(name = "CREATE_DATE", columnDefinition = "DATE|创建时间||", nullable = true)
	private Date createDate;

    @Column(name = "RECEIVE_DATE", columnDefinition = "DATE|接受时间||", nullable = true)
    private Date receiveDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public Date getReceiveDate() {
        return receiveDate;
    }

    public void setReceiveDate(Date receiveDate) {
        this.receiveDate = receiveDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getReceivingUnit() {
        return receivingUnit;
    }

    public void setReceivingUnit(String receivingUnit) {
        this.receivingUnit = receivingUnit;
    }
}