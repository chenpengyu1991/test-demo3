package com.founder.rhip.sr.controller.form;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.util.StringUtil;

public class SrStaffQueryForm {

    private String name;
    private String gender;
    private String idCard;
    private String town;
    private String village;
    private String station;
    private String organCode;
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getIdCard() {
        return idCard;
    }
    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getVillage() {
        return village;
    }

    public void setVillage(String village) {
        this.village = village;
    }

    public String getStation() {
        return station;
    }

    public void setStation(String station) {
        this.station = station;
    }

    public Criteria getCriteria(){
        Criteria criteria = new Criteria();
        if(StringUtil.isNotEmpty(name)){
            criteria.add("NAME", OP.LIKE, name);
        }
        if(StringUtil.isNotEmpty(gender)){
            criteria.add("GENDER",gender);
        }
        if(StringUtil.isNotEmpty(idCard)){
            criteria.add("ID_CARD",idCard);
        }
        
        criteria.add("ORGAN_CODE",organCode);
        
        return criteria;
    }
	public String getOrganCode() {
		return organCode;
	}
	public void setOrganCode(String organCode) {
		this.organCode = organCode;
	}
    
}
