<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<jsp:include page="../layouts/load-js-css-resources.jsp"></jsp:include>




<script src="${pageContext.request.contextPath}/js/views/user/updateSelf.js" type="text/javascript"></script>

<div class="postcontent">
	<form id="userSelfId" name="userForm" action="" method="post">
		<input name="userCode" id="userCode" type="hidden" value="${user.userCode}"/>
		<div class="postdiv" >
			<fieldset class="layui-elem-field">
				<legend>联系方式</legend>
				<table class="posttable">
					<colgroup>
						<col style="width:40%;"/>
				        <col style="width:60%;"/>
					</colgroup>
					<tr>
						<th>用户名</th>
						<td>
	                       ${user.userName}
	                    </td>
					</tr>
					<tr>
						<th>姓名</th>
						<td>
	                        ${user.name}
	                    </td>
					</tr>
					<tr>
						<th>身份证</th>
						<td>
	                        ${user.identityCard}
	                    </td>
					</tr>
					<tr>
						<th>电子邮件</th>
						<td>
	                        <input type="text" id="email" name="email" value="${user.email}" reg='{"maxlength":"30","regex":"email"}' class="x-layui-input"/>
	                    </td>
					</tr>
                    <tr>
                        <th>固定电话</th>
                        <td>
                            <input type="text" id="telephone" name="telephone" reg='{"maxlength":"20","regex":"phone"}' value="${user.telephone}"  class="x-layui-input"/>&nbsp;
                        </td>
                    </tr>
                    <tr>
                        <th>手机</th>
                        <td>
                            <input type="text" id="mobile" name="mobile" reg='{"maxlength":"20","regex":"mobile"}'  value="${user.mobile}"  class="x-layui-input"/>
                        </td>
                    </tr>
				</table>
			</fieldset>
		</div>
		
		<p align="center">
			<!-- <input type="button" id="saveUserSelfButId" name="save" value="保存" class="btnopr"/> &nbsp; -->
			<button class="layui-btn layui-btn-sm"  id="saveUserSelfButId">保存</button>
			<br>
		</p>
		<input type="hidden" id="password" name="password"/>
	</form>
</div>
