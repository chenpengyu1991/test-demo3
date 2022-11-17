<%@page pageEncoding="UTF-8"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/ehr-tag" prefix="ehr"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%> 
<script src="${pageContext.request.contextPath}/js/views/vaccine/hospital/contine_vaccine.js" type="text/javascript"></script>
<%@ page import="com.founder.rhip.ehr.common.RoleType" %>
<c:set var="JKYFJZ" value="<%=RoleType.JKYFJZ.getValue()%>"/>
<c:set var="ZXYFJZ" value="<%=RoleType.ZXYFJZ.getValue()%>"/>
<c:set var="YYFJZ" value="<%=RoleType.YYFJZ.getValue()%>"/>

<input type="hidden" id="ehrId" value="${ehrId}"/>
<input type="hidden" id="vaccineType" value="2"/>
<!-- 患者基本情况 -->
<div class="postcontent">
	<div style="text-align: center; font-size: 16px; font-weight: bold;">
		永城市成人乙肝疫苗接种登记表
	</div>
	
	<div class="postdiv">
	<fieldset class="layui-elem-field">
		<legend>患者基本情况</legend>
		<table style="width:99%" class="posttable">
            <colgroup >
                <col width="13%" />
                <col width="20%" />
                <col width="10%" />
                <col width="26%" />
                <col width="10%" />
                <col width="20%" />
            <colgroup>
			<tbody>
				<tr>
					<th>姓名：</th>
					<td>${vaccinationMgmt.name }</td>
                    <th>身份证号：</th>
                    <td>${vaccinationMgmt.idCard }</td>
					<th>性别：</th>
					<td><ehr:dic dicmeta="GBT226112003" code="${vaccinationMgmt.gender}"/></td>
				</tr>
				<tr>
                    <th>年龄：</th>
                    <td>${vaccinationMgmt.age } &nbsp;岁</td>
					<th>居住地址：</th>
					<td>
					<ehr:dic dicmeta="FS990001" code="${vaccinationMgmt.patownShip}"></ehr:dic>
					<ehr:dic dicmeta="FS990001" code="${vaccinationMgmt.pastreet}"></ehr:dic>
					${vaccinationMgmt.pahouseNumber}
					<th>联系电话：</th>
					<td>${vaccinationMgmt.phoneNumber}</td>
				</tr>		
			</tbody>
		</table>
	</fieldset>
	</div>

<!-- 乙肝二对半检测结果  -->
	<div class="postdiv">
	<fieldset class="layui-elem-field">
	<legend>乙肝二对半检测结果</legend>
	<br/>
	<table style="width:99%" class="posttable">
		<tbody>
			<tr>
				<c:forEach var="examineDetail" items="${examineDetailList}" varStatus="status">
					<input type="hidden" name="VaccinationDetailsDTO.examineDetailList[${status.index}].id" value="${examDetail.id}"/>
					<input type="hidden" name="VaccinationDetailsDTO.examineDetailList[${status.index}].inspectionItemName"
						 value="${examineDetail.inspectionItemName}"/>
					<th>${examineDetail.inspectionItemName}：</th>
					<td>
						<c:choose>
							<c:when test="${examineDetail.inspectionResult eq '1'}">阴性</c:when>
							<c:when test="${examineDetail.inspectionResult eq '2'}">阳性</c:when>
							<c:when test="${examineDetail.inspectionResult eq '3'}">不详</c:when>
						</c:choose>
					</td>
				</c:forEach>
			</tr>		
		</tbody>
	</table>
	<br/>
	</fieldset>
	</div>
	
	<!-- 接种信息  -->
	<div id="vaccineHepatitisDivId">
		<jsp:include page="vaccine_hepatitis.jsp"/>
	</div>
	<!-- 接种信息  -->
</div>