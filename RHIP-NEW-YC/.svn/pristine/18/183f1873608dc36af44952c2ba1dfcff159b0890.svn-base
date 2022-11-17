<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<script src="${pageContext.request.contextPath}/js/views/oh/occPatient/reportAdd.js" type="text/javascript"></script>
<form id="report-input-form">
    <div class="toolbar">
        <a href="javascript:void(0)" onclick="javascript:occPatientReportAdd.returnSearch()"><button class="btn-gray layui-btn layui-btn-sm button"><i class="layui-icon">&#xe65c;</i>返回</button></a>
        <c:if test="${type ne 'view'}">
            <a href="javascript:void(0)" id="report-input-save-btn">
                <a href="javascript:void(0)" id="reportSave"><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe605;</i>保存</button></a>
            </a>
        </c:if>
    </div>
    <div class="postcontent contentfixed32" style="padding-top:15px">
        <i class="popno">职业病报告卡</i>

        <div class="postdiv">
            <fieldset>
                <legend>基本信息</legend>
                <table class="posttable">
                    <colgroup>
                        <col style="width: 20%; min-width: 100px;"/>
                        <col style="width: 30%; min-width: 200px;"/>
                        <col style="width: 20%; min-width: 100px;"/>
                        <col style="width: 30%; min-width: 200px;"/>
                    </colgroup>
                    <tr>
                        <th><label class="required">姓名</label></th>
                        <td><input type="text" name="name" value="${odReport.name}" id="nameStr" reg="{'required':true,'maxlength':50}"/></td>
                        <th>城乡居民健康档案编号</th>
                        <td>
                            <input type="text" name="healthFileNo" id="healthFileNoStr" value="${odReport.healthFileNo}" reg='{"maxlength":"17"}'/>
                        </td>
                    </tr>
                    <tr>
                        <th>职业病报告卡编号</th>
                        <td>
                            <input type="text" name="recordNumber" value="${odReport.recordNumber}" reg='{"maxlength":"20"}'/>
                        </td>
                        <th><label class="required">性别</label></th>
                        <td><ehr:dic-radio id="gender" uninclude="0,9" dicmeta="GBT226112003" name="gender"
                                           value="${odReport.gender}" reg="{'required':true}"/></td>
                    </tr>
                    <tr>
                        <th><label class="required">出生日期</label></th>
                        <td>
                            <input type="text" class="layui-input x-admin-content-sm-date" reg='{"required":"true"}' name="birthday" id="birthday" style="padding-left: 0px;"
                                   value="<fmt:formatDate value='${odReport.birthday}' pattern='yyyy/MM/dd'/>" />
                        </td>
                        <th>身份证件类别</th>
                        <td>
                            <ehr:dic-list name="idcardType" dicmeta="CV0201101" value="${odReport.idcardType}" width="75%;"/>
                        </td>
                    </tr>
                    <tr>
                        <th><label class="required">身份证件号码</label></th>
                        <td>
                            <%--<input type="text" name="idcard" value="${odReport.idcard}" reg="{'maxlength':18}">--%>
                            <input type="text" id="idCard" name="idcard" value="${odReport.idcard}"
                                   placeholder="输入身份证获取个人信息" reg='{"idCard":"true"}'/>
                        </td>
                        <th>行政区划代码</th>
                        <td><input type="text" name="areaCode" value="${odReport.areaCode}" reg="{'maxlength':6}"/></td>
                    </tr>
                    <tr>
                        <th>户籍地址</th>
                        <td colspan="3">
                            <input type="text" name="hrprovince" style="width: 80px;" reg="{'maxlength':70}" value="${odReport.hrprovince}">省
                            <input type="text" name="hrcity" style="width: 80px;" reg="{'maxlength':70}" value="${odReport.hrcity}">市
                            <input type="text" name="hrcounty" style="width: 80px;" reg="{'maxlength':70}" value="${odReport.hrcounty}">县(区)
                            <input type="text" name="hrtownShip" style="width: 80px;" reg="{'maxlength':70}" value="${odReport.hrtownShip}">乡(镇、街道办事处)
                            <input type="text" name="hrhouseNumber" style="width: 200px;" reg="{'maxlength':70}" value="${odReport.hrhouseNumber}">(门牌号码)
                        </td>
                    </tr>
                    <tr>
                        <th><label class="required">现住址(详填)</label></th>
                        <td colspan="3">
                         	 <ehr:dic-town-street-village villageId="pavillage_address" streetId="street_address"
														 townId="patown_address" villageName="paGroup" streetName="pastreet"
														 townName="patownShip" villageValue="${odReport.paGroup}" streetValue="${odReport.pastreet}"
														 townValue="${odReport.patownShip}" width="118px;" reg="{'required':true}" />
                           <%--  <ehr:dic-town-village villageId="pavillage_address" townId="patown_address"
                                                  villageName="pastreet" townName="patownShip"
                                                  villageValue="${odReport.pastreet}"
                                                  townValue="${odReport.patownShip}" width="180px;"/> --%>
                            <%--<label id="tempPaValue">--%>
                                <%--<ehr:dic code="${odReport.patownShip}" dicmeta="FS990001"/>--%>
                                <%--<ehr:dic code="${odReport.pastreet}" dicmeta="FS990001"/>--%>
                            <%--</label>--%>
                            <input type="text" id="pahouseNumber" name="pahouseNumber" value="${odReport.pahouseNumber}"
                                   reg='{"required":"true","maxlength":"70"}' style="width: 180px;"/>
                            <span id="spanPaNumber">(门牌号)</span>
                        </td>
                    </tr>
                    <tr>
                        <th><label class="required">工作单位地址</label></th>
                        <td colspan="3">
                           <%--  <ehr:dic-town-village villageId="pavillage_address" townId="patown_address"
                                                  villageName="uastreet" townName="uatownShip"
                                                  villageValue="${odReport.uastreet}"
                                                  townValue="${odReport.uatownShip}" width="180px;"/> --%>
                            <%--<label id="tempPaValue">--%>
                                <%--<ehr:dic code="${odReport.patownShip}" dicmeta="FS990001"/><ehr:dic--%>
                                    <%--code="${odReport.pastreet}"--%>
                                    <%--dicmeta="FS990001"/>--%>
                            <%--</label>--%>
                            <input type="text" id="uahouseNumber" name="uahouseNumber" value="${odReport.uahouseNumber}"
                                   reg='{"required":"true","maxlength":"70"}' style="width: 180px;"/>
                            <span id="spanPaNumber"><!-- (门牌号) --></span>
                        </td>
                    </tr>
                    <tr>
                        <th>邮政编码</th>
                        <td><input type="text" name="postCode" value="${odReport.postCode}"
                                   reg="{'maxlength':6}"/></td>
                        <th><label class="required">本人电话号码</label></th>
                        <td><input type="text" id="phoneNumberId"  name="phoneNumber" value="${odReport.phoneNumber}"
                                   reg="{'required':true,'regex':'phone'}"/></td>
                    </tr>
                    <tr>
                        <th>家人电话号码</th>
                        <td><input type="text" name="familyPhone" value="${odReport.familyPhone}"
                                   reg="{'regex':'phone'}"/></td>
                        <th>学历</th>
                        <td><ehr:dic-list name="education" id="educationId" dicmeta="GBT46582006" value="${odReport.education}" width="75%;"/></td>
                    </tr>
                    <tr>
                        <th><label class="required">工作单位名称</label></th>
                        <td><input type="text" name="unitName" value="${odReport.unitName}" id="unitNameId"
                                   reg="{'required':true,'maxlength':70}"/></td>
                        <th>工作单位电话号码</th>
                        <td><input type="text" name="unitPhone" value="${odReport.unitPhone}" reg="{'regex':'phone'}"/></td>
                    </tr>
                    <tr>
                        <th><label class="required">从事职业工种描述</label></th>
                        <td><input type="text" name="workDesc" value="${odReport.workDesc}" reg="{'required':true,'maxlength':100}"/></td>
                    </tr>
                </table>
            </fieldset>
            <fieldset>
                <legend>职业病信息</legend>
                <table class="posttable">
                    <colgroup>
                        <col style="width: 20%; min-width: 100px;"/>
                        <col style="width: 30%; min-width: 200px;"/>
                        <col style="width: 20%; min-width: 100px;"/>
                        <col style="width: 30%; min-width: 200px;"/>
                    </colgroup>
                    <tr>
                        <th>受照史</th>
                        <td><input type="text" name="irradiationHistory" value="${odReport.irradiationHistory}"
                                   reg="{'maxlength':'100'}"/></td>
                        <th>职业照射种类</th>
                        <td><ehr:dic-list name="occupationExposureTypeCode" dicmeta="CV0300201" value="${odReport.occupationExposureTypeCode}" width="75%;"/></td>
                    </tr>
                    <tr>
                        <th>开始从事放射工作日期</th>
                        <td>
                            <input type="text" class="layui-input x-admin-content-sm-date" name="startWorkDate" id="startWorkDate" style="padding-left: 0px;"
                                   value="<fmt:formatDate value='${odReport.startWorkDate}' pattern='yyyy/MM/dd'/>" />
                        </td>
                        <th>开始接尘日期</th>
                        <td>
                            <input type="text" class="layui-input x-admin-content-sm-date" name="startDustDate" id="startDustDate" style="padding-left: 0px;"
                                   value="<fmt:formatDate value='${odReport.startDustDate}' pattern='yyyy/MM/dd'/>" />
                        </td>
                    </tr>
                    <tr>
                        <th>实际接害工龄(a)</th>
                        <td><input type="text" name="actualHarmAge" value="${odReport.actualHarmAge}" reg="{'maxlength':'2'}"/></td>
                    </tr>
                    <tr>
                        <th>放射工龄(a)</th>
                        <td><input type="text" name="radiationAge" value="${odReport.radiationAge}" reg="{'maxlength':'2'}"/></td>
                        <th>累积受照时长(h/a)</th>
                        <td><input type="text" name="cumulativeExposureRuntime"  value="${odReport.cumulativeExposureRuntime}" reg="{'maxlength':'4'}"/></td>
                    </tr>
                    <tr>
                        <th>受照日期</th>
                        <td>
                            <input type="text" class="layui-input x-admin-content-sm-date" name="exposureDate" id="exposureDate" style="padding-left: 0px;"
                                   value="<fmt:formatDate value='${odReport.exposureDate}' pattern='yyyy/MM/dd'/>" />
                        </td>
                        <th>首次出现症状日期</th>
                        <td>
                            <input type="text" class="layui-input x-admin-content-sm-date" name="firstSymptomsDate" id="firstSymptomsDate" style="padding-left: 0px;"
                                   value="<fmt:formatDate value='${odReport.firstSymptomsDate}' pattern='yyyy/MM/dd'/>" />
                        </td>
                    </tr>
                    <tr>
                        <th>受照剂量(Gy)</th>
                        <td><input type="text" name="exposureDose" value="${odReport.exposureDose}" reg="{'maxlength':'6','number':'ture','scale':'1'}"/></td>
                        <th>受照类型</th>
                        <td><ehr:dic-list name="exposureTypeCode" dicmeta="FS10020" value="${odReport.exposureTypeCode}" width="75%;"/></td>
                    </tr>
                    <tr>
                        <th>受照原因</th>
                        <td><ehr:dic-list name="exposureReasonCode" dicmeta="CV0300202" value="${odReport.exposureReasonCode}" width="75%;"/></td>
                        <th><label class="required">职业病-种类</label></th>
                        <td><input type="text" name="occupationTypeCode" value="${odReport.occupationTypeCode}"
                                   reg="{'required':true,'maxlength':'2','number':'ture'}"/></td>
                    </tr>
                    <tr>
                        <th>尘肺--类别</th>
                        <td><input type="text" name="asbestosisType" value="${odReport.asbestosisType}"
                                   reg="{'maxlength':'1','number':'ture'}"/></td>
                        <th>尘肺期别</th>
                        <td><ehr:dic-list name="asbestosisStage" dicmeta="CV0501026" code="2,3,4" value="${odReport.asbestosisStage}" width="75%;"/></td>
                    </tr>
                    <tr>
                        <th><label class="required">职业病-名称(ICD-10)</label></th>
                        <td><input type="text" name="occupationNameCode" value="${odReport.occupationNameCode}"
                                   reg="{'required':true,'maxlength':'20'}"/></td>
                        <th>职业病伤残等级</th>
                        <td><ehr:dic-list name="occupationLevelCode" dicmeta="CV0510004" value="${odReport.occupationLevelCode}" width="75%;"/></td>
                    </tr>
                    <tr>
                        <th>职业病转归</th>
                        <td><ehr:dic-list name="occupationPrognosisCode" dicmeta="CV0510010" value="${odReport.occupationLevelCode}" width="75%;"/></td>
                        <th>职业性放射性-疾病</th>
                        <td><input type="text" name="occupationRadiationCode" value="${odReport.occupationRadiationCode}" reg="{'maxlength':'100'}"/></td>
                    </tr>
                    <tr>
                        <th>放射性疾病的分度</th>
                        <td><ehr:dic-list name="radiationIndexCode" dicmeta="CV0501033" value="${odReport.radiationIndexCode}" width="75%;"/></td>
                        <th>放射性疾病的分期</th>
                        <td><ehr:dic-list name="radiationDivisionCode" dicmeta="CV0501034" value="${odReport.radiationDivisionCode}" width="75%;"/></td>
                    </tr>
                    <tr>
                        <th>尘肺合并肺结核的标志</th>
                        <td><ehr:dic-radio name="asbestosisTuberculosisFlag" dicmeta="PH00001" code="1,2"
                                           value="${odReport.asbestosisTuberculosisFlag}"/></td>
                        <th>职业性放射性疾病处理类别</th>
                        <td><ehr:dic-list name="occupationRadiationType" dicmeta="CV0600205" value="${odReport.occupationRadiationType}" width="75%;"/></td>
                    </tr>
                    <tr>
                        <th>死亡日期时间</th>
                        <td>
                            <input type="text" class="layui-input x-admin-content-sm-date" name="deathDate" id="deathDate" style="padding-left: 0px;"
                                   value="<fmt:formatDate value='${odReport.deathDate}' pattern='yyyy/MM/dd HH:mm:ss'/>" />
                        </td>
                        <th>根本-死因(ICD-10)</th>
                        <td><input type="text" id="underlyingDeathCode" name="underlyingDeathCode" value="${odReport.underlyingDeathCode}" reg="{'maxlength':'20'}"/></td>
                    </tr>
                    <tr>
                        <th><label class="required">诊断机构名称</label></th>
                        <td><input type="text" name="diagnosisOrganName" value="${odReport.diagnosisOrganName}"
                                   reg="{'required':true,'maxlength':'70'}"></td>
                        <th><label class="required">诊断日期时间</label></th>
                        <td>
                            <input type="text" class="layui-input x-admin-content-sm-date" reg="{'required':true}" name="diagnosisDate" id="diagnosisDate" style="padding-left: 0px;"
                                   value="<fmt:formatDate value='${odReport.diagnosisDate}' pattern='yyyy/MM/dd HH:mm:ss'/>" />
                        </td>
                    </tr>
                    <tr>
                        <th><label class="required">诊断医师姓名</label></th>
                        <td><input type="text" name="diagnosticianName" value="${odReport.diagnosticianName}"
                                   reg="{'required':true,'maxlength':'50'}"></td>
                        <th>填报机构名称</th>
                        <td><input type="text" name="fillOrganName" value="${odReport.fillOrganName}"
                                   reg="{'required':true,'maxlength':'70'}">
                            <input type="hidden" name="createOrganCode"  value="${odReport.createOrganCode}"/>      
                        </td>
                                   
                    </tr>
                    <tr>
                        <th>填报人姓名</th>
                        <td><input type="text" name="fillUserName" value="${odReport.fillUserName}"
                                   reg="{'required':true,'maxlength':'50'}"></td>
                        <th>填报日期时间</th>
                        <td><input type="text" class="layui-input x-admin-content-sm-date" name="fillTime" id="fillTime" style="padding-left: 0px;"
                                   value="<fmt:formatDate value='${odReport.fillTime}' pattern='yyyy/MM/dd HH:mm:ss'/>" reg="{'required':true}"/>
                        </td>
                    </tr>
                </table>
            </fieldset>
        </div>
    </div>
</form>
<script type="text/javascript">
    layui.use('laydate', function(){
        var laydate = layui.laydate;

        laydate.render({
            elem: '#birthday'
            ,format: 'yyyy/MM/dd'
            ,max:0
        });

        laydate.render({
            elem: '#startWorkDate'
            ,format: 'yyyy/MM/dd'
            ,max:0
        });

        laydate.render({
            elem: '#startDustDate'
            ,format: 'yyyy/MM/dd'
            ,max:0
        });

        laydate.render({
            elem: '#exposureDate'
            ,format: 'yyyy/MM/dd'
            ,max:0
        });

        laydate.render({
            elem: '#firstSymptomsDate'
            ,format: 'yyyy/MM/dd'
            ,max:0
        });

        laydate.render({
            elem: '#deathDate'
            ,format: 'yyyy/MM/dd HH:mm:ss'
            ,max:0
            ,trigger: 'click'
        });
        laydate.render({
            elem: '#diagnosisDate'
            ,format: 'yyyy/MM/dd HH:mm:ss'
            ,max:0
            ,trigger: 'click'
        });
        laydate.render({
            elem: '#fillTime'
            ,format: 'yyyy/MM/dd HH:mm:ss'
            ,max:0
            ,trigger: 'click'
        });

    });
</script>