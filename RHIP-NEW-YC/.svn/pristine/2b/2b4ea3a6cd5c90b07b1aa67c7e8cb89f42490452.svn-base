<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<script src="${pageContext.request.contextPath}/js/views/hm/studentExam/search.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/hm/studentExam/base.js" type="text/javascript"></script>
<div class="section">
	<div class="toolbar">
        <a href="javascript:void(0)" id="btnAdd"><b class="xinz">新增</b></a>
		<a href="javascript:void(0)" id="btnPrint"><b class="dayin">打印</b></a>
		<a href="javascript:void(0)" id="btnExport"><b class="export">导出</b></a>
    </div>    
	<div class="searchbox">
		<form id="searchForm">
			<table id="searchTable">
				<colgroup>
					<col style="min-width:70px; width: 10%;" />
					<col style="min-width:250px; width: 30%;" />
					<col style="min-width:70px; width: 10%;" />
					<col style="min-width:100px; width: 20%;" />
					<col style="min-width:70px; width: 10%;" />
					<col style="min-width:120px; width: 20%;" />
				</colgroup>
				<tbody>
					<tr>
						<td class="coltext">学&nbsp;&nbsp;&nbsp;&nbsp;校</td>
						<td class="colinput">
							<ehr:dic-list dicmeta="FS10255" id="type" name="type" width="30%;" onchange="hmStudentExamBase.refreshSchool(this.value)"/>
							<select id="selectSchool" name="schoolCode" style="width:65%;">
								<option value="">请选择学校</option>
							</select>
						</td>
						<td class="coltext">年&nbsp;&nbsp;&nbsp;&nbsp;级</td>
						<td class="colinput">
							<ehr:dic-list name="gradeCode" dicmeta="FS10258" width="width:80%;" />
						</td>
						<td class="coltext">班&nbsp;&nbsp;&nbsp;&nbsp;级</td>
						<td class="colinput">
							<input type="text" name="classCode" style="width:80%;"/>
						</td>
					</tr>
					<tr>
						<td class="coltext">身份证号</td>
						<td class="colinput"><tag:idcardInput name="idcard" style="width:80%;" /></td>
						<td class="coltext">姓&nbsp;&nbsp;&nbsp;&nbsp;名</td>
						<td class="colinput"><input type="text" name="name" style="width:80%;"/></td>
						<td class="coltext">性&nbsp;&nbsp;&nbsp;&nbsp;别</td>
						<td class="colinput">
							<ehr:dic-list name="gender" dicmeta="GBT226112003" code="1,2" width="80%" />
						</td>
					</tr>
					<tr>
						<td class="coltext">体检日期</td>
						<td class="colinput">
							<tag:dateInput id="beginDate" name="beginDate" pattern="yyyy/MM/dd" style="width:75px;" />
							&nbsp;~&nbsp;
							<tag:dateInput id="endDate" name="endDate" pattern="yyyy/MM/dd" style="width:75px;" />
						</td>
						<td class="coltext">状&nbsp;&nbsp;&nbsp;&nbsp;态</td>
						<td class="colinput">
							<select name="status" style="width:80%">
								<option value="0">请选择</option>
								<option value="2">已录入</option>
								<option value="3">已打印</option>
							</select>
						</td>
						<td></td>
						<td style="text-align: left;">
							<input type="button" id="btnSearch" value="查询" class="search_btn"/>
						</td>
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