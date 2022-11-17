<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<div class="repeattable">
    <table class="layui-table x-admin-sm-table-list-middle">
        <colgroup>
            <col style="width: 20%;"/>
            <col style="width: 20%;"/>
            <col style="width: 20%;"/>
            <col style="width: 20%;"/>
            <col style="width: 20%;"/>
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
                	<a class="basicIndex layui-btn layui-btn-normal layui-btn-xs" style="color: #FFF;font-size: 12px;" href="#" title="查看" onclick="pFOSearch.viewPrenatalFollowup(${prenatalFollowup.id})"><i class="layui-icon"></i>查看</a>
                    <ehr:authorize ifAnyGranted="0205,03,0405">
                        <c:if test="${currentLoginInfo.organization.organCode eq prenatalFollowup.createOrganCode}">
                            <a class="personModify layui-btn layui-btn-xs" style="color: #FFF;font-size: 12px;" href="#" title="修改" onclick="pFOSearch.getPrenatalFollowup(${prenatalFollowup.id})"><i class="layui-icon"></i>修改</a>
                            <a class="layui-btn layui-btn-danger layui-btn-xs" style="color: #FFF;font-size: 12px;" href="javascript:void(0);" onclick="pFOSearch.deletePrenatalFollowup(${prenatalFollowup.id})" title="删除"><i class="layui-icon"></i>删除</a>
                        </c:if>
                    </ehr:authorize>
                </td>
            </tr>
        </c:forEach>
        <tr>
            <ehr:pagination action="pFOSearch.search" colspan="5"/>
        </tr>
        </tbody>
    </table>

    <%-- <table>
        <tr>
            <ehr:pagination action="pFOSearch.search"/>
        </tr>
    </table> --%>
</div>