<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="ehr" uri="/ehr-tag"%>

<script type="text/javascript" src="${pageContext.request.contextPath}/js/views/portal/frequent/search.js"></script>

<div id="top_allLink">
	<div class="section">
		<form method="post" id="form_search">
			<div class="searchbox" id="searchTable">
				<table id="frequentSearchTable">
					<colgroup>
						<col style="width: 10%;" />
						<col style="width: 23%;" />
						<col style="width: 10%;" />
						<col style="width: 23%;" />
						<col style="width: 10%;" />
						<col style="width: 23%;" />
					</colgroup>
					<tbody>
					<tr>
						<td class="coltext">姓名:</td>
						<td class="colinput"><input type="text" name="frequentName"></td>
						<td class="coltext">身份证号:</td>
						<td class="colinput"><input type="text" name="cardNo"></td>
						<td class="coltext">性别:</td>
						<td class="colinput">
							<ehr:dic-list id="gender" dicmeta="GBT226112003" name="gender" reg="{'required':true}" />
						</td>
					</tr>
					<tr>
						<td class="coltext">预约状态:</td>
						<td class="colinput">
							<ehr:dic-list id="reserveStatus" dicmeta="LH00006" name="reserveStatus" reg="{'required':true}" />
						</td>
						<td class="coltext">隶属用户:</td>
						<td class="colinput"><input type="text" name="realName"></td>
						<td></td>
						<td>
							<input id="frequentSearchBut" class="search_btn" type="button" value="查询" style="float: left" />
						</td>
					</tr>
					</tbody>
				</table>
				<table>
					<tr>
						<td colspan="6" class="colbottom">
							<span id="frequentSearchSpanId" class="ico-bottom">&nbsp;</span>
						</td>
					</tr>
				</table>
			</div>
		</form>
		<div id="frequent_records"></div>
	</div>
</div>
<div id="frequentDetails"></div>


