define(function(){
	function load() {
		$(function () {

			/*  if ($("#firstMsg").length > 0) {
			 alert($("#firstMsg").html());
			 $("#firstMsg").remove();
			 }*/
			//分页绑定函数
			pageUtil.bind("memberDiv",personSearch);
			$('#personName').onEnter(personSearch, 1);

			$("#memberFamilySearchId").click(function () {
				personSearch(1);
			});

			util.checkBoxAll("personAllCheck", "personCheck");
			util.checkBoxAll("memberAllCheck", "memberCheck");

			$("#searchPesonBtn").click(function () {
				personSearch(1);
			});

			$("#memberAddBtn").click(function () {
				if ($("#allMembers input:checked").length == 0) {
					layer.alert("请选择待加入的成员！", {icon:0,title:'提示'});
					return;
				}
				$("#memberForm").submitFormLoadHtml({
					url: contextPath + "/family/member/add",
					insertDiv: "memberDiv",
					param: {
						indexPage: 1,
						personName: $("#personName").val(),
						idCard: $("#idCard").val()
					}
				});
			});

			$("#memberDeleBtn").click(function () {
				if ($("#memberTables input:checked").length == 0) {
					layer.alert("请选择要删除的成员！", {icon:0,title:'提示'});
					return;
				}
				$("#memberForm").submitFormLoadHtml({
					url: contextPath + "/family/member/remove",
					insertDiv: "memberDiv",
					param: {
						indexPage: 1,
						personName: $("#personName").val(),
						idCard: $("#idCard").val()
					}
				});
			});

		});
	}
	function personSearch(indexPage) {
		$("#memberForm").submitFormLoadHtml({
			url : contextPath + "/family/person/list",
			insertDiv :"memberDiv",
			param:{
				indexPage : indexPage,
				personName : $("#personName").val(),
                idCard : $("#idCard").val()
			}
		});
	}
	
	return {
		personSearch : personSearch,
		load : load
	};
});