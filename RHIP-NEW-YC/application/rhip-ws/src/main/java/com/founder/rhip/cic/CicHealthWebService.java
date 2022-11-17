package com.founder.rhip.cic;

import javax.annotation.Resource;
import javax.jws.WebService;
import org.springframework.stereotype.Service;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.ehr.entity.cic.CicTarget;
/**
 * 基础健康数据接口
 * 
 * @version 1.0, 2014-5-9
 * @author Ye jianfei
 */
@Service("cicHealthWebService")
@WebService(serviceName = "cicHealthWebService")
public class CicHealthWebService extends CicBaseWebService implements ICicHealthWebService {
	
	@Resource(name = "cicHealthService")
	private ICicHealthService cicHealthService;
	
	@Override
	public String healthData(String searchXml) {
		CicResult cicHealthResult = new CicResult();
		String result ="";
		if (ObjectUtil.isNullOrEmpty(searchXml)) {
			cicHealthResult.setMessage("传入xml数据为空");
			result = marshal(cicHealthResult);
		} else {
            save(searchXml,"cicHealth");
            CicHealthIn cicHealthIn = null;
			try {
				cicHealthIn = parse(CicHealthIn.class, searchXml);
				result = dealWithData(cicHealthIn,cicHealthResult);
			} catch (Exception e) {
				logger.error("基础健康数据接口：" + e, e);
				cicHealthResult.setMessage(e.getMessage());
				result = marshal(cicHealthResult);
			} finally {
				cicHealthIn = null;
			}
		}
		if(cicHealthResult.getCode().equals("2001")){//失败
			logger.error("基础健康数据接口，交易码：" + cicHealthResult.getTranscode() + "," + cicHealthResult.getMessage());
		}
		return result;		
	}
	
	/**
	 * 处理数据
	 *
	 * @param cicHealthIn
	 * @param cicHealthResult
	 * @return
	 * @author Ye jianfei
	 */
	private String dealWithData(CicHealthIn cicHealthIn,CicResult cicHealthResult){
		String result = "";
		String transcode = cicHealthIn.getTranscode();
		if(StringUtil.isNullOrEmpty(transcode)){
			cicHealthResult.setMessage("交易码为空！");
			result = marshal(cicHealthResult);
		}else{
			cicHealthResult.setTranscode(transcode);
			switch(transcode){
				case CicConstants.HEALTH_DATA:
					result = dealWithHealthData(cicHealthIn,cicHealthResult);
					break;
				case CicConstants.CARD_WRITE_STATUS:
					result = dealWithCardWriteStatus(cicHealthIn,cicHealthResult);
					break;	
				default:
					cicHealthResult.setMessage("交易码错误！：" + transcode);
					result = marshal(cicHealthResult);
			}				
		}
		return result;
	
	}
	
	private String dealWithHealthData(CicHealthIn cicHealthIn,CicResult cicHealthResult){
		String result = "";
		if(ObjectUtil.isNotEmpty(cicHealthIn)){ 
			boolean checkFlag = checkData(cicHealthIn,cicHealthResult,new String[]{"idcard","citizenCardNo","createOrganCode"
					,"createOrganName","createUserId","createUserName"});
			if(!checkFlag){//参数验证失败
				result = cicHealthResult.toXml();
			}else{
				CicTarget target = cicHealthService.getCicTarget(cicHealthIn);
				if(ObjectUtil.isNullOrEmpty(target)){
					cicHealthResult.setMessage("无此人健康数据！");
					result = marshal(cicHealthResult);
				}else if(CicConstants.HEALTH_FLAG_SUCCESS.equals(target.getFlag())){//数据成功查询
					result = marshal(target);
				}else{
					result = marshal(getHealthResult(target));
				}
			}
		}
		return result;
	}
	
	private CicResult getHealthResult(CicTarget target){
		CicResult result = new CicResult();
		result.setTranscode(target.getTranscode());
		if(CicConstants.HEALTH_FLAG_NOCHANGE.equals(target.getFlag())){
			result.setMessage("上次市民卡写入成功，本次数据没有发生变化");
		}else if(CicConstants.HEALTH_FLAG_NONE.equals(target.getFlag())){
			result.setMessage("无此人健康数据！");
		}
		return result;
	}
	
	private String dealWithCardWriteStatus(CicHealthIn cicHealthIn,CicResult cicHealthResult){
		String result = "";
		if(ObjectUtil.isNotEmpty(cicHealthIn)){
			boolean checkFlag = checkData(cicHealthIn,cicHealthResult,new String[]{"idcard","citizenCardNo","writeStatus"});
			if(!checkFlag){//参数验证失败
				result = cicHealthResult.toXml();
			}else{
				boolean saveFlag = cicHealthService.saveWriteStatus(cicHealthIn);
				if(!saveFlag){
					cicHealthResult.setMessage("无此人查询记录！");
				}
				result = cicHealthResult.toXml();
			}
		}
		return result;		
	}
	/**
	 * 参数检查
	 * @param cicHealthIn
	 * @param cicHealthResult
	 * @param properties
	 * @return
	 */
	private boolean checkData(CicHealthIn cicHealthIn,CicResult cicHealthResult,String...properties) {
		boolean result = true;
		String message = validateModel(cicHealthIn,properties);
		if(StringUtil.isNotEmpty(message)){
			cicHealthResult.setMessage(message);
			result = false;
		}
		return result;
	}
}
