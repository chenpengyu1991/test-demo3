package com.founder.rhip.ehr.service.export;

import java.util.Map;

/**
 * 列表导出单元格定义
 * @author liuk
 *
 */
public class ItemDefinition {

	private boolean isDic;
	private boolean isMultiple;
	private boolean isNumber;
	private boolean isDate;
	private boolean isOrganization;
	private boolean isUser;
	private boolean isStaff;
	//顺序
	private int index;
	//key
	private String code;
	private String separator = ",";
	private String column;
	private String dicType;

	public String datePattern;
	public String numberPattern;
	//自定义字典
	private Map<String, String> dicMap;
	//空值
	private String nullValue;

	private IValueGetter valueGetter;

	public String getColumn() {
		return column;
	}

	public void setColumn(String column) {
		this.column = column;
	}

	public boolean isDic() {
		return isDic;
	}

	public void setDic(boolean isDic) {
		this.isDic = isDic;
	}

	public String getDicType() {
		return dicType;
	}

	public void setDicType(String dicType) {
		this.dicType = dicType;
	}

	public boolean isMultiple() {
		return isMultiple;
	}

	public void setMultiple(boolean isMultiple) {
		this.isMultiple = isMultiple;
	}

	public String getSeparator() {
		return separator;
	}

	public void setSeparator(String separator) {
		this.separator = separator;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public boolean isNumber() {
		return isNumber;
	}

	public void setNumber(boolean isNumber) {
		this.isNumber = isNumber;
	}

	public boolean isDate() {
		return isDate;
	}

	public void setDate(boolean isDate) {
		this.isDate = isDate;
	}

	public IValueGetter getValueGetter() {
		return valueGetter;
	}

	public void setValueGetter(IValueGetter valueGetter) {
		this.valueGetter = valueGetter;
	}

	public String getDatePattern() {
		return datePattern;
	}

	public void setDatePattern(String datePattern) {
		this.datePattern = datePattern;
	}

	public String getNumberPattern() {
		return numberPattern;
	}

	public void setNumberPattern(String numberPattern) {
		this.numberPattern = numberPattern;
	}

	public boolean isOrganization() {
		return isOrganization;
	}

	public void setOrganization(boolean isOrganization) {
		this.isOrganization = isOrganization;
	}

	public boolean isUser() {
		return isUser;
	}

	public void setUser(boolean isUser) {
		this.isUser = isUser;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public boolean isStaff() {
		return isStaff;
	}

	public void setStaff(boolean isStaff) {
		this.isStaff = isStaff;
	}

	public Map<String, String> getDicMap() {
		return dicMap;
	}

	public void setDicMap(Map<String, String> dicMap) {
		this.dicMap = dicMap;
	}

	public String getNullValue() {
		return nullValue;
	}

	public void setNullValue(String nullValue) {
		this.nullValue = nullValue;
	}
}
