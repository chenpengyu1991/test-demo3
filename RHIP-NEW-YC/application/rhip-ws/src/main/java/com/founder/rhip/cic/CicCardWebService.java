package com.founder.rhip.cic;

import javax.annotation.Resource;
import javax.jws.WebService;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.springframework.stereotype.Service;

import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.ehr.entity.cic.CicCitizenCard;

/**
 * 市民卡管理
 * 
 * @version 1.0, 2014-5-7
 * @author Ye jianfei
 */
@Service("cicCardWebService")
@WebService(serviceName = "cicCardWebService")
public class CicCardWebService extends CicBaseWebService implements ICicCardWebService {
	
	@Resource(name = "cicCardService")
	private ICicCardService cicCardService;
	
	@Override
	public String cardManagement(String cicCardXml) {
		CicResult cicCardResult = new CicResult();
		if (ObjectUtil.isNullOrEmpty(cicCardXml)) {
			cicCardResult.setMessage("传入xml数据为空");
		} else {
            save(cicCardXml,"cicCard");
            CicCitizenCard cicCitizenCard = null;
			try {
				cicCitizenCard = parse(CicCitizenCard.class, cicCardXml);
				dealWithData(cicCitizenCard,cicCardResult);
			} catch (Exception e) {
				logger.error("市民卡接口：" + e, e);
				cicCardResult.setMessage(ExceptionUtils.getStackTrace(e));
			} finally {
				cicCitizenCard = null;
			}
		}
		if(cicCardResult.getCode().equals("2001")){//失败
			logger.error("市民卡接口，交易码："  + cicCardResult.getTranscode() + "," + cicCardResult.getMessage());
		}
		String result =cicCardResult.toXml();
		return result;		
	}
	/**
	 * 处理数据
	 *
	 * @param cardInData
	 * @return
	 * @author Ye jianfei
	 */
	private void dealWithData(CicCitizenCard cicCitizenCard,CicResult cicCardResult){
		String transcode = cicCitizenCard.getTranscode();
		if(StringUtil.isNullOrEmpty(transcode)){
			cicCardResult.setMessage("交易码为空！");
		}else{
			cicCardResult.setTranscode(transcode);
			switch(transcode){
				case CicConstants.BLACKLIST:
					dealWithBlacklist(cicCitizenCard,cicCardResult);
					break;
				case CicConstants.CREATE:
					dealWithCreate(cicCitizenCard,cicCardResult);
					break;	
				case CicConstants.REISSUE:
					dealWithReissue(cicCitizenCard,cicCardResult);
					break;
				case CicConstants.CHANGE:
					dealWithChange(cicCitizenCard,cicCardResult);
					break;
				case CicConstants.USE_COUNT:
					dealWithUseCount(cicCitizenCard,cicCardResult);
					break;
				default:
					cicCardResult.setMessage("交易码错误！：" + transcode);				
					logger.error("市民卡接口:交易码错误");
			}				
		}
	
	}

	/**
	 * 黑名单
	 *
	 * @param cicCitizenCard
	 * @param cicCardResult
	 * @return
	 * @author Ye jianfei
	 */
	private void dealWithBlacklist(CicCitizenCard cicCitizenCard,CicResult cicCardResult){
		boolean checkFlag = checkData(cicCitizenCard,cicCardResult,new String[]{"citizenCardNo","paperType","paperNo","cardStatus","flag","txtDate"});
		if(checkFlag){
			String message = cicCardService.blackCitizenCard(cicCitizenCard);
			if(StringUtil.isNotEmpty(message)){
				cicCardResult.setMessage(message);
			}
		}
	}	
	
	/**
	 * 发卡
	 *
	 * @param cicCitizenCard
	 * @param cicCardResult
	 * @return
	 * @author Ye jianfei
	 */
	private void dealWithCreate(CicCitizenCard cicCitizenCard,CicResult cicCardResult){
		/**
		 * 参数验证
		 */
		boolean checkFlag = checkData(cicCitizenCard,cicCardResult,new String[]{"paperType","paperNo","citizenCardNo"
				,"name","releaseDate","corpName"
				,"phone","prAddr","birthday","gender"});
		if(checkFlag){
			String message = cicCardService.createCitizenCard(cicCitizenCard);
			if(StringUtil.isNotEmpty(message)){
				cicCardResult.setMessage(message);
			}
		}
	}	
	
	/**
	 * 补卡
	 *
	 * @param cicCitizenCard
	 * @param cicCardResult
	 * @return
	 * @author Ye jianfei
	 */
	private void dealWithReissue(CicCitizenCard cicCitizenCard,CicResult cicCardResult){
		/**
		 * 参数验证
		 */
		boolean checkFlag = checkData(cicCitizenCard,cicCardResult,new String[]{"paperType","paperNo","citizenCardNo"
				,"oldCitizenCardNo","name","txtDate"});		
		if(checkFlag){
			String message = cicCardService.reissueCitizenCard(cicCitizenCard);
			if(StringUtil.isNotEmpty(message)){
				cicCardResult.setMessage(message);
			}
		}
	}	
	
	/**
	 * 换卡
	 *
	 * @param cicCitizenCard
	 * @param cicCardResult
	 * @return
	 * @author Ye jianfei
	 */
	private void dealWithChange(CicCitizenCard cicCitizenCard,CicResult cicCardResult){
		/**
		 * 参数验证
		 */
		boolean checkFlag = checkData(cicCitizenCard,cicCardResult,new String[]{"paperType","paperNo","citizenCardNo"
				,"oldCitizenCardNo","name","txtDate"});			
		if(checkFlag){
			String message = cicCardService.changeCitizenCard(cicCitizenCard);
			if(StringUtil.isNotEmpty(message)){
				cicCardResult.setMessage(message);
			}
		}
	}

	/**
	 * 市民卡使用次数
	 *
	 * @param cicCitizenCard
	 * @param cicCardResult
	 * @return
	 * @author Ye jianfei
	 */
	private void dealWithUseCount(CicCitizenCard cicCitizenCard,CicResult cicCardResult){
		/**
		 * 参数验证
		 */
		boolean checkFlag = checkData(cicCitizenCard,cicCardResult,new String[]{"starDate","endDate"});			
		if(checkFlag){
			int count = cicCardService.getUseCount(cicCitizenCard.getStarDate(), cicCitizenCard.getEndDate());
			if(ObjectUtil.isNotEmpty(count)){
				cicCardResult.setRtnrst(count);
			}
		}else{
			cicCardResult.setRtnrst(0);
		}
	}
	
	
	private boolean checkData(CicCitizenCard cicCitizenCard,CicResult cicCardResult,String...properties) {
		boolean result = true;
		String message = validateModel(cicCitizenCard,properties);
		if(StringUtil.isNotEmpty(message)){
			cicCardResult.setMessage(message);
			result = false;
		}
		if(CicConstants.PAPERTYPE.equals(cicCitizenCard.getPaperType())){//如果是身份证
			result &= checkIdacrd(cicCitizenCard.getPaperNo(),cicCardResult,"身份证号码");
		}
		return result;
	}
}
