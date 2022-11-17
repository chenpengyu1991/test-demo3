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
</div>
<form id="infoEditForm">
	<div class="postcontent contentfixed">
		<i class="popno">8-10岁儿童监测调查记录</i>
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
						<td colspan="3"><ehr:dic dicmeta="GBT226112003" code="${monitor.gender}" /></td>
					</tr>
					<tr>
						<th>学校地址</th>
						<td colspan="5">河南省永城市<ehr:dic dicmeta="FS990001" code="${monitor.gbCode}" />
							<ehr:dic dicmeta="FS990001" code="${monitor.villageCode}" />
							<c:if test="${not empty monitor.schoolName}" >${monitor.schoolName}</c:if>
							<c:if test="${not empty monitor.className}" >${monitor.className}班</c:if>
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
						<td><ehr:dic dicmeta="FS10262" code="${monitor.saltSource}" /></td>
						<th>食盐种类</th>
						<td><ehr:dic dicmeta="FS10259" code="${monitor.saltType}" /></td>
						<th>一年内是否服用碘丸</th>
						<td><ehr:dic dicmeta="PH00001" code="${monitor.iodizedOilCapsule}" /></td>
					</tr>
					<tr>
						<th>尿样检测结果</th>
						<td>${monitor.urineTestResult}μg/L</td>
						<th>碘盐检测结果</th>
						<td colspan="3">${monitor.saltIodineContent}mg/kg</td>
					</tr>
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
						<td><ehr:dic dicmeta="FS10263" code="${monitor.thyroidPalpation}" /></td>
						<th>左宽</th>
						<td>${monitor.tyroidLeftWidth}mm</td>
						<th>右宽</th>
						<td>${monitor.tyroidRightWidth}mm</td>
					</tr>
					<tr>
						<th>智商答对题数</th>
						<td>${monitor.intelligenceQuestScore}</td>
						<th>左长</th>
						<td>${monitor.tyroidLeftLength}mm</td>
						<th>右长</th>
						<td>${monitor.tyroidRightLength}mm</td>
					</tr>
					<tr>
						<th></th>
						<td></td>
						<th>左厚</th>
						<td>${monitor.tyroidLeftHeight}mm</td>
						<th>右厚</th>
						<td>${monitor.tyroidRightHeight}mm</td>
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
						<td>${monitor.familyMembers}</td>
						<td>${monitor.zeroDaySupperPt}</td>
						<td>${monitor.firstBreakfirstPt}</td>
						<td>${monitor.firstLunchPt}</td>
						<td>${monitor.firstSupperPt}</td>
						<td>${monitor.secondBreakfirstPt}</td>
						<td>${monitor.secondLunchPt}</td>
						<td>${monitor.secondSupperPt}</td>
						<td>${monitor.thirdBreakfirstPt}</td>
						<td>${monitor.thirdLunchPt}</td>
						<td>${monitor.thirdSupperPt}</td>
						<td>${monitor.fourthBreakfirstPt}</td>
						<td>${monitor.threeDaysDiningPtSalt}</td>
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
						<td>${monitor.saltcellarWeightBefore}g</td>
						<th>第3天晚餐后盐罐重量</th>
						<td>${monitor.saltcellarWeightAfter}g</td>
						<th>日人均摄盐量</th>
						<td>${monitor.averageSaltIntake}  g/人*天</td>
					</tr>
					<tr>
						<th>备注</th>
						<td colspan="5">${monitor.saltIntakeRemark}</td>
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
						<td>${monitor.soyWeightBefore}g</td>
						<th>第3天晚餐后酱油重量</th>
						<td>${monitor.soyWeightAfter}g</td>
						<th>日人均酱油摄入量</th>
						<td>${monitor.averageSoyIntake}  g/人*天</td>
					</tr>
					<tr>
						<th>备注</th>
						<td colspan="5">${monitor.soyIntakeRemark}</td>
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
