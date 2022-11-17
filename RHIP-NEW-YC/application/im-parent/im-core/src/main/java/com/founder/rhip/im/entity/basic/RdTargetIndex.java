package com.founder.rhip.im.entity.basic;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="RD_TARGET_INDEX")
public class RdTargetIndex implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID",columnDefinition="NUMBER|业务主键|11|",length=11,nullable=false)
	private Long id;

	@Column(name="PARENT_ID",columnDefinition="NUMBER|父节点ID|11|",length=11,nullable=true)
	private Long parentId;

	@Column(name="DEPTH",columnDefinition="NUMBER|层次|11|",length=11,nullable=true)
	private Long depth;

	@Column(name="IS_PARENT",columnDefinition="NUMBER|父节点标志|11|",length=11,nullable=true)
	private Long isParent;

	@Column(name="CODE",columnDefinition="VARCHAR2|指标编码|60|",length=60,nullable=true)
	private String code;

	@Column(name="NAME_ZH",columnDefinition="VARCHAR2|中文名称|200|",length=200,nullable=true)
	private String nameZh;

	@Column(name="NAME_EN",columnDefinition="VARCHAR2|英文名称|200|",length=200,nullable=true)
	private String nameEn;

	@Column(name="UNIT",columnDefinition="VARCHAR2|指标单位|60|",length=60,nullable=true)
	private String unit;

	@Column(name="PATH",columnDefinition="VARCHAR2|路径|200|",length=200,nullable=true)
	private String path;

	@Column(name="SORT",columnDefinition="NUMBER|排序|11|",length=11,nullable=true)
	private Long sort;

	@Column(name="TARGET_CLASS",columnDefinition="VARCHAR2|图标|60|",length=60,nullable=true)
	private String targetClass;

	@Column(name="STATUS",columnDefinition="NUMBER|状态|1|",length=1,nullable=true)
	private Long status;

	@Column(name="TYPE",columnDefinition="VARCHAR2|指标类型（首页中划分为3个区块）|20|",length=20,nullable=true)
	private String type;

	@Column(name="CHART_TYPE",columnDefinition="VARCHAR2|图表类型（01：柱状图，02：饼状图，03：仪表盘，04：折线图|2|",length=2,nullable=true)
	private String chartType;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getParentId() {
		return this.parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public Long getDepth() {
		return this.depth;
	}

	public void setDepth(Long depth) {
		this.depth = depth;
	}

	public Long getIsParent() {
		return this.isParent;
	}

	public void setIsParent(Long isParent) {
		this.isParent = isParent;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getNameZh() {
		return this.nameZh;
	}

	public void setNameZh(String nameZh) {
		this.nameZh = nameZh;
	}

	public String getNameEn() {
		return this.nameEn;
	}

	public void setNameEn(String nameEn) {
		this.nameEn = nameEn;
	}

	public String getUnit() {
		return this.unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getPath() {
		return this.path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Long getSort() {
		return this.sort;
	}

	public void setSort(Long sort) {
		this.sort = sort;
	}

	public String getTargetClass() {
		return this.targetClass;
	}

	public void setTargetClass(String targetClass) {
		this.targetClass = targetClass;
	}

	public Long getStatus() {
		return this.status;
	}

	public void setStatus(Long status) {
		this.status = status;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getChartType() {
		return this.chartType;
	}

	public void setChartType(String chartType) {
		this.chartType = chartType;
	}

}