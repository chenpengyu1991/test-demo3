<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<script src="${pageContext.request.contextPath}/js/views/ihm/cwhTarget/child/trend/index.js" type="text/javascript"></script>
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
<script src="${pageContext.request.contextPath}/js/require/require.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/require/requireMain.js" type="text/javascript"></script>
<script type="text/javascript">
    require(['views/ihm/cwhTarget/child/trend/index'],function(trendIndex){
        trendIndex.load();
    });
</script>
<div class="section" id="top_all">
	<div class="searchBox">
		<form id="searchForm">
            <%--按年--%>
            <input type="hidden" name="rangeType" value="3"/>
            <%--全年--%>
            <input type="hidden" name="yearType" value="1"/>
            <table id="searchTable">
                <colgroup>
                    <col style="width: 15%; min-width: 80px;"/>
                    <col style="width: 35%; min-width: 150px;"/>
                    <col style="width: 15%; min-width: 80px;"/>
                    <col style="width: 35%; min-width: 150px;"/>
                    <col/>
                </colgroup>
                <tbody>
                <tr>
                    <td class="col-text"><label class="required">统计年度</label></td>
                    <td class="col-input">
                        <tag:dateInput name="yearDate" onlypast="true" pattern="yyyy"  date="${currentYear}" reg='{"required":"true"}'></tag:dateInput>
                    </td>
                    <td></td>
                    <td style="text-align: right;">
                        <input type="button" id="btnSearch" value="查询" onclick="" class="search_btn" />
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
    <div id="childChartDiv" style="height:450px;padding:10px 20px 10px 20px;">

    </div>
    <div id="nodata" class="callout callout-info lead" style="display: none">
        <h3>暂无数据</h3>
    </div>
</div>
<div id="trendDetailDiv"></div>