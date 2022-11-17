<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<div class="repeattable">
    <table id="person_record_table" class="layui-table x-admin-sm-table-list-middle">
        <colgroup>
            <col style="width: 10%"/>
            <col style="width: 10%"/>
            <col style="width: 15%"/>
            <col style="width: 15%"/>
            <col style="width: 15%"/>
            <col style="width: 10%"/>
            <col style="width: 30%"/>
        </colgroup>
        <thead>
			<tr>
				<th>用户名</th>
				<th>姓名</th>
				<th>性别</th>
				<th>机构</th>
				<th>固定电话</th>
				<th>状态</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody class="tbody">
			<c:forEach items="${collection}" var="varName">
					<tr>
						<td title="${varName.userName}">${varName.userName}</td>
						<td title="${varName.name}">${varName.name}</td>
						<td style="text-align: center;" title="<ehr:dic dicmeta="GBT226112003" code="${varName.gender}"/>"><ehr:dic dicmeta="GBT226112003" code="${varName.gender}"/></td>
						<td title="<ehr:user-org userCode="${varName.userCode}"/>">
							<ehr:user-org userCode="${varName.userCode}"/>
						</td>	
						<td>${varName.telephone}</td> 
						<td style="text-align: center;">
							<c:choose>
								<c:when test="${varName.status == 1}">已启用</c:when>
								<c:when test="${varName.status == 2}">已失效</c:when>
								<c:otherwise>
									已禁用
								</c:otherwise>
							</c:choose>
						<td style="text-align: center;">
							<c:choose>
								<c:when test="${varName.status == 2}">已失效</c:when>
								<c:otherwise>
									<%-- <a href="#this" id="modifyUser${varName.id}" data-userCode="${varName.userCode}">修改</a> --%>
									<a href="#this" id="modifyUser${varName.id}" data-userCode="${varName.userCode}" class="layui-btn layui-btn-xs" title="修改" style="color: #FFF;font-size: 12px;"><i class="layui-icon">&#xe642;</i>修改</a>&nbsp;
									<%-- <a href="#this" id="doableUser${varName.id}" data-userCode="${varName.userCode}" data-status='${varName.status}'>${varName.status == 1 ? '禁用' : '启用'}</a> --%>
									<c:if test="${varName.status eq 1}">
										<a href="#this" id="doableUser${varName.id}" data-userCode="${varName.userCode}" class="layui-btn layui-btn-danger layui-btn-xs" data-status='${varName.status}' title="禁用" style="color: #FFF;font-size: 12px;"><i class="layui-icon">&#x1007;</i>禁用</a>&nbsp;
									</c:if>
									 <c:if test="${varName.status ne 1}">
										<a href="#this" id="doableUser${varName.id}" data-userCode="${varName.userCode}" class="layui-btn layui-btn-normal layui-btn-xs" data-status='${varName.status}' title="启用" style="color: #FFF;font-size: 12px;"><i class="layui-icon">&#x1005;</i>启用</a>&nbsp;
									</c:if>
									<%-- <a href="#this" id="deleteUser${varName.id}" data-userCode="${varName.userCode}">删除</a> --%>
									<a href="#this" id="deleteUser${varName.id}" data-userCode="${varName.userCode}" class="layui-btn layui-btn-danger layui-btn-xs" title="删除" style="color: #FFF;font-size: 12px;"><i class="layui-icon">&#xe640;</i>删除</a>&nbsp;
									<ehr:authorize ifAnyGranted="01">
										<%-- <a href="#this" id="passwordUser${varName.id}" data-userCode="${varName.userCode}">密码重置</a> --%>
										<a href="#this" id="passwordUser${varName.id}" data-userCode="${varName.userCode}" class="layui-btn layui-btn-warm layui-btn-xs" title="密码重置" style="color: #FFF;font-size: 12px;"><i class="layui-icon">&#xe669;</i>密码重置</a>
									</ehr:authorize>
								</c:otherwise>
							</c:choose>
						</td>
					</tr>
				</c:forEach>
				<!-- 分页加上后，样式有问题 -->
			<tr>
				<ehr:pagination action="userSearch.searchUser" colspan="7" />
			</tr>
		</tbody> 
	</table>
	<%--<ehr:paging />--%>
</div>

