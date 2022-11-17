package com.founder.rhip.ehr.entity.child;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name="CH_ETBJ_TRESF")
public class ChEtbjTresf implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID",columnDefinition="NUMBER|数据库唯一编号（自增长）|11|",length=11,nullable=false)
	private Long id;

	@Column(name="TRESFLSH",columnDefinition="VARCHAR2|体弱儿随访流水号|32|",length=32,nullable=false)
	private String tresflsh;

	@Column(name="MPI",columnDefinition="VARCHAR2|个人主索引|40|",length=40,nullable=false)
	private String mpi;

	@Column(name="JKDABH",columnDefinition="VARCHAR2|健康档案编号|50|",length=50,nullable=false)
	private String jkdabh;

	@Column(name="MQSFZHM",columnDefinition="VARCHAR2|母亲身份证号码|18|",length=18,nullable=false)
	private String mqsfzhm;

	@Column(name="MQXM",columnDefinition="VARCHAR2|母亲姓名|50|",length=50,nullable=false)
	private String mqxm;

	@Column(name="TREZXDABH",columnDefinition="VARCHAR2|体弱儿专项档案编号|32|",length=32,nullable=false)
	private String trezxdabh;

	@Column(name="SFFS_DM",columnDefinition="VARCHAR2|随访方式代码|50|",length=50,nullable=false)
	private String sffsDm;

	@Column(name="SFFS_MC",columnDefinition="VARCHAR2|随访方式名称|100|",length=100,nullable=false)
	private String sffsMc;

	@Column(name="SFFSQTXS",columnDefinition="VARCHAR2|随访方式其他详述|500|",length=500,nullable=true)
	private String sffsqtxs;

	@Column(name="SFRQ",columnDefinition="DATE|随访日期||",nullable=false)
	private Date sfrq;

	@Column(name="XM",columnDefinition="VARCHAR2|姓名|20|",length=20,nullable=true)
	private String xm;

	@Column(name="XB_DM",columnDefinition="VARCHAR2|性别代码|10|",length=10,nullable=false)
	private String xbDm;

	@Column(name="XB",columnDefinition="VARCHAR2|性别|20|",length=20,nullable=false)
	private String xb;

	@Column(name="CSRQ",columnDefinition="DATE|出生日期||",nullable=false)
	private Date csrq;

	@Column(name="TZ",columnDefinition="NUMBER|体重|8|",length=8,nullable=false)
	private BigDecimal tz;

	@Column(name="TZPJ_DM",columnDefinition="VARCHAR2|体重评价代码|50|",length=50,nullable=false)
	private String tzpjDm;

	@Column(name="TZPJ_MC",columnDefinition="VARCHAR2|体重评价名称|200|",length=200,nullable=false)
	private String tzpjMc;

	@Column(name="SC",columnDefinition="NUMBER|身长|8|",length=8,nullable=false)
	private BigDecimal sc;

	@Column(name="SCPJ_DM",columnDefinition="VARCHAR2|身长评价代码|50|",length=50,nullable=false)
	private String scpjDm;

	@Column(name="SCPJ_MC",columnDefinition="VARCHAR2|身长评价名称|200|",length=200,nullable=false)
	private String scpjMc;

	@Column(name="SGTZ",columnDefinition="VARCHAR2|身高体重|50|",length=50,nullable=false)
	private String sgtz;

	@Column(name="SGTZPJ_DM",columnDefinition="VARCHAR2|身高体重评价代码|50|",length=50,nullable=false)
	private String sgtzpjDm;

	@Column(name="SGTZPJ_MC",columnDefinition="VARCHAR2|身高体重评价名称|200|",length=200,nullable=false)
	private String sgtzpjMc;

	@Column(name="WYFS_DM",columnDefinition="VARCHAR2|喂养方式代码|50|",length=50,nullable=false)
	private String wyfsDm;

	@Column(name="WYFS_MC",columnDefinition="VARCHAR2|喂养方式名称|100|",length=100,nullable=false)
	private String wyfsMc;

	@Column(name="WYFSHQKXS",columnDefinition="VARCHAR2|喂养方式和情况详述|4000|",length=4000,nullable=true)
	private String wyfshqkxs;

	@Column(name="WMRCS",columnDefinition="INTEGER|喂母乳次数||",nullable=true)
	private Integer wmrcs;

	@Column(name="FYQKXS",columnDefinition="VARCHAR2|发育情况详述|50|",length=50,nullable=true)
	private String fyqkxs;

	@Column(name="LCZZHTZ_DM",columnDefinition="VARCHAR2|临床症状和体征代码|100|",length=100,nullable=true)
	private String lczzhtzDm;

	@Column(name="LCZZHTZDM_MC",columnDefinition="VARCHAR2|临床症状和体征代码名称|4000|",length=4000,nullable=true)
	private String lczzhtzdmMc;

	@Column(name="LCZZHTZQTXS",columnDefinition="VARCHAR2|临床症状和体征其他详述|4000|",length=4000,nullable=true)
	private String lczzhtzqtxs;

	@Column(name="FZJCQKXS",columnDefinition="VARCHAR2|辅助检查情况详述|4000|",length=4000,nullable=true)
	private String fzjcqkxs;

	@Column(name="ZDCLXS",columnDefinition="VARCHAR2|指导处理详述|4000|",length=4000,nullable=true)
	private String zdclxs;

	@Column(name="SFSW_DM",columnDefinition="VARCHAR2|是否死亡代码|50|",length=50,nullable=true)
	private String sfswDm;

	@Column(name="SFSWDM_MC",columnDefinition="VARCHAR2|是否死亡代码名称|100|",length=100,nullable=true)
	private String sfswdmMc;

	@Column(name="SWSJ",columnDefinition="DATE|死亡时间||",nullable=true)
	private Date swsj;

	@Column(name="SWYY_DM",columnDefinition="VARCHAR2|死亡原因代码|4000|",length=4000,nullable=true)
	private String swyyDm;

	@Column(name="SWYYDM_MC",columnDefinition="VARCHAR2|死亡原因代码名称|4000|",length=4000,nullable=true)
	private String swyydmMc;

	@Column(name="XCSFRQ",columnDefinition="DATE|下次随访日期||",nullable=true)
	private Date xcsfrq;

	@Column(name="XCSFDD",columnDefinition="VARCHAR2|下次随访地点|500|",length=500,nullable=true)
	private String xcsfdd;

	@Column(name="SFYSBM",columnDefinition="VARCHAR2|随访医生编码|200|",length=200,nullable=true)
	private String sfysbm;

	@Column(name="SFYSXM",columnDefinition="VARCHAR2|随访医生姓名|200|",length=200,nullable=true)
	private String sfysxm;

	@Column(name="SFJG_DM",columnDefinition="VARCHAR2|随访机构代码|100|",length=100,nullable=false)
	private String sfjgDm;

	@Column(name="SFJG_MC",columnDefinition="VARCHAR2|随访机构名称|200|",length=200,nullable=false)
	private String sfjgMc;

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

	public String getTresflsh() {
		return this.tresflsh;
	}

	public void setTresflsh(String tresflsh) {
		this.tresflsh = tresflsh;
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

	public String getTrezxdabh() {
		return this.trezxdabh;
	}

	public void setTrezxdabh(String trezxdabh) {
		this.trezxdabh = trezxdabh;
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

	public Date getSfrq() {
		return this.sfrq;
	}

	public void setSfrq(Date sfrq) {
		this.sfrq = sfrq;
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

	public BigDecimal getTz() {
		return this.tz;
	}

	public void setTz(BigDecimal tz) {
		this.tz = tz;
	}

	public String getTzpjDm() {
		return this.tzpjDm;
	}

	public void setTzpjDm(String tzpjDm) {
		this.tzpjDm = tzpjDm;
	}

	public String getTzpjMc() {
		return this.tzpjMc;
	}

	public void setTzpjMc(String tzpjMc) {
		this.tzpjMc = tzpjMc;
	}

	public BigDecimal getSc() {
		return this.sc;
	}

	public void setSc(BigDecimal sc) {
		this.sc = sc;
	}

	public String getScpjDm() {
		return this.scpjDm;
	}

	public void setScpjDm(String scpjDm) {
		this.scpjDm = scpjDm;
	}

	public String getScpjMc() {
		return this.scpjMc;
	}

	public void setScpjMc(String scpjMc) {
		this.scpjMc = scpjMc;
	}

	public String getSgtz() {
		return this.sgtz;
	}

	public void setSgtz(String sgtz) {
		this.sgtz = sgtz;
	}

	public String getSgtzpjDm() {
		return this.sgtzpjDm;
	}

	public void setSgtzpjDm(String sgtzpjDm) {
		this.sgtzpjDm = sgtzpjDm;
	}

	public String getSgtzpjMc() {
		return this.sgtzpjMc;
	}

	public void setSgtzpjMc(String sgtzpjMc) {
		this.sgtzpjMc = sgtzpjMc;
	}

	public String getWyfsDm() {
		return this.wyfsDm;
	}

	public void setWyfsDm(String wyfsDm) {
		this.wyfsDm = wyfsDm;
	}

	public String getWyfsMc() {
		return this.wyfsMc;
	}

	public void setWyfsMc(String wyfsMc) {
		this.wyfsMc = wyfsMc;
	}

	public String getWyfshqkxs() {
		return this.wyfshqkxs;
	}

	public void setWyfshqkxs(String wyfshqkxs) {
		this.wyfshqkxs = wyfshqkxs;
	}

	public Integer getWmrcs() {
		return this.wmrcs;
	}

	public void setWmrcs(Integer wmrcs) {
		this.wmrcs = wmrcs;
	}

	public String getFyqkxs() {
		return this.fyqkxs;
	}

	public void setFyqkxs(String fyqkxs) {
		this.fyqkxs = fyqkxs;
	}

	public String getLczzhtzDm() {
		return this.lczzhtzDm;
	}

	public void setLczzhtzDm(String lczzhtzDm) {
		this.lczzhtzDm = lczzhtzDm;
	}

	public String getLczzhtzdmMc() {
		return this.lczzhtzdmMc;
	}

	public void setLczzhtzdmMc(String lczzhtzdmMc) {
		this.lczzhtzdmMc = lczzhtzdmMc;
	}

	public String getLczzhtzqtxs() {
		return this.lczzhtzqtxs;
	}

	public void setLczzhtzqtxs(String lczzhtzqtxs) {
		this.lczzhtzqtxs = lczzhtzqtxs;
	}

	public String getFzjcqkxs() {
		return this.fzjcqkxs;
	}

	public void setFzjcqkxs(String fzjcqkxs) {
		this.fzjcqkxs = fzjcqkxs;
	}

	public String getZdclxs() {
		return this.zdclxs;
	}

	public void setZdclxs(String zdclxs) {
		this.zdclxs = zdclxs;
	}

	public String getSfswDm() {
		return this.sfswDm;
	}

	public void setSfswDm(String sfswDm) {
		this.sfswDm = sfswDm;
	}

	public String getSfswdmMc() {
		return this.sfswdmMc;
	}

	public void setSfswdmMc(String sfswdmMc) {
		this.sfswdmMc = sfswdmMc;
	}

	public Date getSwsj() {
		return this.swsj;
	}

	public void setSwsj(Date swsj) {
		this.swsj = swsj;
	}

	public String getSwyyDm() {
		return this.swyyDm;
	}

	public void setSwyyDm(String swyyDm) {
		this.swyyDm = swyyDm;
	}

	public String getSwyydmMc() {
		return this.swyydmMc;
	}

	public void setSwyydmMc(String swyydmMc) {
		this.swyydmMc = swyydmMc;
	}

	public Date getXcsfrq() {
		return this.xcsfrq;
	}

	public void setXcsfrq(Date xcsfrq) {
		this.xcsfrq = xcsfrq;
	}

	public String getXcsfdd() {
		return this.xcsfdd;
	}

	public void setXcsfdd(String xcsfdd) {
		this.xcsfdd = xcsfdd;
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

	public String getMqsfzhm() {
		return mqsfzhm;
	}

	public void setMqsfzhm(String mqsfzhm) {
		this.mqsfzhm = mqsfzhm;
	}

	public String getMqxm() {
		return mqxm;
	}

	public void setMqxm(String mqxm) {
		this.mqxm = mqxm;
	}
}