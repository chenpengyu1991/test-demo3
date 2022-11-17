package com.founder.rhip.ehr.common;

public class OHConstants {

	/* 添加操作 */
	public static final String add = "add";

	/* 编辑操作 */
	public static final String edit = "edit";

	/* 查看操作 */
	public static final String view = "view";

	/* 删除操作 */
	public static final String del = "del";

	/* 审核通过 */
	public static final String VERIFY_STATE_1 = "1";

	/* 审核未通过 */
	public static final String VERIFY_STATE_2 = "2";

	/* 未审核 */
	public static final String VERIFY_STATE_3 = "3";

	/* 备案 */
	public static final String VERIFY_STATE_4 = "4";

	/* 社区服务中心角色NAME */
	public static final String ROLE_3 = "03";

	/* 市级医院角色NAME */
	public static final String ROLE_19 = "19";

	/* 疾控职业卫生科角色NAME */
	public static final String ROLE_23 = "23";

	/* 已删除标记 */
	public static Integer delete_1 = 1;

	/* 删除标记 */
	public static Integer delete_0 = 0;

	/* 重点企业服务 监测示意图上传文件session key名 */
	public static String ENTITYPRISE_UPLOAD_SESSION_KEY = "ohjcshyt_fileMap";
	
	/* 放射卫生管理 放射科位置图上传文件session key名 */
	public static String RADIOLOGICAL_SITE_SESSION_KEY = "ohfskwzt_fileMap";
	
	/* 放射卫生管理 放射科布置图上传文件session key名 */
	public static String RADIOLOGICAL_LAYOUT_SESSION_KEY = "ohfskbzt_fileMap";
}
