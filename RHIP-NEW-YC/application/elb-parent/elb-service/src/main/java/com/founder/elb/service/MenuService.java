package com.founder.elb.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.founder.elb.entity.RoleAccess;
import com.founder.elb.repository.IAccessDao;
import com.founder.elb.repository.IRoleAccessDao;
import com.founder.elb.repository.IRoleDao;
import com.founder.fasf.beans.OP;
import com.founder.fasf.beans.Parameters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.founder.elb.dto.Node;
import com.founder.elb.entity.Access;
import com.founder.elb.entity.Menu;
import com.founder.elb.repository.IMenuDao;
import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Order;
import com.founder.fasf.util.ObjectUtil;
import org.springframework.transaction.annotation.Transactional;

@Service("menuService")
public class MenuService implements IMenuService {	

	@Autowired
	private IMenuDao menuDao;

    @Autowired
    private IAccessDao accessDao;

    @Autowired
    private IRoleAccessDao roleAccessDao;

	@Override
	public String getMenus(List<Access> accesslist) {
		if(ObjectUtil.isNullOrEmpty(accesslist)) return "";
		Criteria criteria = new Criteria("status", 1);
		List<Menu> oList = menuDao.getList(criteria,new Order("MENU_NO").asc("CODE"));
		Map<String, Integer> menuMap = new HashMap<String, Integer>();
		for (int i = 0; i < oList.size(); i++) {
			oList.get(i).setFlag(0);
			menuMap.put(oList.get(i).getCode(), i);
		}
		for (Access access : accesslist) {
			setSelectMenu(oList, menuMap, access.getSrcId().toString());
		}
		Node root=new Node();
		StringBuilder menus=new StringBuilder();
		for (Menu menu : oList) {
			if(menu.getFlag()==1){
				String pIds="0";
				Integer pId=menu.getParentCode();
				if(menu.getParentCode()>0){
					Menu pMenu=oList.get(menuMap.get(pId.toString()));
					pIds=pMenu.getCode();
				}
				menu.setCode(pIds+"/"+menu.getCode());
				root.process(menu);				
			}
		}		
		root.toHTML(menus);
		return menus.toString();
	}
	
	@Override
	public String getMenusWithName(List<Access> accesslist) {
		if(ObjectUtil.isNullOrEmpty(accesslist)) return "";
		Criteria criteria = new Criteria("status", 1);
		List<Menu> oList = menuDao.getList(criteria,new Order("MENU_NO").asc("CODE"));
		Map<String, Integer> menuMap = new HashMap<String, Integer>();
		for (int i = 0; i < oList.size(); i++) {
			oList.get(i).setFlag(0);
			menuMap.put(oList.get(i).getCode(), i);
		}
		for (Access access : accesslist) {
			setSelectMenu(oList, menuMap, access.getSrcId().toString());
		}
		Node root=new Node();
		StringBuilder menus=new StringBuilder();
		for (Menu menu : oList) {
			if(menu.getFlag()==1){
				String pIds="0";
				Integer pId=menu.getParentCode();
				if(menu.getParentCode()>0){
					Menu pMenu=oList.get(menuMap.get(pId.toString()));
					pIds=pMenu.getCode();
				}
				menu.setCode(pIds+"/"+menu.getCode());
				root.process(menu);				
			}
		}		
		root.toHTMLWithName(menus);
		return menus.toString();
	}

	private void setSelectMenu(List<Menu> oList, Map<String, Integer> menuMap,String menuCode) {
		if (menuMap.containsKey(menuCode)) {
			oList.get(menuMap.get(menuCode)).setFlag(1);
			Integer pId = oList.get(menuMap.get(menuCode)).getParentCode();
			if (pId > 0) {setSelectMenu(oList, menuMap, pId.toString());
			}
		}
	}

	@Override
	public List<Menu> getMenus() {
		Criteria criteria = new Criteria("status", 1);
		List<Menu> list = menuDao.getList(criteria,
				new Order("MENU_NO").asc("CODE"));
		return list;
	}

	@Override
	public Menu getMenu(String menuCode) {
		return menuDao.get(new Criteria("code", menuCode));
	}

	@Override
	public int createMenu(Menu menu) {
		int result = menuDao.insert(menu);
		return result;
	}

    @Transactional
    @Override
    public int addMenu(Menu menu) {
        int result = 0;
        Number menuId = menuDao.generatedKey(menu,"ID",null);
        if(ObjectUtil.isNotEmpty(menuId)){//插入角色表,更新CODE字段
            Access access = new Access();
            access.setId(menuId.intValue());
            access.setSrcId(menuId.intValue());
            access.setDescription(menu.getNameZh());
			access.setAccessCode(menu.getCode());
            access.setAccessLevel(2);
            accessDao.insert(access);

            RoleAccess roleAccess = new RoleAccess();
            roleAccess.setRoleCode("01");
            roleAccess.setAccessCode(menu.getCode());
            roleAccess.setOrganCode("0");
            roleAccessDao.insert(roleAccess);

            Parameters parameters = new Parameters();
            parameters.add("CODE", menuId);
            result = menuDao.update(parameters,new Criteria("ID",menuId));
        }
        return result;
    }

    @Override
    public int updateMenu(Menu menu,String ... properties) {
        int result = menuDao.update(menu,properties);
        return result;
    }

	@Override
    @Transactional
	public int deleteMenu(String[] menuCode) {
		int result = menuDao.delete(new Criteria("code", OP.IN,menuCode));
        accessDao.delete(new Criteria("access_code", OP.IN,menuCode));
        roleAccessDao.delete(new Criteria("access_code", OP.IN,menuCode));
		return result;
	}

	@Override
	public List<Menu> getMenus(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

}
