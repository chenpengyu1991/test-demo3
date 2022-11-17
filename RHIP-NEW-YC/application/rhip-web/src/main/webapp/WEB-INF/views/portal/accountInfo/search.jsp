<%@ page language="java" contentType="text/html; charset=UTF-8"
	     pageEncoding="UTF-8"%>
<%@ taglib prefix="ehr" uri="/ehr-tag"%>
<script type="text/javascript">
	 require(['views/portal/accountInfo/search'],function(accountInfoSearch){
		 accountInfoSearch.load();
	 });
</script>
<div id="top_allLink">
	<div class="section">
		<form method="post" id="form_search">
			<div class="searchbox" id="searchTable">
				<table id="accountInfoSearchTable">
					<colgroup>
						<col style="width: 10%;" />
						<col style="width: 23%;" />
						<col style="width: 10%;" />
						<col style="width: 23%;" />
						<col style="width: 10%;" />
					</colgroup>
					<tbody>
						<tr>
							<td class="coltext">账户名:</td>
							<td class="colinput"><input type="text" name="accountName"></td>
							<td class="coltext">身份证号:</td>
							<td class="colinput"><input type="text" name="cardNo"></td>
							<td class="coltext">用户状态:</td>
							<td class="colinput">
								<ehr:dic-list id="status" dicmeta="LH00006" name="status" reg="{'required':true}" />
							</td>
						</tr>
						<tr>
							<td class="coltext">预约状态:</td>
							<td class="colinput">
								<ehr:dic-list id="status" dicmeta="LH00006" name="status" reg="{'required':true}" />
							</td>
							<td></td>
							<td></td>
							<td></td>
							<td>
							    <input id="accountInfoSearchBut" class="search_btn" type="button" value="查询" style="float: left" />
							</td>
						</tr>
					</tbody>
				</table>
				<table>
					<tr>
						<td colspan="6" class="colbottom">
						    <span onclick="toggle(this,'accountInfoSearchTable')" class="ico-bottom">&nbsp;</span>
						</td>
					</tr>
				</table>
			</div>
		</form>
		<div id="accountInfo_records"></div>
	</div>
</div>
<div id="accountInfoDetails"></div>


