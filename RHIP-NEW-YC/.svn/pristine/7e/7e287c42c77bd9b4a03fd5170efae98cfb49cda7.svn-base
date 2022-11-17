<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
	
<div class="postcontent">
	<form id="bulletinEditForm">
	<div class="postdiv">
		<fieldset class="layui-elem-field">
			<table style="width:99%" class="posttable">
				<tr>
					<td style="font-size: 16px;font-weight: bold;text-align: center;">
						${bulletin.title}
					</td>
				</tr>
				<tr>
					<td style="text-align: center;">
						<fmt:formatDate value='${bulletin.submitTime}' pattern='yyyy年MM月dd日'/>
					</td>
				</tr>
			</table>
		</fieldset>
	</div>
	
	<div class="postdiv">
		<fieldset class="layui-elem-field">
			<textarea style="width: 850px;height: 280px;border: none;overflow: auto;">${bulletin.content}</textarea>
		</fieldset>
	</div>
	</form>
</div>
