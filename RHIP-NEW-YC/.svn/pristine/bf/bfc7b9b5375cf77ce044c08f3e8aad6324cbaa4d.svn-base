<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:if test="${empty orgDtos}">
无记录
</c:if>
<ul id="browser" class="sidemenulist  treeview-famfamfam">
		<li class="sidemenu01 expandable"><span class="sidemenu01" onclick="javascript:personRecordPagination.allMenuClick()">全部</span>
		<c:forEach var="menuForm" items="${orgDtos}">
			<c:if test="${not empty menuForm.childOrganizationDtos}">
				<li class="sidemenu01"><span class="sidemenu01">${menuForm.organization.organizationMenuName}</span>
					<ul>
						<c:forEach var="childMenuForm" items="${menuForm.childOrganizationDtos}">
							<c:if test="${not empty childMenuForm.childOrganizationDtos }">
								<li class="sidemenu02">
									<span title="${childMenuForm.organization.name}" class="sidemenu02" onclick="javascript:personRecordPagination.searchOrgTree('${childMenuForm.organization.orgCode}');">
                                            ${childMenuForm.organization.organizationMenuName}
									</span>
									<ul>
									<c:forEach var="childChildMenuForm" items="${childMenuForm.childOrganizationDtos}">
										<li title="${childChildMenuForm.organization.name}" class="sidemenu03"><a href="javascript:void(0);" id="search" onclick="javascript:personRecordPagination.searchOrgTree('${childChildMenuForm.organization.orgCode}');">
										${childChildMenuForm.organization.organizationMenuName}</a>
										</li>
									</c:forEach>
									</ul>
								</li>
							</c:if>
							<c:if test="${empty childMenuForm.childOrganizationDtos}">
								<li class="sidemenu022">
									<span title="${childMenuForm.organization.name}" class="sidemenu022"  onclick="javascript:personRecordPagination.searchOrgTree('${childMenuForm.organization.orgCode}');">
                                            ${childMenuForm.organization.organizationMenuName}
									</span>
								</li>
							</c:if>
						</c:forEach>
					</ul>
				</li>
			</c:if>
			<c:if test="${empty menuForm.childOrganizationDtos}">
				<li>
					<span title="${menuForm.organization.name}" class="sidemenu01" onclick="javascript:personRecordPagination.searchOrgTree('${menuForm.organization.orgCode}');">
                            ${menuForm.organization.organizationMenuName}
					</span>
				</li>
			</c:if>
		</c:forEach>
	</ul>