package com.founder.rhip.ehr.entity.women;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name="WH_YCFBJ_CHFS")
public class WhYcfbjChfs implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID",columnDefinition="NUMBER|数据库唯一编号（自增长）|11|",length=11,nullable=true)
	private Long id;

	@Column(name="CHFSLSBH",columnDefinition="VARCHAR2|产后访视流水编号|40|",length=40,nullable=true)
	private String chfslsbh;

	@Column(name="MPI",columnDefinition="VARCHAR2|个人主索引|40|",length=40,nullable=true)
	private String mpi;

	@Column(name="JKDABH",columnDefinition="VARCHAR2|健康档案编号|50|",length=50,nullable=true)
	private String jkdabh;

	@Column(name="YCFBH",columnDefinition="VARCHAR2|孕产妇编号|40|",length=40,nullable=true)
	private String ycfbh;

	@Column(name="BCFSRQ",columnDefinition="DATE|本次访视日期||",nullable=true)
	private Date bcfsrq;

	@Column(name="XM",columnDefinition="VARCHAR2|姓名|40|",length=40,nullable=true)
	private String xm;

	@Column(name="SFFS_DM",columnDefinition="VARCHAR2|随访方式代码|50|",length=50,nullable=true)
	private String sffsDm;

	@Column(name="SFFS_MC",columnDefinition="VARCHAR2|随访方式名称|100|",length=100,nullable=true)
	private String sffsMc;

	@Column(name="SFFSQTXS",columnDefinition="VARCHAR2|随访方式其他详述|500|",length=500,nullable=true)
	private String sffsqtxs;

	@Column(name="CHDJT",columnDefinition="INTEGER|产后第几天||",nullable=true)
	private Integer chdjt;

	@Column(name="FMRQ",columnDefinition="DATE|分娩日期||",nullable=true)
	private Date fmrq;

	@Column(name="CYRQ",columnDefinition="DATE|出院日期||",nullable=true)
	private Date cyrq;

	@Column(name="YBJKQK",columnDefinition="VARCHAR2|一般健康情况|4000|",length=4000,nullable=true)
	private String ybjkqk;

	@Column(name="YBXLQK",columnDefinition="VARCHAR2|一般心理情况|4000|",length=4000,nullable=true)
	private String ybxlqk;

	@Column(name="SZY",columnDefinition="NUMBER|舒张压|8|",length=8,nullable=true)
	private BigDecimal szy;

	@Column(name="SSY",columnDefinition="NUMBER|收缩压|8|",length=8,nullable=true)
	private BigDecimal ssy;

	@Column(name="TW",columnDefinition="NUMBER|体温|8|",length=8,nullable=true)
	private BigDecimal tw;

	@Column(name="MB",columnDefinition="INTEGER|脉搏||",nullable=true)
	private Integer mb;

	@Column(name="RFQK_DM",columnDefinition="VARCHAR2|乳房情况代码|50|",length=50,nullable=true)
	private String rfqkDm;

	@Column(name="RFQK_MC",columnDefinition="VARCHAR2|乳房情况名称|100|",length=100,nullable=true)
	private String rfqkMc;

	@Column(name="RFYCXS",columnDefinition="VARCHAR2|乳房异常详述|500|",length=500,nullable=true)
	private String rfycxs;

	@Column(name="ELQK_DM",columnDefinition="VARCHAR2|恶露情况代码|50|",length=50,nullable=true)
	private String elqkDm;

	@Column(name="ELQK_MC",columnDefinition="VARCHAR2|恶露情况名称|100|",length=100,nullable=true)
	private String elqkMc;

	@Column(name="ELYCXS",columnDefinition="VARCHAR2|恶露异常详述|500|",length=500,nullable=true)
	private String elycxs;

	@Column(name="ZGQKYC_DM",columnDefinition="VARCHAR2|子宫情况异常代码|50|",length=50,nullable=true)
	private String zgqkycDm;

	@Column(name="ZGQKYC",columnDefinition="VARCHAR2|子宫情况异常|100|",length=100,nullable=true)
	private String zgqkyc;

	@Column(name="ZGYCXS",columnDefinition="VARCHAR2|子宫异常详述|500|",length=500,nullable=true)
	private String zgycxs;

	@Column(name="SKQK_DM",columnDefinition="VARCHAR2|伤口情况代码|50|",length=50,nullable=true)
	private String skqkDm;

	@Column(name="SKQK_MC",columnDefinition="VARCHAR2|伤口情况名称|100|",length=100,nullable=true)
	private String skqkMc;

	@Column(name="SKYCXS",columnDefinition="VARCHAR2|伤口异常详述|500|",length=500,nullable=true)
	private String skycxs;

	@Column(name="QTYCXS",columnDefinition="VARCHAR2|其他异常详述|4000|",length=4000,nullable=true)
	private String qtycxs;

	@Column(name="BCSFFL_DM",columnDefinition="VARCHAR2|本次随访分类代码|50|",length=50,nullable=true)
	private String bcsfflDm;

	@Column(name="BCSFFL_MC",columnDefinition="VARCHAR2|本次随访分类名称|100|",length=100,nullable=true)
	private String bcsfflMc;

	@Column(name="BCSFFLYCXS",columnDefinition="VARCHAR2|本次随访分类异常详述|500|",length=500,nullable=true)
	private String bcsfflycxs;

	@Column(name="YCFJKZD_DM",columnDefinition="VARCHAR2|孕产妇健康指导代码|50|",length=50,nullable=true)
	private String ycfjkzdDm;

	@Column(name="YCFJKZD_MC",columnDefinition="VARCHAR2|孕产妇健康指导名称|500|",length=500,nullable=true)
	private String ycfjkzdMc;

	@Column(name="QTJKZD_MC",columnDefinition="VARCHAR2|其他健康指导名称|100|",length=100,nullable=true)
	private String qtjkzdMc;

	@Column(name="QTJKZDXS",columnDefinition="VARCHAR2|其他健康指导详述|800|",length=800,nullable=true)
	private String qtjkzdxs;

	@Column(name="YWZZ_DM",columnDefinition="VARCHAR2|有无转诊代码|20|",length=20,nullable=true)
	private String ywzzDm;

	@Column(name="YWZZ_MC",columnDefinition="VARCHAR2|有无转诊名称|20|",length=20,nullable=true)
	private String ywzzMc;

	@Column(name="ZZYY",columnDefinition="VARCHAR2|转诊原因|4000|",length=4000,nullable=true)
	private String zzyy;

	@Column(name="ZZJG_DM",columnDefinition="VARCHAR2|转诊机构代码|100|",length=100,nullable=true)
	private String zzjgDm;

	@Column(name="ZZJG_MC",columnDefinition="VARCHAR2|转诊机构名称|200|",length=200,nullable=true)
	private String zzjgMc;

	@Column(name="ZZJGKSBM",columnDefinition="VARCHAR2|转诊机构科室编码|100|",length=100,nullable=true)
	private String zzjgksbm;

	@Column(name="ZZJGKSMC",columnDefinition="VARCHAR2|转诊机构科室名称|200|",length=200,nullable=true)
	private String zzjgksmc;

	@Column(name="XCSFRQ",columnDefinition="DATE|下次随访日期||",nullable=true)
	private Date xcsfrq;

	@Column(name="SFJG_DM",columnDefinition="VARCHAR2|随访机构代码|100|",length=100,nullable=true)
	private String sfjgDm;

	@Column(name="SFJG_MC",columnDefinition="VARCHAR2|随访机构名称|200|",length=200,nullable=true)
	private String sfjgMc;

	@Column(name="SFYSBM",columnDefinition="VARCHAR2|随访医生编码|200|",length=200,nullable=true)
	private String sfysbm;

	@Column(name="SFYSXM",columnDefinition="VARCHAR2|随访医生姓名|200|",length=200,nullable=true)
	private String sfysxm;

	@Column(name="BZ",columnDefinition="VARCHAR2|备注|4000|",length=4000,nullable=true)
	private String bz;

	@Column(name="DJSJ",columnDefinition="DATE|登记时间||",nullable=true)
	private Date djsj;

	@Column(name="DJRYDM",columnDefinition="VARCHAR2|登记人员代码|40|",length=40,nullable=true)
	private String djrydm;

	@Column(name="DJRYMC",columnDefinition="VARCHAR2|登记人员名称|100|",length=100,nullable=true)
	private String djrymc;

	@Column(name="DJJG_DM",columnDefinition="VARCHAR2|登记机构代码|100|",length=100,nullable=true)
	private String djjgDm;

	@Column(name="DJJG_MC",columnDefinition="VARCHAR2|登记机构名称|200|",length=200,nullable=true)
	private String djjgMc;

	@Column(name="ZHXGSJ",columnDefinition="DATE|最后修改时间||",nullable=true)
	private Date zhxgsj;

	@Column(name="ZHXGRYDM",columnDefinition="VARCHAR2|最后修改人员代码|40|",length=40,nullable=true)
	private String zhxgrydm;

	@Column(name="ZHXGRYMC",columnDefinition="VARCHAR2|最后修改人员名称|100|",length=100,nullable=true)
	private String zhxgrymc;

	@Column(name="ZHXGJG_DM",columnDefinition="VARCHAR2|最后修改机构代码|100|",length=100,nullable=true)
	private String zhxgjgDm;

	@Column(name="ZHXGJG_MC",columnDefinition="VARCHAR2|最后修改机构名称|200|",length=200,nullable=true)
	private String zhxgjgMc;

	@Column(name="CLINIC_ORGAN_CODE",columnDefinition="VARCHAR2|就诊机构代码|50|",length=50,nullable=true)
	private String clinicOrganCode;

	@Column(name="CLINIC_ORGAN_NAME",columnDefinition="VARCHAR2|就诊机构名称|100|",length=100,nullable=true)
	private String clinicOrganName;

	@Column(name="BUSINESS_LOCAL_ID",columnDefinition="VARCHAR2|业务数据本地唯一id|32|",length=32,nullable=true)
	private String businessLocalId;

	@Column(name="UPLOAD_TIME",columnDefinition="DATE|系统上传时间||",nullable=true)
	private Date uploadTime;

	@Column(name="SFZJH",columnDefinition="VARCHAR2|身份证件号||",nullable=true)
	private String sfzjh;

	public String getSfzjh() {
		return sfzjh;
	}

	public void setSfzjh(String sfzjh) {
		this.sfzjh = sfzjh;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getChfslsbh() {
		return this.chfslsbh;
	}

	public void setChfslsbh(String chfslsbh) {
		this.chfslsbh = chfslsbh;
	}

	public String getMpi() {
		return this.mpi;
	}

	public void setMpi(String mpi) {
		this.mpi = mpi;
	}

	public String getJkdabh() {
		return this.jkdabh;
	}

	public void setJkdabh(String jkdabh) {
		this.jkdabh = jkdabh;
	}

	public String getYcfbh() {
		return this.ycfbh;
	}

	public void setYcfbh(String ycfbh) {
		this.ycfbh = ycfbh;
	}

	public Date getBcfsrq() {
		return this.bcfsrq;
	}

	public void setBcfsrq(Date bcfsrq) {
		this.bcfsrq = bcfsrq;
	}

	public String getXm() {
		return this.xm;
	}

	public void setXm(String xm) {
		this.xm = xm;
	}

	public String getSffsDm() {
		return this.sffsDm;
	}

	public void setSffsDm(String sffsDm) {
		this.sffsDm = sffsDm;
	}

	public String getSffsMc() {
		return this.sffsMc;
	}

	public void setSffsMc(String sffsMc) {
		this.sffsMc = sffsMc;
	}

	public String getSffsqtxs() {
		return this.sffsqtxs;
	}

	public void setSffsqtxs(String sffsqtxs) {
		this.sffsqtxs = sffsqtxs;
	}

	public Integer getChdjt() {
		return this.chdjt;
	}

	public void setChdjt(Integer chdjt) {
		this.chdjt = chdjt;
	}

	public Date getFmrq() {
		return this.fmrq;
	}

	public void setFmrq(Date fmrq) {
		this.fmrq = fmrq;
	}

	public Date getCyrq() {
		return this.cyrq;
	}

	public void setCyrq(Date cyrq) {
		this.cyrq = cyrq;
	}

	public String getYbjkqk() {
		return this.ybjkqk;
	}

	public void setYbjkqk(String ybjkqk) {
		this.ybjkqk = ybjkqk;
	}

	public String getYbxlqk() {
		return this.ybxlqk;
	}

	public void setYbxlqk(String ybxlqk) {
		this.ybxlqk = ybxlqk;
	}

	public BigDecimal getSzy() {
		return this.szy;
	}

	public void setSzy(BigDecimal szy) {
		this.szy = szy;
	}

	public BigDecimal getSsy() {
		return this.ssy;
	}

	public void setSsy(BigDecimal ssy) {
		this.ssy = ssy;
	}

	public BigDecimal getTw() {
		return this.tw;
	}

	public void setTw(BigDecimal tw) {
		this.tw = tw;
	}

	public Integer getMb() {
		return this.mb;
	}

	public void setMb(Integer mb) {
		this.mb = mb;
	}

	public String getRfqkDm() {
		return this.rfqkDm;
	}

	public void setRfqkDm(String rfqkDm) {
		this.rfqkDm = rfqkDm;
	}

	public String getRfqkMc() {
		return this.rfqkMc;
	}

	public void setRfqkMc(String rfqkMc) {
		this.rfqkMc = rfqkMc;
	}

	public String getRfycxs() {
		return this.rfycxs;
	}

	public void setRfycxs(String rfycxs) {
		this.rfycxs = rfycxs;
	}

	public String getElqkDm() {
		return this.elqkDm;
	}

	public void setElqkDm(String elqkDm) {
		this.elqkDm = elqkDm;
	}

	public String getElqkMc() {
		return this.elqkMc;
	}

	public void setElqkMc(String elqkMc) {
		this.elqkMc = elqkMc;
	}

	public String getElycxs() {
		return this.elycxs;
	}

	public void setElycxs(String elycxs) {
		this.elycxs = elycxs;
	}

	public String getZgqkycDm() {
		return this.zgqkycDm;
	}

	public void setZgqkycDm(String zgqkycDm) {
		this.zgqkycDm = zgqkycDm;
	}

	public String getZgqkyc() {
		return this.zgqkyc;
	}

	public void setZgqkyc(String zgqkyc) {
		this.zgqkyc = zgqkyc;
	}

	public String getZgycxs() {
		return this.zgycxs;
	}

	public void setZgycxs(String zgycxs) {
		this.zgycxs = zgycxs;
	}

	public String getSkqkDm() {
		return this.skqkDm;
	}

	public void setSkqkDm(String skqkDm) {
		this.skqkDm = skqkDm;
	}

	public String getSkqkMc() {
		return this.skqkMc;
	}

	public void setSkqkMc(String skqkMc) {
		this.skqkMc = skqkMc;
	}

	public String getSkycxs() {
		return this.skycxs;
	}

	public void setSkycxs(String skycxs) {
		this.skycxs = skycxs;
	}

	public String getQtycxs() {
		return this.qtycxs;
	}

	public void setQtycxs(String qtycxs) {
		this.qtycxs = qtycxs;
	}

	public String getBcsfflDm() {
		return this.bcsfflDm;
	}

	public void setBcsfflDm(String bcsfflDm) {
		this.bcsfflDm = bcsfflDm;
	}

	public String getBcsfflMc() {
		return this.bcsfflMc;
	}

	public void setBcsfflMc(String bcsfflMc) {
		this.bcsfflMc = bcsfflMc;
	}

	public String getBcsfflycxs() {
		return this.bcsfflycxs;
	}

	public void setBcsfflycxs(String bcsfflycxs) {
		this.bcsfflycxs = bcsfflycxs;
	}

	public String getYcfjkzdDm() {
		return this.ycfjkzdDm;
	}

	public void setYcfjkzdDm(String ycfjkzdDm) {
		this.ycfjkzdDm = ycfjkzdDm;
	}

	public String getYcfjkzdMc() {
		return this.ycfjkzdMc;
	}

	public void setYcfjkzdMc(String ycfjkzdMc) {
		this.ycfjkzdMc = ycfjkzdMc;
	}

	public String getQtjkzdMc() {
		return this.qtjkzdMc;
	}

	public void setQtjkzdMc(String qtjkzdMc) {
		this.qtjkzdMc = qtjkzdMc;
	}

	public String getQtjkzdxs() {
		return this.qtjkzdxs;
	}

	public void setQtjkzdxs(String qtjkzdxs) {
		this.qtjkzdxs = qtjkzdxs;
	}

	public String getYwzzDm() {
		return this.ywzzDm;
	}

	public void setYwzzDm(String ywzzDm) {
		this.ywzzDm = ywzzDm;
	}

	public String getYwzzMc() {
		return this.ywzzMc;
	}

	public void setYwzzMc(String ywzzMc) {
		this.ywzzMc = ywzzMc;
	}

	public String getZzyy() {
		return this.zzyy;
	}

	public void setZzyy(String zzyy) {
		this.zzyy = zzyy;
	}

	public String getZzjgDm() {
		return this.zzjgDm;
	}

	public void setZzjgDm(String zzjgDm) {
		this.zzjgDm = zzjgDm;
	}

	public String getZzjgMc() {
		return this.zzjgMc;
	}

	public void setZzjgMc(String zzjgMc) {
		this.zzjgMc = zzjgMc;
	}

	public String getZzjgksbm() {
		return this.zzjgksbm;
	}

	public void setZzjgksbm(String zzjgksbm) {
		this.zzjgksbm = zzjgksbm;
	}

	public String getZzjgksmc() {
		return this.zzjgksmc;
	}

	public void setZzjgksmc(String zzjgksmc) {
		this.zzjgksmc = zzjgksmc;
	}

	public Date getXcsfrq() {
		return this.xcsfrq;
	}

	public void setXcsfrq(Date xcsfrq) {
		this.xcsfrq = xcsfrq;
	}

	public String getSfjgDm() {
		return this.sfjgDm;
	}

	public void setSfjgDm(String sfjgDm) {
		this.sfjgDm = sfjgDm;
	}

	public String getSfjgMc() {
		return this.sfjgMc;
	}

	public void setSfjgMc(String sfjgMc) {
		this.sfjgMc = sfjgMc;
	}

	public String getSfysbm() {
		return this.sfysbm;
	}

	public void setSfysbm(String sfysbm) {
		this.sfysbm = sfysbm;
	}

	public String getSfysxm() {
		return this.sfysxm;
	}

	public void setSfysxm(String sfysxm) {
		this.sfysxm = sfysxm;
	}

	public String getBz() {
		return this.bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}

	public Date getDjsj() {
		return this.djsj;
	}

	public void setDjsj(Date djsj) {
		this.djsj = djsj;
	}

	public String getDjrydm() {
		return this.djrydm;
	}

	public void setDjrydm(String djrydm) {
		this.djrydm = djrydm;
	}

	public String getDjrymc() {
		return this.djrymc;
	}

	public void setDjrymc(String djrymc) {
		this.djrymc = djrymc;
	}

	public String getDjjgDm() {
		return this.djjgDm;
	}

	public void setDjjgDm(String djjgDm) {
		this.djjgDm = djjgDm;
	}

	public String getDjjgMc() {
		return this.djjgMc;
	}

	public void setDjjgMc(String djjgMc) {
		this.djjgMc = djjgMc;
	}

	public Date getZhxgsj() {
		return this.zhxgsj;
	}

	public void setZhxgsj(Date zhxgsj) {
		this.zhxgsj = zhxgsj;
	}

	public String getZhxgrydm() {
		return this.zhxgrydm;
	}

	public void setZhxgrydm(String zhxgrydm) {
		this.zhxgrydm = zhxgrydm;
	}

	public String getZhxgrymc() {
		return this.zhxgrymc;
	}

	public void setZhxgrymc(String zhxgrymc) {
		this.zhxgrymc = zhxgrymc;
	}

	public String getZhxgjgDm() {
		return this.zhxgjgDm;
	}

	public void setZhxgjgDm(String zhxgjgDm) {
		this.zhxgjgDm = zhxgjgDm;
	}

	public String getZhxgjgMc() {
		return this.zhxgjgMc;
	}

	public void setZhxgjgMc(String zhxgjgMc) {
		this.zhxgjgMc = zhxgjgMc;
	}

	public String getClinicOrganCode() {
		return this.clinicOrganCode;
	}

	public void setClinicOrganCode(String clinicOrganCode) {
		this.clinicOrganCode = clinicOrganCode;
	}

	public String getClinicOrganName() {
		return this.clinicOrganName;
	}

	public void setClinicOrganName(String clinicOrganName) {
		this.clinicOrganName = clinicOrganName;
	}

	public String getBusinessLocalId() {
		return this.businessLocalId;
	}

	public void setBusinessLocalId(String businessLocalId) {
		this.businessLocalId = businessLocalId;
	}

	public Date getUploadTime() {
		return this.uploadTime;
	}

	public void setUploadTime(Date uploadTime) {
		this.uploadTime = uploadTime;
	}

}