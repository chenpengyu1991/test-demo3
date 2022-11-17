package com.founder.rhip.mdm.common;

public enum OperateType {
	
	batchImport("批量导入"),
	
	regist("注册"),
	
	create("创建"),
	
	update("更新"),
	
	delete("删除"),
	
	merge("合并"),
	
	move("迁移"),
	
	split("拆分"),
	
	other("其他");
	
	private String name;
	
	private OperateType(String name){
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
}
