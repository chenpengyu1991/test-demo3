<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<jsp:include page="../../layouts/load-js-css-resources.jsp"></jsp:include>

<script src="${pageContext.request.contextPath}/js/views/ihm/bloodMgnt/search.js" type="text/javascript"></script>
<%--<script src="${pageContext.request.contextPath}/js/views/ihm/cwhTarget/cwhCommon.js" type="text/javascript"></script>--%>

<div class="toolbar">
    <div class="x-nav">
		      <span class="layui-breadcrumb">
		        <a href="javascript:void(0)">综合管理</a>
		        <a href="javascript:void(0)">献血管理</a>
		        <a>
		          <cite>
                      献血记录
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
                    <col style="width: 10%; min-width: 70px;"/>
                    <col style="width: 20%; min-width: 70px;"/>
                    <col style="width: 10%; min-width: 70px;"/>
                    <col style="width: 20%; min-width: 70px;"/>
                    <col style="width: 10%; min-width: 70px;"/>
                    <col style="width: 20%; min-width: 70px;"/>
                    <col/>
                </colgroup>
                <tbody>
                <tr>
                    <td class="col-text">姓名</td>
                    <td class="col-input">
                        <input type="text" name="name"  style="width: 180px;">
                    </td>
                    <td class="col-text">性别</td>
                    <td class="col-input">
                       <select name="gender"  class="x-layui-input" style="width: 180px;">
                           <option value="">请选择</option>
                           <option value="男">男</option>
                           <option value="女">女</option>
                       </select>
                    </td>
                    <td class="col-text">身份证号</td>
                    <td class="col-input">
                        <input type="text" name="idcard" style="width: 180px;">
                    </td>
                    <td></td>
                </tr>
                <tr>
                    <td class="col-text">献血方式</td>
                    <td class="col-input">
                        <input type="text" name="bloodType"  style="width: 180px;">
                    </td>
                    <td class="col-text">ABO血型</td>
                    <td class="col-input">
                        <select name="aboBloodType" class="x-layui-input" style="width: 180px;">
                           <option value="">请选择</option>
                           <option value="A">A</option>
                           <option value="B">B</option>
                           <option value="O">O</option>
                           <option value="AB">AB</option>
                           <option value="不详">不详</option>
                       </select>
                    </td>
                    <td colspan="2"></td>
                    <td style="text-align: right;">
                        <button class="layui-btn layui-btn-sm"  id="btnSearch"><i class="layui-icon">&#xe615;</i>查询</button>
                    </td>
                </tr>
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