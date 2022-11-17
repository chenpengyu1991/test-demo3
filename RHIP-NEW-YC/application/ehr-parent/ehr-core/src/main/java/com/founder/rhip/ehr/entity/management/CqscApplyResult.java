package com.founder.rhip.ehr.entity.management;

import javax.persistence.Entity;
import java.io.Serializable;

@Entity
public class CqscApplyResult implements Serializable{
	private static final long serialVersionUID = 1;

	
	//申请单号
	private String applyId;

	//病人身份证号
	private String idCardNo;	
	
	//病人类型代码
	private String paitTypeNo;
	
	//病人类型名称
	private String paitTypeName;
	
	//病人姓名
	private String paitName;
	
	//病人性别
	private String paitSex;
	
	//病人出生日期
	private String birthDay;
	
	//病人体重
	private String patiWeight;
	
	//病人通讯地址
	private String address;
	
	//病人联系电话
	private String phone;
	
	//保健号
	private String healthNo;
	
	//临床诊断
	private String clinicalDiag;
	
	//末次月经日
	private String lmpDate;
	
	//孕周天数
	private String pregWeekDay;
	
	//确定孕周方法
	private String pregWeekMethoo;

	//申请日期
	private String applyDate;
	
	//送检医生编号
	private String receOperNo;
	
	//送检医生姓名
	private String receOperName;
	
	//送检日期
	private String receDate;
	
	//申请单状态
	private String status;
	
	//标本编号
	private String sampNo;
	
	//标本类型
	private String sampType;
	
	//预产年龄
	private String perProdAge;
	
	//特别提醒代码
	private String remindNos;
	
	//特别提醒内容
	private String remindNames;
	
	//检验者代码
	private String testOperNo;
	
	//检验者姓名
	private String testOperName;
	
	//检验时间
	private String testTime;
	
	//诊断项目
	private String itemCode;
	
	//诊断方法
	private String itemName;
	
	//诊断结果
	private String result;

	public String getApplyId() {
		return applyId;
	}

	public void setApplyId(String applyId) {
		this.applyId = applyId;
	}

	public String getIdCardNo() {
		return idCardNo;
	}

	public void setIdCardNo(String idCardNo) {
		this.idCardNo = idCardNo;
	}

	public String getPaitTypeNo() {
		return paitTypeNo;
	}

	public void setPaitTypeNo(String paitTypeNo) {
		this.paitTypeNo = paitTypeNo;
	}

	public String getPaitTypeName() {
		return paitTypeName;
	}

	public void setPaitTypeName(String paitTypeName) {
		this.paitTypeName = paitTypeName;
	}

	public String getPaitName() {
		return paitName;
	}

	public void setPaitName(String paitName) {
		this.paitName = paitName;
	}

	public String getPaitSex() {
		return paitSex;
	}

	public void setPaitSex(String paitSex) {
		this.paitSex = paitSex;
	}

	public String getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}

	public String getPatiWeight() {
		return patiWeight;
	}

	public void setPatiWeight(String patiWeight) {
		this.patiWeight = patiWeight;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getHealthNo() {
		return healthNo;
	}

	public void setHealthNo(String healthNo) {
		this.healthNo = healthNo;
	}

	public String getClinicalDiag() {
		return clinicalDiag;
	}

	public void setClinicalDiag(String clinicalDiag) {
		this.clinicalDiag = clinicalDiag;
	}

	public String getLmpDate() {
		return lmpDate;
	}

	public void setLmpDate(String lmpDate) {
		this.lmpDate = lmpDate;
	}

	public String getPregWeekDay() {
		return pregWeekDay;
	}

	public void setPregWeekDay(String pregWeekDay) {
		this.pregWeekDay = pregWeekDay;
	}

	public String getPregWeekMethoo() {
		return pregWeekMethoo;
	}

	public void setPregWeekMethoo(String pregWeekMethoo) {
		this.pregWeekMethoo = pregWeekMethoo;
	}

	public String getApplyDate() {
		return applyDate;
	}

	public void setApplyDate(String applyDate) {
		this.applyDate = applyDate;
	}

	public String getReceOperNo() {
		return receOperNo;
	}

	public void setReceOperNo(String receOperNo) {
		this.receOperNo = receOperNo;
	}

	public String getReceOperName() {
		return receOperName;
	}

	public void setReceOperName(String receOperName) {
		this.receOperName = receOperName;
	}

	public String getReceDate() {
		return receDate;
	}

	public void setReceDate(String receDate) {
		this.receDate = receDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSampNo() {
		return sampNo;
	}

	public void setSampNo(String sampNo) {
		this.sampNo = sampNo;
	}

	public String getSampType() {
		return sampType;
	}

	public void setSampType(String sampType) {
		this.sampType = sampType;
	}

	public String getPerProdAge() {
		return perProdAge;
	}

	public void setPerProdAge(String perProdAge) {
		this.perProdAge = perProdAge;
	}

	public String getRemindNos() {
		return remindNos;
	}

	public void setRemindNos(String remindNos) {
		this.remindNos = remindNos;
	}

	public String getRemindNames() {
		return remindNames;
	}

	public void setRemindNames(String remindNames) {
		this.remindNames = remindNames;
	}

	public String getTestOperNo() {
		return testOperNo;
	}

	public void setTestOperNo(String testOperNo) {
		this.testOperNo = testOperNo;
	}

	public String getTestOperName() {
		return testOperName;
	}

	public void setTestOperName(String testOperName) {
		this.testOperName = testOperName;
	}

	public String getTestTime() {
		return testTime;
	}

	public void setTestTime(String testTime) {
		this.testTime = testTime;
	}

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
	
}
