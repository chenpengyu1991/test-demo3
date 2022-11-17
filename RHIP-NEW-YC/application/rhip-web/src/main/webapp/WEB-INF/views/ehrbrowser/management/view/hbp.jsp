<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<script type="text/javascript">
$(function(){
	$(".toolbar").show();
});
</script>
	<table class="posttable">
		<colgroup>
			<col style="width: 15%" />
			<col style="width: 35%" />
			<col style="width: 15%" />
			<col style="width: 35%" />
		</colgroup>
		<tr>
			<th><label for="hbpManageLevel">高血压管理等级</label></th>
			<td><ehr:dic dicmeta="DMD00025" code="${brwDiseaseInfo.hbpManageLevel}"/></td>
			<th><label for="hbpType">高血压类型</label></th>
			<td><ehr:dic dicmeta="DMD00006" code="${brwDiseaseInfo.hbpType}" /></td>
			</tr>
		<tr>
			<th><label for="hbpSbp">血压</label></th>
			<td colspan="3"><c:out value="${brwDiseaseInfo.hbpSbp}" />~<c:out value="${brwDiseaseInfo.hbpDbp}" /></td>
		</tr>
		<tr>
			<th><label for="hbpDiagnosedOrganCode">确诊医院</label></th>
			<td><ehr:org code="${brwDiseaseInfo.hbpDiagnosedOrganCode}"/></td>
			<%-- <td><ehr:dic dicmeta="FS10002" code="${brwDiseaseInfo.hbpDiagnosedOrganCode}" /></td> --%>
			<th><label for="hbpDiagnosedDate">确诊时间</label></th>
			<td><fmt:formatDate value="${brwDiseaseInfo.hbpDiagnosedDate}" pattern='yyyy/MM/dd'/></td>
		</tr>
	</table>
	<div class = "postcontent">
		<div class="postdiv">
			<fieldset class="layui-elem-field">
				<legend><span style="font-size: 12px;font-weight: bolder;">高血压并发症情况</span></legend>
				<table class="posttable">
					<colgroup>
						<col style="width: 15%" />
						<col style="width: 35%" />
						<col style="width: 15%" />
						<col style="width: 35%" />
					</colgroup>
					<tr>
						<th><label for="hbpCerebrovascularFlag">脑血管疾病</label></th>
						<td><ehr:dic dicmeta="DMD00019" code="${brwDiseaseInfo.hbpCerebrovascularFlag}" /></td>
						<th><label for="hbpHeartFlag">心脏疾病</label></th>
						<td><ehr:dic dicmeta="DMD00020" code="${brwDiseaseInfo.hbpHeartFlag}"  /></td>
					</tr>
					<tr>
						<th><label for="hbpKidneyFlag">肾脏疾病</label></th>
						<td><ehr:dic dicmeta="DMD00021" code="${brwDiseaseInfo.hbpKidneyFlag}"  /></td>
						<th><label for="hbpVascularFlag">血管疾病</label></th>
						<td><ehr:dic dicmeta="DMD00022" code="${brwDiseaseInfo.hbpVascularFlag}"  /></td>
					</tr>
					<tr>
						<th><label for="hbpRetinopathyFlag">高度性视网膜病变</label></th>
						<td><ehr:dic dicmeta="DMD00023" code="${brwDiseaseInfo.hbpRetinopathyFlag}" 	/></td>
						<th><label for="hbpSelfliveFlag">生活自理能力</label></th>
						<td colspan="3"><ehr:dic dicmeta="DMD00024" code="${brwDiseaseInfo.hbpSelfliveFlag}" /></td>
					</tr>
				</table>
		</fieldset>
	</div>
</div>