<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<div class="repeattable">
    <table class="layui-table x-admin-sm-table-list-middle">
        <colgroup>
            <col style="min-width:80px;width: 10%;"/>
            <col style="min-width:150px;width: 18%;"/>
            <col style="min-width:80px;width: 15%;"/>
            <col style="min-width:80px;width: 12%;"/>
            <col style="min-width:80px;width: 12%;"/>
            <col style="min-width:80px;width: 15%;"/>
            <col style="min-width:80px;width: 10%;"/>
        </colgroup>
        <thead>
        <tr>
            <th>姓名</th>
            <th>身份证号</th>
            <th>分娩时间</th>
            <th>分娩方式</th>
            <th>助产机构</th>
            <th>登记机构</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="woman" items="${womanList}" varStatus="status">
            <tr>
                <td class="centertd"><ehr:tip>${woman.name}</ehr:tip></td>
                <td class="centertd"><ehr:tip>${woman.idCard}</ehr:tip></td>
                <td class="centertd"><ehr:tip><fmt:formatDate value="${woman.deliveryDate}"
                                                              pattern="yyyy/MM/dd HH:mm"></fmt:formatDate></ehr:tip></td>
                <td class="centertd"><ehr:dic code="${woman.deliveryWay}" dicmeta="FS10308"></ehr:dic></td>
                <td class="centertd"><ehr:tip>${woman.deliveryHospitalName}</ehr:tip></td>
                <td class="centertd"><ehr:tip>${woman.createOrganName}</ehr:tip></td>
                <td class="centertd">
                	<a href="javascript:void(0);"  onclick="womenHealth.delivery1(${woman.id})" title="查看" class="layui-btn layui-btn-normal layui-btn-xs" style="color: #FFF;font-size: 12px;"><i class="layui-icon">&#xe615;</i>查看</a>
            <%--        <ehr:authorize ifAnyGranted="02,03">
                        <c:if test="${currentLoginInfo.organization.organCode eq woman.createOrganCode}">
                            <a href="javascript:void(0)" onclick="womanSearch.getDelivery(${woman.id})"
                               class="person-link-btn">修改</a>
                            <a href="javascript:void(0)" onclick="womanSearch.delDelivery(${woman.id})"
                               class="person-link-btn">删除</a>
                        </c:if>
                    </ehr:authorize>--%>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>