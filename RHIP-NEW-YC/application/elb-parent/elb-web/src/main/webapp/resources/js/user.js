$(document).ready(function() {
	searchTooltip();
	
});

function searchTooltip() {
	elb.searchTooltip("#sUserName", "请输入用户名");
	elb.searchTooltip("#sName", "请输入姓名");
	elb.searchTooltip("#sEmail", "请输入Email");
	elb.searchTooltip("#sTelephone", "请输入固定电话");
	elb.searchTooltip("#sMobile", "请输入手机号");
	elb.searchTooltip("#sHomeAddress", "请输入家庭住址");
}

function viewDetail(userId) {
	
	var path = contextPath + "/user/update/?userId=" + userId;
	window.location.href = path;
}

function searchUser(indexPage) {
	var form = document.getElementById('userFormId');
	form.action = contextPath + "/user/searchUser?indexPage=" + indexPage;
	form.submit();
}

function addUser() {
	var path = contextPath + "/user/add/";
	window.location.href = path;
}

function delUser() {
	if (!confirm("确认删除?"))
		return false;
	var userIds = "";
	$(".chk_selectone:checked").each(function() {
		userIds += $(this).val() + ",";
	});
	if (userIds == "") {
		alert("请选择用户");
		return;
	}

	var path = contextPath + "/user/delete/?userIds=" + userIds;
	window.location.href = path;
}

function statusChange(field) {
	if (!confirm("确认变更?"))
		return false;
	var userId = "";
	$(".chk_selectone:checked").each(function() {
		userId += $(this).val() + ",";
	});
	if (userId == "") {
		alert("请选择用户");
		return;
	}
	
	var path = contextPath + "/user/status/" + "?userIds=" + userId
			+ "&status=" + field;
	window.location.href = path;
}

function roleSet() {
	var userIds = "";
	$(".chk_selectone:checked").each(function() {
		userIds += $(this).val() + ",";
	});
	if (userIds == "") {
		alert("请选择用户");
		return;
	}
	var path = contextPath + "/user/goToRoleSet/" + userIds;
	window.location.href = path;
}