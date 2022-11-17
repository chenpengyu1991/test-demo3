
package com.founder.elb.service;

import java.util.List;

import com.founder.elb.entity.Access;
import com.founder.elb.entity.Menu;

public interface IMenuService {

	List<Menu> getMenus(String userId);
	// Integer accessType;//1:地址访问权限；2:业务操作权限；3:字段访问权限
	
	String getMenus(List<Access> accesslist);
	
	String getMenusWithName(List<Access> accesslist);
	
	List<Menu> getMenus();
	
	Menu getMenu(String menuCode);
	//查看菜单细节
	
	int createMenu(Menu menu);


    /**
     * 添加菜单
     * @param menu
     * @return
     */
    public int addMenu(Menu menu);
    /**
     * 更新菜单信息
     * @param menu
     * @param properties
     * @return
     */
    public int updateMenu(Menu menu,String ... properties);

    int deleteMenu(String[] menuCode);
}
