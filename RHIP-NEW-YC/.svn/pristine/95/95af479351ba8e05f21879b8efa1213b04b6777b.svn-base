package com.founder.rhip.ehr.repository.child;

import com.founder.fasf.beans.*;
import com.founder.fasf.repository.IDao;
import com.founder.rhip.ehr.dto.womenChild.GravidaReportResultDto;
import com.founder.rhip.ehr.dto.womenChild.GravidaSearchDto;
import com.founder.rhip.ehr.entity.child.WomenChildHealth;
import com.founder.rhip.ehr.entity.child.WomenChildHealthNew;

import java.util.List;
import java.util.Map;

public interface IWomenChildHealthDao extends IDao<WomenChildHealth, String> {

	List<WomenChildHealth> getWomenChildHealthSumList(Criteria criteria);

	PageList<WomenChildHealth> getPageList(Page page);
	
	PageList<WomenChildHealth> queryPageList(Page page, Boolean flg, List<String> orgCodes, Map<String, String> paramMap, Order order, int type);

	PageList<WomenChildHealthNew> selectPageList(Page page, Boolean flg, List<String> orgCodes, Map<String, String> paramMap, Order order, int type);

	PageList<GravidaReportResultDto> searchGravidaReportList(Page page, GravidaSearchDto dto, Order order);

	PageList<Map<String, Object>> searchGravidaReportMapList(Page page, GravidaSearchDto dto, Order order);

	public void updatePersonRecordMove(Parameters parameters, Criteria criteria);
}
