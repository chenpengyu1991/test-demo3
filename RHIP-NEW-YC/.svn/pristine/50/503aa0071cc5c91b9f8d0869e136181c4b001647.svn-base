package com.founder.rhip.ehr.tld;

import java.io.IOException;

import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.JspWriter;

import com.founder.fasf.util.ObjectUtil;

/**
 * 显示图片的TAG
 * @author LJY
 *
 */
public class ImageShowTag extends BaseTag {

	private static final long serialVersionUID = -2965834693493677396L;
	
	private String imgUrl;
	private String title;
	private String width;
	private String height;
	
	public int doStartTagInternal() throws JspTagException {
		if (imgUrl.indexOf("\\") > 0) {
			imgUrl = imgUrl.replace("\\","/");
		}
		StringBuilder sb = new StringBuilder();
		sb.append("<a href=\"javascript:void(0);\" onclick=\"util.showDialog('");
		sb.append(imgUrl);
		sb.append("','" + title + "'");
		
		if(ObjectUtil.isNotEmpty(width)){
			sb.append("," + width);
		}
		if(ObjectUtil.isNotEmpty(height)){
			sb.append("," + height);
		}
		sb.append(");\">");
		sb.append(title);
		sb.append("</a>");
		try {
			JspWriter jw = pageContext.getOut();
			jw.write(sb.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return SKIP_BODY;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWidth() {
		return width;
	}

	public void setWidth(String width) {
		this.width = width;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}
}
