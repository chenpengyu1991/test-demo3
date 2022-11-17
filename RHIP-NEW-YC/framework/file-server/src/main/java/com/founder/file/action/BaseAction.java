package com.founder.file.action;

import com.founder.file.service.FileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import java.io.File;

/**
 * @author liuk
 * @since 14-3-17 下午3:27
 */
public class BaseAction extends HttpServlet {

    protected Logger logger= LoggerFactory.getLogger(getClass());

	private FileService fileService;

	@Override
	public void init() throws ServletException {
		fileService = (FileService) getServletContext().getAttribute(FileService.class.getName());
	}

	protected FileService getFileService() {
		return fileService;
	}

	protected boolean checkId(String id) {
		if (null == id || id.trim().length() < 1) {
			return false;
		}

        //id必须以文件结尾
        if(id.endsWith("\\")||id.endsWith("/")){
            return false;
        }

		return true;
	}
}