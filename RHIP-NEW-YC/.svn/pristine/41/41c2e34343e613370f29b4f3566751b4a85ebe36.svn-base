<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<%@ page import="com.founder.rhip.ehr.common.RoleType" %>
<c:set var="ZXMB" value="<%=RoleType.ZXMB.getValue()%>"/>
<c:set var="ZMB" value="<%=RoleType.ZMB.getValue()%>"/>

<table id="manageCardList" class="layui-table x-admin-sm-table-list-middle">
	<colgroup>
		<col style="width: 10%;" />
		<col style="width: 5%" />
		<col style="width: 15%" />
		<col style="width: 10%" />
		<col style="width: 10%" />
		<col style="width: 13%" />
		<col style="width: 25%" />
		<col style="width: 12%;" />
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
				<td class="centertd"><a href="javascript:void(0)" title="管理卡信息" class="report-link" data-disid="${dmDiseaseInfo.id}">${dmDiseaseInfo.name}</a></td>
				<td class="centertd"><ehr:dic dicmeta="GBT226112003" code="${dmDiseaseInfo.gender}" /></td>
				<td class="centertd"><ehr:ehrBrwLink personId="${dmDiseaseInfo.personId}" ><tags:textWithTip value="${dmDiseaseInfo.idcard}"></tags:textWithTip></ehr:ehrBrwLink></td>
				<td class="centertd"><fmt:formatDate value="${dmDiseaseInfo.birthday}" pattern="yyyy/MM/dd" /></td>
				<td class="centertd"><tags:textWithTip value="${dmDiseaseInfo.phoneNumber}" /></td>
				<td><ehr:tip trim="true">
						<ehr:org code="${dmDiseaseInfo.createOrganCode}"></ehr:org>
					</ehr:tip>
				</td>
				<td><tags:textWithTip value=" ${dmDiseaseInfo.hbpFlag eq '2' ? '高血压':''} ${dmDiseaseInfo.diFlag eq '2' ? '糖尿病':''} ${dmDiseaseInfo.tumorFlag eq '2' ? '肿瘤':''}  ${dmDiseaseInfo.coronaryFlag eq '2' ? '冠心病':''} ${dmDiseaseInfo.strokeFlag eq '2' ? '脑卒中':''}" /></td>
				<td class="centertd">
				<%-- <a title="查看全部体检信息" class="phy-link" href="javascript:void(0)" data-personid="${dmDiseaseInfo.personId}">查看</a> --%>
				<a title="查看全部体检信息" class="phy-link layui-btn layui-btn-normal layui-btn-xs" href="javascript:void(0)" data-personid="${dmDiseaseInfo.personId}" style="color: #FFF;font-size: 12px;"><i class="layui-icon">&#xe615;</i>查看</a>&nbsp;
				<ehr:authorize ifAnyGranted="${ZXMB},${ZMB}">
				<%-- <a title="立即新增体检" class="add-link" href="javascript:void(0)" data-personid="${dmDiseaseInfo.personId}">新增</a> --%>
				<a title="立即新增体检" class="add-link layui-btn layui-btn-xs" href="javascript:void(0)" data-personid="${dmDiseaseInfo.personId}" style="color: #FFF;font-size: 12px;"><i class="layui-icon">&#xe61f;</i>新增</a>
				</ehr:authorize>
				</td>
			</tr>
		</c:forEach>
	</tbody>
	<ehr:pagination action="cmdPhyExaminationList.search" colspan="8" />
</table>