<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/views/hm/studentExam/schoolInfoEdit.js"></script>
<div id="infoEditFormDiv">
<div id="top"></div>
<div class="toolbar">
	<a href="javascript:void(0)" id="save"><b class="baocun">保存</b></a>
</div>
<form id="infoEditForm">
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
						<th><label class="required">学校编码</label></th>
						<td>
						    <c:if test="${empty school.schoolId}">
						    	<input type="text" name="schoolCode" value="${school.schoolCode}" reg='{"required":"true", "maxlength":"10"}' />
						    </c:if>
							<c:if test="${not empty school.schoolId}">${school.schoolCode}
								<input type="hidden" name="schoolCode" value="${school.schoolCode}" />
								<input type="hidden" name="schoolId" value="${school.schoolId}" />
							</c:if>
						</td>
						<th><label class="required">学校名称</label></th>
						<td><input type="text" name="name" value="${school.name}" reg='{"required":"true", "maxlength":"16"}' /></td>
					</tr>
					<tr>
						<th><label class="required">学校类型</label></th>
						<td><ehr:dic-list name="type" dicmeta="FS10255" value="${school.type}" reg='{"required":"true"}' /></td>
						<th><label class="required">地区类型</label></th>
						<td><ehr:dic-list name="areaType" dicmeta="FS10256" value="${school.areaType}" reg='{"required":"true"}' /></td>
					</tr>
					<tr>
						<th>学校地址</th>
						<td colspan="3"><input type="text" name="address" value="${school.address}" reg='{"maxlength":"160"}' /></td>
					</tr>
					<tr>
						<th>体检机构</th>
						<td colspan="3">
							<ehr:dic-town-centre-station townName="organTown" centreName="examOrgan"  isShowInfirmary="true" 
								townValue="${school.organTown}" centreValue="${school.examOrgan}" isShowOther="true"/>
						</td>
					</tr>
					<tr>
						<th>备注</th>
						<td colspan="3">
							<textarea name="remark" style="width: 90%; font-size:12px;" rows="3"  reg='{"maxlength":"200"}' >${school.remark}</textarea>
						</td>
					</tr>
					</tbody>
				</table>
			</fieldset>
		</div>
	</div>
</form>
</div>