package com.founder.rhip.ehr.service.export;

import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

public interface IExcelExportService {
	void exportExcel(String title, String html, OutputStream outputStream);

	void exportListExecl(String title, Class<?> def, List<Map<String, Object>> dataSource, OutputStream outputStream);

	void exportListExecl(String title, Class<?> def, Map<String, IValueGetter> customValue, List<Map<String, Object>> dataSource, OutputStream outputStream);

	void exportListExecl(String title, Class<?> def, Map<String, IValueGetter> customValue, HttpServletResponse response, IDataSource dataSourceCallback);

	void exportListExecl(String title, Class<?> def, HttpServletResponse response, IDataSource dataSourceCallback);
}
