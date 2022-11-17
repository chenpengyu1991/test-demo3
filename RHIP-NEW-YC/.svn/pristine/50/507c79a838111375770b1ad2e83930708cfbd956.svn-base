<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<jsp:include page="../../layouts/load-js-css-resources.jsp"></jsp:include>
<style>

	/*
     * Component: Callout
     * ------------------
     */
	.callout {
		border-radius: 3px;
		margin: 0 0 20px 0;
		padding: 15px 30px 15px 15px;
		border-left: 5px solid #eee;
	}
	.callout a {
		color: #fff;
		text-decoration: underline;
	}
	.callout a:hover {
		color: #eee;
	}
	.callout h4 {
		margin-top: 0;
		font-weight: 600;
	}
	.callout p:last-child {
		margin-bottom: 0;
	}
	.callout code {
		background-color: #fff;
	}
	.callout.callout-info {
		border-color: #0097bc;
	}
	.callout.callout-info{
		color: #fff !important;
	}
	.callout.callout-info{
		background-color: #00c0ef !important;
	}
	.lead {
		margin-bottom: 20px;
		font-size: 16.099999999999998px;
		font-weight: 200;
		line-height: 1.4;
	}

	@media (min-width: 768px) {
		.lead {
			font-size: 21px;
		}
	}
	h3{
		font-family: "Helvetica Neue", Helvetica, Arial, sans-serif;
		font-weight: 500;
		line-height: 1.1;
		margin-top: 10px;
		margin-bottom: 10px;
		font-size: 18px;
		display: block;
		-webkit-margin-before: 1.33em;
		-webkit-margin-after: 1.33em;
		-webkit-margin-start: 0px;
		-webkit-margin-end: 0px;
		font-weight: bold;
	}
</style>
<script src="${pageContext.request.contextPath}/js/views/ihm/ihmCommon.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/ihm/chartFun2.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/ihm/diagnosisTarget/search2.js" type="text/javascript"></script>
<%-- <script src="${pageContext.request.contextPath}/js/require/require.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/require/requireMain.js" type="text/javascript"></script>
<script type="text/javascript">
	require(['views/ihm/diagnosisTarget/search'],function(diagnosisSearch){
		diagnosisSearch.load();
	});
</script> --%>
	<div class="toolbar">
	    	<div class="x-nav">
			      <span class="layui-breadcrumb">
			        <a href="javascript:void(0)">综合管理</a>
			        <a>
			          <cite>
			           疾病排名
			          </cite></a>
			      </span>
			</div>
	    </div>

<div class="section" id="top_all">
	<div class="searchbox searchSection x-admin-sm">
		<form id="targetSearchForm">
			<table id="targetSearch">
                <colgroup>
                    <col style="width: 8%; min-width: 55px;"/>
                    <col style="width: 18%; min-width: 100px;"/>
                    <col style="width: 6%; min-width: 45px;"/>
                    <col/>
                    <col style="width: 11%; min-width: 80px;"/>
                </colgroup>
				<tbody>
                    <c:if test="${empty timeRangeFlag}">
					<tr>
                        <td class="col-text">时间类型</td>
                        <td class="col-input">
                        	<select name="rangeType" id="rangeType" style="width: 120px;">
                        		<c:if test="${empty monthRangeFlag}"><option value="1">按月</option></c:if>
                        		<c:if test="${empty quarterRangeFlag}"><option value="2">按季度</option></c:if>
                        		<c:if test="${empty yearRangeFlag}"><option value="3">按年</option></c:if>
                        		<c:if test="${empty rangeFlag}"><option value="4">按时间段</option></c:if>
							</select>
                        </td>
                        <td class="col-text">时间</td>
						<td class="col-input">
							<input type="hidden" id="beginDate" name="beginDate"/>
							<input type="hidden" id="endDate" name="endDate"/>
		                    <div id="byMonth">
                        		<%-- <tag:dateInput name="monthDate" pattern="yyyy/MM" id="beginDate1" date="${currentBeginDate}" onlypast="true" style="width: 80px;"/> --%>
                        		<input type="text" class="layui-input x-admin-sm-date" name="monthDate" id="beginDate1" value="<fmt:formatDate value='${currentBeginDate}' pattern="yyyy/MM"></fmt:formatDate>"
                               style="width: 80px;padding-left: 0px;">
							</div>	
							<div id="byQuarter">
								<%-- <tag:dateInput name="quarterDate" pattern="yyyy" id="beginDate2" date="${currentBeginDate}" onlypast="true" style="width: 80px;"/> --%>
								<input type="text" class="layui-input x-admin-sm-date" name="quarterDate" id="beginDate2" value="<fmt:formatDate value='${currentBeginDate}' pattern="yyyy"></fmt:formatDate>"
                               style="width: 80px;padding-left: 0px;">
								<select name="rangeQuarter" id="rangeQuarter" style="width: 80px;">
                          			<option value="1">第一季度</option>
                          			<option value="2">第二季度</option>
                          			<option value="3">第三季度</option>
                          			<option value="4">第四季度</option>
                  				</select>								
							</div>
							<div id="byYear">
								<%-- <tag:dateInput name="yearDate" pattern="yyyy" id="beginDate3" date="${currentBeginDate}" onlypast="true" style="width: 80px;"/> --%>
								<input type="text" class="layui-input x-admin-sm-date" name="yearDate" id="beginDate3" value="<fmt:formatDate value='${currentBeginDate}' pattern="yyyy"></fmt:formatDate>"
                               style="width: 80px;padding-left: 0px;">
								<c:if test="${empty fullYearFlag}"><input type="radio" id="yearType1" name="yearType"  class="radioGroup" value="1" /><label for="yearType1">全年</label></c:if>
								<c:if test="${empty firstHalfYearFlag}"><input type="radio" id="yearType2" name="yearType"  class="radioGroup" value="2" /><label for="yearType2">上半年</label></c:if>
								<c:if test="${empty secondHalfYearFlag}"><input type="radio" id="yearType3" name="yearType"  class="radioGroup" value="3" /><label for="yearType3">下半年</label></c:if>
							</div>
							<div id="byRange">
								<c:if test="${empty pattern}"><c:set var="patternFormat" value="yyyy/MM/dd"></c:set></c:if>
                        		<c:if test="${not empty pattern}"><c:set var="patternFormat" value="${pattern}"></c:set></c:if>
								<%-- <tag:dateInput name="beginDate4" pattern="${patternFormat}" id="beginDate4" maxId="endDate4" date="${currentBeginDate}" onlypast="true" style="width: 80px;"/>~<tag:dateInput name="endDate4" pattern="${patternFormat}" id="endDate4" minId="beginDate4" date="${currentEndDate}" onlypast="true"  style="width: 80px;"/> --%>
								<input type="text" class="layui-input x-admin-sm-date" name="beginDate4" id="beginDate4" value="<fmt:formatDate value='${currentBeginDate}' pattern="yyyy/MM/dd"></fmt:formatDate>"
                               style="width: 80px;padding-left: 0px;"> ~
                        	   <input type="text" class="layui-input x-admin-sm-date" name="endDate4" id="endDate4" value="<fmt:formatDate value='${currentEndDate}' pattern="yyyy/MM/dd"></fmt:formatDate>"
                               style="width: 80px;padding-left: 0px;">
							</div>
						</td>
						<td>
							<!-- <input type="button" id="btnSearch" value="查询" onclick="" class="search_btn" /> -->
							<button class="layui-btn layui-btn-sm"  id="btnSearch"><i class="layui-icon">&#xe615;</i>查询</button>
						</td>
					</tr>
                   </c:if>
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
	<div id="resultDiv" style="height:450px;padding:10px 20px 10px 20px;">

	</div>
	<div id="nodata" class="callout callout-info lead" style="display: none">
		<h3>暂无数据</h3>
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

        
        laydate.render({
            elem: '#beginDate4'
            , format: 'yyyy/MM/dd'
            , max: 0
            , trigger: 'click' 
        });
        
        
        laydate.render({
            elem: '#endDate4'
            , format: 'yyyy/MM/dd'
            , max: 0
            , trigger: 'click' 
        });


    });

</script>