package com.founder.rhip.ihm.service;

import com.founder.fasf.beans.Criteria;
import com.founder.rhip.ehr.entity.women.PostnatalFollowup;
import com.founder.rhip.ehr.repository.women.IPostnatalFollowupDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by yuanzg on 2017/3/28.
 */
@Service("postnatalFollowupService")
public class PostnatalFollowupServiceImpl implements IPostnatalFollowupService{
    @Autowired
    private IPostnatalFollowupDao postnatalFollowupDao;

    @Override
    public PostnatalFollowup getPostnatalFollowup(Criteria criteria) {
        return postnatalFollowupDao.get(criteria);
    }

    @Override
    public void addPostnatalFollowup(PostnatalFollowup postnatalFollowup) {
        postnatalFollowupDao.insert(postnatalFollowup);
    }

    @Override
    public int updatePostnatalFollowup(PostnatalFollowup postnatalFollowup) {
        return postnatalFollowupDao.update(postnatalFollowup);
    }

    @Override
    public void deletePostnatalFollowup(Criteria criteria) {
        postnatalFollowupDao.delete(criteria);
    }

    @Override
    public List<PostnatalFollowup> getlist(Criteria criteria) {
        return postnatalFollowupDao.getList(criteria);
    }

    public List<PostnatalFollowup> getPostnatalFollNum(Integer year,Integer quarter,String orgCode){
        return postnatalFollowupDao.getPostnatalFollNum(year,quarter,orgCode);
    }
}
