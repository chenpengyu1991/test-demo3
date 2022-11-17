<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<div class="repeattable">
	<table class="layui-table x-admin-sm-table-list-middle">
		<colgroup>
	        <col style="min-width:60px;width:10%;"/>
			<col style="min-width:60px;width:5%;"/>
			<col style="min-width:120px;width:20%;"/>
			<col style="min-width:60px;width:10%;"/>
			<col style="min-width:60px;width:5%;"/>
			<col style="min-width:60px;width:10%;"/>
			<col style="min-width:60px;width:10%;"/>
	        <col style="min-width:60px;width:10%;"/>
	        <col style="min-width:120px;width:20%;"/>
		</colgroup>	
		<thead>
			<tr>
				<th>姓名</th>
				<th>性别</th>
				<th>身份证号</th>
				<th>药品名称</th>
				<th>数量</th>
				<th>单价</th>								
				<th>总价</th>
				<th>发药日期</th>
				<th>发药机构</th>
			</tr>
		</thead>
		<tbody>
        <c:forEach var="drugUse" items="${drugUses}" varStatus="status">
            <tr>
                <td class="centertd"><ehr:tip>${drugUse.name}</ehr:tip></td>
                <td class="centertd"><ehr:tip><ehr:dic dicmeta="GBT226112003" code="${drugUse.gender}" /></ehr:tip></td>
                <td class="centertd"><ehr:tip>${drugUse.idcard}</ehr:tip></td>
                <td><ehr:tip>${drugUse.drugName}</ehr:tip></td>
                <td class="righttd"><tags:numberLabel value="${drugUse.useCount}"/></td>
                <td class="righttd"><tags:numberLabel value="${drugUse.currentUnitOrice}"/></td>
                <td class="righttd"><tags:numberLabel value="${drugUse.currentPrice}"/></td>
                <td class="centertd"><fmt:formatDate value="${drugUse.useDt}" pattern="yyyy/MM/dd" /></td>
                <td>
                	<c:choose>
                		<c:when test="${not empty drugUse.fillOrganStation}"><ehr:tip><ehr:org code="${drugUse.fillOrganStation}"/></ehr:tip></c:when>
                		<c:when test="${not empty drugUse.fillOrganCenter}"><ehr:tip><ehr:org code="${drugUse.fillOrganCenter}"/></ehr:tip></c:when>
                	</c:choose>
                </td>
            </tr>
        </c:forEach>
        <tr>
			<ehr:pagination action="drugUseSearch.searchDrugUse" colspan="9"/>
		</tr>
		</tbody>
	</table>
	
	<%-- <table>
		<tr>
			<ehr:pagination action="drugUseSearch.searchDrugUse" />
		</tr>
	</table> --%>
</div>