<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib  tagdir="/WEB-INF/tags" prefix="tag"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<script src="${pageContext.request.contextPath}/js/views/idm/filariasis/followup.js" type="text/javascript"></script>
<script type="text/javascript">
    layui.use('laydate', function () {
        var laydate = layui.laydate;

        laydate.render({
            elem: '#lymphaticLastBreakDt'
            , format: 'yyyy/MM/dd'
            , max: 0
            , done: function (value) {
                if (!$.isEmpty(value)) {
                    $("#lymphaticLastBreakDt").removeClass("lose");
                } else {
                    $("#lymphaticLastBreakDt").addClass("lose");
                }
            }
        });
        
        laydate.render({
            elem: '#lastBreakDt'
            , format: 'yyyy/MM/dd'
            , max: 0
            , done: function (value) {
                if (!$.isEmpty(value)) {
                    $("#lastBreakDt").removeClass("lose");
                } else {
                    $("#lastBreakDt").addClass("lose");
                }
            }
        });

        
        laydate.render({
            elem: '#visitDt'
            , format: 'yyyy/MM/dd'
            , max: 0
            , done: function (value) {
                if (!$.isEmpty(value)) {
                    $("#visitDt").removeClass("lose");
                } else {
                    $("#visitDt").addClass("lose");
                }
            }
        });

    });

</script>
<div>
<div class="toolbar">
    <a href="javascript:filStandard.returnSearch('standardization.searchTemp')"><button class="btn-gray layui-btn layui-btn-sm button"><i class="layui-icon">&#xe65c;</i>返回</button></a>
    <c:if test="${logoff != '1'}">
        <a href="javascript:void(0)" onclick="javascript:filStandard.initAddFr()" id="xinzeng" style="display: none"><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe608;</i>新增</button></a>
        <a href="javascript:filStandard.saveFr('edit')" id="xiugai" style="display: none"><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe605;</i>保存</button></a>
        <a href="javascript:filStandard.saveFr('add')" id="baocun" ><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe605;</i>保存</button></a>
    </c:if>
    <%--<a href="javascript:void(0)" onclick="javascript:contact.deleteCc()" id="shanchu" style="display: none"><b class="zuofei">删除</b></a>--%>
    <input type="hidden" id="lymphedema" value="${lymphedema}">
    <input type="hidden" id="chyluria" value="${chyluria}">
</div>
<div class="divFixed125" style="top: 200px;">
    <div class="repeattable" id="contactsList" style="width:300px; float: left;margin-right: 10px;margin-top: 10px; margin-left: 10px;">
        <table id="ccList" class="layui-table x-admin-sm-table-list-middle">
            <colgroup>
                <col style="width:50%"/>
                <col style="width:50%"/>
            </colgroup>
            <thead>
            <tr>
                <th class="centerth">随访医生</th>
                <th class="centerth">随访日期</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="fr" items="${frList}" varStatus="status">
                <tr onclick="filStandard.clickRow(this)" id="${fr.id}">
                    <td><ehr:user userCode="${fr.visitById}"/></td>
                    <td><fmt:formatDate value="${fr.visitDt}" pattern="yyyy/MM/dd" /></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <table class="mini">
            <tr>
                <ehr:pagination-mini action="filStandard.searchFollowUpList"/>
            </tr>
        </table>
    </div>
    <div class="postcontent postdiv" id="detailDiv">
        <fieldset style="margin-top: 10px">
            <form id="frForm">
                <input type="hidden" id="listLcJson" name="listLcJson">
                <table class="posttable">
                    <colgroup>
                        <col/>
                        <col style="width:150px;"/>
                    </colgroup>
                    <tr>
                        <td colspan="2" style="text-align: center"><i class="popno" style="width: auto">
                            <c:if test="${lymphedema == 1}">淋巴水肿</c:if>
                            <c:if test="${chyluria == 1}">乳糜尿</c:if>
                            病人随访记录</i></td>
                    </tr>
                </table>
                <table class="posttable">
                    <colgroup>
                        <col style="min-width: 50px; width: 20%;" />
                        <col style="min-width: 80px; width: 29%;" />
                        <col style="min-width: 50px; width: 23%;" />
                        <col style="min-width: 80px; width: 28%;" />
                    </colgroup>
                    <tr>
                        <th>编号：</th>
                        <td>
                            <input type="text" name="visitNo" reg='{"length":"4"}'
                                   value="${listFr.visitNo}" style="width: 80px;"/>
                        </td>
                    </tr>
                    <tr>
                        <th>现住址：</th>
                        <td colspan="3">
                            <ehr:dic-town-village villageName="pastreet" townName="patownShip"
                                                  villageValue="${listFr.pastreet}" townValue="${listFr.patownShip}"
                                                  width="130px;"/>
                            <br><label id="tempPaValue">
                            <ehr:dic code="${listFr.patownShip}" dicmeta="FS990001"/><ehr:dic code="${listFr.pastreet}" dicmeta="FS990001"/>
                        </label>
                            <input type="text" name="pahouseNumber" value="${listFr.pahouseNumber}"
                                   reg='{"maxlength":"50"}' style="width: 90px;"/>
                        </td>
                    </tr>
                    <tr>
                        <input type="hidden" id="singleId" name="idmId" value="${singleId}">
                        <input type="hidden" name="id" value="${listFr.id}">
                        <th>姓名</th>
                        <td><input type="text" name="name" value="${listFr.name}" reg='{"maxlength":"50"}'/></td>
                        <th>年龄</th>
                        <td><input type="text" name="age" value="${listFr.age}" reg='{"maxlength":"20"}'/></td>
                    </tr>
                    <tr>
                        <th>性别</th>
                        <td><ehr:dic-radio dicmeta="GBT226112003" code="1,2"  name="gender" value="${listFr.gender}"/> </td>
                        <th>电话</th>
                        <td><input type="text" name="phoneNumber" value="${listFr.phoneNumber}" reg='{"regex":"phone"}'/></td>
                    </tr>
                    <tbody id="frDetailDiv">
                    <tr>
                        <td><b style="margin: 15px;">一般情况：</b></td>
                    </tr>
                    <tr>
                        <th>1.血压：</th>
                        <td><input type="text" name="bloodPressure" value="${listFr.bloodPressure}"
                                   reg='{"maxlength":"20"}' style="width: 80px;text-align: center">mmHg</td>
                        <th>2.脉搏：</th>
                        <td><input type="text" name="pulse" value="${listFr.pulse}" reg='{"maxlength":"20"}'
                                   style="width: 80px;text-align: center">次/分</td>
                    </tr>
                    <tr>
                        <th>3.体温：</th>
                        <td><input type="text" name="temperature" value="${listFr.temperature}" reg='{"maxlength":"20"}'
                                   style="width: 80px;text-align: center">℃</td>
                    </tr>
                    <c:if test="${lymphedema == 1}">
                        <tr>
                            <td><b style="margin: 15px;">患肢情况：</b></td>
                        </tr>
                        <tr>
                            <th>1.皮肤粗糙：</th>
                            <td><ehr:dic-radio name="pachulosis" dicmeta="PH00002" code="1,2" value="${listFr.pachulosis}"/></td>
                            <th>2.皮肤苔藓样变：</th>
                            <td><ehr:dic-radio name="skinLichen" dicmeta="PH00002" code="1,2" value="${listFr.skinLichen}"/></td>
                        </tr>
                        <tr>
                            <th>3.凹陷性水肿：</th>
                            <td><ehr:dic-radio name="pittingEdema" dicmeta="PH00002" code="1,2" value="${listFr.pittingEdema}"/></td>
                            <th>4.溃疡：</th>
                            <td><ehr:dic-radio name="ulcer" dicmeta="PH00002" code="1,2" value="${listFr.ulcer}"/></td>
                        </tr>
                        <tr>
                            <th>5.患肢畸形：</th>
                            <td><ehr:dic-radio name="deformity" dicmeta="PH00002" code="1,2" value="${listFr.deformity}"/></td>
                            <th>6.淋巴管/结发作：</th>
                            <td>
                                <ehr:dic-radio name="lymphatic" dicmeta="PH00002" code="1,2" value="${listFr.lymphatic}"
                                               onchange="toggleOther('lymphatic','lymphaticPart1',1);
                                                   toggleOther('lymphatic','lymphaticPart2',1);"/>
                            </td>
                        </tr>

                        <tr id="lymphaticPart1" style="display: none">
                            <th>最近发作时间：</th>
                            <td>
                                <input type="text" reg='{"required":"true"}' class="layui-input x-admin-content-sm-date"
                                       name="lymphaticLastBreakDt" id="lymphaticLastBreakDt"
                                       value="<fmt:formatDate value='${listFr.lymphaticLastBreakDt}' pattern='yyyy/MM/dd'/>"
                                       style="padding-left: 0px;"/>
                            <th>部位：</th>
                            <td><ehr:dic-radio name="breakPart" dicmeta="IDM00287" value="${listFr.breakPart}"/></td>
                        </tr>
                        <tr id="lymphaticPart2" style="display: none">
                            <th>特点：</th>
                            <td><ehr:dic-radio name="trait" dicmeta="IDM00279" value="${listFr.trait}"/></td>
                            <th>高热寒战：</th>
                            <td><ehr:dic-radio name="hyperpyrexiaShiver" dicmeta="PH00002" code="1,2" value="${listFr.hyperpyrexiaShiver}"/></td>
                        </tr>
                    </c:if>
                    <c:if test="${chyluria == 1}">
                        <tr>
                            <td colspan="3"><b style="margin: 15px;">患者发病情况：</b></td>
                        </tr>
                        <tr>
                            <th>1.3年内有无发病：</th>
                            <td><ehr:dic-radio name="isBreak" dicmeta="PH00002" code="1,2" value="${listFr.isBreak}"/></td>
                            <th>2.发作特点：</th>
                            <td><ehr:dic-list name="impressType" dicmeta="IDM00284" value="${listFr.impressType}"/></td>
                        </tr>
                        <tr>
                            <th>3.发作持续时间：</th>
                            <td><ehr:dic-list name="breakDuration" dicmeta="IDM00288" value="${listFr.breakDuration}"/></td>
                            <th>4.最近发作时间：</th>
                            <td>
                                <input type="text" reg='{"required":"true"}' class="layui-input x-admin-content-sm-date"
                                       name="lastBreakDt" id="lastBreakDt"
                                       value="<fmt:formatDate value='${listFr.lastBreakDt}' pattern='yyyy/MM/dd'/>"
                                       style="padding-left: 0px;"/>
                            </td>
                        </tr>
                        <tr>
                            <th>5.发作诱因：</th>
                            <td><ehr:dic-list name="incentive" dicmeta="IDM00283" value="${listFr.incentive}"/></td>
                            <th>6.尿液外观：</th>
                            <td>
                                <ehr:dic-list name="urineFacade" dicmeta="IDM00285" value="${listFr.urineFacade}" />
                            </td>
                        </tr>
                        <tr>
                            <th>7.排尿困难：</th>
                            <td><ehr:dic-radio name="urineHard" dicmeta="PH00002" code="1,2" value="${listFr.urineHard}"/></td>
                            <th>8.乳糜试验：</th>
                            <td>
                                <ehr:dic-radio name="chyle" dicmeta="FS10043" value="${listFr.chyle}"/>
                            </td>
                        </tr>
                        <tr>
                            <th>9.治疗情况：</th>
                            <td><ehr:dic-list name="treatCondition" dicmeta="IDM00286" code="1,2,4,99" value="${listFr.treatCondition}"/></td>
                        </tr>
                    </c:if>

                    <tr>
                        <td colspan="3"><b style="margin: 15px;">自我照料情况：</b></td>
                    </tr>
                    <c:if test="${lymphedema == 1}">
                        <tr>
                            <th>每天卫生清洁：</th>
                            <td><ehr:dic-radio name="health" dicmeta="PH00002" code="1,2" value="${listFr.health}"/></td>
                            <th>药物霜剂防治感染：</th>
                            <td><ehr:dic-radio name="infection" dicmeta="PH00002" code="1,2" value="${listFr.infection}"/></td>
                        </tr>
                        <tr>
                            <th>患肢抬高：</th>
                            <td><ehr:dic-radio name="raise" dicmeta="PH00002" code="1,2" value="${listFr.raise}"/></td>
                            <th>适当患肢锻炼：</th>
                            <td><ehr:dic-radio name="exercise" dicmeta="PH00002" code="1,2" value="${listFr.exercise}"/></td>
                        </tr>
                    </c:if>

                    <c:if test="${chyluria == 1}">
                        <tr>
                            <th>低脂高蛋白饮食：</th>
                            <td><ehr:dic-radio name="diet" dicmeta="PH00002" code="1,2" value="${listFr.diet}"/></td>
                            <th>每日饮水量：</th>
                            <td><ehr:dic-list name="water" dicmeta="IDM00290" value="${listFr.water}"/></td>
                        </tr>
                        <tr>
                            <th>劳作情况：</th>
                            <td><ehr:dic-radio name="workCondition" dicmeta="IDM00289" value="${listFr.workCondition}"/></td>
                            <th>登高和剧烈运动：</th>
                            <td><ehr:dic-radio name="sport" dicmeta="PH00002" code="1,2" value="${listFr.sport}"/></td>
                        </tr>
                    </c:if>
                    </tbody>
                </table>

                <table class="posttable">
                    <tr>
                        <td colspan="3">
                            <b style="margin: 15px;">自我照料情况和医生登记：</b>
                            <a href="javascript:void(0)" id="addEfcList">
                                <button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe608;</i>添加</button>
                            </a>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="4">
                            <div class="repeattable">
                                <div class="toolbarsublist">
                                    <%--<a href="javascript:void(0)"><b class="xinz">添加</b></a></b>--%>
                                </div>
                                <table id="lcTable" class="layui-table x-admin-sm-table-list-middle">
                                    <thead>
                                    <tr>
                                        <th class="centerth" rowspan="2" style="width: 90px;">推荐方法</th>
                                        <th class="centerth" colspan="3" style="width: 160px;">自我照料情况评价</th>
                                        <th class="centerth" rowspan="2" style="width: 120px;">存在问题</th>
                                        <th class="centerth" rowspan="2" >建议</th>
                                        <th class="centerth" rowspan="2" style="width: 130px;">操作</th>
                                    </tr>
                                    <tr>
                                        <th class="centerth">符合要求</th>
                                        <th class="centerth">不符要求</th>
                                        <th class="centerth">未做</th>
                                    </tr>
                                    </thead>
                                </table>
                            </div>
                        </td>
                    </tr>
                </table>

                <table style="margin-top: 15px;">
                    <colgroup>
                        <col style="min-width: 50px; width: 20%;" />
                        <col style="min-width: 80px; width: 29%;" />
                        <col style="min-width: 50px; width: 23%;" />
                        <col style="min-width: 80px; width: 28%;" />
                    </colgroup>
                    <tr>
                        <th>随访者：</th>
                        <td>
                            <ehr:user userCode="${listFr.visitById}"/>
                            <input type="hidden" name="visitById" value="${listFr.visitById}"/>
                        </td>
                        <th>随访日期：</th>
                        <td>
                            <input type="text" reg='{"required":"true"}' class="layui-input x-admin-content-sm-date"
                                   name="visitDt" id="visitDt"
                                   value="<fmt:formatDate value='${listFr.visitDt}' pattern='yyyy/MM/dd'/>"
                                   style="padding-left: 0px;"/>
                        </td>
                    </tr>
                </table>
            </form>
        </fieldset>
    </div>
</div>

</div>