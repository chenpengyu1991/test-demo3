package com.founder.file.action;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;

/**
 * @author liuk
 * @since 14-3-14 下午1:57
 */
@WebServlet(asyncSupported = false, urlPatterns = "/file/download/*")
public class FileDownLoadAction extends BaseAction {

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
                int index= id.lastIndexOf("\\");
                if(index==-1){
                    index=id.lastIndexOf("/");
                }
                if(index!=-1){
                    fileName=id.substring(index,id.length());
                }else{
                    fileName=id;
                }

            }
            setContentType(fileName,response);
            OutputStream out=response.getOutputStream();
            getFileService().write(id,out);
            return;
		} catch (Exception e) {
            logger.error("文件下载未知错误:{}",id);
            response.sendError(500,e.getMessage());
		}
	}

    /**
     * 设置不同类型文件
     * @param fileName
     * @param response
     */
    private void setContentType(String fileName, HttpServletResponse response) {
        try {
            String name = new String(fileName.getBytes("GBK"),"ISO8859_1");
            response.setHeader("Content-Disposition", "attachment; filename=\"" + name + "\"");
            if (StringUtils.endsWithIgnoreCase(fileName, "xls") || StringUtils.endsWithIgnoreCase(fileName, "xlsx")) {
                response.setContentType("application/vnd.ms-excel");
            } else if (StringUtils.endsWithIgnoreCase(fileName, "ppt")  || StringUtils.endsWithIgnoreCase(fileName, "pptx")) {
                response.setContentType("application/vnd.ms-powerpoint");
            } else if (StringUtils.endsWithIgnoreCase(fileName, "doc") || StringUtils.endsWithIgnoreCase(fileName, "docx")) {
                response.setContentType("application/vnd.ms-msword");
            } else if (StringUtils.endsWithIgnoreCase(fileName, "pdf")) {
                response.setContentType("application/pdf");
            } else if (StringUtils.endsWithIgnoreCase(fileName, "txt")) {
                response.setContentType("application/rtf");
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

}
