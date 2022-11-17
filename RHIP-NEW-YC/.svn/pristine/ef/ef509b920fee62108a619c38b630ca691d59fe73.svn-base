package com.founder.rhip.ehr.file;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.nio.charset.CodingErrorAction;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.config.ConnectionConfig;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.InputStreamEntity;
import org.apache.http.entity.SerializableEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * http工具
 * 
 * @author liuk
 * @since 2014年3月14日 23:41:27
 *
 */
//@Component
public class Https {

	private final static Logger logger = LoggerFactory.getLogger(Https.class);

	private PoolingHttpClientConnectionManager connManager = null;
	private CloseableHttpClient httpClient = null;
    private  int connectTimeout = 5000;
    @Value("${fileServerConnectionPoolSize}")
	private  int total = 20;

	@PreDestroy
	private void destroy() {
		if (null != httpClient) {
			try {
				httpClient.close();
				httpClient = null;
				connManager.close();
				connManager = null;
			} catch (Exception e) {
				logger.error("", e);
			}
		}
		;
	}

	@PostConstruct
	private void init() {
		try {

			Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder.<ConnectionSocketFactory> create().register("http", PlainConnectionSocketFactory.INSTANCE).build();
			connManager = new PoolingHttpClientConnectionManager(socketFactoryRegistry);
			httpClient = HttpClients.custom().setConnectionManager(connManager).build();
			ConnectionConfig connectionConfig = ConnectionConfig.custom().setMalformedInputAction(CodingErrorAction.IGNORE).setUnmappableInputAction(CodingErrorAction.IGNORE).setCharset(Consts.UTF_8).build();
			connManager.setDefaultConnectionConfig(connectionConfig);

			// 只有一个server
			connManager.setMaxTotal(total);
			connManager.setDefaultMaxPerRoute(total);
		} catch (Exception e) {
			throw new RuntimeException("https init error", e);
		}
	}

	public String postStream(URI uri, InputStream in, int timeout) {
		Objects.requireNonNull(in);
		HttpEntity entity = new InputStreamEntity(in, ContentType.APPLICATION_OCTET_STREAM);
		return doPost(uri,entity,timeout);
	}

    public String postForm(URI uri, Map<String,String> form, int timeout) {
        Objects.requireNonNull(form);
        int size=form.size();
        HttpEntity entity = null;
        if(size>0){
            List<NameValuePair> list=new ArrayList<>(form.size());
            for(Map.Entry<String,String> entry :form.entrySet()){
                list.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
            }
            try {
                entity = new UrlEncodedFormEntity(list);
            } catch (UnsupportedEncodingException e) {
                throw new RuntimeException("不支持的参数", e);
            }
        }
        return doPost(uri,entity,timeout);
    }


    private String doPost(URI uri,HttpEntity entity , int timeout) {
        Objects.requireNonNull(uri);

        String id = null;
        HttpPost post = null;

        try {
            if (timeout < 0) {
                timeout = connectTimeout;
            }

            post = new HttpPost(uri);
            RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(timeout).setConnectTimeout(timeout).setConnectionRequestTimeout(timeout).setExpectContinueEnabled(false).build();
            post.setConfig(requestConfig);
            if(null!=entity){
                post.setEntity(entity);
            }
            try (CloseableHttpResponse response = httpClient.execute(post)) {
                HttpEntity responseEntity = response.getEntity();
                try {
                    if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                        if (responseEntity != null) {
                            id = EntityUtils.toString(responseEntity, Consts.UTF_8);
                        }
                    } else {
                        logger.error(response.toString());
                        logger.error( EntityUtils.toString(responseEntity, Consts.UTF_8));
                    }
                } finally {
                    if (entity != null) {
                        entity.getContent().close();
                    }
                }
            }
        } catch (UnsupportedEncodingException e) {
            logger.error("UnsupportedEncodingException", e);
        } catch (Exception e) {
            logger.error("Exception", e);
        } finally {
            post.releaseConnection();
        }
        return id;
    }

}
