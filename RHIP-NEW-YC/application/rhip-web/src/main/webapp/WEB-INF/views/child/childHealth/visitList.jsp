<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<div class="repeattable x-admin-sm">
    <table class="layui-table x-admin-sm-table-list-middle">
        <colgroup>
            <col style="min-width:150px;width: 20%;"/>
            <col style="min-width:80px;width: 12%;"/>
            <col style="min-width:80px;width: 12%;"/>
            <col style="min-width:80px;width: 12%;"/>
            <col style="min-width:80px;"/>
            <col style="min-width:80px;"/>
            <col style="min-width:80px;width: 12%;"/>
        </colgroup>

        <%--新生儿随访--%>
        <thead>
        <tr>
            <th>姓名</th>
            <th>性别</th>
            <th>出生日期</th>
            <th>访视医师姓名</th>
             <th>访视机构</th>
            <th>访视日期</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="child" items="${childList}" varStatus="status">
            <tr>
                <td class="centertd"><ehr:tip>${child.neonatusName}</ehr:tip></td>
                <td class="centertd"><ehr:tip><ehr:dic code="${child.neonatalGender}" dicmeta="GBT226112003"></ehr:dic></ehr:tip></td>
                <td class="centertd"><ehr:tip><fmt:formatDate value="${child.neonatusBirthday}" pattern="yyyy/MM/dd"></fmt:formatDate></ehr:tip></td>
                 
                <td class="centertd">${child.supervisionDoctor}
                <ehr:staff-name staffCode="${child.supervisionDoctorCode}"/>
                </td>
                
                <td class="centertd">
                <ehr:tip><ehr:org code="${child.createOrganCode}"/></ehr:tip></td>
                <td class="centertd"><fmt:formatDate value="${child.visitDate}" pattern="yyyy/MM/dd"/></td>
                <td class="centertd">
                	<a class="layui-btn layui-btn-normal layui-btn-xs" style="color: #FFF;font-size: 12px;" href="#" title="查看" onclick="childHealth.viewNeonatalVisi1t(${child.id})"><i class="layui-icon">&#xe615;</i>查看</a>
                
                	<%-- <a href="javascript:void(0);"  onclick="childHealth.viewNeonatalVisi1t(${child.id})" title="查看" ><i class="layui-icon">&#xe615;</i></a> --%>
                       <%--
                       <ehr:authorize ifAnyGranted="02,03">
                        <c:if test="${currentLoginInfo.organization.organCode eq child.createOrganCode}">
                     <a href="javascript:void(0)" onclick="familyVisitSearch.editViewNeonatalVisit(${child.id})"
                       class="person-link-btn">修改</a>
                       
                       <a href="javascript:void(0)" onclick="familyVisitSearch.deleteViewNeonatalVisit(${child.id})"
                       class="person-link-btn">删除</a> </c:if></ehr:authorize>--%>
                          
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>