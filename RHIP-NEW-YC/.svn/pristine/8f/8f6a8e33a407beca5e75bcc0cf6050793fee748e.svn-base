var mhmCommon = (function() {

    function toggle(obj,tableId) {
        $(obj).toggleClass("ico-top");
        $(obj).toggleClass("ico-bottom");
        $("#" + tableId).toggle();
    };

    function returnSearch(methodName){
        var searchTemp = eval(methodName);
        /*if(contentChanged){
            msgUtil.backConfirm(function(){
                searchTemp();
            });
        }else{
            searchTemp();
        }*/
        
        // if(contentChanged) {
            layui.use('layer', function(){
            	var layer = layui.layer;
            	layer.confirm('确认离开？', {icon:1, title:'确认提示'}, function(){
            		layer.closeAll();
            		searchTemp();
            	});
            });
        // }else{
        //     searchTemp();
        // }
    }

    function removeTr(rmBtn){
      /*  msgUtil.confirm("你确定要删除此条数据吗？",function(){
            var extendDiv = rmBtn.parentNode.parentNode;
            $(extendDiv).remove();
        });*/
        
        layui.use('layer', function(){
        	var layer = layui.layer;
        	layer.confirm("你确定要删除此条数据吗？", {icon:2, title:'确认提示'}, function(index){
        		var extendDiv = rmBtn.parentNode.parentNode;
                $(extendDiv).remove();
                layer.close(index);
        	});
        });
    }

    function closePopUp(dialogId){
        $.removeDialog (dialogId);
    }
    
    function closeLayUiDialog() {
    	layui.use('layer', function(){
			var layer = layui.layer;
			layer.closeAll();
		});
    }
    
    /*隐藏、显示地址*/
    function toggerAddress(){

    }

    /**
    *
    * @param singleId 页面子表为1对1时的tableId
    * @param tableIds 页面子表为1对多时的tableId
    * @param flags  子表的flag
    * @param idmId
    * @returns {Array}
    */
   function getTablesData(singleId, tableIds, flags, idmId){
       var tableData = [];
       tableData = getArrayDataForTable(singleId, tableData, 0, idmId);
       for(var i=0; i<tableIds.length; i++ ){
           tableData = getArrayDataForTable(tableIds[i], tableData,flags[i], idmId);
       }
       return tableData;
   }

   function getArrayDataForTable(tableId, tableData,flag, idmId){
       $("#"+tableId+" tr").each(function(trindex,tritem){
           if(trindex > 0){
               var trData = {};
               $(tritem).find("td").each(function(tdindex,tditem){
//                   trData['idmId'] = idmId;
                   var inputValue = $(tditem).text();
                   inputValue = inputValue.replace(/\t/g,'');//制表符替换
                   inputValue = inputValue.replace(/\n/g,'');//换行替换     
                   if('' != inputValue && "undefined" !=inputValue && undefined !=inputValue ){
                       trData[$(this).attr("field")] = inputValue;
                   }
                   trData['flag'] = flag;
               });
               tableData.push(trData);
           }
       });
       return tableData;
   }

   /**
    *
    * @param showFields 显示的字段
    * @param hideFields 隐藏的字段
    * @param showValues 显示字段的值
    * @param hideValues 隐藏字段的值
    * @param editMethod 修改的方法
    * @returns {string} 新增的一条子表记录的html
    */

   function generateTrHtml(showFields, hideFields, showValues, hideValues, editMethod){
       var html = '<tr>';
       for(var i=0; i<showFields.length; i++){
           html += '<td field="' + showFields[i] + '" title="'+showValues[i]+'">'+showValues[i] +'</td>';
       }
       for(var i=0; i<hideFields.length; i++){
           html += '<td field="' + hideFields[i] + '" style="display: none">' + hideValues[i] + '</td>';
       }
       html += '<td class="btnsublist">' +
			'<a class="layui-btn layui-btn-xs" href="#" onclick=' + '\"'+ editMethod + '\"' + ' title="修改" style="color: #FFF;font-size: 12px;"><i class="layui-icon">&#xe642;</i>修改</a>&nbsp;' +
			'<a class="layui-btn layui-btn-danger layui-btn-xs" href="#"   onclick="mhmCommon.removeTr(this)" title="删除" style="color: #FFF;font-size: 12px;"><i class="layui-icon">&#xe640;</i>删除</a>' +
           '</td>';
       html += '</tr>';
       return html;
   }

   /**
    *
    * @param tableId 弹出子表的tableId
    * @returns {{}}
    */
   function getPopObj(tableId){
       var popObj = {};
       $("#" + tableId).find("input").each(function(index, obj) {
           if (obj.type == "text" || obj.type == "hidden") {
               var inputValue = $(this).val();
               popObj[$(this).attr("name")] = inputValue;
           }
           if(obj.type == "radio"){
               if($(this).is(":checked")){
                   popObj[$(this).attr("name")] = $(this).val();
               }
           }
       });
       return popObj;
   }
	function queryPerson(validate,idCard) {
        if (validate.validate("idcard")){
            $.getJsonByUrl({
                url : "/idm/report/queryPerson",
                wait : true,
                callback : function(data) {
                    if(!$.isEmpty(data)){
                        if(data.flag){
                            setPersonData(data);
                            setAge(data.Idcard);
                        }else{
                            setIcData(data.Idcard);
                            setAge(data.Idcard);
                        }
                    }
                },
                param:{idCard:idCard}
            });
        }
	};
	function setPersonData(data){
		$('#idCard').val(data.Idcard);
		$('#name').val(data.Name);
		
		var gender;
		if($.isEmpty(data.Gender)){
			gender = IC.getGender(data.Idcard);
		}else{
			gender = data.Gender;
		}
		$('input[type=radio][name=gender][value=' + gender + ']').attr("checked",true);
	};
	/*如果获取患者信息失败，根据身份证号码获取性别、出生日期*/
	function setIcData(idCard){
		var gender = IC.getGender(idCard);
		if(!$.isEmpty(gender)){
			$('#gender').val(gender);
		}
	}
	/*解析日期字符串*/
	function parseDate(str){
		
		if(str.match(/^\d{4}[\/\/\s+]\d{1,2}[\/\/\s+]\d{1,2}$/)){
			return new Date(str.replace(/[\-\/\s+]/i,'/'));
		}else if(str.match(/^\d{8}$/)){
			return new Date(str.substring(0,4)+'/'+str.substring(4,6)+'/'+str.substring(6));
		}else{
			layer.alert('date parse error', {icon:0,title:'提示'});
		}
	}
	/*根据出生日期获取年龄*/
	function getAge(strDate){
    	if($.isEmpty($.trim(strDate))){
    		return;
    	}		
		var age;
		var aDate=new Date();
		var thisYear=aDate.getFullYear();
		var thisMonth=aDate.getMonth()+1;
		var thisDay=aDate.getDate();
		var brith=parseDate(strDate);
		brithy=brith.getFullYear();
		brithm=brith.getMonth()+1;
		brithd=brith.getDate();
		if(thisYear-brithy<0){
			layer.alert("输入错误！", {icon:0,title:'提示'});
		    age="";
		}else{
			if(thisMonth-brithm<0){
				age = thisYear-brithy-1;
		    }
			else{
		         if(thisDay-brithd>=0){
		        	 age = thisYear-brithy;
		         }
		         else{
		        	 age = thisYear-brithy-1;
		         }
		    }
		}
		return age;
	}	
    function setAge(idNo){
        var idCardBirthDay = IC.getBirthday(idNo);
        var age = getAge(idCardBirthDay);
        $("#age").val(age);
    }	
    /*
     * 新增或者编辑时更改按钮显示状态
     * */
    function changeBtnStatus(type){
    	if(type=='add'){
    		$("#add").hide();
            $("#update").hide();
            $("#delete").hide();
            $("#pass").hide();
            $("#reject").hide();
            $("#save").show();
    	}else{
    		var followupStatus = $('#followupStatus').val();
    		$("#add").show();
            $("#update").show();
            $("#delete").show();
            if(followupStatus == '0'){//未审核时，显示审核按钮
	            $("#pass").show();
	            $("#reject").show();            	
            }else{
	            $("#pass").hide();
	            $("#reject").hide();             	
            }
            $("#save").hide();
    	}
    }   

    /**
	 * 初始化药品选择下拉框，按药品名称查询
	 * selectId:autoSelect的ID
	 * selectFun:回调函数
     */
	function initDrugSelectBox(selectId,selectFun,isFree){
		var method = eval(selectFun);
		var opDrugSelectBox = {
			url:"/mhm/drug/drugTree",
			feild : {
				value : "id",
				lable : "drugName"
			},
			param:{isFree:isFree},
			selectFun:function(data){
				method(data);
			}
		};
		var drugSelectBox=$("#" + selectId);
		if(drugSelectBox.length > 0){
			drugSelectBox.selectBox(opDrugSelectBox);	
		}
	}

    function displayPaAddress() {
        $("select[name='mhmBasicsInfo.pastreet']").on("change villageChange", function()
        {
            var prefix = $("select[name='mhmBasicsInfo.patownShip']").find("option[value!='']:selected").text();
            prefix += $(this).find("option[value!='']:selected").text();
            $("#tempPaValue").text(prefix);
        });
    }

    function displayHrAddress() {
        $("select[name='mhmBasicsInfo.hrstreet']").on("change villageChange", function()
        {
            var prefix = $("select[name='mhmBasicsInfo.hrtownShip']").find("option[value!='']:selected").text();
            prefix += $(this).find("option[value!='']:selected").text();
            $("#tempHrValue").text(prefix);
        });
    }

    function addIcd10AutoComplete(id){
        $.getJsonByUrl({
            url: "/mhm/management/complete/mhmDisease",
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
//                        mustMatch: true,
                        formatItem: function(row, i, max) {
                            return  row.diseaseName + "[" + row.icd10main + "]";
                        },
                        formatMatch: function(row, i, max) {
                            return row.diseaseName + " " + row.icd10main;
                        },
                        formatResult: function(row) {
                            return row.diseaseName + "[" + row.icd10main + "]";
                        }
                    });
                }
            }
        });
    }

	return {
        toggle:toggle,
        returnSearch:returnSearch,
        toggerAddress:toggerAddress,
        getTablesData:getTablesData,
		removeTr:removeTr,
		closePopUp:closePopUp,
        generateTrHtml:generateTrHtml,
        getPopObj:getPopObj,
        queryPerson:queryPerson,
        getAge:getAge,
        changeBtnStatus:changeBtnStatus,
        initDrugSelectBox:initDrugSelectBox,
        displayPaAddress:displayPaAddress,
        displayHrAddress:displayHrAddress,
        addIcd10AutoComplete:addIcd10AutoComplete,
        closeLayUiDialog:closeLayUiDialog
	};
})();



