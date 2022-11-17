package com.founder.rhip.ehr.controller;

import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.founder.rhip.BaseController;
import com.founder.rhip.ehr.common.FileUtils;

/**
 * 文件上传
 * 
 * @author GaoFei
 *
 */
@Controller
@RequestMapping(value = "/showImage")
public class ShowImageController extends BaseController {
	
	@RequestMapping("/showAsImage")
	public void showAsImage(String fileSource, HttpServletResponse response) {
		String[] fs=fileSource.split(":");
		String originalFilePath = FileUtils.getRealPath(fs[0],fs[1]);
		
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

    @RequestMapping("/showPortalImage")
    public void showPortalImage(String fileSource, HttpServletResponse response) {
        try {
            String[] fs = fileSource.split(":");
            String file=fs[1];
            //TODO 强制修正为子目录防止安全问题,配置
            if (file.startsWith("upload/")){
                String originalFilePath = FileUtils.getRealPath("default", file);
                InputStream in = new FileInputStream(originalFilePath);
                BufferedImage bufferedImage = ImageIO.read(in);
                OutputStream outputStream = response.getOutputStream();
                ImageIO.write(bufferedImage, StringUtils.substringAfterLast(originalFilePath, "."), outputStream);
                outputStream.flush();
                outputStream.close();
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
    }


    @RequestMapping("/showUeImage")
	public void showUeImage(String fileSource, HttpServletResponse response) {
		String[] fs=fileSource.split(":");
		String originalFilePath = FileUtils.getRealPath(fs[0],fs[1]);
		
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
}
