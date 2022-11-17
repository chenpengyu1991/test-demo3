package com.founder.rhip.ehr.service.export.impl;

import java.io.IOException;
import java.io.OutputStream;

import nu.xom.ParsingException;
import nu.xom.ValidityException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.stereotype.Component;

import com.founder.rhip.ehr.service.export.ExcelRender;
import com.founder.rhip.ehr.service.export.Report;
import com.founder.rhip.ehr.service.export.Unit;

/**
 * xls 导出
 * 
 * @author liuk
 * 
 */
@Component("hssfExeclRender")
public class HssfExeclRender implements ExcelRender {

	public void doWork(Report report, OutputStream outputStream) throws ValidityException, ParsingException, IOException {
		// 创建工作表
		HSSFWorkbook donationWorkbook = new HSSFWorkbook();
		HSSFSheet donationSheet = donationWorkbook.createSheet();
		donationSheet.setDefaultColumnWidth(10);
		donationSheet.setDefaultRowHeight((short) (20 * 20));

		Font titleFont = ExcelUtil.createTitleFonts(donationWorkbook);
		CellStyle cellStyleTitle = ExcelUtil.createStyleCell(donationWorkbook);
		cellStyleTitle = ExcelUtil.setCellStyleAlignment(cellStyleTitle, CellStyle.ALIGN_CENTER, CellStyle.VERTICAL_CENTER);
		cellStyleTitle.setFont(titleFont);
		
		Font font = ExcelUtil.createFonts(donationWorkbook);
		CellStyle cellStyle = ExcelUtil.createStyleCell(donationWorkbook);
		cellStyle = ExcelUtil.setCellStyleAlignment(cellStyle, CellStyle.ALIGN_CENTER, CellStyle.VERTICAL_CENTER);
		cellStyle.setFont(font);
		Unit[][] header = report.getHeader();
		int row = 2;
		buildCells(row, donationSheet, cellStyle, header);

		Unit[][] body = report.getBody();
		if (null != body) {
			row += header.length;
			buildCells(row, donationSheet, cellStyle, body);
		}

		
		Unit[][] footer = report.getFooter();
		if (null != footer) {
			CellStyle left = ExcelUtil.createStyleCell(donationWorkbook);
			left = ExcelUtil.setCellStyleAlignment(left, CellStyle.ALIGN_LEFT, CellStyle.VERTICAL_CENTER);
			left.setFont(font);
			row += body.length;
			buildCells(row, donationSheet, left, footer);
		}

		HSSFRow donationRow = donationSheet.createRow(0);
		HSSFCell createdCell = donationRow.createCell(0);
		createdCell.setCellValue(report.getTitle());
		
		createdCell.setCellStyle(cellStyleTitle);
		
		CellRangeAddress cellRangeAddress = new CellRangeAddress(0, 1, 0, header[0].length - 1);
		donationSheet.addMergedRegion(cellRangeAddress);

		donationWorkbook.write(outputStream);
	}

	private void buildCells(int row, HSSFSheet donationSheet, CellStyle cellStyle, Unit[][] units) {
		for (int i = 0; i < units.length + 0; i++) {
			Unit[] rowUnits = units[i - 0];
			HSSFRow donationRow = donationSheet.createRow(i + row);
			for (int j = 0; j < rowUnits.length + 0; j++) {
				donationSheet.autoSizeColumn(j, true);
				Unit unit = rowUnits[j - 0];
				HSSFCell createdCell = donationRow.createCell(j);
				if (unit != null){
					if (unit.isUsed()){
						CellRangeAddress cellRangeAddress = new CellRangeAddress(i + row, i + row + unit.getRowspan() - 1, j, j + unit.getColspan() - 1);
						donationSheet.addMergedRegion(cellRangeAddress);
					}
					createdCell.setCellValue(unit.getValue());
				}
				createdCell.setCellStyle(cellStyle);
			}
		}
	}

	@Override
	public void execute(Report report, OutputStream outputStream) {
		try {
			doWork(report, outputStream);
		} catch (Exception e) {
			throw new RuntimeException("excel生成失败", e);
		}
	}
}
