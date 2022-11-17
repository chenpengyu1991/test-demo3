<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<div class="content">
	<div class="titlebar" style="margin-top: 10px;">
		<div class="title">人员职业信息</div>
		<div class="toobar"></div>
	</div>
	<table class="formtable">
		<tiles:insertAttribute name="staffCareerInfo"/>
	</table>
	<tiles:insertAttribute name="staffBasicInfo"/>
</div>