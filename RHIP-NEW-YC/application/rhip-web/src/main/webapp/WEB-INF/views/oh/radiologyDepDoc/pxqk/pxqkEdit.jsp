<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<script src="${pageContext.request.contextPath}/js/views/oh/radiologyDepDoc/pxqk/pxqkEdit.js" type="text/javascript"></script>
<input id="ohTrainingOperationType" type="hidden" value="${ohTrainingOperationType }">
<div>
	<div class="postcontent">
		<form method="post" id="training_form">
			<input name="id" type="hidden" value="${record.id }">
			<input name="isDelete" type="hidden" value="${record.isDelete }">
				<fieldset class="layui-elem-field">
					<legend>培训情况</legend>
					<table style="width: 99%" class="posttable">
						<tbody>
						<colgroup>
							<col width="40%" />
							<col width="40%" />
						<colgroup>
						<tr>
							<th><label class="required">姓名:</label></th>
							<td><input type="text" class="x-layui-input" name="name" value="${record.name}" reg='{"required":"true","maxlength":"16"}' /></td>
						</tr>
						<tr>
							<th><label class="required">培训时间:</label></th>
							<td>
								<c:if test="${empty record.treateTime}">
									<jsp:useBean id="today" class="java.util.Date"/>
									<input type="text" reg='{"required":"true"}'  class="layui-input x-admin-content-sm-date"  name="treateTime" id="treateTime" value="<fmt:formatDate value='${today}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;" />
								</c:if>
								<c:if test="${not empty record.treateTime}">
									<input type="text" reg='{"required":"true"}'  class="layui-input x-admin-content-sm-date"  name="treateTime" id="treateTime" value="<fmt:formatDate value='${record.treateTime}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;" />
								</c:if>
							</td>
						</tr>

						<tr>
							<th><label class="required">培训证号:</label></th>
							<td><input type="text" class="x-layui-input" name="treateNo" value="${record.treateNo }" reg='{"required":"true","maxlength":"16"}'/><td>
						</tr>
						</tbody>
					</table>
				</fieldset>
		</form>
		<div style="text-align: center">
			<a id="saveRecord" href="javascript:pxqkEdit.save()" ><button class="layui-btn layui-btn-sm">保存</button></a>
			<a id="cancleRecord" href="javascript:pxqkEdit.cancle()" ><button class="layui-btn layui-btn-sm">关闭</button></a>
		</div>
	</div>
</div>

<script type="text/javascript">
	layui.use('laydate', function(){
		var laydate = layui.laydate;

		laydate.render({
			elem: '#treateTime'
			,format: 'yyyy/MM/dd'
			,max:0
			,trigger: 'click'
		});
	});
</script>
