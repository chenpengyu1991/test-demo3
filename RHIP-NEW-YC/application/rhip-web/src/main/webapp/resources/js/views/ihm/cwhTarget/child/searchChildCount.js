var childSearch = (function() {
	var validate=null;
    $(function() {
       // $("#villageId").hide();
    	validate = $("#searchForm").easyValidate();
        $("#btnSearch").click(function(e) {
            e.preventDefault();
           search(1);
        });
        $("#btnSearch").onEnter(search, 1);
    });

    function search(pageIndex) {
		var result=validate.validateForm();
    	if(!result){
    		return;
    	}
        var searchObj = {
            url : '/ihm/child/statistics/childCountList',
            insertDiv : "childCountListDiv"
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
                    area: ['850px', '600px'],
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
        $.post(contextPath+'/ihm/neonatalVisitDetail', {
                id:id
            },
            function(ret) {
                layer.open({
                    type: 1,
                    id:'neonatalVisitDetail',
                    area: ['850px', '600px'],
                    title:'新生儿随访信息',
                    content: ret,
                    zIndex:layer.zIndex
                });
            });
       /* var dialog = {
            url : "/ihm/neonatalVisitDetail",
            param : {id:id},
            height : 570,
            width : 800,
            title : "新生儿随访信息" ,
            id :"dialog"
        };
        $.dialog(dialog);*/
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

      /*  var dialog = {
            url : "/ihm/healthExaminationDetail",
            param : {id:id},
            height : 570,
            width : 800,
            title : "儿童健康体检" ,
            id :"dialog"
        };
        $.dialog(dialog);*/
    }

	return {
		search:search,
        viewBirthCertificate:viewBirthCertificate,
        viewBirthDefect:viewBirthDefect,
        viewHealthCard:viewHealthCard,
        viewNeonatalVisit:viewNeonatalVisit,
        viewHealthExamination:viewHealthExamination
	};
})();



