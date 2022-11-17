package com.founder.rhip.ehr.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.founder.fasf.util.ObjectUtil;

public class ExcelUtils {
	
	//private boolean isExcel2003 = true;
	
	private Workbook wb;
	
	private int totalRows;
	
	private Sheet sheet;
	
	private int currentRow;
	
	private File file;
	
	/**
	 * 加载excel流
	 * @param in
	 * @throws IOException
	 * @throws InvalidFormatException
	 */
	public ExcelUtils(InputStream in) throws IOException, InvalidFormatException {
        try {
        	wb =WorkbookFactory.create(in);
        } finally {
        	in.close();
        }
        changeSheet(0);
	}
	
	/**
	 * 加载excel文件
	 * @param filePath
	 * @throws IOException
	 * @throws InvalidFormatException 
	 */
	public ExcelUtils(String filePath) throws IOException, InvalidFormatException {
        /** 检查文件名是否为空或者是否是Excel格式的文件 */
        if (filePath == null || !filePath.matches("^.+\\.(?i)((xls)|(xlsx))$")) {
            return;
        }
        
        /** 对文件的合法性进行验证 */
        //if (filePath.matches("^.+\\.(?i)(xlsx)$")) {
        //    isExcel2003 = false;
        //}
        
        /** 检查文件是否存在 */
        file = new File(filePath);
        if (file == null || !file.exists()) {
            return;
        }
        
        InputStream in = new FileInputStream(file);
        try {
        	wb =WorkbookFactory.create(in);
        } finally {
        	in.close();
        }
        changeSheet(0);
	}
	
	/**
	 * 判断excel格式
	 * @return
	 */
	//public boolean isExcel2003() {
	//	return isExcel2003;
	//}
	
	/**
	 * 判断是否还有未读数据行
	 * @return
	 */
	public boolean hasNextLine() {
		return currentRow < totalRows;
	}
	
	/**
	 * 返回当前的sheet
	 * @return
	 */
	public Sheet getCurrentSheet() {
		return sheet;
	}
	
	/**
	 * 返回指定行对象
	 * @param rownum 行号，从0开始
	 * @return
	 */
	public Row getRow(int rownum) {
		return sheet.getRow(rownum);
	}
	
	/**
	 * 在指定位置创建行
	 * @param rownum 行号，从0开始
	 * @return
	 */
	public Row createRow(int rownum) {
		return sheet.createRow(rownum);
	}
	
	/**
	 * 改变sheet
	 * @param sheetIndex
	 * @return
	 */
	public Sheet changeSheet(int sheetIndex) {
		sheet = wb.getSheetAt(sheetIndex);
		totalRows = sheet.getPhysicalNumberOfRows();
		currentRow = 0;
		return sheet;
	}
	
	/**
	 * 改变sheet
	 * @param sheetName
	 * @return
	 */
	public Sheet changeSheet(String sheetName) {
		sheet = wb.getSheet(sheetName);
		totalRows = sheet.getPhysicalNumberOfRows();
		currentRow = 0;
		return sheet;
	}

	/**
	 * 读取一行数据
	 * @return
	 */
	public List<Object> readLine() {
		List<Object> values = readLine(currentRow);
		currentRow++;
		return values;
	}
	
	/**
	 * 读取指定sheet的一行数据
	 * @param rowIndex 行号从0开始
	 * @return
	 */
	public List<Object> readLine(int rowIndex) {
		List<Object> rows = new ArrayList<Object>();
		if (sheet == null) {
            return rows;
        }
		Row row = sheet.getRow(rowIndex);
		if (row == null) {
			return rows;
		}
		short minColIx = row.getFirstCellNum();
	    short maxColIx = row.getLastCellNum();
        for (short c = minColIx; c < maxColIx; c++) {
            Cell cell = row.getCell(c,Row.RETURN_BLANK_AS_NULL);
            rows.add(read(cell));
        }
		return rows;
	}
	
	/**
	 * 读取指定位置值
	 * @param columnRowNum 例如：B20或者C2
	 * @return
	 */
	public Object read(String columnRowNum) {
        int[] rowNumColumnNum = convertToRowNumColumnNum(columnRowNum);  
        int rowIndex = rowNumColumnNum[0];  
        int colIndex = rowNumColumnNum[1];
		return read(rowIndex, colIndex);
	}
	
	/**
	 * 读取指定位置值
	 * @param rowIndex
	 * @param colIndex
	 * @return
	 */
	public Object read(int rowIndex, int colIndex) {
		Row row = sheet.getRow(rowIndex);
		return read(row, colIndex);
	}
	
	/**
	 * 读取指定位置值
	 * @param row
	 * @param colIndex
	 * @return
	 */
	public Object read(Row row, int colIndex) {
		if (row == null) {
			return "";
		}
		Cell cell = row.getCell(colIndex);
		return read(cell);
	}
	
	/**
	 * 读取指定单元格值
	 * @param cell
	 * @return 单元格值
	 */
    public Object read(Cell cell) {
        if (cell == null) {
            return "";
        }
        if (Cell.CELL_TYPE_NUMERIC == cell.getCellType()) {
            if (DateUtil.isCellDateFormatted(cell)) {
                return cell.getDateCellValue();
            }
            return cell.getNumericCellValue();
        }
        if (Cell.CELL_TYPE_STRING == cell.getCellType()) {
        	return cell.getStringCellValue();
        }
        if (Cell.CELL_TYPE_BOOLEAN == cell.getCellType()) {
        	return cell.getBooleanCellValue();
        }
        return cell.toString();
    }
    
    /**
     * 新增一行数据
     * @param values
     */
    public void writeLine(List<Object> values) {
    	writeLine(values, totalRows);
    	totalRows++;
    }
    
    /**
     * 拷贝创建一行
     * @param values
     */
    public void writeLineWithFormat(List<Object> values) {
    	writeLineWithFormat(values, totalRows);
    	totalRows++;
    }
    
    /**
     * 拷贝创建一行
     * @param values
     * @param rowIndex
     */
    public void writeLineWithFormat(List<Object> values, int rowIndex) {
    	if (values == null || values.size() == 0) {
    		return;
    	}
    	//sheet.shiftRows(rowIndex, rowIndex + 1, 1);//是否需要新插入一行
        Row newRow = sheet.createRow(rowIndex);  
        Row oldRow = sheet.getRow(rowIndex - 1);  
        for (int index = 0; index < values.size(); index++) {  
            Cell oldCell = oldRow.getCell(index);  
            if (oldCell != null) {  
                CellStyle cellStyle = oldCell.getCellStyle();  
                write(newRow.createCell(index), cellStyle, values.get(index));
            }  
        } 
    }
    
    /**
     * 删除行
     *
     * @param startRow
     * @param endRow
     * @param n
     */
    public void shiftRows( int startRow, int endRow, int n ){
    	sheet.shiftRows(startRow,endRow,n);
    	totalRows = totalRows - (endRow-startRow + 1);
    }
    
    /**
     * 在指定行填写数据
     * @param values
     * @param rowIndex
     */
    public void writeLine(List<Object> values, int rowIndex) {
    	if (values == null || values.size() == 0) {
    		return;
    	}
    	Row row = sheet.createRow(rowIndex);
    	for (int index = 0; index < values.size(); index++) {
    		write(row, index, values.get(index));
    	}
    }
    
    /**
     * 在指定位置填写数据
     * @param columnRowNum 例如：B20或者C2
     * @param value
     */
    public void write(String columnRowNum, Object value) {
        int[] rowNumColumnNum = convertToRowNumColumnNum(columnRowNum);  
        int rowIndex = rowNumColumnNum[0];  
        int colIndex = rowNumColumnNum[1];
    	write(rowIndex, colIndex, value);
    }
    
    /**
     * 在指定位置填写数据
     * @param rowIndex
     * @param colIndex
     * @param value
     */
    public void write(int rowIndex, int colIndex, Object value) {
    	Row row = sheet.getRow(rowIndex);
    	write(row, colIndex, value);
    }
    
    /**
     * 在指定位置填写数据
     * @param row
     * @param colIndex
     * @param value
     */
    public void write(Row row, int colIndex, Object value) {
        if (row == null) {
        	return;
        }
        Cell cell = row.getCell(colIndex);
        if (cell == null) {
        	cell = row.createCell(colIndex);
        }
        write(cell, value);
    }
    
    /**
     * 在指定位置填写数据
     * @param cell
     * @param value
     */
    public void write(Cell cell, Object value) {
        if (cell == null) {
        	return;
        }
    	if (value instanceof Date) {
    		cell.setCellValue((Date)value);
    	} else if (value instanceof Calendar) {
    		cell.setCellValue((Calendar)value);
    	} else if (value instanceof Boolean) {
    		cell.setCellValue((Boolean)value);
    	} else if (value instanceof Double
    			|| value instanceof Float
    			|| value instanceof Integer
    			|| value instanceof Byte) {
    		cell.setCellValue(Double.valueOf(getStringValue(value)));
    	} else {
    		cell.setCellValue(getStringValue(value));
    	}
    }
    
    /**
     * 在指定位置填写数据
     * @param cell
     * @param style
     * @param value
     */
    public void write(Cell cell, CellStyle style, Object value) {
        if (cell == null) {
        	return;
        }
        if (style != null) {
        	cell.setCellStyle(style);
        }
        write(cell, value);
    }
    
    /**
     * 保存当前excel
     * @param out
     * @throws IOException
     */
    public void save(OutputStream out) throws IOException {
    	wb.write(out);
    }
    
    /**
     * 保存当前excel
     * @param filePath
     * @throws IOException
     */
    public void save(String filePath) throws IOException {
    	OutputStream out = new FileOutputStream(filePath);
    	try {
    		save(out);
    	} finally {
    		out.close();
    	}
    }
    
    /**
     * 保存当前excel
     * @throws IOException
     */
    public void save() throws IOException {
    	if (file == null) {
    		return;
    	}
    	OutputStream out = new FileOutputStream(file);
    	try {
    		save(out);
    	} finally {
    		out.close();
    	}
    }
    
    /**
     * 判断是否是空行
     * @param line
     * @return
     */
    public static boolean isEmptyLine(List<Object> line) {
    	if (line == null || line.size() == 0) {
    		return true;
    	}
    	for (Object val : line) {
    		if (ObjectUtil.isNotEmpty(val)) {
    			return false;
    		}
    	}
    	return true;
    }
    
    /**
     * 取得字符串值
     * @param value
     * @return
     */
    public static String getStringValue(Object value) {
    	if (ObjectUtil.isNullOrEmpty(value)) {  
            return "";
        } else if (value instanceof String) {
        	return ((String)value).replace("　", " ").replace(" ", " ").trim();
        } else if (value instanceof Double) {
        	return getRightStr((Double)value);
        } else { 
            return value.toString().replace("　", " ").replace(" ", " ").trim();
        }
    }
    
    public static String getStringValue(List<Object> line , int index) {
    	return getStringValue(getValue(line, index));
    }
    
    public static Object getValue(List<Object> line , int index) {
    	if (line == null || line.isEmpty()) {
    		return null;
    	}
    	int size = line.size();
    	if (index >= size) {
    		return null;
    	}
    	return line.get(index);
    }
    
    public static Date getDateValue(List<Object> line , int index, String format) {
    	return getDateValue(getValue(line, index), format);
    }
    
    public static Date getDateValue(Object value, String format) {
    	if (ObjectUtil.isNullOrEmpty(value)) {  
            return null;
        } else if (value instanceof Date) {
        	return (Date)value;
        } else { 
            return com.founder.fasf.util.DateUtil.parseSimpleDate(getStringValue(value), format);
        }
    }
    
    /**
     * 取得整数值
     * @param value
     * @return
     */
    public static Integer getIntegerValue(Object value) {
    	if (ObjectUtil.isNullOrEmpty(value)) {  
            return null;  
        } else if (value instanceof Double) {  
            return ((Double)value).intValue();  
        } else {
        	return Integer.parseInt(getStringValue(value));
        }
    }
    
    public static Integer getIntegerValue(List<Object> line , int index) {
    	return getIntegerValue(getValue(line, index));
    }
    
    /**
     * 取得浮点数值
     * @param value
     * @return
     */
    public static Double getDoubleValue(Object value) {
    	if (ObjectUtil.isNullOrEmpty(value)) {  
            return null;  
        } else if (value instanceof Double) {  
            return (Double)value;  
        } else {
        	return Double.parseDouble(getStringValue(value));
        }
    }
    
    public static Double getDoubleValue(List<Object> line , int index) {
    	return getDoubleValue(getValue(line, index));
    }
    
    /** 
     * 将单元格的行列位置转换为行号和列号 
     * @param columnRowNum 行列位置 
     * @return 长度为2的数组，第1位为行号，第2位为列号 
     */  
    private int[] convertToRowNumColumnNum(String columnRowNum) {  
        columnRowNum = columnRowNum.toUpperCase();  
        char[] chars = columnRowNum.toCharArray();  
        int rowNum = 0;  
        int columnNum = 0;  
        for (char c : chars) {  
            if ((c >= 'A' && c <= 'Z')) {  
                columnNum = columnNum * 26 + ((int) c - 64);  
            } else {  
                rowNum = rowNum * 10 + new Integer(c + "");  
            }  
        }  
        return new int[] { rowNum - 1, columnNum - 1 };  
    }
    
    /**
     * 正确地处理整数后自动加零的情况
     * @param sNum
     * @return
     */
    private static String getRightStr(double sNum) {
        String resultStr = String.format("%.5f", sNum);
        if (resultStr.matches("^[-+]?\\d+\\.[0]+$")) {
            resultStr = resultStr.substring(0, resultStr.indexOf("."));
        }
        return resultStr;
    }
    
}
