package com.founder.rhip.he.service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.rhip.ehr.entity.healtheducation.HeMedia;

import javax.print.attribute.standard.Media;
import java.util.Map;

/**
 * 健康教育下的影像播放 add by Kevin Ro 2018-07-16
 */
public interface IHeMediaService {

    /**
     * 分页查询
     * @param criteria
     * @param page
     * @return
     */
    public PageList<HeMedia> getMediaPageList(Criteria criteria, Page page);

    /**
     * 删除
     * @param ids
     * @return
     */
    public int deleteMedia(Long... ids);

    /**
     * 查询单个影像
     * @param criteria
     * @return
     */
    public HeMedia getMedia(Criteria criteria);

    /**
     * 保存影像
     * @param media
     * @return
     */
    public int saveMedia(HeMedia media, Map<String, String> map,Map<String, String> filenameMap);

    /**
     * 更新影像
     * @param media
     * @return
     */
    public int updateMedia(HeMedia media, Map<String, String> map,Map<String, String> filenameMap,String...properties);

}
