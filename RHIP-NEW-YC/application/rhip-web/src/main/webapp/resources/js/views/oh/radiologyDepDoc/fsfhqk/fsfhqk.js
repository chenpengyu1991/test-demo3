var fsfhqk = (function() {
	var operationType = $("#operationType").val();
	var hospitalId = $("#id").val();
	
	$(function(){
		performMachineRoomRecords(1);
		performCautionAlarmRecords(1);
		if(operationType=='1'){
			$("#fskjfxxAdd").hide();
			$("#fskwzbzqkModify").hide();
			$("#qtfhcsAdd").hide();
		}
			
	});
	
	//加载放射科情况列表
	function performMachineRoomRecords(indexPage){
		var option = {
				url : "/oh/radiologicalProtectionReport/radiologicalProtection/machineRoom",
				insertDiv : "machineRoomList",
				param : {
					hospitalId : hospitalId,
					indexPage : indexPage
				}
		};
		$.loadHtmlByUrl(option);
	}
	//加载其他防护措施列表
	function performCautionAlarmRecords(indexPage){
		var option = {
				url : "/oh/radiologicalProtectionReport/radiologicalProtection/cautionAlarm",
				insertDiv : "cautionAlarmList",
				param : {
					hospitalId : hospitalId,
					indexPage : indexPage
				}
		};
		$.loadHtmlByUrl(option);
	}
	
	//添加放射设备情况
	function addMachineRoomRecord(){
		$.post(contextPath+"/oh/radiologicalProtectionReport/radiologicalProtection/machineRoom/edit",
			function(ret){
				layui.use(['layer'], function() {
					var layer = layui.layer
					layer.open({
						type: 1,
						id:'fskqkEdit',
						area: ['600px', '520px'],
						title:"放射科情况",
						content: ret
					});
				});
			});
	}
	
	//逻辑删除放射设备情况
	function deleteMachineRoomRecord(id){
		layui.use('layer', function() {
			var layer = layui.layer;
			var index = layer.confirm('确认删除?', {icon:2, title:'确认提示'}, function(){
				$.getJsonByUrl({
					url : "/oh/radiologicalProtectionReport/radiologicalProtection/machineRoom/delete",
					callback:function(data){
						if (data == '1'){
							layer.alert("删除成功！", {icon:0,title:'提示'}, function() {
								editRecord.fsfhqk();
								layer.closeAll();
							});
						} else{
							layer.alert("删除失败！", {icon:0,title:'提示'});
							layer.closeAll();
							return;
						}
					},
					param:{
						id:id
					}
				});
			});
		});
	}
	
	//更新放射设备情况
	function updateMachineRoomRecord(id){
		$.post(contextPath+"/oh/radiologicalProtectionReport/radiologicalProtection/machineRoom/edit",
			{
				ohMachineRoomId : id,
				ohMachineRoomOperationType : '2'
			},
			function(ret){
				layui.use(['layer'], function() {
					var layer = layui.layer
					layer.open({
						type: 1,
						id:'fskqkEdit',
						area: ['600px', '520px'],
						title:"修改医院放射设备情况",
						content: ret
					});
				});
			});
	}
	
	
	//添加其他防护措施
	function addCautionAlarmRecord(){
		$.post(contextPath+"/oh/radiologicalProtectionReport/radiologicalProtection/cautionAlarm/edit",
			function(ret){
				layui.use(['layer'], function() {
					var layer = layui.layer
					layer.open({
						type: 1,
						id:'qtfhcsEdit',
						area: ['450px', '290px'],
						title:"其他防护措施",
						content: ret
					});
				});
			});
	}
	
	//逻辑删除其他防护措施
	function deleteCautionAlarmRecord(id){
		layui.use('layer', function() {
			var layer = layui.layer;
			var index = layer.confirm('确认删除?', {icon:2, title:'确认提示'}, function(){
				$.getJsonByUrl({
					url : "/oh/radiologicalProtectionReport/radiologicalProtection/cautionAlarm/delete",
					callback:function(data){
						if (data == '1'){
							layer.alert("删除成功！", {icon:0,title:'提示'}, function() {
								editRecord.fsfhqk();
								layer.closeAll();
							});
						} else{
							layer.alert("删除失败！", {icon:0,title:'提示'});
							layer.closeAll();
							return;
						}
					},
					param:{
						id:id
					}
				});
			});
		});
	}
	
	//更新其他防护措施
	function updateCautionAlarmRecord(id){
		$.post(contextPath+"/oh/radiologicalProtectionReport/radiologicalProtection/cautionAlarm/edit",
			{
				ohCautionAlarmId : id,
				ohCautionAlarmOperationType : '2'
			},
			function(ret){
				layui.use(['layer'], function() {
					var layer = layui.layer
					layer.open({
						type: 1,
						id:'qtfhcsEdit',
						area: ['450px', '290px'],
						title:"其他防护措施",
						content: ret
					});
				});
			});
	}
	
	function editRadiologicalPostion(id){
		$.post(contextPath+"/oh/radiologicalProtectionReport/radiologicalProtection/radiologicalPostion/edit",
			{
				id : id
			},
			function(ret){
				layui.use(['layer'], function() {
					var layer = layui.layer
					layer.open({
						type: 1,
						id:'fskwzbzqkEdit',
						area: ['600px', '360px'],
						title:"放射科位置布置情况",
						content: ret
					});
				});
			});
	}
	
	return {
		addMachineRoomRecord:addMachineRoomRecord,
		deleteMachineRoomRecord:deleteMachineRoomRecord,
		updateMachineRoomRecord:updateMachineRoomRecord,
		editRadiologicalPostion:editRadiologicalPostion,
		addCautionAlarmRecord:addCautionAlarmRecord,
		deleteCautionAlarmRecord:deleteCautionAlarmRecord,
		updateCautionAlarmRecord:updateCautionAlarmRecord,
		searchMachineRoom:performMachineRoomRecords,
		searchCautionAlarm:performCautionAlarmRecords
	};
})();
