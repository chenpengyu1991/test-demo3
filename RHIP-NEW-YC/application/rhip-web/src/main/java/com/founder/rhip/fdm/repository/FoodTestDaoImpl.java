package com.founder.rhip.fdm.repository;

import com.founder.fasf.repository.AbstractDao;
import com.founder.rhip.fdm.entity.FoodTest;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Created by sa on 2014/10/28.
 */
@Repository("fcFoodTest")
public class FoodTestDaoImpl extends AbstractDao<FoodTest,Long> implements IFoodTestDao{
    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
}
