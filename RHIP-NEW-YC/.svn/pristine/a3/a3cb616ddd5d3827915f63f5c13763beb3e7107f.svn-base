package com.founder.file.util;

import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

import javax.imageio.ImageIO;

public class ImageUtil {

    public static final String[] IMAGE_TYPE2={".jpg",".png",".bmp",".jpeg"};

	/**
	 * 检查是否是图片文件
	 * 
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
	 * 
	 * @param srcFile
	 */
	public static void createThumbnail(InputStream in, Path path, int imageSize) {
		try {
			BufferedImage bis = ImageIO.read(in);
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
			BufferedImage bid = new BufferedImage(nw, nh, BufferedImage.TYPE_3BYTE_BGR);
			ato.filter(bis, bid);
			ImageIO.write(bid, "jpeg", Files.newOutputStream(path));
		} catch (Exception e) {
			throw new RuntimeException(" Failed in create preview image. Error:  " + e.getMessage());
		}
	}
	
	/**
	 * 调整图片大小
	 * @param in
	 * @param savePath
	 * @param imageSize
	 */
	public static void tuneImage(InputStream in, String savePath, int imageSize) {
		if (in == null || savePath == null) {
			return;
		}
		try {
			File fo = new File(savePath); // dest
			BufferedImage bis = ImageIO.read(in);
			transImage(bis, imageSize, fo);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void transImage(BufferedImage bufferedImage, int imageSize, File destFile) {
		if (bufferedImage == null) {
			return;
		}
		try {
			AffineTransform transform = new AffineTransform();
			int w = bufferedImage.getWidth();
			int h = bufferedImage.getHeight();
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
			ato.filter(bufferedImage, bid);
			ImageIO.write(bid, "jpeg", destFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


}
