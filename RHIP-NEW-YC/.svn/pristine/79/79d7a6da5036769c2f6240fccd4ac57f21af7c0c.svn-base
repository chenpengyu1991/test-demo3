package com.founder.rhip.ehr.service.export.impl;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
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
public class JsoupHtmlTableParser {

	private final static String THEAD = "thead";
	private final static String TBODY = "tbody";
	private final static String TFOOT = "tfoot";
	private final static String COLSPAN = "colspan";
	private final static String ROWSPAN = "rowspan";
	private final static String TR = "tr";

	public Report parse(String html) {
		Document doc;
		try {
			doc = Jsoup.parse(html);
		} catch (Exception e) {
			throw new RuntimeException("文档解析失败:" + html, e);
		}
		
		return parseReport(doc);
	}

	public String clean(String from) {
		String to = null;
		if (ObjectUtil.isNotEmpty(from)) {
			to = from.replaceAll("\t|\r|\n", "");
		}
		return to;
	}

	private int getColumns(Element rowElement) {
		Elements cellElements = rowElement.children();
		int colums = 0;
		for (int j = 0; j < cellElements.size(); j++) {
			Element cell = cellElements.get(j);
			String colspan = getAttribution(cell, COLSPAN);
			colums += parseSpan(colspan);
		}
		return colums;
	}

	private Report parseReport(Document xmlReport) {
		Report report = new Report();
		// header 部分必须存在
		Elements headerRowElements = xmlReport.getElementsByTag(THEAD).get(0).getElementsByTag(TR);
		Element firstHeadElement = headerRowElements.get(0);
		int colums = getColumns(firstHeadElement);
		int rows = headerRowElements.size();
		Unit[][] header = new Unit[rows][colums];
		buidlUnits(header, headerRowElements);
		report.setHeader(header);

		// body
		Elements bodyElements = xmlReport.getElementsByTag(TBODY);
		if (bodyElements.size() > 0) {
			Elements bodyRowElements = bodyElements.get(0).getElementsByTag(TR);
			rows = bodyRowElements.size();
			Unit[][] body = new Unit[rows][colums];
			buidlUnits(body, bodyRowElements);
			report.setBody(body);
		}

		Elements footElements = xmlReport.getElementsByTag(TFOOT);
		if (footElements.size() > 0) {
			Elements footerRowElements = footElements.get(0).getElementsByTag(TR);
			rows = footerRowElements.size();
			Unit[][] footer = new Unit[rows][colums];
			buidlUnits(footer, footerRowElements);
			report.setFooter(footer);
		}
		return report;
	}

	private void buidlUnits(Unit[][] units, Elements rowElements) {
		int rows = units.length;
		for (int i = 0; i < rows; i++) {
			Elements cells = rowElements.get(i).children();
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

	private Unit convertToUnit(Element cell) {
		// String dataFormatString = cell.getAttributeValue("data-type");
		String rowspan = getAttribution(cell, ROWSPAN);
		String colspan = getAttribution(cell, COLSPAN);
		String value = cell.text();
		Unit unit = new Unit();
		unit.setValue(value);
		unit.setRowspan(parseSpan(rowspan));
		unit.setColspan(parseSpan(colspan));
		return unit;
	}

	private String getAttribution(Element cell, String name) {
		return cell.attr(name);
	}

	/**
     * 不支持span为0的特殊情况,浏览器支持不同.必须正常指定
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
