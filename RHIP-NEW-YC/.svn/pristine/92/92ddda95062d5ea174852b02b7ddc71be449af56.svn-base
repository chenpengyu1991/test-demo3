<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<div class="postdiv">
	<fieldset class="layui-elem-field">
		<table class="posttable">
			<colgroup>
				<col style="width: 12%;" />
				<col style="width: 38%;" />
				<col style="width: 12%;" />
				<col style="width: 38%;" />
			</colgroup>
			<tr>
				<th class="coltext">卫生专业</th>
				<td><ehr:dic-list width="200px" dicmeta="HSA00006" uninclude="1,4,99" parentCode="0" id="hsa-inspection-location-healthProfessional"
						name="locationInfo.healthProfessional"
					/>&nbsp;&nbsp;<a href="javascript:void(0)" id="addReportCard" style="display: none">新增报卡</a></td>
				<th class="coltext">行业分类</th>
				<td class="colinput"><select style="width:200px" id="hsa-inspection-location-mainBusinessCode" name="locationInfo.mainBusinessCode"><option value="">请选择</option></select></td>
			</tr>
			<tr style="line-height: 30px;">
				<th class="coltext">法人/负责人</th>
				<td class="colinput"><input type="text" name="locationInfo.personInCharge"></td>
					<th class="coltext">巡查地点或单位</th>
				<td class="colinput"><input type="text" name="locationInfo.unitName"></td>
		
			</tr>
			<tr>
				<td colspan="3"></td>
				<td>
				<!-- <input type="button" id="hsa-inspection-location-select-btn" value="查询" class="search_btn" width="80"> -->
				<button class="layui-btn layui-btn-sm button" id="hsa-inspection-location-select-btn"><i class="layui-icon"></i>查询</button>
				</td>
			</tr>
		</table>
		<fieldset class="layui-elem-field">
			<legend>地点信息选择</legend>
			<div class="repeattable" id="hsa-inspection-location-select-list-content"></div>
		</fieldset>
	</fieldset>
</div>
