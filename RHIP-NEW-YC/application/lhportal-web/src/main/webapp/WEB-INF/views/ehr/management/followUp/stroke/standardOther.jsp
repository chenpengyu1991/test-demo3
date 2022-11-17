<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<form id="dm-followup-stroke-standard-other-from" class="dm-followup-from">
<input type="hidden"  name="id" value="${strtum.id}"  >
	<input type="hidden" name="planId" value="${strtum.planId}"> 
	<input type="hidden" name="followupFlag" value="${strtum.followupFlag}" />
	<input type="hidden"  name="diseaseType" value="3" />
	<c:set var="input" value="${strtum}" scope="request"></c:set>
	<div class="postcontent">
		<div class="postdiv">
			<fieldset>
				<legend>脑卒中规范化随访</legend>
				<jsp:include page="../common/followupWay.jsp"></jsp:include>
				<jsp:include page="../common/physiologicalOther.jsp"></jsp:include>
				<jsp:include page="../common/newestStatus.jsp"></jsp:include>
				<jsp:include page="../common/druguse.jsp"></jsp:include>
				<jsp:include page="../common/education.jsp"></jsp:include>
				<jsp:include page="../common/result.jsp"></jsp:include>
				<jsp:include page="../common/StroCorInputInfo.jsp"></jsp:include>
			</fieldset>
		</div>
	</div>
</form>
