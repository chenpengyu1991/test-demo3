<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script type="text/javascript">
var domainInfoEdit = (function(){
	$(function() {
		var validate = $("#domainForm").easyValidate();
		$("#saveButton").click(function() {
			if (validate.validateForm()) {
				$("#domainForm").submitFormGetJson({
					url : "/mdmDomain/save",
					callback : submitCallback,
					param : {
						type : $("#type").val()
					}
				});
			}
		});
		
		$("#cancelButton").click(function() {
			$.removeDialog("d1");
		});
	}); 

	function submitCallback(data) {
		layer.alert(data.message, {icon:0,title:'提示'}, function(index){
			if (data.result) {
				$.removeDialog("d1");
				domainSearch.search($("#indexPage").val());
			}
			layer.close(index);
		});
	}
	/*
	function validate() {
		var msg = "";
		$("#domainForm").find("input").each(function() {
			var val = $(this).val();
			var type = $(this).attr("type");
			var checkList = {};
			eval("checkList=" + $(this).attr("checkList"));
			if ($.isEmptyObject(checkList)) {
				;
			} else {
				for (var i in checkList) {
					if ("notNull" == i) {
						if ("text" == type || "select" == type) {
							if ($.trim(val).length == 0) {
								msg += checkList[i] + "\n";
							}
						}
					}
				}
			}
		});
		return msg;
	}
	*/
	return {
		
	};
})();
</script>

<div>
	<div class="msgError" id="msgError" style="display: none;"></div>
	<div class="msgOK" id="msgOK" style="display: none;"></div>
	<div style="padding-left: 15px; padding-right: 15px; width: auto;">
		<form:form id="domainForm" modelAttribute="domain">
			<fieldset>
				<legend>域信息:</legend>
				<table class="formtable">
					<tr>
						<th><label class="required">域编码</label></th>
						<td>
							<c:if test="${empty domain.domainCode}">
								<form:input path="domainCode" reg='{"required":"true","maxlength":"30"}'  />
								<input type="hidden" id="type" value="add" />
							</c:if>
							<c:if test="${not empty domain.domainCode}">
								${domain.domainCode}
								<form:hidden path="domainCode" />
								<input type="hidden" id="type" value="edit" />
							</c:if>
						</td>
					</tr>
					<tr>
						<th><label class="required">域名称</label></th>
						<td><form:input path="domainName" reg='{"required":"true","maxlength":"100"}'  />
					</tr>
				</table>
			</fieldset>
		</form:form>
		<p style="margin-top: 15px;" align="center">
			<input type="button" id="saveButton" name="save" value="保 存" class="btnopr" /> 
			<input type="button" id="cancelButton" name="save" value="关 闭" class="btnopr" />
		</p>
		<div id="messageDiv" style="margin: 5px;"></div>
	</div>
</div>
