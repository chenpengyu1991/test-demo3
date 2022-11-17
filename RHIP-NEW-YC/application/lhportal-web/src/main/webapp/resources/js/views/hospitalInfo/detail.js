var hospitalInit = (function(){
	
	$(function() {
		/*hospitalInfo*/
		$("#yljg").click(function() {
			window.location.href = contextPath+ "/infoShow/hospitalList?indexPage=1";
		});
		$("#levelOne, #levelOne1, #levelOne2").click(function() {
			window.location.href = contextPath+ "/infoShow/hospitalList?grade=1&indexPage=1";
		});
		$("#levelTwo, #levelTwo1, #levelTwo2").click(function() {
			window.location.href = contextPath+ "/infoShow/hospitalList?grade=2&indexPage=1";
		});
		$("#levelThree, #levelThree1, #levelThree2").click(function() {
			window.location.href = contextPath+ "/infoShow/hospitalList?grade=3&indexPage=1";
		});
		$("#levelFour, #levelFour1, #levelFour2").click(function() {
			window.location.href = contextPath+ "/infoShow/hospitalList?grade=4&indexPage=1";
		});
		$("#yyjt").click(function() {
			window.location.href = contextPath+ "/infoShow/hospitalGroupList?indexPage=1";
		});
		$("#orgTypeA, #orgTypeA1").click(function() {
			window.location.href = contextPath+ "/infoShow/hospitalGroupList?orgType=A1&indexPage=1";
		});
		$("#orgTypeB, #orgTypeB1").click(function() {
			window.location.href = contextPath+ "/infoShow/hospitalGroupList?orgType=B1&indexPage=1";
		});
		
		/*hospitalInfo end*/
		init_hospital_tab();
		initPic();
	});
	
	function initPic() {
		var hasImg = $(".hospital-pic").find("img").html();
		if (hasImg == undefined) {
			$(".hospital-pic").append("<img src="+contextPath+"/images/hospic.png/>");
		}
	}
	
	//医院信息滚动
	function init_hospital_tab() {
		$("#titles").find("li").click(function() {
			var tabLiList=$("#titles li").find("a");
			var current_index = $(this).index();
			for(var i = 0;i < $("#titles").find("li").length;i++)
			{
				if(i == current_index){
					tabLiList.eq(i).addClass("select");
					$("#titleContent1_item0_" + i.toString()).show();
				}else{
					tabLiList.eq(i).removeClass("select");
					$("#titleContent1_item0_" + i.toString()).hide();
				}
			}
		});
	}

})();