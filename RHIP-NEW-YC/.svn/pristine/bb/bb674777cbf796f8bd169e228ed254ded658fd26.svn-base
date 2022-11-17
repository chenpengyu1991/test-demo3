<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<jsp:include page="../../layouts/load-js-css-resources.jsp"></jsp:include>

<style type='text/css'>
ul.ztree {margin-top: 10px;border: 1px solid #617775;background: #f0f6e4;width:500px;height:100%;overflow-y:scroll;overflow-x:auto;}
</style>
<script type="text/javascript">
var departmentManager = (function(){
	$(function() {
		var treeSetting = {
			data : {
				simpleData : {
					enable : true
				}
			},
			callback : {
				onClick : onClick
			}
		};
		$.getJsonByUrl({
			 url : contextPath+"/mdmOrganization/organationTree",
			 param : {
				organType : "A100,B100,B200,R2,R1,R11,C,D300"
			 },
			 wait:true,
			 callback:function(data) {
				 $.fn.zTree.init($("#treeParent"), treeSetting, data.objList);
			 }
		});
	});
	
	function beforeClick(treeId, treeNode, clickFlag) {
		className = (className === "dark" ? "":"dark");
		showLog("[ "+getTime()+" beforeClick ]&nbsp;&nbsp;" + treeNode.name );
		return (treeNode.click != false);
	}
	
	function onClick(event, treeId, treeNode, clickFlag) {
		var type = treeNode.type;
		var id = treeNode.id;
		if (type == '0' || id.charAt(0) == 'X') {
			$("#departmentSearchResult").html("无法查询科室");
			return;
		}
		var loadObj = {
			url : "/mdmDepartment/search",
			insertDiv : "departmentSearchResult",
			param : {
				organCode : id
			}
		};
		$.urlPost(loadObj);
	}
	
	return {
		
	};
})();
</script>
<div style="height: 450px;width: 850px;margin-top: 10px;">
	<div style="float:left;text-algin:left;width:350px;height:450px;">
		<ul id="treeParent" class="ztree" style="width:350px;"></ul>
	</div>
	<div style="float:right;width: 450px;">
		<div id="departmentSearchResult" />
	</div>
</div>