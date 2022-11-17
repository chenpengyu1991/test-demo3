package com.founder.rhip.mdm.app;

import com.founder.fasf.beans.Record;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.mdm.entity.EntityType;
import com.founder.rhip.mdm.service.IChargeItemService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service("chargeItemsApp")
public class ChargeItemsApp extends MDMBaseApp implements IChargeItemsApp {

	@Resource(name = "mdmChargeItemService")
	private IChargeItemService chargeItemService;

	/**
	 * 同步收费项字典
	 * @param   item
	 * @return  int
	 */
	@Override
	public int synchronizeChargeItems(Map<String, Object> item) throws CheckException {
		List<String> messageList = new ArrayList<>();
		Record record = new Record();
		record.putAll(item);
		checkAll(messageList, record, EntityType.SZD_TOPHOSCHARGEITEM);
		if (ObjectUtil.isNotEmpty(messageList)) {
			throw getCheckException(messageList);
		}
		// upload
		try {
			return chargeItemService.syncChargeItem(item);
		} catch (Exception e) {
			log.error("数据同步出错", e);
			throw new CheckException(e);
		}
	}
}
