package com.founder.rhip.ehr.repository.basic;

import com.founder.fasf.repository.AbstractDao;
import com.founder.rhip.ehr.entity.basic.PersonInfo;

import java.io.Serializable;

public class RqflAbstractDao<T, PK extends Serializable> extends AbstractDao<T, PK> {
    protected StringBuilder getDynamicRecord(String dynamicRecord,StringBuilder sql){
        String[] sourceStrArray = dynamicRecord.split(",");
        for (int i = 0; i < sourceStrArray.length; i++) {
//	BUG0168264		if(i == 0){
            sql.append(" AND( ");
/*			}
			else {
				sql.append(" OR( ");
			}*/

            if(sourceStrArray[i] .equals("1")){
                sql.append(" MONTHS_BETWEEN(SYSDATE, B.BIRTHDAY)/12 >= 7");
                sql.append(" AND TO_CHAR(B.BIRTHDAY,'YYYY')>TO_CHAR(SYSDATE,'YYYY')-65");
                sql.append(" AND (MATERNAL_FLAG='1' or MATERNAL_FLAG is null)");
                sql.append(" AND NOT EXISTS( select person_id from DM_DISEASE_INFO D where (D.HBP_FLAG=2  OR D.DI_FLAG=2) AND B.ID=D.PERSON_ID ) ");
            }
            if(sourceStrArray[i] .equals("2")){
                sql.append(" MONTHS_BETWEEN(SYSDATE, B.BIRTHDAY)/12 < 7 AND MONTHS_BETWEEN(SYSDATE, B.BIRTHDAY)/12 >= 0");
            }
            if(sourceStrArray[i] .equals("3")){
                sql.append(" TO_CHAR(B.BIRTHDAY,'YYYY')<=TO_CHAR(SYSDATE,'YYYY')-65");
            }
            if(sourceStrArray[i] .equals("4")){
                sql.append(" MATERNAL_FLAG='2'");
            }
            if(sourceStrArray[i] .equals("5")){
                sql.append(" EXISTS( select person_id from DM_DISEASE_INFO D where D.HBP_FLAG=2 AND D.STATUS = 1 AND B.ID=D.PERSON_ID )");
            }
            if(sourceStrArray[i] .equals("6")){
                sql.append(" EXISTS( select person_id from DM_DISEASE_INFO D where D.DI_FLAG=2 AND D.STATUS = 1 AND B.ID=D.PERSON_ID )");
            }
            if(sourceStrArray[i] .equals("7")){
                sql.append(" EXISTS(select dh.person_id from DHS_DISEASE_HISTORY dh where dh.DISEASE_CODE in('208', '209', '212') and dh.person_id = B.ID)");
            }
            if(sourceStrArray[i] .equals("8")){
                sql.append(" EXISTS( select dh.person_id from DHS_DISEASE_HISTORY dh where dh.DISEASE_CODE = '208' and dh.person_id = B.ID)");
            }
            if(sourceStrArray[i] .equals("9")){
                sql.append(" EXISTS(select dh.person_id from DHS_DISEASE_HISTORY dh where dh.DISEASE_CODE = '207' and dh.person_id = B.ID )");
            }
            if(i == sourceStrArray.length-1){ sql.append(" ) "); }
            if(i != 0){sql.append(" ) ");}

        }

        return sql;
		/*switch (dynamicRecord) {
		case 1://普通人群
			sql.append(" AND MONTHS_BETWEEN(SYSDATE, B.BIRTHDAY)/12 >= 7");
			//sql.append(" AND MONTHS_BETWEEN(SYSDATE, B.BIRTHDAY)/12 < 65");
			sql.append(" AND TO_CHAR(B.BIRTHDAY,'YYYY')>TO_CHAR(SYSDATE,'YYYY')-65");
			sql.append(" AND (MATERNAL_FLAG='1' or MATERNAL_FLAG is null)");
			sql.append(" AND NOT EXISTS( select person_id from DM_DISEASE_INFO D where (D.HBP_FLAG=2  OR D.DI_FLAG=2) AND B.ID=D.PERSON_ID )");
			break;
		case 2://儿童
			sql.append(" AND MONTHS_BETWEEN(SYSDATE, B.BIRTHDAY)/12 < 7 AND MONTHS_BETWEEN(SYSDATE, B.BIRTHDAY)/12 >= 0");
			break;
		case 3://老年人
			//sql.append(" AND MONTHS_BETWEEN(SYSDATE, B.BIRTHDAY)/12 >= 65");
			sql.append(" AND TO_CHAR(B.BIRTHDAY,'YYYY')<=TO_CHAR(SYSDATE,'YYYY')-65");
			break;
		case 4://孕产妇
			sql.append(" AND MATERNAL_FLAG='2'");
			break;
		case 5://高血压患者
			sql.append(" AND EXISTS( select person_id from DM_DISEASE_INFO D where D.HBP_FLAG=2 AND D.STATUS = 1 AND B.ID=D.PERSON_ID )");
			break;
		case 6://糖尿病患者
			sql.append(" AND EXISTS( select person_id from DM_DISEASE_INFO D where D.DI_FLAG=2 AND D.STATUS = 1 AND B.ID=D.PERSON_ID )");
			break;
		case 7://传染病
			sql.append(" AND EXISTS(select dh.person_id from DHS_DISEASE_HISTORY dh where dh.DISEASE_CODE in('208', '209', '212') and dh.person_id = B.ID)");
//					"and EXISTS(select id from SY_EHR_HEALTH_EVENT e where ehr_type = '" + EventType.PERSON_RECORD_BASIC_INFO.getCode() + "' and e.person_id = dh.person_id))");
			break;
		case 8://肺结核
			sql.append(" AND EXISTS( select dh.person_id from DHS_DISEASE_HISTORY dh where dh.DISEASE_CODE = '208' and dh.person_id = B.ID)");
//					"and  EXISTS(select id from SY_EHR_HEALTH_EVENT e where ehr_type = '" + EventType.PERSON_RECORD_BASIC_INFO.getCode() + "' and e.person_id = dh.person_id))");
			break;
		case 9://精神障碍患者
			sql.append(" AND EXISTS(select dh.person_id from DHS_DISEASE_HISTORY dh where dh.DISEASE_CODE = '207' and dh.person_id = B.ID )");
//					"and EXISTS(select id from SY_EHR_HEALTH_EVENT e where ehr_type = '" + EventType.PERSON_RECORD_BASIC_INFO.getCode() + "' and e.person_id = dh.person_id))");
			break;
		}*/
    }
}
