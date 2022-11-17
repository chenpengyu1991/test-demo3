var referralSearch = (function(){
    $(function(){
        $("#searchForm").onEnter(search, 1);
        $("#searchBtn").click(function(e) {
        	e.preventDefault();
            search(1);
        });
        $("#addOutBtn").click(function() {
            addReferral(1);
        });
        $("#addBackBtn").click(function() {
            addReferral(2);
        });
        search(1);
    })

    function search(indexPage){
        if (indexPage == null) {
            indexPage = $("#indexPage").val();
        }
        var searchOption = {
            url : contextPath + "/ehrbrowser/basic/referralInfoSearch",
            insertDiv : "listDiv",
            param : {
                indexPage : indexPage
            }
        }
        $("#searchForm").submitFormLoadHtml(searchOption);
    }

    function addReferral(dualReferralType){
/*        $.post(contextPath+'/ehrbrowser/basic/addReferralInfo', {
        	dualReferralType : dualReferralType
        },
        function(ret) {
        	layui.use(['layer'], function() {
        	  var layer = layui.layer
        	  layer.open({
        		  type: 1,
        		  id:'echDialog',
        		  area: ['800px', '650px'],
        		  title:'双向转诊单新增',
        		  content: ret
        	  });
        	});
        });*/
        $.loadHtmlByUrl({
            url :contextPath+'/ehrbrowser/basic/addReferralInfo',
            insertDiv :"referral_info",
            param : {
                dualReferralType : dualReferralType
            },
            wait : true
        });
    }
    function detail(id){
        if (!id)
        {
            return;
        }
       /* var param = {
            id : id,
            operation : "view"
        };*/
       /* var dialogParams = {
            id : "referralInfoDialog",
            url : contextPath + "/ehrbrowser/basic/referralInfoOperation",
            param : param,
            height : 500,
            width : 790,
            title : "双向转诊单查看"
        };

        $.dialog(dialogParams);*/
/*        $.post(contextPath+"/ehrbrowser/basic/referralInfoOperation",
        		{id : id,
                 operation : "view"}, 
	            function(ret){
				layui.use(['layer'], function() {
	        		  var layer = layui.layer
	        		  layer.open({
	        			  type: 1,
	        			  area: ['790px', '580px'],
	        			  title:"双向转诊单查看",
	        			  content: ret
	        		  });
	        		});
	        	});*/
        var requestUrlType =$("#requestUrlType").val();
        $.loadHtmlByUrl({
            url :contextPath+'/ehrbrowser/basic/referralInfoOperation',
            insertDiv :"referral_info",
            param : {
                id : id,
                operation : "view",
                requestUrlType:requestUrlType
    },
            wait : true
        });
    }

    function edit(id){
        if (!id)
        {
            return;
        }
       /* var param = {
            id : id,
            operation : "edit"
        };
        var dialogParams = {
            id : "referralInfoDialog",
            url : contextPath + "/ehrbrowser/basic/referralInfoOperation",
            param : param,
            height : 500,
            width : 790,
            title : "双向转诊单修改"
        };

        $.dialog(dialogParams);*/
/*        $.post(contextPath+"/ehrbrowser/basic/referralInfoOperation",
        		{id : id,
        	    operation : "edit"}, 
	            function(ret){
	        		  layer.open({
	        			  type: 1,
	        			  area: ['790px', '510px'],
	        			  title:"双向转诊单修改",
	        			  content: ret
	        		  });
	        	});*/
        $.loadHtmlByUrl({
            url :contextPath+'/ehrbrowser/basic/referralInfoOperation',
            insertDiv :"referral_info",
            param : {
                id : id,
                operation : "edit"
            },
            wait : true
        });
    }

    function del(id){
        /*layer.confirm("是否删除该记录？", (function(index) {
            var option = {
                url : "/ehrbrowser/basic/deleteReferralInfo",
                param : {
                    id : id
                },
                callback : (function(result) {
                    layer.alert(result.message);
                    if (result.success) {
                        search();
                    }
                })
            };
            $.getJsonByUrl(option);
            layer.close(index);
        }));*/
    	var option = {
                url : "/ehrbrowser/basic/deleteReferralInfo",
                param:{
                	id : id
                },
                callback:function(result){
                	layui.use('layer', function(){
            			var layer = layui.layer;
            			if(result.success) {
            				layer.alert(result.message, {icon:0,title:'提示'}, function(){
            					window.parent.location.reload();//刷新父页面
//            					search(1);
            				});
            			}
            			layer.alert(result.message, {icon:0,title:'提示'});
            		});
                }
            };
    		
    		layui.use('layer', function(){
    			var layer = layui.layer;
    			layer.confirm('确认要删除吗？', {icon:2, title:'确认提示'}, function(index){
    				//发异步删除数据
    				$.getJsonByUrl(question);
//    				layer.msg('已删除!',{icon:1,time:1000});
    			});
    		});
    }


    return {
        search : search,
        addReferral : addReferral,
        detail : detail,
        edit : edit,
        del : del
    }
})();