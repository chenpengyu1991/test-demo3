function b(){
	h = $(window).height();
	t = $(document).scrollTop();
	if(t > h){
		$('#gotop').show();
	}else{
		$('#gotop').hide();
	}
}
$(document).ready(function(e) {
	b();
	$('#gotop').click(function(){
		$(document).scrollTop(0);	
	})
	$('#AndroidApp').hover(function(){
			$(this).attr('id','AndroidApp_hover');
			$('#AndroidApp_img').show();
		},function(){
			$(this).attr('id','AndroidApp');
			$('#AndroidApp_img').hide();
	})
	$('#iPhoneApp').hover(function(){
			$(this).attr('id','iPhoneApp_hover');
			$('#iPhoneApp_img').show();
		},function(){
			$(this).attr('id','iPhoneApp');
			$('#iPhoneApp_img').hide();
	})
	$('#qrCode').hover(function(){
			$(this).attr('id','qrCode_hover');
			$('#qrCode_img').show();
		},function(){
			$(this).attr('id','qrCode');
			$('#qrCode_img').hide();
	})
	$('#gotop').hover(function(){
			$(this).attr('id','gotop_hover');
		},function(){
			$(this).attr('id','gotop');
	})
	$("#AndroidApp").add("#androidAppDownload").click(function() {
		window.location.href = "http://www.pgyer.com/AndroidYinChuanFormal";
	});
	$("#iPhoneApp").add("#iphoneAppDownload").click(function() {
		window.location.href = "https://itunes.apple.com/cn/app/yin-chuan-zhi-hui-yi-liao/id1073315154?mt=8";
	});
});

$(window).scroll(function(e){
	b();		
})
