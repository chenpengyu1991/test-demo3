package com.founder.rhip.ehr.entity.control.oh;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "OH_MACHINE_ROOM")
public class OhMachineRoom implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|数据库唯一编号（自增长）|11|", length = 11, nullable = false)
	private Long id;

	@Column(name = "HOSPITAL_ID", columnDefinition = "NUMBER|医院ID|11|", length = 11, nullable = true)
	private Long hospitalId;

	@Column(name = "TYPE", columnDefinition = "VARCHAR2|类别|2|", length = 2, nullable = true)
	private String type;

	@Column(name = "NAME", columnDefinition = "VARCHAR2|机房/场所名称|50|", length = 50, nullable = true)
	private String name;

	@Column(name = "LENGTH", columnDefinition = "NUMBER|长||", scale = 11,precision = 2, nullable = true)
	private BigDecimal length;

	@Column(name = "WIDTH", columnDefinition = "NUMBER|宽||",  scale = 11,precision = 2, nullable = true)
	private BigDecimal width;

	@Column(name = "HEIGHT", columnDefinition = "NUMBER|高||", scale = 11,precision = 2, nullable = true)
	private BigDecimal height;

	@Column(name = "AREA", columnDefinition = "NUMBER|面积||",  scale = 11,precision = 2, nullable = true)
	private BigDecimal area;

	@Column(name = "AROUND_WALL", columnDefinition = "VARCHAR2|四周墙体|50|", length = 50, nullable = true)
	private String aroundWall;

	@Column(name = "ROOF", columnDefinition = "VARCHAR2|机房顶|50|", length = 50, nullable = true)
	private String roof;

	@Column(name = "GATE", columnDefinition = "VARCHAR2|防护大门|50|", length = 50, nullable = true)
	private String gate;

	@Column(name = "WICKET", columnDefinition = "VARCHAR2|防护小门|50|", length = 50, nullable = true)
	private String wicket;

	@Column(name = "WINDOWS", columnDefinition = "VARCHAR2|窗户|50|", length = 50, nullable = true)
	private String windows;

	@Column(name = "GROUND", columnDefinition = "VARCHAR2|机房地面|50|", length = 50, nullable = true)
	private String ground;

	@Column(name = "LEAD_GLASS", columnDefinition = "VARCHAR2|防护铅玻璃|50|", length = 50, nullable = true)
	private String leadGlass;

	@Column(name = "CREATE_TIME", columnDefinition = "DATE|创建时间||", nullable = true)
	private Date createTime;

	@Column(name = "CREATE_BY", columnDefinition = "VARCHAR2|创建者|50|", length = 50, nullable = true)
	private String createBy;

	@Column(name = "UPDATE_TIME", columnDefinition = "DATE|更新时间||", nullable = true)
	private Date updateTime;

	@Column(name = "UPDATE_BY", columnDefinition = "VARCHAR2|更新者|50|", length = 50, nullable = true)
	private String updateBy;

	@Column(name = "IS_DELETE", columnDefinition = "INT|删除状态||", nullable = true)
	private Integer isDelete;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getHospitalId() {
		return this.hospitalId;
	}

	public void setHospitalId(Long hospitalId) {
		this.hospitalId = hospitalId;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getLength() {
		return length;
	}

	public void setLength(BigDecimal length) {
		this.length = length;
	}

	public BigDecimal getWidth() {
		return width;
	}

	public void setWidth(BigDecimal width) {
		this.width = width;
	}

	public BigDecimal getHeight() {
		return height;
	}

	public void setHeight(BigDecimal height) {
		this.height = height;
	}

	public BigDecimal getArea() {
		return area;
	}

	public void setArea(BigDecimal area) {
		this.area = area;
	}

	public String getAroundWall() {
		return this.aroundWall;
	}

	public void setAroundWall(String aroundWall) {
		this.aroundWall = aroundWall;
	}

	public String getRoof() {
		return this.roof;
	}

	public void setRoof(String roof) {
		this.roof = roof;
	}

	public String getGate() {
		return this.gate;
	}

	public void setGate(String gate) {
		this.gate = gate;
	}

	public String getWicket() {
		return this.wicket;
	}

	public void setWicket(String wicket) {
		this.wicket = wicket;
	}

	public String getWindows() {
		return this.windows;
	}

	public void setWindows(String windows) {
		this.windows = windows;
	}

	public String getGround() {
		return this.ground;
	}

	public void setGround(String ground) {
		this.ground = ground;
	}

	public String getLeadGlass() {
		return this.leadGlass;
	}

	public void setLeadGlass(String leadGlass) {
		this.leadGlass = leadGlass;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getUpdateBy() {
		return updateBy;
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