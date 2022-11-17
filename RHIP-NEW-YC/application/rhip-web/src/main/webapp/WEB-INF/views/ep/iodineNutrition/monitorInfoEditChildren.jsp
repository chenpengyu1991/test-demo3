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
		<i class="popno">8-10岁儿童监测调查记录</i>
		<div class="postdiv">
			<table>
				<tr>
					<td>
						编号
						<c:if test="${empty monitor.surveyNo}">
							<input type="text" name="surveyNo" value="${monitor.surveyNo}" style="width: 80px" reg='{"maxlength":"20"}' />
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
						<th>姓名</th>
						<td><input type="text" name="name" value="${monitor.name}" style="width: 200px" reg='{"maxlength":"20"}' /></td>
						<th>年龄</th>
						<td><tag:numberInput name="age" value="${monitor.age}" style="width: 40px" reg='{"min":8,"max":10}' /></td>
					</tr>
					<tr>
						<th>身份证</th>
						<td><tag:idcardInput name="idCard" value="${monitor.idCard}"  style="width: 200px" reg='{"creditcard":"true"}' /></td>
						<th>性别</th>
						<td colspan="3"><ehr:dic-radio name="gender" dicmeta="GBT226112003" value="${monitor.gender}" code="1,2"  /></td>
					</tr>
					<tr>
						<th>学校地址</th>
						<td colspan="5">河南省永城市
							<ehr:dic-town-street-village villageId="pavillage_address" streetId="pastreet_address" 
														 townId="patown_address"  streetName="villageCode"
														 townName="gbCode"  streetValue="${monitor.villageCode}"
														 townValue="${monitor.gbCode}"  width="180px;" reg='{"required":"true"}'/>
                            <%-- <ehr:dic-town-village townValue="${monitor.gbCode}" townName="gbCode" 
                                                 villageValue ="${monitor.villageCode}"  villageName="villageCode"  /> --%>
                            <input type="text" name="schoolName"  value="${monitor.schoolName}"
                                    reg='{"maxlength":"20"}' style="width: 180px;"/>
                            <input type="text" name="className"  value="${monitor.className}"
                                    reg='{"maxlength":"10"}' style="width: 60px;"/>班
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
						<th>食盐来源</th>
						<td><ehr:dic-list name="saltSource" dicmeta="FS10262" value="${monitor.saltSource}"  /></td>
						<th>食盐种类</th>
						<td><ehr:dic-list name="saltType" dicmeta="FS10259" value="${monitor.saltType}"  /></td>
						<th>一年内是否服用碘丸</th>
						<td><ehr:dic-radio dicmeta="PH00001" name="iodizedOilCapsule" code="1,2" value="${monitor.iodizedOilCapsule}"  /></td>
					</tr>
					<c:if test="${role eq 1}">
					<tr>
						<th>尿样检测结果</th>
						<td><tag:numberInput name="urineTestResult" point="point" value="${monitor.urineTestResult}" style="width: 60px" reg='{"min":0,"max":9999999.99}'/>μg/L</td>
						<th>碘盐检测结果</th>
						<td colspan="3"><tag:numberInput name="saltIodineContent" point="point" value="${monitor.saltIodineContent}" style="width: 60px" reg='{"min":0,"max":9999999.99}'/>mg/kg</td>
					</tr>
					</c:if>
					<c:if test="${role eq 0}">
						<input name="urineTestResult" type="hidden" value="${monitor.urineTestResult}" />
						<input name="saltIodineContent" type="hidden" value="${monitor.saltIodineContent}" />
					</c:if>
					</tbody>
				</table>
			</fieldset>
			<fieldset>
				<legend>甲状腺容积调查</legend>
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
						<th>触诊</th>
						<td><ehr:dic-radio dicmeta="FS10263" name="thyroidPalpation" value="${monitor.thyroidPalpation}"  /></td>
						<th><label>左宽</th>
						<td><tag:numberInput name="tyroidLeftWidth" point="point" value="${monitor.tyroidLeftWidth}" style="width: 60px" reg='{"min":0,"max":30}'/>mm</td>
						<th><label>右宽</th>
						<td><tag:numberInput name="tyroidRightWidth" point="point" value="${monitor.tyroidRightWidth}" style="width: 60px" reg='{"min":0,"max":30}'/>mm</td>
					</tr>
					<tr>
						<th>智商答对题数</th>
						<td><tag:numberInput name="intelligenceQuestScore" value="${monitor.intelligenceQuestScore}" style="width: 60px" reg='{"min":0,"max":100}'/></td>
						<th><label>左长</th>
						<td><tag:numberInput name="tyroidLeftLength" point="point" value="${monitor.tyroidLeftLength}" style="width: 60px" reg='{"min":0,"max":30}'/>mm</td>
						<th><label>右长</th>
						<td><tag:numberInput name="tyroidRightLength" point="point" value="${monitor.tyroidRightLength}" style="width: 60px" reg='{"min":0,"max":30}'/>mm</td>
					</tr>
					<tr>
						<th></th>
						<td></td>
						<th><label>左厚</th>
						<td><tag:numberInput name="tyroidLeftHeight" point="point" value="${monitor.tyroidLeftHeight}" style="width: 60px" reg='{"min":0,"max":30}'/>mm</td>
						<th><label>右厚</th>
						<td><tag:numberInput name="tyroidRightHeight" point="point" value="${monitor.tyroidRightHeight}" style="width: 60px" reg='{"min":0,"max":30}'/>mm</td>
					</tr>
					</tbody>
				</table>
			</fieldset>
			<fieldset>
				<legend>三天用餐人次调查</legend>
				<div class="repeattable">
				<table>
					<tbody>
					<tr>
						<th style="text-align:center;" rowspan="2">家庭总人口数</th>
						<th style="text-align:center;">前一天</th>
						<th style="text-align:center;" colspan="3">第1天</th>
						<th style="text-align:center;" colspan="3">第2天</th>
						<th style="text-align:center;" colspan="3">第3天</th>
						<th style="text-align:center;">第4天</th>
						<th style="text-align:center;" rowspan="2">3天用餐总人数</th>
					</tr>
					<tr>
						<th style="text-align:center;">晚</th>
						<th style="text-align:center;">早</th>
						<th style="text-align:center;">中</th>
						<th style="text-align:center;">晚</th>
						<th style="text-align:center;">早</th>
						<th style="text-align:center;">中</th>
						<th style="text-align:center;">晚</th>
						<th style="text-align:center;">早</th>
						<th style="text-align:center;">中</th>
						<th style="text-align:center;">晚</th>
						<th style="text-align:center;">早</th>
					</tr>
					<tr>
						<td><tag:numberInput name="familyMembers" value="${monitor.familyMembers}" reg='{"min":0,"max":30}'/></td>
						<td><tag:numberInput name="zeroDaySupperPt" value="${monitor.zeroDaySupperPt}" reg='{"min":0,"max":30}'/></td>
						<td><tag:numberInput name="firstBreakfirstPt" value="${monitor.firstBreakfirstPt}" reg='{"min":0,"max":30}'/></td>
						<td><tag:numberInput name="firstLunchPt" value="${monitor.firstLunchPt}" reg='{"min":0,"max":30}'/></td>
						<td><tag:numberInput name="firstSupperPt" value="${monitor.firstSupperPt}" reg='{"min":0,"max":30}'/></td>
						<td><tag:numberInput name="secondBreakfirstPt" value="${monitor.secondBreakfirstPt}" reg='{"min":0,"max":30}'/></td>
						<td><tag:numberInput name="secondLunchPt" value="${monitor.secondLunchPt}" reg='{"min":0,"max":30}'/></td>
						<td><tag:numberInput name="secondSupperPt" value="${monitor.secondSupperPt}" reg='{"min":0,"max":30}'/></td>
						<td><tag:numberInput name="thirdBreakfirstPt" value="${monitor.thirdBreakfirstPt}" reg='{"min":0,"max":30}'/></td>
						<td><tag:numberInput name="thirdLunchPt" value="${monitor.thirdLunchPt}" reg='{"min":0,"max":30}'/></td>
						<td><tag:numberInput name="thirdSupperPt" value="${monitor.thirdSupperPt}" reg='{"min":0,"max":30}'/></td>
						<td><tag:numberInput name="fourthBreakfirstPt" value="${monitor.fourthBreakfirstPt}" reg='{"min":0,"max":30}'/></td>
						<td><input name="threeDaysDiningPtSalt" type="text" readonly="true" value="${monitor.threeDaysDiningPtSalt}" reg='{"min":0,"max":270}'/></td>
					</tr>
					</tbody>
				</table>
				</div>
			</fieldset>
			<fieldset>
				<legend>家庭三日日人均摄盐量调查</legend>
				<table class="posttable">
					<colgroup>
						<col style="min-width:70px; width: 17%;"/>
						<col style="min-width:100px; width: 16%;"/>
						<col style="min-width:70px; width: 17%;"/>
						<col style="min-width:100px; width: 16%;"/>
	                    <col style="min-width:70px; width: 17%;"/>
	                    <col style="min-width:183px; width: 16%;"/>
					</colgroup>
					<tbody>
					<tr>
						<th>第1天早餐前盐罐重量</th>
						<td><tag:numberInput name="saltcellarWeightBefore" point="point" value="${monitor.saltcellarWeightBefore}" style="width: 60px" reg='{"min":0,"max":10000}'/>g</td>
						<th>第3天晚餐后盐罐重量</th>
						<td><tag:numberInput name="saltcellarWeightAfter" point="point" value="${monitor.saltcellarWeightAfter}" style="width: 60px" reg='{"min":0,"max":10000}'/>g</td>
						<th>日人均摄盐量</th>
						<td><input name="averageSaltIntake" type="text" readonly="true" value="${monitor.averageSaltIntake}" style="width: 40px" />  g/人*天</td>
					</tr>
					<tr>
						<th>备注</th>
						<td colspan="5"><input type="text" name="saltIntakeRemark" value="${monitor.saltIntakeRemark}" reg='{"maxlength":"100"}' /></td>
					</tr>
					</tbody>
				</table>
			</fieldset>
			<fieldset>
				<legend>家庭三日日人均酱油摄入量调查</legend>
				<table class="posttable">
					<colgroup>
						<col style="min-width:70px; width: 17%;"/>
						<col style="min-width:100px; width: 16%;"/>
						<col style="min-width:70px; width: 17%;"/>
						<col style="min-width:100px; width: 16%;"/>
	                    <col style="min-width:70px; width: 17%;"/>
	                    <col style="min-width:183px; width: 16%;"/>
					</colgroup>
					<tbody>
					<tr>
						<th>第1天早餐前酱油重量</th>
						<td><tag:numberInput name="soyWeightBefore" point="point" value="${monitor.soyWeightBefore}" style="width: 60px" reg='{"min":0,"max":10000}'/>g</td>
						<th>第3天晚餐后酱油重量</th>
						<td><tag:numberInput name="soyWeightAfter" point="point" value="${monitor.soyWeightAfter}" style="width: 60px" reg='{"min":0,"max":10000}'/>g</td>
						<th>日人均酱油摄入量</th>
						<td><input name="averageSoyIntake" type="text" readonly="true" value="${monitor.averageSoyIntake}" style="width: 40px" />  g/人*天</td>
					</tr>
					<tr>
						<th>备注</th>
						<td colspan="5"><input type="text" name="soyIntakeRemark" value="${monitor.soyIntakeRemark}" reg='{"maxlength":"100"}' /></td>
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
						<td><input type="text"name="investigator" value="${monitor.investigator}" style="width: 200px" reg='{"maxlength":"20"}' /></td>
						<th>调查单位</th>
						<td><input type="text" name="investigateUnit" value="${monitor.investigateUnit}" style="width: 200px" reg='{"maxlength":"50"}' /></td>
						<th>调查时间</th>
						<td><tag:dateInput onlypast="true" name="investigateTime" pattern="yyyy/MM/dd" date="${monitor.investigateTime}" style="width:75px;" /></td>
					</tr>
					</tbody>
				</table>
			</fieldset>
		</div>
	</div>
</form>
</div>
