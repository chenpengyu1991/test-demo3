<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<jsp:include page="../../layouts/load-js-css-resources.jsp"></jsp:include>

<script src="${pageContext.request.contextPath}/js/views/ihm/firstAid/search.js" type="text/javascript"></script>
<div class="toolbar">
    <div class="x-nav">
		      <span class="layui-breadcrumb">
		        <a href="javascript:void(0)">综合管理</a>
		        <a href="javascript:void(0)">急救资源</a>
		        <a>
		          <cite>
                      接受事件
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
                    <col style="width: 10%; min-width: 30px;"/>
                    <col style="width: 20%; min-width: 30px;"/>
                    <col style="width: 10%; min-width: 30px;"/>
                    <col style="width: 20%; min-width: 30px;"/>
                    <col style="width: 10%; min-width: 30px;"/>
                    <col style="width: 20%; min-width: 30px;"/>
                    <col/>
                </colgroup>
                <tbody>
                <tr>
                    <td class="col-text">受理人</td>
                    <td class="col-input">
                        <input type="text" name="assignee" style="width: 180px;">
                    </td>
                    <td class="col-text">受理类型</td>
                    <td class="col-input">
                       <select name="acceptType" id="acceptType" style="width: 180px;" class="x-layui-input">

                           <option value="">请选择</option>
                           <option value="催车">催车</option>
                           <option value="增援挂起">增援挂起</option>
                           <option value="正常挂起">正常挂起</option>
                           <option value="现场反馈">现场反馈</option>
                           <option value="正常派车">正常派车</option>
                           <option value="增援派车">增援派车</option>
                           <option value="事件记录">事件记录</option>
                           <option value="唤醒待派">唤醒待派</option>
                           <option value="撤销待派">撤销待派</option>
                           <option value="欲派无车">欲派无车</option>
                       </select>
                    </td>
                    <td class="col-text">患者姓名</td>
                    <td class="col-input">
                        <input type="text" name="patName" style="width: 180px;">
                    </td>

                    <td></td>
                </tr>
                <tr>
                    <td class="col-text">受理日期</td>
                    <td class="col-input" colspan="3">
<%--                        <tag:dateInput name="beginTime" pattern="yyyy/MM/dd" style="width:125px;"></tag:dateInput> ~--%>
<%--                        <tag:dateInput name="endTime" pattern="yyyy/MM/dd" style="width:125px;"></tag:dateInput>--%>
                        <input type="text" class="layui-input x-admin-sm-date" name="beginTime" id="beginTime"
                               style="width: 80px;padding-left: 0px;"> ~
                        <input type="text" class="layui-input x-admin-sm-date" name="endTime" id="endTime"
                               style="width: 80px;padding-left: 0px;">
                    </td>
                    <td class="col-text">呼救电话</td>
                    <td class="col-input">
                        <input type="text" name="fromCall" style="width: 180px;">
                    </td>
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
<script type="text/javascript">
    layui.use('laydate', function () {
        var laydate = layui.laydate;

        laydate.render({
            elem: '#beginTime'
            , format: 'yyyy/MM/dd'
            , max: 0
        });

        laydate.render({
            elem: '#endTime'
            , format: 'yyyy/MM/dd'
            , max: 0
        });


    });

</script>