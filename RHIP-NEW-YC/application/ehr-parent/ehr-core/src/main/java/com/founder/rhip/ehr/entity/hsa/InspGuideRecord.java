package com.founder.rhip.ehr.entity.hsa;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "HSA_INSP_GUIDE_RECORD")
public class InspGuideRecord implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|数据库唯一编号（自增长）||", length = 11, nullable = true)
	private Long id;

	@Column(name = "INSP_REOCRD_ID", columnDefinition = "NUMBER|巡查记录编号||", length = 11, nullable = true)
	private Long inspReocrdId;

	@Column(name = "INSP_GUIDE_TYPE_CODE", columnDefinition = "VARCHAR2|巡查指导类型代码||", length = 2, nullable = true)
	private String inspGuideTypeCode;

	@Column(name = "INSP_GUIDE_TYPE_NAME", columnDefinition = "VARCHAR2|巡查指导类型名称||", length = 50, nullable = true)
	private String inspGuideTypeName;
	
	@Column(name = "BCB", columnDefinition = "VARCHAR2|亮证经营代码||", length = 1, nullable = true)
	private String bcb;

	@Column(name = "CYXKZ", columnDefinition = "VARCHAR2|餐饮许可证||", length = 1, nullable = true)
	private String cyxkz;
	
	@Column(name = "BFHIN", columnDefinition = "VARCHAR2|建立食品安全管理组织网络、卫生制度等||", length = 1, nullable = true)
	private String bfhin;

	@Column(name = "FBLFBR", columnDefinition = "VARCHAR2|建立食品采购查验和索证索票制度，食品原辅料采购记录||", length = 1, nullable = true)
	private String fblfbr;

	@Column(name = "OSNU", columnDefinition = "VARCHAR2|经营超过保质期、无标签、或使用非食品原料生产食品等||", length = 1, nullable = true)
	private String osnu;

	@Column(name = "ICT", columnDefinition = "VARCHAR2|内外环境整洁有序，无杂物堆放，垃圾桶密闭加盖||", length = 1, nullable = true)
	private String ict;

	@Column(name = "LPAU", columnDefinition = "VARCHAR2|设凉菜间，有消毒水池、空调、紫外线灯||", length = 1, nullable = true)
	private String lpau;

	@Column(name = "LHS", columnDefinition = "VARCHAR2|设食品原料仓库/区域，有货架||", length = 1, nullable = true)
	private String lhs;

	@Column(name = "LCD", columnDefinition = "VARCHAR2|设餐具消毒间（场所），清洗、消毒设施（水池）||", length = 1, nullable = true)
	private String lcd;

	@Column(name = "ACF", columnDefinition = "VARCHAR2|有生、熟冰箱，生、熟食品分开存放||", length = 1, nullable = true)
	private String acf;

	@Column(name = "WFCF", columnDefinition = "VARCHAR2|配备除“四害”防治设施、开展除“四害”活动||", length = 1, nullable = true)
	private String wfcf;

	@Column(name = "HMS", columnDefinition = "VARCHAR2|卫生管理制度||", length = 1, nullable = true)
	private String hms;

	@Column(name = "HMP", columnDefinition = "VARCHAR2|卫生管理人员||", length = 1, nullable = true)
	private String hmp;
	
	@Column(name = "WT", columnDefinition = "VARCHAR2|水质检测记录 / 检测报告（学校）||", length = 1, nullable = true)
	private String wt;

	@Column(name = "WDD", columnDefinition = "VARCHAR2|水质净化消毒设施正常运转/ 饮水机消毒（学校）||", length = 1, nullable = true)
	private String wdd;

	@Column(name = "WPSW", columnDefinition = "VARCHAR2|水源卫生防护措施 / 贮存仓库（学校）||", length = 1, nullable = true)
	private String wpsw;

	@Column(name = "HYGIENIC_LICENSE", columnDefinition = "VARCHAR2|卫生许可证（仅限集中式供水单位填写）||", length = 1, nullable = true)
	private String hygienicLicense;

	@Column(name = "UD", columnDefinition = "VARCHAR2|使用的涉水产品、消毒剂卫生许可批件||", length = 1, nullable = true)
	private String ud;

	@Column(name = "RCWT", columnDefinition = "VARCHAR2|定期清洗消毒和水质检验（仅限二次供水单位填写）||", length = 1, nullable = true)
	private String rcwt;

	@Column(name = "SDW", columnDefinition = "VARCHAR2|二次供水水箱饮用水专用（仅限二次供水单位填写）||", length = 1, nullable = true)
	private String sdw;

	@Column(name = "SSP", columnDefinition = "VARCHAR2|二次供水水箱周围污染（仅限二次供水单位填写）||", length = 1, nullable = true)
	private String ssp;

	@Column(name = "DOSP", columnDefinition = "VARCHAR2|饮用水水质感官性状检测异味||", length = 1, nullable = true)
	private String dosp;

	@Column(name = "DOSTV", columnDefinition = "VARCHAR2|饮用水水质感官性状检测肉眼可见物||", length = 1, nullable = true)
	private String dostv;
	
	@Column(name = "WBGZ", columnDefinition = "VARCHAR2|卫生防病管理组织||", length = 1, nullable = true)
	private String wbgz;
	
	@Column(name = "ERP", columnDefinition = "VARCHAR2|疫情报告专（兼）职人员||", length = 1, nullable = true)
	private String erp;

	@Column(name = "PEP", columnDefinition = "VARCHAR2|突发公共卫生应急预案||", length = 1, nullable = true)
	private String pep;

	@Column(name = "IDMS", columnDefinition = "VARCHAR2|传染病管理制度||", length = 1, nullable = true)
	private String idms;

	@Column(name = "MCR", columnDefinition = "VARCHAR2|晨检制度及晨检记录||", length = 1, nullable = true)
	private String mcr;

	@Column(name = "SCR", columnDefinition = "VARCHAR2|因病缺勤病因追查与登记制度||", length = 1, nullable = true)
	private String scr;

	@Column(name = "PVI", columnDefinition = "VARCHAR2|小学新生入学接种证查验||", length = 1, nullable = true)
	private String pvi;

	@Column(name = "SHR", columnDefinition = "VARCHAR2|学生健康档案||", length = 1, nullable = true)
	private String shr;

	@Column(name = "KTC", columnDefinition = "VARCHAR2|开展传染病防治知识培训并做好记录||", length = 1, nullable = true)
	private String ktc;

	@Column(name = "IRO", columnDefinition = "VARCHAR2|疫情信息按规定上报||", length = 1, nullable = true)
	private String iro;

	@Column(name = "WPDD", columnDefinition = "VARCHAR2|卫生管理组织网络、卫生制度和有关岗位制度||", length = 1, nullable = true)
	private String wpdd;

	@Column(name = "WHPM", columnDefinition = "VARCHAR2|建立化妆品、一次性卫生用品采购索证制度，有索证登记||", length = 1, nullable = true)
	private String whpm;

	@Column(name = "HPC", columnDefinition = "VARCHAR2|专用消毒间（场所）||", length = 1, nullable = true)
	private String hpc;

	@Column(name = "UWP", columnDefinition = "VARCHAR2|足够容量清洗消毒保洁设施||", length = 1, nullable = true)
	private String uwp;

	@Column(name = "RC", columnDefinition = "VARCHAR2|供顾客使用的公共用品、用具一客一换一消毒||", length = 1, nullable = true)
	private String rc;

	@Column(name = "SWT", columnDefinition = "VARCHAR2|空调等通风设施运转、保养、维修、洗消等工作状态良好||", length = 1, nullable = true)
	private String swt;

	@Column(name = "HCANDHK", columnDefinition = "VARCHAR2|健康合格证明和卫生知识培训合格证明||", length = 1, nullable = true)
	private String hcandhk;

	@Column(name = "PRA_NAMES", columnDefinition = "VARCHAR2|从业人员名称||", length = 500, nullable = true)
	private String praNames;

	@Column(name = "PRA_COUNT", columnDefinition = "INT|从业人员数目||",length=6, nullable = true)
	private Integer praCount;

	@Column(name = "OTHER", columnDefinition = "VARCHAR2|其他||", length = 500, nullable = true)
	private String other;

	@Column(name = "AWHC", columnDefinition = "VARCHAR2|从业人员无健康合格证明、卫生知识培训合格证明名单||", length = 500, nullable = true)
	private String awhc;
	
	@Column(name = "COMMON_CONTENT", columnDefinition = "VARCHAR2|通用|", length = 1000, nullable = true)
	private String commonContent;
	

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getInspReocrdId() {
		return this.inspReocrdId;
	}

	public void setInspReocrdId(Long inspReocrdId) {
		this.inspReocrdId = inspReocrdId;
	}

	public String getInspGuideTypeCode() {
		return this.inspGuideTypeCode;
	}

	public void setInspGuideTypeCode(String inspGuideTypeCode) {
		this.inspGuideTypeCode = inspGuideTypeCode;
	}

	public String getInspGuideTypeName() {
		return this.inspGuideTypeName;
	}

	public void setInspGuideTypeName(String inspGuideTypeName) {
		this.inspGuideTypeName = inspGuideTypeName;
	}

	public String getBcb() {
		return this.bcb;
	}

	public void setBcb(String bcb) {
		this.bcb = bcb;
	}

	public String getBfhin() {
		return this.bfhin;
	}

	public void setBfhin(String bfhin) {
		this.bfhin = bfhin;
	}

	public String getFblfbr() {
		return this.fblfbr;
	}

	public void setFblfbr(String fblfbr) {
		this.fblfbr = fblfbr;
	}

	public String getOsnu() {
		return this.osnu;
	}

	public void setOsnu(String osnu) {
		this.osnu = osnu;
	}

	public String getIct() {
		return this.ict;
	}

	public void setIct(String ict) {
		this.ict = ict;
	}

	public String getLpau() {
		return this.lpau;
	}

	public void setLpau(String lpau) {
		this.lpau = lpau;
	}

	public String getLhs() {
		return this.lhs;
	}

	public void setLhs(String lhs) {
		this.lhs = lhs;
	}

	public String getLcd() {
		return this.lcd;
	}

	public void setLcd(String lcd) {
		this.lcd = lcd;
	}

	public String getAcf() {
		return this.acf;
	}

	public void setAcf(String acf) {
		this.acf = acf;
	}

	public String getWfcf() {
		return this.wfcf;
	}

	public void setWfcf(String wfcf) {
		this.wfcf = wfcf;
	}

	public String getHms() {
		return this.hms;
	}

	public void setHms(String hms) {
		this.hms = hms;
	}

	public String getHmp() {
		return this.hmp;
	}

	public void setHmp(String hmp) {
		this.hmp = hmp;
	}

	public String getWt() {
		return this.wt;
	}

	public void setWt(String wt) {
		this.wt = wt;
	}

	public String getWdd() {
		return this.wdd;
	}

	public void setWdd(String wdd) {
		this.wdd = wdd;
	}

	public String getWpsw() {
		return this.wpsw;
	}

	public void setWpsw(String wpsw) {
		this.wpsw = wpsw;
	}

	public String getHygienicLicense() {
		return this.hygienicLicense;
	}

	public void setHygienicLicense(String hygienicLicense) {
		this.hygienicLicense = hygienicLicense;
	}

	public String getUd() {
		return this.ud;
	}

	public void setUd(String ud) {
		this.ud = ud;
	}

	public String getRcwt() {
		return this.rcwt;
	}

	public void setRcwt(String rcwt) {
		this.rcwt = rcwt;
	}

	public String getSdw() {
		return this.sdw;
	}

	public void setSdw(String sdw) {
		this.sdw = sdw;
	}

	public String getSsp() {
		return this.ssp;
	}

	public void setSsp(String ssp) {
		this.ssp = ssp;
	}

	public String getDosp() {
		return this.dosp;
	}

	public void setDosp(String dosp) {
		this.dosp = dosp;
	}

	public String getDostv() {
		return this.dostv;
	}

	public void setDostv(String dostv) {
		this.dostv = dostv;
	}

	public String getErp() {
		return this.erp;
	}

	public void setErp(String erp) {
		this.erp = erp;
	}

	public String getPep() {
		return this.pep;
	}

	public void setPep(String pep) {
		this.pep = pep;
	}

	public String getIdms() {
		return this.idms;
	}

	public void setIdms(String idms) {
		this.idms = idms;
	}

	public String getMcr() {
		return this.mcr;
	}

	public void setMcr(String mcr) {
		this.mcr = mcr;
	}

	public String getScr() {
		return this.scr;
	}

	public void setScr(String scr) {
		this.scr = scr;
	}

	public String getPvi() {
		return this.pvi;
	}

	public void setPvi(String pvi) {
		this.pvi = pvi;
	}

	public String getShr() {
		return this.shr;
	}

	public void setShr(String shr) {
		this.shr = shr;
	}

	public String getKtc() {
		return this.ktc;
	}

	public void setKtc(String ktc) {
		this.ktc = ktc;
	}

	public String getIro() {
		return this.iro;
	}

	public void setIro(String iro) {
		this.iro = iro;
	}

	public String getWpdd() {
		return this.wpdd;
	}

	public void setWpdd(String wpdd) {
		this.wpdd = wpdd;
	}

	public String getWhpm() {
		return this.whpm;
	}

	public void setWhpm(String whpm) {
		this.whpm = whpm;
	}

	public String getHpc() {
		return this.hpc;
	}

	public void setHpc(String hpc) {
		this.hpc = hpc;
	}

	public String getUwp() {
		return this.uwp;
	}

	public void setUwp(String uwp) {
		this.uwp = uwp;
	}

	public String getRc() {
		return this.rc;
	}

	public void setRc(String rc) {
		this.rc = rc;
	}

	public String getSwt() {
		return this.swt;
	}

	public void setSwt(String swt) {
		this.swt = swt;
	}

	public String getHcandhk() {
		return this.hcandhk;
	}

	public void setHcandhk(String hcandhk) {
		this.hcandhk = hcandhk;
	}

	public String getPraNames() {
		return this.praNames;
	}

	public void setPraNames(String praNames) {
		this.praNames = praNames;
	}

	public Integer getPraCount() {
		return this.praCount;
	}

	public void setPraCount(Integer praCount) {
		this.praCount = praCount;
	}

	public String getOther() {
		return this.other;
	}

	public void setOther(String other) {
		this.other = other;
	}

	public String getAwhc() {
		return this.awhc;
	}

	public void setAwhc(String awhc) {
		this.awhc = awhc;
	}
	public String getWbgz() {
		return wbgz;
	}

	public void setWbgz(String wbgz) {
		this.wbgz = wbgz;
	}
	public String getCyxkz() {
		return cyxkz;
	}

	public void setCyxkz(String cyxkz) {
		this.cyxkz = cyxkz;
	}

	public String getCommonContent() {
		return commonContent;
	}

	public void setCommonContent(String commonContent) {
		this.commonContent = commonContent;
	}
}