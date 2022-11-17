<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<%@ page import="com.founder.rhip.idm.common.SchStatus" %>
<c:set var="CURE" value="<%=SchStatus.CURE.getValue()%>" />
<script src="${pageContext.request.contextPath}/js/views/idm/schistosome/cardEdit.js" type="text/javascript"></script>

<div class="toolbar">
	<!-- <a href="javascript:void(0)" onclick="javascript:cardEdit.returnSearch()"><b class="fanhui">返回</b></a> -->
	<a href="javascript:void(0)" id="manageCardReturn"><button class="btn-gray layui-btn layui-btn-sm button"><i class="layui-icon">&#xe65c;</i>返回</button></a>
	<c:if test="${schDto.specialStatus != CURE && '1'!=logoff}">
    	<!-- <a href="javascript:void(0)" onclick="javascript:cardEdit.cardSubmit()"><b class="baocun">保存</b></a> -->
    	<a href="javascript:void(0)" id="manageCardSave" ><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe605;</i>保存</button></a>
    </c:if>
</div>
<div class="divFixed125">
	<form id="cardForm">
		<input type="hidden" name="singleId" value="${schDto.singleId}">
		<input type="hidden" name="idmId" id="idmId" value="${schDto.idmId}">
		<input type="hidden" id="logoff" value="${logoff}"/>
		<input type="hidden" name="specialStatus" id="specialStatusId" value="${schDto.specialStatus}">
		<input type="hidden" name="generalCondition.id" value="${schDto.generalCondition.id}">
		<input type="hidden" name="otherCondition.id" value="${schDto.otherCondition.id}">
		<input type="hidden" name="caseInformation.id" value="${schDto.caseInformation.id}">
		<input type="hidden" name="diagnosis.id" value="${schDto.diagnosis.id}">
		<input type="hidden" name="listRrJson" id="listRrJsonId">
		<input type="hidden" name="listCrJson" id="listCrJsonId">
		<div class="postcontent">
			<i class="popno">江苏省晚期血吸虫病人信息管理卡</i>
			<fieldset class="layui-elem-field">
				<legend>一般情况</legend>
				<table class="posttable">
					<colgroup>
						<col style="min-width: 110px; width: 15%;"/>
						<col style="min-width: 260px; width: 35%;"/>
						<col style="min-width: 110px; width: 15%;"/>
						<col style="min-width: 260px; width: 35%;"/>
					</colgroup>
					<tbody>
					<tr>
						<th>姓名:</th>
						<td>
							<input type="text" id="name" name="generalCondition.name" value="${schDto.generalCondition.name}"
								   style="width: 100px;" reg='{"maxlength":"50"}'/>
						</td>
						<th>身份证号:</th>
						<td>
							<input type="text" id="idCard" name="generalCondition.idcard" value="${schDto.generalCondition.idcard}"
								   placeholder="输入身份证获取个人信息" reg='{"idCard":"true"}'/>
						</td>
					</tr>
					<tr>
						<th>性别:</th>
						<td colspan="3">
							<ehr:dic-radio name="generalCondition.gender" dicmeta="GBT226112003" value="${schDto.generalCondition.gender}"  code="1,2"/>
						</td>
					</tr>
					<tr>
						<th><label class="required">常住类型:</label></th>
						<td colspan="3">
							<ehr:dic-radio name="generalCondition.floatPopulation" dicmeta="FS10005" reg='{"required":"true"}'
										   value="${schDto.generalCondition.floatPopulation}" onchange="idmCommon.toggerAddress()"/>
						</td>
					</tr>
					<tr>
						<th class="required">地址：</th>
						<td colspan="3">
							<ehr:dic-town-village villageId="pavillage_address" townId="patown_address" villageName="generalCondition.pastreet" townName="generalCondition.patownShip"
												  villageValue="${schDto.generalCondition.pastreet}" townValue="${schDto.generalCondition.patownShip}" width="160px;" reg='{"required":"true"}'/>
							<div>
								<label id="tempPaValue">
									<ehr:dic code="${schDto.generalCondition.patownShip}" dicmeta="FS990001"/><ehr:dic code="${schDto.generalCondition.pastreet}" dicmeta="FS990001"/>
								</label>
								<input type="text" id="pahouseNumber" name="generalCondition.pahouseNumber" value="${schDto.generalCondition.pahouseNumber}"
									   reg='{"maxlength":"50","required":"true"}'  style="width: 180px;">
								<span id="spanPaNumber">(门牌号)</span>
							</div>
						</td>
					</tr>
					<tr>
						<th>邮编:</th>
						<td>
							<input type="text" name="generalCondition.postcode" value="${schDto.generalCondition.postcode}"
								   style="width: 100px;" reg='{"postCode":"true","maxlength":"10"}'/>
						</td>
						<th>电话:</th>
						<td>
							<input type="text" id="phoneNumber" name="generalCondition.phoneNumber" value="${schDto.generalCondition.phoneNumber}"
								   reg='{"phone":"true","maxlength":"20"}'/>
						</td>
					</tr>
					<tr>
						<th>晚血分型:</th>
						<td>
							<ehr:dic-list name="otherCondition.classifyAccording" dicmeta="CV0501025" width="120px;"
										  code="1,2,3,4" value="${schDto.otherCondition.classifyAccording}" />
						</td>
						<th>病情分类:</th>
						<td>
							<ehr:dic-list name="otherCondition.caseType" dicmeta="IDM00328" width="120px;"
										  code="1,2,3" value="${schDto.otherCondition.caseType}" />
						</td>
					</tr>
					<tr>
						<th>确诊时间:</th>
						<td>
							<%-- <tag:dateInput nullToToday="false" id="diagnosisDtId" name="diagnosis.diagnosisDt" style="width: 80px;"
                             pattern="yyyy/MM" date="${schDto.diagnosis.diagnosisDt}" onlypast="true"></tag:dateInput> --%>
							<input type="text" class="layui-input x-admin-content-sm-date"  name="diagnosis.diagnosisDt" id="diagnosisDtId" value="<fmt:formatDate value='${schDto.diagnosis.diagnosisDt}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;width: 80px;" />
						</td>
						<th>转归:</th>
						<td>
							<ehr:dic-list name="otherCondition.outcomeCode" dicmeta="IDM00005" width="120px;"
										  code="1,2,9,6" value="${schDto.otherCondition.outcomeCode}" />
						</td>
					</tr>
					<tr>
						<th>建卡单位:</th>
						<td>
							<ehr:org code="${schDto.caseInformation.surveyOrg}"/>
							<input type="hidden" name="caseInformation.surveyOrg" value="${schDto.caseInformation.surveyOrg}">
						</td>
						<th>建卡时间:</th>
						<td>
							<%-- <tag:dateInput nullToToday="false" id="diagnosisDtId" name="diagnosis.diagnosisDt" style="width: 80px;"
                                           pattern="yyyy/MM/dd" date="${schDto.diagnosis.diagnosisDt}" onlypast="true"></tag:dateInput> --%>
							<input type="text" class="layui-input x-admin-content-sm-date"  name="caseInformation.caseFillDate" id="caseFillDateId" value="<fmt:formatDate value='${schDto.caseInformation.caseFillDate}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;width: 80px;" />
						</td>
					</tr>
					</tbody>
				</table>
			</fieldset>
			<fieldset class="layui-elem-field">
				<legend>信息变更</legend>
				<c:if test="${schDto.specialStatus != CURE}">
					<div class="toolbarsublist">
						<a href="javascript:void(0)" id="addCr" class="layui-btn layui-btn-xs button" style="color: #FFF;font-size: 12px;" ><i class="layui-icon">&#xe608;</i>新增变更</a>
					</div>
				</c:if>
				<div id ="childDiv" class="repeattable">
					<table id="crTable" class="layui-table x-admin-sm-table-list-middle">
						<colgroup>
							<col style="min-width: 400px; width: 60%;"/>
							<col style="min-width: 80px; width: 10%;"/>
							<col style="min-width: 80px; width: 10%;"/>
							<col style="min-width: 100px; width: 15%;"/>
						</colgroup>
						<tbody>
						<tr>
							<th class="centerth">变更信息</th>
							<th class="centerth">变更时间</th>
							<th class="centerth">变更者</th>
							<th class="centerth">操作</th>
						</tr>
						<c:forEach var="cR" items="${schDto.listCrs}" varStatus="status">
							<tr>
								<td field="changeContent"><ehr:tip>${cR.changeContent}</ehr:tip></td>
								<td field="changeDt">
									<ehr:tip><fmt:formatDate value="${cR.changeDt}" pattern="yyyy/MM/dd"/></ehr:tip>
								</td>
								<td field="changeUser" style="display:none;">${cR.changeUser}</td>
								<td field="idmId" style="display:none;">${schDto.idmId}</td>
								<td field="changeUserStr"><ehr:tip>${cR.changeUser}</ehr:tip></td>
								<td class="centertd btnsublist" field="btn">
									<c:if test="${schDto.specialStatus != CURE}">
										<!-- <a href="javascript:void(0)" onclick='cardEdit.popupCr(this,"edit")'><i class="layui-icon"></i></a>
										<a href="javascript:void(0)" onclick="idmCommon.removeTr(this)" ><i class="layui-icon"></i></a> -->
										<a href="javascript:void(0)" class="layui-btn layui-btn-xs" style="color: #FFF;font-size: 12px;" onclick="cardEdit.popupRr(this,'edit')" title="修改"><i class="layui-icon">&#xe642;</i>修改</a>
										<a href="javascript:void(0)" class="layui-btn layui-btn-danger layui-btn-xs"  style="color: #FFF;font-size: 12px;" onclick="idmCommon.removeTr(this)" title="删除"><i class="layui-icon">&#xe640;</i>删除</a>
									</c:if>
								</td>
							</tr>
						</c:forEach>
						</tbody>
					</table>
				</div>
			</fieldset>
			<fieldset class="layui-elem-field">
				<legend>享受治疗救助</legend>
				<c:if test="${schDto.specialStatus != CURE}">
					<div class="toolbarsublist">
						<a href="javascript:void(0)" id="addRr" class="layui-btn layui-btn-xs button" style="color: #FFF;font-size: 12px;" ><i class="layui-icon">&#xe608;</i>新增治疗救助</a>
					</div>
				</c:if>
				<div id ="childDiv" class="repeattable">
					<table id="rrTable" class="layui-table x-admin-sm-table-list-middle">
						<colgroup>
							<col style="min-width: 120px; width: 20%;"/>
							<col style="min-width: 150px; width: 25%;"/>
							<col style="min-width: 120px; width: 20%;"/>
							<col style="min-width: 120px; width: 20%;"/>
							<col style="min-width: 100px; width: 15%;"/>
						</colgroup>
						<tbody>
						<tr>
							<th class="centerth">时间</th>
							<th class="centerth">类型</th>
							<th class="centerth">金额</th>
							<th class="centerth">转归</th>
							<th class="centerth">操作</th>
						</tr>
						<c:forEach var="rR" items="${schDto.listRrs}" varStatus="status">
							<tr>
								<td field=treatmentDt><ehr:tip><fmt:formatDate value="${rR.treatmentDt}" pattern="yyyy/MM/dd"/></ehr:tip></td>
								<td field="treatmentType"><ehr:tip>${rR.treatmentType}</ehr:tip></td>
								<td field="treatmentMoney" >${rR.treatmentMoney}</td>
								<td field="lapsetoStr"><ehr:tip><ehr:dic dicmeta="IDM00005" code="${rR.lapseto}"/></ehr:tip></td>
								<td field="idmId" style="display:none;">${schDto.idmId}</td>
								<td field="lapseto" style="display:none;">${rR.lapseto}</td>
								<td class="centertd 	btnsublist" field="btn">
									<c:if test="${schDto.specialStatus != CURE}">
										<!-- <a href="javascript:void(0)" onclick="cardEdit.popupRr(this,'edit')" title="修改"><i class="layui-icon">&#xe642;</i></a>&nbsp;&nbsp; -->
										<!-- <a href="javascript:void(0)" onclick="idmCommon.removeTr(this)" title="删除"><i class="layui-icon"></i></a> -->
										<a href="javascript:void(0)" class="layui-btn layui-btn-xs"  style="color: #FFF;font-size: 12px;" onclick="cardEdit.popupRr(this,'edit')" title="修改"><i class="layui-icon">&#xe642;</i>修改</a>
										<a href="javascript:void(0)" class="layui-btn layui-btn-danger layui-btn-xs"  style="color: #FFF;font-size: 12px;" onclick="idmCommon.removeTr(this)" title="删除"><i class="layui-icon">&#xe640;</i>删除</a>
									</c:if>
								</td>
							</tr>
						</c:forEach>
						</tbody>
					</table>
				</div>
			</fieldset>
		</div>
	</form>
</div>


<script type="text/javascript">

layui.use('laydate', function(){
    var laydate = layui.laydate;
    
    laydate.render({
      elem: '#diagnosisDtId' 
   	   ,format: 'yyyy/MM/dd'
   	   ,max:0
   	, trigger: 'click' 
    });

    laydate.render({
        elem: '#caseFillDateId' 
     	   ,format: 'yyyy/MM/dd'
     	   ,max:0
     	, trigger: 'click' 
      });
    
    
  });
</script>