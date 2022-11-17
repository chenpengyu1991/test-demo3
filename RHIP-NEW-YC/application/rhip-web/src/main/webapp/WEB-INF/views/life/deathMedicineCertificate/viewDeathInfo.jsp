<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/views/ehrbrowser/basic/basic.css" />
<script src="${pageContext.request.contextPath}/js/views/life/search.js" type="text/javascript"></script>
<div class="postcontent">
	<!-- <div class="toolbar">
	  <a href="javascript:void(0)" id="back"><b class="fanhui">返回</b></a>
	</div> -->

	<ul>
		<li style="text-align: center; font-size: 25px;">死亡医学证明</li>
	</ul>
	<br/>
	
<form id="reportForm">
<fieldset class="postcontent">	
	<legend>基本信息</legend>
	<input type="hidden" id="dis-person-id" name="personInfo.id" value="${personInfo.id}">
	<table class="posttable">
		<colgroup>
			<col style="width: 20%;min-width:100px;" />
			<col style="width: 30%;min-width:200px;" />
			<col style="width: 15%;min-width:100px;" />
			<col style="width: 35%;min-width:200px;" />
		</colgroup>
		<tr>
				<th width="15%">姓名</th>
				<td>${personInfo.name}</td>
				<th width="15%">健康档案号</th>
				<td>${personInfo.healthFileNo}</td>
				
			</tr>
			<tr>
				<th width="15%">出生日期</th>
				<td><fmt:formatDate value="${personInfo.birthday}" pattern="yyyy/MM/dd"/></td>
				<th width="15%">地址</th>
				<td>
					<ehr:dic dicmeta="FS990001" code="${personInfo.patownShip}"></ehr:dic>
					<ehr:dic dicmeta="FS990001" code="${personInfo.pastreet}"></ehr:dic>
					<c:out value="${personInfo.pahouseNumber}"></c:out>
				</td>
			</tr>
	</table>
</fieldset>
<fieldset class="postcontent">	
	<legend>一般信息</legend>
	<table class="posttable">
		<colgroup>
			<col style="width: 20%;min-width:100px;" />
			<col style="width: 30%;min-width:200px;" />
			<col style="width: 15%;min-width:100px;" />
			<col style="width: 35%;min-width:200px;" />
		</colgroup>
			<tr>
				<th width="15%">建档人</th>
				<td>${personInfo.inputName}</td>
				<th width="15%">建档日期</th>
				<td><fmt:formatDate value="${personInfo.inputDate}" pattern="yyyy/MM/dd"/></td>
			</tr>
			 <tr>
				<th width="15%">死亡时间</th>
				<td><fmt:formatDate value="${personInfo.deathDate}" pattern="yyyy/MM/dd"/></td>
				<th><label  id="placeType">死亡地点</label></th>
				<td style="text-align:left;"><ehr:dic  code="${personInfo.place}" dicmeta="CV0201103"></ehr:dic></td>
			</tr>
			<tr>
				<th><label>死亡原因</label></th>
				<td>${personInfo.deathReason}</td>
				<th><label>死亡类别</label></th>
				<td style="text-align:left;"><ehr:dic code="${personInfo.deathPlaceType}" dicmeta="CV0201103"></ehr:dic></td>
			</tr>
	</table>
</fieldset>

<fieldset  class="postcontent">	
	<legend>死亡登记信息</legend>
	<table class="posttable">
		<colgroup>
			<col style="width: 20%;min-width:100px;" />
			<col style="width: 30%;min-width:200px;" />
			<col style="width: 15%;min-width:100px;" />
			<col style="width: 35%;min-width:200px;" />
		</colgroup>
			<tr>
				<th>编号</th>
				<td>${personInfo.deathCertificateNo}</td>
			</tr>
			<tr>
				<th width="15%">性别</th>
				<td> <ehr:dic dicmeta="GBT226112003" code="${personInfo.gender}" ></ehr:dic></td>
			</tr>
		
			<tr>
				<th>民族</th>
				<td><ehr:dic code="${personInfo.nation}" dicmeta="GBT3304"></ehr:dic ></td>
				<th>职业工种</th>
				<td><ehr:dic code="${personInfo.occupation}" dicmeta="GBT6565"></ehr:dic ></td>
			</tr>
			<tr>
			    <th>身份证号</th>
				<td>${personInfo.idcard}</td>
				<th>户籍</th>
				<td><ehr:dic dicmeta="FS10005"  code="${personInfo.householdType}" /></td>
			</tr>
			
			<tr>
				<th>生前工作单位</th>
				<td>${personInfo.unitName}</td>
			</tr>
			<tr>
				<th width="15%">婚姻</th>
				<td><ehr:dic code="${personInfo.marriage}" dicmeta="GBT226122003"></ehr:dic > </td>
				<th width="15%">文化程度</th>
				<td><ehr:dic code="${personInfo.education}" dicmeta="GBT46582006"></ehr:dic ></td>
			</tr>
		 	<tr>
				<th width="15%">实足年龄</th>
				<td>${personInfo.age}</td>
				</tr>
			<tr >
			<th width="15%">家属姓名</th>
				<td>${personInfo.guardian}</td>
				<th width="15%">住址或工作单位</th>
				<td >${personInfo.guardianUnitName}</td>
			</tr>
			<tr>
				<th width="15%" rowspan="5">致死的主要疾病诊断</th>
				<td colspan="3">（请填写具体的病名，勿填症状体征）</td>
			</tr>
			<tr>
				<td colspan="3">（a）直接导致死亡的疾病或情况：${personInfo.directCondition}</td>
			</tr>
			<tr>
				<td colspan="3">（b）引起（a）的疾病或情况：${conditionA}</td>
			</tr>
			<tr>
				<td colspan="3">（c）引起（b）的疾病或情况：${personInfo.conditionB}</td>
			</tr>
			<tr>
				<td colspan="3">其他疾病诊断（促进死亡，但与导致死亡无关的其他重要情况）：${personInfo.conditionC}</td>
			</tr>
			<tr>
			
			</tr>
			<tr>
				<th width="15%">发病至死亡大概时间间隔</th>
				<td >${personInfo.intervalRuntime}</td>
			</tr>
			<tr>
				<th width="15%">死者生前上述疾病的最高诊断单位</th>
				<td colspan="3"><ehr:dic  dicmeta="CV0810004" code="${personInfo.deathHighOrganLevel}"></ehr:dic></td>
			</tr>
			<tr>
				<th width="15%">死者生前上述疾病的最高诊断依据</th>
				<td ><ehr:dic dicmeta="CV0501037" code="${personInfo.deathHighEvidenceTypeCode}"/></td>
			</tr>
			<tr>
				<th width="15%">住院号</th>
				<td >${personInfo.admissionNo}</td>
				<th width="15%">医师姓名</th>
				<td>${personInfo.doctorName}</td>
			</tr>
				<tr>
				<th width="15%">单位名称</th>
				<td >${personInfo.deathHospitalName}</td>
				<th width="15%">填报日期</th>
				<td><fmt:formatDate value="${personInfo.fillTime}" pattern="yyyy/MM/dd"/></td>
			</tr>
			<tr>
				
				
				<th>编码</th>
				<td>${personInfo.reportNo}</td>
				
			</tr>
			<tr>
				<th width="15%">分类号</th>
				<td><ehr:dic dicmeta="MH00020" code="${personInfo.categoryNo}"/></td>
			</tr>
			<tr>
				
				<th>调查记录生前疾病史及症状体征</th>
				<td colspan="3">${personInfo.diseaseHistory}</td>
				
			</tr>
			<tr>
				<th width="15%">被调查者姓名</th>
				<td>${personInfo.contactName}</td>
				<th width="15%">与死者关系</th>
				<td>${personInfo.relation}</td>
			</tr>
			<tr>
				<th width="15%">联系地址或者工作单位</th>
				<td>${personInfo.contactUnitName} </td>
				<th width="15%">死因推断</th>
				<td>${personInfo.deathReasonDeduction}</td>
			</tr>
			<tr>
				<th width="15%">调查者姓名</th>
				<td>${personInfo.fillUserName}</td>
				<th width="15%">调查日期</th>
				<td><fmt:formatDate value="${personInfo.surveyTime}" pattern="yyyy/MM/dd"/></td>
			</tr>
			<tr>
				<th width="15%">备注</th>
				<td colspan="3">${personInfo.remarks}</td>
			</tr>
	</table>
</fieldset>
</form> 
</div>

</div>  


