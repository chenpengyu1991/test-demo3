package com.founder.rhip.mdm;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import com.founder.rhip.mdm.entity.Person;

@WebService
public interface IPersonWebService {
	
	@WebMethod
	public List<Person> query(
			@WebParam(name = "idCard")String idCard, 
			@WebParam(name = "name")String name) throws Exception;

}
