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
		$("#browser").treeview({
			animated : "fast",
			collapsed : true,
			unique : true,
			persist : "location"
		});
		$("#browser").click(function(event) {
			var item = $(event.target);
			var selectId = item.attr("organCode");
			var selectName = item.attr("organName");
			if (selectId && selectName) {
				tree_click({selectId : selectId, selectName : selectName});
			}
		});
	}
	
	function tree_click(data) {
		//alert("data is:{selectId : "+data.selectId+", selectName : "+data.selectName+"}");
	}
	
	return {
		
	};
	
})();
</script>
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
<div id="sidemenuwrapper">
	<div id="org_treebox" class="sidemenu"></div>
</div>