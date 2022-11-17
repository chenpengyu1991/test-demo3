<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<div class="repeattable">
    <table class="layui-table x-admin-sm-table-list-middle">
        <colgroup>
            <col style="min-width: 100px; width: 30%;">
            <col style="min-width: 260px; width: 30%;">
            <col style="min-width: 360px; width: 30%;">
            <col style="min-width: 360px; width: 10%;">
        </colgroup>
        <thead>
        <tr>
            <th>疾病名称</th>
            <th>疾病编码</th>
            <th>ICD编码</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="setup" items="${setups.list}" varStatus="status">
            <tr>
                <td class="centertd" title="${setup.itemName}">
	                <c:if test="${setup.parentCode != '3' && setup.parentCode != '2' && setup.parentCode != '1' && setup.parentCode != null}">
	                	<ehr:dic dicmeta="CV0501017" code="${setup.parentCode}"/>&nbsp;
	                </c:if>
	                ${setup.itemName}
                </td>
                <td class="centertd" title="${setup.itemCode}">${setup.itemCode}</td>
                <td class="centertd" title="${setup.icdCode}">${setup.icdCode}</td>
                <td class="centertd">
                <a href="javascript:void(0);" onclick="setupDisease.deleteSet(${setup.itemId})" title="删除该条记录" class="layui-btn layui-btn-danger layui-btn-xs" style="color: #FFF;font-size: 12px;" ><i class="layui-icon"></i>删除</a>
                
                </td>
            </tr>
        </c:forEach>
         <tr>
            <ehr:pagination action="setupDisease.search" colspan="4"/>
        </tr>
        </tbody>
    </table>

   <%--  <table>
        <tr>
            <ehr:pagination action="setupDisease.search" />
        </tr>
    </table> --%>

</div>

