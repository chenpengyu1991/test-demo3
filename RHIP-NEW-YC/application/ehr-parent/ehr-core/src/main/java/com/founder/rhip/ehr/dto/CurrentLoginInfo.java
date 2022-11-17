package com.founder.rhip.ehr.dto;

import java.util.List;

import com.founder.elb.entity.Role;
import com.founder.rhip.ehr.entity.basic.User;
import com.founder.rhip.mdm.entity.Organization;

public class CurrentLoginInfo {

    private User user;
    private Organization organization;
    private List<Role> roles;

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

}
