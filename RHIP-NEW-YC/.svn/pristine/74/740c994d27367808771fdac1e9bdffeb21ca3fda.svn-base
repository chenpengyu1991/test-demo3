package com.founder.rhip.he.controller;

import com.alibaba.fastjson.JSONObject;
import com.founder.fasf.beans.Criteria;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.BaseController;
import com.founder.rhip.ehr.common.FileType;
import com.founder.rhip.ehr.common.FileUtils;
import com.founder.rhip.ehr.common.RhipModuleName;
import com.founder.rhip.ehr.common.RoleType;
import com.founder.rhip.ehr.entity.basic.UploadInfoRecord;
import com.founder.rhip.ehr.entity.file.FileDo;
import com.founder.rhip.ehr.service.basic.IUploadInfoRecordService;
import com.founder.rhip.ehr.service.file.MongoService;
import com.founder.rhip.mdm.entity.Organization;
import com.mongodb.DBObject;
import com.mongodb.gridfs.GridFSDBFile;
import org.apache.commons.lang.StringUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URLEncoder;
import java.util.*;

/**
 * 文件上传
 *
 * @author GaoFei
 *
 */
@Controller
@RequestMapping(value = "/he/upload")
public class FileUploadController extends BaseController {

	@Resource(name = "uploadInfoRecordService")
	private IUploadInfoRecordService uploadInfoRecordService;

	@Resource
	private MongoService fileService;
	/**
	 * 上传文件
	 *
	 * @param request
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/uploadFile/{fileSource}")
	public void uploadFile(HttpServletRequest request, HttpServletResponse response, @PathVariable("fileSource") String fileSource) {
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(MediaType.TEXT_HTML);
		response.setContentType("text/html;charset=UTF-8");
		ModelMap model = new ModelMap();
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		MultipartFile file = multipartRequest.getFile("qqfile");
		String uuid = request.getParameter("qquuid");
		HttpSession session = request.getSession();
		String fileId = null;
		try {
			createOperationLog(request, RhipModuleName.HE, "上传附件", OperationName.IMP);
			InputStream inputStream = file.getInputStream();
			fileId = fileService.saveGridFSFile(inputStream,file.getOriginalFilename(),file.getContentType(),new Date());
			//保存原文件名在session中
			Map<String, String> filenameMap = (Map<String, String>) session.getAttribute(fileSource + "_filenameMap");
			if (filenameMap == null) {
				filenameMap = new HashMap<>();
				session.setAttribute(fileSource + "_filenameMap", filenameMap);
			}
			filenameMap.put(uuid, file.getOriginalFilename());
		} catch (Exception e) {
			model.addAttribute("success", false);
			model.addAttribute("message", "上传失败。" + e.getMessage());
			logger.error("上传附件失败", e);
		}
		if (StringUtil.isNullOrEmpty(fileId)) {
			model.addAttribute("success", false);
			response.setContentType("text/html");
			try {
				response.getWriter().write("{\"success\":\"false\"}");
			} catch (Exception e) {
				e.printStackTrace();
			}		}
		Map<String, String> fileMap = (Map<String, String>) session.getAttribute(fileSource + "_fileMap");
		if (fileMap == null) {
			fileMap = new HashMap<>();
			session.setAttribute(fileSource + "_fileMap", fileMap);
		}
		fileMap.put(uuid, fileId);

		model.addAttribute("success", true);
		response.setContentType("text/html");
		try {
			response.getWriter().write("{\"success\":\"false\"}");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 删除上传文件
	 *
	 * @param uuid
	 * @param request
	 * @param response
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/deleteFile/{fileDoc}/{uuid}")
	public void delete(@PathVariable String fileDoc, @PathVariable String uuid, HttpServletRequest request, HttpServletResponse response) {
		Map<String, String> fileMap = (Map<String, String>) request.getSession().getAttribute(fileDoc + "_fileMap");
		if (fileMap == null) {
			response.setStatus(404);
			return;
		}
		String fileId = fileMap.get(uuid);
		if (StringUtil.isNotEmpty(fileId)) {
			fileService.removeGridFSFile(fileId);
			response.setStatus(200);
			fileMap.remove(uuid); // 清理session
		} else {
			response.setStatus(404);
		}
	}

	@RequestMapping("/deleteAttachment/{id}")
	@ResponseBody
	public ModelMap deleteAttachment(@PathVariable("id") Long id, HttpServletResponse response, HttpServletRequest request) {
		UploadInfoRecord uploadInfoRecord = uploadInfoRecordService.queryUploadInfoRecord(new Criteria("ID", id)).get(0);
		createOperationLog(request, RhipModuleName.HE, "删除附件", OperationName.DELETE);
		boolean ret = uploadInfoRecordService.deleteUploadInfoRecord(id);
		if (ret) {
			fileService.removeGridFSFile(uploadInfoRecord.getOriginalFilePath());
		}

		ModelMap model = new ModelMap();
		if (ret) {
			model.addAttribute("result", true);
			model.addAttribute("message", "删除成功！");
		} else {
			model.addAttribute("result", false);
			model.addAttribute("message", "删除失败！");
		}

		return model;
	}

	@RequestMapping("/showAsImage/{id}")
	public void showAsImage(@PathVariable Long id, HttpServletResponse response) {
		List<UploadInfoRecord> uploadInfoRecords = null;
		UploadInfoRecord uploadInfoRecord = null;
		String originalFilePath = null;
		if (ObjectUtil.isNullOrEmpty(id) || ObjectUtil.isNullOrEmpty(uploadInfoRecords = uploadInfoRecordService.queryUploadInfoRecord(new Criteria("ID", id)))
				|| ObjectUtil.isNullOrEmpty(uploadInfoRecord = uploadInfoRecords.get(0)) || ObjectUtil.isNullOrEmpty(originalFilePath = uploadInfoRecord.getOriginalFilePath())) {
			return;
		}

		try {
			InputStream in = fileService.getGridFSFile(originalFilePath).getInputStream();
			BufferedImage bufferedImage = ImageIO.read(in);
			OutputStream outputStream = response.getOutputStream();
			ImageIO.write(bufferedImage, StringUtils.substringAfterLast(uploadInfoRecord.getOriginalFileName(), "."), outputStream);
			outputStream.flush();
			outputStream.close();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
	}

	@RequestMapping("/showSmallImage/{id}")
	public void showSmallImage(@PathVariable Long id, HttpServletResponse response) {
		List<UploadInfoRecord> uploadInfoRecords = null;
		UploadInfoRecord uploadInfoRecord = null;
		String originalFilePath = null;
		if (ObjectUtil.isNullOrEmpty(id) || ObjectUtil.isNullOrEmpty(uploadInfoRecords = uploadInfoRecordService.queryUploadInfoRecord(new Criteria("ID", id)))
				|| ObjectUtil.isNullOrEmpty(uploadInfoRecord = uploadInfoRecords.get(0)) || ObjectUtil.isNullOrEmpty(originalFilePath = uploadInfoRecord.getOriginalFilePath())) {
			return;
		}

		try {
			InputStream in = fileService.getGridFSFile(uploadInfoRecord.getOriginalFilePath()).getInputStream();
			GridFSDBFile file = fileService.getGridFSFile(uploadInfoRecord.getOriginalFilePath());
			DBObject dbObject = file.getMetaData();
			String fileName = dbObject.get("fileName").toString();
				byte[] fileByte = FileUtils.input2byte(in);
				FileType imgType = FileUtils.getType(fileByte);
				String contentType = "jpg";
				if (ObjectUtil.isNotEmpty(imgType)) {
					contentType = imgType.name();
				}
				fileByte = getThumbnailByte(fileByte, contentType);
				FileDo fileDo = new FileDo(fileName, file.getContentType(), fileByte.length, fileByte);
				outputImage(fileDo,response);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
	}

	@RequestMapping("/showUeImage")
	public void showUeImage(String fileSource, HttpServletResponse response) {
		String[] fs = fileSource.split(":");
		String originalFilePath = FileUtils.getRealPath(fs[0], fs[1]);

		try {
			InputStream in = new FileInputStream(originalFilePath);
			BufferedImage bufferedImage = ImageIO.read(in);
			OutputStream outputStream = response.getOutputStream();
			ImageIO.write(bufferedImage, StringUtils.substringAfterLast(originalFilePath, "."), outputStream);
			outputStream.flush();
			outputStream.close();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
	}

	@RequestMapping("/download/{id}")
	public void download(@PathVariable("id") Long id, HttpServletRequest request, HttpServletResponse response) {
		if (id == null) {
			return;
		}
		List<UploadInfoRecord> uploadInfoRecords = uploadInfoRecordService.queryUploadInfoRecord(new Criteria("ID", id));
		UploadInfoRecord uploadInfoRecord = null;
		String fileName = null;
		if (ObjectUtil.isNullOrEmpty(uploadInfoRecords) || (uploadInfoRecord = uploadInfoRecords.get(0)) == null
				|| ObjectUtil.isNullOrEmpty(fileName = uploadInfoRecord.getOriginalFileName())) {
			return;
		}
		createOperationLog(request, RhipModuleName.HE, "文件下载", OperationName.EXP);
		// 设置对应的文件类型
		setContentType(fileName, response, request);

		OutputStream os = null;
		InputStream is = null;
		try {
			GridFSDBFile file = fileService.getGridFSFile(uploadInfoRecord.getOriginalFilePath());
			os = response.getOutputStream();
			is = file.getInputStream();
			int len = 0;
			byte buffer[] = new byte[3 * 1024];
			while ((len = is.read(buffer)) != -1) {
				os.write(buffer, 0, len);
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
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

	@RequestMapping("/viewAttchement/{id}")
	public String viewAttchement(@PathVariable("id") Long id, String orgCode, String divId, String fileResource, HttpServletRequest request, ModelMap model) {
		Organization org = getCurrentOrg(request);
		boolean delete = (StringUtils.equalsIgnoreCase(org.getOrganCode(), orgCode) || hasRole(RoleType.YY_GLY, request)) ? true : false;
		List<UploadInfoRecord> uploadInfoRecords = uploadInfoRecordService.queryUploadInfoRecord(new Criteria("RESOURCE_ID", id).add("FILE_RESOURCE", fileResource));
		model.addAttribute("attches", uploadInfoRecords);
		model.addAttribute("delete", delete);
		model.addAttribute("resourceId", id);
		model.addAttribute("orgCode", orgCode);
		model.addAttribute("fileResource", fileResource);
		model.addAttribute("divId", divId);
		return "rhip.he.health.education.attchement.edit";
	}

	/**
	 * 设置不同类型文件
	 * @param fileName
	 * @param response
	 */
	private void setContentType(String fileName, HttpServletResponse response, HttpServletRequest request) {
		if (ObjectUtil.isNullOrEmpty(fileName)) {
			return;
		}

		try {
			String userAgent = request.getHeader("User-Agent").toLowerCase();
			StringTokenizer st = new StringTokenizer(userAgent,";");
			st.nextToken();
			//得到用户的浏览器名
			String accBrowser = st.nextToken().trim();
			//得到用户的操作系统名
			String accOs = st.nextToken().trim();
			String name = "";
			if(accBrowser.contains("mac")){
				name = new String(fileName.getBytes("UTF-8"),"ISO8859_1");
			}else{
				name = new String(fileName.getBytes("GBK"),"ISO8859_1");
			}
			response.reset();
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

	private byte[] getThumbnailByte(byte[] bytesSrc,String formatName){
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		int imageSize = 180;
		try {
			ByteArrayInputStream bais = new ByteArrayInputStream(bytesSrc);
			BufferedImage bi1 = ImageIO.read(bais);
			AffineTransform transform = new AffineTransform();
			int w = bi1.getWidth();
			int h = bi1.getHeight();
			int nw = imageSize;
			int nh = (nw * h) / w;
			if (nh > imageSize) {
				nh = imageSize;
				nw = (nh * w) / h;
			}
			double sx = (double) nw / w;
			double sy = (double) nh / h;

			transform.setToScale(sx, sy);
			AffineTransformOp ato = new AffineTransformOp(transform, null);
			BufferedImage bid = new BufferedImage(nw, nh, BufferedImage.TYPE_3BYTE_BGR);
			ato.filter(bi1, bid);
			//经测试转换的图片是格式这里就什么格式，否则会失真
			ImageIO.write(bid, StringUtil.isNullOrEmpty(formatName)?"jpg":formatName.toLowerCase(), baos);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return baos.toByteArray();
	}

	/**
	 * 输出图片
	 */
	private void outputImage(FileDo file, HttpServletResponse response){
		try {
			ByteArrayInputStream in = new ByteArrayInputStream(file.getContent());
			BufferedImage bufferedImage = ImageIO.read(in);
			OutputStream outputStream = response.getOutputStream();
			FileType imgType = FileUtils.getType(file.getContent());
			if(ObjectUtil.isNotEmpty(imgType)) {
				ImageIO.write(bufferedImage, imgType.name(), outputStream);
			}else{
				ImageIO.write(bufferedImage,"jpg", outputStream);
			}
			outputStream.flush();
			outputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
