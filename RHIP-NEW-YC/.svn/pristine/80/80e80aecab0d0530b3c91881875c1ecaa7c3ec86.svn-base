var hospitalInit = (function(){
	
	$(function() {
		/*hospitalInfo*/
		initList();
		initPic();
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
	});
	
	function initList() {
		for(var i = 0;i < $(".hospital-feature").find(".feature-detail").length;i++)
		{
			var description = $(".hospital-feature .detail-"+i.toString()).html();
			description=description.replace(/<\/?[^>]*>/gim,"");
			description = description.replace(/(^\s+)|(\s+$)/g, ""); 
			description = description.replace(/(\&nbsp;)/g, "");
			if(description.length > 70) {
				description = description.substring(0,70)+" . . ."; 
			}
			$(".hospital-feature .detail-"+i.toString()).html(description);
		}
	}
	
	function initPic() {
		for(var i = 0;i < $(".hospitalInfo_lists").find("li").length;i++) {
			var hasImgs = $(".pic-"+i.toString()).find("a img").html();
			if (hasImgs == undefined) {
				$(".hospital-info .pic-"+i.toString()).find('a').append("<img src="+contextPath+"/images/hospic.png/>").html();
			}
		}
	}
})();