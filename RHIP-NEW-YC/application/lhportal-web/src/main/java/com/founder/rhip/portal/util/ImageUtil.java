package com.founder.rhip.portal.util;

import javax.imageio.ImageIO;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;

public class ImageUtil {

	/**
	 * 检查是否是图片文件
	 * @param fileName
	 * @param imageType
	 * @return
	 */
	public static boolean isImage(String fileName, String imageType[]) {
		for (String type : imageType) {
			if (fileName.endsWith(type)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 图片生成缩略图
	 * @param srcFile
	 */
	public static void createThumbnail(String srcFile, int imageSize) {
		String destFile = getThumbnailPath(srcFile);
		try {
			File fi = new File(srcFile); // src
			File fo = new File(destFile); // dest
			BufferedImage bis = ImageIO.read(fi);
			AffineTransform transform = new AffineTransform();
			int w = bis.getWidth();
			int h = bis.getHeight();
			double scale = (double) w / h;
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
			BufferedImage bid = new BufferedImage(nw, nh,
					BufferedImage.TYPE_3BYTE_BGR);
			ato.filter(bis, bid);
			ImageIO.write(bid, "jpeg", fo);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(
					" Failed in create preview image. Error:  "
							+ e.getMessage());
		}
	}

	/**
	 * 取得缩略图路径
	 * @param srcFile
	 * @return
	 */
	public static String getThumbnailPath(String srcFile) {
		String path = null;
		String fileName = null;
		if (srcFile.contains("/")) {
			path = srcFile.substring(0, srcFile.lastIndexOf('/') + 1);
			fileName = srcFile.substring(srcFile.lastIndexOf('/') + 1);
		} else if (srcFile.contains("\\")) {
			path = srcFile.substring(0, srcFile.lastIndexOf('\\') + 1);
			fileName = srcFile.substring(srcFile.lastIndexOf('\\') + 1);
		}
		fileName = "Thumbnail_" + fileName;
		return path + fileName;
	}

}
