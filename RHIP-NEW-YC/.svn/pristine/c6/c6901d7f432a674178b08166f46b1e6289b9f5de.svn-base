package com.founder.rhip.he.service;


import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Order;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.service.AbstractService;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.common.ImageUtil;
import com.founder.rhip.ehr.common.ResourceCategory;
import com.founder.rhip.ehr.entity.basic.UploadInfoRecord;
import com.founder.rhip.ehr.entity.healtheducation.HeMedia;
import com.founder.rhip.ehr.repository.basic.IUploadInfoRecordDao;
import com.founder.rhip.ehr.repository.healtheducation.IHeMediaDao;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.print.attribute.standard.Media;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service("heMediaService")
public class HeMediaServiceImpl extends AbstractService implements IHeMediaService {

    @Resource(name = "heMediaDao")
    private IHeMediaDao heMediaDao;


    @Resource(name = "uploadInfoRecordDao")
    private IUploadInfoRecordDao uploadInfoRecordDao;

    private static final String[] IMAGE_TYPE = new String[] {"jpg", "jpeg", "png", "bmp"};

    @Override
    public PageList<HeMedia> getMediaPageList(Criteria criteria, Page page) {
        Order order=new Order("FILL_DATE",false);
        order.desc("ID");
        return heMediaDao.getPageList(page, criteria, order);
    }

    @Override
    public int deleteMedia(Long... ids) {
        return heMediaDao.delete(ids);
    }

    @Override
    public HeMedia getMedia(Criteria criteria) {
        return heMediaDao.get(criteria);
    }

    @Override
    public int saveMedia(HeMedia media, Map<String, String> map,Map<String, String> filenameMap) {
        Long id = heMediaDao.generatedKey(media, "ID", null).longValue();
        // 附件
        if (ObjectUtil.isNotEmpty(map)) {
            List<UploadInfoRecord> uploadInfoRecords = new ArrayList<>();
            for (String uuid : map.keySet()) {
                String originalFilePath = map.get(uuid);
                UploadInfoRecord uploadInfoRecord = new UploadInfoRecord();
                uploadInfoRecord.setResourceId(id);
                uploadInfoRecord.setOriginalFilePath(originalFilePath);
                uploadInfoRecord.setOriginalFileName(filenameMap.get(uuid));//设置附件名字
                String suffixName = StringUtils.substringAfterLast(filenameMap.get(uuid), ".");//设置文件类型
                if (ArrayUtils.contains(IMAGE_TYPE, StringUtils.lowerCase(suffixName))) {
                    uploadInfoRecord.setFileType("image");//设置文件类型
                }
                //StringBuilder sb = new StringBuilder(StringUtils.substringBeforeLast(originalFilePath, "\\")).append(Constants.THUMBNAIL).append(StringUtils.substringAfterLast(originalFilePath, "\\"));
                //uploadInfoRecord.setThumbnailPath(sb.toString()); // 缩略图地址
                uploadInfoRecord.setThumbnailPath(ImageUtil.getThumbnailPath(originalFilePath)); // 缩略图地址
                uploadInfoRecord.setFileResource(ResourceCategory.HEALTH_RESOURCE_VIDEO.getCode());
                uploadInfoRecord.setCreateTime(new Date());
                uploadInfoRecord.setCreater(media.getResourceCreater());
                uploadInfoRecords.add(uploadInfoRecord);
            }
            uploadInfoRecordDao.batchInsert(uploadInfoRecords);
        }
        return id.intValue();
    }

    @Override
    public int updateMedia(HeMedia media, Map<String, String> map,Map<String, String> filenameMap,String... properties) {
        int rs =heMediaDao.update(media,properties);
        // 附件
        if (ObjectUtil.isNotEmpty(map)) {
            List<UploadInfoRecord> uploadInfoRecords = new ArrayList<>();
            for (String uuid : map.keySet()) {
                String originalFilePath = map.get(uuid);
                UploadInfoRecord uploadInfoRecord = new UploadInfoRecord();
                uploadInfoRecord.setResourceId(media.getId());
                uploadInfoRecord.setOriginalFilePath(originalFilePath);
                uploadInfoRecord.setOriginalFileName(filenameMap.get(uuid));//设置附件名字
                String suffixName = StringUtils.substringAfterLast(filenameMap.get(uuid), ".");//设置文件类型
                if (ArrayUtils.contains(IMAGE_TYPE, StringUtils.lowerCase(suffixName))) {
                    uploadInfoRecord.setFileType("image");//设置文件类型
                }
                //StringBuilder sb = new StringBuilder(StringUtils.substringBeforeLast(originalFilePath, "\\")).append(Constants.THUMBNAIL).append(StringUtils.substringAfterLast(originalFilePath, "\\"));
                //uploadInfoRecord.setThumbnailPath(sb.toString()); // 缩略图地址
                uploadInfoRecord.setThumbnailPath(ImageUtil.getThumbnailPath(originalFilePath)); // 缩略图地址
                uploadInfoRecord.setFileResource(ResourceCategory.HEALTH_RESOURCE_VIDEO.getCode());
                uploadInfoRecord.setCreateTime(new Date());
                uploadInfoRecord.setCreater(media.getResourceCreater());
                uploadInfoRecords.add(uploadInfoRecord);
            }
            uploadInfoRecordDao.batchInsert(uploadInfoRecords);
        }
        return rs;
    }
}
