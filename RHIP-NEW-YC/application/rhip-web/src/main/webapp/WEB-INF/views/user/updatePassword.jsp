<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<jsp:include page="../layouts/load-js-css-resources.jsp"></jsp:include>

<script src="${pageContext.request.contextPath}/js/views/user/updateSelf.js" type="text/javascript"></script>

<div class="postcontent">
	<form id="userPasswordId" name="userForm" action="" method="post">
		<input name="userCode" id="userCode" type="hidden" value="${user.userCode}"/>
		<div class="postdiv" >
			<fieldset class="layui-elem-field">
				<legend>信息确认</legend>
				<table class="posttable" >
					<colgroup>
						<col style="width:40%;"/>
				        <col style="width:60%;"/>
					</colgroup>
					<tr>
						<th>旧密码</th>
						<td>
	                       <input type="password" name="oldPassword"  class="x-layui-input" />
	                    </td>
					</tr>
					<tr>
						<th>新密码</th>
						<td>
	                         <input type="password" name="newPassword"  class="x-layui-input" reg='{"regex":"passWordReg"}'/>
	                    </td>
					</tr>
					<tr>
						<th>确认密码</th>
						<td>
	                         <input type="password" name="newPassword2" class="x-layui-input" />
	                    </td>
					</tr>
				</table>
			</fieldset>
		</div>
		
		<p align="center">
			<!-- <input type="button" id="savePasButId" name="save" value="保存" class="btnopr"/> -->
			<button class="layui-btn layui-btn-sm"  id="savePasButId">保存</button>
			<br>
		</p>
		<input type="hidden" id="password" name="password"/>
	</form>
</div>
