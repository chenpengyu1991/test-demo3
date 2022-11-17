package com.founder.rhip.ehr.service.export;

import java.util.Map;

/**
 * 单元格值获取器
 * @author liuk
 *
 */
public interface IValueGetter {
	public String get(ItemDefinition itemDefinition, Map<String, Object> data);
}
