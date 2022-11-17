package com.founder.rhip.idm.common;

public enum AssignmentStatus {
	/** 
	 * 待纳入
	 */
	ASSIGNING(1),
	 /**
	  * 已纳入
	  */
	ASSIGNED(2);
	
	private Integer value;
	
	AssignmentStatus(Integer value){
		this.value = value;
	}

	public Integer getValue() {
		return value;
	}
	

}
