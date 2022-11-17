<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="ehr" uri="/ehr-tag"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>

<script type="text/javascript">
	 require(['views/portal/interaction/search'],function(interactioSearch){
		 interactioSearch.load();
	 });
</script>
<!-- <div class="toolbar">
        <a href="javascript:void(0)" id="reportcard-list-export-btn"><b class="export">导出</b></a>
    </div> -->
<div class="section" id="searchDiv">
	<div class="searchbox" id="searchBox">
		<form method="post" id="form_search">
			<table id="interactionSearchTableId">
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
                		<td class="coltext">标题:</td>
						<td class="colinput"><input type="text" name="title" id="title" />
						<td class="coltext">办件类型:</td>
						<td><ehr:dic-list id="eventType" dicmeta="LH00002" name="eventType" reg="{'required':true}" />
						</td>
						<td class="coltext">回复状态:</td>
						<td><ehr:dic-list id="status" dicmeta="LH00003" name="status" reg="{'required':true}" />
						</td>
                	</tr>
					<tr>
						<td class="coltext">创建时间:</td>
                        <td nowrap="nowrap" >
							<tag:dateInput name="beginTime" id="beginTime" pattern="yyyy/MM/dd" onlypast="true" style="width:35%;" ></tag:dateInput>~
							<tag:dateInput name="endTime" id="endTime" pattern="yyyy/MM/dd" onlypast="true" style="width:35%;"></tag:dateInput>
                        </td>
                        <td></td>
                        <td></td>
                        <td></td>
						<td><input id="interactionSearchBtn" class="search_btn" type="button" value="查询" style="float: left;" /></td>
					</tr>
				</tbody>
			</table>
			<table>
				<tr>
					<td colspan="6" class="colbottom">
					    <span id="interactionSearchSpanId" class="ico-bottom">&nbsp;</span>
					</td>
				</tr>
			</table>
		</form>
	</div>
	<div id="interaction_records"></div>
</div>
<div id="interactionDiv"></div>
