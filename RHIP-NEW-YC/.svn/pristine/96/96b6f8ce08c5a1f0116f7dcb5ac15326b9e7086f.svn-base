<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib  tagdir="/WEB-INF/tags" prefix="tag"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<%--<script src="${pageContext.request.contextPath}/js/views/integration/emailconfig.js" type="text/javascript"></script>--%>
<script type="text/javascript">
	require(['views/integration/emailconfig'],function(emailconfig){
		emailconfig.load();
	});
</script>
<div class="postcontent">
<form id="emailConfigForm">
	<fieldset>
	<legend>邮件服务器设置</legend>
	<div class="postdiv">
		<table class="formtable">
			<colgroup>
				<col style="width:15%;"/>
				<col style="width:35%;"/>
				<col style="width:15%;"/>
				<col style="width:35%;"/>				
			</colgroup>
			<tr>
				<th><label class="required" title="用来发送系统提醒邮件">SMTP地址:</label></th>
				<td>
					<input type="text" name="smtpAddress" value ='${emailConfig.smtpAddress}' reg='{"required":"true","maxlength":50}' style="width:180px;"/>
				</td>
				<th><label class="required" title="用来发送系统提醒邮件">邮箱用户名:</label></th>
				<td>
					<input type="text" name="emailUserName" value ='${emailConfig.emailUserName }' reg='{"required":"true","maxlength":50}' style="width:180px;"/>
				</td>				
			</tr>				
			<tr>
				<th><label class="required" title="用来发送系统提醒邮件">邮箱密码:</label></th>
				<td>
					<input type="text" name="emailPassword" value ='${emailConfig.emailPassword}' reg='{"required":"true","maxlength":50}' style="width:180px;"/>
				</td>
				<th><label class="required" title="用来发送系统提醒邮件">发件人地址:</label></th>
				<td>
					<input type="text" name="emailFrom" value ='${emailConfig.emailFrom}' reg='{"required":"true","email":"true"}' style="width:180px;"/>
				</td>				
			</tr>	
			<tr>
				<th><label class="required" title="用来发送系统提醒邮件">发件人姓名:</label></th>
				<td colspan="3">
					<input type="text" name="emailFromName" value ='${emailConfig.emailFromName}' reg='{"required":"true","maxlength":50}' style="width:180px;"/>
				</td>
			</tr>																					
		</table>
	</div>
</fieldset>
<fieldset>
	<legend>邮件设置</legend>
	<div class="postdiv">
		<table class="formtable">
			<colgroup>
				<col style="width:15%;"/>
				<col style="width:85%;"/>
			</colgroup>
			<tr>
				<th><label class="required">监控天数:</label></th>
				<td>
					<input type="text" name="monitorDays" value ='${emailConfig.monitorDays}' reg='{"required":"true","digits":"true","min":1,"max":30}' style="width:150px;"/>
				</td>
			</tr>				
			<tr>
				<th><label class="required">邮件称谓:</label></th>
				<td>
					<input type="text" name="emailName" value ='${emailConfig.emailName}' reg='{"required":"true","maxlength":50}' />
				</td>
			</tr>
			<tr>
				<th><label class="required">邮件标题:</label></th>
				<td>
					<input type="text" name="emailTitle" value ='${emailConfig.emailTitle}' reg='{"required":"true","maxlength":50}' />
				</td>
			</tr>																
		</table>
	</div>
</fieldset>	
<fieldset>
	<legend>收件人设置</legend>
	<div class="postdiv">
		<table class="formtable">
			<colgroup>
				<col style="width:15%;"/>
				<col style="width:35%;"/>
				<col style="width:15%;"/>
				<col style="width:35%;"/>
			</colgroup>
			<tr>
				<th><label class="required">收件人邮箱:</label></th>
				<td>
					<input type="text" name="emailTo" value ='${emailConfig.emailTo}' reg='{"required":"true","email":"true"}' style="width:180px;"/>
				</td>
				<th>收件人邮箱:</th>
				<td>
					<input type="text" name="emailTo1" value ='${emailConfig.emailTo1}' reg='{"email":"true"}' style="width:180px;"/>
				</td>				
			</tr>
			<tr>
				<th>收件人邮箱:</th>
				<td>
					<input type="text" name="emailTo2" value ='${emailConfig.emailTo2}' reg='{"email":"true"}' style="width:180px;"/>
				</td>
				<th>收件人邮箱:</th>
				<td>
					<input type="text" name="emailTo3" value ='${emailConfig.emailTo3}' reg='{"email":"true"}' style="width:180px;"/>
				</td>				
			</tr>
			<tr>
				<th>收件人邮箱:</th>
				<td>
					<input type="text" name="emailTo4" value ='${emailConfig.emailTo4}' reg='{"email":"true"}' style="width:180px;"/>
				</td>
				<th>收件人邮箱:</th>
				<td>
					<input type="text" name="emailTo5" value ='${emailConfig.emailTo5}' reg='{"email":"true"}' style="width:180px;"/>
				</td>				
			</tr>
			<tr>
				<th>收件人邮箱:</th>
				<td>
					<input type="text" name="emailTo6" value ='${emailConfig.emailTo6}' reg='{"email":"true"}' style="width:180px;"/>
				</td>
				<th>收件人邮箱:</th>
				<td>
					<input type="text" name="emailTo7" value ='${emailConfig.emailTo7}' reg='{"email":"true"}' style="width:180px;"/>
				</td>				
			</tr>
			<tr>
				<th>收件人邮箱:</th>
				<td>
					<input type="text" name="emailTo8" value ='${emailConfig.emailTo8}' reg='{"email":"true"}' style="width:180px;"/>
				</td>
				<th>收件人邮箱:</th>
				<td>
					<input type="text" name="emailTo9" value ='${emailConfig.emailTo9}' reg='{"email":"true"}' style="width:180px;"/>
				</td>				
			</tr>
		</table>
	</div>
</fieldset>	
</form>

	<div class="toolbarpop">
		<input type="button" id="save_config" value="保存" >
	</div>
</div>
