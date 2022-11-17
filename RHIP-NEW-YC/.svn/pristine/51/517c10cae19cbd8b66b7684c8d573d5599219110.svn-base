
var hivCase = (function() {
	$(function() {

        toggleOther('attackCondition.deathCause','deathCauseOtherDiv',4);
        toggleOther('attackCondition.infectionRoute','infectionRouteOtherDiv',99);
        toggleOther('exposureHistory.takeDrugHis','takeDrugDiv',1);
        toggleOther('exposureHistory.sexBehaviorHis','sexBehaviorHisDiv',1);
        toggleOther('exposureHistory.oppositeSexBehavior','oppositeSexBehaviorDiv',1);
        toggleOther('exposureHistory.commercialSexBehavior','commercialSexBehaviorDiv',1);
        toggleOther('exposureHistory.marriageSexBehavior','marriageSexBehaviorDiv',1);
        toggleOther('exposureHistory.noComMarSexBeh','noComMarSexBehDiv',1);
        toggleOther('exposureHistory.gaySexBehavior','gaySexBehaviorDiv',1);
        toggleOther('exposureHistory.receptionBloodHistory','receptionBloodHistoryDiv',1);
        toggleOther('exposureHistory.donateBloodHistory','donateBloodHistoryDiv',1);
        toggleOnes('exposureHistory.havingChildren','havingChildrenDiv','1,3');
        toggleOther('exposureHistory.immunizationHistory','immunizationHistoryDiv',1);
        toggleOther('exposureHistory.exposureWay','exposureWayDiv',5);
        toggleOtherCK('attackCondition.clinicalManifestation','clinicalOtherDiv',18);
        toggleOtherSC('attackCondition.crowdCategory','crowdCategoryOtherDiv',28);
        toggleOtherSC('attackCondition.sampleSource','sampleSourceOtherDiv',99);

        
        caseEdit.toggerAddress();
	});

    /*
     * 选择其他时，显示其他输入框 radioName：radio的name otherId:DivId,其他输入框等放在Div中
     * code:当当前选中的radio的值与是code包含的任意值时显示otherId
     */
    function toggleOnes(radioName, otherId, code)
    {
    	var raValue = $('input[name="' + radioName + '"]:visible:checked').val();
    	if (code.indexOf(raValue) != -1)
    	{
    		$("#" + otherId).show();
    		$("#" + otherId).find("input").each(function()
    		{
    			$(this).show();
    		});
    	} else
    	{
    		$("#" + otherId).hide();
    		$("#" + otherId).find("input[type=text]").each(function()
    		{
    			$(this).val('');
    		});
    		$("#" + otherId).find("input[type=radio]").each(function()
    		{
    			$(this).attr("checked", false);
    		});
    		$("#" + otherId).find("input[type=checkbox]").each(function()
    		{
    			$(this).attr("checked", false);
    		});
    		$("#" + otherId).find("select").each(function()
    		{
    			$(this).val('');
    		});
    	}	
    }

    return {
        toggleOnes:toggleOnes
    };
})();




