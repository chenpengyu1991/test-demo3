<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<div class="repeattable">
	<table class="layui-table x-admin-sm-table-list-middle">
		<colgroup>
			<col style="min-width:150px;width: 20%;"/>
            <col style="min-width:150px;width: 20%;"/>
            <col style="min-width:120px;width: 15%;"/>
            <col style="min-width:120px;width: 15%;"/>
            <col style="min-width:120px;width: 15%;"/>
            <col style="min-width:120px;width: 15%;"/>		
		</colgroup>
		<thead>
			<tr>
                <th>医疗机构</th>
                <th>接受健康管理的老年人数(人)</th>
                <th>填写完整的健康体检表格数</th>
                <th>管理人数</th>
                <th>已辨识人数</th>
                <th>管理服务率(%)</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="health" items="${healthlist}" varStatus="status">
				<tr>
                 	<td>
                 		<c:if test="${empty health.organCode}"><ehr:tip><b>总计</b></ehr:tip></c:if>
                    	<c:choose>
                    		<c:when test="${genreCode == '0' }"><ehr:tip><ehr:dic dicmeta="FS990001" code="${health.organCode}"/></ehr:tip></c:when>
                    		<c:otherwise><ehr:tip><ehr:org  code="${health.organCode}"/></ehr:tip></c:otherwise>
                    	</c:choose>
                    	
                   	</td>
                   	<td><tags:numberLabel value="${health.applyNum}" defaultValue="0" /></td>
                   	<td><tags:numberLabel value="${health.wholeNum}" defaultValue="0" /></td>
                   	<td><tags:numberLabel value="${health.householdNum}" defaultValue="0" /></td> 
                   	<td><tags:numberLabel value="${health.manageNum}" defaultValue="0" /></td>
                   	<td><tags:numberLabel value="${health.manageRate*100}" defaultValue="0"  fractionDigits="2"/></td>
                </tr>
			</c:forEach>
		</tbody>
	</table>
</div>