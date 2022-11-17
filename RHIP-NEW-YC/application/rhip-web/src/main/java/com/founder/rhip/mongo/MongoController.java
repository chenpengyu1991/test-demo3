package com.founder.rhip.mongo;

import com.alibaba.fastjson.JSONObject;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.BaseController;
import com.founder.rhip.ehr.common.FileUtils;
import com.founder.rhip.ehr.common.PropertiesUtils;
import com.founder.rhip.ehr.service.file.MongoService;
import com.mongodb.DBObject;
import com.mongodb.gridfs.GridFSDBFile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.Date;
import java.util.Properties;

/**
 * 文件上传
 *
 * @author GaoFei
 *
 */
@Controller
@RequestMapping(value = "/mongo")
public class MongoController extends BaseController {
	private int FILE_MAX_SIZE = 1024;

	private Properties properties = PropertiesUtils.initProperties("fileUpload");
	@Resource
	private MongoService fileService;

	/**
	 * 测试页面
	 * @param model
	 * @return
	 */
	@RequestMapping("/test")
	public String search(Model model) {
		return "rhip.mongo.test";
	}

	@RequestMapping("/testDownload")
	public void testDownload(HttpServletResponse response) {
		OutputStream os = null;
		InputStream is = null;
		try {
			GridFSDBFile file = fileService.getGridFSFile("5f4f61a0f6d71719980cc0d9");
			DBObject dbObject = file.getMetaData();
			Object fileName = dbObject.get("fileName");
			response.setHeader("content-disposition", "attachment;fileName="
					+ URLEncoder.encode(String.valueOf(fileName), "UTF-8"));

			os = response.getOutputStream();
			response.setContentLength(Integer.valueOf(String.valueOf(file.getLength())).intValue());
			InputStream inputStream = file.getInputStream();
			byte [] fileByte = FileUtils.input2byte(inputStream);
			os.write(fileByte, 0, fileByte.length);
		} catch (FileNotFoundException fileException) {
			logger.warn("文件不存在：" + fileException.getMessage());
		} catch (Exception e) {//FileNotFoundException
			e.printStackTrace();
		} finally {
			try {
				if (os != null) {
					os.close();
				}
				if (is != null) {
					is.close();
				}
			} catch (IOException e) {
			}
		}
	}

	/**
	 * 上传文件
	 * @return
	 */
	@RequestMapping(value = "/testUpload")
	@ResponseBody
	public ModelMap testUpload(HttpServletRequest request, @RequestParam("file") MultipartFile file) {
		boolean result = false;
		String resultMessage = "";
		ModelMap model = new ModelMap();
		try {
			Object fileId = null;
			InputStream inputStream = file.getInputStream();
			fileId = fileService.saveGridFSFile(inputStream,file.getOriginalFilename(),file.getContentType(),new Date());
			if(ObjectUtil.isNotEmpty(fileId)){
				JSONObject fileJson = new JSONObject();
				fileJson.put("name",file.getOriginalFilename());
				fileJson.put("id",fileId);
				fileJson.put("size",file.getSize());
				model.put("fileJson", fileJson);
			}
			if(ObjectUtil.isNotEmpty(fileId)){
				model.put("fileId", fileId);
				result = true;
				resultMessage = "文件上传成功！";

			}
		} catch (Exception e) {
			e.printStackTrace();
			resultMessage = "文件上传失败" + e.getMessage();
		} catch (Throwable throwable) {
			result = false;
			resultMessage = "文件上传失败！" + throwable.getMessage();
		}
		model.put("resultMessage", resultMessage);
		model.put("result", result);
		return model;
	}
}
