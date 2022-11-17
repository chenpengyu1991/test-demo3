package com.founder.file.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 文件删除
 * @author liuk
 * @since 14-3-14 下午1:57
 */
@WebServlet(asyncSupported = false, urlPatterns = "/file/delete/*")
public class FileDeleteAction extends BaseAction {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        String id = request.getParameter("id");
        if (!checkId(id)){
            response.sendError(500,"文件id不能为空");
            return;
        }
		try {
            getFileService().delete(id);
		} catch (Exception e) {
            logger.error("文件删除失败:{}",id);
			response.sendError(500, e.getMessage());
		}
	}

}
