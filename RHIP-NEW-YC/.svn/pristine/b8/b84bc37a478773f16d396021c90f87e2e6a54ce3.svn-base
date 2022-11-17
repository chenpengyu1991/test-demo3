<%--
  Created by IntelliJ IDEA.
  User: chen.q
  Date: 15-6-19
  Time: 下午4:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<script src="${pageContext.request.contextPath}/js/views/userspace/prescription/prescriptionMh.js" type="text/javascript"></script>
<script>
    function searchHealthPrescriptionMhById(id) {
        var dialogParams = {
            id : "healthPrescriptionDpMhId",
            url : "/health/prescriptionMh/detail/"+id,
            height : 500,
            width : 850,
            title : "查看健康生活指导"
        };
        $.dialog(dialogParams);
    };
</script>
<div class="rightnav">
<table style="width: 95%;border: 0">
    <tr>
        <td class="dingwei"><div id="location">当前位置:&gt;&gt;健康生活指导</div>
        </td>
    </tr>
</table>
<div class="repeattable">
    <table>
        <colgroup>
            <col style="width: 100px;" />
            <col style="width: 100px;" />
            <col style="width: 100px;" />
            <col style="width: 100px;" />
            <col style="width: 100px;" />
        </colgroup>
        <thead>
        <tr>
            <th>机构名称</th>
            <th>处方标题</th>
            <th>处方名称</th>
            <th>创建时间</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="prescription" items="${healthPrescriptions}">
            <tr>
                <td>
                        <%--<c:if test="${empty orgCode && empty centerOrgCode && empty gbcode}">--%>
                        <%--<ehr:tip><ehr:dic code="${prescription.gbcode}" dicmeta="FS990001"  /></ehr:tip>--%>
                        <%--</c:if>--%>
                        <%--<c:if test="${not empty orgCode || not empty centerOrgCode || not empty gbcode}">--%>
                        <%--<ehr:tip><ehr:org code="${prescription.orgCode}" /></ehr:tip>--%>
                        <%--</c:if>--%>
                        <%--需求修改：不显示镇显示具体机构名称,如果是站则显示中心名称.2014-02-17--%>
                    <c:if test="${prescription.orgCode eq prescription.centerOrgCode}">
                        <ehr:tip><ehr:org code="${prescription.orgCode}" /></ehr:tip>
                    </c:if>
                    <c:if test="${prescription.orgCode ne prescription.centerOrgCode}">
                        <ehr:tip><ehr:org code="${prescription.centerOrgCode}" /></ehr:tip>
                    </c:if>
                    <c:if test="${prescription.orgCode eq '_999'}"><ehr:tip>健康教育所</ehr:tip></c:if>
                </td>
                <td><ehr:tip>${prescription.title}</ehr:tip></td>
                <td><ehr:tip>${prescription.name}</ehr:tip></td>
                <td style="text-align: center; padding-left: 2px;"><fmt:formatDate value="${prescription.createTime}" pattern="yyyy-MM-dd"/></td>
                <td style="text-align: center; padding-left: 2px;">
                    <a href="javascript:void(0);" class="link"  onclick="searchHealthPrescriptionMhById(${prescription.id})">查看</a>

                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <table>
        <tr>
            <ehr:pagination action="prescriptionPage.search" />
        </tr>
    </table>
</div>
</div>