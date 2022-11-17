<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="ehr" uri="/ehr-tag"%>
<script src="${pageContext.request.contextPath}/js/views/oh/pesticidePoison/edit.js" type="text/javascript"></script>

<div id="ohPoisonReportAdd">
	<div class="postcontent">
		<form method="post" id="edit_form">
			<input id="operationType" name="operationType" type="hidden" value="${operationType }">
			<input name="id" type="hidden" value="${record.id} " />
			<input id="verifyState" name="verifyState" type="hidden" value="${record.verifyState }">
			<input name="isDelete" type="hidden" value="${record.isDelete }">
			<input id="checkFlag" type="hidden"  value="${record.otherFlag }">
			<input id="createBy" name="createBy" type="hidden" value="${record.createBy }">
			<input id="createOrganCode" name="createOrganCode" type="hidden" value="${record.createOrganCode }">
			<tag:dateInput id="createTime" name="createTime" pattern="yyyy/MM/dd" date="${record.createTime}" style="width: 100px;display:none"/>
				<fieldset class="layui-elem-field">
					<legend>农药中毒报告</legend>
					<table style="width: 99%" class="posttable">
						<tbody>
						<colgroup>
							<col width="18%" />
							<col width="35%" />
							<col width="18%" />
							<col width="35%" />
						<colgroup>
						<tr>
							<th><label>报卡类别:</label></th>
							<td><ehr:dic-radio reg='{"required":"true"}' id="cardType" name="cardType" dicmeta="FS10016" value="${record.cardType }"></ehr:dic-radio></td>
							<th><label>卡片序号:</label></th>
							<td>
							    <c:choose>
							        <c:when test="${operationType=='1' }">${record.cardNo}</c:when>
							        <c:otherwise><input type="text" class="x-layui-input" name="cardNo" value="${record.cardNo}" reg='{"maxlength":"20"}'></c:otherwise>
							    </c:choose>
							</td>
						</tr>
						<tr>
						    <th><label <c:if test="${operationType != '1'}">class="required"</c:if>>身份证号:</label></th>
							<td>
							    <c:choose>
							        <c:when test="${operationType=='1' }">${record.idcard}</c:when>
							        <c:otherwise><input type="text" class="x-layui-input" id="idcard" name="idcard" value="${record.idcard}" reg='{"required":"true","idCard":true,"maxlength":"18"}' placeholder="输入身份证获取人员信息"></c:otherwise>
							    </c:choose>
							</td>
							<th><label <c:if test="${operationType != '1'}">class="required"</c:if>>姓名:</label></th>
							<td>
							    <c:choose>
							        <c:when test="${operationType=='1' }">${record.name}</c:when>
							        <c:otherwise><input type="text" class="x-layui-input" id="name" name="name" value="${record.name}" reg='{"required":"true","maxlength":"16"}'></c:otherwise>
							    </c:choose>
							    </td>
						</tr>
						<tr>
							<th><label <c:if test="${operationType != '1'}">class="required"</c:if>>年龄:</label></th>
							<td>
							    <c:choose>
							        <c:when test="${operationType=='1' }">${record.age}</c:when>
							        <c:otherwise><input type="text" class="x-layui-input" id="age" name="age" value="${record.age}" reg='{"required":"true","regex":"digits","maxlength":"3"}'></c:otherwise>
							    </c:choose>
							</td>
							<th><label <c:if test="${operationType != '1'}">class="required"</c:if>>性别:</label></th>
							<td>
							    <ehr:dic-list id="gender" dicmeta="GBT226112003" name="gender" value="${record.gender}" reg='{"required":"true"}'/>
							</td>
						</tr>
						<tr>
						    <th><label <c:if test="${operationType != '1'}">class="required"</c:if>>现住址:</label></th>
						    <td colspan="4">
								<ehr:dic-town-street-village villageId="pavillage_address" streetId="street_address"
															 townId="patown_address" villageName="paGroup" streetName="pastreet"
															 townName="patownShip" villageValue="${record.paGroup}" streetValue="${record.pastreet}"
															 townValue="${record.patownShip}" width="118px;" reg="{'required':true}" />

								<span id="spanPaNumber">门牌号:</span>
								<c:choose>
									<c:when test="${operationType=='1' }">${record.pahouseNumber}</c:when>
									<c:otherwise><input type="text" class="x-layui-input" id="pahouseNumber" name="pahouseNumber" value="${record.pahouseNumber}" reg='{"required":"true","maxlength":"20"}' style="width: 180px;"/></c:otherwise>
								</c:choose>
							</td>
						</tr>
						<tr>
							<th><label>文化程度:</label></th>
							<td><ehr:dic-list id="education" name="education" dicmeta="GBT46582006" code="IDM09,IDM07,IDM02,IDM03,IDM08,IDM11" value="${record.education }" /></td>
							<th><label>中毒农药名称:</label></th>
							<td>
							    <c:choose>
							        <c:when test="${operationType=='1' }">${record.drugName}</c:when>
							        <c:otherwise><input type="text" class="x-layui-input" name="drugName" value="${record.drugName}" reg='{"maxlength":"16"}'/></c:otherwise>
							    </c:choose>
							</td>
						</tr>
						<tr>
							<th><label>中毒农药种类:</label></th>
							<td><ehr:dic-list id="drugTypes" name="drugType" dicmeta="CV0300204" value="${record.drugType }"></ehr:dic-list></td>
							<th><label>中毒类型:</label></th>
							<td><ehr:dic-list id="poisonType" name="poisonType" dicmeta="CV510123" value="${record.poisonType }"></ehr:dic-list></td>
						</tr>
						<tr>
							<th><label>中毒原因:</label></th>
							<td>
								<ehr:dic-cascaded-list firstId="poisonReasonCode" secId="poisonReasonSubcode" dicmetaFirst="OH00007" dicmetaSec="OH00008" firstName="poisonReasonCode" secName="poisonReasonSubcode" firstValue="${ record.poisonReasonCode}" secValue="${ record.poisonReasonSubcode}"></ehr:dic-cascaded-list>
							</td>
							<th><label>中毒程度:</label></th>
							<td><ehr:dic-list id="poisonLevel" name="poisonLevel" dicmeta="OH00004" value="${record.poisonLevel }"></ehr:dic-list></td>
						</tr>
						<tr>
							<th><label>转归:</label></th>
							<td><ehr:dic-list id="outcome" name="outcome" dicmeta="CV550102" value="${record.outcome }"></ehr:dic-list></td>
							<th class="deathDate"><label>死亡日期:</label></th>
							<td class="deathDate">
							    <c:choose>
							        <c:when test="${operationType=='1' }"><fmt:formatDate value="${record.deathDate}" pattern="yyyy/MM/dd"/></c:when>
							        <c:otherwise>
										<input type="text" reg='{"required":"true"}'  class="layui-input x-admin-content-sm-date" minId="diagnosisDt" name="deathDate" id="deathDate"
											   value="<fmt:formatDate value='${record.deathDate}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;" />
							        </c:otherwise>
							    </c:choose>
							</td>
						</tr>
						<tr>
							<th><label>诊断日期:</label></th>
							<td>
							    <c:choose>
							        <c:when test="${operationType=='1' }"><fmt:formatDate value="${record.diagnosisDt}" pattern="yyyy/MM/dd"/></c:when>
							        <c:otherwise>
                                        <input type="text" maxId="diagnosisDt" reg='{"required":"true"}'  class="layui-input x-admin-content-sm-date"  name="diagnosisDt" id="diagnosisDt"
                                               value="<fmt:formatDate value='${record.diagnosisDt}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;" />
							        </c:otherwise>
							    </c:choose>
							</td>
							<th><label>报告日期:</label></th>
							<td>
							    <c:choose>
							        <c:when test="${operationType=='1' }"><fmt:formatDate value="${record.reportDate}" pattern="yyyy/MM/dd"/></c:when>
							        <c:otherwise>
										<input type="text" maxId="deathDate" reg='{"required":"true"}'  class="layui-input x-admin-content-sm-date"  name="reportDate" id="reportDate"
											   value="<fmt:formatDate value='${record.reportDate}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;" />
							        </c:otherwise>
							    </c:choose>
							</td>
						</tr>
						<tr>
							<th><label>诊断单位:</label></th>
							<td>
							    <ehr:org-type-list id="diagnosisOrg"  width="180px" name="diagnosisOrg" type="hospital,centre"  value="${record.diagnosisOrg}"/>
							             外地诊断:<input id="otherFlag" type="checkbox" value="1" name="otherFlag" ${record.otherFlag eq '1' ?'checked':''}>
							    <c:choose>
							        <c:when test="${operationType=='1'}">${record.otherOrg}</c:when>
							        <c:otherwise><input id="otherOrg" class="x-layui-input" name="otherOrg" style="width:150px " reg="{'maxlength':16,'dependOn':'otherFlag','required':true}" type="text" value="${record.otherOrg}" /></c:otherwise>
							    </c:choose>
							</td>
							<th><label>单位负责人:</label></th>
							<td>
							     <c:choose>
							        <c:when test="${operationType=='1' }">${record.headUnit}</c:when>
							        <c:otherwise><input type="text" class="x-layui-input" name="headUnit" value="${record.headUnit}" reg='{"maxlength":"16"}' /></c:otherwise>
							     </c:choose>
						    </td>
						</tr>
						<tr>
							<th><label>报告人:</label></th>
							<td>
							     <c:choose>
							        <c:when test="${operationType=='1' }">${record.reporter}</c:when>
							        <c:otherwise><input type="text" class="x-layui-input" name="reporter" value="${record.reporter}" reg='{"maxlength":"16"}'/></c:otherwise>
							     </c:choose>
							</td>
							<th><label>报告人联系电话:</label></th>
							<td>
							    <c:choose>
							        <c:when test="${operationType=='1' }">${record.reporterTel}</c:when>
							        <c:otherwise><input type="text" class="x-layui-input" name="reporterTel" value="${record.reporterTel}" reg='{"maxlength":"18","regex":"phone"}' /></c:otherwise>
							     </c:choose>
							</td>
						</tr>
						<tr>
						    <th><label>备注:</label></th>
							<td colspan="3">
							    <c:choose>
							        <c:when test="${operationType=='1' }">${record.remark}</c:when>
							        <c:otherwise><input type="text" class="x-layui-input" name="remark" value="${record.remark}" reg='{"maxlength":"200"}'/></c:otherwise>
							     </c:choose>
							</td>
						</tr>
						</tbody>
					</table>
				</fieldset>
		</form>
		<div style="text-align: center">
			<c:choose>
				<c:when test="${operationType=='4' }">
					<a id="checkRecord" href="javascript:void(0)" onclick="editRecord.checkRecord(${record.id})" ><button class="layui-btn layui-btn-sm">审核</button></a>
					<a id="cancleRecord" href="javascript:void(0)" onclick="editRecord.unCheckRecord(${record.id})" ><button class="layui-btn layui-btn-sm">退回</button></a>
				</c:when>
				<c:when test="${operationType=='1' }"></c:when>
				<c:otherwise>
					<a id="saveRecord" href="javascript:void(0)" onclick="editRecord.save()" ><button class="layui-btn layui-btn-sm">保存</button></a>
					<a id="cancleRecord" href="javascript:void(0)" onclick="editRecord.cancle()" ><button class="layui-btn layui-btn-sm">取消</button></a>
				</c:otherwise>
			</c:choose>
		</div>
	</div>
</div>

<script type="text/javascript">
	layui.use('laydate', function(){
		var laydate = layui.laydate;

		laydate.render({
			elem: '#deathDate'
			,format: 'yyyy/MM/dd'
			,max:0
			,trigger: 'click'
		});

		laydate.render({
			elem: '#diagnosisDt'
			,format: 'yyyy/MM/dd'
			,max:0
			,trigger: 'click'
		});

		laydate.render({
			elem: '#reportDate'
			,format: 'yyyy/MM/dd'
			,max:0
			,trigger: 'click'
		});

	});
</script>
