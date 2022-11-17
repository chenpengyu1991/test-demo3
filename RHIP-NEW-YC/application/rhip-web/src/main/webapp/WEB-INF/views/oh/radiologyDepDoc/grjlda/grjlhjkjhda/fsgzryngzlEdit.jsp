<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<script src="${pageContext.request.contextPath}/js/views/oh/radiologyDepDoc/grjlda/grjlhjkjhda/fsgzryngzlEdit.js" type="text/javascript"></script>
<input id="ohWorkloadOperationType" type="hidden" value="${ohWorkloadOperationType }">
<div>
	<form method="post" id="workload_form">
	    <input name="id" type="hidden" value="${record.id }">
	    <input name="isDelete" type="hidden" value="${record.isDelete }">
		<div class="postcontent">
			<div class="postdiv">
				<fieldset>
					<legend>放射工作人员年工作量</legend>
					<table style="width: 99%" class="posttable">
						<tbody>
						<colgroup>
							<col width="40%" />
							<col width="40%" />
						<colgroup>
						<tr>
							<th><label>年份:</label></th>
							<td><input type="text" name="year" value="${record.year}" reg='{"regex":"digits","maxlength":"4"}'></td>
						</tr>
						<tr>
							<th><label>透视:</label></th>
							<td><input type="text" name="perspective" value="${record.perspective}" reg='{"maxlength":"32"}'></td>
						</tr>
						<tr>
							<th><label>胃肠:</label></th>
							<td><input type="text" name="stomachIntestine" value="${record.stomachIntestine }" reg='{"maxlength":"32"}'></td>
						</tr>
						<tr>
							<th><label>拍片:</label></th>
							<td><input type="text" name="xRay" value="${record.xRay }" reg='{"maxlength":"32"}'><td>
						</tr>
						<tr>
							<th><label>介入:</label></th>
							<td><input type="text" name="intervene" value="${record.intervene }" reg='{"maxlength":"32"}'><td>
						</tr>
						<tr>
							<th><label>骨科复位:</label></th>
							<td><input type="text" name="orthopedicsRepst" value="${record.orthopedicsRepst}" reg='{"maxlength":"32"}'></td>
						</tr>
						<tr>
							<th><label>镊取异物:</label></th>
							<td><input type="text" name="foreignForceps" value="${record.foreignForceps}" reg='{"maxlength":"32"}'></td>
						</tr>
						</tbody>
					</table>
				</fieldset>
			</div>
		</div>
	</form>
</div>
<div style="text-align: center">
	<div>
		    <input id="saveRecord" class="btnopr" type="button"  value="保存" onclick="fsgzryngzlEdit.save()"/>&nbsp;&nbsp;&nbsp;&nbsp; 
		    <input id="cancleRecord" class="btnopr" type="button"  value="取消" onclick="fsgzryngzlEdit.cancle()" />
	</div>
</div>