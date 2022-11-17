
package com.founder.fasf.service;

import javax.annotation.Resource;

import org.apache.log4j.Logger;

import com.founder.fasf.exception.ValidationException;
import com.founder.fasf.repository.IGenericDao;

public abstract class AbstractService {
	
	@Resource(name = "genericDao")
	protected IGenericDao genericDao;

    protected final static String YEAR_FORMAT = "yyyy";

    protected final static String MONTH_FORMAT = "yyyy/MM";

    protected final static String DAY_FORMAT = "yyyy/MM/dd";

	protected Logger log = Logger.getLogger(this.getClass());
	
	protected void validate(Object obj) throws ValidationException {
		log.debug("Validating object : " + obj);
	}
}
