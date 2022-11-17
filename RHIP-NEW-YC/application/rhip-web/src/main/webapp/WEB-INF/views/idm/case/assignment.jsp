<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%--<script src="${pageContext.request.contextPath}/js/views/idm/case/search.js" type="text/javascript"></script>--%>
 <script src="${pageContext.request.contextPath}/js/views/idm/case/assignment.js" type="text/javascript"></script>

<div>
	<div class="toolbar">
	 <a href="javascript:void(0)" id="save"><button class="layui-btn layui-btn-sm button"><i class="layui-icon"></i>保存</button></a>
	</div>
	<form id="assignForm">
		<div class="postcontent">
			<input type="hidden" name="id" value="${id}"/>
			<table class="posttable" style="margin-top:50px;">
				<colgroup>
					<col style="width: 30%;"/>
					<col style="width: 70%;"/>
				</colgroup>
					<tr>
						<th><label class="required">分配至：</label></th>
						<td>
							<ehr:org-type-list name="assignedToUnit" code="${statusInfo.assignedToUnit}" width="250px;" /> 
						</td>
					</tr>
			</table>
		</div>
	</form>
</div>