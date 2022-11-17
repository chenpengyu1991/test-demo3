<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<%@ page import="com.founder.rhip.ehr.common.RoleType" %>
<c:set var="ZXMB" value="<%=RoleType.ZXMB.getValue()%>"/>
<c:set var="ZMB" value="<%=RoleType.ZMB.getValue()%>"/>

<ehr:authorize ifAnyGranted="${ZXMB},${ZMB}">
	<c:set var="role_check_issqz" value="${true}"></c:set>
</ehr:authorize>

<table id="manageCardList" class="layui-table x-admin-sm-table-list-middle">
	<colgroup>
		<col style="width: 10%;" />
		<col style="width: 10%" />
		<col style="width: 15%" />
		<col style="width: 10%" />
		<col style="width: 10%" />
		<col style="width: 15%" />
		<col style="width: 30%;"/>
		<ehr:authorize ifAnyGranted="${ZXMB},${ZMB}">
			<col style="width: 100px;"/>
		</ehr:authorize>
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
			<ehr:authorize ifAnyGranted="${ZXMB},${ZMB}">
				<th>操作</th>
			</ehr:authorize>
		</tr>
	</thead>
	<tbody class="tbody">
		<c:forEach var="dmDiseaseInfo" items="${dmDiseaseInfoList}">
			<tr>
				<td class="centertd">
					<a href="javascript:void(0)" title="管理卡信息" class="report-link"
					   data-disid="${dmDiseaseInfo.id}" data-show="${deleteOrCancel eq '2' ? '0' : '1'}">${dmDiseaseInfo.name}</a>
				</td>
				<td class="centertd"><ehr:dic dicmeta="GBT226112003" code="${dmDiseaseInfo.gender}" /></td>
				<td class="centertd"><ehr:ehrBrwLink personId="${dmDiseaseInfo.personId}" ><tags:textWithTip value="${dmDiseaseInfo.idcard}"></tags:textWithTip></ehr:ehrBrwLink></td>
				<td class="centertd"><fmt:formatDate value="${dmDiseaseInfo.birthday}" pattern="yyyy/MM/dd" /></td>
				<td class="centertd"><tags:textWithTip value="${dmDiseaseInfo.phoneNumber}" /></td>
				<td><ehr:tip>
						<ehr:org code="${dmDiseaseInfo.createOrganCode}"></ehr:org>
					</ehr:tip>
					<c:choose>
						<c:when test="${deleteOrCancel eq '2'}">
							<c:set var="disDetail">
								<c:if test="${dmDiseaseInfo.hbpFlag eq '1'}">高血压</c:if> <c:if test="${dmDiseaseInfo.diFlag eq '1'}">糖尿病</c:if> <c:if test="${dmDiseaseInfo.tumorFlag eq '1'}">肿瘤</c:if> <c:if test="${dmDiseaseInfo.coronaryFlag eq '1'}">冠心病</c:if> <c:if test="${dmDiseaseInfo.strokeFlag eq '1'}">脑卒中</c:if>
							</c:set>
						</c:when>
						<c:otherwise>
							<c:set var="disDetail">
								<c:if test="${dmDiseaseInfo.hbpFlag eq '2'}">高血压</c:if> <c:if test="${dmDiseaseInfo.diFlag eq '2'}">糖尿病</c:if> <c:if test="${dmDiseaseInfo.tumorFlag eq '2'}">肿瘤</c:if> <c:if test="${dmDiseaseInfo.coronaryFlag eq '2'}">冠心病</c:if> <c:if test="${dmDiseaseInfo.strokeFlag eq '2'}">脑卒中</c:if>
							</c:set>
						</c:otherwise>
					</c:choose>
				</td>
				<td>
					<c:choose>
						<c:when test="${deleteOrCancel eq '2'}">
							<label title="${disDetail}">
									${dmDiseaseInfo.hbpFlag eq '1' ? '高血压':''} ${dmDiseaseInfo.diFlag eq '1' ? '糖尿病':''} ${dmDiseaseInfo.tumorFlag eq '1' ? '肿瘤':''} ${dmDiseaseInfo.coronaryFlag eq '1' ? '冠心病':''} ${dmDiseaseInfo.strokeFlag eq '1' ? '脑卒中':''}
							</label>
						</c:when>
						<c:otherwise>
							<label title="${disDetail}">
									${dmDiseaseInfo.hbpFlag eq '2' ? '高血压':''} ${dmDiseaseInfo.diFlag eq '2' ? '糖尿病':''} ${dmDiseaseInfo.tumorFlag eq '2' ? '肿瘤':''} ${dmDiseaseInfo.coronaryFlag eq '2' ? '冠心病':''} ${dmDiseaseInfo.strokeFlag eq '2' ? '脑卒中':''}
							</label>
						</c:otherwise>
					</c:choose>

				</td>
				<ehr:authorize ifAnyGranted="${ZXMB},${ZMB}">
					<td class="centertd">
						<c:choose>
							<c:when test="${dmDiseaseInfo.status eq '1'}">
								<%-- <a title="恢复管理卡信息" class="renew-link" href="javascript:void(0)" data-disid="${dmDiseaseInfo.id}">恢复</a> --%>
								<%--<a title="恢复管理卡信息" class="renew-link" href="javascript:void(0)" data-disid="${dmDiseaseInfo.id}"><i class="layui-icon">&#xe669;</i></a>--%>
								<a href="javascript:void(0);" title="恢复管理卡信息" class="renew-link layui-btn layui-btn-xs button" data-disid="${dmDiseaseInfo.id}" style="color: #ffffff;"><i class="layui-icon" >&#xe669;</i>恢复</a>
							</c:when>
							<c:otherwise>
								<span class="loadclass layui-btn layui-btn-xs" style="background-color: #B5B5A5;" title="恢复"><i class="layui-icon">&#xe669;</i>恢复</span>
							</c:otherwise>
						</c:choose>
					</td>
				</ehr:authorize>
			</tr>
		</c:forEach>
	</tbody>
	<tr>
	<ehr:authorize ifAnyGranted="${ZXMB},${ZMB}">
		<ehr:pagination action="cdmStandardizationCancel.search" colspan="8" />
	</ehr:authorize>
	<ehr:authorize ifNotGranted="${ZXMB},${ZMB}">
		<ehr:pagination action="cdmStandardizationCancel.search" colspan="7" />
	</ehr:authorize>
	</tr>
</table>