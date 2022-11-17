package com.founder.rhip.ehr.service.woman;

import java.util.List;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.rhip.ehr.dto.MaternalHealthManage;
import com.founder.rhip.ehr.entity.women.PrenatalFollowup;
import com.founder.rhip.ehr.entity.women.PrenatalFollowupOther;

/**
 * Created by jianghaiying on 17-3-23.
 */
public interface IPrenatalFollowupService {

    public PageList<PrenatalFollowup> getPrenatalFollowupList(Criteria criteria, Page page);

    public PrenatalFollowup getPrenatalFollowup(Criteria criteria);

    public void savePrenatalFollowup(PrenatalFollowup prenatalFollowup);

    public int deletePrenatalFollowup(Long prenatalFollowupId);

    public PageList<PrenatalFollowupOther> getPrenatalFollowupOtherList(Criteria criteria, Page page);

    public PrenatalFollowupOther getPrenatalFollowupOther(Criteria criteria);

    public void savePrenatalFollowupOther(PrenatalFollowupOther PrenatalFollowupOther);

    public int deletePrenatalFollowupOther(Long prenatalFollowupOtherId);

    public List<PrenatalFollowup> getList(Criteria criteria);

    public Integer getPrenataFollNum(Integer year,Integer quarter,String orgCode);

	public List<MaternalHealthManage> getMaternalHealthManage(Integer year, Integer quarter, List<String> organCodeList);

}
