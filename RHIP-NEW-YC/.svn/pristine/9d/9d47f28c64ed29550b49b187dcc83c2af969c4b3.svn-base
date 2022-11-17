var childSearch = (function() {
	var validate=null;
    $(function() {
        $("#advanceSearchConditionBtn").click(function(e) {
            e.preventDefault();
            controlAdvanceSearchSection($(this));
        });
    	validate = $("#searchForm").easyValidate();
    	$("#searchForm").onEnter(search, 1);
        $("#btnSearch").click(function(e) {
            e.preventDefault();
           search(1);
        });
        $("#btnSearch").onEnter(search, 1);
        search(1);
    });

    function search(pageIndex) {
		var result=validate.validateForm();
    	if(!result){
    		return;
    	}

        var searchType = $("#searchType").val();
        var url = '';
        if('1' == searchType){
            url = '/ihm/child/birthCertificate/list';
        }
        if('2' == searchType){
            url = '/ihm/child/birthDefect/list';
        }
        if('3' == searchType){
            url = '/ihm/child/healthCard/list';
        }
        if('4' == searchType){
            url = '/ihm/child/neonatalVisit/list';
        }
        if('5' == searchType){
            url = '/ihm/child/healthExamination/list';
        }
        if('6' == searchType){
            url = '/ihm/child/birthDefect/list';
        }
        if('7' == searchType){
            url = '/ihm/child/diseaseScreen/list';
        }
        if('8' == searchType){
            url = '/ihm/child/frailFollowup/list';
        }
        pageIndex = ($.isEmpty(pageIndex)?1:pageIndex);
        var searchObj = {
            url : url,
            insertDiv : "childListDiv",
            param : {
                pageIndex : pageIndex
            },
            callback : function(data) {
            	$("#pageIndex").val(pageIndex);
            }
        };
        $("#searchForm").submitFormLoadHtml(searchObj);
    };

    function viewBirthCertificate(id){
        $.post(contextPath+'/ihm/newBornDetail', {
            id:id
        },
        function(ret) {
            layer.open({
                type: 1,
                id:'newBornDetail',
                area: ['850px', '550px'],
                title:'出生医学证明',
                content: ret,
                zIndex:layer.zIndex
            });
        });
       /*
        var dialog = {
            url : "/ihm/newBornDetail",
            param : {id:id},
            height : 550,
            width : 750,
            title : "出生医学证明" ,
            id :"dialog"
        };
        $.dialog(dialog);*/
    }

    function viewBirthDefect(id){
        $.post(contextPath+'/ihm/birthDefectDetail', {
                id:id
            },
            function(ret) {
                layer.open({
                    type: 1,
                    id:'birthDefectDetail',
                    area: ['850px', '600px'],
                    title:'出生缺陷登记',
                    content: ret,
                    zIndex:layer.zIndex
                });
            });

      /*  var dialog = {
            url : "/ihm/birthDefectDetail",
            param : {id:id},
            height : 600,
            width : 800,
            title : "出生缺陷登记" ,
            id :"dialog"
        };
        $.dialog(dialog);*/
    }


    function viewHealthCard(id){
        $.post(contextPath+'/ihm/healthCardDetail', {
                id:id
            },
            function(ret) {
                layer.open({
                    type: 1,
                    id:'healthCardDetail',
                    area: ['850px', '600px'],
                    title:'儿童保健卡',
                    content: ret,
                    zIndex:layer.zIndex
                });
            });

       /* var dialog = {
            url : "/ihm/healthCardDetail",
            param : {id:id},
            height : 570,
            width : 800,
            title : "儿童保健卡" ,
            id :"dialog"
        };
        $.dialog(dialog);*/
    }

    function viewNeonatalVisit(id){
        $('#child-exam-list-box').hide();
        $('#child-exam-input-box').show();
        $.loadHtmlByUrl({
            url: '/ihm/neonatalVisitDetail',
            insertDiv: 'child-exam-input-box',
            param: {
                id:id
            }
        })
    }

    function editViewNeonatalVisit(id){
        $('#child-exam-list-box').hide();
        $('#child-exam-input-box').show();
        $.loadHtmlByUrl({
            url: '/ihm/addNeonatalVisitDetail',
            insertDiv: 'child-exam-input-box',
            param: {
            	id:id
            }
        })
    }
    function deleteViewNeonatalVisit(id){
    	layui.use('layer', function(){
    		var layer = layui.layer;
    		layer.confirm("确定要删除吗？", {icon:2, title:'确认提示'}, function(index){
				$.getJsonByUrl({
					url:"/ihm/deleteNeonatalVisit",
					param:{
						id:id
					},
					callback:function(data){
						if(data == "删除成功!"){
							layer.alert("删除成功！", {icon:0,title:'提示'}, function(){
								$("#btnSearch").click();
                                layer.close(index);
							});
						}else{
							layer.alert("删除失败！", {icon:0,title:'提示'});
						}
					}
				});
				layer.close(index);
    		});
    	});		
    	
    	
    }
    function viewChildExams() {
        $('#child-exam-list-box').show();
        $('#child-exam-input-box').hide();
        $.loadHtmlByUrl({
            url: '/ihm/child/neonatalVisit/list',
            insertDiv: 'child-exam-input-box',
            param: {
            	pageIndex:pageIndex
                /*examineAgeGroup: childSearch.examineAgeGroup,
                babyCardNo: babyCardNo*/
            }
        })
    }
    function viewHealthExamination(id){
        $.post(contextPath+'/ihm/healthExaminationDetail', {
                id:id
            },
            function(ret) {
                layer.open({
                    type: 1,
                    id:'healthExaminationDetail',
                    area: ['850px', '600px'],
                    title:'儿童健康体检',
                    content: ret,
                    zIndex:layer.zIndex
                });
            });

       /* var dialog = {
            url : "/ihm/healthExaminationDetail",
            param : {id:id},
            height : 570,
            width : 800,
            title : "儿童健康体检" ,
            id :"dialog"
        };
        $.dialog(dialog);*/
    }

    function viewDiseaseScreen(id){
        $.post(contextPath+'/ehrbrowser/health/neonatalDiseaseScreen', {
                personId:id
            },
            function(ret) {
                layer.open({
                    type: 1,
                    id:'neonatalDiseaseScreen',
                    area: ['850px', '600px'],
                    title:'新生儿疾病筛查',
                    content: ret,
                    zIndex:layer.zIndex
                });
            });

       /* var dialog = {
            url : "/ehrbrowser/health/neonatalDiseaseScreen",
            param : {personId:id},
            height : 600,
            width : 750,
            title : "新生儿疾病筛查" ,
            id :"dialog"
        };
        $.dialog(dialog);*/
    }

	return {
		search:search,
        viewDiseaseScreen:viewDiseaseScreen,
        viewBirthCertificate:viewBirthCertificate,
        viewBirthDefect:viewBirthDefect,
        viewHealthCard:viewHealthCard,
        viewNeonatalVisit:viewNeonatalVisit,
        editViewNeonatalVisit:editViewNeonatalVisit,
        deleteViewNeonatalVisit:deleteViewNeonatalVisit,
        viewHealthExamination:viewHealthExamination
	};
})();



