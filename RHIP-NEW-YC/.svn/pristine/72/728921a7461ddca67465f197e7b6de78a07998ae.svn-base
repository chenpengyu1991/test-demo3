<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<table id="planList">
	<colgroup>
		<col style="width: 10%;" />
		<col style="width: 10%" />
		<col style="width: 20%" />
		<col style="width: 15%" />
		<col style="width: 15%" />
		<col style="width: 25%" />
		<col style="width: 5%" />
	</colgroup>
	<thead>
		<tr>
			<th style="width: 20px;">姓名</th>
			<th style="width: 20px;">性别</th>
			<th style="width: 45px;">身份证号</th>
			<th style="width: 30px;">出生日期</th>
			<th style="width: 40px;">联系电话</th>
			<th style="width: 60px;">患病类型</th>
			<th style="width: 20px;">操作</th>
		</tr>
	</thead>
	<tbody class="tbody">
		<c:forEach var="dmPlanInfo" items="${dmPlanList}">
			<tr>
				<td><a title="查看管理卡信息" class="report-link" href="javascript:void(0)" data-personid="${dmPlanInfo.diseaseId}">${dmPlanInfo.name}</a></td>
				<td><ehr:tip> <ehr:dic dicmeta="GBT226112003" code="${dmPlanInfo.gender}" /> </ehr:tip> </td>
				<td><ehr:ehrBrwLink personId="${dmPlanInfo.personId}" ><ehr:tip>${dmPlanInfo.idcard}</ehr:tip></ehr:ehrBrwLink ></td>
				<td><ehr:tip> <fmt:formatDate value="${dmPlanInfo.birthday}" pattern="yyyy/MM/dd" /> </ehr:tip></td>
				<td><ehr:tip>${dmPlanInfo.phoneNumber}</ehr:tip></td>
                <td><tags:textWithTip value=" ${dmPlanInfo.hbpFlag eq '2' ? '高血压':''} ${dmPlanInfo.diFlag eq '2' ? '糖尿病':''} ${dmPlanInfo.tumorFlag eq '2' ? '肿瘤':''}  ${dmPlanInfo.coronaryFlag eq '2' ? '冠心病':''} ${dmPlanInfo.strokeFlag eq '2' ? '脑卒中':''}"/></td>
				<td><a title="点击进行保健计划操作" class="plan-link" href="javascript:void(0)" data-personid="${dmPlanInfo.diseaseId}">计划</a></td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<table>
  <tr>
  	<ehr:pagination action="cdmManagePlanlist.search"/>
  </tr>
</table>
