package com.founder.rhip.ehr.controller.external;

/**
 * @author liuk
 *
 */
public class IcdType {
	private String icdCode;
	private String category;// 类别：慢病,传染病...
	private String type;// 疾病(甲、乙、丙) 慢病（高血压,糖尿病、...）
	private String subType;// 子类
    private String idmCode;//传染病对应字典编码

	public String getIcdCode() {
		return icdCode;
	}

	public void setIcdCode(String icdCode) {
		this.icdCode = icdCode;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSubType() {
		return subType;
	}

	public void setSubType(String subType) {
		this.subType = subType;
	}

    public String getIdmCode() {
        return idmCode;
    }

    public void setIdmCode(String idmCode) {
        this.idmCode = idmCode;
    }

    public IcdType(String category, String type) {
		super();
		this.type = type;
		this.category = category;
	}
    public IcdType(String category, String type, String subType ) {
    	super();
    	this.type = type;
    	this.category = category;
    	this.subType=subType;
    }

    public IcdType(String icdCode, String category, String type, String idmCode) {
        super();
        this.icdCode = icdCode;
        this.category = category;
        this.type = type;
        this.idmCode = idmCode;
    }

	public IcdType() {
		super();
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
}

