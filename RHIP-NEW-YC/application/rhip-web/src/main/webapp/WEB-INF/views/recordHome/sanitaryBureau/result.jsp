<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/ehr-tag" prefix="ehr" %>

<style>
<!--
.layui-table td, .layui-table th {
    position: relative;
    padding: 0px 0px;
    min-height: 20px;
    line-height: 20px;
    font-size: 14px;
    }
 #pop_record_table input[type=text] {padding: 0px 5px; font-size: 12px;}
-->
</style>

<div style="overflow-x: auto">
<table id="pop_record_table" class="layui-table" style="padding: 0px;">
    <colgroup>
        <col style="width: 160px;"/>
        <col style="width: 12%;" span="8"/>
    </colgroup>
    <thead>
    <tr>
        <th rowspan="2" style="width: 50px;">站名称</th>
        <th colspan="2" style="width: 100px;">常住人口</th>
        <th colspan="2" style="width: 100px;">男性</th>
        <th colspan="2" style="width: 100px;">女性</th>
        <th colspan="2" style="width: 100px;">儿童(0-6岁)</th>
        <%--<th colspan="2" style="width: 100px;">育龄妇女</th>
        <th colspan="2" style="width: 100px;">老人(≥60岁)</th>--%>
        <th colspan="2" style="width: 100px;">高血压</th>
        <th colspan="2" style="width: 100px;">糖尿病</th>
        <th colspan="2" style="width: 100px;">精神病</th>
        <th colspan="2" style="width: 100px;">老人(≥65岁)</th>
        <th rowspan="2" style="width: 50px;">家庭数</th>
    </tr>
    <tr>
        <th class="zimu">户籍</th>
        <th class="zimu">非户籍</th>
        <th class="zimu">户籍</th>
        <th class="zimu">非户籍</th>
        <th class="zimu">户籍</th>
        <th class="zimu">非户籍</th>
        <th class="zimu">户籍</th>
        <th class="zimu">非户籍</th>
        <th class="zimu">户籍</th>
        <th class="zimu">非户籍</th>
        <th class="zimu">户籍</th>
        <th class="zimu">非户籍</th>
        <th class="zimu">户籍</th>
        <th class="zimu">非户籍</th>
        <th class="zimu">户籍</th>
        <th class="zimu">非户籍</th>
    </tr>
    </thead>

    <tbody id="displayBody">
    <c:forEach items="${stationPopulaceList }" var="populace">
        <tr>
            <td title=<ehr:org code="${populace.organCode}"></ehr:org>>
                <ehr:org code="${populace.organCode}"></ehr:org>
            </td>
            <td><c:out value="${populace.householdNum }"></c:out></td>
            <td><c:out value="${populace.unHouseHoldNum }"></c:out></td>
            <td><c:out value="${populace.householdManNum }"></c:out></td>
            <td><c:out value="${populace.unHouseholdManNum }"></c:out></td>
            <td><c:out value="${populace.householdWomanNum }"></c:out></td>
            <td><c:out value="${populace.unHouseholdWomanNum }"></c:out></td>
            <td><c:out value="${populace.householdSixChildNum }"></c:out>
            </td>
            <td><c:out value="${populace.unHouseholdSixChildNum }"></c:out>
            </td>
            <%--<td><c:out value="${populace.householdFertileWomanNum }"></c:out>
            </td>
            <td><c:out value="${populace.unHouseholdFertileWomanNum }"></c:out>
            </td>
            <td><c:out value="${populace.householdSixoToSixfNum }"></c:out>
            </td>
            <td><c:out value="${populace.unHouseholdSixoToSixfNum }"></c:out>
            </td>--%>
            <td><c:out value="${populace.householdPhbNum}"></c:out></td>
            <td><c:out value="${populace.unhouseholdPhbNum}"></c:out></td>
            <td><c:out value="${populace.householdDiNum}"></c:out></td>
            <td><c:out value="${populace.unhouseholdDiNum}"></c:out></td>
            <td><c:out value="${populace.householdMentalNum}"></c:out></td>
            <td><c:out value="${populace.unhouseholdMentalNum}"></c:out></td>
            <td><c:out value="${populace.householdGreatSixfNum }"></c:out>
            </td>
            <td><c:out value="${populace.unHouseholdGreatSixfNum }"></c:out>
            </td>
            <td><c:out value="${populace.familyNum}"></c:out>
            </td>
        </tr>
    </c:forEach>
    </tbody>
    <tbody id="editBody" style="display: none;">
    <c:forEach items="${stationPopulaceList }" var="populace" varStatus="status">
        <tr>
            <td title=<ehr:org code="${populace.organCode}"></ehr:org>>
                <input type="hidden" name="PopulaceDTO.stationPopulaceList[${status.index }].id" value="${populace.id }">
                <input type="hidden" name="PopulaceDTO.stationPopulaceList[${status.index }].organCode" value="${populace.organCode }">
                <input type="hidden" name="PopulaceDTO.stationPopulaceList[${status.index }].countYear" value="${populace.countYear }">
                <input type="hidden" name="PopulaceDTO.stationPopulaceList[${status.index }].organName" readonly="readonly" value="${populace.organName }"/>
                <ehr:org code="${populace.organCode}"></ehr:org>
            </td>
            <td>
                <input type="text" name="PopulaceDTO.stationPopulaceList[${status.index }].householdNum" size="3" value="${populace.householdNum}" maxlength="9" onkeypress="return event.keyCode>=48&&event.keyCode<=57||event.keyCode==8;" onpaste="return !clipboardData.getData('text').match(/\D/);" style="ime-mode: Disabled" ondragenter="return false"/>
            </td>
            <td>
                <input type="text" name="PopulaceDTO.stationPopulaceList[${status.index }].unHouseHoldNum" size="3" value="${populace.unHouseHoldNum}" maxlength="9" onkeypress="return event.keyCode>=48&&event.keyCode<=57||event.keyCode==8;" onpaste="return !clipboardData.getData('text').match(/\D/);" style="ime-mode: Disabled" ondragenter="return false"/>
            </td>
            <td>
                <input type="text" name="PopulaceDTO.stationPopulaceList[${status.index }].householdManNum" size="3" value="${populace.householdManNum }" maxlength="9" onkeypress="return event.keyCode>=48&&event.keyCode<=57||event.keyCode==8;" onpaste="return !clipboardData.getData('text').match(/\D/);" style="ime-mode: Disabled" ondragenter="return false"/>
            </td>
            <td>
                <input type="text" name="PopulaceDTO.stationPopulaceList[${status.index }].unHouseholdManNum" size="3" value="${populace.unHouseholdManNum }" maxlength="9" onkeypress="return event.keyCode>=48&&event.keyCode<=57||event.keyCode==8;" onpaste="return !clipboardData.getData('text').match(/\D/);" style="ime-mode: Disabled" ondragenter="return false"/>
            </td>
            <td>
                <input type="text" name="PopulaceDTO.stationPopulaceList[${status.index }].householdWomanNum" size="3" value="${populace.householdWomanNum }" maxlength="9" onkeypress="return event.keyCode>=48&&event.keyCode<=57||event.keyCode==8;" onpaste="return !clipboardData.getData('text').match(/\D/);" style="ime-mode: Disabled" ondragenter="return false"/>
            </td>
            <td>
                <input type="text" name="PopulaceDTO.stationPopulaceList[${status.index }].unHouseholdWomanNum" size="3" value="${populace.unHouseholdWomanNum }" maxlength="9" onkeypress="return event.keyCode>=48&&event.keyCode<=57||event.keyCode==8;" onpaste="return !clipboardData.getData('text').match(/\D/);" style="ime-mode: Disabled" ondragenter="return false"/>
            </td>
            <td>
                <input type="text" name="PopulaceDTO.stationPopulaceList[${status.index }].householdSixChildNum" size="3" value="${populace.householdSixChildNum }" maxlength="9" onkeypress="return event.keyCode>=48&&event.keyCode<=57||event.keyCode==8;" onpaste="return !clipboardData.getData('text').match(/\D/);" style="ime-mode: Disabled" ondragenter="return false"/>
            </td>
            <td>
                <input type="text" name="PopulaceDTO.stationPopulaceList[${status.index }].unHouseholdSixChildNum" size="3" value="${populace.unHouseholdSixChildNum }" maxlength="9" onkeypress="return event.keyCode>=48&&event.keyCode<=57||event.keyCode==8;" onpaste="return !clipboardData.getData('text').match(/\D/);" style="ime-mode: Disabled" ondragenter="return false"/>
            </td>
            <%--<td>
                <input type="text" name="PopulaceDTO.stationPopulaceList[${status.index }].householdFertileWomanNum" size="3" value="${populace.householdFertileWomanNum }" maxlength="9" onkeypress="return event.keyCode>=48&&event.keyCode<=57||event.keyCode==8;" onpaste="return !clipboardData.getData('text').match(/\D/);" style="ime-mode: Disabled" ondragenter="return false"/>
            </td>
            <td>
                <input type="text" name="PopulaceDTO.stationPopulaceList[${status.index }].unHouseholdFertileWomanNum" size="3" value="${populace.unHouseholdFertileWomanNum }" maxlength="9" onkeypress="return event.keyCode>=48&&event.keyCode<=57||event.keyCode==8;" onpaste="return !clipboardData.getData('text').match(/\D/);" style="ime-mode: Disabled" ondragenter="return false"/>
            </td>
            <td>
                <input type="text" name="PopulaceDTO.stationPopulaceList[${status.index }].householdSixoToSixfNum" size="3" value="${populace.householdSixoToSixfNum}" maxlength="9" onkeypress="return event.keyCode>=48&&event.keyCode<=57||event.keyCode==8;" onpaste="return !clipboardData.getData('text').match(/\D/);" style="ime-mode: Disabled" ondragenter="return false"/>
            </td>
            <td>
                <input type="text" name="PopulaceDTO.stationPopulaceList[${status.index }].unHouseholdSixoToSixfNum" size="3" value="${populace.unHouseholdSixoToSixfNum }" maxlength="9" onkeypress="return event.keyCode>=48&&event.keyCode<=57||event.keyCode==8;" onpaste="return !clipboardData.getData('text').match(/\D/);" style="ime-mode: Disabled" ondragenter="return false"/>
            </td>--%>
            <td>
                <input type="text" name="PopulaceDTO.stationPopulaceList[${status.index }].householdPhbNum" size="3" value="${populace.householdPhbNum }" maxlength="9" onkeypress="return event.keyCode>=48&&event.keyCode<=57||event.keyCode==8;" onpaste="return !clipboardData.getData('text').match(/\D/);" style="ime-mode: Disabled" ondragenter="return false"/>
            </td>
            <td>
                <input type="text" name="PopulaceDTO.stationPopulaceList[${status.index }].unhouseholdPhbNum" size="3" value="${populace.unhouseholdPhbNum }" maxlength="9" onkeypress="return event.keyCode>=48&&event.keyCode<=57||event.keyCode==8;" onpaste="return !clipboardData.getData('text').match(/\D/);" style="ime-mode: Disabled" ondragenter="return false"/>
            </td>
            <td>
                <input type="text" name="PopulaceDTO.stationPopulaceList[${status.index }].householdDiNum" size="3" value="${populace.householdDiNum }" maxlength="9" onkeypress="return event.keyCode>=48&&event.keyCode<=57||event.keyCode==8;" onpaste="return !clipboardData.getData('text').match(/\D/);" style="ime-mode: Disabled" ondragenter="return false"/>
            </td>
            <td>
                <input type="text" name="PopulaceDTO.stationPopulaceList[${status.index }].unhouseholdDiNum" size="3" value="${populace.unhouseholdDiNum }" maxlength="9" onkeypress="return event.keyCode>=48&&event.keyCode<=57||event.keyCode==8;" onpaste="return !clipboardData.getData('text').match(/\D/);" style="ime-mode: Disabled" ondragenter="return false"/>
            </td>
            <td>
                <input type="text" name="PopulaceDTO.stationPopulaceList[${status.index }].householdMentalNum" size="3" value="${populace.householdMentalNum }" maxlength="9" onkeypress="return event.keyCode>=48&&event.keyCode<=57||event.keyCode==8;" onpaste="return !clipboardData.getData('text').match(/\D/);" style="ime-mode: Disabled" ondragenter="return false"/>
            </td>
            <td>
                <input type="text" name="PopulaceDTO.stationPopulaceList[${status.index }].unhouseholdMentalNum" size="3" value="${populace.unhouseholdMentalNum }" maxlength="9" onkeypress="return event.keyCode>=48&&event.keyCode<=57||event.keyCode==8;" onpaste="return !clipboardData.getData('text').match(/\D/);" style="ime-mode: Disabled" ondragenter="return false"/>
            </td>
            <td>
                <input type="text" name="PopulaceDTO.stationPopulaceList[${status.index }].householdGreatSixfNum" size="3" value="${populace.householdGreatSixfNum }" maxlength="9" onkeypress="return event.keyCode>=48&&event.keyCode<=57||event.keyCode==8;" onpaste="return !clipboardData.getData('text').match(/\D/);" style="ime-mode: Disabled" ondragenter="return false"/>
            </td>
            <td>
                <input type="text" name="PopulaceDTO.stationPopulaceList[${status.index }].unHouseholdGreatSixfNum" size="3" value="${populace.unHouseholdGreatSixfNum }" maxlength="9" onkeypress="return event.keyCode>=48&&event.keyCode<=57||event.keyCode==8;" onpaste="return !clipboardData.getData('text').match(/\D/);" style="ime-mode: Disabled" ondragenter="return false"/>
            </td>
            <td>
                <input type="text" name="PopulaceDTO.stationPopulaceList[${status.index }].familyNum" size="3" value="${populace.familyNum}" maxlength="9" onkeypress="return event.keyCode>=48&&event.keyCode<=57||event.keyCode==8;" onpaste="return !clipboardData.getData('text').match(/\D/);" style="ime-mode: Disabled" ondragenter="return false"/>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</div>