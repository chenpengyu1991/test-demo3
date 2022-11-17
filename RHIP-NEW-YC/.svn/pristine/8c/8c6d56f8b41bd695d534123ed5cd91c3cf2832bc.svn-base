package com.founder.rhip.ehr.entity.control.dmbc;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "DMBC_FLY_CAUGHT")
public class DmbcFlyCaught implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|数据库唯一编号（自增长）||", length = 11, scale = 11, nullable = true)
	private Long id;

	@Column(name = "MONITOR_ID", columnDefinition = "NUMBER|苍蝇监测记录ID||", length = 11, scale = 11, nullable = true)
	private Long monitorId;

	@Column(name = "ENVIRONMENT", columnDefinition = "VARCHAR2|环境类型||", length = 20, scale = 20, nullable = true)
	private String environment;

	@Column(name = "PLACE", columnDefinition = "VARCHAR2|地点||", length = 40, scale = 40, nullable = true)
	private String place;

	@Column(name = "CAGE_COUNT", columnDefinition = "NUMBER|蝇笼数||", length = 5, scale = 5, nullable = true)
	private Long cageCount;
	
	@Column(name = "HOUSE_FLY", columnDefinition = "NUMBER|家蝇||", length = 5, scale = 5, nullable = true)
	private Long houseFly;

	@Column(name = "MUSCA_SORBENS", columnDefinition = "NUMBER|市蝇||", length = 5, scale = 5, nullable = true)
	private Long muscaSorbens;

	@Column(name = "LUCILLIA_SERICATA", columnDefinition = "NUMBER|丝光绿蝇||", length = 5, scale = 5, nullable = true)
	private Long lucilliaSericata;

	@Column(name = "LUCILIA_CUPRINA", columnDefinition = "NUMBER|铜绿蝇||", length = 5, scale = 5, nullable = true)
	private Long luciliaCuprina;

	@Column(name = "LUCILIA_ILLUSTRIS", columnDefinition = "NUMBER|亮绿蝇||", length = 5, scale = 5, nullable = true)
	private Long luciliaIllustris;

	@Column(name = "CHRYSOMYIA_MEGACEPHALA", columnDefinition = "NUMBER|大头金蝇||", length = 5, scale = 5, nullable = true)
	private Long chrysomyiaMegacephala;

	@Column(name = "PHORMIA_REGINA", columnDefinition = "NUMBER|伏蝇||", length = 5, scale = 5, nullable = true)
	private Long phormiaRegina;

	@Column(name = "PROTOPHORMIA_TERRAENOVAE", columnDefinition = "NUMBER|新陆原伏蝇||", length = 5, scale = 5, nullable = true)
	private Long protophormiaTerraenovae;

	@Column(name = "ALDRICHINA_GRAHAMI", columnDefinition = "NUMBER|巨尾阿丽蝇||", length = 5, scale = 5, nullable = true)
	private Long aldrichinaGrahami;

	@Column(name = "CALLIPHORA_VICINA", columnDefinition = "NUMBER|红头丽蝇||", length = 5, scale = 5, nullable = true)
	private Long calliphoraVicina;

	@Column(name = "MUSCINA_STABULANS", columnDefinition = "NUMBER|厩腐蝇||", length = 5, scale = 5, nullable = true)
	private Long muscinaStabulans;

	@Column(name = "FANNIA_CANICULARIS", columnDefinition = "NUMBER|夏厕蝇||", length = 5, scale = 5, nullable = true)
	private Long fanniaCanicularis;

	@Column(name = "FANNIA_PRISCA", columnDefinition = "NUMBER|元厕蝇||", length = 5, scale = 5, nullable = true)
	private Long fanniaPrisca;

	@Column(name = "BOETTCHERISCA_PEREGRINA", columnDefinition = "NUMBER|棕尾别麻蝇||", length = 5, scale = 5, nullable = true)
	private Long boettcheriscaPeregrina;

	@Column(name = "OTHER", columnDefinition = "NUMBER|其它||", length = 5, scale = 5, nullable = true)
	private Long other;

	@Column(name = "TOTAL", columnDefinition = "NUMBER|合计||", length = 5, scale = 5, nullable = true)
	private Long total;

	@Column(name = "DENSITY", columnDefinition = "NUMBER|密度（只/笼）||", length = 5, scale = 5, nullable = true)
	private Long density;

	@Column(name = "REMARKS", columnDefinition = "VARCHAR2|备注||", length = 40, scale = 40, nullable = true)
	private String remarks;

	@Column(name = "SPECIES_CODE", columnDefinition = "VARCHAR2|苍蝇种类代码||", length = 40, scale = 40, nullable = true)
	private String speciesCode;

	@Column(name = "CREATE_TIME", columnDefinition = "DATE|创建时间||", nullable = true)
	private Date createTime;

	@Column(name = "CREATE_BY", columnDefinition = "VARCHAR2|创建者||", length = 20, scale = 20, nullable = true)
	private String createBy;

	@Column(name = "UPDATE_TIME", columnDefinition = "DATE|更新时间||", nullable = true)
	private Date updateTime;

	@Column(name = "UPDATE_BY", columnDefinition = "VARCHAR2|更新者||", length = 20, scale = 20, nullable = true)
	private String updateBy;

	@Column(name = "IS_DELETE", columnDefinition = "INT|删除状态||", nullable = true)
	private Integer isDelete;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getMonitorId() {
		return this.monitorId;
	}

	public void setMonitorId(Long monitorId) {
		this.monitorId = monitorId;
	}

	public String getEnvironment() {
		return this.environment;
	}

	public void setEnvironment(String environment) {
		this.environment = environment;
	}

	public String getPlace() {
		return this.place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public Long getHouseFly() {
		return this.houseFly;
	}

	public void setHouseFly(Long houseFly) {
		this.houseFly = houseFly;
	}

	public Long getMuscaSorbens() {
		return this.muscaSorbens;
	}

	public void setMuscaSorbens(Long muscaSorbens) {
		this.muscaSorbens = muscaSorbens;
	}

	public Long getLucilliaSericata() {
		return this.lucilliaSericata;
	}

	public void setLucilliaSericata(Long lucilliaSericata) {
		this.lucilliaSericata = lucilliaSericata;
	}

	public Long getLuciliaCuprina() {
		return this.luciliaCuprina;
	}

	public void setLuciliaCuprina(Long luciliaCuprina) {
		this.luciliaCuprina = luciliaCuprina;
	}

	public Long getLuciliaIllustris() {
		return this.luciliaIllustris;
	}

	public void setLuciliaIllustris(Long luciliaIllustris) {
		this.luciliaIllustris = luciliaIllustris;
	}

	public Long getChrysomyiaMegacephala() {
		return this.chrysomyiaMegacephala;
	}

	public void setChrysomyiaMegacephala(Long chrysomyiaMegacephala) {
		this.chrysomyiaMegacephala = chrysomyiaMegacephala;
	}

	public Long getPhormiaRegina() {
		return this.phormiaRegina;
	}

	public void setPhormiaRegina(Long phormiaRegina) {
		this.phormiaRegina = phormiaRegina;
	}

	public Long getProtophormiaTerraenovae() {
		return this.protophormiaTerraenovae;
	}

	public void setProtophormiaTerraenovae(Long protophormiaTerraenovae) {
		this.protophormiaTerraenovae = protophormiaTerraenovae;
	}

	public Long getAldrichinaGrahami() {
		return this.aldrichinaGrahami;
	}

	public void setAldrichinaGrahami(Long aldrichinaGrahami) {
		this.aldrichinaGrahami = aldrichinaGrahami;
	}

	public Long getCalliphoraVicina() {
		return this.calliphoraVicina;
	}

	public void setCalliphoraVicina(Long calliphoraVicina) {
		this.calliphoraVicina = calliphoraVicina;
	}

	public Long getMuscinaStabulans() {
		return this.muscinaStabulans;
	}

	public void setMuscinaStabulans(Long muscinaStabulans) {
		this.muscinaStabulans = muscinaStabulans;
	}

	public Long getFanniaCanicularis() {
		return this.fanniaCanicularis;
	}

	public void setFanniaCanicularis(Long fanniaCanicularis) {
		this.fanniaCanicularis = fanniaCanicularis;
	}

	public Long getFanniaPrisca() {
		return this.fanniaPrisca;
	}

	public void setFanniaPrisca(Long fanniaPrisca) {
		this.fanniaPrisca = fanniaPrisca;
	}

	public Long getBoettcheriscaPeregrina() {
		return this.boettcheriscaPeregrina;
	}

	public void setBoettcheriscaPeregrina(Long boettcheriscaPeregrina) {
		this.boettcheriscaPeregrina = boettcheriscaPeregrina;
	}

	public Long getOther() {
		return this.other;
	}

	public void setOther(Long other) {
		this.other = other;
	}

	public Long getTotal() {
		total=0L;
		if(houseFly!=null)
			total+=houseFly;
		if(muscaSorbens!=null)
			total+=muscaSorbens;
		if(lucilliaSericata!=null)
			total+=lucilliaSericata;
		if(luciliaCuprina!=null)
			total+=luciliaCuprina;
		if(luciliaIllustris!=null)
			total+=luciliaIllustris;
		if(chrysomyiaMegacephala!=null)
			total+=chrysomyiaMegacephala;
		if(phormiaRegina!=null)
			total+=phormiaRegina;
		if(protophormiaTerraenovae!=null)
			total+=protophormiaTerraenovae;
		if(aldrichinaGrahami!=null)
			total+=aldrichinaGrahami;
		if(calliphoraVicina!=null)
			total+=calliphoraVicina;
		if(muscinaStabulans!=null)
			total+=muscinaStabulans;
		if(fanniaCanicularis!=null)
			total+=fanniaCanicularis;
		if(fanniaPrisca!=null)
			total+=fanniaPrisca;
		if(boettcheriscaPeregrina!=null)
			total+=boettcheriscaPeregrina;
		if(other!=null)
			total+=other;
		return this.total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	public Long getDensity() {
		return  Math.round(Double.valueOf((total/cageCount)));
		//return this.density;
	}

	public void setDensity(Long density) {
		this.density = density;
	}

	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getSpeciesCode() {
		if (this.speciesCode != null) {
			return this.speciesCode;
		} else {
			StringBuilder sb = new StringBuilder();
			if (houseFly != null && houseFly > 0)
				sb.append("1,");
			if (muscaSorbens != null && muscaSorbens > 0)
				sb.append("2,");
			if (lucilliaSericata != null && lucilliaSericata > 0)
				sb.append("3,");
			if (luciliaCuprina != null && luciliaCuprina > 0)
				sb.append("4,");
			if (luciliaIllustris != null && luciliaIllustris > 0)
				sb.append("5,");
			if (chrysomyiaMegacephala != null && chrysomyiaMegacephala > 0)
				sb.append("6,");
			if (phormiaRegina != null && phormiaRegina > 0)
				sb.append("7,");
			if (protophormiaTerraenovae != null && protophormiaTerraenovae > 0)
				sb.append("8,");
			if (aldrichinaGrahami != null && aldrichinaGrahami > 0)
				sb.append("9,");
			if (calliphoraVicina != null && calliphoraVicina > 0)
				sb.append("10,");
			if (muscinaStabulans != null && muscinaStabulans > 0)
				sb.append("11,");
			if (fanniaCanicularis != null && fanniaCanicularis > 0)
				sb.append("12,");
			if (fanniaPrisca != null && fanniaPrisca > 0)
				sb.append("13,");
			if (boettcheriscaPeregrina != null && boettcheriscaPeregrina > 0)
				sb.append("14,");
			if (other != null && other > 0)
				sb.append("99,");
			if (sb.indexOf(",") > 0) {
				sb.deleteCharAt(sb.length() - 1);
			}
			return sb.toString();
		}
	}

	public void setSpeciesCode(String speciesCode) {
		this.speciesCode = speciesCode;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getCreateBy() {
		return this.createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public Date getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getUpdateBy() {
		return this.updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	public Integer getIsDelete() {
		return this.isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

	public Long getCageCount() {
		return cageCount;
	}

	public void setCageCount(Long cageCount) {
		this.cageCount = cageCount;
	}

}