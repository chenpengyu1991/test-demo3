<%--
  Created by IntelliJ IDEA.
  User: zheng_dandan
  Date: 13-6-14
  Time: 上午11:03
  To change this template use File | Settings | File Templates.
--%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="ehr" uri="/WEB-INF/tld/ehr-tag.tld"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<%@ page import="com.founder.rhip.ehr.common.PortalSetType" %>

<c:set var="portalSetTypes" value="<%=PortalSetType.values()%>" />

<script src="${pageContext.request.contextPath}/js/views/portal/portalSet/search.js" type="text/javascript"></script>

<div class="section" id="searchDiv">
	<div class="toolbar">
		<%--<a id="add" onclick="setSearch.add()"><b class="xinz">新增</b></a>--%>
	</div>
    <div class="searchbox" id="searchBox">
        <form id="set_form_search">
            <table id="reportSearch">
                <tbody>
                <colgroup>
                    <col style="min-width:70px; width: 10%;"/>
                    <col style="min-width:160px; width: 23%;"/>
                    <col style="min-width:80px; width: 10%;"/>
                    <col style="min-width:160px; width: 23%;"/>
                    <col style="min-width:60px; width: 10%;"/>
                    <col style="min-width:160px; width: 23%;"/>
                    <col style="min-width:160px; width: 13%;"/>
                </colgroup>
                <tr>
                    <td class="coltext">编码</td>
                    <td><input type="text" name="code" /></td>
                    <td class="coltext">名称</td>
                    <td><input type="text" name="name" /></td>
                    <td class="coltext">类型</td>
                   <!--  <td><input type="text" name="type" /></td> -->
	                <td>
	                   <select name="type" >
						  <option value="">请选择</option>
                           <c:forEach var="portalSetType" items="${portalSetTypes}">
                               <option value="${portalSetType.value}">${portalSetType.value}</option>
                           </c:forEach>
						</select>
					</td>	
                    <td><input id="set_search_btn" class="search_btn" type="button" value="查询" style="float: left;" /></td>
                </tr>
                </tbody>
            </table>
            <table>
                <tr>
                    <td colspan="6" class="colbottom">
                        <span onclick="stopSearch.toggle(this,'reportSearch')" class="ico-bottom">&nbsp;</span>
                    </td>
                </tr>
            </table>
        </form>
    </div>
    <div id="set_records"></div>
</div>
