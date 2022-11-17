package com.founder.rhip.im.entity.report;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * 报表定义
 * 
 * @author yejianfei
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "ReportDefine")
public class ReportDefine {
	//报表类型
	@XmlElement(name = "reportType")
	private String reportType;
	//报表名称
	@XmlElement(name = "reportName")
	private String reportName;
	//单元格合并
	@XmlElement(name = "cellMerge")
	private Boolean cellMerge = false;
	//报表SQL
	@XmlElement(name = "reportSql")
	private String reportSql;
	//报表列
	@XmlElement(name = "uiColumn")
	private List<UiColumn> uiColumns = new ArrayList<UiColumn>();

	public String getReportType() {
		return reportType;
	}

	public void setReportType(String reportType) {
		this.reportType = reportType;
	}

	public String getReportName() {
		return reportName;
	}

	public void setReportName(String reportName) {
		this.reportName = reportName;
	}

	public String getReportSql() {
		return reportSql;
	}

	public void setReportSql(String reportSql) {
		this.reportSql = reportSql;
	}

	public List<UiColumn> getUiColumns() {
		return uiColumns;
	}

	public void setUiColumns(List<UiColumn> uiColumns) {
		this.uiColumns = uiColumns;
	}

	public ReportDefine(){
		super();
	}

	public Boolean getCellMerge() {
		return cellMerge;
	}

	public void setCellMerge(Boolean cellMerge) {
		this.cellMerge = cellMerge;
	}

}
