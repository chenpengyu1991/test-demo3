package com.founder.rhip.ehr.dto;

import java.util.List;

import com.founder.elb.entity.Menu;

public class MenuForm {

    private Menu menu;

    private List<MenuForm> childMenuForms;

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public List<MenuForm> getChildMenuForms() {
        return childMenuForms;
    }

    public void setChildMenuForms(List<MenuForm> childMenuForms) {
        this.childMenuForms = childMenuForms;
    }


}
