var addUser = (function() {

	$(function() {
		var userCode = $("#userCode").val();
		if(userCode != 0){
			loadOrg();
		}
		$("#saveUserButtonId").click(function(e) {
            e.preventDefault();
            saveUser();
        });
		$("#selectStaffUser").click(function(e) {
            e.preventDefault();
			selectStaff(1);
		});
	});

	function selectStaff(indexPage){
        $.post(contextPath+'/user/selectStaff',
            function(ret){
                layui.use(['layer'], function() {
                    var layer = layui.layer
                    layer.open({
                        type: 1,
                        id:'staffDialog',
                        area: ['750px', '450px'],
                        title:'选择人员',
                        content: ret,
                        success: function(layero, index){
                            $('#staff_index').val(index);
                        }
                    });
                });
            });
	}
	
	function loadOrg(){
		$.loadHtmlByUrl({
			url:"/user/orgList",
			insertDiv:"orgListDiv",
			param:{
				staffCode: $("#staffCode").val(),
				userCode: $("#userCode").val()
			}
		});
		$("#saveUserButtonId").show();
	}

	function loadRoleByOrganCode(orgCode){
		$("input[name='organCode']:visible:checked ").each(function(index) {
			if(orgCode ==$(this).val()) {
				loadRole(orgCode);
			}
		});
	}

	function loadRole(orgCode){
		var roleCodes = "";
		$("#td" + orgCode).find("input").each(function(index, obj) {
			roleCodes = $(this).val();
            $.post(contextPath+'/user/roleList',
                {
                	orgCode: orgCode,
                    roleCode: roleCodes
                },
                function(ret){
                    layui.use(['layer'], function() {
                        var layer = layui.layer
                        layer.open({
                            type: 1,
                            id:'userRoleDialogId',
                            area: ['700px', '450px'],
                            title:'角色',
                            content: ret,
                            success: function(layero, index){
                                $('#role_index').val(index);
                            }
                        });
                    });
                });
			$("#saveUserButtonId").show();
		});
	}
	function setValue(idCard,name,gender,staffCode,mobile){
		$("#roleListDiv").html("");
		$("#saveUserButtonId").hide();
		$("#idCardTxt").val(idCard);
		$("#name").val(name);
		$("#staffCode").val(staffCode);
		$("#gender").val(gender);
		$("#mobile").val(mobile);
	}

	function hiddenMsg(){
		$("#msgOKAdd").hide();
		$("#msgErrorAdd").hide();
	}
	
	function showMsg(divId,msg){
		$("#" + divId).html(msg);
		$("#" + divId).show();
	}
	
	function saveUser() {
		hiddenMsg();
        /* **********  */
        var validate = $("#userFormAddId").easyValidate();
        var result = validate.validateForm();
        if (!result) {
            return;
        }
		//验证机构以及相应的用户是否为空
		result = isHaveSameOrg();
		if(!$.isEmpty(result)) {
			layer.alert(result, {icon:0,title:'提示'});
			return;
		}
        var option = {
			url : "/user/save",
			param : {
				orgRoleCodeStr: util.Obj2str(getTableData('userOrgTableId', [], [], ''))
			},
			wait: true,
			callback : function(data) {
				if (data == "1") {
                    layer.alert("保存成功！", {icon:0,title:'提示'}, function(){
                        var changeStaff = $("#changeStaff").val();
                        $.removeDialog("userDialog");
                        if(changeStaff == "change"){
                            return;
                        }
                        layer.closeAll();
                        userSearch.searchUser(1);
                    });
					return;
				}else if(data=="0"){
					layer.alert("保存失败！", {icon:0,title:'提示'});
					return;
				}
				layer.alert(data, {icon:0,title:'提示'});
			}
		};
		$("#userFormAddId").submitFormGetJson(option);
	}

	/**
	 * 验证机构和相应角色是否为空
	 * @returns {string}
	 */
	function isHaveSameOrg() {
		var orgFlag = true;
		var roleFlag = true;
		//验证是否勾选机构
		$("#userOrgTableId tr").each(function(trindex,tritem){
			if(trindex > 0){
				var trData = {};
				$(tritem).find("td").each(function(tdindex,tditem){
					if(($(this).attr("field") == "organCode")){
						$(this).find("input").each(function(index, obj) {
							if($(this).is(":checked")){
								orgFlag = false;
							}
						});

					}
					if(($(this).attr("field") == "roleCode")){
						$(this).find("input").each(function(index, obj) {
							if(!$.isEmpty($(this).val())){
								roleFlag = false;
							}
						});
					}
				});
				//同一行若选了机构没有选此机构相应的角色
				if(orgFlag || roleFlag) {
					orgFlag = true;
					roleFlag = true;
				}
			}
		});
		if(orgFlag && roleFlag) {
			return "请至少选择一个机构及对应的角色！";
		}
	}

	function getTableData(tableId){
		var tableData = [];
		$("#"+tableId+" tr").each(function(trindex,tritem){
			{
				var trData = {};
				$(tritem).find("td").each(function(tdindex,tditem){
					if($(tditem).find('input').attr("type") == "checkbox") {
						if (!$(tditem).find('input').is(":checked")) {
							return false;
						}
					}
					var inputValue = $(tditem).find('input').val();
					if('' != inputValue && "undefined" != inputValue && undefined != inputValue){
						inputValue = inputValue.replace(/\t/g,'');//制表符替换
						inputValue = inputValue.replace(/\n/g,'');//换行替换
						trData[$(this).find("input").attr("name")] = inputValue;
					}
				});
				tableData.push(trData);
			}
		});
		return tableData;
	}

	return {
		setValue: setValue,
		loadOrg: loadOrg,
		loadRole: loadRole,
		loadRoleByOrganCode: loadRoleByOrganCode
	};
})();
