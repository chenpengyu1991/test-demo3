package com.founder.rhip.im.repository;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.repository.SqlBuilder;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.im.entity.ReportBaseEntity;
import com.founder.rhip.im.entity.ReportBaseModel;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

/**
 * DAO implement of AbstractReportDao
 * 报表基类
 * 
 */
public abstract class AbstractReportDao<T, PK extends Serializable> extends AbstractDao<T, PK> {

    private Class<T> tClazz;
    @SuppressWarnings("unchecked")
    public AbstractReportDao() {
        tClazz = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    private static final String GROUP_BY_GBCODE = "DECODE(GROUPING_ID(GB_CODE),1,'grouping',GB_CODE) GB_CODE,";
    private static final String GROUP_BY_ORGAN_CODE = "DECODE(GROUPING_ID(GB_CODE),1,'grouping',GB_CODE) GB_CODE,"
            + "DECODE(GROUPING_ID(ORGAN_CODE),1,'grouping',ORGAN_CODE) ORGAN_CODE,";

    /**
     * 获取列表类统计SQL
     * @param ca
     * @return
     */
    protected String getSql(Criteria ca,String sqlDefine){
/*      %1$s 按镇分组：GB_CODE,按医院分组：GB_CODE,ORGAN_CODE
        %2$s 机构条件
        %3$s 分组函数字段
        %4$s 按镇分组：GB_CODE,按医院分组：ORGAN_CODE
        %5$s 报表条件*/
        //机构分组字段
        String groupField = getGroupField(ca);
        //机构条件
        String orgWhere = getOrgWhereSql(ca);
        //分组函数字段
        String grouping = getGrouping(ca);
        //报表机构分组字段
        String reportGroupField = getReportGroupField(ca);
        //GROUPING条件
        String groupingWhere = getGroupingWhere(ca);
        //按镇统计,移除GENRE_CODE
        if("0".equals(ca.get(ReportBaseModel.GENRE_CODE))){
            ca.remove(ReportBaseModel.GENRE_CODE);
        }
        //报表条件
        StringBuilder reportWhere = new StringBuilder();
        SqlBuilder.buildWhereStatement(ReportBaseEntity.class, reportWhere, ca);

        String lastSql = String.format(sqlDefine,groupField,orgWhere,grouping,reportGroupField,reportWhere.toString(),groupingWhere);
        return lastSql;
    }

    /**
     * 获取机构分组条件
     * @param ca
     * @return
     */
    private String getGroupField(Criteria ca){
        String field = "GB_CODE,ORGAN_CODE";
        String genreCode = ca.get(ReportBaseModel.GENRE_CODE).toString();
        //按镇统计
        if("0".equals(genreCode)){
            field = "GB_CODE";
        }
        return  field;
    }

    /**
     * 获取机构分组条件
     * @param ca
     * @return
     */
    private String getReportGroupField(Criteria ca){
        String field = "ORGAN_CODE";
        String genreCode = ca.get(ReportBaseModel.GENRE_CODE).toString();
        //按镇统计
        if("0".equals(genreCode)){
            field = "GB_CODE";
        }
        return  field;
    }

    /**
     * 获取分组函数字段
     * @param ca
     * @return
     */
    private String getGrouping(Criteria ca){
        String result = GROUP_BY_ORGAN_CODE;
        String genreCode = ca.get(ReportBaseModel.GENRE_CODE).toString();
        //按镇统计
        if("0".equals(genreCode)){
            result = GROUP_BY_GBCODE;
        }
        return  result;
    }
    /**
     * 获得机构条件
     * @param ca
     * @return
     */
    private String getOrgWhereSql(Criteria ca){
        StringBuilder result = new StringBuilder(" WHERE 1=1 ");
        String LOP = " AND ";

        Object gbCode = ca.get(ReportBaseModel.GB_CODE);
        if(ObjectUtil.isNotEmpty(gbCode)){
            result.append(LOP + " GB_CODE = '" + gbCode + "'");
            ca.remove(ReportBaseModel.GB_CODE);
        }

        Object organCode = ca.get(ReportBaseModel.ORGAN_CODE);
        if(ObjectUtil.isNotEmpty(organCode)){
            result.append(LOP + " ORGAN_CODE = '" + organCode + "'");
            ca.remove(ReportBaseModel.ORGAN_CODE);
        }

        Object genreCode = ca.get(ReportBaseModel.GENRE_CODE);
        if(ObjectUtil.isNotEmpty(genreCode) && !("0".equals(genreCode))){
            result.append(LOP + " GENRE_CODE = '" + genreCode + "'");
        }
        return result.toString();
    }

    private String getGroupingWhere(Criteria ca){
        String result = "WHERE (GB_CODE  = 'grouping' AND ORGAN_CODE = 'grouping')" +
                "   OR(GB_CODE <> 'grouping' AND ORGAN_CODE = 'grouping')" +
                "   OR(GB_CODE <> 'grouping' AND ORGAN_CODE <> 'grouping')";
        String genreCode = ca.get(ReportBaseModel.GENRE_CODE).toString();
        //按镇统计
        if("0".equals(genreCode)){
            result = "";
        }
        return result;
    }

}