var setupDisease = (function() {
    //保存的验证
    var validate=null;
    //查询的验证
    var validateSearch=null;

	$(function() {
        validate = $("#setForm").easyValidate();
        validateSearch = $("#resultForm").easyValidate();
        validateUnbind = $("#unbindForm").easyValidate();

        $("#setupBtnSearch").click(function(e) {
			e.preventDefault();
            search(1);
        });

        document.onkeydown = function (e) {
            var theEvent = window.event || e;
            var code = theEvent.keyCode || theEvent.which;
            if (code == 13) {
                search(1);
            }
        };
        //进页面就执行查询
        search(1);

        //页面加载完成后执行代码，执行【传染病名称的再拼接】
        load.pageLoad({
            callBack : function(){
            	queryInfection();
            	queryDisease();
            	addIcd10AutoComplete("disease");
            }
                     
        });

	});

//    查询
    function search(indexPage) {
//        debugger;
        var result=validateSearch.validateForm();
        if(!result){
            return;
        }
        
        //查询
        var searchObj = {
            url : "/idm/set/setupDiseaseList",
            insertDiv : "setDiv",
            param : {
                indexPage : indexPage
            }
        };
        $("#resultForm").submitFormLoadHtml(searchObj);
    };

//    保存设置动作
    function save() {

        var result=validate.validateForm();
        if(!result){
            return;
        }
        var itemCode = $('#infection option:selected').val();
        var icdCode = $('#bindDiseaseCode').val();
        if($.isEmpty(itemCode) || $.isEmpty(icdCode)){
            layer.alert("必须选择病名和绑定的ICD编码！", {icon:0,title:'提示'});
            return;
        }
       
        $("#setForm").submitFormGetJson({
            url : "/idm/set/saveBinding",
            param: {
            	itemCode : itemCode,
            	icdCode : icdCode
            },
           callback : function(data) {
                if (data.result =="fail") {
                    layer.alert(data.info, {icon:0,title:'提示'});
                }else {
                    layer.alert("保存成功！", {icon:0,title:'提示'});
                    search(1);
                    $("#unBindDiseaseCode").html("");
                    $("#searchDiseaseCode").html("");
                    queryDisease();
                    return false;
                }
            }
        });
    };
    
    //  单个疾病解除绑定
    function unbind() {
        var result=validateUnbind.validateForm();
        if(!result){
            return;
        }
        var icdCode = $('#unBindDiseaseCode option:selected').val();
        if($.isEmpty(icdCode)){
            layer.alert("必须选择ICD编码！", {icon:0,title:'提示'});
            return;
        }
       
        $("#unbindForm").submitFormGetJson({
            url : "/idm/set/unBinding",
            param: {
            	icdCode : icdCode
            },
           callback : function(data) {
                if (data.result =="fail") {
                    layer.alert(data.info, {icon:0,title:'提示'});
                }else {
                    layer.alert("解除绑定成功！", {icon:0,title:'提示'});
                    search(1);
                    $("#unBindDiseaseCode").html("");
                    $("#searchDiseaseCode").html("");
                    queryDisease();
                    return false;
                }
            }
        });
    };

    /*根据选择的疾病的code，取得疾病的名称*/
    function getInfectionsName(){
        var name = $('#infection option:selected').text();
        var obj = document.getElementsByName("infectiousCode")
        $('#infectiousName').val(name);
    };

//    组合39种疾病的下拉内容
    function queryInfection() {
        $("#searchInfectiousCode").append('<option value="">' + "请选择" + '</option>');
        $("#infection").append('<option value="">' + "请选择" + '</option>');
        $.getJsonByUrl({
            url : "/idm/set/queryInfection",
            callback : function(data) {
                $.each(data,function(key,values){
                    $("#infection").append('<option value="'+ key +'">' + values + '</option>');
                    $("#searchInfectiousCode").append('<option value="'+ key +'">' + values + '</option>');
                }); 
            }
        });
    };
    
    //  组合ICD10疾病的下拉内容
    function queryDisease() {
        $("#searchDiseaseCode").append('<option value="">' + "请选择" + '</option>');
        $("#unBindDiseaseCode").append('<option value="">' + "请选择" + '</option>');
        $.getJsonByUrl({
            url : "/idm/set/queryDiseaseJson",
            callback : function(data) {
                /*$.each(data.diseases,function(key,values){
                    $("#searchDiseaseCode").append('<option value="'+ key +'">' + key + '</option>');
                });*/
                $.each(data.icds,function(key,values){
                	$("#searchDiseaseCode").append('<option value="'+ key +'">' + key + '</option>');
                    $("#unBindDiseaseCode").append('<option value="'+ key +'">' + key + '</option>');
                });
            }
        });
    };
    
    function deleteSet(id) {
    	layui.use('layer', function(){
    		var layer = layui.layer;
    		layer.confirm("确认删除?", {icon:2, title:'确认提示'}, function(index){
				$.getJsonByUrl({
					url : "/idm/set/deleteBinding",
					callback:function(data){
						if (data.indexOf("fail") > -1) {
							layer.alert("删除失败！", {icon:0,title:'提示'});
		                }else {
		                	layer.alert("删除成功！", {icon:0,title:'提示'});
		                    search(1);
		                    $("#unBindDiseaseCode").html("");
		                    $("#searchDiseaseCode").html("");
		                    queryDisease();
		                    return false;
		                }
					},
					param:{
						id:id
					}
				});
				layer.close(index);
			});
		});		
	}
    
    function addIcd10AutoComplete(id){
        $.getJsonByUrl({
            url: "/idm/set/queryDisease",
            callback : function(data)
            {
                var mhmIcd10Code = $("#"+id);
                if (mhmIcd10Code.length > 0){
                    mhmIcd10Code.autocomplete(data, {
                        minChars: 0,
                        width:250,
                        max: 100,
                        autoFill: false,
                        matchContains: true,
                       // multiple: true,
                       // multipleSeparator: ",",  
                        //selectFirst : false, 
                        mustMatch: true,
                        formatItem: function(row, i, max) {
                            return  row.diseaseName + "[" + row.icd10main + "]";
                        },
                        formatMatch: function(row, i, max) {
                            return row.diseaseName + " " + row.icd10main;
                        },
                        formatResult: function(row) {
                            return row.diseaseName + " " + row.icd10main;
                        }
                    });
                }
            }
        });
    }

    return {
        search : search,
        save: save,
        deleteSet: deleteSet,
        getInfectionsName: getInfectionsName,
        unbind : unbind
    }
})();




