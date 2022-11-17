<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<script src="${pageContext.request.contextPath}/js/views/idm/malaria/epidemicFocus.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/idm/idmCommon.js" type="text/javascript"></script>
<div class="toolbar">
    <div class="toolbar" style="background: none">
        <a href="javascript:standardSearch.returnSearch()" id="cancelContact"><b class="fanhui">返回</b></a>
        <c:if test="${logoff != '1'}">
        	<a href="javascript:epidemicFocus.submitEpidemicFocus()"><b class="baocun">保存</b></a>
        </c:if>
    </div>
</div>
<form id="epidemicFocusForm">
    <input type="hidden" id="pageIndex" name="pageIndex" value="${pageIndex}">
    <input type="hidden" name="singleId" value="${malariaDto.singleId}"/>
    <input type="hidden" name="idmId" value="${malariaDto.idmId}"/>
    <input type="hidden" id="type" name="type" value="${type}"/>
    <input type="hidden" id="logoff" value="${logoff}"/>    
    <input type="hidden" id="listEddJson" name="listEddJson"/>
    <div class="postcontent">
        <i class="popno">市疟疾病疫点处理监测记录 </i>
        <div class="postdiv">
            <fieldset>
                <legend>一般情况</legend>
                <table class="posttable">
                    <colgroup>
                        <col style="width: 27%" />
                        <col style="width: 23%" />
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
                        <th><label class="required">身份证号：</label></th>
                        <td>
                            <input type="text" name="generalCondition.idcard" value="${malariaDto.generalCondition.idcard}"
                                   reg='{"required":"true","idCard":"idCard"}'/>
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
	                                   reg='{"required":"true","maxlength":"50"}'  style="width: 150px;">
	                            <span id="spanPaNumber">(门牌号)</span>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <th><label class="required">疫点名称（自然村、街、巷、院落）：</label></th>
                        <td colspan="3">
                            <input type="hidden" name="epidemicFocusClose.id" value="${malariaDto.epidemicFocusClose.id}">
                            <input type="text"  name="epidemicFocusClose.farmName" value="${malariaDto.epidemicFocusClose.farmName}" reg='{"required":"true","maxlength":"100"}'/>
                        </td>
                    </tr>
                    <tr>
                        <th><label class="required">疫点范围：</label></th>
                        <td colspan="3">
                            <input type="text" name="epidemicFocusClose.farmRange" value="${malariaDto.epidemicFocusClose.farmRange}"
                                   reg='{"required":"true","maxlength":"20"}'>
                            <br><label class="required" style="padding-right: 15px;">面积</label>
                            <input type="text" name="epidemicFocusClose.farmArea" value="${malariaDto.epidemicFocusClose.farmArea}"
                                   reg='{"required":"true","maxlength":"20"}' style="width: 80px;text-align: center">
                            <label class="required" style="padding-right: 15px;">户数</label>
                            <input type="text" name="epidemicFocusClose.rangeFamily" value="${malariaDto.epidemicFocusClose.rangeFamily}"
                                   reg='{"required":"true","maxlength":"20"}' style="width: 80px;text-align: center">
                            <br><label class="required" style="padding-right: 15px;">人口数</label>
                            <input type="text" name="epidemicFocusClose.farmPeopleNum" value="${malariaDto.epidemicFocusClose.farmPeopleNum}"
                                   reg='{"required":"true","maxlength":"20"}' style="width: 80px;text-align: center">
                            <label class="required" style="padding-right: 15px;">其中外来暂住人口数</label>
                            <input type="text" name="epidemicFocusClose.farmForeignNum" value="${malariaDto.epidemicFocusClose.farmForeignNum}"
                                   reg='{"required":"true","maxlength":"20"}' style="width: 80px;text-align: center">
                        </td>
                    </tr>
                    <tr>
                        <th>处理情况：</th>
                        <td colspan="3">
                            1. 预防服药：日期<tag:dateInput name="epidemicFocusClose.farmMedTime" date="${malariaDto.epidemicFocusClose.farmMedTime}" onlypast="true" style="width:90px;"/>
                            药物和方法<input type="text" name="epidemicFocusClose.drugName" value="${malariaDto.epidemicFocusClose.drugName}" style="width:200px; text-align: center" reg='{"maxlength":"100"}'>
                            服药人数<input type="text" name="epidemicFocusClose.farmMedNum" value="${malariaDto.epidemicFocusClose.farmMedNum}" style="width:80px;text-align: center" reg='{"maxlength":"20"}'>
                            <br>2. 药物灭蚊：日期<tag:dateInput name="epidemicFocusClose.mosquitoDt" date="${malariaDto.epidemicFocusClose.mosquitoDt}" onlypast="true" style="width:90px;"/>
                            药物和方法<input type="text" name="epidemicFocusClose.mosquitoDrugName" value="${malariaDto.epidemicFocusClose.mosquitoDrugName}" style="width:200px;text-align: center" reg='{"maxlength":"100"}'>
                            灭蚊范围<input type="text" name="epidemicFocusClose.mosquitoRange" value="${malariaDto.epidemicFocusClose.mosquitoRange}" style="width:100px;text-align: center" reg='{"maxlength":"100"}'>
                            <br>3. 健康教育：日期<tag:dateInput name="epidemicFocusClose.heDt" date="${malariaDto.epidemicFocusClose.heDt}" onlypast="true" style="width:90px;"/>
                            内容和方法<input type="text" name="epidemicFocusClose.heContent" value="${malariaDto.epidemicFocusClose.heContent}" style="width:200px;text-align: center" reg='{"maxlength":"100"}'>
                            受教育人数<input type="text" name="epidemicFocusClose.heNum" value="${malariaDto.epidemicFocusClose.heNum}" style="width:80px;text-align: center" reg='{"maxlength":"20"}'>
                        </td>
                    </tr>
                    </tbody>
                </table>
            </fieldset>
        </div>
        <div class="repeattable">
            监测结果：
            <table id="eddTable">
                <thead>
                    <tr>
                        <th class="centerth" style="width: 80px;" rowspan="2">日期</th>
                        <th class="centerth" style="width: 40px;" rowspan="2">发热<br>人数</th>
                        <th class="centerth" style="width: 110px;" colspan="2">其中</th>
                        <%--<th class="centerth" style="width: 50px;">外来人口</th>--%>
                        <th class="centerth" style="width: 40px;" rowspan="2">发疟<br>人数</th>
                        <th class="centerth" style="width: 110px;" colspan="2">其中</th>
                        <%--<th class="centerth" style="width: 50px;">外来人口</th>--%>
                        <th class="centerth" style="width: 80px;" colspan="2">血检</th>
                        <%--<th class="centerth" style="width: 40px;">阳性</th>--%>
                        <th class="centerth" style="width: 135px;" colspan="3">IFAT</th>
                        <%--<th class="centerth" style="width: 40px;">阳性</th>--%>
                        <%--<th class="centerth" style="width: 50px;">>=1:80</th>--%>
                        <th class="centerth" rowspan="2">处理情况</th>
                        <th class="centerth" style="width: 80px;" rowspan="2">监测人</th>
                        <th class="centerth" style="width: 70px;" rowspan="2">
                            <div class="toolbarsublist" style="text-align: center"><a href="javascript:epidemicFocus.popupEdd()" id="addEfcList" ><b class="xinz">添加</b></a></div>
                        </th>
                    </tr>
                    <tr>
                        <th class="centerth" style="width: 55px;">本地居民</th>
                        <th class="centerth" style="width: 55px;">外来人口</th>
                        <th class="centerth" style="width: 55px;">本地居民</th>
                        <th class="centerth" style="width: 55px;">外来人口</th>
                        <th class="centerth" style="width: 40px;">人数</th>
                        <th class="centerth" style="width: 40px;">阳性</th>
                        <th class="centerth" style="width: 40px;">人数</th>
                        <th class="centerth" style="width: 40px;">阳性</th>
                        <th class="centerth" style="width: 55px;">>=1:80</th>
                    </tr>
                </thead>
                <c:forEach var="edd" items="${malariaDto.listEdd}" varStatus="status">
                    <tr>
                        <td field="checkDt"><ehr:tip><fmt:formatDate pattern="yyyy/MM/dd" value="${edd.checkDt}"/></ehr:tip></td>
                        <td field="feverNum"><ehr:tip>${edd.feverNum}</ehr:tip></td>
                        <td field="feverLocal"><ehr:tip>${edd.feverLocal}</ehr:tip></td>
                        <td field="feverForeign"><ehr:tip>${edd.feverForeign}</ehr:tip></td>
                        <td field="agueNum"><ehr:tip>${edd.agueNum}</ehr:tip></td>
                        <td field="agueLocal"><ehr:tip>${edd.agueLocal}</ehr:tip></td>
                        <td field="agueForeign"><ehr:tip>${edd.agueForeign}</ehr:tip></td>
                        <td field="bloodNum"><ehr:tip>${edd.bloodNum}</ehr:tip></td>
                        <td field="bloodPositiveNum"><ehr:tip>${edd.bloodPositiveNum}</ehr:tip></td>
                        <td field="ifatNum"><ehr:tip>${edd.ifatNum}</ehr:tip></td>
                        <td field="ifatPositiveNum"><ehr:tip>${edd.ifatPositiveNum}</ehr:tip></td>
                        <td field="ifatProportionNum"><ehr:tip>${edd.ifatProportionNum}</ehr:tip></td>
                        <td field="disposeCondition"><ehr:tip>${edd.disposeCondition}</ehr:tip></td>
                        <td field="checkUser">${edd.checkUser}</td>
                        <td class="btnsublist" field="btn">
                            <a href="javascript:void(0)" onclick="epidemicFocus.popupEdd(this, 'edit')">修改</a>&nbsp;
                            <a href="javascript:void(0)" onclick="idmCommon.removeTr(this)">删除</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</form>
