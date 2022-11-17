<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<script type="text/javascript">
	$(function() {
		var option = {
			currentPage : ${page.currentPage},
			totalPages : ${page.totalPages},
			totalRows : ${page.totalRows},
			pageSize : ${page.pageSize},
			contextPath:contextPath,
			callback:search
		};
		$("#pagination").pagination(option);
	});
</script>
<tiles:insertAttribute name="list" />
<div id="pagination"></div>
