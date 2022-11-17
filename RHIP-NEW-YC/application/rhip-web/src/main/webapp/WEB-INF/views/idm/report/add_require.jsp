<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ page import="com.founder.rhip.ehr.common.RoleType" %>
<c:set var="JKFYK" value="<%=RoleType.JKFYK.getValue()%>" />
<script src="${pageContext.request.contextPath}/js/views/idm/report/edit.js" type="text/javascript"></script>
<%-- <script data-main="${pageContext.request.contextPath}/js/util/main_report_idm" src="${pageContext.request.contextPath}/js/require/require.js"></script> --%>
<div class="toolbar">
    <c:choose>
	    <c:when test="${approvalFlag==1}">
            <a href="javascript:void(0)" id="returnId" onclick="javascript:reportEdit.returnSearch()"><b class="fanhui">返回</b></a>
            <a href="javascript:void(0)" id="passId" data-status="1" onclick="reportEdit.approval(2)"><b class="tongguo">通过</b></a>
            <a href="javascript:void(0)" id="cancelId" data-status="3" onclick="reportEdit.approval(3)"><b class="zuofei">作废</b></a>
            <a href="javascript:void(0)" id="recordId" data-id="${reportDto.report.idmId}" onclick="reportEdit.approvalDialog(${reportDto.report.idmId})"><b class="jilu">操作记录</b></a>
        </c:when>
        <c:when test="${reportFlag=='reportOut'}">
            <input type="hidden" id="orgFlag" value="${orgFlag}">
            <a href="javascript:void(0)" id="report-input-error-btn" name="report-input-error-btn"><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#x1006;</i>诊断错误</button></a>
        </c:when>
        <%--如果报卡已经审核通过，且角色为SQZX,可以修改报卡--%>
        <c:when test="${editFlag==1}">
            <a href="javascript:void(0)" id="returnId" onclick="javascript:reportEdit.returnSearch()"><b class="fanhui">返回</b></a>
            <a href="javascript:void(0)" id="saveId" data-status="4" onclick="reportEdit.approval(4)"><b class="tongguo">保存</b></a>
            <a href="javascript:void(0)" id="cancelId" data-status="3" onclick="reportEdit.approval(3)"><b class="zuofei">作废</b></a>
            <a href="javascript:void(0)" id="recordId" data-id="${reportDto.report.idmId}" onclick="reportEdit.approvalDialog(${reportDto.report.idmId})"><b class="jilu">操作记录</b></a>
        </c:when>
        <%--疾控可以修改和作废自己上报的卡--%>
        <c:when test="${(ROLE==JKFYK && reportDto.report.fillOrganCode==currentOrgCode)}">
            <a href="javascript:void(0)" id="returnId" onclick="<%--javascript:reportEdit.returnSearch()--%>"><b class="fanhui">返回</b></a>
            <a href="javascript:void(0)" id="saveId" data-status="4" onclick="reportEdit.approval(4)"><b class="tongguo">保存</b></a>
            <a href="javascript:void(0)" id="cancelId" data-status="3" onclick="reportEdit.approval(3)"><b class="zuofei">作废</b></a>
            <a href="javascript:void(0)" id="recordId" data-id="${reportDto.report.idmId}" onclick="reportEdit.approvalDialog(${reportDto.report.idmId})"><b class="jilu">操作记录</b></a>
        </c:when>
        <c:otherwise>
            <a href="javascript:void(0)" id="saveSubmit" onclick="<%--javascript:reportEdit.reportSubmit()--%>"><b class="tijiao">保存提交</b></a>
        </c:otherwise>
    </c:choose>
    <c:if test="${resubmit==1}">
    	<a href="javascript:void(0)" id="returnId" onclick="javascript:reportEdit.returnSystem()"><b class="fanhui">返回</b></a>
    </c:if>

    <a href="javascript:void(0)" id="report-input-save-btn" name="report-input-save-btn"><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe605;</i>提交报卡</button></a>
    <a href="javascript:void(0)" id="reportHelp"><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe607;</i>帮助</button></a>

    <input type="hidden" id="pageIndex" value="${pageIndex}">
    <input type="hidden" id="reportFlag" value="${reportFlag}">
    <input type="hidden"  id="occupationCheckAgeFlag"  value="1"/>
    <input type="hidden" id="report-result" name="report-result" value="-1" />
   	<input type="hidden" id="patownShip" value="${patownShip}">
   	<input type="hidden" id="idcardFlag" value="-1">
   	<input type="hidden" id="resubmit" value="${resubmit}">

</div>
<br/>
<br/>


<form id="reportForm">
<input type="hidden" id="reportRecordId" name ="reportRecordId" value="${reportRecordId}">
<input type="hidden" name ="reSubmitFlag" value="${reSubmitFlag}">
<input type="hidden" id="logoff" name="logoff" value="${reportDto.logoff}">
<input type="hidden" name="report.approvalFlg" value="${reportDto.report.approvalFlg}"/>
<input type="hidden" name="report.roleType" value="${reportDto.report.roleType}"/>
<%-- <input type="hidden" id="currentFillTime" name="report.currentFillTime" value="${reportDto.report.currentFillTime}"/>  --%>
    <div class="postcontent contentfixed32">
        <i class="popno">中华人民共和国传染病报告卡 </i>
        <div class="postdiv">
                <table class="posttable">
                    <tbody>
                    <tr>
                        <td style="width: 50%; text-align: left;">
                            卡片编号：
                            <c:choose>
                                <c:when test="${empty reportDto.report.recordNumber}">
                                    <span>自动生成</span>
                                </c:when>
                                <c:otherwise>
                                    ${reportDto.report.recordNumber}
                                    <input type="hidden" name="report.recordNumber" value="${reportDto.report.recordNumber}"/>
                                </c:otherwise>
                            </c:choose>
                            <input type="hidden" name="report.id" id="hiddenReportId" value="${reportDto.report.id}"/>
                            <input type="hidden" name="report.idmId" value="${reportDto.report.idmId}"/>
                            <input type="hidden" id="reportStatusId" name="report.reportStatus" value="${reportDto.report.reportStatus}"/>
                        </td>
                        <td style="width: 50%; text-align: right;">
                            <label class="required">报卡类别：</label>
                            <%-- <ehr:dic-radio id="reportCardTypeCode" name="report.reportCardTypeCode" dicmeta="IDM00001"
                                           value="${reportDto.report.reportCardTypeCode==null ? 1 : reportDto.report.reportCardTypeCode}"
                                          reg='{"required":"true"}'/> --%>
                             <ehr:dic-radio id="reportCardTypeCode" name="report.reportCardTypeCode" dicmeta="IDM00631"
                                  value="${reportDto.report.reportCardTypeCode==null ? 1 : reportDto.report.reportCardTypeCode}"
                                 reg='{"required":"true"}'/>
                        </td>
                    </tr>
                    </tbody>
                </table>
            <fieldset>
                <table class="posttable">
                    <colgroup>
                        <col style="min-width: 80px; width: 20%;"/>
                        <col style="min-width: 150px; width: 30%;"/>
                        <col style="min-width: 80px; width: 25%;"/>
                        <col style="min-width: 150px; width: 25%;"/>
                    </colgroup>
                    <tbody>
                    <tr>
                        <th>报告单位</th>
                        <td><input type="text" name="report.fillOrganName" value="${reportDto.report.fillOrganName}" readonly="readonly"/>
                            <input type="hidden" name="report.fillOrganCode" value="${reportDto.report.fillOrganCode}"/>
                        </td>
                    </tr>
                    <tr>
                        <th><label class="required">患者姓名</label></th>
                        <td><input type="text" id="name" name="report.name" value="${reportDto.report.name}" reg='{"maxlength":"10","required":"true"}'/></td>
                        <td></td>
                        <td></td>
                    </tr>
                    <tr>
                        <th>患儿家长姓名</th>
                        <td><input type="text" id="parentsName" name="report.parentsName" value="${reportDto.report.parentsName}" reg='{"maxlength":"50"}'/></td>
                    </tr>
                    <tr>
                        <th>身份证号</th>
                        <td>
							 <c:choose>
							 	<c:when test="${reportFlag=='reportOut'}">
									<tag:idcardInput id="idCard" name="report.idcard" value="${reportDto.report.idcard}" reg='{"idCard":"true"}'></tag:idcardInput>
							    </c:when>
							    <c:otherwise>
									<input type="text" id="idCard" name="report.idcard" value="${reportDto.report.idcard}"
							        	placeholder="输入身份证获取个人信息" reg='{"idCard":"true"}'/>
							    </c:otherwise>
							</c:choose>
                        </td>
                    </tr>
                   <%--  <tr>
                        <th>身份证件类别</th>
                        <td colspan="3"><ehr:dic-radio id="otherIdcardTypeId" name="report.otherIdcardType" dicmeta="CV0201101" code="01,02,03,04,05,06,07,99"
                                                        value="${reportDto.report.otherIdcardType==null ? '01' : reportDto.report.otherIdcardType}"
                                                        onchange="reportEdit.toggerIdcardType()"/></td>
                    </tr>
                    <tr id="otherIdcardTypeDiv1">
                        <th>身份证号</th>
                        <td>
							 <c:choose>
							 	<c:when test="${reportFlag=='reportOut'}">
									<tag:idcardInput id="idCard" name="report.idcard" value="${reportDto.report.idcard}" reg='{"idCard":"true"}'></tag:idcardInput>
							    </c:when>
							    <c:otherwise>
									<input type="text" id="idCard" name="report.idcard" value="${reportDto.report.idcard}"
							        	placeholder="输入身份证获取个人信息" reg='{"idCard":"true"}'/>
							    </c:otherwise>
							</c:choose>
                        </td>
                    </tr>
                    <tr id="otherIdcardTypeDiv2">
                        <th>其他证件号码</th>
                        <td><input type="text" id="otherIdcard" name="report.otherIdcard" value="${reportDto.report.otherIdcard}" reg='{"maxlength":"20"}'/></td>
                    </tr> --%>
                    <tr>
                        <th><label class="required">性别</label></th>
                        <td><ehr:dic-radio  name="report.gender" dicmeta="GBT226112003" value="${reportDto.report.gender}"  reg='{"required":"true"}' code="1,2"/></td>
                    </tr>
                    <tr>
                        <th><label class="required">出生日期</label></th>
                        <td colspan="3">
                            <input type="text" class="layui-input x-admin-content-sm-date" reg='{"required":"true","regex":"date"}'  name="report.birthday" id="birthday" style="width: 100px;padding-left: 0px;" value="<fmt:formatDate value='${reportDto.report.birthday}' pattern='yyyy/MM/dd'/>"/>
                            <span>（如出生日期不详，实足年龄:</span>
                            <input type="text" id="age"  style="width: 50px;" name="report.age" value="${reportDto.report.age}" reg='{"digits":"true","min":"1","max":"200"}'/>
                            <span>年龄单位:</span>
                            <ehr:dic-radio id="ageUnit" name="report.ageUnit"  dicmeta="IDM00003" value="${reportDto.report.ageUnit}"/>
                            <span>）</span></td>
                    </tr>
                    <tr>
                        <th>工作单位或学校或托幼机构</th>
                        <td><input type="text" id="unitNameId" name="report.unitName" value="${reportDto.report.unitName}" reg='{"maxlength":"70"}'/>
                        </td>
                    </tr>
                    <tr>
                        <th><label class="required">联系电话</label></th>
                        <td><input type="text" id="phoneNumberId" name="report.phoneNumber" value="${reportDto.report.phoneNumber}"
                                   reg='{"required":"true","regex":"phone","maxlength":20}'/></td>
                    </tr>
                    <tr>
                        <th><label class="required">病人属于</label></th>
                        <td colspan="3">
                        	<ehr:dic-radio name="report.infectedpersonBelong" dicmeta="CV0201104" id="infectedpersonBelongId" uninclude="7"
                                          value="${reportDto.report.infectedpersonBelong}"
                                          reg='{"required":"true"}'/>
                        </td>
                    </tr>
                    <tr>
                        <th><label class="required">现住址(详填)</label></th>
                        <td colspan="3">
                            <div class="${'2' eq reportDto.report.infectedpersonBelong ? 'hide' : '' }" id="pa-address-select">
                                <ehr:dic-town-street-village villageId="pavillage_address" streetId="pastreet_address" callback="reportEdit.displayPaAddress"
                                                             townId="patown_address" villageName="report.paGroup" streetName="report.pastreet"
                                                             townName="report.patownShip" villageValue="${reportDto.report.paGroup}" streetValue="${reportDto.report.pastreet}"
                                                             townValue="${reportDto.report.patownShip}" width="180px;" reg='{"dependOn":"report.infectedpersonBelong","dependValue":"1","required":"true"}'/>
                            </div>
                            <label id="tempPaValue">
                                <ehr:dic code="${reportDto.report.patownShip}" dicmeta="FS990001"/>
                                <ehr:dic code="${reportDto.report.pastreet}" dicmeta="FS990001"/>
                                <ehr:dic code="${reportDto.report.paGroup}" dicmeta="FS990001"/>
                            </label>
                            <input type="text" id="pahouseNumber" name="report.pahouseNumber" value="${reportDto.report.pahouseNumber}"
                                   reg='{"required":"true","maxlength":"70"}' style="width: 180px;"/>
                            <span id="spanPaNumber">(门牌号)</span>
                        </td>
                    </tr>
                    <tr>
                        <th><label class="required">患者职业</label></th>
                        <td colspan="3">
                            <ehr:dic-list id="Occupation" name="report.occupation" dicmeta="GBT6565" value="${reportDto.report.occupation}" reg='{"required":"true"}' width="150px"
                                          onchange="reportEdit.toggleOccupation('report.occupation','spanOccupationOther','CV020120299');reportEdit.occupationCheck(this.value);"
                                          code="CV020120201,CV020120202,CV020120203,CV020120204,CV020120205,CV020120206,CV020120207,CV020120208,CV020120209,CV020120210,CV020120211,CV020120212,CV020120213,CV020120214,CV020120215,CV020120216,CV020120299,CV020120217"/>
                            <span id="spanOccupationOther">
                            	<input type="text" style="width: 150px;" name="report.occupationOther" value="${reportDto.report.occupationOther}" reg='{"maxlength":"10"}' />
                            </span>
                        </td>
                    </tr>
                    <tr>
                        <th><label class="required">病例分类(1)</label></th>
                        <td colspan="3"><ehr:dic-radio id="caseCategory" name="report.caseCategory" dicmeta="CV0501002"
                                          value="${reportDto.report.caseCategory}" reg='{"required":"true"}' /></td>
                    </tr>
                    <tr>
                        <th>病例分类(2)</th>
                        <td colspan="3"><ehr:dic-radio id="caseCategoryFlag" name="report.caseCategoryFlag" dicmeta="FS10062"
                                          value="${reportDto.report.caseCategoryFlag}"/> <span>(乙型肝炎、丙型肝炎、血吸虫病必填)</span>
                        </td>
                    </tr>
                    <tr>
                        <th><label class="required">发病日期</label></th>
                        <td colspan="3">
                            <tag:dateInput nullToToday="true" id="pathogenesisDateId" name="report.pathogenesisDate" pattern="yyyy/MM/dd"
                                           date="${reportDto.report.pathogenesisDate}" onlypast="true" reg='{"required":"true"}'
                                           style="width: 100px"></tag:dateInput>
                            <span>(病原携带者填初检日期或就诊时间)</span>
                        </td>
                    </tr>
                    <tr>
                        <th><label class="required">诊断日期</label></th>
                        <td>
                            <input type="text" class="layui-input x-admin-content-sm-date" reg='{"required":"true","compare":["pathogenesisDateId","ge","诊断日期不能早于发病日期"]}' name="report.diagnosisDate" id="diagnosisDateId" style="width: 140px;padding-left: 0px;" value="<fmt:formatDate value='${reportDto.report.diagnosisDate}' pattern='yyyy/MM/dd'/>"/>
                            <input type="hidden" id="diagnosisHour" name="report.diagnosisHour"/>
                        </td>
                    </tr>
                    <tr>
                        <th>死亡日期</th>
                        <td>
                            <input type="text" class="layui-input x-admin-content-sm-date" reg='{"compare":["pathogenesisDateId","ge","死亡日期不能早于发病日期"]}' name="report.deathDate" id="deathDateId" style="width: 100px;padding-left: 0px;" value="<fmt:formatDate value='${reportDto.report.deathDate}' pattern='yyyy/MM/dd HH'/>"/>时
                            <input type="hidden" id="deathHour" name="report.deathHour"/>
                        </td>
                    </tr>
                    </tbody>
                </table>
            </fieldset>
            <fieldset class="topfield">
                <table class="posttable">
                    <colgroup>
                        <col style="min-width: 80px; width: 20%;"/>
                        <col style="min-width: 150px; width: 30%;"/>
                        <col style="min-width: 80px; width: 25%;"/>
                        <col style="min-width: 150px; width: 25%;"/>
                    </colgroup>
                    <tbody>

                    <tr>
                        <th><label class="required">传染病名称</label></th>
                        <td>
                            <select name="report.infectiousCode" id="infectiousCode" style="width: 150px;"
                                    reg='{"required":"true"}'>
                            </select>
                            <input type="hidden" id="infectiousName" name="report.infectiousName"/>
                            <input type="hidden" id="infectiousCodeHidden" value="${reportDto.report.infectiousCode}"/>
                            <input type="hidden" name="reportDesc.id" value="${reportDto.reportDesc.id}"/>
                            <input type="hidden" name="reportDesc.idmId" value="${reportDto.reportDesc.idmId}"/>
						</td>
                        <td><span id="sampleTip"></span></td>
                        <td></td>
                    </tr>
                    <tbody id="311detail" style="display: none">
                         <tr>
                             <th>实验室结果</th>
                             <td><ehr:dic-list id="hfmdCheckResult" name="reportDesc.checkResult" dicmeta="IDM00346" value="${reportDto.reportDesc.checkResult}"/></td>
                             <th>重症患者</th>
                             <td><ehr:dic-radio name="reportDesc.severeCase" dicmeta="PH00001" code="1,2" value="${reportDto.reportDesc.severeCase}"/></td>
                         </tr>
                    </tbody>
                    <tbody id="2032detail" style="display: none">
                        <tr>
                            <th>HBsAg阳性时间</th>
                            <td><ehr:dic-list name="reportDesc.hbsagPositiveDt" dicmeta="IDM00343" value="${reportDto.reportDesc.hbsagPositiveDt}"/></td>
                            <th>首次出现乙肝症状和体征时间</th>
                            <td>
                                <input type="text" class="layui-input x-admin-content-sm-date"  name="reportDesc.hbvSignDt" id="hbvSignDtID" value="<fmt:formatDate value='${reportDto.reportDesc.hbvSignDt}' pattern='yyyy/MM'/>" />
                            </td>
                        </tr>
                        <tr>
                            <th>本次ALT</th>
                            <td><input type="text" name="reportDesc.alt" value="${reportDto.reportDesc.alt}" style="width: 80px;" reg='{"maxlength":"20"}'>U/L</td>
                            <th>抗-HBc IgM 1:1000检测结果</th>
                            <td><ehr:dic-radio name="reportDesc.hbcCheckResult" dicmeta="CV0300404" code="2,3,1" value="${reportDto.reportDesc.hbcCheckResult}"/></td>
                        </tr>
                        <tr>
                            <th>肝穿检测结果</th>
                            <td><ehr:dic-radio name="reportDesc.punctureCheckResult" dicmeta="IDM00344" value="${reportDto.reportDesc.punctureCheckResult}"/></td>
                            <th>恢复期血清HBsAg阴转，抗HBs阳转</th>
                            <td><ehr:dic-radio name="reportDesc.hbsToPositive" dicmeta="PH00001" code="1,2,4" value="${reportDto.reportDesc.hbsToPositive}"/></td>
                        </tr>
                    </tbody>
                    <tbody id="206detail" style="display: none">
                        <tr>
                            <th><label class="required">病例分类(根据病情)</label></th>
                            <td><ehr:dic-radio name="reportDesc.conditionWay" dicmeta="IDM00342" value="${reportDto.reportDesc.conditionWay}"/></td>
                            <th><label class="required">是否住院</label></th>
                            <td><ehr:dic-radio name="reportDesc.inHospital" dicmeta="PH00001" code="1,2" value="${reportDto.reportDesc.inHospital}"/></td>
                        </tr>
                        <tr>
                            <th><label class="required">住院日期</label></th>
                            <td>
                                <input type="text" class="layui-input x-admin-content-sm-date"  name="reportDesc.inHospitalDt" id="inHospitalDtId" value="<fmt:formatDate value='${reportDto.reportDesc.inHospitalDt}' pattern='yyyy/MM/dd'/>"/>
                            </td>
                            <th><label class="required">出院日期</label></th>
                            <td>
                                <input type="text" class="layui-input x-admin-content-sm-date"  name="reportDesc.outHospitalDt" id="outHospitalDtId" value="<fmt:formatDate value='${reportDto.reportDesc.outHospitalDt}' pattern='yyyy/MM/dd'/>"/>
                            </td>
                        </tr>
                        <tr>
                            <th><label class="required">是否治愈</label></th>
                            <td><ehr:dic-radio name="reportDesc.cure" dicmeta="PH00001" code="1,2" value="${reportDto.reportDesc.cure}"/></td>
                            <th><label class="required">是否境外输入</label></th>
                            <td><ehr:dic-radio name="reportDesc.overseas" dicmeta="PH00001" code="1,2" value="${reportDto.reportDesc.overseas}"/></td>
                        </tr>
                    </tbody>
                    <tbody id="222223detail" style="display: none">
                        <tr>
                            <th><label class="required" re = 1>婚姻状况</label></th>
                             <td><ehr:dic-radio name="report.marriage" dicmeta="IDM00632" value="${reportDto.report.marriage}"/></td>
                           <%--  <td><ehr:dic-radio name="report.marriage" dicmeta="IDM00345" value="${reportDto.report.marriage}"/></td> --%>
                            <%-- <th><label class="required" re = 1>民族</label></th>
                            <td><ehr:dic-list id="nationId" name="report.nation" dicmeta="GBT3304" value="${reportDto.report.nation}"/></td> --%>
                        </tr>
                        <tr>
                            <th><label class="required" re = 1>文化程度</label></th>
                            <td colspan="3">
                                <ehr:dic-list id="educationId" name="report.education" dicmeta="GBT46582006" value="${reportDto.report.education}"
                                               code="IDM11,IDM12,IDM04,IDM13,IDM03,IDM02,IDM07,90" />
                            </td>
                            <th></th>
                            <td></td>
                        </tr>
                       <%--  <tr>
                            <th>户籍</th>
                            <td colspan="3">
                                <div class="${'2' eq reportDto.report.infectedpersonBelong ? 'hide' : '' }" id="hr-address-select">
                                <ehr:dic-town-village villageId="hrvillage_address" townId="hrtown_address" villageName="report.hrstreet" townName="report.hrtownShip"
                                                      villageValue="${reportDto.report.hrstreet}" townValue="${reportDto.report.hrtownShip}" width="180px;"/>

                                </div>
                                <label id="tempHrValue">
                                    <ehr:dic code="${reportDto.report.hrtownShip}" dicmeta="FS990001"/><ehr:dic code="${reportDto.report.hrstreet}" dicmeta="FS990001"/>
                                </label>
                                <input type="text" id="hrhouseNumber" name="report.hrhouseNumber" value="${reportDto.report.hrhouseNumber}"
                                       style="width: 180px;" reg='{"maxlength":"50"}'>
                                <span id="spanHrNumber"></span>
                            </td>
                        </tr> --%>
                        <tr>
                            <th><label class="required" re = 1>接触史</label></th>
                            <td colspan="3"><ehr:dic-checkbox name="reportDesc.contactHistory" dicmeta="IDM00338" value="${reportDto.reportDesc.contactHistory}"/></td>
                        </tr>
                        <tr>
                            <%-- <th><label class="required" re = 1>性病史</label></th>
                            <td><ehr:dic-radio name="reportDesc.vdHistory" dicmeta="PH00002" code="1,2,4" value="${reportDto.reportDesc.vdHistory}"/></td> --%>
                            <th><label class="required" re = 1>最可能感染途径</label></th>
                            <td><ehr:dic-list id="infectionWayId" name="reportDesc.infectionWay" dicmeta="IDM00339" value="${reportDto.reportDesc.infectionWay}"/></td>
                        </tr>
                        <tr>
                            <th><label class="required" re = 1>样本来源</label></th>
                            <td><ehr:dic-list id="sampleSourceId" name="reportDesc.sampleSource" dicmeta="IDM00340" value="${reportDto.reportDesc.sampleSource}"/></td>
                           <%--  <th><label class="required" re = 1>实验室检测结论</label></th>
                            <td><ehr:dic-radio name="reportDesc.checkConclusion" dicmeta="IDM00341" value="${reportDto.reportDesc.checkConclusion}"/></td> --%>
                        </tr>
                       <%--  <tr>
                            <th><label class="required" re = 1>确认（替代策略）检测阳性日期</label></th>
                            <td><tag:dateInput name="reportDesc.checkPositiveDt" onlypast="true" date="${reportDto.reportDesc.checkPositiveDt}"/></td>
                            <th><label class="required" re = 1>确认（替代策略）检测单位</label></th>
                            <td><input type="text" name="reportDesc.checkPositiveUnit" value="${reportDto.reportDesc.checkPositiveUnit}" reg='{"maxlength":"100"}'/></td>
                        </tr> --%>
                    </tbody>
                    <%-- <tr id="202detail" style="display: none">
                        <th><label class="required">艾滋病确诊日期</label></th>
                        <td><tag:dateInput name="reportDesc.hivDiagnoseDt" onlypast="true" date="${reportDto.reportDesc.hivDiagnoseDt}"/></td>
                    </tr>
                    <tr id="otherInfectiousName" style="display: none">
                        <th><label class="required">其他法定管理以及<br>重点监测传染病</label>
                        </th>
                        <td colspan="3"><input type="text" name="report.otherInfectiousName" value="${reportDto.report.otherInfectiousName}"
                                   reg='{"maxlength":"20","required":"true"}'/></td>
                    </tr> --%>
                </table>
            </fieldset>
            <fieldset class="topfield">
                <table class="posttable">
                    <colgroup>
                        <col style="min-width: 80px; width: 20%;"/>
                        <col style="min-width: 150px; width: 30%;"/>
                        <col style="min-width: 80px; width: 25%;"/>
                        <col style="min-width: 150px; width: 25%;"/>
                    </colgroup>
                    <tbody>
                    <tr>
                        <th>订正病名</th>
                        <td><input type="text" name="report.amendName" value="${reportDto.report.amendName}" reg='{"maxlength":"30"}'/>
                        </td>
                        <th>退卡原因</th>
                        <td><input type="text" name="report.backCardCause" value="${reportDto.report.backCardCause}"
                                   reg='{"maxlength":"50"}'/></td>
                    </tr>
                    <tr>

                        <th>联系电话</th>
                        <td><input type="text" name="report.fillOrganPhone" value="${reportDto.report.fillOrganPhone}"
                                   reg='{"regex":"phone","maxlength":"20"}'/></td>
                    </tr>
                </tbody>
                </table>
            </fieldset>
            <fieldset class="topfield">
                <table class="posttable">
                    <colgroup>
                        <col style="min-width: 80px; width: 20%;"/>
                        <col style="min-width: 150px; width: 30%;"/>
                        <col style="min-width: 80px; width: 25%;"/>
                        <col style="min-width: 150px; width: 25%;"/>
                    </colgroup>
                    <tbody>
                    <tr>
                        <th>报告医生</th>
                        <td>
                            <c:choose>
                            <c:when test="${reportDto.report.reportDoctorId == null}">
                                <input type="text" name="report.reportDoctorName" value="${reportDto.report.reportDoctorName}" readonly="readonly"/>
                            </c:when>
                            <c:otherwise >
                                <ehr:user userCode="${reportDto.report.reportDoctorId}"></ehr:user>                            </c:otherwise>
                            </c:choose>
							<input type="hidden"  name="report.reportDoctorId" value="${reportDto.report.reportDoctorId}"/>
                        </td>
                        <%-- <th><label class="required">填卡日期</label></th>
                        <td><tag:dateInput nullToToday="true" name="report.fillDate" pattern="yyyy/MM/dd"
                                           date="${reportDto.report.fillDate}" onlypast="true" reg='{"required":"true","compare":["pathogenesisDateId","ge","填卡日期不能小于发病日期"]}'
                                           style="width: 80px">
                        </tag:dateInput>
                        </td> --%>
                        <th><label class="required">填卡日期</label></th>
                        <td>
                            <input type="text" class="layui-input x-admin-content-sm-date" reg='{"required":"true","compare":["diagnosisDateId","ge","填卡日期不能早于诊断日期"]}'  name="report.fillDate" id="fillDateId" value="<fmt:formatDate value='${reportDto.report.fillDate}' pattern='yyyy/MM/dd HH:mm:ss' />" style="width: 140px;padding-left: 0px;"/>
                            <input type="hidden" id="fillHour" name="report.fillHour"/>
                        </td>
                    </tr>
                    </tbody>
                </table>
            </fieldset>
            <fieldset class="topfield" style="display: none" id="deleteContentId">
                <table class="posttable">

                    <colgroup>
                        <col style="min-width: 80px; width: 20%;"/>
                        <col style="min-width: 150px; width: 30%;"/>
                        <col style="min-width: 80px; width: 25%;"/>
                        <col style="min-width: 150px; width: 25%;"/>
                    </colgroup>
                    <tbody>
                    <tr>
                        <th>作废原因:</th>
                        <td colspan="3">
                            <ehr:dic-radio name="report.deleteContent" dicmeta="IDM00379" value="${reportDto.report.deleteContent}"/>
                            <span id="deleteContentOtherId" style="display: none"><input type="text" style="width: 200px;" name="report.deleteContentOther" reg="{'maxlength':200,'required':'true'}" value="${reportDto.report.deleteContentOther}" /></span>
                        </td>
                    </tr>
                    </tbody>
                </table>
            </fieldset>
                <fieldset class="topfield">
                    <table class="posttable">

                        <colgroup>
                            <col style="min-width: 80px; width: 20%;"/>
                            <col style="min-width: 150px; width: 30%;"/>
                            <col style="min-width: 80px; width: 25%;"/>
                            <col style="min-width: 150px; width: 25%;"/>
                        </colgroup>
                        <tbody>
                        <tr>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                        </tr>
                        <tr>
                            <th>备注</th>
                            <td colspan="3">
                                <textarea name="report.comments" style="width: 90%" rows=10
                                          reg='{"maxlength":"200"}'>${reportDto.report.comments}</textarea>
                            </td>
                        </tr>
                        </tbody>
                    </table>
                </fieldset>
        </div>
    </div>
</form>

<script type="text/javascript">
    layui.use('laydate', function() {
        var laydate = layui.laydate;

        laydate.render({
            elem: '#birthday'
            ,format:'yyyy/MM/dd'
            ,max:0
        });

        laydate.render({
            elem: '#pathogenesisDateId'
            ,format:'yyyy/MM/dd'
            ,max:0
        });

        laydate.render({
            elem: '#diagnosisDateId'
            ,format:'yyyy/MM/dd'
            ,max:0
        });

        laydate.render({
            elem: '#deathDateId'
            ,type:'datetime'
            ,format:'yyyy/MM/dd HH'
        });

        laydate.render({
            elem: '#hbvSignDtID'
            ,type:'month'
            ,format:'yyyy/MM'
            ,max:0
        });

        laydate.render({
            elem: '#inHospitalDtId'
            ,format:'yyyy/MM/dd'
            ,max:0
        });

        laydate.render({
            elem: '#outHospitalDtId'
            ,format:'yyyy/MM/dd'
            ,max:0
        });

        laydate.render({
            elem: '#fillDateId'
            ,type:'datetime'
            ,format:'yyyy/MM/dd HH:mm:ss'
            , trigger: 'click'
        });
    });

</script>






<%-- <%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ page import="com.founder.rhip.ehr.common.RoleType" %>
<c:set var="JKFYK" value="<%=RoleType.JKFYK.getValue()%>" />
<script data-main="${pageContext.request.contextPath}/js/util/main_report_idm" src="${pageContext.request.contextPath}/js/require/require.js"></script>
<script src="${pageContext.request.contextPath}/js/views/idm/report/edit.js" type="text/javascript"></script>

<div class="toolbar">
    <c:choose>
        <c:when test="${approvalFlag==1}">
            <a href="javascript:void(0)" id="returnId" onclick="javascript:reportEdit.returnSearch()""><b class="fanhui">返回</b></a>
            <a href="javascript:void(0)" id="passId" data-status="1" onclick="reportEdit.approval(1)"><b class="tongguo">通过</b></a>
            <a href="javascript:void(0)" id="cancelId" data-status="3" onclick="reportEdit.approval(3)"><b class="zuofei">作废</b></a>
            <a href="javascript:void(0)" id="recordId" data-id="${reportDto.report.idmId}" onclick="reportEdit.approvalDialog(${reportDto.report.idmId})"><b class="jilu">操作记录</b></a>
        </c:when>
        <c:when test="${reportFlag=='reportOut'}">
            <input type="hidden" id="orgFlag" value="${orgFlag}">
            <a id="report-input-save-btn" name="report-input-save-btn"  style="${orgFlag eq 1 ? 'display: none' : ''}"><b class="tijiao_out">提交报卡</b></a>
            <a id="report-input-error-btn" name="report-input-error-btn" style="${orgFlag eq 1 ? 'display: none' : ''}"><b class="quxiao_out">诊断错误</b></a>
        </c:when>
        如果报卡已经审核通过，且角色为SQZX,可以修改报卡
        <c:when test="${editFlag==1}">
            <a href="javascript:void(0)" id="returnId" onclick="javascript:reportEdit.returnSearch()"><b class="fanhui">返回</b></a>
            <a href="javascript:void(0)" id="saveId" data-status="4" onclick="reportEdit.approval(4)""><b class="tongguo">保存</b></a>
            <a href="javascript:void(0)" id="cancelId" data-status="3" onclick="reportEdit.approval(3)"><b class="zuofei">作废</b></a>
            <a href="javascript:void(0)" id="recordId" data-id="${reportDto.report.idmId}" onclick="reportEdit.approvalDialog(${reportDto.report.idmId})"><b class="jilu">操作记录</b></a>
        </c:when>
        疾控可以修改和作废自己上报的卡
        <c:when test="${(ROLE==JKFYK && reportDto.report.fillOrganCode==currentOrgCode)}">
            <a href="javascript:void(0)" id="returnId" onclick="javascript:reportEdit.returnSearch()"><b class="fanhui">返回</b></a>
            <a href="javascript:void(0)" id="saveId" data-status="4" onclick="reportEdit.approval(4)""><b class="tongguo">保存</b></a>
            <a href="javascript:void(0)" id="cancelId" data-status="3" onclick="reportEdit.approval(3)""><b class="zuofei">作废</b></a>
            <a href="javascript:void(0)" id="recordId" data-id="${reportDto.report.idmId}" onclick="reportEdit.approvalDialog(${reportDto.report.idmId})"><b class="jilu">操作记录</b></a>
        </c:when>
        <c:otherwise>
            <a href="javascript:void(0)" id="saveSubmit" onclick="javascript:reportEdit.reportSubmit()"><b class="tijiao">保存提交</b></a>
        </c:otherwise>
    </c:choose>
    <c:if test="${resubmit==1}">
    	<a href="javascript:void(0)" id="returnId" onclick="javascript:reportEdit.returnSystem()"><b class="fanhui">返回</b></a>
    </c:if>

    <a id="report-input-save-btn" name="report-input-save-btn"><b class="tijiao_out">提交报卡</b></a>
    <a href="javascript:void(0)" id="reportHelp" ><b class="help">帮助</b></a>

    <input type="hidden" id="pageIndex" value="${pageIndex}">
    <input type="hidden" id="reportFlag" value="${reportFlag}">
    <input type="hidden"  id="occupationCheckAgeFlag"  value="1"/>
    <input type="hidden" id="report-result" name="report-result" value="-1" />
   	<input type="hidden" id="patownShip" value="${patownShip}">
   	<input type="hidden" id="idcardFlag" value="-1">
   	<input type="hidden" id="resubmit" value="${resubmit}">

</div>
<br/>
<br/>

<form id="reportForm">
<input type="hidden" id="reportRecordId" name ="reportRecordId" value="${reportRecordId}">
<input type="hidden" name ="reSubmitFlag" value="${reSubmitFlag}">
<input type="hidden" id="logoff" name="logoff" value="${reportDto.logoff}">
    <div class="postcontent contentfixed32">
        <i class="popno">中华人民共和国传染病报告卡 </i>
        <div class="postdiv">
                <table class="posttable">
                    <tbody>
                    <tr>
                        <td style="width: 50%; text-align: left;">
                            卡片编号：
                            <c:choose>
                                <c:when test="${empty reportDto.report.recordNumber}">
                                    <span>自动生成</span>
                                </c:when>
                                <c:otherwise>
                                    ${reportDto.report.recordNumber}
                                    <input type="hidden" name="report.recordNumber" value="${reportDto.report.recordNumber}"/>
                                </c:otherwise>
                            </c:choose>
                            <input type="hidden" name="report.id" id="hiddenReportId" value="${reportDto.report.id}"/>
                            <input type="hidden" name="report.idmId" value="${reportDto.report.idmId}"/>
                            <input type="hidden" id="reportStatusId" name="report.reportStatus" value="${reportDto.report.reportStatus}"/>
                        </td>
                        <td style="width: 50%; text-align: right;">
                            <label class="required">报卡类别：</label>
                            <ehr:dic-radio id="reportCardTypeCode" name="report.reportCardTypeCode" dicmeta="IDM00001"
                                           value="${reportDto.report.reportCardTypeCode==null ? 1 : reportDto.report.reportCardTypeCode}"
                                          reg='{"required":"true"}'/>
                        </td>
                    </tr>
                    </tbody>
                </table>
            <fieldset>
                <table class="posttable">
                    <colgroup>
                        <col style="min-width: 80px; width: 20%;"/>
                        <col style="min-width: 150px; width: 30%;"/>
                        <col style="min-width: 80px; width: 25%;"/>
                        <col style="min-width: 150px; width: 25%;"/>
                    </colgroup>
                    <tbody>
                    <tr>
                        <th>报告单位</th>
                        <td><input type="text" name="report.fillOrganName" value="${reportDto.report.fillOrganName}" readonly="readonly"/>
                            <input type="hidden" name="report.fillOrganCode" value="${reportDto.report.fillOrganCode}"/>
                        </td>
                    </tr>
                    <tr>
                        <th><label class="required">患者姓名</label></th>
                        <td><input type="text" id="name" name="report.name" value="${reportDto.report.name}" reg='{"maxlength":"10","required":"true"}'/></td>
                        <td></td>
                        <td></td>
                    </tr>
                    <tr>
                        <th>患儿家长姓名</th>
                        <td><input type="text" id="parentsName" name="report.parentsName" value="${reportDto.report.parentsName}" reg='{"maxlength":"50"}'/></td>
                    </tr>
                    <tr>
                        <th>身份证号</th>
                        <td>
							 <c:choose>
							 	<c:when test="${reportFlag=='reportOut'}">
									<tag:idcardInput id="idCard" name="report.idcard" value="${reportDto.report.idcard}" reg='{"idCard":"true"}'></tag:idcardInput>
							    </c:when>
							    <c:otherwise>
									<input type="text" id="idCard" name="report.idcard" value="${reportDto.report.idcard}"
							        	placeholder="输入身份证获取个人信息" reg='{"idCard":"true"}'/>
							    </c:otherwise>
							</c:choose>
                        </td>
                    </tr>
                    <tr>
                        <th><label class="required">性别</label></th>
                        <td><ehr:dic-radio  name="report.gender" dicmeta="GBT226112003" value="${reportDto.report.gender}"  reg='{"required":"true"}' code="1,2"/></td>
                    </tr>
                    <tr>
                        <th><label class="required">出生日期</label></th>
                        <td colspan="3">
                        	<tag:dateInput nullToToday="true" id="birthday" name="report.birthday" style="width: 100px;"
                                           reg='{"required":"true","regex":"date"}'  pattern="yyyy/MM/dd" date="${reportDto.report.birthday}" onlypast="true">
                            </tag:dateInput>
                            <span>（如出生日期不详，实足年龄:</span>
                            <input type="text" id="age"  style="width: 50px;" name="report.age" value="${reportDto.report.age}" reg='{"digits":"true","min":"1","max":"200"}'/>
                            <span>年龄单位:</span>
                            <ehr:dic-radio id="ageUnit" name="report.ageUnit"  dicmeta="IDM00003" value="${reportDto.report.ageUnit}"/>
                            <span>）</span></td>
                    </tr>
                    <tr>
                        <th>工作单位</th>
                        <td><input type="text" id="unitNameId" name="report.unitName" value="${reportDto.report.unitName}" reg='{"maxlength":"70"}'/>
                        </td>
                    </tr>
                    <tr>
                        <th><label class="required">联系电话</label></th>
                        <td><input type="text" id="phoneNumberId" name="report.phoneNumber" value="${reportDto.report.phoneNumber}"
                                   reg='{"required":"true","regex":"phone","maxlength":20}'/></td>
                    </tr>
                    <tr>
                        <th><label class="required">病人属于</label></th>
                        <td colspan="3">
                        	<ehr:dic-radio name="report.infectedpersonBelong" dicmeta="CV0201104" id="infectedpersonBelongId"
                                          value="${reportDto.report.infectedpersonBelong}"
                                          reg='{"required":"true"}'/>
                        </td>
                    </tr>
                    <tr>
                        <th><label class="required">现住址(详填)</label></th>
                        <td colspan="3">
                            <div class="${'2' eq reportDto.report.infectedpersonBelong ? 'hide' : '' }" id="pa-address-select">
                                <ehr:dic-town-village villageId="pavillage_address" townId="patown_address"
                            	villageName="report.pastreet" townName="report.patownShip"
                                villageValue="${reportDto.report.pastreet}"
                                townValue="${reportDto.report.patownShip}" width="180px;"
                                reg='{"dependOn":"report.infectedpersonBelong","dependValue":"1","required":"true"}'/>
                            <span id="pabr">
                                <br/>
                            </span>
                            </div>
                            <label id="tempPaValue">
                                <ehr:dic code="${reportDto.report.patownShip}" dicmeta="FS990001"/><ehr:dic code="${reportDto.report.pastreet}" dicmeta="FS990001"/>
                            </label>
                            <input type="text" id="pahouseNumber" name="report.pahouseNumber" value="${reportDto.report.pahouseNumber}"
                                   reg='{"required":"true","maxlength":"70"}' style="width: 180px;"/>
                            <span id="spanPaNumber">(门牌号)</span>
                        </td>
                    </tr>
                    <tr>
                        <th><label class="required">患者职业</label></th>
                        <td colspan="3">
                        	<ehr:dic-list id="Occupation" name="report.occupation" dicmeta="GBT6565" value="${reportDto.report.occupation}" reg='{"required":"true"}' width="200px"
                            	code="CV020120201,CV020120202,CV020120203,CV020120204,CV020120205,CV020120206,CV020120207,CV020120208,CV020120209,CV020120210,CV020120211,CV020120212,CV020120213,CV020120214,CV020120215,CV020120216,CV020120299,CV020120217"/>
                            <span id="spanOccupationOther">
                            	<input type="text" style="width: 150px;" name="report.occupationOther" value="${reportDto.report.occupationOther}" reg='{"maxlength":"10"}' />
                            </span>
                        </td>
                    </tr>
                    <tr>
                        <th><label class="required">病例分类(1)</label></th>
                        <td colspan="3"><ehr:dic-radio id="caseCategory" name="report.caseCategory" dicmeta="CV0501002"
                                          value="${reportDto.report.caseCategory}" reg='{"required":"true"}' /></td>
                    </tr>
                    <tr>
                        <th>病例分类(2)</th>
                        <td><ehr:dic-radio id="caseCategoryFlag" name="report.caseCategoryFlag" dicmeta="FS10062"
                                          value="${reportDto.report.caseCategoryFlag}"/> <span>(乙型肝炎、血吸虫病填写)</span>
                        </td>
                    </tr>
                    <tr>
                        <th><label class="required">发病日期</label></th>
                        <td colspan="3">
                            <tag:dateInput id="pathogenesisDateId" name="report.pathogenesisDate" pattern="yyyy/MM/dd"
                                           date="${reportDto.report.pathogenesisDate}" onlypast="true" reg='{"required":"true"}'
                                           style="width: 100px"></tag:dateInput>
                            <span>(病原携带者填初检日期或就诊时间)</span>
                        </td>
                    </tr>
                    <tr>
                        <th><label class="required">诊断日期</label></th>
                        <td>
                        	<tag:dateInput nullToToday="true" id="diagnosisDateId" name="report.diagnosisDate" pattern="yyyy/MM/dd HH:mm:ss"
                            	date="${reportDto.report.diagnosisDate}" onlypast="true" reg='{"required":"true","compare":["pathogenesisDateId","ge","诊断日期不能小于发病日期"]}' style="width: 140px"></tag:dateInput>
                            <input type="hidden" id="diagnosisHour" name="report.diagnosisHour"/>
                        </td>
                    </tr>
                    <tr>
                        <th>死亡日期</th>
                        <td><tag:dateInput nullToToday="true" id="deathDateId" name="report.deathDate" pattern="yyyy/MM/dd"
                                           date="${reportDto.report.deathDate}" onlypast="true" reg='{"compare":["pathogenesisDateId","ge","死亡日期不能小于发病日期"]}'
                                           style="width: 100px"></tag:dateInput></td>
                    </tr>
                    </tbody>
                </table>
            </fieldset>
            <fieldset class="topfield">
                <table class="posttable">
                    <colgroup>
                        <col style="min-width: 80px; width: 20%;"/>
                        <col style="min-width: 150px; width: 30%;"/>
                        <col style="min-width: 80px; width: 25%;"/>
                        <col style="min-width: 150px; width: 25%;"/>
                    </colgroup>
                    <tbody>

                    <tr>
                        <th><label class="required">传染病名称</label></th>
                        <td>
                            <select name="report.infectiousCode" id="infectiousCode" style="width: 150px;"
                                    reg='{"required":"true"}'>
                            </select>
                            <input type="hidden" id="infectiousName" name="report.infectiousName"/>
                            <input type="hidden" id="infectiousCodeHidden" value="${reportDto.report.infectiousCode}"/>
                            <input type="hidden" name="reportDesc.id" value="${reportDto.reportDesc.id}"/>
                            <input type="hidden" name="reportDesc.idmId" value="${reportDto.reportDesc.idmId}"/>
						</td>
                        <td><span id="sampleTip"></span></td>
                        <td></td>
                    </tr>
                    <tbody id="311detail" style="display: none">
                         <tr>
                             <th>实验室结果</th>
                             <td><ehr:dic-list id="hfmdCheckResult" name="reportDesc.checkResult" dicmeta="IDM00346" value="${reportDto.reportDesc.checkResult}"/></td>
                             <th>重症患者</th>
                             <td><ehr:dic-radio name="reportDesc.severeCase" dicmeta="PH00001" code="1,2" value="${reportDto.reportDesc.severeCase}"/></td>
                         </tr>
                    </tbody>
                    <tbody id="2032detail" style="display: none">
                        <tr>
                            <th>HBsAg阳性时间</th>
                            <td><ehr:dic-list name="reportDesc.hbsagPositiveDt" dicmeta="IDM00343" value="${reportDto.reportDesc.hbsagPositiveDt}"/></td>
                            <th>首次出现乙肝症状和体征时间</th>
                            <td><tag:dateInput id="hbvSignDtID" name="reportDesc.hbvSignDt" date="${reportDto.reportDesc.hbvSignDt}" pattern="yyyy/MM"/></td>
                        </tr>
                        <tr>
                            <th>本次ALT</th>
                            <td><input type="text" name="reportDesc.alt" value="${reportDto.reportDesc.alt}" style="width: 80px;" reg='{"maxlength":"20"}'>U/L</td>
                            <th>抗-HBc IgM 1:1000检测结果</th>
                            <td><ehr:dic-radio name="reportDesc.hbcCheckResult" dicmeta="CV0300404" code="2,3,1" value="${reportDto.reportDesc.hbcCheckResult}"/></td>
                        </tr>
                        <tr>
                            <th>肝穿检测结果</th>
                            <td><ehr:dic-radio name="reportDesc.punctureCheckResult" dicmeta="IDM00344" value="${reportDto.reportDesc.punctureCheckResult}"/></td>
                            <th>恢复期血清HBsAg阴转，抗HBs阳转</th>
                            <td><ehr:dic-radio name="reportDesc.hbsToPositive" dicmeta="PH00001" code="1,2,4" value="${reportDto.reportDesc.hbsToPositive}"/></td>
                        </tr>
                    </tbody>
                    <tbody id="206detail" style="display: none">
                        <tr>
                            <th><label class="required">病例分类(根据病情)</label></th>
                            <td><ehr:dic-radio name="reportDesc.conditionWay" dicmeta="IDM00342" value="${reportDto.reportDesc.conditionWay}"/></td>
                            <th><label class="required">是否住院</label></th>
                            <td><ehr:dic-radio name="reportDesc.inHospital" dicmeta="PH00001" code="1,2" value="${reportDto.reportDesc.inHospital}"/></td>
                        </tr>
                        <tr>
                            <th><label class="required">住院日期</label></th>
                            <td><tag:dateInput name="reportDesc.inHospitalDt" pattern="yyyy/MM/dd" date="${reportDto.reportDesc.inHospitalDt}" onlypast="true"/></td>
                            <th><label class="required">出院日期</label></th>
                            <td><tag:dateInput name="reportDesc.outHospitalDt" pattern="yyyy/MM/dd" date="${reportDto.reportDesc.outHospitalDt}" onlypast="true"/></td>
                        </tr>
                        <tr>
                            <th><label class="required">是否治愈</label></th>
                            <td><ehr:dic-radio name="reportDesc.cure" dicmeta="PH00001" code="1,2" value="${reportDto.reportDesc.cure}"/></td>
                            <th><label class="required">是否境外输入</label></th>
                            <td><ehr:dic-radio name="reportDesc.overseas" dicmeta="PH00001" code="1,2" value="${reportDto.reportDesc.overseas}"/></td>
                        </tr>
                    </tbody>
                    <tbody id="222223detail" style="display: none">
                        <tr>
                            <th><label class="required" re = 1>婚姻状况</label></th>
                            <td><ehr:dic-radio name="report.marriage" dicmeta="IDM00345" value="${reportDto.report.marriage}"/></td>
                            <th><label class="required" re = 1>民族</label></th>
                            <td><ehr:dic-list id="nationId" name="report.nation" dicmeta="GBT3304" value="${reportDto.report.nation}"/></td>
                        </tr>
                        <tr>
                            <th><label class="required" re = 1>文化程度</label></th>
                            <td>
                                <ehr:dic-list id="educationId" name="report.education" dicmeta="GBT46582006" value="${reportDto.report.education}"
                                               code="IDM11,IDM12,IDM04,IDM13,IDM03,IDM02,IDM07,90" />
                            </td>
                            <th></th>
                            <td></td>
                        </tr>
                        <tr>
                            <th>户籍</th>
                            <td colspan="3">
                                <div class="${'2' eq reportDto.report.infectedpersonBelong ? 'hide' : '' }" id="hr-address-select">
                                <ehr:dic-town-village villageId="hrvillage_address" townId="hrtown_address" villageName="report.hrstreet" townName="report.hrtownShip"
                                                      villageValue="${reportDto.report.hrstreet}" townValue="${reportDto.report.hrtownShip}" width="180px;"/>
                                <span id="hrbr">
                                    <br/>
                                </span>
                                </div>
                                <label id="tempHrValue">
                                    <ehr:dic code="${reportDto.report.hrtownShip}" dicmeta="FS990001"/><ehr:dic code="${reportDto.report.hrstreet}" dicmeta="FS990001"/>
                                </label>
                                <input type="text" id="hrhouseNumber" name="report.hrhouseNumber" value="${reportDto.report.hrhouseNumber}"
                                       style="width: 180px;" reg='{"maxlength":"50"}'>
                                <span id="spanHrNumber"></span>
                            </td>
                        </tr>
                        <tr>
                            <th><label class="required" re = 1>接触史</label></th>
                            <td colspan="3"><ehr:dic-checkbox name="reportDesc.contactHistory" dicmeta="IDM00338" value="${reportDto.reportDesc.contactHistory}"/></td>
                        </tr>
                        <tr>
                            <th><label class="required" re = 1>性病史</label></th>
                            <td><ehr:dic-radio name="reportDesc.vdHistory" dicmeta="PH00002" code="1,2,4" value="${reportDto.reportDesc.vdHistory}"/></td>
                            <th><label class="required" re = 1>最可能感染途径</label></th>
                            <td><ehr:dic-list id="infectionWayId" name="reportDesc.infectionWay" dicmeta="IDM00339" value="${reportDto.reportDesc.infectionWay}"/></td>
                        </tr>
                        <tr>
                            <th><label class="required" re = 1>样本来源</label></th>
                            <td><ehr:dic-list id="sampleSourceId" name="reportDesc.sampleSource" dicmeta="IDM00340" value="${reportDto.reportDesc.sampleSource}"/></td>
                            <th><label class="required" re = 1>实验室检测结论</label></th>
                            <td><ehr:dic-radio name="reportDesc.checkConclusion" dicmeta="IDM00341" value="${reportDto.reportDesc.checkConclusion}"/></td>
                        </tr>
                        <tr>
                            <th><label class="required" re = 1>确认（替代策略）检测阳性日期</label></th>
                            <td><tag:dateInput name="reportDesc.checkPositiveDt" onlypast="true" date="${reportDto.reportDesc.checkPositiveDt}"/></td>
                            <th><label class="required" re = 1>确认（替代策略）检测单位</label></th>
                            <td><input type="text" name="reportDesc.checkPositiveUnit" value="${reportDto.reportDesc.checkPositiveUnit}" reg='{"maxlength":"100"}'/></td>
                        </tr>
                    </tbody>
                    <tr id="202detail" style="display: none">
                        <th><label class="required">艾滋病确诊日期</label></th>
                        <td><tag:dateInput name="reportDesc.hivDiagnoseDt" onlypast="true" date="${reportDto.reportDesc.hivDiagnoseDt}"/></td>
                    </tr>
                    <tr id="otherInfectiousName" style="display: none">
                        <th><label class="required">其他法定管理以及<br>重点监测传染病</label>
                        </th>
                        <td colspan="3"><input type="text" name="report.otherInfectiousName" value="${reportDto.report.otherInfectiousName}"
                                   reg='{"maxlength":"20","required":"true"}'/></td>
                    </tr>
                </table>
            </fieldset>
            <fieldset class="topfield">
                <table class="posttable">
                    <colgroup>
                        <col style="min-width: 80px; width: 20%;"/>
                        <col style="min-width: 150px; width: 30%;"/>
                        <col style="min-width: 80px; width: 25%;"/>
                        <col style="min-width: 150px; width: 25%;"/>
                    </colgroup>
                    <tbody>
                    <tr>
                        <th>订正病名</th>
                        <td><input type="text" name="report.amendName" value="${reportDto.report.amendName}" reg='{"maxlength":"30"}'/>
                        </td>
                        <th>退卡原因</th>
                        <td><input type="text" name="report.backCardCause" value="${reportDto.report.backCardCause}"
                                   reg='{"maxlength":"50"}'/></td>
                    </tr>
                    <tr>

                        <th>联系电话</th>
                        <td><input type="text" name="report.fillOrganPhone" value="${reportDto.report.fillOrganPhone}"
                                   reg='{"regex":"phone","maxlength":"20"}'/></td>
                    </tr>
                </tbody>
                </table>
            </fieldset>
            <fieldset class="topfield">
                <table class="posttable">
                    <colgroup>
                        <col style="min-width: 80px; width: 20%;"/>
                        <col style="min-width: 150px; width: 30%;"/>
                        <col style="min-width: 80px; width: 25%;"/>
                        <col style="min-width: 150px; width: 25%;"/>
                    </colgroup>
                    <tbody>
                    <tr>
                        <th>报告医生</th>
                        <td>
                            <c:choose>
                            <c:when test="${reportDto.report.reportDoctorId == null}">
                                <input type="text" name="report.reportDoctorName" value="${reportDto.report.reportDoctorName}" readonly="readonly"/>
                            </c:when>
                            <c:otherwise >
                                <ehr:user userCode="${reportDto.report.reportDoctorId}"></ehr:user>                            </c:otherwise>
                            </c:choose>
							<input type="hidden"  name="report.reportDoctorId" value="${reportDto.report.reportDoctorId}"/>
                        </td>
                        <th><label class="required">填卡日期</label></th>
                        <td><tag:dateInput nullToToday="true" name="report.fillDate" pattern="yyyy/MM/dd"
                                           date="${reportDto.report.fillDate}" onlypast="true" reg='{"required":"true","compare":["pathogenesisDateId","ge","填卡日期不能小于发病日期"]}'
                                           style="width: 80px">
                        </tag:dateInput>
                        </td>
                    </tr>
                    </tbody>
                </table>
            </fieldset>
            <fieldset class="topfield" style="display: none" id="deleteContentId">
                <table class="posttable">

                    <colgroup>
                        <col style="min-width: 80px; width: 20%;"/>
                        <col style="min-width: 150px; width: 30%;"/>
                        <col style="min-width: 80px; width: 25%;"/>
                        <col style="min-width: 150px; width: 25%;"/>
                    </colgroup>
                    <tbody>
                    <tr>
                        <th>作废原因:</th>
                        <td colspan="3">
                            <ehr:dic-radio name="report.deleteContent" dicmeta="IDM00379" value="${reportDto.report.deleteContent}"/>
                            <span id="deleteContentOtherId" style="display: none"><input type="text" style="width: 200px;" name="report.deleteContentOther" reg="{'maxlength':200,'required':'true'}" value="${reportDto.report.deleteContentOther}" /></span>
                        </td>
                    </tr>
                    </tbody>
                </table>
            </fieldset>
                <fieldset class="topfield">
                    <table class="posttable">

                        <colgroup>
                            <col style="min-width: 80px; width: 20%;"/>
                            <col style="min-width: 150px; width: 30%;"/>
                            <col style="min-width: 80px; width: 25%;"/>
                            <col style="min-width: 150px; width: 25%;"/>
                        </colgroup>
                        <tbody>
                        <tr>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                        </tr>
                        <tr>
                            <th>备注</th>
                            <td colspan="3">
                                <textarea name="report.comments" style="width: 90%" rows=10
                                          reg='{"maxlength":"200"}'>${reportDto.report.comments}</textarea>
                            </td>
                        </tr>
                        </tbody>
                    </table>
                </fieldset>
        </div>
    </div>
</form>
 --%>