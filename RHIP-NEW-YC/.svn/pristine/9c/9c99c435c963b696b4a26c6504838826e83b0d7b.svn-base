<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ page import="com.founder.rhip.ehr.common.RoleType" %>
<c:set var="ADMIN" value="<%=RoleType.ADMIN.getValue()%>"/>
<c:set var="YY_GLY" value="<%=RoleType.YY_GLY.getValue()%>"/>
<c:set var="ZX_GLY" value="<%=RoleType.ZX_GLY.getValue()%>"/>
<c:set var="Z_GLY" value="<%=RoleType.Z_GLY.getValue()%>"/>
<%--<jsp:include page="../layouts/load-js-css-resources.jsp"></jsp:include>--%>

<script src="${pageContext.request.contextPath}/js/views/user/staff.js" type="text/javascript"></script>

<div style="width: 95%; padding-left: 10px;">
<div class="searchbox searchSection x-admin-sm">
	<form id="starffSearchForm" name="starffSearchForm" action="" method="post">
        <input id="searchStaffOrganCode" name="organCode" type="hidden"/>
        <input type="hidden" id="staff_index">
        <table id="urSearch">
            <colgroup>
               <col style="width: 15%;"/>
               <col style="width: 55%;"/>
               <col style="width: 30%;"/>
               </colgroup>
            <tr>
                <td class="coltext">所属机构</td>
                <ehr:authorize ifAnyGranted="${ADMIN}">
                    <td class="colinput" colspan="3">
                        <ehr:medical-organ centreName="village" stationName="station" townName="town"
                                                     townId="searchTownStaffId" centreId="searchCenterStaffId" stationId="searchStationStaffId" width="150px"
                                                     isShowHealthOversight="true" cssClass="x-layui-input" isShow="true" isShowOther="true" isShowJk="true" shoQwjw="true" isShowOneself="true"/>
                        <input id="searchOrganCode" name="organCode" type="hidden"/>
                    </td>
                </ehr:authorize>

                <ehr:authorize ifAnyGranted="${QWGZX}">
                    <td class="colinput" colspan="3">
                        <ehr:dic-town-centre-station centreName="village" stationName="station" townName="town" townValue="${currentLoginInfo.organization.organCode}"
                                                     townId="searchTown" centreId="searchCenter" stationId="searchStation" width="150px"
                                                     isAdministration="false" isAllTown="true" isShowOneself="true" includeTownCodes="${currentLoginInfo.organization.organCode}"
                        />
                        <input id="searchOrganCode" name="organCode" type="hidden"/>
                    </td>
                </ehr:authorize>

                <ehr:authorize ifAnyGranted="${YY_GLY}">
                    <td class="colinput">
                        <ehr:org-type-list name="organCode" type="hospital"  defaultval="false"/>
                    </td>
                </ehr:authorize>

                <ehr:authorize ifAnyGranted="${ZX_GLY}">
                    <td class="colinput">
                        <ehr:org-type-list name="organCode" parentCode="${currentLoginInfo.organization.organCode}"
                                           defaultval="false" includeParent="true"/>
                    </td>
                </ehr:authorize>

                <ehr:authorize ifAnyGranted="${Z_GLY}">
                    <td class="colinput">
                        <select name="organCode">
                            <option value="${currentLoginInfo.organization.organCode}">
                                <ehr:org code="${currentLoginInfo.organization.organCode}"/>

                            </option>
                        </select>
                    </td>
                </ehr:authorize>

            </tr>
			<tr>
				<td class="coltext">姓名</td>
				<td class="colinput">
                    <input type="text" id="staffName" name="staffName" value="${staffName}" style="width: 35%;"/>
                    <input type="text" style="display: none;"/>
                </td>
                <td class="colinput" style="text-align: center;">
                    <button class="layui-btn layui-btn-sm" id="searchStaffButId"><i class="layui-icon">&#xe615;</i>查询</button>
                </td>
			</tr>
		</table>
	</form>
 </div>
<div id="listDivStaff"></div>
</div>
