<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tag" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<div>
    <form id="addActive" method="get">
        <input type="hidden" id="rowIndex" value="${rowIndex}"/>

        <div>
            <table class="formtable" id="popActiveTable">
                <colgroup>
                    <col style="width: 20%"/>
                    <col style="width: 80%"/>
                </colgroup>
                <tr>
                    <th>时间</th>
                    <td>
                        <tag:dateInput name="activityDt" onlypast="true" id="activityDt"
                                       date="${idmListEfc.activityDt}"/>
                    </td>
                </tr>
                <tr>
                    <th><label class="required">地点</label></th>
                    <td>
                        <input type="text" name="activityAddr" id="activityAddr" value="${idmListEfc.activityAddr}"
                               reg='{"required":"true","maxlength":"20"}'/>
                    </td>
                </tr>
                <tr>
                    <th>解大便处</th>
                    <td>
                        <input type="text" name="dungAddr" id=dungAddr value="${idmListEfc.dungAddr}"
                               reg='{"maxlength":"100"}'/>
                    </td>
                </tr>
                <tr>
                    <th>呕吐处</th>
                    <td>
                        <input type="text" name="vomitAddr" id="vomitAddr" value="${idmListEfc.vomitAddr}"
                               reg='{"maxlength":"100"}'/>
                    </td>
                </tr>
                <tr>
                    <th>交通工具污染</th>
                    <td>
                        <input type="text" name="vehiclePollute" id="vehiclePollute" value="${idmListEfc.vehiclePollute}"
                               reg='{"maxlength":"100"}'/>
                    </td>
                </tr>
            </table>
        </div>
    </form>
    <div class="toolbarpop">
        <c:if test="${type == 'add'}">
            <input type="button" value="添加" onclick="choleraCase.addActiveList()" />
        </c:if>
        <c:if test="${type == 'edit'}">
            <input type="button" value="修改" onclick="choleraCase.editActiveList()" />
        </c:if>
        <input type="button" value="取消" onclick="caseEdit.closePopUp('activeDialog')" />
    </div>
</div>

