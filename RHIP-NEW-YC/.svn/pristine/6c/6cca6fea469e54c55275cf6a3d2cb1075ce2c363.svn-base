<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<%@ page import="com.founder.rhip.ehr.common.RoleType" %>
<c:set var="ADMIN" value="<%=RoleType.ADMIN.getValue()%>"/>
<c:set var="JKMBK" value="<%=RoleType.JKMBK.getValue()%>"/>
<c:set var="ZXMB" value="<%=RoleType.ZXMB.getValue()%>"/>
<c:set var="ZMB" value="<%=RoleType.ZMB.getValue()%>"/>

<ehr:authorize ifAnyGranted="${ZMB}">
</ehr:authorize>
<table id="manageCardList" class="layui-table x-admin-sm-table-list-middle">
	<colgroup>
		<col style="width: 8%;" />
		<col style="width: 8%" />
		<col style="width: 19%" />
		<col style="width: 10%" />
		<col style="width: 10%" />
		<col style="width: 15%" />
		<col style="width: 25%" />
		<ehr:authorize ifAnyGranted="${ZXMB},${ZMB}">
			<col style="width: 80px;">
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
				<td class="centertd"><a title="管理卡信息" class="report-link" href="javascript:void(0)" data-disid="${dmDiseaseInfo.id}">${dmDiseaseInfo.name}</a></td>
				<td class="centertd"><ehr:dic dicmeta="GBT226112003" code="${dmDiseaseInfo.gender}" /></td>
				<td class="centertd"><ehr:ehrBrwLink  personId="${dmDiseaseInfo.personId}"><tags:textWithTip value="${dmDiseaseInfo.idcard}"></tags:textWithTip></ehr:ehrBrwLink></td>
				<td class="centertd"><fmt:formatDate value="${dmDiseaseInfo.birthday}" pattern="yyyy/MM/dd" /></td>
				<td class="centertd"><tags:textWithTip value="${dmDiseaseInfo.phoneNumber}" /></td>
				<td>
					<ehr:tip trim="true">
						<ehr:org code="${dmDiseaseInfo.createOrganCode}"></ehr:org>
					</ehr:tip>
				</td>
                <c:set var="disDetail">
					<c:if test="${dmDiseaseInfo.hbpFlag eq '2'}">高血压:<fmt:formatDate value="${dmDiseaseInfo.hbpManagedDate}" pattern="yyyy/MM/dd" /> </c:if>
					<c:if test="${dmDiseaseInfo.diFlag eq '2'}">糖尿病:<fmt:formatDate value="${dmDiseaseInfo.diManagedDate}" pattern="yyyy/MM/dd" /> </c:if>
					<c:if test="${dmDiseaseInfo.tumorFlag eq '2'}">肿瘤:<fmt:formatDate value="${dmDiseaseInfo.tumorManagedDate}" pattern="yyyy/MM/dd" /> </c:if>
					<c:if test="${dmDiseaseInfo.coronaryFlag eq '2'}">冠心病:<fmt:formatDate value="${dmDiseaseInfo.coronaryManagedDate}" pattern="yyyy/MM/dd" /> </c:if>
					<c:if test="${dmDiseaseInfo.strokeFlag eq '2'}">脑卒中:<fmt:formatDate value="${dmDiseaseInfo.strokeManagedDate}" pattern="yyyy/MM/dd" /> </c:if>
                </c:set>
				<td>
                    <label  title="${disDetail}">
						${dmDiseaseInfo.hbpFlag eq '2' ? '高血压':''} ${dmDiseaseInfo.diFlag eq '2' ? '糖尿病':''} ${dmDiseaseInfo.tumorFlag eq '2' ? '肿瘤':''} ${dmDiseaseInfo.coronaryFlag eq '2' ? '冠心病':''} ${dmDiseaseInfo.strokeFlag eq '2' ? '脑卒中':''}
                    </label>
                </td>
				<ehr:authorize ifAnyGranted="${ZXMB},${ZMB}">
				<td>
				<%-- <a title="撤销管理卡信息" class="delete-link" href="javascript:void(0)" data-disid="${dmDiseaseInfo.id}">撤销</a> --%>
				<%--<a class="delete-link" href="javascript:void(0)" data-disid="${dmDiseaseInfo.id}" title="撤销管理卡信息"><i class="layui-icon">&#xe640;</i></a>--%>
					<a class="delete-link layui-btn layui-btn-danger layui-btn-xs" href="#" title="撤销管理卡信息" style="color: #FFF;font-size: 12px;" data-disid="${dmDiseaseInfo.id}"><i class="layui-icon">&#xe640;</i>撤销</a>
				</td>
				</ehr:authorize>
			</tr>
		</c:forEach>
		<tr>

			<ehr:authorize ifAnyGranted="${ZXMB},${ZMB}">
				<ehr:pagination action="healthCardList.search" colspan="8"/>
			</ehr:authorize>
			<ehr:authorize ifNotGranted="${ZXMB},${ZMB}">
				<ehr:pagination action="healthCardList.search" colspan="7"/>
			</ehr:authorize>
		</tr>
	</tbody>
</table>
<%-- <table>
  <tr>
  	<ehr:pagination action="healthCardList.search"/>
  </tr>
</table> --%>

