package com.founder.file.action;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.http.entity.ContentType;

/**
 * @author liuk
 * @since 14-3-14 下午1:57
 */
@WebServlet(asyncSupported = false, urlPatterns = "/file/preview/*")
public class FilePreViewAction extends BaseAction {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        String id = request.getParameter("id");
        if (!checkId(id)){
            logger.error("文件id不合法");
            response.sendError(500,"文件id不合法");
            return;
        }
		try {
            String fileName = request.getParameter("fileName");
            if (null==fileName){
                fileName=id;
            }
            setContentType(fileName,response);
            OutputStream out=response.getOutputStream();
            getFileService().write(id,out);
            return;
		} catch (Exception e) {
            logger.error("文件预览未知错误:{}",id);
            response.sendError(500,e.getMessage());
		}
	}

    /**
     * 设置不同类型文件
     * @param fileName
     * @param response
     */
    private void setContentType(String fileName, HttpServletResponse response) {
        int index =fileName.lastIndexOf(".");
        if(-1==index){
            response.setContentType("image/jpg");
        }else {
            String type=fileName.substring(index,fileName.length()).trim();
            if(type.endsWith("jpg")){
                response.setContentType("image/jpg");
            }else if(type.endsWith("png")){
                response.setContentType("image/png");
            }else if(type.endsWith("gif")){
                response.setContentType("image/gif");
            }
         }
    }

}
