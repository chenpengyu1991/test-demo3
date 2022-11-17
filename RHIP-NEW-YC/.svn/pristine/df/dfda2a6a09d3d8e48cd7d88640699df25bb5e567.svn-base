package com.founder.rhip.ehr.service.export.impl;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.founder.fasf.beans.Page;
import com.founder.fasf.service.AbstractService;
import com.founder.fasf.util.Assert;
import com.founder.rhip.ehr.service.export.ExcelRender;
import com.founder.rhip.ehr.service.export.ExportConfig;
import com.founder.rhip.ehr.service.export.IDataSource;
import com.founder.rhip.ehr.service.export.IExcelExportService;
import com.founder.rhip.ehr.service.export.IListExcelRender;
import com.founder.rhip.ehr.service.export.IValueGetter;
import com.founder.rhip.ehr.service.export.ItemDefinition;
import com.founder.rhip.ehr.service.export.Report;

/**
 * excel导出
 * 
 * @author liuk
 * 
 */
@Service("excelExportService")
public class ExcelExportServiceImpl extends AbstractService implements IExcelExportService {
	@Autowired
	private JsoupHtmlTableParser htmlTableParser;

	@Resource(name = "hssfExeclRender")
	private ExcelRender execlRender;

	private AtomicInteger atomicInteger = new AtomicInteger(0);

	@Autowired
	private ItemDefinitionBuilder itemHelper;

	private IListExcelRender listExcelRender;

	@Autowired
	private Map<String, IListExcelRender> excelRenders;

	@PostConstruct
	public void init() {
		String name = ExportConfig.DEFAULT_LIST_EXCEL_RENDER;
		IListExcelRender listExcelRender = excelRenders.get(name);
		Assert.notNull(listExcelRender, "获取指定的excel生成器失败");
		this.listExcelRender = listExcelRender;
	}

	@Override
	public void exportExcel(String title, String html, OutputStream outputStream) {
		Report report = htmlTableParser.parse(html);
		report.setTitle(title);
		execlRender.execute(report, outputStream);
	}

	@Override
	public void exportListExecl(String title, Class<?> def, List<Map<String, Object>> dataSource, OutputStream outputStream) {
		this.exportListExecl(title, def, null, dataSource, outputStream);
	}

	@Override
	public void exportListExecl(String title, Class<?> def, Map<String, IValueGetter> customValue, List<Map<String, Object>> dataSource, OutputStream outputStream) {
		List<ItemDefinition> definitions = itemHelper.build(def, customValue);
		listExcelRender.execute(definitions, dataSource, outputStream);
	}

	@Override
	public void exportListExecl(String title, Class<?> def, HttpServletResponse response, IDataSource dataSourceCallback) {
		this.exportListExecl(title, def, null, response, dataSourceCallback);
	}

	// TODO 去掉HttpServletResponse依赖
	// TODO 提示信息不用Cookie
	// TODO 异步方式
	@Override
	public void exportListExecl(String title, Class<?> def, Map<String, IValueGetter> customValue, HttpServletResponse response, IDataSource dataSourceCallback) {
		int currentCount = atomicInteger.get();
		if (currentCount >= 10) {
			setCookie(response, ExportConfig.RESULT_COOKIE_RESPONSE_VALUE);
			return;
		}
        Path tempDic=null;
        try {
			atomicInteger.incrementAndGet();
			List<ItemDefinition> definitions = itemHelper.build(def, customValue);
			int current = 1;
			Page page = buildPage(current);
			// 第一次数据获取
			List<Map<String, Object>> dataSource = dataSourceCallback.get(page);
			
			OutputStream outputStream = getOutputStream(response);
			// 如果不止一页则分页导出并压缩为zip
			if (page.getTotalPages() > current) {
				tempDic = createTempDirectory();
				buildExcelTempFile(definitions, current, dataSource, tempDic);
				while (page.getTotalPages() > current) {
					page.next();
					current = page.getCurrentPage();
					dataSource = dataSourceCallback.get(page);
					buildExcelTempFile(definitions, current, dataSource, tempDic);
				}
				setDownLoadRespose(response, title.concat(".zip"));
				zipAndDownload(outputStream, tempDic);
			} else {
				setDownLoadRespose(response, title.concat(".xlsx"));
				exportListExecl(title, def,customValue, dataSource, outputStream);
			}
		} catch (Exception e) {
			throw new RuntimeException("生成excel失败", e);
		} finally {
            if(null!=tempDic){
                cleanTemp(tempDic);
            }
            atomicInteger.decrementAndGet();
		}
	}

	private Path createTempDirectory() {
		Path tempDic = null;
		try {
			tempDic = Files.createTempDirectory("exportExcel_");
		} catch (IOException e) {
			throw new RuntimeException("生成临时文件夹失败", e);
		}
		return tempDic;
	}

	private OutputStream getOutputStream(HttpServletResponse response) {
		OutputStream outputStream = null;
		try {
			outputStream = response.getOutputStream();
		} catch (IOException e) {
			throw new RuntimeException("获取输出流失败", e);
		}
		return outputStream;
	}

	private void buildExcelTempFile(List<ItemDefinition> definitions, int current, List<Map<String, Object>> dataSource, Path tempDic) {
		Path excel = tempDic.resolve(String.valueOf(current).concat(".xlsx"));
		try (OutputStream o1 = Files.newOutputStream(excel);) {
			listExcelRender.execute(definitions, dataSource, o1);
		} catch (Exception e) {
			throw new RuntimeException("写入到临时excel文件失败", e);
		}
	}

	private Page buildPage(int current) {
		// TODO pagesize配置不同调用可以不同
		Page page = new Page(ExportConfig.PAGE_SIZE, current);
		return page;
	}

	private void zipAndDownload(OutputStream outputStream, Path tempDic) {
		try (DirectoryStream<Path> ds = Files.newDirectoryStream(tempDic); ZipOutputStream zipout = new ZipOutputStream(outputStream);) {
			for (Path file : ds) {
				zipout.putNextEntry(new ZipEntry(file.getFileName().toString()));
				Files.copy(file, zipout);
				zipout.flush();
			}
		} catch (Exception e) {
			throw new RuntimeException("压缩写出失败", e);
		}
	}

	private void cleanTemp(Path tempDic) {
		try (DirectoryStream<Path> ds = Files.newDirectoryStream(tempDic)) {
			for (Path file : ds) {
				Files.delete(file);
			}
			Files.delete(tempDic);
		} catch (Exception e) {
			log.warn("清除文件失败", e);
		}
	}

	private void setDownLoadRespose(HttpServletResponse response, String fileName) {
		String name = fileName;
		try {
			// TODO UTF-8
			name = new String(fileName.getBytes("GBK"), "ISO8859_1");
		} catch (UnsupportedEncodingException e) {
			log.warn("下载名称设置失败", e);
		}
		response.setHeader("Content-Disposition", "attachment; filename=\"" + name + "\"");
		response.setContentType("application/octet-stream");
		setCookie(response, ExportConfig.RESULT_COOKIE_SUCCESS_VALUE);
	}

	private void setCookie(HttpServletResponse response, String value) {
		Cookie cookie = new Cookie(ExportConfig.RESULT_COOKIE_NAME, value);
		cookie.setPath("/");
		response.addCookie(cookie);
	}

}
