<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ include file="../layouts/base.jsp"%>

<script type="text/javascript">
	$(window.parent.document).ready(function() {
		$(window.parent.document)[0].title = 'IDS-用户修改';
	});
	
	$(function() {
		$("#birth").ligerDateEditor({
			showTime : false,
			label : '',
			labelWidth : 100,
			labelAlign : 'left'
		});
		
	});
	

	function saveUser() {
		var roleIds = "";
		$("input[name='rolecheck']:checked").each(function(){
			
			roleIds+=$(this).val()+",";
			
		});
		
		$("#rolecheckAll").val(roleIds);
		
		var form = document.getElementById('userFormId');
		form.action = "${pageContext.request.contextPath}/user/save";
		form.submit();
	}
	

	
</script>

<div class="section">
	<div class="titlebar">
		<div class="title">用户管理</div>
		<div class="toobar">
		<img src="${pageContext.request.contextPath}/resources/images/btn/back.png"/><span  onclick="javascript:history.go(-1);">返回</span>		
		</div>
	</div>
	
	<form id="userFormId" name="userForm" action="" method="post">
		<table class=formtable>
			<tr>
				<th style="width: 200px">用户名</th>				
				<td style="width: 500px">${user.userName} <input type="hidden" id="userNameId" name="userName" value="${user.userName}"/>
				</td>
				<th style="width: 200px">姓名</th>				
				<td style="width: 500px"><input type="text" id="name" name="name" value="${user.name}"/>
				</td>
				<th style="width: 200px">性别</th>				
				<td style="width: 500px">
				<select id="gender" name="gender" >
					<option value=""></option>
					<option value="1" 
					<c:if test="${user.gender==1}"> selected="selected" </c:if> > 男</option>
					<option value="0" 
					<c:if test="${user.gender==0}"> selected="selected" </c:if> > 女</option>
				</select>
				</td>
				
			</tr>
			
			<tr>
				<th style="width: 200px">生日</th>				
				<td><input type="text" id="birth" name="birth" value="<fmt:formatDate value='${user.birthDate}' pattern='yyyy-MM-dd'/>"  onfocus="WdatePicker()" class="Wdate" />
				</td>
				<th style="width: 200px">身份证</th>				
				<td><input type="text" id="identityCard" name="identityCard" value="${user.identityCard}"/>
				</td>
				<th style="width: 200px">email</th>				
				<td><input type="text" id="email" name="email" value="${user.email}"/>
				</td>
				
			</tr>
			
			<tr>
				<th style="width: 200px">固定电话</th>				
				<td><input type="text" id="telephone" name="telephone" value="${user.telephone}"/>
				</td>
				<th style="width: 200px">手机</th>				
				<td><input type="text" id="mobile" name="mobile" value="${user.mobile}"/>
				</td>
				<th style="width: 200px">家庭住址</th>				
				<td><input type="text" id="homeAddress" name="homeAddress" value="${user.homeAddress}"/>
				</td>
				
			</tr>
			
			<tr>
				<th style="width: 200px">用户描述</th>				
				<td><input type="text" id="description" name="description" value="${user.description}"/>
				</td>
				<th style="width: 200px">是否可用</th>				
				<td><input type="radio" name="status" value="1" <c:if test="${user.status==1}"> checked="checked" </c:if> style="width: 20px;" />是 <input type="radio" name="status" value="0" <c:if test="${user.status!=1}"> checked="checked" </c:if> style="width: 20px;" />否</td>
				<th></th>
				<td></td>
				
			</tr>
		</table>
		
		<div class="titlebar">
		<div class="title">角色设定:</div>
		</div>
		<table border="1">
		<c:forEach var="role"  items="${roles}" varStatus="status">
			<c:if test="${status.index % columnSize == 0}"><%="<tr>"%></c:if>
			
					<td>
					<input type="checkbox" name="rolecheck" class="chk_selectone" value="${role.id}"
					<c:forEach items="${usedRoles}" var="usedRole">
					<c:if test="${role.id eq usedRole.id}">
					checked="checked"
					</c:if>
					</c:forEach>
					/>
					${role.name}
					</td>
					  
			
		</c:forEach> 
		
		<c:if test="${fn:length(roles) % 5 != 0}">
			<c:forEach begin="1" end="${columnSize-(fn:length(roles) % columnSize)}" step="1"><td></td></c:forEach>
		</c:if>
		
		</table>
		<br>
		<br>
		<input type="button" id="saveButtonId" name="save" value="保存"	onclick="saveUser()" class="button" />
		<input type="hidden" id="id" name="id" value="${user.id}"/>
		<input type="hidden" name="roleIds" id="rolecheckAll">
		<input type="hidden" id="password" name="password" value="${user.password}"/>
		
</form>
	${message}

</div>
