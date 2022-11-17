<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="ehr" uri="/WEB-INF/tld/ehr-tag.tld"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>

<script type="text/javascript">
	 require(['views/portal/sms/search'],function(smsSearch){
		 smsSearch.load();
	 });
</script>
<div id="top_allLink">
<div class="section">
	<form method="post" id="sms_form_search">
		<div class="searchbox" id="searchTable">
			<table id="smsSearchTable">
				<colgroup>
					<col style="width: 10%;" />
					<col style="width: 23%;" />
					<col style="width: 10%;" />
					<col style="width: 23%;" />
					<col style="width: 10%;" />
				</colgroup>
				<tbody>
					<tr>
						<td class="coltext">姓名:</td>
						<td class="colinput"><input type="text" name="name"></td>
						<td class="coltext">手机号:</td>
						<td class="colinput"><input type="text" name="phoneNumber"></td>
					</tr>
					<tr>
						<td class="coltext">短信类别:</td>
						<td class="colinput"><input type="text" name="type"></td>
						<td class="coltext">发送时间:</td>
						<td class="colinput">
							<tag:dateInput name="createTimeBegin" id="createTimeBegin" style="width:35%;" ></tag:dateInput>~
							<tag:dateInput name="createTimeEnd" id="createTimeEnd"  style="width:35%;"></tag:dateInput>
						</td>						</td>
						<td>
							<input id="smsSearchBtn" class="search_btn" type="button" value="查询" style="float: left" />
						</td>
					</tr>
				</tbody>
			</table>
			<table>
				<tr>
					<td colspan="6" class="colbottom">
					    <span id="smsSearchTableSpanId" class="ico-bottom">&nbsp;</span>
					</td>
				</tr>
			</table>
		</div>
	</form>
	<div id="sms_list"></div>
</div>
</div>
<div id="sms_detail"></div>


