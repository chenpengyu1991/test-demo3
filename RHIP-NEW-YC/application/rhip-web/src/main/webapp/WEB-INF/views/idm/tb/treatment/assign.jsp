<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib  tagdir="/WEB-INF/tags" prefix="tag"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.founder.rhip.idm.common.SpecialEvents" %>
<%@ page import="com.founder.rhip.idm.common.TbStatus" %>
<c:set var="T_TREATMENT" value="<%=SpecialEvents.T_TREATMENT.getValue()%>"/>
<c:set var="TREATMENT" value="<%=TbStatus.TREATMENT.getValue()%>" />

<script src="${pageContext.request.contextPath}/js/views/idm/case/edit.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/idm/tb/treatment.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/idm/tb/tb_common.js" type="text/javascript"></script>

<c:set var="JFS" value="0109" />
<c:set var="SQZX" value="0209" />

<form id="tbForm" style="padding-top: 15px; padding-bottom: 20px;">
	<input type="hidden" name="idmId" value="${idmId}" id="idmId"/>
	<input type="hidden" name="singleId" value="${singleId}" id="singleId"/>
	<input type="hidden" id="pageIndex" value="${pageIndex}">
			<table class="posttable">
				<colgroup>
					<col style="width: 35%;" />
					<col style="width: 65%" />
				</colgroup>
				<tr>
					<th style="text-align: right;"><label class="required">接纳机构:</label></th>
					<td>
						<c:choose>
							<%--<c:when test="${ROLE==JFS||ROLE=='21'||ROLE=='91'}">
								<ehr:org-type-list id="orgCode" name="orgCode" type="hospital,centre"/>
							</c:when>--%>
							<c:when test="${ROLE==SQZX}">
								<ehr:org-type-list id="orgCode" name="orgCode" parentCode="${currentLoginInfo.organization.organCode }"/>
							</c:when>
							<c:otherwise>
								<ehr:org-type-list id="orgCode" name="orgCode" type="hospital,centre"/>
							</c:otherwise>
						</c:choose>
					 </td>
				</tr>
				<%--<tr>--%>
                    <%--<td colspan="2" style="text-align: center;">--%>
                        <%--<input type="button" id="editContactPerson" value="保存 " onclick="treatment.saveAssign()">--%>
                        <%--<input type="button" id="cancelContact" value="取消" onclick="treatment.closePopUp('assignDialog')">--%>
                    <%--</td>--%>
                <%--</tr>--%>
			</table>
</form>
<div class="toolbarpop">
    <input type="button" id="editContactPerson" value="保存 " onclick="treatment.saveAssign()">
    <input type="button" id="cancelContact" value="取消" onclick="treatment.closePopUp('assignDialog')">
</div>