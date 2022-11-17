<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/ehr-tag" prefix="ehr"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script src="${pageContext.request.contextPath}/js/views/ehr/medicalService/inpatient/search.js" type="text/javascript"></script>


	<div>
		<div>
			<form id="inpatient-search-from" action="<c:url value="/inpatient/index"  />">
				<div align="right" >
					<label><input class="inpatient-search-btn" type="radio" value="1" name="timeType" checked="checked"/>最近三个月</label>
					<label><input class="inpatient-search-btn" name="timeType" value="2" type="radio" />最近一年</label>
					<label><input class="inpatient-search-btn" name="timeType" value="3" type="radio" />全部</label>
				</div>
			</form>
		</div>
		<div id="inpatient-result-content">
		</div>
		

	</div>
