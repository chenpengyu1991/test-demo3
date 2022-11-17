<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<div class="repeattable">
	<table id="serviceTable">
		<colgroup>
	        <col style="min-width:80px;width: 20%;"/>
			<col style="min-width:150px;width: 20%;"/>
			<col style="min-width:80px;width: 20%;"/>
		    <col style="min-width:80px;width: 20%;"/>
	        <col style="min-width:80px;width: 20%;"/>
	        <col style="min-width:120px;width: 20%;"/>
	        <col style="min-width:80px;width: 20%;"/>
	        <col style="min-width:120px;width: 20%;"/>
		</colgroup>
		<thead>
			<tr>
			    <th>姓名</th>
				<th>身份证号码</th>
				<th>疾病名称</th>
				<th>迁出村委会</th>
                <th>迁出机构</th>
				<th>迁入机构</th>
				<th>操作者</th>
				<th>迁移时间</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="VillageDmManaCardLogList" items="${VillageDmManaCardLogList}" varStatus="status">
				<tr>
				    <td style="text-align:center">${VillageDmManaCardLogList.name}</td>
				    <td style="text-align:center"><ehr:tip>${VillageDmManaCardLogList.idcard}</ehr:tip></td>	   
				     <td>
					<c:if test="${VillageDmManaCardLogList.hbpFlag eq '2'}">高血压  </c:if>
					<c:if test="${VillageDmManaCardLogList.diFlag eq '2'}">糖尿病  </c:if>
					<c:if test="${VillageDmManaCardLogList.tumorFlag eq '2'}">肿瘤 </c:if>
					<c:if test="${VillageDmManaCardLogList.coronaryFlag eq '2'}">冠心病  </c:if>
					<c:if test="${VillageDmManaCardLogList.strokeFlag eq '2'}">脑卒中 </c:if>
				    </td>
				     <td>${VillageDmManaCardLogList.villageName}</td>
				    <td><ehr:tip><ehr:org code="${VillageDmManaCardLogList.createOrganCode}"/></ehr:tip></td>
                    <td><ehr:tip><ehr:org code="${VillageDmManaCardLogList.currentOrganCode}"/></ehr:tip></td>
                     <td style="text-align:center">${VillageDmManaCardLogList.operator}</td>
                     <td style="text-align:center">
                    <fmt:formatDate value='${VillageDmManaCardLogList.recordChangeTime}' pattern='yyyy/MM/dd'/>
                    </td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<table>
		<tr>
			<ehr:pagination action="villagetransferLogSearch.search" />
		</tr>
	</table>
</div>