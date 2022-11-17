package com.founder.rhip.ep.controller.form;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;

import java.util.Date;

public class WaterIodineQueryForm {
	
	private Date beginDate;
	
	private Date endDate;
	
	private String monitorId;
	
	private String gbCode;
	
	private String factoryName;
	
	private String factoryType;

    private String monitorType;

	public Date getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getMonitorId() {
		return monitorId;
	}

	public void setMonitorId(String monitorId) {
		this.monitorId = monitorId;
	}

	public String getGbCode() {
		return gbCode;
	}

	public void setGbCode(String gbCode) {
		this.gbCode = gbCode;
	}

	public String getFactoryName() {
		return factoryName;
	}

	public void setFactoryName(String factoryName) {
		this.factoryName = factoryName;
	}

	public String getFactoryType() {
		return factoryType;
	}

	public void setFactoryType(String factoryType) {
		this.factoryType = factoryType;
	}

    public String getMonitorType() {
        return monitorType;
    }

    public void setMonitorType(String monitorType) {
        this.monitorType = monitorType;
    }

    public Criteria toCriteria() {
		Criteria criteria = new Criteria();
		if (StringUtil.isNotEmpty(monitorId)) {
			criteria.add("monitorId", OP.LIKE, monitorId);
		}
		if (StringUtil.isNotEmpty(factoryName)) {
			criteria.add("factoryName", OP.LIKE, factoryName);
		}
		if (StringUtil.isNotEmpty(gbCode)) {
			criteria.add("gbCode", gbCode);
		}
		if (StringUtil.isNotEmpty(factoryType)) {
			criteria.add("factoryType", factoryType);
		}
        if (StringUtil.isNotEmpty(monitorType)) {
            criteria.add("monitorType", monitorType);
        }
		if (ObjectUtil.isNotEmpty(beginDate)) {
			if (ObjectUtil.isNotEmpty(endDate)) {
				criteria.add("investigateTime", OP.BETWEEN, new Date[]{beginDate, endDate});
			} else {
				criteria.add("investigateTime", OP.GE, beginDate);
			}
		}else if (ObjectUtil.isNotEmpty(endDate)) {
			criteria.add("investigateTime", OP.LE, endDate);
		}
		return criteria;
	}
	
}
