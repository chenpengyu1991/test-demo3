package com.founder.rhip.ehr.repository.healtheducation;

import com.founder.fasf.repository.AbstractDao;
import com.founder.rhip.ehr.entity.healtheducation.HeMedia;
import org.springframework.stereotype.Repository;

@Repository("heMediaDao")
public class HeMediaDaoImpl extends AbstractDao<HeMedia,Long> implements  IHeMediaDao {
}
