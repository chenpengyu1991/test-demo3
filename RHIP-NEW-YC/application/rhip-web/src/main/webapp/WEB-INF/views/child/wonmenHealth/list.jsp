<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<div class="repeattable x-admin-sm">
	<table id="person_record_table" class="layui-table x-admin-sm-table-list-middle">

        <thead>
        <tr>
            <th>姓名</th>
            <th>身份证号</th>
            <th>健康档案编号</th>
            <th>性别</th>
            <th>创建日期</th>
            <th>创建人</th>
            <th>更新日期</th>
            <th>更新人</th>
            <!-- <th>管理机构<th>
            <th>管理机构<th> -->
            <th>管理机构</th>
            
        </tr>
        </thead>
        <tbody>
        <c:forEach var="child" items="${childList}" varStatus="status">
            <tr>
                <td class="centertd"><a href="javascript:void(0);"  onclick="womenHealth.record('${child.idCard}')" >${child.name}</a></td>
                <td class="centertd"><ehr:tip>${child.idCard}</ehr:tip></td>
                 <td class="centertd"><ehr:tip>${child.healthFileNo}</ehr:tip></td>
                <td class="centertd"><ehr:tip><ehr:dic code="${child.gender}" dicmeta="GBT226112003"></ehr:dic></ehr:tip></td>
                <td class="centertd"><ehr:tip><fmt:formatDate value="${child.createDate}" pattern="yyyy/MM/dd"/></ehr:tip></td>
                <td class="centertd"><ehr:tip>${child.createPerson}</ehr:tip></td>
                <td class="centertd"><ehr:tip><fmt:formatDate value="${child.updateDate}" pattern="yyyy/MM/dd"/></ehr:tip></td>
                <td class="centertd"><ehr:tip>${child.updatePerson}</ehr:tip></td>
                 <td class="centertd"><ehr:tip><ehr:org code="${child.orgCode}"/></ehr:tip></td> 
            </tr>
        </c:forEach>
        <tr>
            <ehr:pagination action="womenHealth.search" colspan="9"/>
        </tr>
        </tbody>
    </table>

    <%-- <table>
        <tr>
            <ehr:pagination action="womenHealth.search"/>
        </tr>
    </table> --%>
</div>