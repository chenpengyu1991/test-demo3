<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr" %>

<script src="${pageContext.request.contextPath}/js/views/user/role.js" type="text/javascript"></script>

<form id="userRoleFormId">
	<input type="hidden" id="organCodeId" value="${orgCode}"/>
	<input type="hidden" id="role_index">
	<input type="hidden" id="row_index" value="${rowIndex}">
	<div>
		<table class="posttable" id="userRoleTableId">
			<tr>
				<td>
					<c:forEach var="role" items="${roles}" begin="0" end="${(line1-1)<0?0:(line1)-1}" varStatus="status">
						<label style="padding-right: 0px;">
							<c:if test="${status.index eq 0}">
								<input reg='{"required":"true"}' type="checkbox" name="roleCode" <c:if test="${role.hasRole==1}"> checked="checked" </c:if>
									   class="chk_selectone" value="${role.roleCode}" data="${role.name}" reg='{"required":"true"}'/> ${role.name}
							</c:if>
							<c:if test="${status.index ne 0}">
								<input type="checkbox" name="roleCode" <c:if test="${role.hasRole==1}"> checked="checked" </c:if>
									   class="chk_selectone" value="${role.roleCode}" data="${role.name}" reg='{"required":"true"}'/> ${role.name}
							</c:if>
							<br/>
						</label>
						<input type="hidden" id="roleName${role.roleCode}" value="${role.name}"/>
					</c:forEach>
				</td>
				<td>
					<c:forEach var="role" items="${roles}" begin="${line1}" end="${(line1 + line2 - 1)<0?0:(line1 + line2 - 1)}"  varStatus="status">
						<label style="padding-right: 0px;">
							<input type="checkbox" name="roleCode" <c:if test="${role.hasRole==1}"> checked="checked" </c:if>
								   class="chk_selectone" value="${role.roleCode}" data="${role.name}" reg='{"required":"true"}'/> ${role.name}<br/>
						</label>
						<input type="hidden" id="roleName${role.roleCode}" value="${role.name}"/>
					</c:forEach>
				</td>
				<td>
					<c:forEach var="role" items="${roles}"  begin="${line1 + line2}" end="${line1 + line2 + line3}"  varStatus="status">
						<label style="padding-right: 0px;">
							<input type="checkbox" name="roleCode" <c:if test="${role.hasRole==1}"> checked="checked" </c:if>
								   class="chk_selectone" value="${role.roleCode}" data="${role.name}" reg='{"required":"true"}'"/> ${role.name}<br/>
						</label>
						<input type="hidden" id="roleName${role.roleCode}" value="${role.name}"/>
					</c:forEach>
				</td>
			</tr>
		</table>
	</div>
	<div class="toolbarpop" style="padding: 0 0px 10px;">
		<button class="layui-btn layui-btn-sm" id="saveUserRoleBtn" ><i class="layui-icon"></i>保存</button>
		<button class="layui-btn layui-btn-sm" id="cancelContact"><i class="layui-icon"></i>取消</button>
	</div>
</form>


