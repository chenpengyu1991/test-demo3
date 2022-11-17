package com.founder.rhip.mdm;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.beans.Record;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.BaseWebService;
import com.founder.rhip.mdm.common.CheckUtil;
import com.founder.rhip.mdm.service.IDictionaryService;
import com.founder.rhip.mdm.entity.EntityType;
import com.founder.rhip.mdm.entity.Medicine;
import com.founder.rhip.mdm.entity.SzdTophoschargeitem;
import com.founder.rhip.mdm.service.IChargeItemService;
import com.founder.rhip.mdm.service.IMedicineService;
import com.founder.rhip.mdm.service.IMDMConfigService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.jws.WebService;
import java.text.SimpleDateFormat;
import java.util.*;

@Service("chargetItemDOCService")
@WebService(serviceName="ChargetItemService")
public class ChargeItemWebService extends BaseWebService implements IChargeItemWebService {

	@Resource(name = "mdmChargeItemService")
	private IChargeItemService chargeItemService;

	@Resource(name = "mdmMedicineService")
	private IMedicineService medicineService;

	@Resource(name = "mdmConfigService")
	private IMDMConfigService mdmConfigService;

	@Resource(name = "mdmDictionaryService")
	private IDictionaryService dictionaryService;

	private Logger log = LoggerFactory.getLogger(getClass());

	private CheckUtil.ICheckDictionary checkDict = new CheckUtil.ICheckDictionary(){
		@Override
		public Map<String, String> getDictionary(String dictKey) {
			return null;
		}
	};

	@Override
	public String downloadMedicine(String param) {
		String templateName = "res_downloadMedicines";
		WSParamProcessor processor = new WSParamProcessor();
		Map<String, Object> request;
		try {
			request = processor.parseRequest(param);
		} catch (Exception e) {
			return processor.errorResponse(templateName, e.getMessage());
		}
		if (ObjectUtil.isNullOrEmpty(request)) {
			return processor.errorResponse(templateName, "请求无效");
		}
		String lastDownloadTime = (String) request.get("lastDownloadTime");
		Long lastTime = stringTimeToLong(lastDownloadTime);
		List<Medicine> medicines = medicineService.queryMedicines(new Criteria("operateTime", OP.GT, lastTime));
		// levelCode translate
		List<Map<String, Object>> list = new ArrayList<>();
		for (Medicine med : medicines) {
			// levelCode translate
			String levelCode = med.getLevelCode();
			Map<String, String> codes = dictionaryService.getDicItemMapUseCache(new Criteria("dicCode", "FS10242"));
			levelCode = codes.get(levelCode);
			med.setLevelCode(levelCode);
			list.add(new Record(med).getMap());
		}
		String response;
		try {
			response = processor.createResponse(templateName, list);
		} catch (Exception e) {
			return processor.errorResponse(templateName, e.getMessage());
		}
		return response;
	}

	@Override
	public String uploadChargeItems(String param) {
		String templateName = "res_uploadChargeItems";
		WSParamProcessor processor = new WSParamProcessor();
		List<Map<String, Object>> request;
		try {
			request = processor.parseRequestToList(param);
		} catch (Exception e) {
			return processor.errorResponse(templateName, e.getMessage());
		}
		if (ObjectUtil.isNullOrEmpty(request)) {
			return processor.errorResponse(templateName, "请求无效");
		}
		// validation
		CheckUtil checkUtil = CheckUtil.getInstance(mdmConfigService);
		List<String> messageList = new ArrayList<>();
		for (Map<String, Object> item : request) {
			Record record = new Record();
			record.putAll(item);
			checkUtil.checkAll(messageList, record, EntityType.SZD_TOPHOSCHARGEITEM, checkDict);
		}
		if (ObjectUtil.isNotEmpty(messageList)) {
			return processor.errorResponse(templateName, StringUtil.join(messageList));
		}
		// upload
		int processed;
		try {
			processed = chargeItemService.syncChargeItems(request);
		} catch (Exception e) {
			log.error("数据同步出错", e);
			return processor.errorResponse(templateName, e.getMessage());
		}
		Map<String, Object> response = new HashMap<>();
		response.put("return", "共" + request.size() + "条数据，操作成功" + processed + "条。");
		try {
			return processor.createResponse(templateName, response);
		} catch (Exception e) {
			log.error("无法生成返回报文XML", e);
			return processor.errorResponse(templateName, e.getMessage());
		}
	}

	//@Override
	public String downloadTopHosChargeItemsX(String param) {
		String templateName = "res_downloadTopHosChargeItems";
		WSParamProcessor processor = new WSParamProcessor();
		Map<String, Object> request;
		try {
			request = processor.parseRequest(param);
		} catch (Exception e) {
			log.error("解析失败", e);
			return processor.errorResponse(templateName, "解析失败\n" + e.getMessage());
		}
		if (ObjectUtil.isNullOrEmpty(request)) {
			return processor.errorResponse(templateName, "请求无效");
		}
		String organCode = (String) request.get("organizationId");
		Date lastDownloadTime = (Date) request.get("lastDownloadTime");
		List<Map<String, Object>> chargeItems = chargeItemService.getLatestChargeItems(organCode, lastDownloadTime);
        try {
			return processor.createResponse(templateName, chargeItems);
		} catch (Exception e) {
			log.error("生成返回报文XML出错。", e);
			return processor.errorResponse(templateName, e.getMessage());
		}
	}

	@Override
	public List<SzdTophoschargeitem> downloadTopHosChargeItems(String saasId, String organizationId, String type, String lastDownloadTime) throws Exception {
		Integer type_ = null;
		try {
			if (StringUtil.isNotEmpty(type)) {
				type_ = Integer.parseInt(type);
			}
		} catch (Exception e) {
			log.error("类型格式不对", e);
			throw e;
		}
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date lastTime = null;
		try {
			if (StringUtil.isNotEmpty(lastDownloadTime)) {
				lastTime = df.parse(lastDownloadTime);
			}
		} catch (Exception e) {
			log.error("时间格式不对", e);
			throw e;
		}
		try {
			List<SzdTophoschargeitem> chargeItems = chargeItemService.getLatestChargeItems(organizationId, type_, lastTime);
			log.info("Service Name: downloadTopHosChargeItems 处理成功 参数(" + "saasId : " + saasId + ",organizationId : " + organizationId + ",type : " + type + ",lastDownloadTime : " + lastDownloadTime +") 返回记录数：" + chargeItems.size());
			//log.info("处理成功");
			return chargeItems;
		} catch (Exception e) {
			log.error("Service Name: downloadTopHosChargeItems 处理失败 参数(" + "saasId : " + saasId + ",organizationId : " + organizationId + ",type : " + type + ",lastDownloadTime : " + lastDownloadTime +") 错误：" + e.getMessage(), e);
			//log.error("处理失败" + saasId, e);
		}
		return null;
	}

	@Override
	public String isExistInBaseList(String param) {
		String templateName = "res_isExistInBaseList";
		WSParamProcessor processor = new WSParamProcessor();
		List<Map<String, Object>> request;
		try {
			request = processor.parseRequestToList(param);
		} catch (Exception e) {
			return processor.errorResponse(templateName, e.getMessage());
		}
		if (ObjectUtil.isNullOrEmpty(request)) {
			return processor.errorResponse(templateName, "请求无效");
		}
		List<String> medicines = new ArrayList<>();
		for (Map<String, Object> req : request) {
			String baseCode = (String) req.get("baseCode");
			if (StringUtil.isNotEmpty(baseCode)) {
				medicines.add(baseCode);
			}
		}
		List<String> failedList;
		int totalSize = medicines.size();
		try {
			failedList = medicineService.baseMedValidation(medicines);
		} catch (Exception e) {
			log.error(null, e);
			return processor.errorResponse(templateName, e.getMessage());
		}
		int success = totalSize;
		if (ObjectUtil.isNotEmpty(failedList)) {
			success = totalSize - failedList.size();
		}
		Map<String, Object> response = new HashMap<>();
		response.put("return", "Success");
		response.put("description", "共" + totalSize + "条数据，验证成功" + success + "条，不成功" + failedList.size() + "条。");
		if (ObjectUtil.isNotEmpty(failedList)) {
			response.put("notInBaseList", "[" + StringUtil.join(failedList) + "]");
		}
		try {
			return processor.createResponse(templateName, response);
		} catch (Exception e) {
			return processor.errorResponse(templateName, e.getMessage());
		}
	}

	private Long stringTimeToLong(String time) {
		if (time == null) {
			return null;
		}
		time = time.replace("-", "");
		time = time.replace(" ", "");
		time = time.replace(":", "");
		if (time.length() == 14) {
			time += "000";
		}
		return Long.parseLong(time);
	}
}
