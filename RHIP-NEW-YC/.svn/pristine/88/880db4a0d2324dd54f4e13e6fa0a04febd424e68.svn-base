<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ page import="com.founder.rhip.ehr.common.RoleType" %>
<%@ page import="com.founder.rhip.ehr.common.EHRConstants" %>
<jsp:include page="../../layouts/load-js-css-resources.jsp"></jsp:include>

<c:set var="ADMIN" value="<%=RoleType.ADMIN.getValue()%>"/>
<c:set var="ZXLNR" value="<%=RoleType.ZXLNR.getValue()%>"/>
<c:set var="ZLNR" value="<%=RoleType.ZLNR.getValue()%>"/>
<c:set var="YYLNR" value="<%=RoleType.YYLNR.getValue()%>"/>
<c:set var="JKLNR" value="<%=RoleType.JKLNR.getValue()%>"/>
<c:set var="QWGZX" value="<%=RoleType.QWGZX.getValue()%>"/>

<script src="${pageContext.request.contextPath}/js/views/hm/progress/search.js" type="text/javascript"></script>

<div class="section">
    <div class="toolbar">
            <div class="x-nav">
		      <span class="layui-breadcrumb">
		        <a href="javascript:void(0)">老年人健康管理</a>
		        <a>
		          <cite>进度统计</cite></a>
		      </span>
		</div>

    </div>
    <div class="searchBox searchSection x-admin-sm">
        <form id="targetSearchForm">
            <table id="targetSearch">
                <colgroup>
					 	<col style="width: 10%; min-width: 70px;"/>
                        <col style="width: 15%; min-width: 140px;"/>
                        <col style="width: 10%; min-width: 70px;"/>
                        <col style="width: 35%; min-width: 180px;"/>
						<col style="width: 15%; min-width: 70px;"/>
					</colgroup>
                <tbody>
                <tr>
							<td class="col-text">统计类型</td>
	                        <td class="col-input">
	                        	<select name="genreCode" id="genreCode" style="width: 130px;" class="x-layui-input">
	                        		<option value="1">按机构</option>
	                        		<option value="2">按现地址</option>
	                        	</select>
	                        </td>
							<td class="col-text org_td">机构</td>
							<td class="col-input org_td"> 
								<ehr:authorize ifAnyGranted="${ADMIN},${QWGZX},${JKLNR}">
                           				 <ehr:dic-town-centre-station townName="townCode" centreName="centerCode" stationName="orgCode"
                                                        isShowOneself="true" style="width:130px;" cssClass="x-layui-input"/>
		                        </ehr:authorize>
		                        <ehr:authorize ifAnyGranted="${ZXLNR}">
		                            <ehr:dic-org-list name="orgCode" isShowOneself="true" width="30%;" cssClass="x-layui-input"/>
		                        </ehr:authorize>
		                        <ehr:authorize ifAnyGranted="${ZLNR}">
		                            <ehr:dic-org-list id="organCode" name="orgCode" width="30%;" cssClass="x-layui-input"/>
		                        </ehr:authorize>
							</td>
							<td class="col-text add_td">现地址</td>
							<td class="col-input add_td"> 
								<ehr:dic-town-street-village townName="patownShip" streetName="pastreet" width="30%" cssClass="x-layui-input"/>
							</td>
						</tr>
						<tr>
							<td class="col-text">时间类型</td>
	                        <td class="col-input">
	                        	<select name="rangeType" id="rangeType" style="width: 120px;" class="x-layui-input">
	                        		<option value="1">按月</option>
	                        		<option value="2">按季度</option>
	                        		<option value="3">按年</option>
	                        		<option value="4">按时间段</option>
								</select>
	                        </td>
	                        <td class="col-text">时间</td>
							<td class="col-input">
								<input type="hidden" id="beginTime" name="beginTime"/>
								<input type="hidden" id="endTime" name="endTime"/>
			                    <div id="byMonth">
	                        		<%-- <tag:dateInput name="monthDate" pattern="yyyy/MM" id="beginDate1" date="${currentBeginDate}" onlypast="true" style="width: 80px;"/> --%>
	                        		<input type="text" class="layui-input x-admin-sm-date"  name="monthDate" id="beginDate1" value="<fmt:formatDate value='${currentBeginDate}' pattern='yyyy/MM'/>"  style="width: 80px;padding-left: 0px;" />
								</div>
								<div id="byQuarter">
									<%-- <tag:dateInput name="quarterDate" pattern="yyyy" id="beginDate2" date="${currentBeginDate}" onlypast="true" style="width: 80px;"/> --%>
									<input type="text" class="layui-input x-admin-sm-date"  name="quarterDate" id="beginDate2" value="<fmt:formatDate value='${currentBeginDate}' pattern='yyyy'/>"  style="width: 80px;padding-left: 0px;" />
									<select name="rangeQuarter" id="rangeQuarter" style="width: 80px;" class="x-layui-input">
	                          			<option value="1">第一季度</option>
	                          			<option value="2">第二季度</option>
	                          			<option value="3">第三季度</option>
	                          			<option value="4">第四季度</option>
	                  				</select>
								</div>
								<div id="byYear">
									<%-- <tag:dateInput name="yearDate" pattern="yyyy" id="beginDate3" date="${currentBeginDate}" onlypast="true" style="width: 80px;"/> --%>
									<input type="text" class="layui-input x-admin-sm-date"  name="yearDate" id="beginDate3" value="<fmt:formatDate value='${currentBeginDate}' pattern='yyyy'/>"  style="width: 80px;padding-left: 0px;" />
									<c:if test="${empty fullYearFlag}"><input type="radio" id="yearType1" name="yearType"  class="radioGroup" value="1" /><label for="yearType1">全年</label></c:if>
									<c:if test="${empty firstHalfYearFlag}"><input type="radio" id="yearType2" name="yearType"  class="radioGroup" value="2" /><label for="yearType2">上半年</label></c:if>
									<c:if test="${empty secondHalfYearFlag}"><input type="radio" id="yearType3" name="yearType"  class="radioGroup" value="3" /><label for="yearType3">下半年</label></c:if>
								</div>
								<div id="byRange">
									<c:if test="${empty pattern}"><c:set var="patternFormat" value="yyyy/MM/dd"></c:set></c:if>
	                        		<c:if test="${not empty pattern}"><c:set var="patternFormat" value="${pattern}"></c:set></c:if>
									<%-- <tag:dateInput name="beginDate4" pattern="${patternFormat}" id="beginDate4" maxId="endDate4" date="${currentBeginDate}" onlypast="true" style="width: 80px;"/>~
									<tag:dateInput name="endDate4" pattern="${patternFormat}" id="endDate4" minId="beginDate4" date="${currentEndDate}" onlypast="true"  style="width: 80px;"/> --%>
									<input type="text" class="layui-input x-admin-sm-date"  name="beginDate4" id="beginDate4" style="width: 80px;padding-left: 0px;" value="<fmt:formatDate value='${currentBeginDate}' pattern='yyyy/MM/dd'/>"/> ~
                            		<input type="text" class="layui-input x-admin-sm-date"  name="endDate4" id="endDate4" style="width: 80px;padding-left: 0px;" value="<fmt:formatDate value='${currentEndDate}' pattern='yyyy/MM/dd'/>" />
								</div>
							</td>
							<td>
							<%-- <input type="button" id="btnSearch" value="查询"
								onclick="" class="search_btn" /> --%>
								<button class="layui-btn layui-btn-sm" id="btnSearch"><i class="layui-icon">&#xe615;</i>查询</button>
								</td>
						</tr>
                </tbody>
            </table>
            <table>
                <tr>
                    <td class="colbottom">
                        <span onclick="toggle(this,'targetSearch')" class="ico-bottom">&nbsp;</span>
                    </td>
                </tr>
            </table>
        </form>
    </div>
	<div class="toolbarSection">
		<a href="javascript:void(0)" id="progress-export-btn"><button class="layui-btn layui-btn-sm" ><i class="layui-icon">&#xe67d;</i>导出</button></a>
	</div>
    <div id="resultDiv">
    </div>
</div>

<div id="idmSymptomType_pop-chart-con"></div>

<script type="text/javascript">
    layui.use('laydate', function(){
        var laydate = layui.laydate;
        
        laydate.render({
          elem: '#beginDate1'
          ,type:'month'
       	   ,format: 'yyyy/MM'
       	   ,max:0
        });

        laydate.render({
            elem: '#beginDate2'
            ,type:'year'
         	   ,max:0
          });
        
        laydate.render({
            elem: '#beginDate3'
            	,type:'year'
         	   ,max:0
          });
        
        laydate.render({
            elem: '#beginDate4'
            	,format:'yyyy/MM/dd'
         	   ,max:0
          });
        
        laydate.render({
            elem: '#endDate4'
            	,format:'yyyy/MM/dd'
         	   ,max:0
          });
        
      });

    </script>
