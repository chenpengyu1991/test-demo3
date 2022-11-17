<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<jsp:include page="../../../../layouts/load-js-css-resources.jsp"></jsp:include>
<%--<script src="${pageContext.request.contextPath}/js/views/ihm/cwhTarget/child/searchChildCount.js" type="text/javascript"></script>--%>
<script src="${pageContext.request.contextPath}/js/views/ihm/ihmCommon.js" type="text/javascript"></script>

<div class="section">
    <div class="toolbar">
        <div class="toolbar">
            <div class="x-nav">
		        <span class="layui-breadcrumb">
                    <a href="javascript:void(0)">综合管理</a>
			    <a href="javascript:void(0)">妇幼保健</a>
			    <a><cite>孕产妇死亡监测</cite></a>
		        </span>
            </div>
        </div>
    </div>
    <div class="searchbox searchSection x-admin-sm" >
        <input type="hidden" id="pageIndex" value="${pageIndex}">
        <input type="hidden" id="searchUrl" value="${searchUrl}">
        <form id="targetSearchForm">
            <table id="targetSearch">
                <colgroup>
                    <col style="width: 10%; min-width: 80px;"/>
                    <col style="width: 20%; min-width: 120px;"/>
                    <col style="width: 8%; min-width: 60px;"/>
                    <col style="width: 52%; min-width: 260px;"/>
                    <col style="width: 10%; min-width: 100px;"/>
                </colgroup>
                <tbody>
                <tr>
                    <td class="col-text">机构</td>
                    <td>
                        <ehr:dic-town-village townName="gbCode" width="180px;" />
                        <input type="hidden" name="genreCode" value="0">
                    </td>
                    <td></td> <td></td>
                    <td rowspan="2">
                        <button class="layui-btn layui-btn-sm" id="targetBtnSearch" ><i class="layui-icon"></i>查询</button>
                    </td>
                </tr>
                <tr>
                    <td class="col-text">时间类型</td>
                    <td class="col-input">
                        <select name="rangeType" id="rangeType" style="width: 180px;">
                            <c:if test="${empty monthRangeFlag}"><option value="1">按月</option></c:if>
                            <c:if test="${empty quarterRangeFlag}"><option value="2">按季度</option></c:if>
                            <c:if test="${empty yearRangeFlag}"><option value="3">按年</option></c:if>
                           <!-- <c:if test="${empty rangeFlag}"><option value="4">按时间段</option></c:if> -->
                        </select>
                    </td>
                    <td class="col-text">时间</td>
                    <td class="col-input">
                        <input type="hidden" id="beginDate" name="beginDate"/>
                        <input type="hidden" id="endDate" name="endDate"/>
                        <div id="byMonth">
<%--                            <tag:dateInput name="monthDate" pattern="yyyy/MM" id="beginDate1" date="${currentBeginDate}" onlypast="true" style="width: 80px;"/>--%>
                            <input type="text" class="layui-input x-admin-content-sm-date"  name="monthDate" id="beginDate1" value="<fmt:formatDate value='${currentBeginDate}' pattern='yyyy/MM'/>"  style="padding-left: 0px;width: 180px" />

                        </div>
                        <div id="byQuarter">
<%--                            <tag:dateInput name="quarterDate" pattern="yyyy" id="beginDate2" date="${currentBeginDate}" onlypast="true" style="width: 80px;"/>--%>
                            <input type="text" class="layui-input x-admin-content-sm-date"  name="quarterDate" id="beginDate2" value="<fmt:formatDate value='${currentBeginDate}' pattern='yyyy'/>"  style="padding-left: 0px;width: 80px" />
                            <select name="rangeQuarter" id="rangeQuarter" style="width: 80px;">
                                <option value="1">第一季度</option>
                                <option value="2">第二季度</option>
                                <option value="3">第三季度</option>
                                <option value="4">第四季度</option>
                            </select>
                        </div>
                        <div id="byYear">
<%--                            <tag:dateInput name="yearDate" pattern="yyyy" id="beginDate3" date="${currentBeginDate}" onlypast="true" style="width: 80px;"/>--%>
                            <input type="text" class="layui-input x-admin-content-sm-date"  name="yearDate" id="beginDate3" value="<fmt:formatDate value='${currentBeginDate}' pattern='yyyy'/>"  style="padding-left: 0px;width: 80px" />
                            <c:if test="${empty fullYearFlag}"><input type="radio" id="yearType1" name="yearType"  class="radioGroup" value="1" /><label for="yearType1">全年</label></c:if>
                            <c:if test="${empty firstHalfYearFlag}"><input type="radio" id="yearType2" name="yearType"  class="radioGroup" value="2" /><label for="yearType2">上半年</label></c:if>
                            <c:if test="${empty secondHalfYearFlag}"><input type="radio" id="yearType3" name="yearType"  class="radioGroup" value="3" /><label for="yearType3">下半年</label></c:if>
                        </div>
                        <div id="byRange">
                            <c:if test="${empty pattern}"><c:set var="patternFormat" value="yyyy/MM/dd"></c:set></c:if>
                            <c:if test="${not empty pattern}"><c:set var="patternFormat" value="${pattern}"></c:set></c:if>
                            <tag:dateInput name="beginDate4" pattern="${patternFormat}" id="beginDate4" maxId="endDate4" date="${currentBeginDate}" onlypast="true" style="width: 80px;"/>~<tag:dateInput name="endDate4" pattern="${patternFormat}" id="endDate4" minId="beginDate4" date="${currentEndDate}" onlypast="true"  style="width: 80px;"/>
                        </div>
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
        <jsp:include page="maternalDeathList.jsp" ></jsp:include>
    </div>
</div>
<script type="text/javascript">

    layui.use('laydate', function(){
        var laydate = layui.laydate;

        laydate.render({
            elem: '#beginDate1'
            ,format: 'yyyy/MM'
            ,max:0
            ,type: 'month'
        });

        laydate.render({
            elem: '#beginDate2'
            ,format: 'yyyy'
            ,max:0
            ,type: 'year'
        });


        laydate.render({
            elem: '#beginDate3'
            ,format: 'yyyy'
            ,max:0
            ,type: 'year'
        });
    });
</script>