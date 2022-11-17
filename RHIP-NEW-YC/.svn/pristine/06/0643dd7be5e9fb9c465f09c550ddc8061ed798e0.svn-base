package com.founder.rhip.portal.repository;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.repository.SqlBuilder;
import com.founder.rhip.ehr.entity.portal.ChargeItem;
import com.founder.rhip.ehr.repository.portal.IChargeItemRelevantDao;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by f on 2016/11/24.
 */
@Repository("chargeItemDao")
public class ChargeItemRelevantDaoImpl extends AbstractDao<ChargeItem,Long> implements IChargeItemRelevantDao {
    @Resource(name = "portaldbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;

}
