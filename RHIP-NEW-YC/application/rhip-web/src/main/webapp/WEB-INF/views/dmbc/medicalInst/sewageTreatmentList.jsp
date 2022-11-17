<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<script src="${pageContext.request.contextPath}/js/views/dmbc/medicalInst/sewageTreatmentList.js" type="text/javascript"></script>
<div class="repeattable">
	<table>
		<colgroup>
			<col style="min-width:60px;width: 20%;"/>
	        <col style="min-width:120px;width: 20%;"/>
			<col style="min-width:40px;width: 20%;"/>	
	        <col style="min-width:100px;width: 20%;"/>			
		</colgroup>	
		<thead>
			<tr>
				<th>机构名称</th>
				<th>污水日均产量</th>
				<th>处理工艺流程图</th>
				<th>操作</th>			
			</tr>
		</thead>
		<tbody>
			<c:forEach var="sewageTreatment" items="${sewageTreatmentList.list}" varStatus="status">
				<tr>
					<td title="<ehr:org code="${sewageTreatment.orgName}"/>">
						<ehr:org code="${sewageTreatment.orgName}"/>
					</td>
					<td title="${sewageTreatment.avgDailyOutput}">
						${sewageTreatment.avgDailyOutput}
					</td>
					<td title="">
						<c:if test="${sewageTreatment.picUrl ne null}">
							<ehr:imageShow imgUrl="${sewageTreatment.picUrl}" title="示意图"/>
						</c:if>
						<c:if test="${sewageTreatment.picUrl eq null}">无</c:if>
					</td>
					<td style="text-align:center">
					    <a href="#this" onclick="sewageTreatmentList.viewOrEdit('${sewageTreatment.id}','view')">查看</a>
						<ehr:authorize ifAnyGranted="02,03">
							<a href="#this" onclick="sewageTreatmentList.viewOrEdit('${sewageTreatment.id}','edit')">修改</a>
							<a href="#this" onclick="sewageTreatmentList.del('${sewageTreatment.id}')">删除</a>
						</ehr:authorize>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<table>
		<tr>
			<ehr:pagination action="sewageTreatmentSearch.search" />
		</tr>
	</table>
</div>