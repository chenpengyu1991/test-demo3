/**   
* @Title: ReserveHisServiceImpl.java 
* @Package com.founder.rhip.portal.service 
* @Description:预约和HIS交互的接口
* @author LJY
* @date 2013-8-8 下午2:26:34 
* @version V1.0   
*/
package com.founder.rhip.portal.service;

import java.util.HashMap;
import java.util.Map;

import com.founder.rhip.portal.dto.NewOrderResponse;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.founder.fasf.util.Base64Util;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.portal.dto.InputValues;
import com.founder.rhip.portal.dto.NewOrderRequest;
import com.founder.rhip.portal.service.util.Axis2Util;
import com.founder.rhip.portal.service.util.Constants;
import com.founder.rhip.portal.service.util.ValidateUtil;
import com.founder.rhip.portal.service.util.XmlWebserviceForUtil;

/**
 * @ClassName: ReservePayServiceImpl
 * @Description: 预约支付相关接口
 * @author  bagen
 * @date 2016年3月16日
 *
 */
@Service("reservePayService")
public class ReservePayServiceImpl implements IReservePayService {

	protected static Logger logger = Logger.getLogger(ReservePayServiceImpl.class.getName());
	
	/**
	* @Title: getReserve
	* @Description: 查询预约挂号
	* @param inputValues
	* @return String
	*/
	@Override
	public Map<String,Object> addOrder(InputValues inputValues){
		//方法返回变量
		Map<String, Object> returnMap = new HashMap<String, Object>();
		//验证传入的参数
		String validateString = ValidateUtil.doValidate(inputValues, "reservemobile","hospitalid",
				"scheduleid","parttimeid","creator");
		if(ObjectUtil.isNotEmpty(validateString)){
			returnMap.put(Constants.RESERVE_RET_CODE, Constants.RET_CODE_ERROR);
			returnMap.put(Constants.RESERVE_RET_MSG,validateString);
			return returnMap;
		}
		NewOrderRequest  orderReq = new NewOrderRequest();
		orderReq.setInputvalues(inputValues); 
		String request = XmlWebserviceForUtil.getString(orderReq, NewOrderRequest.class);
		String[] params = new String[]{Base64Util.encrypt(request.toString(), "UTF-8")};
		String response = Axis2Util.sendService(params, "NewOrder",Constants.FIRST_HOSPITAL);
		Map<String, Object> resMap = Axis2Util.toXmlResult(response,Constants.FIRST_HOSPITAL);
		//获取异常情况
		if(Constants.RET_CODE_ERROR.equals(resMap.get(Constants.RESERVE_RET_CODE))){
			return resMap;
		}
		//获取返回的XML
		String resultXml = resMap.get(Constants.RESERVE_RET_MSG).toString();
		try {
			NewOrderResponse newOrder = XmlWebserviceForUtil.parseDataXml(resultXml, NewOrderResponse.class);
			//接口返回错误
			if(!Axis2Util.checkResult(newOrder.getReturnresult())){
				returnMap.put(Constants.RESERVE_RET_CODE, Constants.RET_CODE_ERROR);
				returnMap.put(Constants.RESERVE_RET_MSG,(newOrder.getReturnresult()).getErrormsg());
				return returnMap;
			}
			returnMap.put(Constants.RESERVE_RET_CODE, Constants.RET_CODE_CORRECT);
			returnMap.put(Constants.RESERVE_RET_MSG,newOrder);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnMap;
	}
	
}
