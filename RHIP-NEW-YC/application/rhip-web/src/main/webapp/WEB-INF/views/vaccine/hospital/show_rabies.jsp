<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/ehr-tag" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page import="com.founder.rhip.ehr.common.RoleType" %>
<c:set var="JKYFJZ" value="<%=RoleType.JKYFJZ.getValue()%>"/>
<c:set var="ZXYFJZ" value="<%=RoleType.ZXYFJZ.getValue()%>"/>
<c:set var="YYFJZ" value="<%=RoleType.YYFJZ.getValue()%>"/>

<script src="${pageContext.request.contextPath}/js/views/vaccine/hospital/contine_vaccine.js" type="text/javascript"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery/jquery.jqprint.js"></script>
<script type="text/javascript">
	$("#print").click(function() {
	    $("#printRa").jqprint();
	    mainPageH.search(1);
	    return;
	});
</script>
<%--<div class="toolbar">--%>
    <%--<a href="javascript:void(0)" id="print"><b class="">打印</b></a>--%>
<%--</div>--%>
<input type="hidden" id="ehrId" value="${ehrId}"/>
<%--本次事件的性质。0或者1或者5表示重新接种，其他表示加强接种。 --%>
<input type="hidden" id="vaccineTypeFlag" value="${vaccinationEvent.flag}"/>
<input type="hidden" id="personId" value="${vaccinationMgmt.personId}"/>
<%--标识是何种注射 1：表示狂犬疫苗 --%>
<input type="hidden" id="vaccineType" value="1"/>
<!-- 患者基本情况 -->
<div class="postcontent" id="printRa">
	<div style="text-align: center; font-size: 16px; font-weight: bold;">
		永城市狂犬病暴露预防处置登记表
	</div>

	<div class="postdiv">
	<fieldset class="layui-elem-field">
		<legend>患者基本情况</legend>
		<table style="width:99%;" class="posttable">
            <colgroup >
                <col width="15%" />
                <col width="15%" />
                <col width="15%" />
                <col width="15%" />
                <col width="20%" />
                <col width="20%" />
            <colgroup>
			<tbody>
				<%-- <tr>
                    <th>身份证号：</th>
                    <td>${vaccinationMgmt.idCard}</td>
					<th>姓名：</th>
					<td>${vaccinationMgmt.name}</td>
                </tr>
                <tr>
					<th>性别：</th>
					<td><ehr:dic dicmeta="GBT226112003" code="${vaccinationMgmt.gender}"/></td>
					<th>年龄：</th>
					<td>${vaccinationMgmt.age} &nbsp;岁</td>
				</tr> --%>
				
				<tr>
                    <th style="text-align: right;">姓名：</th>
                    <td>${vaccinationMgmt.name}</td>
                    <th style="text-align: right;">身份证号码：</th>
                    <td>${vaccinationMgmt.idCard}</td>
                    <th style="text-align: right;">性别：</th>
                    <td><ehr:dic dicmeta="GBT226112003" code="${vaccinationMgmt.gender}"/></td>
                </tr>
                 <tr>
                	<th style="text-align: right;">监护人姓名：</th>
                    <td>${vaccinationMgmt.guardianNameText}</td>
                    <th style="text-align: right;">监护人联系电话：</th>
                    <td>${vaccinationMgmt.guardianPhoneText}</td>
                    <th style="text-align: right;">年龄：</th>
                    <td>${vaccinationMgmt.age}&nbsp;岁</td>
                </tr>
                <tr>
                    <th style="text-align: right;">体重：</th>
                    <td>${vaccinationMgmt.weight}&nbsp;公斤</td>
                    <th style="text-align: right;">联系电话：</th>
                    <td>${vaccinationMgmt.phoneNumber}</td>
                    <th style="text-align: right;">职业：</th>
                    <td><ehr:dic dicmeta="GBT6565" code="${vaccinationMgmt.occupation}" /></td>
                </tr>
                <tr>
                    <th style="text-align: right;">地址：</th>
                    <td><ehr:dic dicmeta="FS990001" code="${vaccinationMgmt.patownShip}" /><ehr:dic dicmeta="FS990001" code="${vaccinationMgmt.pastreet}" />${vaccinationMgmt.pahouseNumber}</td>
                    <th style="text-align: right;">就诊日期：</th>
                    <td><fmt:formatDate value="${traumaHistory.treatmentTime}" pattern='yyyy/MM/dd HH'/>时</td>
                </tr>
				
			</tbody>
		</table>
	</fieldset>
	</div>
	
	<div class="postdiv">
	<fieldset class="layui-elem-field">
	<legend>狂犬疫苗接种史</legend>
		<table style="width:99%;" class="posttable">
            <colgroup >
                <col width="15%" />
                <col width="15%" />
                <col width="15%" />
                <col width="15%" />
                <col width="20%" />
                <col width="20%" />
            <colgroup>
			<tbody>
				<tr>
                    <th style="text-align: right;">伤人日期：</th>
                    <td><fmt:formatDate value="${traumaHistory.opsDate}" pattern='yyyy/MM/dd HH'/>时</td>
                    <th style="text-align: right;" >以前是否接种过人狂犬疫苗：</th>
                    <td	>
                        <ehr:dic dicmeta="PH00001" code="${vaccinationEvent.isInjected==null?2:vaccinationEvent.isInjected}"></ehr:dic>
                    </td>
                    <th style="text-align: right;">最近一次接种日期：</th>
                    <td>
                        <fmt:formatDate value="${vaccinationEvent.lastInjectedDate}" pattern='yyyy/MM/dd'/>
                    </td>
                </tr>
             	<tr>
                   	<th style="text-align: right;">全程接种是否完成：</th>
                    <td>
                        <c:if test="${vacciantionFlag eq 1}">是</c:if>
                        <c:if test="${vacciantionFlag ne 1}">否</c:if>
                    </td>
                    <th style="text-align: right;">一年内是否全程接种过：</th>
                    <td>
                        <c:if test="${vaccinationEvent.isOneYearInjected eq 1}">是</c:if>
                        <c:if test="${vaccinationEvent.isOneYearInjected ne 1}">否</c:if>
                    </td>
                    <th style="text-align: right;">一年前三年内是否全程接种过：</th>
           			<td>
                   		<c:if test="${vaccinationEvent.isThreeYearInjected eq 1}">是</c:if>
                   		<c:if test="${vaccinationEvent.isThreeYearInjected ne 1}">否</c:if>
                	</td>
             	</tr>
           	 	<tr>
           			<th style="text-align: right;">三年内是否加强接种过：</th>
            		<td>
                   		<c:if test="${vaccinationEvent.isPowerInjected eq 1}">是</c:if>
                   		<c:if test="${vaccinationEvent.isPowerInjected ne 1}">否</c:if>
                	</td>
                	<th style="text-align: right;">全程接种最后一剂接种时间：</th>
             		<td>
                		<fmt:formatDate value="${vaccinationEvent.lastFullInjectedDate}" pattern='yyyy/MM/dd'/>
                	</td>
                	<th style="text-align: right;">加强接种最后一剂接种时间：</th>
                	<td>
                		<fmt:formatDate value="${vaccinationEvent.lastPowerInjectedDate}" pattern='yyyy/MM/dd'/>
                	</td>
            	</tr>
			</tbody>
		</table>
		
		
		
		
		
		
	</fieldset>
	</div>
	
	
	
	<div class="postdiv">
	<fieldset class="layui-elem-field">
	<legend>暴露（被伤）情况</legend>
		<table style="width:99%;" class="posttable">
            <colgroup >
                <col width="15%" />
                <col width="15%" />
                <col width="15%" />
                <col width="15%" />
                <col width="20%" />
                <col width="20%" />
            <colgroup>
			<tbody>
				 <tr>
                 	<th style="text-align: right;">伤人动物：</th>
                    <td>${traumaHistory.hurtType}</td>
                	<th style="text-align: right;">动物来源：</th>
                    <td>${traumaHistory.hurtSource}</td>
                    <th style="text-align: right;">动物状态：</th>
                    <td>${traumaHistory.hurtStatus}</td>
                </tr>
                <tr>
                	<th style="text-align: right;">伤口部位：</th>
                    <td><ehr:dic dicmeta="FS990002" code="${traumaHistory.opsName}" /></td>
                	<th style="text-align: right;">暴露方式：</th>
                    <td>${traumaHistory.exposeType}</td>
                    <th style="text-align: right;">被伤性质：</th>
                    <td>${traumaHistory.hurtNature}</td>
                </tr>
			</tbody>
		</table>
		
		
		
		
		
		
	</fieldset>
	</div>
	
	<div class="repeattable">
			<table class="layui-table x-admin-sm-table-list-middle">
				<thead>
					<tr>
                        <th style="width: 10%;text-align: center;">分级</th>
                        <th style="width: 50%;text-align: center;">接触方式</th>
                        <th style="width: 10%;text-align: center;">暴露程度</th>
                        <th style="width: 30%;text-align: center;">医师建议</th>
					</tr>
				</thead>
				<tbody>
                    <c:if test="${traumaHistory.biteLevel eq '1'}" >
					<tr>
						<td>
							<b style="font-size: 16px;">√</b>&nbsp;&nbsp;I级
						</td>
						<td>符合以下情况之一者：<br/>1、接触或喂养动物；<br/>2、完好的皮肤被舔。</td>
						<td>无</td>
						<td>
							1、确认接触方式可靠则不需处置。<br/>
							2、暴露前免疫。
						</td>
					</tr>
                    </c:if>
                    <c:if test="${traumaHistory.biteLevel eq '2'}" >
					<tr>
						<td><b style="font-size: 16px;">√</b>&nbsp;&nbsp;II级
						</td>
						<td>符合以下情况之一者：<br/>1、裸露的皮肤被轻咬；<br/>2、无出血的轻微抓伤或擦伤。</td>
						<td>轻度</td>
						<td>1、处理伤口；<br/>2、接种人狂犬病疫苗。</td>
					</tr>
                    </c:if>
                    <c:if test="${traumaHistory.biteLevel eq '3'}" >
					<tr>
						<td>
							<b style="font-size: 16px;">√</b>&nbsp;&nbsp;III级</td>
						<td>符合以下情况之一者：<br/>1、单处或多处贯穿性皮肤咬伤或抓伤；<br/>2、破损皮肤被舔；<br/>3、开放性伤口或粘膜被污染。</td>
						<td>重度</td>
						<td>1、处理伤口；<br/>2、接种人狂犬病疫苗。<br/>3、注射狂犬病人免疫球蛋白。	</td>
					</tr>
                    </c:if>
				</tbody>
			</table>
		</div>
	<div class="repeattable" style="font-size: 14px;">
            伤口处理情况：
            <table class="layui-table x-admin-sm-table-list-middle">
                <colgroup >
                	<col width="10%" />
                	<col width="40%" />
                	<col width="30%" />
                	<col width="20%" />
           		<colgroup>
           		<thead>
					<tr><th>医疗机构</th>
                        <th>冲洗</th>
                        <th>消毒</th>
                        <th>其他处理</th>
					</tr>
				</thead>
                <tbody>
                <tr>
                        <td>本门诊</td>
                        <td>冲洗方式：${traumaHistory.flushMethod} 冲洗时长：${traumaHistory.flushTime}</td>
                        <td>消毒剂：${traumaHistory.disInfectant} </td>
                        <td>其他处理：${traumaHistory.otherHandle} </td>
                     
                </tr>
                 <tr>
                        <td>其他</td>
                       	<td>冲洗方式：${traumaHistory.otherFlushMethod} 冲洗时长：${traumaHistory.otherFlushTime}</td>
                        <td>消毒剂：${traumaHistory.otherDisInfectant} </td>
                        <td>其他处理：${traumaHistory.otherHandles} </td>
                </tr>
                </tbody>
            </table>
        </div>
    <div id="vaccineRabiesDivId">
		<jsp:include page="vaccine_rabies.jsp"/>
	</div>    
    <!-- 备注 -->
    <div id="continueRabies">
        <div class="postdiv">
            <fieldset class="layui-elem-field">
                <legend>备注</legend>
                <textarea class="vacnte" readonly="readonly" rows="5" cols="40">${vaccinationEvent.comments}</textarea>
            </fieldset>
        </div>
        <%--<ehr:authorize ifAnyGranted="06,17,31,33,34,35">--%>
        <c:if test="${operate == 2}">
            <ehr:authorize ifAnyGranted="${JKYFJZ},${ZXYFJZ},${YYFJZ}">
                <div style="text-align: center;">
                    <c:if test="${continueInject}">
                        <!-- <input id="injectVaccineBtn" class="btn" type="button" value="登记疫苗接种"/> -->
                        <button class="layui-btn layui-btn-sm"  id="injectVaccineBtn">登记疫苗接种</button>
                    </c:if>
                    <c:if test="${continueGray}">
                        <!-- 免疫球蛋白护士不能接种医生可以接种 -->

                        <!-- <input id="injectGrayBtn" class="btn" type="button" value="登记免疫蛋白接种"/> -->
                        <button class="layui-btn layui-btn-sm"  id="injectGrayBtn">登记免疫蛋白接种</button>
                    </c:if>
                </div>
            </ehr:authorize>
        </c:if>
    </div>
</div>
