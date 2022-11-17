package com.founder.rhip.ehr.entity.women;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="WH_YCFBJ_GWSF")
public class WhYcfbjGwsf implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID",columnDefinition="NUMBER|数据库唯一编号（自增长）|11|",length=11,nullable=false)
	private Long id;

	@Column(name="GWSFLSH",columnDefinition="VARCHAR2|高危随访流水号|40|",length=40,nullable=false)
	private String gwsflsh;

	@Column(name="MPI",columnDefinition="VARCHAR2|个人主索引|40|",length=40,nullable=false)
	private String mpi;

	@Column(name="JKDABH",columnDefinition="VARCHAR2|健康档案编号|50|",length=50,nullable=false)
	private String jkdabh;

	@Column(name="GWDJBH",columnDefinition="VARCHAR2|高危登记编号|40|",length=40,nullable=false)
	private String gwdjbh;

	@Column(name="SFZJH",columnDefinition="VARCHAR2|高危登记编号|40|",length=40,nullable=false)
	private String sfzjh;

	@Column(name="GWSFRQ",columnDefinition="DATE|高危随访日期||",nullable=false)
	private Date gwsfrq;

	@Column(name="SFFS_DM",columnDefinition="VARCHAR2|随访方式代码|50|",length=50,nullable=false)
	private String sffsDm;

	@Column(name="SFFS_MC",columnDefinition="VARCHAR2|随访方式名称|100|",length=100,nullable=false)
	private String sffsMc;

	@Column(name="SFFSQTXS",columnDefinition="VARCHAR2|随访方式其他详述|500|",length=500,nullable=true)
	private String sffsqtxs;

	@Column(name="XM",columnDefinition="VARCHAR2|姓名|40|",length=40,nullable=false)
	private String xm;

	@Column(name="CSRQ",columnDefinition="DATE|出生日期||",nullable=false)
	private Date csrq;

	@Column(name="NL",columnDefinition="INTEGER|年龄||",nullable=false)
	private Integer nl;

	@Column(name="NLDW_DM",columnDefinition="VARCHAR2|年龄单位代码|50|",length=50,nullable=false)
	private String nldwDm;

	@Column(name="NLDWDM_MC",columnDefinition="VARCHAR2|年龄单位代码名称|100|",length=100,nullable=false)
	private String nldwdmMc;

	@Column(name="DQYZ",columnDefinition="INTEGER|当前孕周||",nullable=false)
	private Integer dqyz;

	@Column(name="ZYZZ_DM",columnDefinition="VARCHAR2|主要症状代码|50|",length=50,nullable=true)
	private String zyzzDm;

	@Column(name="ZYZZ2DM_MC",columnDefinition="VARCHAR2|主要症状代码名称|100|",length=100,nullable=true)
	private String zyzz2dmMc;

	@Column(name="ZYZZ2QTXS",columnDefinition="VARCHAR2|主要症状其他详述|4000|",length=4000,nullable=true)
	private String zyzz2qtxs;

	@Column(name="ZYTZ",columnDefinition="VARCHAR2|主要体征|4000|",length=4000,nullable=true)
	private String zytz;

	@Column(name="FZJC",columnDefinition="VARCHAR2|辅助检查|4000|",length=4000,nullable=true)
	private String fzjc;

	@Column(name="CLYJ",columnDefinition="VARCHAR2|处理意见|4000|",length=4000,nullable=true)
	private String clyj;

	@Column(name="YCQGWYS_DM",columnDefinition="VARCHAR2|孕产期高危因素代码|50|",length=50,nullable=false)
	private String ycqgwysDm;

	@Column(name="YCQGWYS_MC",columnDefinition="VARCHAR2|孕产期高危因素名称|200|",length=200,nullable=false)
	private String ycqgwysMc;

	@Column(name="YCQQTGWYS",columnDefinition="VARCHAR2|孕产期其他高危因素|4000|",length=4000,nullable=true)
	private String ycqqtgwys;

	@Column(name="GWPD_DM",columnDefinition="VARCHAR2|高危评定代码|50|",length=50,nullable=true)
	private String gwpdDm;

	@Column(name="GWPDDM_MC",columnDefinition="VARCHAR2|高危评定代码名称|100|",length=100,nullable=true)
	private String gwpddmMc;

	@Column(name="GWPF",columnDefinition="INTEGER|高危评分||",nullable=true)
	private Integer gwpf;

	@Column(name="ZLJG_DM",columnDefinition="VARCHAR2|治疗结果代码|50|",length=50,nullable=true)
	private String zljgDm;

	@Column(name="ZLJG_MC",columnDefinition="VARCHAR2|治疗结果代码名称|100|",length=100,nullable=true)
	private String zljgMc;

	@Column(name="SFSW_DM",columnDefinition="VARCHAR2|是否死亡代码|50|",length=50,nullable=false)
	private String sfswDm;

	@Column(name="SFSW_MC",columnDefinition="VARCHAR2|是否死亡名称|100|",length=100,nullable=false)
	private String sfswMc;

	@Column(name="SWSJ",columnDefinition="DATE|死亡时间||",nullable=true)
	private Date swsj;

	@Column(name="SWYY",columnDefinition="VARCHAR2|死亡原因|500|",length=500,nullable=true)
	private String swyy;

	@Column(name="SFYSBM",columnDefinition="VARCHAR2|随访医生编码|40|",length=40,nullable=true)
	private String sfysbm;

	@Column(name="SFYSXM",columnDefinition="VARCHAR2|随访医生姓名|40|",length=40,nullable=true)
	private String sfysxm;

	@Column(name="SFJG_DM",columnDefinition="VARCHAR2|随访机构代码|100|",length=100,nullable=false)
	private String sfjgDm;

	@Column(name="SFJG_MC",columnDefinition="VARCHAR2|随访机构名称|200|",length=200,nullable=false)
	private String sfjgMc;

	@Column(name="XCSFRQ",columnDefinition="DATE|下次随访日期||",nullable=true)
	private Date xcsfrq;

	@Column(name="BZ",columnDefinition="VARCHAR2|备注|4000|",length=4000,nullable=true)
	private String bz;

	@Column(name="DJSJ",columnDefinition="DATE|登记时间(系统)||",nullable=false)
	private Date djsj;

	@Column(name="DJRYDM",columnDefinition="VARCHAR2|登记人员代码|40|",length=40,nullable=true)
	private String djrydm;

	@Column(name="DJRYMC",columnDefinition="VARCHAR2|登记人员名称|100|",length=100,nullable=true)
	private String djrymc;

	@Column(name="DJJG_DM",columnDefinition="VARCHAR2|登记机构代码|100|",length=100,nullable=false)
	private String djjgDm;

	@Column(name="DJJG_MC",columnDefinition="VARCHAR2|登记机构名称|200|",length=200,nullable=false)
	private String djjgMc;

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

	public String getGwsflsh() {
		return this.gwsflsh;
	}

	public void setGwsflsh(String gwsflsh) {
		this.gwsflsh = gwsflsh;
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

	public String getGwdjbh() {
		return this.gwdjbh;
	}

	public String getSfzjh() {
		return sfzjh;
	}

	public void setSfzjh(String sfzjh) {
		this.sfzjh = sfzjh;
	}

	public void setGwdjbh(String gwdjbh) {
		this.gwdjbh = gwdjbh;
	}

	public Date getGwsfrq() {
		return this.gwsfrq;
	}

	public void setGwsfrq(Date gwsfrq) {
		this.gwsfrq = gwsfrq;
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

	public String getXm() {
		return this.xm;
	}

	public void setXm(String xm) {
		this.xm = xm;
	}

	public Date getCsrq() {
		return this.csrq;
	}

	public void setCsrq(Date csrq) {
		this.csrq = csrq;
	}

	public Integer getNl() {
		return this.nl;
	}

	public void setNl(Integer nl) {
		this.nl = nl;
	}

	public String getNldwDm() {
		return this.nldwDm;
	}

	public void setNldwDm(String nldwDm) {
		this.nldwDm = nldwDm;
	}

	public String getNldwdmMc() {
		return this.nldwdmMc;
	}

	public void setNldwdmMc(String nldwdmMc) {
		this.nldwdmMc = nldwdmMc;
	}

	public Integer getDqyz() {
		return this.dqyz;
	}

	public void setDqyz(Integer dqyz) {
		this.dqyz = dqyz;
	}

	public String getZyzzDm() {
		return this.zyzzDm;
	}

	public void setZyzzDm(String zyzzDm) {
		this.zyzzDm = zyzzDm;
	}

	public String getZyzz2dmMc() {
		return this.zyzz2dmMc;
	}

	public void setZyzz2dmMc(String zyzz2dmMc) {
		this.zyzz2dmMc = zyzz2dmMc;
	}

	public String getZyzz2qtxs() {
		return this.zyzz2qtxs;
	}

	public void setZyzz2qtxs(String zyzz2qtxs) {
		this.zyzz2qtxs = zyzz2qtxs;
	}

	public String getZytz() {
		return this.zytz;
	}

	public void setZytz(String zytz) {
		this.zytz = zytz;
	}

	public String getFzjc() {
		return this.fzjc;
	}

	public void setFzjc(String fzjc) {
		this.fzjc = fzjc;
	}

	public String getClyj() {
		return this.clyj;
	}

	public void setClyj(String clyj) {
		this.clyj = clyj;
	}

	public String getYcqgwysDm() {
		return this.ycqgwysDm;
	}

	public void setYcqgwysDm(String ycqgwysDm) {
		this.ycqgwysDm = ycqgwysDm;
	}

	public String getYcqgwysMc() {
		return this.ycqgwysMc;
	}

	public void setYcqgwysMc(String ycqgwysMc) {
		this.ycqgwysMc = ycqgwysMc;
	}

	public String getYcqqtgwys() {
		return this.ycqqtgwys;
	}

	public void setYcqqtgwys(String ycqqtgwys) {
		this.ycqqtgwys = ycqqtgwys;
	}

	public String getGwpdDm() {
		return this.gwpdDm;
	}

	public void setGwpdDm(String gwpdDm) {
		this.gwpdDm = gwpdDm;
	}

	public String getGwpddmMc() {
		return this.gwpddmMc;
	}

	public void setGwpddmMc(String gwpddmMc) {
		this.gwpddmMc = gwpddmMc;
	}

	public Integer getGwpf() {
		return this.gwpf;
	}

	public void setGwpf(Integer gwpf) {
		this.gwpf = gwpf;
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

	public String getSwyy() {
		return this.swyy;
	}

	public void setSwyy(String swyy) {
		this.swyy = swyy;
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

	public Date getXcsfrq() {
		return this.xcsfrq;
	}

	public void setXcsfrq(Date xcsfrq) {
		this.xcsfrq = xcsfrq;
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