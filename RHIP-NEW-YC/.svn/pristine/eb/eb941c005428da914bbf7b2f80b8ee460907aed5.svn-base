<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<jsp:include page="../layouts/load-js-css-resources.jsp"></jsp:include>
<script src="${pageContext.request.contextPath}/js/views/user/search.js" type="text/javascript"></script>

<%@ page import="com.founder.rhip.ehr.common.RoleType" %>
<c:set var="ADMIN" value="<%=RoleType.ADMIN.getValue()%>"/>
<c:set var="YY_GLY" value="<%=RoleType.YY_GLY.getValue()%>"/>
<c:set var="ZX_GLY" value="<%=RoleType.ZX_GLY.getValue()%>"/>
<c:set var="Z_GLY" value="<%=RoleType.Z_GLY.getValue()%>"/>

<div class="section">
<div class="msgError" id="msgError" style="display: none;"></div>
<div class="msgOK" id="msgOK" style="display: none;"></div>

<div class="toolbar">
	<div class="x-nav">
		      <span class="layui-breadcrumb">
		        <a href="javascript:void(0)">系统管理</a>
		        <a href="javascript:void(0)">权限管理</a>
		        <a>
		          <cite>用户管理</cite></a>
		      </span>
		</div>
</div>
 <div class="searchbox searchSection x-admin-sm">
	<form id="userFormId" name="userForm" action="" method="post">
		<table id="useSearchTableId">
               <colgroup>
                    <col style="width: 10%"/>
                    <col style="width: 23%"/>
                    <col style="width: 10%"/>
                    <col style="width: 23%"/>
                    <col style="width: 10%"/>
                    <col style="width: 23%"/>
                </colgroup>
     			<tbody>
				<tr>
					<td class="coltext">用户名</td>
					<td class="colinput">
                         <input type="text" id="UserName" name="USER_NAME:String:LIKE" class="x-layui-input"/>
                    </td>
                    <td class="coltext">角色</td>
                    <td class="colinput">
                        <select id="roleCode" name="roleCode" class="x-layui-input">
                            <option value="">请选择</option>
                            <c:forEach items="${roles}" var="role">
                                <option value="${role.roleCode}">${role.description}</option>
                            </c:forEach>
                        </select>
                    </td>
                    <td class="coltext">姓名</td>
                    <td class="colinput">
                        <input type="text" id="Name" name="name:String:LIKE" class="x-layui-input"/>
                    </td>
				</tr>
				<tr>
					<td class="coltext">机构</td>
					<ehr:authorize ifAnyGranted="${ADMIN}">
						<td class="colinput" colspan="3">
							<ehr:medical-organ centreName="village" stationName="station" townName="town"
														 townId="searchTown" centreId="searchCenter" stationId="searchStation" width="150px"
														  isShowHealthOversight="true" cssClass="x-layui-input" isShow="true" isShowOther="true" isShowJk="true" shoQwjw="true" isShowOneself="true"/>
								<input id="searchOrganCode" name="organCode" type="hidden"/>
						</td>
					</ehr:authorize>

					<ehr:authorize ifAnyGranted="${QWGZX}">
						<td class="colinput" colspan="3">
							<ehr:dic-town-centre-station centreName="village" stationName="station" townName="town" townValue="${currentLoginInfo.organization.organCode}"
														 townId="searchTown" centreId="searchCenter" stationId="searchStation" width="150px"
														 isAdministration="false" isAllTown="true" isShowOneself="true" includeTownCodes="${currentLoginInfo.organization.organCode}" cssClass="x-layui-input"
							/>
							<input id="searchOrganCode" name="organCode" type="hidden"/>
						</td>
					</ehr:authorize>

					<ehr:authorize ifAnyGranted="${YY_GLY}">
						<td class="colinput">
							<ehr:org-type-list name="organCode" type="hospital"  defaultval="false" cssClass="x-layui-input"/>
						</td>
					</ehr:authorize>

					<ehr:authorize ifAnyGranted="${ZX_GLY}">
						<td class="colinput">
							<ehr:org-type-list name="organCode" parentCode="${currentLoginInfo.organization.organCode}"
											   defaultval="false" includeParent="true" cssClass="x-layui-input"/>
						</td>
					</ehr:authorize>

					<ehr:authorize ifAnyGranted="${Z_GLY}">
						<td class="colinput">
							<select name="organCode" cssClass="x-layui-input">
								<option value="${currentLoginInfo.organization.organCode}">
									<ehr:org code="${currentLoginInfo.organization.organCode}"/>

								</option>
							</select>
						</td>
					</ehr:authorize>

					<td class="coltext">状态</td>
					<td class="colinput">
						<select id="status" name="status" class="x-layui-input">
							<option value="">请选择</option>
								<option value="1">已启用</option>
								<option value="0">已禁用</option>
						    </select>
					</td>
					<ehr:authorize ifAnyGranted="${YY_GLY},${ZX_GLY},${Z_GLY}">
						<td class="colinput"/>
						<td class="colinput">
							<button class="layui-btn layui-btn-sm" id="userSearchBut"><i class="layui-icon">&#xe615;</i>查询</button>
						</td>
					</ehr:authorize>

				</tr>
				<ehr:authorize ifAnyGranted="${ADMIN},${QWGZX}">
				<tr>
					<td class="colinput"/>
					<td class="colinput"/>
					<td class="colinput"/>
					<td class="colinput"/>
					<td class="colinput"/>
					<td class="colinput">
						<button class="layui-btn layui-btn-sm" id="userSearchBut"><i class="layui-icon">&#xe615;</i>查询</button>
					</td>
				</tr>
				</ehr:authorize>
			</tbody>
		</table>
         <table>
              <tr>
                  <td colspan="4" class="colbottom">
                         <span id="userSearchSpanId" class="ico-bottom">&nbsp;</span>
                  </td>
              </tr>
         </table>
	</form>
 </div>
	<div class="toolbarSection">
		<a href="javascript:void(0)" id="userAddButId"><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe608;</i>新增</button></a>
	</div>
<div id="listDiv"></div>
</div>