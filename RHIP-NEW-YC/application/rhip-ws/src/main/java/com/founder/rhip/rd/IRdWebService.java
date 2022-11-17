package com.founder.rhip.rd;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public interface IRdWebService {
	
	/**
	 * 传送相关统计指标消息
	 * @param dataXML 请求的XML各类统计指标
	 * @param dataType 数据类型
	 * 对应的类型如下所示
	 * M01:门急诊综合
	 * M02:门急诊费用分析
	 * M03:住院综合
	 * M04:出院病人费用分析
	 * M05:全院收入情况
	 * M06:医技检查分析
	 * M07:医疗质量与安全
	 * M08:床位分布
	 * @return 返回"200"表示正常结束,返回"500"系统内部错误,否则返回出错信息
	 */
	@WebMethod
	public String trans(@WebParam(name = "dataXml") String  dataXML, @WebParam(name = "dataType") String  dataType);
}
