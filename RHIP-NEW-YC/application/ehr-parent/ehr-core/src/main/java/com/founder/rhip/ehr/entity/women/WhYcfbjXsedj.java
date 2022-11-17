package com.founder.rhip.ehr.entity.women;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name="WH_YCFBJ_XSEDJ")
public class WhYcfbjXsedj implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID",columnDefinition="NUMBER|数据库唯一编号（自增长）|11|",length=11,nullable=false)
	private Long id;

	@Column(name="SFZJH",columnDefinition="VARCHAR2|母亲身份证件号|18|",length=18,nullable=true)
	private String sfzjh;

	@Column(name="XSEDJBH",columnDefinition="VARCHAR2|新生儿登记编号|50|",length=50,nullable=false)
	private String xsedjbh;

	@Column(name="MPI",columnDefinition="VARCHAR2|个人主索引|40|",length=40,nullable=false)
	private String mpi;

	@Column(name="JKDABH",columnDefinition="VARCHAR2|健康档案编号|50|",length=50,nullable=false)
	private String jkdabh;

	@Column(name="YCFBH",columnDefinition="VARCHAR2|孕产妇编号|50|",length=50,nullable=false)
	private String ycfbh;

	@Column(name="FMJLLSH",columnDefinition="VARCHAR2|分娩记录流水号|50|",length=50,nullable=true)
	private String fmjllsh;

	@Column(name="ZSZBH",columnDefinition="VARCHAR2|准生证编号|50|",length=50,nullable=true)
	private String zszbh;

	@Column(name="YXCSZH",columnDefinition="VARCHAR2|医学出生证号|50|",length=50,nullable=true)
	private String yxcszh;

	@Column(name="TS",columnDefinition="INTEGER|胎数||",nullable=true)
	private Integer ts;

	@Column(name="CSSX",columnDefinition="INTEGER|出生顺序||",nullable=true)
	private Integer cssx;

	@Column(name="MCSJ",columnDefinition="DATE|娩出时间||",nullable=false)
	private Date mcsj;

	@Column(name="FMFS_DM",columnDefinition="VARCHAR2|分娩方式代码|50|",length=50,nullable=false)
	private String fmfsDm;

	@Column(name="FMFS_MC",columnDefinition="VARCHAR2|分娩方式名称|100|",length=100,nullable=false)
	private String fmfsMc;

	@Column(name="FMFSXS",columnDefinition="VARCHAR2|分娩方式详述|4000|",length=4000,nullable=true)
	private String fmfsxs;

	@Column(name="XSEXB_DM",columnDefinition="VARCHAR2|新生儿性别代码|10|",length=10,nullable=false)
	private String xsexbDm;

	@Column(name="XSEXB",columnDefinition="VARCHAR2|新生儿性别|20|",length=20,nullable=false)
	private String xsexb;

	@Column(name="CSSG",columnDefinition="NUMBER|出生身高|8|",length=8,nullable=false)
	private BigDecimal cssg;

	@Column(name="CSTZ",columnDefinition="NUMBER|出生体重|8|",length=8,nullable=false)
	private BigDecimal cstz;

	@Column(name="CSEJJ_DM",columnDefinition="VARCHAR2|出生儿结局代码|50|",length=50,nullable=true)
	private String csejjDm;

	@Column(name="CSEJJ_MC",columnDefinition="VARCHAR2|出生儿结局名称|100|",length=100,nullable=true)
	private String csejjMc;

	@Column(name="CSEJJQTXS",columnDefinition="VARCHAR2|出生儿结局其他详述|4000|",length=4000,nullable=true)
	private String csejjqtxs;

	@Column(name="APGAR1FZPF",columnDefinition="INTEGER|Apgar1分钟评分||",nullable=true)
	private Integer apgar1fzpf;

	@Column(name="APGAR5FZPF",columnDefinition="INTEGER|Apgar5分钟评分||",nullable=true)
	private Integer apgar5fzpf;

	@Column(name="APGAR10FZPF",columnDefinition="INTEGER|Apgar10分钟评分||",nullable=true)
	private Integer apgar10fzpf;

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

	@Column(name="SFCSH1XSNZJCZXSZKN_DM",columnDefinition="VARCHAR2|是否出生后1小时内早接触、早吸吮、早开奶代码|50|",length=50,nullable=true)
	private String sfcsh1xsnzjczxszknDm;

	@Column(name="SFCSH1XSNZJCZXSZKN_MC",columnDefinition="VARCHAR2|是否出生后1小时内早接触、早吸吮、早开奶名称|100|",length=100,nullable=true)
	private String sfcsh1xsnzjczxszknMc;

	@Column(name="YWBLXHD_DM",columnDefinition="VARCHAR2|有无病理性黄疸代码|50|",length=50,nullable=true)
	private String ywblxhdDm;

	@Column(name="YWBLXHD_MC",columnDefinition="VARCHAR2|有无病理性黄疸名称|100|",length=100,nullable=true)
	private String ywblxhdMc;

	@Column(name="YWHXJPZHZ_DM",columnDefinition="VARCHAR2|有无呼吸窘迫综合症代码|50|",length=50,nullable=true)
	private String ywhxjpzhzDm;

	@Column(name="YWHXJPZHZ_MC",columnDefinition="VARCHAR2|有无呼吸窘迫综合症名称|100|",length=100,nullable=true)
	private String ywhxjpzhzMc;

	@Column(name="YWFY_DM",columnDefinition="VARCHAR2|有无肺炎代码|50|",length=50,nullable=true)
	private String ywfyDm;

	@Column(name="YWFY_MC",columnDefinition="VARCHAR2|有无肺炎名称|100|",length=100,nullable=true)
	private String ywfyMc;

	@Column(name="YWYZZ_DM",columnDefinition="VARCHAR2|有无硬肿症代码|50|",length=50,nullable=true)
	private String ywyzzDm;

	@Column(name="YWYZZ_MC",columnDefinition="VARCHAR2|有无硬肿症名称|100|",length=100,nullable=true)
	private String ywyzzMc;

	@Column(name="YWQXQYXNB_DM",columnDefinition="VARCHAR2|有无缺血缺氧性脑病代码|50|",length=50,nullable=true)
	private String ywqxqyxnbDm;

	@Column(name="YWQXQYXNB_MC",columnDefinition="VARCHAR2|有无缺血缺氧性脑病名称|100|",length=100,nullable=true)
	private String ywqxqyxnbMc;

	@Column(name="YWQBGR_DM",columnDefinition="VARCHAR2|有无脐部感染代码|50|",length=50,nullable=true)
	private String ywqbgrDm;

	@Column(name="YWQBGR_MC",columnDefinition="VARCHAR2|有无脐部感染名称|100|",length=100,nullable=true)
	private String ywqbgrMc;

	@Column(name="YWBXZ_DM",columnDefinition="VARCHAR2|有无败血症代码|50|",length=50,nullable=true)
	private String ywbxzDm;

	@Column(name="YWBXZ_MC",columnDefinition="VARCHAR2|有无败血症名称|100|",length=100,nullable=true)
	private String ywbxzMc;

	@Column(name="YWPSF_DM",columnDefinition="VARCHAR2|有无破伤风代码|50|",length=50,nullable=true)
	private String ywpsfDm;

	@Column(name="YWPSF_MC",columnDefinition="VARCHAR2|有无破伤风名称|100|",length=100,nullable=true)
	private String ywpsfMc;

	@Column(name="QTXSEBZXS",columnDefinition="VARCHAR2|其他新生儿并发症详述|4000|",length=4000,nullable=true)
	private String qtxsebzxs;

	@Column(name="SFXSECH_DM",columnDefinition="VARCHAR2|是否新生儿存活代码|50|",length=50,nullable=true)
	private String sfxsechDm;

	@Column(name="SFXSECH_MC",columnDefinition="VARCHAR2|是否新生儿存活名称|100|",length=100,nullable=true)
	private String sfxsechMc;

	@Column(name="SFMRWY_DM",columnDefinition="VARCHAR2|是否母乳喂养代码|50|",length=50,nullable=true)
	private String sfmrwyDm;

	@Column(name="SFMRWY_MC",columnDefinition="VARCHAR2|是否母乳喂养名称|100|",length=100,nullable=true)
	private String sfmrwyMc;

	@Column(name="SFXSEJBSC_DM2X",columnDefinition="VARCHAR2|是否新生儿疾病筛查代码（2项）|50|",length=50,nullable=true)
	private String sfxsejbscDm2x;

	@Column(name="SFXSEJBSC_MC2X",columnDefinition="VARCHAR2|是否新生儿疾病筛查名称（2项）|100|",length=100,nullable=true)
	private String sfxsejbscMc2x;

	@Column(name="SFXSEJBSC_DM27X",columnDefinition="VARCHAR2|是否新生儿疾病筛查代码（27项）|50|",length=50,nullable=true)
	private String sfxsejbscDm27x;

	@Column(name="SFXSEJBSC_MC27X",columnDefinition="VARCHAR2|是否新生儿疾病筛查名称（27项）|100|",length=100,nullable=true)
	private String sfxsejbscMc27x;

	@Column(name="TLJCJG_DM",columnDefinition="VARCHAR2|听力检测结果代码|50|",length=50,nullable=true)
	private String tljcjgDm;

	@Column(name="TLJCJG_MC",columnDefinition="VARCHAR2|听力检测结果名称|100|",length=100,nullable=true)
	private String tljcjgMc;

	@Column(name="YMMC_DM",columnDefinition="VARCHAR2|疫苗名称代码|50|",length=50,nullable=true)
	private String ymmcDm;

	@Column(name="YM_MC",columnDefinition="VARCHAR2|疫苗名称|200|",length=200,nullable=true)
	private String ymMc;

	@Column(name="YGMYQDBZSQK_DM",columnDefinition="VARCHAR2|乙肝免疫球蛋白注射情况代码|100|",length=100,nullable=true)
	private String ygmyqdbzsqkDm;

	@Column(name="YGMYQDBZSQK",columnDefinition="VARCHAR2|乙肝免疫球蛋白注射情况|100|",length=100,nullable=true)
	private String ygmyqdbzsqk;

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

	public String getXsedjbh() {
		return this.xsedjbh;
	}

	public void setXsedjbh(String xsedjbh) {
		this.xsedjbh = xsedjbh;
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

	public String getFmjllsh() {
		return this.fmjllsh;
	}

	public void setFmjllsh(String fmjllsh) {
		this.fmjllsh = fmjllsh;
	}

	public String getZszbh() {
		return this.zszbh;
	}

	public void setZszbh(String zszbh) {
		this.zszbh = zszbh;
	}

	public String getYxcszh() {
		return this.yxcszh;
	}

	public void setYxcszh(String yxcszh) {
		this.yxcszh = yxcszh;
	}

	public Integer getTs() {
		return this.ts;
	}

	public void setTs(Integer ts) {
		this.ts = ts;
	}

	public Integer getCssx() {
		return this.cssx;
	}

	public void setCssx(Integer cssx) {
		this.cssx = cssx;
	}

	public Date getMcsj() {
		return this.mcsj;
	}

	public void setMcsj(Date mcsj) {
		this.mcsj = mcsj;
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

	public String getXsexbDm() {
		return this.xsexbDm;
	}

	public void setXsexbDm(String xsexbDm) {
		this.xsexbDm = xsexbDm;
	}

	public String getXsexb() {
		return this.xsexb;
	}

	public void setXsexb(String xsexb) {
		this.xsexb = xsexb;
	}

	public BigDecimal getCssg() {
		return this.cssg;
	}

	public void setCssg(BigDecimal cssg) {
		this.cssg = cssg;
	}

	public BigDecimal getCstz() {
		return this.cstz;
	}

	public void setCstz(BigDecimal cstz) {
		this.cstz = cstz;
	}

	public String getCsejjDm() {
		return this.csejjDm;
	}

	public void setCsejjDm(String csejjDm) {
		this.csejjDm = csejjDm;
	}

	public String getCsejjMc() {
		return this.csejjMc;
	}

	public void setCsejjMc(String csejjMc) {
		this.csejjMc = csejjMc;
	}

	public String getCsejjqtxs() {
		return this.csejjqtxs;
	}

	public void setCsejjqtxs(String csejjqtxs) {
		this.csejjqtxs = csejjqtxs;
	}

	public Integer getApgar1fzpf() {
		return this.apgar1fzpf;
	}

	public void setApgar1fzpf(Integer apgar1fzpf) {
		this.apgar1fzpf = apgar1fzpf;
	}

	public Integer getApgar5fzpf() {
		return this.apgar5fzpf;
	}

	public void setApgar5fzpf(Integer apgar5fzpf) {
		this.apgar5fzpf = apgar5fzpf;
	}

	public Integer getApgar10fzpf() {
		return this.apgar10fzpf;
	}

	public void setApgar10fzpf(Integer apgar10fzpf) {
		this.apgar10fzpf = apgar10fzpf;
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

	public String getSfcsh1xsnzjczxszknDm() {
		return this.sfcsh1xsnzjczxszknDm;
	}

	public void setSfcsh1xsnzjczxszknDm(String sfcsh1xsnzjczxszknDm) {
		this.sfcsh1xsnzjczxszknDm = sfcsh1xsnzjczxszknDm;
	}

	public String getSfcsh1xsnzjczxszknMc() {
		return this.sfcsh1xsnzjczxszknMc;
	}

	public void setSfcsh1xsnzjczxszknMc(String sfcsh1xsnzjczxszknMc) {
		this.sfcsh1xsnzjczxszknMc = sfcsh1xsnzjczxszknMc;
	}

	public String getYwblxhdDm() {
		return this.ywblxhdDm;
	}

	public void setYwblxhdDm(String ywblxhdDm) {
		this.ywblxhdDm = ywblxhdDm;
	}

	public String getYwblxhdMc() {
		return this.ywblxhdMc;
	}

	public void setYwblxhdMc(String ywblxhdMc) {
		this.ywblxhdMc = ywblxhdMc;
	}

	public String getYwhxjpzhzDm() {
		return this.ywhxjpzhzDm;
	}

	public void setYwhxjpzhzDm(String ywhxjpzhzDm) {
		this.ywhxjpzhzDm = ywhxjpzhzDm;
	}

	public String getYwhxjpzhzMc() {
		return this.ywhxjpzhzMc;
	}

	public void setYwhxjpzhzMc(String ywhxjpzhzMc) {
		this.ywhxjpzhzMc = ywhxjpzhzMc;
	}

	public String getYwfyDm() {
		return this.ywfyDm;
	}

	public void setYwfyDm(String ywfyDm) {
		this.ywfyDm = ywfyDm;
	}

	public String getYwfyMc() {
		return this.ywfyMc;
	}

	public void setYwfyMc(String ywfyMc) {
		this.ywfyMc = ywfyMc;
	}

	public String getYwyzzDm() {
		return this.ywyzzDm;
	}

	public void setYwyzzDm(String ywyzzDm) {
		this.ywyzzDm = ywyzzDm;
	}

	public String getYwyzzMc() {
		return this.ywyzzMc;
	}

	public void setYwyzzMc(String ywyzzMc) {
		this.ywyzzMc = ywyzzMc;
	}

	public String getYwqxqyxnbDm() {
		return this.ywqxqyxnbDm;
	}

	public void setYwqxqyxnbDm(String ywqxqyxnbDm) {
		this.ywqxqyxnbDm = ywqxqyxnbDm;
	}

	public String getYwqxqyxnbMc() {
		return this.ywqxqyxnbMc;
	}

	public void setYwqxqyxnbMc(String ywqxqyxnbMc) {
		this.ywqxqyxnbMc = ywqxqyxnbMc;
	}

	public String getYwqbgrDm() {
		return this.ywqbgrDm;
	}

	public void setYwqbgrDm(String ywqbgrDm) {
		this.ywqbgrDm = ywqbgrDm;
	}

	public String getYwqbgrMc() {
		return this.ywqbgrMc;
	}

	public void setYwqbgrMc(String ywqbgrMc) {
		this.ywqbgrMc = ywqbgrMc;
	}

	public String getYwbxzDm() {
		return this.ywbxzDm;
	}

	public void setYwbxzDm(String ywbxzDm) {
		this.ywbxzDm = ywbxzDm;
	}

	public String getYwbxzMc() {
		return this.ywbxzMc;
	}

	public void setYwbxzMc(String ywbxzMc) {
		this.ywbxzMc = ywbxzMc;
	}

	public String getYwpsfDm() {
		return this.ywpsfDm;
	}

	public void setYwpsfDm(String ywpsfDm) {
		this.ywpsfDm = ywpsfDm;
	}

	public String getYwpsfMc() {
		return this.ywpsfMc;
	}

	public void setYwpsfMc(String ywpsfMc) {
		this.ywpsfMc = ywpsfMc;
	}

	public String getQtxsebzxs() {
		return this.qtxsebzxs;
	}

	public void setQtxsebzxs(String qtxsebzxs) {
		this.qtxsebzxs = qtxsebzxs;
	}

	public String getSfxsechDm() {
		return this.sfxsechDm;
	}

	public void setSfxsechDm(String sfxsechDm) {
		this.sfxsechDm = sfxsechDm;
	}

	public String getSfxsechMc() {
		return this.sfxsechMc;
	}

	public void setSfxsechMc(String sfxsechMc) {
		this.sfxsechMc = sfxsechMc;
	}

	public String getSfmrwyDm() {
		return this.sfmrwyDm;
	}

	public void setSfmrwyDm(String sfmrwyDm) {
		this.sfmrwyDm = sfmrwyDm;
	}

	public String getSfmrwyMc() {
		return this.sfmrwyMc;
	}

	public void setSfmrwyMc(String sfmrwyMc) {
		this.sfmrwyMc = sfmrwyMc;
	}

	public String getSfxsejbscDm2x() {
		return this.sfxsejbscDm2x;
	}

	public void setSfxsejbscDm2x(String sfxsejbscDm2x) {
		this.sfxsejbscDm2x = sfxsejbscDm2x;
	}

	public String getSfxsejbscMc2x() {
		return this.sfxsejbscMc2x;
	}

	public void setSfxsejbscMc2x(String sfxsejbscMc2x) {
		this.sfxsejbscMc2x = sfxsejbscMc2x;
	}

	public String getSfxsejbscDm27x() {
		return this.sfxsejbscDm27x;
	}

	public void setSfxsejbscDm27x(String sfxsejbscDm27x) {
		this.sfxsejbscDm27x = sfxsejbscDm27x;
	}

	public String getSfxsejbscMc27x() {
		return this.sfxsejbscMc27x;
	}

	public void setSfxsejbscMc27x(String sfxsejbscMc27x) {
		this.sfxsejbscMc27x = sfxsejbscMc27x;
	}

	public String getTljcjgDm() {
		return this.tljcjgDm;
	}

	public void setTljcjgDm(String tljcjgDm) {
		this.tljcjgDm = tljcjgDm;
	}

	public String getTljcjgMc() {
		return this.tljcjgMc;
	}

	public void setTljcjgMc(String tljcjgMc) {
		this.tljcjgMc = tljcjgMc;
	}

	public String getYmmcDm() {
		return this.ymmcDm;
	}

	public void setYmmcDm(String ymmcDm) {
		this.ymmcDm = ymmcDm;
	}

	public String getYmMc() {
		return this.ymMc;
	}

	public void setYmMc(String ymMc) {
		this.ymMc = ymMc;
	}

	public String getYgmyqdbzsqkDm() {
		return this.ygmyqdbzsqkDm;
	}

	public void setYgmyqdbzsqkDm(String ygmyqdbzsqkDm) {
		this.ygmyqdbzsqkDm = ygmyqdbzsqkDm;
	}

	public String getYgmyqdbzsqk() {
		return this.ygmyqdbzsqk;
	}

	public void setYgmyqdbzsqk(String ygmyqdbzsqk) {
		this.ygmyqdbzsqk = ygmyqdbzsqk;
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