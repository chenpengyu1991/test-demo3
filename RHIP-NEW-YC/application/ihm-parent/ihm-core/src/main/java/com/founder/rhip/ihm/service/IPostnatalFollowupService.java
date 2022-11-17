package com.founder.rhip.ihm.service;

import com.founder.fasf.beans.Criteria;
import com.founder.rhip.ehr.entity.women.PostnatalFollowup;

import java.util.List;

/**
 * Created by yuanzg on 2017/3/28.
 */
public interface IPostnatalFollowupService {

    public PostnatalFollowup getPostnatalFollowup(Criteria criteria);

    public void addPostnatalFollowup(PostnatalFollowup postnatalFollowup);

    public int updatePostnatalFollowup(PostnatalFollowup postnatalFollowup);

    public void deletePostnatalFollowup(Criteria criteria);

    public List<PostnatalFollowup> getlist(Criteria criteria);

    public List<PostnatalFollowup> getPostnatalFollNum(Integer year,Integer quarter,String orgCode);
}
