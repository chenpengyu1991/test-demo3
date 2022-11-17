define(function() {
	function load() {
		$(function () {
			pageUtil.bind("resultDiv",search);

			validate = $("#weightSearchForm").easyValidate();

			//initOrg();

			$("#weightSetSearchId").click(function() {
				search(1);
			});
			$("#weightSearchForm").onEnter(search, 1);
			search(1);
			$("#weight-set-add-btn").click(add);
		});
	}
    function initOrg(){
    	init('organCode','A1,B1,B2',['0']);
    }

    function add() { 
		$("#top_all_weight").hide();
		//var pageIndex = $("#currentPage" + tbType).val();
		$.loadHtmlByUrl({
			url : "/report/rpWeight/add",
			insertDiv :"detailDivWeight"
		});
		$("#detailDivWeight").show();
	};
	
	function search(pageIndex){
		$("#top_all_weight").show();
		$("#detailDivWeight").hide();
		var result=validate.validateForm();
		if(!result){
			return;
		}
		pageIndex = ($.isEmpty(pageIndex)?1:pageIndex);
		var searchObj = {
			url : "/report/rpWeight/list",
			insertDiv : "resultDiv",
			param : {
				indexPage : pageIndex
			},
			callback : function(data) {
				$("#pageIndex").val(pageIndex);
				initLinkClick('deleteWeightSet',delWeightSet, {id:"data-id"});
			}
		};
		$("#weightSearchForm").submitFormLoadHtml(searchObj);
	}

	function delWeightSet(id) {
		layui.use('layer', function(){
			var layer = layui.layer;
			layer.confirm("确认删除?", {icon:2, title:'确认提示'}, function(index){
				deleteDo(id);
				layer.close(index);
			});
		});		
	}

	function deleteDo(id){
		$.getJsonByUrl({
			url : "/report/rpWeight/delete",
			callback:function(data){
				if (data == "success") {
					layer.alert("删除成功！", {icon:0,title:'提示'});
					search($("#currentPage").val());
				} else  {
					layer.alert("删除失败！", {icon:0,title:'提示'});
				}
			},
			param:{
				id:id
			}
		});
	}

    /**
     * 初始化机构控件
     * orgId:控件ID
     * orgType:机构类型
     * unSelectType:不能选择的机构类型
     */
	function init(orgId,orgType,unSelectType){
        //机构下拉树设置
        var option={
            url:"/mdmOrganization/organationTree",
            unSelecteType:unSelectType,  //下来树不能类型：0：镇，B1:中心，B2:站
            param:{organType:orgType},  //查询机构类型,逗号分割
            selectFun:selectTreeFun
        };
        //机构自动检索设置
        var opb = {
            url:"/mdmOrganization/organationSelect",
            feild: {
                value: "organCode",
                lable: "organName"
            },
            param:{organType:orgType},  //查询机构类型,逗号分割
            selectFun:selectBoxFun
        };

        var hospitalCode=$("#" + orgId);
        if(hospitalCode.length>0){
            //初始化自动检索
            hospitalCode.selectBox(opb);
            //初始化下拉树
            hospitalCode.initTreeSelect(option);
        }
    }   
    
    /**
     * 机构下拉树回调
     */
    function selectTreeFun(data){
    	var orgType = $("input[name='orgType'][type='radio']:checked").val();
    	$('#genreCode' + orgType).val(data.type);
    	$('#genreCode').val(data.type);
    }
    /**
     * 机构自动检索回调
     */
    function selectBoxFun(data){
    	var orgType = $("input[name='orgType'][type='radio']:checked").val();
    	$('#genreCode' + orgType).val(data.attr('genreCode'));
    	$('#genreCode').val(data.attr('genreCode'));
    }
	function changeOrgType(){
		var orgType = $('input:radio[name="orgType"]:checked').val();
		if(orgType == '1'){
			$('#orgCode1').show();
			$('#orgCode2').hide();
			$('#orgCode3').hide();
			$('#orgCode4').hide();
		}else if(orgType == '2'){
			$('#orgCode1').hide();
			$('#orgCode2').show();
			$('#orgCode3').hide();
			$('#orgCode4').hide();
		}else if(orgType == '3'){
			$('#orgCode1').hide();
			$('#orgCode2').hide();
			$('#orgCode3').show();
			$('#orgCode4').hide();
		}else if(orgType == '4'){
			$('#orgCode1').hide();
			$('#orgCode2').hide();
			$('#orgCode3').hide();
			$('#orgCode4').show();
		}
	}    
	return {
		load:load,
		search: search,
		changeOrgType:changeOrgType
	};
});



