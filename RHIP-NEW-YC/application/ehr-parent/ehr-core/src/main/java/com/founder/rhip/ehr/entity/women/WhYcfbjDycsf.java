package com.founder.rhip.ehr.entity.women;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name="WH_YCFBJ_DYCSF")
public class WhYcfbjDycsf implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID",columnDefinition="NUMBER|数据库唯一编号（自增长）|11|",nullable=false)
	private Long id;

	@Column(name="SFZJH",columnDefinition="VARCHAR2|身份证件号|18|",length=18,nullable=true)
	private String sfzjh;

	@Column(name="CQSFLSH",columnDefinition="VARCHAR2|产前随访流水号+C8:DC7:D9|50|",nullable=false)
	private String cqsflsh;

	@Column(name="MPI",columnDefinition="VARCHAR2|个人主索引|40|",nullable=false)
	private String mpi;

	@Column(name="JKDABH",columnDefinition="VARCHAR2|健康档案编号|50|",nullable=false)
	private String jkdabh;

	@Column(name="YCFBH",columnDefinition="VARCHAR2|孕产妇编号|50|",nullable=false)
	private String ycfbh;

	@Column(name="XM",columnDefinition="VARCHAR2|姓名|40|",nullable=false)
	private String xm;

	@Column(name="CSRQ",columnDefinition="DATE|出生日期||",nullable=false)
	private Date csrq;

	@Column(name="NL",columnDefinition="INTEGER|年龄||",nullable=false)
	private Integer nl;

	@Column(name="NLDW_DM",columnDefinition="VARCHAR2|年龄单位代码|50|",nullable=false)
	private String nldwDm;

	@Column(name="NLDWDM_MC",columnDefinition="VARCHAR2|年龄单位代码名称|100|",nullable=false)
	private String nldwdmMc;

	@Column(name="ZFXM",columnDefinition="VARCHAR2|丈夫姓名|40|",nullable=true)
	private String zfxm;

	@Column(name="ZFDW",columnDefinition="VARCHAR2|丈夫单位|50|",nullable=true)
	private String zfdw;

	@Column(name="ZFLXDH",columnDefinition="VARCHAR2|丈夫联系电话|20|",nullable=true)
	private String zflxdh;

	@Column(name="ZFCSRQ",columnDefinition="DATE|丈夫出生日期||",nullable=true)
	private Date zfcsrq;

	@Column(name="ZFNL",columnDefinition="VARCHAR2|丈夫年龄|40|",nullable=true)
	private String zfnl;

	@Column(name="DQYZ",columnDefinition="VARCHAR2|当前孕周|40|",nullable=true)
	private String dqyz;

	@Column(name="YC",columnDefinition="INTEGER|孕次||",nullable=true)
	private Integer yc;

	@Column(name="CC",columnDefinition="INTEGER|产次||",nullable=true)
	private Integer cc;

	@Column(name="YDFM",columnDefinition="INTEGER|阴道分娩||",nullable=true)
	private Integer ydfm;

	@Column(name="PGC",columnDefinition="INTEGER|剖宫产||",nullable=true)
	private Integer pgc;

	@Column(name="MCYJRQ",columnDefinition="DATE|末次月经日期||",nullable=true)
	private Date mcyjrq;

	@Column(name="YCQ",columnDefinition="DATE|预产期||",nullable=true)
	private Date ycq;

	@Column(name="YCFJWS_DM",columnDefinition="VARCHAR2|孕产妇既往史代码|50|",nullable=true)
	private String ycfjwsDm;

	@Column(name="YCFJWS_MC",columnDefinition="VARCHAR2|孕产妇既往史名称|100|",nullable=true)
	private String ycfjwsMc;

	@Column(name="YCFQTJWS",columnDefinition="VARCHAR2|孕产妇其他既往史|100|",nullable=true)
	private String ycfqtjws;

	@Column(name="YCFJZS_DM",columnDefinition="VARCHAR2|孕产妇家族史代码|50|",nullable=true)
	private String ycfjzsDm;

	@Column(name="YCFJZS_MC",columnDefinition="VARCHAR2|孕产妇家族史名称|100|",nullable=true)
	private String ycfjzsMc;

	@Column(name="YCFQTJZS",columnDefinition="VARCHAR2|孕产妇其他家族史|100|",nullable=true)
	private String ycfqtjzs;

	@Column(name="YCFGRS_DM",columnDefinition="VARCHAR2|孕产妇个人史代码|50|",nullable=true)
	private String ycfgrsDm;

	@Column(name="YCFGRS_MC",columnDefinition="VARCHAR2|孕产妇个人史名称|100|",nullable=true)
	private String ycfgrsMc;

	@Column(name="YCFQTGRS",columnDefinition="VARCHAR2|孕产妇其他个人史|100|",nullable=true)
	private String ycfqtgrs;

	@Column(name="SSSYWFKSS_DM",columnDefinition="VARCHAR2|手术史-有无妇科手术|50|",nullable=true)
	private String sssywfkssDm;

	@Column(name="SSSFKSS_MC",columnDefinition="VARCHAR2|手术史-妇科手术名称|100|",nullable=true)
	private String sssfkssMc;

	@Column(name="SSSFKSSXS",columnDefinition="VARCHAR2|手术史-妇科手术详述|500|",nullable=true)
	private String sssfkssxs;

	@Column(name="YCSLCCS",columnDefinition="INTEGER|孕产史流产次数||",nullable=true)
	private Integer ycslccs;

	@Column(name="YCSZRLCCS",columnDefinition="INTEGER|孕产史自然流产次数||",nullable=true)
	private Integer ycszrlccs;

	@Column(name="YCSRGLCCS",columnDefinition="INTEGER|孕产史人工流产次数||",nullable=true)
	private Integer ycsrglccs;

	@Column(name="YCSSTCS",columnDefinition="INTEGER|孕产史死胎次数||",nullable=true)
	private Integer ycsstcs;

	@Column(name="YCSSCCS",columnDefinition="INTEGER|孕产史死产次数||",nullable=true)
	private Integer ycssccs;

	@Column(name="YCSXSESWCS",columnDefinition="INTEGER|孕产史新生儿死亡次数||",nullable=true)
	private Integer ycsxseswcs;

	@Column(name="YCSCSQXECS",columnDefinition="INTEGER|孕产史出生缺陷儿次数||",nullable=true)
	private Integer ycscsqxecs;

	@Column(name="SG",columnDefinition="NUMBER|身高|8|",length=8,nullable=true)
	private BigDecimal sg;

	@Column(name="TZ",columnDefinition="NUMBER|体重|8|",length=8,nullable=true)
	private BigDecimal tz;

	@Column(name="TZZS",columnDefinition="NUMBER|体质指数|8|",length=8,nullable=true)
	private BigDecimal tzzs;

	@Column(name="SZY",columnDefinition="INTEGER|舒张压||",nullable=true)
	private Integer szy;

	@Column(name="SSY",columnDefinition="INTEGER|收缩压||",nullable=true)
	private Integer ssy;

	@Column(name="TZXZQK_DM",columnDefinition="VARCHAR2|听诊心脏情况代码|50|",length=50,nullable=true)
	private String tzxzqkDm;

	@Column(name="TZXZQK_MC",columnDefinition="VARCHAR2|听诊心脏情况名称|100|",length=100,nullable=true)
	private String tzxzqkMc;

	@Column(name="TZXZYCMS",columnDefinition="VARCHAR2|听诊心脏异常描述|500|",length=500,nullable=true)
	private String tzxzycms;

	@Column(name="TZFBQK_DM",columnDefinition="VARCHAR2|听诊肺部情况代码|50|",length=50,nullable=true)
	private String tzfbqkDm;

	@Column(name="TZFBQK_MC",columnDefinition="VARCHAR2|听诊肺部情况名称|100|",length=100,nullable=true)
	private String tzfbqkMc;

	@Column(name="TZFBYCMS",columnDefinition="VARCHAR2|听诊肺部异常描述|500|",length=500,nullable=true)
	private String tzfbycms;

	@Column(name="FKWYQK_DM",columnDefinition="VARCHAR2|妇科外阴情况代码|50|",length=50,nullable=true)
	private String fkwyqkDm;

	@Column(name="FKWYQK_MC",columnDefinition="VARCHAR2|妇科外阴情况名称|100|",length=100,nullable=true)
	private String fkwyqkMc;

	@Column(name="FKWYYCMS",columnDefinition="VARCHAR2|妇科外阴异常描述|500|",length=500,nullable=true)
	private String fkwyycms;

	@Column(name="FKYDQK_DM",columnDefinition="VARCHAR2|妇科阴道情况代码,|50|",length=50,nullable=true)
	private String fkydqkDm;

	@Column(name="FKYDQK_MC",columnDefinition="VARCHAR2|妇科阴道情况名称|100|",length=100,nullable=true)
	private String fkydqkMc;

	@Column(name="FKYDYCMS",columnDefinition="VARCHAR2|妇科阴道异常描述|500|",length=500,nullable=true)
	private String fkydycms;

	@Column(name="FKGJQK_DM",columnDefinition="VARCHAR2|妇科宫颈情况代码|50|",length=50,nullable=true)
	private String fkgjqkDm;

	@Column(name="FKGJQK_MC",columnDefinition="VARCHAR2|妇科宫颈情况名称|100|",length=100,nullable=true)
	private String fkgjqkMc;

	@Column(name="FKGJYCMS",columnDefinition="VARCHAR2|妇科宫颈异常描述|500|",length=500,nullable=true)
	private String fkgjycms;

	@Column(name="FKZGQK_DM",columnDefinition="VARCHAR2|妇科子宫情况代码|50|",length=50,nullable=true)
	private String fkzgqkDm;

	@Column(name="FKZGQK_MC",columnDefinition="VARCHAR2|妇科子宫情况名称|100|",length=100,nullable=true)
	private String fkzgqkMc;

	@Column(name="FKZGYCMS",columnDefinition="VARCHAR2|妇科子宫异常描述|500|",length=500,nullable=true)
	private String fkzgycms;

	@Column(name="FKFJQK_DM",columnDefinition="VARCHAR2|妇科附件情况代码|50|",length=50,nullable=true)
	private String fkfjqkDm;

	@Column(name="FKFJQK_MC",columnDefinition="VARCHAR2|妇科附件情况名称|100|",length=100,nullable=true)
	private String fkfjqkMc;

	@Column(name="FKFJYCMS",columnDefinition="VARCHAR2|妇科附件异常描述|500|",length=500,nullable=true)
	private String fkfjycms;

	@Column(name="FKQTMS",columnDefinition="VARCHAR2|妇科其他描述|500|",length=500,nullable=true)
	private String fkqtms;

	@Column(name="XCG_XHDBZ",columnDefinition="NUMBER|血常规血红蛋白值|8|",length=8,nullable=true)
	private BigDecimal xcgXhdbz;

	@Column(name="XCG_BXBZ",columnDefinition="NUMBER|血常规白细胞值|8|",length=8,nullable=true)
	private BigDecimal xcgBxbz;

	@Column(name="XCG_XXBZ",columnDefinition="NUMBER|血常规血小板值|8|",length=8,nullable=true)
	private BigDecimal xcgXxbz;

	@Column(name="XCG_QTMS",columnDefinition="VARCHAR2|血常规其他描述|500|",length=500,nullable=true)
	private String xcgQtms;

	@Column(name="NCG_NDB",columnDefinition="VARCHAR2|尿常规尿蛋白|50|",length=50,nullable=true)
	private String ncgNdb;

	@Column(name="NCG_NT",columnDefinition="VARCHAR2|尿常规尿糖|50|",length=50,nullable=true)
	private String ncgNt;

	@Column(name="NCG_NTT",columnDefinition="VARCHAR2|尿常规尿酮体|50|",length=50,nullable=true)
	private String ncgNtt;

	@Column(name="NCG_NQX",columnDefinition="VARCHAR2|尿常规尿潜血|50|",length=50,nullable=true)
	private String ncgNqx;

	@Column(name="NCGQTMS",columnDefinition="VARCHAR2|尿常规其他描述|500|",length=500,nullable=true)
	private String ncgqtms;

	@Column(name="ABO_DM",columnDefinition="VARCHAR2|ABO血型代码|50|",length=50,nullable=true)
	private String aboDm;

	@Column(name="ABO_MC",columnDefinition="VARCHAR2|ABO血型名称|100|",length=100,nullable=true)
	private String aboMc;

	@Column(name="RHYX_DM",columnDefinition="VARCHAR2|RH阴性代码|50|",length=50,nullable=true)
	private String rhyxDm;

	@Column(name="RHYX_MC",columnDefinition="VARCHAR2|RH阴性名称|100|",length=100,nullable=true)
	private String rhyxMc;

	@Column(name="KFXT",columnDefinition="NUMBER|空腹血糖（mmol/L）|8|",length=8,nullable=true)
	private BigDecimal kfxt;

	@Column(name="GGNXQGBZAM",columnDefinition="NUMBER|肝功能血清谷丙转氨酶|8|",length=8,nullable=true)
	private BigDecimal ggnxqgbzam;

	@Column(name="GGNXQGCZAM",columnDefinition="NUMBER|肝功能血清谷草转氨酶|8|",length=8,nullable=true)
	private BigDecimal ggnxqgczam;

	@Column(name="GGNBDB",columnDefinition="NUMBER|肝功能白蛋白|8|",length=8,nullable=true)
	private BigDecimal ggnbdb;

	@Column(name="GGNZDHS",columnDefinition="NUMBER|肝功能总胆红素|8|",length=8,nullable=true)
	private BigDecimal ggnzdhs;

	@Column(name="GGNJHDHS",columnDefinition="NUMBER|肝功能结合胆红素|8|",length=8,nullable=true)
	private BigDecimal ggnjhdhs;

	@Column(name="SGNXQJG",columnDefinition="NUMBER|肾功能血清肌酐|8|",length=8,nullable=true)
	private BigDecimal sgnxqjg;

	@Column(name="SGNXNSD",columnDefinition="NUMBER|肾功能血尿素氮|8|",length=8,nullable=true)
	private BigDecimal sgnxnsd;

	@Column(name="YDFMWJCJG_DM",columnDefinition="VARCHAR2|阴道分泌物检查结果代码|50|",length=50,nullable=true)
	private String ydfmwjcjgDm;

	@Column(name="YDFMWJCJG_MC",columnDefinition="VARCHAR2|阴道分泌物检查结果名称|100|",length=100,nullable=true)
	private String ydfmwjcjgMc;

	@Column(name="YDFMWQTYCMS",columnDefinition="VARCHAR2|阴道分泌物其他异常描述|500|",length=500,nullable=true)
	private String ydfmwqtycms;

	@Column(name="YDQFMWJD_DM",columnDefinition="VARCHAR2|阴道清分泌物洁度代码|50|",length=50,nullable=true)
	private String ydqfmwjdDm;

	@Column(name="YDQFMWJD_MC",columnDefinition="VARCHAR2|阴道清分泌物洁度名称|100|",length=100,nullable=true)
	private String ydqfmwjdMc;

	@Column(name="YXGYBMKY_DM",columnDefinition="VARCHAR2|乙型肝炎表面抗原代码|50|",length=50,nullable=true)
	private String yxgybmkyDm;

	@Column(name="YXGYBMKY_MC",columnDefinition="VARCHAR2|乙型肝炎表面抗原名称|100|",length=100,nullable=true)
	private String yxgybmkyMc;

	@Column(name="YXGYBMKT_DM",columnDefinition="VARCHAR2|乙型肝炎表面抗体代码|50|",length=50,nullable=true)
	private String yxgybmktDm;

	@Column(name="YXGYBMKT_MC",columnDefinition="VARCHAR2|乙型肝炎表面抗体名称|100|",length=100,nullable=true)
	private String yxgybmktMc;

	@Column(name="YXGYKY_DM",columnDefinition="VARCHAR2|乙型肝炎E抗原代码|50|",length=50,nullable=true)
	private String yxgykyDm;

	@Column(name="YXGYKY_MC",columnDefinition="VARCHAR2|乙型肝炎E抗原名称|100|",length=100,nullable=true)
	private String yxgykyMc;

	@Column(name="YXGYKT_DM",columnDefinition="VARCHAR2|乙型肝炎E抗体代码|50|",length=50,nullable=true)
	private String yxgyktDm;

	@Column(name="YXGYKT_MC",columnDefinition="VARCHAR2|乙型肝炎E抗体名称|100|",length=100,nullable=true)
	private String yxgyktMc;

	@Column(name="YXGYHXKT_DM",columnDefinition="VARCHAR2|乙型肝炎核心抗体代码|50|",length=50,nullable=true)
	private String yxgyhxktDm;

	@Column(name="YXGYHXKT_MC",columnDefinition="VARCHAR2|乙型肝炎核心抗体名称|100|",length=100,nullable=true)
	private String yxgyhxktMc;

	@Column(name="MDXQXSY_DM",columnDefinition="VARCHAR2|梅毒血清学试验代码|50|",length=50,nullable=true)
	private String mdxqxsyDm;

	@Column(name="MDXQXSY_MC",columnDefinition="VARCHAR2|梅毒血清学试验名称|100|",length=100,nullable=true)
	private String mdxqxsyMc;

	@Column(name="HIVKTJC_DM",columnDefinition="VARCHAR2|HIV抗体检测代码|50|",length=50,nullable=true)
	private String hivktjcDm;

	@Column(name="HIVKTJC_MC",columnDefinition="VARCHAR2|HIV抗体检测名称|500|",length=500,nullable=true)
	private String hivktjcMc;

	@Column(name="BCXS",columnDefinition="VARCHAR2|B超详述|4000|",length=4000,nullable=true)
	private String bcxs;

	@Column(name="FZJCQTMS",columnDefinition="VARCHAR2|辅助检查其他描述|4000|",length=4000,nullable=true)
	private String fzjcqtms;

	@Column(name="ZJPG_DM",columnDefinition="VARCHAR2|总结评估代码|50|",length=50,nullable=true)
	private String zjpgDm;

	@Column(name="ZJPG_MC",columnDefinition="VARCHAR2|总结评估名称|100|",length=100,nullable=true)
	private String zjpgMc;

	@Column(name="ZJPGYCMS",columnDefinition="VARCHAR2|总结评估异常描述|500|",length=500,nullable=true)
	private String zjpgycms;

	@Column(name="JKZD_DM",columnDefinition="VARCHAR2|健康指导代码|50|",length=50,nullable=true)
	private String jkzdDm;

	@Column(name="JKZD_MC",columnDefinition="VARCHAR2|健康指导名称|100|",length=100,nullable=true)
	private String jkzdMc;

	@Column(name="QTYCFJKZDXS",columnDefinition="VARCHAR2|其他孕产妇健康指导名称|50|",length=50,nullable=true)
	private String qtycfjkzdxs;

	@Column(name="QTYCFJKZD_MC",columnDefinition="VARCHAR2|其他孕产妇健康指导详述|500|",length=500,nullable=true)
	private String qtycfjkzdMc;

	@Column(name="YWZZ_DM",columnDefinition="VARCHAR2|有无转诊代码|50|",length=50,nullable=true)
	private String ywzzDm;

	@Column(name="YWZZ_MC",columnDefinition="VARCHAR2|有无转诊名称|100|",length=100,nullable=true)
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

	public String getCqsflsh() {
		return this.cqsflsh;
	}

	public void setCqsflsh(String cqsflsh) {
		this.cqsflsh = cqsflsh;
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

	public String getDqyz() {
		return this.dqyz;
	}

	public void setDqyz(String dqyz) {
		this.dqyz = dqyz;
	}

	public Integer getYc() {
		return this.yc;
	}

	public void setYc(Integer yc) {
		this.yc = yc;
	}

	public Integer getCc() {
		return this.cc;
	}

	public void setCc(Integer cc) {
		this.cc = cc;
	}

	public Integer getYdfm() {
		return this.ydfm;
	}

	public void setYdfm(Integer ydfm) {
		this.ydfm = ydfm;
	}

	public Integer getPgc() {
		return this.pgc;
	}

	public void setPgc(Integer pgc) {
		this.pgc = pgc;
	}

	public Date getMcyjrq() {
		return this.mcyjrq;
	}

	public void setMcyjrq(Date mcyjrq) {
		this.mcyjrq = mcyjrq;
	}

	public Date getYcq() {
		return this.ycq;
	}

	public void setYcq(Date ycq) {
		this.ycq = ycq;
	}

	public String getYcfjwsDm() {
		return this.ycfjwsDm;
	}

	public void setYcfjwsDm(String ycfjwsDm) {
		this.ycfjwsDm = ycfjwsDm;
	}

	public String getYcfjwsMc() {
		return this.ycfjwsMc;
	}

	public void setYcfjwsMc(String ycfjwsMc) {
		this.ycfjwsMc = ycfjwsMc;
	}

	public String getYcfqtjws() {
		return this.ycfqtjws;
	}

	public void setYcfqtjws(String ycfqtjws) {
		this.ycfqtjws = ycfqtjws;
	}

	public String getYcfjzsDm() {
		return this.ycfjzsDm;
	}

	public void setYcfjzsDm(String ycfjzsDm) {
		this.ycfjzsDm = ycfjzsDm;
	}

	public String getYcfjzsMc() {
		return this.ycfjzsMc;
	}

	public void setYcfjzsMc(String ycfjzsMc) {
		this.ycfjzsMc = ycfjzsMc;
	}

	public String getYcfqtjzs() {
		return this.ycfqtjzs;
	}

	public void setYcfqtjzs(String ycfqtjzs) {
		this.ycfqtjzs = ycfqtjzs;
	}

	public String getYcfgrsDm() {
		return this.ycfgrsDm;
	}

	public void setYcfgrsDm(String ycfgrsDm) {
		this.ycfgrsDm = ycfgrsDm;
	}

	public String getYcfgrsMc() {
		return this.ycfgrsMc;
	}

	public void setYcfgrsMc(String ycfgrsMc) {
		this.ycfgrsMc = ycfgrsMc;
	}

	public String getYcfqtgrs() {
		return this.ycfqtgrs;
	}

	public void setYcfqtgrs(String ycfqtgrs) {
		this.ycfqtgrs = ycfqtgrs;
	}

	public String getSssywfkssDm() {
		return this.sssywfkssDm;
	}

	public void setSssywfkssDm(String sssywfkssDm) {
		this.sssywfkssDm = sssywfkssDm;
	}

	public String getSssfkssMc() {
		return this.sssfkssMc;
	}

	public void setSssfkssMc(String sssfkssMc) {
		this.sssfkssMc = sssfkssMc;
	}

	public String getSssfkssxs() {
		return this.sssfkssxs;
	}

	public void setSssfkssxs(String sssfkssxs) {
		this.sssfkssxs = sssfkssxs;
	}

	public Integer getYcslccs() {
		return this.ycslccs;
	}

	public void setYcslccs(Integer ycslccs) {
		this.ycslccs = ycslccs;
	}

	public Integer getYcszrlccs() {
		return this.ycszrlccs;
	}

	public void setYcszrlccs(Integer ycszrlccs) {
		this.ycszrlccs = ycszrlccs;
	}

	public Integer getYcsrglccs() {
		return this.ycsrglccs;
	}

	public void setYcsrglccs(Integer ycsrglccs) {
		this.ycsrglccs = ycsrglccs;
	}

	public Integer getYcsstcs() {
		return this.ycsstcs;
	}

	public void setYcsstcs(Integer ycsstcs) {
		this.ycsstcs = ycsstcs;
	}

	public Integer getYcssccs() {
		return this.ycssccs;
	}

	public void setYcssccs(Integer ycssccs) {
		this.ycssccs = ycssccs;
	}

	public Integer getYcsxseswcs() {
		return this.ycsxseswcs;
	}

	public void setYcsxseswcs(Integer ycsxseswcs) {
		this.ycsxseswcs = ycsxseswcs;
	}

	public Integer getYcscsqxecs() {
		return this.ycscsqxecs;
	}

	public void setYcscsqxecs(Integer ycscsqxecs) {
		this.ycscsqxecs = ycscsqxecs;
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

	public Integer getSzy() {
		return this.szy;
	}

	public void setSzy(Integer szy) {
		this.szy = szy;
	}

	public Integer getSsy() {
		return this.ssy;
	}

	public void setSsy(Integer ssy) {
		this.ssy = ssy;
	}

	public String getTzxzqkDm() {
		return this.tzxzqkDm;
	}

	public void setTzxzqkDm(String tzxzqkDm) {
		this.tzxzqkDm = tzxzqkDm;
	}

	public String getTzxzqkMc() {
		return this.tzxzqkMc;
	}

	public void setTzxzqkMc(String tzxzqkMc) {
		this.tzxzqkMc = tzxzqkMc;
	}

	public String getTzxzycms() {
		return this.tzxzycms;
	}

	public void setTzxzycms(String tzxzycms) {
		this.tzxzycms = tzxzycms;
	}

	public String getTzfbqkDm() {
		return this.tzfbqkDm;
	}

	public void setTzfbqkDm(String tzfbqkDm) {
		this.tzfbqkDm = tzfbqkDm;
	}

	public String getTzfbqkMc() {
		return this.tzfbqkMc;
	}

	public void setTzfbqkMc(String tzfbqkMc) {
		this.tzfbqkMc = tzfbqkMc;
	}

	public String getTzfbycms() {
		return this.tzfbycms;
	}

	public void setTzfbycms(String tzfbycms) {
		this.tzfbycms = tzfbycms;
	}

	public String getFkwyqkDm() {
		return this.fkwyqkDm;
	}

	public void setFkwyqkDm(String fkwyqkDm) {
		this.fkwyqkDm = fkwyqkDm;
	}

	public String getFkwyqkMc() {
		return this.fkwyqkMc;
	}

	public void setFkwyqkMc(String fkwyqkMc) {
		this.fkwyqkMc = fkwyqkMc;
	}

	public String getFkwyycms() {
		return this.fkwyycms;
	}

	public void setFkwyycms(String fkwyycms) {
		this.fkwyycms = fkwyycms;
	}

	public String getFkydqkDm() {
		return this.fkydqkDm;
	}

	public void setFkydqkDm(String fkydqkDm) {
		this.fkydqkDm = fkydqkDm;
	}

	public String getFkydqkMc() {
		return this.fkydqkMc;
	}

	public void setFkydqkMc(String fkydqkMc) {
		this.fkydqkMc = fkydqkMc;
	}

	public String getFkydycms() {
		return this.fkydycms;
	}

	public void setFkydycms(String fkydycms) {
		this.fkydycms = fkydycms;
	}

	public String getFkgjqkDm() {
		return this.fkgjqkDm;
	}

	public void setFkgjqkDm(String fkgjqkDm) {
		this.fkgjqkDm = fkgjqkDm;
	}

	public String getFkgjqkMc() {
		return this.fkgjqkMc;
	}

	public void setFkgjqkMc(String fkgjqkMc) {
		this.fkgjqkMc = fkgjqkMc;
	}

	public String getFkgjycms() {
		return this.fkgjycms;
	}

	public void setFkgjycms(String fkgjycms) {
		this.fkgjycms = fkgjycms;
	}

	public String getFkzgqkDm() {
		return this.fkzgqkDm;
	}

	public void setFkzgqkDm(String fkzgqkDm) {
		this.fkzgqkDm = fkzgqkDm;
	}

	public String getFkzgqkMc() {
		return this.fkzgqkMc;
	}

	public void setFkzgqkMc(String fkzgqkMc) {
		this.fkzgqkMc = fkzgqkMc;
	}

	public String getFkzgycms() {
		return this.fkzgycms;
	}

	public void setFkzgycms(String fkzgycms) {
		this.fkzgycms = fkzgycms;
	}

	public String getFkfjqkDm() {
		return this.fkfjqkDm;
	}

	public void setFkfjqkDm(String fkfjqkDm) {
		this.fkfjqkDm = fkfjqkDm;
	}

	public String getFkfjqkMc() {
		return this.fkfjqkMc;
	}

	public void setFkfjqkMc(String fkfjqkMc) {
		this.fkfjqkMc = fkfjqkMc;
	}

	public String getFkfjycms() {
		return this.fkfjycms;
	}

	public void setFkfjycms(String fkfjycms) {
		this.fkfjycms = fkfjycms;
	}

	public String getFkqtms() {
		return this.fkqtms;
	}

	public void setFkqtms(String fkqtms) {
		this.fkqtms = fkqtms;
	}

	public BigDecimal getXcgXhdbz() {
		return this.xcgXhdbz;
	}

	public void setXcgXhdbz(BigDecimal xcgXhdbz) {
		this.xcgXhdbz = xcgXhdbz;
	}

	public BigDecimal getXcgBxbz() {
		return this.xcgBxbz;
	}

	public void setXcgBxbz(BigDecimal xcgBxbz) {
		this.xcgBxbz = xcgBxbz;
	}

	public BigDecimal getXcgXxbz() {
		return this.xcgXxbz;
	}

	public void setXcgXxbz(BigDecimal xcgXxbz) {
		this.xcgXxbz = xcgXxbz;
	}

	public String getXcgQtms() {
		return this.xcgQtms;
	}

	public void setXcgQtms(String xcgQtms) {
		this.xcgQtms = xcgQtms;
	}

	public String getNcgNdb() {
		return this.ncgNdb;
	}

	public void setNcgNdb(String ncgNdb) {
		this.ncgNdb = ncgNdb;
	}

	public String getNcgNt() {
		return this.ncgNt;
	}

	public void setNcgNt(String ncgNt) {
		this.ncgNt = ncgNt;
	}

	public String getNcgNtt() {
		return this.ncgNtt;
	}

	public void setNcgNtt(String ncgNtt) {
		this.ncgNtt = ncgNtt;
	}

	public String getNcgNqx() {
		return this.ncgNqx;
	}

	public void setNcgNqx(String ncgNqx) {
		this.ncgNqx = ncgNqx;
	}

	public String getNcgqtms() {
		return this.ncgqtms;
	}

	public void setNcgqtms(String ncgqtms) {
		this.ncgqtms = ncgqtms;
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

	public String getRhyxDm() {
		return this.rhyxDm;
	}

	public void setRhyxDm(String rhyxDm) {
		this.rhyxDm = rhyxDm;
	}

	public String getRhyxMc() {
		return this.rhyxMc;
	}

	public void setRhyxMc(String rhyxMc) {
		this.rhyxMc = rhyxMc;
	}

	public BigDecimal getKfxt() {
		return this.kfxt;
	}

	public void setKfxt(BigDecimal kfxt) {
		this.kfxt = kfxt;
	}

	public BigDecimal getGgnxqgbzam() {
		return this.ggnxqgbzam;
	}

	public void setGgnxqgbzam(BigDecimal ggnxqgbzam) {
		this.ggnxqgbzam = ggnxqgbzam;
	}

	public BigDecimal getGgnxqgczam() {
		return this.ggnxqgczam;
	}

	public void setGgnxqgczam(BigDecimal ggnxqgczam) {
		this.ggnxqgczam = ggnxqgczam;
	}

	public BigDecimal getGgnbdb() {
		return this.ggnbdb;
	}

	public void setGgnbdb(BigDecimal ggnbdb) {
		this.ggnbdb = ggnbdb;
	}

	public BigDecimal getGgnzdhs() {
		return this.ggnzdhs;
	}

	public void setGgnzdhs(BigDecimal ggnzdhs) {
		this.ggnzdhs = ggnzdhs;
	}

	public BigDecimal getGgnjhdhs() {
		return this.ggnjhdhs;
	}

	public void setGgnjhdhs(BigDecimal ggnjhdhs) {
		this.ggnjhdhs = ggnjhdhs;
	}

	public BigDecimal getSgnxqjg() {
		return this.sgnxqjg;
	}

	public void setSgnxqjg(BigDecimal sgnxqjg) {
		this.sgnxqjg = sgnxqjg;
	}

	public BigDecimal getSgnxnsd() {
		return this.sgnxnsd;
	}

	public void setSgnxnsd(BigDecimal sgnxnsd) {
		this.sgnxnsd = sgnxnsd;
	}

	public String getYdfmwjcjgDm() {
		return this.ydfmwjcjgDm;
	}

	public void setYdfmwjcjgDm(String ydfmwjcjgDm) {
		this.ydfmwjcjgDm = ydfmwjcjgDm;
	}

	public String getYdfmwjcjgMc() {
		return this.ydfmwjcjgMc;
	}

	public void setYdfmwjcjgMc(String ydfmwjcjgMc) {
		this.ydfmwjcjgMc = ydfmwjcjgMc;
	}

	public String getYdfmwqtycms() {
		return this.ydfmwqtycms;
	}

	public void setYdfmwqtycms(String ydfmwqtycms) {
		this.ydfmwqtycms = ydfmwqtycms;
	}

	public String getYdqfmwjdDm() {
		return this.ydqfmwjdDm;
	}

	public void setYdqfmwjdDm(String ydqfmwjdDm) {
		this.ydqfmwjdDm = ydqfmwjdDm;
	}

	public String getYdqfmwjdMc() {
		return this.ydqfmwjdMc;
	}

	public void setYdqfmwjdMc(String ydqfmwjdMc) {
		this.ydqfmwjdMc = ydqfmwjdMc;
	}

	public String getYxgybmkyDm() {
		return this.yxgybmkyDm;
	}

	public void setYxgybmkyDm(String yxgybmkyDm) {
		this.yxgybmkyDm = yxgybmkyDm;
	}

	public String getYxgybmkyMc() {
		return this.yxgybmkyMc;
	}

	public void setYxgybmkyMc(String yxgybmkyMc) {
		this.yxgybmkyMc = yxgybmkyMc;
	}

	public String getYxgybmktDm() {
		return this.yxgybmktDm;
	}

	public void setYxgybmktDm(String yxgybmktDm) {
		this.yxgybmktDm = yxgybmktDm;
	}

	public String getYxgybmktMc() {
		return this.yxgybmktMc;
	}

	public void setYxgybmktMc(String yxgybmktMc) {
		this.yxgybmktMc = yxgybmktMc;
	}

	public String getYxgykyDm() {
		return this.yxgykyDm;
	}

	public void setYxgykyDm(String yxgykyDm) {
		this.yxgykyDm = yxgykyDm;
	}

	public String getYxgykyMc() {
		return this.yxgykyMc;
	}

	public void setYxgykyMc(String yxgykyMc) {
		this.yxgykyMc = yxgykyMc;
	}

	public String getYxgyktDm() {
		return this.yxgyktDm;
	}

	public void setYxgyktDm(String yxgyktDm) {
		this.yxgyktDm = yxgyktDm;
	}

	public String getYxgyktMc() {
		return this.yxgyktMc;
	}

	public void setYxgyktMc(String yxgyktMc) {
		this.yxgyktMc = yxgyktMc;
	}

	public String getYxgyhxktDm() {
		return this.yxgyhxktDm;
	}

	public void setYxgyhxktDm(String yxgyhxktDm) {
		this.yxgyhxktDm = yxgyhxktDm;
	}

	public String getYxgyhxktMc() {
		return this.yxgyhxktMc;
	}

	public void setYxgyhxktMc(String yxgyhxktMc) {
		this.yxgyhxktMc = yxgyhxktMc;
	}

	public String getMdxqxsyDm() {
		return this.mdxqxsyDm;
	}

	public void setMdxqxsyDm(String mdxqxsyDm) {
		this.mdxqxsyDm = mdxqxsyDm;
	}

	public String getMdxqxsyMc() {
		return this.mdxqxsyMc;
	}

	public void setMdxqxsyMc(String mdxqxsyMc) {
		this.mdxqxsyMc = mdxqxsyMc;
	}

	public String getHivktjcDm() {
		return this.hivktjcDm;
	}

	public void setHivktjcDm(String hivktjcDm) {
		this.hivktjcDm = hivktjcDm;
	}

	public String getHivktjcMc() {
		return this.hivktjcMc;
	}

	public void setHivktjcMc(String hivktjcMc) {
		this.hivktjcMc = hivktjcMc;
	}

	public String getBcxs() {
		return this.bcxs;
	}

	public void setBcxs(String bcxs) {
		this.bcxs = bcxs;
	}

	public String getFzjcqtms() {
		return this.fzjcqtms;
	}

	public void setFzjcqtms(String fzjcqtms) {
		this.fzjcqtms = fzjcqtms;
	}

	public String getZjpgDm() {
		return this.zjpgDm;
	}

	public void setZjpgDm(String zjpgDm) {
		this.zjpgDm = zjpgDm;
	}

	public String getZjpgMc() {
		return this.zjpgMc;
	}

	public void setZjpgMc(String zjpgMc) {
		this.zjpgMc = zjpgMc;
	}

	public String getZjpgycms() {
		return this.zjpgycms;
	}

	public void setZjpgycms(String zjpgycms) {
		this.zjpgycms = zjpgycms;
	}

	public String getJkzdDm() {
		return this.jkzdDm;
	}

	public void setJkzdDm(String jkzdDm) {
		this.jkzdDm = jkzdDm;
	}

	public String getJkzdMc() {
		return this.jkzdMc;
	}

	public void setJkzdMc(String jkzdMc) {
		this.jkzdMc = jkzdMc;
	}

	public String getQtycfjkzdxs() {
		return this.qtycfjkzdxs;
	}

	public void setQtycfjkzdxs(String qtycfjkzdxs) {
		this.qtycfjkzdxs = qtycfjkzdxs;
	}

	public String getQtycfjkzdMc() {
		return this.qtycfjkzdMc;
	}

	public void setQtycfjkzdMc(String qtycfjkzdMc) {
		this.qtycfjkzdMc = qtycfjkzdMc;
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
		return djrymc;
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