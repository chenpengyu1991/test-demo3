/**
 * Created with JetBrains WebStorm.
 * User: liuk
 * Date: 13-7-30
 * Time: 下午5:10
 * To change this template use File | Settings | File Templates.
 */
var hsaSodpMain = (function ()
{
	$(function ()
	{
		addEvent();
	});

	function addEvent()
	{
		$("#sodp-add-btn").on("click", addPerson)
		$("#hsa-sodp-add-list-table").on("click", ".edit-link", sodpEdit);
		$("#hsa-sodp-add-list-table").on("click", ".delete-link", sodpDelete);
	}

	function addPerson()
	{
		editPerson(null);
	}

	function editPerson(data)
	{
		var param = {};
		if (data){
			param = data;
		}
		var dialogObj = {
			url: "/hsa/inspRecord/sodp/add",
			title: "添加可疑职业病人",
			id: "hsa-sodp-add-from-dialog",
			param: param
		};
		$.dialog(dialogObj);
	}

	function addCallback(data)
	{
		if (data){
			buildTr(data);
		}
	}

	function saveCallback(data)
	{
		if(data){
			buildUpdateTr(data);
		}
	}

	var proArr = ["name", "age", "gender", "idcard", "workUnit", "occupation", "susOccDiseaseName", "unitPhoneNumber", "phoneNumber", "recipientUnit", "recipientName", "recipientPhone","id"];
	
	var sopdIndex = $("#susOccDiseaseDatagrid tr").length;
	
	function buildTr(data)
	{
		var tr = "<tr id = '"+sopdIndex+"'>";
		var i = 0;
		var size = proArr.length;
		for (; i < size; i++) {
			var key = proArr[i];
			var value = data[key];
			var label=data[key+"__label"];
			if(!label){
				label=value;
			}
			if(key =="id"){
				tr += "<td class='hide' title='"+label+"' dataValue='" + value + "' dataName='" + key + "'>" + label + "</td>";
			}else{
				tr += "<td title='"+label+"' dataValue='" + value+"" + "' dataName='" + key + "'>" + label + "</td>";
			} 	
		}
		tr += "<td title='修改 删除'><a href='javascript:void(0)' class='edit-link' >修改 </a><a href='javascript:void(0)' class='delete-link' > 删除</a></td>";
		tr += "</tr>";
		$("#hsa-sodp-add-list-table").find("tbody").append($(tr));
		sopdIndex++;
	}
	function buildUpdateTr(data){
		var updateId = $("#updateId").val();
		$("#"+updateId).empty();
		var tr = "";
		var i = 0;
		var size = proArr.length;
		for (; i < size; i++) {
			var key = proArr[i];
			var value = data[key];
			var label=data[key+"__label"];
			if(!label){
				label=value;
			}
			if(key =="id"){
				tr += "<td class='hide' title='"+label+"' dataValue='" + value + "' dataName='" + key + "'>" + label + "</td>";
			}else{
				tr += "<td title='"+label+"' dataValue='" + value+ "' dataName='" + key + "'>" + label + "</td>";
			} 	
		}
		tr += "<td title='修改 删除'><a href='javascript:void(0)' class='edit-link' >修改 </a><a href='javascript:void(0)' class='delete-link' > 删除</a></td>";
		$("#"+updateId).append(tr);
	}
	function sodpDelete()
	{
		var $this = $(this);
		var index = layer.confirm("是否删除", {icon:2, title:'确认提示'}, function ()
		{
			$this.parent("td").parent("tr").remove();
			layer.close(index);
		});
	}

	function sodpEdit()
	{
		var $tr = $(this).parent("td").parent("tr");
		var data = trToData($tr);
		editPerson(data);
		var id = $tr.attr("id");
		$("#updateId").val(id);
	}

	function trToData($tr)
	{
		var data = {};
		if ($tr.length > 0){
			var tds = $tr.children("td");
			var tdSize = tds.length;
			var i = 0, name, $td;
			for (; i < tdSize; i++) {
				$td = $(tds[i]);
				name = $td.attr("dataName");
				data[name] = $td.attr("dataValue");
			}
		}
		return data;
	}
	return {
		addCallback: addCallback,
		saveCallback: saveCallback
	};

})();
