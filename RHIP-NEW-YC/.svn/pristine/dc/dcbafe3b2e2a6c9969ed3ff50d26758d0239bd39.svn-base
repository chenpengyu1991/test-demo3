<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<div class="repeattable">
    <table class="layui-table x-admin-sm-table-list-middle">
        <colgroup>
            <col style="min-width:80px;width: 12%;"/>
            <col style="min-width:80px;width: 12%;"/>
            <col style="min-width:80px;width: 12%;"/>
            <col style="min-width:80px;width: 12%;"/>
            <col style="min-width:80px;width: 10%;"/>
        </colgroup>
        <thead>
        <tr>
            <th>本人姓名</th>
            <th>身份证号</th>
            <th>预产期</th>
            <th>随访机构</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody class="tbody">
        <c:forEach var="prenatalFollowup" items="${prenatalFollowupOthers}" varStatus="status">
            <tr>
                <td class="centertd"><ehr:tip>${prenatalFollowup.name}</ehr:tip></td>
                <td class="centertd"><ehr:tip>${prenatalFollowup.idCard}</ehr:tip></td>
                <td class="centertd"><ehr:tip><fmt:formatDate value="${prenatalFollowup.estimatedDueDates}" pattern="yyyy/MM/dd"></fmt:formatDate></ehr:tip></td>
                <td class="centertd"><ehr:tip><ehr:org code="${prenatalFollowup.createOrganCode}"/></ehr:tip></td>
                <td class="centertd">
                	<a href="javascript:void(0);"  onclick="womenHealth.viewPrenatalFollowup1(${prenatalFollowup.id})" title="查看" class="layui-btn layui-btn-normal layui-btn-xs" style="color: #FFF;font-size: 12px;"><i class="layui-icon">&#xe615;</i>查看</a>
                <%--    <ehr:authorize ifAnyGranted="02,03">
                        <c:if test="${currentLoginInfo.organization.organCode eq prenatalFollowup.createOrganCode}">
                            <a href="javascript:void(0)" onclick="pFOSearch.getPrenatalFollowup(${prenatalFollowup.id})" class="person-link-btn">修改</a>
                            <a href="javascript:void(0)" onclick="pFOSearch.deletePrenatalFollowup(${prenatalFollowup.id})" class="person-link-btn">删除</a>
                        </c:if>
                    </ehr:authorize>--%>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>