package com.founder.rhip.ehr.common;

/**
 * Created with IntelliJ IDEA.
 * User: Andy
 * Date: 13-1-14
 * Time: 下午5:37
 * To change this template use File | Settings | File Templates.
 */
public enum ReserveStauts {
	CAN("1","可以预约"),
	CANNOT("0","不可以预约"),
    SWDZ("01","尚未到诊"),
    YDZ("02","已到诊"),
    YQWDZ("03","逾期未到诊"),
    QX("04","已取消"),
    TZ("05","已停诊"),      //虚拟医生角色（为外部报卡使用）
	BKTC("06","取消预约");
    
    private String stauts;
    private String description;

    ReserveStauts(String stauts,String description) {
    	this.stauts = stauts;
    	this.description = description;
    }
    
    public static ReserveStauts getByStauts(String stauts){
    	ReserveStauts[] ReserveStautss =  ReserveStauts.values();
    	for(ReserveStauts reserveStauts:ReserveStautss){
    		if(reserveStauts.getStauts().equals(stauts)){
    			return reserveStauts;
    		}
    	}
    	return null;
    }

	public String getStauts() {
		return stauts;
	}

	public void setStauts(String stauts) {
		this.stauts = stauts;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
