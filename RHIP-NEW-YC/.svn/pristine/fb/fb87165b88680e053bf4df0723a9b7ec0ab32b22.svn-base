/**
 * 镇村关系标签  镇中心站标签相关的函数
 */
var orgUtil = (function(){

	/**
	 * 镇街道居委会下拉列表  点击镇控件响应的函数 获取相关联的街道
	 * @param radom
	 * @param isShowOneself
	 */
	function getStreetOpting(radom, patownShip, methodName, pastreet){
		var gbCode = $("select[idd='townId" + radom + "']").val();
		showTitle("townId" + radom); // 显示默认选中的值
		// kevin ro add
		if("childDeath" == pastreet) {
			$("#childDeathhrtownShi").val(""); 
			$("#childDeathpatownShip").val("");
			$("#childDeathhrtownShi").val($("select[idd='townId" + radom + "']").find("option:selected").text())
			$("#childDeathpatownShip").val(gbCode);
		}
		$.getJsonByUrl({
			url : contextPath + "/organization/json",
			param : {
				parentCode : gbCode,
				villageCode: patownShip
			},
			callback : function(data)
			{
				// 删除option
				removeOption('streetId', radom);
				$("select[idd='streetId" + radom + "']").append("<option value=\"\">请选择</option>" + data);
				$("select[idd='streetId" + radom + "']").show();
				showTitle("streetId" + radom); debugger;// 显示默认选中的值
				
				removeOption('villageId', radom);
				$("select[idd='villageId" + radom + "']").append("<option value=\"\">请选择</option>");
				$("select[idd='villageId" + radom + "']").show();
				showTitle("villageId" + radom);
				
				if(pastreet!="")//pastreet空时无需调用此方法
					getVillageOpting(radom, pastreet, methodName);
				if (gbCode == '')
				{
					removeOption('villageId', radom);
					$("select[idd='streetId" + radom + "']").hide();
					$("select[idd='villageId" + radom + "']").hide();
				}
			}
		});
	}

	function getTownOpting(radom,  isShowOneself, isAdministration, centerCode,stationCode){
		var gbCode = $("select[idd='townsId" + radom + "']").val();
		showTitle("townsId" + radom); // 显示默认选中的值
		$.getJsonByUrl({
			url : contextPath + "/organization/centre",
			param : {
				gbCode : gbCode,
				isAdministration : isAdministration
			},
			callback : function(data)
			{
				// 删除option
				debugger
				removeOption('centreId', radom);
				if (data != "empty")
				{
					$("select[idd='centreId" + radom + "']").append("<option value=\"\">请选择</option>" + data);
					$("select[idd='centreId" + radom + "']").show();
				} else
				{
					$("select[idd='centreId" + radom + "']").hide();
					$("select[idd='stationId" + radom + "']").hide();
				}
				if (centerCode!=""){
					$("select[idd='centreId" + radom + "']").val(centerCode);
				}
				showTitle("centreId" + radom); // 显示默认选中的值
				removeOption('stationId', radom);
				getOptingByStationCode(radom, isShowOneself,stationCode);
				if (gbCode == '')
				{
					removeOption('stationId', radom);
					$("select[idd='centreId" + radom + "']").hide();
					$("select[idd='stationId" + radom + "']").hide();
				}
			}
		});
	}

	/**
	 * 街道村级联表现 点击街道响应的函数
	 */
	function getVillageOpting(radom, pastreet, methodName)
	{
        var gbCode = $("select[idd='streetId" + radom + "']").val();
        showTitle("streetId" + radom);
		$.getJsonByUrl({
			url : contextPath + "/organization/json",
			checkRepeat : false,
			callback : function(data)
			{
				// 删除option
				var i = 0;
				while ($("select[idd='villageId" + radom + "'] option").length > 0 && i <= $("select[idd='villageId" + radom + "'] option").length)
				{
					$("select[idd='villageId" + radom + "'] option:last").remove();
					i = 0;
				}
				$("select[idd='villageId" + radom + "']").show();
				$("select[idd='villageId" + radom + "']").append("<option value=\"\">请选择</option>" + data);

				if(pastreet){
					$("select[idd='villageId" + radom + "']").val(pastreet);
				}else{
					$("select[idd='villageId" + radom + "']").val("");
				}

				if (!$.isEmpty(methodName))
				{
					var callback = eval(methodName);
					callback();
				}

				// 派发事件
				$("select[idd='villageId" + radom + "']").trigger("villageChange");
				$("select[idd='villageId" + radom + "']").trigger("blur");

				// 显示默认选中的值
				showTitle("villageId" + radom);
				// 给站添加事件 当期值变化时 显示title
				$("select[idd='villageId" + radom + "']").change(function()
				{
					showTitle("villageId" + radom);
				});
			
			},
			param : {
				parentCode : gbCode,
				villageCode: pastreet
			}
		});
	}

	/**
	 * 镇中心站下拉列表  点击镇控件响应的函数 获取相关联的中心
	 * @param radom
	 * @param isShowOneself
	 */
	function getCentreOpting(radom, isShowOneself, isAdministration){
		var gbCode = $("select[idd='townsId" + radom + "']").val();
		showTitle("townsId" + radom); // 显示默认选中的值
		$.getJsonByUrl({
			url : contextPath + "/organization/centre",
			param : {
				gbCode : gbCode,
				isAdministration : isAdministration
			},
			callback : function(data)
			{
				// 删除option
				removeOption('centreId', radom);
				if (data != "empty")
				{
					$("select[idd='centreId" + radom + "']").append("<option value=\"\">请选择</option>" + data);
					$("select[idd='centreId" + radom + "']").show();
				} else
				{
					$("select[idd='centreId" + radom + "']").hide();
					$("select[idd='stationId" + radom + "']").hide();
				}
				showTitle("centreId" + radom); // 显示默认选中的值
				removeOption('stationId', radom);
				getStationOptingTemp(radom, isShowOneself);
				if (gbCode == '')
				{
					removeOption('stationId', radom);
					$("select[idd='centreId" + radom + "']").hide();
					$("select[idd='stationId" + radom + "']").hide();
				}
			}
		});
	}

	/**
	 * 镇中心站下拉列表  点击中心控件响应的函数 获取相关联的站
	 * @param radom
	 * @param isShowOneself
	 */
	function getStationOpting(radom, isShowOneself)
	{
		// 目的是处理 不显示站级别的shu
		if (radom.indexOf('_') != -1)
		{
			showTitle("centreId" + radom.replace('_', ''));
			return;
		}
		showTitle("centreId" + radom);
		getStationOptingTemp(radom, isShowOneself);

	}

	function getStationOptingTemp(radom, isShowOneself) {
		var supOrganCode = $("select[idd='centreId" + radom + "']").val();
		if (supOrganCode == null || supOrganCode == '')
		{
			$("select[idd='stationId" + radom + "']").hide();
			//如果中心为空，站选择为空
			$("select[idd='stationId" + radom + "']").val([]);
			showTitle("stationId" + radom); // 显示默认选中的值
			return;
		}
		$.getJsonByUrl({
			url : contextPath + "/organization/station",
			callback : function(data)
			{
				// 删除option
				removeOption('stationId', radom);

				if (data != "empty")
				{
					$("select[idd='stationId" + radom + "']").append("<option value=\"\">请选择</option>" + data);
					showTitle("stationId" + radom); // 显示默认选中的值
					// 给站添加事件 当期值变化时 显示title
					$("select[idd='stationId" + radom + "']").change(function()
					{
						showTitle("stationId" + radom);
					});
					$("select[idd='stationId" + radom + "']").show();
				} else
				{
					$("select[idd='stationId" + radom + "']").hide();
				}
			},
			param : {
				supOrganCode : supOrganCode,
				isShowOneself : isShowOneself
			}
		});
	}

	function getOptingByStationCode(radom, isShowOneself,stationCode) {
		var supOrganCode = $("select[idd='centreId" + radom + "']").val();
		if (supOrganCode == null || supOrganCode == '')
		{
			$("select[idd='stationId" + radom + "']").hide();
			//如果中心为空，站选择为空
			$("select[idd='stationId" + radom + "']").val([]);
			showTitle("stationId" + radom); // 显示默认选中的值
			return;
		}
		$.getJsonByUrl({
			url : contextPath + "/organization/station",
			callback : function(data)
			{
				// 删除option
				debugger
				removeOption('stationId', radom);

				if (data != "empty")
				{
					$("select[idd='stationId" + radom + "']").append("<option value=\"\">请选择</option>" + data);
					$("select[idd='stationId" + radom + "']").show();
					if (stationCode!=""){
						$("select[idd='stationId" + radom + "']").val(stationCode);
					}
					showTitle("stationId" + radom); // 显示默认选中的值
				} else
				{
					$("select[idd='stationId" + radom + "']").hide();
				}

			},
			param : {
				supOrganCode : supOrganCode,
				isShowOneself : isShowOneself
			}
		});
	}

	/**
	 * 删除select中的option
	 * 
	 * @param name
	 * @param radom
	 */
	function removeOption(name, radom)
	{
		var i = 0;
		while ($("select[idd='" + name + radom + "'] option").length > 0 && i <= $("select[idd='" + name + radom + "'] option").length)
		{
			$("select[idd='" + name + radom + "'] option:last").remove();
			i = 0;
		}
	}

	//二级关联下拉 字典菜单
	function getCascadedOpting(idd, subIdd, methodName, code, url)
	{
		var parentCode = $("select[idd='" + idd + "']").val();
		showTitle(idd);
		$.getJsonByUrl({
			url : contextPath + "/organization/cascadedList",
			checkRepeat : false,
			callback : function(data)
			{
				// 删除option
				var i = 0;
				while ($("select[idd='" + subIdd + "'] option").length > 0 && i <= $("select[idd='" + subIdd + "'] option").length)
				{
					$("select[idd='" + subIdd + "'] option:last").remove();
					i = 0;
				}
				if (data != "empty")
				{
					$("select[idd='" + subIdd + "']").append(data);
				} else
				{
					$("select[idd='" + subIdd + "']").append("<option value=\"\">请选择</option>");
				}

				if (!$.isEmpty(methodName))
				{
					var callback = eval(methodName);
					callback();
				}

				// 派发事件
				$("select[idd='" + subIdd + "']").trigger("villageChange");

				// 显示默认选中的值
				showTitle(subIdd);
				// 给站添加事件 当期值变化时 显示title
				$("select[idd='" + subIdd + "']").change(function()
				{
					showTitle(subIdd);
				});
			},
			param : {
				parentCode : parentCode,
				code : code
			}
		});
	}

	/**
	 * 很据机构代码更新科室选择下拉框
	 * organCode : 机构代码
	 * deptId : 科室下拉框ID
	 */
	function getDeptOption(organCode, deptId)
	{
		var option = {
			url : "/mdmOrganization/getDeptList",
			param : {
				organCode : organCode
			},
			callback : (function(list) {
				var select = $("#" + deptId);
				select.empty();
				var html = '<option value="">请选择</option>';
				for (var i in list) {
					html += '<option value="' + list[i].deptCode+ '">' + list[i].deptName + '</option>';
				}
				$(select).append(html);
			})
		};
		$.getJsonByUrl(option);
	}
	return {
		getVillageOpting: getVillageOpting,
		getCentreOpting: getCentreOpting,
		getStationOpting: getStationOpting,
		getCascadedOpting: getCascadedOpting,
		getDeptOption: getDeptOption,
		getTownOpting:getTownOpting,
		getStreetOpting: getStreetOpting
	}
})();
