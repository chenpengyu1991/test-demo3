package com.founder.rhip.ncp.repository;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.repository.IDao;
import com.founder.rhip.ncp.dto.FollowDto;

import java.util.Map;

public interface IFollowListDao extends IDao<FollowDto, String> {

   PageList<FollowDto> searchFollowList(Page page, Criteria criteria);

   Map<String, Object> searchQuickCnt(Criteria ca);
}
