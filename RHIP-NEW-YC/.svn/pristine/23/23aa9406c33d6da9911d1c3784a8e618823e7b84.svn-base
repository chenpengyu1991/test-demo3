package com.founder.rhip.ehr.repository.control;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.repository.SqlBuilder;
import com.founder.rhip.ehr.entity.control.RemindStatistics;
import com.founder.rhip.mdm.app.IDictionaryApp;
import com.founder.rhip.mdm.entity.DicItem;
import com.founder.rhip.mdm.entity.Organization;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by wang_zhou on 2015/6/5.
 */
@Repository("remindStatisticsDao")
public class RemindStatisticsDaoImpl extends AbstractDao<RemindStatistics, Integer> implements IRemindStatisticsDao {
    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
}