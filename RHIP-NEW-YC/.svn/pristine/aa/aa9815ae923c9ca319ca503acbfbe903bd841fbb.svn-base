package com.founder.rhip.portal.util;

import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import javax.imageio.ImageIO;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.Properties;

/**
 * 处理文件操作
 */
public class FileUtils {

	private static Properties properties;

	private static int thumbnailSize;

	private static final String FOLDER_PATH = "_folderPath";

	private static final String FOLDER_SIZE = "_folderSize";
	
	private static final String DEFAULT_FOLDER_PATH = "default_folderPath";
	
	protected static Logger log = Logger.getLogger(FileUtils.class);

	static {
		properties = PropertiesUtils.initProperties("fileUpload");
		thumbnailSize = Integer.parseInt((String) properties.get("thumbnailSize"));
	}

	/**
	 * 取文件名后缀
	 * @param fileName
	 * @return
	 */
	public static String getSuffix(String fileName) {
		if (!StringUtils.contains(fileName, '.')) {
			return null;
		}
		return fileName.substring(fileName.lastIndexOf('.') + 1);
	}

	/**
	 * 从输入流读取文件并保存
	 * @param is
	 * @param fileSource
	 * @param fileName
	 * @return
	 * @throws Exception
	 */
	public static String saveFile(InputStream is, String fileSource, String fileName) throws Exception {
		String uploadTime = DateUtil.toFormatString("yyyyMMddHHmmss", new Date());
		String folderPath = (String) properties.get(fileSource + FOLDER_PATH);
		long folderSize = Long.parseLong((String)properties.get(fileSource + FOLDER_SIZE));
		folderSize = folderSize * 1024 * 1024;
		String savePath = getSavePath(folderPath, folderSize, uploadTime.substring(0, 8));
		if (StringUtil.isNullOrEmpty(savePath)) {
			return null;
		}
		fileName = renameFile(fileName, uploadTime);
		String filePath = save(is, savePath, fileName);

		String[] imageTypes = ((String) properties.get("supportImageType")).split(",");
		if (ImageUtil.isImage(fileName, imageTypes)) {
			ImageUtil.createThumbnail(filePath, thumbnailSize);
		}
		return filePath;
	}

	
	/**
	 * 获取相对路径
	 * @param filePath
	 * @return
	 */
	public static String getRelativePath(String fileSource,String filePath){
		String folderPath = (String) properties.get(fileSource + FOLDER_PATH);
		int folderPathLength = folderPath.length() + 1;
		return filePath.substring(folderPathLength);
	}
	
	/**
	 * 获取绝对路径
	 * @param fileSource
	 * @param filePath
	 * @return
	 */
	public static String getRealPath(String fileSource,String filePath){
		String folderPath = (String) properties.get(fileSource + FOLDER_PATH);
		
		if(ObjectUtil.isNullOrEmpty(folderPath)){
			folderPath = (String) properties.get(DEFAULT_FOLDER_PATH);
		}
		return folderPath + File.separator + filePath;
	}
	
	/**
	 * 获取绝对路径
	 * @param fileSource
	 * @param filePath
	 * @return
	 */
	public static String getSmbRealPath(String fileSource,String filePath){
		String folderPath = (String) properties.get(fileSource + FOLDER_PATH);
		
		if(ObjectUtil.isNullOrEmpty(folderPath)){
			folderPath = (String) properties.get(DEFAULT_FOLDER_PATH);
		}
		String smbFilePath =  folderPath + File.separator + filePath;
		
		return smbFilePath.substring(3);
	}
	
	/**
	 * 获取绝对路径
	 * @param fileSource
	 * @param filePath
	 * @return
	 */
	public static String getSmbRealFolder(String fileSource,String filePath){
		String folderPath = (String) properties.get(fileSource + FOLDER_PATH);
		
		if(ObjectUtil.isNullOrEmpty(folderPath)){
			folderPath = (String) properties.get(DEFAULT_FOLDER_PATH);
		}
		
		String fPath = filePath.substring(0,8);
		String smbFilePath =  folderPath + File.separator + fPath;
		return smbFilePath.substring(3);
	}
	
	
	/**
	 * 删除文件
	 * @param filePath
	 * @return
	 */
	public static boolean deleteFile(String filePath) {
		File file = new File(filePath);
		if (!file.exists()) {
			return true;
		}
		boolean deleted = file.delete();
		deleteFile(ImageUtil.getThumbnailPath(filePath));
		return deleted;
	}

	private static String save(InputStream is, String savePath, String fileName) throws Exception {
		File file = new File(savePath, fileName);
		OutputStream os = null;
		try {
			os = new FileOutputStream(file);
			int len = 0;
			byte buffer[] = new byte[3 * 1024];
			while ((len = is.read(buffer)) != -1) {
				os.write(buffer, 0, len);
			}
		} catch (Exception e) {
			throw e;
		} finally {
			is.close();
			os.close();
		}
		return file.getAbsolutePath();
	}

	/**
	 * 检查路径是否可用，若没有文件夹或大小超过最大值则新建文件夹
	 *
	 * @param folderPath
	 * @param folderSize
	 * @return
	 * @throws IOException
	 */
	private static String getSavePath(String folderPath, long folderSize, String date) throws IOException {
		if (StringUtil.isNullOrEmpty(folderPath)) {
			return null;
		}
		File topFolder = new File(folderPath);
		if (!topFolder.exists()) {
			return null;
		}
		// get the latest folder
		File currentFolder = getLatestFolder(topFolder, date);
		if (currentFolder != null) {
			long size = getFolderSize(currentFolder);
			if (size < folderSize) {
				return currentFolder.getAbsolutePath();
			}
		}
		// create new folder
		File newFolder = new File(folderPath, date);
		newFolder.mkdir();
		return newFolder.getAbsolutePath();
	}

	/**
	 * 取得当天最新的文件夹
	 * @param folder
	 * @param today
	 * @return
	 */
	private static File getLatestFolder(File folder, String today) {
		if (!folder.exists()) {
			return null;
		}
		File[] fList = folder.listFiles();
		if (ObjectUtil.isNullOrEmpty(fList)) {
			return null;
		}
		File latestFolder = null;
		String latestName = "";
		for (File f : fList) {
			if (f.isDirectory()) {
				String name = f.getName();
				if (name.startsWith(today) && name.compareTo(latestName) > 0) {
					latestName = name;
					latestFolder = f;
				}
			}
		}
		return latestFolder;
	}

	/**
	 * 计算文件大小
	 * @param file
	 * @return
	 * @throws IOException
	 */
	private static long getFileSize(File file) throws IOException {
		if (file == null) {
			return 0;
		}
		long size = 0;
		if (file.exists()) {
			FileInputStream fis = new FileInputStream(file);
			size = fis.available();
		}
		return size;
	}

	/**
	 * 计算文件夹大小
	 * @param folder
	 * @return
	 * @throws IOException
	 */
	private static long getFolderSize(File folder) throws IOException {
		if (folder == null) {
			return 0;
		}
		long size = 0;
		File[] fileList = folder.listFiles();
		if (ObjectUtil.isNullOrEmpty(fileList)) {
			return 0;
		}
		for (File f : fileList) {
			if (f.isDirectory()) {
				size += getFolderSize(f);
			} else {
				size += getFileSize(f);
			}
		}
		return size;
	}

	/**
	 * 文件重命名
	 * @param fileName
	 * @param uploadTime
	 * @return
	 */
	private static String renameFile(String fileName, String uploadTime) {
		return uploadTime + fileName.substring(fileName.lastIndexOf('.')).toLowerCase();
	}


}
