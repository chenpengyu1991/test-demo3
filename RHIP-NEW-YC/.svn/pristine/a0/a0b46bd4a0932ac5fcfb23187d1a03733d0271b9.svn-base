<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
	<%-- <c:set var="reportInfo" scope="request" value="${coronaryReport}"></c:set> --%>
	<%-- <c:set var="index" scope="request" value="1"></c:set> --%>
		<input type="hidden" name="report[${index}].id" value="${reportInfo.id}"> 
	<input type="hidden" name="report[${index}].personId" value="${reportInfo.personId}" >
	<input type="hidden" name="report[${index}].idCard" value="${reportInfo.idcard}">
	<input type="hidden" name="report[${index}].cdmId" value="${reportInfo.cdmId}" > 
	<input type="hidden" name="report[${index}].reportType" value="${reportInfo.reportType}" /> 
	<input type="hidden" name="report[${index}].dmPersonId" value="${reportInfo.dmPersonId}" />
	<%--报卡类型--%>
	<input type="hidden" name="report[${index}].disType" value="${reportInfo.disType}" />
	<legend>冠心病 <span style="color: #ff0000"><ehr:dic dicmeta="DMD00005" code="${reportInfo.cdmStatusInfo.reportStatus}"></ehr:dic>${reportInfo.reportType =='2' ? ' (死亡报卡)' :''}</span></legend>
	<table class="posttable">
		<colgroup>
									<col style="width: 15%;min-width:100px;" />
									<col style="width: 35%;min-width:200px;" />
									<col style="width: 15%;min-width:100px;" />
									<col style="width: 35%;min-width:200px;" />

		</colgroup>
		<c:if test="${allowEdit}">
			<tr>
				<th><label class="required">冠心病类型</label></th>
				<td><ehr:dic-list width="180px;" dicmeta="DMD00008" name="report[${index}].coronaryType" value="${reportInfo.coronaryType}"
						reg="{'required':true}"
					/></td>
				<th><label class="required">发病日期</label></th>
				<td>
				<%-- <tag:dateInput onlypast="true" id="report${index}-coronaryAccidentDate" name="report[${index}].coronaryAccidentDate" date="${reportInfo.coronaryAccidentDate}"
						reg="{'required':true}"
					/> --%>
					<input type="text" class="layui-input x-admin-content-sm-date" reg="{'required':true}"  name="report[${index}].coronaryAccidentDate" id="report${index}-coronaryAccidentDate"  value="<fmt:formatDate value='${reportInfo.coronaryAccidentDate}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;" />
					</td>
			</tr>
			<tr>
				<th><label class="required">诊断日期</label></th>
				<td style="vertical-align:top;">
				<%-- <tag:dateInput onlypast="true" name="report[${index}].coronaryDiagnosisDate" date="${reportInfo.coronaryDiagnosisDate}"
						 reg="{'required':true,'greaterThan':'report${index}-coronaryAccidentDate'}" 
					/> --%>
					<input type="text" class="layui-input x-admin-content-sm-date" reg="{'required':true,'greaterThan':'report${index}-coronaryAccidentDate'}"   name="report[${index}].coronaryDiagnosisDate" id="reportCardAppCoronaryDiagnosisDateId" value="<fmt:formatDate value='${reportInfo.coronaryDiagnosisDate}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;" />
					</td>
				<th><label>诊断依据</label></th>
				<td><ehr:dic-list width="180px;" type="true" dicmeta="DMD00010" name="report[${index}].coronaryDiagnosisDepends"
						value="${reportInfo.coronaryDiagnosisDepends}" reg="{'required':true}"
					/></td>
			</tr>
			<%-- <tr>
				<th>ICD-10编码</th>
				<td><input type="text" name="report[${index}].coronaryIcdTenCode" value="${reportInfo.coronaryIcdTenCode}" readonly="readonly"/></td>
			</tr> --%>
		</c:if>
		<c:if test="${false==allowEdit}">
			<tr>
				<th><label >冠心病类型</label></th>
				<td><ehr:dic   dicmeta="DMD00008" code="${reportInfo.coronaryType}" /></td>
				<th><label >发病日期</label></th>
				<td><input type="text" value='<fmt:formatDate value="${reportInfo.coronaryAccidentDate}" pattern="yyyy/MM/dd" />' readonly="readonly" /></td>
			</tr>
			<tr>
				<th> <label>诊断日期</label></th>
				<td style="vertical-align:top;" ><input type="text" value='<fmt:formatDate value="${reportInfo.coronaryDiagnosisDate}" pattern="yyyy/MM/dd" />' readonly="readonly" /></td>
				<th><label >诊断依据</label></th>
				<td><ehr:dic dicmeta="DMD00010" code="${reportInfo.coronaryDiagnosisDepends}"  /></td>
			</tr>
			<%-- <tr>
				<th>ICD-10编码</th>
				<td>${reportInfo.coronaryIcdTenCode}</td>
			</tr> --%>
		</c:if>
		<jsp:include page="inputInfo.jsp"></jsp:include>
	
	</table>
	<jsp:include page="death.jsp"></jsp:include>

		<script type="text/javascript">

layui.use('laydate', function(){
    var laydate = layui.laydate;
    var coronaryIndex = ${index};
    laydate.render({
        elem: '#report' + coronaryIndex + "-coronaryAccidentDate"
     	   ,format: 'yyyy/MM/dd'
     	   ,max:0
     	  	, trigger: 'click'
      });
    
    laydate.render({
      elem: '#reportCardAppCoronaryDiagnosisDateId' 
   	   ,format: 'yyyy/MM/dd'
   	   ,max:0
     	, trigger: 'click'
    });

  });
</script>