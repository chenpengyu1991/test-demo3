<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>


<script type="text/javascript">
	$(function() {
		var validate = null;
		validate = $("#modifyConfigForm").easyValidate();
		$("#saveButton").click(function(e) {
			e.preventDefault();
			var result = validate.validateForm();
			if (!result) {
				return;
			}
			saveConfig();
		});
	});

	function saveConfig() {

		$("#modifyConfigForm").submitFormGetJson({
			url : '/standParameterCfg/saveConfig',
			param:{
			},
			wait:true,
			callback:function(data){
				debugger
				layui.use('layer', function(){
					var layer = layui.layer;
					if(data >0){
						var index = layer.alert("保存成功！", {icon:0,title:'提示'}, function() {
							layer.closeAll();
							sysConfigSearch.search(1);
						});
					}else{
						var index = layer.alert("保存失败！", {icon:0,title:'提示'}, function() {
							layer.closeAll();
						});
					}
				});
			}
		});
	}
</script>
<div class="toolbar">
	<!-- <a href="javascript:void(0)" id="healthEducationResourceRecordSaveButton" ><b class="baocun">保存</b></a> -->
	<a href="javascript:void(0)"
	   id="saveButton"><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe605;</i>保存</button></a>
</div>
<div class="divAbsolute55">
	<form id="modifyConfigForm">
		<input type="hidden" name="id" value="${standParameterCfg.id}"/>
		<div class="postcontent">
				<table class="posttable">
					<colgroup>
						<col style="width: 10%;"/>
						<col style="width: 90%;"/>
					</colgroup>
					<tr>
						<th><label class="required">参数名称</label></th>
						<td>
							<input type="text" name="name" value="${standParameterCfg.name}" reg='{"required":"true"}'/>
						</td>
					</tr>
					<tr>
						<th><label class="required">描述</label></th>
						<td>
							<input type="text" name="description" value="${standParameterCfg.description}" reg='{"required":"true"}'/>
						</td>
					</tr>
<%--					<tr>
						<th><label>值</label></th>
						<td>
							<input type="text" name="value" value="${standParameterCfg.value}"/>
						</td>
					</tr>--%>
					<tr>
						<th><label class="required">状态</label></th>
						<td>
							<ehr:dic-radio name="valid" dicmeta="SYS00001" value="${standParameterCfg.valid}" reg='{"required":"true"}'></ehr:dic-radio>
						</td>
					</tr>

				</table>
		</div>
	</form>
</div>
