<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tag" %>
<%@ page import="com.founder.rhip.ehr.common.RoleType" %>
<%@ page import="com.founder.rhip.mhm.common.MhmStatus" %>
<c:if test="${loadResourcesMark eq 'add'}">
<jsp:include page="../../layouts/load-js-css-resources.jsp"></jsp:include>
</c:if>

<c:set var="ZJSB" value="<%=RoleType.ZJSB.getValue()%>"/>
<c:set var="ZXJFYS" value="<%=RoleType.ZXJFYS.getValue()%>"/>
<c:set var="JKJFZX" value="<%=RoleType.JKJFZX.getValue()%>"/>
<c:set var="SUBMIT" value="<%=MhmStatus.SUBMIT.getValue()%>"/>
<c:set var="VERIFY_SQZX" value="<%=MhmStatus.VERIFY_SQZX.getValue()%>"/>
<c:set var="VERIFY_DIAGNOSIS" value="<%=MhmStatus.VERIFY_DIAGNOSIS.getValue()%>"/>
<c:if test='${empty addType}'>
	<script src="${pageContext.request.contextPath}/js/views/mhm/mhmCommon.js" type="text/javascript"></script>
</c:if>
<script src="${pageContext.request.contextPath}/js/views/mhm/clue/clueEdit.js" type="text/javascript"></script>

<div style="min-width: 720px;">
<div class="toolbar" style="margin-top: 10px;">
<div class="x-nav">
      <span class="layui-breadcrumb">
        <a href="javascript:void(0)">精神障碍患者管理</a>
        <a href="javascript:void(0)">线索登记</a>
        <a>
          <cite>新增线索登记表</cite></a>
      </span>
    </div>
    
    
    
	<c:if test='${not empty addType}'>
    <!-- <a href="javascript:void(0)" onclick="clueEdit.returnSearch()"><b class="fanhui">返回</b></a> -->
    <a href="javascript:void(0)" onclick="clueEdit.returnSearch()"><button class="btn-gray layui-btn layui-btn-sm button"><i class="layui-icon">&#xe65c;</i>返回</button></a>
    </c:if>
    <%--此人注销也可以审核之类的，不能建立基本档案及规范化管理--%>
    <%--<c:if test="${logoff != 1}">--%>
        <c:if test='${clueDto.status == VERIFY_SQZX && ROLE == JKJFZX}'>
            <!-- <a href="javascript:void(0)" onclick="clueEdit.approval(2)"><b class="tongguo">诊断</b></a> -->
            <a href="javascript:void(0)" onclick="clueEdit.approval(2)"><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe679;</i>诊断</button></a>
        </c:if>
        <c:if test='${clueDto.status == VERIFY_DIAGNOSIS && ROLE == JKJFZX}'>
            <!-- <a href="javascript:void(0)" onclick="clueEdit.approval(3)"><b class="tongguo">复核</b></a> -->
            <a href="javascript:void(0)" onclick="clueEdit.approval(3)"><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe672;</i>复核</button></a>
        </c:if>
        <c:if test='${clueDto.status == SUBMIT && ROLE==ZXJFYS}'>
            <!-- <a href="javascript:void(0)" onclick="clueEdit.approval()"><b class="tongguo">通过</b></a> -->
            <a href="javascript:void(0)" onclick="clueEdit.approval()"><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe605;</i>通过</button></a>
            <!-- <a href="javascript:void(0)" onclick="clueEdit.approval(5)"><b class="zuofei">不通过</b></a> -->
            <a href="javascript:void(0)" onclick="clueEdit.approval(5)"><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#x1006;</i>不通过</button></a>
        </c:if>
        <c:if test="${(ROLE==ZJSB && addType != 'view' )||(empty addType && ROLE==ZXJFYS)}">
            <!-- <a href="javascript:void(0)" onclick="clueEdit.clueSubmit()"><b class="tijiao">提交</b></a> -->
            <a href="javascript:void(0)" onclick="clueEdit.clueSubmit()"><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe605;</i>提交</button></a>
        </c:if>
    <%--</c:if>--%>
 	<c:if test="${not empty addType}">
    	<%-- <a href="javascript:void(0)" onclick="clueEdit.popuApproval(${clueDto.statusId})"><b class="jilu">操作记录</b></a> --%>
    	<a href="javascript:void(0)" onclick="clueEdit.popuApproval(${clueDto.statusId})"><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe60e;</i>操作记录</button></a>
    </c:if> 
    <input type="hidden" id="pageIndex" value="${pageIndex}">
</div>
<br/>
<br/>
<form id="clueForm">
	<input type="hidden" name="statusId" value="${clueDto.statusId}"/>
	<input type="hidden" name="eventId" value="${clueDto.eventId}"/>
	<input type="hidden" id="clueStatus" name="status" value="${clueDto.status}"/>
	<input type="hidden" id="addType" name="addType" value="${addType}"/>
	<input type="hidden" id="logoffId" name="logoff" value="${clueDto.logoff}"/>
	<input type="hidden" id="birthdate" name="mhmBasicsInfo.birthdate" value="<fmt:formatDate value="${clueDto.mhmBasicsInfo.birthdate}" pattern="yyyy/MM/dd" />"/>
	<input type="hidden" id="familyPhone" name="mhmBasicsInfo.familyPhone" value="${clueDto.mhmBasicsInfo.familyPhone}"/>

    <input type="hidden" name="mhmBasicsInfo.patientResource" value="${clueDto.mhmBasicsInfo.patientResource}"/>
	<input type="hidden" name="mhmOtherInfo.bringIntoFlag" value="${clueDto.mhmOtherInfo.bringIntoFlag}"/>
    <input type="hidden" name="mhmOtherInfo.fillOrganCode" value="${clueDto.mhmOtherInfo.fillOrganCode}"/>
    <input type="hidden" name="mhmOtherInfo.fillDate" value="<fmt:formatDate value="${clueDto.mhmOtherInfo.fillDate}" pattern="yyyy/MM/dd" />"/>
    <input type="hidden" name="mhmOtherInfo.belongTownship" value="${clueDto.mhmOtherInfo.belongTownship}"/>
    <input type="hidden" name="mhmOtherInfo.belongCenter" value="${clueDto.mhmOtherInfo.belongCenter}"/>
    <input type="hidden" name="mhmOtherInfo.fillDoctorId" value="${clueDto.mhmOtherInfo.fillDoctorId}"/>
    
    <%--中心审批信息--%>
    <input type="hidden" name="mhmOtherInfo.modifyDoctorId" value="${clueDto.mhmOtherInfo.modifyDoctorId}"/>
    <input type="hidden" name="mhmOtherInfo.modifyDate" value="<fmt:formatDate value="${clueDto.mhmOtherInfo.modifyDate}" pattern="yyyy/MM/dd" />"/>
    <input type="hidden" name="mhmOtherInfo.modifyOrganCode" value="${clueDto.mhmOtherInfo.modifyOrganCode}"/>
    <%--精防中心诊断信息--%>
    <input type="hidden" name="mhmOtherInfo.diagnosisOrganCode" value="${clueDto.mhmOtherInfo.diagnosisOrganCode}"/>
    <input type="hidden" name="mhmOtherInfo.diagnosisDate" value="<fmt:formatDate value="${clueDto.mhmOtherInfo.diagnosisDate}" pattern="yyyy/MM/dd" />"/>
    <input type="hidden" name="mhmOtherInfo.diagnosisDoctorId" value="${clueDto.mhmOtherInfo.diagnosisDoctorId}"/>
    <%--精防中心复核信息--%>
    <input type="hidden" name="mhmOtherInfo.reOrganCode" value="${clueDto.mhmOtherInfo.reOrganCode}"/>
    <input type="hidden" name="mhmOtherInfo.reDate" value="<fmt:formatDate value="${clueDto.mhmOtherInfo.reDate}" pattern="yyyy/MM/dd" />"/>
    <input type="hidden" name="mhmOtherInfo.reDoctorId" value="${clueDto.mhmOtherInfo.reDoctorId}"/>
        
    <input type="hidden" name="mhmBasicsInfo.id" value="${clueDto.mhmBasicsInfo.id}"/>
    <input type="hidden" name="mhmSign.id" value="${clueDto.mhmSign.id}"/>
    <input type="hidden" name="mhmDiagnosis.id" value="${clueDto.mhmDiagnosis.id}"/>
    <input type="hidden" name="mhmOtherInfo.id" value="${clueDto.mhmOtherInfo.id}"/>
     <input type="hidden" id="idcardFlag" name="idcardFlag" value="1"/>                      
    <div class="postcontent contentfixed32" style="min-width: 700px;">
        <i class="popno">线索登记表</i>
        <div class="postdiv">
            <fieldset class="layui-elem-field">
                <table class="posttable">
                    <colgroup>
                        <col style="min-width: 80px; width: 15%;"/>
                        <col style="min-width: 150px; width: 35%;"/>
                        <col style="min-width: 80px; width: 15%;"/>
                        <col style="min-width: 150px; width: 35%;"/>
                    </colgroup>
                    <tbody>
                    <tr>
                        <th><label class="required">姓名</label></th>
                        <td><input type="text" id="clueName" name="mhmBasicsInfo.name" value="${clueDto.mhmBasicsInfo.name}"
                                   reg='{"maxlength":"50","required":"true"}' class="x-layui-input"/>
                        </td>
                        <th>身份证号</th>
                        <td><input type="text" id="idcard" name="mhmBasicsInfo.idcard" value="${clueDto.mhmBasicsInfo.idcard}"
                                   placeholder="输入身份证获取个人信息" reg='{"idCard":"true"}' class="x-layui-input"/>
                        </td>
                    </tr>
                    <tr>
                        <th><label class="required">性别</label></th>
                        <td><ehr:dic-radio  name="mhmBasicsInfo.gender" dicmeta="GBT226112003" value="${clueDto.mhmBasicsInfo.gender}"  reg='{"required":"true"}' code="1,2"/></td>
                        <th>年龄</th>
                        <td><input type="text" id="age" name="mhmBasicsInfo.age" value="${clueDto.mhmBasicsInfo.age}"
                        	reg='{"digits":"true","min":"0","max":"200"}' class="x-layui-input"/>岁
                        </td>
                    </tr>
                    <tr>
                        <th><label class="required">患者职业</label></th>
                        <td>
                            <ehr:dic-list id="Occupation" name="mhmBasicsInfo.occupation" dicmeta="GBT6565" value="${clueDto.mhmBasicsInfo.occupation}" reg='{"required":"true"}' width="200px"
                                          onchange="toggleOtherSC('mhmBasicsInfo.occupation','spanOccupationOther','CV020120299')"
                                          code="CV020120201,CV020120202,CV020120203,CV020120204,CV020120205,CV020120206,CV020120207,CV020120208,CV020120209,CV020120210,CV020120211,CV020120212,CV020120213,CV020120214,CV020120215,CV020120216,CV020120299,CV020120217"/>
                            <span id="spanOccupationOther">
                            	<input type="text" style="width: 150px;" name="mhmBasicsInfo.occupationOther" value="${clueDto.mhmBasicsInfo.occupationOther}" reg='{"maxlength":"100"}' />
                            </span>
                        </td>
                        <th>工作单位</th>
                        <td><input type="text" id="unitNameId" name="mhmBasicsInfo.unitName" value="${clueDto.mhmBasicsInfo.unitName}" reg='{"maxlength":"70"}'/>
                        </td>
                    </tr>
                    <tr>
                        <th><label class="required">病人属于</label></th>
                        <td colspan="3">
                        	<ehr:dic-radio name="mhmBasicsInfo.floatPopulation" dicmeta="CV0201104"
                                          value="${clueDto.mhmBasicsInfo.floatPopulation}"
                                          reg='{"required":"true"}' onchange="clueEdit.toggerAddress()"/>
                        </td>
                    </tr>
                    <tr>
                        <th><label class="required">现住址(详填)</label></th>
                        <td colspan="3">
                                <ehr:dic-town-street-village villageId="pavillage_address" streetId="pastreet_address" callback="clueEdit.displayPaAddress"
														 townId="patown_address" villageName="mhmBasicsInfo.paGroup" streetName="mhmBasicsInfo.pastreet"
														 townName="mhmBasicsInfo.patownShip" villageValue="${clueDto.mhmBasicsInfo.paGroup}" streetValue="${clueDto.mhmBasicsInfo.pastreet}"
														 townValue="${clueDto.mhmBasicsInfo.patownShip}" width="180px;" reg="{'required':true}"/>
							
                                
                                
                           <%--  <ehr:dic-town-street-village villageId="village_address" streetId="street_address"
												 townId="town_address" villageName="generalCondition.paGroup" streetName="generalCondition.pastreet"
												 townName="generalCondition.patownShip" villageValue="${clueDto.mhmBasicsInfo.paGroup}" streetValue="${clueDto.mhmBasicsInfo.titleTown}"
												 townValue="${clueDto.mhmBasicsInfo.patownShip}" reg='{"required":"true"}' width="180px;"/> --%>
                            <span id="br">
                                <%--<br/>--%>
                            </span>
                            <label id="tempPaValue">
								<ehr:dic code="${clueDto.mhmBasicsInfo.patownShip}" dicmeta="FS990001"/>
								<ehr:dic code="${clueDto.mhmBasicsInfo.pastreet}" dicmeta="FS990001"/>
								<ehr:dic code="${clueDto.mhmBasicsInfo.paGroup}" dicmeta="FS990001"/>
							</label>
                            <%-- <label id="tempPaValue">
                                <ehr:dic code="${clueDto.mhmBasicsInfo.patownShip}" dicmeta="FS990001"/><ehr:dic code="${clueDto.mhmBasicsInfo.pastreet}" dicmeta="FS990001"/>
                            </label> --%>
                            <input type="text" id="pahouseNumber" name="mhmBasicsInfo.pahouseNumber" value="${clueDto.mhmBasicsInfo.pahouseNumber}"
                                   reg='{"required":"true","maxlength":"50"}' style="width: 180px;"/>
                            <span id="spanPaNumber">(门牌号)</span>
                            
                        </td>
                    </tr>
                    <tr>
                        <th>户主姓名</th>
                        <td>
                        	<input type="text" name="mhmBasicsInfo.headHouseholdName" value="${clueDto.mhmBasicsInfo.headHouseholdName}"
                        	reg='{"maxlength":"50"}'/>
                        </td>
                        <th>与户主关系</th>
                        <td>
                        	<ehr:dic-list  name="mhmBasicsInfo.relation" dicmeta="MH00044" value="${clueDto.mhmBasicsInfo.relation}"   code="1,2,3,4,5,6"/>
                        </td>
                    </tr>
                    <tr>
                        <th><label class="required">监护人姓名</label></th>
                        <td>
                        	<input type="text" name="mhmBasicsInfo.parentsName" value="${clueDto.mhmBasicsInfo.parentsName}"
                        		reg='{"maxlength":"50" ,"required":"true"}' />
                        </td>
                        <th><label class="required">与监护人关系</label></th>
                        <td>
                        	<ehr:dic-list  name="mhmBasicsInfo.guarderRelationCode" dicmeta="MH00044" value="${clueDto.mhmBasicsInfo.guarderRelationCode}"   code="1,2,3,4,5,6" reg='{"required":"true"}' />
                        </td>
                    </tr>
                    <tr>
                        <th></th>
                        <td colspan="3">
                            符合“精神疾病线索调查问卷”第几条：&nbsp;&nbsp;&nbsp;&nbsp;<a href="javascript:void(0)" id="popuClues" onclick="javascript:clueEdit.showClues()">精神疾病线索调查问卷</a>
                            <br/>
                            <input type="hidden" id="expressionId" name="mhmSign.expression" value="${clueDto.mhmSign.expression}">
                            <label id="cluesDetail" >
                            	<c:if test="${fn:contains(clueDto.mhmSign.expression,'01')}">
                            		一、变得孤僻少语，不愿与别人接触。<br>
								</c:if>
                            	<c:if test="${fn:contains(clueDto.mhmSign.expression,'02')}">
                            		二、经常无目的乱走，出现一些别人无法理解的行为，甚至不知羞耻。<br>
								</c:if>
                            	<c:if test="${fn:contains(clueDto.mhmSign.expression,'03')}">
                            		三、无缘无故伤自己，或伤别人，或毁坏东西。<br>
								</c:if>
                            	<c:if test="${fn:contains(clueDto.mhmSign.expression,'04')}">
                            		四、动作非常缓慢，做什么事情都很慢，甚至整天躺在床上不动不说话。<br>
								</c:if>
                            	<c:if test="${fn:contains(clueDto.mhmSign.expression,'05')}">
                            		五、爱管闲事，整天忙碌不停，或乱花钱。<br>
								</c:if>
                            	<c:if test="${fn:contains(clueDto.mhmSign.expression,'06')}">
                            		六、毫无原因地大发脾气，什么都不顾忌。<br>
								</c:if>
                            	<c:if test="${fn:contains(clueDto.mhmSign.expression,'07')}">
                            		七、哭笑无常，或独自发笑，或出怪像做鬼脸。<br>
								</c:if>
                            	<c:if test="${fn:contains(clueDto.mhmSign.expression,'08')}">
                            		八、兴奋、话多，说个不停，或吹嘘自己脑袋特别聪明。<br>
								</c:if>
                            	<c:if test="${fn:contains(clueDto.mhmSign.expression,'09')}">
                            		九、情绪低沉，或常独自流泪，或厌世想死，或焦虑不安。<br>
								</c:if>
                            	<c:if test="${fn:contains(clueDto.mhmSign.expression,'10')}">
                            		十、话少、冷谈、对任何事都不关心，对家中亲人也毫无感情。<br>
								</c:if>
                            	<c:if test="${fn:contains(clueDto.mhmSign.expression,'11')}">
                            		十一、胡言乱语，或自言自语，或说些别人听不懂的话。<br>
								</c:if>
                            	<c:if test="${fn:contains(clueDto.mhmSign.expression,'12')}">
                            		十二、认为自己的脑子不受自己控制。<br>
								</c:if>
                            	<c:if test="${fn:contains(clueDto.mhmSign.expression,'13')}">
                            		十三、多疑，或没有根据地认为别人害他，控制他。<br>
								</c:if>
                            	<c:if test="${fn:contains(clueDto.mhmSign.expression,'14')}">
                            		十四、极不现实地吹嘘自己才智过人，权重位高。<br>
								</c:if>
                            	<c:if test="${fn:contains(clueDto.mhmSign.expression,'15')}">
                            		十五、乱说别人追求他，或怀疑爱人有姘头。<br>
								</c:if>
                            	<c:if test="${fn:contains(clueDto.mhmSign.expression,'16')}">
                            		十六、听到别人听不到的声音，或乱说有人在谈论他。<br>
								</c:if>
                            	<c:if test="${fn:contains(clueDto.mhmSign.expression,'17')}">
                            		十七、看到或闻道不存在的东西、气味，或尝到水里或饭里有怪味、毒药味等。<br>
								</c:if>
                            	<c:if test="${fn:contains(clueDto.mhmSign.expression,'18')}">
                            		十八、生活工作能力明显下降，或变得呆滞滞、傻乎乎的。<br>
								</c:if>
                            	<c:if test="${fn:contains(clueDto.mhmSign.expression,'19')}">
                            		十九、记忆力非常差，甚至记不住子女的年龄，或常忘记东西，或出门后找不到回家的路。<br>
								</c:if>
                            	<c:if test="${fn:contains(clueDto.mhmSign.expression,'20')}">
                            		二十、变得衣着不整或穿戴怪异，或不知饥饱，或不知清洁，甚至大小便也不知避人。<br>
								</c:if>
                            	<c:if test="${fn:contains(clueDto.mhmSign.expression,'21')}">
                            		二十一、有”羊癫疯“（癫痫），后来出现过精神不正常，如说糊涂话，躁动不安，行为反常，呆痴、凶狠任性等。<br>
								</c:if>
                            	<c:if test="${fn:contains(clueDto.mhmSign.expression,'22')}">
                            		二十二、吃药成瘾，或吸毒，或经常大量饮酒，不喝就受不了。<br>
								</c:if>
                            	<c:if test="${fn:contains(clueDto.mhmSign.expression,'23')}">
                            		二十三、脾气特别古怪，变得幼稚、自私，连亲人也不相信，或认为别人偷他东西，或胡乱说子女不给他吃穿。<br>
								</c:if>
                            	<c:if test="${fn:contains(clueDto.mhmSign.expression,'24')}">
                            		二十四、自幼呆傻，不能上学，不会自理生活，或虽能勉强读书，但又出现过行为反常，胡言乱语，吵闹毁物等。<br>
								</c:if>
                            </label>
                        </td>
                    </tr>
                    <tr>
                        <th>备注</th>
                        <td colspan="3">
                        	<textarea name="mhmSign.comments" style="width: 90%" rows=5  reg='{"maxlength":"200"}'>${clueDto.mhmSign.comments}</textarea>
                       	</td>
                    </tr>
                    </tbody>
                </table>
            </fieldset>
        </div>
								
        <c:if test='${(ROLE==JKJFZX) || (addType=="view")}'>
	        <div class="postdiv">
	            <fieldset class="layui-elem-field">
	                <table class="posttable">
	                    <colgroup>
	                        <col style="min-width: 80px; width: 15%;"/>
	                        <col style="min-width: 150px; width: 85%;"/>
	                    </colgroup>
	                    <tbody>
	                    	<c:if test='${clueDto.status == VERIFY_SQZX}'>
		                        <tr>
		                            <th><label class="required">确诊</label></th>
		                            <td>
		                            	<ehr:dic-radio  name="mhmDiagnosis.diagnosisResult" dicmeta="MH00002"
		                            		value="${clueDto.mhmDiagnosis.diagnosisResult}" reg='{"required":"true"}'
		                            		onchange="toggleOther('mhmDiagnosis.diagnosisResult','spanDiagnosisResult','2')"/>
		                            	<span id="spanDiagnosisResult" style="display:none">
		                            		<%--<input type="text" name="mhmDiagnosis.diagnosisContent" value="${clueDto.mhmDiagnosis.diagnosisContent}"--%>
		                            			<%--reg='{"required":"true","maxlength":"400"}' style="width: 200px;"/>--%>
                                            <%--<ehr:dic-list name="mhmDiagnosis.diagnosisContent" dicmeta="MH00052" value="${clueDto.mhmDiagnosis.diagnosisContent}"></ehr:dic-list>--%>
                                            <input type="text" id="mhmIcd10CodeId" name="mhmDiagnosis.diagnosisContent" value="${clueDto.mhmDiagnosis.diagnosisContent}"/>
		                            	</span>
		                            </td>
		                        </tr>
	                        </c:if>
	                        <c:if test='${clueDto.status >= VERIFY_DIAGNOSIS}'>
                                <c:if test='${addType!="view"}'>
                                <tr>
                                    <th>确诊</th>
                                    <td>
                                        上一步诊断结果:【 <ehr:dic dicmeta="MH00002" code="${clueDto.mhmDiagnosis.diagnosisResult}"/> 】
                                        &nbsp;&nbsp;
                                        <c:if test="${not empty clueDto.mhmDiagnosis.diagnosisContent}">
                                            详细描述：${clueDto.mhmDiagnosis.diagnosisContent}
                                        </c:if>
                                    </td>
                                </tr>
                                </c:if>
		                        <tr>
		                            <th><label class="required">复核诊断</label></th>
		                            <td>
		                            	<ehr:dic-radio  name="mhmDiagnosis.reCheck" dicmeta="MH00002" value="${clueDto.mhmDiagnosis.reCheck}" reg='{"required":"true"}'
		                            		onchange="toggleOther('mhmDiagnosis.reCheck','spanReCheck','2')"/>
		                            	<span id="spanReCheck" style="display:none">
		                            		<%--<input type="text" name="mhmDiagnosis.diagnosisContent" value="${clueDto.mhmDiagnosis.diagnosisContent}"--%>
		                            			<%--reg='{"required":"true","maxlength":"400"}' style="width: 200px;"/>--%>
                                            <%--<ehr:dic-list name="mhmDiagnosis.diagnosisContent" dicmeta="MH00052" value="${clueDto.mhmDiagnosis.diagnosisContent}"></ehr:dic-list>--%>
                                            <input type="text" id="mhmIcd10CodeId" name="mhmDiagnosis.diagnosisContent" value="${clueDto.mhmDiagnosis.diagnosisContent}"/>
		                            	</span>
		                            </td>
		                        </tr>
	                        </c:if>
	                    </tbody>
	                </table>
	            </fieldset>
	        </div>
        </c:if>
        <div style="height: 100px;"></div>
    </div>
</form>
</div>