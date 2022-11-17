package com.founder.rhip.export.controller;

import java.io.OutputStream;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.founder.rhip.ehr.common.RhipModuleName;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.founder.fasf.util.Assert;
import com.founder.rhip.BaseController;
import com.founder.rhip.ehr.service.export.ExportConfig;
import com.founder.rhip.ehr.service.export.IExcelExportService;

@Controller
@RequestMapping("/export")
public class ExportController extends BaseController {

	@Resource(name = "excelExportService")
	private IExcelExportService excelExportService;

	@RequestMapping("/excel")
	@ResponseBody
	public String excel(ReportContentForm content, HttpSession session) {
		UUID uuid = UUID.randomUUID();
		String id = uuid.toString().replace("-", "");
		session.setAttribute(id, content);
		return id;
	}

	@RequestMapping("/excel/{id}")
	public void excel(@PathVariable("id") String id, HttpSession session, HttpServletRequest request,HttpServletResponse response) {
		Object content = session.getAttribute(id);
		Assert.notNull(content);
		Assert.isInstanceOf(ReportContentForm.class, content);
		try (OutputStream outputStream = response.getOutputStream();) {
			ReportContentForm contentForm = (ReportContentForm) content;
			String title=contentForm.getTitle();
			title=null==title?"report":title.trim();
			setExcelContent(response, title+ ".xls");
            setCookie(response, ExportConfig.RESULT_COOKIE_SUCCESS_VALUE);
			excelExportService.exportExcel(title, contentForm.getContent(), outputStream);
            createOperationLog(request, RhipModuleName.REPORT_EXPORT,title,OperationName.EXP);
		} catch (Exception e) {
			throw new RuntimeException("导出失败", e);
		} finally {
			session.removeAttribute(id);
		}
	}

	private void setCookie(HttpServletResponse response, String value) {
		Cookie cookie = new Cookie(ExportConfig.RESULT_COOKIE_NAME, value);
		cookie.setPath("/");
		response.addCookie(cookie);
	}
}
