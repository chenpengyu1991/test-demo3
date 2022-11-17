<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr" %>
<div class="repeattable">
    <form id="populationListForm">
        <table>
            <colgroup>
                <col style="width: 16%"/>
                <col style="width: 8%"/>
                <col style="width: 10%"/>
                <col style="width: 10%"/>
                <col style="width: 12%"/>
                <col style="width: 12%"/>
                <col style="width: 11%"/>
                <col style="width: 7%"/>
                <col style="width: 8%"/>
                <col style="width: 6%"/>
            </colgroup>
            <thead>
            <tr>
                <th rowspan="2">机构</th>
                <th colspan="9">人口基本情况</th>
            </tr>
            <tr>
                <th>常住人口(人)</th>
                <th>65岁以上老人数(人)</th>
                <th>高血压患者人数(人)</th>
                <th>2型糖尿病患者人数(人)</th>
                <th>重性精神障碍患者人数</th>
                <th>中医体质辨识人数(人)</th>
                <th>活产数(人)</th>
                <th>0-6岁儿童数(人)</th>
                <th>产妇人数</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${populace}" var="populace">
            <tr>
            <c:if test="${countType eq '1'}">
            <td><ehr:org code="${populace.organCode}"/></td>
            <td style="text-align: center">${populace.total}</td>
            <td style="text-align: center">${populace.elderNum}</td>
            <td style="text-align: center">${populace.phbNum}</td>
            <td style="text-align: center">${populace.diNum}</td>
            <td style="text-align: center">${populace.psychosisNum}</td>
            </c:if>
            <c:if test="${countType eq '2'}">
             <td><ehr:org code="${populace.organCode}"/></td>
             <td style="text-align: center">--</td>
             <td style="text-align: center">--</td>
             <td style="text-align: center">--</td>
             <td style="text-align: center">--</td>
             <td style="text-align: center">--</td>
             </c:if>
            <td style="text-align: center">${populace.identificationNum}</td>
            <td style="text-align: center">${populace.liveBirth}</td>
            <td style="text-align: center">${populace.childNum}</td>
            <td style="text-align: center">${populace.maternalNum}</td>
            </tr>
            </c:forEach>
            <tr>
            <td style="text-align: center">合计</td>
                <c:if test="${countType eq '1'}">
                    <td style="text-align: center">${total.total}</td>
                    <td style="text-align: center">${total.elderNum}</td>
                    <td style="text-align: center">${total.phbNum}</td>
                    <td style="text-align: center">${total.diNum}</td>
                    <td style="text-align: center">${total.psychosisNum}</td>
                </c:if>
                <c:if test="${countType eq '2'}">
                    <td style="text-align: center">--</td>
                    <td style="text-align: center">--</td>
                    <td style="text-align: center">--</td>
                    <td style="text-align: center">--</td>
                    <td style="text-align: center">--</td>
                </c:if>
                <td style="text-align: center">${total.identificationNum}</td>
                <td style="text-align: center">${total.liveBirth}</td>
                <td style="text-align: center">${total.childNum}</td>
                <td style="text-align: center">${total.maternalNum}</td>
            </tr>
            </tbody>
        </table>
    </form>
</div>
