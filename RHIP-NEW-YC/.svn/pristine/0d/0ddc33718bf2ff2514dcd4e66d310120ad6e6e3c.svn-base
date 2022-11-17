package com.founder.rhip.ehr.repository.wsMonitor;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.repository.SqlBuilder;
import com.founder.fasf.util.DateUtil;
import com.founder.rhip.ehr.entity.wsMonitor.WsClientInfo;
import com.founder.rhip.ehr.entity.wsMonitor.WsOperationLog;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.Date;

/**
 * DAO implement of WsClientInfo
 * 
 */
@Repository("wsClientInfoDao")
public class WsClientInfoDaoImpl extends AbstractDao<WsClientInfo, Long> implements IWsClientInfoDao {
    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;

    private final static String  assess= "SELECT info.ORG_CODE" +
            ",info.USER_IP" +
            ",info.IS_OFF" +
            ",DECODE(accesstb_st.ACCESS_COUNT,null,0,accesstb_st.ACCESS_COUNT) ACCESS_COUNT " +
            " FROM WS_CLIENT_INFO info " +
            " LEFT JOIN  (" +
            "   SELECT  accesstb.*,client.ORG_CODE,client.IS_OFF FROM(" +
            "       SELECT COUNT(*) ACCESS_COUNT,USER_IP FROM WS_OPERATION_LOG" +
            "       %1$s" +//日志筛选条件：时间
            "       GROUP BY USER_IP" +
            "   )  accesstb" +
            "   LEFT JOIN WS_CLIENT_INFO client on client.USER_IP = accesstb.USER_IP" +
            ") accesstb_st on (info.ORG_CODE = accesstb_st.org_code and INFO.USER_IP = accesstb_st.USER_IP) " +
            " %2$s";//机构条件

    /**
     * 统计客户访问次数
     * @param page
     * @param beginDate
     * @param endDate
     * @param criteria
     * @return
     */
    public PageList<WsClientInfo> getAccessMap(Page page, String beginDate, String endDate, Criteria criteria){
        Criteria caLog = new Criteria();
        /*请求开始时间*/
        Date begin = DateUtil.parseDateString(beginDate);
        Date end = DateUtil.parseDateString(endDate);
        DateUtil.getCriteriaByDateRange(caLog, "startTime", begin,end);
        StringBuilder sql = new StringBuilder(assess);
        StringBuilder  logWhere = new StringBuilder();
        SqlBuilder.buildWhereStatement(WsOperationLog.class, logWhere, caLog);
        StringBuilder  orgWhere = new StringBuilder();
        SqlBuilder.buildWhereStatement(WsClientInfo.class, orgWhere, criteria);

        criteria.add(caLog);
        String lastSql = String.format(sql.toString(),logWhere.toString(),orgWhere.toString());
        return this.getPageList(page,lastSql,criteria);
    }
}