
package com.founder.elb.entity;

import java.util.ArrayList;
import java.util.List;

public class AccessLevel {

	private Integer id;

	private String name;

	private String srcName;

	private Integer status;// 1表示可用 0 表示不可用

	public AccessLevel(Integer id, String name, String srcName, Integer status) {
		this.id = id;
		this.status = status;
		this.srcName = srcName;
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public static List<AccessLevel> getAccessLevel(int level) {
		List<AccessLevel> result = new ArrayList<AccessLevel>();
		if (level >= 1) {
			result.add(new AccessLevel(1, "系统访问控制", "sysContorl", 1));
		}
		if (level >= 2) {
			result.add(new AccessLevel(2, "菜单访问控制", "Menu", 1));
		}
		if (level >= 3) {
			result.add(new AccessLevel(3, "业务操作控制", "ActionControl", 1));
		}
		if (level >= 4) {
			result.add(new AccessLevel(4, "数据字段控制", "FieldControl", 1));
		}
		return result;
	}

	public String getSrcName() {
		return srcName;
	}

	public void setSrcName(String srcName) {
		this.srcName = srcName;
	}
}
