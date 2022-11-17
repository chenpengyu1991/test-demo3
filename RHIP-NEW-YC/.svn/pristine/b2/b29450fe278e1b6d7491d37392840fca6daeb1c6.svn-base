package com.founder.rhip.ehr.service;

import java.util.List;

import javax.annotation.Resource;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Parameters;
import com.founder.fasf.service.AbstractService;
import com.founder.rhip.ehr.entity.basic.AdministrativeArea;
import com.founder.rhip.ehr.repository.basic.IAdministrativeAreaDao;
import com.founder.rhip.mdm.common.StatusValue;
import com.founder.rhip.mdm.entity.DicItem;
import com.founder.rhip.mdm.service.IDictionaryService;

@Service("administrativeAreaService")
public class AdministrativeAreaServiceImpl extends AbstractService implements
		IAdministrativeAreaService {

	@Resource(name = "administrativeAreaDao")
	private IAdministrativeAreaDao administrativeAreaDao;

	@Resource(name="mdmDictionaryService")
	private IDictionaryService dictionaryService;
	
	@Override
	public List<AdministrativeArea> getAll() {
		return administrativeAreaDao.getAll();
	}
	
	/**
	 * 保存行政村 首先要在字典表中保存
	 * 不清楚这个表的作用 整个系统关于行政村和镇都是从字典表中取数据 唯有健康档案模块
	 * @param dicItem
	 */
	public void saveAdministrativeArea(@NotNull DicItem dicItem) {
		dictionaryService.createDicItem(dicItem);
		AdministrativeArea administrativeArea = new AdministrativeArea();
		administrativeArea.setGbcode(dicItem.getItemCode());
		administrativeArea.setAreaName(dicItem.getItemName());
		administrativeAreaDao.insert(administrativeArea);
	}
	
	/**
	 * 更新行政村 首先要在字典表中更新
	 * @param dicItem
	 */
	public void updateAdministrativeArea(@NotNull DicItem dicItem) {
		AdministrativeArea administrativeArea = administrativeAreaDao.get(new Criteria("GBCODE", dicItem.getItemCode()));
		administrativeArea.setGbcode(dicItem.getItemCode());
		administrativeArea.setAreaName(dicItem.getItemName());
		dictionaryService.updateDicItem(dicItem);
		administrativeAreaDao.update(administrativeArea);
	}
	
	/**
	 * 删除行政村 首先要在字典表中删除
	 * @param dicItem
	 */
	public void deleteAdministrativeArea(@NotNull DicItem dicItem) {
		dictionaryService.updateDicItem(dicItem);
		administrativeAreaDao.update(new Parameters("IS_DELETE", StatusValue.deleteValue.getValue()), new Criteria("GBCODE", dicItem.getItemCode()));
	}
	
}
