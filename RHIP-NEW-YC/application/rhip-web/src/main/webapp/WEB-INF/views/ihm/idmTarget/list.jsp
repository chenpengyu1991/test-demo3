<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>

<script src="${pageContext.request.contextPath}/js/views/ihm/idmTarget/list.js" type="text/javascript"></script>

<div class="repeattable">
    <c:if test="${viewType == 2}">
            <table>
            <colgroup>
            </colgroup>
            <thead>
            <tr>
                <th>机构</th>
                <th>登记传染病人数</th>
                <th>报告传染病人数</th>
                <th>报告及时传染病人数</th>
                <th>医生工作站传染病上报数</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="target" items="${targetList}">
                <tr>
                    <td>
                        <c:choose>
                            <c:when test="${target.type eq 1}">
                                <ehr:tip><ehr:dic code="${target.code}" dicmeta="FS990001"></ehr:dic></ehr:tip>
                            </c:when>
                            <c:otherwise>
                                <ehr:tip><ehr:org code="${target.code}"></ehr:org></ehr:tip>
                            </c:otherwise>
                        </c:choose>
                    </td>
                    <c:forEach var="targetCode" items="${target.targetCodes}">
                        <td>
                            <input type="hidden" name="targetHidden" value="${target.code},${target.type},${targetCode}"/>
                        </td>
                    </c:forEach>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:if>

    <c:if test="${viewType == 1 or viewType == null}">
        <table>
            <colgroup>
            </colgroup>
            <thead>
            <tr>
                <th>机构</th>
                <th>新发现2型糖尿病患者数</th>
                <th>年内累计管理2型糖尿病患者数</th>
                <th>规范管理2型糖尿病患者数</th>
                <th>2型糖尿病患者最近一次随访血糖达标患者数</th>
                <th>新发现高血压患者数</th>
                <th>年内累计管理高血压患者数</th>
                <th>规范管理高血压患者数</th>
                <th>最近一次随访血压达标患者数</th>
                <th>医生工作站慢病上报数</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="target" items="${targetList}">
                <tr>
                    <td>
                        <c:choose>
                            <c:when test="${target.type eq 1}">
                                <ehr:tip><ehr:dic code="${target.code}" dicmeta="FS990001"></ehr:dic></ehr:tip>
                            </c:when>
                            <c:otherwise>
                                <ehr:tip><ehr:org code="${target.code}"></ehr:org></ehr:tip>
                            </c:otherwise>
                        </c:choose>
                    </td>
                    <c:forEach var="targetCode" items="${target.targetCodes}">
                        <td>
                            <input type="hidden" name="targetHidden" value="${target.code},${target.type},${targetCode}"/>
                        </td>
                    </c:forEach>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:if>
    <c:if test="${viewType == 3}">
            <table>
            <colgroup>
            </colgroup>
            <thead>
            <tr>
                <th>机构</th>
                <th>新发现重性精神障碍患者数</th>
                <th>年内累计管理重性精神障碍患者数</th>
                <th>规范管理重性精神障碍患者数</th>
                <th>最近一次随访时分类为"病情稳定"的患者数</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="target" items="${targetList}">
                <tr>
                    <td>
                        <c:choose>
                            <c:when test="${target.type eq 1}">
                                <ehr:tip><ehr:dic code="${target.code}" dicmeta="FS990001"></ehr:dic></ehr:tip>
                            </c:when>
                            <c:otherwise>
                                <ehr:tip><ehr:org code="${target.code}"></ehr:org></ehr:tip>
                            </c:otherwise>
                        </c:choose>
                    </td>
                    <c:forEach var="targetCode" items="${target.targetCodes}">
                        <td>
                            <input type="hidden" name="targetHidden" value="${target.code},${target.type},${targetCode}"/>
                        </td>
                    </c:forEach>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:if>    
</div>