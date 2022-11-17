package com.founder.rhip.cdm.service;

import com.founder.rhip.ehr.entity.management.DmPopulaceInfo;
import com.founder.rhip.mdm.entity.DicItem;

import java.util.List;

/**
 * 人口数据
 * 
 * @author liuk
 * 
 */
public interface IPopulaceInfoService {

	List<DmPopulaceInfo> searchPopulaceInfo();

	List<DmPopulaceInfo> buildPopulaceInfo(Integer countYear, List<DicItem> items);

	boolean saveOrUpdatePopulaceInfo(List<DmPopulaceInfo> dmPopulaceInfo);

	DmPopulaceInfo getTotalCountByYear(String year);

}
