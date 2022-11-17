<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<jsp:include page="../../../layouts/load-js-css-resources.jsp"></jsp:include>

<script src="${pageContext.request.contextPath}/js/views/ihm/medicalTarget/hospitalBloodUseSearch.js" type="text/javascript"></script>

<div class="toolbar">
    	<div class="x-nav">
		      <span class="layui-breadcrumb">
		        <a href="javascript:void(0)">综合管理</a>
		        <a href="javascript:void(0)">医疗服务</a>
		        <a>
		          <cite>
		          用血信息
		          </cite>
		       </a>
		      </span>
		</div>
    </div>
<div class="section">
    <div class="searchbox searchSection x-admin-sm">
        <input type="hidden" id="pageIndex" value="${pageIndex}">
        <input type="hidden" id="searchUrl" value="${searchUrl}">
        <form id="searchForm">
            <table id="searchTable">
                <colgroup>
                    <col style="width: 12%; min-width: 200px;"/>
                    <col style="width: 15%; min-width: 100px;"/>
                    <col style="width: 10%; min-width: 70px;"/>
                    <col style="width: 15%; min-width: 100px;"/>
                    <col style="width: 10%; min-width: 70px;"/>
                    <col style="width: 13%; min-width: 100px;"/>
                    <col style="width: 10%; min-width: 70px;"/>
                    <col style="width: 15%; min-width: 100px;"/>
                </colgroup>
                <tbody>
                <tr>
                    <td class="col-text">姓名</td>
                    <td class="col-input">
                        <input type="text" name="name">
                    </td>
                    <td class="col-text">身份证号</td>
                    <td class="col-input">
                        <input type="text" name="idCard">
                    </td>
                    <td class="col-text">性别</td>
                    <td class="col-input">
                       <ehr:dic-list name="gender" dicmeta="GBT226112003"></ehr:dic-list>
                    </td>
                    <td class="col-text">年龄</td>
                    <td class="col-input">
                        <input type="text" name="age">
                    </td>
                </tr>
                <tr>
                    <td class="col-text">医疗机构名称</td>
                    <td class="col-input">
                        <input type="text" name="hospital">
                    </td>
                    <td class="col-text">输血时间</td>
                    <td class="col-input" colspan="4">
                        <%-- <tag:dateInput name="dateFrom"></tag:dateInput> ~<tag:dateInput name="dateTo"></tag:dateInput> --%>
                        <input type="text" class="layui-input x-admin-sm-date" name="dateFrom" id="dateFrom"
                               style="width: 80px;padding-left: 0px;"> ~
                       	<input type="text" class="layui-input x-admin-sm-date" name="dateTo" id="dateTo"
                               style="width: 80px;padding-left: 0px;">
                    </td>
                    <td style="text-align: left;">
                        <!-- <input type="button" id="btnSearch" value="查询" onclick="" class="search_btn" /> -->
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

<script type="text/javascript">
    layui.use('laydate', function () {
        var laydate = layui.laydate;

        laydate.render({
            elem: '#dateFrom'
            , format: 'yyyy/MM/dd'
            , max: 0
        });

        laydate.render({
            elem: '#dateTo'
            , format: 'yyyy/MM/dd'
            , max: 0
        });


    });

</script>