package com.founder.rhip.ehr.common;

/**
 * Created with IntelliJ IDEA.
 * User: Andy
 * Date: 13-1-14
 * Time: 下午5:37
 * To change this template use File | Settings | File Templates.
 */
public enum WeightSetType {

	VACCINATION_NUM("1","VACCINATION_NUM"),
	CHILD_NUM("2","CHILD_NUM"),
	PREGNANT_WOMEN_NUM("3","PREGNANT_WOMEN_NUM"),
	GESTATIONAL_WOMEN_NUM("4","GESTATIONAL_WOMEN_NUM"),
	PREMARITAL_NUM("5","PREMARITAL_NUM");      //虚拟医生角色（为外部报卡使用）

    private String weightIndex;
    private String weightIndexColumn;

    WeightSetType(String weightIndex, String weightIndexColumn) {
    	this.weightIndex = weightIndex;
    	this.weightIndexColumn = weightIndexColumn;
    }
    
    public static WeightSetType getByWeightIndex(String weightIndex){
    	WeightSetType[] WeightSetTypes =  WeightSetType.values();
    	for(WeightSetType WeightSetType:WeightSetTypes){
    		if(WeightSetType.getWeightIndex().equals(weightIndex)){
    			return WeightSetType;
    		}
    	}
    	return null;
    }

	public String getWeightIndex() {
		return weightIndex;
	}

	public void setWeightIndex(String weightIndex) {
		this.weightIndex = weightIndex;
	}

	public String getWeightIndexColumn() {
		return weightIndexColumn;
	}

	public void setWeightIndexColumn(String weightIndexColumn) {
		this.weightIndexColumn = weightIndexColumn;
	}
}
