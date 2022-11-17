var serviceInfo = (function(){
	$(function() {
		initLinkClick('subTitle',subTitle, {id:"data-code", parentCode:"data-parentCode"});
		initLinkClick('title',title, {id:"data-code"});
		initLinkClick('serviceInfoDetail',serviceInfoDetail, {id:"data-id"});
		initLinkClick('mdmMedicineOp',mdmMedicineOp);
		initLinkClick('chargeitem',chargeitem);
		initLinkClick('patientbed',patientbed);
	});


	function subTitle(id, parentCode) {
		window.location.href = contextPath+ "/infoShow/infoChildList?code="+id+"&parentCode="+parentCode+"&indexPage=1";
	}
	function title(id) {
		window.location.href = contextPath+ "/infoShow/infoList?code="+id+"&indexPage=1";
	}
	function serviceInfoDetail(id) {
		window.location.href = contextPath+ "/infoShow/infoDetail?id="+id;
	}

	function mdmMedicineOp () {
		window.location.href = contextPath+ "/infoShow/medicineSearch";
	}
	function chargeitem() {
		window.location.href = contextPath+ "/infoShow/medicineRelevantSearch";
	}
	function patientbed() {
		window.location.href = contextPath+"/infoShow/patientbedSearch";
	}
})();