<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 
<%@ include file="../layouts/base.jsp"%>

 

<script type="text/javascript">
	$(window.parent.document).ready(function() {
		$(window.parent.document)[0].title = 'IDS-创建用户';
		
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
	
	function checkUserName(){
		
		$("#checkName").load("${pageContext.request.contextPath}/user/check",$("#userName").serialize());
	
	}
	
</script>
	

<div class="section">
	<div class="titlebar">
		<div class="title">新增用户</div>
		<div class="toobar">
		<img src="${pageContext.request.contextPath}/resources/images/btn/back.png"/><span  onclick="javascript:history.go(-1);">返回</span>		
		</div>
	</div>	
	<form id="userFormId" name="userForm" action="" method="post">
		<table class="formtable">
			<tr>
				<th style="width: 200px">用户名</th>				
				<td style="width: 500px"><input type="text" id="userName" name="userName"  onblur="checkUserName()"/>
				<span id="checkName"></span>
				</td>
				<th style="width: 200px">姓名</th>				
				<td style="width: 500px"><input type="text" id="name" name="name" />
				</td>
				<th style="width: 200px">性别</th>				
				<td style="width: 500px"><select  id="gender" name="gender" >
				<option value="1">男</option>
				<option value="0">女</option>
				</select>
				</td>
			</tr>
			
			<tr>
				<th style="width: 200px">生日</th>				
				<td><input type="text" id="birth" name="birth" onClick="WdatePicker()" class="Wdate" />
				</td>
				<th style="width: 200px">身份证</th>				
				<td><input type="text" id="identityCard" name="identityCard" />
				</td>
				<th style="width: 200px">email</th>				
				<td><input type="text" id="email" name="email" />
				</td>
				
			</tr>
			
			<tr>
				<th style="width: 200px">固定电话</th>				
				<td><input type="text" id="telephone" name="telephone" />
				</td>
				<th style="width: 200px">手机</th>				
				<td><input type="text" id="mobile" name="mobile" />
				</td>
				<th style="width: 200px">家庭住址</th>				
				<td><input type="text" id="homeAddress" name="homeAddress" />
				</td>
				
			</tr>
			
			<tr>
				<th style="width: 200px">用户描述</th>				
				<td><textarea id="description" name="description" ></textarea>
				</td>
				<th style="width: 200px">是否可用</th>				
				<td><input type="radio" name="status" value="1" checked="checked" style="width: 20px;" />是 <input type="radio" name="status" value="0" style="width: 20px;" />否</td>
				<td></td>
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
					<input type="checkbox" name="rolecheck" class="chk_selectone" value="${role.id}"/>
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
		<input type="hidden" name="roleIds" id="rolecheckAll">
		<input type="hidden" id="password" name="password"/>

</form>
	${message}

</div>
