package com.founder.rhip.ehr.repository.mongo;

import com.founder.fasf.util.ObjectUtil;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.gridfs.GridFSDBFile;
import com.mongodb.gridfs.GridFSFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

public abstract class GridFsDao
{
    @Autowired
    protected GridFsTemplate gridFsTemplate;

    /**
     * 保存一个对象
     *
     * @author http://www.chisalsoft.com
     */
    public String save(InputStream inputStream, String fileName, String contentType, Date createDate)
    {
        String fileId = null;
        DBObject metaData = new BasicDBObject();
        metaData.put("createdDate", createDate);
        metaData.put("fileName", fileName);
        GridFSFile gridFSFile = gridFsTemplate.store(inputStream,fileName,contentType,metaData);
        if(ObjectUtil.isNotEmpty(gridFSFile)){
            fileId = gridFSFile.getId().toString();
        }
        return fileId;
    }
    public void removeFile(Object id) {
        this.gridFsTemplate.delete(new Query().addCriteria(Criteria.where("_id").is(id)));
    }

    public GridFSDBFile getFileById(Object id) {
        GridFSDBFile file = null;
        List<GridFSDBFile> result = this.gridFsTemplate.find(new Query().addCriteria(Criteria.where("_id").is(id)));
        if (result != null || result.size() > 0) {
            file = result.get(0);
        }
        return file;
    }
}