<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<script src="${pageContext.request.contextPath}/js/views/hm/studentExam/schoolSearch.js" type="text/javascript"></script>
<div class="section">
	<div class="toolbar">
        <a href="javascript:void(0)" id="btnAdd"><b class="xinz">新增</b></a>
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
						<td class="coltext">学校类型</td>
						<td class="colinput">
							<ehr:dic-list name="type" dicmeta="FS10255" width="130px" />
						</td>
						<td class="coltext">地区类型</td>
						<td class="colinput">
							<ehr:dic-list name="areaType" dicmeta="FS10256" width="80px" />
						</td>
						<td class="coltext">体检机构</td>
						<td class="colinput">
							<ehr:dic-town-centre-station townName="organTown" centreName="examOrgan"  isShowOther="true" isShowInfirmary="true" />
						</td>
					</tr>
					<tr>
						<td class="coltext">学校编码</td>
						<td class="colinput"><input type="text" name="schoolCode" style="width:130px;"/></td>
						<td class="coltext">学校名称</td>
						<td class="colinput"><input type="text" name="name" style="width:170px;"/></td>
						<td class="coltext"></td>
						<td class="colinput">
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