package com.founder.rhip.hsa.controller.insp;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.LOP;
import com.founder.fasf.beans.OP;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;

/**
 * 
 * @author liuk
 * 
 */
public class ReportReocrdQueryForm implements Serializable {
	private static final long serialVersionUID = 1L;
	private Date startCreateDate;
	private Date endCreateDate;
	private String centerOrganCode;
	private String status;
	private String gbcode;
	private Date startDiscoveryDate;
	private Date endDiscoveryDate;
	private String infoContent;
	private String infoTypeCode;

	public Criteria toCriteria() {
		Criteria criteria = new Criteria();

		if (ObjectUtil.isNotEmpty(centerOrganCode)) {
			Criteria cr = new Criteria();
			cr.add("createCenterOrganCode", centerOrganCode);
			cr.add(LOP.OR, "createOrganCode", centerOrganCode);
			criteria.add(cr);
		} else if (ObjectUtil.isNotEmpty(gbcode)) {
			criteria.add("createGbcode", gbcode);
		}

		if (StringUtil.isNotEmpty(status)) {
			criteria.add("STATUS", status);
		}

		if (StringUtil.isNotEmpty(infoTypeCode)) {
			criteria.add("infoTypeCode", infoTypeCode);
		}

		if (StringUtil.isNotEmpty(infoContent)) {
			criteria.add("infoContent", OP.LIKE, infoContent);
		}

		if (null != startDiscoveryDate && null == endDiscoveryDate) {
			criteria.add("discoveryDate", OP.GE, DateUtil.makeTimeToZero(startDiscoveryDate));
		} else if (null == startDiscoveryDate && null != endDiscoveryDate) {
			criteria.add("discoveryDate", OP.LE, DateUtil.makeTimeToMax(endDiscoveryDate));
		} else if (null != startDiscoveryDate && null != endDiscoveryDate) {
			criteria.add("discoveryDate", OP.BETWEEN, new Date[] { DateUtil.makeTimeToZero(startDiscoveryDate), DateUtil.makeTimeToMax(endDiscoveryDate) });
		}

		if (null != startCreateDate && null == endCreateDate) {
			criteria.add("createDate", OP.GE, DateUtil.makeTimeToZero(startCreateDate));
		} else if (null == startCreateDate && null != endCreateDate) {
			criteria.add("createDate", OP.LE, DateUtil.makeTimeToMax(endCreateDate));
		} else if (null != startCreateDate && null != endCreateDate) {
			criteria.add("createDate", OP.BETWEEN, new Date[] { DateUtil.makeTimeToZero(startCreateDate), DateUtil.makeTimeToMax(endCreateDate) });
		}

		return criteria;
	}

	// 把字符串转为日期
	public static Date ConverToDate(String strDate) {
		Date date = null;
		DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
		try {
			date = df.parse(strDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	public Date getStartCreateDate() {
		return startCreateDate;
	}

	public void setStartCreateDate(Date startCreateDate) {
		this.startCreateDate = startCreateDate;
	}

	public Date getEndCreateDate() {
		return endCreateDate;
	}

	public void setEndCreateDate(Date endCreateDate) {
		this.endCreateDate = endCreateDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getStartDiscoveryDate() {
		return startDiscoveryDate;
	}

	public void setStartDiscoveryDate(Date startDiscoveryDate) {
		this.startDiscoveryDate = startDiscoveryDate;
	}

	public Date getEndDiscoveryDate() {
		return endDiscoveryDate;
	}

	public void setEndDiscoveryDate(Date endDiscoveryDate) {
		this.endDiscoveryDate = endDiscoveryDate;
	}

	public String getInfoContent() {
		return infoContent;
	}

	public void setInfoContent(String infoContent) {
		this.infoContent = infoContent;
	}

	public String getInfoTypeCode() {
		return infoTypeCode;
	}

	public void setInfoTypeCode(String infoTypeCode) {
		this.infoTypeCode = infoTypeCode;
	}

	public String getCenterOrganCode() {
		return centerOrganCode;
	}

	public void setCenterOrganCode(String centerOrganCode) {
		this.centerOrganCode = centerOrganCode;
	}

	public String getGbcode() {
		return gbcode;
	}

	public void setGbcode(String gbcode) {
		this.gbcode = gbcode;
	}

}
