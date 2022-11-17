package com.founder.rhip.ehr.entity.control.idm.notifiabledisease;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "IDM_LIST_BDD")
public class ListBdd implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|数据库唯一编号（自增长）||", length = 11, nullable = false)
	private Integer id;

	@Column(name = "IDM_ID", columnDefinition = "NUMBER|本系统唯一编码||", length = 11, nullable = false)
	private Integer idmId;

	@Column(name = "MEAL_NUM", columnDefinition = "VARCHAR2|餐次|2|", length = 2, nullable = true)
	private String mealNum;

	@Column(name = "ATTACK", columnDefinition = "VARCHAR2|发病时间|2|", length = 2, nullable = true)
	private String attack;
	
	@Column(name = "DIET_DATE", columnDefinition = "DATE|餐饮日期||", length = 2, nullable = true)
	private Date dietDate;
	
	@Column(name = "ADDR", columnDefinition = "VARCHAR2|地点||", length = 100, nullable = true)
	private String addr;

	@Column(name = "FOOD_NAME", columnDefinition = "VARCHAR2|食物名称||", length = 100, nullable = true)
	private String foodName;

	@Column(name = "MEAL_PEOPLE", columnDefinition = "VARCHAR2|同餐对象||", length = 100, nullable = true)
	private String mealPeople;

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdmId() {
		return this.idmId;
	}

	public void setIdmId(Integer idmId) {
		this.idmId = idmId;
	}

	public String getMealNum() {
		return this.mealNum;
	}

	public void setMealNum(String mealNum) {
		this.mealNum = mealNum;
	}

	public String getAttack() {
		return this.attack;
	}

	public void setAttack(String attack) {
		this.attack = attack;
	}

	public String getAddr() {
		return this.addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getFoodName() {
		return this.foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	public String getMealPeople() {
		return this.mealPeople;
	}

	public void setMealPeople(String mealPeople) {
		this.mealPeople = mealPeople;
	}

	public Date getDietDate() {
		return dietDate;
	}

	public void setDietDate(Date dietDate) {
		this.dietDate = dietDate;
	}
}