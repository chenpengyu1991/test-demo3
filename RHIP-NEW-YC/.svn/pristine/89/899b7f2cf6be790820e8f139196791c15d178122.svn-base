/**
 * Created by haiyingjiang on 15/8/24.
 */

var interactionList = (function(){
    $(function() {
        initLinkClick('interactionDetail',interactionDetail, {id:"data-id"});
    });

    function interactionDetail(id) {
        window.location.href = contextPath+ "/interactionShow/detail?id="+id;
    }
    
    jQuery(".interaction_contents").slide({
		titCell:".messageTitle", //鼠标触发对象
		targetCell:".message", //与titCell一一对应，第n个titCell控制第n个targetCell的显示隐藏
		effect:"slideDown", //targetCell下拉效果
		delayTime:300 , //效果时间
		triggerTime:150, //鼠标延迟触发时间（默认150）
		defaultPlay:false,//默认是否执行效果（默认true）
		returnDefault:false, //鼠标从.sideMen移走后返回默认状态（默认false）
		autoPlay:false,
		trigger:"click"
		});

})();