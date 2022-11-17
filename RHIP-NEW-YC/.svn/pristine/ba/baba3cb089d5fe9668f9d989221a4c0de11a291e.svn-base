package com.founder.rhip.ehr.file;

import org.apache.http.client.utils.URIBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collections;

/**
 * 远程文件调用
 * @author liuk
 * @since 14-3-15 上午11:15
 */
//@Component
public class RemoteFileService implements IFileService {

	@Autowired
	private Https https;

	private final static Logger logger = LoggerFactory.getLogger(RemoteFileService.class);

    @Value("${fileServerAdd}")
	private String add;

    @Value("${fileServerDelete}")
    private String delete;

    @Value("${fileServerDownload}")
    private String download;

    @Value("${fileServerPreview}")
    private String preview;

    @Value("${fileServerHost}")
	private String host;

    @Value("${fileServerConnectionTimeout}")
    private  int connectTimeout;

    private int defaultThumbnailSize=120;

	@Override
	public String trySave(InputStream inputStream, String type, String fileName,boolean thumb,Integer thumbnailSize) {
		String id = null;
		try {
			URIBuilder builder = new URIBuilder(host+add);
            builder.addParameter("type",type);
			builder.addParameter("fileName", fileName);
            if (thumb){
                if(null==thumbnailSize){
                    thumbnailSize=defaultThumbnailSize;
                }
                builder.addParameter("thumbnailSize", String.valueOf(thumbnailSize));
            }
			URI uri = builder.build();
			id = https.postStream(uri, inputStream, 0);
		} catch (URISyntaxException e) {
			logger.error("url错误", e);
		} catch (Exception e) {
			logger.error("未知错误", e);
		}
		return id;
	}

	@Override
	public OutputStream tryRead(String id) {
		return null;
	}

    @Override
    public  boolean tryDelete(String id){
        try {
            URIBuilder builder = new URIBuilder(host+delete);
            builder.addParameter("id",id);
            URI uri = builder.build();
            https.postForm(uri, Collections.<String, String>emptyMap(), 0);
        } catch (URISyntaxException e) {
            logger.error("url错误", e);
        } catch (Exception e) {
            logger.error("未知错误", e);
        }
        return true;
    }

    @Override
    public URI tryGetDownloadLink(String fileName,String id){
        URI uri=null;
        try {
            URIBuilder builder = new URIBuilder(host+download);
            builder.addParameter("id",id);
            builder.addParameter("fileName", fileName);
            uri=  builder.build();
        } catch (Exception e) {
            logger.error("",e);
        }
        return uri;
    }

    @Override
    public URI tryGetPreviewLink(String fileName,String id){
        URI uri=null;
        try {
            URIBuilder builder = new URIBuilder(host+preview);
            builder.addParameter("id",id);
            builder.addParameter("fileName", fileName);
            uri=  builder.build();
        } catch (Exception e) {
            logger.error("",e);
        }
        return uri;
    }
}
