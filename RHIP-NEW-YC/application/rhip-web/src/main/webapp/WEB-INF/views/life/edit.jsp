<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/views/ehrbrowser/basic/basic.css" />

<div style="background-color: white; height: 515px;">
	<ul>
		<li style="text-align: center; font-size: 25px;">死亡医学证明</li>
	</ul>
	<br/>
	<div class="table-basic">
		<table>
			<colgroup>
				<col style="width: 15%;"/>
	            <col style="width: 35%;"/>
				<col style="width: 15%;"/>
	            <col style="width: 35%;"/>
			</colgroup>
			<tr>
				<th width="15%">姓名</th>
				<td>${personDeathRecord.name}</td>
				<th width="15%">性别</th>
				<td><ehr:dic code="${personDeathRecord.gender}" dicmeta="GBT226112003"/></td>
			</tr>
			<tr>
				<th width="15%">身份证号</th>
				<td><c:if test="${empty personDeathRecord.idcard}">
					<label>${personDeathRecord.idcard} </label>
				</c:if>
					<c:if test="${not empty personDeathRecord.idcard}">
						<label>${personDeathRecord.idcard} </label>
					</c:if></td>
				<th width="15%">民族</th>
				<td><ehr:dic dicmeta="GBT3304" code="${personDeathRecord.nation}"/></td>
			</tr>
			<tr>
				<th width="15%">出生日期</th>
				<td><fmt:formatDate value="${personDeathRecord.birthday}" pattern="yyyy/MM/dd"></fmt:formatDate></td>
				<th width="15%">职业</th>
				<td><ehr:dic dicmeta="GBT6565" code="${personDeathRecord.occupation}"/></td>
			</tr>
			<tr>
				<th width="15%">婚姻状况</th>
				<td><ehr:dic dicmeta="GBT226122003" code="${personDeathRecord.marriage}"/></td>
				<th width="15%">学历</th>
				<td><ehr:dic dicmeta="GBT46582006" code="${personDeathRecord.education}"/></td>
			</tr>
			<tr><th width="15%">实足年龄</th>
				<td >${personDeathRecord.age}</td>
				<th width="15%">住院号</th>
				<td >${personDeathRecord.admissionNo}</td>
			</tr>

			<tr>
				<th width="15%">报告日期</th>
				<td><fmt:formatDate value="${personDeathRecord.reportDate}" pattern="yyyy/MM/dd"></fmt:formatDate></td>
				<th width="15%">死亡日期</th>
				<td><fmt:formatDate value="${personDeathRecord.deathDate}" pattern="yyyy/MM/dd"></fmt:formatDate></td>
			</tr>
			<tr>
				<th width="15%">联系人姓名</th>
				<td>${personDeathRecord.contactName} </td>
				<th width="15%">家人电话号码</th>
				<td>${personDeathRecord.familyPhone}</td>
			</tr>
			<tr>
				<th width="15%">人群分类</th>
				<td><ehr:dic dicmeta="FS990023" code="${personDeathRecord.personType}"/></td>
				<th width="15%">死因分类</th>
				<td><ehr:dic dicmeta="MH00020" code="${personDeathRecord.deathClass}"/></td>
			</tr>
			<tr>
				<th><label  id="deathIcd">根本死因编码</label></th>
				<td><label>${personDeathRecord.deathIcd} </label></td>
				<th><label  id="deathReason">根本死亡原因名称</label></th>
				<td><label>${personDeathRecord.deathReason} </label></td>
			</tr>
			<tr>
				<th><label  id="otherDiagnose">其他疾病诊断</label></th>
				<td><label>${personDeathRecord.otherDiagnose} </label></td>
				<th><label  id="organLevel">最高诊断机构级别</label></th>
				<td><ehr:dic dicmeta="CV850003" code="${personDeathRecord.organLevel}"/></td>
			</tr>
			<tr>
				<th><label  id="placeType">死亡地点类别</label></th>
			<td><ehr:dic dicmeta="CV0201103" code="${personDeathRecord.placeType}"/></td>
			<th><label  id="deathBasis">死亡诊断依据</label></th>
			<td><ehr:dic dicmeta="CV0501037" code="${personDeathRecord.deathBasis}"/></td>
			</tr>
			<tr>
				<th><label   id="duration">（A）发病至死亡大概时间间隔</label></th>
				<td><fmt:formatDate value="${personDeathRecord.duration}" pattern="hh:mm:ss"></fmt:formatDate></td>
				<th><label  id="dCause">（A）直接导致死亡的疾病名称</label></th>
				<td><label>${personDeathRecord.dCause} </label></td>
			</tr>
			<tr>
				<th><label   id="causeAName">（B）引起（A）的疾病名称</label></th>
				<td><label>${personDeathRecord.causeAName}</label></td>
				<th><label id="causeADur">（B）引起（A）大概时间间隔</label></th>
				<td><fmt:formatDate value="${personDeathRecord.causeADur}" pattern="hh:mm:ss"></fmt:formatDate></td>
			</tr>
			<tr>
				<th>（c）引起（B）的疾病名称</th>
				<td><label>${personDeathRecord.causeBName}</label></td>
				<th><label id="causeBDur">（c）引起（B）大概时间间隔</label></th>
				<td><fmt:formatDate value="${personDeathRecord.causeBDur}" pattern="hh:mm:ss"></fmt:formatDate></td>
			</tr>
			<tr>
				<th><label   id="causeCName">直接死亡原因c名称</label></th>
				<td><label>${personDeathRecord.causeCName} </label></td>
				<th><label  id="causeCDur">引起（C）大概时间间隔</label></th>
				<td><fmt:formatDate value="${personDeathRecord.causeCDur}" pattern="hh:mm:ss"></fmt:formatDate></td>
			</tr>
			<tr>
				<th><label   id="causeDName">直接死亡原因D名称</label></th>
				<td><label>${personDeathRecord.causeDName}</label></td>
				<th><label  id="causeDDur">引起（D）大概时间间隔</label></th>
				<td><fmt:formatDate value="${personDeathRecord.causeDDur}" pattern="hh:mm:ss"></fmt:formatDate></td>
			</tr>
			<tr>
				<th>创建记录用户</th>
				<td>${personDeathRecord.inputUser} </td>
				<th><label  id="updateUser">更新记录用户</label></th>
				<td><label>${personDeathRecord.updateUser} </label></td>
				</td>
			</tr>
			<tr>
				<th><label  id="updateOrgancode">更新记录机构</label></th>
				<td><ehr:org code="${personDeathRecord.updateOrgancode}"/></td>
				<th><label   id="updateDate">更新时间</label></th>
				<td><fmt:formatDate value="${personDeathRecord.updateDate}" pattern="yyyy/MM/dd"></fmt:formatDate></td>
			</tr>
			<tr>
				<th width="15%">录入人身份证号</th>
				<td><c:if test="">
					<label>${personDeathRecord.inputIdcard} </label>
				</c:if>
					<c:if test="">
						<label>${personDeathRecord.inputIdcard} </label>
					</c:if></td>
				<th width="15%">录入日期和时间</th>
				<td><fmt:formatDate value="${personDeathRecord.inputDate}" pattern="yyyy/MM/dd hh:mm:ss"></fmt:formatDate></td>
				</td>
			</tr>
			<tr>
				<th><label  id="inputOrgancode">录入机构</label></th>
				<td><ehr:org code="${personDeathRecord.inputOrgancode}"/></td>
				<th><label  id="cancelStatus">注销状态</label></th>
				<td> <ehr:dic dicmeta="PH00035" code="${personDeathRecord.cancelStatus}"/></td>
			</tr>
		</table>
	</div>
</div>