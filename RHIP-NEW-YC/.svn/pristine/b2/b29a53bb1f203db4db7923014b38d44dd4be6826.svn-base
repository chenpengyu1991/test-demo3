<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<table id="manageCardList" class="layui-table x-admin-sm-table-list-middle">
	<colgroup>
		<col style="width: 10%;" />
		<col style="width: 5%" />
		<col style="width: 15%" />
		<col style="width: 10%" />
		<col style="width: 10%" />
		<col style="width: 15%" />
		<col style="width: 30%" />
		<col style="width: 100px" />
	</colgroup>
	<thead>
		<tr>
			<th>姓名</th>
			<th>性别</th>
			<th>身份证号</th>
			<th>出生日期</th>
			<th>联系电话</th>
			<th>管理机构</th>
			<th>患病类型</th>
			<th>操作</th>
		</tr>
	</thead>
	<tbody class="tbody">
		<c:forEach var="dmDiseaseInfo" items="${dmDiseaseInfoList}">
			<tr>
				<td class="centertd"><a href="javascript:void(0)" title="点击查看管理卡信息" class="report-link" data-disid="${dmDiseaseInfo.id}">${dmDiseaseInfo.name}</a></td>
				<td class="centertd"><ehr:dic dicmeta="GBT226112003" code="${dmDiseaseInfo.gender}" /></td>
				<%--<td><a href="javascript:void(0)" onclick="openEhrBrwById('${dmDiseaseInfo.personId}')"><ehr:tip>${dmDiseaseInfo.idcard}</ehr:tip></a></td>--%>
				<td class="centertd"><ehr:ehrBrwLink personId="${dmDiseaseInfo.personId}" >${dmDiseaseInfo.idcard}</ehr:ehrBrwLink></td>
                <td class="centertd"><fmt:formatDate value="${dmDiseaseInfo.birthday}" pattern="yyyy/MM/dd" /></td>
				<td class="centertd"><tags:textWithTip value="${dmDiseaseInfo.phoneNumber}" /></td>
				<td><ehr:tip><ehr:org code="${dmDiseaseInfo.createOrganCode}"></ehr:org></ehr:tip></td>
                <c:set var="disDetail">
<c:if test="${dmDiseaseInfo.hbpFlag eq '2'}">高血压${dmDiseaseInfo.followupCountHbp} </c:if>
<c:if test="${dmDiseaseInfo.diFlag eq '2'}">糖尿病${dmDiseaseInfo.followupCountDi} </c:if>
<c:if test="${dmDiseaseInfo.tumorFlag eq '2'}">肿瘤${dmDiseaseInfo.followupCountTumor} </c:if>
<c:if test="${dmDiseaseInfo.coronaryFlag eq '2'}">冠心病${dmDiseaseInfo.followupCountCoronary} </c:if>
<c:if test="${dmDiseaseInfo.strokeFlag eq '2'}">脑卒中${dmDiseaseInfo.followupCountStroke}</c:if>
                </c:set>

				<td title="${disDetail}">
					<c:if test="${dmDiseaseInfo.hbpFlag eq '2'}">
						<span style="color:${dmDiseaseInfo.checkHbpNextFollowupDateStatus ? 'red':'black'};">高血压${dmDiseaseInfo.followupCountHbp}&nbsp;</span>
					</c:if> <c:if test="${dmDiseaseInfo.diFlag eq '2'}">
						<span style="color:${dmDiseaseInfo.checkDiNextFollowupDateStatus ? 'red' : 'black' }; ">糖尿病${dmDiseaseInfo.followupCountDi}&nbsp;</span>
					</c:if> <c:if test="${dmDiseaseInfo.tumorFlag eq '2'}">
						<span style="color:${dmDiseaseInfo.checkTumorNextFollowupDateStatus ? 'red' : 'black' }; ">肿瘤${dmDiseaseInfo.followupCountTumor}&nbsp;</span>
					</c:if> <c:if test="${dmDiseaseInfo.coronaryFlag eq '2'}">
						<span style="color:${dmDiseaseInfo.checkCoronaryNextFollowupDateStatus ? 'red' : 'black' }; ">冠心病${dmDiseaseInfo.followupCountCoronary}&nbsp;</span>
					</c:if> <c:if test="${dmDiseaseInfo.strokeFlag eq '2'}">
						<span style="color:${dmDiseaseInfo.checkStrokeNextFollowupDateStatus ? 'red' : 'black' }; ">脑卒中${dmDiseaseInfo.followupCountStroke}</span>
					</c:if>
				</td>
				<td class="centertd">
				<%-- <a href="javascript:void(0)" title="点击进入随访操作" class="followup-link" data-disid="${dmDiseaseInfo.id}">随访</a> --%>
				<%-- <a href="javascript:void(0)" title="点击进入随访操作" class="followup-link" data-disid="${dmDiseaseInfo.id}"><i class="layui-icon" style="color: #009688;">&#xe60e;</i></a> --%>
				 <a href="javascript:void(0);"   title="点击进入随访操作" class="followup-link layui-btn layui-btn-xs button" data-disid="${dmDiseaseInfo.id}" style="color: #ffffff;"><i class="layui-icon" >&#xe642;</i>管理</a>
				</td>
			</tr>
		</c:forEach>
	</tbody>
	<ehr:pagination action="healthCardList.search" colspan="8" />
</table>