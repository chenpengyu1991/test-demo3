<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
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
<%--<script src="${pageContext.request.contextPath}/js/views/ihm/ihmCommon.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/require/require.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/require/requireMain.js" type="text/javascript"></script> --%>
<!-- <script type="text/javascript">
	require(['views/ihm/prescriptionTarget/prescriptionCost'],function(prescriptionCost){
		prescriptionCost.load();
	});
</script> -->
<script src="${pageContext.request.contextPath}/js/views/ihm/chartFun2.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/ihm/prescriptionTarget/prescriptionCost2.js" type="text/javascript"></script>
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
					<tr>
                    	<td class="col-text">统计类型</td>
                        <td class="col-input">
                        	<select name="genreCode" id="genreCode" style="width: 130px;">
                                <%--卫生局--%>
                                <ehr:authorize ifNotGranted="39,02,03">
                                    <c:if test="${empty gbFlag}">
                                        <option value="0">按镇</option>
                                    </c:if>
                                </ehr:authorize>
                                <%--卫生局,市级医院--%>
                                <ehr:authorize ifNotGranted="02,03">
                                    <c:if test="${empty hospitalFlag}">
                                        <option value="A100">按市级医院</option>
                                    </c:if>
                                </ehr:authorize>
                                <%--卫生局,卫生院--%>
                                <ehr:authorize ifNotGranted="02,39">
                                    <c:if test="${empty superOrganFlag}">
                                        <option value="B100">按卫生院</option>
                                    </c:if>
                                </ehr:authorize>
                                <%--卫生局,卫生院,社区服务中心--%>
                                <ehr:authorize ifNotGranted="39">
                                    <c:if test="${empty organFlag}">
                                        <option value="B200">按社区卫生服务站</option>
                                    </c:if>
                                </ehr:authorize>
                        	</select>
                        </td>
                        <td class="col-text">机构</td>
						<td class="col-input">
							<tag:autoSelect name="organCode" id="hospitalCode" codeValue="${reportUnitCode}" style="width:200px;" reg="{'required':'true'}"></tag:autoSelect>
							<%--&lt;%&ndash;卫生局角色&ndash;%&gt;
							<ehr:authorize ifNotGranted="39,02,03">	
								<input type="hidden" id="gbCode" name="gbCode"/>
								<input type="hidden" id="superOrganCode" name="superOrganCode"/>
								<input type="hidden" id="organCode" name="organCode"/>
								&lt;%&ndash;市级医院&ndash;%&gt;
								<div id="byHospital">
									<ehr:org-type-list id="organCode0" name="organCode0" type="hospital"  value="${organCode}" code="${organCode}" width="260px"/>
								</div>								
								&lt;%&ndash;卫生院&ndash;%&gt;
								<div id="byCentre">
									<ehr:dic-town-centre-station centreId="centre1" townId="town1" centreName="superOrganCode1" townName="gbCode1" width="220px;" />
								</div>	
								&lt;%&ndash;社区服务站&ndash;%&gt;
								<div id="byStation">
									<ehr:dic-town-centre-station centreId="centre2" townId="town2" stationId="station2" centreName="superOrganCode2" stationName="organCode2" townName="gbCode2" width="33%;" />
								</div>	
								&lt;%&ndash;镇&ndash;%&gt;
								<div id="byTown">
									<ehr:dic-town-village townId="town3" townName="gbCode3" width="180px"/>
								</div>															
							</ehr:authorize>
							&lt;%&ndash;市级医院角色&ndash;%&gt;
							<ehr:authorize ifAnyGranted="39">
								&lt;%&ndash;市级医院&ndash;%&gt;
								<div id="byHospital">
									<input type="hidden" name="organCode" value="${orgCode}"/>
									<ehr:org  code="${orgCode}"/>
								</div>
							</ehr:authorize>							
							&lt;%&ndash;卫生院角色&ndash;%&gt;
							<ehr:authorize ifAnyGranted="03">	
								&lt;%&ndash;卫生院&ndash;%&gt;
								<div id="byCentre">
									<input type="hidden" name="superOrganCode" value="${orgCode}"/>
									<ehr:org  code="${orgCode}"/>
								</div>	
								&lt;%&ndash;社区服务站&ndash;%&gt;
								<div id="byStation">
									<ehr:dic-org-list name="organCode" width="130px;"/>
								</div>	
							</ehr:authorize>
							&lt;%&ndash;社区服务站角色&ndash;%&gt;
							<ehr:authorize ifAnyGranted="02">	
								&lt;%&ndash;社区服务站&ndash;%&gt;
								<div id="byStation">
									<input type="hidden" name="organCode" value="${orgCode}"/>
									<ehr:org  code="${orgCode}"/>
								</div>	
							</ehr:authorize>	--%>
						</td>
						<td rowspan="2">
							<button class="layui-btn layui-btn-sm"  id="btnSearch"><i class="layui-icon">&#xe615;</i>查询</button>
						</td>
					</tr>
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
                        		<input type="text" class="layui-input x-admin-sm-date" name="monthDate" id="beginDate1" value="<fmt:formatDate value='${currentBeginDate}' pattern="yyyy/MM"></fmt:formatDate>"
                               style="width: 80px;padding-left: 0px;">
							</div>	
							<div id="byQuarter">
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
	<input type="hidden" id="orgCodes">
	<div id="resultDiv" style="height:450px;padding-bottom: 10px;">

	</div>
	<div id="nodata" class="callout callout-info lead" style="display: none">
		<h3>暂无数据</h3>
	</div>
</div>
<div id="prescriptionDetailDiv"></div>

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