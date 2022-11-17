<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<div id="infoEditFormDiv">
<div id="top"></div>
<div class="toolbar">
	
</div>
	<div class="postcontent">
		<div class="postdiv">
			<fieldset>
				<legend>学校信息</legend>
				<table class="posttable">
					<colgroup>
						<col style="min-width: 80px; width: 15%;"/>
						<col style="min-width: 150px; width: 35%;"/>
						<col style="min-width: 80px; width: 15%;"/>
						<col style="min-width: 150px; width: 35%;"/>
					</colgroup>
					<tbody>
					<tr>
						<th>学校编码</th>
						<td>${school.schoolCode}</td>
						<th>学校名称</th>
						<td>${school.name}</td>
					</tr>
					<tr>
						<th>学校类型</th>
						<td><ehr:dic dicmeta="FS10255" code="${school.type}" /></td>
						<th>地区类型</th>
						<td><ehr:dic dicmeta="FS10256" code="${school.areaType}" /></td>
					</tr>
					<tr>
						<th>学校地址</th>
						<td colspan="3">${school.address}</td>
					</tr>
					<tr>
						<th>体检机构</th>
						<td colspan="3"><ehr:org code="${school.examOrgan}"/></td>
					</tr>
					<tr>
						<th>备注</th>
						<td colspan="3">${school.remark}</td>
					</tr>
					</tbody>
				</table>
			</fieldset>
		</div>
	</div>
</div>