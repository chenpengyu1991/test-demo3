<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/views/ep/iodate/monitorEdit.js"/>
<div>
	<div class="postcontent">
		<form id="editForm" class="postcontent">
			<input type="hidden" name="id" value="${record.id}"/>
			<input type="hidden" name="function" value="monitorRecord"/>
			<table class="posttable">
				<tr>
					<td><label class="required"><b>监测日期：</b></label>
						<input type="text" reg='{"required":"true"}'  class="layui-input x-admin-content-sm-date" name="monitorTime" id="monitorTime"
							   value="<fmt:formatDate value='${record.monitorTime}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px; width: 100px;" />
					</td>
				</tr>
			</table>
			<fieldset class="layui-elem-field">
				<legend>监测记录</legend>
				<table class="posttable">
					<colgroup>
						<col style="width: 17%;"/>
						<col style="width: 33%;"/>
						<col style="width: 17%;"/>
						<col style="width: 33%;"/>
					</colgroup>
					<tbody>
					<tr>
						<th><label class="required">永城市</label></th>
						<td colspan="3">
							<select id="monitorTown1" name="gbCode" style="width: 150px" reg="{'required':'true'}">
								<option value="">请选择</option>
								<c:forEach var="town" items="${townList}">
									<option value="${town[0]}" ${record.gbCode eq town[0] ? "selected" : ""}>${town[1]}</option>
								</c:forEach>
							</select>
							<select id="monitorVillage1" name="villageCode" style="width: 150px"  reg="{'required':'true'}">
								<option value="">请选择</option>
								<c:forEach var="village" items="${villages}">
									<option value="${village[1]}" ${record.villageCode eq village[1] ? "selected" : ""}>${village[0]}</option>
								</c:forEach>
							</select>
						</td>
					</tr>
					<tr>
						<th><label class="required">户主姓名</label></th>
						<td><input type="text" class="x-layui-input" name="name" value="${record.name}" style="width: 150px" reg="{'required':'true','maxlength':100}"/></td>
						<th>随机号</th>
						<td><input type="text" class="x-layui-input" name="randomNumber" value="${record.randomNumber}" style="width: 150px" reg="{'maxlength':50}"/></td>
					</tr>
					<tr>
						<th>户主身份证号</th>
						<td><tag:idcardInput name="idCard" value="${record.idCard}" style="width: 150px" reg="{'creditcard':'true'}"/></td>
						<th>食盐种类</th>
						<td><ehr:dic-list name="EndemicPreventDTO.saltTestRecords[0].saltType" dicmeta="FS10259" code="3,4,5,6" value="${test.saltType}" width="150px"/></td>
					</tr>
					<tr>
						<th>联系电话</th>
						<td><input type="text" class="x-layui-input" name="telephone" value="${record.telephone}" style="width: 150px" reg="{'maxlength':50}"/></td>
						<th>是否海藻碘盐或强化盐</th>
						<td><ehr:dic-list name="EndemicPreventDTO.saltTestRecords[0].specialSaltStatus" dicmeta="FS10246" value="${test.specialSaltStatus}" width="150px"/></td>
					</tr>
					<tr>
						<th>家中是否有孕妇</th>
						<td><ehr:dic-list name="gravidaStatus" dicmeta="FS10246" value="${record.gravidaStatus}" width="150px"/></td>
					</tr>
					</tbody>
				</table>
			</fieldset>
			<div style="display: ${displayTest}">
				<fieldset class="layui-elem-field">
					<legend>现场半定量监测</legend>
					<table class="posttable">
						<colgroup>
							<col style="width: 17%;"/>
							<col style="width: 83%;"/>
						</colgroup>
						<tbody>
						<tr>
							<th><label class="required">监测结果</label></th>
							<td><ehr:dic-list name="EndemicPreventDTO.saltTestRecords[0].testResult" dicmeta="FS10260" value="${test.testResult}" width="150px" reg="{'required':'true'}"/></td>
						</tr>
						<tr>
							<th>备注</th>
							<td><textarea class="x-layui-input" name="EndemicPreventDTO.saltTestRecords[0].testRemark" rows="5" reg="{'maxlength':100}">${test.testRemark}</textarea></td>
						</tr>
						</tbody>
					</table>
				</fieldset>
				<fieldset class="layui-elem-field">
					<legend>实验室检测记录</legend>
					<table class="posttable">
						<colgroup>
							<col style="width: 17%;"/>
							<col style="width: 33%;"/>
							<col style="width: 17%;"/>
							<col style="width: 33%;"/>
						</colgroup>
						<tbody>
						<tr>
							<th>实验室</th>
							<td><input type="text" class="x-layui-input" name="EndemicPreventDTO.saltTestRecords[0].laboratory" value="${test.laboratory}" style="width: 150px" reg="{'maxlength':50}"/></td>
							<th>该省选定的碘盐含量</th>
							<td><input type="text" class="x-layui-input" name="EndemicPreventDTO.saltTestRecords[0].provinceIodineStandard" value="${test.provinceIodineStandard}" style="width: 150px" reg="{'maxlength':100}"/> mg/Kg</td>
						</tr>
						<tr>
							<th>样品原编号</th>
							<td><input type="text" class="x-layui-input" name="EndemicPreventDTO.saltTestRecords[0].saltSamplingNumber" value="${test.saltSamplingNumber}" style="width: 150px" reg="{'maxlength':50}"/></td>
							<th>监测方法</th>
							<td><input type="text" class="x-layui-input" name="EndemicPreventDTO.saltTestRecords[0].monitorMethod" value="${test.monitorMethod}" style="width: 150px" reg="{'maxlength':50}"/></td>
						</tr>
						<tr>
							<th>实验室监测编号</th>
							<td><input type="text" class="x-layui-input" name="EndemicPreventDTO.saltTestRecords[0].monitorNumber" value="${test.monitorNumber}" style="width: 150px" reg="{'maxlength':50}"/></td>
							<th><label class="required">测定结果</label></th>
							<td><input type="text" class="x-layui-input" name="EndemicPreventDTO.saltTestRecords[0].determinedResult" value="${test.determinedResult}" style="width: 150px" reg='{"required":"true","number":"true","scale":4,"max":999999.9999}'/> mg/Kg</td>
						</tr>
						<tr>
							<th>备注</th>
							<td colspan="3"><textarea class="x-layui-input" name="EndemicPreventDTO.saltTestRecords[0].labCheckRemark" rows="5" reg="{'maxlength':200}">${test.labCheckRemark}</textarea></td>
						</tr>
						</tbody>
					</table>
				</fieldset>
			</div>
		</form>
		<div style="text-align: center;margin-top: -15px;">
			<a id="save" href="javascript:void(0)" ><button class="layui-btn layui-btn-sm">保存</button></a>
		</div>
	</div>
	<div><input type="hidden" id="dialogId" value="monitorRecordDialog"/></div>
</div>

<script type="text/javascript">
	layui.use('laydate', function(){
		var laydate = layui.laydate;

		laydate.render({
			elem: '#monitorTime'
			,format: 'yyyy/MM/dd'
			,max:0
			,trigger: 'click'
		});
	});
</script>