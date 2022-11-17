<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<table class="posttable">
	<colgroup>
		<col style="width: 8%;" />
		<col style="width: 56%;" />
		<col style="width: 25%;" />
	</colgroup>
	<tr>
		<td><label>项目</label></td>
		<td align="center"><label>巡查内容</label></td>
		<td><label>巡查结果</label></td>
	</tr>
	<tr>
		<td><input type="checkbox" data-target='td-dosp' data-target1='td-dostv' ${inspRecord.inspGuideRecord.dosp !=5 &&inspRecord.inspGuideRecord.dosp !=null ? 'checked':''}></input></td>
		<td><label>饮用水水质感官性状检测:</label></td>
	</tr>
	<tr>
		<td></td>
		<td><label>①异味: </label></td>
		<td class="${inspRecord.inspGuideRecord.dosp !=5 &&inspRecord.inspGuideRecord.dosp !=null ? '':'hide'}" id="td-dosp"><ehr:dic-radio hideCodes="3,4,5"
				reg='{"required":"true","extension":["cuValidate","请填写"]}' dicmeta="HSA00003" name="inspGuideRecord.dosp" value="${inspRecord.inspGuideRecord.dosp}"  /></td>
	</tr>
	<tr>
		<td></td>
		<td><label>②肉眼可见物: </label></td>
		<td class="${inspRecord.inspGuideRecord.dostv !=5 &&inspRecord.inspGuideRecord.dostv !=null ? '':'hide'}" id="td-dostv"><ehr:dic-radio hideCodes="3,4,5"
				reg='{"required":"true","extension":["cuValidate","请填写"]}' dicmeta="HSA00003" name="inspGuideRecord.dostv" value="${inspRecord.inspGuideRecord.dostv}" /></td>
	</tr>
</table>