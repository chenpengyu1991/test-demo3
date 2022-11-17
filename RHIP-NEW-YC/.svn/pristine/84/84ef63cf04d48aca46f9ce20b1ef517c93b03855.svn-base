<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/views/ep/iodineNutrition/monitorInfoEdit.js"></script>
<div id="infoEditFormDiv">
<div id="top"></div>
<div class="toolbar">
	<a href="javascript:void(0)" id="back"><b class="fanhui">返回</b></a>
</div>
<form id="infoEditForm">
	<div class="postcontent contentfixed">
		<i class="popno">育龄妇女调查记录</i>
		<div class="postdiv">
			<table>
				<tr>
					<td>编号：${monitor.surveyNo}</td>
					<td style="text-align:right;"></td>
				</tr>
			</table>
			<fieldset>
				<legend>基本信息</legend>
				<table class="posttable">
					<colgroup>
						<col style="min-width:70px; width: 15%;"/>
						<col style="min-width:100px; width: 18%;"/>
						<col style="min-width:70px; width: 15%;"/>
						<col style="min-width:100px; width: 18%;"/>
	                    <col style="min-width:70px; width: 17%;"/>
	                    <col style="min-width:183px; width: 16%;"/>
					</colgroup>
					<tbody>
					<tr>
						<th>抽样点</th>
						<td>
								<c:forEach var="sampling" items="${samplingList}">
									${sampling.id eq monitor.samplingId ? sampling.name : ""}
								</c:forEach> 
						</td>
						<th>姓名</th>
						<td>${monitor.name}</td>
						<th>年龄</th>
						<td>${monitor.age}</td>
					</tr>
					<tr>
						<th>身份证</th>
						<td>${monitor.idCard}</td>
						<th>性别</th>
						<td><ehr:dic dicmeta="GBT226112003" code="${monitor.gender}" /></td>
						<th>基本情况</th>
						<td><ehr:dic dicmeta="FS10271" code="${monitor.baseInfo}" /></td>
					</tr>
					<tr>
						<th>居住地址</th>
						<td colspan="5">河南省永城市<ehr:dic dicmeta="FS990001" code="${monitor.gbCode}" />
							<ehr:dic dicmeta="FS990001" code="${monitor.villageCode}" />
							<c:if test="${not empty monitor.villageGroup}" >${monitor.villageGroup}小组</c:if>
							<c:if test="${not empty monitor.naturalVillage}" >${monitor.naturalVillage}自然村</c:if>
						</td>
					</tr>
					</tbody>
				</table>
			</fieldset>
			<fieldset>
				<legend>盐碘、尿碘监测调查</legend>
				<table class="posttable">
					<colgroup>
						<col style="min-width:70px; width: 15%;"/>
						<col style="min-width:100px; width: 18%;"/>
						<col style="min-width:70px; width: 15%;"/>
						<col style="min-width:100px; width: 18%;"/>
	                    <col style="min-width:70px; width: 17%;"/>
	                    <col style="min-width:183px; width: 16%;"/>
					</colgroup>
					<tbody>
					<tr>
						<th>一年内是否服用碘丸</th>
						<td><ehr:dic dicmeta="PH00001" code="${monitor.iodizedOilCapsule}" /></td>
						<th>尿样检测结果</th>
						<td>${monitor.urineTestResult}μg/L</td>
						<th>碘盐检测结果</th>
						<td>${monitor.saltIodineContent}mg/kg</td>
					</tr>
					</tbody>
				</table>
			</fieldset>
			<fieldset>
				<legend>调查记录</legend>
				<table class="posttable">
					<colgroup>
						<col style="min-width:70px; width: 15%;"/>
						<col style="min-width:100px; width: 18%;"/>
						<col style="min-width:70px; width: 15%;"/>
						<col style="min-width:100px; width: 18%;"/>
	                    <col style="min-width:70px; width: 17%;"/>
	                    <col style="min-width:183px; width: 16%;"/>
					</colgroup>
					<tbody>
					<tr>
						<th>调查人</th>
						<td>${monitor.investigator}</td>
						<th>调查单位</th>
						<td>${monitor.investigateUnit}</td>
						<th>调查时间</th>
						<td><fmt:formatDate value="${monitor.investigateTime}" pattern="yyyy/MM/dd"/></td>
					</tr>
					</tbody>
				</table>
			</fieldset>
		</div>
	</div>
</form>
</div>