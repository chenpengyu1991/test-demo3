<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<div class="repeattable">
    <form id="mentalEpilepsyPatientForm">
        <table>
            <colgroup>
                <col style="width: 25%"/>
                <col style="width: 25%"/>
                <col style="width: 25%"/>
                <col style="width: 25%"/>
            </colgroup>
            <thead>
            <tr>
                <th rowspan="2">机构</th>
                <th colspan="3">重性精神病患者管理服务、癫痫患者管理</th>
            </tr>
            <tr>
                <th>重性精神病患者管理数</th>
                <th>最近一次随访时分类为病情稳定的患者数(人)</th>
                <th>随访治疗癫痫患者数(人)</th>
            </tr>
            </thead>
            <tbody id="noModifyTbody">
            <c:forEach items="${mentalEpiPatientList}" var="MentalEpiList">
                <tr>
                    <td><c:out value="${MentalEpiList.ORGANNAME}"></c:out></td>
                    <td><c:out value="${MentalEpiList.MENTALNUM}"></c:out></td>
                    <td><c:out value="${MentalEpiList.STABLEDISEASENUM}"></c:out></td>
                    <td><c:out value="${MentalEpiList.EPILEPSYNUM}"></c:out></td>
                </tr>
            </c:forEach>
            <tr>
                <td><b>合计</b></td>
                <td><c:out value="${total.MENTALNUM}"></c:out></td>
                <td><c:out value="${total.STABLEDISEASENUM}"></c:out></td>
                <td><c:out value="${total.EPILEPSYNUM}"></c:out></td>
            </tr>
            </tbody>
            <tbody id="modifyTbody" style="display: none">
            <input type="hidden" name="organCode" value="${editMental.organCode}"/>
            <input type="hidden" name="organName" value="${editMental.organName}"/>
            <input type="hidden" name="id" value="${editMental.id}"/>
            <input type="hidden" name="parentCode" value="${editMental.parentCode}"/>
            <input type="hidden" name="genreCode" value="${editMental.genreCode}"/>
            <input type="hidden" name="gbCode" value="${editMental.gbCode}"/>
            <tr>
                <td><c:out value="${editMental.organName}"></c:out></td>
                <td><tag:numberInput name="mentalNum" value="${editMental.mentalNum}"></tag:numberInput></td>
                <td><tag:numberInput name="stableDiseaseNum" value="${editMental.stableDiseaseNum}"></tag:numberInput></td>
                <td><tag:numberInput name="epilepsyNum" value="${editMental.epilepsyNum}"></tag:numberInput></td>
            </tr>
            </tbody>
        </table>
    </form>
</div>

