<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<div class="dm-followup-from-content">
<form id="dm-followup-tumor-first-from" class="dm-followup-from">
	<input type="hidden" name="id" value="${tumor.id}" /> <input type="hidden" name="followupFlag" value="${tumor.followupFlag}" />
	<div class="postcontent">
		<div class="postdiv">
			<fieldset>
				<legend>肿瘤首次随访</legend>
				<table class="posttable">
					<colgroup>
						<col style="min-width: 100px; width: 30%" />
						<col style="min-width: 150px; width: 70%" />
					</colgroup>
					<tr>
						<th><label class="required" for="visitDate">随访日期</label></th>
						<td><tag:dateInput style="width:178px;" onlypast="true" id="visitDate" name="visitDate" date="${tumor.visitDate}" reg="{'required':true,'compare':['definitionNextDate','le','随访日期不能大于下次随访日期']}" /></td>
					</tr>
					<tr>
						<th><label class="required"  for="visitWayCode">随访方式</label></th>
						<td><ehr:dic-radio dicmeta="DMD00026" value="${tumor.visitWayCode}" reg="{'required':true}"  name="visitWayCode" ></ehr:dic-radio></td>
					</tr>
					<tr>
						<th><label>治疗情况</label></th>
						<td><ehr:dic-radio dicmeta="DMD00048" name="cure" value="${tumor.cure}"></ehr:dic-radio></td>
					</tr>
					<tr id="tumor-cure" ${tumor.cure !='1'?'style="display:none"':'' }>
						<th><label class="required" >治疗项目</label></th>
						<td><ehr:dic-checkbox reg="{'required':true}" dicmeta="DMD00047" name="cureProject" value="${tumor.cureProject}"></ehr:dic-checkbox></td>
					</tr>
					<tr>
						<th><label for="opsHospital">手术医院</label></th>
						<td><input name="opsHospital" type="text" value="${tumor.opsHospital }" reg="{'maxlength':70}" /></td>
					</tr>
					<tr>
						<th><label for="radiotherapyHospital">放疗医院</label></th>
						<td><input name="radiotherapyHospital" type="text" value="${tumor.radiotherapyHospital }"  reg="{'maxlength':70}"/></td>
					</tr>
					<tr>
						<th><label for="chemotherapyHospital">化疗医院</label></th>
						<td><input name="chemotherapyHospital" type="text" value="${tumor.chemotherapyHospital }"  reg="{'maxlength':70}"/></td>
					</tr>
					<tr>
						<th><label for="metastasis">转移情况</label></th>
						<td><ehr:dic-radio dicmeta="FS10238" name="metastasis" value="${tumor.metastasis }"></ehr:dic-radio><span style="display:${tumor.metastasis !='2'?'none':'inline' }" id="metastasisPart">转移部位:
						<input name="metastasisPart" type="text" value="${tumor.metastasisPart }" reg="{'required':true,'maxlength':100,'dependOn':'metastasis','dependValue':'2'}" style="width: 268px;" /></span></td>
					</tr>
					<tr>
						<th><label for="theriomaHistoryFlag">肿瘤家族史</label></th>
						<td>
							<ehr:dic-radio dicmeta="FS10238" name="theriomaHistoryFlag" value="${tumor.theriomaHistoryFlag }"></ehr:dic-radio>
							<span style="display:${tumor.theriomaHistoryFlag !='2'?'none':'inline' }" id="theriomaHistoryDetail">关系称谓,病名：
								<input style="width: 229px;" type="text" name="theriomaHistoryDetail" value="${tumor.theriomaHistoryDetail }" reg="{'required':true,'maxlength':100,'dependOn':'theriomaHistoryFlag','dependValue':'2'}"/>
							</span>
						</td>
					</tr>
					<tr>
						<th><label  for="currentStatusFlag">目前情况</label></th>
						<td><ehr:dic-radio dicmeta="DMD00049" name="currentStatusFlag" value="${tumor.currentStatusFlag}" /></td>
					</tr>
					<tr>
						<th><label  for="guidanceContent">指导内容</label></th>
						<td><ehr:dic-checkbox dicmeta="DMD00050" name="guidanceContent" value="${tumor.guidanceContent }"/></td>
					</tr>
					<tr>
						<th><label  class="required" for="crtesianValue">卡氏评分</label></th>
						<td colspan="3"><select style="width: 60px;" name="crtesianValue" reg="{'required':true}">
								<option ${tumor.crtesianValue eq 100 ?"selected='true'":""} value="100">100</option>
								<option ${tumor.crtesianValue eq 90 ?"selected='true'":""} value="90">90</option>
								<option ${tumor.crtesianValue eq 80 ?"selected='true'":""} value="80">80</option>
								<option ${tumor.crtesianValue eq 70 ?"selected='true'":""} value="70">70</option>
								<option ${tumor.crtesianValue eq 60 ?"selected='true'":""} value="60">60</option>
								<option ${tumor.crtesianValue eq 50 ?"selected='true'":""} value="50">50</option>
								<option ${tumor.crtesianValue eq 40 ?"selected='true'":""} value="40">40</option>
								<option ${tumor.crtesianValue eq 30 ?"selected='true'":""} value="30">30</option>
								<option ${tumor.crtesianValue eq 20 ?"selected='true'":""} value="20">20</option>
								<option ${tumor.crtesianValue eq 10 ?"selected='true'":""} value="10">10</option>
								<option ${tumor.crtesianValue eq 0 ?"selected='true'":""} value="0">0</option>
						</select></td>
					</tr>
					<tr>
						<th><label class="required" for="definitionNextDate">下次随访日期</label></th>
						<td><tag:dateInput style="width:178px;" onlyfuture="true" id="nextVisitDate" name="nextVisitDate" date="${tumor.nextVisitDate}" reg="{'required':true,'compare':['visitDate','ge','下次随访日期不能小于随访日期']}" />
					</tr>
				</table>
				<c:set var="input" value="${tumor}" scope="request"></c:set>
			</fieldset>
			<jsp:include page="../common/inputInfo.jsp"></jsp:include>
		</div>
	</div>
</form>
</div>