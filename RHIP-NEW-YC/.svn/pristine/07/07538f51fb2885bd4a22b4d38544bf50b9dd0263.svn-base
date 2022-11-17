var staffUser = (function() {
	$(function(){
		pageUtil.bind("listDivStaff",searchStaff);
		searchStaff(1);
		$("#starffSearchForm").onEnter(function(){
			searchStaff(1);
		});
		$("#searchStaffButId").click(function(e){
            e.preventDefault();
			searchStaff(1);
		});
	});
	function searchStaff(indexPage) {
        $("#searchStaffOrganCode").val(getOrgCode());
        var url = contextPath + "/user/listStaff";
		var searchObj = {
				 url : url,
				 insertDiv : "listDivStaff",
				 param : {
	            	staffName:$("#staffName").val(),
					 organCode: $("#searchStaffOrganCode").val(),
	            	indexPage:indexPage
				 },
				callback: function() {
					$("a[id^='selectedStaff']").each(function(){
						  $(this).click(function() {
							  getStaffInfo($(this).attr('data-card'),$(this).attr('data-name'),$(this).attr('data-gender'),$(this).attr('data-staffCode'),$(this).attr('data-mobile'));
						  });
						});
				}
			 };
		$("#starffSearchForm").formPost(searchObj);
	}
    function getOrgCode() {
		debugger;
        var organCode = $("#searchStationStaffId").val();
        if ($.isEmpty(organCode)) {
            organCode = $("#searchCenterStaffId").val();
        }
        if ($.isEmpty(organCode)) {
            organCode = $("#searchTownStaffId").val();
        }
        return organCode;
    }
	function getStaffInfo(idCard,name,gender,staffCode,mobile) {
        layer.close($('#staff_index').val());
		addUser.setValue(idCard,name,gender,staffCode,mobile);
		addUser.loadOrg();
	}
	
	return {
		searchStaff:searchStaff
	};
})();
