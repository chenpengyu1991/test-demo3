<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>

<div>
	<ul>
		<li style="text-align: center; font-size: 25px;">产前筛查与诊断</li>
	</ul>
	<br/>
	<div class="table-basic-narrow">
		<table>
			<colgroup>
				<col style="width: 20%;"/>
	            <col style="width: 30%;"/>
				<col style="width: 20%;"/>
	            <col style="width: 30%;"/>
			</colgroup>
			<tr>
				<th>姓名</th>
				<td>${prenatalScreenDiagnosis.name}</td>
				<th>出生日期</th>
				<td><fmt:formatDate value="${prenatalScreenDiagnosis.birthday}" pattern="yyyy/MM/dd"/></td>
			</tr>
			<tr>
				<th>身份证件号码</th>
				<td>${prenatalScreenDiagnosis.idCard}</td>
				<th>体重(kg)</th>
				<td>${prenatalScreenDiagnosis.bodyWeight}</td>
			</tr>
			<tr>
				<th>收缩压(mmHg)</th>
				<td>${prenatalScreenDiagnosis.sbp}</td>
				<th>舒张压(mmHg)</th>
				<td>${prenatalScreenDiagnosis.dbp}</td>
			</tr>
			<tr>
				<th>妊娠结局</th>
				<td>${prenatalScreenDiagnosis.pregnancyOutcome}</td>
				<th>检查(测)日期</th>
				<td><fmt:formatDate value="${prenatalScreenDiagnosis.checkDate}" pattern="yyyy/MM/dd"/></td>
			</tr>
			<tr>
				<th>产前筛查孕周</th>
				<td>${prenatalScreenDiagnosis.screeningPreWeek}</td>
				<th>产前筛查项目</th>
				<td>${prenatalScreenDiagnosis.screeningItem}</td>
			</tr>
			<tr>
				<th>产前筛查方法代码</th>
				<td>${prenatalScreenDiagnosis.screeningMethod}</td>
				<th>产前筛查结果</th>
				<td>${prenatalScreenDiagnosis.screeningResult}</td>
			</tr>
			<tr>
				<th>筛查日期</th>
				<td><fmt:formatDate value="${prenatalScreenDiagnosis.screeningDate}" pattern="yyyy/MM/dd"/></td>
				<th>产前筛查医师姓名</th>
				<td>${prenatalScreenDiagnosis.screeningDoctorName}</td>
			</tr>
			<tr>
				<th>产前筛查机构名称</th>
				<td>${prenatalScreenDiagnosis.screeningOrganName}</td>
				<th>产前诊断孕周</th>
				<td>${prenatalScreenDiagnosis.diagnosisPreWeek}</td>
			</tr>
			<tr>
				<th>诊断项目</th>
				<td>${prenatalScreenDiagnosis.diagnosisItem}</td>
				<th>诊断方法</th>
				<td>${prenatalScreenDiagnosis.diagnosisMethod}</td>
			</tr>
			<tr>
				<th>诊断结果</th>
				<td>${prenatalScreenDiagnosis.diagnosisResult}</td>
				<th>产前诊断医学意见</th>
				<td>${prenatalScreenDiagnosis.diagnosisMedicalOpinion}</td>
			</tr>
			<tr>
				<th>诊断日期</th>
				<td><fmt:formatDate value="${prenatalScreenDiagnosis.diagnosisDate}" pattern="yyyy/MM/dd"/></td>
				<th>产前诊断医师姓名</th>
				<td>${prenatalScreenDiagnosis.diagnosticianName}</td>
			</tr>
			<tr>
				<th>诊断机构名称</th>
				<td colspan="3">${prenatalScreenDiagnosis.diagnosisOrganName}</td>
			</tr>
		</table>
	</div>
</div>