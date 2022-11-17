<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib  tagdir="/WEB-INF/tags" prefix="tag"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<div class="postdiv" id="subDetailDiv">
    <fieldset style="margin-top: 10px">
        <legend>随访情况</legend>
        <form id="frForm">
            <table class="posttable">
                <colgroup>
                    <col style="min-width: 50px; width: 15%;" />
                    <col style="min-width: 80px; width: 35%;" />
                    <col style="min-width: 50px; width: 15%;" />
                    <col style="min-width: 80px; width: 35%;" />
                </colgroup>
                <tr>
                    <input type="hidden" id="singleId" name="idmId" value="${singleId}">
                    <input type="hidden" name="id" id="subId" value="${listFr.id}">
                    <th><label class="required">患者姓名：</label></th>
                    <td><input type="text" name="name" value="${listFr.name}" reg='{"maxlength":"50","required":"true"}'/></td>
                    <th>家长姓名：</th>
                    <td><input type="text" name="parentsName" value="${listFr.parentsName}" reg='{"maxlength":"50"}'/></td>
                </tr>
                <tbody id="toEmpty">
                    <tr>
                        <th>现住址：</th>
                        <td colspan="3">
                            <ehr:dic-town-village villageName="pastreet" townName="patownShip"
                                                  villageValue="${listFr.pastreet}" townValue="${listFr.patownShip}"
                                                  width="150px;"/>
                            <input type="text" name="pahouseNumber" value="${listFr.pahouseNumber}"
                                   reg='{"maxlength":"50"}' style="width: 150px;"/>
                        </td>
                    </tr>
                    <tr>
                        <th>电话：</th>
                        <td><input type="text" name="phoneNumber" value="${listFr.phoneNumber}" reg='{"regex":"phone"}'/></td>
                        <th>病例类型：</th>
                        <td><ehr:dic-radio name="caseType" dicmeta="IDM00334" value="${listFr.caseType}"/></td>
                    </tr>
                    <tr>
                        <th>备注：</th>
                        <td colspan="3"><textarea name="comments" reg='{"maxlength":"400"}'>${listFr.comments}</textarea></td>
                    </tr>
                </tbody>
            </table>

            <table style="margin-top: 15px;">
                <colgroup>
                    <col style="min-width: 50px; width: 15%;" />
                    <col style="min-width: 80px; width: 35%;" />
                    <col style="min-width: 50px; width: 15%;" />
                    <col style="min-width: 80px; width: 35%;" />
                </colgroup>
                <tr>
                    <th>填报人员：</th>
                    <td>
                        <ehr:user userCode="${listFr.visitById}"/>
                        <input type="hidden" name="visitById" value="${listFr.visitById}"/>
                    </td>
                    <th><label class="required">填报日期：</label></th>
                    <td><tag:dateInput name="visitDt" pattern="yyyy/MM/dd" onlypast="true" date="${listFr.visitDt}" reg='{"required":"true"}'/></td>
                </tr>
            </table>
        </form>
    </fieldset>
</div>
