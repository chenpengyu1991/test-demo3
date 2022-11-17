package com.founder.rhip.cic;

import javax.persistence.Transient;
import javax.validation.constraints.Pattern;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import com.founder.rhip.ehr.validator.constraints.Idcard;


/**
 * 基础健康数据查询条件
 * 
 * 
 * @version 1.0, 2014-5-9
 * @author Ye jianfei
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "root")
public class CicHealthIn {
	/**
	 * 交易码 
	 */
	@Transient
	@NotEmpty(message="交易码为空")
	@Pattern(regexp="R106|R107")
	private String transcode;
	
	/**
	 * 身份证号码
	 */
	@Idcard(message="身份证号码非法")
	@NotEmpty(message="身份证号码为空")
	private String idcard;
	
	/**
	 * 虞城通号
	 */
	@Length(max = 20,message="虞城通号长度过长")
	private String citizenCardNo;
	
	/**
	 * 机构编码
	 */
	@NotEmpty(message="机构编码为空")
	@Length(max = 50,message="机构编码长度过长")
	private String createOrganCode;
	
	/**
	 * 机构名称
	 */
	@NotEmpty(message="机构名称为空")
	@Length(max = 100,message="机构名称长度过长")
	private String createOrganName;
	
	/**
	 * 医生code
	 */
	@NotEmpty(message="医生code为空")
	@Length(max = 50,message="医生code长度过长")
	private String createUserId;
	
	/**
	 * 医生姓名
	 */
	@NotEmpty(message="医生姓名为空")
	@Length(max = 10,message="医生姓名长度过长")
	private String createUserName;
	
	/**
	 * 市民卡写入状态
	 */
	@NotEmpty(message="市民卡写入状态为空")
	@Pattern(regexp="0|1",message="市民卡写入状态值非法")
	private String writeStatus;

	
	public String getTranscode() {
		return transcode;
	}

	
	public void setTranscode(String transcode) {
		this.transcode = transcode;
	}

	
	public String getIdcard() {
		return idcard;
	}

	
	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	
	public String getCitizenCardNo() {
		return citizenCardNo;
	}

	
	public void setCitizenCardNo(String citizenCardNo) {
		this.citizenCardNo = citizenCardNo;
	}

	
	public String getCreateOrganCode() {
		return createOrganCode;
	}

	
	public void setCreateOrganCode(String createOrganCode) {
		this.createOrganCode = createOrganCode;
	}

	
	public String getCreateOrganName() {
		return createOrganName;
	}

	
	public void setCreateOrganName(String createOrganName) {
		this.createOrganName = createOrganName;
	}

	
	public String getCreateUserId() {
		return createUserId;
	}

	
	public void setCreateUserId(String createUserId) {
		this.createUserId = createUserId;
	}

	
	public String getCreateUserName() {
		return createUserName;
	}

	
	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName;
	}


	public String getWriteStatus() {
		return writeStatus;
	}


	public void setWriteStatus(String writeStatus) {
		this.writeStatus = writeStatus;
	}
}
