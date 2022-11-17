<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<script src="${pageContext.request.contextPath}/js/views/question/add.js" type="text/javascript"></script>
	
<div class="postcontent">
	<form id="questionEditForm">
	<input type="hidden" name="id" value="${question.id}"/>
	<input type="hidden" id="fromHome" value="${fromHome}"/>
	<div class="postdiv searchSection x-admin-sm">
		<fieldset class="layui-elem-field">
			<table style="width:99%" class="posttable">
				<tr>
					<th style="width: 100px">
	                	<label class="required">关键词</label>
					</th>
					<td>
						<input type="text" name="keyWord" value="${question.keyWord}" reg='{"required":"true","maxlength":"50"}' class="x-layui-input" />
					</td>
					<th style="width: 100px"><label class="required">模块选项</label></th>
					<td><ehr:dic-list reg='{"required":"true"}' name="keyWordType" code="1,2,3,4,5,6,7,8,9,10,11,12" dicmeta="HE00032" value="${question.keyWordType}"></ehr:dic-list></td>
				</tr>
			</table>
		</fieldset>
	</div>
	
	<div class="postdiv">
		<fieldset class="layui-elem-field">
			<legend>
			<label class="required">内容</label>
			</legend>
			<textarea name="content" id="contentText" style="width: 850px;height: 280px;" reg='{"required":"true","maxlength":"4000"}' class="x-layui-input">${question.content}</textarea>
		</fieldset>
	</div>
	
	<p align="center">
		<button class="layui-btn layui-btn-sm"  id="saveButtonId" >保存</button>
		<%-- <input type="button" id="saveButtonId" name="save" value="保存" onclick="questionAdd.save()" class="btnopr"/> --%>
		<br>
	</p>
	</form>
</div>
