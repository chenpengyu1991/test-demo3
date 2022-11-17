<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="ehr" uri="/ehr-tag"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>

<script type="text/javascript">
	 require(['views/portal/infoType/search'],function(infoTypeSearch){
		 infoTypeSearch.load();
	 });
</script>
<div id="section">
<div class="toolbar">
    <%--<a id="infoTypeAdd"><b class="xinz">新增</b></a>--%>
</div>
	<div class="searchbox">
		<form method="post" id="form_search">
			<table id="infoTypeSearchTableId">
				<tbody>
                <colgroup>
                    <col style="min-width:70px; width: 10%;"/>
                    <col style="min-width:160px; width: 23%;"/>
                    <col style="min-width:80px; width: 10%;"/>
                    <col style="min-width:160px; width: 23%;"/>
                    <col style="min-width:60px; width: 10%;"/>
                    <col style="min-width:160px; width: 23%;"/>
                </colgroup>
					<tr>
						<td class="coltext">名称:</td>
						<td class="colinput"><input type="text"  id="name" name="name"/></td>
                        <td class="coltext">创建时间:</td>
                        <td nowrap="nowrap" >
							<tag:dateInput name="beginTime" id="beginTime" pattern="yyyy/MM/dd" onlypast="true" style="width:35%;" ></tag:dateInput>~
							<tag:dateInput name="endTime" id="endTime" pattern="yyyy/MM/dd" onlypast="true" style="width:35%;"></tag:dateInput>
                        </td>
                        <td></td>
						<td><input id="infoTypeSearchBtn" class="search_btn" type="button" value="查询" style="float: left;" /></td>
					</tr>
				</tbody>
			</table>
			<table>
				<tr>
					<td colspan="6" class="colbottom">
					    <span id="infoTypeSearchSpanId" class="ico-bottom">&nbsp;</span>
					</td>
				</tr>
			</table>
		</form>
	</div>
	<div id="infoType_records"></div>
</div>
<div id="subInfoType_search"></div>
