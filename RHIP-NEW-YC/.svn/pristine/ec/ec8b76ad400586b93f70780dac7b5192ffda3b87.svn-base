
package com.founder.fasf.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

class SubOrder implements Serializable {

	private static final long serialVersionUID = 1L;

	private boolean ascending;

	private boolean ignoreCase;

	private String propertyName;

	public String toString() {
		return new StringBuilder().append(this.propertyName).append(" ").append(ignoreCase ? "" : ascending ? "ASC" : "DESC").toString();
	}

	SubOrder ignoreCase() {
		this.ignoreCase = true;
		return this;
	}

	SubOrder(String propertyName) {
		this.propertyName = propertyName;
		this.ignoreCase = true;
	}

	SubOrder(String propertyName, boolean ascending) {
		this.propertyName = propertyName;
		this.ascending = ascending;
	}
}

public class Order implements Serializable {

	private static final long serialVersionUID = -5151895564387545714L;

	private List<SubOrder> subOrders;

	public Order(String fieldName) {
		if (subOrders == null)
			subOrders = new ArrayList<SubOrder>();
		subOrders.add(new SubOrder(fieldName));
	}

	public Order(String fieldName, boolean ascending) {
		if (subOrders == null)subOrders = new ArrayList<SubOrder>();
		subOrders.add(new SubOrder(fieldName, ascending));
	}

	public Order asc(String fieldName) {
		subOrders.add(new SubOrder(fieldName, true));
		return this;
	}

	public Order desc(String fieldName) {
		subOrders.add(new SubOrder(fieldName, false));
		return this;
	}
	
	public String toString() {		
		StringBuilder orderStr=new StringBuilder(" ORDER BY ");
		int i=0;
		for (SubOrder subOrder : subOrders) {
			if (i > 0){orderStr.append(",");}
			orderStr.append(subOrder.toString());
			i++;
		}
		return orderStr.toString();
	}
}