<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<link href="${pageContext.request.contextPath}/js/fineuploader/fineuploader-3.4.1.css" rel="stylesheet"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/fineuploader/jquery.fineuploader-3.4.1.js"/>
<script src="${pageContext.request.contextPath}/js/views/hm/studentExam/import.js" type="text/javascript"/>
<form id="importStudent">
	<div class="postcontent">
		<div class="postdiv">
			<fieldset>
				<legend>导入学生</legend>
				<table class="posttable">
					<colgroup>
						<col style="width: 20%"/>
						<col style=""/>
					</colgroup>
					<tr>
						<th>学校</th>
						<td>
							<select id="selectSchoolForStu">
								<option value="">请选择学校</option>
								<ehr:schoolList />
							</select>
						</td>
					</tr>
					<tr>
						<th>操作方式</th>
						<td>
							<input type="radio" name="actionType" value="0" /> 覆盖导入
							<input type="radio" name="actionType" value="1"  /> 追加导入
						</td>
					</tr>
					<tr>
						<th>文件</th>
						<td>
							<div id="importStudentFile"></div>
						</td>
					</tr>
					<tr>
						<th rowspan="2">导入帮助</th>
						<td>
							<a href="javascript:void(0);" onclick="hmStudentExamImport.downloadTemplet()">模板下载</div>
						</td>
					</tr>
					<tr>
						<td>
							<span style="color:red">* 覆盖导入</span> - 会删除已有的学生信息，以新导入的学生信息为准，适合在新学期开始的时候导入学生时使用<br />
							<span style="color:red">* 追加导入</span> - 不会删除已有的学生信息，适合在平时追加导入学生时使用
						</td>
					</tr>
				</table>
			</fieldset>
		</div>
	</div>
</form>