<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<%@ page import="com.founder.rhip.idm.common.TbStatus" %>
<%@ page import="com.founder.rhip.ehr.common.RoleType" %>
<c:set var="JKJHB" value="<%=RoleType.JKJHB.getValue()%>"/>
<c:set var="RECOMMENDATION" value="<%=TbStatus.RECOMMENDATION.getValue()%>" />
<c:set var="REGISTER" value="<%=TbStatus.REGISTER.getValue()%>" />

<script src="${pageContext.request.contextPath}/js/views/idm/idmCommon.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/idm/tb/register.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/idm/tb/tb_common.js" type="text/javascript"></script>

<div>
	<div id="top_allRegister">
		<div class="searchbox searchSection x-admin-sm">
			<form id="registerSearchForm">
				<table id="registerSearch">
					<colgroup>
						<col style="min-width:70px; width: 10%;"/>
						<col style="min-width:100px; width: 23%;"/>
						<col style="min-width:70px; width: 10%;"/>
						<col style="min-width:100px; width: 23%;"/>
						<col style="min-width:70px; width: 10%;"/>
						<col style="min-width:183px; width: 23%;"/>
					</colgroup>	
					<tbody>
						<tr>
							<td class="coltext">姓名</td>
							<td class="colinput"><input type="text" name="name" class="x-layui-input"/></td>
							<td class="coltext">身份证号</td>
							<td class="colinput"><tag:idcardInput name="idcard"  id="idcard" cssClass="x-layui-input"/>
								<input type="button" id="check-submit-btn" value="读卡" style="width: 40px;">
							</td>
							<td class="coltext">性别</td>
							<td class="colinput"><ehr:dic-list name="gender"
									dicmeta="GBT226112003" code="1,2" cssClass="x-layui-input" /></td>
						</tr>
						<tr>
							<td class="coltext">状态</td>
							<td class="colinput">
								<select name="specialStatus" class="x-layui-input">
									<option value="">请选择</option>
									<option value="${REGISTER}">已筛查登记</option>
									<option value="${RECOMMENDATION}">未筛查登记</option>
								</select>
							</td>
							<td class="coltext">常住类型</td>
							<td class="colinput"><ehr:dic-list dicmeta="FS10005" name="floatPopulation" cssClass="x-layui-input"/></td>
							<td></td>
							<td>
								<%-- <input type="button" id="registerBtnSearch" value="查询" class="search_btn"/> --%>
								<button class="layui-btn layui-btn-sm" id="registerBtnSearch"><i class="layui-icon">&#xe615;</i>查询</button>
							</td>
						</tr>
					</tbody>
				</table>
				<table>
	                <tr>
	                    <td colspan="6" class="colbottom">
	                          <span onclick="tbCommon.toggle(this,'registerSearch')" class="ico-bottom">&nbsp;</span>
	                    </td>
	                </tr>
				</table>
			</form>
			</div>
		<div class="toolbarSection">
			<ehr:authorize ifNotGranted="${JKJHB}">
				<%-- <a href="javascript:void(0)" onclick="tbCommon.add('',${REGISTER},'1','Register')"><b class="xinz">新建</b></a> --%>
				<a href="javascript:void(0)" onclick="tbCommon.add('',${REGISTER},'1','Register')"><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe608;</i>新建</button></a>
			</ehr:authorize>
			<%-- <a href="javascript:void(0)" onclick="tbCommon.downLoadRegister()"><b class="export">导出</b></a> --%>
			<a href="javascript:void(0)" onclick="tbCommon.downLoadRegister()"><button class="layui-btn layui-btn-sm" ><i class="layui-icon">&#xe67d;</i>导出</button></a>
		</div>
		<div id="listDivRegister"></div>
	</div>
	<div id="detailDivRegister"></div>
</div>