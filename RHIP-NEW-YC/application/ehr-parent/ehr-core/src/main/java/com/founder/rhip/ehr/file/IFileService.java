package com.founder.rhip.ehr.file;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;

/**
 * @author liuk
 * @since 14-3-15 上午11:08
 */
public interface IFileService {

    /**
     *
     * 保存文件 保存失败不抛出异常,返回null
     *
     * @param inputStream the input stream
     * @param type the type
     * @param fileName the file name
     * @return the string
     */
    String trySave(InputStream inputStream,String type,String fileName,boolean thumb,Integer thumbnailSize);

    OutputStream tryRead(String id);

    boolean tryDelete(String id);

     URI tryGetDownloadLink(String fileName,String id);

    URI tryGetPreviewLink(String fileName,String id);
}
