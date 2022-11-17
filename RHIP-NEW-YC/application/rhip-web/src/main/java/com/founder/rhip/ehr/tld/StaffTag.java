package com.founder.rhip.ehr.tld;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.mdm.app.CheckException;
import com.founder.rhip.mdm.app.IStaffApp;
import com.founder.rhip.mdm.entity.Staff;
import com.founder.rhip.mdm.service.IStaffService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.JspWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 给出机构code值显示其机构名称
 * @author Jiang Haiying
 *
 */
public class StaffTag extends BaseTag {

	private static final long serialVersionUID = -7173108652475404757L;

	@Autowired
	private IStaffApp staffApp;

	@Autowired
	private IStaffService mdmStaffService;

	private String staffCode = null;//医务人员id
	private String userCode = null;//用户编码

	public int doStartTagInternal() throws JspTagException {
		inject();
		String name = "";

		name = this.getName(staffCode, userCode);

		try {
			JspWriter jw = pageContext.getOut();
			jw.write(name);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return SKIP_BODY;
	}

	private String getName(String staffCode, String userCode){
		String name = "";
		List<Staff> staffs = new ArrayList<Staff>();
		try {
			if(ObjectUtil.isNotEmpty(staffCode) && ObjectUtil.isNotEmpty(userCode)) {
				String []dd = staffCode.split(",");
				String []tt = userCode.split(",");

				staffs = mdmStaffService.getStaffsByUserCode(staffCode.split(","), userCode.split(","));
			} else if(ObjectUtil.isNotEmpty(staffCode)) {
				String[] staffCodes = staffCode.split(",");
				staffs = staffApp.queryStaff(new Criteria("staffCode", OP.IN, staffCodes));
			} else if(ObjectUtil.isNotEmpty(userCode)) {
				staffs = mdmStaffService.getStaffsByUserCode(null, userCode.split(","));
			} else {
				return name;
			}

		} catch (CheckException e) {
			e.printStackTrace();
		} catch (Exception e) {
			throw new RuntimeException("医务人员标签", e);
			//e.printStackTrace();
		}
		if(ObjectUtil.isNotEmpty(staffs)) {
			for (Staff staff : staffs) {
				if (name == "") {
					name = staff.getName();
				} else {
					name = name + "," + staff.getName();
				}
			}
		}
		return name;
	}
	public int doEndTagInternal() throws JspException {
		return super.doEndTag();
	}

	public String getStaffCode() {
		return staffCode;
	}

	public void setStaffCode(String staffCode) {
		this.staffCode = staffCode;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
}
