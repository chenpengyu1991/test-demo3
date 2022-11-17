var popDistribution = (function () {

    $(function () {

        $("#editBody").hide();
        showModifyButton();

        $("#modifyCommunityIdSpan").on("click", function (e) {
        	e.preventDefault();
            $("#displayBody").hide();
            $("#editBody").show();
            showCancelButton();

        });

        $("#cancelCommunityId").click(function (e) {
        	e.preventDefault();
            getPersonCountData(false);
            $("#displayBody").show();
            $("#editBody").hide();
            showModifyButton();
        });

        $("#saveCommunityId").click(function (e) {
        	e.preventDefault();
            // 保存修改的内容：
            saveCommunityInfo();
        });

        $("#popSearch").on("click", function (e) {
        	e.preventDefault();
        	if($("#countYear").val()!=null && $("#countYear").val()!="" &&$("#countYear").val()!=undefined){
        		getPersonCountData(true);
        	}else{
        		layui.use('layer', function(){
        			var layer = layui.layer;
        			layer.alert('请选择年度！', {icon:0,title:'提示'});
        		});
        	}
            
        });

        getPersonCountData(false);
    });


    function getPersonCountData(check) {
    	var countYear = $("[name='PopulaceDTO.countYear']").val();
        var townCode = $("[name='PopulaceDTO.gbCode']").val();
        var organCode = $("[name='PopulaceDTO.organCode']").val();
        if(townCode){
            getPopChangeData(townCode, organCode,countYear);
        } else if (check) {
        	layui.use('layer', function(){
    			var layer = layui.layer;
    			layer.alert('请选择区县！', {icon:0,title:'提示'});
    		});
        }
    }

    function showModifyButton() {
        $("#cancelCommunityIdSpan").hide();
        $("#modifyCommunityIdSpan").show();
        $("[name='PopulaceDTO.gbCode']").prop("disabled",false);
        $("[name='PopulaceDTO.organCode']").prop("disabled",false);
    };

    function showCancelButton() {
        $("#modifyCommunityIdSpan").hide();
        $("#cancelCommunityIdSpan").show();
        $("[name='PopulaceDTO.gbCode']").prop("disabled",true);
        $("[name='PopulaceDTO.organCode']").prop("disabled",true);
    };

    function initCal() {
        $("#communityInfoForm").find("input[name*='householdNum']").on("blur", function () {
            var householdNum = $(this).attr("name");
            var householdPhbNum = householdNum.replace("householdNum", "householdPhbNum");
            var householdDiNum = householdNum.replace("householdNum", "householdDiNum");
            var householdMentalNum = householdNum.replace("householdNum", "householdMentalNum");
            var householdGreatSixfNum = householdNum.replace("householdNum", "householdGreatSixfNum");
            var total = $("input[name='" + householdNum + "']").val();
            var phb = (total*0.78*0.218).toFixed(0);
            var di = (total*0.78*0.05).toFixed(0);
            var mental = (total*0.0036).toFixed(0);
            var sixf = (total*0.0768).toFixed(0);
            $("input[name='" + householdPhbNum + "']").attr("value", phb.toString());
            $("input[name='" + householdDiNum + "']").attr("value", di.toString());
            $("input[name='" + householdMentalNum + "']").attr("value", mental.toString());
            $("input[name='" + householdGreatSixfNum + "']").attr("value", sixf.toString());
        });
        $("#communityInfoForm").find("input[name*='unHouseHoldNum']").on("blur", function () {
            var unHouseHoldNum = $(this).attr("name");
            var unhouseholdPhbNum = unHouseHoldNum.replace("unHouseHoldNum", "unhouseholdPhbNum");
            var unhouseholdDiNum = unHouseHoldNum.replace("unHouseHoldNum", "unhouseholdDiNum");
            var unhouseholdMentalNum = unHouseHoldNum.replace("unHouseHoldNum", "unhouseholdMentalNum");
            var unHouseholdGreatSixfNum = unHouseHoldNum.replace("unHouseHoldNum", "unHouseholdGreatSixfNum");
            var total = $("input[name='" + unHouseHoldNum + "']").val();
            var phb = (total*0.78*0.218).toFixed(0);
            var di = (total*0.78*0.05).toFixed(0);
            var mental = (total*0.0036).toFixed(0);
            var sixf = (total*0.0768).toFixed(0);
            $("input[name='" + unhouseholdPhbNum + "']").attr("value", phb.toString());
            $("input[name='" + unhouseholdDiNum + "']").attr("value", di.toString());
            $("input[name='" + unhouseholdMentalNum + "']").attr("value", mental.toString());
            $("input[name='" + unHouseholdGreatSixfNum + "']").attr("value", sixf.toString());
        });
        $("#communityInfoForm").find("input[name*='householdManNum']").on("blur", function () {
            var householdManNum = $(this).attr("name");
            var householdNum = householdManNum.replace("householdManNum", "householdNum");
            var householdWomanNum = householdManNum.replace("householdManNum", "householdWomanNum");
            var total = $("input[name='" + householdNum + "']").val();
            var man = $("input[name='" + householdManNum + "']").val();
            var woman = total - man;
            $("input[name='" + householdWomanNum + "']").attr("value", woman.toString());
        });

        $("#communityInfoForm").find("input[name*='householdWomanNum']").on("blur", function () {
            var householdWomanNum = $(this).attr("name");
            var householdNum = householdWomanNum.replace("householdWomanNum", "householdNum");
            var householdManNum = householdWomanNum.replace("householdWomanNum", "householdManNum");
            var total = $("input[name='" + householdNum + "']").val();
            var woman = $("input[name='" + householdWomanNum + "']").val();
            var man = total - woman;
            $("input[name='" + householdManNum + "']").attr("value", man.toString());
        });

        $("#communityInfoForm").find("input[name*='unHouseholdManNum']").on("blur", function () {
            var unHouseholdManNum = $(this).attr("name");
            var unHouseholdNum = unHouseholdManNum.replace("unHouseholdManNum", "unHouseHoldNum");
            var unHouseholdWomanNum = unHouseholdManNum.replace("unHouseholdManNum", "unHouseholdWomanNum");
            var total = $("input[name='" + unHouseholdNum + "']").val();
            var man = $("input[name='" + unHouseholdManNum + "']").val();
            var woman = total - man;
            $("input[name='" + unHouseholdWomanNum + "']").attr("value", woman.toString());
        });

        $("#communityInfoForm").find("input[name*='unHouseholdWomanNum']").on("blur", function () {
            var unHouseholdWomanNum = $(this).attr("name");
            var unHouseholdNum = unHouseholdWomanNum.replace("unHouseholdWomanNum", "unHouseHoldNum");
            var unHouseholdManNum = unHouseholdWomanNum.replace("unHouseholdWomanNum", "unHouseholdManNum");
            var total = $("input[name='" + unHouseholdNum + "']").val();
            var woman = $("input[name='" + unHouseholdWomanNum + "']").val();
            var man = total - woman;
            $("input[name='" + unHouseholdManNum + "']").attr("value", man.toString());
        });
    }


    function saveCommunityInfo() {
        var townCode = $("[name='PopulaceDTO.gbCode']").val();
        var organCode = $("[name='PopulaceDTO.organCode']").val();
        var countYear= $("[name='PopulaceDTO.countYear']").val();
        $("#communityInfoForm").submitFormLoadHtml({
            url: contextPath + "/populace/populaceUpdate",
            insertDiv: "pop_dis_result_div",
            param: {
                "PopulaceDTO.gbCode": townCode,
                "PopulaceDTO.organCode": organCode,
                "PopulaceDTO.countYear" : countYear
            },
            callback: function () {
            	getPersonCountData(true);
            	layui.use('layer', function(){
        			var layer = layui.layer;
        			var index = layer.alert('修改成功!', {icon:0,title:'提示'}, function(){
        				layer.close(index);
        				showModifyButton();
        				initCal();
        			});
        		});
            }
        });
    };

    function getPopChangeData(townCode, organCode,countYear) {
        $("#communityInfoSearchForm").submitFormLoadHtml({
            url: contextPath + "/populace/popChange",
            param: {
                gbCode: townCode,
                organCode: organCode,
                countYear : countYear
            },
            insertDiv: "pop_dis_result_div",
            callback: function () {
                showModifyButton();
                initCal();
            }
        });
    };
})();