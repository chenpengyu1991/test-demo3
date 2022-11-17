<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript">
$(function() {
	$("#browser1").treeview({
		animated : "fast",
		collapsed : false,
		unique : true,
		persist : "location"
	});
	$(".sidemenu1 a").click(function(){
		$(".sidemenu1").find(".active").removeClass("active");
		$(this).parent().addClass("active");		
	});
});

function manager(url) {
	/*
	hiddenUrl = url;
	
	var loadObj = {
		url : url,
		insertDiv : "Main1"
	};
	$.urlPost(loadObj);
	*/
	
	layer.alert(url, {icon:0,title:'提示'});
	$("#Main1").empty();
	contentViews = new Array();
	pushMainContent(url);
}

var contentViews = new Array();

pushMainContent = function(url, param) {
	var contentIndex = contentViews.length;
	var viewObj = contentViews[contentIndex];
	var divId = "";
	if (viewObj && (viewObj.url == url)) {
		divId = viewObj.divId;
	} else {
		if (contentIndex > 0) {
			baseLayoutLoad.showHideDiv("mainCotent_" + (contentIndex - 1));
		}
		
		divId = "mainCotent_" + contentIndex;
		var newDiv = $("<div/>");
		newDiv.attr("id", divId);
		$("#Main1").append(newDiv);
		contentViews[contentIndex] = {url:url, divId:divId};
	}

	var loadObj = {
		url : url,
		insertDiv : divId,
		param : param
	};
	
	$.urlPost(loadObj);
};

popMainContent = function() {
	var viewObj = contentViews.pop();
	$("#" + viewObj.divId).remove();
	
	if (contentViews.length > 0) {
		baseLayoutLoad.showHideDiv("mainCotent_" + (contentViews.length-1));
	}
};
</script>
<div id="sidemenuwrapper1" >
<div id="sidemenuwrapper1" >
<div class="sidemenu1">
	<ul id="browser1" class="sidemenulist1  treeview-famfamfam">
		<li class="sidemenu01"><span class="sidemenu01">系统管理</span>
			<ul>
					<li class="sidemenu022">
						<span class="sidemenu022"  onclick="javascript:manager('${pageContext.request.contextPath}/organization/search');">
								机构管理
						</span>
					</li>
					<li class="sidemenu022">
						<span class="sidemenu022"  onclick="javascript:manager('${pageContext.request.contextPath}/user/search');">
								用户管理
						</span>
					</li>
					<li class="sidemenu022">
						<span class="sidemenu022"  onclick="javascript:manager('${pageContext.request.contextPath}/role/search');">
								角色列表
						</span>
					</li>
					<li class="sidemenu022">
						<span class="sidemenu022"  onclick="javascript:manager('${ctx}/mdmDictionary/search')">标准字典维护
						</span>
					</li>
					<li class="sidemenu022">
						<span class="sidemenu022"  onclick="javascript:manager('${ctx}/mdmDictionary/downloadSearch')">标准字典下载/导入
						</span>
					</li>
					<li class="sidemenu022">
						<span class="sidemenu022"  onclick="javascript:manager('${ctx}/mdmMedicine/manager')">标准药物维护
						</span>
					</li>
					<li class="sidemenu022">
						<span class="sidemenu022"  onclick="javascript:manager('${ctx}/mdmDisease/manager')">标准疾病维护
						</span>
					</li>
					<li class="sidemenu022">
						<span class="sidemenu022"  onclick="javascript:manager('${ctx}/person/personManage')">个人管理
						</span>
					</li>
					<li class="sidemenu022">
						<span class="sidemenu022"  onclick="javascript:manager('${ctx}/staff/staffManage')">人员管理
						</span>
					</li>
			</ul>
		</li>
	</ul>
</div>
</div>
<input type="hidden" id="menuUrlHid" value=""/>
<input type="hidden" id="preUrlHid" value=""/>
</div>