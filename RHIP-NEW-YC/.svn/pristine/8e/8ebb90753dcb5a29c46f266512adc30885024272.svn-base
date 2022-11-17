<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<input type="hidden" id="personInfoId" value=""/> 
<div class="repeattable">
	<table class="layui-table x-admin-sm-table-list-middle">
		<colgroup>
			<col style="width:40px;"/>
			<col style="width:90px;"/>
			<col style="width:30px;"/>
			<col style="width:40px;"/>
			<col style="width:60px;"/>
			<col style="width:100px;"/>
			<col style="width:35px;"/>
			<col style="width:35px;"/>
			<col style="width:40px;"/>
		</colgroup>
		<thead style="text-align: center">
			  <tr>
				 <th>姓名</th>
				 <th>身份证号</th>
				 <th>性别</th>
				 <th>出生年月</th>			
				 <th>联系电话</th>
				 <th>常住地址</th>
				 <th>随访状态</th>
				 <th>评价状态</th>
				 <th>操作</th>
			  </tr>
	   </thead>
	   <tbody style="text-align: center">
			 <c:forEach var="personInfoList" items="${personInfo}">
			 	<tr  id = "followUpSelectPerson${personInfoList.personId}"  data-id = "${personInfoList.personId}" >
			 		<td class="centertd"><ehr:tip>${personInfoList.name}</ehr:tip></td>
			 		<td class="centertd"><ehr:tip>${personInfoList.idcard}</ehr:tip></td>
			 		<td class="centertd"><ehr:tip><ehr:dic dicmeta="GBT226112003" code="${personInfoList.gender}"/></ehr:tip></td>
			 		<td class="centertd"><ehr:tip><fmt:formatDate value="${personInfoList.birthday}" pattern="yyyy/MM/dd"/></ehr:tip></td>
			 		<td class="centertd"><ehr:tip>${personInfoList.phoneNumber}</ehr:tip></td>
			 		<td >
                        <ehr:tip><c:out value="${personInfoList.paprovince}"></c:out><c:out value="${personInfoList.pacity}"></c:out><c:out value="${personInfoList.pacounty}"></c:out><ehr:dic dicmeta="FS990001" code="${personInfoList.patownShip}"></ehr:dic><ehr:dic dicmeta="FS990001" code="${personInfoList.pastreet}"></ehr:dic><c:out value="${personInfoList.pahouseNumber}"></c:out></ehr:tip>					
                    </td>
			 		<td class="centertd">
			 			<c:choose>
			 				<c:when test="${personInfoList.followUpStatus eq '1'}">已建</c:when>
			 				<c:otherwise>待建</c:otherwise>
			 			</c:choose>			 	
			 		</td>
			 		<td class="centertd">
			 			<c:choose>
			 				<c:when test="${personInfoList.conclusionStatus eq '1'}">已建</c:when>
			 				<c:otherwise>待建</c:otherwise>
			 			</c:choose>			 	
			 		</td>
			 		<td title="制定随访记录" class="centertd">
			 		<%-- <a href="javascript:void(0)" id = "followUpPlanInfoClick${personInfoList.personId}"  data-id = "${personInfoList.personId}" >记录制定</a> --%>
			 		<a href="javascript:void(0)" id = "followUpPlanInfoClick${personInfoList.personId}"  data-id = "${personInfoList.personId}"  title="记录制定"><i class="layui-icon" style="color: #009688;">&#xe631;</i></a>
			 		</td>
			 	</tr>
			 </c:forEach>
			 <ehr:pagination action="followUp.searchFollowUpPersonInfo" colspan="9"/>
	   </tbody>
	</table>
	<%--<ehr:paging />--%>
</div>