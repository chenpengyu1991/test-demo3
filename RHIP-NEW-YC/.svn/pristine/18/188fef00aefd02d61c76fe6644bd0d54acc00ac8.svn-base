package com.founder.rhip.mdm.repository;

import com.founder.fasf.beans.Criteria;
import com.founder.rhip.mdm.entity.SzdTophoschargeitem;
import com.founder.rhip.mdm.repository.IChargeItemDao;

import org.springframework.stereotype.Repository;

@Repository("mdmChargeItemDao")
public class ChargeItemDao extends MDMRepository<SzdTophoschargeitem, String> implements IChargeItemDao {

	private static final String TABLE_SZD_TOPHOSCHARGEITEM_LOG = "SZD_TOPHOSCHARGEITEM_LOG";
	
	@Override
	public void insertChargeItemLog(Criteria criteria) {
		insertLogRecord(TABLE_SZD_TOPHOSCHARGEITEM_LOG, criteria);
		/*
		if (catalogId == null || catalogId.length == 0) {
			return;
		}
		int maxLength = 1000, srcPos = 0;
		String[] ids = null;
		do {
			int length = (maxLength < (catalogId.length - srcPos)) ? maxLength : (catalogId.length - srcPos);
			ids = new String[length];
			System.arraycopy(catalogId, srcPos, ids, 0, length);
			String itemFields = StringUtil.join(coverPropertiesToFields(properties));
			StringBuilder sb = new StringBuilder();
			sb.append("INSERT INTO SZD_TOPHOSCHARGEITEM_LOG (").append(itemFields).append(") SELECT ").append(itemFields).append(" FROM SZD_TOPHOSCHARGEITEM WHERE CATALOGID IN (")
					.append(StringUtil.join(ids)).append(")");
			execute(sb.toString());
			srcPos += length;
		} while (srcPos < catalogId.length);
		*/
	}

}
