package com.founder.rhip.ehr.entity.child;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name="CH_ETBJ_CSYXZM")
public class ChEtbjCsyxzm implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID",columnDefinition="NUMBER|数据库唯一编号（自增长）|11|",length=11,nullable=true)
	private Long id;

	@Column(name="CSYXZMH",columnDefinition="VARCHAR2|出生医学证明号|50|",length=50,nullable=true)
	private String csyxzmh;

	@Column(name="MPI",columnDefinition="VARCHAR2|个人主索引|40|",length=40,nullable=true)
	private String mpi;

	@Column(name="JKDABH",columnDefinition="VARCHAR2|健康档案编号|50|",length=50,nullable=true)
	private String jkdabh;

	@Column(name="YCFBH",columnDefinition="VARCHAR2|孕产妇编号|50|",length=50,nullable=true)
	private String ycfbh;

	@Column(name="XSEDJBH",columnDefinition="VARCHAR2|新生儿登记编号|50|",length=50,nullable=true)
	private String xsedjbh;

	@Column(name="ZSZBH",columnDefinition="VARCHAR2|准生证编号|50|",length=50,nullable=true)
	private String zszbh;

	@Column(name="XM",columnDefinition="VARCHAR2|姓名|40|",length=40,nullable=true)
	private String xm;

	@Column(name="XB_DM",columnDefinition="VARCHAR2|性别代码|10|",length=10,nullable=true)
	private String xbDm;

	@Column(name="XB",columnDefinition="VARCHAR2|性别|20|",length=20,nullable=true)
	private String xb;

	@Column(name="CSRQ",columnDefinition="DATE|出生日期||",nullable=true)
	private Date csrq;

	@Column(name="CZLX_DM",columnDefinition="VARCHAR2|常住类型代码|50|",length=50,nullable=true)
	private String czlxDm;

	@Column(name="CZLX_MC",columnDefinition="VARCHAR2|常住类型名称|100|",length=100,nullable=true)
	private String czlxMc;

	@Column(name="XZZ_DM",columnDefinition="VARCHAR2|现住址-代码（居委会、村委会）|100|",length=100,nullable=true)
	private String xzzDm;

	@Column(name="XZZ",columnDefinition="VARCHAR2|现住址|500|",length=500,nullable=true)
	private String xzz;

	@Column(name="XSEJKZK_DM",columnDefinition="VARCHAR2|新生儿健康状况代码|50|",length=50,nullable=true)
	private String xsejkzkDm;

	@Column(name="XSEJKZK_MC",columnDefinition="VARCHAR2|新生儿健康状况名称|100|",length=100,nullable=true)
	private String xsejkzkMc;

	@Column(name="CSYZ",columnDefinition="VARCHAR2|出生孕周|50|",length=50,nullable=true)
	private String csyz;

	@Column(name="CSTZ",columnDefinition="NUMBER|出生体重|8|",length=8,nullable=true)
	private BigDecimal cstz;

	@Column(name="CSSC",columnDefinition="NUMBER|出生身长|8|",length=8,nullable=true)
	private BigDecimal cssc;

	@Column(name="TS",columnDefinition="INTEGER|胎数||",nullable=true)
	private Integer ts;

	@Column(name="CSCX",columnDefinition="VARCHAR2|出生次序|50|",length=50,nullable=true)
	private String cscx;

	@Column(name="MQXM",columnDefinition="VARCHAR2|母亲姓名|50|",length=50,nullable=true)
	private String mqxm;

	@Column(name="MQNL",columnDefinition="VARCHAR2|母亲年龄|50|",length=50,nullable=true)
	private String mqnl;

	@Column(name="MQGJ",columnDefinition="VARCHAR2|母亲国籍|50|",length=50,nullable=true)
	private String mqgj;

	@Column(name="MQSFZHM",columnDefinition="VARCHAR2|母亲身份证号码|18|",length=18,nullable=true)
	private String mqsfzhm;

	@Column(name="MQMZ",columnDefinition="VARCHAR2|母亲民族|50|",length=50,nullable=true)
	private String mqmz;

	@Column(name="FQXM",columnDefinition="VARCHAR2|父亲姓名|50|",length=50,nullable=true)
	private String fqxm;

	@Column(name="FQNL",columnDefinition="VARCHAR2|父亲年龄|50|",length=50,nullable=true)
	private String fqnl;

	@Column(name="FQGJ",columnDefinition="VARCHAR2|父亲国籍|50|",length=50,nullable=true)
	private String fqgj;

	@Column(name="FQSFZHM",columnDefinition="VARCHAR2|父亲身份证号码|18|",length=18,nullable=true)
	private String fqsfzhm;

	@Column(name="FQMZ",columnDefinition="VARCHAR2|父亲民族|50|",length=50,nullable=true)
	private String fqmz;

	@Column(name="ZCRYBH",columnDefinition="VARCHAR2|助产人员编号|50|",length=50,nullable=true)
	private String zcrybh;

	@Column(name="ZCRYXM",columnDefinition="VARCHAR2|助产人员姓名|50|",length=50,nullable=true)
	private String zcryxm;

	@Column(name="CSDDFLDM",columnDefinition="VARCHAR2|出生地点分类代码|50|",length=50,nullable=true)
	private String csddfldm;

	/**
	 * 新增八个省市县乡字段
	 */

	@Column(name = "PROVINCE_CODE", columnDefinition = "VARCHAR2|出生地址-省代码(自治区、直辖市)||", length = 50, nullable = true)
	private String province_code;

	@Column(name = "CITY_CODE", columnDefinition = "VARCHAR2|出生地址-市代码(地区、州)||", length = 50, nullable = true)
	private String city_code;

	@Column(name = "COUNTY_CODE", columnDefinition = "VARCHAR2|出生地址-县代码(区)||", length = 50, nullable = true)
	private String county_code;

	@Column(name = "TOWNSHIP_CODE", columnDefinition = "VARCHAR2|出生地址-乡代码(镇、街道办事处)||", length = 50, nullable = true)
	private String townShip_code;

	@Column(name = "PROVINCE_NAME", columnDefinition = "VARCHAR2|出生地址-省名称(自治区、直辖市)||", length = 50, nullable = true)
	private String province_name;

	@Column(name = "CITY_NAME", columnDefinition = "VARCHAR2|出生地址-市名称(地区、州)||", length = 50, nullable = true)
	private String city_name;

	@Column(name = "COUNTY_NAME", columnDefinition = "VARCHAR2|出生地址-县名称(区)||", length = 50, nullable = true)
	private String county_name;

	@Column(name = "TOWNSHIP_NAME", columnDefinition = "VARCHAR2|出生地址-乡名称(镇、街道办事处)||", length = 50, nullable = true)
	private String townShip_name;


	@Column(name="CSDDFL",columnDefinition="VARCHAR2|出生地点分类|50|",length=50,nullable=true)
	private String csddfl;

	@Column(name="QTCSDD_MC",columnDefinition="VARCHAR2|其他出生地点名称|100|",length=100,nullable=true)
	private String qtcsddMc;

	@Column(name="ZCJG_DM",columnDefinition="VARCHAR2|助产机构代码|100|",length=100,nullable=true)
	private String zcjgDm;

	@Column(name="ZCJG_MC",columnDefinition="VARCHAR2|助产机构名称|200|",length=200,nullable=true)
	private String zcjgMc;

	@Column(name="QRQ",columnDefinition="DATE|签发日期||",nullable=true)
	private Date qrq;

	@Column(name="QZJG_DM",columnDefinition="VARCHAR2|签证机构代码|100|",length=100,nullable=true)
	private String qzjgDm;

	@Column(name="QZJG_MC",columnDefinition="VARCHAR2|签证机构名称|200|",length=200,nullable=true)
	private String qzjgMc;

	@Column(name="QRYBH",columnDefinition="VARCHAR2|签发人员编号|50|",length=50,nullable=true)
	private String qrybh;

	@Column(name="QRYXM",columnDefinition="VARCHAR2|签发人员姓名|50|",length=50,nullable=true)
	private String qryxm;

	@Column(name="BZ",columnDefinition="VARCHAR2|备注|4000|",length=4000,nullable=true)
	private String bz;

	@Column(name="DJSJ",columnDefinition="DATE|登记时间(系统)||",nullable=true)
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

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCsyxzmh() {
		return this.csyxzmh;
	}

	public void setCsyxzmh(String csyxzmh) {
		this.csyxzmh = csyxzmh;
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

	public String getXsedjbh() {
		return this.xsedjbh;
	}

	public void setXsedjbh(String xsedjbh) {
		this.xsedjbh = xsedjbh;
	}

	public String getZszbh() {
		return this.zszbh;
	}

	public void setZszbh(String zszbh) {
		this.zszbh = zszbh;
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

	public String getCzlxDm() {
		return this.czlxDm;
	}

	public void setCzlxDm(String czlxDm) {
		this.czlxDm = czlxDm;
	}

	public String getCzlxMc() {
		return this.czlxMc;
	}

	public void setCzlxMc(String czlxMc) {
		this.czlxMc = czlxMc;
	}

	public String getXzzDm() {
		return this.xzzDm;
	}

	public void setXzzDm(String xzzDm) {
		this.xzzDm = xzzDm;
	}

	public String getXzz() {
		return this.xzz;
	}

	public void setXzz(String xzz) {
		this.xzz = xzz;
	}

	public String getXsejkzkDm() {
		return this.xsejkzkDm;
	}

	public void setXsejkzkDm(String xsejkzkDm) {
		this.xsejkzkDm = xsejkzkDm;
	}

	public String getXsejkzkMc() {
		return this.xsejkzkMc;
	}

	public void setXsejkzkMc(String xsejkzkMc) {
		this.xsejkzkMc = xsejkzkMc;
	}

	public String getCsyz() {
		return this.csyz;
	}

	public void setCsyz(String csyz) {
		this.csyz = csyz;
	}

	public BigDecimal getCstz() {
		return this.cstz;
	}

	public void setCstz(BigDecimal cstz) {
		this.cstz = cstz;
	}

	public BigDecimal getCssc() {
		return this.cssc;
	}

	public void setCssc(BigDecimal cssc) {
		this.cssc = cssc;
	}

	public Integer getTs() {
		return this.ts;
	}

	public void setTs(Integer ts) {
		this.ts = ts;
	}

	public String getCscx() {
		return this.cscx;
	}

	public void setCscx(String cscx) {
		this.cscx = cscx;
	}

	public String getMqxm() {
		return this.mqxm;
	}

	public void setMqxm(String mqxm) {
		this.mqxm = mqxm;
	}

	public String getMqnl() {
		return this.mqnl;
	}

	public void setMqnl(String mqnl) {
		this.mqnl = mqnl;
	}

	public String getMqgj() {
		return this.mqgj;
	}

	public void setMqgj(String mqgj) {
		this.mqgj = mqgj;
	}

	public String getMqsfzhm() {
		return this.mqsfzhm;
	}

	public void setMqsfzhm(String mqsfzhm) {
		this.mqsfzhm = mqsfzhm;
	}

	public String getMqmz() {
		return this.mqmz;
	}

	public void setMqmz(String mqmz) {
		this.mqmz = mqmz;
	}

	public String getFqxm() {
		return this.fqxm;
	}

	public void setFqxm(String fqxm) {
		this.fqxm = fqxm;
	}

	public String getFqnl() {
		return this.fqnl;
	}

	public void setFqnl(String fqnl) {
		this.fqnl = fqnl;
	}

	public String getFqgj() {
		return this.fqgj;
	}

	public void setFqgj(String fqgj) {
		this.fqgj = fqgj;
	}

	public String getFqsfzhm() {
		return this.fqsfzhm;
	}

	public void setFqsfzhm(String fqsfzhm) {
		this.fqsfzhm = fqsfzhm;
	}

	public String getFqmz() {
		return this.fqmz;
	}

	public void setFqmz(String fqmz) {
		this.fqmz = fqmz;
	}

	public String getZcrybh() {
		return this.zcrybh;
	}

	public void setZcrybh(String zcrybh) {
		this.zcrybh = zcrybh;
	}

	public String getZcryxm() {
		return this.zcryxm;
	}

	public void setZcryxm(String zcryxm) {
		this.zcryxm = zcryxm;
	}

	public String getCsddfldm() {
		return this.csddfldm;
	}

	public void setCsddfldm(String csddfldm) {
		this.csddfldm = csddfldm;
	}

	public String getCsddfl() {
		return this.csddfl;
	}

	public void setCsddfl(String csddfl) {
		this.csddfl = csddfl;
	}

	public String getQtcsddMc() {
		return this.qtcsddMc;
	}

	public void setQtcsddMc(String qtcsddMc) {
		this.qtcsddMc = qtcsddMc;
	}

	public String getZcjgDm() {
		return this.zcjgDm;
	}

	public void setZcjgDm(String zcjgDm) {
		this.zcjgDm = zcjgDm;
	}

	public String getZcjgMc() {
		return this.zcjgMc;
	}

	public void setZcjgMc(String zcjgMc) {
		this.zcjgMc = zcjgMc;
	}

	public Date getQrq() {
		return this.qrq;
	}

	public void setQrq(Date qrq) {
		this.qrq = qrq;
	}

	public String getQzjgDm() {
		return this.qzjgDm;
	}

	public void setQzjgDm(String qzjgDm) {
		this.qzjgDm = qzjgDm;
	}

	public String getQzjgMc() {
		return this.qzjgMc;
	}

	public void setQzjgMc(String qzjgMc) {
		this.qzjgMc = qzjgMc;
	}

	public String getQrybh() {
		return this.qrybh;
	}

	public void setQrybh(String qrybh) {
		this.qrybh = qrybh;
	}

	public String getQryxm() {
		return this.qryxm;
	}

	public void setQryxm(String qryxm) {
		this.qryxm = qryxm;
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

	public String getProvince_code() {
		return province_code;
	}

	public String getCity_code() {
		return city_code;
	}

	public String getCounty_code() {
		return county_code;
	}

	public String getTownShip_code() {
		return townShip_code;
	}

	public String getProvince_name() {
		return province_name;
	}

	public String getCity_name() {
		return city_name;
	}

	public String getCounty_name() {
		return county_name;
	}

	public String getTownShip_name() {
		return townShip_name;
	}

	public void setProvince_code(String province_code) {
		this.province_code = province_code;
	}

	public void setCity_code(String city_code) {
		this.city_code = city_code;
	}

	public void setCounty_code(String county_code) {
		this.county_code = county_code;
	}

	public void setTownShip_code(String townShip_code) {
		this.townShip_code = townShip_code;
	}

	public void setProvince_name(String province_name) {
		this.province_name = province_name;
	}

	public void setCity_name(String city_name) {
		this.city_name = city_name;
	}

	public void setCounty_name(String county_name) {
		this.county_name = county_name;
	}

	public void setTownShip_name(String townShip_name) {
		this.townShip_name = townShip_name;
	}
}