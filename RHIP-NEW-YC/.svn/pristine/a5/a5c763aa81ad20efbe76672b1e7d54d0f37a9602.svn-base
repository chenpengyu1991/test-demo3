<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script src="${pageContext.request.contextPath}/js/views/mdm/smpi/staffOrgAdd.js" type="text/javascript"></script>

<%@ page import="com.founder.rhip.ehr.common.RoleType" %>
<c:set var="ADMIN" value="<%=RoleType.ADMIN.getValue()%>"/>
<c:set var="YY_GLY" value="<%=RoleType.YY_GLY.getValue()%>"/>
<c:set var="ZX_GLY" value="<%=RoleType.ZX_GLY.getValue()%>"/>
<c:set var="Z_GLY" value="<%=RoleType.Z_GLY.getValue()%>"/>

<form id="staffOrgForm">
    <input type="hidden" id="rowIndexed" value="${rowIndex}"/>
    <input type="hidden" id="id" name="id" value="${dcGroup.id}"/>

    <div class="postcontent">
        <div class="postdiv">
            <table class="posttable" id="popStaffOrgTable">
                <colgroup>
                    <col style="min-width: 80px; width: 15%;"/>
                    <col style="min-width: 150px; width: 35%;"/>
                    <col style="min-width: 80px; width: 15%;"/>
                    <col style="min-width: 150px; width: 35%;"/>
                </colgroup>
                <tr>
                    <th><label class="required">机构名称：</label></th>
                    <td colspan="3">
                        <c:choose>
                            <c:when test="${type ne 'edit'}">
                                <ehr:authorize ifAnyGranted="${ADMIN}">
                                    <%--<tag:autoSelect name="organCode" id="staffOrganTree" style="width: 150px" reg="{'required':'true'}"/>--%>
                                    <ehr:medical-organ centreName="village" stationName="station" townName="town" isAllTown="true"
                                                                 townId="selectTownId"	centreId="selectCenterId" stationId="selectStationId" style="width:25%;"
                                                                 isShowHealthOversight="true" isShow="true" isShowOther="true" isShowJk="true" shoQwjw="true"/>
                                    <input type="hidden" id="organCodeId" name="organCode"/>
                                    <input type="hidden" id="organNameId" name="organName"/>
                                </ehr:authorize>
                                <ehr:authorize ifAnyGranted="${YY_GLY}">
                                    <ehr:org-type-list name="station" type="hospital"
                                                       defaultval="false"  width="30%;" reg="{'required':'true'}"/>
                                </ehr:authorize>

                                <ehr:authorize ifAnyGranted="${ZX_GLY}">
                                    <ehr:org-type-list name="station" parentCode="${currentLoginInfo.organization.organCode}"
                                                       defaultval="false" includeParent="true"
                                                       width="30%;" reg="{'required':'true'}"/>
                                </ehr:authorize>

                                <ehr:authorize ifAnyGranted="${Z_GLY}">
                                    <select name="station" style="width: 30%;" reg="{'required':'true'}">
                                        <option value="${currentLoginInfo.organization.organCode}">
                                            <ehr:org code="${currentLoginInfo.organization.organCode}"/>

                                        </option>
                                    </select>
                                </ehr:authorize>
                            </c:when>
                            <c:otherwise>
                                <input type="hidden" id="organCodeId" name="organCode" value="${staffOrg.organCode}"/>
                                <input type="hidden" id="organNameId" name="organName" value="<ehr:org code="${staffOrg.organCode}"/>"/>
                                <ehr:org code="${staffOrg.organCode}"/>
                            </c:otherwise>
                        </c:choose>
                    </td>
                </tr>
                <tr>
                    <th>所在科室</th>
                    <td>
                        <select name="deptCode" id="deptSelectId" style="width: 61%;">
                            <option value="">请选择</option>
                            <c:forEach var="dept" items="${deptList}">
                                <option value="${dept.deptCode}" ${staffOrg.deptCode eq dept.deptCode ? "selected" : ""}>${dept.deptName}</Option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <th>工作证号</th>
                    <td><input type="text" name="workIdCard" value="${staffOrg.workIdCard}" reg="{'maxlength':20}"/></td>
                    <th>胸牌号</th>
                    <td><input type="text" name="cardNum" value="${staffOrg.cardNum}" reg="{'maxlength':20}"/></td>
                </tr>
                </tr>

            </table>
        </div>
    </div>
    <div  style="padding: 0 0px 10px;text-align: center;">
        <%-- <input type="button" id="editContact" value="保存" onclick="staffOrgAdd.saveOptionData('${rowIndex}')" class="btnopr"> --%>
        <button class="layui-btn layui-btn-sm" id="staffOrgAddBtn">保存</button>&nbsp;&nbsp;&nbsp;
        <!-- <input type="button" id="cancelContact" value="取消" onclick="staffOrgAdd.closePopUp()" class="btnopr"> -->
        <button class="layui-btn layui-btn-sm" id="staffOrgCancelBtn">取消</button>
    </div>
</form>


