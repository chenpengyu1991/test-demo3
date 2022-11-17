<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<script type="text/javascript">

$(function() {
	showLogs(1);
});

	
	
	function showLogs(indexPage) {
		
		var searchObj = {
				url : "/mdmOrganization/showLogs",
				insertDiv : "orgLogListDivId",
				param : {
					indexPage : indexPage,
					organId : $("#organId").val()
				}
			};
			$.loadHtmlByUrl(searchObj);
	}
	
</script>
<div id="orgLogListDivId">
</div>
<input type="hidden" id="organId" value="${organId}" />
