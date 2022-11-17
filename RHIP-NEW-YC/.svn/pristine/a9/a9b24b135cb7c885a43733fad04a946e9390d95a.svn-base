<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/views/ep/iodineNutrition/knowledgeInfoEdit.js"></script>
<div id="infoEditFormDiv">
<form id="infoEditForm">
	<div class="postcontent">
		<div class="postdiv">
			<fieldset>
				<legend>问卷信息</legend>
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
						<th><label class="required">抽样点类型</label></th>
						<td><ehr:dic-list id="sampling_type" name="samplingLocationType" dicmeta="FS10272" value="${knowledge.samplingLocationType}" reg='{"required":"true"}' />
						<input type="hidden" name="id" value="${knowledge.id}" /></td>
						<th><label class="required">抽样点名称</label></th>
						<td>
							<select id="sampling_name" name="samplingId" reg="{'required':'true'}" >
								<option value="">请选择</option>
								<c:forEach var="sampling" items="${samplingList}">
									<option value="${sampling.id}"  ${sampling.id eq knowledge.samplingId ? "selected" : ""}>${sampling.name}</option>
								</c:forEach> 
							</select>
						</td>
						<th><label class="required">调查人数</label></th>
						<td><tag:numberInput name="totalPersonNo" value="${knowledge.totalPersonNo}" style="width: 60px" reg='{"required":"true","min":0,"max":1000}'/></td>
					</tr>
					<tr>
						<th><label class="required">每人应答问题数</label></th>
						<td><tag:numberInput name="questionsForEach" value="${knowledge.questionsForEach}" style="width: 60px" reg='{"required":"true","min":0,"max":10}'/></td>
						<th><label class="required">正确答题数之和</label></th>
						<td><tag:numberInput name="totalCorrectAnswers" value="${knowledge.totalCorrectAnswers}" style="width: 60px" reg='{"required":"true","min":0,"max":10000}'/></td>
						<th><label class="required">知晓率</label></th>
						<td><input type="text" name="awarenessRate" value="${knowledge.awarenessRate}" style="width: 50px" readonly="true" reg='{"required":"true","min":0,"max":100}'/>%</td>
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
						<td><input type="text"name="investigator" value="${knowledge.investigator}" style="width: 80px" reg='{"required":"true", "maxlength":"20"}' /></td>
						<th><label class="required">调查单位</label></th>
						<td><input type="text" name="investigateUnit" value="${knowledge.investigateUnit}" style="width: 150px" reg='{"required":"true", "maxlength":"50"}' /></td>
						<th><label class="required">调查时间</label></th>
						<td><tag:dateInput onlypast="true" name="investigateTime" pattern="yyyy/MM/dd" date="${knowledge.investigateTime}" style="width:75px;" reg='{"required":"true"}'/></td>
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