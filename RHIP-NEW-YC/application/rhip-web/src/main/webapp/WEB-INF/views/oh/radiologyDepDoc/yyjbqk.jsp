<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="ehr" uri="/ehr-tag"%>
<script src="${pageContext.request.contextPath}/js/views/oh/radiologyDepDoc/yyjbqk.js" type="text/javascript"></script>

<div>
	<div class="postcontent">
		<form method="post" id="hospitalInfo_form">
		<input type="hidden" name="isDelete" value="0" />
				<fieldset class="layui-elem-field">
					<legend>医院基本情况</legend>
					<table style="width: 99%" class="posttable">
						<tbody>
						<colgroup>
							<col width="30%" />
							<col width="70%" />
						<colgroup>
						<tr>
							<th><label class="required">档案号:</label></th>
							<td><input type="text" name="fileNo" reg='{"required":"true","maxlength":"18"}' class="x-layui-input" /></td>
						</tr>
						<tr>
							<th><label class="required">医院名称:</label></th>
							<td>
								<tag:autoSelect name="hospitalName" id="hospitalName" nameValue="${record.hospitalName}" codeValue="${record.hospitalName}"
								 reg='{"required":"true","maxlength":"16"}'></tag:autoSelect>
							</td>
						</tr>
						<tr>
							<th><label class="required">医院地址:</label></th>
							<td><input type="text" id="addr" name="addr" reg='{"required":"true","maxlength":"38"}' class="x-layui-input" /></td>
						</tr>
						<tr>
							<th><label class="required">医院组织机构代码:</label></th>
							<td><input type="text" name="orgCode" reg='{"required":"true","maxlength":"18"}' class="x-layui-input" /></td>
						</tr>
						<tr>
							<th><label>医院级别:</label></th>
							<td><ehr:dic-list id="hLevel" name="hLevel" dicmeta="DM02-02" value="${record.hLevel }"></ehr:dic-list></td>
						</tr>
						<tr>
							<th><label class="required">法定代表人:</label></th>
							<td><input type="text" id="legalRepr"  name="legalRepr" reg='{"required":"true","maxlength":"16"}' class="x-layui-input" /></td>
						</tr>
						<tr>
							<th><label class="required">防护负责人:</label></th>
							<td><input type="text" name="protectionHead" reg='{"required":"true","maxlength":"16"}' class="x-layui-input" /></td>
                        </tr>
                        <tr>
							<th><label>联系电话:</label></th>
							<td><input type="text" id="phone" name="phone" reg='{"maxlength":"18","regex":"phone"}' class="x-layui-input" /></td>
						</tr>
						<tr>
							<th><label>建档时间:</label></th>
							<td>
								<input type="text" reg='{"required":"true"}'  class="layui-input x-admin-content-sm-date"  name="createTime" id="createTime"
									   value="<fmt:formatDate value='${record.createTime}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;" />
							</td>
						</tr>
						</tbody>
					</table>
				</fieldset>
		</form>
		<div style="text-align: center">
			<a id="saveRecord" href="javascript:void(0)" onclick="yyjbqk.save()" ><button class="layui-btn layui-btn-sm">保存</button></a>
			<a id="cancleRecord" href="javascript:void(0)" onclick="yyjbqk.cancle()" ><button class="layui-btn layui-btn-sm">取消</button></a>
		</div>
	</div>
</div>

<script type="text/javascript">
	layui.use('laydate', function(){
		var laydate = layui.laydate;

		laydate.render({
			elem: '#createTime'
			,format: 'yyyy/MM/dd'
			,max:0
			,trigger: 'click'
			,value: new Date()
		});

	});
</script>