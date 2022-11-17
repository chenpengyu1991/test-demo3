package com.founder.rhip.ehr.entity.child;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="CH_ETBJ_TRE")
public class ChEtbjTre implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID",columnDefinition="NUMBER|数据库唯一编号（自增长）|11|",length=11,nullable=false)
	private Long id;

	@Column(name="TREZXDABH",columnDefinition="VARCHAR2|体弱儿专项档案编号|32|",length=32,nullable=false)
	private String trezxdabh;

	@Column(name="MPI",columnDefinition="VARCHAR2|个人主索引|40|",length=40,nullable=false)
	private String mpi;

	@Column(name="JKDABH",columnDefinition="VARCHAR2|健康档案编号|50|",length=50,nullable=false)
	private String jkdabh;

	@Column(name="ETXXBH",columnDefinition="VARCHAR2|儿童信息编号|50|",length=50,nullable=false)
	private String etxxbh;

	@Column(name="XM",columnDefinition="VARCHAR2|姓名|20|",length=20,nullable=true)
	private String xm;

	@Column(name="XB_DM",columnDefinition="VARCHAR2|性别代码|10|",length=10,nullable=false)
	private String xbDm;

	@Column(name="XB",columnDefinition="VARCHAR2|性别|20|",length=20,nullable=false)
	private String xb;

	@Column(name="CSRQ",columnDefinition="DATE|出生日期||",nullable=false)
	private Date csrq;

	@Column(name="MQSFZHM",columnDefinition="VARCHAR2|母亲身份证号码|18|",length=18,nullable=false)
	private String mqsfzhm;

	@Column(name="MQXM",columnDefinition="VARCHAR2|母亲姓名|50|",length=50,nullable=false)
	private String mqxm;

	@Column(name="FQSFZHM",columnDefinition="VARCHAR2|父亲身份证号码|18|",length=18,nullable=true)
	private String fqsfzhm;

	@Column(name="FQXM",columnDefinition="VARCHAR2|父亲姓名|50|",length=50,nullable=true)
	private String fqxm;

	@Column(name="ETTRYS_DM",columnDefinition="VARCHAR2|儿童体弱因素代码|50|",length=50,nullable=false)
	private String ettrysDm;

	@Column(name="ETTRYS_MC",columnDefinition="VARCHAR2|儿童体弱因素名称|500|",length=500,nullable=false)
	private String ettrysMc;

	@Column(name="ETTRYSQTXS",columnDefinition="VARCHAR2|儿童体弱因素其他详述|500|",length=500,nullable=true)
	private String ettrysqtxs;

	@Column(name="ETTRYY_DM",columnDefinition="VARCHAR2|儿童体弱原因代码|50|",length=50,nullable=false)
	private String ettryyDm;

	@Column(name="ETTRYY_MC",columnDefinition="VARCHAR2|儿童体弱原因名称|200|",length=200,nullable=false)
	private String ettryyMc;

	@Column(name="ETTRYYQTXS",columnDefinition="VARCHAR2|儿童体弱原因其他详述|200|",length=200,nullable=true)
	private String ettryyqtxs;

	@Column(name="XTXJBXS",columnDefinition="VARCHAR2|先天性疾病详述|4000|",length=4000,nullable=true)
	private String xtxjbxs;

	@Column(name="WCQTRYSXS",columnDefinition="VARCHAR2|围产期体弱因素详述|4000|",length=4000,nullable=true)
	private String wcqtrysxs;

	@Column(name="TRQTXS",columnDefinition="VARCHAR2|体弱其他详述|4000|",length=4000,nullable=true)
	private String trqtxs;

	@Column(name="ZLJG_DM",columnDefinition="VARCHAR2|治疗结果代码|50|",length=50,nullable=true)
	private String zljgDm;

	@Column(name="ZLJG_MC",columnDefinition="VARCHAR2|治疗结果代码名称|100|",length=100,nullable=true)
	private String zljgMc;

	@Column(name="JABZ_DM",columnDefinition="VARCHAR2|结案标志代码|50|",length=50,nullable=false)
	private String jabzDm;

	@Column(name="JABZ",columnDefinition="VARCHAR2|结案标志|200|",length=200,nullable=false)
	private String jabz;

	@Column(name="JARQ",columnDefinition="DATE|结案日期||",nullable=true)
	private Date jarq;

	@Column(name="JASM",columnDefinition="VARCHAR2|结案说明|4000|",length=4000,nullable=true)
	private String jasm;

	@Column(name="SFCXJABS_DM",columnDefinition="VARCHAR2|是否撤销结案标识代码|50|",length=50,nullable=true)
	private String sfcxjabsDm;

	@Column(name="SFCXJABS_MC",columnDefinition="VARCHAR2|是否撤销结案标识名称|100|",length=100,nullable=true)
	private String sfcxjabsMc;

	@Column(name="CXJARQ",columnDefinition="DATE|撤销结案日期||",nullable=true)
	private Date cxjarq;

	@Column(name="CXJASM",columnDefinition="VARCHAR2|撤销结案说明|4000|",length=4000,nullable=true)
	private String cxjasm;

	@Column(name="TBRQ",columnDefinition="DATE|填表日期||",nullable=false)
	private Date tbrq;

	@Column(name="TBR",columnDefinition="VARCHAR2|填表人|200|",length=200,nullable=false)
	private String tbr;

	@Column(name="SFTRETBZ_DM",columnDefinition="VARCHAR2|是否体弱儿童标志代码|50|",length=50,nullable=false)
	private String sftretbzDm;

	@Column(name="SFTRETBZ_MC",columnDefinition="VARCHAR2|是否体弱儿童标志名称|100|",length=100,nullable=false)
	private String sftretbzMc;

	@Column(name="CSYZ",columnDefinition="INTEGER|出生孕周||",nullable=false)
	private Integer csyz;

	@Column(name="SFSW_DM",columnDefinition="VARCHAR2|是否死亡代码|50|",length=50,nullable=false)
	private String sfswDm;

	@Column(name="SFSW_MC",columnDefinition="VARCHAR2|是否死亡名称|100|",length=100,nullable=false)
	private String sfswMc;

	@Column(name="SWSJ",columnDefinition="DATE|死亡时间||",nullable=true)
	private Date swsj;

	@Column(name="JDJG_DM",columnDefinition="VARCHAR2|建档机构代码|100|",length=100,nullable=false)
	private String jdjgDm;

	@Column(name="JDJG_MC",columnDefinition="VARCHAR2|建档机构名称|200|",length=200,nullable=false)
	private String jdjgMc;

	@Column(name="JDRDM",columnDefinition="VARCHAR2|建档人代码|50|",length=50,nullable=true)
	private String jdrdm;

	@Column(name="JDRMC",columnDefinition="VARCHAR2|建档人名称|100|",length=100,nullable=true)
	private String jdrmc;

	@Column(name="JDRXLDHHM",columnDefinition="VARCHAR2|建档人联系电话号码|20|",length=20,nullable=true)
	private String jdrxldhhm;

	@Column(name="GDJG_DM",columnDefinition="VARCHAR2|管档机构代码|100|",length=100,nullable=true)
	private String gdjgDm;

	@Column(name="GDJG_MC",columnDefinition="VARCHAR2|管档机构名称|200|",length=200,nullable=true)
	private String gdjgMc;

	@Column(name="JDRQ",columnDefinition="DATE|建档日期||",nullable=false)
	private Date jdrq;

	@Column(name="BZ",columnDefinition="VARCHAR2|备注|4000|",length=4000,nullable=true)
	private String bz;

	@Column(name="ZHXGSJ",columnDefinition="DATE|最后修改时间||",nullable=false)
	private Date zhxgsj;

	@Column(name="ZHXGRYDM",columnDefinition="VARCHAR2|最后修改人员代码|40|",length=40,nullable=true)
	private String zhxgrydm;

	@Column(name="ZHXGRYMC",columnDefinition="VARCHAR2|最后修改人员名称|100|",length=100,nullable=true)
	private String zhxgrymc;

	@Column(name="ZHXGJG_DM",columnDefinition="VARCHAR2|最后修改机构代码|100|",length=100,nullable=false)
	private String zhxgjgDm;

	@Column(name="ZHXGJG_MC",columnDefinition="VARCHAR2|最后修改机构名称|200|",length=200,nullable=false)
	private String zhxgjgMc;

	@Column(name="CLINIC_ORGAN_CODE",columnDefinition="VARCHAR|就诊机构代码|50|",length=50,nullable=false)
	private String clinicOrganCode;

	@Column(name="CLINIC_ORGAN_NAME",columnDefinition="VARCHAR|就诊机构名称|100|",length=100,nullable=false)
	private String clinicOrganName;

	@Column(name="BUSINESS_LOCAL_ID",columnDefinition="VARCHAR|业务数据本地唯一id|32|",length=32,nullable=false)
	private String businessLocalId;

	@Column(name="UPLOAD_TIME",columnDefinition="DATE|系统上传时间||",nullable=true)
	private Date uploadTime;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTrezxdabh() {
		return this.trezxdabh;
	}

	public void setTrezxdabh(String trezxdabh) {
		this.trezxdabh = trezxdabh;
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

	public String getEtxxbh() {
		return this.etxxbh;
	}

	public void setEtxxbh(String etxxbh) {
		this.etxxbh = etxxbh;
	}

	public String getXm() {
		return this.xm;
	}

	public void setXm(String xm) {
		this.xm = xm;
	}

	public String getXbDm() {
		return this.xbDm;
	}

	public void setXbDm(String xbDm) {
		this.xbDm = xbDm;
	}

	public String getXb() {
		return this.xb;
	}

	public void setXb(String xb) {
		this.xb = xb;
	}

	public Date getCsrq() {
		return this.csrq;
	}

	public void setCsrq(Date csrq) {
		this.csrq = csrq;
	}

	public String getMqsfzhm() {
		return this.mqsfzhm;
	}

	public void setMqsfzhm(String mqsfzhm) {
		this.mqsfzhm = mqsfzhm;
	}

	public String getMqxm() {
		return this.mqxm;
	}

	public void setMqxm(String mqxm) {
		this.mqxm = mqxm;
	}

	public String getFqsfzhm() {
		return this.fqsfzhm;
	}

	public void setFqsfzhm(String fqsfzhm) {
		this.fqsfzhm = fqsfzhm;
	}

	public String getFqxm() {
		return this.fqxm;
	}

	public void setFqxm(String fqxm) {
		this.fqxm = fqxm;
	}

	public String getEttrysDm() {
		return this.ettrysDm;
	}

	public void setEttrysDm(String ettrysDm) {
		this.ettrysDm = ettrysDm;
	}

	public String getEttrysMc() {
		return this.ettrysMc;
	}

	public void setEttrysMc(String ettrysMc) {
		this.ettrysMc = ettrysMc;
	}

	public String getEttrysqtxs() {
		return this.ettrysqtxs;
	}

	public void setEttrysqtxs(String ettrysqtxs) {
		this.ettrysqtxs = ettrysqtxs;
	}

	public String getEttryyDm() {
		return this.ettryyDm;
	}

	public void setEttryyDm(String ettryyDm) {
		this.ettryyDm = ettryyDm;
	}

	public String getEttryyMc() {
		return this.ettryyMc;
	}

	public void setEttryyMc(String ettryyMc) {
		this.ettryyMc = ettryyMc;
	}

	public String getEttryyqtxs() {
		return this.ettryyqtxs;
	}

	public void setEttryyqtxs(String ettryyqtxs) {
		this.ettryyqtxs = ettryyqtxs;
	}

	public String getXtxjbxs() {
		return this.xtxjbxs;
	}

	public void setXtxjbxs(String xtxjbxs) {
		this.xtxjbxs = xtxjbxs;
	}

	public String getWcqtrysxs() {
		return this.wcqtrysxs;
	}

	public void setWcqtrysxs(String wcqtrysxs) {
		this.wcqtrysxs = wcqtrysxs;
	}

	public String getTrqtxs() {
		return this.trqtxs;
	}

	public void setTrqtxs(String trqtxs) {
		this.trqtxs = trqtxs;
	}

	public String getZljgDm() {
		return this.zljgDm;
	}

	public void setZljgDm(String zljgDm) {
		this.zljgDm = zljgDm;
	}

	public String getZljgMc() {
		return this.zljgMc;
	}

	public void setZljgMc(String zljgMc) {
		this.zljgMc = zljgMc;
	}

	public String getJabzDm() {
		return this.jabzDm;
	}

	public void setJabzDm(String jabzDm) {
		this.jabzDm = jabzDm;
	}

	public String getJabz() {
		return this.jabz;
	}

	public void setJabz(String jabz) {
		this.jabz = jabz;
	}

	public Date getJarq() {
		return this.jarq;
	}

	public void setJarq(Date jarq) {
		this.jarq = jarq;
	}

	public String getJasm() {
		return this.jasm;
	}

	public void setJasm(String jasm) {
		this.jasm = jasm;
	}

	public String getSfcxjabsDm() {
		return this.sfcxjabsDm;
	}

	public void setSfcxjabsDm(String sfcxjabsDm) {
		this.sfcxjabsDm = sfcxjabsDm;
	}

	public String getSfcxjabsMc() {
		return this.sfcxjabsMc;
	}

	public void setSfcxjabsMc(String sfcxjabsMc) {
		this.sfcxjabsMc = sfcxjabsMc;
	}

	public Date getCxjarq() {
		return this.cxjarq;
	}

	public void setCxjarq(Date cxjarq) {
		this.cxjarq = cxjarq;
	}

	public String getCxjasm() {
		return this.cxjasm;
	}

	public void setCxjasm(String cxjasm) {
		this.cxjasm = cxjasm;
	}

	public Date getTbrq() {
		return this.tbrq;
	}

	public void setTbrq(Date tbrq) {
		this.tbrq = tbrq;
	}

	public String getTbr() {
		return this.tbr;
	}

	public void setTbr(String tbr) {
		this.tbr = tbr;
	}

	public String getSftretbzDm() {
		return this.sftretbzDm;
	}

	public void setSftretbzDm(String sftretbzDm) {
		this.sftretbzDm = sftretbzDm;
	}

	public String getSftretbzMc() {
		return this.sftretbzMc;
	}

	public void setSftretbzMc(String sftretbzMc) {
		this.sftretbzMc = sftretbzMc;
	}

	public Integer getCsyz() {
		return this.csyz;
	}

	public void setCsyz(Integer csyz) {
		this.csyz = csyz;
	}

	public String getSfswDm() {
		return this.sfswDm;
	}

	public void setSfswDm(String sfswDm) {
		this.sfswDm = sfswDm;
	}

	public String getSfswMc() {
		return this.sfswMc;
	}

	public void setSfswMc(String sfswMc) {
		this.sfswMc = sfswMc;
	}

	public Date getSwsj() {
		return this.swsj;
	}

	public void setSwsj(Date swsj) {
		this.swsj = swsj;
	}

	public String getJdjgDm() {
		return this.jdjgDm;
	}

	public void setJdjgDm(String jdjgDm) {
		this.jdjgDm = jdjgDm;
	}

	public String getJdjgMc() {
		return this.jdjgMc;
	}

	public void setJdjgMc(String jdjgMc) {
		this.jdjgMc = jdjgMc;
	}

	public String getJdrdm() {
		return this.jdrdm;
	}

	public void setJdrdm(String jdrdm) {
		this.jdrdm = jdrdm;
	}

	public String getJdrmc() {
		return this.jdrmc;
	}

	public void setJdrmc(String jdrmc) {
		this.jdrmc = jdrmc;
	}

	public String getJdrxldhhm() {
		return this.jdrxldhhm;
	}

	public void setJdrxldhhm(String jdrxldhhm) {
		this.jdrxldhhm = jdrxldhhm;
	}

	public String getGdjgDm() {
		return this.gdjgDm;
	}

	public void setGdjgDm(String gdjgDm) {
		this.gdjgDm = gdjgDm;
	}

	public String getGdjgMc() {
		return this.gdjgMc;
	}

	public void setGdjgMc(String gdjgMc) {
		this.gdjgMc = gdjgMc;
	}

	public Date getJdrq() {
		return this.jdrq;
	}

	public void setJdrq(Date jdrq) {
		this.jdrq = jdrq;
	}

	public String getBz() {
		return this.bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
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