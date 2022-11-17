<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<%@ page import="com.founder.rhip.ehr.common.RoleType" %>
<c:set var="ADMIN" value="<%=RoleType.ADMIN.getValue()%>"/>
<c:set var="JKXG" value="<%=RoleType.JKXG.getValue()%>"/>
<c:set var="ZXXG" value="<%=RoleType.ZXXG.getValue()%>"/>
<c:set var="ZXG" value="<%=RoleType.ZXG.getValue()%>"/>
<table id="manageCardList" class="layui-table x-admin-sm-table-list-middle">
	<colgroup>
		<col style="width: 12%" />
		<col style="width: 8%" />
		<col style="width: 7%" />
		<col style="width: 4%" />
		<col style="width: 14%" />
		<col style="width: 8%" />
		<col style="width: 9%" />
		<col style="width: 12%" />
		<col style="width: 8%" />
		<col style="width: 6%" />
		<col style="width: 5%" />
		<ehr:authorize ifAnyGranted="${ZXXG},${ZXG}">
			<col style="width: 80px;">
		</ehr:authorize>
	</colgroup>
	<thead>
		<tr>
			<th>类型</th>
			<th>临床分型</th>
			<th>姓名</th>
			<th>性别</th>
			<th>身份证号</th>
			<th>出生日期</th>
			<th>联系电话</th>
			<th>管理机构</th>
			<th>出院日期</th>
			<th>管理状态</th>
			<th>签约状态</th>
			<ehr:authorize ifAnyGranted="${ZXXG},${ZXG}">
			<th>操作</th>
			</ehr:authorize> 
		</tr>
	</thead>
	<tbody class="tbody">
		<c:forEach var="ncpPatient" items="${ncpPatientList}">
			<tr <c:if test="${ncpPatient.filingFlag=='9'}">style="background-color: #D3D3D3"</c:if> >
				<td>
					<ehr:dic dicmeta="NCP00003" code="${ncpPatient.patientType}" />
					<c:if test="${not empty ncpPatient.zlType}">
						(<ehr:dic dicmeta="NCP00011" code="${ncpPatient.zlType}" />)
					</c:if>
				</td>
				<td><c:if test="${ncpPatient.clinicalClass=='1'}"> <span style="font-size:28px;color:#00CC00;">●</span></c:if>
					<c:if test="${ncpPatient.clinicalClass=='2'}"> <span style="font-size:28px;color:#0000FF;">●</span></c:if>
					<c:if test="${ncpPatient.clinicalClass=='3'}"> <span style="font-size:28px;color:#FF9900;">●</span></c:if>
					<c:if test="${ncpPatient.clinicalClass=='4'}"> <span style="font-size:28px;color:#FF0000;">●</span></c:if>
					<ehr:dic dicmeta="NCP00001" code="${ncpPatient.clinicalClass}" /></td>
				<td><a title="管理卡信息" class="report-link" href="javascript:void(0)" data-disid="${ncpPatient.id}">${ncpPatient.name}</a></td>
				<td><ehr:dic dicmeta="GBT226112003" code="${ncpPatient.gender}" /></td>
				<td><ehr:ehrBrwLink  personId="${ncpPatient.personId}"><tags:textWithTip value="${ncpPatient.idcard}"></tags:textWithTip></ehr:ehrBrwLink></td>
				<td><fmt:formatDate value="${ncpPatient.birthday}" pattern="yyyy/MM/dd" /></td>
				<td><tags:textWithTip value="${ncpPatient.phoneNumber}" /></td>
				<td><ehr:tip trim="true">
						<ehr:org code="${ncpPatient.managementOrg}"></ehr:org>
					</ehr:tip></td>
				<td><fmt:formatDate value="${ncpPatient.dischargeDate}" pattern="yyyy/MM/dd" /></td>
				<td><c:if test="${ncpPatient.filingFlag=='9'}">已结案</c:if><c:if test="${ncpPatient.filingFlag=='1' or ncpPatient.filingFlag=='5'}">正常管理</c:if> </td>
				<td <c:if test="${(ncpPatient.signFlag=='0' || ncpPatient.signFlag==null) and (ncpPatient.filingFlag=='1' || ncpPatient.filingFlag=='5')}"> style="background-color: #FFEC8B"; </c:if>>
							<c:if test="${ncpPatient.signFlag!=null}">
							<ehr:dic dicmeta="FS10399" code="${ncpPatient.signFlag}" />
							</c:if>
							<c:if test="${ncpPatient.signFlag==null}">
							未签约
							</c:if>
				</td>	
				 <ehr:authorize ifAnyGranted="${ZXXG},${ZXG}"> 
				<td>
				<c:if test="${ncpPatient.filingFlag!='9'}">
				<%-- <a title="修改管理卡信息" class="update-link" href="javascript:void(0)" data-disid="${ncpPatient.id}">修改</a> --%>
				<a title="修改管理卡信息" class="update-link" href="javascript:void(0)" data-disid="${ncpPatient.id}"><i class="layui-icon">&#xe642;</i></a>&nbsp;
				<%-- <a title="撤销管理卡信息" class="delete-link" href="javascript:void(0)" data-disid="${ncpPatient.id}">撤销</a> --%>
				<a title="撤销管理卡信息" class="delete-link" href="javascript:void(0)" data-disid="${ncpPatient.id}"><i class="layui-icon">&#xe666;</i></a>
				</c:if></td>
				 </ehr:authorize> 
			</tr>
		</c:forEach>
	</tbody>
</table>
<table>
  <tr>
  	<ehr:pagination action="healthCardList.search"/>
  </tr>
</table>

