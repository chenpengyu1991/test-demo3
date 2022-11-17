<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script src="${pageContext.request.contextPath}/js/views/idm/filariasis/add.js" type="text/javascript"></script>

<script>
    $(function(){
        enableChangeConfirm();
        idmCommon.displayPaAddress();
    })
</script>

<script type="text/javascript">
    layui.use('laydate', function(){
        var laydate = layui.laydate;

        //执行一个laydate实例
        laydate.render({
            elem: '#surveyDate'
            ,format: 'yyyy/MM/dd'
            ,max:0
        });
    });
</script>

<div class="toolbar">
    <div class="toolbar" style="background: none">
        <a href="javascript:addFilariasis.returnSearch()" id="cancelContact"><button class="btn-gray layui-btn layui-btn-sm button"><i class="layui-icon">&#xe65c;</i>返回</button></a>
        <c:if test="${type == 'add'}">
            <a href="javascript:addFilariasis.registerSubmit('add')"><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe605;</i>保存</button></a>
        </c:if>
        <c:if test="${type == 'edit'}">
            <a href="javascript:addFilariasis.registerSubmit('edit')"><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe605;</i>保存</button></a>
        </c:if>
    </div>

</div>
<div class="divFixed125">
    <form id="registerForm">
        <div class="postcontent">
            <i class="popno" style="height: auto;padding-top: 10px;"> 丝虫病防治病人登记表
            </i>
            <input type="hidden" name="singleId" value="${filariasisDto.singleId}"/>
            <input type="hidden" name="idmId" value="${filariasisDto.idmId}"/>
            <input type="hidden" id="type" value="${type}"/>

            <div class="postdiv">
                <table class="posttable">
                    <colgroup>
                        <col style="width: 50%;"/>
                        <col style="width: 50%;"/>
                    </colgroup>
                </table>
                <fieldset>
                    <table class="posttable">
                        <colgroup>
                            <col style="width: 15%"/>
                            <col style="width: 35%"/>
                            <col style="width: 15%"/>
                            <col style="width: 35%"/>
                        </colgroup>
                        <tr>
                            <th><label class="required">姓名：</label></th>
                            <td>
                                <input type="text" name="generalCondition.name" value="${filariasisDto.generalCondition.name}" reg='{"maxlength":"50","required":"true"}'/>
                                <input type="hidden" name="generalCondition.id" value="${filariasisDto.generalCondition.id}"/>
                                <input type="hidden" name="generalCondition.idmId" value="${filariasisDto.generalCondition.idmId}"/>
                            </td>
                            <td></td>
                            <td></td>
                        </tr>
                        <tr>
                            <th>性别：</th>
                            <td>
                                <ehr:dic-radio name="generalCondition.gender" dicmeta="GBT226112003" value="${filariasisDto.generalCondition.gender}" code="1,2"/>
                            </td>
                        </tr>
                        <tr>
                            <th>年龄：</th>
                            <td><input type="text" name="generalCondition.age" value="${filariasisDto.generalCondition.age}" reg='{"maxlength":"20"}'></td>
                        </tr>
                        <tr>
                            <th>血检结果：</th>
                            <td>
                                <ehr:dic-radio name="labExamine.testResult" dicmeta="FS10043" value="${filariasisDto.labExamine.testResult}"/>
                                <input type="hidden" name="labExamine.id" value="${filariasisDto.labExamine.id}">
                                <input type="hidden" name="labExamine.idmId" value="${filariasisDto.labExamine.idmId}">
                            </td>
                        </tr>
                        <tr>
                            <th><label class="required">现住址：</label></th>
                            <td colspan="3">
                                <ehr:dic-town-street-village villageId="pavillage_address" streetId="pastreet_address" callback="idmCommon.displayPaAddress"
                                                             townId="patown_address" villageName="generalCondition.paGroup" streetName="generalCondition.pastreet"
                                                             townName="generalCondition.patownShip" villageValue="${filariasisDto.generalCondition.paGroup}" streetValue="${filariasisDto.generalCondition.pastreet}"
                                                             townValue="${filariasisDto.generalCondition.patownShip}" width="180px;" reg='{"required":"true"}'/>
                                <div>
                                    <label id="tempPaValue">
                                        <ehr:dic code="${filariasisDto.generalCondition.patownShip}" dicmeta="FS990001"/>
                                        <ehr:dic code="${filariasisDto.generalCondition.pastreet}" dicmeta="FS990001"/>
                                        <ehr:dic code="${filariasisDto.generalCondition.paGroup}" dicmeta="FS990001"/>
                                    </label>
                                    <input type="text" id="text_pahouseNumber" name="generalCondition.pahouseNumber" value="${filariasisDto.generalCondition.pahouseNumber}"
                                           reg='{"maxlength":"50","required":"true"}'  style="width: 180px;">
                                    <span id="spanPaNumber">(门牌号)</span>
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <th>备注：</th>
                            <td colspan="3">
                                <textarea name="caseInformation.changeDetail" style="width: 90%" rows=5  reg='{"maxlength":"200"}'>${filariasisDto.caseInformation.changeDetail}</textarea>
                            </td>
                        </tr>
                    </table>
                </fieldset>
                <fieldset>
                    <table class="posttable">
                        <colgroup>
                            <col style="width: 15%"/>
                            <col style="width: 35%"/>
                            <col style="width: 15%"/>
                            <col style="width: 35%"/>
                        </colgroup>
                        <tbody>
                        <tr>
                            <th>填写单位:</th>
                            <td colspan="3">
                                <ehr:org code="${filariasisDto.caseInformation.surveyOrg}"/>
                                <input type="hidden"  name="caseInformation.id" value="${filariasisDto.caseInformation.id}"/>
                                <input type="hidden" name="caseInformation.idmId" value="${filariasisDto.caseInformation.idmId}">
                                <input type="hidden"  name="caseInformation.surveyOrg" value="${filariasisDto.caseInformation.surveyOrg}"/>
                                <input type="hidden"  name="caseInformation.modifySurveyOrg" value="${filariasisDto.caseInformation.surveyOrg}"/>
                            </td>
                        </tr>
                        <tr>
                            <th>填写医生:</th>
                            <td>
                                <ehr:user userCode="${filariasisDto.caseInformation.respondents}"/>
                                <input type="hidden"  name="caseInformation.respondents" value="${filariasisDto.caseInformation.respondents}"/>
                            </td>
                            <th>登记日期:</th>
                            <td>
                                <input type="text" reg='{"required":"true"}' class="layui-input x-admin-content-sm-date"
                                       name="caseInformation.surveyDate" id="surveyDate"
                                       value="<fmt:formatDate value='${filariasisDto.caseInformation.surveyDate}' pattern='yyyy/MM/dd'/>"
                                       style="padding-left: 0px;"/>
                            </td>
                        </tr>
                        </tbody>
                    </table>
                </fieldset>
            </div>
        </div>
    </form>
</div>

