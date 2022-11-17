/**
 * Created by haiyingjiang on 15/8/18.
 */
var common = (function(){
    function toRegister() {
    	window.location.href = contextPath+ "/accountInfo/toRegister";
    }

    function toFindPwd() {
        window.location.href = contextPath+ "/accountInfo/toFindPwd";
    }

    function toLogin() {
        window.location.href = contextPath+ "/accountInfo/toLogin";
    }
    /**
     * block page UI ,show wait
     */
    function toBlockUI(){
    	//等待gif路径
    	imageurl = '<h1><img src="'+contextPath+'/images/wait.gif" /></h1>';
    	$.blockUI({
    		message : imageurl
    	})
    }
    /**
     * unblock page UI
     */
    function toUnBlockUI(){
    	$.unblockUI(); 
    }
    return {
        toRegister: toRegister,
        toFindPwd: toFindPwd,
        toLogin: toLogin,
        toBlockUI: toBlockUI,
        toUnBlockUI: toUnBlockUI
    };
})();