<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<link href="${pageContext.request.contextPath}/js/fineuploader/fineuploader-3.4.1.css" rel="stylesheet"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/fineuploader/jquery.fineuploader-3.4.1.js"/>
<script src="${pageContext.request.contextPath}/js/views/hm/fissureSealant/import.js" type="text/javascript"></script>
	<div class="postcontent">
		<div class="postdiv">
			<fieldset>
				<legend>导入</legend>
				<table class="posttable">
					<colgroup>
						<col style="width: 20%"/>
						<col style=""/>
					</colgroup>
					<tr>
						<th><label class="required">学校</label></th>
						<td>
							<select id="selectSchoolForStu">
								<option value="">请选择学校</option>
								<ehr:schoolList type="01,06" />
							</select>
						</td>
					</tr>
					<tr>
						<th><label class="required">年份</label></th>
						<td><tag:dateInput name="year" id="year" pattern="yyyy" style="width:75px;" /></td>
					</tr>
					<tr>
						<th><label class="required">男生数</label></th>
						<td><tag:numberInput id="mNumber" name="mNumber" style="width: 60px" /></td>
					</tr>
					<tr>
						<th><label class="required">女生数</label></th>
						<td><tag:numberInput id="fNumber" name="fNumber" style="width: 60px" /></td>
					</tr>
					<%-- 
					<tr>
						<th>总人数</th>
						<td><tag:numberInput id="totleNumber" style="width: 60px" /></td>
					</tr>
					--%>
					<tr>
						<th><label class="required">文件</label></th>
						<td>
							<div id="importFile"></div>
							<div id="importComplete" style="display:none;"></div>
						</td>
					</tr>
					<tr>
						<th>导入帮助</th>
						<td>
							<a href="javascript:void(0);" onclick="hmFissureSealantImport.downloadTemplet()">模板下载</div>
						</td>
					</tr>
				</table>
			</fieldset>
		</div>
	</div>