
package com.founder.ids.test;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.LOP;
import com.founder.fasf.beans.OP;
import com.founder.ids.entity.User;
import com.founder.ids.service.ISecurityService;

public class SecurityServiceTest extends AbstractServiceTest {

	@Autowired
	private ISecurityService securityService;

	private User getUser() {
		User user = new User();
		user.setId(1l);
		user.setName("test");
		//user.setAvailable(1);
		user.setBirthDate(new Date());
		user.setGender(29);
		return user;
	}

	@Test
	public void testGetUsers() {
		Criteria criteria = new Criteria("id", ":'where1=1")
		.add(LOP.OR, "name", "founder")
		.add(LOP.OR, new Criteria("description", OP.LIKE, "k").add("mobile", OP.IN, new String[] { "12385475", "23987123" }))
		.add(LOP.OR, new Criteria("email", OP.LIKE, "@k").add("gender", OP.IN, new Integer[] { 2, 1 }))
		.add(LOP.OR, new Criteria("homeAddress", OP.FLIKE, "北京").add("gender", OP.IN, new Integer[] { 1 }))
		.add(new Criteria("identityCard", OP.ELIKE, "08").add("gender", OP.BETWEEN, new Date[] { new Date(), new Date() }));
// SELECT id, user_name, password, name, gender, birth_date,
 //identity_card, email, telephone, mobile, home_address, description,
// available
// FROM USER WHERE
// id=:id OR name=:name
// OR (description LIKE '%k%' AND mobile IN ('12385475','23987123'))
// OR (email LIKE '%@k%' AND gender IN (2,1))
// OR (home_address LIKE '北京%' AND gender IN (11))
// AND (identity_card LIKE '%08' AND (gender>=:mingender AND
// gender<=:maxgender))
		List<User> users = securityService.getUsers(criteria);
		System.out.println(users.size());
	}

	@Test
	public void testAddUser() {
		int s = securityService.createUser(getUser());
		System.out.println(s);
	}

	@Test
	public void testUpdateUser() {
		int s = securityService.updateUser(getUser());
		System.out.println(s);
	}

	@Test
	public void testDeleteUser() {
		Long[] userIds = new Long[] { 1l, 2l };
		int s = securityService.deleteUser(userIds);
		System.out.println(s);
	}
}
