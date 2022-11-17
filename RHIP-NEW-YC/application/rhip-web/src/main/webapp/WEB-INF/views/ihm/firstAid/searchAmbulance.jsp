<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<jsp:include page="../../layouts/load-js-css-resources.jsp"></jsp:include>

<script src="${pageContext.request.contextPath}/js/views/ihm/firstAid/search.js" type="text/javascript"></script>
<%--<script src="${pageContext.request.contextPath}/js/views/ihm/cwhTarget/cwhCommon.js" type="text/javascript"></script>--%>

<div class="toolbar">
    <div class="x-nav">
		      <span class="layui-breadcrumb">
		        <a href="javascript:void(0)">综合管理</a>
		        <a href="javascript:void(0)">急救资源</a>
		        <a>
		          <cite>
                      车辆信息
		          </cite>
                </a>
		      </span>
    </div>
</div>
<div class="section">
    <div class="searchBox searchSection x-admin-sm">
        <input type="hidden" id="pageIndex" value="${pageIndex}">
        <input type="hidden" id="searchUrl" value="${searchUrl}">
        <form id="searchForm">
            <table id="searchTable">
                <colgroup>
                    <col style="width: 10%;"/>
                    <col style="width: 20%;"/>
                    <col style="width: 10%;"/>
                    <col style="width: 20%;"/>
                    <col style="width: 10%;"/>
                    <col style="width: 20%;"/>
                    <col/>
                </colgroup>
                <tbody>
                <tr>
                    <td class="col-text">车牌号码</td>
                    <td class="col-input">
                        <input type="text" name="busNo"  style="width: 180px;">
                    </td>
                    <td class="col-text">司机</td>
                    <td class="col-input">
                        <input type="text" name="driver"  style="width: 180px;">
                    </td>
                    <td class="col-text">车载电话</td>
                    <td class="col-input">
                        <input type="text" name="carTelphone" style="width: 180px;">
                    </td>
                    <td style="text-align: right;">
                        <button class="layui-btn layui-btn-sm"  id="btnSearch"><i class="layui-icon">&#xe615;</i>查询</button>
                    </td>
                </tr>
                <%--<tr>--%>
                    <%--<td class="col-text">中心编码</td>--%>
                    <%--<td class="col-input">--%>
                        <%--<input type="text" name="centerNo" >--%>
                    <%--</td>--%>
                    <%--<td colspan="4"></td>--%>
                    <%--<td style="text-align: right;">--%>
                        <%--<input type="button" id="btnSearch" value="查询" onclick="" class="search_btn" />--%>
                    <%--</td>--%>
                <%--</tr>--%>
                </tbody>
            </table>
            <table>
                <tr>
                    <td colspan="4" class="col-bottom"><span onclick="toggle(this,'searchTable')" class="ico-bottom">&nbsp;</span></td>
                </tr>
            </table>
        </form>
    </div>
    <div id="listDiv">
    </div>
</div>