<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<script src="${pageContext.request.contextPath}/js/views/hm/studentExam/reportSearch.js" type="text/javascript"></script>
<div class="section">
	<div class="toolbar">
        <a href="javascript:void(0)" id="btnReportExport"><b class="export">报表导出</b></a>
    </div>    
	<div class="searchbox" style="overflow-x: auto;">
		<form id="reportSearchForm">
			<table id="reportTable">
				<colgroup>
					<col style="width:20%;" />
					<col style="width:20%;" />
					<col style="width:60%;" />
				</colgroup>
				<tr>
					<td>
						<fieldset style="margin-left:5px;padding:5px;">
							<legend>年份</legend>
							<table style="min-width:150px">
								<tr>
									<td><label class="required">体检年份</label></td>
									<td><tag:dateInput name="examYear" pattern="yyyy" style="width:75px;" date="${examYear}" reg='{"required":"true"}'/>
										<input type="text" name="notuse" style="display:none;" />
								</tr>
							</table>
						</fieldset>
					</td>
					<td>
						<fieldset style="margin-left:5px;padding:5px;">
							<legend>地区  <input type="checkbox" id="areaTypeInputAll" /></legend>
							<table style="min-width:150px">
								<colgroup>
									<col style="width:50%;" />
									<col style="width:50%;" />
								</colgroup>
								<c:forEach var="areaType" items="${areaTypes}" varStatus="status">
									<c:if test="${status.index%2==0}"><tr></c:if>
									<td><input type="checkbox" chkRef="areaTypeInput" name="areaTypeInput" value="${areaType.itemCode}" />  ${areaType.itemName}</td>
									<c:if test="${status.count%2==0}"></tr></c:if>
								</c:forEach>
							</table>
						</fieldset>
					</td>
					<td>
						<fieldset style="margin-right:5px;padding:5px;">
							<legend>学校类型  <input type="checkbox" id="typeInputAll" /></legend>
							<table style="min-width:150px">
								<colgroup>
									<col style="width:16%;" />
									<col style="width:16%;" />
									<col style="width:16%;" />
									<col style="width:16%;" />
									<col style="width:16%;" />
									<col style="width:16%;" />
								</colgroup>
								<c:forEach var="type" items="${types}" varStatus="status">
									<c:if test="${status.index%6==0}"><tr></c:if>
									<td><input type="checkbox" chkRef="typeInput" name="typeInput" value="${type.itemCode}" />  ${type.itemName}</td>
									<c:if test="${status.count%6==0}"></tr></c:if>
								</c:forEach>
							</table>
						</fieldset>
					</td>
				</tr>
				<tr>
					<td colspan="3">
						<div style="margin:10px 5px 5px;border:gray solid 1px;">
							<div style="clean:both;text-align:right;padding:5px;">
								<div style="float:left;text-align:left;" id="checkSchoolShowDiv"><b>选择学校：</b></div>
								<a href="javascript:void(0)" id="btnExportSchool">展开</a>
							</div>
							<div style="display:none;"id="schoolListDiv">
								<fieldset style="margin-top:10px;padding:5px;border-style:solid none none none;">
									<legend>全选  <input type="checkbox" id="schoolInputAll" /></legend>
									<div id="schoolInputDiv" >
										<table>
											<colgroup>
												<col style="width:16%;" />
												<col style="width:16%;" />
												<col style="width:16%;" />
												<col style="width:16%;" />
												<col style="width:16%;" />
												<col style="width:16%;" />
											</colgroup>
											<c:forEach var="school" items="${schools}" varStatus="status">
												<c:if test="${status.index%6==0}"><tr></c:if>
												<td><input type="checkbox" chkRef="schoolCode" name="schoolCode" value="${school.schoolCode}" />  ${school.name}</td>
												<c:if test="${status.count%6==0}"></tr></c:if>
											</c:forEach>
										</table>
									</div>
								</fieldset>
							</div>
						</div>
					</td>
				</tr>
				<tr>
					<td colspan="3">
						<div style="margin:10px 5px 5px;border:gray solid 1px;">
							<div style="clean:both;text-align:right;padding:5px;">
								<div style="float:left;text-align:left;" id="checkGradeShowDiv"><b>选择年级：</b></div>
								<a href="javascript:void(0)" id="btnExportGrade">展开</a>
							</div>
							<div style="display:none;"id="gradeListDiv">
								<fieldset style="margin-top:10px;padding:5px;border-style:solid none none none;">
									<legend>全选  <input type="checkbox" id="gradeInputAll" /></legend>
									<div id="gradeInputDiv" >
										<table>
											<colgroup>
												<col style="width:16%;" />
												<col style="width:16%;" />
												<col style="width:16%;" />
												<col style="width:16%;" />
												<col style="width:16%;" />
												<col style="width:16%;" />
											</colgroup>
											<c:forEach var="grade" items="${gradeCodes}" varStatus="status">
												<c:if test="${status.index%6==0}"><tr></c:if>
												<td><input type="checkbox" chkRef="gradeCode" name="gradeCode" value="${grade.itemCode}" />  ${grade.itemName}</td>
												<c:if test="${status.count%6==0}"></tr></c:if>
											</c:forEach>
										</table>
									</div>
								</fieldset>
							</div>
						</div>
					</td>
				</tr>
			</table>
		<table>
			<tr>
				<td style="text-align: center;">
					<input type="button" id="btnReportSearch" value="查询" class="search_btn"/>
				</td>
			</tr>
		</table>
		</form>
		<table>
			<tr>
				<td class="colbottom">
					<span class="ico-bottom" onclick="toggle(this,'reportSearchForm')">&nbsp;</span>
				</td>
			</tr>
		</table>
	</div>
	<div id="reportListDiv" style="min-width: 750px; min-height:300px;"></div>
</div>