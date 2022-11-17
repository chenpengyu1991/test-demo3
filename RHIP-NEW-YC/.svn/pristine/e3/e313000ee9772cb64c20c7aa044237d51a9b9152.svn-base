<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<%@ page import="com.founder.rhip.ehr.common.RoleType" %>
<c:set var="JKSCB" value="<%=RoleType.JKSCB.getValue()%>"/>
<c:set var="ADMIN" value="<%=RoleType.ADMIN.getValue()%>"/>
<c:set var="ZXSCB" value="<%=RoleType.ZXSCB.getValue()%>"/>

<script src="${pageContext.request.contextPath}/js/views/idm/filariasis/registerSearch.js" type="text/javascript"></script>
<div>
	<div id="register_top_all">
        <div class="toolbar">
        </div>
		<div class="searchBox searchSection x-admin-sm">
			<form id="registerSearchForm">
                <table id="registerSearch" >
				<colgroup>
					<col style="min-width:70px; width: 10%;"/>
					<col style="min-width:100px; width: 23%;"/>
					<col style="min-width:70px; width: 10%;"/>
					<col style="min-width:100px; width: 23%;"/>
                    <col style="min-width:70px; width: 10%;"/>
                    <col style="min-width:183px; width: 23%;"/>
				</colgroup>		
					<tbody>
                    <input type="hidden" id="pageIndex" value="${pageIndex}">
                    <%--隐藏的文本框是为了一个文本框不能响应回车事件的解决方法，不能删除--%>
                    <input type="text" style="display: none;">
                        <tr>
                            <td class="coltext">住址</td>
                            <td class="colinput" rowspan="2" style="vertical-align: top; padding-top: 5px;">
                                <ehr:dic-town-street-village townName="patownShip" streetName="pastreet" width="50%" cssClass="x-layui-input"/>
                            </td>
                            <td class="coltext">姓名</td>
                            <td class="colinput"><input type="text" name="name" class="x-layui-input"/></td>
                            <ehr:authorize ifAnyGranted="${JKSCB},${ADMIN}">
                                <td class="coltext">监测单位</td>
                                <td class="colinput">
                                    <tag:autoSelect name="surveyOrg" id="surveyOrg"></tag:autoSelect>
                                </td>
                            </ehr:authorize>
                            <ehr:authorize ifNotGranted="${JKSCB},${ADMIN}">
                                <td colspan="2"></td>
                            </ehr:authorize>
                        </tr>
						<tr>
                            <td></td>
                            <td class="coltext">性别</td>
                            <td class="colinput">
                                <ehr:dic-list id="gender" name="gender" dicmeta="GBT226112003" code="1,2" cssClass="x-layui-input"/>
                            </td>
                            <td></td>
                            <td class="centertd">
                                <button class="layui-btn layui-btn-sm" id="registerBtnSearch"><i class="layui-icon">&#xe615;</i>查询</button>
                            </td>
                        </tr>
					</tbody>
				</table>
                <table>
	                <tr>
	                    <td colspan="7" class="colbottom">
	                          <span onclick="idmCommon.toggle(this,'registerSearch')" class="ico-bottom">&nbsp;</span>
	                    </td>
	                </tr>
				</table>
			 </form>
		</div>
        <div class="toolbarSection x-admin-sm">
            <ehr:authorize ifAnyGranted="${ZXSCB},${JKSCB}">
                <a href="javascript:void(0)" onclick='filRegSearch.initAddReg()'>
                    <button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe608;</i>新增</button>
                </a>
            </ehr:authorize>
        </div>
		<div id="registerResultDiv"></div>
	</div>
	<div id="registerDetailDiv" ></div>
</div>

