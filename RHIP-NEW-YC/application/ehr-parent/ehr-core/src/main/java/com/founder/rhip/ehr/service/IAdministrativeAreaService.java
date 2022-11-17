package com.founder.rhip.ehr.service;

import java.util.List;

import javax.validation.constraints.NotNull;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Parameters;
import com.founder.rhip.ehr.entity.basic.AdministrativeArea;
import com.founder.rhip.mdm.common.StatusValue;
import com.founder.rhip.mdm.entity.DicItem;

/**
 * @author xu_bin
 */
public interface IAdministrativeAreaService {

    /**
     * get all AdministrativeArea
     *
     * @return list
     */
    public List<AdministrativeArea> getAll();
    
    
    /**
	 * 保存行政村 首先要在字典表中保存
	 * 不清楚这个表的作用 整个系统关于行政村和镇都是从字典表中取数据 唯有健康档案模块
	 * @param dicItem
	 */
	public void saveAdministrativeArea(@NotNull DicItem dicItem);
	
	/**
	 * 更新行政村 首先要在字典表中更新
	 * @param dicItem
	 */
	public void updateAdministrativeArea(@NotNull DicItem dicItem);
	
	/**
	 * 删除行政村 首先要在字典表中删除
	 * @param dicItem
	 */
	public void deleteAdministrativeArea(@NotNull DicItem dicItem);
}
