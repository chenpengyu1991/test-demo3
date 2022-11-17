<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<jsp:include page="../../../layouts/load-js-css-resources.jsp"></jsp:include>
<script src="${pageContext.request.contextPath}/js/views/ihm/ehrTarget/die.js" type="text/javascript"></script>
<div class="toolbar">
	<div class="x-nav">
      <span class="layui-breadcrumb">
        <a href="javascript:void(0)">综合管理</a>
        <a href="javascript:void(0)">健康档案</a>
        <a><cite>居民死因统计</cite></a>
      </span>
	</div>
</div>
<div class="section">
	<div class="searchbox searchSection x-admin-sm">
		<form id="dieTargetSearchForm">
			<table id="targetSearchDie">
                <colgroup>
                    <col style="width: 10%; min-width: 55px;"/>
                    <col style="width: 30%; min-width: 100px;"/>
                    <col style="width: 10%; min-width: 45px;"/>
                    <col style="width: 50%; min-width: 80px;"/>
                </colgroup>
				<tbody>
					<tr>
                    	<td class="col-text">统计类型</td>
                        <td class="col-input">
                        	<select name="genreCode" id="genreCode" style="width: 200px;">
									<option value="A100">按市级医院</option>
									<option value="B100">按卫生院</option>
									<option value="J100">市疾病预防控制中心</option>
                        	</select>
                        </td>
                        <td class="col-text" ><label id="orgLabelId">机构</label></td>
						<td class="col-input">
								<input type="hidden" id="gbCode" name="gbCode"/>
								<input type="hidden" id="superOrganCode" name="superOrganCode"/>
								<input type="hidden" id="organCode" name="organCode"/>
								<%--市级医院--%>
								<div id="byHospital">
									<ehr:org-type-list onchange="dieStatisticsSearch.changeOrgType()" id="organCode0" name="organCode0" type="hospital" subsid="0" value="${organCode}" code="${organCode}" width="200px;"/>
								</div>								
								<%--卫生院--%>					
								<div id="byCentre">
									<ehr:dic-town-centre-station centreId="centre1" townId="town1" centreName="superOrganCode1" townName="gbCode1" width="200px;" />
								</div>	
								<%--社区服务站--%>					
								<div id="byStation">
									<ehr:dic-town-centre-station centreId="centre2" townId="town2" stationId="station2" centreName="superOrganCode2" stationName="organCode2" townName="gbCode2" width="33%;" />
								</div>	
								<%--镇--%>					
								<div id="byTown">
									<ehr:dic-town-village townId="town3" townName="gbCode3" width="200px"/>
								</div>															
						</td>     

					</tr>
                    <c:if test="${empty timeRangeFlag}">
					<tr>
                        <td class="col-text">时间类型</td>
                        <td class="col-input">
                        	<select name="rangeType" id="rangeType" style="width: 200px;">
                        		<option value="1">按月</option>
                        		<option value="2">按季度</option>
                        		<option value="3">按年</option>
                        		<option value="4">按时间段</option>
							</select>
                        </td>
                        <td class="col-text">死亡时间</td>
						<td class="col-input">
							<input type="hidden" id="beginDate" name="beginDate"/>
							<input type="hidden" id="endDate" name="endDate"/>
		                    <div id="byMonth">
								<input type="text" class="layui-input x-admin-sm-date"  name="monthDate" id="beginDate1" style="width:33%;">
							</div>
							<div id="byQuarter">
								<input type="text" class="layui-input x-admin-sm-date"  name="quarterDate" id="beginDate2" style="width:33%;">
								<select name="rangeQuarter" id="rangeQuarter" style="width: 80px;">
                          			<option value="1">第一季度</option>
                          			<option value="2">第二季度</option>
                          			<option value="3">第三季度</option>
                          			<option value="4">第四季度</option>
                  				</select>								
							</div>
							<div id="byYear">
								<input type="text" class="layui-input x-admin-sm-date"  name="yearDate" id="beginDate3" style="width:33%;">
								<input type="radio" id="yearType1" name="yearType"  class="radioGroup" value="1" /><label for="yearType1">全年</label>
								<input type="radio" id="yearType2" name="yearType"  class="radioGroup" value="2" /><label for="yearType2">上半年</label>
								<input type="radio" id="yearType3" name="yearType"  class="radioGroup" value="3" /><label for="yearType3">下半年</label>
							</div>
							<div id="byRange">
								<input type="text" class="layui-input x-admin-sm-date"  name="beginDate4" id="beginDate4" style="width:33%;" value="<fmt:formatDate value='${currentBeginDate}' pattern='yyyy/MM/dd'/>"> ~
								<input type="text" class="layui-input x-admin-sm-date"  name="endDate4" id="endDate4" style="width:33%;" value="<fmt:formatDate value='${currentEndDate}' pattern='yyyy/MM/dd'/>">
							</div>
						</td>
					</tr>
                   </c:if>
					<tr>
						<td colspan="4" class="righttd">
							<button class="layui-btn layui-btn-sm" id="dieTargetBtnSearch"><i class="layui-icon">&#xe615;</i>查询</button>
						</td>
					</tr>
				</tbody>
			</table>
			<table>
				<tr>
					<td class="col-bottom">
						<span onclick="toggle(this,'targetSearchDie')" class="ico-bottom">&nbsp;</span>
					</td>   					
				</tr>
			</table>

		</form>
	</div>
	<div id="resultDiv">
		<jsp:include page="datagrid.jsp" ></jsp:include>
	</div>
</div>
<script type="text/javascript">
	layui.use('laydate', function(){
		var laydate = layui.laydate;
		//执行一个laydate实例
		laydate.render({
			elem: '#beginDate1',
			type:"month",
			format: 'yyyy/MM',
			max:0,
			value: new Date()
		});
		//执行一个laydate实例
		laydate.render({
			type:"year",
			elem: '#beginDate2', //指定元素
			max:0,
			value: new Date()
		});
		//执行一个laydate实例
		laydate.render({
			type:"year",
			elem: '#beginDate3',
			max:0,
			value: new Date()
		});
		//执行一个laydate实例
		laydate.render({
			elem: '#beginDate4'
			,format: 'yyyy/MM/dd'
			,max:0
		});

		//执行一个laydate实例
		laydate.render({
			elem: '#endDate4'
			,format: 'yyyy/MM/dd'
			,max:0
		});
	});
</script>