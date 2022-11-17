<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib  tagdir="/WEB-INF/tags" prefix="tag"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<script src="${pageContext.request.contextPath}/js/views/idm/idmCommon.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/idm/case/frts.js" type="text/javascript"></script>
<script type="text/javascript"> 
	$(function(){
        enableChangeConfirm();
    });
</script>

<div class="toolbar toolbarfixed0">
    <a href="javascript:void(0)" onclick="javascript:frSearch.returnSearch()"><b class="fanhui">返回</b></a>
    <c:if test="${'1' != logoff}">
        <a href="javascript:void(0)" onclick="javascript:frts.initAdd()" id="xinzeng" style="display: none"><b class="xinz">新增</b></a>
        <%--<a href="javascript:void(0)" onclick="javascript:frts.saveFr('edit')" id="xiugai" style="display: none"><b class="xiug">修改</b></a>--%>
        <a href="javascript:void(0)" onclick="javascript:frts.saveFr('edit')" id="xiugai" style="display: none"><b class="baocun">保存</b></a>
        <a href="javascript:void(0)" onclick="javascript:frts.saveFr('add')" id="baocun" ><b class="baocun">保存</b></a>
        <a href="javascript:void(0)" onclick="javascript:frts.deleteFr()" id="shanchu" style="display: none"><b class="zuofei">删除</b></a>
    </c:if>
</div>
<div class="postcontent contentfixed">
    <form id="frForm">
    <div class="postdiv" id="subDetailDiv">
        <fieldset style="margin-top: 10px">
            <legend>病人基本信息</legend>
                <table class="posttable">
                    <colgroup>
                        <col style="min-width: 50px; width: 15%;"/>
                        <col style="min-width: 80px; width: 35%;"/>
                        <col style="min-width: 50px; width: 15%;"/>
                        <col style="min-width: 80px; width: 35%;"/>
                    </colgroup>
                    <tr>
                    	<input type="hidden" id="infectiousCode" name="infectiousCode" value="${infectiousCode}">
                        <input type="hidden" id="singleIdFr" name="idmId" value="${singleId}">
                        <input type="hidden" name="id" id="subId" value="${listFr.id}">
                        <input type="hidden" name="listFrJson" id="listFrJson">
                        <th><label class="required">姓名：</label></th>
                        <td><input type="text" name="name" value="${listFr.name}" reg='{"maxlength":"50","required":"true"}'/></td>
                        <th>性别：</th>
                        <td><ehr:dic-radio dicmeta="GBT226112003" name="gender" value="${listFr.gender}"/></td>
                    </tr>
                    <tr>
                        <th><label class="required">年龄：</label></th>
                        <td><input type="text" name="age" value="${listFr.age}" reg='{"maxlength":"20","required":"true"}'/></td>
                        <th>家长姓名：</th>
                        <td><input type="text" name="parentsName" value="${listFr.parentsName}" reg='{"maxlength":"50"}'/></td>
                    </tr>
                    <tr>
                        <th>现住址：</th>
                        <td colspan="3">
                            <ehr:dic-town-village villageName="pastreet" townName="patownShip" villageValue="${listFr.pastreet}" townValue="${listFr.patownShip}" width="180px;"/>
                            <input type="text" name="pahouseNumber" value="${listFr.pahouseNumber}" reg='{"maxlength":"50"}' style="width: 180px;"/>
                        </td>
                    </tr>
                    <tr>
                        <th>联系电话：</th>
                        <td><input type="text" name="phoneNumber" value="${listFr.phoneNumber}" reg='{"regex":"phone"}'/></td>
                        <th>发病日期：</th>
                        <td><tag:dateInput name="attackDt" date="${listFr.attackDt}" onlypast="true"></tag:dateInput>
                    </tr>
                    <tr>
                        <th>就诊日期：</th>
                        <td><tag:dateInput name="treatmentDt" date="${listFr.treatmentDt}" onlypast="true"></tag:dateInput></td>
                        <th>初次就诊医院：</th>
                        <td><input type="text" name="treatmentUnit" value="${listFr.treatmentUnit}"/></td>
                    </tr>
                    <tr>
                        <th>是否住院：</th>
                        <td><ehr:dic-radio name="inHospital" dicmeta="PH00001" value="${listFr.inHospital}" code="1,2"></ehr:dic-radio></td>
                    </tr>
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

        </fieldset>
    </div>
    <div id="frListTable" class="repeattable" >
        <div class="toolbarsublist">
            随访情况：<a href="javascript:void(0)" id="addEfcList" onclick="frSearch.popupFr()" ><b class="xinz">添加</b></a>
        </div>
        <table style="width: 100%" id="frTable">
            <colgroup>
                <col style="width:80px;"/>
                <col style="width:65px;"/>
                <col style="width:65px;"/>
                <col style="width:80px;"/>
                <col style="width:80px;"/>
                <col/>
                <col/>
                <col style="width:80px;"/>
            </colgroup>
        <thead>
            <tr>
                <th rowspan="2" class="centerth">随访日期</th>
                <th rowspan="1" colspan="3" class="centerth">临床表现</th>
                <th rowspan="2" class="centerth">病情进展</th>
                <th rowspan="2" class="centerth">病情加重后转诊医疗机构</th>
                <th rowspan="2" class="centerth">备注<br>（填写病情加重的症状和体征）</th>
                <th rowspan="2" class="centerth">操作</th>
            </tr>
            <tr>
                <th  class="centerth">体温（℃）</th>
                <th class="centerth">皮疹</th>
                <th class="centerth">其他症状体征</th>
            </tr>
        </thead>
        <tbody>
        <c:forEach var="fr" items="${frList}" varStatus="status">
            <tr>
                <td field="visitDt"><ehr:tip><fmt:formatDate value="${fr.visitDt}" pattern="yyyy/MM/dd"/></ehr:tip></td>
                <td field="temperature"><ehr:tip>${fr.temperature}</ehr:tip></td>
                <td field="rashStr"><ehr:tip><ehr:dic dicmeta="IDM00377" code="${fr.rash}"></ehr:dic></ehr:tip></td>
                <td field="otherSymptom"><ehr:tip>${fr.otherSymptom}</ehr:tip></td>
                <td field="diseaseProgressStr"><ehr:tip><ehr:dic dicmeta="IDM00378" code="${fr.diseaseProgress}"></ehr:dic></ehr:tip></td>
                <td field="transferUnit"><ehr:tip>${fr.transferUnit}</ehr:tip></td>
                <td field="comments"><ehr:tip>${fr.comments}</ehr:tip></td>
                <td field="rash" style="display: none">${fr.rash}</td>
                <td field="diseaseProgress" style="display: none">${fr.diseaseProgress}</td>
                <td class="btnsublist" field="btn">
                    <a href="javascript:void(0)" onclick="frSearch.popupFr(this, 'edit')">修改</a>&nbsp;
                    <a href="javascript:void(0)" onclick="idmCommon.removeTr(this)">删除</a>
                </td>
            </td></td>
            </tr>
        </c:forEach>
        </tbody>
        </table>
        <%--<table>--%>
            <%--<tr>--%>
                <%--<ehr:pagination action="frts.searchFrList"/>--%>
            <%--</tr>--%>
        <%--</table>--%>
    </div>
    </form>
</div>
