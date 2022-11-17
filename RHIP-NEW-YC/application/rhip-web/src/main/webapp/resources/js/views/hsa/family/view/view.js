
!(function() {
	$(function() {

		$("#hsa-familyrecordadd-back-btn").click(function() {
			back();
		});
		HsaCommon.makeFormViewOnly($("#hsa-familyrecordadd-form"));

	});

	function back() {
		hsaFamilyList.showList(true);
	}

})();