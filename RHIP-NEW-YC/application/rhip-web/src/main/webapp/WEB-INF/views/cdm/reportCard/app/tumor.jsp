<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%-- <c:set var="reportInfo" scope="request" value="${tumorReport}"></c:set> --%>
<%-- <c:set var="index" scope="request" value="3"></c:set> --%>
	<input type="hidden" name="report[${index}].id" value="${reportInfo.id}"> 
	<input type="hidden" name="report[${index}].personId" value="${reportInfo.personId}" >
	<input type="hidden" name="report[${index}].idCard" value="${reportInfo.idcard}">
	<input type="hidden" name="report[${index}].cdmId" value="${reportInfo.cdmId}" > 
	<input type="hidden" name="report[${index}].reportType" value="${reportInfo.reportType}" />
	<input type="hidden" name="report[${index}].dmPersonId" value="${reportInfo.dmPersonId}" />
	<%--报卡类型--%>
	<input type="hidden" name="report[${index}].disType" value="${reportInfo.disType}" />
<legend>肿瘤 <span style="color: #ff0000"><ehr:dic dicmeta="DMD00005" code="${reportInfo.cdmStatusInfo.reportStatus}"></ehr:dic>${reportInfo.reportType =='2' ? ' (死亡报卡)' :''}</span></legend>
<table class="posttable">
	<colgroup>
									<col style="width: 15%;min-width:100px;" />
									<col style="width: 35%;min-width:200px;" />
									<col style="width: 15%;min-width:100px;" />
									<col style="width: 35%;min-width:200px;" />
	</colgroup>
	<c:if test="${allowEdit}">
		<%--<th>是否继发</th>
		<td><input type="checkbox" value="1" name="isSecondary" ${reportInfo.isSecondary eq '1' ?'checked':''}/></td>--%>
		<tr>
            <%-- <th><label  class="required"  >ICD-10编码</label></th>
            <td><input type="text" id="tumorIcd10Code"  name="report[${index}].tumorIcdTenCode" value="${reportInfo.tumorIcdTenCode}" reg='{"required":true,"regex":"^C[0-9]{2}(\\.[a-zA-Z0-9]{1,3}([a-zA-Z0-9]|\\+)?)?$|^D[0-3][0-9](\\.[a-zA-Z0-9]{1,3}([a-zA-Z0-9]|\\+)?)?$|^D[4][0-8](\\.[a-zA-Z0-9]{1,3}([a-zA-Z0-9]|\\+)?)?$"}' tip="请输入正确的肿瘤icd10编码" /></td>
 --%>
            <th><label class="required" >肿瘤病名</label></th>
			<td><input type="text"  id="tumorIcd10Name"  name="report[${index}].tumorType" value="${reportInfo.tumorType}" reg="{'required':true,'maxlength':50}" /></td>
			</tr>
		<tr>
			<th><label class="required" >知情状态标志</label></th>
			<td ><ehr:dic-list width="180px" dicmeta="PH00001"  name="report[${index}].tumorInformedFlag" value="${reportInfo.tumorInformedFlag}" reg="{'required':true}" /></td>
		
<%-- 			<th><label class="required" >ICD-10名称</label></th> --%>
<%-- 			<td><input type="text"  name="report[${index}].tumorIcdTenName" value="${reportInfo.tumorIcdTenName}" reg="{'required':true,'maxlength':100}" /></td> --%>
			<th><label >原发部位</label></th>
			<td><input type="text"  name="report[${index}].tumorPrimaryPart" value="${reportInfo.tumorPrimaryPart}" reg="{'maxlength':33}" /></td>
		</tr>
		<tr>
			<th><label >转移部位</label></th>
			<td style="vertical-align:top;"><input type="text"  name="report[${index}].tumorMetastasisPart" value="${reportInfo.tumorMetastasisPart}" reg="{'maxlength':33}" /></td>
			<th><label >诊断依据</label></th>
			<td><ehr:dic-list type="true"  width="180px;"  dicmeta="DMD00010"  name="report[${index}].tumorDiagnosisDepends" value="${reportInfo.tumorDiagnosisDepends}"
				reg="{'maxlength':33}"
			/></td>
		</tr>
		<tr>
			<th><label >病理类型</label></th>
			<td><input type="text"  name="report[${index}].tumorPathologyType" value="${reportInfo.tumorPathologyType}" reg="{'maxlength':16}" /></td>
			<th><label >ICD-0-3编码</label></th>
			<td><input type="text"  name="report[${index}].tumorIcdThreeCode" value="${reportInfo.tumorIcdThreeCode}" reg="{'maxlength':8}" /></td>
		</tr>
		<tr>
			<th><label class="required" >发病日期</label></th>
			<td>
			<%-- <tag:dateInput onlypast="true" id="report${index}-tumorAccidentDate"  name="report[${index}].tumorAccidentDate" date="${reportInfo.tumorAccidentDate}" reg="{'required':true}" /> --%>
			<input type="text" class="layui-input x-admin-content-sm-date" reg="{'required':true}"  name="report[${index}].tumorAccidentDate" id="report${index}-tumorAccidentDate"  value="<fmt:formatDate value='${reportInfo.tumorAccidentDate}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;" />
			</td>
			<th><label class="required" >诊断日期</label></th>
			<td>
			<%-- <tag:dateInput  onlypast="true"  name="report[${index}].tumorDiagnosisDate" date="${reportInfo.tumorDiagnosisDate}" reg="{'required':true,'greaterThan':'report${index}-tumorAccidentDate'}"  /> --%>
			<input type="text" class="layui-input x-admin-content-sm-date" reg="{'required':true,'greaterThan':'report${index}-tumorAccidentDate'}"  name="report[${index}].tumorDiagnosisDate" id="reportCardAppTumorDiagnosisDateId" value="<fmt:formatDate value='${reportInfo.tumorDiagnosisDate}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;" />
			</td>
		</tr>

		<c:if test="">

		</c:if>
	</c:if>
	<c:if test="${false==allowEdit}">
		<%-- <th>是否继发</th>
		<td><input type="checkbox" value="1" name="isSecondary" ${reportInfo.isSecondary eq '1' ?'checked':''} disabled="true"/></td> --%>
		<tr>
            <%-- <th><label class="required">ICD-10编码</label></th>
            <td><input type="text"   value="${reportInfo.tumorIcdTenCode}" readonly="readonly" /></td>
 --%>
            <th><label class="required" >肿瘤病名</label></th>
				<td><input type="text"   value="${reportInfo.tumorType}" readonly="readonly"/></td>
			</tr>
			<tr>
<!-- 				<th><label class="required" >ICD-10名称</label></th> -->
<%-- 				<td><input type="text"   value="${reportInfo.tumorIcdTenName}" readonly="readonly"/></td> --%>
				<th><label >原发部位</label></th>
				<td><input type="text"   value="${reportInfo.tumorPrimaryPart}" readonly="readonly" /></td>
			</tr>
			<tr>
				<th><label >转移部位</label></th>
				<td style="vertical-align:top;"><input type="text"   value="${reportInfo.tumorMetastasisPart}" readonly="readonly" /></td>
				<th><label >诊断依据</label></th>
				<td><ehr:dic dicmeta="DMD00010" code="${reportInfo.tumorDiagnosisDepends}"/></td>
			</tr>
			<tr>
				<th><label >病理类型</label></th>
				<td><input type="text"  value="${reportInfo.tumorPathologyType}" readonly="readonly"/></td>
				<th><label >ICD-0-3编码</label></th>
				<td><input type="text"   value="${reportInfo.tumorIcdThreeCode}" readonly="readonly" /></td>
			</tr>
			<tr>
				<th><label class="required">发病日期</label></th>
				<td><input type="text" value='<fmt:formatDate value="${reportInfo.tumorAccidentDate}" pattern="yyyy/MM/dd" />' readonly="readonly" /></td>
				<th><label class="required" >诊断日期</label></th>
				<td><input type="text" value='<fmt:formatDate value="${reportInfo.tumorDiagnosisDate}" pattern="yyyy/MM/dd" />' readonly="readonly" /></td>
			</tr>
			<tr>
				<th><label class="required" >知情状态标志</label></th>
				<td colspan="3"><ehr:dic dicmeta="PH00001"  code="${reportInfo.tumorInformedFlag}" /></td>
			</tr>
	</c:if>
	<jsp:include page="inputInfo.jsp"></jsp:include>
	
</table>
<c:if test="${fn:length(reportInfo.secondaryReportInfos) > 0}">
	<fieldset>
		<legend>继发部位</legend>
		<table class="posttable">
			<colgroup>
				<col style="width: 15%;min-width:100px;" />
				<col style="width: 35%;min-width:200px;" />
				<col style="width: 15%;min-width:100px;" />
				<col style="width: 35%;min-width:200px;" />
			</colgroup>
			<c:forEach items="${reportInfo.secondaryReportInfos}" var="secondaryReportInfo">
				<tr>
					<th>是否继发源</th>
					<td>
						<c:choose>
							<c:when test="${secondaryReportInfo.id eq reportInfo.secondaryId}">
								是
							</c:when>
							<c:otherwise>否</c:otherwise>
						</c:choose>
					</td>
				</tr>
				<tr>
					<%-- <th>ICD-10编码</th>
					<td>${secondaryReportInfo.tumorIcdTenCode}</td>
					 --%><th>肿瘤病名</th>
					<td>${secondaryReportInfo.tumorType}</td>
				</tr>
				<tr>
					<th>发病日期</th>
					<td><fmt:formatDate value="${secondaryReportInfo.tumorAccidentDate}" pattern="yyyy/MM/dd"/> </td>
					<th>诊断日期</th>
					<td><fmt:formatDate value="${secondaryReportInfo.tumorDiagnosisDate}" pattern="yyyy/MM/dd"/></td>
				</tr>
			</c:forEach>
		</table>
	</fieldset>
</c:if>
<jsp:include page="death.jsp"></jsp:include>

<script type="text/javascript">

layui.use('laydate', function(){
    var laydate = layui.laydate;
    var tumorIndex = ${index};
    laydate.render({
        elem: '#report' + tumorIndex + "-tumorAccidentDate"
     	   ,format: 'yyyy/MM/dd'
     	   ,max:0
     	  	, trigger: 'click'
      });
    
    laydate.render({
      elem: '#reportCardAppTumorDiagnosisDateId' 
   	   ,format: 'yyyy/MM/dd'
   	   ,max:0
     	, trigger: 'click'
    });

  });
</script>