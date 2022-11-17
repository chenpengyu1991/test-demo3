/*
 * Copyright (c) 2010-2020 Founder Ltd. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of
 * Founder. You shall not disclose such Confidential Information
 * and shall use it only in accordance with the terms of the agreements
 * you entered into with Founder.
 */

package com.founder.rhip.idm.controller;

import java.util.HashMap;
import java.util.Map;


/**
 * 根据传染病代码获取个案调查页面地址
 * 
 * @version 1.0, 2013-3-18
 * @author Ye jianfei
 */
public class CaseLayoutMap {
	private static Map<String, String> LayoutMap = new HashMap<String, String>();
	
	public static String getLayoutStr(String infectiousCode){
		if(LayoutMap.size() == 0){
			initLayout();
		}
		return LayoutMap.get(infectiousCode);
	}

    public static String getPrintStr(String infectiousCode){
        if(LayoutMap.size() == 0){
            initLayout();
        }
        return LayoutMap.get(infectiousCode) + ".print";
    }
	
	private static void initLayout(){
		LayoutMap.put("101","rhip.idm.case.plague.add");//	鼠疫
		LayoutMap.put("102","rhip.idm.case.cholera");//	霍乱
		//LayoutMap.put("201","rhip.idm.case.sars.add");//	传染性非典型肺炎
		LayoutMap.put("202","rhip.idm.case.hiv");//	艾滋病
		LayoutMap.put("229","rhip.idm.case.hiv");//	hiv
		/*LayoutMap.put("202","rhip.idm.case.hiv");//	hiv
		LayoutMap.put("227","rhip.idm.case.hiv");//	艾滋病
*/		//LayoutMap.put("2031","rhip.idm.case.hav");//	病毒性肝炎 甲型
		//LayoutMap.put("2032","rhip.idm.case.hbv");//	病毒性肝炎 乙型
		//LayoutMap.put("2033","rhip.idm.case.hcv");//	病毒性肝炎 丙型
		//LayoutMap.put("2034","rhip.idm.case.hav");//	病毒性肝炎 戊型
		//20170420修改 
		LayoutMap.put("2031","rhip.idm.case.notHbv");//	病毒性肝炎 甲型
		LayoutMap.put("2032","rhip.idm.case.hbv");//	病毒性肝炎 乙型
		LayoutMap.put("2033","rhip.idm.case.notHbv");//	病毒性肝炎 丙型
		LayoutMap.put("2034","rhip.idm.case.notHbv");//	病毒性肝炎 戊型
		//LayoutMap.put("2035","");//	病毒性肝炎 未分型
		LayoutMap.put("204","rhip.idm.case.afp.add");//	脊髓灰质炎
		LayoutMap.put("327","rhip.idm.case.afp.add");//	急性弛缓性麻痹(AFP)
		//LayoutMap.put("205","rhip.idm.case.hiwhpai");//	人感染高致病性禽流感
		LayoutMap.put("206","rhip.idm.case.h1n1");//	甲型(H1N1)流感
		LayoutMap.put("207","rhip.idm.case.morbilli");//	麻疹
		LayoutMap.put("208","rhip.idm.case.hemorrhagicFever");//	流行性出血热
		LayoutMap.put("209","rhip.idm.case.rabies");//	狂犬病
		LayoutMap.put("210","rhip.idm.case.encephalitisB");//	流行性乙型脑炎
		LayoutMap.put("211","rhip.idm.case.dengue");//	登革热
		LayoutMap.put("2121","rhip.idm.case.anthrax");//	炭疽 肺炭疽
		LayoutMap.put("2122","rhip.idm.case.anthrax");//	炭疽 皮肤炭疽
		LayoutMap.put("2123","rhip.idm.case.anthrax");//	炭疽 未分型
		LayoutMap.put("2131","rhip.idm.case.dysentery.add");//	痢疾 细菌性
		//LayoutMap.put("2132","rhip.idm.case.dysentery.add");//	痢疾 阿米巴性
		//LayoutMap.put("2141","");//	肺结核 涂阳
		//LayoutMap.put("2142","");//	肺结核 仅培阳
		//LayoutMap.put("2143","");//	肺结核 菌阴
		//LayoutMap.put("2144","");//	肺结核 未痰检
		LayoutMap.put("2151","rhip.idm.case.typhia.add");//	伤寒 伤寒
		LayoutMap.put("2152","rhip.idm.case.typhia.add");//	伤寒 副伤寒
		LayoutMap.put("216","rhip.idm.case.meningitis.add");//	流行性脑脊髓膜炎
		LayoutMap.put("217","rhip.idm.case.pertussis");//	百日咳
		LayoutMap.put("218","rhip.idm.case.diphtheria");//	白喉
		LayoutMap.put("219","rhip.idm.case.tetanusNeonatorum");//	新生儿破伤风
		LayoutMap.put("220","rhip.idm.case.scarlatina");//	猩红热
		LayoutMap.put("221","rhip.idm.case.brucellosis");//	布鲁氏菌病
		//LayoutMap.put("222","rhip.idm.case.gonorrhea");//	淋病
		//LayoutMap.put("2231","rhip.idm.case.syphilis");//	梅毒 Ⅰ期
		//LayoutMap.put("2232","rhip.idm.case.syphilis");//	梅毒 Ⅱ期
		//LayoutMap.put("2233","rhip.idm.case.syphilis");//	梅毒 Ⅲ期
		//LayoutMap.put("2234","rhip.idm.case.syphilis");//	梅毒 胎传
		LayoutMap.put("2235","rhip.idm.case.syphilis");//	梅毒 隐性
		LayoutMap.put("224","rhip.idm.case.leptospirosis");//	钩端螺旋体病
		//LayoutMap.put("225","");//	血吸虫病
		LayoutMap.put("2261","rhip.idea.case.malaria");//	疟疾 间日虐
		LayoutMap.put("2262","rhip.idea.case.malaria");//	疟疾 恶性疟
		LayoutMap.put("2263","rhip.idea.case.malaria");//	疟疾 未分型
		//LayoutMap.put("240","rhip.idm.case.h7n9");//	h7n9
		LayoutMap.put("228","rhip.idm.case.h7n9");//	h7n9
		LayoutMap.put("301","rhip.idm.case.influenza");//	流行性感冒
		LayoutMap.put("302","rhip.idm.case.mumps");//	流行性腮腺炎
		LayoutMap.put("303","rhip.idm.case.rubella");//	风疹
		LayoutMap.put("304","rhip.idm.case.conjunctivitis");//	急性出血性结膜炎
		//LayoutMap.put("305","");//	麻风病
		//LayoutMap.put("306","rhip.idm.case.typhusFever");//	流行性和地方性斑疹伤寒
		//LayoutMap.put("307","rhip.idm.case.kalaAzar");//	黑热病
		//LayoutMap.put("308","rhip.idm.case.echinococcosis");//	包虫病
		//LayoutMap.put("309","");//	丝虫病
		LayoutMap.put("310","rhip.idm.case.lax");//	除霍乱、细菌性和阿米巴性痢疾、伤寒和副伤寒以外的感染性腹泻病
		LayoutMap.put("311","rhip.idm.case.hfmd.add");//手足口病
		LayoutMap.put("316","rhip.idm.case.varicella");//水痘
		
	}
	
}
