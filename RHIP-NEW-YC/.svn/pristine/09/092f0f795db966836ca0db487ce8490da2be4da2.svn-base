/**
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 * 
 * This software is the confidential and proprietary information of Founder. 
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with Founder.
 */

package com.founder.rhip.ihm.service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.util.Assert;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.ehr.repository.ihm.IIdmAnalyseTargetDao;
import com.founder.rhip.ehr.repository.ihm.IInhosTargetReportDao;
import com.founder.rhip.mdm.common.OrgGenreCode;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * 十八种住院重点疾病监测指标报表
 */
@Service("mdTargetService")
public class MdTargetServiceImpl extends IhmService implements IMdTargetService {

	@Resource(name="inhosTargetReportDao")
	private IInhosTargetReportDao inhosTargetReportDao;

    /**
     * 存储22中疾病内部编码,名称
     */
    private Map<String,Object> diseaseTypeMap = new HashMap<String,Object>();

	@Override
	public List<Map<String, Object>> getMdList(Integer year,String genreCode,String gbCode,String organCode){
        Assert.notNull(year, "统计年份不能为空");
		List<Map<String, Object>> result = inhosTargetReportDao.getMdList(year,genreCode,gbCode,organCode);
		return fillDiseaseData(result);
	}

    /**
     * 将没有统计到的数据补齐
     *
     * @param reports
     * @author Ye jianfei
     */
    protected List<Map<String, Object>> fillDiseaseData(List<Map<String, Object>> reports){
        List<Map<String, Object>> results = new ArrayList<Map<String, Object>>();
        String filedDiseaseType = "DISEASE_TYPE";//疾病编码字段名称
        String filedDiseaseName = "DISEASE_NAME";//疾病名称字段名称
        //初始化所有疾病列表
        initDiseaseTypeMap();
        Map<String, Object> diseaseData;
        for(int i = 1;i<23;i++){
            diseaseData = new HashMap<String,Object>();
            diseaseData.put(filedDiseaseType,String.valueOf(i));
            diseaseData.put(filedDiseaseName,diseaseTypeMap.get(String.valueOf(i)));
            for(Map<String, Object> map:reports){
                Object diseaseType  = map.get(filedDiseaseType);
                if(diseaseType.equals(String.valueOf(i))){//如果找到疾病数据
                    map.put(filedDiseaseName,diseaseTypeMap.get(String.valueOf(i)));
                    diseaseData.putAll(map);
                    break;
                }
            }
            results.add(diseaseData);
        }
        return results;
    }

    private void initDiseaseTypeMap() {
        diseaseTypeMap.put("1", "急性心肌梗死");
        diseaseTypeMap.put("2", "充血性心力衰竭");
        diseaseTypeMap.put("3", "脑出血");
        diseaseTypeMap.put("4", "脑梗死");
        diseaseTypeMap.put("5", "创伤性颅脑损伤");
        diseaseTypeMap.put("6", "消化道出血（无并发症）");
        diseaseTypeMap.put("7", "多部位损伤");
        diseaseTypeMap.put("8", "细菌性肺炎");
        diseaseTypeMap.put("9", "慢性阻塞性肺疾病");
        diseaseTypeMap.put("10", "糖尿病伴短期并发症");
        diseaseTypeMap.put("11", "糖尿病伴长期并发症");
        diseaseTypeMap.put("12", "糖尿病伴下肢截肢");
        diseaseTypeMap.put("13", "未控制血糖的糖尿病");
        diseaseTypeMap.put("14", "结节性甲状腺肿");
        diseaseTypeMap.put("15", "急性阑尾炎伴腹膜炎及脓肿");
        diseaseTypeMap.put("16", "前列腺增生");
        diseaseTypeMap.put("17", "肾衰竭");
        diseaseTypeMap.put("18", "败血症(成人)");
        diseaseTypeMap.put("19", "高血压病(成人)");
        diseaseTypeMap.put("20", "急性胰腺炎");
        diseaseTypeMap.put("21", "恶性肿瘤术后化疗");
        diseaseTypeMap.put("22", "恶性肿瘤维持性化疗");
    }
}