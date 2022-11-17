package com.founder.rhip.mdm.service;

import java.util.List;
import java.util.Map;

import com.founder.fasf.beans.Criteria;

public interface IExplorerSetService {
	/**
	 * 查询设置列表
	 * @param criteria 查询条件
	 * @return
	 */
	Map<String, List<String>> getExplorerSetMap(Criteria criteria);

	/**
	 * 保存设置结果
	 * @param setRet 设置类型（个人信息、近期体征、既往史：1，医疗保健活动：2，检查、检验：3，用药情况：4）
	 * @return true或者false
	 */
	Boolean saveSetResult(String setRet);
}
