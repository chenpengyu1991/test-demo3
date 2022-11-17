<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<form id="dm-followup-stroke-normal-from" class="dm-followup-from">
<c:set var="input" value="${strtum}" scope="request"></c:set>
<input type="hidden"  name="id" value="${strtum.id}"  >
<input type="hidden"  name="planId" value="${strtum.planId}"  >
	<input type="hidden"  name="followupFlag" value="${strtum.followupFlag}" />
	<input type="hidden"  name="diseaseType" value="3" />
	<div class="postcontent">
		<div class="postdiv">
			<fieldset>
				<legend>脑卒中常规随访</legend>
				<jsp:include page="../common/normal.jsp"></jsp:include>
			</fieldset>
		</div>
	</div>
</form>