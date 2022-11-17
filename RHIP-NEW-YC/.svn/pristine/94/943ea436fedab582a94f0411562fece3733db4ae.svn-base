<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/tld/elb-tag.tld" prefix="elb"%>

<link href="${pageContext.request.contextPath}/resources/css/global.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/resources/css/forms.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/resources/css/control.css" rel="stylesheet" type="text/css" />
<script src="${pageContext.request.contextPath}/resources/js/jquery/jquery-1.7.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/js/common.js" type="text/javascript"></script>

<script type="text/javascript">
	var path = "${pageContext.request.contextPath}";

	function search(index) {

		//flag = validateForm();
		/* if(flag) {
			var url = path + "/referral/patient/list";
			//loadHtml2(url,'upReferralForm','resultDiv',index);
			
		} */
		//$("#dicList").show();
		var form = document.getElementById('dicSearchForm');
		form.action = "${pageContext.request.contextPath}/dic/search";
		form.submit();
	}

	//验证输入条件是否为空
	function validateForm() {
		var value = $("#patientValue").val();
		if (value.replace(/(^\s+)|(\s+$)|'|%|_/g, "") == "") {
			alert("查询条件不可以为空！");
			return false;
		}
		return true;
	}

	//验证是否选择患者
	function upReferral() {
		var patientId = $("input:radio[name=patientId]:checked").val();
		if (null != patientId) {
			var url = path + "/referral/upreferral/new/" + patientId;
			document.location.href = url;
		} else {
			alert("请选择患者！");
		}
	}

	function getDicmetas() {
		var val = $("#domain").val();
		$.get("${pageContext.request.contextPath}/dic/changedomain?rr=" + new Date(), {
			domainId : val
		}, function(data) {
			if ($("#dicmeta").find('option').length > 0) {
				var option = $("#dicmeta").find('option');
				var len = option.length;
				if (len > 0) {
					for ( var i = 0; i < len; i++) {
						if (option.eq(i).val() != '') {
							$("#dicmeta option[value='" + option.eq(i).val() + "']").remove();
						}
					}
				}
			}
			data = eval("(" + data + ")");
			$.each(data, function(key, val) {
				$("<option value='"+val.code+"'>" + val.name + "</option>").appendTo($("#dicmeta"));
			});
		});
	}
</script>

<div class="section">
	<div class="titlebar">字典管理</div>
	<div class="content">
		<form id="dicSearchForm" name="dicSearchForm" action="" method="post">
			<table class="formtable">
				<tbody>
					<tr>
						<td style="width: 300px"><select name="domain" id="domain" onchange="getDicmetas()">
								<option value="0">请选择</option>
								<c:forEach var="domain" items="${domains}">
									<option value="${domain.id}">${domain.name}</option>
								</c:forEach>
						</select></td>
						<td style="width: 300px"><select name="code" id="dicmeta">
								<option value="0">请选择</option>
						</select></td>
						<td><button type="button" onclick="search(1);">查 询</button></td>
					</tr>
				</tbody>
			</table>
		</form>
	</div>
	<div id="dicList" style="display: block">

		<div class="titlebar">
			<div class="title">角色管理</div>
			<div class="toobar">
				<img src="${pageContext.request.contextPath}/resources/images/btn/add.png" /><span onclick="goToAdd()">新增</span> <img src="${pageContext.request.contextPath}/resources/images/btn/edit.png" /><span onclick="edit()">修改</span> <img src="${pageContext.request.contextPath}/resources/images/btn/delete.png" /><span onclick="delRole()">删除</span>
			</div>
		</div>
		<form id="roleFormId" name="roleForm" action="" method="post">
			<table class="repeattable">
				<thead>
					<tr>
						<th style="width: 20px"><input type="checkbox" name="checkAll" class="chk_selectall" /></th>
						<th style="width: 30px">编号</th>
						<th style="width: 200px">角色</th>
						<th>描述</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="dicMap" items="${dictionaries}">
						<c:forEach var="map" items="${dicMap}">
							<tr>
								<td>${map.key}</td>
								<td>${map.value}</td>
							</tr>
						</c:forEach>
					</c:forEach> 
					<tr>
						<elb:pagination action="search" colspan="10" />
					</tr>
				</tbody>
			</table>
		</form>
	</div>
</div>
