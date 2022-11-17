<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/views/ep/iodate/monitorEdit.js"/>
<script>
	var nonIodizedSaltEdit = (function() {
		$(function() {
			layui.use('laydate', function(){
		        var laydate = layui.laydate;
				//年月日
				laydate.render({
				  elem: '#monitorTime'
				  ,format: 'yyyy/MM/dd'
				  ,max:0 //今天之后不可选
				});
			});
			
			$("#addSalt").click(function() {
				saltIncrease();
				epMonitorEdit.revalidate();
			})
		});

		function deleteSalt(obj) {
			if ($("#saltTable tr").length == 2) {
				saltIncrease();
			}
			$(obj).closest("tr").remove();
			epMonitorEdit.revalidate();
		}

		function saltIncrease() {
			var no = $("#saltNumbers").val();
			$("#saltNumbers").val(no * 1 + 1);
			$("#saltTable").append($("#saltRow").html().replace(new RegExp("index", "g"), no));
		}

		return {
			deleteSalt : deleteSalt
		}
	})();
</script>
<div>
	<form id="editForm">
		<div class="postcontent">
		<c:if test="${surveyType eq 1}">
			<i class="popno">非碘盐用户调查表</i>
		</c:if>
		<c:if test="${surveyType eq 2}">
			<i class="popno">非碘盐户所在村零售点食用盐调查表</i>
		</c:if>
		<div class="postdiv">
			<input type="hidden" name="id" value="${record.id}"/>
			<input type="hidden" name="surveyType" value="${surveyType}"/>
			<input type="hidden" name="function" value="nonIodizedSalt"/>
			<table class="posttable">
				<tr>
					<td><label class="required"><b>调查日期：</b></label>
						<input type="text" name="monitorTime" id="monitorTime" value="<fmt:formatDate value="${record.monitorTime}" pattern="yyyy/MM/dd"/>" 
						style="padding-left: 0px;width: 100px;" reg="{'required':'true'}"/>
					</td>
				</tr>
			</table>
			<c:if test="${surveyType eq 1}">
				<fieldset class="layui-elem-field">
					<legend>调查对象</legend>
					<table class="posttable">
						<colgroup>
							<col style="width: 15%"/>
							<col style="width: 35%"/>
							<col style="width: 15%"/>
							<col style="width: 35%"/>
						</colgroup>
						<tbody>
						<tr>
							<th><label class="required">地址</label></th>
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
								<input type="text" name="houseNumber" value="${record.houseNumber}" style="width: 150px" reg="{'maxlength':50}"/> 组（门牌号）
							</td>
						</tr>
						<tr>
							<th><label class="required">户主姓名</label></th>
							<td colspan="3"><input type="text" name="name" value="${record.name}" style="width: 150px" reg="{'required':'true','maxlength':100}"/></td>
						</tr>
						</tbody>
					</table>
				</fieldset>
				<br/>
				<fieldset class="layui-elem-field">
					<legend>盐样调查及相关知识</legend>
					<table class="posttable">
						<colgroup>
							<col style="width: 15%"/>
							<col style="width: 35%"/>
							<col style="width: 15%"/>
							<col style="width: 35%"/>
						</colgroup>
						<tbody>
						<tr>
							<th><label class="required">盐样编号</label></th>
							<td><input type="text" name="EndemicPreventDTO.saltTestRecords[0].saltSamplingNumber" value="${record.saltSamplingNumber}" style="width: 150px" reg="{'required':'true','maxlength':50}"/></td>
							<th>是否知道碘缺乏病</th>
							<td><ehr:dic-radio name="knownIddFlag" dicmeta="FS10276" value="${record.knownIddFlag}"/></td>
						</tr>
						<tr>
							<th>盐样种类</th>
							<td><ehr:dic-list name="EndemicPreventDTO.saltTestRecords[0].saltType" dicmeta="FS10259" code="1,2" value="${test.saltType}" width="150px"/></td>
							<th>碘缺乏病是否可预防</th>
							<td><ehr:dic-radio name="iddPreventableFlag" dicmeta="FS10277" value="${record.iddPreventableFlag}"/></td>
						</tr>
						<tr>
							<th>价格</th>
							<td><tag:numberInput name="EndemicPreventDTO.saltTestRecords[0].saltPrice" value="${test.saltPrice}" point="true" style="width: 100px" reg="{'scale':2,'max':999.99}"/> 元/公斤</td>
							<th>碘缺乏病预防措施</th>
							<td><ehr:dic-radio name="premunition" dicmeta="FS10278" value="${record.premunition}"/></td>
						</tr>
						<tr>
							<th>购盐地方</th>
							<td><ehr:dic-list name="EndemicPreventDTO.saltTestRecords[0].saltSource" dicmeta="FS10262" code="1,2" value="${test.saltSource}" width="150px"/></td>
							<th>选择食盐的主要因素</th>
							<td><ehr:dic-radio name="saltChoiceFactor" dicmeta="FS10279" code="1,2,3,5" value="${record.saltChoiceFactor}"/></td>
						</tr>
						<tr>
							<th>包装</th>
							<td><ehr:dic-list name="EndemicPreventDTO.saltTestRecords[0].saltPackingType" dicmeta="FS10261" code="2,3" value="${test.saltPackingType}" width="150px"/></td>
						</tr>
						</tbody>
					</table>
				</fieldset>
			</c:if>

			<c:if test="${surveyType eq 2}">
				<fieldset class="layui-elem-field">
					<legend>调查对象</legend>
					<table class="posttable">
						<colgroup>
							<col style="width: 20%"/>
							<col style="width: 80%"/>
						</colgroup>
						<tbody>
						<tr>
							<th><label class="required">地址：</label></th>
							<td>
								<select id="monitorTown2" name="gbCode" style="width: 150px" reg="{'required':'true'}">
									<option value="">请选择</option>
									<c:forEach var="town" items="${townList}">
										<option value="${town[0]}" ${record.gbCode eq town[0] ? "selected" : ""}>${town[1]}</option>
									</c:forEach>
								</select>
								<select id="monitorVillage2" name="villageCode" style="width: 150px"  reg="{'required':'true'}">
									<option value="">请选择</option>
									<c:forEach var="village" items="${villages}">
										<option value="${village[1]}" ${record.villageCode eq village[1] ? "selected" : ""}>${village[0]}</option>
									</c:forEach>
								</select>
							</td>
						</tr>
						<tr>
							<th><label class="required">调查商店名称</label></th>
							<td><input type="text" name="name" value="${record.name}" style="width: 150px" reg="{'required':'true','maxlength':100}"/></td>
						</tr>
						</tbody>
					</table>
				</fieldset>
				<br/>
				<fieldset class="layui-elem-field">
					<legend>相关知识及购盐意向</legend>
					<table class="posttable">
						<colgroup>
							<col style="width: 20%"/>
							<col style="width: 80%"/>
						</colgroup>
						<tbody>
						<tr>
							<th>是否知道碘缺乏病</th>
							<td><ehr:dic-radio name="knownIddFlag" dicmeta="FS10276" value="${record.knownIddFlag}"/></td>
						</tr>
						<tr>
							<th>碘缺乏病是否可以预防</th>
							<td><ehr:dic-radio name="iddPreventableFlag" dicmeta="FS10277" value="${record.iddPreventableFlag}"/></td>
						</tr>
						<tr>
							<th>碘缺乏病的主要预防措施</th>
							<td><ehr:dic-radio name="premunition" dicmeta="FS10278" value="${record.premunition}"/></td>
						</tr>
						<tr>
							<th>食盐进货的主要决定因素</th>
							<td><ehr:dic-radio name="saltChoiceFactor" dicmeta="FS10279" code="1,2,4,5" value="${record.saltChoiceFactor}"/></td>
						</tr>
						</tbody>
					</table>
				</fieldset>
				<br/>
				<fieldset class="layui-elem-field">
					<legend><label class="required">盐样调查</label></legend>
					<div class="repeattable">
						<table id="saltTable" style="width: 90%">
							<colgroup>
								<col style="width: 15%"/>
								<col style="width: 15%"/>
								<col style="width: 15%"/>
								<col style="width: 15%"/>
								<col style="width: 16%"/>
								<col style="width: 10%"/>
								<col style="width: 7%"/>
							</colgroup>
							<tbody>
							<tr>
								<td><label class="required">品牌名称</label></td>
								<td><label class="required">食盐种类</label></td>
								<td><label class="required">食盐价格</label></td>
								<td><label class="required">包装</label></td>
								<td><label class="required">来源</label></td>
								<td><label class="required">检测结果</label></td>
								<td>
									<a id="addSalt" href="javascript:void(0)" class="layui-btn layui-btn-xs button" style="color: #FFF;font-size: 12px;margin-bottom: 3px;margin-left: 3px;"><i class="layui-icon">&#xe608;</i>添加</a>
								</td>
							</tr>
							<input type="hidden" id="saltNumbers" value="${saltCount}"/>
							<c:forEach var="salt" items="${saltList}" varStatus="idx">
								<tr>
									<td><input type="text" name="EndemicPreventDTO.saltTestRecords[${idx.index}].saltBrand" value="${salt.saltBrand}" reg="{'required':'true','maxlength':50}"/></td>
									<td><ehr:dic-list name="EndemicPreventDTO.saltTestRecords[${idx.index}].saltType" dicmeta="FS10259" code="1,2" value="${salt.saltType}" reg="{'required':'true'}"/></td>
									<td><ehr:dic-list name="EndemicPreventDTO.saltTestRecords[${idx.index}].saltPrice" dicmeta="FS10280" value="${salt.saltPrice}" reg="{'required':'true'}"/></td>
									<td><ehr:dic-list name="EndemicPreventDTO.saltTestRecords[${idx.index}].saltPackingType" dicmeta="FS10261" value="${salt.saltPackingType}" reg="{'required':'true'}"/></td>
									<td><ehr:dic-list name="EndemicPreventDTO.saltTestRecords[${idx.index}].saltSource" dicmeta="FS10262" code="3,4" value="${salt.saltSource}" reg="{'required':'true'}"/></td>
									<td><ehr:dic-list name="EndemicPreventDTO.saltTestRecords[${idx.index}].testResult" dicmeta="FS10260" value="${salt.testResult}" reg="{'required':'true'}"/></td>
									<td>
										<a href="javascript:void(0);" onclick="nonIodizedSaltEdit.deleteSalt(this)" title="删除" class="layui-btn layui-btn-danger layui-btn-xs" style="color: #FFF;font-size: 12px;margin-left: 3px;margin-bottom: 3px;"><i class="layui-icon">&#xe640;</i>删除</a>
									</td>
								</tr>
							</c:forEach>
							</tbody>
						</table>
					</div>
				</fieldset>
			</c:if>
		</div>
		</div>
	</form>
	<%--<div class="toolbarpop" style="margin-top: -25px;">
		<a href="javascript:void(0);" id="save"><button class="layui-btn layui-btn-sm">保存</button></a>
	</div>--%>
	<div style="display: none">
		<input type="hidden" id="dialogId" value="nonIodizedSaltDialog"/>
		<table id="saltRow">
			<tr>
				<td><input type="text" name="EndemicPreventDTO.saltTestRecords[index].saltBrand" reg="{'required':'true'}"/></td>
				<td><ehr:dic-list name="EndemicPreventDTO.saltTestRecords[index].saltType" dicmeta="FS10259" code="1,2" reg="{'required':'true'}"/></td>
				<td><ehr:dic-list name="EndemicPreventDTO.saltTestRecords[index].saltPrice" dicmeta="FS10280" reg="{'required':'true'}"/></td>
				<td><ehr:dic-list name="EndemicPreventDTO.saltTestRecords[index].saltPackingType" dicmeta="FS10261" reg="{'required':'true'}"/></td>
				<td><ehr:dic-list name="EndemicPreventDTO.saltTestRecords[index].saltSource" dicmeta="FS10262" code="3,4" reg="{'required':'true'}"/></td>
				<td><ehr:dic-list name="EndemicPreventDTO.saltTestRecords[index].testResult" dicmeta="FS10260" reg="{'required':'true'}"/></td>
				<td>
					<a href="javascript:void(0);"  onclick="nonIodizedSaltEdit.deleteSalt(this)" title="删除"  class="layui-btn layui-btn-danger layui-btn-xs" style="color: #FFF;font-size: 12px;margin-left: 3px;margin-bottom: 3px;"><i class="layui-icon">&#xe640;</i>删除</a>
				</td>
			</tr>
		</table>
	</div>
</div>