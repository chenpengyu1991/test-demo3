package com.founder.file.action;

import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author liuk
 * @since 14-3-14 下午1:57
 */
@WebServlet(asyncSupported = false, urlPatterns = "/file/add/*")
public class FileAddAction extends BaseAction {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
		try {
			Writer writer = response.getWriter();
			String fileName = request.getParameter("fileName");
			String type = request.getParameter("type");
            String thumbnailSizeString=request.getParameter("thumbnailSize");

            //是否需要缩略图,只要大小即生成
            boolean thumb=false;
            int  thumbnailSize=0;
            if (null!=thumbnailSizeString&&thumbnailSizeString.trim().length()>0){
                try {
                    thumbnailSize =Integer.parseInt(thumbnailSizeString);
                    thumb=true;
                } catch (NumberFormatException e) {
                     thumb=false;
                }
            }
            //保存文件
			try (InputStream inputStream = request.getInputStream()) {
				String id = getFileService().save(inputStream, type, fileName,thumb,thumbnailSize);
				if (null == id) {
                    logger.error("文件保存失败:{}/{}",type,fileName);
					response.sendError(500, "文件保存失败");
				} else {
					response.setStatus(200);
					writer.write(id);
					writer.flush();
				}
			}

		} catch (Exception e) {
            logger.error("文件保存失败",e);
			response.sendError(500, e.getMessage());
		}
	}




}
