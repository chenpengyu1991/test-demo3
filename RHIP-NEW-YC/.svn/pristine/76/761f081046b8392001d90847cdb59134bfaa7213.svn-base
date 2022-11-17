var statisticsCommon = (function() {
	$(function() {
		initForm();
	});

	function initForm() {
		$('#centre1').on("change", function() {
			$('#superOrganCode').val(this.value);
		});
		$('#town1').on("change", function() {
			$('#gbCode').val(this.value);
		});
		$('#centre2').on("change", function() {
			$('#superOrganCode').val(this.value);
		});
		$('#town2').on("change", function() {
			$('#gbCode').val(this.value);
		});
		$('#station2').on("change", function() {
			$('#organCode').val(this.value);
		});
		$('#genreCode').on("change", function() {
			changeOrgType();
		});

		$('#organCode0').on("change", function() {
			$('#superOrganCode').val(this.value);
		});
		$('#town3').on("change", function() {
			$('#gbCode').val(this.value);
		});

		changeOrgType();
	}
	
	function changeOrgType(){
		var genreCode = $('#genreCode').val();
		if(genreCode == 'A100'){
			$('#byHospital').show();
			$('#byCentre').hide();
			$('#byStation').hide();
			$('#byTown').hide();
			getCurrentOrgCode(0);
		}else if(genreCode == 'B100'){
			$('#byHospital').hide();
			$('#byCentre').show();
			$('#byStation').hide();
			$('#byTown').hide();
			getCurrentOrgCode(1);
		}else if(genreCode == 'B200'){
			$('#byHospital').hide();
			$('#byCentre').hide();
			$('#byStation').show();
			$('#byTown').hide();
			getCurrentOrgCode(2);
		}else if(genreCode == '0'){
			$('#byHospital').hide();
			$('#byCentre').hide();
			$('#byStation').hide();
			$('#byTown').show();
			getCurrentOrgCode(3);
		}
	};

	function getCurrentOrgCode(index){
		$('#gbCode').val($('#town' + index).val());
		if(index==0){
			$('#superOrganCode').val($('#organCode' + index).val());
		}else if(index != 3){
			$('#superOrganCode').val($('#centre' + index).val());	
			$('#organCode').val($('#station' + index).val());
		}else{
			$('#superOrganCode').val("");	
			$('#organCode').val("");
		}
	}
	
	return {
		changeOrgType:changeOrgType
	};
})();