define(function() {
	var validate=null;
	function load() {
		$(function () {
			init();
		});
	}
			function init() {
				//机构下拉树设置
				var option={
					url:"/mdmOrganization/organationTree",
					unSelecteType:['0']  //不能选择：0是镇，B1是中心
				};
				//机构自动检索设置
				var opb = {
					url:"/mdmOrganization/organationSelect",
					feild: {
						value: "organCode",
						lable: "organName"
					},
					param:{organType:"A100,B100,B200"}  //只查询B1（即所有站）
				};

				var hospitalCode=$("#orgCodeForAdd");
				if(hospitalCode.length>0){
					//初始化自动检索
					hospitalCode.selectBox(opb);
					//初始化下拉树
					hospitalCode.initTreeSelect(option);
				}
			}



			return {
				load : load
			};
});

