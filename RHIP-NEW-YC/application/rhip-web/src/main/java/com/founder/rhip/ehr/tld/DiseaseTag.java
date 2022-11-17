package com.founder.rhip.ehr.tld;

import java.io.IOException;

import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.JspWriter;

import org.springframework.beans.factory.annotation.Autowired;

import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.mdm.app.IDiseaseApp;
import com.founder.rhip.mdm.entity.Disease;

/**
 * icd编码显示名称
 * 
 * @author liuk
 * 
 */
public final class DiseaseTag extends BaseTag {
	private static final long serialVersionUID = 6375236950704996479L;

	private String icd;

	@Autowired
	private IDiseaseApp diseaseApp;

	public int doStartTagInternal() throws JspTagException {
		if (ObjectUtil.isNullOrEmpty(icd)) {
			return SKIP_BODY;
		}
		String name = getName();
		try {
			JspWriter jw = pageContext.getOut();
			jw.write(name);
		} catch (IOException e) {
			throw new RuntimeException("疾病显示失败", e);
		}
		return SKIP_BODY;
	}

	private String getName() {
		String name = "";
		inject();
		Disease disease = diseaseApp.queryDisease(icd);
		if (null != disease) {
			name = disease.getDiseaseName();
		}
		return name;
	}

	public String getIcd() {
		return icd;
	}

	public void setIcd(String icd) {
		this.icd = icd;
	}

}
