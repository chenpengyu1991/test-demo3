<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ page import="com.founder.rhip.ehr.common.RoleType" %>
<c:set var="ZXZYY" value="<%=RoleType.ZXLNR.getValue()%>"/>
<c:set var="ZZYY" value="<%=RoleType.ZLNR.getValue()%>"/>
<div class="repeattable">
	<table class="layui-table x-admin-sm-table-list-middle">
		<colgroup>
			<col style="width: 60px;" />
			<col style="width: 50px;" />
			<col style="width: 50px;" />
			<col style="width: 110px;" />
			<col style="width: 160px;" />
			<col style="width: 50px;" />
			<col style="width: 120px;" />
		</colgroup>
		<thead>
			<tr>
				<th>姓名</th>
				<th>性别</th>
				<th>年龄(岁)</th>
				<th>身份证号</th>
				<th>管理机构</th>
				<th>是否辨识</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody style="text-align: center">
			<c:forEach var="personInfo" items="${personInfos}">
				<tr>
					<td><ehr:tip>${personInfo.name}</ehr:tip></td>
					<td><ehr:dic dicmeta="GBT226112003" code="${personInfo.gender}" /></td>
					<td>${personInfo.age}</td>
					<td title="${personInfo.idcard}">
						<ehr:tip>${personInfo.idcard==null?personInfo.otherIdcard:personInfo.idcard}</ehr:tip>
					</td>
					<td><ehr:tip><ehr:org flag="0" code="${personInfo.inputOrganCode}"/></ehr:tip></td>
					<td><c:if test="${personInfo.isTcm ge 1}">是</c:if><c:if test="${personInfo.isTcm eq 0}">否</c:if></td>
					<td>
						<a title="查看全部体质辨识" class="phy-link layui-btn layui-btn-normal layui-btn-xs" href="javascript:void(0)" style="color: #FFF;font-size: 12px;" data-personid="${personInfo.personId}"><i class="layui-icon">&#xe615;</i>查看</a>
						<c:if test="${personInfo.logoff eq 0}">
							<ehr:authorize ifAnyGranted="${ZXZYY},${ZZYY}">
								<a title="立即新增体质辨识" class="add-link layui-btn layui-btn-xs" href="javascript:void(0)" style="color: #FFF;font-size: 12px;" data-personid="${personInfo.personId}" data-type="edit"><i class="layui-icon">&#xe608;</i>新增</a>
							</ehr:authorize>
						</c:if>
					</td>
					<%-- <td>
						<ehr:authorize ifAnyGranted="01">
							<c:if test="${personInfo.tcmStatus eq 0}">未辨识</c:if>
							<c:if test="${empty personInfo.tcmStatus}">未辨识</c:if>
							<c:if test="${personInfo.tcmStatus eq '1'}">已辨识</c:if>
						</ehr:authorize>
                        <c:choose>
						<c:when test="${personInfo.tcmStatus eq 1 && personInfo.logoff eq 0}">
							<ehr:authorize ifNotGranted="01,04">
								<a href="javascript:void(0)" onclick="echManageSearch.initReport(${personInfo.id},'edit')" title="修改"><i class="layui-icon">&#xe642;</i></a>
							</ehr:authorize>
							<a href="javascript:void(0)" onclick="echManageSearch.initReport(${personInfo.id},'view')" title="查看" ><i class="layui-icon">&#xe615;</i></a>
						</c:when>
                            <c:when test="${personInfo.tcmStatus eq 1 && personInfo.logoff eq 1}">
                                <a href="javascript:void(0)" onclick="echManageSearch.initReport(${personInfo.id},'view')" title="查看" ><i class="layui-icon">&#xe615;</i></a>
                            </c:when>
                        </c:choose>
                        <ehr:authorize ifNotGranted="01">
							<c:if test="${personInfo.tcmStatus eq 0 && personInfo.logoff eq 0}">
								<a href="javascript:void(0)" onclick="echManageSearch.initReport(${personInfo.id},'edit')" title="新建" ><i class="layui-icon">&#xe608;</i></a>
							</c:if>	
							<c:if test="${empty personInfo.tcmStatus && personInfo.logoff eq 0}">
                                <a href="javascript:void(0)" onclick="echManageSearch.initReport(${personInfo.id},'edit')" title="新建" ><i class="layui-icon">&#xe608;</i></a>
							</c:if>												
						</ehr:authorize>
					</td> --%>
				</tr>
			</c:forEach>
			<tr>
			<ehr:pagination action="echManageSearch.manageSearch" colspan="7" />
		</tr>
		</tbody>
	</table>
	<%-- <table>
		<tr>
			<ehr:pagination action="echManageSearch.manageSearch" />
		</tr>
	</table> --%>
</div>