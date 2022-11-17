package com.founder.rhip.ehr.service.child;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Order;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.rhip.ehr.entity.basic.User;
import com.founder.rhip.ehr.entity.child.ChildHealthExamination;
import com.founder.rhip.mdm.entity.Organization;

import java.util.List;

/**
 * Created by jingqiu on 17-3-23.
 */
public interface IChildHealthExamineService {

    public PageList<ChildHealthExamination> getPagedChildInfo(Page page, Criteria criteria, String examineAgeGroup);

    public List<ChildHealthExamination> getChildHealthExamList(Criteria criteria);

    public List<ChildHealthExamination> getChildHealthExamList(Criteria criteria, Order order);

    public List<ChildHealthExamination> getChildHealthExamList(String examineAgeGroup, String babyCardNo, String idCard);

    public ChildHealthExamination getChildHealthExam(Criteria criteria);

    public int addChildHealthExam(ChildHealthExamination examination, Organization organization, User user);

    public int addChildrenEchExam(ChildHealthExamination examination);

    public int updateChildHealthExam(ChildHealthExamination examination);

    public int deleteChildHealthExam(Integer id);

    public PageList<ChildHealthExamination> getPageChildExamine(Criteria criteria, Page page, Order order);

}
