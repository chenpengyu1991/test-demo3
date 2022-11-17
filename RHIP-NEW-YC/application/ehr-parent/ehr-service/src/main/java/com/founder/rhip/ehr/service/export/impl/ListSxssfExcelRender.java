package com.founder.rhip.ehr.service.export.impl;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.springframework.stereotype.Component;

import com.founder.fasf.util.StringUtil;
import com.founder.rhip.ehr.service.export.ExportConfig;
import com.founder.rhip.ehr.service.export.IListExcelRender;
import com.founder.rhip.ehr.service.export.ItemDefinition;

/**
 * 导出excel,支持大量数据,仅支持xlsx
 * @author liuk
 *
 */
@Component("listSxssfExcelRender")
public class ListSxssfExcelRender implements IListExcelRender {

	@Override
	public void execute(List<ItemDefinition> definitions, List<Map<String, Object>> dataSource, OutputStream outputStream) {
		try {
			run(definitions, dataSource, outputStream);
		} catch (Exception e) {
			throw new RuntimeException("excel生成失败", e);
		}
	}

	public void run(List<ItemDefinition> definitions, List<Map<String, Object>> dataSource, OutputStream outputStream) throws IOException {
		SXSSFWorkbook donationWorkbook = new SXSSFWorkbook(ExportConfig.ROW_ACCESS_WINDOW_SIZE);
		Sheet donationSheet = donationWorkbook.createSheet();
		// donationSheet.setDefaultColumnWidth(10);
		// donationSheet.setDefaultRowHeight((short) (20 * 20));
		CellStyle cellStyle = ExcelUtil.createStyleCell(donationWorkbook);
		Row donationNAmeRow = donationSheet.createRow(0);
		for (int j = 0; j < definitions.size(); j++) {
			donationSheet.autoSizeColumn(j, true);
			Cell donationNAmeCell = donationNAmeRow.createCell(j);
			donationNAmeCell.setCellValue(definitions.get(j).getColumn());
		}

		for (int i = 0; i < dataSource.size(); i++) {
			Map<String, Object> map = dataSource.get(i);
			buildCells(donationWorkbook,i + 1, donationSheet,cellStyle,definitions, map);
		}

		donationWorkbook.write(outputStream);
	}

	private void buildCells(SXSSFWorkbook wb,int row, Sheet donationSheet, CellStyle cellStyle, List<ItemDefinition> definitions, Map<String, Object> map) {
		Row donationRow = donationSheet.createRow(row);
		for (int j = 0; j < definitions.size(); j++) {
			ItemDefinition itemDefinition = definitions.get(j);
			Cell createdCell = donationRow.createCell(j);
			String value = itemDefinition.getValueGetter().get(itemDefinition, map);
			String nullValue = itemDefinition.getNullValue();
			if (StringUtil.isNotEmpty(nullValue) && StringUtil.isNullOrEmpty(value)) {
				value = nullValue;
			}
			//日期格式 add by yjf
			if(itemDefinition.isDate()){
				//内嵌格式：HSSFDataFormat.getBuiltinFormat("m/d/yy h:mm")
				//自定义格式：
				DataFormat format = wb.createDataFormat(); 
				cellStyle.setDataFormat(format.getFormat(itemDefinition.getDatePattern()));
			}
			createdCell.setCellValue(value);
			createdCell.setCellStyle(cellStyle);
		}
	}

}
