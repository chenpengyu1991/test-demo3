package com.founder.rhip.ehr.entity.control.dmbc;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "DMBC_MOSQUITOES_CAUGHT")
public class DmbcMosquitoesCaught implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|数据库唯一编号（自增长）||", length = 11, scale = 11, nullable = true)
	private Long id;

	@Column(name = "MONITOR_ID", columnDefinition = "NUMBER|成蚊监测记录ID||", length = 11, scale = 11, nullable = true)
	private Long monitorId;

	@Column(name = "PLACE", columnDefinition = "VARCHAR2|地点||", length = 40, scale = 40, nullable = true)
	private String place;

	@Column(name = "CULEX_PI", columnDefinition = "NUMBER|淡色（致倦）库蚊||", length = 5, scale = 5, nullable = true)
	private Long culexPi;

	@Column(name = "CULEX_TR", columnDefinition = "NUMBER|三带喙库蚊||", length = 5, scale = 5, nullable = true)
	private Long culexTr;

	@Column(name = "AEDES_AL", columnDefinition = "NUMBER|白纹伊蚊||", length = 5, scale = 5, nullable = true)
	private Long aedesAl;

	@Column(name = "AEDES_AE", columnDefinition = "NUMBER|埃及伊蚊||", length = 5, scale = 5, nullable = true)
	private Long aedesAe;

	@Column(name = "AN_S", columnDefinition = "NUMBER|中华按蚊||", length = 5, scale = 5, nullable = true)
	private Long anS;

	@Column(name = "AN_A", columnDefinition = "NUMBER|嗜人按蚊||", length = 5, scale = 5, nullable = true)
	private Long anA;

	@Column(name = "AN_D", columnDefinition = "NUMBER|大劣按蚊||", length = 5, scale = 5, nullable = true)
	private Long anD;

	@Column(name = "AN_M", columnDefinition = "NUMBER|微小按蚊||", length = 5, scale = 5, nullable = true)
	private Long anM;

	@Column(name = "OTHER", columnDefinition = "NUMBER|其它||", length = 5, scale = 5, nullable = true)
	private Long other;

	@Column(name = "TOTAL", columnDefinition = "NUMBER|合计||", length = 5, scale = 5, nullable = true)
	private Long total;

	@Column(name = "REMARKS", columnDefinition = "VARCHAR2|备注||", length = 40, scale = 40, nullable = true)
	private String remarks;

	@Column(name = "SPECIES_CODE", columnDefinition = "VARCHAR2|蚊种代码||", length = 40, scale = 40, nullable = true)
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

	public String getPlace() {
		return this.place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public Long getCulexPi() {
		return this.culexPi;
	}

	public void setCulexPi(Long culexPi) {
		this.culexPi = culexPi;
	}

	public Long getCulexTr() {
		return this.culexTr;
	}

	public void setCulexTr(Long culexTr) {
		this.culexTr = culexTr;
	}

	public Long getAedesAl() {
		return this.aedesAl;
	}

	public void setAedesAl(Long aedesAl) {
		this.aedesAl = aedesAl;
	}

	public Long getAedesAe() {
		return this.aedesAe;
	}

	public void setAedesAe(Long aedesAe) {
		this.aedesAe = aedesAe;
	}

	public Long getAnS() {
		return this.anS;
	}

	public void setAnS(Long anS) {
		this.anS = anS;
	}

	public Long getAnA() {
		return this.anA;
	}

	public void setAnA(Long anA) {
		this.anA = anA;
	}

	public Long getAnD() {
		return this.anD;
	}

	public void setAnD(Long anD) {
		this.anD = anD;
	}

	public Long getAnM() {
		return this.anM;
	}

	public void setAnM(Long anM) {
		this.anM = anM;
	}

	public Long getOther() {
		return this.other;
	}

	public void setOther(Long other) {
		this.other = other;
	}

	public Long getTotal() {
		total=0L;
		if(culexPi!=null)
			total+=culexPi;
		if(culexTr!=null)
			total+=culexTr;
		if(aedesAl!=null)
			total+=aedesAl;
		if(aedesAe!=null)
			total+=aedesAe;
		if(anS!=null)
			total+=anS;
		if(anA!=null)
			total+=anA;
		if(anD!=null)
			total+=anD;
		if(anM!=null)
			total+=anM;
		if(other!=null)
			total+=other;
		return this.total;
	}

	public void setTotal(Long total) {
		this.total = total;
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
			StringBuilder sb = new StringBuilder("");
			if (culexPi != null && culexPi > 0) {
				sb.append("1,");
			}
			if (culexTr != null && culexTr > 0) {
				sb.append("2,");
			}
			if (aedesAl != null && aedesAl > 0) {
				sb.append("3,");
			}
			if (aedesAe != null && aedesAe > 0) {
				sb.append("4,");
			}
			if (anS != null && anS > 0) {
				sb.append("5,");
			}
			if (anA != null && anA > 0) {
				sb.append("6,");
			}
			if (anD != null && anD > 0) {
				sb.append("7,");
			}
			if (anM != null && anM > 0) {
				sb.append("8,");
			}
			if (other != null && other > 0) {
				sb.append("99,");
			}
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

}