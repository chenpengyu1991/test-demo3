package com.founder.rhip.ehr.repository.ihm;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.mdm.entity.Staff;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * DAO implement of 医护人员统计
 * 
 */
@Repository("hrBaseTargetDao")
public class HRBaseTargetDaoImpl extends AbstractDao<Staff, Long> implements IHRBaseTargetDao {

    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
	
    private static final String ORGAN_BASE_SQL = " select ccc.organ_code as organ_code, ccc.organ_name as organ_name, "
			+ " max(decode(ccc.%1$s, '1', ccc.num, 0)) as count1, "
			+ " max(decode(ccc.%1$s, '2', ccc.num, 0)) as count2, "
			+ " max(decode(ccc.%1$s, '3', ccc.num, 0)) as count3, "
			+ " max(decode(ccc.%1$s, '4', ccc.num, 0)) as count4, "
			+ " max(decode(ccc.%1$s, '5', ccc.num, 0)) as count5, "
			+ " max(decode(ccc.%1$s, '6', ccc.num, 0)) as count6 "
			+ " from "
			+ " (select ttt.organ_code, ttt.organ_name, ttt.%1$s, count(1) as num from "
			+ " (SELECT sta.organ_code AS organ_code, "
			+ " org.organ_name AS organ_name, "
			+ " org.gb_code AS gb_code, "
			+ " org.genre_code AS genre_code, "
			+ " sta.%1$s AS %1$s "
			+ " FROM mdm_staff sta "
			+ " LEFT JOIN mdm_organization org "
			+ " ON sta.organ_code  = org.organ_code "
			+ " where sta.%1$s is not null %2$s) ttt "
			+ " group by ttt.organ_code, ttt.organ_name, ttt.%1$s) ccc group by ccc.organ_code, ccc.organ_name ";
    
	private static final String ORGAN_SQL = "select Coalesce(sub1.organ_code, sub2.organ_code) as organ_code, Coalesce(sub1.organ_name, sub2.organ_name) as organ_name, "
			+ "nvl(sub1.count1, 0) as count1, nvl(sub1.count2, 0) as count2, nvl(sub1.count3, 0) as count3, nvl(sub1.count4, 0) as count4, nvl(sub1.count5, 0) as count5, nvl(sub1.count6, 0) as count6, "
			+ "nvl(sub2.count1, 0) as count7, nvl(sub2.count2, 0) as count8, nvl(sub2.count3, 0) as count9, nvl(sub2.count4, 0) as count10, nvl(sub2.count5, 0) as count11, nvl(sub2.count6, 0) as count12 "
			+ "from (%1$s) sub1 FULL OUTER JOIN (%2$s) sub2 on sub1.organ_code = sub2.organ_code ";
	
	private static final String GB_BASE_SQL = " select ccc.gb_code as organ_code, "
			+ " max(decode(ccc.%1$s, '1', ccc.num, 0)) as count1, "
			+ " max(decode(ccc.%1$s, '2', ccc.num, 0)) as count2, "
			+ " max(decode(ccc.%1$s, '3', ccc.num, 0)) as count3, "
			+ " max(decode(ccc.%1$s, '4', ccc.num, 0)) as count4, "
			+ " max(decode(ccc.%1$s, '5', ccc.num, 0)) as count5, "
			+ " max(decode(ccc.%1$s, '6', ccc.num, 0)) as count6 "
			+ " from "
			+ " (select ttt.gb_code, ttt.%1$s, count(1) as num from "
			+ " (SELECT sta.organ_code AS organ_code, "
			+ " org.organ_name AS organ_name, "
			+ " org.gb_code AS gb_code, "
			+ " org.genre_code AS genre_code, "
			+ " sta.%1$s AS %1$s "
			+ " FROM mdm_staff sta "
			+ " LEFT JOIN mdm_organization org "
			+ " ON sta.organ_code  = org.organ_code "
			+ " where sta.%1$s is not null %2$s) ttt "
			+ " group by ttt.gb_code, ttt.%1$s) ccc group by ccc.gb_code ";
	
	private static final String GB_SQL = "select Coalesce(sub1.organ_code, sub2.organ_code) as organ_code, "
			+ "nvl(sub1.count1, 0) as count1, nvl(sub1.count2, 0) as count2, nvl(sub1.count3, 0) as count3, nvl(sub1.count4, 0) as count4, nvl(sub1.count5, 0) as count5, nvl(sub1.count6, 0) as count6, "
			+ "nvl(sub2.count1, 0) as count7, nvl(sub2.count2, 0) as count8, nvl(sub2.count3, 0) as count9, nvl(sub2.count4, 0) as count10, nvl(sub2.count5, 0) as count11, nvl(sub2.count6, 0) as count12, "
			+ "di.item_name as organ_name "
			+ "from (%1$s) sub1 FULL OUTER JOIN (%2$s) sub2 on sub1.organ_code = sub2.organ_code "
			+ "LEFT JOIN  dic_item di on Coalesce(sub1.organ_code, sub2.organ_code) = di.item_code "
			+ "WHERE di.dic_code = 'FS990001' ";

	//人员构成（从业分类）
	String STAFF_CY_TYPE ="SELECT SUM(CY_TYPE1) CY_TYPE1,SUM(CY_TYPE2) CY_TYPE2"
			+ " ,SUM(CY_TYPE3) CY_TYPE3,SUM(CY_TYPE4) CY_TYPE4\n"
			+ " ,SUM(CY_TYPE5) CY_TYPE5,SUM(CY_TYPE6) CY_TYPE6\n"
			+ " FROM(\n"
			+ "     SELECT DECODE(CY_TYPE,'1',1,0) CY_TYPE1,DECODE(CY_TYPE,'2',1,0) CY_TYPE2,\n"
			+ "         DECODE(CY_TYPE,'3',1,0) CY_TYPE3,DECODE(CY_TYPE,'4',1,0) CY_TYPE4,\n"
			+ "         DECODE(CY_TYPE,'5',1,0) CY_TYPE5,DECODE(CY_TYPE,'6',1,0) CY_TYPE6\n"
			+ "     FROM MDM_STAFF\n"
			+ " )\n";
	
	@Override
	public List<Map<String, Object>> getHealthTargetList(String organCode, String superOrganCode, String gbCode, String genreCode) {
		Criteria criteria = new Criteria();
		
		if("0".equals(genreCode))
		{
			StringBuilder whereBaseSQL = null;
			StringBuilder gbBaseSQL = new StringBuilder(GB_BASE_SQL);
			StringBuilder gbSQL= new StringBuilder(GB_SQL);
			
			if(StringUtil.isNotEmpty(gbCode))
			{
				whereBaseSQL = new StringBuilder(" and org.gb_code = '" + gbCode + "' ");
			}else
			{
				whereBaseSQL = new StringBuilder(" and org.gb_code is not null ");
			}
			
			whereBaseSQL.append(" and org.genre_code in ('B100','B200') and org.status = '1'  and sta.status = '1' ");
			//从业分类
			String cyTypeSql = String.format(gbBaseSQL.toString(), "cy_type", whereBaseSQL.toString());
			//人员分类
			String ryTypeSql = String.format(gbBaseSQL.toString(), "ry_type", whereBaseSQL.toString());
			
			String lastSql = String.format(gbSQL.toString(), cyTypeSql, ryTypeSql);
			
			return this.getMapList(lastSql, criteria);
		}else
		{
			StringBuilder whereBaseSQL = null;
			StringBuilder organSQL = new StringBuilder(ORGAN_SQL);
			StringBuilder organBaseSQL = new StringBuilder(ORGAN_BASE_SQL);

			if("A100".equals(genreCode))
			{
				whereBaseSQL = new StringBuilder(" and org.genre_code = 'A100' ");
				
				if(StringUtil.isNotEmpty(superOrganCode))
				{
					whereBaseSQL.append(" and org.ORGAN_CODE = '" + superOrganCode + "' ");
				}else
				{
					whereBaseSQL.append(" and sta.ORGAN_CODE is not null ");
				}
			}else if("B100".equals(genreCode))
			{
				whereBaseSQL = new StringBuilder(" and org.genre_code = 'B100' ");
				
				if(StringUtil.isNotEmpty(gbCode))
				{
					whereBaseSQL.append(" and org.gb_code = '" + gbCode + "' ");
				}
				
				if(StringUtil.isNotEmpty(superOrganCode))
				{
					whereBaseSQL.append(" and org.ORGAN_CODE = '" + superOrganCode + "' ");
				}else
				{
					whereBaseSQL.append(" and sta.ORGAN_CODE is not null ");
				}
			}else if("B200".equals(genreCode))
			{
				whereBaseSQL = new StringBuilder(" and org.genre_code = 'B200' ");
				
				if(StringUtil.isNotEmpty(gbCode))
				{
					whereBaseSQL.append(" and org.gb_code = '" + gbCode + "' ");
				}
				
				if(StringUtil.isNotEmpty(superOrganCode))
				{
					whereBaseSQL.append(" and org.parent_code = '" + superOrganCode + "' ");
				}
				
				if(StringUtil.isNotEmpty(organCode))
				{
					whereBaseSQL.append(" and org.ORGAN_CODE = '" + organCode + "' ");
				}else
				{
					whereBaseSQL.append(" and sta.ORGAN_CODE is not null ");
				}
			}
			
			whereBaseSQL.append(" and org.status = '1'  and sta.status = '1' ");
			//从业分类
			String cyTypeSql = String.format(organBaseSQL.toString(), "cy_type", whereBaseSQL.toString());
			//人员分类
			String ryTypeSql = String.format(organBaseSQL.toString(), "ry_type", whereBaseSQL.toString());
			
			String lastSql = String.format(organSQL.toString(), cyTypeSql, ryTypeSql);
			
			return this.getMapList(lastSql, criteria);
		}
	}

    @Override
    public List<Map<String, Object>> getPracticeList(String organCode, String superOrganCode, String gbCode, String genreCode) {
        Criteria criteria = new Criteria();

        if("0".equals(genreCode))
        {
            StringBuilder whereBaseSQL = null;
            StringBuilder gbBaseSQL = new StringBuilder(GB_BASE_SQL);
            StringBuilder gbSQL= new StringBuilder(GB_SQL);

            if(StringUtil.isNotEmpty(gbCode))
            {
                whereBaseSQL = new StringBuilder(" and org.gb_code = '" + gbCode + "' ");
            }else
            {
                whereBaseSQL = new StringBuilder(" and org.gb_code is not null ");
            }

            whereBaseSQL.append(" and org.genre_code in ('B100','B200') and org.status = '1'  and sta.status = '1' ");
            //职称
            String cyTypeSql = String.format(gbBaseSQL.toString(), "TECHNICAL", whereBaseSQL.toString());
            //执业类型
            String ryTypeSql = String.format(gbBaseSQL.toString(), "PRACTICE_TYPE", whereBaseSQL.toString());

            String lastSql = String.format(gbSQL.toString(), cyTypeSql, ryTypeSql);

            return this.getMapList(lastSql, criteria);
        }else
        {
            StringBuilder whereBaseSQL = null;
            StringBuilder organSQL = new StringBuilder(ORGAN_SQL);
            StringBuilder organBaseSQL = new StringBuilder(ORGAN_BASE_SQL);

            if("A100".equals(genreCode))
            {
                whereBaseSQL = new StringBuilder(" and org.genre_code = 'A100' ");

                if(StringUtil.isNotEmpty(superOrganCode))
                {
                    whereBaseSQL.append(" and org.ORGAN_CODE = '" + superOrganCode + "' ");
                }else
                {
                    whereBaseSQL.append(" and sta.ORGAN_CODE is not null ");
                }
            }else if("B100".equals(genreCode))
            {
                whereBaseSQL = new StringBuilder(" and org.genre_code = 'B100' ");

                if(StringUtil.isNotEmpty(gbCode))
                {
                    whereBaseSQL.append(" and org.gb_code = '" + gbCode + "' ");
                }

                if(StringUtil.isNotEmpty(superOrganCode))
                {
                    whereBaseSQL.append(" and org.ORGAN_CODE = '" + superOrganCode + "' ");
                }else
                {
                    whereBaseSQL.append(" and sta.ORGAN_CODE is not null ");
                }
            }else if("B200".equals(genreCode))
            {
                whereBaseSQL = new StringBuilder(" and org.genre_code = 'B200' ");

                if(StringUtil.isNotEmpty(gbCode))
                {
                    whereBaseSQL.append(" and org.gb_code = '" + gbCode + "' ");
                }

                if(StringUtil.isNotEmpty(superOrganCode))
                {
                    whereBaseSQL.append(" and org.parent_code = '" + superOrganCode + "' ");
                }

                if(StringUtil.isNotEmpty(organCode))
                {
                    whereBaseSQL.append(" and org.ORGAN_CODE = '" + organCode + "' ");
                }else
                {
                    whereBaseSQL.append(" and sta.ORGAN_CODE is not null ");
                }
            }

            whereBaseSQL.append(" and org.status = '1'  and sta.status = '1' ");
            //职称
            String cyTypeSql = String.format(organBaseSQL.toString(), "TECHNICAL", whereBaseSQL.toString());
            //执业类型
            String ryTypeSql = String.format(organBaseSQL.toString(), "PRACTICE_TYPE", whereBaseSQL.toString());

            String lastSql = String.format(organSQL.toString(), cyTypeSql, ryTypeSql);

            return this.getMapList(lastSql, criteria);
        }
    }

	@Override
	public Map<String, Object> getStaffCyTypeDate() {
		Map<String, Object> result = new HashMap<>();
		List<Map<String,Object>>  mapList = this.getMapList(STAFF_CY_TYPE,new Criteria());
		if(ObjectUtil.isNotEmpty(mapList)){
			result = mapList.get(0);
		}
		return result;
	}


}