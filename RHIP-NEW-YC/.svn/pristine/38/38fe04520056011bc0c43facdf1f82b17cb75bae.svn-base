<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="ehr" uri="/ehr-tag"%>
<script src="${pageContext.request.contextPath}/js/views/oh/radiologyDepDoc/grjlda/grjldaEdit.js" type="text/javascript"></script>
<input id="ohPersonalDoseOperationType" type="hidden" value="${ohPersonalDoseOperationType }">
<div>
	<div class="postcontent">
		<form method="post" id="personalDose_form">
			<input name="id" type="hidden" value="${record.id }">
			<input name="isDelete" type="hidden" value="${record.isDelete }">
				<fieldset class="layui-elem-field">
					<legend>个人剂量档案</legend>
					<table style="width: 99%" class="posttable">
						<tbody>
						<colgroup>
							<col width="40%" />
							<col width="40%" />
						<colgroup>
						<tr>
							<th><label class="required">姓名:</label></th>
							<td><input id="name" class="x-layui-input" type="text" name="name" value="${record.name}" reg='{"required":"true","maxlength":"16"}'></td>
						</tr>
						<tr>
							<th><label class="required">性别:</label></th>
							<td>
							    <c:choose>
							        <c:when test="${ohPersonalDoseOperationType=='1' }">${record.gender}</c:when>
							        <c:otherwise><ehr:dic-list id="gender" dicmeta="GBT226112003" name="gender" value="${record.gender}" reg='{"required":"true"}'/></c:otherwise>
							    </c:choose>
							</td>
						</tr>
						<tr>
						    <th><label class="required">身份证号:</label></th>
							<td><input type="text" id="idcard" class="x-layui-input" name="idCard" value="${record.idCard}" reg='{"required":"true","idCard":true,"maxlength":"18"}' placeholder="输入身份证获取人员信息"></td>
						</tr>
						<tr>
							<th><label>出生日期:</label></th>
							<td>
								<input type="text" reg='{"required":"true"}'  class="layui-input x-admin-content-sm-date"  name="birthdate" id="birthdate" value="<fmt:formatDate value='${record.birthdate}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;" />
							</td>
						</tr>
						<tr>
							<th><label>职称:</label></th>
							<td><input type="text" class="x-layui-input" name="proTitle" value="${record.proTitle }" reg='{"maxlength":"16"}'/><td>
						</tr>
						<tr>
							<th><label>开始放射工作时间:</label></th>
							<td>
								<c:if test="${empty record.startDate}">
									<jsp:useBean id="today" class="java.util.Date"/>
									<input type="text" reg='{"required":"true"}'  class="layui-input x-admin-content-sm-date"  name="startDate" id="startDate11" value="<fmt:formatDate value='${today}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;" />
								</c:if>
								<c:if test="${not empty record.startDate}">
									<input type="text" reg='{"required":"true"}'  class="layui-input x-admin-content-sm-date"  name="startDate" id="startDate11" value="<fmt:formatDate value='${record.startDate}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;" />
								</c:if>
							</td>
						</tr>
						<tr>
							<th><label class="required">剂量号:</label></th>
							<td><input type="text" class="x-layui-input" name="doseNo" value="${record.doseNo}" reg='{"required":"true","maxlength":"18","regex":"^[A-Za-z0-9]+$"}' tip="请输入英文大小写或者数字符号"/></td>
						</tr>
						<tr>
							<th><label class="required">工作证号:</label></th>
							<td><input type="text" class="x-layui-input" name="jobNum" value="${record.jobNum}" reg='{"required":"true","maxlength":"18","regex":"^[A-Za-z0-9]+$"}' tip="请输入英文大小写或者数字符号"/></td>
                        </tr>
                        <tr>
							<th><label  class="required">健康档案号:</label></th>
							<td><input id="healthRecordNo" class="x-layui-input" type="text" name="healthRecordNo" value="${record.healthRecordNo}" reg='{"required":"true","maxlength":"18","regex":"^[A-Za-z0-9]+$"}' tip="请输入英文大小写或者数字符号"/></td>
                        </tr>
						</tbody>
					</table>
				</fieldset>
		</form>
		<div style="text-align: center">
			<a id="saveRecord" href="javascript:grjldaEdit.save()" ><button class="layui-btn layui-btn-sm">保存</button></a>
			<a id="cancleRecord" href="javascript:grjldaEdit.cancle()" ><button class="layui-btn layui-btn-sm">关闭</button></a>
		</div>
	</div>
</div>

<script type="text/javascript">
	layui.use('laydate', function(){
		var laydate = layui.laydate;

		laydate.render({
			elem: '#startDate11'
			,format: 'yyyy/MM/dd'
			,max:0
			,trigger: 'click'
		});

		laydate.render({
			elem: '#birthdate'
			,format: 'yyyy/MM/dd'
			,max:0
			,trigger: 'click'
		});
	});
</script>