<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="com.founder.rhip.mdm.common.OrgGenreCode" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<c:set var="HOSPITAL" value="<%=OrgGenreCode.HOSPITAL.getValue()%>" />
<c:set var="CENTRE" value="<%=OrgGenreCode.CENTRE.getValue()%>" />
<c:set var="STATION" value="<%=OrgGenreCode.STATION.getValue()%>" />
<div class="repeattable">
    <table class="layui-table x-admin-sm-table-list-middle">
        <colgroup>
            <col style="min-width:150px;width: 16%;"/>
            <col style="min-width:70px;width: 9%;"/>
            <col style="min-width:70px;width: 9%;"/>
            <col style="min-width:70px;width: 9%;"/>
            <col style="min-width:70px;width: 9%;"/>
            <col style="min-width:70px;width: 9%;"/>
            <%--<col style="min-width:70px;width: 9%;"/>--%>
            <col style="min-width:70px;width: 18%;"/>
        </colgroup>
        <thead>
        <tr>
            <th rowspan="2">机构/乡镇</th>
            <th rowspan="2">挂号人次数</th>
            <th rowspan="2">就诊人次数</th>
            <th rowspan="2">留观人次数</th>
            <th colspan="3">门急诊收费</th>

        </tr>
        <tr>
            <th>医保</th>
            <%--<th>新型农村合作医疗</th>--%>
            <th>个人费用</th>
            <th>合计费用</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="report" items="${reports}" varStatus="status">
            <tr>
                <c:choose>
                    <c:when test="${genreCode == '0' }">
                        <td>
                            <ehr:tip><ehr:dic code="${report.GB_CODE}" dicmeta="FS990001"/></ehr:tip>
                            <c:if test="${report.GB_CODE == 'grouping' || report.organ_code == 'grouping'}"> <b>合计</b> </c:if>
                        </td>
                    </c:when>

                    <c:otherwise>
                        <c:choose>
                            <c:when test="${report.GB_CODE == 'grouping' || report.organ_code == 'grouping'}">
                                <td class="centertd"><b>合计</b></td>
                            </c:when>
                            <c:when test="${report.GB_CODE == 'grouping' || report.organ_code == 'grouping'}">
                            </c:when>
                            <c:otherwise>
                                <td><ehr:tip><ehr:org code="${report.organ_code}"/></ehr:tip></td>
                            </c:otherwise>
                        </c:choose>
                    </c:otherwise>
                </c:choose>
                <td><tags:numberLabel value="${report.registerNum}" defaultValue="0" fractionDigits="0"/></td>
                <td><tags:numberLabel value="${report.visitNum}" defaultValue="0" /></td>
                <td><tags:numberLabel value="${report.observedNum}" defaultValue="0" fractionDigits="0"/></td>
                <td><tags:numberLabel value="${report.MEDICAL01 + report.MEDICAL02 +report.MEDICAL03 }" fractionDigits="2" defaultValue="0" /></td>
                <%--<td><tags:numberLabel value="${report.cooperative_medical_fee}" fractionDigits="2" defaultValue="0" /></td>--%>
                <td><tags:numberLabel value="${report.personalCost}" fractionDigits="2" defaultValue="0" /></td>
                <td><tags:numberLabel value="${report.outpatientCost}" fractionDigits="2" defaultValue="0" /></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>