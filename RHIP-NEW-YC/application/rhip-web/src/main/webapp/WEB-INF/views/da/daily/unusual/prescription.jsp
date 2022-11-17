<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>

<script src="${pageContext.request.contextPath}/js/views/da/daCommon.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/da/daily/unusual/prescription.js" type="text/javascript"></script>
<script type="text/javascript">
	require(['views/lda/unusualSearch'],function(ldaUnusualSearch){
		ldaUnusualSearch.load();
	});
</script>
<div class="toolbar">
    <a href="javascript:void(0)" id="ldaUnusualSearchReturn"><b class="fanhui">返回</b></a>
</div>

<div class="postcontent contentfixed32" style="margin:10px 0px 0px 0px">
	<fieldset>
		<legend>处方详细</legend>
		<table class="posttable">
			<colgroup>
				<col style="min-width:60px; width: 10%;"/>
				<col style="min-width:120px; width: 25%;"/>
				<col style="min-width:60px; width: 10%;"/>
				<col style="min-width:100px; width: 20%;"/>
				<col style="min-width:60px; width: 10%;"/>
				<col style="min-width:120px; width: 25%;"/>
            </colgroup>
			<tbody>
				<tr>
                	<th>处方号码</th>
                    <td>${prescription.recordNumber}</td>
                	<th>开方日期</th>
                    <td><fmt:formatDate pattern="yyyy/MM/dd" value="${prescription.prescribeDate}"/></td>  
                	<th>就诊科室</th>
                    <td>${prescription.prescribeRoomName}</td>     
				</tr>
				<tr>
                	<th>病人姓名</th>
                    <td>${prescription.name}</td>
                	<th>性别</th>
                    <td><ehr:dic dicmeta="GBT226112003" code="${prescription.gender}"/></td>  
                	<th>年龄</th>
                    <td>${prescription.age}</td>  
				</tr>	
				<tr>
					<th>开方医生</th>
                    <td>${prescription.prescribeDoctorName}</td>  
                	<th>费别</th>
                    <td><ehr:dic dicmeta="CV0710003" code="${prescription.medicalCostPayWay}"/></td><%--需要从门诊摘要中获取--%>                       
                	<th>处方类型</th>
                    <td><ehr:dic dicmeta="FS10306" code="${prescription.cmType}"/></td>  
				</tr>							
			</tbody>
		</table>		
	</fieldset>
	<input type="hidden" id="drugUsagePageIndex" value="${drugUsagePageIndex}">
	<input type="hidden" id="ehrId" value="${ehrId}">
	<input type="hidden" id="recordNumber" value="${recordNumber}">
	<form id="drugUsageSearchForm">
	</form>
	<div id="drugUsageResultDiv" style="margin:10px 0px 0px 0px"></div>
</div>

