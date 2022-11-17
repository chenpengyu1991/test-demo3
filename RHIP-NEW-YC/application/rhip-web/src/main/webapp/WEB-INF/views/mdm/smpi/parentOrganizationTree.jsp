<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib  tagdir="/WEB-INF/tags" prefix="tag"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<style type='text/css'>
ul.ztree {margin-top: 10px;border: 1px solid #617775;background: #f0f6e4;width:500px;height:100%;overflow-y:scroll;overflow-x:auto;}
</style>
<script src="${pageContext.request.contextPath}/js/views/mdm/organizationArea/parentOrganizationTree.js" type="text/javascript"></script>
<div class="postcontent">
     <div class="zTreeDemoBackground left">
		<ul id="treeParent" class="ztree" style="min-width: 420px; width: 50%;"></ul>
	</div>
	<p style="margin-top: 15px;" align="center">
		<input type="button" id="sureButton" value="确定" class="btnopr" onclick="villageAdd.closePopUp('d2')"/> 
	</p>
</div>