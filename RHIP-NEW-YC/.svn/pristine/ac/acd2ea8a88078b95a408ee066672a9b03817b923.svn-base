<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ page import="com.founder.rhip.ehr.common.RoleType" %>
<c:set var="ADMIN" value="<%=RoleType.ADMIN.getValue()%>"/>
<c:set var="QWGZX" value="<%=RoleType.QWGZX.getValue()%>"/>
<c:set var="ZXLNR" value="<%=RoleType.ZXLNR.getValue()%>"/>
<c:set var="ZLNR" value="<%=RoleType.ZLNR.getValue()%>"/>

<script src="${pageContext.request.contextPath}/js/views/hm/verify/list.js" type="text/javascript"></script>
<div class="repeattable">
	<table>
		<colgroup>
			<ehr:authorize ifAnyGranted="${ZXLNR},${ZLNR}">
			<col style="width: 30px;" />
			</ehr:authorize>
			<col style="width: 100px;" />
			<col style="width: 50px;" />
			<col style="width: 50px;" />
			<col style="width: 150px;" />
			<col style="width: 200px;" />
			<col style="width: 50px;" />
			<col style="width: 150px;" />
			<col style="width: 50px;" />
		</colgroup>
		<thead>
			<tr>
				<ehr:authorize ifAnyGranted="${ZXLNR},${ZLNR}">
				<th><input type="checkbox" id="checkAllRecords"/></th>
				</ehr:authorize>
				<th>姓名</th>
				<th>性别</th>
				<th>年龄</th>
				<th>身份证号</th>
				<th>社区</th>
				<th>是否核实</th>
				<th>体检编号</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="record" items="${records}">
				<tr>
					<ehr:authorize ifAnyGranted="${ZXLNR},${ZLNR}">
				    <td class="checkboxtd">
				    	<c:choose>
				    		<c:when test="${record.logoff == 0}"><input type="checkbox" chkRef="personId" value="${record.id}" /></c:when>
				    		<c:otherwise><input type="checkbox" chkRef="personId" value="${record.id}" disabled="disabled"/></c:otherwise>
				    	</c:choose>
				    </td>
				    </ehr:authorize>
					<td>${record.name}</td>
					<td><ehr:dic dicmeta="GBT226112003" code="${record.gender}" /></td>
					<td>${record.age}</td>
					<td>${record.idcard}</td>
					<td><ehr:org code="${record.inputOrganCode}"/></td>
					<td><c:if test="${record.confirm eq 1}">是</c:if><c:if test="${record.confirm eq 0}">否</c:if></td>
					<td>${record.examNumber}</td>
					<td style="text-align: center">
					  <ehr:authorize ifAnyGranted="${ZXLNR},${ZLNR}">
					  <c:choose>
				    		<c:when test="${record.logoff == 0}">
				    			<div id="hmVerifyList_${record.id}">
									<c:if test="${record.confirm eq 1}">
										<a href="javascript:void(0)" onclick="hmVerifyList.cancelConfirmPerson('${record.id}')">取消</a>
									</c:if>
									<c:if test="${record.confirm eq 0}">
										<a href="javascript:void(0)" onclick="hmVerifyList.confirmPerson('${record.id}')">核实</a>
									</c:if>
								  </div>
				    		</c:when>
				    	</c:choose>
					  </ehr:authorize>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<table>
		<tr>
			<ehr:pagination action="hmVerifySearch.search"  />
		</tr>
	</table>
	
</div>