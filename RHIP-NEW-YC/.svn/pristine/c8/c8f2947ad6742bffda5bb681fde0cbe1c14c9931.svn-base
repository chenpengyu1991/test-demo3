<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<link href="${pageContext.request.contextPath}/resources/css/global.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/resources/css/forms.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/resources/css/control.css" rel="stylesheet" type="text/css" />
<script src="${pageContext.request.contextPath}/resources/js/jquery/jquery-1.7.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/js/common.js" type="text/javascript"></script>



<script type="text/javascript">
	
	
	function allRoleSet(){
		
		if (!confirm("确认变更?")) return false;
		var roleId = "";
		var userId=$("input[name='userIds']").val();
		$("input[name='rolecheck']:checked").each(function(){
			
			roleId+=$(this).val()+",";
			
		});
		
		var path = "${pageContext.request.contextPath}/user/roleSet/"+"?roleIds="+roleId+"&userIds="+userId;
		window.location.href=path;
		
		
	}
	
</script>
	
	
<div class="section">
   	<div class="titlebar">
		<div class="title">角色统一设定</div>
		<div class="toobar">
		<img src="${pageContext.request.contextPath}/resources/images/btn/back.png"/><span  onclick="javascript:history.go(-1);">返回</span>		
		</div>
	</div>

    <table class="repeattable" >
    		
	
		<tr>
			<th style="width:30px">编号</th>
			<th>用户id</th>
			<th>用户名</th>
			<th>性别</th>
			<th>Email</th>
			<th>固定电话</th>
			<th>手机</th>
			<th>地址</th>
			<th>状态</th>
		
		</tr>
		<c:forEach  items="${collection}" var="varName">
		<tr>
			<td>${varName.id}</td>
			<td>${varName.userName}</td>
			<td>${varName.name}</td>
			<td>${varName.gender}</td>
			<td>${varName.email}</td>
			<td>${varName.telephone}</td>
			<td>${varName.mobile}</td>
			<td>${varName.homeAddress}</td>
			<td>${varName.status}</td>
			
		</tr>
		</c:forEach>
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
		<input type="button" value="提交" onclick="allRoleSet()">
		<input type="hidden" name="userIds" value="${userIds}"/>
       	
	
</div>