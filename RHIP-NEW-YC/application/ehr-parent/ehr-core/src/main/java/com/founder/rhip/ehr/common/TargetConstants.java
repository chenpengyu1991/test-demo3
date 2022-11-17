package com.founder.rhip.ehr.common;

/**
 * 用于综合指标编码描述
 */
public class TargetConstants {

    /**
     * 健康档案统计指标
     */
    public static final String LEI_JI_DANG_AN_HJ = "PH001"; //累计档案 - 户籍
    public static final String LEI_JI_DANG_AN_FHJ = "PH002"; //累计档案 - 非户籍
    public static final String ZHONG_DIAN_REN_QUN_LR = "PH003"; //重点人群 - 65岁以上老年人
    public static final String ZHONG_DIAN_REN_QUN_GXY = "PH004"; //重点人群 - 高血压
    public static final String ZHONG_DIAN_REN_QUN_TNB = "PH005"; //重点人群 - 2型糖尿病
    public static final String ZHONG_DIAN_REN_QUN_JSB = "PH006"; //重点人群 - 精神病
    public static final String BEN_NIAN_XIN_ZENG_DANG_AN = "PH007"; //本年度新增档案数
    public static final String EHR_SHI_YONG_QING_KUANG_YOU = "PH008"; //健康档案使用情况 - 有动态记录数
    public static final String EHR_SHI_YONG_QING_KUANG_WU = "PH009"; //健康档案使用情况 - 无动态记录数

    /**
     * 健康教育统计指标
     */
    public static final String HE_DELIVERY_MATERIAL_KIND = "PH010"; //发放健康教育印刷资料种类
    public static final String HE_DELIVERY_MATERIAL_QUANTITY = "PH011"; // 发放健康教育印刷资料数量
    public static final String HE_PLAY_AUDIO_QUANTITY = "PH012"; // 播放音像数量数
    public static final String HE_SET_BULLETIN_BOARD_QUANTITY = "PH013"; //设置宣传栏数
    public static final String HE_BULLETIN_BOARD_QUANTITY_UPDATE_QUANTITY = "PH014"; //宣传栏更新次数
    public static final String HE_PUBLIC_HEALTH_CONSULT_QUANTITY = "PH0151"; //开展公众健康咨询次数
    public static final String HE_PUBLIC_HEALTH_CONSULT_PERSON_QUANTITY = "PH0152"; //开展公众健康咨询参加人数
    public static final String HE_HEALTH_KNOWLEDGE_LECTURE_QUANTITY = "PH0161"; //举办健康知识讲座次数
    public static final String HE_HEALTH_KNOWLEDGE_LECTURE_PERSON_QUANTITY = "PH0162"; //举办健康知识讲座参加人数
    public static final String[] HE_TARGETS = new String[] {"PH010","PH011","PH012","PH013","PH014","PH0151","PH0152","PH0161","PH0162"};
    
    /**
     * 老年人健康管理
     */
    public static final String HM_APPLY_PERSON_QUANTITY = "PH029"; // 接受健康管理的老年人数(人)
    public static final String HM_WHOLE_PHYSICAL_EXAMINATION_REPORT = "PH030"; //填写完整的健康体检表格数
    public static final String[] HM_TARGETS = new String[] {"PH029",HM_APPLY_PERSON_QUANTITY};
    
    /**
     * 妇幼保健统计指标
     */
    public static final String FU_YOU_BAO_JIAN_XSEFS = "PH021"; //新生儿访视人数
    public static final String FU_YOU_BAO_JIAN_YEJKDA = "PH022"; //婴幼儿健康管理数
    public static final String FU_YOU_BAO_JIAN_46GL = "PH023"; //4-6岁儿童健康管理数
    public static final String FU_YOU_BAO_JIAN_06GL = "PH024"; //0-6岁儿童保健覆盖数
    public static final String FU_YOU_BAO_JIAN_ZY = "PH025"; //早孕建册数(册)
    public static final String FU_YOU_BAO_JIAN_CQ5 = "PH026"; //产前检查5次及以上孕妇数(人)
    public static final String FU_YOU_BAO_JIAN_CHFS = "PH027"; //产后访视产妇数(人)
    public static final String FU_YOU_BAO_JIAN_CHFS42 = "PH028"; //产后42天健康检查产妇数

    /**
     * 传染病统计指标
     */
    public static final String IDM_REG = "PH045"; //登记传染病人数
    public static final String IDM_REPORT = "PH046"; //报告传染病人数
    public static final String IDM_INTIME = "PH047"; //报告及时传染病人数
    public static final String IDM_CDM_STATION_REPORT = "PH053"; //医生工作站慢病、传染病上报数
    public static final String CDM_STATION_REPORT = "PH054"; //医生工作站慢病上报数
    public static final String IDM_STATION_REPORT = "PH055"; //医生工作站传染病上报数
    public static final String IDM_YESTERDAY_REPORT = "PH056"; //昨日上报数

    /**
     * 慢病统计指标
     */
    public static final String CDM_DI_TYPE_TWO_NEW_COUNT= "PH035"; //新发现2型糖尿病患者数	
    public static final String CDM_DI_TYPE_TWO_MANAGED_BY_YEAR_COUNT= "PH036"; //年内累计管理2型糖尿病患者数	
    public static final String CDM_DI_TYPE_TWO_MANAGED_TOTAL_COUNT = "PH037"; //	规范管理2型糖尿病患者数	
    public static final String CDM_DI_TYPE_TWO_FOLLOWUP_BSOK_COUNT = "PH038"; //2型糖尿病患者最近一次随访血糖达标患者数	
    public static final String CDM_DI_TYPE_TWO_FOLLOWUP_COUNT = "PH56"; //2型糖尿病 随访患者数	
    
    public static final String CDM_DI_NEW_COUNT= "PH057"; //糖尿病患者数	
    public static final String CDM_DI_MANAGED_BY_YEAR_COUNT= "PH058"; //年内累计管理糖尿病患者数	
    public static final String CDM_DI_MANAGED_TOTAL_COUNT = "PH059"; //	规范管理糖尿病患者数	
    public static final String CDM_DI_FOLLOWUP_BSOK_COUNT = "PH060"; //最近一次随访血糖达标患者数	
    public static final String CDM_DI_FOLLOWUP_COUNT = "PH061"; //随访患者数	

    
    public static final String CDM_HBP_NEW_COUNT = "PH031"; //新发现高血压患者数
    public static final String CDM_HBP_MANAGED_BY_YEAR_COUNT = "PH032"; //	年内累计管理高血压患者数	
    public static final String CDM_HBP_MANAGED_TOTAL_COUNT= "PH033"; //规范管理高血压患者数
    public static final String CDM_HBP_FOLLOWUP_BSOK_COUNT = "PH034"; //最近一次随访血压达标患者数	
    public static final String CDM_HBP_FOLLOWUP_COUNT = "PH062"; //随访标患者数	

    /**
     * 精神卫生统计指标
     */
    public static final String MHM_NEW_SEVERE_COUNT= "PH039"; //新发现重性精神疾病患者数
    public static final String MHM_WITHIN_SEVERE_COUNT= "PH040"; //年内累计管理重性精神疾病患者数
    public static final String MHM_MANAGEMENT_SEVERE_COUNT= "PH041"; //规范管理重性精神疾病患者数
    public static final String MHM_FOLLOWUP_STABLE_COUNT= "PH042"; //最近一次随访时分类为“病情稳定”的患者数
    
    /**
     * 妇幼保健
     * @return
     */
    public static final String WOMAN_CHILDREN_021 = "PH021"; //新生儿访视人数	
    public static final String WOMAN_CHILDREN_022 = "PH022";  //婴幼儿健康管理数	
    public static final String WOMAN_CHILDREN_027 = "PH027"; //产后访视产妇数(人)
    public static final String WOMAN_CHILDREN_028 = "PH028"; //产后42天健康检查产妇数
    
    public static String[] ehrCodeArray(){
    	String[] arr = new String[]{
		     LEI_JI_DANG_AN_HJ ,
		     LEI_JI_DANG_AN_FHJ ,
		     ZHONG_DIAN_REN_QUN_LR ,
		     ZHONG_DIAN_REN_QUN_GXY ,
		     ZHONG_DIAN_REN_QUN_TNB ,
		     ZHONG_DIAN_REN_QUN_JSB ,
		     //BEN_NIAN_XIN_ZENG_DANG_AN ,
		     EHR_SHI_YONG_QING_KUANG_YOU ,
		     EHR_SHI_YONG_QING_KUANG_WU 
    	};
    	return arr;
    }

    //传染病
    public static String[] idmCodeArray(){
        String[] arr = new String[]{
            IDM_REG,
            IDM_REPORT,
            IDM_INTIME,
            IDM_STATION_REPORT
        };
        return arr;
    }

    //精神卫生管理
    public static String[] MhmCodeArray(){
        String[] arr = new String[]{
        		MHM_NEW_SEVERE_COUNT,
        		MHM_WITHIN_SEVERE_COUNT,
        		MHM_MANAGEMENT_SEVERE_COUNT,
        		MHM_FOLLOWUP_STABLE_COUNT
        };
        return arr;
    }
    
    //传染病
    public static String[] cdmCodeArray(){
        String[] arr = new String[]{
                CDM_DI_TYPE_TWO_NEW_COUNT,
                CDM_DI_TYPE_TWO_MANAGED_BY_YEAR_COUNT,
                CDM_DI_TYPE_TWO_MANAGED_TOTAL_COUNT,
                CDM_DI_TYPE_TWO_FOLLOWUP_BSOK_COUNT,
                CDM_HBP_NEW_COUNT,
                CDM_HBP_MANAGED_BY_YEAR_COUNT,
                CDM_HBP_MANAGED_TOTAL_COUNT,
                CDM_HBP_FOLLOWUP_BSOK_COUNT,
                CDM_STATION_REPORT,
        };
        return arr;
    }
    
    //妇幼保健
    public static String[] cwhCodeArray(){
    	String[] arr = new String[]{
    			FU_YOU_BAO_JIAN_XSEFS,
    		    FU_YOU_BAO_JIAN_YEJKDA,
    		    FU_YOU_BAO_JIAN_46GL,
    		    FU_YOU_BAO_JIAN_06GL,
    		    FU_YOU_BAO_JIAN_ZY,
    		    FU_YOU_BAO_JIAN_CQ5,
    		    FU_YOU_BAO_JIAN_CHFS,
    		    FU_YOU_BAO_JIAN_CHFS42
    	};
    	return arr;
    }
}

