package com.founder.rhip.ehr.entity.women;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name="WH_YCFBJ_JD")
public class WhYcfbjJd implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID",columnDefinition="NUMBER|数据库唯一编号（自增长）|11|",length=11,nullable=false)
	private Long id;

	@Id
	@Column(name="YCFBH",columnDefinition="VARCHAR2|孕产妇编号||",nullable=false)
	private String ycfbh;

	@Column(name="MPI",columnDefinition="VARCHAR2|个人主索引|40|",length=40,nullable=false)
	private String mpi;

	@Column(name="JKDABH",columnDefinition="VARCHAR2|健康档案编号|50|",length=50,nullable=false)
	private String jkdabh;

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

	@Column(name="CZLX_DM",columnDefinition="VARCHAR2|常住类型代码|50|",length=50,nullable=false)
	private String czlxDm;

	@Column(name="CZLX_MC",columnDefinition="VARCHAR2|常住类型名称|100|",length=100,nullable=false)
	private String czlxMc;

	@Column(name="XZZ_DM",columnDefinition="VARCHAR2|现住址-代码（居委会、村委会）|100|",length=100,nullable=false)
	private String xzzDm;

	@Column(name="XZZ",columnDefinition="VARCHAR2|现住址|500|",length=500,nullable=false)
	private String xzz;

	@Column(name="HJDZ_DM",columnDefinition="VARCHAR2|户籍地址-代码（居委会、村委会）|100|",length=100,nullable=false)
	private String hjdzDm;

	@Column(name="HJDZ",columnDefinition="VARCHAR2|户籍地址|500|",length=500,nullable=false)
	private String hjdz;

	@Column(name="SFZJLB_DM",columnDefinition="VARCHAR2|身份证件类别代码|50|",length=50,nullable=false)
	private String sfzjlbDm;

	@Column(name="SFZJLB_MC",columnDefinition="VARCHAR2|身份证件类别名称|100|",length=100,nullable=false)
	private String sfzjlbMc;

	@Column(name="SFZJH",columnDefinition="VARCHAR2|身份证件号|40|",length=40,nullable=false)
	private String sfzjh;

	@Column(name="TBYZ",columnDefinition="VARCHAR2|填表孕周|40|",length=40,nullable=true)
	private String tbyz;

	@Column(name="YC",columnDefinition="INTEGER|孕次||",nullable=true)
	private Integer yc;

	@Column(name="ZFXM",columnDefinition="VARCHAR2|丈夫姓名|40|",length=40,nullable=true)
	private String zfxm;

	@Column(name="ZFDW",columnDefinition="VARCHAR2|丈夫单位|50|",length=50,nullable=true)
	private String zfdw;

	@Column(name="ZFLXDH",columnDefinition="VARCHAR2|丈夫联系电话|20|",length=20,nullable=true)
	private String zflxdh;

	@Column(name="ZFCSRQ",columnDefinition="DATE|丈夫出生日期||",nullable=true)
	private Date zfcsrq;

	@Column(name="ZFNL",columnDefinition="VARCHAR2|丈夫年龄|40|",length=40,nullable=true)
	private String zfnl;

	@Column(name="SG",columnDefinition="NUMBER|身高|8|",length=8,nullable=true)
	private BigDecimal sg;

	@Column(name="TZ",columnDefinition="NUMBER|体重|8|",length=8,nullable=true)
	private BigDecimal tz;

	@Column(name="TZZS",columnDefinition="NUMBER|体质指数|8|",length=8,nullable=true)
	private BigDecimal tzzs;

	@Column(name="ABO_DM",columnDefinition="VARCHAR2|ABO血型代码|50|",length=50,nullable=true)
	private String aboDm;

	@Column(name="ABO_MC",columnDefinition="VARCHAR2|ABO血型名称|100|",length=100,nullable=true)
	private String aboMc;

	@Column(name="SFGW_DM",columnDefinition="VARCHAR2|是否高危代码|50|",length=50,nullable=true)
	private String sfgwDm;

	@Column(name="SFGW_MC",columnDefinition="VARCHAR2|是否高危名称|100|",length=100,nullable=true)
	private String sfgwMc;

	@Column(name="YCQGWYS_DM",columnDefinition="VARCHAR2|孕产期高危因素代码|50|",length=50,nullable=true)
	private String ycqgwysDm;

	@Column(name="YCQGWYS_MC",columnDefinition="VARCHAR2|孕产期高危因素名称|200|",length=200,nullable=true)
	private String ycqgwysMc;

	@Column(name="YCQQTGWYS",columnDefinition="VARCHAR2|孕产期其他高危因素|4000|",length=4000,nullable=true)
	private String ycqqtgwys;

	@Column(name="GWPD_DM",columnDefinition="VARCHAR2|高危评定代码|50|",length=50,nullable=true)
	private String gwpdDm;

	@Column(name="GWPDDM_MC",columnDefinition="VARCHAR2|高危评定代码名称|100|",length=100,nullable=true)
	private String gwpddmMc;

	@Column(name="GWPF",columnDefinition="INTEGER|高危评分||",nullable=true)
	private Integer gwpf;

	@Column(name="SFZZ_DM",columnDefinition="VARCHAR2|是否转诊代码|50|",length=50,nullable=true)
	private String sfzzDm;

	@Column(name="SFZZ_MC",columnDefinition="VARCHAR2|是否转诊名称|100|",length=100,nullable=true)
	private String sfzzMc;

	@Column(name="ZZYY",columnDefinition="VARCHAR2|转诊原因|4000|",length=4000,nullable=true)
	private String zzyy;

	@Column(name="ZZJG_DM",columnDefinition="VARCHAR2|转诊机构代码|100|",length=100,nullable=true)
	private String zzjgDm;

	@Column(name="ZZJG_MC",columnDefinition="VARCHAR2|转诊机构名称|200|",length=200,nullable=true)
	private String zzjgMc;

	@Column(name="ZZJGKSBM",columnDefinition="VARCHAR2|转诊机构科室编码|50|",length=50,nullable=true)
	private String zzjgksbm;

	@Column(name="ZZJGKSMC",columnDefinition="VARCHAR2|转诊机构科室名称|100|",length=100,nullable=true)
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

	@Column(name="JABZ_DM",columnDefinition="VARCHAR2|结案标志代码|50|",length=50,nullable=true)
	private String jabzDm;

	@Column(name="JABZ",columnDefinition="VARCHAR2|结案标志|200|",length=200,nullable=true)
	private String jabz;

	@Column(name="JDJG_DM",columnDefinition="VARCHAR2|建档机构代码|100|",length=100,nullable=true)
	private String jdjgDm;

	@Column(name="JDJG_MC",columnDefinition="VARCHAR2|建档机构名称|200|",length=200,nullable=true)
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

	@Column(name="JDRQ",columnDefinition="DATE|建档日期||",nullable=true)
	private Date jdrq;

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

	@Column(name="CLINIC_ORGAN_CODE",columnDefinition="VARCHAR|就诊机构代码|50|",length=50,nullable=true)
	private String clinicOrganCode;

	@Column(name="CLINIC_ORGAN_NAME",columnDefinition="VARCHAR|就诊机构名称|100|",length=100,nullable=true)
	private String clinicOrganName;

	@Column(name="BUSINESS_LOCAL_ID",columnDefinition="VARCHAR|业务数据本地唯一id|32|",length=32,nullable=true)
	private String businessLocalId;

	@Id
	@Column(name="UPLOAD_TIME",columnDefinition="DATE|系统上传时间||",nullable=false)
	private Date uploadTime;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getYcfbh() {
		return this.ycfbh;
	}

	public void setYcfbh(String ycfbh) {
		this.ycfbh = ycfbh;
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

	public String getHjdzDm() {
		return this.hjdzDm;
	}

	public void setHjdzDm(String hjdzDm) {
		this.hjdzDm = hjdzDm;
	}

	public String getHjdz() {
		return this.hjdz;
	}

	public void setHjdz(String hjdz) {
		this.hjdz = hjdz;
	}

	public String getSfzjlbDm() {
		return this.sfzjlbDm;
	}

	public void setSfzjlbDm(String sfzjlbDm) {
		this.sfzjlbDm = sfzjlbDm;
	}

	public String getSfzjlbMc() {
		return this.sfzjlbMc;
	}

	public void setSfzjlbMc(String sfzjlbMc) {
		this.sfzjlbMc = sfzjlbMc;
	}

	public String getSfzjh() {
		return this.sfzjh;
	}

	public void setSfzjh(String sfzjh) {
		this.sfzjh = sfzjh;
	}

	public String getTbyz() {
		return this.tbyz;
	}

	public void setTbyz(String tbyz) {
		this.tbyz = tbyz;
	}

	public Integer getYc() {
		return this.yc;
	}

	public void setYc(Integer yc) {
		this.yc = yc;
	}

	public String getZfxm() {
		return this.zfxm;
	}

	public void setZfxm(String zfxm) {
		this.zfxm = zfxm;
	}

	public String getZfdw() {
		return this.zfdw;
	}

	public void setZfdw(String zfdw) {
		this.zfdw = zfdw;
	}

	public String getZflxdh() {
		return this.zflxdh;
	}

	public void setZflxdh(String zflxdh) {
		this.zflxdh = zflxdh;
	}

	public Date getZfcsrq() {
		return this.zfcsrq;
	}

	public void setZfcsrq(Date zfcsrq) {
		this.zfcsrq = zfcsrq;
	}

	public String getZfnl() {
		return this.zfnl;
	}

	public void setZfnl(String zfnl) {
		this.zfnl = zfnl;
	}

	public BigDecimal getSg() {
		return this.sg;
	}

	public void setSg(BigDecimal sg) {
		this.sg = sg;
	}

	public BigDecimal getTz() {
		return this.tz;
	}

	public void setTz(BigDecimal tz) {
		this.tz = tz;
	}

	public BigDecimal getTzzs() {
		return this.tzzs;
	}

	public void setTzzs(BigDecimal tzzs) {
		this.tzzs = tzzs;
	}

	public String getAboDm() {
		return this.aboDm;
	}

	public void setAboDm(String aboDm) {
		this.aboDm = aboDm;
	}

	public String getAboMc() {
		return this.aboMc;
	}

	public void setAboMc(String aboMc) {
		this.aboMc = aboMc;
	}

	public String getSfgwDm() {
		return this.sfgwDm;
	}

	public void setSfgwDm(String sfgwDm) {
		this.sfgwDm = sfgwDm;
	}

	public String getSfgwMc() {
		return this.sfgwMc;
	}

	public void setSfgwMc(String sfgwMc) {
		this.sfgwMc = sfgwMc;
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

	public String getSfzzDm() {
		return this.sfzzDm;
	}

	public void setSfzzDm(String sfzzDm) {
		this.sfzzDm = sfzzDm;
	}

	public String getSfzzMc() {
		return this.sfzzMc;
	}

	public void setSfzzMc(String sfzzMc) {
		this.sfzzMc = sfzzMc;
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