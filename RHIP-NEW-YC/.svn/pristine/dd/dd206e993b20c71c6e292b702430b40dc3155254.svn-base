var drugDCSearch = (function() {
    $(function() {
        addDrugAutoComplete();
    	$("#searchForm").onEnter(search, 1);
        $("#btnSearch").click(function(e) {
        	e.preventDefault();
           search(1);
        });
        $("#initAdd").click(function(e) {
        	e.preventDefault();
            initEdit('add');
        });
        search(1);
    });

    function addDrugAutoComplete(){
        $.getJsonByUrl({
            url: "/dcConfig/drug/list",
            param : {inputValue:"C"},
            callback : function(data)
            {
                var drug = $("#queryCode");
                if (drug.length > 0){
                    drug.autocomplete(data, {
                        minChars: 0,
                        width:250,
                        max: 100,
                        autoFill: false,
                        matchContains: true,
                        formatItem: function(row, i, max) {
                            return  row.drugName;
                        },
                        formatMatch: function(row, i, max) {
                            return row.drugName;
                        },
                        formatResult: function(row) {
                            return row.drugName;
                        }
                    }).result(function(event, data, formatted){
                        $("input[name='queryCode']").val(data.drugName);
                        $("input[name='coopInsuranceCd']").val(data.coopInsuranceCd);
                        $("input[name='pubmediCd']").val(data.pubmediCd);
                    });
                }
            }
        });
    }

    function search(pageIndex) {
        var drugName = $("#queryCode").val();
        if(isEmpty(drugName)){
            $("#coopInsuranceCd").val("");
            $("#pubmediCd").val("");
        }
        $("#messageDiv").remove();
        $("#top_all").show();
        $("#detailDiv").hide();
        pageIndex = (isEmpty(pageIndex)?1:pageIndex);
        var personal = $("#personal").val();
        var searchObj = {
            url : '/dcConfig/check/drug/list',
            insertDiv : "resultDiv",
            param : {
                pageIndex : pageIndex,
                personal : personal
            },
            callback : function(data) {
            	$("#pageIndex").val(pageIndex);
            }
        };
        $("#searchForm").submitFormLoadHtml(searchObj);
    };



    function initEdit(type, id) {
        var title = '';
        if("add" == type){
            title = '添加用药设置';
        }else if("edit" == type){
            title = '修改用药设置';
        }
        
        $.post(contextPath+'/dcConfig/check/drug/add', {
        	type:type,
        	id:id
    	},
    	function(ret) {
    	  layer.open({
    		  type: 1,
    		  id:'dcConfigDialog',
    		  area: ['450px', '220px'],
    		  title:title,
    		  content: ret
    	  });
    	});
    }

	function toggle(obj, tableId) {
		$(obj).toggleClass("ico-top");
		$(obj).toggleClass("ico-bottom");
		$("#" + tableId).toggle();
	}
	
	return {
		search:search,
        initEdit:initEdit,
        toggle:toggle
	};
})();



