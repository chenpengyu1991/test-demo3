<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/ehr-tag" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script src="${pageContext.request.contextPath}/js/views/cdm/standardization/phyExamination/view.js" type="text/javascript"></script>
<div id="cdm-phyexam-main" style="height: 450px;">
	<form id="cdm-person-phyexam-view-form">
		<div class="postcontent">
			<i class="popno">慢病体检</i>
			<div class="postdiv" >
				<jsp:include page="view_personPhyExam.jsp"></jsp:include>
			</div>
		</div>
	</form>
</div>
