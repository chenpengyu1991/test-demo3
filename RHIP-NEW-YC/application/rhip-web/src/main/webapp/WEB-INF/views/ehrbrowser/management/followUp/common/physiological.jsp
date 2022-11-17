<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<fieldset class="layui-elem-field">
	<legend>生理生化指标</legend>
	<table class="posttable">
		<colgroup>
			<col style="min-width: 100px; width: 30%" />
			<col style="min-width: 150px; width: 70%" />
		</colgroup>
		<jsp:include page="../common/bp.jsp"></jsp:include>
	</table>
</fieldset>