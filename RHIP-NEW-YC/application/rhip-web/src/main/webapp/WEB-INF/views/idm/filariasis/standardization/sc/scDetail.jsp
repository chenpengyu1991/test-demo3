<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib  tagdir="/WEB-INF/tags" prefix="tag"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<script src="${pageContext.request.contextPath}/js/views/idm/filariasis/followup.js" type="text/javascript"></script>

<div class="postdiv" id="detailDiv">
    <fieldset style="margin-top: 10px">
        <form id="scForm">
            <table class="posttable">
                <tr>
                    <td style="text-align: center"><i class="popno" style="width: auto">慢性丝虫病工作督导检查记录表</i></td>
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
                    <input type="hidden" id="singleId" name="idmId" value="${singleId}">
                    <input type="hidden" name="id" value="${listSc.id}">
                    <th><label class="required">姓名：</label></th>
                    <td><input type="text" name="name" value="${listSc.name}" reg='{"required":"true","maxlength":"50"}'/></td>
                    <th><label class="required">年龄：</label></th>
                    <td><input type="text" name="age" value="${listSc.age}" reg='{"required":"true","maxlength":"20"}'/></td>
                </tr>
                <tr>
                    <th><label class="required">性别：</label></th>
                    <td><ehr:dic-radio dicmeta="GBT226112003" code="1,2"  name="gender" value="${listSc.gender}" reg='{"required":"true"}'/> </td>
                    <th><label class="required">电话：</label></th>
                    <td><input type="text" name="phoneNumber" value="${listSc.phoneNumber}" reg='{"required":"true","regex":"phone"}'/></td>
                </tr>
                <tr>
                    <th><label class="required">住址：</label></th>
                    <td colspan="3">
                        <ehr:dic-town-village villageName="pastreet" townName="patownShip"
                                              villageValue="${listSc.pastreet}" townValue="${listSc.patownShip}"
                                              width="130px;" reg='{"required":"true"}'/>
                        <label id="tempPaValue">
                            <ehr:dic code="${listSc.patownShip}" dicmeta="FS990001"/><ehr:dic code="${listSc.pastreet}" dicmeta="FS990001"/>
                        </label>
                        <input type="text" name="pahouseNumber" value="${listSc.pahouseNumber}"
                               reg='{"maxlength":"50"}' style="width: 120px;" reg='{"required":"true","maxlength":"100"}'/>
                    </td>
                </tr>
            </table>
            <table id="scDetailDiv" class="posttable">
                <colgroup>
                    <col style="min-width: 150px; width: 33%;" />
                    <col style="min-width: 100px; width: 20%;" />
                    <col style="min-width: 100px; width: 20%;" />
                    <col style="min-width: 100px;" />
                </colgroup>
                <tr>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                </tr>
                <tr>
                    <td><b style="margin: 15px;">责任医生工作情况：</b></td>
                </tr>
                <tr>
                    <th>1.年内随访：</th>
                    <td colspan="3"><input type="text" name="followupNum" value="${listSc.followupNum}" style="width: 80px;text-align: center" reg='{"maxlength":"20"}'>次</td>
                </tr>
                <tr>
                    <th>随访日期：</th>
                    <td colspan="3"><input type="text" name="followupDtStr" value="${listSc.followupDtStr}" reg='{"maxlength":"200"}'></td>
                </tr>
                <tr>
                    <th>2.有哪些督导内容：</th>
                    <td colspan="3">
                        <ehr:dic-checkbox name="supervisorContent" dicmeta="IDM00291" value="${listSc.supervisorContent}" onchange="toggleOtherCK('supervisorContent','supervisorOther',99);"/>
                        <input type="text" id="supervisorOther" name="supervisorOther" value="${listSc.supervisorOther}" style="width: 120px;display: none" reg='{"maxlength":"200"}'>
                    </td>
                </tr>
                <tr>
                    <th>3.年内发放哪些照料用品：</th>
                    <td colspan="3"><input type="text" name="mindGoods" value="${listSc.mindGoods}" reg='{"maxlength":"200"}'/></td>
                </tr>
                <tr>
                    <th>4.在自我照料方面需要哪些帮助：</th>
                    <td colspan="3"><input type="text" name="assistance" value="${listSc.assistance}" reg='{"maxlength":"200"}'/></td>
                </tr>
                <tr>
                    <td><b style="margin: 15px;">患者满意度：</b></td>
                </tr>
                <tr>
                    <th>1.患者对责任医生的服务态度和工作质量是否满意？</th>
                    <td colspan="3"><ehr:dic-radio name="satisfaction" dicmeta="IDM00292" value="${listSc.satisfaction}"/></td>
                </tr>
                <tr>
                    <th>2.上述评价的理由是：</th>
                    <td colspan="3">
                        <textarea id="reasonContent" name="reasonContent" rows="3" reg='{"maxlength":"800"}'>${listSc.reasonContent}</textarea>
                    </td>
                </tr>
                <tr>
                    <th>评价和整改意见：</th>
                    <td colspan="3"><textarea id="suggestion" name="suggestion" rows="3" reg='{"maxlength":"800"}'>${listSc.suggestion}</textarea></td>
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
                    <th>检查人：</th>
                    <td>
                        <ehr:user userCode="${listSc.checkUser}"/>
                        <input type="hidden" name="checkUser" value="${listSc.checkUser}"/>
                    </td>
                    <th>检查日期：</th>
                    <td>
                    <%-- <tag:dateInput name="supervisorDt" pattern="yyyy/MM/dd" onlypast="true" date="${listSc.supervisorDt}"/> --%>
                    <input type="text" reg='{"required":"true"}' class="layui-input x-admin-content-sm-date"
                               name="supervisorDt" id="supervisorDt"
                               value="<fmt:formatDate value='${listSc.supervisorDt}' pattern='yyyy/MM/dd'/>"
                               style="padding-left: 0px;"/>
                    </td>
                </tr>
            </table>
        </form>
    </fieldset>
</div>

<script type="text/javascript">
    layui.use('laydate', function () {
        var laydate = layui.laydate;

        laydate.render({
            elem: '#supervisorDt'
            , format: 'yyyy/MM/dd'
            , max: 0
        });


    });
    
  </script>