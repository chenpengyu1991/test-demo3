<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/views/ep/iodineNutrition/monitorInfoEdit.js"></script>
<div id="infoEditFormDiv">
<div id="top"></div>
<div class="toolbar">
	<a href="javascript:void(0)" id="back"><b class="fanhui">返回</b></a>
	<a href="javascript:void(0)" id="save"><b class="baocun">保存</b></a>
</div>
<form id="infoEditForm">
	<div class="postcontent contentfixed">
		<i class="popno">育龄妇女调查记录</i>
		<div class="postdiv">
			<table>
				<tr>
					<td><label class="required">编号</label>
						<c:if test="${empty monitor.surveyNo}">
							<input type="text" name="surveyNo" value="${monitor.surveyNo}" style="width: 80px" reg='{"required":"true", "maxlength":"20"}' />
						</c:if>
						<c:if test="${not empty monitor.surveyNo}">
							${monitor.surveyNo}<input type="hidden" name="surveyNo" value="${monitor.surveyNo}" />
						</c:if>
						<input type="hidden" name="id" value="${monitor.id}" />
						<input type="hidden" name="crowd" value="${monitor.crowd}" />
					</td>
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
						<th><label class="required">抽样点</label></th>
						<td>
							<select name="samplingId" style="width:180px" reg='{"required":"true"}'>
								<option value="">请选择</option>
								<c:forEach var="sampling" items="${samplingList}">
									<option value="${sampling.id}"  ${sampling.id eq monitor.samplingId ? "selected" : ""}>${sampling.name}</option>
								</c:forEach> 
							</select>
						</td>
						<th><label class="required">姓名</label></th>
						<td><input type="text" name="name" value="${monitor.name}" style="width: 200px" reg='{"required":"true", "maxlength":"20"}' /></td>
						<th><label class="required">年龄</label></th>
						<td><tag:numberInput name="age" value="${monitor.age}" style="width: 40px" reg='{"required":"true","min":18,"max":40}' /></td>
					</tr>
					<tr>
						<th>身份证</th>
						<td><tag:idcardInput name="idCard" value="${monitor.idCard}"  style="width: 200px" reg='{"creditcard":"true"}' /></td>
						<th><label class="required">性别</label></th>
						<td><ehr:dic-radio name="gender" dicmeta="GBT226112003" value="${monitor.gender}" code="2"/></td>
						<th><label class="required">基本情况</label></th>
						<td><ehr:dic-list name="baseInfo" dicmeta="FS10271" value="${monitor.baseInfo}" code="1,2,3,4" reg='{"required":"true"}' /></td>
					</tr>
					<tr>
						<th><label class="required">居住地址</label></th>
						<td colspan="5">河南省永城市
							<ehr:dic-town-street-village villageId="pavillage_address" streetId="pastreet_address" 
														 townId="patown_address"  streetName="villageCode"
														 townName="gbCode"  streetValue="${monitor.villageCode}"
														 townValue="${monitor.gbCode}"  width="180px;" reg='{"required":"true"}'/>
						
                            <%-- <ehr:dic-town-village townValue="${monitor.gbCode}" townName="gbCode" 
                                                  villageValue="${monitor.villageCode}"  villageName="villageCode" reg='{"required":"true"}' /> --%>
                            <input type="text" name="villageGroup"  value="${monitor.villageGroup}"
                                    reg='{"maxlength":"20"}' style="width: 180px;"/>小组
                            <input type="text" name="naturalVillage"  value="${monitor.naturalVillage}"
                                    reg='{"maxlength":"10"}' style="width: 60px;"/>自然村
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
						<th><label class="required">一年内是否服用碘丸</label></th>
						<td><ehr:dic-radio dicmeta="PH00001" name="iodizedOilCapsule" code="1,2" value="${monitor.iodizedOilCapsule}" reg='{"required":"true"}' /></td>
						<c:if test="${role eq 1}">
							<th><label class="required">尿样检测结果</label></th>
							<td><tag:numberInput name="urineTestResult" point="point" value="${monitor.urineTestResult}" style="width: 60px" reg='{"required":"true","min":0,"max":9999999.99}'/>μg/L</td>
							<th><label class="required">碘盐检测结果</label></th>
							<td><tag:numberInput name="saltIodineContent" point="point" value="${monitor.saltIodineContent}" style="width: 60px" reg='{"required":"true","min":0,"max":9999999.99}'/>mg/kg</td>
						</c:if>
						<c:if test="${role eq 0}">
							<th></th>
							<td><input name="urineTestResult" type="hidden" value="${monitor.urineTestResult}" /></td>
							<th></th>
							<td><input name="saltIodineContent" type="hidden" value="${monitor.saltIodineContent}" /></td>
						</c:if>
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
						<th><label class="required">调查人</label></th>
						<td><input type="text"name="investigator" value="${monitor.investigator}" style="width: 200px" reg='{"required":"true", "maxlength":"20"}' /></td>
						<th><label class="required">调查单位</label></th>
						<td><input type="text" name="investigateUnit" value="${monitor.investigateUnit}" style="width: 200px" reg='{"required":"true", "maxlength":"50"}' /></td>
						<th><label class="required">调查时间</label></th>
						<td><tag:dateInput onlypast="true" name="investigateTime" pattern="yyyy/MM/dd" date="${monitor.investigateTime}" style="width:75px;" reg='{"required":"true"}'/></td>
					</tr>
					</tbody>
				</table>
			</fieldset>
		</div>
	</div>
</form>
</div>