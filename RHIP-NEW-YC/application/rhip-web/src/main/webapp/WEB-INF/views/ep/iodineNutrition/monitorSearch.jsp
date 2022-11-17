<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<jsp:include page="../../layouts/load-js-css-resources.jsp"></jsp:include>

<script type="text/javascript" src="${pageContext.request.contextPath}/js/views/ep/iodineNutrition/monitorSearch.js"/>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/views/menubox/menubox.css"/>
<div class="section">
	<div class="toolbar" >
		<c:if test="${fn:length(samplingList)>0}">
		    <div style="position:relative;">
				<a href="javascript:void(0)"><b class="xinz" id="btnAdd">新增</b></a>
				<div id="menubox">
					<ul>
						<c:if test="${type eq 1}">
							<li><a href="javascript:void(0)" data-type="2">育龄妇女</a></li>
						</c:if>
						<c:if test="${type eq 2}">
							<li><a href="javascript:void(0)" data-type="1">8-10岁儿童</a></li>
						</c:if>
						<c:if test="${type eq 3}">
							<li><a href="javascript:void(0)" data-type="1">8-10岁儿童</a></li>
							<li><a href="javascript:void(0)" data-type="2">育龄妇女</a></li>
						</c:if>
					</ul>
				</div>
			</div>
		</c:if>
	</div>
	<div class="searchbox">
		<form id="searchForm">
			<table id="searchTable">
				<colgroup>
					<col style="min-width:70px; width: 10%;"/>
					<col style="min-width:100px; width: 23%;"/>
					<col style="min-width:70px; width: 10%;"/>
					<col style="min-width:100px; width: 23%;"/>
                    <col style="min-width:70px; width: 10%;"/>
                    <col style="min-width:183px; width: 23%;"/>
				</colgroup>
				<tr>
					<td class="coltext">调查时间</td>
					<td class="colinput">
						<tag:dateInput id="beginDate" name="beginDate" pattern="yyyy/MM/dd" style="width:75px;" />
						&nbsp;~&nbsp;
						<tag:dateInput id="endDate" name="endDate" pattern="yyyy/MM/dd" style="width:75px;" />
					</td>
					<td class="coltext">抽样点</td>
					<td class="colinput">
						<select name="samplingId" style="width:180px" >
							<option value="">请选择</option>
							<c:forEach var="sampling" items="${samplingList}">
								<option value="${sampling.id}">${sampling.name}</option>
							</c:forEach> 
						</select>
					</td>
					<td class="coltext">调查人群</td>
					<td class="colinput">
						<ehr:dic-list name="crowd" dicmeta="FS10273" width="150px" />
					</td>
					<td class="colinput" rowspan="2"><input type="button" id="btnSearch" value="查询" class="search_btn"/></td>
				</tr>
				<tr>
					<td class="coltext">编号</td>
					<td class="colinput"><input type="text" name="surveyNo" style="width:177px"/></td>
					<td class="coltext">姓名</td>
					<td class="colinput"><input type="text" name="name" style="width:178px"/></td>
					<td class="coltext">身份证</td>
					<td class="colinput"><tag:idcardInput name="idCard" style="width:150px" /></td>
				</tr>
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