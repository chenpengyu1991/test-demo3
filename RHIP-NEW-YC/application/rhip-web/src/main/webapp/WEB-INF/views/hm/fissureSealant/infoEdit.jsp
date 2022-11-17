<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/views/hm/fissureSealant/infoEdit.js"></script>
<div id="infoEditFormDiv">
<form id="infoEditForm">
	<div class="postcontent">
		<div class="postdiv">
			<fieldset>
				<legend>窝沟信息</legend>
				<table class="posttable">
					<colgroup>
						<col style="min-width: 80px; width: 15%;"/>
						<col style="min-width: 150px; width: 35%;"/>
						<col style="min-width: 80px; width: 15%;"/>
						<col style="min-width: 150px; width: 35%;"/>
					</colgroup>
					<tbody>
					<tr>
						<th>身份证号</th>
						<td>${fs.idcard}<input type="hidden" name="idcard" value="${fs.idcard}" /></td>
						<th><label class="required">本地学生</label></th>
						<td><ehr:dic-radio dicmeta="PH00001" name="nativeStudent" code="1,2" value="${fs.nativeStudent}" reg='{"required":"true"}' /></td>
					</tr>
					<tr>
						<th>学校</th>
						<td colspan="3">${fs.schoolName}
						<input type="hidden" name="schoolName" value="${fs.schoolName}" />
						<input type="hidden" name="schoolCode" value="${fs.schoolCode}" /></td>
					</tr>
					<tr>
						<th><label class="required">姓名</label></th>
						<td>
								<input type="text" name="name" value="${fs.name}" style="width: 100px" reg='{"required":"true", "maxlength":"20"}' />
								<input type="hidden" name="fissureSealantId" value="${fs.fissureSealantId}" />
						</td>
						<th><label class="required">性别</label></th>
						<td><ehr:dic-radio name="gender" dicmeta="GBT226112003" value="${fs.gender}" code="1,2" reg='{"required":"true"}' /></td>
					</tr>
					<tr>
						<th><label class="required">检查牙数</label></th>
						<td><tag:numberInput name="teethNumber" value="${fs.teethNumber}" style="width: 60px" reg='{"required":"true","min":0,"max":32}'/></td>
						<th><label class="required">患龋</label></th>
						<td><ehr:dic-radio dicmeta="PH00001" name="hasDentalCaries" code="1,2" value="${fs.hasDentalCaries}" reg='{"required":"true"}' /></td>
					</tr>
					<tr>
						<th><label class="required">龋齿数</label></th>
						<td><tag:numberInput name="dentalCaries" value="${fs.dentalCaries}" style="width: 60px" reg='{"required":"true","min":0,"max":32}'/></td>
						<th><label class="required">可封闭数</label></th>
						<td><tag:numberInput name="needNumber" value="${fs.needNumber}" style="width: 60px" reg='{"required":"true","min":0,"max":32}'/></td>
					</tr>
					<tr>
						<th><label class="required">封闭数</label></th>
						<td><tag:numberInput name="realNumber" value="${fs.realNumber}" style="width: 60px" reg='{"required":"true","min":0,"max":32}'/></td>
						<th><label class="required">封闭日期</label></th>
						<td><tag:dateInput name="closeDate" pattern="yyyy/MM/dd" date="${fs.closeDate}" style="width:75px;" reg='{"required":"true"}'/></td>
					</tr>
					<tr>
						<th>医师</th>
						<td colspan="3"><input type="text" name="doctor" value="${fs.doctor}" style="width: 100px" reg='{"maxlength":"20"}' /></td>
					</tr>
					<tr>
						<th>牙位</th>
						<td colspan="3"><input type="text" name="position" value="${fs.position}" style="width: 300px" reg='{"maxlength":"50"}' /></td>
					</tr>
					</tbody>
				</table>
			</fieldset>
		</div>
		</div>
	</form>
	<div class="toolbarpop">
		<input type="button" id="save" value="保 存"/>
	</div>
</div>