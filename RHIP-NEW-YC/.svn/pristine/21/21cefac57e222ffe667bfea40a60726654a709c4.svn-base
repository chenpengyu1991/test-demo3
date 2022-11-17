<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<script src="${pageContext.request.contextPath}/js/views/question/answer.js" type="text/javascript"></script>
	
<div class="postcontent">
	<form id="questionAnswerForm">
	<input type="hidden" name="id" value="${question.id}"/>
	<input type="hidden" id="fromHome" value="${fromHome}"/>
	<div class="postdiv">
		<fieldset class="layui-elem-field">
			<table style="width:99%" class="posttable">
				<tr>
					<th style="width: 100px">
	                	<label class="required">关键词</label>
					</th>
					<td colspan="3">
						${question.keyWord}
					</td>
				</tr>
				<tr>
					<th style="width: 100px">
	                	提问人
					</th>
					<td>
						<ehr:user userCode="${question.submitor}"></ehr:user>
					</td>
					<th style="width: 100px">
	                	提问时间
					</th>
					<td>
						<fmt:formatDate value='${question.submitTime}' pattern='yyyy/MM/dd'/>
					</td>
				</tr>
				<%--<tr>
					<th style="width: 100px">
	                	提问者
					</th>
					<td>
						<ehr:user userCode="${question.submitor}" />
					</td>
				</tr>--%>
			</table>
		</fieldset>
	</div>
	
	<div class="postdiv">
		<fieldset class="layui-elem-field">
			<legend>内容</legend>
			<textarea style="width: 870px;height: 100px;border: none;overflow: auto;" class="x-layui-input" >${question.content}</textarea>
		</fieldset>
	</div>
	
	<div class="postdiv">
		<fieldset class="layui-elem-field">
			<legend>
				<label class="required">解答</label>
			</legend>
			<textarea name="answerContent" id="answerContent" style="width: 870px;height: 100px;" reg='{"required":"true","maxlength":"4000"}' class="x-layui-input" >${question.answerContent}</textarea>
		</fieldset>
	</div>
	
	<p align="center">
		<!-- <input type="button" id="saveButtonId" name="save" value="保存" onclick="questionAnswer.save()" class="btnopr"/> -->
		<button class="layui-btn layui-btn-sm"  id="saveButtonId" >保存</button>
		<br>
	</p>
	</form>
</div>
