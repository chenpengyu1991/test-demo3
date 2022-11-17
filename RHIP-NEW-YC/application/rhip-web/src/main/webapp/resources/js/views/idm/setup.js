var setup = (function() {
    //保存的验证
    var validate=null;
    //查询的验证
    var validateSearch=null;

	$(function() {
        validate = $("#setForm").easyValidate();
        validateSearch = $("#resultForm").easyValidate();

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


        //给保存的机构加上请选择
        $("#organization").multiselect({
            header : false,
            noneSelectedText : '请选择',
            selectedList : 39
        });

        //进页面就执行查询
        search(1);

        //页面加载完成后执行代码，执行【传染病名称的再拼接】
        load.pageLoad({
            callBack : queryInfection
        });

	});

//    查询
    function search(indexPage) {
//        debugger;
        var result=validateSearch.validateForm();
        if(!result){
            return;
        }
        //设置页面上的年份描述
        if($("#searchYear").val()!= null && $("#searchYear").val() != ""){
            document.getElementById("labelYear").innerHTML=$("#searchYear").val();
        }else{
            document.getElementById("labelYear").innerHTML="未指定";
        }
        //查询
        var searchObj = {
            url : "/idm/set/setupList",
            insertDiv : "setDiv",
            param : {
                indexPage : indexPage
            }
        };
        $("#resultForm").submitFormLoadHtml(searchObj);
    };

//    保存设置动作
    function save() {
//        debugger;
        var result=validate.validateForm();
        if(!result){
            return;
        }
        var infectiousStr = $('#infectiousName').val();
        var organizationStr = $('#organization option:selected').text();

        if($.isEmpty(infectiousStr) || $.isEmpty(organizationStr)){
            layer.alert("必须选择病名和机构！", {icon:0,title:'提示'});
            return;
        }

        $("#setForm").submitFormGetJson({
            url : "/idm/set/save",
           callback : function(data) {
                if (data.indexOf("fail") > -1) {
                    layer.alert("保存失败！", {icon:0,title:'提示'});
                }else {
                    layer.alert("保存成功！", {icon:0,title:'提示'});
                    search(1);
                    return false;
                }
            }
        });
    };

    /*根据选择的疾病的code，取得疾病的名称*/
    function getInfectionsName(){
        var name = $('#disease option:selected').text();
        var obj = document.getElementsByName("infectiousCode")
        $('#infectiousName').val(name);
    };

//    组合39种疾病的下拉内容
    function queryInfection() {
        $("#searchInfectiousCode").append('<option value="">' + "请选择" + '</option>');

        $.getJsonByUrl({
            url : "/idm/set/queryInfection",
            callback : function(data) {
                $.each(data,function(key,values){
                    $("#disease").append('<option value="'+ key +'">' + values + '</option>');
                    $("#searchInfectiousCode").append('<option value="'+ key +'">' + values + '</option>');
                });
                $("#disease").multiselect({
                    header : false,
                    noneSelectedText : '请选择',
                    selectedList : 39
                });
            }
        });
    };
    
    function deleteSet(id) {
    	layui.use('layer', function(){
    		var layer = layui.layer;
    		layer.confirm("确认删除?", {icon:2, title:'确认提示'}, function(index){
				$.getJsonByUrl({
					url : "/idm/set/delete",
					callback:function(data){
						if (data.indexOf("fail") > -1) {
							layer.alert("删除失败！", {icon:0,title:'提示'});
		                }else {
		                	layer.alert("删除成功！", {icon:0,title:'提示'});
		                    search(1);
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

    return {
        search : search,
        save: save,
        deleteSet: deleteSet,
        getInfectionsName: getInfectionsName
    }
})();




