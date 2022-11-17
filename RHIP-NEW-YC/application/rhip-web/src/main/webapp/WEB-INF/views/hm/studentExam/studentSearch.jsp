<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<script src="${pageContext.request.contextPath}/js/views/hm/studentExam/studentSearch.js" type="text/javascript"></script>
<div class="section">
	<div class="toolbar">
		<a href="javascript:void(0)" id="btnImport"><b class="import">导入学生</b></a>
    </div>    
	<div class="searchbox">
		<form id="searchForm">
			<table id="searchTable">
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
						<td class="coltext">学&nbsp;&nbsp;&nbsp;&nbsp;校</td>
						<td class="colinput">
							<select id="selectSchool" name="schoolCode" style="width:170px;">
								<option value="">请选择学校</option>
								<ehr:schoolList />
							</select>
						</td>
						<td class="coltext">年&nbsp;&nbsp;&nbsp;&nbsp;级</td>
						<td class="colinput">
							<ehr:dic-list name="gradeCode" dicmeta="FS10258" width="150px" />
						</td>
						<td class="coltext">班&nbsp;&nbsp;&nbsp;&nbsp;级</td>
						<td class="colinput">
							<input type="text" name="classCode" style="width:150px;"/>
						</td>
					</tr>
					<tr>
						<td class="coltext">身份证号</td>
						<td class="colinput"><tag:idcardInput name="idcard" style="width:170px" /></td>
						<td class="coltext">姓&nbsp;&nbsp;&nbsp;&nbsp;名</td>
						<td class="colinput"><input type="text" name="name" style="width:150px;"/></td>
						<td class="coltext">性&nbsp;&nbsp;&nbsp;&nbsp;别</td>
						<td class="colinput">
							<ehr:dic-list name="gender" dicmeta="GBT226112003" code="1,2" width="150px" />
						</td>
					</tr>
					<tr>
						<td class="coltext">年&nbsp;&nbsp;&nbsp;&nbsp;份</td>
						<td class="colinput"><tag:dateInput name="year" id="year" pattern="yyyy" date="${currentYear}" style="width:75px;" /></td>
						<td class="coltext">状&nbsp;&nbsp;&nbsp;&nbsp;态</td>
						<td class="colinput">
							<select name="status" style="width:150px;">
								<option value="0">请选择</option>
								<option value="1">未录入</option>
								<option value="2">已录入</option>
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