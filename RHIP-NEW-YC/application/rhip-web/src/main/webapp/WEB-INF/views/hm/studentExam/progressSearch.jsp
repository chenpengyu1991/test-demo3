<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<script src="${pageContext.request.contextPath}/js/views/hm/studentExam/progressSearch.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/hm/studentExam/base.js" type="text/javascript"></script>

<div class="section">
		<div class="searchBox">
			<input type="hidden" id="pageIndex" value="${pageIndex}">
			<form id="progressSearchForm">
				<table id="progressSearch">
					<colgroup>
					 	<col style="width: 20%; min-width: 100px;"/>
                        <col style="width: 50%; min-width: 300px;"/>
                        <col style="width: 30%; min-width: 120px;"/>
					</colgroup>
					<tbody>
						<tr>
							<td class="col-text">学校</td>
							<td class="col-input"> 
								<ehr:dic-list dicmeta="FS10255" id="type" name="type" width="100px;" onchange="hmStudentExamBase.refreshSchool(this.value)"/>
								<select id="selectSchool" name="schoolCode" style="width:250px;">
									<option value="">请选择学校</option>
								</select>
							</td>
							<td style="text-align: right;"><input type="button" id="progressBtnSearch" value="查询"
								onclick="" class="search_btn" /></td>
						</tr>
					</tbody>
				</table>
				<table>
					<tr>
						<td colspan="4" class="col-bottom"><span
							onclick="progressSearch.toggle(this,'progressSearch')"
							class="ico-bottom">&nbsp;</span></td>
					</tr>
				</table>

			</form>
		</div>
		<div id="progressResultDiv">
		</div>
</div>