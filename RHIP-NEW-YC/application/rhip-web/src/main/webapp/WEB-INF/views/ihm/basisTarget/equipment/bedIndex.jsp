<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<script>
	$(function(){
		$("#bedReturn").click(function() {
			$('#bedMain').show();
			$('#detail').hide();
		});

	});
</script>
<b class="jiandang">床位资源<a href="javascript:void(0)" style="margin-top: 3px;" class="view" id = "bedReturn"><button style="background-color: #C0C0C0;" class="btn-gray layui-btn layui-btn-xs button"><i class="layui-icon">&#xe65c;</i>返回</button></a></b>
<jsp:include page="../../searchByOrg.jsp"/>