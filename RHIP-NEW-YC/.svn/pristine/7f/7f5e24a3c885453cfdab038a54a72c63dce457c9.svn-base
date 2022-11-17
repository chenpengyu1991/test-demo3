package com.founder.rhip.cic;

import java.util.Date;
import java.util.List;

import com.founder.rhip.ehr.entity.cic.CicCitizenCard;

/**
 * 市民卡管理SERVICE接口
 * 
 * @version 1.0, 2014-3-7
 * @author Ye jianfei
 */
public interface ICicCardService {
	
	/**
	 * 黑名单
	 *
	 * @param cicCitizenCard
	 * @return
	 * @author Ye jianfei
	 */
	public String blackCitizenCard(CicCitizenCard cicCitizenCard);
	/**
	 * 发卡
	 *
	 * @param cicCitizenCard
	 * @return
	 * @author Ye jianfei
	 */
	public String createCitizenCard(CicCitizenCard cicCitizenCard);
	
	/**
	 * 补卡
	 *
	 * @param cicCitizenCard
	 * @return
	 * @author Ye jianfei
	 */
	public String reissueCitizenCard(CicCitizenCard cicCitizenCard);
	
	/**
	 * 换卡
	 *
	 * @param cicCitizenCard
	 * @return
	 * @author Ye jianfei
	 */
	public String changeCitizenCard(CicCitizenCard cicCitizenCard);	
	
	/**
	 * 市民卡使用次数
	 *
	 * @param startDate
	 * @param endDate
	 * @return
	 * @author Ye jianfei
	 */
	public int getUseCount(Date startDate,Date endDate);
	
	/**
	 * 批量导入市民卡数据
	 *
	 * @param card
	 * @return
	 * @author Ye jianfei
	 */
	public String importCitizenCard(CicCitizenCard card);
}