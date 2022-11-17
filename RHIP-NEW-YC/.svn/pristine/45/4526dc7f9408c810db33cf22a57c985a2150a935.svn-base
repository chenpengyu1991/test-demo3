var addOrg = (function() {
	$(function() {
		$("#searchTownId").change(function() {
			showRoles();
		});
		$("#searchCenterId").change(function() {
			showRoles();
		});
		$("#searchStationId").change(function() {
			showRoles();
		});

		$("#saveRoleBtn").click(function() {
			saveRoles();
		});

	});

	function showRoles() {
	}

	function saveRoles() {
		var orgCode = getOrgCode();
		if($.isEmpty(orgCode)){
			layer.alert("请选择机构！", {icon:0,title:'提示'});
			return;
		}
		var roles = $("input[name=rolecheck]").getValue();
		if($.isEmpty(roles)){
			layer.alert("请选择角色！", {icon:0,title:'提示'});
			return;
		}
		var userCode = $("#userCode").val();
		var option = {
			url : "/user/saveOrg",
			param : {
				orgCode : orgCode,
				userCode : userCode
			},
			callback : function(data) {
				addUser.reloadRole(userCode);
				$.removeDialog("orgDialogId");
			}
		};
		$("#orgForm").submitFormGetJson(option);
	}
	
	/**
	 * 获取机构三级标签的机构编码
	 * 
	 * */
	function getOrgCode() {
		var orgCode = $("#searchStationId").val();
		
		if ($.isEmpty(orgCode)) {
			orgCode = $("#searchCenterId").val();
		}
		return orgCode;
	}
})();
