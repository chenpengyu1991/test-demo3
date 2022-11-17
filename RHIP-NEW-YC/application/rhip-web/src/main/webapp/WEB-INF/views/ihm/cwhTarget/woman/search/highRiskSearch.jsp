<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<jsp:include page="../../../../layouts/load-js-css-resources.jsp"></jsp:include>
<script src="${pageContext.request.contextPath}/js/views/ihm/cwhTarget/woman/search.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/ihm/cwhTarget/cwhCommon.js" type="text/javascript"></script>

<div class="toolbar">
    <div class="toolbar">
        <div class="x-nav">
		        <span class="layui-breadcrumb">
                    <a href="javascript:void(0)">综合管理</a>
			    <a href="javascript:void(0)">妇幼保健</a>
			    <a><cite>高危产妇管理</cite></a>
		        </span>
        </div>
    </div>
</div>
<div class="section">
    <div class="searchbox searchSection x-admin-sm">
        <input type="hidden" id="pageIndex" value="${pageIndex}">
        <input type="hidden" id="searchType" value="${searchType}">
        <form id="searchForm">
            <table id="searchTable">
                <colgroup>
                    <col style="width: 10%; min-width: 70px;"/>
                    <col style="width: 15%; min-width: 70px;"/>
                    <col style="width: 10%; min-width: 70px;"/>
                    <col style="width: 15%; min-width: 70px;"/>
                    <col style="width: 10%; min-width: 70px;"/>
                    <col style="width: 15%; min-width: 70px;"/>
                    <col/>
                </colgroup>
                <tbody>
                <tr>
                    <td class="col-text">姓名</td>
                    <td class="col-input">
                        <input type="text" name="name" >
                    </td>
                    <td class="col-text">身份证号</td>
                    <td class="col-input">
                        <input type="text" name="idCard" >
                    </td>
                    <td class="col-text">出生日期</td>
                    <td class="col-input">
<%--                        <tag:dateInput name="birthday" onlypast="true"></tag:dateInput>--%>
                        <input type="text" class="layui-input x-admin-sm-date"  name="birthday" id="birthday" style="width:180px;" value="<fmt:formatDate value='${currentBeginDate}' pattern='yyyy/MM/dd'/>">

                    </td>
                    <td></td>
                </tr>
                <tr>

                    <td colspan="5"></td>
                    <td></td>
                    <td style="text-align: right;">
<%--                        <input type="button" id="btnSearch" value="查询" onclick="" class="search_btn" />--%>
                        <button class="layui-btn layui-btn-sm" id="btnSearch"><i class="layui-icon">&#xe615;</i>查询</button>

                    </td>
                </tr>
                </tbody>
            </table>
            <table>
                <tr>
                    <td colspan="4" class="col-bottom"><span onclick="util.toggle(this,'searchTable')" class="ico-bottom">&nbsp;</span></td>
                </tr>
            </table>
        </form>
    </div>
    <div id="womanListDiv">
        <jsp:include page="${listpath}"></jsp:include>
    </div>
</div>
<script type="text/javascript">
    layui.use('laydate', function(){
        var laydate = layui.laydate;


        //执行一个laydate实例
        laydate.render({
            elem: '#birthday'
            ,format: 'yyyy/MM/dd'
            ,max:0
        });

    });
</script>