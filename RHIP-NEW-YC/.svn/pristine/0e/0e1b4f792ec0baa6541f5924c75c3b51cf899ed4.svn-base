package com.founder.rhip.ehr.service.export.impl;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.springframework.stereotype.Component;

import com.founder.fasf.util.StringUtil;
import com.founder.rhip.ehr.service.export.IListExcelRender;
import com.founder.rhip.ehr.service.export.ItemDefinition;

/**
 * 列表导出
 * @author liuk
 *
 */
@Component("listExcelRender")
public class ListExcelRender implements IListExcelRender {

	@Override
	public void execute(List<ItemDefinition> definitions, List<Map<String, Object>> dataSource, OutputStream outputStream) {
		try {
			run(definitions, dataSource, outputStream);
		} catch (Exception e) {
			throw new RuntimeException("excel生成失败", e);
		}
	}

	public void run(List<ItemDefinition> definitions, List<Map<String, Object>> dataSource, OutputStream outputStream) throws IOException {

		HSSFWorkbook donationWorkbook = new HSSFWorkbook();
		HSSFSheet donationSheet = donationWorkbook.createSheet();
		donationSheet.setDefaultColumnWidth(10);
		donationSheet.setDefaultRowHeight((short) (20 * 20));

		Font font = ExcelUtil.createFonts(donationWorkbook);
		CellStyle cellStyle = ExcelUtil.createStyleCell(donationWorkbook);
		cellStyle = ExcelUtil.setCellStyleAlignment(cellStyle, CellStyle.ALIGN_CENTER, CellStyle.VERTICAL_CENTER);
		cellStyle.setFont(font);

		HSSFRow donationNAmeRow = donationSheet.createRow(0);
		for (int j = 0; j < definitions.size(); j++) {
			donationSheet.autoSizeColumn(j, true);
			HSSFCell donationNAmeCell = donationNAmeRow.createCell(j);
			donationNAmeCell.setCellValue(definitions.get(j).getColumn());
			donationNAmeCell.setCellStyle(cellStyle);
		}

		for (int i = 0; i < dataSource.size(); i++) {
			Map<String, Object> map = dataSource.get(i);
			buildCells(donationWorkbook,i + 1, donationSheet, cellStyle, definitions, map);
		}

		// HSSFRow donationRow = donationSheet.createRow(0);
		// HSSFCell createdCell = donationRow.createCell(0);
		// createdCell.setCellValue("导出");
		// createdCell.setCellStyle(cellStyle);
		//
		// CellRangeAddress cellRangeAddress = new CellRangeAddress(0, 1, 0,
		// definitions.size() - 1);
		// donationSheet.addMergedRegion(cellRangeAddress);

		donationWorkbook.write(outputStream);
	}

	private void buildCells(HSSFWorkbook wb,int row, HSSFSheet donationSheet, CellStyle cellStyle, List<ItemDefinition> definitions, Map<String, Object> map) {
		HSSFRow donationRow = donationSheet.createRow(row);
		for (int j = 0; j < definitions.size(); j++) {
			ItemDefinition itemDefinition = definitions.get(j);
			// donationSheet.autoSizeColumn(j, true);
			HSSFCell createdCell = donationRow.createCell(j);
			String value = itemDefinition.getValueGetter().get(itemDefinition, map);
			String nullValue = itemDefinition.getNullValue();
			if (StringUtil.isNotEmpty(nullValue) && StringUtil.isNullOrEmpty(value)) {
				value = nullValue;
			}
			//日期格式 add by yjf
			if(itemDefinition.isDate()){
				HSSFDataFormat format= wb.createDataFormat();
				cellStyle.setDataFormat(format.getFormat(itemDefinition.getDatePattern()));
			}
			createdCell.setCellValue(value);
			createdCell.setCellStyle(cellStyle);

		}
	}

}
