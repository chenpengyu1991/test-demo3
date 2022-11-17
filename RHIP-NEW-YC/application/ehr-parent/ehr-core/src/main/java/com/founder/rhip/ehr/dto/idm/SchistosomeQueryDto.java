package com.founder.rhip.ehr.dto.idm;

/*
 * 血吸虫专项Dto
 */

import java.io.Serializable;
import java.util.Date;

public class SchistosomeQueryDto implements Serializable {

    private static final long serialVersionUID = 1L;

    /*姓名*/
    private String name;
    
    /*性别*/
    private String gender;    

    /*年龄*/
    private String age; 
    
    /*联系电话*/
    private String phoneNumber; 
    
    /*血检结果*/
    private String testResult;
    
    /*身份证号码*/
    private String idcard;
    
    /*现居住地乡街道*/
    private String patownShip;   
    
    /*现居住地村社区*/
    private String pastreet; 
    
    /*现居住地门牌号*/
    private String pahouseNumber;

    /*现居住地详细地址*/
    private String paAddress;

    //户口所在地乡街道
    private String hrtownShip;

    //户口所在地村社区
    private String hrhouseNumber;

    //户口所在地门牌号
    private String hrstreet;
 
    /*户口所在地详细地址*/
    private String hrAddress;
    
    /*诊断分期*/
    private String treatment;
 
    /*标本来源*/
    private String sampleResource;
    
    /*IHA检验日期*/
    private Date ihaDt;
    
    /*IHA检验结果*/
    private String ihaCheck;    

    /*DDIA检验日期*/
    private Date ddiaDt;
    
    /*DDIA检验结果*/
    private String ddia;   
    
    /*COPT检验日期*/
    private Date coptDt;
    
    /*COPT检验结果*/
    private String copt;   
 
    /*粪检日期*/
    private Date stoolDt;
    
    /*粪检结果*/
    private String stool;  
    
    /*已建立晚血调查*/
    private String sid;
    /*已建立晚血管理卡*/    
    private String cid;
    /*已建立复查登记*/    
    private String rid;

    /*已建立个案调查*/    
    private String caseId;
    
     /*业务表唯一标识*/
    private String singleId;

    /*状态表唯一标识*/
    private String idmId;
    
    /*业务表-专项类别*/
    private String idmType;
    
    /*业务表-专项状态*/
    private String specialStatus;
    
    /*注销状态*/
    private String logoff;    
    
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	
	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	
	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	
	/**
	 * @return the age
	 */
	public String getAge() {
		return age;
	}

	
	/**
	 * @param age the age to set
	 */
	public void setAge(String age) {
		this.age = age;
	}

	
	/**
	 * @return the phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	
	/**
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	
	/**
	 * @return the testResult
	 */
	public String getTestResult() {
		return testResult;
	}

	
	/**
	 * @param testResult the testResult to set
	 */
	public void setTestResult(String testResult) {
		this.testResult = testResult;
	}

	
	/**
	 * @return the patownShip
	 */
	public String getPatownShip() {
		return patownShip;
	}

	
	/**
	 * @param patownShip the patownShip to set
	 */
	public void setPatownShip(String patownShip) {
		this.patownShip = patownShip;
	}

	
	/**
	 * @return the pastreet
	 */
	public String getPastreet() {
		return pastreet;
	}

	
	/**
	 * @param pastreet the pastreet to set
	 */
	public void setPastreet(String pastreet) {
		this.pastreet = pastreet;
	}

	
	/**
	 * @return the pahomeNumber
	 */
	public String getPahouseNumber() {
		return pahouseNumber;
	}

	
	/**
	 * @param pahouseNumber the pahomeNumber to set
	 */
	public void setPahouseNumber(String pahouseNumber) {
		this.pahouseNumber = pahouseNumber;
	}

	
	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

    public String getSingleId() {
        return singleId;
    }

    public void setSingleId(String singleId) {
        this.singleId = singleId;
    }


	/**
	 * @return the idmId
	 */
	public String getIdmId() {
		return idmId;
	}


	/**
	 * @param idmId the idmId to set
	 */
	public void setIdmId(String idmId) {
		this.idmId = idmId;
	}


	/**
	 * @return the idcard
	 */
	public String getIdcard() {
		return idcard;
	}


	/**
	 * @param idcard the idcard to set
	 */
	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

    public String getHrtownShip() {
        return hrtownShip;
    }

    public void setHrtownShip(String hrtownShip) {
        this.hrtownShip = hrtownShip;
    }

    public String getHrhouseNumber() {
        return hrhouseNumber;
    }

    public void setHrhouseNumber(String hrhouseNumber) {
        this.hrhouseNumber = hrhouseNumber;
    }

    public String getHrstreet() {
        return hrstreet;
    }

    public void setHrstreet(String hrstreet) {
        this.hrstreet = hrstreet;
    }


	/**
	 * @return the treatment
	 */
	public String getTreatment() {
		return treatment;
	}


	/**
	 * @param treatment the treatment to set
	 */
	public void setTreatment(String treatment) {
		this.treatment = treatment;
	}


	/**
	 * @return the idmType
	 */
	public String getIdmType() {
		return idmType;
	}


	/**
	 * @param idmType the idmType to set
	 */
	public void setIdmType(String idmType) {
		this.idmType = idmType;
	}


	/**
	 * @return the sid
	 */
	public String getSid() {
		return sid;
	}


	/**
	 * @param sid the sid to set
	 */
	public void setSid(String sid) {
		this.sid = sid;
	}


	/**
	 * @return the cid
	 */
	public String getCid() {
		return cid;
	}


	/**
	 * @param cid the cid to set
	 */
	public void setCid(String cid) {
		this.cid = cid;
	}


	/**
	 * @return the rid
	 */
	public String getRid() {
		return rid;
	}


	/**
	 * @param rid the rid to set
	 */
	public void setRid(String rid) {
		this.rid = rid;
	}


	/**
	 * @return the specialStatus
	 */
	public String getSpecialStatus() {
		return specialStatus;
	}


	/**
	 * @param specialStatus the specialStatus to set
	 */
	public void setSpecialStatus(String specialStatus) {
		this.specialStatus = specialStatus;
	}


	/**
	 * @return the sampleResource
	 */
	public String getSampleResource() {
		return sampleResource;
	}


	/**
	 * @param sampleResource the sampleResource to set
	 */
	public void setSampleResource(String sampleResource) {
		this.sampleResource = sampleResource;
	}


	/**
	 * @return the ihaDt
	 */
	public Date getIhaDt() {
		return ihaDt;
	}


	/**
	 * @param ihaDt the ihaDt to set
	 */
	public void setIhaDt(Date ihaDt) {
		this.ihaDt = ihaDt;
	}


	/**
	 * @return the ihaCheck
	 */
	public String getIhaCheck() {
		return ihaCheck;
	}


	/**
	 * @param ihaCheck the ihaCheck to set
	 */
	public void setIhaCheck(String ihaCheck) {
		this.ihaCheck = ihaCheck;
	}


	/**
	 * @return the ddiaDt
	 */
	public Date getDdiaDt() {
		return ddiaDt;
	}


	/**
	 * @param ddiaDt the ddiaDt to set
	 */
	public void setDdiaDt(Date ddiaDt) {
		this.ddiaDt = ddiaDt;
	}


	/**
	 * @return the ddia
	 */
	public String getDdia() {
		return ddia;
	}


	/**
	 * @param ddia the ddia to set
	 */
	public void setDdia(String ddia) {
		this.ddia = ddia;
	}


	/**
	 * @return the coptDt
	 */
	public Date getCoptDt() {
		return coptDt;
	}


	/**
	 * @param coptDt the coptDt to set
	 */
	public void setCoptDt(Date coptDt) {
		this.coptDt = coptDt;
	}


	/**
	 * @return the copt
	 */
	public String getCopt() {
		return copt;
	}


	/**
	 * @param copt the copt to set
	 */
	public void setCopt(String copt) {
		this.copt = copt;
	}


	/**
	 * @return the stoolDt
	 */
	public Date getStoolDt() {
		return stoolDt;
	}


	/**
	 * @param stoolDt the stoolDt to set
	 */
	public void setStoolDt(Date stoolDt) {
		this.stoolDt = stoolDt;
	}


	/**
	 * @return the stool
	 */
	public String getStool() {
		return stool;
	}


	/**
	 * @param stool the stool to set
	 */
	public void setStool(String stool) {
		this.stool = stool;
	}


	/**
	 * @return the caseId
	 */
	public String getCaseId() {
		return caseId;
	}


	/**
	 * @param caseId the caseId to set
	 */
	public void setCaseId(String caseId) {
		this.caseId = caseId;
	}


	/**
	 * @return the paAddress
	 */
	public String getPaAddress() {
		return paAddress;
	}


	/**
	 * @param paAddress the paAddress to set
	 */
	public void setPaAddress(String paAddress) {
		this.paAddress = paAddress;
	}


	/**
	 * @return the hrAddress
	 */
	public String getHrAddress() {
		return hrAddress;
	}


	/**
	 * @param hrAddress the hrAddress to set
	 */
	public void setHrAddress(String hrAddress) {
		this.hrAddress = hrAddress;
	}


	public String getLogoff() {
		return logoff;
	}


	public void setLogoff(String logoff) {
		this.logoff = logoff;
	}
}