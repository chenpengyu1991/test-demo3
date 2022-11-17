
package com.founder.rhip.ehr.common;

/**
 * 上传文件来源类型
 * 
 * @author GaoFei
 * 
 */
public enum ResourceCategory {
	HEALTH_ACTIVE("1"), // 健康教育活动
	HEALTH_INDIVIDUAL("8"),//个体化健康教育
	HEALTH_EDUCATION_RECORD("2"), // 健康教育记录
	HEALTH_EDUCATION_SUPERVISOR("3"), // 健康督查
	HEALTH_RESOURCE_MATERIAL("4"), // 健康教育资源宣传资料
	HEALTH_COPY("5"), // 稿件提供
	HEALTH_SURVEY("6"), // 调研问卷
	HEALTH_RESOURCE_VIDEO("7"); // 健康教育资源播放影像
	private String code;

	private ResourceCategory(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}
}
