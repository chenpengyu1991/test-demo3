package com.founder.rhip.ehr.entity.control.idm.notifiabledisease;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.lang.StringUtils;

@Entity
@Table(name = "IDM_LIST_LE")
public class ListLe implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|数据库唯一编号（自增长）||", length = 11, nullable = true)
	private Integer id;

	@Column(name = "IDM_ID", columnDefinition = "NUMBER|||", length = 11, nullable = true)
	private Integer idmId;

	@Column(name = "SAMPLE_ID", columnDefinition = "VARCHAR2|采集标本||", length = 2, nullable = true)
	private String sampleId;

	@Column(name = "CHECK_ITEM", columnDefinition = "VARCHAR2|检查项目||", length = 2, nullable = true)
	private String checkItem;

	@Column(name = "SAMPLE_DY_FIRST", columnDefinition = "DATE|首次采样时间||", nullable = true)
	private Date sampleDyFirst;

	@Column(name = "SAMPLE_RESULT_FIRST", columnDefinition = "VARCHAR2|首次检查结果||", length = 100, nullable = true)
	private String sampleResultFirst;

	@Column(name = "SAMPLE_DY_SECOND", columnDefinition = "DATE|第二次采样时间||", nullable = true)
	private Date sampleDySecond;

	@Column(name = "SAMPLE_RESULT_SECOND", columnDefinition = "VARCHAR2|第二次检查结果||", length = 100, nullable = true)
	private String sampleResultSecond;

	@Column(name = "CHECK_FT", columnDefinition = "DATE|送检时间||", nullable = true)
	private Date checkFt;

	@Column(name = "CHECK_RESULT", columnDefinition = "VARCHAR2|检验结果||", length = 100, nullable = true)
	private String checkResult;

	@Column(name = "WBC_SAMPLE_DT", columnDefinition = "DATE|血白细胞采样时间||", nullable = true)
	private Date wbcSampleDt;

	@Column(name = "WBC_SAMPLE_RESULT", columnDefinition = "VARCHAR2|血白细胞结果||", length = 100, nullable = true)
	private String wbcSampleResult;

	@Column(name = "TS_SMEAR_DT", columnDefinition = "DATE|咽拭子涂片镜检采样时间||", nullable = true)
	private Date tsSmearDt;

	@Column(name = "TS_SMEAR_RESULT", columnDefinition = "VARCHAR2|咽拭子涂片镜检结果||", length = 100, nullable = true)
	private String tsSmearResult;

	@Column(name = "TS_CULTURE_DT", columnDefinition = "DATE|咽拭子菌培养采样时间||", nullable = true)
	private Date tsCultureDt;

	@Column(name = "TS_CULTURE_RESULT", columnDefinition = "VARCHAR2|咽拭子菌培养结果||", length = 100, nullable = true)
	private String tsCultureResult;

	@Column(name = "CD_SAMPLE_DT", columnDefinition = "DATE|白喉杆菌毒力试验采样时间||", nullable = true)
	private Date cdSampleDt;

	@Column(name = "CD_SAMPLE_RESULT", columnDefinition = "VARCHAR2|白喉杆菌毒力试验结果||", length = 100, nullable = true)
	private String cdSampleResult;

	@Column(name = "OTHER_DT", columnDefinition = "DATE|其他采样时间||", nullable = true)
	private Date otherDt;

	@Column(name = "OTHER_RESULT", columnDefinition = "VARCHAR2|其他结果||", length = 100, nullable = true)
	private String otherResult;

	@Column(name = "CULTURE_DT", columnDefinition = "DATE|培养时间||", nullable = true)
	private Date cultureDt;

	@Column(name = "BLOOD", columnDefinition = "VARCHAR2|血||", length = 100, nullable = true)
	private String blood;

	@Column(name = "DUNG", columnDefinition = "VARCHAR2|粪||", length = 100, nullable = true)
	private String dung;

	@Column(name = "URINE", columnDefinition = "VARCHAR2|尿||", length = 100, nullable = true)
	private String urine;

	@Column(name = "OTHER", columnDefinition = "VARCHAR2|其他||", length = 200, nullable = true)
	private String other;

	@Column(name = "GRUBERS_REACTION_DT", columnDefinition = "DATE|肥达氏反应日期||", nullable = true)
	private Date grubersReactionDt;

	@Column(name = "O", columnDefinition = "VARCHAR2|O||", length = 100, nullable = true)
	private String o;

	@Column(name = "H", columnDefinition = "VARCHAR2|H||", length = 100, nullable = true)
	private String h;

	@Column(name = "A", columnDefinition = "VARCHAR2|A||", length = 100, nullable = true)
	private String a;

	@Column(name = "B", columnDefinition = "VARCHAR2|B||", length = 100, nullable = true)
	private String b;

	@Column(name = "C", columnDefinition = "VARCHAR2|C||", length = 100, nullable = true)
	private String c;

	@Column(name = "CELL_CATEGORY_DT", columnDefinition = "DATE|细胞计数分类日期||", nullable = true)
	private Date cellCategoryDt;

	@Column(name = "TOTALITY", columnDefinition = "VARCHAR2|总数||", length = 100, nullable = true)
	private String totality;

	@Column(name = "NEUTROPHILCELL", columnDefinition = "VARCHAR2|中性||", length = 100, nullable = true)
	private String neutrophilcell;

	@Column(name = "LYMPHOCYTE", columnDefinition = "VARCHAR2|淋巴||", length = 100, nullable = true)
	private String lymphocyte;

	@Column(name = "EOSINOPHILS", columnDefinition = "VARCHAR2|嗜酸性||", length = 100, nullable = true)
	private String eosinophils;

	@Column(name = "ROUTINE_BLOOD_TEST_DT", columnDefinition = "DATE|血常规检查时间||", nullable = true)
	private Date routineBloodTestDt;

	@Column(name = "WBC", columnDefinition = "VARCHAR2|WBC||", length = 100, nullable = true)
	private String wbc;

	@Column(name = "N", columnDefinition = "VARCHAR2|N||", length = 100, nullable = true)
	private String n;

	@Column(name = "L", columnDefinition = "VARCHAR2|L||", length = 100, nullable = true)
	private String l;

	@Column(name = "DETECTION_UNIT", columnDefinition = "VARCHAR2|检测单位||", length = 200, nullable = true)
	private String detectionUnit;

	@Column(name = "X_DT", columnDefinition = "DATE|X线检查时间||", nullable = true)
	private Date xDt;

	@Column(name = "RESULT_CONTENT", columnDefinition = "VARCHAR2|结果||", length = 100, nullable = true)
	private String resultContent;

	@Column(name = "CT_DT", columnDefinition = "DATE|CT检查时间||", nullable = true)
	private Date ctDt;

	@Column(name = "SAMPLE_TYPE", columnDefinition = "VARCHAR2|标本类型||", length = 100, nullable = true)
	private String sampleType;

	@Column(name = "COLLECT_DT", columnDefinition = "DATE|采集时间||", nullable = true)
	private Date collectDt;

	@Column(name = "LE_DT", columnDefinition = "DATE|日期||", nullable = true)
	private Date leDt;

	@Column(name = "METHOD", columnDefinition = "VARCHAR2|方法||", length = 100, nullable = true)
	private String method;

    @Column(name = "FLAG", columnDefinition = "VARCHAR2|子表标识||", length = 20, nullable = true)
    private String flag;
    
    @Column(name = "RED_BLOOD_CELL", columnDefinition = "VARCHAR2|红细胞||", length = 50, nullable = true)
    private String redBloodCell;
    @Column(name = "WHITE_BLOOD_CELL", columnDefinition = "VARCHAR2|白细胞||", length = 50, nullable = true)
    private String whiteBloodCell;
    @Column(name = "SHIGELLA", columnDefinition = "VARCHAR2|志贺||", length = 50, nullable = true)
    private String shigella;
    @Column(name = "FREUND", columnDefinition = "VARCHAR2|福氏||", length = 50, nullable = true)
    private String freund;
    @Column(name = "POWELL", columnDefinition = "VARCHAR2|鲍氏||", length = 50, nullable = true)
    private String powell;
    @Column(name = "SONNEI", columnDefinition = "VARCHAR2|宋内||", length = 50, nullable = true)
    private String sonnei;

	public String getRedBloodCell() {
		return redBloodCell;
	}

	public void setRedBloodCell(String redBloodCell) {
		this.redBloodCell = redBloodCell;
	}

	public String getWhiteBloodCell() {
		return whiteBloodCell;
	}

	public void setWhiteBloodCell(String whiteBloodCell) {
		this.whiteBloodCell = whiteBloodCell;
	}

	public String getShigella() {
		return shigella;
	}

	public void setShigella(String shigella) {
		this.shigella = shigella;
	}

	public String getFreund() {
		return freund;
	}

	public void setFreund(String freund) {
		this.freund = freund;
	}

	public String getPowell() {
		return powell;
	}

	public void setPowell(String powell) {
		this.powell = powell;
	}

	public String getSonnei() {
		return sonnei;
	}

	public void setSonnei(String sonnei) {
		this.sonnei = sonnei;
	}

	@Transient
	private String sampleStr;
	
	@Transient
	private String checkItemStr;

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdmId() {
		return this.idmId;
	}

	public void setIdmId(Integer idmId) {
		this.idmId = idmId;
	}

	public String getSampleId() {
		return this.sampleId;
	}

	public void setSampleId(String sampleId) {
		this.sampleId = sampleId;
	}

	public String getCheckItem() {
		return this.checkItem;
	}

	public void setCheckItem(String checkItem) {
		this.checkItem = checkItem;
	}

	public Date getSampleDyFirst() {
		return this.sampleDyFirst;
	}

	public void setSampleDyFirst(Date sampleDyFirst) {
		this.sampleDyFirst = sampleDyFirst;
	}

	public String getSampleResultFirst() {
		return this.sampleResultFirst;
	}

	public void setSampleResultFirst(String sampleResultFirst) {
		this.sampleResultFirst = sampleResultFirst;
	}

	public Date getSampleDySecond() {
		return this.sampleDySecond;
	}

	public void setSampleDySecond(Date sampleDySecond) {
		this.sampleDySecond = sampleDySecond;
	}

	public String getSampleResultSecond() {
		return this.sampleResultSecond;
	}

	public void setSampleResultSecond(String sampleResultSecond) {
		this.sampleResultSecond = sampleResultSecond;
	}

	public Date getCheckFt() {
		return this.checkFt;
	}

	public void setCheckFt(Date checkFt) {
		this.checkFt = checkFt;
	}

	public String getCheckResult() {
		return this.checkResult;
	}

	public void setCheckResult(String checkResult) {
		this.checkResult = checkResult;
	}

	public Date getWbcSampleDt() {
		return this.wbcSampleDt;
	}

	public void setWbcSampleDt(Date wbcSampleDt) {
		this.wbcSampleDt = wbcSampleDt;
	}

	public String getWbcSampleResult() {
		return this.wbcSampleResult;
	}

	public void setWbcSampleResult(String wbcSampleResult) {
		this.wbcSampleResult = wbcSampleResult;
	}

	public Date getTsSmearDt() {
		return this.tsSmearDt;
	}

	public void setTsSmearDt(Date tsSmearDt) {
		this.tsSmearDt = tsSmearDt;
	}

	public String getTsSmearResult() {
		return this.tsSmearResult;
	}

	public void setTsSmearResult(String tsSmearResult) {
		this.tsSmearResult = tsSmearResult;
	}

	public Date getTsCultureDt() {
		return this.tsCultureDt;
	}

	public void setTsCultureDt(Date tsCultureDt) {
		this.tsCultureDt = tsCultureDt;
	}

	public String getTsCultureResult() {
		return this.tsCultureResult;
	}

	public void setTsCultureResult(String tsCultureResult) {
		this.tsCultureResult = tsCultureResult;
	}

	public Date getCdSampleDt() {
		return this.cdSampleDt;
	}

	public void setCdSampleDt(Date cdSampleDt) {
		this.cdSampleDt = cdSampleDt;
	}

	public String getCdSampleResult() {
		return this.cdSampleResult;
	}

	public void setCdSampleResult(String cdSampleResult) {
		this.cdSampleResult = cdSampleResult;
	}

	public Date getOtherDt() {
		return this.otherDt;
	}

	public void setOtherDt(Date otherDt) {
		this.otherDt = otherDt;
	}

	public String getOtherResult() {
		return this.otherResult;
	}

	public void setOtherResult(String otherResult) {
		this.otherResult = otherResult;
	}

	public Date getCultureDt() {
		return this.cultureDt;
	}

	public void setCultureDt(Date cultureDt) {
		this.cultureDt = cultureDt;
	}

	public String getBlood() {
		return this.blood;
	}

	public void setBlood(String blood) {
		this.blood = blood;
	}

	public String getDung() {
		return this.dung;
	}

	public void setDung(String dung) {
		this.dung = dung;
	}

	public String getUrine() {
		return this.urine;
	}

	public void setUrine(String urine) {
		this.urine = urine;
	}

	public String getOther() {
		return this.other;
	}

	public void setOther(String other) {
		this.other = other;
	}

	public Date getGrubersReactionDt() {
		return this.grubersReactionDt;
	}

	public void setGrubersReactionDt(Date grubersReactionDt) {
		this.grubersReactionDt = grubersReactionDt;
	}

	public String getO() {
		return this.o;
	}

	public void setO(String o) {
		this.o = o;
	}

	public String getH() {
		return this.h;
	}

	public void setH(String h) {
		this.h = h;
	}

	public String getA() {
		return this.a;
	}

	public void setA(String a) {
		this.a = a;
	}

	public String getB() {
		return this.b;
	}

	public void setB(String b) {
		this.b = b;
	}

	public String getC() {
		return this.c;
	}

	public void setC(String c) {
		this.c = c;
	}

	public Date getCellCategoryDt() {
		return this.cellCategoryDt;
	}

	public void setCellCategoryDt(Date cellCategoryDt) {
		this.cellCategoryDt = cellCategoryDt;
	}

	public String getTotality() {
		return this.totality;
	}

	public void setTotality(String totality) {
		this.totality = totality;
	}

	public String getNeutrophilcell() {
		return this.neutrophilcell;
	}

	public void setNeutrophilcell(String neutrophilcell) {
		this.neutrophilcell = neutrophilcell;
	}

	public String getLymphocyte() {
		return this.lymphocyte;
	}

	public void setLymphocyte(String lymphocyte) {
		this.lymphocyte = lymphocyte;
	}

	public String getEosinophils() {
		return this.eosinophils;
	}

	public void setEosinophils(String eosinophils) {
		this.eosinophils = eosinophils;
	}

	public Date getRoutineBloodTestDt() {
		return this.routineBloodTestDt;
	}

	public void setRoutineBloodTestDt(Date routineBloodTestDt) {
		this.routineBloodTestDt = routineBloodTestDt;
	}

	public String getWbc() {
		return this.wbc;
	}

	public void setWbc(String wbc) {
		this.wbc = wbc;
	}

	public String getN() {
		return this.n;
	}

	public void setN(String n) {
		this.n = n;
	}

	public String getL() {
		return this.l;
	}

	public void setL(String l) {
		this.l = l;
	}

	public String getDetectionUnit() {
		return this.detectionUnit;
	}

	public void setDetectionUnit(String detectionUnit) {
		this.detectionUnit = detectionUnit;
	}

	public Date getxDt() {
		return this.xDt;
	}

	public void setxDt(Date xDt) {
		this.xDt = xDt;
	}

	public String getResultContent() {
		return this.resultContent;
	}

	public void setResultContent(String resultContent) {
		this.resultContent = resultContent;
	}

	public Date getCtDt() {
		return this.ctDt;
	}

	public void setCtDt(Date ctDt) {
		this.ctDt = ctDt;
	}

	public String getSampleType() {
		return this.sampleType;
	}

	public void setSampleType(String sampleType) {
		this.sampleType = sampleType;
	}

	public Date getCollectDt() {
		return this.collectDt;
	}

	public void setCollectDt(Date collectDt) {
		this.collectDt = collectDt;
	}

	public Date getLeDt() {
		return this.leDt;
	}

	public void setLeDt(Date leDt) {
		this.leDt = leDt;
	}

	public String getMethod() {
		return this.method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getSampleStr() {
		if (StringUtils.isNotEmpty(sampleId)) {
			switch (sampleId) {
			case "1":
				return "唾液";
			case "2":
				return "脑脊液";
			case "3":
				return "尿液";
			case "4":
				return "鼻咽洗液";
			}
		}
		return "";
	}
	
	public String getCheckItemStr() {
		if(StringUtils.isNotEmpty(checkItem)) {
			switch(checkItem){
			case "1":
				return "白细胞计数";
			case "2":
				return "血培养";
			case "3":
				return "抗体测定";
			case "4":
				return "尿常规";
			case "5":
				return "尿常规";
			case "6":
				return "脑脊液常规";
		}
	}
		return "";
	}
}