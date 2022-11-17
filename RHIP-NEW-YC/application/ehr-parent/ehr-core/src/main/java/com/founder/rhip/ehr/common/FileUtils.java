package com.founder.rhip.ehr.common;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.util.Date;
import java.util.Properties;
import java.util.UUID;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;

/**
 * 处理文件操作
 */
public class FileUtils {

	private static Properties properties;

	private static int thumbnailSize;

	private static final String FOLDER_PATH = "_folderPath";

	private static final String FOLDER_SIZE = "_folderSize";

	private static final String FILE_SIZE = "_fileSize";

	private static final String DEFAULT_FOLDER_PATH = "default_folderPath";

	protected static Logger log = Logger.getLogger(FileUtils.class);

	static {
		properties = PropertiesUtils.initProperties("fileUpload");
		thumbnailSize = Integer.parseInt((String) properties.get("thumbnailSize"));
	}

	/**
	 * 取文件名后缀
	 *
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
	 *
	 * @param is
	 * @param fileSource
	 * @param fileName
	 * @return
	 * @throws Exception
	 */
	public static String saveFile(InputStream is, String fileSource, String fileName) throws Exception {
		String fs = (String) properties.get(fileSource + FILE_SIZE);
		String[] imageTypes = ((String) properties.get("supportImageType")).split(",");
		String uploadTime = DateUtil.toDateString(new Date(), "yyyyMMddHHmmss");
		String folderPath = (String) properties.get(fileSource + FOLDER_PATH);
		long folderSize = Long.parseLong((String) properties.get(fileSource + FOLDER_SIZE));
		folderSize = folderSize * 1024 * 1024;
		String savePath = getSavePath(folderPath, folderSize, uploadTime.substring(0, 8));
		if (StringUtil.isNullOrEmpty(savePath)) {
			return null;
		}
		fileName = renameFile(fileName,uploadTime);
		String filePath = null;
		if (StringUtil.isNotEmpty(fs) && ImageUtil.isImage(fileName, imageTypes)) {
			filePath = new StringBuilder(savePath).append(File.separator).append(fileName).toString();
			long fileSize = Long.parseLong(fs);
			long thisSize = is.available();
			if (thisSize > fileSize * 1024 * 1024) {
				int imageSize = Integer.parseInt((String) properties.get("imageSize"));
				//TODO:处理大于2M的图片
//				throw new Exception("文件大小超过限制！");
				ImageUtil.tuneImage(is, filePath, imageSize);
			} else {
				filePath = save(is, savePath, fileName);
			}
		} else {
			filePath = save(is, savePath, fileName);
		}

		if (ImageUtil.isImage(fileName, imageTypes)) {
			ImageUtil.createThumbnail(filePath, thumbnailSize);
		}
		return filePath;
	}

	/**
	 * 获取相对路径
	 *
	 * @param filePath
	 * @return
	 */
	public static String getRelativePath(String fileSource, String filePath) {
		String folderPath = (String) properties.get(fileSource + FOLDER_PATH);
		int folderPathLength = folderPath.length() + 1;
		return filePath.substring(folderPathLength);
	}

	/**
	 * 获取实际路径
	 *
	 * @param fileSource
	 * @param filePath
	 * @return
	 */
	public static String getRealPath(String fileSource, String filePath) {
		String folderPath = (String) properties.get(fileSource + FOLDER_PATH);

		if (ObjectUtil.isNullOrEmpty(folderPath)) {
			folderPath = (String) properties.get(DEFAULT_FOLDER_PATH);
		}
		return folderPath + File.separator + filePath;
	}
	/**
	 * * 判断文件类型
	 *
	 * @param src        文件二进制
	 * @return 文件类型
	 */
	public static FileType getType(byte [] src) {
		String fileHead = bytesToHexString(src);
		if (fileHead == null || fileHead.length() == 0) {
			return null;
		}
		fileHead = fileHead.toUpperCase();
		FileType[] fileTypes = FileType.values();
		for (FileType type : fileTypes) {
			if (fileHead.startsWith(type.getValue())) {
				return type;
			}
		}
		return null;
	}
	/**
	 * 将文件头转换成16进制字符串 *
	 *
	 * @param src：原生
	 * @return 16进制字符串
	 */
	private static String bytesToHexString(byte[] src) {
		StringBuilder stringBuilder = new StringBuilder();
		if (src == null || src.length <= 0) {
			return null;
		}
		for (int i = 0; i < src.length; i++) {
			int v = src[i] & 0xFF;
			String hv = Integer.toHexString(v);
			if (hv.length() < 2) {
				stringBuilder.append(0);
			}
			stringBuilder.append(hv);
		}
		return stringBuilder.toString();
	}

	/**
	 * 删除文件
	 *
	 * @param filePath
	 * @return
	 */
	public static boolean deleteFile(String filePath) {
		return doDeleteFile(filePath) && doDeleteFile(ImageUtil.getThumbnailPath(filePath));
	}

	private static boolean doDeleteFile(String first, String... more) {
		Path path = FileSystems.getDefault().getPath(first, more);
		boolean deleted = true;
		try {
			Files.delete(path);
		} catch (NoSuchFileException fileException) {
			log.warn("指定的文件不存在:" + path.getFileName());
		} catch (Exception e) {
			log.error("文件删除失败", e);
			deleted = false;
		}
		return deleted;
	}

	private static String save(InputStream is, String savePath, String fileName) {
		Path path = FileSystems.getDefault().getPath(savePath, fileName);
		try {
			Files.copy(is, path);
		} catch (IOException e) {
			log.error("文件保存失败", e);
			throw new RuntimeException(e);
		}
		String p = path.toAbsolutePath().toString();
		return p.replace("\\", "/");

		// OutputStream os = null;
		// File file = null;
		// String path = null;
		// byte buffer[] = null;
		// try {
		// file = new File(savePath, fileName);
		// path = file.getAbsolutePath();
		// os = new FileOutputStream(file);
		// int len = 0;
		// buffer = new byte[3 * 1024];
		// while ((len = is.read(buffer)) != -1) {
		// os.write(buffer, 0, len);
		// }
		//
		// } catch (Exception e) {
		// log.error("文件保存失败", e);
		// throw new RuntimeException(e);
		// } finally {
		// try {
		// file = null;
		// if (null != is) {
		// os.close();
		// os = null;
		// }
		// if (null != is) {
		// is.close();
		// is = null;
		// }
		// buffer = null;
		// } catch (IOException e) {
		// log.error("文件流关闭失败", e);
		// }
		// }
		// return path;
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
			topFolder.mkdirs();
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
	 *
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
	 *
	 * @param file
	 * @return
	 * @throws IOException
	 */
	private static long getFileSize(File file) throws IOException {
		if (file == null) {
			return 0;
		}
		long size = 0;
		Path path = file.toPath();
		if (Files.isRegularFile(path)) {
			return Files.size(path);
		}
		return size;
	}

	/**
	 * 计算文件夹大小
	 *
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
	 *
	 * @param fileName
	 * @param uploadTime
	 * @return
	 */
	private static String renameFile(String fileName, String uploadTime) {
		UUID uuid = UUID.randomUUID();
		return uuid.toString().replace("-", "")+fileName.substring(fileName.lastIndexOf('.')).toLowerCase();
		// return uploadTime+
		// fileName.substring(fileName.lastIndexOf('.')).toLowerCase();
	}

	public static final byte[] input2byte(InputStream inStream)
			throws IOException {
		ByteArrayOutputStream swapStream = new ByteArrayOutputStream();
		byte[] buff = new byte[1024];
		int rc = 0;
		while ((rc = inStream.read(buff, 0, 100)) > 0) {
			swapStream.write(buff, 0, rc);
		}
		byte[] in2b = swapStream.toByteArray();
		return in2b;
	}

	/**
	 * 从输入流中获取数据
	 *
	 * @param inStream
	 *            输入流
	 * @return
	 * @throws IOException
	 * @throws Exception
	 */
	public static byte[] readInputStream(InputStream inStream) throws IOException {
		ByteArrayOutputStream outStream = new ByteArrayOutputStream();
		byte[] buffer = new byte[10240];
		int len = 0;
		while ((len = inStream.read(buffer)) != -1) {
			outStream.write(buffer, 0, len);
		}
		inStream.close();
		return outStream.toByteArray();

	}
}
