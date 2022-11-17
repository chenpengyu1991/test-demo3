<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<script src="${pageContext.request.contextPath}/js/views/oh/occPatient/list.js" type="text/javascript"></script>
<div class="repeattable">
	<table class="layui-table x-admin-sm-table-list-middle">
		<colgroup>
			<ehr:authorize ifAnyGranted="0123">
			<col style="min-width:60px;width: 3%;"/>
			</ehr:authorize>
	        <col style="min-width:120px;width: 8%;"/>
			<col style="min-width:40px;width: 4%;"/>
	        <col style="min-width:100px;width: 8%;"/>	
	        <col style="min-width:100px;width: 15%;"/>	
	        <col style="min-width:100px;width: 10%;"/>	
            <col style="min-width:100px;width: 8%;"/>	
            <col style="min-width:100px;width: 8%;"/>	
            <col style="min-width:100px;width: 8%;"/>
            <col style="min-width:100px;width: 8%;"/>
            <col style="min-width:100px;width: 8%;"/>			
            <col style="min-width:100px;width: 20%;"/>			
		</colgroup>	
		<thead>
			<tr>
				<ehr:authorize ifAnyGranted="0123">
				<th>全选<input type="checkbox" id="all" /></th>
				</ehr:authorize>
				<th>姓名</th>
				<th>性别</th>
				<th>出生日期</th>	
				<th>身份证号</th>
				<th>工种</th>
				<th>档案类型</th>
				<th>建档时间</th>
				<th>审核状态</th>
				<th>审核人</th>
				<th>审核日期</th>
				<th>操作</th>			
			</tr>
		</thead>
		<tbody>	
			<c:forEach var="employeeInfo" items="${employeeInfoList.list}" varStatus="status">
				<tr>
					<ehr:authorize ifAnyGranted="0123">
					<td class="centertd">
						
						<input type="checkbox" 
						<c:if test="${employeeInfo.verifyState!=1}" >chkRef="employeeInfoIds"</c:if>
						 name="employeeInfoIds" value="${employeeInfo.id}"
						<c:if test="${employeeInfo.verifyState==1||employeeInfo.verifyState==2}">disabled="disabled"</c:if>
						/>
						
					</td>
					</ehr:authorize>
					<td title="${employeeInfo.name}" class="centertd">${employeeInfo.name}</td>
					<td class="centertd" title="<ehr:dic dicmeta="FS10006"  code="${employeeInfo.gender}" />">
						<ehr:dic dicmeta="FS10006"  code="${employeeInfo.gender}" />
					</td>
					<td class="centertd" title="<fmt:formatDate value="${employeeInfo.birthdate}" pattern="yyyy/MM/dd" />">
						<fmt:formatDate value="${employeeInfo.birthdate}" pattern="yyyy/MM/dd" />
					</td>
					<td class="centertd" title="${employeeInfo.idcard}">${employeeInfo.idcard}</td>
					<td title="${employeeInfo.jobType}">${employeeInfo.jobType}</td>
					<td title="<ehr:dic dicmeta="OH00001"  code="${employeeInfo.docType}" />">
						<ehr:dic dicmeta="OH00001"  code="${employeeInfo.docType}" />
					</td>
					<td class="centertd" title="<fmt:formatDate value="${employeeInfo.createTime}" pattern="yyyy/MM/dd" />">
						<fmt:formatDate value="${employeeInfo.createTime}" pattern="yyyy/MM/dd" />
					</td>
					<td title="<ehr:dic dicmeta="CV0900103"  code="${employeeInfo.verifyState}" />">
						<ehr:dic dicmeta="CV0900103"  code="${employeeInfo.verifyState}" />
					</td>
					<td title="${employeeInfo.verifier}">${employeeInfo.verifier}</td>
					<td class="centertd" title="<fmt:formatDate value="${employeeInfo.verifyDate}" pattern="yyyy/MM/dd" />">
						<fmt:formatDate value="${employeeInfo.verifyDate}" pattern="yyyy/MM/dd" />
					</td>
					<td class="centertd">
						<a href="javascript:void(0);"  onclick="occPatientList.view('${employeeInfo.id}')" title="查看" ><i class="layui-icon">&#xe615;</i></a>&nbsp;&nbsp;
						<c:if test="${employeeInfo.verifyState==1}">
						    <ehr:authorize ifAnyGranted="0123">
								<a href="javascript:void(0);"  onclick="occPatientList.modify('${employeeInfo.id}')" title="修改"><i class="layui-icon">&#xe642;</i></a>&nbsp;&nbsp;
								<a href="javascript:void(0);"  onclick="occPatientList.del('${employeeInfo.id}')" title="删除"><i class="layui-icon">&#xe640;</i></a>&nbsp;&nbsp;
						    </ehr:authorize>
					    </c:if>
					    <c:if test="${employeeInfo.verifyState!=1}">
					    	<ehr:authorize ifNotGranted="01">
							<a href="javascript:void(0);"  onclick="occPatientList.modify('${employeeInfo.id}')" title="修改"><i class="layui-icon">&#xe642;</i></a>&nbsp;&nbsp;
							<a href="javascript:void(0);"  onclick="occPatientList.del('${employeeInfo.id}')" title="删除"><i class="layui-icon">&#xe640;</i></a>
							</ehr:authorize>
					    </c:if>
					</td>
				</tr>
			</c:forEach>
			<tr>
				<ehr:authorize ifAnyGranted="0123">
					<ehr:pagination action="occPatientSearch.search" colspan="12"/>
				</ehr:authorize>
				<ehr:authorize ifNotGranted="0123">
					<ehr:pagination action="occPatientSearch.search" colspan="11"/>
				</ehr:authorize>
			</tr>
		</tbody>
	</table>
	
	<%-- <table>
		<tr>
			<ehr:pagination action="occPatientSearch.search" />
		</tr>
	</table> --%>
</div>