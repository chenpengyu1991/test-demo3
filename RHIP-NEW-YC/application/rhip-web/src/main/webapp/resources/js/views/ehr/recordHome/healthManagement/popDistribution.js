var popDistribution = (function() {

	$(function() {
		$("#editBody").hide();
		showModifyButton();

		$("#modifyCommunityIdSpan").on("click", function() {
			$("#displayBody").hide();
			$("#editBody").show();
			showCancelButton();
		});

		$("#cancelCommunityId").click(function() {
			$("#displayBody").show();
			$("#editBody").hide();
			showModifyButton();
		});

		$("#saveCommunityId").click(function() {
			// 保存修改的内容：
			saveCommunityInfo();
		});
		getPopChangeData();
	});

	function showModifyButton() {
		$("#cancelCommunityIdSpan").hide();
		$("#modifyCommunityIdSpan").show();
	};

	function showCancelButton() {
		$("#modifyCommunityIdSpan").hide();
		$("#cancelCommunityIdSpan").show();
	};

	function saveCommunityInfo() {
		$("#ehr-person-count-form").submitFormLoadHtml({
			url : contextPath + "/populace/healthManagementPopUpdate",
			insertDiv : "pop_dis_result_div",
			callback:function(data){
				showModifyButton();
			}
		});
	};
	
	function getPopChangeData(){
		$("#communityInfoForm").submitFormLoadHtml({
			url : contextPath + "/populace/popChange",
			insertDiv : "pop_dis_result_div"
		});
	};
})();