var apf = (function() {
	$(function() {
		/*  初步调查结果  */
		$(":input[name='diagnosis.afp']").change(function() {
			toggleOther('diagnosis.afp', 'afpCategory', 1);
			toggleOther('diagnosis.afp', 'unAfp', 2);
			//隐藏其他输入框
			$("#afpOther").hide();
			$("#unAfpOther").hide();
			//若下拉选择99，那么现实其他输入框
			toggleOtherSC('diagnosis.afpCategory', 'afpOther', 99);
			toggleOtherSC('diagnosis.unAfp', 'unAfpOther', 99);
		});
		
		$(":input[name='diagnosis.afpCategory']").change(function () {
			toggleOtherSC('diagnosis.afpCategory', 'afpOther', 99);
		});
		
		$(":input[name='diagnosis.unAfp']").change(function () {
			toggleOtherSC('diagnosis.unAfp', 'unAfpOther', 99);
		});
		
		//初始化操作

		//初始化现实是否对应的apf选择
		toggleOther('diagnosis.afp', 'afpCategory', 1);
		toggleOther('diagnosis.afp', 'unAfp', 2);
		//初始化下拉对应的其他输入框
		toggleOtherSC('diagnosis.afpCategory', 'afpOther', 99);
		toggleOtherSC('diagnosis.unAfp', 'unAfpOther', 99);
		
		/*  免疫史 */
		//服疫苗形式
		$(":input[name='epidemiologicalSurvey.immunizationHistoryForm']").change(function(){
			toggleOtherSC('epidemiologicalSurvey.immunizationHistoryForm', 'immuniHistoryFormOther', 99);
		});
		toggleOtherSC('epidemiologicalSurvey.immunizationHistoryForm', 'immuniHistoryFormOther', 99);
		//服疫苗形式
		$(":input[name='epidemiologicalSurvey.immunizationHistoryFormF']").change(function(){
			toggleOtherSC('epidemiologicalSurvey.immunizationHistoryFormF', 'immuniHistoryFormFOther', 99);
		});
		toggleOtherSC('epidemiologicalSurvey.immunizationHistoryFormS', 'immuniHistoryFormSOther', 99);
		//服疫苗形式
		$(":input[name='epidemiologicalSurvey.immunizationHistoryFormS']").change(function(){
			toggleOtherSC('epidemiologicalSurvey.immunizationHistoryFormS', 'immuniHistoryFormSOther', 99);
		});
		toggleOtherSC('epidemiologicalSurvey.immunizationHistoryFormT', 'immuniHistoryFormTOther', 99);
		//服疫苗形式
		$(":input[name='epidemiologicalSurvey.immunizationHistoryFormT']").change(function(){
			toggleOtherSC('epidemiologicalSurvey.immunizationHistoryFormT', 'immuniHistoryFormTOther', 99);
		});
		toggleOtherSC('epidemiologicalSurvey.immunizationHistoryFormF', 'immuniHistoryFormFOther', 99);
		
		//未全程免疫主要原因
		$(":input[name='epidemiologicalSurvey.unvaccinatedReason']").change(function(){
			toggleOtherSC('epidemiologicalSurvey.unvaccinatedReason', 'unvaccinatedReasonOther', 99);
		});
		toggleOtherSC('epidemiologicalSurvey.unvaccinatedReason', 'unvaccinatedReasonOther', 99);
		
		/* 实验室资料 */
		//标本量1
		$(":input[name='labExamine.sampleNumberFlag_1']").change(function(){
			toggleOtherSC('labExamine.sampleNumberFlag_1', 'sampleNumber_1', 1);
		});
		toggleOtherSC('labExamine.sampleNumberFlag_1', 'sampleNumber_1', 1);
		
		//标本量2
		$(":input[name='labExamine.sampleNumberFlag_2']").change(function(){
			toggleOtherSC('labExamine.sampleNumberFlag_2', 'sampleNumber_2', 1);
		});
		toggleOtherSC('labExamine.sampleNumberFlag_2', 'sampleNumber_2', 1);
		
		/*最后诊断及分类(省填写)*/
		$(":input[name='diagnosis.diagnosisCategory']").change(function(){
			hideClassByClass('diagnosis.diagnosisCategory', 'noSpecimen', 3);
			hideClassByClass('diagnosis.diagnosisCategory', 'polioExcludeReason', 2);
			hideClassByClass('diagnosis.diagnosisCategory', 'polioDiagnosisReason', 1);
			toggleOtherSC('diagnosis.polioExcludeDiagnosis', 'diagnosisOther', 99);
		});
		hideClassByClass('diagnosis.diagnosisCategory', 'noSpecimen', 3);
		hideClassByClass('diagnosis.diagnosisCategory', 'polioExcludeReason', 2);
		hideClassByClass('diagnosis.diagnosisCategory', 'polioDiagnosisReason', 1);
		
		/* 最后诊断 */
		$(":input[name='diagnosis.polioExcludeDiagnosis']").change(function(){
			toggleOtherSC('diagnosis.polioExcludeDiagnosis', 'diagnosisOther', 99);
		});
		toggleOtherSC('diagnosis.polioExcludeDiagnosis', 'diagnosisOther', 99);
		
		/*f. 居住状况*/
		$(":input[name='generalCondition.livingConditions']").change(function(){
			toggleOtherSC('generalCondition.livingConditions','livingConditionsOther',4);
		});
		toggleOtherSC('generalCondition.livingConditions','livingConditionsOther',4);
	});
	
	/*
	 * 选择其他时，显示其他输入框 radioName：radio的name otherClass:otherClass,将要隐藏的类内容
	 * code:code之为radio的选择值时候，那么就执行隐藏
	 */
	function hideClassByClass(name, otherClass, code) {
		raValue = $('input[name="' + name + '"]:checked').val();
		if (raValue == code) {
			$("." + otherClass).show();
			$("." + otherClass).find("input").each(function() {
				$(this).show();
			});
		} else {
			$("." + otherClass).hide();
			$("." + otherClass).find("input[type=text]").each(function() {
				$(this).val('');
			});
			$("." + otherClass).find("input[type=radio]").each(function() {
				$(this).attr("checked", false);
			});
			$("." + otherClass).find("input[type=checkbox]").each(function() {
				$(this).attr("checked", false);
			});
			$("." + otherClass).find("select").each(function() {
				$(this).val('');
			});
		}
	}
})();