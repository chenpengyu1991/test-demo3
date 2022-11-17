package com.founder.file.service;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.Objects;
import java.util.Properties;
import java.util.UUID;

import org.apache.commons.lang.time.DateFormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.founder.file.util.ImageUtil;

/**
 * @author liuk
 * @since 14-3-14 下午3:26
 */
public class FileService {

	private final static Logger logger = LoggerFactory.getLogger(FileService.class);

	private String baseFolder;
	private Path base;

	public FileService() {

        try {
            Properties properties=new Properties();
            InputStream in= Thread.currentThread().getContextClassLoader().getResourceAsStream("setting.properties");
            properties.load(in);
            baseFolder= properties.getProperty("fileSaveFolder");
        } catch (IOException e) {
            logger.error("获取文件保存文件夹配置错误");
            throw new RuntimeException("获取文件保存文件夹配置错误",e);
        }

        if(null==baseFolder||baseFolder.trim().length()<1){
            logger.error("文件保存文件夹配置错误");
            throw new RuntimeException("文件保存文件夹配置错误");
        }

        base = Paths.get(baseFolder);
		if (!Files.exists(base)) {
			try {
				Files.createDirectories(base);
			} catch (IOException e) {
                logger.error("文件保存文件夹创建失败",e);
				throw new RuntimeException(e);
			}
		} else if (!Files.isDirectory(base)) {
            logger.error("文件保存文件夹配置错误");
			throw new RuntimeException("文件保存文件夹必须为文件夹");
		}
	}

	public String save(InputStream in,String type, String fileName,boolean thumb,int thumbnailSize) {

        Objects.requireNonNull(in, "输入不能为空");
		Objects.requireNonNull(type, "type不能为空");
		Objects.requireNonNull(fileName, "fileName不能为空");

		String id = null;
		
		try {
			String newFile = getFileName(fileName);
			String folderName = type+File.separator+getFolderName();
			Path folderPath = base.resolve(folderName);
            //如果当前文件不存在,则新建
			if (!Files.exists(folderPath)) {
				Files.createDirectories(folderPath);
			}
            //待保存文件
			Path newPath = folderPath.resolve(newFile);
            //保存文件
			Files.copy(in, newPath);

            //生成缩略图
            if(thumb==true&&ImageUtil.isImage(fileName,ImageUtil.IMAGE_TYPE2)){
                Path thumbPath=folderPath.resolve(buildThumbName(newFile));
                ImageUtil.createThumbnail(Files.newInputStream(newPath),thumbPath, thumbnailSize);
            }

            //生成id
			id = buildId(folderName, newFile);
		} catch (Exception e) {
			logger.error("文件保存失败{}",fileName,e);
            throw  new RuntimeException("文件保存失败",e);
		}
		
		return id;
	}


	public InputStream read(String id) {
        Objects.requireNonNull(id);

        InputStream in=null;

        Path path= base.resolve(id);
        if(!Files.exists(path)){
            logger.error("文件不存在{}",id);
            return in;
        }

        if (Files.isDirectory(path)){
            logger.error("不支持读取文件夹{}",id);
            throw  new RuntimeException("不支持读取文件夹:"+id);
        }

        try {
            in=Files.newInputStream(path);
        } catch (IOException e) {
            logger.error("文件读取失败{}",id,e);
            throw  new RuntimeException("文件读取失败",e);
        }
        return  in;
    }

    public void write(String id,OutputStream out) {
        Objects.requireNonNull(id);
        Objects.requireNonNull(out);

        Path path= base.resolve(id);

        if(!Files.exists(path)){
            logger.error("文件不存在{}",id);
            throw  new RuntimeException("文件不存在:"+id);
        }

        if (Files.isDirectory(path)){
            logger.error("不支持读取文件夹{}",id);
            throw  new RuntimeException("不支持下载文件夹:"+id);
        }

        try {
           Files.copy(path,out);
        } catch (IOException e) {
            logger.error("文件{}写出失败",id,e);
            throw  new RuntimeException("写出失败",e);
        }
    }

    public void delete(String id){
        Objects.requireNonNull(id);
        Path path= base.resolve(id);

        //如果文件不存在,不处理
        if(Files.exists(path)){

            if (Files.isDirectory(path)){
                logger.error("不支持删除文件夹{}",id);
                throw  new RuntimeException("不支持删除文件夹:"+id);
            }

            try {
                Files.delete(path);
                //TODO 删除生成的文件
            } catch (IOException e) {
                logger.error("文件{}删除失败",id,e);
                throw  new RuntimeException("删除失败",e);
            }
        }
    }


    private String buildId(String folderName, String newFile) {
        return folderName + File.separator + newFile;
    }

    private String buildThumbName(String newFile) {
        //TODO prefix config
        return "Thumbnail_"+ newFile;
    }

    private String getFolderName() {
        Date now = new Date();
        String name = DateFormatUtils.format(now, "yyyyMMdd");
        return name;
    }

    private String getFileName(String fileName) {
        UUID uuid = UUID.randomUUID();
        return uuid.toString().replace("-", "") +"_"+ fileName.toLowerCase();
    }
}
