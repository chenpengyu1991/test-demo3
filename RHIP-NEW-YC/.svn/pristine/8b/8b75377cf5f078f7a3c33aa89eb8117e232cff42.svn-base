<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr" %>
<script type="text/javascript">
	 require(['views/portal/serviceInfo/search'],function(ServiceInfoSearch){
		 ServiceInfoSearch.load();
	 });
</script>
<div>
	<div class="section" id="mainSearchDiv">
		<div class="toolbar">
			<a id="add"><b class="xinz">新增</b></a>
		</div>
		<div class="searchbox">
			<form method="post" id="form_search">
				<div class="searchbox">
					<table id="serviceInfoSearchTableId">
						<colgroup>
							<col style="min-width:70px; width: 10%;"/>
							<col style="min-width:160px; width: 23%;"/>
							<col style="min-width:80px; width: 10%;"/>
							<col style="min-width:160px; width: 23%;"/>
							<col style="min-width:60px; width: 10%;"/>
							<col style="min-width:160px; width: 23%;"/>
						</colgroup>
						<tbody>
						<tr>
							<td class="coltext">标题</td>
							<td class="colinput"><input type="text" name="title" id="title" />
							</td>
							<td class="coltext">创建日期</td>
							<td nowrap="nowrap" >
								<tag:dateInput name="beginTime" id="beginTime" pattern="yyyy/MM/dd" onlypast="true" style="width:49%;" ></tag:dateInput>~
								<tag:dateInput name="endTime" id="endTime" pattern="yyyy/MM/dd" onlypast="true" style="width:49%;"></tag:dateInput>
							</td>
							<td class="coltext">来源</td>
							<td class="colinput"><input type="text" name="source" id="source" />
							</td>
						</tr>
						<tr>
							<td class="coltext">作者</td>
							<td class="colinput"><input type="text" name="author"	id="author"/>
							</td>

							<td class="coltext">类别</td>
							<td class="colinput">
								<select id="infoType" name="infoType" style="width:45%;" >
									<option value="">请选择类别</option>
									<c:forEach items="${infoTypeParentList}" var="infoType">
										<option value="${infoType.id}">${infoType.name}</option>
									</c:forEach>
								</select>
								<select id="detailType" name="detailType" style="width:45%;" >
									<option value="">请选择子类别</option>
								</select>
								<span id="sortError"></span>
							</td>
							<td class="coltext">审核状态</td>
							<td>
								<ehr:dic-list id="status" dicmeta="LH00008" name="status" code="0,1"/>
							</td>
						</tr>
						<tr>
							<td class="coltext">滚动图片状态</td>
							<td>
								<ehr:dic-list id="isRollPicture" dicmeta="FS10186" name="isRollPicture" code="0,1"/>
							</td>
							<td></td>
							<td></td>
							<td></td>
							<td><input id="serviceInfoSearchBut" class="search_btn"
									   type="button" value="查询" style="float: left" /></td>
						</tr>
						</tbody>
					</table>
				</div>
				<table>
					<tr>
						<td colspan="6" class="colbottom">
							<span id="servicefInfoSearchSpanId" class="ico-bottom">&nbsp;</span></td>
					</tr>
				</table>
			</form>
		</div>
		<div id="info_records"></div>
	</div>
	<div id="operationDiv"></div>
</div>