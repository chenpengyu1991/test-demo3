package com.founder.rhip.im.entity.report;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * 报表列定义
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class UiColumn{
	//列显示名称
	@XmlElement(name = "headName")
	private String headName;
	//列样式
	@XmlElement(name = "headStyle")
	private String headStyle;
	//列数据源KEY
	@XmlElement(name = "dataKey")
	private String dataKey;
	//数据类型
	@XmlElement(name = "dataType")
	private String dataType;
	//数据单位
	@XmlElement(name = "dataUnit")
	private String dataUnit;
	//列显示在哪个分组，目前只支持2组
	@XmlElement(name = "tableIndex")
	private String tableIndex;
	//table个数
	@XmlElement(name = "tableCount")
	private String tableCount;
	//所在行
	@XmlElement(name = "rowNum")
	private Integer rowNum = 0;
	//colspan
	@XmlElement(name = "colspan")
	private Integer colspan;


	public UiColumn(){
		super();
	}

	public String getHeadName() {
		return headName;
	}

	public void setHeadName(String headName) {
		this.headName = headName;
	}

	public String getHeadStyle() {
		return headStyle;
	}

	public void setHeadStyle(String headStyle) {
		this.headStyle = headStyle;
	}

	public String getDataKey() {
		return dataKey;
	}

	public void setDataKey(String dataKey) {
		this.dataKey = dataKey;
	}

	public String getDataType() {
		return dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	public String getDataUnit() {
		return dataUnit;
	}

	public void setDataUnit(String dataUnit) {
		this.dataUnit = dataUnit;
	}

	public String getTableIndex() {
		return tableIndex;
	}

	public void setTableIndex(String tableIndex) {
		this.tableIndex = tableIndex;
	}

	public String getTableCount() {
		return tableCount;
	}

	public void setTableCount(String tableCount) {
		this.tableCount = tableCount;
	}

	public Integer getRowNum() {
		return rowNum;
	}

	public void setRowNum(Integer rowNum) {
		this.rowNum = rowNum;
	}

	public Integer getColspan() {
		return colspan;
	}

	public void setColspan(Integer colspan) {
		this.colspan = colspan;
	}
}
