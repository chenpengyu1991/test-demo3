package com.founder.rhip.ehr.entity.portal;

import oracle.sql.TIMESTAMP;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by f on 2016/11/24.
 */
@Entity
@Table(name = "SZD_CHARGEITEM")
@XmlRootElement(name = "root")
@XmlAccessorType(XmlAccessType.FIELD)
public class ChargeItem implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name = "CHAITEM_CD", columnDefinition = "CHAR|项目代码||", nullable=false)
    private String chaitemCd;

    @Column(name = "ITEM_NO", columnDefinition = "VARCHAR2|项目编码||",length = 32 , nullable = true)
    private String itemNo;

    @Column(name = "TYPE", columnDefinition = "CHAR|大类||", nullable = true)
    private String type;

    @Column(name = "ITEM_NAME", columnDefinition = "VARCHAR2|项目名称||",length = 70, nullable = false)
    private String itemName;

    @Column(name = "PYCODE", columnDefinition = "VARCHAR2|拼音码||",length = 30 , nullable = true)
    private String pycode;

    @Column(name = "WBCODE", columnDefinition = "VARCHAR2|五笔码||",length = 30 , nullable = true)
    private String wbcode;

    @Column(name = "SORTNO", columnDefinition = "NUMBER|排序码||", nullable = true)
    private Integer sortno;

    @Column(name = "SPEC", columnDefinition = "VARCHAR2|规格||",length = 64 , nullable = true)
    private String spec;

    @Column(name = "UNIT", columnDefinition = "VARCHAR2|单位||",length = 32 , nullable = true)
    private String unit;

    @Column(name = "PRICE1", columnDefinition = "NUMBER|单价1||", nullable = true)
    private Integer price1;

    @Column(name = "PRICE2", columnDefinition = "NUMBER|单价2||", nullable = true)
    private Integer price2;

    @Column(name = "PRICE3", columnDefinition = "NUMBER|单价3||", nullable = true)
    private Integer price3;

    @Column(name = "PRICE4", columnDefinition = "NUMBER|单价4||", nullable = true)
    private Integer price4;

    @Column(name = "CREDIT_CD", columnDefinition = "VARCHAR2|借方科目||",length = 20 , nullable = true)
    private String creditCd;

    @Column(name = "AUDIT_CD", columnDefinition = "VARCHAR2|贷方科目||",length = 20 , nullable = true)
    private String auditCd;

    @Column(name = "MZOPEN_FLG", columnDefinition = "CHAR|门诊开放||", nullable = true)
    private String mzopenFlg;

    @Column(name = "ZYOPEN_FLG", columnDefinition = "CHAR|住院开放||", nullable = true)
    private String zyopenFlg;

    @Column(name = "CHGTYPE_CD", columnDefinition = "VARCHAR2|费用性质||",length = 15 , nullable = true)
    private String chgtypeCd;

    @Column(name = "COOP_INSURANCE_CD", columnDefinition = "VARCHAR2|农合编码||",length = 32 , nullable = true)
    private String coopInsuranceCd;

    @Column(name = "PUBMEDI_CD", columnDefinition = "VARCHAR2|公疗编码||",length = 32 , nullable = true)
    private String pubmediCd;

    @Column(name = "GROUP_FLG", columnDefinition = "CHAR|组合项标志||", nullable = true)
    private String groupFlg;

    @Column(name = "EXPE_FLG", columnDefinition = "CHAR|贵重标志||", nullable = true)
    private String expeFlg;

    @Column(name = "MZCONFIRM_FLG", columnDefinition = "CHAR|门诊确认||", nullable = true)
    private String mzconfirmFlg;

    @Column(name = "ZYCONFIRM_FLG", columnDefinition = "CHAR|住院确认||", nullable = true)
    private String zyconfirmFlg;

    @Column(name = "PRINT_NAME", columnDefinition = "VARCHAR2|打印名称||",length = 70 , nullable = true)
    private String printName;

    @Column(name = "EXEC_DEPT_CD", columnDefinition = "CHAR|执行科室_代码||", nullable = true)
    private String execDeptCd;

    @Column(name = "CHARGECLASS", columnDefinition = "CHAR|费用类别_代码||", nullable = true)
    private String chargeclass;

    @Column(name = "STAT_TYPE1_CD", columnDefinition = "CHAR|统计类别1_代码||", nullable = true)
    private String statType1Cd;

    @Column(name = "STAT_TYPE2_CD", columnDefinition = "CHAR|统计类别2_代码||", nullable = true)
    private String statType2Cd;

    @Column(name = "MZ_INVOICE_TYPE_CD", columnDefinition = "CHAR|门诊发票类别_代码||", nullable = true)
    private String mzInvoiceTypeCd;

    @Column(name = "ZYINVOICE_CLASS_CD", columnDefinition = "CHAR|住院发票类别_代码||", nullable = true)
    private String zyinvoiceClassCd;

    @Column(name = "DRUG_CLASS_CD", columnDefinition = "CHAR|药品类别_代码||", nullable = true)
    private String drugClassCd;

    @Column(name = "DOSAGE_FORM_CD", columnDefinition = "CHAR|剂型_代码||", nullable = true)
    private String dosageFormCd;

    @Column(name = "CLASSMANAGER", columnDefinition = "CHAR|大类管理 1-口服 2-大输涣娑3-针剂 4-饮片 5-其它||", nullable = true)
    private String classmanager;

    @Column(name = "HEMP_CLASS_CD", columnDefinition = "CHAR|毒麻类别_代码||", nullable = true)
    private String hempClassCd;

    @Column(name = "ACCOUNT_METHOD_CD", columnDefinition = "CHAR|核算方法_代码||", nullable = true)
    private String accountMethodCd;

    @Column(name = "DOSE_METHOD_CD", columnDefinition = "VARCHAR2|给药方法_代码||",length = 16 , nullable = true)
    private String doseMethodCd;

    @Column(name = "FREQUENCY_CD", columnDefinition = "VARCHAR2|频次_代码||",length = 16 , nullable = true)
    private String frequencyCd;

    @Column(name = "BAR_CD", columnDefinition = "VARCHAR2|条型码||",length = 20 , nullable = true)
    private String barCd;

    @Column(name = "OTC_FLG", columnDefinition = "CHAR|OTC标志||", nullable = true)
    private String otcFlg;

    @Column(name = "POISION_FLG", columnDefinition = "CHAR|毒麻标志||", nullable = true)
    private String poisionFlg;

    @Column(name = "MANUFACTORY_DEF", columnDefinition = "CHAR|默认厂家||", nullable = true)
    private String manufactoryDef;

    @Column(name = "SUPPLIER_DEF", columnDefinition = "CHAR|默认供应商||", nullable = true)
    private String supplierDef;

    @Column(name = "SPECCONTENT", columnDefinition = "NUMBER|规格含量||", nullable = true)
    private Integer speccontent;

    @Column(name = "DOSAGEUNIT", columnDefinition = "VARCHAR2|剂量单位||",length = 12 , nullable = true)
    private String dosageunit;

    @Column(name = "COMMDOSAGE", columnDefinition = "NUMBER|常用剂量||", nullable = true)
    private Integer commdosage;

    @Column(name = "VOLUME", columnDefinition = "NUMBER|体积||", nullable = true)
    private Integer volume;

    @Column(name = "VOLUUNIT", columnDefinition = "VARCHAR2|体积单位||",length = 12 , nullable = true)
    private String voluunit;

    @Column(name = "WEIGHT", columnDefinition = "NUMBER|重量||", nullable = true)
    private Integer weight;

    @Column(name = "WEIGHTUNIT", columnDefinition = "VARCHAR2|重量单位||",length =12 , nullable = true)
    private String weightunit;

    @Column(name = "CONCENTRATION", columnDefinition = "VARCHAR2|浓度||",length =12 , nullable = true)
    private String concentration;

    @Column(name = "EXPIRYDATE", columnDefinition = "NUMBER|效期||", nullable = true)
    private Integer expirydate;

    @Column(name = "MZPUT_FLG", columnDefinition = "CHAR|门诊发药标志||", nullable = true)
    private String mzputFlg;

    @Column(name = "ZYPUT_FLG", columnDefinition = "CHAR|住院发药标志||", nullable = true)
    private String zyputFlg;

    @Column(name = "ROUNDTYPE", columnDefinition = "CHAR|||", nullable = true)
    private String roundtype;

    @Column(name = "REGI_NO", columnDefinition = "VARCHAR2|注册证号||",length =20 , nullable = true)
    private String regiNo;

    @Column(name = "REGI_VALIDITY", columnDefinition = "DATE|注册证效期||", nullable = true)
    private Date regiValidity;

    @Column(name = "HEALTH_NO", columnDefinition = "VARCHAR2|卫生证号||",length =30 , nullable = true)
    private String healthNo;

    @Column(name = "HEALTH_VALIDITY", columnDefinition = "DATE|卫生证效期||", nullable = true)
    private Date healthValidity;

    @Column(name = "CLASS_NO", columnDefinition = "VARCHAR2|分类码||",length =20 , nullable = true)
    private String classNo;

    @Column(name = "ADD_RATE", columnDefinition = "NUMBER|加价率||", nullable = true)
    private Integer addRate;

    @Column(name = "INTER_NO", columnDefinition = "VARCHAR2|国标码||",length = 30 , nullable = true)
    private String interNo;

    @Column(name = "GOODS_POSITION", columnDefinition = "VARCHAR2|货位号||",length = 30 , nullable = true)
    private String goodsPosition;

    @Column(name = "BRAND", columnDefinition = "VARCHAR2|品牌||",length =64 , nullable = true)
    private String brand;

    @Column(name = "REUSE_FLG", columnDefinition = "CHAR|是否重复使用||", nullable = true)
    private String reuseFlg;

    @Column(name = "REUSE_TIMES", columnDefinition = "NUMBER|重复使用次数||", nullable = true)
    private Integer reuseTimes;

    @Column(name = "REUSE_MAXTIMES", columnDefinition = "NUMBER|重复使用次数限额||", nullable = true)
    private Integer reuseMaxtimes;

    @Column(name = "SKINTEST_FLG", columnDefinition = "CHAR|||", nullable = true)
    private String skintestFlg;

    @Column(name = "ISUSE", columnDefinition = "CHAR|启用标志||", nullable = false)
    private String isuse;

    @Column(name = "REMARKS", columnDefinition = "VARCHAR2|备注||",length = 50 , nullable = true)
    private String remarks;

    @Column(name = "RECORD_CREATER", columnDefinition = "CHAR|记录生成人||", nullable = true)
    private String recordCreater;

    @Column(name = "RECORD_DATE", columnDefinition = "TIMESTAMP|记录生成日期||", nullable = true)
    private Date recordDate;

    @Column(name = "RECENT_CHANGER", columnDefinition = "CHAR|最近修改人||", nullable = true)
    private String recentChanger;

    @Column(name = "LAST_MODIFIED", columnDefinition = "TIMESTAMP|最近修改日期||", nullable = true)
    private Date lastModified;

    @Column(name = "TENANT_ID", columnDefinition = "CHAR|租户ID||", nullable = true)
    private String tenantId;

    @Column(name = "TRAN_ID", columnDefinition = "NUMBER|||", nullable = true)
    private Integer tranId;

    @Column(name = "IS_SPECIAL", columnDefinition = "CHAR|0：否  1：是||", nullable = true)
    private String isSpecial;

    @Column(name = "ANTIBIOTIC_LEVEL", columnDefinition = "CHAR|1, 2, 3 三个级别||", nullable = true)
    private String antibioticLevel;

    @Column(name = "LIST_TYPE", columnDefinition = "CHAR|目录类别 1:国家  2：省增补||", nullable = true)
    private String listType;

    @Column(name = "BASE_DURG_ID", columnDefinition = "VARCHAR2|药品项目对应的基药编码||",length =32 , nullable = true)
    private String baseDurgId;

    @Column(name = "GMP_FLG", columnDefinition = "CHAR|||", nullable = true)
    private String gmpFlg;

    @Column(name = "ANTI_FLG", columnDefinition = "CHAR|||", nullable = true)
    private String antiFlg;

    @Column(name = "ORIGIN_FLG", columnDefinition = "CHAR|||", nullable = true)
    private String originFlg;

    @Column(name = "PRES_QUOTA", columnDefinition = "NUMBER|||", nullable = true)
    private Integer presQuota;

    @Column(name = "COMPAREINDEX", columnDefinition = "VARCHAR2|||",length =64 , nullable = true)
    private String compareindex;

    @Column(name = "IS_JS", columnDefinition = "CHAR|1是激素||", nullable = true)
    private String isJs;

    public String getChaitemCd() {
        return chaitemCd;
    }

    public String getItemNo() {
        return itemNo;
    }

    public String getType() {
        return type;
    }

    public String getItemName() {
        return itemName;
    }

    public String getPycode() {
        return pycode;
    }

    public String getWbcode() {
        return wbcode;
    }

    public Integer getSortno() {
        return sortno;
    }

    public String getSpec() {
        return spec;
    }

    public String getUnit() {
        return unit;
    }

    public Integer getPrice1() {
        return price1;
    }

    public Integer getPrice2() {
        return price2;
    }

    public Integer getPrice3() {
        return price3;
    }

    public Integer getPrice4() {
        return price4;
    }

    public String getCreditCd() {
        return creditCd;
    }

    public String getAuditCd() {
        return auditCd;
    }

    public String getMzopenFlg() {
        return mzopenFlg;
    }

    public String getZyopenFlg() {
        return zyopenFlg;
    }

    public String getChgtypeCd() {
        return chgtypeCd;
    }

    public String getCoopInsuranceCd() {
        return coopInsuranceCd;
    }

    public String getPubmediCd() {
        return pubmediCd;
    }

    public String getGroupFlg() {
        return groupFlg;
    }

    public String getExpeFlg() {
        return expeFlg;
    }

    public String getMzconfirmFlg() {
        return mzconfirmFlg;
    }

    public String getZyconfirmFlg() {
        return zyconfirmFlg;
    }

    public String getPrintName() {
        return printName;
    }

    public String getExecDeptCd() {
        return execDeptCd;
    }

    public String getChargeclass() {
        return chargeclass;
    }

    public String getStatType1Cd() {
        return statType1Cd;
    }

    public String getStatType2Cd() {
        return statType2Cd;
    }

    public String getMzInvoiceTypeCd() {
        return mzInvoiceTypeCd;
    }

    public String getZyinvoiceClassCd() {
        return zyinvoiceClassCd;
    }

    public String getDrugClassCd() {
        return drugClassCd;
    }

    public String getDosageFormCd() {
        return dosageFormCd;
    }

    public String getClassmanager() {
        return classmanager;
    }

    public String getHempClassCd() {
        return hempClassCd;
    }

    public String getAccountMethodCd() {
        return accountMethodCd;
    }

    public String getDoseMethodCd() {
        return doseMethodCd;
    }

    public String getFrequencyCd() {
        return frequencyCd;
    }

    public String getBarCd() {
        return barCd;
    }

    public String getOtcFlg() {
        return otcFlg;
    }

    public String getPoisionFlg() {
        return poisionFlg;
    }

    public String getManufactoryDef() {
        return manufactoryDef;
    }

    public String getSupplierDef() {
        return supplierDef;
    }

    public Integer getSpeccontent() {
        return speccontent;
    }

    public String getDosageunit() {
        return dosageunit;
    }

    public Integer getCommdosage() {
        return commdosage;
    }

    public Integer getVolume() {
        return volume;
    }

    public String getVoluunit() {
        return voluunit;
    }

    public Integer getWeight() {
        return weight;
    }

    public String getWeightunit() {
        return weightunit;
    }

    public String getConcentration() {
        return concentration;
    }

    public Integer getExpirydate() {
        return expirydate;
    }

    public String getMzputFlg() {
        return mzputFlg;
    }

    public String getZyputFlg() {
        return zyputFlg;
    }

    public String getRoundtype() {
        return roundtype;
    }

    public String getRegiNo() {
        return regiNo;
    }

    public Date getRegiValidity() {
        return regiValidity;
    }

    public String getHealthNo() {
        return healthNo;
    }

    public Date getHealthValidity() {
        return healthValidity;
    }

    public String getClassNo() {
        return classNo;
    }

    public Integer getAddRate() {
        return addRate;
    }

    public String getInterNo() {
        return interNo;
    }

    public String getGoodsPosition() {
        return goodsPosition;
    }

    public String getBrand() {
        return brand;
    }

    public String getReuseFlg() {
        return reuseFlg;
    }

    public Integer getReuseTimes() {
        return reuseTimes;
    }

    public Integer getReuseMaxtimes() {
        return reuseMaxtimes;
    }

    public String getSkintestFlg() {
        return skintestFlg;
    }

    public String getIsuse() {
        return isuse;
    }

    public String getRemarks() {
        return remarks;
    }

    public String getRecordCreater() {
        return recordCreater;
    }

    public Date getRecordDate() {
        return recordDate;
    }

    public String getRecentChanger() {
        return recentChanger;
    }

    public Date getLastModified() {
        return lastModified;
    }

    public String getTenantId() {
        return tenantId;
    }

    public Integer getTranId() {
        return tranId;
    }

    public String getIsSpecial() {
        return isSpecial;
    }

    public String getAntibioticLevel() {
        return antibioticLevel;
    }

    public String getListType() {
        return listType;
    }

    public String getBaseDurgId() {
        return baseDurgId;
    }

    public String getGmpFlg() {
        return gmpFlg;
    }

    public String getAntiFlg() {
        return antiFlg;
    }

    public String getOriginFlg() {
        return originFlg;
    }

    public Integer getPresQuota() {
        return presQuota;
    }

    public String getCompareindex() {
        return compareindex;
    }

    public String getIsJs() {
        return isJs;
    }

    public void setChaitemCd(String chaitemCd) {
        this.chaitemCd = chaitemCd;
    }

    public void setItemNo(String itemNo) {
        this.itemNo = itemNo;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setPycode(String pycode) {
        this.pycode = pycode;
    }

    public void setWbcode(String wbcode) {
        this.wbcode = wbcode;
    }

    public void setSortno(Integer sortno) {
        this.sortno = sortno;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public void setPrice1(Integer price1) {
        this.price1 = price1;
    }

    public void setPrice2(Integer price2) {
        this.price2 = price2;
    }

    public void setPrice3(Integer price3) {
        this.price3 = price3;
    }

    public void setPrice4(Integer price4) {
        this.price4 = price4;
    }

    public void setCreditCd(String creditCd) {
        this.creditCd = creditCd;
    }

    public void setAuditCd(String auditCd) {
        this.auditCd = auditCd;
    }

    public void setMzopenFlg(String mzopenFlg) {
        this.mzopenFlg = mzopenFlg;
    }

    public void setZyopenFlg(String zyopenFlg) {
        this.zyopenFlg = zyopenFlg;
    }

    public void setChgtypeCd(String chgtypeCd) {
        this.chgtypeCd = chgtypeCd;
    }

    public void setCoopInsuranceCd(String coopInsuranceCd) {
        this.coopInsuranceCd = coopInsuranceCd;
    }

    public void setPubmediCd(String pubmediCd) {
        this.pubmediCd = pubmediCd;
    }

    public void setGroupFlg(String groupFlg) {
        this.groupFlg = groupFlg;
    }

    public void setExpeFlg(String expeFlg) {
        this.expeFlg = expeFlg;
    }

    public void setMzconfirmFlg(String mzconfirmFlg) {
        this.mzconfirmFlg = mzconfirmFlg;
    }

    public void setZyconfirmFlg(String zyconfirmFlg) {
        this.zyconfirmFlg = zyconfirmFlg;
    }

    public void setPrintName(String printName) {
        this.printName = printName;
    }

    public void setExecDeptCd(String execDeptCd) {
        this.execDeptCd = execDeptCd;
    }

    public void setChargeclass(String chargeclass) {
        this.chargeclass = chargeclass;
    }

    public void setStatType1Cd(String statType1Cd) {
        this.statType1Cd = statType1Cd;
    }

    public void setStatType2Cd(String statType2Cd) {
        this.statType2Cd = statType2Cd;
    }

    public void setMzInvoiceTypeCd(String mzInvoiceTypeCd) {
        this.mzInvoiceTypeCd = mzInvoiceTypeCd;
    }

    public void setZyinvoiceClassCd(String zyinvoiceClassCd) {
        this.zyinvoiceClassCd = zyinvoiceClassCd;
    }

    public void setDrugClassCd(String drugClassCd) {
        this.drugClassCd = drugClassCd;
    }

    public void setDosageFormCd(String dosageFormCd) {
        this.dosageFormCd = dosageFormCd;
    }

    public void setClassmanager(String classmanager) {
        this.classmanager = classmanager;
    }

    public void setHempClassCd(String hempClassCd) {
        this.hempClassCd = hempClassCd;
    }

    public void setAccountMethodCd(String accountMethodCd) {
        this.accountMethodCd = accountMethodCd;
    }

    public void setDoseMethodCd(String doseMethodCd) {
        this.doseMethodCd = doseMethodCd;
    }

    public void setFrequencyCd(String frequencyCd) {
        this.frequencyCd = frequencyCd;
    }

    public void setBarCd(String barCd) {
        this.barCd = barCd;
    }

    public void setOtcFlg(String otcFlg) {
        this.otcFlg = otcFlg;
    }

    public void setPoisionFlg(String poisionFlg) {
        this.poisionFlg = poisionFlg;
    }

    public void setManufactoryDef(String manufactoryDef) {
        this.manufactoryDef = manufactoryDef;
    }

    public void setSupplierDef(String supplierDef) {
        this.supplierDef = supplierDef;
    }

    public void setSpeccontent(Integer speccontent) {
        this.speccontent = speccontent;
    }

    public void setDosageunit(String dosageunit) {
        this.dosageunit = dosageunit;
    }

    public void setCommdosage(Integer commdosage) {
        this.commdosage = commdosage;
    }

    public void setVolume(Integer volume) {
        this.volume = volume;
    }

    public void setVoluunit(String voluunit) {
        this.voluunit = voluunit;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public void setWeightunit(String weightunit) {
        this.weightunit = weightunit;
    }

    public void setConcentration(String concentration) {
        this.concentration = concentration;
    }

    public void setExpirydate(Integer expirydate) {
        this.expirydate = expirydate;
    }

    public void setMzputFlg(String mzputFlg) {
        this.mzputFlg = mzputFlg;
    }

    public void setZyputFlg(String zyputFlg) {
        this.zyputFlg = zyputFlg;
    }

    public void setRoundtype(String roundtype) {
        this.roundtype = roundtype;
    }

    public void setRegiNo(String regiNo) {
        this.regiNo = regiNo;
    }

    public void setRegiValidity(Date regiValidity) {
        this.regiValidity = regiValidity;
    }

    public void setHealthNo(String healthNo) {
        this.healthNo = healthNo;
    }

    public void setHealthValidity(Date healthValidity) {
        this.healthValidity = healthValidity;
    }

    public void setClassNo(String classNo) {
        this.classNo = classNo;
    }

    public void setAddRate(Integer addRate) {
        this.addRate = addRate;
    }

    public void setInterNo(String interNo) {
        this.interNo = interNo;
    }

    public void setGoodsPosition(String goodsPosition) {
        this.goodsPosition = goodsPosition;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setReuseFlg(String reuseFlg) {
        this.reuseFlg = reuseFlg;
    }

    public void setReuseTimes(Integer reuseTimes) {
        this.reuseTimes = reuseTimes;
    }

    public void setReuseMaxtimes(Integer reuseMaxtimes) {
        this.reuseMaxtimes = reuseMaxtimes;
    }

    public void setSkintestFlg(String skintestFlg) {
        this.skintestFlg = skintestFlg;
    }

    public void setIsuse(String isuse) {
        this.isuse = isuse;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public void setRecordCreater(String recordCreater) {
        this.recordCreater = recordCreater;
    }

    public void setRecordDate(Date recordDate) {
        this.recordDate = recordDate;
    }

    public void setRecentChanger(String recentChanger) {
        this.recentChanger = recentChanger;
    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public void setTranId(Integer tranId) {
        this.tranId = tranId;
    }

    public void setIsSpecial(String isSpecial) {
        this.isSpecial = isSpecial;
    }

    public void setAntibioticLevel(String antibioticLevel) {
        this.antibioticLevel = antibioticLevel;
    }

    public void setListType(String listType) {
        this.listType = listType;
    }

    public void setBaseDurgId(String baseDurgId) {
        this.baseDurgId = baseDurgId;
    }

    public void setGmpFlg(String gmpFlg) {
        this.gmpFlg = gmpFlg;
    }

    public void setAntiFlg(String antiFlg) {
        this.antiFlg = antiFlg;
    }

    public void setOriginFlg(String originFlg) {
        this.originFlg = originFlg;
    }

    public void setPresQuota(Integer presQuota) {
        this.presQuota = presQuota;
    }

    public void setCompareindex(String compareindex) {
        this.compareindex = compareindex;
    }

    public void setIsJs(String isJs) {
        this.isJs = isJs;
    }
}
