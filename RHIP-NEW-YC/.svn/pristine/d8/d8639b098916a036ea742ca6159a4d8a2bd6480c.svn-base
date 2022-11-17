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
           <a><cite>儿童死亡监测</cite></a>
        </span>
        </div>
    </div>
    <div class="searchbox searchSection x-admin-sm">
        <input type="hidden" id="pageIndex" value="${pageIndex}">
        <input type="hidden" id="searchUrl" value="${searchUrl}">
        <form id="targetSearchForm">
            <table id="targetSearch">
                <colgroup>
                    <col style="width: 10%; min-width: 80px;"/>
                    <col style="width: 20%; min-width: 120px;"/>
                    <col style="width: 10%; min-width: 80px;"/>
                    <col style="width: 20%; min-width: 120px;"/>
                    <col style="width: 10%; min-width: 80px;"/>
                    <col style="width: 30%; min-width: 120px;"/>
                </colgroup>
                <tbody>
                <tr>
                    <td class="col-text">镇</td>
                    <td>
                        <ehr:dic-town-village townName="gbCode" />
                        <input type="hidden" name="genreCode" value="0">
                    </td>
                    <td class="col-text">时间类型</td>
                    <td class="col-input">
                        <select name="rangeType" id="rangeType" >
                            <c:if test="${empty monthRangeFlag}"><option value="1">按月</option></c:if>
                            <c:if test="${empty quarterRangeFlag}"><option value="2">按季度</option></c:if>
                            <c:if test="${empty yearRangeFlag}"><option value="3"  <c:if test="${not empty yearRange}">selected</c:if>>按年</option></c:if>
                        </select>
                    </td>
                    <td class="col-text">时间</td>
                    <td class="col-input">
                        <input type="hidden" id="beginDate" name="beginDate"/>
                        <input type="hidden" id="endDate" name="endDate"/>
                        <div id="byMonth">
                            <input type="text" class="layui-input x-admin-sm-date" name="monthDate" id="beginDate1" value="<fmt:formatDate value='${currentBeginDate}' pattern="yyyy/MM"></fmt:formatDate>"
                                   style="width: 120px;padding-left: 0px;">
                        </div>
                        <div id="byQuarter">
                            <input type="text" class="layui-input x-admin-sm-date" name="quarterDate" id="beginDate2" value="<fmt:formatDate value='${currentBeginDate}' pattern="yyyy"></fmt:formatDate>"
                                   style="width: 120px;padding-left: 0px;">
                            <select name="rangeQuarter" id="rangeQuarter" style="width: 100px;">
                                <option value="1">第一季度</option>
                                <option value="2">第二季度</option>
                                <option value="3">第三季度</option>
                                <option value="4">第四季度</option>
                            </select>
                        </div>
                        <div id="byYear">
                            <input type="text" class="layui-input x-admin-sm-date" name="yearDate" id="beginDate3" value="<fmt:formatDate value='${currentBeginDate}' pattern="yyyy"></fmt:formatDate>"
                                   style="width: 120px;padding-left: 0px;">
                            <c:if test="${empty fullYearFlag}"><input type="radio" id="yearType1" name="yearType"  class="radioGroup" value="1" /><label for="yearType1">全年</label></c:if>
                            <c:if test="${empty firstHalfYearFlag}"><input type="radio" id="yearType2" name="yearType"  class="radioGroup" value="2" /><label for="yearType2">上半年</label></c:if>
                            <c:if test="${empty secondHalfYearFlag}"><input type="radio" id="yearType3" name="yearType"  class="radioGroup" value="3" /><label for="yearType3">下半年</label></c:if>
                        </div>
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
                        <span onclick="util.toggle(this,'targetSearch')" class="ico-bottom">&nbsp;</span>
                    </td>
                </tr>
            </table>

        </form>
    </div>
    <div id="resultDiv">
        <jsp:include page="deathList.jsp" ></jsp:include>
    </div>
</div>
<script type="text/javascript">
    layui.use('laydate', function () {
        var laydate = layui.laydate;

        laydate.render({
            elem: '#beginDate1'
            ,type:'month'
            , format: 'yyyy/MM'
            , max: 0
            , trigger: 'click'
        });

        laydate.render({
            elem: '#beginDate2'
            ,type:'year'
            , format: 'yyyy'
            , max: 0
            , trigger: 'click'
        });

        laydate.render({
            elem: '#beginDate3'
            ,type: 'year'
            , format: 'yyyy'
            , max: 0
            , trigger: 'click'
        });
    });
</script>