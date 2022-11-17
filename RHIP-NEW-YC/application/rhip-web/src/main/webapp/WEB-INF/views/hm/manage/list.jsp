<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/views/hm/manage/list.js"/>
<%@ page import="com.founder.rhip.ehr.common.RoleType" %>
<c:set var="ADMIN" value="<%=RoleType.ADMIN.getValue()%>"/>
<c:set var="JKLNR" value="<%=RoleType.JKLNR.getValue()%>"/>
<c:set var="ZXLNR" value="<%=RoleType.ZXLNR.getValue()%>"/>
<c:set var="ZLNR" value="<%=RoleType.ZLNR.getValue()%>"/>
<div class="repeattable">
	<table class="layui-table x-admin-sm-table-list-middle">
		<colgroup>
			<col style="width: 60px;" />
			<col style="width: 30px;" />
			<col style="width: 40px;" />
			<col style="width: 80px;" />
			<col style="width: 90px;" />
			<col style="width: 100px;" />
			<col style="width: 120px;" />
			<col style="width: 40px;" />
			<col style="width: 40px;" />
			<col style="width: 40px;" />
			<col style="width: 70px;" />
			<col style="width: 100px;" />
		</colgroup>
		<thead>
			<tr>
				<th>姓名</th>
				<th>性别</th>
				<th>年龄(岁)</th>
				<th>出生日期</th>
				<th>身份证号</th>
				<th>档案编号</th>
				<th>管理机构</th>
				<th>是否体检</th>
				<th>是否评估</th>
				<th>是否中医指导</th>
				<th>备注</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody style="text-align: center">
			<c:forEach var="physicalExamRecord" items="${physicalExamRecords}">
				<tr>
					<td class="centertd">${physicalExamRecord.name}</td>
					<td class="centertd"><ehr:dic dicmeta="GBT226112003" code="${physicalExamRecord.gender}" /></td>
					<td class="centertd">${physicalExamRecord.age}</td>
					<td class="centertd"><fmt:formatDate value="${physicalExamRecord.birthday}" pattern="yyyy/MM/dd" /></td>
					<td class="centertd" title="${physicalExamRecord.idcard}">${physicalExamRecord.idcard}</td>
					<td class="centertd" title="${physicalExamRecord.healthFileNo}">${physicalExamRecord.healthFileNo}</td>
					<td title="<ehr:org flag="0" code="${physicalExamRecord.inputOrganCode}"/>"><ehr:org flag="0" code="${physicalExamRecord.inputOrganCode}"/></td>
					<td><c:if test="${physicalExamRecord.isExam ge 1}">是</c:if><c:if test="${physicalExamRecord.isExam eq 0 }">否</c:if></td>
					<td><c:if test="${physicalExamRecord.isEstimateStatus ge 1}">是</c:if><c:if test="${physicalExamRecord.isEstimateStatus eq 0}">否</c:if></td>
					<td><c:if test="${physicalExamRecord.isHealthGuideStatus ge 1}">是</c:if><c:if test="${physicalExamRecord.isHealthGuideStatus eq 0}">否</c:if></td>
					<td style="text-align: left;"><ehr:dic dicmeta="FS990026" code="${physicalExamRecord.remarks}"/></td>
					<td style="text-align: left;">
						<a title="查看全部体检信息" class="phy-link layui-btn layui-btn-normal layui-btn-xs" href="javascript:void(0)" style="color: #FFF;font-size: 12px;" data-personid="${physicalExamRecord.personId}"><i class="layui-icon">&#xe615;</i>查看</a>
					    <c:if test="${physicalExamRecord.logoff == 0}">
							<ehr:authorize ifAnyGranted="${ZXLNR},${ZLNR}">
								<a title="立即新增体检" class="add-link layui-btn layui-btn-xs" href="javascript:void(0)" style="color: #FFF;font-size: 12px;" data-personid="${physicalExamRecord.personId}"><i class="layui-icon" >&#xe608;</i>新增</a>
							</ehr:authorize>
					    </c:if>
                       <%--  <ehr:authorize ifAnyGranted="${ZXLNR},${ZLNR}">
                        	<c:choose>
					    		<c:when test="${physicalExamRecord.logoff == 0}">
									<c:choose>
										<c:when test="${physicalExamRecord.examStatus eq 1}">
											<a href="javascript:void(0)" onclick="hmManageList.view(${physicalExamRecord.id},${physicalExamRecord.personId})">查看</a>
											<a href="javascript:void(0)" onclick="hmManageList.view(${physicalExamRecord.id},${physicalExamRecord.personId})" title="查看" ><i class="layui-icon">&#xe615;</i></a>
											<a href="javascript:void(0)" onclick="hmManageList.add(${physicalExamRecord.id},${physicalExamRecord.personId})">编辑</a>
											<a href="javascript:void(0)" onclick="hmManageList.add(${physicalExamRecord.id},${physicalExamRecord.personId})" title="编辑"><i class="layui-icon">&#xe642;</i></a>
											<a href="javascript:void(0)" onclick="hmManageList.deleteExam(${physicalExamRecord.personId},${physicalExamRecord.examNumber})">删除</a>
											<a href="javascript:void(0)" onclick="hmManageList.deleteExam(${physicalExamRecord.personId},${physicalExamRecord.examNumber})" title="删除"><i class="layui-icon">&#xe640;</i></a>
										</c:when>
										<c:otherwise>
											<span class="loadclass" title="查看"><i class="layui-icon">&#xe615;</i></span>
											<a href="javascript:void(0)" onclick="hmManageList.add(${physicalExamRecord.id},${physicalExamRecord.personId})">录入</a>
											<a href="javascript:void(0)" onclick="hmManageList.add(${physicalExamRecord.id},${physicalExamRecord.personId})" title="录入"><i class="layui-icon">&#xe608;</i></a>
											<span class="loadclass" title="删除"><i class="layui-icon">&#xe640;</i></span>
										</c:otherwise>
									</c:choose>
								</c:when>
					    		<c:otherwise>
					    			<c:choose>
										<c:when test="${physicalExamRecord.examStatus eq 1}">
											<span class="loadclass" title="查看"><i class="layui-icon">&#xe615;</i></span>
											<span class="loadclass" title="编辑"><i class="layui-icon">&#xe642;</i></span>
											<span class="loadclass" title="删除"><i class="layui-icon">&#xe640;</i></span>
										</c:when>
										<c:otherwise>
											<span class="loadclass" title="查看"><i class="layui-icon">&#xe615;</i></span>
											<span class="loadclass" title="录入"><i class="layui-icon">&#xe608;</i></span>
											<span class="loadclass" title="删除"><i class="layui-icon">&#xe640;</i></span>
										</c:otherwise>
									</c:choose>
					    		</c:otherwise>
					    	</c:choose>
                        </ehr:authorize>
						<ehr:authorize ifAnyGranted="${JKLNR},${ADMIN}">
							<c:if test="${physicalExamRecord.examStatus eq 1}">
								<a href="javascript:void(0)" onclick="hmManageList.view(${physicalExamRecord.id},${physicalExamRecord.personId})">查看</a>
								<a href="javascript:void(0)" onclick="hmManageList.view(${physicalExamRecord.id},${physicalExamRecord.personId})" title="查看" ><i class="layui-icon">&#xe615;</i></a>
							</c:if>
							
						</ehr:authorize> --%>
					</td>
				</tr>
			</c:forEach>
		</tbody>
		<tr>
			<ehr:pagination action="hmManageSearch.search" colspan="12"/>
		</tr>
	</table>
	<%-- <table>
		<tr>
			<ehr:pagination action="hmManageSearch.search" />
		</tr>
	</table> --%>
</div>