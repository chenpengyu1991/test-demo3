package com.founder.rhip.mongo;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.founder.fasf.beans.Criteria;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.BaseController;
import com.founder.rhip.ehr.common.*;
import com.founder.rhip.ehr.entity.basic.UploadInfoRecord;
import com.founder.rhip.ehr.entity.file.FileDo;
import com.founder.rhip.ehr.service.basic.IUploadInfoRecordService;
import com.founder.rhip.ehr.service.file.MongoService;
import com.founder.rhip.fds.entity.AttachmentRecord;
import com.founder.rhip.fds.service.IAttachmentRecordService;
import com.founder.rhip.mdm.entity.Organization;
import com.founder.rhip.util.MD5Util;
import com.mongodb.DBObject;
import com.mongodb.gridfs.GridFSDBFile;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.lang.StringUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

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
 * 文件 上传/下载 Controller 类；
 */
@Controller
@RequestMapping(value = "/mongoFile")
public class MongoUploadController extends BaseController {

	@Resource(name = "attachmentRecordService")
	private IAttachmentRecordService attachmentRecordService;

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
		String uuid = request.getParameter("qquuid");
		HttpSession session = request.getSession();
		String fileId = null;
		FileDo file = null;
		try {
			createOperationLog(request, RhipModuleName.HE, "上传附件", OperationName.IMP);
			file = upload(request,fileSource);
			fileId = file.get_id();
		} catch (Exception e) {
			model.addAttribute("success", false);
			model.addAttribute("message", "上传失败。" + e.getMessage());
			logger.error("上传附件失败", e);
		} catch (Throwable throwable) {
			model.addAttribute("message", "上传失败。" + throwable.getMessage());
			logger.error("上传附件失败", throwable);
		}
		if (StringUtil.isNullOrEmpty(fileId)) {
			model.addAttribute("success", false);
			response.setContentType("text/html");
			try {
				response.getWriter().write("{\"success\":\"false\"}");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		model.addAttribute("success", true);
		response.setContentType("text/html");
		try {
			response.getWriter().write("{\"success\":\"false\"}");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 上传文件
	 * @param request
	 * @return
	 */
	private FileDo upload(HttpServletRequest request, String fileSrc) throws Throwable {
		String fileId = "";
		FileDo f = new FileDo();
		if (ServletFileUpload.isMultipartContent(request)) {
			String uuid = request.getParameter("qquuid");
			HttpSession session = request.getSession();
			MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
			CommonsMultipartFile file = (CommonsMultipartFile)multipartRequest.getFile("qqfile");
			try {
				byte[] fileByte = FileUtils.readInputStream(file.getInputStream());
				f = new FileDo(file.getOriginalFilename(), file.getContentType(),fileByte.length, fileByte);
				//保存MD5值
				InputStream is1 = new ByteArrayInputStream(fileByte);
				f.setMd5(MD5Util.getMD5(is1));
				f.setFileSrc(fileSrc);
				fileId = fileService.saveFile(f);
				f.set_id(fileId);
				//将文件ID保存在Session中
				Map<String, String[]> fileMap = (Map<String, String[]>) session.getAttribute(fileSrc + "_fileMap");
				if (fileMap == null) {
					fileMap = new HashMap<>();
					session.setAttribute(fileSrc + "_fileMap", fileMap);
				}
				fileMap.put(uuid, new String[]{fileId, f.getContentType(), String.valueOf(f.getSize()), f.getName(), f.getMd5()});
			} catch (IOException e) {
				throw e.getCause();
			} catch (Exception e) {
				throw e.getCause();
			}
		}
		return f;
	}

	/**
	 * 删除上传文件
	 *
	 * @param uuid
	 * @param request
	 * @param response
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/deleteFile/{fileSrc}/{uuid}")
	public void delete(@PathVariable String fileSrc, @PathVariable String uuid, HttpServletRequest request, HttpServletResponse response) {
		boolean result = false;
		ModelMap model = new ModelMap();
		try {
			if (StringUtil.isNotEmpty(uuid)) {
				Map<String, String[]> fileMap = (Map<String, String[]>) request.getSession().getAttribute(fileSrc +"_fileMap");
				if(ObjectUtil.isNotEmpty(fileMap)) {
					String fileInfoArray[] = fileMap.get(uuid);
					if(ObjectUtil.isNotEmpty(fileInfoArray)) {
						String fileId = fileInfoArray[0];
						model.put("fileId",fileId);
						fileService.removeFile(fileId);
						fileMap.remove(uuid);
					}
					result = true;
				}else{
					result = false;
				}
			}
		} catch(Exception ex){
			result = false;
		}
		model.put("result", result);
	}

	@RequestMapping("/deleteAttachment/{id}")
	@ResponseBody
	public ModelMap deleteAttachment(@PathVariable("id") Long id, HttpServletResponse response, HttpServletRequest request) {
		AttachmentRecord attachmentRecord = attachmentRecordService.queryAttachmentRecord(new Criteria("ID", id)).get(0);
		createOperationLog(request, RhipModuleName.HE, "删除附件", OperationName.DELETE);
		boolean ret = attachmentRecordService.deleteAttachmentRecord(id);
		if (ret) {
			fileService.removeFile(attachmentRecord.getMongoId());
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

	@RequestMapping("/showAsImage/{fileId}")
	public void showAsImage(@PathVariable String fileId, Boolean thumbnail, HttpServletResponse response) {
		if(ObjectUtil.isNullOrEmpty(thumbnail)){
			thumbnail = false;
		}
		FileDo file = fileService.getFileById(fileId);
		if(ObjectUtil.isNotEmpty(file)) {
			try {
				byte[] fileByte = file.getContent();
				if (thumbnail) {
					FileType imgType = FileUtils.getType(file.getContent());
					String contentType = "jpg";
					if(ObjectUtil.isNotEmpty(imgType)) {
						contentType = imgType.name();
					}
					fileByte = getThumbnailByte(fileByte, contentType);
					file.setContent(fileByte);
					file.setSize(fileByte.length);
				}
				outputImage(file,response);
			} catch (Exception e) {//FileNotFoundException
				e.printStackTrace();
			}
		}
	}

	@RequestMapping("/showSmallImage/{fileId}")
	public void showSmallImage(@PathVariable String fileId, HttpServletResponse response) {
		FileDo file = fileService.getFileById(fileId);
		if(ObjectUtil.isNotEmpty(file)) {
			try {
				byte[] fileByte = file.getContent();
				FileType imgType = FileUtils.getType(file.getContent());
				String contentType = "jpg";
				if(ObjectUtil.isNotEmpty(imgType)) {
					contentType = imgType.name();
				}
				fileByte = getThumbnailByte(fileByte, contentType);
				file.setContent(fileByte);
				file.setSize(fileByte.length);
				outputImage(file,response);
			} catch (Exception e) {//FileNotFoundException
				e.printStackTrace();
			}
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

	@RequestMapping("/download/{fileId}")
	public void download(@PathVariable("fileId") String fileId, HttpServletRequest request, HttpServletResponse response) {
		if (StringUtil.isNullOrEmpty(fileId)) {
			return;
		}
		OutputStream os = null;
		InputStream is = null;
		try {
			FileDo file = fileService.getFileById(fileId);
			response.setHeader("content-disposition", "attachment;fileName="
					+ URLEncoder.encode(file.getName(), "UTF-8"));

			os = response.getOutputStream();
			response.setContentLength(Integer.valueOf(String.valueOf(file.getSize())).intValue());
			os.write(file.getContent(), 0, file.getContent().length);
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

	@RequestMapping("/viewAttchement/{id}")
	public String viewAttchement(@PathVariable("id") Long id, String orgCode, String divId, String fileResource, HttpServletRequest request, ModelMap model) {
		Organization org = getCurrentOrg(request);
		boolean delete = (StringUtils.equalsIgnoreCase(org.getOrganCode(), orgCode) || hasRole(RoleType.YY_GLY, request)) ? true : false;
		List<AttachmentRecord> attachmentRecords = attachmentRecordService.queryAttachmentRecord(new Criteria("BUSINESS_ID", id).add("FILE_SRC", fileResource));
		model.addAttribute("attches", attachmentRecords);
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