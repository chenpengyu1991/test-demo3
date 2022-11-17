<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<div class="Menubox">
	<ul id="coronaryTags">
		<li id="coronary1" onclick="setTab('coronary',1,2)" class="hover">常规管理</li>
		<li id="coronary2" onclick="setTab('coronary',2,2)">规范化管理</li>
	</ul>
</div>
<div  style="width: 100%;text-align: left" class="contentbox">
	<div id="con_coronary_1">
		<jsp:include page="normal.jsp"></jsp:include>
	</div>
	<div id="con_coronary_2" style="display: none">
		<jsp:include page="standard.jsp"></jsp:include>
	</div>
</div>