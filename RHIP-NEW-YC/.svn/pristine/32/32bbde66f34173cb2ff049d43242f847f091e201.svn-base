<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<script src="${pageContext.request.contextPath}/js/views/question/answer.js" type="text/javascript"></script>
	
<div class="postcontent">
	<input type="hidden" name="id" value="${question.id}"/>
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
			<%--	<tr>
					<th style="width: 100px">
	                	提问者
					</th>
					<td>
						<ehr:user userCode="${question.submitor}"/>
					</td>
				</tr>--%>
			</table>
		</fieldset>
	</div>
	
	<div class="postdiv">
		<fieldset class="layui-elem-field">
			<legend>内容</legend>
			<textarea style="width: 870px;height: 80px;border: none;overflow: auto;">${question.content}</textarea>
		</fieldset>
	</div>
	<div class="postdiv">
		<fieldset class="layui-elem-field">
			<table style="width:99%" class="posttable">
				<tr>
					<th style="width: 100px">
	                	解答人
					</th>
					<td>
						<ehr:user userCode="${question.answer}"></ehr:user>
					</td>
					<th style="width: 100px">
	                	解答时间
					</th>
					<td>
						<fmt:formatDate value='${question.answerTime}' pattern='yyyy/MM/dd'/>
					</td>
				</tr>
			</table>
		</fieldset>
	</div>
	<div class="postdiv">
		<fieldset class="layui-elem-field">
			<legend>解答</legend>
			<textarea style="width: 870px;height: 80px;border: none;overflow: auto;">${question.answerContent}</textarea>
		</fieldset>
	</div>
</div>
