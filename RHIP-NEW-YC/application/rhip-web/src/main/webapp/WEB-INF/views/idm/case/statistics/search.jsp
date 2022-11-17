<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ page import="com.founder.rhip.ehr.common.RoleType"%>
<jsp:include page="../../../layouts/load-js-css-resources.jsp"></jsp:include>

<c:set var="ADMIN" value="<%=RoleType.ADMIN.getValue()%>"/>
<c:set var="JKFYK" value="<%=RoleType.JKFYK.getValue()%>"/>
<c:set var="ZXCRB" value="<%=RoleType.ZXCRB.getValue()%>"/>
<c:set var="ZCRB" value="<%=RoleType.ZCRB.getValue()%>"/>
<c:set var="YYCRB" value="<%=RoleType.YYCRB.getValue()%>"/>

<script src="${pageContext.request.contextPath}/js/views/idm/case/statistics/search.js" type="text/javascript"></script>

<div class="section">
	<div class="searchBox searchSection x-admin-sm">
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
                                <%--卫生局,疾控慢病科--%>
                               <%--  <ehr:authorize ifAnyGranted="${ADMIN},${JKFYK}">
                                    <c:if test="${empty gbFlag}">
                                        <option value="0">按镇</option>
                                    </c:if>
                                </ehr:authorize> --%>
                                <%--卫生局,市级医院--%>
								<ehr:authorize ifAnyGranted="${ADMIN},${YYCRB},${JKFYK}">
									<option value="A100">按市级医院</option>
									<%-- <c:if test="${empty hospitalFlag && empty elderlyPhysicalExam}">
										<option value="A100">按市级医院</option>
									</c:if> --%>
								</ehr:authorize>
								<%--卫生局,卫生院,疾控慢病科--%>
	                          	<ehr:authorize ifAnyGranted="${ADMIN},${JKFYK}">
									<c:if test="${empty superOrganFlag}">
										<option value="B100">按中心</option>
									</c:if>
								</ehr:authorize>
								<%--卫生局,卫生院,社区服务中心--%>
								<ehr:authorize ifAnyGranted="${ADMIN},${ZCRB},${ZXCRB},${JKFYK}">
										<option value="B200">按社区卫生服务站</option>
								</ehr:authorize>
	                          	<%-- <ehr:authorize ifAnyGranted="${ADMIN},${ZCRB},${ZXCRB}">
									<c:if test="${empty organFlag && empty elderlyPhysicalExam}">
										<option value="B200">按社区卫生服务站</option>
									</c:if>
								</ehr:authorize> --%>
                        	</select>
                        </td>
                        <td class="col-text">机构</td>
						<td class="col-input">
							<%--卫生局角色,老年人健康管理疾控慢病科--%>
							<ehr:authorize ifAnyGranted="${ADMIN},${JKFYK}">
								<input type="hidden" id="gbCode" name="gbCode"/>
								<input type="hidden" id="superOrganCode" name="superOrganCode"/>
								<input type="hidden" id="organCode" name="organCode"/>
								<%--市级医院--%>
								<%-- <div id="byHospital">
									<ehr:org-type-list id="organCode0" name="organCode0" type="hospital" subsid="0" value="${organCode}" code="${organCode}" width="260px" />
								</div> --%>
								<div id="byHospital">
									<ehr:org-type-list id="organCode0" name="organCode0" type="hospital" subsid="0" value="${organCode}" code="${organCode}" width="260px" />
								</div>
								<!-- 卫生院 -->
								<div id="byCentre">
									<ehr:dic-town-centre-station  isAdministration="true" centreId="centre1" townId="town1" centreName="superOrganCode1" townName="gbCode1" width="220px;"/>
								</div>
								<%--社区服务站--%>
								<div id="byStation">
									<ehr:dic-town-centre-station  isAdministration="true" centreId="centre2" townId="town2" stationId="station2" centreName="superOrganCode2" stationName="organCode2" townName="gbCode2"  width="33%;"/>
								</div>
								<%--镇--%>
								<%-- <div id="byTown">
									<ehr:dic-town-village townId="town3" townName="gbCode3" width="180px"  />
								</div> --%>
							</ehr:authorize>
							<%--市级医院角色--%>
							<ehr:authorize ifAnyGranted="${YYCRB}">
								<%--市级医院--%>
								<div id="byHospital">
									<%-- <input type="hidden" name="organCode" value="${orgCode}"/> --%>
									<input type="hidden" name="organCode" value="${orgCode}"/>
									<ehr:org  code="${orgCode}"/>
								</div>
							</ehr:authorize>
							<%--卫生院角色--%>
							<ehr:authorize ifAnyGranted="${ZXCRB}">
								<%--卫生院--%>
								<div id="byCentre">
									<input type="hidden" name="superOrganCode" value="${orgCode}"/>
									<ehr:org  code="${orgCode}"/>
								</div>
								<%--社区服务站--%>
								<div id="byStation">
									<ehr:dic-org-list name="organCode" width="130px;"/>
								</div>
							</ehr:authorize>
							<%--社区服务站角色--%>
							<ehr:authorize ifAnyGranted="${ZCRB}">
								<%--社区服务站--%>
								<div id="byStation">
									<input type="hidden" name="organCode" value="${orgCode}"/>
									<ehr:org  code="${orgCode}"/>
								</div>
							</ehr:authorize>
						</td>
						<c:choose>
							 <c:when test="${opEmHpMarkFlag eq 1}">
							 	<td rowspan="3">
									<%-- <input type="button" id="targetBtnSearch" value="查询" onclick="" class="search_btn" /> --%>
									<button class="layui-btn layui-btn-sm" id="targetBtnSearch"><i class="layui-icon">&#xe615;</i>查询</button>
								</td>
							 </c:when>
							 <c:otherwise>
							 	<td rowspan="2">
									<%-- <input type="button" id="targetBtnSearch" value="查询" onclick="" class="search_btn" /> --%>
									<button class="layui-btn layui-btn-sm" id="targetBtnSearch"><i class="layui-icon">&#xe615;</i>查询</button>
								</td>
							 </c:otherwise>
						</c:choose>
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
                        		<%-- <tag:dateInput name="monthDate" pattern="yyyy/MM" id="beginDate1" date="${currentBeginDate}" onlypast="true" style="width: 80px;"/> --%>
                        		<input type="text" class="layui-input x-admin-sm-date" style="width:80px;padding-left: 0px;" placeholder="选择月份" name="monthDate" id="beginDate1" value="<fmt:formatDate value='${currentBeginDate}' pattern='yyyy/MM'/>" />
							</div>
							<div id="byQuarter">
								<%-- <tag:dateInput name="quarterDate" pattern="yyyy" id="beginDate2" date="${currentBeginDate}" onlypast="true" style="width: 80px;"/> --%>
								<input type="text" class="layui-input x-admin-sm-date" style="width:80px;padding-left: 0px;" placeholder="选择年份" name="quarterDate" id="beginDate2" value="<fmt:formatDate value='${currentBeginDate}' pattern='yyyy'/>" />
								<select name="rangeQuarter" id="rangeQuarter" style="width: 80px;">
                          			<option value="1">第一季度</option>
                          			<option value="2">第二季度</option>
                          			<option value="3">第三季度</option>
                          			<option value="4">第四季度</option>
                  				</select>
							</div>
							<div id="byYear">
								<%-- <tag:dateInput name="yearDate" pattern="yyyy" id="beginDate3" date="${currentBeginDate}" onlypast="true" style="width: 80px;"/> --%>
								<input type="text" class="layui-input x-admin-sm-date" style="width:80px;padding-left: 0px;" placeholder="选择年份" name="yearDate" id="beginDate3" value="<fmt:formatDate value='${currentBeginDate}' pattern='yyyy'/>" />
								<c:if test="${empty fullYearFlag}"><input type="radio" id="yearType1" name="yearType"  class="radioGroup" value="1" /><label for="yearType1">全年</label></c:if>
								<c:if test="${empty firstHalfYearFlag}"><input type="radio" id="yearType2" name="yearType"  class="radioGroup" value="2" /><label for="yearType2">上半年</label></c:if>
								<c:if test="${empty secondHalfYearFlag}"><input type="radio" id="yearType3" name="yearType"  class="radioGroup" value="3" /><label for="yearType3">下半年</label></c:if>
							</div>
							<div id="byRange">
								<c:if test="${empty pattern}"><c:set var="patternFormat" value="yyyy/MM/dd"></c:set></c:if>
                        		<c:if test="${not empty pattern}"><c:set var="patternFormat" value="${pattern}"></c:set></c:if>
								<%-- <tag:dateInput name="beginDate4" pattern="${patternFormat}" id="beginDate4" maxId="endDate4" date="${currentBeginDate}" onlypast="true" style="width: 80px;"/>~<tag:dateInput name="endDate4" pattern="${patternFormat}" id="endDate4" minId="beginDate4" date="${currentEndDate}" onlypast="true"  style="width: 80px;"/> --%>
							   <input type="text" class="layui-input x-admin-sm-date"  placeholder="管理开始时间" name="beginDate4" id="beginDate4" value="<fmt:formatDate value='${currentBeginDate}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;width: 80px;"/> ~
                               <input type="text" class="layui-input x-admin-sm-date"  placeholder="管理结束时间" name="endDate4" id="endDate4" value="<fmt:formatDate value='${currentEndDate}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;width: 80px;"/>
					   		
							</div>
						</td>
					</tr>
                   </c:if>
                   <c:if test="${opEmHpMarkFlag eq 1}">
                   		<tr>
                   			<td class="col-text">费用来源</td>
                   			<td class="col-input">
		                   		<input type="radio" id="opEmHpMark0" name="opEmHpMark"  class="radioGroup" value="" checked="checked"/><label for="opEmHpMark0">全部</label>
		                   		<input type="radio" id="opEmHpMark1" name="opEmHpMark"  class="radioGroup" value="1" /><label for="opEmHpMark1">门诊</label>
		                   		<input type="radio" id="opEmHpMark2" name="opEmHpMark"  class="radioGroup" value="2" /><label for="opEmHpMark2">急诊</label>
		                   		<input type="radio" id="opEmHpMark3" name="opEmHpMark"  class="radioGroup" value="3" /><label for="opEmHpMark3">住院</label>
	                   		</td>
                   		</tr>
                   </c:if>
				</tbody>
			</table>
			<table>
				<tr>
					<td class="col-bottom">
						<span onclick="toggle(this,'targetSearch')" class="ico-bottom">&nbsp;</span>
					</td>
				</tr>
			</table>

		</form>
	</div>
	<div id="resultDiv">
	</div>
</div>

<div id="idmSymptomType_pop-chart-con" style="width: 800px;height:400px"></div>

















<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<script src="${pageContext.request.contextPath}/js/views/hm/progress/search.js" type="text/javascript"></script>

<div class="section">
		<div class="searchBox">
			<form id="progressSearchForm">
				<table id="progressSearch">
					<colgroup>
					 	<col style="width: 10%; min-width: 70px;"/>
                        <col style="width: 20%; min-width: 140px;"/>
                        <col style="width: 10%; min-width: 70px;"/>
                        <col style="width: 30%; min-width: 180px;"/>
						<col style="width: 10%; min-width: 70px;"/>
					</colgroup>
					<tbody>
						<tr>
							<td class="col-text">时间</td>
							<td class="col-input">
								<tag:dateInput id="startDate" name="startDate" style="width: 120px;"/>~
                        		<tag:dateInput  id="endDate" name="endDate" style="width: 120px;" /></td>
							<td class="col-text">机构</td>
							<td class="col-input">
								<ehr:authorize ifAnyGranted="${ADMIN}">
									<ehr:dic-town-centre-station centreName="inputSuperOrganCode" stationName="inputOrganCode" townName="gbcode" width="130px;" />
								</ehr:authorize>
								<ehr:authorize ifAnyGranted="${ZCRB},${ZXCRB}">
								<ehr:dic-org-list name="inputOrganCode" width="150px"/>
								</ehr:authorize>
							</td>
							<td style="text-align: right;"><input type="button" id="progressBtnSearch" value="查询"
								onclick="" class="search_btn" /></td>
						</tr>
					</tbody>
				</table>
				<table>
					<tr>
						<td colspan="4" class="col-bottom"><span
							onclick="hmProgressSearch.toggle(this,'progressSearch')"
							class="ico-bottom">&nbsp;</span></td>
					</tr>
				</table>

			</form>
		</div>

		<div id="progressResultDiv">
		</div>
</div> --%>

 <script type="text/javascript">
    layui.use('laydate', function() {
        var laydate = layui.laydate;
        
        laydate.render({
          elem: '#beginDate1'
          ,type:'month'
       	   ,format: 'yyyy/MM'
       	   ,max:0
        });

        laydate.render({
          elem: '#beginDate2'
           ,type: 'year'
        	   ,max:0
        });
        
       
        laydate.render({
            elem: '#beginDate3' 
            	 ,type: 'year'
         	   ,max:0
          });
        
        laydate.render({
            elem: '#beginDate4' 
         	   ,format: 'yyyy/MM/dd'
         	   ,max:0
          });
        
        laydate.render({
            elem: '#endDate4' 
         	   ,format: 'yyyy/MM/dd'
         	   ,max:0
          });
      });

    </script>