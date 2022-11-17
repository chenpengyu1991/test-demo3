package com.founder.rhip.ehr.entity.child;

import com.founder.rhip.ehr.service.export.Item;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="CH_ETBJ_JD")
public class ChEtbjJd implements Serializable {

	private static final long serialVersionUID = 1L;

	@Item(index=0,column = "序号")
	@Transient
	private String num;

	@Id
	@Column(name="ID",columnDefinition="NUMBER|数据库唯一编号（自增长）|11|",length=11,nullable=true)
	private Long id;

	@Column(name="ETXXBH",columnDefinition="VARCHAR2|儿童信息编号|50|",length=50,nullable=true)
	private String etxxbh;

	@Column(name="MPI",columnDefinition="VARCHAR2|个人主索引|40|",length=40,nullable=true)
	private String mpi;

	@Column(name="JKDABH",columnDefinition="VARCHAR2|健康档案编号|50|",length=50,nullable=true)
	private String jkdabh;

	@Column(name="CSYXZMH",columnDefinition="VARCHAR2|出生医学证明号|50|",length=50,nullable=true)
	private String csyxzmh;

	@Item(index=1,column = "儿童姓名")
	@Column(name="XM",columnDefinition="VARCHAR2|姓名|200|",length=200,nullable=true)
	private String xm;

	@Column(name="XB_DM",columnDefinition="VARCHAR2|性别代码|10|",length=10,nullable=true)
	private String xbDm;

	@Item(index=2,column = "性别")
	@Column(name="XB",columnDefinition="VARCHAR2|性别|20|",length=20,nullable=true)
	private String xb;

	@Item(index=3,column = "出生日期")
	@Column(name="CSRQ",columnDefinition="DATE|出生日期||",nullable=true)
	private Date csrq;

	@Column(name="CZLX_DM",columnDefinition="VARCHAR2|常住类型代码|50|",length=50,nullable=true)
	private String czlxDm;

	@Item(index=6,column = "户籍")
	@Column(name="CZLX_MC",columnDefinition="VARCHAR2|常住类型名称|100|",length=100,nullable=true)
	private String czlxMc;

	@Column(name="XZZ_DM",columnDefinition="VARCHAR2|现住址-代码（居委会、村委会）|100|",length=100,nullable=true)
	private String xzzDm;

	@Item(index=7,column = "现住址")
	@Column(name="XZZ",columnDefinition="VARCHAR2|现住址|500|",length=500,nullable=true)
	private String xzz;

	@Column(name="HJDZ_DM",columnDefinition="VARCHAR2|户籍地址-代码（居委会、村委会）|100|",length=100,nullable=true)
	private String hjdzDm;

	@Column(name="HJDZ",columnDefinition="VARCHAR2|户籍地址|500|",length=500,nullable=true)
	private String hjdz;

	@Column(name="SFZJLB_DM",columnDefinition="VARCHAR2|身份证件类别代码|50|",length=50,nullable=true)
	private String sfzjlbDm;

	@Column(name="SFZJLB_MC",columnDefinition="VARCHAR2|身份证件类别名称|100|",length=100,nullable=true)
	private String sfzjlbMc;

	@Column(name="SFZJH",columnDefinition="VARCHAR2|身份证件号|40|",length=40,nullable=true)
	private String sfzjh;

	@Column(name="YZBM",columnDefinition="VARCHAR2|邮政编码|10|",length=10,nullable=true)
	private String yzbm;

	@Item(index=4,column = "母亲姓名")
	@Column(name="MQXM",columnDefinition="VARCHAR2|母亲姓名|200|",length=200,nullable=true)
	private String mqxm;

	@Column(name="MQZY_DM",columnDefinition="VARCHAR2|母亲职业代码|100|",length=100,nullable=true)
	private String mqzyDm;

	@Column(name="MQZY",columnDefinition="VARCHAR2|母亲职业|100|",length=100,nullable=true)
	private String mqzy;

	@Column(name="MQGZDW",columnDefinition="VARCHAR2|母亲工作单位|500|",length=500,nullable=true)
	private String mqgzdw;

	@Column(name="MQLXDH",columnDefinition="VARCHAR2|母亲联系电话|20|",length=20,nullable=true)
	private String mqlxdh;

	@Item(index=8,column = "电话（母）")
	@Column(name="MQWHCD_DM",columnDefinition="VARCHAR2|母亲文化程度代码|50|",length=50,nullable=true)
	private String mqwhcdDm;

	@Column(name="MQWHCD_CM",columnDefinition="VARCHAR2|母亲文化程度名称|100|",length=100,nullable=true)
	private String mqwhcdCm;

	@Column(name="MQCSRQ",columnDefinition="DATE|母亲出生日期||",nullable=true)
	private Date mqcsrq;

	@Column(name="MQSFZHM",columnDefinition="VARCHAR2|母亲身份证号码|18|",length=18,nullable=true)
	private String mqsfzhm;

	@Column(name="MQJKZK_DM",columnDefinition="VARCHAR2|母亲健康状况代码|50|",length=50,nullable=true)
	private String mqjkzkDm;

	@Column(name="MQJKZK_MC",columnDefinition="VARCHAR2|母亲健康状况名称|100|",length=100,nullable=true)
	private String mqjkzkMc;

	@Column(name="MQJKZKXS",columnDefinition="VARCHAR2|母亲健康状况详述|4000|",length=4000,nullable=true)
	private String mqjkzkxs;

	@Column(name="FQXM",columnDefinition="VARCHAR2|父亲姓名|200|",length=200,nullable=true)
	private String fqxm;

	@Column(name="FQZY_DM",columnDefinition="VARCHAR2|父亲职业代码|50|",length=50,nullable=true)
	private String fqzyDm;

	@Column(name="FQZY",columnDefinition="VARCHAR2|父亲职业|50|",length=50,nullable=true)
	private String fqzy;

	@Column(name="FQGZDW",columnDefinition="VARCHAR2|父亲工作单位|500|",length=500,nullable=true)
	private String fqgzdw;

	@Column(name="FQLXDH",columnDefinition="VARCHAR2|父亲联系电话|20|",length=20,nullable=true)
	private String fqlxdh;

	@Column(name="FQWHCD_DM",columnDefinition="VARCHAR2|父亲文化程度代码|50|",length=50,nullable=true)
	private String fqwhcdDm;

	@Column(name="FQWHCD_MC",columnDefinition="VARCHAR2|父亲文化程度名称|50|",length=50,nullable=true)
	private String fqwhcdMc;

	@Column(name="FQCSRQ",columnDefinition="DATE|父亲出生日期||",nullable=true)
	private Date fqcsrq;

	@Column(name="FQSFZHM",columnDefinition="VARCHAR2|父亲身份证号码|18|",length=18,nullable=true)
	private String fqsfzhm;

	@Column(name="FQJKZK_DM",columnDefinition="VARCHAR2|父亲健康状况代码|50|",length=50,nullable=true)
	private String fqjkzkDm;

	@Column(name="FQJKZK_MC",columnDefinition="VARCHAR2|父亲健康状况名称|100|",length=100,nullable=true)
	private String fqjkzkMc;

	@Column(name="FQJKZKXS",columnDefinition="VARCHAR2|父亲健康状况详述|4000|",length=4000,nullable=true)
	private String fqjkzkxs;

	@Column(name="FMFS_DM",columnDefinition="VARCHAR2|分娩方式代码|50|",length=50,nullable=true)
	private String fmfsDm;

	@Column(name="FMFS_MC",columnDefinition="VARCHAR2|分娩方式名称|100|",length=100,nullable=true)
	private String fmfsMc;

	@Column(name="FMFSXS",columnDefinition="VARCHAR2|分娩方式详述|4000|",length=4000,nullable=true)
	private String fmfsxs;

	@Column(name="YWXTXHYCDXXJBJZS_DM",columnDefinition="VARCHAR2|有无先天性或遗传代谢性疾病家族史代码|50|",length=50,nullable=true)
	private String ywxtxhycdxxjbjzsDm;

	@Column(name="YWXTXHYCDXXJBJZS",columnDefinition="VARCHAR2|有无先天性或遗传代谢性疾病家族史|10|",length=10,nullable=true)
	private String ywxtxhycdxxjbjzs;

	@Column(name="XTXHYCDXXJBJZSXS",columnDefinition="VARCHAR2|先天性或遗传代谢性疾病家族史详述|4000|",length=4000,nullable=true)
	private String xtxhycdxxjbjzsxs;

	@Column(name="ZCJG_DM",columnDefinition="VARCHAR2|助产机构代码|100|",length=100,nullable=true)
	private String zcjgDm;

	@Item(index=5,column = "分娩医院")
	@Column(name="ZCJG_MC",columnDefinition="VARCHAR2|助产机构名称|200|",length=200,nullable=true)
	private String zcjgMc;

	@Column(name="ZCRYXM",columnDefinition="VARCHAR2|助产机构姓名|30|",length=30,nullable=true)
	private String zcryxm;

	@Column(name="SFCSQX_DM",columnDefinition="VARCHAR2|是否出生缺陷代码|50|",length=50,nullable=true)
	private String sfcsqxDm;

	@Column(name="SFCSQX_MC",columnDefinition="VARCHAR2|是否出生缺陷名称|100|",length=100,nullable=true)
	private String sfcsqxMc;

	@Column(name="CSQXLB_DM",columnDefinition="VARCHAR2|出生缺陷类别代码|50|",length=50,nullable=true)
	private String csqxlbDm;

	@Column(name="CSQXLBDM_MC",columnDefinition="VARCHAR2|出生缺陷类别代码名称|100|",length=100,nullable=true)
	private String csqxlbdmMc;

	@Column(name="CSQXXS",columnDefinition="VARCHAR2|出生缺陷详述|4000|",length=4000,nullable=true)
	private String csqxxs;

	@Column(name="SFTRETBZ_DM",columnDefinition="VARCHAR2|是否体弱儿童标志代码|50|",length=50,nullable=true)
	private String sftretbzDm;

	@Column(name="SFTRETBZ_MC",columnDefinition="VARCHAR2|是否体弱儿童标志名称|100|",length=100,nullable=true)
	private String sftretbzMc;

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

	@Column(name="BZ",columnDefinition="VARCHAR2|备注|4000|",length=4000,nullable=true)
	private String bz;

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

	@Item(index=9,column = "新生儿访视")
	@Transient
	private String isFoShi;

	@Item(index=10,column = "1月龄")
	@Transient
	private String isOneMonth;

	@Item(index=11,column = "3月龄")
	@Transient
	private String isThreeMonth;

	@Item(index=12,column = "6月龄")
	@Transient
	private String isSixMonth;

	@Item(index=13,column = "8月龄")
	@Transient
	private String isEightMonth;

	@Item(index=14,column = "12月龄")
	@Transient
	private String isTwelveMonth;

	@Item(index=15,column = "18月龄")
	@Transient
	private String isEighteenMonth;

	@Item(index=16,column = "24月龄")
	@Transient
	private String isTwentyFourMonth;

	@Item(index=17,column = "30月龄")
	@Transient
	private String isThirtyMonth;

	@Item(index=18,column = "3岁")
	@Transient
	private String isThreeYear;

	@Item(index=19,column = "4岁")
	@Transient
	private String isFourYear;

	@Item(index=20,column = "5岁")
	@Transient
	private String isFiveYear;

	@Item(index=21,column = "6岁")
	@Transient
	private String isSixYear;
	
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEtxxbh() {
		return this.etxxbh;
	}

	public void setEtxxbh(String etxxbh) {
		this.etxxbh = etxxbh;
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

	public String getCsyxzmh() {
		return this.csyxzmh;
	}

	public void setCsyxzmh(String csyxzmh) {
		this.csyxzmh = csyxzmh;
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

	public String getYzbm() {
		return this.yzbm;
	}

	public void setYzbm(String yzbm) {
		this.yzbm = yzbm;
	}

	public String getMqxm() {
		return this.mqxm;
	}

	public void setMqxm(String mqxm) {
		this.mqxm = mqxm;
	}

	public String getMqzyDm() {
		return this.mqzyDm;
	}

	public void setMqzyDm(String mqzyDm) {
		this.mqzyDm = mqzyDm;
	}

	public String getMqzy() {
		return this.mqzy;
	}

	public void setMqzy(String mqzy) {
		this.mqzy = mqzy;
	}

	public String getMqgzdw() {
		return this.mqgzdw;
	}

	public void setMqgzdw(String mqgzdw) {
		this.mqgzdw = mqgzdw;
	}

	public String getMqlxdh() {
		return this.mqlxdh;
	}

	public void setMqlxdh(String mqlxdh) {
		this.mqlxdh = mqlxdh;
	}

	public String getMqwhcdDm() {
		return this.mqwhcdDm;
	}

	public void setMqwhcdDm(String mqwhcdDm) {
		this.mqwhcdDm = mqwhcdDm;
	}

	public String getMqwhcdCm() {
		return this.mqwhcdCm;
	}

	public void setMqwhcdCm(String mqwhcdCm) {
		this.mqwhcdCm = mqwhcdCm;
	}

	public Date getMqcsrq() {
		return this.mqcsrq;
	}

	public void setMqcsrq(Date mqcsrq) {
		this.mqcsrq = mqcsrq;
	}

	public String getMqsfzhm() {
		return this.mqsfzhm;
	}

	public void setMqsfzhm(String mqsfzhm) {
		this.mqsfzhm = mqsfzhm;
	}

	public String getMqjkzkDm() {
		return this.mqjkzkDm;
	}

	public void setMqjkzkDm(String mqjkzkDm) {
		this.mqjkzkDm = mqjkzkDm;
	}

	public String getMqjkzkMc() {
		return this.mqjkzkMc;
	}

	public void setMqjkzkMc(String mqjkzkMc) {
		this.mqjkzkMc = mqjkzkMc;
	}

	public String getMqjkzkxs() {
		return this.mqjkzkxs;
	}

	public void setMqjkzkxs(String mqjkzkxs) {
		this.mqjkzkxs = mqjkzkxs;
	}

	public String getFqxm() {
		return this.fqxm;
	}

	public void setFqxm(String fqxm) {
		this.fqxm = fqxm;
	}

	public String getFqzyDm() {
		return this.fqzyDm;
	}

	public void setFqzyDm(String fqzyDm) {
		this.fqzyDm = fqzyDm;
	}

	public String getFqzy() {
		return this.fqzy;
	}

	public void setFqzy(String fqzy) {
		this.fqzy = fqzy;
	}

	public String getFqgzdw() {
		return this.fqgzdw;
	}

	public void setFqgzdw(String fqgzdw) {
		this.fqgzdw = fqgzdw;
	}

	public String getFqlxdh() {
		return this.fqlxdh;
	}

	public void setFqlxdh(String fqlxdh) {
		this.fqlxdh = fqlxdh;
	}

	public String getFqwhcdDm() {
		return this.fqwhcdDm;
	}

	public void setFqwhcdDm(String fqwhcdDm) {
		this.fqwhcdDm = fqwhcdDm;
	}

	public String getFqwhcdMc() {
		return this.fqwhcdMc;
	}

	public void setFqwhcdMc(String fqwhcdMc) {
		this.fqwhcdMc = fqwhcdMc;
	}

	public Date getFqcsrq() {
		return this.fqcsrq;
	}

	public void setFqcsrq(Date fqcsrq) {
		this.fqcsrq = fqcsrq;
	}

	public String getFqsfzhm() {
		return this.fqsfzhm;
	}

	public void setFqsfzhm(String fqsfzhm) {
		this.fqsfzhm = fqsfzhm;
	}

	public String getFqjkzkDm() {
		return this.fqjkzkDm;
	}

	public void setFqjkzkDm(String fqjkzkDm) {
		this.fqjkzkDm = fqjkzkDm;
	}

	public String getFqjkzkMc() {
		return this.fqjkzkMc;
	}

	public void setFqjkzkMc(String fqjkzkMc) {
		this.fqjkzkMc = fqjkzkMc;
	}

	public String getFqjkzkxs() {
		return this.fqjkzkxs;
	}

	public void setFqjkzkxs(String fqjkzkxs) {
		this.fqjkzkxs = fqjkzkxs;
	}

	public String getFmfsDm() {
		return this.fmfsDm;
	}

	public void setFmfsDm(String fmfsDm) {
		this.fmfsDm = fmfsDm;
	}

	public String getFmfsMc() {
		return this.fmfsMc;
	}

	public void setFmfsMc(String fmfsMc) {
		this.fmfsMc = fmfsMc;
	}

	public String getFmfsxs() {
		return this.fmfsxs;
	}

	public void setFmfsxs(String fmfsxs) {
		this.fmfsxs = fmfsxs;
	}

	public String getYwxtxhycdxxjbjzsDm() {
		return this.ywxtxhycdxxjbjzsDm;
	}

	public void setYwxtxhycdxxjbjzsDm(String ywxtxhycdxxjbjzsDm) {
		this.ywxtxhycdxxjbjzsDm = ywxtxhycdxxjbjzsDm;
	}

	public String getYwxtxhycdxxjbjzs() {
		return this.ywxtxhycdxxjbjzs;
	}

	public void setYwxtxhycdxxjbjzs(String ywxtxhycdxxjbjzs) {
		this.ywxtxhycdxxjbjzs = ywxtxhycdxxjbjzs;
	}

	public String getXtxhycdxxjbjzsxs() {
		return this.xtxhycdxxjbjzsxs;
	}

	public void setXtxhycdxxjbjzsxs(String xtxhycdxxjbjzsxs) {
		this.xtxhycdxxjbjzsxs = xtxhycdxxjbjzsxs;
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

	public String getZcryxm() {
		return this.zcryxm;
	}

	public void setZcryxm(String zcryxm) {
		this.zcryxm = zcryxm;
	}

	public String getSfcsqxDm() {
		return this.sfcsqxDm;
	}

	public void setSfcsqxDm(String sfcsqxDm) {
		this.sfcsqxDm = sfcsqxDm;
	}

	public String getSfcsqxMc() {
		return this.sfcsqxMc;
	}

	public void setSfcsqxMc(String sfcsqxMc) {
		this.sfcsqxMc = sfcsqxMc;
	}

	public String getCsqxlbDm() {
		return this.csqxlbDm;
	}

	public void setCsqxlbDm(String csqxlbDm) {
		this.csqxlbDm = csqxlbDm;
	}

	public String getCsqxlbdmMc() {
		return this.csqxlbdmMc;
	}

	public void setCsqxlbdmMc(String csqxlbdmMc) {
		this.csqxlbdmMc = csqxlbdmMc;
	}

	public String getCsqxxs() {
		return this.csqxxs;
	}

	public void setCsqxxs(String csqxxs) {
		this.csqxxs = csqxxs;
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

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getIsFoShi() {
		return isFoShi;
	}

	public void setIsFoShi(String isFoShi) {
		this.isFoShi = isFoShi;
	}

	public String getIsOneMonth() {
		return isOneMonth;
	}

	public void setIsOneMonth(String isOneMonth) {
		this.isOneMonth = isOneMonth;
	}

	public String getIsThreeMonth() {
		return isThreeMonth;
	}

	public void setIsThreeMonth(String isThreeMonth) {
		this.isThreeMonth = isThreeMonth;
	}

	public String getIsSixMonth() {
		return isSixMonth;
	}

	public void setIsSixMonth(String isSixMonth) {
		this.isSixMonth = isSixMonth;
	}

	public String getIsEightMonth() {
		return isEightMonth;
	}

	public void setIsEightMonth(String isEightMonth) {
		this.isEightMonth = isEightMonth;
	}

	public String getIsTwelveMonth() {
		return isTwelveMonth;
	}

	public void setIsTwelveMonth(String isTwelveMonth) {
		this.isTwelveMonth = isTwelveMonth;
	}

	public String getIsEighteenMonth() {
		return isEighteenMonth;
	}

	public void setIsEighteenMonth(String isEighteenMonth) {
		this.isEighteenMonth = isEighteenMonth;
	}

	public String getIsTwentyFourMonth() {
		return isTwentyFourMonth;
	}

	public void setIsTwentyFourMonth(String isTwentyFourMonth) {
		this.isTwentyFourMonth = isTwentyFourMonth;
	}

	public String getIsThirtyMonth() {
		return isThirtyMonth;
	}

	public void setIsThirtyMonth(String isThirtyMonth) {
		this.isThirtyMonth = isThirtyMonth;
	}

	public String getIsThreeYear() {
		return isThreeYear;
	}

	public void setIsThreeYear(String isThreeYear) {
		this.isThreeYear = isThreeYear;
	}

	public String getIsFourYear() {
		return isFourYear;
	}

	public void setIsFourYear(String isFourYear) {
		this.isFourYear = isFourYear;
	}

	public String getIsFiveYear() {
		return isFiveYear;
	}

	public void setIsFiveYear(String isFiveYear) {
		this.isFiveYear = isFiveYear;
	}

	public String getIsSixYear() {
		return isSixYear;
	}

	public void setIsSixYear(String isSixYear) {
		this.isSixYear = isSixYear;
	}
}