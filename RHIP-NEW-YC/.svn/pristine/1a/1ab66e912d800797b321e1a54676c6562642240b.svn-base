package com.founder.rhip.im.monitor.form;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.util.DateUtil;

import java.util.Date;

/**
 * 硬件監控查询表单
 * @author Jin jicheng
 */
public class MachineMonitorQueryForm {
    private String ipAddress;
	private String createTimeBegin;
	private String createTimeEnd;

    public Criteria getCriteria() {
		Criteria criteria = new Criteria();
		getDateCriteria(criteria);
		return criteria;
	}

    private Criteria getDateCriteria(Criteria criteria){
        if (null != ipAddress && ipAddress != ""){
            criteria.add("ipAddress", OP.LIKE, ipAddress);
        }

		/*監控日期*/
		Date createDateBegin = DateUtil.parseDateString(this.createTimeBegin);
		Date createDateEnd = DateUtil.parseDateString(this.createTimeEnd);
		DateUtil.getCriteriaByDateRange(criteria, "createTime", createDateBegin, createDateEnd);
		return criteria;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public String getCreateTimeBegin() {
		return createTimeBegin;
	}

	public void setCreateTimeBegin(String createTimeBegin) {
		this.createTimeBegin = createTimeBegin;
	}

	public String getCreateTimeEnd() {
		return createTimeEnd;
	}

	public void setCreateTimeEnd(String createTimeEnd) {
		this.createTimeEnd = createTimeEnd;
	}

    
    
}
