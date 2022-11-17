<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<jsp:include page="../../../../layouts/load-js-css-resources.jsp"></jsp:include>
<script src="${pageContext.request.contextPath}/js/views/ihm/cwhTarget/child/searchChildCount.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/ihm/ihmCommon.js" type="text/javascript"></script>
<div class="section">
    <div class="toolbar">
        <div class="x-nav">
	       <span class="layui-breadcrumb">
               <a href="javascript:void(0)">综合管理</a>
               <a href="javascript:void(0)">妇幼保健</a>
               <a><cite>儿童人数统计</cite></a>
            </span>
        </div>
    </div>
    <div class="searchbox searchSection x-admin-sm">
        <input type="hidden" id="pageIndex" value="${pageIndex}">
        <input type="hidden" id="searchUrl" value="${searchUrl}">
        <form id="targetSearchForm">
            <table id="targetSearch">
                <colgroup>
                    <col style="width: 10%;"/>
                    <col style="width: 20%;"/>
                    <col style="width: 10%;"/>
                    <col style="width: 20%;"/>
                    <col style="width: 10%;"/>
                    <col style="width: 20%;"/>
                </colgroup>
                <tbody>
                <tr>
                    <td class="col-text">镇</td>
                    <td>
                        <ehr:dic-town-village townName="gbCode" />
                        <input type="hidden" name="genreCode" value="0">
                    </td>
                    <td class="col-text">时间点</td>
                    <td class="col-input">
                        <input type="radio" name="timePoint" value="3" checked="checked">3月31日
                        <input type="radio" name="timePoint" value="9">9月30日
                    </td>
                </tr>
                <tr>
                    <td class="righttd" colspan="6">
                        <button class="layui-btn layui-btn-sm" id="targetBtnSearch"><i class="layui-icon">&#xe615;</i>查询</button>
                    </td>
                </tr>
                </tbody>
            </table>
            <table>
                <tr>
                    <td class="col-bottom">
                        <span onclick="toggle(this,'targetSearch')" class="ico-bottom">&nbsp;</span>
                    </td>
                </tr>
            </table>
        </form>
    </div>
    <div id="resultDiv"><jsp:include page="childCountList.jsp" ></jsp:include></div>
</div>