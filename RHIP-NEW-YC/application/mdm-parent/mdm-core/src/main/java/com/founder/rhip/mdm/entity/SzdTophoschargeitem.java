package com.founder.rhip.mdm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "MDM_TOPHOSCHARGEITEM")
public class SzdTophoschargeitem implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "CATALOGID", columnDefinition = "CHAR|目录编号||", length = 32, nullable = false)
	private String catalogid;

	@Column(name = "TENANT_ID", columnDefinition = "CHAR|机构编码||", length = 6, nullable = false)
	private String tenantId;

	@Column(name = "EXPIRYDATE", columnDefinition = "DATE|终止日期||", nullable = false)
	private Date expirydate;

	@Column(name = "OPENDATE", columnDefinition = "DATE|启用日期||", nullable = false)
	private Date opendate;

	@Column(name = "UPLOADER", columnDefinition = "VARCHAR2|上传人||", length = 10, nullable = false)
	private String uploader;

	@Column(name = "UPLOADERNAME", columnDefinition = "VARCHAR2|上传人名称||", length = 32, nullable = false)
	private String uploadername;

	@Column(name = "UPLOADTIME", columnDefinition = "DATE|上传时间||", nullable = false)
	private Date uploadtime;

	@Column(name = "TYPE", columnDefinition = "CHAR|分类 1-药品 2-收费项目 3-耗材||", length = 1, nullable = false)
	private Integer type;

	@Column(name = "HOSCODE", columnDefinition = "VARCHAR2|医院编码||", length = 10, nullable = false)
	private String hoscode;

	@Column(name = "BASECODE", columnDefinition = "VARCHAR2|基药编码||", length = 20, nullable = true)
	private String basecode;

	@Column(name = "MEDIINSUCODE", columnDefinition = "VARCHAR2|医保编码||", length = 20, nullable = true)
	private String mediinsucode;

	@Column(name = "NCMSCODE", columnDefinition = "VARCHAR2|农保编码||", length = 20, nullable = true)
	private String ncmscode;

	@Column(name = "USERCODE1", columnDefinition = "VARCHAR2|自定义码1||", length = 20, nullable = true)
	private String usercode1;

	@Column(name = "USERCODE2", columnDefinition = "VARCHAR2|自定义码2||", length = 20, nullable = true)
	private String usercode2;

	@Column(name = "USERCODE3", columnDefinition = "VARCHAR2|自定义码3||", length = 20, nullable = true)
	private String usercode3;

	@Column(name = "CHARGETYPECD", columnDefinition = "VARCHAR2|费用类型代码||", length = 2, nullable = false)
	private String chargetypecd;

	@Column(name = "CHARGETYPES", columnDefinition = "VARCHAR2|费用类型名称||", length = 20, nullable = false)
	private String chargetypes;

	@Column(name = "CHARGECLASSCD", columnDefinition = "VARCHAR2|费用类别代码||", length = 4, nullable = false)
	private String chargeclasscd;

	@Column(name = "CHARGECLASS", columnDefinition = "VARCHAR2|费用类别名称||", length = 20, nullable = false)
	private String chargeclass;

	@Column(name = "DRUGCLASSCD", columnDefinition = "VARCHAR2|药品类别代码||", length = 4, nullable = true)
	private String drugclasscd;

	@Column(name = "DRUGCLASS", columnDefinition = "VARCHAR2|药品类别名称||", length = 64, nullable = true)
	private String drugclass;

	@Column(name = "ITEM_NAME", columnDefinition = "VARCHAR2|项目名称||", length = 70, nullable = false)
	private String itemName;

	@Column(name = "PYCODE", columnDefinition = "VARCHAR2|拼音码||", length = 30, nullable = false)
	private String pycode;

	@Column(name = "WBCODE", columnDefinition = "VARCHAR2|五笔码||", length = 30, nullable = false)
	private String wbcode;

	@Column(name = "SPEC", columnDefinition = "VARCHAR2|规格||", length = 64, nullable = false)
	private String spec;

	@Column(name = "DOSAGE_FORM_CD", columnDefinition = "CHAR|剂型代码||", length = 4, nullable = true)
	private String dosageFormCd;

	@Column(name = "DOSAGE_FORM", columnDefinition = "VARCHAR2|剂型名称||", length = 32, nullable = true)
	private String dosageForm;

	@Column(name = "PRICE", columnDefinition = "NUMBER|零售价||", length = 18, nullable = false)
	private Double price;

	@Column(name = "COST_PRICE", columnDefinition = "NUMBER|购入价||", length = 18, nullable = true)
	private Double costPrice;

	@Column(name = "MANUFACTORYCD", columnDefinition = "VARCHAR2|默认厂家编码||", length = 4, nullable = true)
	private String manufactorycd;

	@Column(name = "MANUFACTORY", columnDefinition = "VARCHAR2|默认厂家||", length = 64, nullable = true)
	private String manufactory;

	@Column(name = "PACKUNIT", columnDefinition = "VARCHAR2|包装单位||", length = 12, nullable = false)
	private String packunit;

	@Column(name = "PACKNUM", columnDefinition = "NUMBER|包装含量||", length = 18, nullable = false)
	private Double packnum;

	@Column(name = "MINUNIT", columnDefinition = "VARCHAR2|最小单位||", length = 12, nullable = false)
	private String minunit;

	@Column(name = "DOSAGEUNIT", columnDefinition = "VARCHAR2|剂量单位||", length = 12, nullable = true)
	private String dosageunit;

	@Column(name = "COMMDOSAGE", columnDefinition = "NUMBER|常用剂量||", length = 18, nullable = true)
	private Double commdosage;

	@Column(name = "VOLUME", columnDefinition = "NUMBER|体积||", length = 18, nullable = true)
	private Double volume;

	@Column(name = "VOLUUNIT", columnDefinition = "VARCHAR2|体积单位||", length = 12, nullable = true)
	private String voluunit;

	@Column(name = "WEIGHTUNIT", columnDefinition = "VARCHAR2|重量单位||", length = 12, nullable = true)
	private String weightunit;

	@Column(name = "WEIGHT", columnDefinition = "NUMBER|重量||", length = 18, nullable = true)
	private Double weight;

	@Column(name = "CONCENTRATION", columnDefinition = "VARCHAR2|浓度||", length = 12, nullable = true)
	private String concentration;

	@Column(name = "EXPIRYDATE2", columnDefinition = "NUMBER|有效期||", length = 3, nullable = true)
	private Double expirydate2;

	@Column(name = "DOSE_METHOD_CD", columnDefinition = "VARCHAR2|给药方法代码||", length = 10, nullable = true)
	private String doseMethodCd;

	@Column(name = "DOSE_METHOD", columnDefinition = "VARCHAR2|给药方法||", length = 16, nullable = true)
	private String doseMethod;

	@Column(name = "FREQUENCY_CD", columnDefinition = "VARCHAR2|频次代码||", length = 10, nullable = true)
	private String frequencyCd;

	@Column(name = "ACCOUNTCLASSCD", columnDefinition = "VARCHAR2|会计科目代码||", length = 10, nullable = false)
	private String accountclasscd;

	@Column(name = "ACCOUNTCLASS", columnDefinition = "VARCHAR2|会计科目名称||", length = 64, nullable = false)
	private String accountclass;
	
	@Column(name = "SYNC_FLG", columnDefinition = "CHAR|同步标志||", length = 1, nullable = true)
	private Integer syncFlg;
	
	@Column(name = "SYNC_PER", columnDefinition = "VARCHAR2|同步人||", length = 20, nullable = true)
	private String syncPer;
	
	@Column(name = "SYNC_DATE", columnDefinition = "DATE|同步时间||", nullable = true)
	private Date syncDate;

	public String getCatalogid() {
		return this.catalogid;
	}

	public void setCatalogid(String catalogid) {
		this.catalogid = catalogid;
	}

	public String getTenantId() {
		return this.tenantId;
	}

	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}

	public Date getExpirydate() {
		return this.expirydate;
	}

	public void setExpirydate(Date expirydate) {
		this.expirydate = expirydate;
	}

	public Date getOpendate() {
		return this.opendate;
	}

	public void setOpendate(Date opendate) {
		this.opendate = opendate;
	}

	public String getUploader() {
		return this.uploader;
	}

	public void setUploader(String uploader) {
		this.uploader = uploader;
	}

	public String getUploadername() {
		return this.uploadername;
	}

	public void setUploadername(String uploadername) {
		this.uploadername = uploadername;
	}

	public Date getUploadtime() {
		return this.uploadtime;
	}

	public void setUploadtime(Date uploadtime) {
		this.uploadtime = uploadtime;
	}

	public Integer getType() {
		return this.type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getHoscode() {
		return this.hoscode;
	}

	public void setHoscode(String hoscode) {
		this.hoscode = hoscode;
	}

	public String getBasecode() {
		return this.basecode;
	}

	public void setBasecode(String basecode) {
		this.basecode = basecode;
	}

	public String getMediinsucode() {
		return this.mediinsucode;
	}

	public void setMediinsucode(String mediinsucode) {
		this.mediinsucode = mediinsucode;
	}

	public String getNcmscode() {
		return this.ncmscode;
	}

	public void setNcmscode(String ncmscode) {
		this.ncmscode = ncmscode;
	}

	public String getUsercode1() {
		return this.usercode1;
	}

	public void setUsercode1(String usercode1) {
		this.usercode1 = usercode1;
	}

	public String getUsercode2() {
		return this.usercode2;
	}

	public void setUsercode2(String usercode2) {
		this.usercode2 = usercode2;
	}

	public String getUsercode3() {
		return this.usercode3;
	}

	public void setUsercode3(String usercode3) {
		this.usercode3 = usercode3;
	}

	public String getChargetypecd() {
		return this.chargetypecd;
	}

	public void setChargetypecd(String chargetypecd) {
		this.chargetypecd = chargetypecd;
	}

	public String getChargetypes() {
		return this.chargetypes;
	}

	public void setChargetypes(String chargetypes) {
		this.chargetypes = chargetypes;
	}

	public String getChargeclasscd() {
		return this.chargeclasscd;
	}

	public void setChargeclasscd(String chargeclasscd) {
		this.chargeclasscd = chargeclasscd;
	}

	public String getChargeclass() {
		return this.chargeclass;
	}

	public void setChargeclass(String chargeclass) {
		this.chargeclass = chargeclass;
	}

	public String getDrugclasscd() {
		return this.drugclasscd;
	}

	public void setDrugclasscd(String drugclasscd) {
		this.drugclasscd = drugclasscd;
	}

	public String getDrugclass() {
		return this.drugclass;
	}

	public void setDrugclass(String drugclass) {
		this.drugclass = drugclass;
	}

	public String getItemName() {
		return this.itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getPycode() {
		return this.pycode;
	}

	public void setPycode(String pycode) {
		this.pycode = pycode;
	}

	public String getWbcode() {
		return this.wbcode;
	}

	public void setWbcode(String wbcode) {
		this.wbcode = wbcode;
	}

	public String getSpec() {
		return this.spec;
	}

	public void setSpec(String spec) {
		this.spec = spec;
	}

	public String getDosageFormCd() {
		return this.dosageFormCd;
	}

	public void setDosageFormCd(String dosageFormCd) {
		this.dosageFormCd = dosageFormCd;
	}

	public String getDosageForm() {
		return this.dosageForm;
	}

	public void setDosageForm(String dosageForm) {
		this.dosageForm = dosageForm;
	}

	public Double getPrice() {
		return this.price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getCostPrice() {
		return this.costPrice;
	}

	public void setCostPrice(Double costPrice) {
		this.costPrice = costPrice;
	}

	public String getManufactorycd() {
		return this.manufactorycd;
	}

	public void setManufactorycd(String manufactorycd) {
		this.manufactorycd = manufactorycd;
	}

	public String getManufactory() {
		return this.manufactory;
	}

	public void setManufactory(String manufactory) {
		this.manufactory = manufactory;
	}

	public String getPackunit() {
		return this.packunit;
	}

	public void setPackunit(String packunit) {
		this.packunit = packunit;
	}

	public Double getPacknum() {
		return this.packnum;
	}

	public void setPacknum(Double packnum) {
		this.packnum = packnum;
	}

	public String getMinunit() {
		return this.minunit;
	}

	public void setMinunit(String minunit) {
		this.minunit = minunit;
	}

	public String getDosageunit() {
		return this.dosageunit;
	}

	public void setDosageunit(String dosageunit) {
		this.dosageunit = dosageunit;
	}

	public Double getCommdosage() {
		return this.commdosage;
	}

	public void setCommdosage(Double commdosage) {
		this.commdosage = commdosage;
	}

	public Double getVolume() {
		return this.volume;
	}

	public void setVolume(Double volume) {
		this.volume = volume;
	}

	public String getVoluunit() {
		return this.voluunit;
	}

	public void setVoluunit(String voluunit) {
		this.voluunit = voluunit;
	}

	public String getWeightunit() {
		return this.weightunit;
	}

	public void setWeightunit(String weightunit) {
		this.weightunit = weightunit;
	}

	public Double getWeight() {
		return this.weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public String getConcentration() {
		return this.concentration;
	}

	public void setConcentration(String concentration) {
		this.concentration = concentration;
	}

	public Double getExpirydate2() {
		return this.expirydate2;
	}

	public void setExpirydate2(Double expirydate2) {
		this.expirydate2 = expirydate2;
	}

	public String getDoseMethodCd() {
		return this.doseMethodCd;
	}

	public void setDoseMethodCd(String doseMethodCd) {
		this.doseMethodCd = doseMethodCd;
	}

	public String getDoseMethod() {
		return this.doseMethod;
	}

	public void setDoseMethod(String doseMethod) {
		this.doseMethod = doseMethod;
	}

	public String getFrequencyCd() {
		return this.frequencyCd;
	}

	public void setFrequencyCd(String frequencyCd) {
		this.frequencyCd = frequencyCd;
	}

	public String getAccountclasscd() {
		return this.accountclasscd;
	}

	public void setAccountclasscd(String accountclasscd) {
		this.accountclasscd = accountclasscd;
	}

	public String getAccountclass() {
		return this.accountclass;
	}

	public void setAccountclass(String accountclass) {
		this.accountclass = accountclass;
	}

	public Integer getSyncFlg() {
		return syncFlg;
	}

	public void setSyncFlg(Integer syncFlg) {
		this.syncFlg = syncFlg;
	}

	public String getSyncPer() {
		return syncPer;
	}

	public void setSyncPer(String syncPer) {
		this.syncPer = syncPer;
	}

	public Date getSyncDate() {
		return syncDate;
	}

	public void setSyncDate(Date syncDate) {
		this.syncDate = syncDate;
	}

}