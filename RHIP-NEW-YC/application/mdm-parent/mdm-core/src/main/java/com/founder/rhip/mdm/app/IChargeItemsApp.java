package com.founder.rhip.mdm.app;

import java.util.List;
import java.util.Map;

public interface IChargeItemsApp {

	/**
	 * 同步收费项字典
	 * @param   item
	 * @return  int
	 */
	public int synchronizeChargeItems(Map<String, Object> item) throws CheckException;
}
