<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<form id="dm-followup-coronary-normal-from" class="dm-followup-from">
<input type="hidden"  name="id" value="${strtum.id}"  >
	<input type="hidden" name="planId" value="${strtum.planId}"> <input type="hidden" name="followupFlag" value="${strtum.followupFlag}" /> <input
		type="hidden" name="diseaseType" value="4"
	/>
	<c:set var="input" value="${strtum}" scope="request"></c:set>
	<div class="postcontent">
		<div class="postdiv">
			<fieldset>
				<legend>冠心病常规随访</legend>
				<jsp:include page="../common/normal.jsp"></jsp:include>
			</fieldset>
		</div>
	</div>
</form>