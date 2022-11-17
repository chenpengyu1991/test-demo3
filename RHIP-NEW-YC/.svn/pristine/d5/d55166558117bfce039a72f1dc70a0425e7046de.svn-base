<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/views/dref/search.js"/>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/views/menubox/menubox.css"/>
<div class="section">
	<div class="toolbar">
		<div style="position: relative">
			<a href="javascript:void(0)"><b class="xinz" id="addBtn">新增</b></a>
			<div id="menubox">
				<ul>
					<li><a href="javascript:void(0)" data-type="1">转出单</a></li>
					<li><a href="javascript:void(0)" data-type="2">回转单</a></li>
				</ul>
			</div>
		</div>
	</div>
	<div class="searchbox">
		<form id="searchForm">
			<table id="searchTable">
				<colgroup>
					<col style="width: 13%;" />
					<col style="width: 20%;" />
					<col style="width: 10%;" />
					<col style="width: 23%;" />
					<col style="width: 10%;" />
					<col style="width: 23%;" />
				</colgroup>
				<tbody>
				<tr>
					<td class="coltext">姓名</td>
					<td class="colinput"><input type="text" name="name" style="width: 150px"/></td>
					<td class="coltext">转诊类型</td>
					<td class="colinput"><ehr:dic-list name="dualReferralType" dicmeta="FS10286" width="150px"/></td>
					<td class="coltext">转诊日期</td>
					<td class="colinput"><tag:dateInput name="referralDate" pattern="yyyy/MM/dd" style="width: 150px"/></td>
				</tr>
				<tr>
					<td class="coltext">转出单位</td>
					<td class="colinput"><tag:autoSelect name="destDeptCode" id="destDeptCode" style="width: 150px"/></td>
					<td class="coltext">转入单位</td>
					<td class="colinput"><tag:autoSelect name="referralHospitalCode" id="referralHospitalCode" style="width: 150px"/></td>
					<td class="coltext">转诊来源</td>
					<td class="colinput">
						<select id="referralSource" name="referralSource">
							<option value="">全部</option>
							<option value="1">手机App</option>
							<option value="2">平台</option>
						</select>
					</td>
				</tr>
				<tr>
					<td class="coltext">转诊状态</td>
					<td class="colinput">
						<select id="referralStatus" name="referralStatus">
							<option value="">全部</option>
							<option value="0">未接收</option>
							<option value="1">已接收</option>
							<option value="2">拒绝接收</option>
						</select>
					</td>
					<td></td>
					<td></td>
					<td></td>
					<td><input type="button" id="searchBtn" value="查询" class="search_btn"/></td>
				</tr>
				</tbody>
			</table>
			<table>
				<tr>
					<td class="colbottom">
						<span class="ico-bottom" onclick="toggle(this,'searchTable')">&nbsp;</span>
					</td>
				</tr>
			</table>
		</form>
	</div>
	<div id="listDiv"></div>
</div>