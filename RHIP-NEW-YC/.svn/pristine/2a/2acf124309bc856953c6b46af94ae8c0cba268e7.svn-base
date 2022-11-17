var ceSearch = (function() {
	$(function() {
		$("#searchForm").onEnter(search, 1);
		$("#searchBtn").click(function() {
			search(1);
		});
		search(1);
        $("#addBtn").click(function(){
        	add();
        });
	});

	function search(pageIndex) {
        $("#detailDiv").hide();
		if (pageIndex == null) {
            pageIndex = $("#pageIndex").val();
		}
		var searchOption = {
			url : "/ce/list",
			insertDiv : "listDiv",
			param : {
                pageIndex : pageIndex
			},
            callback : function(data) {
                $("#top_all").show();
                $("#pageIndex").val(pageIndex);
            }
		};
		$("#searchForm").submitFormLoadHtml(searchOption);
	}

    function edit(staffCode){
        $("#top_all").hide();
        var pageIndex = $("#currentPage").val();
        $.loadHtmlByUrl({
            url : "/ce/edit",
            insertDiv :"detailDiv",
            param : {"staffCode":staffCode}
        });
        $("#detailDiv").show();
    };
    
    function add(id) {
    	$("#top_all").hide();
        var pageIndex = $("#currentPage").val();
        $.loadHtmlByUrl({
            url : "/ce/add",
            insertDiv :"detailDiv",
            param : {id:id}
        });
        $("#detailDiv").show();
	}
    
    function updateStaff() {
		var validate = $("#staff_form").easyValidate();
		var result = validate.validateForm();
        if (!result) {
            return;
        }
		$("#staff_form").submitFormGetJson({
			url:"/ce/updateStaff",
			callback:function(data){
				layer.alert("保存成功！", {icon:0,title:'提示'});
				back();
			}
		});
	}
    
	function del(id) {
		var index = layer.confirm("是否删除该记录？", {icon:2, title:'确认提示'}, function() {
			var option = {
					url : "/ce/delete",
					param : {
						id : id
					},
					callback : (function(result) {
						layui.use('layer', function() {
							var layer = layui.layer;
							layer.alert(result.message, {icon:0,title:'提示'});
						});
						if (result.success) {
							search();
						}
					})
				};
				$.getJsonByUrl(option);

			layer.close(index);
		});
	}

	function view(id) {
        $("#top_all").hide();
        var pageIndex = $("#currentPage").val();
        $.loadHtmlByUrl({
            url : "/ce/view",
            insertDiv :"detailDiv",
            param : {id:id}
        });
        $("#detailDiv").show();
	}
	
	function viewByStaff(staffCode){
        $("#top_all").hide();
        var pageIndex = $("#currentPage").val();
        $.loadHtmlByUrl({
            url : "/ce/viewByStaff",
            insertDiv :"detailDiv",
            param : {"staffCode":staffCode}
        });
        $("#detailDiv").show();
    };
	
	function removeProject(){
		$.removeDialog ('projectDialog');
	}
	
	function popupStaff(){
        var staffDialog = {
            url : "/ce/staffSearch",
            height : 600,
            width : 700,
            title : "人员选择",
            id :"staffDialog"
        };
        $.dialog(staffDialog);
    }
	
	function selectStaff(staffCode,name,idCard,technicalName,smpiId){
		$.removeDialog("staffDialog");
		$("#staffCode").val(staffCode);
		$("#smpiId").val(smpiId);

		$("#name").val(name);
		$("#idCard").val(idCard);
		$("#technicalName").val(technicalName);
		$.post(
				contextPath+'/ce/getProject',
				{'staffCode':staffCode},
			      function (data) 
			      {
			          if(data == null || data=='') return;
					  clearProjectTable();
					  var arr = eval(data);  
					  for(var i=0;i<arr.length;i++){
						  appendProjectRow(arr[i]);
					  }
			      }
			);
	}
	
	function saveContinueEducation(continueEducation){
		var validate = $("#continueEducation_form").easyValidate();
		var result = validate.validateForm();
        if (!result) {
            return;
        }
		$("#continueEducation_form").submitFormGetJson({
			url:"/ce/saveEducation",
			callback:function(data){
				if(data == null) return;
				clearProjectTable();
				var creditA = 0;
				var creditB = 0;
				var period = 0;
				for(var i=0;i<data.length;i++){
					creditA += Number(data[i].creditA);
					creditB += Number(data[i].creditB);
					period += Number(data[i].period);
					appendProjectRow(data[i]);
				};
		        clearForm($("#continueEducation_form"));
		        $("#creditA_all").val(creditA);
		        $("#creditB_all").val(creditB);
		        $("#period_all").val(period);
                $.removeDialog("projectDialog");
			}
		});
	}
	
	function popupProject(id,type){
		if(type=="add"){
			if(!id){
				layer.alert("增加项目必须选择人员！", {icon:0,title:'提示'});
				return;
			}
			var projectDialog = {
		            url : "/ce/addProject",
		            height : 220,
		            width : 500,
		            title : "新增项目",
		            id :"projectDialog",
		            param : {"staffCode":id}
		        };
		}
		else{
			var projectDialog = {
		            url : "/ce/editProject",
		            height : 220,
		            width : 500,
		            title : "编辑项目",
		            id :"projectDialog",
		            param : {"id":id}
		        };
		}
		$.dialog(projectDialog);
	}
	
	function clearProjectTable(){
		var table = document.getElementById("projectTable");
	    var tableLength = table.rows.length;
	    for(var int = 1;int < tableLength;int++) {
	        table.deleteRow(1);
	    }
	}
	
	function appendProjectRow(continueEducation){
	       var html = generateTrHtml(
	    		   ['recordYear',
	    		    'projectNo', 
                    'projectName',
                    'organizer',
                    'period',
                    'creditA',
                    'creditB'],['id','staffCode'],
                   [continueEducation.recordYear,
                    continueEducation.projectNo,
    		        continueEducation.projectName,
    		        continueEducation.organizer,
    		        continueEducation.period,
    		        continueEducation.creditA,
    		        continueEducation.creditB],[continueEducation.id,continueEducation.staffCode]);
	        $("#projectTable").append(html);
	    }
	
	function clearForm(form) {
		  $(':input', form).each(function() {
		    var type = this.type;
		    var tag = this.tagName.toLowerCase();
		    if (type == 'text' || type == 'password' || tag == 'textarea')
		      this.value = "";
		    else if (type == 'checkbox' || type == 'radio')
		      this.checked = false;
		    else if (tag == 'select')
		      this.selectedIndex = -1;
		  });
		};

    function generateTrHtml(showFields, hideFields, showValues, hideValues){
        var html = '<tr>';
        for(var i=0; i<showFields.length; i++){
            html += '<td field="' + showFields[i] + '" title="'+showValues[i]+'">'+showValues[i] +'</td>';
        }
        for(var i=0; i<hideFields.length; i++){
            html += '<td field="' + hideFields[i] + '" style="display: none">' + hideValues[i] + '</td>';
        }
        html += '<td class="btnsublist" field="btn">' +
        	'<a href="javascript:void(0)" onclick="ceSearch.popupProject('+hideValues[0]+')">修改</a>&nbsp;' +
            '<a href="javascript:void(0)" onclick="ceSearch.removeTr(this,'+hideValues[0]+','+"'"+hideValues[1]+"'"+')">删除</a>' +
            '</td>';
        html += '</tr>';
        return html;
    }
    
	function back() {
		disableChangeConfirm();
		search(1);
	}
	
	function removeTr(rmBtn,id,staffCode){
		var index = layer.confirm("你确定要删除此条数据吗？", {icon:2, title:'确认提示'}, function() {
			$.post(contextPath+'/ce/delProject',
				      {'id':id,"staffCode":staffCode},
				      function (data) 
				      {
			    		  var extendDiv = rmBtn.parentNode.parentNode;
			    	      $(extendDiv).remove();
			    	      if(data == null) return;
			    	      var creditA=0;
			    	      var creditB=0;
			    	      var period=0;
			    	      for(var i=0;i<data.length;i++){
								creditA += Number(data[i].creditA);
								creditB += Number(data[i].creditB);
								period += Number(data[i].period);
							};
					        $("#creditA_all").val(creditA);
					        $("#creditB_all").val(creditB);
					        $("#period_all").val(period);
				      },'json');

			layer.close(index);
		});
    }

	return {
		search : search,
        edit : edit,
		del : del,
		updateStaff : updateStaff,
        view : view,
        back : back,
        popupProject : popupProject,
        removeProject : removeProject,
        selectStaff : selectStaff,
        popupStaff : popupStaff,
        saveContinueEducation : saveContinueEducation,
        removeTr : removeTr,
        viewByStaff: viewByStaff
	}
})();