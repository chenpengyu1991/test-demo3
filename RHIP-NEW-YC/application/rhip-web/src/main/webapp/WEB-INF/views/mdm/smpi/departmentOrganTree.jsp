<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript">
var organizationTree = (function() {
	$(function() {
		$("#filter_org_btn").click(function(){
			getOrgs();
		});
		//初始化树
		getOrgs();
	});
	
	function getOrgs() {
		var val=$("#filter_org_input").val();
		var getOrgUrl="/mdmOrganization/filterMDMOrg";
		$.loadHtmlByUrl({
			url : getOrgUrl,
			insertDiv :"org_treebox",
			param:{
				orgName:val
			},
			callback:initTree
		});
	}
	
	function initTree(){
		$("#mdmOrganizationTreeView").treeview({
			animated : "fast",
			collapsed : true,
			unique : true,
			persist : "location"
		});
		$("#mdmOrganizationTreeView").click(function(event) {
			var item = $(event.target);
			var selectId = item.attr("organCode");
			var selectName = item.attr("organName");
			//alert(selectId);
			if (selectId && selectName) {
				tree_click({selectId : selectId, selectName : selectName});
			}
		});
	}
	
	function tree_click(data) {
		var loadObj = {
				url : "/mdmDepartment/search",
				insertDiv : "departmentManager",
				param : {
					organCode : data.selectId
				}
			};
			$.urlPost(loadObj);
	}
	
	return {
		
	};
	
})();
</script>
<!-- 
<div>
	<table class="formtable">
		<tbody>
			<tr>
				<td><input type="text" id="filter_org_input"></td>
				<td><input type="button" class="btn" value="搜索"
					id="filter_org_btn" /></td>
			</tr>
		</tbody>
	</table>
</div>
 -->
<div id="sidemenuwrapper">
	<div id="org_treebox" class="sidemenu"></div>
</div>