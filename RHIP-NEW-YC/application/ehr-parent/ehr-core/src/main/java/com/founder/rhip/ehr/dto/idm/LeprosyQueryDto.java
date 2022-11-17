package com.founder.rhip.ehr.dto.idm;



import java.io.Serializable;
import java.util.Date;

/**
 * 结核病列表
 * @author Jiang Haiying
 *
 */
public class LeprosyQueryDto implements Serializable {
	private static final long serialVersionUID = -8675673170121437464L;
	
	/*事件唯一Id*/
	private String singleId;
	
	/*姓名*/
    private String name;
    
    /*性别*/
    private String gender;    

    private Date birthday;
    
    /*年龄*/
    private String age; 
    
    /*身份证*/
    private String idcard; 
    
    /*联系电话*/
    private String phoneNumber; 
    
    /*现居住地乡街道*/
    private String patownShip;   
    
    /*现居住地村社区*/
    private String pastreet; 
    
    /*现居住地详细*/
    private String pahouseNumber;

    private String paAddress;
    
    private String hrAddress;
    
    /*是否流动人口*/
    private String floatPopulation;
    
    /*机构*/
    private String modifySurveyOrg;
    
    /*时间*/
    private Date modifySurveyDate;
    /*用户*/
    private String modifyRespondents;
    
    /*麻风确诊结果*/
    private String reviewResult;
    
    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPatownShip() {
		return patownShip;
	}

	public void setPatownShip(String patownShip) {
		this.patownShip = patownShip;
	}

	public String getPastreet() {
		return pastreet;
	}

	public void setPastreet(String pastreet) {
		this.pastreet = pastreet;
	}

	public String getPahouseNumber() {
		return pahouseNumber;
	}

	public void setPahouseNumber(String pahouseNumber) {
		this.pahouseNumber = pahouseNumber;
	}

	public String getIdcard() {
		return idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	public String getSingleId() {
		return singleId;
	}

	public void setSingleId(String singleId) {
		this.singleId = singleId;
	}

	public String getFloatPopulation() {
		return floatPopulation;
	}

	public void setFloatPopulation(String floatPopulation) {
		this.floatPopulation = floatPopulation;
	}

	public String getModifySurveyOrg() {
		return modifySurveyOrg;
	}

	public void setModifySurveyOrg(String modifySurveyOrg) {
		this.modifySurveyOrg = modifySurveyOrg;
	}

	public Date getModifySurveyDate() {
		return modifySurveyDate;
	}

	public void setModifySurveyDate(Date modifySurveyDate) {
		this.modifySurveyDate = modifySurveyDate;
	}

	public String getModifyRespondents() {
		return modifyRespondents;
	}

	public void setModifyRespondents(String modifyRespondents) {
		this.modifyRespondents = modifyRespondents;
	}

	public String getReviewResult() {
		return reviewResult;
	}

	public void setReviewResult(String reviewResult) {
		this.reviewResult = reviewResult;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getPaAddress() {
		return paAddress;
	}

	public void setPaAddress(String paAddress) {
		this.paAddress = paAddress;
	}

	public String getHrAddress() {
		return hrAddress;
	}

	public void setHrAddress(String hrAddress) {
		this.hrAddress = hrAddress;
	}
    
}