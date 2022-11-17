<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<input type="hidden" id="personInfoId" value=""/> 
<div class="repeattable">
	<table class="layui-table x-admin-sm-table-list-middle">
		<colgroup>
			<col style="width:30px;"/>
			<col style="width:70px;"/>
			<col style="width:25px;"/>
			<col style="width:50px;"/>
			<col style="width:30px;"/>
			<col style="width:50px;"/>
			<col style="width:100px;"/>
			<col style="width:40px;"/>
			<col style="width:45px;"/>
		</colgroup>
		<thead style="text-align: center">
			  <tr>
				 <th>姓名</th>
				 <th>身份证号</th>
				 <th>性别</th>
				 <th>出生年月</th>
				 <th>危险等级</th>
				 <th>联系电话</th>
				 <th>常住地址</th>
				 <th>状态</th>
				 <th>操作</th>
			  </tr>
	   </thead>
	   <tbody style="text-align: center">
			 <c:forEach var="personInfoList" items="${personInfo}">
			 	<tr id="tr${personInfoList.personId}">
			 		<td class="centertd"><%--<a title="${personInfoList.name}" href="javascript:void(0)" id = "highRiskPersonInfoSelect${personInfoList.personId}"  data-id = "${personInfoList.personId}" >${personInfoList.name}</a>--%>
							${personInfoList.name}</td>
			 		<td class="centertd"><ehr:tip>${personInfoList.idcard}</ehr:tip></td>
			 		<td class="centertd"><ehr:tip><ehr:dic dicmeta="GBT226112003" code="${personInfoList.gender}"/></ehr:tip></td>
			 		<td class="centertd"><ehr:tip><fmt:formatDate value="${personInfoList.birthday}" pattern="yyyy/MM/dd"/></ehr:tip></td>
			 		<td class="centertd">
			 			<c:if test="${1==personInfoList.riskLevel }">一级</c:if>
			 			<c:if test="${2==personInfoList.riskLevel }">二级</c:if>
			 			<c:if test="${3==personInfoList.riskLevel }">三级</c:if>
			 		</td>
			 		<td class="centertd">${personInfoList.phoneNumber}</td>
			 		<td>
                        <ehr:tip>
							<ehr:dic dicmeta="FS990001" code="${personInfoList.patownShip}"/>
							<ehr:dic dicmeta="FS990001" code="${personInfoList.pastreet}"/>
							<ehr:dic dicmeta="FS990001" code="${personInfoList.paGroup}"/>
							<c:out value="${personInfoList.pahouseNumber}"/>
						</ehr:tip>
                    </td>
                    <td class="centertd">
                    	<c:choose>
                    		<c:when test="${personInfoList.riskManageStatus == 1}">结束管理</c:when>
                    		<c:otherwise>已管理</c:otherwise>
                    	</c:choose>	
                    </td>
					<td class="centertd">
						<%-- <a title="${personInfoList.name}" href="javascript:void(0)" id = "highRiskPersonInfoSelect${personInfoList.personId}"  data-id = "${personInfoList.personId}" >管理</a> --%>
						<a href="#" title="管理" id = "highRiskPersonInfoSelect${personInfoList.personId}"  data-id = "${personInfoList.personId}" ><i class="layui-icon" style="color: #009688;">&#xe608;</i></a>
						&nbsp;&nbsp;
						<%-- <a href="javascript:void(0)" onclick="hirhRiskPersonInfo.editQuestion('${personInfoList.idcard}', null)">问卷调查</a> --%>
						<a href="#" title="问卷调查" onclick="hirhRiskPersonInfo.editQuestion('${personInfoList.idcard}', null)"><i class="layui-icon" style="color: #1E9FFF;">&#xe6b2;</i></a>
						
					</td>
			 	</tr>
			 </c:forEach>
			 <ehr:pagination action="hirhRiskPersonInfo.searchHighRiskInfo" colspan="9"/>
	   </tbody>
	</table>
</div>