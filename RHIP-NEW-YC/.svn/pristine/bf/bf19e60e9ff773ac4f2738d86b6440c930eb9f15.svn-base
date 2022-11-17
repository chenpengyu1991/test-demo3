<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<script src="${pageContext.request.contextPath}/js/views/idm/malaria/ai.js" type="text/javascript"></script>
<div class="repeattable">
	<table>
		<colgroup>
	        <col style="min-width:70px;width:80px;"/>
			<col style="min-width:70px;width:80px;"/>
	        <col style="min-width:30px;width:40px;"/>
			<col style="min-width:30px;width:40px;"/>
			<col style="min-width:65px;width:65px;"/>
			<col style="min-width:65px;width:65px;"/>
			<col style="min-width:65px;width:65px;"/>
			<col style="min-width:80px;width:80px;"/>
			<col style="min-width:120px;width:180px;"/>
			<col/>
			<col style="min-width:80px;width:80px;"/>
		</colgroup>
		<thead>
			<tr>
				<th>姓名</th>
				<th>户主</th>
				<th>性别</th>
				<th>年龄</th>
				<th>走访结果</th>
				<th>血检方式</th>
				<th>血检结果</th>
				<th>诊断结果</th>
                <th>走访地点</th>
				<th>备注</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="aiList" items="${aiList}" varStatus="status">
				<tr>
					<td title="${aiList.name}">${aiList.name}</td>
                    <td title="${aiList.headHouseholdName}">${aiList.headHouseholdName}</td>
					<td class="centertd" title="<ehr:dic dicmeta="GBT226112003" code="${aiList.gender}"/>"><ehr:dic dicmeta="GBT226112003" code="${aiList.gender}" /></td>
					<td title="${aiList.age}">${aiList.age}</td>
					<td title="<ehr:dic dicmeta="IDM00273" code="${aiList.visitResult}"/>"><ehr:dic dicmeta="IDM00273" code="${aiList.visitResult}"/></td>
					<td class="centertd" title="<ehr:dic dicmeta="IDM00274" code="${aiList.checkType}"/>"><ehr:dic dicmeta="IDM00274" code="${aiList.checkType}"/></td>
					<td class="centertd" title="<ehr:dic dicmeta="CV0450015" code="${aiList.checkResult}"/>"><ehr:dic dicmeta="CV0450015" code="${aiList.checkResult}"/></td>
                    <td title="${aiList.diagnosisResult}">${aiList.diagnosisResult}</td>
                    <td title="<ehr:dic dicmeta="FS990001" code="${aiList.checkTownShip}"></ehr:dic><ehr:dic dicmeta="FS990001" code="${aiList.checkStreet}"></ehr:dic><c:out value="${aiList.checkHouseNumber}"></c:out>">
                        <ehr:dic dicmeta="FS990001" code="${aiList.checkTownShip}"></ehr:dic><ehr:dic dicmeta="FS990001" code="${aiList.checkStreet}"></ehr:dic><c:out value="${aiList.checkHouseNumber}"></c:out>
                    </td>

                    <td title="${aiList.comments}">${aiList.comments}</td>
                    <td style="text-align: center">
                        <a href="javascript:void(0)" onclick="ai.initUpdateAi(${aiList.id})">修改</a>
                        <a href="javascript:void(0)" onclick="ai.deleteAi(${aiList.id})">删除</a>
                    </td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<table>
		<tr>
			<ehr:pagination action="standardSearch.searchStandard" />
		</tr>
	</table>
</div>