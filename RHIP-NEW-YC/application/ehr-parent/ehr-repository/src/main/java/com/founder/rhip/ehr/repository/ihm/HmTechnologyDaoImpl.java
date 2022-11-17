package com.founder.rhip.ehr.repository.ihm;
import org.springframework.stereotype.Repository;

import com.founder.fasf.repository.AbstractDao;
import com.founder.rhip.ehr.entity.ihm.HmTechnology;

/**
 * DAO implement of HmTechnology
 * 
 */
@Repository("hmTechnologyDao")
public class HmTechnologyDaoImpl extends AbstractDao<HmTechnology, Long> implements IHmTechnologyDao {

}