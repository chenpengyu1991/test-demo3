package com.founder.elb.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MDM_MENU")
public class Menu implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|菜单标识|11|", length = 11, nullable = false)
	private Integer id;

	@Column(name = "PARENT_CODE", columnDefinition = "NUMBER|父节点标识|11|", length = 11, nullable = false)
	private Integer parentCode;

	@Column(name = "DEPTH", columnDefinition = "NUMBER|层次|11|", length = 11, nullable = false)
	private Integer depth;

	@Column(name = "IS_PARENT", columnDefinition = "NUMBER|父节点标志|11|", length = 11, nullable = false)
	private Integer isParent;

	@Column(name = "CODE", columnDefinition = "VARCHAR2|编码|20|", length = 20, nullable = true)
	private String code;

	@Column(name = "NAME_ZH", columnDefinition = "VARCHAR2|中文标题|100|", length = 100, nullable = false)
	private String nameZh;

	@Column(name = "NAME_EN", columnDefinition = "VARCHAR2|英文标题|100|", length = 100, nullable = true)
	private String nameEn;

	@Column(name = "PATH", columnDefinition = "VARCHAR2|路径|200|", length = 200, nullable = true)
	private String path;

	@Column(name = "THEME", columnDefinition = "VARCHAR2|主题|50|", length = 50, nullable = true)
	private String theme;

	@Column(name = "STATUS", columnDefinition = "NUMBER|状态|1|", length = 1, nullable = false)
	private Integer status;

	@Column(name = "FLAG", columnDefinition = "NUMBER|权限控制标志|1|", length = 1, nullable = false)
	private Integer flag;
	
	@Column(name = "MENU_NO", columnDefinition = "NUMBER|菜单排序|1|", length = 11, nullable = false)
	private Integer menuNo;

	@Column(name = "MENU_CLASS", columnDefinition = "VARCHAR2|菜单样式|100|", length = 100, nullable = true)
	private String menuClass;

	public Integer getId() {
		return this.id;
	}

	public Integer getMenuNo() {
		return menuNo;
	}

	public void setMenuNo(Integer menuNo) {
		this.menuNo = menuNo;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getParentCode() {
		return parentCode;
	}

	public void setParentCode(Integer parentCode) {
		this.parentCode = parentCode;
	}

	public Integer getDepth() {
		return this.depth;
	}

	public void setDepth(Integer depth) {
		this.depth = depth;
	}

	public Integer getIsParent() {
		return this.isParent;
	}

	public void setIsParent(Integer isParent) {
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

	public String getPath() {
		return this.path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getTheme() {
		return this.theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getFlag() {
		return this.flag;
	}

	public void setFlag(Integer flag) {
		this.flag = flag;
	}

	public String getMenuClass() {
		return menuClass;
	}

	public void setMenuClass(String menuClass) {
		this.menuClass = menuClass;
	}
}