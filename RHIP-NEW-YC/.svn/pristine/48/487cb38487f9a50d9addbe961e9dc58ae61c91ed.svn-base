<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="ehr" uri="/ehr-tag"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>


<div class="repeattable">
<table id="pop_record_table" class="layui-table x-admin-sm-table-list-small">
    <colgroup>
        <col style="width: 120px;"/>
        <col style="width: 12%;" span="7"/>
    </colgroup>
    <thead>
    <tr>
        <th rowspan="2" style="width: 50px;">机构名称</th>
        <th rowspan="2" style="width: 50px;">合计</th>
        <th colspan="2" style="width: 100px;">常住人口</th>
        <th colspan="2" style="width: 100px;">男性</th>
        <th colspan="2" style="width: 100px;">女性</th>
        <%--<th colspan="2" style="width: 100px;">儿童(0-6岁)</th>
        <th colspan="2" style="width: 100px;">育龄妇女</th>
        <th colspan="2" style="width: 100px;">老人(≥60岁)</th>--%>
        <th colspan="2" style="width: 100px;">高血压</th>
        <th colspan="2" style="width: 100px;">糖尿病</th>
        <th colspan="2" style="width: 100px;">精神病</th>
        <th colspan="2" style="width: 100px;">老人(≥65岁)</th>
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
    </tr>
    </thead>

    <tbody id="displayBody">
    <c:forEach items="${stationPopulaceList }" var="populace">
        <tr>
            <td>
            	<ehr:tip>
            		<c:if test="${populace.organCode == '合计'}"><b>合计</b> </c:if>
            		<c:choose>
            			<c:when test="${genreCode=='0'}">
            				<ehr:dic code="${populace.organCode}" dicmeta="FS990001"/> 
            			</c:when>
            			<c:otherwise>
            				<ehr:org code="${populace.organCode}"/>
            			</c:otherwise>
            		</c:choose>
            	</ehr:tip>
            </td>
            <td><tags:numberLabel type="number" defaultValue="0" value="${populace.total }"/></td>
            <td><tags:numberLabel type="number" defaultValue="0" value="${populace.householdNum }"/></td>
            <td><tags:numberLabel type="number" defaultValue="0" value="${populace.unHouseHoldNum }"/></td>
            <td><tags:numberLabel type="number" defaultValue="0" value="${populace.householdManNum }"/></td>
            <td><tags:numberLabel type="number" defaultValue="0" value="${populace.unHouseholdManNum }"/></td>
            <td><tags:numberLabel type="number" defaultValue="0" value="${populace.householdWomanNum }"/></td>
            <td><tags:numberLabel type="number" defaultValue="0" value="${populace.unHouseholdWomanNum }"/></td>
            <%--<td><tags:numberLabel type="number" defaultValue="0" value="${populace.householdSixChildNum }"/></td>
            <td><tags:numberLabel type="number" defaultValue="0" value="${populace.unHouseholdSixChildNum }"/></td>
            <td><tags:numberLabel type="number" defaultValue="0" value="${populace.householdFertileWomanNum }"/> </td>
            <td><tags:numberLabel type="number" defaultValue="0" value="${populace.unHouseholdFertileWomanNum }"/></td>
            <td><tags:numberLabel type="number" defaultValue="0" value="${populace.householdSixoToSixfNum }"/></td>
            <td><tags:numberLabel type="number" defaultValue="0" value="${populace.unHouseholdSixoToSixfNum }"/></td>--%>
            <td><tags:numberLabel type="number" defaultValue="0" value="${populace.householdPhbNum }"/></td>
            <td><tags:numberLabel type="number" defaultValue="0" value="${populace.unhouseholdPhbNum }"/></td>
            <td><tags:numberLabel type="number" defaultValue="0" value="${populace.householdDiNum }"/></td>
            <td><tags:numberLabel type="number" defaultValue="0" value="${populace.unhouseholdDiNum }"/></td>
            <td><tags:numberLabel type="number" defaultValue="0" value="${populace.householdMentalNum }"/></td>
            <td><tags:numberLabel type="number" defaultValue="0" value="${populace.unhouseholdMentalNum }"/></td>
            <td><tags:numberLabel type="number" defaultValue="0" value="${populace.householdGreatSixfNum }"/></td>
            <td><tags:numberLabel type="number" defaultValue="0" value="${populace.unHouseholdGreatSixfNum }"/></td>
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
            <%--<td>
                <input type="text" name="PopulaceDTO.stationPopulaceList[${status.index }].householdSixChildNum" size="3" value="${populace.householdSixChildNum }" maxlength="9" onkeypress="return event.keyCode>=48&&event.keyCode<=57||event.keyCode==8;" onpaste="return !clipboardData.getData('text').match(/\D/);" style="ime-mode: Disabled" ondragenter="return false"/>
            </td>
            <td>
                <input type="text" name="PopulaceDTO.stationPopulaceList[${status.index }].unHouseholdSixChildNum" size="3" value="${populace.unHouseholdSixChildNum }" maxlength="9" onkeypress="return event.keyCode>=48&&event.keyCode<=57||event.keyCode==8;" onpaste="return !clipboardData.getData('text').match(/\D/);" style="ime-mode: Disabled" ondragenter="return false"/>
            </td>
            <td>
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
        </tr>
    </c:forEach>
    </tbody>
</table>
</div>