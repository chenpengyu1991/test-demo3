// Array.prototype.remove = function(val) { 
//     var index = this.indexOf(val); 
//     if (index > -1) { 
//         return  this.splice(index, 1); 
//     }

// };
$(function () {


    //左侧菜单效果
    
    $('.whch-left-nav #nav').on('click', 'li', function(event) {

        var index = $('.whch-left-nav #nav li').index($(this));
        $(".whch-left-nav #nav a").attr("style","");
        $('.whch-left-nav #nav li').eq(index).children('a').attr("style","background-color:#ffffff;");
        

        if($(this).children('.sub-menu').length){
            if($(this).hasClass('open')){

                if($(this).parent().hasClass('sub-menu')){
                    deleteCookie('left_menu_son');
                }else{
                    deleteCookie('left_menu_father');
                }

                $(this).removeClass('open');
                $(this).find('.nav_right').html('&#xe697;');
                $(this).children('.sub-menu').stop().slideUp();
                $(this).siblings().children('.sub-menu').slideUp();
            }else{
                

                if($(this).parent().hasClass('sub-menu')){
                    setCookie('left_menu_son',index);
                }else{
                    setCookie('left_menu_father',index);
                }

                $(this).addClass('open');
                $(this).children('a').find('.nav_right').html('&#xe6a6;');
                $(this).children('.sub-menu').stop().slideDown();
                $(this).siblings().children('.sub-menu').stop().slideUp();
                $(this).siblings().find('.nav_right').html('&#xe697;');
                $(this).siblings().removeClass('open');
            }
        } else {
        	
        }
        
        event.stopPropagation();
         
    })

    // 左侧菜单记忆功能
    /*if(getCookie('left_menu_father')!=null){
        $('.whch-left-nav #nav li').eq(getCookie('left_menu_father')).click();
    }

    if(getCookie('left_menu_son')!=null){
        $('.whch-left-nav #nav li').eq(getCookie('left_menu_son')).click();
    }*/
     
     
     
    
})




