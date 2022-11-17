var baseLayoutLoad = (function(){
	$(function () {
		initMenu();
		initRollPic();
		//initPic();
		//首页医院集团滚动
		initTab();
		$("#jit_close").click(hidden);
		$("#jit_close1").click(hidden1);
		$("#jit_index").click(function(){
			open('index');
		});
		$("#jit_ill").click(function(){
			open('ill');
		});
		$("#dateDivId").html(initDate());
		$("#toLogin1").click(function() {common.toLogin();});
		$("#toRegister1").click(function() {common.toRegister();});
		$("#loginOut").click(function() {loginOut();});
		$("#toChangePwd").click(function() {toChangePwd();});
		$("#toChangePerInfo").click(function() {toChangePerInfo();});
		$("#bmiBtnId").click(showBMI);

		/*initLinkClick('moreYljg',moreYljg);*/
		initLinkClick('yljgDetail',yljgDetail, {id:"data-id", grade:"data-grade"});
		initLinkClick('yyjtDetail',yyjtDetail, {id:"data-id", orgType:"data-orgType"});
		initLinkClick('more',more, {id:"data-code"});
		initLinkClick('moreSub',moreSub, {id:"data-code"});
		initLinkClick('detail',detail, {id:"data-id"});
		
		initLinkClick('moreJkzd',moreJkzd);
		initLinkClick('jkzdDetail',jkzdDetail, {id:"data-id"});
		
		initLinkClick('moreZlxz',moreZlxz);
		initLinkClick('zlxzDetail',zlxzDetail, {id:"data-id", type:"data-type"});
		
		initLinkClick('moreDcwj',moreDcwj);
		initLinkClick('dcwjDetail',dcwjDetail, {id:"data-id"});
		
		initLinkClick('moreRmzj',moreRmzj);
		
	});
	
	/*function initPic() {
		for(var i = 0;i < $(".rmyyList").find("li").length;i++) {
			var hasImgs = $(".pic-"+i.toString()).find("a img").html();
			if (hasImgs == undefined) {
				$(".pic-"+i.toString()).find('a').append("<img src="+contextPath+"/images/doctor/doctor_default_img.jpg/>").html();
			}
		}
	}
*/
	function initRollPic() {
		 var ary = location.href.split("&");
		 	//滚动图片
			jQuery(".content_right").slide( { 
				mainCell:".bd ul", 
				effect:ary[1],
				autoPlay:ary[2],
				trigger:ary[3],
				easing:ary[4],
				delayTime:ary[5],
				mouseOverStop:ary[6],
				pnLoop:ary[7]
			});
			
			//滚动图片的文字描述
			jQuery(".content_right").slide({
				titCell: ".hd li",
				mainCell: ".bd",
				effect: "fold",
				autoPlay: true,
				trigger: "click",
				startFun: function(i) {
					jQuery(".content_right .txt li").eq(i).animate({
						"bottom": 0
					}).siblings().animate({
						"bottom": -30
					});
				}
			});
			
			//滚动新闻
			jQuery(".roll_news").slide({
				mainCell:".xwzxList ul",
				autoPlay:true,
				effect:"topMarquee",
				vis:8,
				interTime:80,
				trigger:"click"
			});
			
			//滚动热门医生
			jQuery(".roll_doctors").slide({
				mainCell:".rmyyList ul",
				autoPlay:true,
				effect:"leftMarquee",
				vis:4,
				interTime:80,
				trigger:"click",
			});
			
			//页面顶部登录后个人信息展示
			jQuery("#top_bar_info").slide({ 
				type:"menu",// 效果类型，针对菜单/导航而引入的参数（默认slide）
				titCell:".nLi1", //鼠标触发对象
				targetCell:".sub1", //titCell里面包含的要显示/消失的对象
				effect:"slideDown", //targetCell下拉效果
				delayTime:300 , //效果时间
				triggerTime:0 //鼠标延迟触发时间（默认150）
			});
	}
	
	function initDate() {
		var date = new Date();
		var yy=date.getFullYear();
		var mm=date.getMonth()+1;
		var dd=date.getDate();
		var ww=date.getDay();
		var ss=parseInt(date.getTime() / 1000);
		if (yy<100) yy="19"+yy;
		var week;
		if(new Date().getDay()==0) week="星期日"
		if(new Date().getDay()==1) week="星期一"
		if(new Date().getDay()==2) week="星期二"
		if(new Date().getDay()==3) week="星期三"
		if(new Date().getDay()==4) week="星期四"
		if(new Date().getDay()==5) week="星期五"
		if(new Date().getDay()==6) week="星期六"
		var fullDate = '今天是' + date.getFullYear() + '年' + (date.getMonth() + 1) + '月' + date.getDate() + '日，' + week+'，农历'+ GetLunarDay(yy,mm,dd);

		return fullDate;
	}
	
	//常熟初始化menu鼠标放上去的效果
	function initMenuCs() {
		$(function () {
			$("#nav ul li").hover(
				function(){
					$(this).attr("id","nav_hover");
					$("#nav_hover .menuTitle a").attr("class","select");
				},
				function(){
					$("#nav_hover .menuTitle .select").attr("class","");
					$(this).attr("id","");
				}
			);
		});
	};
	
	//罗湖初始化menu鼠标放上去的效果
	function initMenu() {
		$(function () {
			$("#nav ul li").hover(
				function(){
					$(this).attr("id","nav_hover");
					$("#nav_hover .menuTitle a").attr("class","select");
				},
				function(){
					$("#nav_hover .menuTitle .select").attr("class","");
					$(this).attr("id","");
				}
			);
		});
		
		/*$(function () {
			$(".top_bar_info ul li").hover(
				function(){
					$(this).attr("id","nav_hover");
					$("#top_bar_info .nLi1").attr("class","select");
				},
				function(){
					$("#top_bar_info .nLi1 .select").attr("class","");
					$(this).attr("id","");
				}
			);
		});*/
	};
	//首页医院集团滚动
	function initTab() {
		$("#tabs").find("li").mouseover(function() {
			var tabLiList=$("#tabs li").find("a");
			var current_index = $(this).index();
			for(var i = 0;i < $("#tabs").find("li").length;i++)
			{
				if(i == current_index){
					tabLiList.eq(i).addClass("select");
					$("#tabContent1_item0_" + i.toString()).show();
				}else{
					tabLiList.eq(i).removeClass("select");
					$("#tabContent1_item0_" + i.toString()).hide();
				}
			}
		});
	}
	
	function more(id) {
		window.location.href = contextPath+ "/infoShow/infoList?code="+id+"&indexPage=1";
	}
	function moreSub(id) {
		window.location.href = contextPath+ "/infoShow/infoChildList?code="+id+"&indexPage=1";
	}
	function moreYljg() {
		window.location.href = contextPath+ "/infoShow/hospitalList?indexPage=1";
	}
	function detail(id) {
		window.location.href = contextPath+ "/infoShow/infoDetail?id="+id;
	}
	function yljgDetail(id, grade) {
		window.location.href = contextPath+ "/infoShow/hospitalInfo?id="+id+"&grade="+grade;
	}
	function yyjtDetail(id, orgType) {
		window.location.href = contextPath+ "/infoShow/hospitalInfo?id="+id+"&orgType="+orgType;
	}
	function moreJkzd() {
		window.location.href = contextPath+ "/health/prescriptionMh/list?indexPage=1";
	}
	function jkzdDetail(id) {
		window.location.href = contextPath + "/health/prescriptionMh/detail/" + id;
	}
	
	function moreZlxz() {
		window.location.href = contextPath+ "/fileManager/index?indexPage=1";
	}
	function zlxzDetail(id, type) {
		window.location.href = contextPath+ "/fileManager/fileDetail?id="+id+"&type="+type;
	}
	
	function moreDcwj() {
		window.location.href = contextPath+ "/survey/index?indexPage=1";
	}
	function dcwjDetail(id) {
		window.location.href = contextPath+ "/survey/surveyDetail?id="+id;
	}
	
	function moreRmzj() {
		window.location.href = contextPath+ "/userSpace/hotExpert/search";
	}
	
	function loginOut(){
		$.getJsonByUrl({
			url : contextPath + "/accountInfo/loginOut",
			callback : function(model) {
				if(model.success){
					window.location.href = contextPath+"/home/infoIndex";
				}
			}
		});
	}
	
	function toChangePwd() {
		window.location.href = contextPath+ "/accountInfo/toChangePwd";
	}
	
	function toChangePerInfo() {
		window.location.href = contextPath+ "/accountInfo/toChangePerInfo";
	}
	function open(type) {
		var url = 'http://joytone.91160.com/index.php?c=guahao&a=step1';
		if(type == "ill"){
			url = 'http://joytone.91160.com/index.php?c=Ill&a=byletter&uid=100001950';
		}
		window.open(url,"_blank");
	};

	function hidden() {
		document.getElementById("suspension").style.display="none";
	};
	
	function hidden1() {
		document.getElementById("suspension1").style.display="none";
	};

	function showBMI() {
		var bmiDialog = {
			id :"bmiDialog",
			url : "/infoShow/bmi",
			height : "auto",
			width : 540,
			title : "体重自测"
		};
		$.dialog(bmiDialog);
	}

	return {
		moreYljg : moreYljg 
	}
})();
