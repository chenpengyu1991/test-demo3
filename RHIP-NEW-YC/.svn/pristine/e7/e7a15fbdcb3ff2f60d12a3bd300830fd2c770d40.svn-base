<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="ehr" uri="/ehr-tag"%>
<script src="${pageContext.request.contextPath}/js/views/oh/radiologyDepDoc/yyfssbqk/yyfssbqkEdit.js" type="text/javascript"></script>
<input id="ohRadiologicalApparatusOperationType" type="hidden" value="${ohRadiologicalApparatusOperationType }">
<div>
	<div class="postcontent">
		<form method="post" id="radiologicalApparatus_form">
			<input name="id" type="hidden" value="${record.id }">
			<input name="isDelete" type="hidden" value="0">
					<fieldset class="layui-elem-field">
						<legend>医院放射设备情况</legend>
						<table style="width: 99%" class="posttable">
							<tbody>
							<colgroup>
								<col width="30%" />
								<col width="50%" />
							<colgroup>
							<tr>
								<th><label class="required">装置编号:</label></th>
								<td><input type="text" class="x-layui-input" name="equipmentCode" reg='{"required":"true","maxlength":"50","regex":"^[A-Za-z0-9]+$"}' tip="请输入英文大小写或者数字符号" value="${record.equipmentCode}"/></td>
							</tr>
							<tr>
								<th><label class="required">装置型号及名称:</label></th>
								<td><input type="text" class="x-layui-input" name="modelName" reg='{"required":"true","maxlength":"16"}' value="${record.modelName}"></td>
							</tr>
							<tr>
								<th><label>生产厂家:</label></th>
								<td><input type="text" class="x-layui-input" name="manufacutrer" value="${record.manufacutrer}" reg='{"maxlength":"16"}'></td>
							</tr>
							<tr>
								<th><label>出厂时间:</label></th>
								<td>
									<c:if test="${empty record.productionDate}">
										<jsp:useBean id="today" class="java.util.Date"/>
										<input type="text" reg='{"required":"true"}'  class="layui-input x-admin-content-sm-date"  name="productionDate" id="productionDate" value="<fmt:formatDate value='${today}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;" />
									</c:if>
									<c:if test="${not empty record.productionDate}">
										<input type="text" reg='{"required":"true"}'  class="layui-input x-admin-content-sm-date"  name="productionDate" id="productionDate" value="<fmt:formatDate value='${record.productionDate}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;" />
									</c:if>
								</td>
							</tr>
							<tr>
								<th><label>启用时间:</label></th>
								<td>
									<c:if test="${empty record.activeDate}">
										<jsp:useBean id="today1" class="java.util.Date"/>
										<input type="text" reg='{"required":"true"}'  class="layui-input x-admin-content-sm-date"  name="activeDate" id="activeDate" value="<fmt:formatDate value='${today1}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;" />
									</c:if>
									<c:if test="${not empty record.activeDate}">
										<input type="text" reg='{"required":"true"}'  class="layui-input x-admin-content-sm-date"  name="activeDate" id="activeDate" value="<fmt:formatDate value='${record.activeDate}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;" />
									</c:if>
								</td>
							</tr>
							<tr>
								<th><label>停用时间:</label></th>
								<td>
									<c:if test="${empty record.stopDate}">
										<jsp:useBean id="today2" class="java.util.Date"/>
										<input type="text" reg='{"required":"true"}'  class="layui-input x-admin-content-sm-date"  name="stopDate" id="stopDate" value="<fmt:formatDate value='${today2}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;" />
									</c:if>
									<c:if test="${not empty record.stopDate}">
										<input type="text" reg='{"required":"true"}'  class="layui-input x-admin-content-sm-date"  name="stopDate" id="stopDate" value="<fmt:formatDate value='${record.stopDate}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;" />
									</c:if>
								</td>
							</tr>
							<tr>
								<th><label class="required">主要参数(Kv/mA):</label></th>
								<td><input type="text" class="x-layui-input" id="keyPara" name="keyPara" reg='{"maxlength":"16","required":"true"}' value="${record.keyPara }"><td>
							</tr>
							<tr>
								<th><label>球管数:</label></th>
								<td><input type="text" class="x-layui-input" name="tubeNum" value="${record.tubeNum}" reg='{"maxlength":"2","regex":"digits"}'></td>
							</tr>
							<tr>
								<th><label>操作方式:</label></th>
								<td><input type="text" class="x-layui-input" name="operatingMode" value="${record.operatingMode}" reg='{"maxlength":"16"}'></td>
							</tr>
							</tbody>
						</table>
					</fieldset>
		</form>
		<div style="text-align: center">
			<a id="saveRecord" href="javascript:yyfssbqkEdit.save()" ><button class="layui-btn layui-btn-sm">保存</button></a>
			<a id="cancleRecord" href="javascript:yyfssbqkEdit.cancle()" ><button class="layui-btn layui-btn-sm">关闭</button></a>
		</div>
	</div>
</div>

<script type="text/javascript">
	layui.use('laydate', function(){
		var laydate = layui.laydate;

		laydate.render({
			elem: '#productionDate'
			,format: 'yyyy/MM/dd'
			,max:0
			,trigger: 'click'
		});

		laydate.render({
			elem: '#activeDate'
			,format: 'yyyy/MM/dd'
			,max:0
			,trigger: 'click'
		});

		laydate.render({
			elem: '#stopDate'
			,format: 'yyyy/MM/dd'
			,max:0
			,trigger: 'click'
		});
	});
</script>
