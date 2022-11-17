<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/views/ep/iodate/samplingEdit.js"/>
<div>
	<div class="postcontent">
		<form id="editForm" class="postcontent">
			<input type="hidden" id="id" name="id" value="${base.id}"/>
			<table class="posttable">
				<colgroup>
					<col style="width: 20%"/>
					<col style="width: 80%"/>
				</colgroup>
				<tr>
					<th><label class="required">抽检方向</label></th>
					<td>
						<ehr:dic-list id="position" name="position" dicmeta="FS10270" value="${base.position}" reg="{'required':'true'}"/>
					</td>
				</tr>
				<tr>
					<th><label class="required">被抽取乡镇</label></th>
					<td>
						<ehr:dic-town-village townId="samplingTown" townName="gbCode" townValue="${base.gbCode}" width="150px" reg="{'required':'true'}"/>
						<input type="hidden" name="oldTown" value="${base.gbCode}"/>
					</td>
				</tr>
				<tr>
					<th><label class="required">被抽取村</label></th>
					<td>
						<table>
							<colgroup>
								<col style="width: 80%"/>
								<col style="width: 20%"/>
							</colgroup>
							<input type="hidden" id="villageCount" value="${villageCount}"/>
							<tbody id="villageTable">
							<c:forEach var="record" items="${samplingRecords}" varStatus="idx">
								<tr>
									<td>
										<select name="EndemicPreventDTO.samplingRecords[${idx.index}].villageCode" style="width: 150px" reg="{'required':'true'}">
											<option value="">请选择</option>
											<c:forEach var="village" items="${villages}">
												<option value="${village.itemCode}" ${village.itemCode eq record.villageCode ? "selected" : ""}>${village.itemName}</option>
											</c:forEach>
										</select>
									</td>
									<td>
										
										<a title="删除" class="layui-btn layui-btn-danger layui-btn-xs" href="javascript:void(0)" onclick="epSamplingEdit.deleteRecord(this)" style="color: #FFF;font-size: 12px;"><i class="layui-icon">&#xe640;</i>删除</a>
									</td>
								</tr>
							</c:forEach>
							</tbody>
							<tbody>
							<tr>
								<td>
									<a title="添加" class="add-link layui-btn layui-btn-xs" href="javascript:void(0)" onclick="epSamplingEdit.addRecord()" style="color: #FFF;font-size: 12px;"><i class="layui-icon">&#xe61f;</i>添加</a>
									<!-- <a href="javascript:void(0);"  onclick="epSamplingEdit.addRecord()" title="添加"><i class="layui-icon">&#xe608;</i></a> -->
								</td>
							</tr>
							</tbody>
						</table>
					</td>
				</tr>
				<tr>
					<th><label class="required">抽样日期</label></th>
					<td>
						<input type="text" reg='{"required":"true"}'  class="layui-input x-admin-content-sm-date" name="samplingTime" id="samplingTimeTemp"
							   value="<fmt:formatDate value='${base.samplingTime}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;" />
					</td>
				</tr>
			</table>
		</form>
		<div style="text-align: center;margin-top: -15px;">
			<a id="save" href="javascript:void(0)" ><button class="layui-btn layui-btn-sm">保存</button></a>
		</div>
	</div>
	<div style="display: none">
		<table id="villageRow">
			<tr>
				<td>
					<select name="EndemicPreventDTO.samplingRecords[index].villageCode" style="width: 150px" reg="{'required':'true'}">
						<option value="">请选择</option>
						<c:forEach var="village" items="${villages}">
							<option value="${village.itemCode}">${village.itemName}</option>
						</c:forEach>
					</select>
				</td>
				<td>
					<!-- <a href="javascript:void(0);"  onclick="epSamplingEdit.deleteRecord(this)" title="删除"><i class="layui-icon">&#xe640;</i></a> -->
					<a title="删除" class="layui-btn layui-btn-danger layui-btn-xs" href="javascript:void(0)" onclick="epSamplingEdit.deleteRecord(this)" style="color: #FFF;font-size: 12px;"><i class="layui-icon">&#xe640;</i>删除</a>
				</td>
			</tr>
		</table>
	</div>
</div>

<script type="text/javascript">
	layui.use('laydate', function(){
		var laydate = layui.laydate;

		laydate.render({
			elem: '#samplingTimeTemp'
			,format: 'yyyy/MM/dd'
			,max:0
			,trigger: 'click'
		});
	});
</script>