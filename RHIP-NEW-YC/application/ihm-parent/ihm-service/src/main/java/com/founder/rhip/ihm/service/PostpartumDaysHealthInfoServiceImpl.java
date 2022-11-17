package com.founder.rhip.ihm.service;

import com.founder.fasf.beans.Criteria;
import com.founder.rhip.ehr.entity.women.PostnatalFollowup;
import com.founder.rhip.ehr.entity.women.PostpartumDaysHealthInfo;
import com.founder.rhip.ehr.repository.women.IPostpartumDaysHealthInfoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by f on 2017/3/28.
 */
@Service("postpartumDaysHealthInfoService")
public class PostpartumDaysHealthInfoServiceImpl implements IPostpartumDaysHealthInfoService{

    @Autowired
    private IPostpartumDaysHealthInfoDao postpartumDaysHealthInfoDao;

    @Override
    public PostpartumDaysHealthInfo getPostpartumDaysHealthInfo(Criteria criteria) {
        return postpartumDaysHealthInfoDao.get(criteria);
    }

    @Override
    public void addPostpartumDaysHealthInfo(PostpartumDaysHealthInfo postpartumDaysHealthInfo) {
        postpartumDaysHealthInfoDao.insert(postpartumDaysHealthInfo);

    }

    @Override
    public int updatePostpartumDaysHealthInfo(PostpartumDaysHealthInfo postpartumDaysHealthInfo) {
        return postpartumDaysHealthInfoDao.update(postpartumDaysHealthInfo);
    }

    @Override
    public void deletePostpartumDaysHealthInfo(Criteria criteria) {
        postpartumDaysHealthInfoDao.delete(criteria);
    }
}
