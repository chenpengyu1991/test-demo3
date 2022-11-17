<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<link href="${pageContext.request.contextPath}/resources/css/global.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/resources/css/forms.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/resources/css/control.css" rel="stylesheet" type="text/css" />
<script src="${pageContext.request.contextPath}/resources/js/jquery/jquery-1.7.js" type="text/javascript"></script> 
<script src="${pageContext.request.contextPath}/resources/js/common.js" type="text/javascript"></script>

<script type="text/javascript">	
	$(window.parent.document).ready(function() {          
		$(window.parent.document)[0].title = 'IDS-动态查询';       
	});
</script>

<div class="section">
    <div class="titlebar">
        <div class="title"></div>
        <div class="toobar"></div>
    </div>
	<table class="repeattable">
		<tr>
			<c:forEach var="varName" items="${colums}">
			<th>${varName}</th>
			</c:forEach>
		</tr>
		<c:forEach var="varName" items="${values}">
		<tr>
			<c:forEach begin="0" end="${length}" var="i">
			<td>${varName[i]}</td>
			</c:forEach>
		</tr>
		</c:forEach>
        <tr>
            <td colspan="4" class="pagination" >
	            <p class="left">共10条记录！</p>
	            <p class="right">第1页/共1页 &nbsp;
		            <a href="#"><img src="${pageContext.request.contextPath}/resources/images/btn/page_01.gif" />首页</a> &nbsp; 
		            <a href="#"><img src="${pageContext.request.contextPath}/resources/images/btn/page_02.gif" />上一页</a> &nbsp;&nbsp;1&nbsp;&nbsp; 
		            <a href="#">下一页<img src="${pageContext.request.contextPath}/resources/images/btn/page_03.gif" /></a> &nbsp; 
		            <a href="#"> 尾页<img src="${pageContext.request.contextPath}/resources/images/btn/page_04.gif" /></a> &nbsp;
	              	<input type="text" class="input_page"/><b>&nbsp;GO</b>
	            </p>
            </td>
        </tr>
	</table>
</div>