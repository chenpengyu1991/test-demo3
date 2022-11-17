package com.founder.rhip.ehr.tld;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.JspWriter;

public class HospitalLevelTag extends BaseTag {

	private String organGrade;
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public int doStartTagInternal() throws JspTagException {
		String organLevel = "";
		switch(organGrade){
		case "10":
			organLevel = "一级";
			break;
		case "12":
			organLevel = "一级甲等";
			break;
		case "13":
			organLevel = "一级乙等";
			break;
		case "14":
			organLevel = "一级丙等";
			break;
		case "20":
			organLevel = "二级";
			break;
		case "22":
			organLevel = "二级甲等";
			break;
		case "23":
			organLevel = "二级乙等";
			break;
		case "24":
			organLevel = "二级丙等";
			break;
		case "30":
			organLevel = "三级";
			break;
		case "31":
			organLevel = "三级特等";
			break;
		case "32":
			organLevel = "三级甲等";
			break;
		case "33":
			organLevel = "三级乙等";
			break;
		case "34":
			organLevel = "三级丙等";
			break;
		case "99":
			organLevel = "不详";
			break;
		}
		JspWriter jw = pageContext.getOut();
		try {
			jw.write(organLevel);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return SKIP_BODY;
	}
	
	public int doEndTagInternal() throws JspException {
		return super.doEndTag();
	}

	public String getOrganGrade() {
		return organGrade;
	}

	public void setOrganGrade(String organGrade) {
		this.organGrade = organGrade;
	}

}
