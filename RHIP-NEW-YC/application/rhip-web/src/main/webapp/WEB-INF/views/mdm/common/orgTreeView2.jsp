<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<ul id="mdmParentOrganTreeView" class="sidemenulist  treeview-famfamfam">
	<c:if test="${empty treeData}">无记录</c:if>
	<c:forEach var="topMenu" items="${treeData}">
		<c:if test="${not empty topMenu.childs}">
			<li class="sidemenu01"><span class="sidemenu01">${topMenu.organizationMenuName}</span>
				<ul>
					<c:forEach var="childMenu" items="${topMenu.childs}">
							<li class="sidemenu022">
								<span title="${childMenu.organName}" class="sidemenu022"
									organCode="${childMenu.organCode}" organName="${childMenu.organName}">
	                                          ${childMenu.organizationMenuName}
								</span>
							</li>
					</c:forEach>
				</ul>
			</li>
		</c:if>
		<c:if test="${empty topMenu.childs}">
			<li>
				<span title="${topMenu.organization.organName}" class="sidemenu01">
	               ${topMenu.organizationMenuName}
				</span>
			</li>
		</c:if>
	</c:forEach>
</ul>