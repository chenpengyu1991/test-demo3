<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.founder.rhip.ehr.common.RoleType" %>
<c:set var="ZXJHB" value="<%=RoleType.ZXJHB.getValue()%>"/>
<c:set var="ZJHB" value="<%=RoleType.ZJHB.getValue()%>"/>
<c:set var="JKJHB" value="<%=RoleType.JKJHB.getValue()%>"/>
<c:set var="ADMIN" value="<%=RoleType.ADMIN.getValue()%>"/>
<c:set var="DDCRBYY" value="<%=RoleType.DDCRBYY.getValue()%>"/>

<script src="${pageContext.request.contextPath}/js/views/idm/tb/standardization.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/idm/tb/tb_common.js" type="text/javascript"></script>

<div class="section">
	<div id="top_allStandardization">
		<div class="searchbox searchSection x-admin-sm">
			<form id="standardizationSearchForm">	
				<input type="hidden" name="typeTb" id="typeTb" value="${typeTb }"/>			
                <table id="standardizationSearch" >
					<colgroup>
						<col style="min-width:70px; width: 10%;"/>
						<col style="min-width:100px; width: 23%;"/>
						<col style="min-width:70px; width: 10%;"/>
						<col style="min-width:100px; width: 23%;"/>
						<col style="min-width:70px; width: 10%;"/>
						<col style="min-width:100px; width: 23%;"/>
					</colgroup>
					<tbody>
						<tr>
							<td class="coltext">姓名</td>
							<td class="colinput"><input type="text" name="name" class="x-layui-input" /></td>
							<td class="coltext">身份证号</td>
							<td class="colinput"><tag:idcardInput name="idcard" id="idCardDd" cssClass="x-layui-input"/>&nbsp;
								<input type="button" id="check-submit-btndd" value="读卡" style="width: 40px;"></td>
							<td class="coltext">性别</td>
							<td class="colinput"><ehr:dic-list name="gender" dicmeta="GBT226112003" code="1,2"/></td>
						</tr>
						<tr>
							<td class="coltext">是否首次随访</td>
							<td class="colinput">
								<select name="firstVist" class="x-layui-input" >
									<option value="">请选择</option>
									<option value="0">否</option>
									<option value="1">是</option>
								</select>
							</td>
							<c:if test="${typeTb eq 7}">
									<ehr:authorize ifAnyGranted="${ZXJHB},${ZJHB}">
										<td class="coltext" id="sf_text" >管理机构</td>
										<td class="colinput" id="sf_input">
											<ehr:dic-org-list id="nowAddressCode" name="orgCode" defaultval="N" width="80%" isShowOneself="true" cssClass="x-layui-input"/>
										</td>
									</ehr:authorize>
									<ehr:authorize ifAnyGranted="${DDCRBYY},${JKJHB},${ADMIN}">
										<td class="coltext" id="sf_text">管理机构</td>
										<td class="colinput" id="sf_input" colspan="5">
											<ehr:dic-town-centre-station centreName="searchCenter" stationName="searchstation" townName="searchTown" isAuthorize="false" isShow="true" isShowOneself="true"
																		 townId="searchTown1" centreId="searchCenter1" stationId="searchStation1" style="width: 150px;" cssClass="x-layui-input"/>
											<input id="searchOrgCode" name="orgCode" type="hidden"/>
										</td>
									</ehr:authorize>
							</c:if>
							<td class="righttd" colspan="3"><button class="layui-btn layui-btn-sm" id="standardizationBtnSearch"><i class="layui-icon">&#xe615;</i>查询</button></td>
						</tr>
					</tbody>
				</table>
				<table>
	                <tr>
	                    <td colspan="6" class="colbottom">
	                          <span onclick="tbCommon.toggle(this,'standardizationSearch')" class="ico-bottom">&nbsp;</span>
	                    </td>
	                </tr>
				</table>
			 </form>
		</div>
		<div id="listDivStandardization"></div>
	</div>
	<div id="detailDivStandardization"></div>
</div>

