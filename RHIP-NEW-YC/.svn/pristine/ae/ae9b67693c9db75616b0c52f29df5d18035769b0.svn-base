<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib  tagdir="/WEB-INF/tags" prefix="tag"%>

<script type="text/javascript">
	 require(['views/portal/hospitalInfo/search'],function(hospitalInfosearch){
		 hospitalInfosearch.load();
	 });
</script>
<input type="hidden" name="id" value="${hospitalInfodetails.id}">
<div class="section" id="searchDiv">
    <div class="toolbar">
        <a id="addHos"><b class="xinz">新增</b></a>
    </div>
	<div class="searchbox" id="searchBox">
		<input type="hidden" id="pageIndex" value="${pageIndex}">
		<form method="post" id="form_search">
			<table id="hospitalInfoSearchTableId">
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
						<td class="coltext">医院名称:</td>
						<td class="colinput"><input type="text" name="hospitalName" id="hospitalName" /></td>
						<td class="coltext">医院等级:</td>
						<td>
						    <ehr:dic-list name="hospitalLevel" dicmeta="DM02-02" reg='{"required":"true"}' width="80%;"/>
						</td>
                        <td class="coltext">机构类别:</td>
						<td>
							 <ehr:dic-list name="organizationType"  reg='{"required":"true"}' dicmeta="GBT2182002"/>
							<%--<ehr:dic-list name="genreCode" dicmeta="GBT2182002" code="A1,R2"/>--%>
                         </td>
					</tr>
					<tr>
						<td class="coltext">审核状态:</td>	
						<td>
							<ehr:dic-list id="status" dicmeta="LH00008" name="status" code="0,1" />
						</td>
						<td class="coltext">创建时间:</td>
                        <td nowrap="nowrap" >
							<tag:dateInput name="beginTime" id="beginTime" pattern="yyyy/MM/dd" onlypast="true" style="width:35%;" ></tag:dateInput>~
							<tag:dateInput name="endTime" id="endTime" pattern="yyyy/MM/dd" onlypast="true" style="width:35%;"></tag:dateInput>
                        </td>
                        <td></td>
						<td><input id="hospitalInfoSearchBtn" class="search_btn" type="button" value="查询" style="float: left;" /></td>
					</tr>
				</tbody>
			</table>
			<table>
				<tr>
					<td colspan="6" class="colbottom">
					    <span id="hospitalInfoSearchSpanId" class="ico-bottom">&nbsp;</span>
					</td>
				</tr>
			</table>
		</form>
	</div>
	<div id="hospitalInfo_records"></div>
</div>
<div id="hospitalInfoDiv"></div>
