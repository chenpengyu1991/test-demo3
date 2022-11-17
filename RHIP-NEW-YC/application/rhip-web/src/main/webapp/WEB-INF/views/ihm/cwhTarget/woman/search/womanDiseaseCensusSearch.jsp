<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<jsp:include page="../../../../layouts/load-js-css-resources.jsp"></jsp:include>

<script src="${pageContext.request.contextPath}/js/views/ihm/cwhTarget/woman/search.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/ihm/cwhTarget/cwhCommon.js" type="text/javascript"></script>
<div class="toolbar">
    <div class="x-nav">
          <span class="layui-breadcrumb">
            <a href="javascript:void(0)">综合管理</a>
            <a href="javascript:void(0)">计划生育</a>
            <a><cite>妇女疾病筛查</cite></a>
          </span>
    </div>
</div>
<div class="section">
    <div class="searchbox searchSection x-admin-sm">
        <input type="hidden" id="pageIndex" value="${pageIndex}">
        <input type="hidden" id="searchType" value="${searchType}">
        <form id="searchForm">
            <table id="searchTable">
                <colgroup>
                    <col style="min-width:150px;width: 17%;"/>
                    <col style="min-width:80px;width: 28%;"/>
                    <col style="min-width:80px;width: 17%"/>
                    <col style="min-width:80px;width: 28%;"/>
                </colgroup>
                <tbody>
                <tr>
                    <td class="col-text">检查机构</td>
                    <td class="col-input">
                        <input type="hidden" id="genreCode" name="genreCode"/>
                        <tag:autoSelect name="organCode" id="organCode" style="width:200px" ></tag:autoSelect>
                    </td>
                    <td class="col-text">检查日期</td>
                    <td class="col-input">
                        <input type="text" class="layui-input x-admin-sm-date"  name="checkDateStart" id="checkDateStart" style="width: 80px;"> ~
                        <input type="text" class="layui-input x-admin-sm-date"  name="checkDateEnd" id="checkDateEnd" style="width: 80px;">
                    </td>
                </tr>
                <tr>
                    <td class="col-text">姓名</td>
                    <td class="col-input">
                        <input type="text" name="name" style="width:200px"/>
                    </td>
                    <td class="col-text">身份证号</td>
                    <td class="col-input">
                        <input type="text" name="idCard" style="width:180px"/>
                    </td>
                </tr>
                <tr>
                    <td colspan="6" class="righttd">
                        <button class="layui-btn layui-btn-sm" id="btnSearch"><i class="layui-icon">&#xe615;</i>查询</button>
                    </td>
                </tr>
                </tbody>
            </table>
            <table>
                <tr>
                    <td colspan="5" class="col-bottom"><span onclick="toggle(this,'searchTable')" class="ico-bottom">&nbsp;</span></td>
                </tr>
            </table>
        </form>
    </div>
    <div id="womanListDiv">
    </div>
</div>
<script type="text/javascript">
    layui.use('laydate', function(){
        var laydate = layui.laydate;
        //执行一个laydate实例
        laydate.render({
            elem: '#checkDateStart'
            ,format: 'yyyy/MM/dd'
            ,max:0
        });

        //执行一个laydate实例
        laydate.render({
            elem: '#checkDateEnd'
            ,format: 'yyyy/MM/dd'
            ,max:0
        });

    });
</script>