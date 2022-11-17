package com.founder.rhip.whch;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.annotation.Resource;
import javax.jws.WebService;

import org.springframework.stereotype.Service;

import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.BaseWebService;
import com.founder.rhip.ehr.common.PropertiesUtils;
import com.founder.rhip.ehr.service.basic.IIntegrationMonitorService;
import com.founder.rhip.whch.service.IWhchService;

@Service("whchWebService")
@WebService(serviceName="whchWebService")
public class WhchWebService extends BaseWebService implements IWhchWebService {
	
	private static String folder;
	
	private static String exceptionFolder;

	@Resource(name = "whchService")
	private IWhchService whchService;
	
	@Resource(name = "integrationMonitorService")
	private IIntegrationMonitorService integrationMonitorService;
	
	static {
		Properties properties = PropertiesUtils.initProperties("setting");
		if (ObjectUtil.isNotEmpty(properties)) {
			folder = properties.getProperty("whch.data.folder");
			exceptionFolder = properties.getProperty("whch.data.exception.folder");
		}
	}
	
	@Override
	public String acceptMessage(String dataXml, String dataType) {
		if (ObjectUtil.isNullOrEmpty(dataXml) || ObjectUtil.isNullOrEmpty(dataType)) {
			return "调用方法参数不可以为空";
		}
		
		try {
			// 保存妇幼数据XML文件到磁盘指定目录
			saveDataFile(dataXml, dataType, false);
			
			Map<String, Long[]> map = new HashMap<>();
			// 保存到数据库
			whchService.setExceptionFolder(exceptionFolder);
			whchService.saveWhchInfo(dataXml, dataType, map);
			// 记录集成数据量
			integrationMonitorService.recordHealthCareIntegrationMonitor(map, new Date(), dataType);
			
			return "已经处理";
		} catch (Exception e) {
			saveDataFile(dataXml, dataType, true);
			logger.error(e.getMessage(), e);
			e.printStackTrace();
			return "处理失败";
		}
	}

	/**
	 * 保存妇幼保健数据文件XML到指定的磁盘目录
	 * 
	 * @param dataXml 妇幼保健数据XML格式
	 * @param dataType 妇幼数据类型
	 * @param isException 处理是否有异常
	 */
	private void saveDataFile(String dataXml, String dataType, boolean isException) {
		if (ObjectUtil.isNullOrEmpty(dataXml) || ObjectUtil.isNullOrEmpty(dataType) || ObjectUtil.isNullOrEmpty(folder) || ObjectUtil.isNullOrEmpty(exceptionFolder)) {
			return;
		}
		StringBuilder sb = new StringBuilder(isException ? exceptionFolder : folder).append(dataType).append(File.separator).append(DateUtil.getDateTime("yyyyMMdd", new Date())).append(File.separator);
		File file = new File(sb.toString());
		if (!file.exists()) {
			file.mkdirs();
		}
		String time = DateUtil.getDateTime("yyyyMMddHHmmss", new Date());
		StringBuilder nb = new StringBuilder(time).append(".xml");
		File f = new File(file, nb.toString());
		InputStream in = null;
		OutputStream os = null;
		try {
			in = new ByteArrayInputStream(dataXml.getBytes("UTF-8"));
			os = new FileOutputStream(f);
			int len = 0;
			byte buffer[] = new byte[3 * 1024];
			while ((len = in.read(buffer)) != -1) {
				os.write(buffer, 0, len);
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		} finally {
			try {
				if (in != null) {
					in.close();
				}
				if (os != null) {
					os.close();
				}
			} catch (IOException e) {
			}
		}
	}
}
