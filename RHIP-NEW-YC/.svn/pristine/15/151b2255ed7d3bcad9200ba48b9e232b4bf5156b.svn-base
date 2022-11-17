package com.founder.rhip.ehr.dto;

import java.util.Date;
import java.util.List;

import com.founder.rhip.ehr.annotation.DisplayField;
import com.founder.rhip.ehr.common.EHRConstants;
import com.founder.rhip.ehr.common.IValidateDTO;
import com.founder.rhip.ehr.common.StarType;
import com.founder.rhip.ehr.entity.basic.PersonInfo;
import com.founder.rhip.ehr.entity.basic.PersonInfoTemp;
import com.founder.rhip.ehr.entity.clinic.EHRHealthEvent;
import com.founder.rhip.ehr.entity.clinic.ExpenseInfo;
import com.founder.rhip.ehr.entity.summary.DeformityHistory;
import com.founder.rhip.ehr.entity.summary.DiseaseHistory;
import com.founder.rhip.ehr.entity.summary.DrugAllergyHistory;
import com.founder.rhip.ehr.entity.summary.ExposeHistory;
import com.founder.rhip.ehr.entity.summary.FamilyHeredityHistory;
import com.founder.rhip.ehr.entity.summary.FamilyHistory;
import com.founder.rhip.ehr.entity.summary.SurgeryHistory;
import com.founder.rhip.ehr.entity.summary.TransBloodHistory;
import com.founder.rhip.ehr.entity.summary.TraumaHistory;

public class PersonalBasicInfoDTO implements IValidateDTO {

	private static final long serialVersionUID = 1L;
	
	//个人基本信息表中基本信息
	private PersonInfo personInfo;
	
	//个人基本信息表中基本信息临时表
	private PersonInfoTemp personInfoTemp;
	
	//药物过敏史
	@DisplayField(star = StarType.TWO)
	private String drugAllergyHistoryFlag;
	
	private String drugAllergyHistoryStr;
	private List<DrugAllergyHistory> drugAllergyHistoryList;

	//药物过敏史选择其它时
	private String drugAllergyHistoryOtherDesc;
	
	//暴露史
	private String exposeHistoryFlag;
	
	private ExposeHistory exposeHistory;
	
	//既往疾病史
	@DisplayField(star = StarType.TWO)
	private String diseaseHistoryFlag;
	
	private List<DiseaseHistory> diseaseHistoryList;
	
	//既往手术史
	@DisplayField(star = StarType.TWO)
	private String surgeryHistoryFlag;
	
	private List<SurgeryHistory> surgeryHistoryList;
	
	//外伤史
	@DisplayField(star = StarType.TWO)
	private String traumaHistoryFlag;
	
	private List<TraumaHistory> traumaHistoryList;
	
	//输血史
	@DisplayField(star = StarType.TWO)
	private String transBloodHistoryFlag;
	
	private List<TransBloodHistory> transBloodHistoryList;
	
	//家族史代码，逗号分隔
	private String familyHistoryStr;
	//家族史
	private List<FamilyHistory> familyHistoryList;
	
	@DisplayField(star = StarType.TWO)
	private String fatherFlag;
	
	private String fatherStr;

	private String fatherStrDesc;
	
	@DisplayField(star = StarType.TWO)
	private String motherFlag;
	
	private String motherStr;

	private String motherStrDesc;

	@DisplayField(star = StarType.TWO)
	private String brotherFlag;
	
	private String brotherStr;

	private String brotherStrDesc;
	
	@DisplayField(star = StarType.TWO)
	private String childFlag;
	
	private String childStr;

	private String childStrDesc;
	
	//家族遗传病史标识
	@DisplayField(star = StarType.TWO)
	private String familyHeredityHistoryFlag;
	
	//家族遗传病史
	private List<FamilyHeredityHistory> familyHeredityHistoryList;
	
	//残疾史
	private String deformityFlag;
	
	private DeformityHistory deformityHistory;
	
	//费用支付方式代码，逗号分隔
	@DisplayField(star = StarType.TWO)
	private String expenseInfoStr;
	
	//费用支付方式表
	private List<ExpenseInfo> expenseInfoList;
	
	//个人基本信息表事件
	private EHRHealthEvent ehrHeathEvent;
	
	//修改人与修改机构
	private String modifyInputerId;
	private String modifyInputName;
	private String modifyInputOrg;
	private String modifyInputOrganCode;
	
	//疾病史
	private String gxy;
	private Date gxyDate;
	private String tnb;
	private Date tnbDate;
	private String gxb;
	private Date gxbDate;
	private String fjb;
	private Date fjbDate;
	private String exzl;
	private String exzlName;//add by yejianfei 20180412 恶性肿瘤具体名称
	private Date exzlDate;
	private String nzz;
	private Date nzzDate;
	private String zxjsb;
	private Date zxjsbDate;
	private String jhb;
	private Date jhbDate;
	private String gy;
	private Date gyDate;
	private String xtjx;
	private Date xtjxDate;
	private String qt;
	private String qtxx;
	private Date qtDate;
	private String qtidm;
	private Date qtidmDate;
	private String zyb;
	private String zybName;//add by yejianfei 20180412 职业病具体名称
	private Date zybDate;
	
	public String getSurgeryHistoryFlag() {
		return surgeryHistoryFlag  == null ? EHRConstants.UN_HAVE : surgeryHistoryFlag;
	}

	public void setSurgeryHistoryFlag(String surgeryHistoryFlag) {
		this.surgeryHistoryFlag = surgeryHistoryFlag;
	}

	public String getTraumaHistoryFlag() {
		return traumaHistoryFlag  == null ? EHRConstants.UN_HAVE : traumaHistoryFlag;
	}

	public void setTraumaHistoryFlag(String traumaHistoryFlag) {
		this.traumaHistoryFlag = traumaHistoryFlag;
	}

	public String getTransBloodHistoryFlag() {
		return transBloodHistoryFlag  == null ? EHRConstants.UN_HAVE : transBloodHistoryFlag;
	}

	public void setTransBloodHistoryFlag(String transBloodHistoryFlag) {
		this.transBloodHistoryFlag = transBloodHistoryFlag;
	}

	public String getExposeHistoryFlag() {
		return exposeHistoryFlag  == null ? EHRConstants.UN_HAVE : exposeHistoryFlag;
	}

	public void setExposeHistoryFlag(String exposeHistoryFlag) {
		this.exposeHistoryFlag = exposeHistoryFlag;
	}

	public String getDrugAllergyHistoryFlag() {
		return drugAllergyHistoryFlag == null ? EHRConstants.UN_HAVE : drugAllergyHistoryFlag;
	}

	public void setDrugAllergyHistoryFlag(String drugAllergyHistoryFlag) {
		this.drugAllergyHistoryFlag = drugAllergyHistoryFlag;
	}

	public String getDrugAllergyHistoryStr() {
		return drugAllergyHistoryStr;
	}

	public String getDeformityFlag() {
		return deformityFlag == null ? EHRConstants.UN_HAVE : deformityFlag;
	}

	public void setDeformityFlag(String deformityFlag) {
		this.deformityFlag = deformityFlag;
	}

	public void setDrugAllergyHistoryStr(String drugAllergyHistoryStr) {
		this.drugAllergyHistoryStr = drugAllergyHistoryStr;
	}

	public String getFamilyHistoryStr() {
		return familyHistoryStr;
	}

	public void setFamilyHistoryStr(String familyHistoryStr) {
		this.familyHistoryStr = familyHistoryStr;
	}

	public String getExpenseInfoStr() {
		return expenseInfoStr;
	}

	public void setExpenseInfoStr(String expenseInfoStr) {
		this.expenseInfoStr = expenseInfoStr;
	}

	public PersonInfo getPersonInfo() {
		return personInfo;
	}

	public void setPersonInfo(PersonInfo personInfo) {
		this.personInfo = personInfo;
	}

	public List<DiseaseHistory> getDiseaseHistoryList() {
		return diseaseHistoryList;
	}

	public void setDiseaseHistoryList(List<DiseaseHistory> diseaseHistoryList) {
		this.diseaseHistoryList = diseaseHistoryList;
	}

	public List<SurgeryHistory> getSurgeryHistoryList() {
		return surgeryHistoryList;
	}

	public void setSurgeryHistoryList(List<SurgeryHistory> surgeryHistoryList) {
		this.surgeryHistoryList = surgeryHistoryList;
	}

	public List<TraumaHistory> getTraumaHistoryList() {
		return traumaHistoryList;
	}

	public void setTraumaHistoryList(List<TraumaHistory> traumaHistoryList) {
		this.traumaHistoryList = traumaHistoryList;
	}

	public List<TransBloodHistory> getTransBloodHistoryList() {
		return transBloodHistoryList;
	}

	public void setTransBloodHistoryList(
			List<TransBloodHistory> transBloodHistoryList) {
		this.transBloodHistoryList = transBloodHistoryList;
	}

	public List<FamilyHistory> getFamilyHistoryList() {
		return familyHistoryList;
	}

	public void setFamilyHistoryList(List<FamilyHistory> familyHistoryList) {
		this.familyHistoryList = familyHistoryList;
	}

	public List<FamilyHeredityHistory> getFamilyHeredityHistoryList() {
		return familyHeredityHistoryList;
	}

	public void setFamilyHeredityHistoryList(
			List<FamilyHeredityHistory> familyHeredityHistoryList) {
		this.familyHeredityHistoryList = familyHeredityHistoryList;
	}

	public List<ExpenseInfo> getExpenseInfoList() {
		return expenseInfoList;
	}

	public void setExpenseInfoList(List<ExpenseInfo> expenseInfoList) {
		this.expenseInfoList = expenseInfoList;
	}

	public List<DrugAllergyHistory> getDrugAllergyHistoryList() {
		return drugAllergyHistoryList;
	}

	public void setDrugAllergyHistoryList(
			List<DrugAllergyHistory> drugAllergyHistoryList) {
		this.drugAllergyHistoryList = drugAllergyHistoryList;
	}

	public DeformityHistory getDeformityHistory() {
		return deformityHistory;
	}

	public void setDeformityHistory(DeformityHistory deformityHistory) {
		this.deformityHistory = deformityHistory;
	}

	public EHRHealthEvent getEhrHeathEvent() {
		return ehrHeathEvent;
	}

	public void setEhrHeathEvent(EHRHealthEvent ehrHeathEvent) {
		this.ehrHeathEvent = ehrHeathEvent;
	}

	public ExposeHistory getExposeHistory() {
		return exposeHistory;
	}

	public void setExposeHistory(ExposeHistory exposeHistory) {
		this.exposeHistory = exposeHistory;
	}

	public String getDiseaseHistoryFlag() {
		return diseaseHistoryFlag == null ? EHRConstants.UN_HAVE : diseaseHistoryFlag;
	}

	public void setDiseaseHistoryFlag(String diseaseHistoryFlag) {
		this.diseaseHistoryFlag = diseaseHistoryFlag;
	}

	public String getGxy() {
		return gxy;
	}

	public void setGxy(String gxy) {
		this.gxy = gxy;
	}

	public Date getGxyDate() {
		return gxyDate;
	}

	public void setGxyDate(Date gxyDate) {
		this.gxyDate = gxyDate;
	}

	public String getTnb() {
		return tnb;
	}

	public void setTnb(String tnb) {
		this.tnb = tnb;
	}

	public Date getTnbDate() {
		return tnbDate;
	}

	public void setTnbDate(Date tnbDate) {
		this.tnbDate = tnbDate;
	}

	public String getGxb() {
		return gxb;
	}

	public void setGxb(String gxb) {
		this.gxb = gxb;
	}

	public Date getGxbDate() {
		return gxbDate;
	}

	public void setGxbDate(Date gxbDate) {
		this.gxbDate = gxbDate;
	}

	public String getFjb() {
		return fjb;
	}

	public void setFjb(String fjb) {
		this.fjb = fjb;
	}

	public Date getFjbDate() {
		return fjbDate;
	}

	public void setFjbDate(Date fjbDate) {
		this.fjbDate = fjbDate;
	}

	public String getExzl() {
		return exzl;
	}

	public void setExzl(String exzl) {
		this.exzl = exzl;
	}

	public String getExzlName() {
		return exzlName;
	}

	public void setExzlName(String exzlName) {
		this.exzlName = exzlName;
	}
	public Date getExzlDate() {
		return exzlDate;
	}

	public void setExzlDate(Date exzlDate) {
		this.exzlDate = exzlDate;
	}

	public String getNzz() {
		return nzz;
	}

	public void setNzz(String nzz) {
		this.nzz = nzz;
	}

	public Date getNzzDate() {
		return nzzDate;
	}

	public void setNzzDate(Date nzzDate) {
		this.nzzDate = nzzDate;
	}

	public String getZxjsb() {
		return zxjsb;
	}

	public void setZxjsb(String zxjsb) {
		this.zxjsb = zxjsb;
	}

	public Date getZxjsbDate() {
		return zxjsbDate;
	}

	public void setZxjsbDate(Date zxjsbDate) {
		this.zxjsbDate = zxjsbDate;
	}

	public String getJhb() {
		return jhb;
	}

	public void setJhb(String jhb) {
		this.jhb = jhb;
	}

	public Date getJhbDate() {
		return jhbDate;
	}

	public void setJhbDate(Date jhbDate) {
		this.jhbDate = jhbDate;
	}

	public String getGy() {
		return gy;
	}

	public void setGy(String gy) {
		this.gy = gy;
	}

	public Date getGyDate() {
		return gyDate;
	}

	public void setGyDate(Date gyDate) {
		this.gyDate = gyDate;
	}

	public String getXtjx() {
		return xtjx;
	}

	public void setXtjx(String xtjx) {
		this.xtjx = xtjx;
	}

	public Date getXtjxDate() {
		return xtjxDate;
	}

	public void setXtjxDate(Date xtjxDate) {
		this.xtjxDate = xtjxDate;
	}

	public String getQt() {
		return qt;
	}

	public void setQt(String qt) {
		this.qt = qt;
	}

	public String getQtxx() {
		return qtxx;
	}

	public void setQtxx(String qtxx) {
		this.qtxx = qtxx;
	}

	public Date getQtDate() {
		return qtDate;
	}

	public void setQtDate(Date qtDate) {
		this.qtDate = qtDate;
	}

	public String getQtidm() {
		return qtidm;
	}

	public void setQtidm(String qtidm) {
		this.qtidm = qtidm;
	}

	public Date getQtidmDate() {
		return qtidmDate;
	}

	public void setQtidmDate(Date qtidmDate) {
		this.qtidmDate = qtidmDate;
	}

	public String getZyb() {
		return zyb;
	}

	public void setZyb(String zyb) {
		this.zyb = zyb;
	}

	public Date getZybDate() {
		return zybDate;
	}

	public void setZybDate(Date zybDate) {
		this.zybDate = zybDate;
	}

	public String getFatherFlag() {
		return fatherFlag == null ? EHRConstants.UN_HAVE : fatherFlag;
	}

	public void setFatherFlag(String fatherFlag) {
		this.fatherFlag = fatherFlag;
	}

	public String getFatherStr() {
		return fatherStr;
	}

	public void setFatherStr(String fatherStr) {
		this.fatherStr = fatherStr;
	}

	public String getMotherFlag() {
		return motherFlag == null ? EHRConstants.UN_HAVE : motherFlag;
	}

	public void setMotherFlag(String motherFlag) {
		this.motherFlag = motherFlag;
	}

	public String getMotherStr() {
		return motherStr;
	}

	public void setMotherStr(String motherStr) {
		this.motherStr = motherStr;
	}

	public String getBrotherFlag() {
		return brotherFlag == null ? EHRConstants.UN_HAVE : brotherFlag;
	}

	public void setBrotherFlag(String brotherFlag) {
		this.brotherFlag = brotherFlag;
	}

	public String getBrotherStr() {
		return brotherStr;
	}

	public void setBrotherStr(String brotherStr) {
		this.brotherStr = brotherStr;
	}

	public String getChildFlag() {
		return childFlag == null ? EHRConstants.UN_HAVE : childFlag;
	}

	public void setChildFlag(String childFlag) {
		this.childFlag = childFlag;
	}

	public String getChildStr() {
		return childStr;
	}

	public void setChildStr(String childStr) {
		this.childStr = childStr;
	}

	public String getFamilyHeredityHistoryFlag() {
		return familyHeredityHistoryFlag == null ? EHRConstants.UN_HAVE : familyHeredityHistoryFlag;
	}

	public void setFamilyHeredityHistoryFlag(String familyHeredityHistoryFlag) {
		this.familyHeredityHistoryFlag = familyHeredityHistoryFlag;
	}
	
	public String getModifyInputName() {
		return modifyInputName;
	}

	public void setModifyInputName(String modifyInputName) {
		this.modifyInputName = modifyInputName;
	}

	public String getModifyInputOrg() {
		return modifyInputOrg;
	}

	public void setModifyInputOrg(String modifyInputOrg) {
		this.modifyInputOrg = modifyInputOrg;
	}

	public PersonInfoTemp getPersonInfoTemp() {
		return personInfoTemp;
	}

	public void setPersonInfoTemp(PersonInfoTemp personInfoTemp) {
		this.personInfoTemp = personInfoTemp;
	}

	public String getModifyInputerId() {
		return modifyInputerId;
	}

	public void setModifyInputerId(String modifyInputerId) {
		this.modifyInputerId = modifyInputerId;
	}

	public String getModifyInputOrganCode() {
		return modifyInputOrganCode;
	}

	public void setModifyInputOrganCode(String modifyInputOrganCode) {
		this.modifyInputOrganCode = modifyInputOrganCode;
	}

	public String getFatherStrDesc() {
		return fatherStrDesc;
	}

	public void setFatherStrDesc(String fatherStrDesc) {
		this.fatherStrDesc = fatherStrDesc;
	}

	public String getMotherStrDesc() {
		return motherStrDesc;
	}

	public void setMotherStrDesc(String motherStrDesc) {
		this.motherStrDesc = motherStrDesc;
	}

	public String getBrotherStrDesc() {
		return brotherStrDesc;
	}

	public void setBrotherStrDesc(String brotherStrDesc) {
		this.brotherStrDesc = brotherStrDesc;
	}

	public String getChildStrDesc() {
		return childStrDesc;
	}

	public void setChildStrDesc(String childStrDesc) {
		this.childStrDesc = childStrDesc;
	}

	public String getDrugAllergyHistoryOtherDesc() {
		return drugAllergyHistoryOtherDesc;
	}

	public void setDrugAllergyHistoryOtherDesc(String drugAllergyHistoryOtherDesc) {
		this.drugAllergyHistoryOtherDesc = drugAllergyHistoryOtherDesc;
	}

	public String getZybName() {
		return zybName;
	}

	public void setZybName(String zybName) {
		this.zybName = zybName;
	}
}
