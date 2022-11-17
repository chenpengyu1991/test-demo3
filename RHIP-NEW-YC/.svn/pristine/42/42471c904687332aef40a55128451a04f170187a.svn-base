<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>

<!-- <script type="text/javascript">
	 require(['views/bulletin/add'],function(bulletinAdd){
		 bulletinAdd.load();
	 });
</script> -->
<script src="${pageContext.request.contextPath}/js/views/bulletin/add2.js" type="text/javascript"></script>
	
<div class="postcontent">
	<form id="bulletinEditForm">
	<input type="hidden" name="id" value="${bulletin.id}"/>
	<div class="postdiv searchSection x-admin-sm">
		<fieldset class="layui-elem-field">
			<table style="width:99%" class="posttable contentItem">
				<tr>
					<th style="width: 100px">
	                	<label class="required">标题</label>
					</th>
					<td>
						<input type="text" name="title" value="${bulletin.title}" reg='{"required":"true","maxlength":"50"}' class="x-layui-input" />
					</td>
					<th>
						<label class="required">是否显示</label>
                   	</th>
                   	<td>
                   		<c:choose>
                   			<c:when test="${empty bulletin}">
                   				<c:set var="isdelete" value="0"></c:set>
                   			</c:when>
                   			<c:when test="${not empty bulletin && bulletin.isDelete != 0}">
                   				<c:set var="isdelete" value="1"></c:set>
                   			</c:when>
                   			<c:otherwise>
                   				<c:set var="isdelete" value="0"></c:set>
                   			</c:otherwise>
                   		</c:choose>
                   		<div class="searchArea">
                   			<div class="layui-form">
                   			<div class="layui-form-item">
                   				<div class="layui-input-block" style="margin-left: 0px;">
									<input name="isDelete" type="radio" value="0" ${isdelete eq '0' ? 'checked' : ''}/> 是
									<input name="isDelete" type="radio" value="1" ${isdelete eq '1' ? 'checked' : ''}/> 否
                   				</div>
                   			</div>
                   			</div>
                   		</div>
					</td>
				</tr>
			</table>
		</fieldset>
	</div>
	
	<div class="postdiv">
		<fieldset class="layui-elem-field">
			<legend><label class="required">内容</label></legend>
			<textarea name="content" id="contentText" style="width: 870px;height: 280px;" reg='{"required":"true","maxlength":"4000"}' class="x-layui-input" >${bulletin.content}</textarea>
		</fieldset>
	</div>
	
	<p align="center">
		<!-- <input type="button" id="saveBulletinButtonId" name="save" value="保存"  class="btnopr"/> -->
		<button class="layui-btn layui-btn-sm"  id="saveBulletinButtonId">保存</button>
	</p>
	</form>
</div>
<script type="text/javascript">
layui.use('form', function() {
	  var form = layui.form;
	form.render();
	});
</script>