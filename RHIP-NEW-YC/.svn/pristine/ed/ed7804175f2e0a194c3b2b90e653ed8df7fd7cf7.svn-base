<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript">
$(function() {
	$("#browser").treeview({
		animated : "fast",
		collapsed : true,
		unique : true,
		persist : "location"
	});
	$(".sidemenu a").click(function(){
		$(".sidemenu").find(".active").removeClass("active");
		$(this).parent().addClass("active");		
	});
});

function searchABC(url)
{
	$.loadHtmlByUrl({
		url : url,
		insertDiv :"list_datagrid"
	});
}

</script>
<div id="sidemenuwrapper" >
<div class="sidemenu">
	<ul id="browser" class="sidemenulist  treeview-famfamfam">
		<c:forEach var="menuForm" items="${orgDtos}">
			<c:if test="${not empty menuForm.childOrganizationDtos}">
				<li class="sidemenu01"><span class="sidemenu01"  onclick="javascript:searchABC('${pageContext.request.contextPath}/region/${menuForm.organization.orgCode}');">${menuForm.organization.name}</span>
					<ul>
						<c:forEach var="childMenuForm" items="${menuForm.childOrganizationDtos}">
							<c:if test="${not empty childMenuForm.childOrganizationDtos }">
								<li class="sidemenu02">
									<span class="sidemenu02" onclick="javascript:searchABC('${pageContext.request.contextPath}/region/${childMenuForm.organization.orgCode}');">
										${childMenuForm.organization.name}
									</span>
									<ul>
									<c:forEach var="childChildMenuForm" items="${childMenuForm.childOrganizationDtos}">
										<li class="sidemenu03"><a href="javascript:void(0);" id="search" onclick="javascript:searchABC('${pageContext.request.contextPath}/region/${childChildMenuForm.organization.orgCode}');">
										${childChildMenuForm.organization.name}</a></li>
									</c:forEach>
									</ul>
								</li>
							</c:if>
							<c:if test="${empty childMenuForm.childOrganizationDtos}">
								<li class="sidemenu022">
									<span class="sidemenu022"  onclick="javascript:searchABC('${pageContext.request.contextPath}/region/${childMenuForm.organization.orgCode}');">
											${childMenuForm.organization.name}
									</span>
								</li>
							</c:if>
						</c:forEach>
					</ul>
				</li>
			</c:if>
			<c:if test="${empty menuForm.childOrganizationDtos}">
				<li>
					<span class="sidemenu01" onclick="javascript:searchABC('${pageContext.request.contextPath}/region/${childMenuForm.organization.orgCode}');">
						${menuForm.organization.name}
					</span>
				</li>
			</c:if>
		</c:forEach>
	</ul>
</div>
</div>
<input type="hidden" id="menuUrlHid" value=""/>
<input type="hidden" id="preUrlHid" value=""/>