<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<jsp:include page="../../../layouts/load-js-css-resources.jsp"></jsp:include>

<script src="${pageContext.request.contextPath}/js/views/idm/ncp/emc/search.js" type="text/javascript"></script>
<div class="section">
<div class="section" id="top_all">

    <div class="searchbox searchSection x-admin-sm">
        <form method="post" id="form_search">
            <table id="health-card-search-table">
                <colgroup>
                    <col style="width:15%">
                    <col style="width:20%">
                    <col style="width:15%">
                    <col style="width:20%">
                    <col style="width:65%">
                </colgroup>
                <tbody>
                <tr>
                    <td class="coltext">姓名</td>
                    <td class="colinput"><input type="text" name="name" id="personName" class="x-layui-input"/></td>
                    <td class="coltext">身份证号</td>
                    <td class="colinput">
                        <tag:idcardInput name="idcard" style="ime-mode:Disabled;" id="idcard"  reg='{"required":"true"}' cssClass="x-layui-input"></tag:idcardInput>
                    </td>
                    <td class="colinput">
                        <!-- <input type="button" value="查询" id="quBtnSearch" class="search_btn"/> -->
                        <button class="layui-btn layui-btn-sm" id="quBtnSearch"><i class="layui-icon">&#xe615;</i>查询</button>
                    </td>
                </tr>
                </tbody>
            </table>
            <table>
                <tr>
                    <td colspan="6" class="colbottom">
                        <span id="health-card-search-toggle-btn" class="ico-bottom">&nbsp;</span>
                    </td>
                </tr>
            </table>
        </form>
    </div>
    <div id="diseaseInfo" class="repeattable">
        <jsp:include page="list.jsp"/>
    </div>
</div>
</div>
