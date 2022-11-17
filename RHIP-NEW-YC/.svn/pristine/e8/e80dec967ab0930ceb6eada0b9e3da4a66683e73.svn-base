package com.founder.rhip.ehr.service.export.impl;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;

import nu.xom.Attribute;
import nu.xom.Builder;
import nu.xom.Document;
import nu.xom.Element;
import nu.xom.Elements;
import nu.xom.ParsingException;
import nu.xom.ValidityException;

import org.springframework.stereotype.Component;

import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.service.export.Report;
import com.founder.rhip.ehr.service.export.Unit;

/**
 * 解析table
 * 
 * @author liuk
 * 
 */
@Component
@Deprecated
public class HtmlTableParser {

	public Report parse(File html) throws ValidityException, ParsingException, IOException {
		Builder parser = new Builder();
		Document xmlReport = parser.build(html);
		return parseReport(xmlReport);
	}

	public Report parse(String html) {

		Builder parser = new Builder();
		Document xmlReport;
		try {
			xmlReport = parser.build(new StringReader(clean(html)));
		} catch (ValidityException e) {
			throw new RuntimeException("格式错误", e);
		} catch (ParsingException e) {
			throw new RuntimeException("解释失败", e);
		} catch (Exception e) {
			throw new RuntimeException("复制失败", e);
		}
		return parseReport(xmlReport);
	}

	private String clean(String from) {
		String to = null;
		if (ObjectUtil.isNotEmpty(from)) {
			to = from.replaceAll("\t|\r|\n", "");
		}
		return to;
	}

	private int getColumns(Element rowElement) {
		Elements cellElements = rowElement.getChildElements();
		int colums = 0;
		for (int j = 0; j < cellElements.size(); j++) {
			Element cell = cellElements.get(j);
			String colspan = getAttribution(cell, "colspan");
			colums += parseSpan(colspan);
		}
		return colums;
	}

	private Report parseReport(Document xmlReport) {
		Elements headerRowElements = xmlReport.getRootElement().getChildElements("thead").get(0).getChildElements("tr");
		Elements bodyRowElements = xmlReport.getRootElement().getChildElements("tbody").get(0).getChildElements("tr");
		Elements footerRowElements = xmlReport.getRootElement().getChildElements("tfoot").get(0).getChildElements("tr");
		Element firstHeadElement = headerRowElements.get(0);
		int colums = getColumns(firstHeadElement);
		int rows = headerRowElements.size();
		Unit[][] header = new Unit[rows][colums];
		buidlUnits(header, headerRowElements);
		rows = bodyRowElements.size();
		Unit[][] body = new Unit[rows][colums];
		buidlUnits(body, bodyRowElements);
		rows = footerRowElements.size();
		Unit[][] footer = new Unit[rows][colums];
		buidlUnits(footer, footerRowElements);
		Report report = new Report();
		report.setBody(body);
		report.setHeader(header);
		report.setFooter(footer);
		return report;
	}

	private void buidlUnits(Unit[][] units, Elements rowElements) {
		int rows = units.length;
		for (int i = 0; i < rows; i++) {
			Elements cells = rowElements.get(i).getChildElements();
			int n = 0;
			for (int k = 0; k < cells.size(); k++) {
				Element cell = cells.get(k);
				while (units[i][n] != null) {
					n++;
				}
				Unit unit = convertToUnit(cell);
				for (int m = 0; m < unit.getRowspan(); m++) {
					for (int l = 0; l < unit.getColspan(); l++) {
						if (m == 0 && l == 0) {
							units[m + i][l + n] = unit;
							unit.setUsed(unit.getRowspan() > 1 || unit.getColspan() > 1);
						} else {
							units[m + i][l + n] = new Unit();
						}
					}
				}
			}
		}
	}

	@SuppressWarnings("unused")
	private Report doParse(Document xmlReport) {
		Unit[][] body;
		Elements rowElements = xmlReport.getRootElement().getChildElements("tbody").get(0).getChildElements("tr");
		Element firstHeadElement = rowElements.get(0);
		Elements cellElements = firstHeadElement.getChildElements();
		int colums = 0;
		int rows = rowElements.size();
		for (int j = 0; j < cellElements.size(); j++) {
			Element cell = cellElements.get(j);
			String colspan = cell.getAttributeValue("colspan");
			colums += parseSpan(colspan);
		}
		body = new Unit[rows][colums];

		for (int i = 0; i < rows; i++) {
			Elements cells = rowElements.get(i).getChildElements();
			int n = 0;
			for (int k = 0; k < cells.size(); k++) {
				Element cell = cells.get(k);
				while (body[i][n] != null) {
					n++;
				}
				Unit unit = convertToUnit(cell);
				for (int m = 0; m < unit.getRowspan(); m++) {
					for (int l = 0; l < unit.getColspan(); l++) {
						if (m == 0 && l == 0) {
							body[m + i][l + n] = unit;
							unit.setUsed(unit.getRowspan() > 1 || unit.getColspan() > 1);
						} else {
							body[m + i][l + n] = new Unit();
						}
					}
				}
			}
		}
		return null;
	}

	private Unit convertToUnit(Element cell) {
		// String dataFormatString = cell.getAttributeValue("data-type");
		String rowspan = getAttribution(cell, "rowspan");
		String colspan = getAttribution(cell, "colspan");
		String value = cell.getValue();
		Unit unit = new Unit();
		unit.setValue(value);
		unit.setRowspan(parseSpan(rowspan));
		unit.setColspan(parseSpan(colspan));
		return unit;
	}

	private String getAttribution(Element cell, String name) {
		int count = cell.getAttributeCount();
		if (count > 0) {
			for (int i = 0; i < count; i++) {
				Attribute attribute = cell.getAttribute(i);
				if (null != attribute && null != name) {
					if (name.toLowerCase().equals(attribute.getLocalName().toLowerCase())) {
						return attribute.getValue();
					}
				}
			}
		}
		return null;
	}

	/**
	 * 默认返回1
	 * 
	 * @param value
	 * @return
	 */
	private int parseSpan(String value) {
		if (null == value) {
			return 1;
		}
		if ("".equals(value.trim())) {
			return 1;
		}
		int val = Integer.parseInt(value);
		if (val > 1) {
			return val;
		} else {
			return 1;
		}

	}
}
