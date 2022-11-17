package com.founder.rhip.ehr.tld;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.JspWriter;

import org.springframework.beans.factory.annotation.Autowired;

import com.founder.fasf.beans.Criteria;
import com.founder.rhip.mdm.entity.Department;
import com.founder.rhip.mdm.service.IDepartmentService;

public class DepartmentTag extends BaseTag {

	private static final long serialVersionUID = -3398794341929409348L;

	@Autowired
	private IDepartmentService departmentService;

	private String organCode;

	private String deptCode;

	public int doStartTagInternal() throws JspTagException {
		String name = "";
		inject();
		Criteria criteria = new Criteria();
		criteria.add("organCode", organCode).add("deptCode", deptCode);
		Department dept = departmentService.getDepartment(criteria);
		if (dept == null) {
			name = deptCode;
		} else {
			name = dept.getDeptName();
		}
		JspWriter jw = pageContext.getOut();
		try {
			jw.write(name);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return SKIP_BODY;
	}

	public int doEndTagInternal() throws JspException {
		return super.doEndTag();
	}

	public String getOrganCode() {
		return organCode;
	}

	public void setOrganCode(String organCode) {
		this.organCode = organCode;
	}

	public String getDeptCode() {
		return deptCode;
	}

	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}
}
