<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<script src="${pageContext.request.contextPath}/js/views/idm/malaria/visit.js" type="text/javascript"></script>
<div class="toolbar">
    <div class="toolbar" style="background: none">
        <a href="javascript:standardSearch.returnSearch()" id="cancelContact"><b class="fanhui">返回</b></a>
        <c:if test="${logoff != '1'}">
        	<a href="javascript:visit.submitVisit()"><b class="baocun">保存</b></a>
        </c:if>
    </div>
</div>
<form id="visitForm">
    <input type="hidden" id="pageIndex" name="pageIndex" value="${pageIndex}">
    <input type="hidden" name="singleId" value="${malariaDto.singleId}"/>
    <input type="hidden" name="idmId" value="${malariaDto.idmId}"/>
    <input type="hidden" id="type" name="type" value="${type}"/>
    <input type="hidden" id="logoff" value="${logoff}"/>
    <input type="hidden" id="listFrJson" name="listFrJson"/>
    <input type="hidden" id="listSdJson" name="listSdJson"/>
    <div class="postcontent">
        <i class="popno">市疟疾病人治疗和访视记录 </i>
        <div class="postdiv">
            <fieldset>
                <legend>一般情况</legend>
                <table class="posttable">
                    <colgroup>
                        <col style="width: 15%" />
                        <col style="width: 35%" />
                        <col style="width: 15%" />
                        <col style="width: 35%" />
                    </colgroup>
                    <tbody>
                    <tr>
                        <th><label class="required">姓名：</label></th>
                        <td>
                            <input type="hidden" name="generalCondition.id" value="${malariaDto.generalCondition.id}">
                            <input type="text" name="generalCondition.name" value="${malariaDto.generalCondition.name}"
                                   reg='{"required":"true","maxlength":"50"}'/>
                        </td>
                        <th><label class="required">性别：</label></th>
                        <td>
                            <ehr:dic-radio name="generalCondition.gender"
                                           dicmeta="GBT226112003" value="${malariaDto.generalCondition.gender}" code="1,2" reg='{"required":"true"}'/>
                        </td>
                    </tr>
                    <tr>
                        <th><label class="required">年龄：</label></th>
                        <td>
                            <input type="text" id="age" name="generalCondition.age" value="${malariaDto.generalCondition.age}"
                                   reg='{"required":"true","maxlength":"20"}'/>
                        </td>
                        <th><label class="required">职业：</label></th>
                        <td colspan="3">
                            <ehr:dic-list dicmeta="GBT6565" name="generalCondition.occupation" width="150px;" value="${malariaDto.generalCondition.occupation}"
                                          code="CV020120201,CV020120202,CV020120203,CV020120204,CV020120205,CV020120206,CV020120207,CV020120208,CV020120209,CV020120210,CV020120211,CV020120212,CV020120213,CV020120214,CV020120215,CV020120216,CV020120299"
                                          onchange="toggleOtherSC('generalCondition.occupation','occupationPart','CV020120299');"
                                          reg='{"required":"true"}'/>
                            <span  id="occupationPart" style="display: none">
                                <input type="text" name="generalCondition.occupationOther" value="${malariaDto.generalCondition.occupationOther}"
                                       reg='{"maxlength":"30"}' style="width: 100px;"/>
                            </span>
                        </td>
                    </tr>
                    <tr>
                        <th>常住类型：</th>
                        <td colspan="3">
                            <ehr:dic-radio name="generalCondition.floatPopulation" dicmeta="FS10005"
                                           value="${malariaDto.generalCondition.floatPopulation}" onchange="idmCommon.toggerAddress()"/>
                        </td>
                    </tr>
                    <tr>
                        <th><label class="required">住址：</label></th>
                        <td colspan="3">
                            <ehr:dic-town-village villageId="pavillage_address" townId="patown_address" villageName="generalCondition.pastreet" townName="generalCondition.patownShip"
                                                  villageValue="${malariaDto.generalCondition.pastreet}" townValue="${malariaDto.generalCondition.patownShip}" width="150px;" reg='{"required":"true"}'/>
                            <div>
	                            <label id="tempPaValue">
	                                <ehr:dic code="${malariaDto.generalCondition.patownShip}" dicmeta="FS990001"/><ehr:dic code="${malariaDto.generalCondition.pastreet}" dicmeta="FS990001"/>
	                            </label>
	                            <input type="text" id="pahouseNumber" name="generalCondition.pahouseNumber" value="${malariaDto.generalCondition.pahouseNumber}"
	                                   reg='{"required":"true","maxlength":"50"}'  style="width: 200px;">
	                            <span id="spanPaNumber">(门牌号)</span>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <th><label class="required">户籍所在地：</label></th>
                        <td colspan="3">
                            <ehr:dic-town-village villageId="hrvillage_address" townId="hrtown_address" villageName="generalCondition.hrstreet" townName="generalCondition.hrtownShip"
                                                  villageValue="${malariaDto.generalCondition.hrstreet}" townValue="${malariaDto.generalCondition.hrtownShip}" width="150px;"
                                                  reg='{"required":"true"}'/>
                            <div>
	                            <label id="tempHrValue">
	                                <ehr:dic code="${malariaDto.generalCondition.hrtownShip}" dicmeta="FS990001"/><ehr:dic code="${malariaDto.generalCondition.hrstreet}" dicmeta="FS990001"/>
	                            </label>
	                            <input type="text" name="generalCondition.hrhouseNumber" id="hrhouseNumber" value="${malariaDto.generalCondition.hrhouseNumber}"
	                                   reg='{"required":"true","maxlength":"50"}' style="width: 200px;" >
	                            <span id="spanHrNumber">(门牌号)</span>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <th><label class="required">发病地点：</label></th>
                        <td colspan="2">
                            <input type="hidden" name="attackCondition.id" value="${malariaDto.attackCondition.id}">
                            <input type="text"  name="attackCondition.pathogenesisPlace" value="${malariaDto.attackCondition.pathogenesisPlace}" reg='{"required":"true","maxlength":"100"}'/>
                        </td>
                    </tr>
                    <tr>
                        <th><label class="required">发病日期：</label></th>
                        <td>
                            <tag:dateInput name="attackCondition.pathogenesisDate" onlypast="true" date="${malariaDto.attackCondition.pathogenesisDate}"
                                    reg='{"required":"true"}'/>
                        </td>
                        <th><label class="required">确诊日期：</label></th>
                        <td>
                            <input type="hidden" name="diagnosis.id" value="${malariaDto.diagnosis.id}">
                            <tag:dateInput name="diagnosis.diagnosisDt" onlypast="true" date="${malariaDto.diagnosis.diagnosisDt}"
                                    reg='{"required":"true"}'/>
                        </td>
                    </tr>
                    <tr>
                        <th><label class="required">治疗开始日期：</label></th>
                        <td>
                            <input type="hidden" name="otherCondition.id" value="${malariaDto.otherCondition.id}">
                            <tag:dateInput name="otherCondition.therapyTime" pattern="yyyy/MM/dd" onlypast="true" date="${malariaDto.otherCondition.therapyTime}"
                                    reg='{"required":"true"}'/>
                        </td>
                        <th><label class="required">治疗方案：</label></th>
                        <td>
                            <input type="text"  name="otherCondition.treatMethod" value="${malariaDto.otherCondition.treatMethod}" reg='{"required":"true","maxlength":"200"}'/>
                        </td>
                    </tr>
                    <tr>
                        <th><label class="required">治疗药物和剂量：</label></th>
                        <td colspan="3">
                            氯喹总量（ 150㎎/片）
                            <input type="hidden" name="drugTherapy.id" value="${malariaDto.drugTherapy.id}">
                            <input type="text" name="drugTherapy.chloroquineTotal" value="${malariaDto.drugTherapy.chloroquineTotal}" reg='{"maxlength":"20"}'  style="width: 55px;text-align: center">片，
                            第1天<input type="text" name="drugTherapy.troche1" value="${malariaDto.drugTherapy.troche1}" reg='{"maxlength":"20"}' style="width: 55px;text-align: center">片，
                            第2天<input type="text" name="drugTherapy.troche2" value="${malariaDto.drugTherapy.troche2}" reg='{"maxlength":"20"}' style="width: 55px;text-align: center">片，
                            第3天<input type="text" name="drugTherapy.troche3" value="${malariaDto.drugTherapy.troche3}" reg='{"maxlength":"20"}' style="width: 55px;text-align: center">片，
                            第4天<input type="text" name="drugTherapy.troche4" value="${malariaDto.drugTherapy.troche4}" reg='{"maxlength":"20"}' style="width: 55px;text-align: center">片
                            <br>伯喹总量（ 7.5㎎/片）
                            <input type="text" name="drugTherapy.primaquineTotal" value="${malariaDto.drugTherapy.primaquineTotal}" reg='{"maxlength":"20"}' style="width: 55px;text-align: center">片，
                            第1天至第<input type="text" name="drugTherapy.daysNum" value="${malariaDto.drugTherapy.daysNum}" reg='{"maxlength":"20"}' style="width: 55px;text-align: center">天，
                            每天<input type="text" name="drugTherapy.trochePre" value="${malariaDto.drugTherapy.trochePre}" reg='{"maxlength":"20"}' style="width: 55px;text-align: center">片
                            <br>其他<a href="javascript:visit.addDrug()" >&nbsp;<b style="padding-left: 15px;" class="xinz">添加</b></a><br>
                            <table id="sdTable">
                                <c:forEach var="sd" items="${malariaDto.listSds}" varStatus="status">
                                    <tr>
                                        <td>
                                            药物名称<input type="text" name="drugName" value="${sd.drugName}" style="width: 120px;text-align: center">，
                                            总量（<input type="text" name="totalNum" value="${sd.totalNum}" style="width: 45px;text-align: center">mg/片）
                                            <input type="text" name="trocheNum" value="${sd.trocheNum}" style="width: 45px;text-align: center">片，
                                            服法<input type="text" name="methodDetail" value="${sd.methodDetail}" style="width: 160px;text-align: center">
                                            &nbsp;<a href="javascript:void(0)" onclick="idmCommon.removeTr(this)">删除</a>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </table>
                        </td>
                    </tr>
                    </tbody>
                </table>
            </fieldset>
        </div>
        <div class="repeattable">
            <div style="font-weight: bold">访视情况：</div>
            <table id="frTable">
                <thead>
                    <tr>
                        <th class="centerth" style="width: 80px;" rowspan="2">访视日期</th>
                        <th class="centerth" style="width: 180px;" colspan="3">其中</th>
                        <th class="centerth" style="width: 160px;" colspan="2">检查</th>
                        <th class="centerth" style="width: 160px;" colspan="2">印象</th>
                        <th class="centerth" rowspan="2">处理意见</th>
                        <th class="centerth" style="width: 80px;" rowspan="2">责任人</th>
                        <th class="centerth" style="width: 80px;" rowspan="2">
                            <div class="toolbarsublist" style="text-align: center"><a href="javascript:visit.popupFr()"><b class="xinz">添加</b></a></div>
                        </th>
                    </tr>
                    <tr>
                        <th class="centerth" style="width: 60px;">发热天数</th>
                        <th class="centerth" style="width: 60px;">热型</th>
                        <th class="centerth" style="width: 60px;">体温℃</th>
                        <th class="centerth" style="width: 80px;">方法</th>
                        <th class="centerth" style="width: 80px;">结果</th>
                        <th class="centerth" style="width: 60px;">印象</th>
                        <th class="centerth" style="width: 80px;">其他</th>
                    </tr>
                </thead>
                <c:forEach var="fr" items="${malariaDto.listFr}" varStatus="status">
                    <tr>
                        <td field="visitDt"><ehr:tip><fmt:formatDate pattern="yyyy/MM/dd" value="${fr.visitDt}"/></ehr:tip></td>
                        <td field="feverDays"><ehr:tip>${fr.feverDays}</ehr:tip></td>
                        <td field="feverType"><ehr:tip>${fr.feverType}</ehr:tip></td>
                        <td field="temperature"><ehr:tip>${fr.temperature}</ehr:tip></td>
                        <td field="checkType"><ehr:tip>${fr.checkType}</ehr:tip></td>
                        <td field="checkResult"><ehr:tip>${fr.checkResult}</ehr:tip></td>
                        <td field="impressTypeStr"><ehr:tip>${fr.impressTypeStr}</ehr:tip></td>
                        <td field="impressOther"><ehr:tip>${fr.impressOther}</ehr:tip></td>
                        <td field="visitContent"><ehr:tip>${fr.visitContent}</ehr:tip></td>
                        <td field="checkUser"><ehr:tip>${fr.checkUser}</ehr:tip></td>
                        <td style="display: none" field="impressType">${fr.impressType}</td>
                        <td class="btnsublist" field="btn">
                            <a href="javascript:void(0)" onclick="visit.popupFr(this, 'edit')">修改</a>&nbsp;
                            <a href="javascript:void(0)" onclick="idmCommon.removeTr(this)">删除</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
        <div class="postdiv" style="margin-top: 10px;">
            <fieldset>
                <table class="posttable">
                    <colgroup>
                        <col style="width: 10%" />
                        <col style="width: 15%" />
                        <col style="width: 15%" />
                        <col style="width: 30%" />
                        <col style="width: 15%" />
                        <col style="width: 15%" />
                    </colgroup>
                    <tr>
                        <th>治疗医生：</th>
                        <td>
                            <%--<ehr:staff-list name="otherCondition.docotrName" orgCode="" value="${malariaDto.otherCondition.docotrName}" />--%>
                            <%--<input type="hidden" name="otherCondition.docotrName" value="${malariaDto.otherCondition.docotrName}">--%>
                            <ehr:user userCode="${malariaDto.otherCondition.docotrName}"/>
                            <input type="hidden" name="otherCondition.docotrName" value="${malariaDto.otherCondition.docotrName}">
                        </td>
                        <th>治疗单位：</th>
                        <td>
                            <ehr:org code="${malariaDto.otherCondition.cureUnit}"/>
                            <input type="hidden" name="otherCondition.cureUnit" value="${malariaDto.otherCondition.cureUnit}">
                            <%--<input type="text" name="otherCondition.cureUnit" value="${malariaDto.otherCondition.cureUnit}">--%>
                        </td>
                        <th>治疗日期：</th>
                        <td>
                            <tag:dateInput name="otherCondition.thisDt" pattern="yyyy/MM/dd" onlypast="true" nullToToday="true" date="${malariaDto.otherCondition.thisDt}"/>
                        </td>
                    </tr>
                </table>
            </fieldset>
        </div>
    </div>
</form>
