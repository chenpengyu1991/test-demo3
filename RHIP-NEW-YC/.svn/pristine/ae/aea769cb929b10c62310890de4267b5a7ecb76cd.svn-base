var womanSearch = (function() {
	var validate=null;
    $(function() {
    	validate = $("#searchForm").easyValidate();
    	$("#searchForm").onEnter(search, 1);
        $("#btnSearch").click(function(e) {
            e.preventDefault();
            search(1);
        });
        search(1);

        //新增产后访视记录
        $("#postnatalAdd").click(function() {
            addPostnatalFollowup();
        });

        $("#postpartumFTwoAdd").click(function() {
            addPostpartumFTwo();
        });
    });

    function search(pageIndex) {
		var result=validate.validateForm();
    	if(!result){
    		return;
    	}
        var searchType = $("#searchType").val();
        var url = '';
        if('1' == searchType){
            url = '/ihm/woman/maternalCard/list';
        }
        if('2' == searchType){
            url = '/ihm/woman/prenatalVisit/list';
        }
        if('3' == searchType){
            url = '/ihm/woman/delivery/list';
        }
        if('4' == searchType){
            url = '/ihm/woman/postpartum/list';
        }
        if('5' == searchType){
            url = '/ihm/woman/highRisk/list';
        }
        if('6' == searchType){
            url = '/ihm/woman/death/list';
        }
        if('7' == searchType){
            url = '/ihm/woman/womanDiseaseCensus/list';
        }
        if('8' == searchType){
            url = '/ihm/woman/postnatalFollowup/list';
        }
        pageIndex = ($.isEmpty(pageIndex)?1:pageIndex);
        var searchObj = {
            url : url,
            insertDiv : "womanListDiv",
            param : {
                pageIndex : pageIndex
            },
            callback : function(data) {
            	$("#pageIndex").val(pageIndex);
            }
        };
        $("#searchForm").submitFormLoadHtml(searchObj);
    };

    function motherhoodPeriodFollowupDetail(id){
        $.post(contextPath+'/ihm/motherhoodPeriodFollowupDetail', {
                id:id
            },
            function(ret) {
                layer.open({
                    type: 1,
                    id:'motherhoodPeriodFollowupDetail',
                    area: ['850px', '550px'],
                    title:'孕产妇登记',
                    content: ret,
                    zIndex:layer.zIndex
                });
            });
       /* var dialog = {
            url : "/ihm/motherhoodPeriodFollowupDetail",
            param : {id:id},
            height : 550,
            width : 750,
            title : "孕产妇登记" ,
            id :"dialog"
        };
        $.dialog(dialog);*/
    }

    function prenatalVisit(id){
        $.post(contextPath+'/ihm/prenatalVisit', {
                id:id
            },
            function(ret) {
                layer.open({
                    type: 1,
                    id:'prenatalVisit',
                    area: ['850px', '550px'],
                    title:'产前检查登记',
                    content: ret,
                    zIndex:layer.zIndex
                });
            });

       /* var dialog = {
            url : "/ihm/prenatalVisit",
            param : {id:id},
            height : 600,
            width : 800,
            title : "产前检查登记" ,
            id :"dialog"
        };
        $.dialog(dialog);*/
    }


    function delivery(personId){
        $.post(contextPath+'/ihm/delivery', {
                personId:personId
            },
            function(ret) {
                layer.open({
                    type: 1,
                    id:'delivery',
                    area: ['850px', '550px'],
                    title:'产妇分娩记录',
                    content: ret,
                    zIndex:layer.zIndex
                });
            });

      /*  var dialog = {
            url : "/ihm/delivery",
            param : {personId:personId},
            height : 570,
            width : 800,
            title : "产妇分娩记录" ,
            id :"dialog"
        };
        $.dialog(dialog);*/
    }

    function postpartum(id){
        $("#postForTwo").hide();
        $("#insertPostForT").show();
        var dialog = {
            url : "/ihm/postpartum",
            insertDiv : "insertPostForT",
            param : {personId:id},
            height : 570,
            width : 800,
            title : "产后42天健康检查" ,
            id :"dialog"
        };
        $.loadHtmlByUrl(dialog);
    }
    function addPostpartumFTwo() {
        $("#postForTwo").hide();
        $("#insertPostForT").show();
        var dialog = {
            url : "/postpartum/addPostpartumFTwo",
            insertDiv : "insertPostForT",
            param : {},
            height : 570,
            width : 800,
            title : "产后42天健康检查" ,
            id :"dialog"
        };
        $.loadHtmlByUrl(dialog);
    }
    function modifyPostpartum(id) {
        $("#postForTwo").hide();
        $("#insertPostForT").show();
        var dialog = {
            url : "/postpartum/modifyPostpartumFTwo",
            insertDiv : "insertPostForT",
            param : {personId:id},
            height : 570,
            width : 800,
            title : "产后42天健康检查" ,
            id :"dialog"
        };
        $.loadHtmlByUrl(dialog);
    }
    function deletePostpartum(id) {
        if(id){
			layui.use('layer', function(){
			var layer = layui.layer;
			var index = layer.confirm('确认删除?', {icon:2, title:'确认提示'}, function(){
				$.getJsonByUrl({
					url : contextPath + "/postpartum/deletePostpartumFTwo",
					param:{
                    	personId: id
               		},
					callback : function(data) {
						if (data.indexOf("success") > -1) {
							layer.close(index);
							womanSearch.search(1);
							layer.alert("删除成功！", {icon:0,title:'提示'});
						} else if (data.indexOf("failed") > -1)  {
							layer.alert("删除失败！", {icon:0,title:'提示'});
						}
					}
				});
			});
		});
	
            /*layer.confirm("确认删除？", function(index) {
                $.getJsonByUrl({
                    url:"/postpartum/deletePostpartumFTwo",
                    callback:function(data){
                        if (data.indexOf("success") > -1) {
                            womanSearch.search(1);
                            layer.alert("删除成功！");
                        } else if (data.indexOf("failed") > -1) {
                            layer.alert("删除失败！");
                        }
                    },
                    param: {
                        personId: id
                    }
                });
                layer.close(index);
            });*/
        }
    }

    function highRisk(id){
        $.post(contextPath+'/ihm/healthExaminationDetail', {
                id:id
            },
            function(ret) {
                layer.open({
                    type: 1,
                    id:'healthExaminationDetail',
                    area: ['850px', '550px'],
                    title:'高危产妇管理',
                    content: ret,
                    zIndex:layer.zIndex
                });
            });


       /* var dialog = {
            url : "/ihm/healthExaminationDetail",
            param : {id:id},
            height : 570,
            width : 800,
            title : "高危产妇管理" ,
            id :"dialog"
        };
        $.dialog(dialog);*/
    }

    function getWomanDiseaseCensus(id){
        $.post(
            contextPath+'/ehrbrowser/health/womanDiseaseCensus',
            { id:id},
            function(ret){
                layui.use(['layer'], function() {
                    var layer = layui.layer
                    layer.open({
                        type: 1,
                        id:'womanDiseaseDialog',
                        area: ['850px', '450px'],
                        title:'妇女病普查',
                        content: ret
                    });
                });
            }
        );
    }

    function getPostnatalFollowup(id){
        $("#pFollowupId").hide();
        $("#pFOUpDiv").show();
        var dialog = {
            url : "/ehrbrowser/health/postnatalFollowup",
            insertDiv : "pFOUpDiv",
            param : {id:id},
            height : 570,
            width : 800,
            title : "产后访视记录表" ,
            id :"dialog"
        };
        $.loadHtmlByUrl(dialog);
    }

    function addPostnatalFollowup() {
        $("#pFollowupId").hide();
        $("#pFOUpDiv").show();
        var dialog = {
            url : "/maternal/addPostpartumVisit",
            insertDiv : "pFOUpDiv",
            param : {},
            height : 570,
            width : 800,
            title : "新增产后访视" ,
            id :"dialog"
        };
        $.loadHtmlByUrl(dialog);
    }

    function modifyPostnatalFollowup(id) {
        $("#pFollowupId").hide();
        $("#pFOUpDiv").show();
        var dialog = {
            url : "/maternal/modifyPostpartumVisit",
            param : {id:id},
            insertDiv : "pFOUpDiv",
            height : 570,
            width : 800,
            title : "产后访视修改" ,
            id :"dialog"
        };
        $.loadHtmlByUrl(dialog);
    }

    function deletePostnatalFollowup(id) {
        if(id){
	
			layui.use('layer', function(){
			var layer = layui.layer;
			var index = layer.confirm('确认删除?', {icon:2, title:'确认提示'}, function(){
				$.getJsonByUrl({
					url : contextPath + "/maternal/deletePostpartumVisit",
					param:{
                    	id: id
               		},
					callback : function(data) {
						if (data.indexOf("success") > -1) {
							layer.close(index);
							womanSearch.search(1);
							layer.alert("删除成功！", {icon:0,title:'提示'});
						} else if (data.indexOf("failed") > -1)  {
							layer.alert("删除失败！", {icon:0,title:'提示'});
						}
					}
				});
			});
		});
        }
    }
    
	return {
		search:search,
        motherhoodPeriodFollowupDetail:motherhoodPeriodFollowupDetail,
        prenatalVisit:prenatalVisit,
        delivery:delivery,
        postpartum:postpartum,
        modifyPostpartum:modifyPostpartum,
        deletePostpartum:deletePostpartum,
        getWomanDiseaseCensus:getWomanDiseaseCensus,
        getPostnatalFollowup:getPostnatalFollowup,
        modifyPostnatalFollowup:modifyPostnatalFollowup,
        deletePostnatalFollowup:deletePostnatalFollowup,
        highRisk:highRisk
	};
})();



