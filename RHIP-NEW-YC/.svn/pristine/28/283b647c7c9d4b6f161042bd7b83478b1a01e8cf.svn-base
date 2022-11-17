<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/views/hm/fissureSealant/infoEdit.js"></script>
<div id="infoEditFormDiv">
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
						<td>${fs.idcard}</td>
						<th>本地学生</th>
						<td><ehr:dic dicmeta="PH00001" code="${fs.nativeStudent}" /></td>
					</tr>
					<tr>
						<th>学校</th>
						<td colspan="3">${fs.schoolName}</td>
					</tr>
					<tr>
						<th>姓名</th>
						<td>${fs.name}</td>
						<th>性别</th>
						<td><ehr:dic dicmeta="GBT226112003" code="${fs.gender}" /></td>
					</tr>
					<tr>
						<th>检查牙数</th>
						<td>${fs.teethNumber}</td>
						<th>患龋</th>
						<td><ehr:dic dicmeta="PH00001" code="${fs.hasDentalCaries}" /></td>
					</tr>
					<tr>
						<th>龋齿数</th>
						<td>${fs.dentalCaries}</td>
						<th>可封闭数</th>
						<td>${fs.needNumber}</td>
					</tr>
					<tr>
						<th>封闭数</th>
						<td>${fs.realNumber}</td>
						<th>封闭日期</th>
						<td><fmt:formatDate value="${fs.closeDate}" pattern="yyyy/MM/dd"/></td>
					</tr>
					<tr>
						<th>医师</th>
						<td colspan="3">${fs.doctor}</td>
					</tr>
					<tr>
						<th>牙位</th>
						<td colspan="3">${fs.position}</td>
					</tr>
					</tbody>
				</table>
			</fieldset>
		</div>
	</div>
</div>