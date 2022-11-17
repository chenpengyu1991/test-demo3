<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript">
/* $(function() {
	$(".sidemenu a").click(function(){
		$(".sidemenu").find(".active").removeClass("active");
		$(this).parent().addClass("active");		
	});
}); */
</script>
<div id="sidemenuwrapper">
<div class="sidebartop"></div>
<div class="sidemenu">
	<ul id="browser" class="sidemenulist treeview-famfamfam">
		<c:forEach var="menuForm" items="${menus}">
			<c:if test="${not empty menuForm.childMenuForms}">
				<li class="sidemenu01"><span class="sidemenu01">${menuForm.menu.nameZh}</span>
					<ul style="display: none;">
						<c:forEach var="childMenuForm" items="${ menuForm.childMenuForms}">
							<c:if test="${not empty childMenuForm.childMenuForms }">
								<li class="sidemenu02"><span class="sidemenu02">${childMenuForm.menu.nameZh}</span>
									<ul>
									<c:forEach var="childChildMenuForm" items="${childMenuForm.childMenuForms}">
										<li class="sidemenu03"><a href="javascript:void(0);" onclick="javascript:baseLayoutLoad.loadMenuContent('${pageContext.request.contextPath}${childChildMenuForm.menu.path}');" <c:if test="${childChildMenuForm.menu.nameZh.length()>12}"> title="${childChildMenuForm.menu.nameZh}"</c:if>>${childChildMenuForm.menu.nameZh}</a></li>
									</c:forEach>
									</ul>
								</li>
							</c:if>
							
							<c:if test="${empty childMenuForm.childMenuForms}">
								<li class="sidemenu022"><span class="sidemenu022"><a href="javascript:void(0);" onclick="javascript:baseLayoutLoad.loadMenuContent('${pageContext.request.contextPath}${childMenuForm.menu.path}');">${childMenuForm.menu.nameZh}</a></span></li>
							</c:if>
						</c:forEach>
					</ul>
				</li>
			</c:if>
			<c:if test="${empty menuForm.childMenuForms}">
				<li class="sidemenu01 expandable"><span class="sidemenu01" onclick="javascript:baseLayoutLoad.loadMenuContent('${pageContext.request.contextPath}${menuForm.menu.path }')">${menuForm.menu.nameZh}</span></li>
			</c:if>
		</c:forEach>
	</ul>
</div>
</div>
<input type="hidden" id="menuUrlHid" value=""/>
<input type="hidden" id="preUrlHid" value=""/>