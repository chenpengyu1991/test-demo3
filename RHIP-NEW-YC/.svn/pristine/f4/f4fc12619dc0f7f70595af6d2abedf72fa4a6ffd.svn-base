package com.founder.rhip.ehr.tld;

import java.io.IOException;
import java.util.List;

import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.JspWriter;

import org.springframework.beans.factory.annotation.Autowired;

import com.founder.rhip.ehr.dto.CurrentLoginInfo;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.mdm.entity.Organization;
import com.founder.rhip.mdm.entity.SchoolInfo;
import com.founder.rhip.mdm.service.ISchoolInfoService;

/**
 * 给出学校列表
 * @author chen weihua
 *
 */
public class SchoolListTag extends BaseTag {

	private static final long serialVersionUID = -7771532441918268451L;

	@Autowired
	private ISchoolInfoService schoolInfoService;
	
	private String type;

	public int doStartTagInternal() throws JspTagException {
		inject();
		String html = null;
		CurrentLoginInfo currentLoginInfo = (CurrentLoginInfo) pageContext.getSession().getAttribute("currentLoginInfo");
		Organization org = currentLoginInfo.getOrganization();
		Criteria criteria = new Criteria();
		if (!"46714114-9".equals(org.getOrganCode())) {
			criteria.add("examOrgan", org.getOrganCode());
		}
		if (StringUtil.isNotEmpty(type)) {
			String[] typeArray = type.split(",");
			criteria.add("type", OP.IN, typeArray);
		}
		List<SchoolInfo> list = schoolInfoService.getSchools(criteria);
		StringBuilder sb = new StringBuilder();
		if(ObjectUtil.isNotEmpty(list)) {
			for (SchoolInfo info : list) {
				getOption(info, sb);
			}
		}
		html = sb.toString();
		try {
			JspWriter jw = pageContext.getOut();
			jw.write(html);
		} catch (IOException e) {
		}
		return SKIP_BODY;
	}
	
	private void getOption(SchoolInfo info, StringBuilder sb) {
		sb.append("<option title=\"");
		sb.append( info.getName());
		sb.append("\" value=\"");
		sb.append(info.getSchoolCode());
		sb.append("\">");
		sb.append(info.getName());
		sb.append("</option>\r\n");
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
