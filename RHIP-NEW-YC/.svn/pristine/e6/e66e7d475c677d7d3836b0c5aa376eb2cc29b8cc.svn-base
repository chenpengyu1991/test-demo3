<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<jsp:include page="../../layouts/load-js-css-resources.jsp"></jsp:include>

<script src="${pageContext.request.contextPath}/js/views/ihm/yz/search.js" type="text/javascript"></script>
<%--<script src="${pageContext.request.contextPath}/js/util/jquery.placeholder.1.3.js" type="text/javascript"></script>--%>
<script type="text/javascript">
   /*  statisticsSearch.load(); */
</script>

<div class="toolbar">
    	<div class="x-nav">
		      <span class="layui-breadcrumb">
		        <a href="javascript:void(0)">综合管理</a>

		          <c:if test="${type eq 1}">
                      <a href="javascript:void(0)">运营监管</a>
                      <a>
                          <cite>
                              门急诊输液监管
		          </c:if>
		           <c:if test="${type eq 2}">
                       <a href="javascript:void(0)">医疗服务</a>
                       <a>
                           <cite>
                               门诊统计
		          </c:if>
		          <c:if test="${type eq 3}">
                      <a href="javascript:void(0)">运营监管</a>
                      <a>
                           <cite>
                               门急诊抗生素监管
		          </c:if>
		          <c:if test="${type eq 4}">
                      <a href="javascript:void(0)">运营监管</a>
                      <a>
                           <cite>
                               门急诊运营监管
		          </c:if>
		          <c:if test="${type eq 5}">
                      <a href="javascript:void(0)">运营监管</a>
                      <a>
                           <cite>
                               住院运营监管
		          </c:if>
		          <c:if test="${type eq 6}">
                      <a href="javascript:void(0)">医疗服务</a>
                      <a>
                           <cite>
                               住院统计
		          </c:if>
		          </cite></a>
		      </span>
		</div>
    </div>
    
<div class="section">
    <div id="top_all">
        <!--div class="toolbar">
        </div -->
        <div class="searchbox searchSection x-admin-sm">
            <form id="statisticsSearchForm">
                <table id="statisticsSearch" >
                    <input type="hidden" id="context" value="${reportType}"/>
                    <colgroup>
                        <col style="width: 8%; min-width: 55px;"/>
                        <col style="width: 18%; min-width: 100px;"/>
                        <col style="width: 6%; min-width: 45px;"/>
                        <col/>
                        <col style="width: 11%; min-width: 80px;"/>
                    </colgroup>
                    <tbody>
                    <tr>
                        <td class="col-text" style="text-align: right">统计类型</td>
                        <td class="col-input">
                            <select name="genreCode" id="genreCode" style="width: 130px;">
                                <%--卫生局,疾控慢病科--%>
                                <ehr:authorize ifAnyGranted="01,11">
                                    <c:if test="${empty gbFlag}">
                                        <option value="0">按镇</option>
                                    </c:if>
                                </ehr:authorize>
                                <%--卫生局,市级医院--%>
                                <ehr:authorize ifAnyGranted="01,39">
                                    <c:if test="${empty hospitalFlag && empty elderlyPhysicalExam}">
                                        <option value="A100">按市级医院</option>
                                    </c:if>
                                </ehr:authorize>
                                <%--卫生局,卫生院,疾控慢病科,卫管中心--%>
                                <ehr:authorize ifAnyGranted="01,03,11,04">
                                    <c:if test="${empty superOrganFlag}">
                                        <option value="B100">按卫生院</option>
                                    </c:if>
                                </ehr:authorize>
                                <%--卫生局,卫生院,社区服务中心--%>
                                <ehr:authorize ifAnyGranted="01,02,03">
                                    <c:if test="${empty organFlag && empty elderlyPhysicalExam}">
                                        <option value="B200">按社区卫生服务站</option>
                                    </c:if>
                                </ehr:authorize>
                            </select>
                        </td>
                        <td class="col-text" style="text-align: right">机构</td>
                        <td class="col-input">
                            <%--卫生局角色,老年人健康管理疾控慢病科--%>
                            <ehr:authorize ifAnyGranted="01,11,04">
                                <input type="hidden" id="gbCode" name="gbCode"/>
                                <input type="hidden" id="superOrganCode" name="superOrganCode"/>
                                <input type="hidden" id="organCode" name="organCode"/>
                                 <%--镇--%>
                                <div id="byTown">
                                    <ehr:dic-town-village townId="town3" townName="gbCode3" width="180px"  />
                                </div>
                                <%--市级医院--%>
                                <div id="byHospital">
                                    <ehr:org-type-list id="organCode0" name="organCode0" type="hospital"  value="${organCode}" code="${organCode}" width="260px" />
                                </div>
                                <%--卫生院--%>
                                <div id="byCentre">
                                    <ehr:dic-town-centre-station centreId="centre1" townId="town1" centreName="superOrganCode1" townName="gbCode1" width="220px;"  />
                                </div>
                                <%--社区服务站--%>
                                <div id="byStation">
                                    <ehr:dic-town-centre-station centreId="centre2" townId="town2" stationId="station2" centreName="superOrganCode2" stationName="organCode2" townName="gbCode2" width="33%;"  />
                                </div>
                               
                            </ehr:authorize>
                            <%--市级医院角色--%>
                            <ehr:authorize ifAnyGranted="39">
                                <%--市级医院--%>
                                <div id="byHospital">
                                    <input type="hidden" name="organCode" value="${orgCode}"/>
                                    <ehr:org  code="${orgCode}"/>
                                </div>
                            </ehr:authorize>
                            <%--卫生院角色--%>
                            <ehr:authorize ifAnyGranted="03">
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
                            <ehr:authorize ifAnyGranted="02">
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
                            </c:when>
                            <c:otherwise>
                                <td rowspan="2">
                            </c:otherwise>
                        </c:choose>
                                <!-- <input type="button" id="statisticsBtnSearch" value="查询" onclick="" class="search_btn" /> -->
                                <button class="layui-btn layui-btn-sm"  id="statisticsBtnSearch"><i class="layui-icon">&#xe615;</i>查询</button>
                    </td>
                    </tr>
                    <c:if test="${empty timeRangeFlag}">
                        <tr>
                            <td class="col-text" style="text-align: right">时间类型</td>
                            <td class="col-input">
                                <select name="rangeType" id="rangeType" style="width: 120px;">
                                    <c:if test="${empty monthRangeFlag}"><option value="1">按月</option></c:if>
                                    <c:if test="${empty quarterRangeFlag}"><option value="2">按季度</option></c:if>
                                    <c:if test="${empty yearRangeFlag}"><option value="3">按年</option></c:if>
                                    <c:if test="${empty rangeFlag}"><option value="4">按时间段</option></c:if>
                                </select>
                            </td>
                            <td class="col-text" style="text-align: right">时间</td>
                            <td class="col-input">
                                <input type="hidden" id="beginDate" name="beginDate"/>
                                <input type="hidden" id="endDate" name="endDate"/>
                                <div id="byMonth">
                                    <tag:dateInput name="monthDate" pattern="yyyy/MM" id="beginDate1" date="${currentBeginDate}" onlypast="true" style="width: 80px;"/>
                                </div>
                                <div id="byQuarter">
                                    <tag:dateInput name="quarterDate" pattern="yyyy" id="beginDate2" date="${currentBeginDate}" onlypast="true" style="width: 80px;"/>
                                    <select name="rangeQuarter" id="rangeQuarter" style="width: 80px;">
                                        <option value="1">第一季度</option>
                                        <option value="2">第二季度</option>
                                        <option value="3">第三季度</option>
                                        <option value="4">第四季度</option>
                                    </select>
                                </div>
                                <div id="byYear">
                                    <tag:dateInput name="yearDate" pattern="yyyy" id="beginDate3" date="${currentBeginDate}" onlypast="true" style="width: 80px;"/>
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
                    <%--<tr>
                        <td class="coltext">统计内容</td>
                        <td class="colinput">
                            <select id="context" name="context">
                                <option value="T001">门急诊运营监管</option>
                                <option value="T002">住院运营监管</option>
                                <!-- <option value="T003">基本药物监管</option> -->
                            </select>
                        </td>


                        <td class="coltext">时间范围</td>
                        <td class="colinput">
                            <tag:dateInput reg='{"required":"true"}' nullToToday="true" id="beginDate" name="beginDate" maxId="endDate" pattern="yyyy/MM/dd"  onlypast="true"  style="width: 40%;" date="${startDate}"></tag:dateInput>
                            ~<tag:dateInput reg='{"required":"true"}' nullToToday="true" id="endDate" name="endDate" minId="beginDate" pattern="yyyy/MM/dd"  onlypast="true"  style="width: 40%;" date="${endDate}"></tag:dateInput>
                        </td>
                        <td align="left" rowspan="2">
                            <input type="button" id="statisticsBtnSearch" value="查询" onclick="" class="search_btn"/>
                            <input type="button" id="import" value="导入历史数据" onclick="" class="search_btn" style="display:none"/>
                        </td>

                    </tr>--%>

                </table>
                <table>
                    <tr>
                        <td colspan="6" class="colbottom">
                            <span onclick="statisticsSearch.toggle(this,'statisticsSearch')" class="ico-bottom">&nbsp;</span>
                        </td>
                    </tr>
                </table>

            </form>
        </div>
        <div id="resultDiv">
        </div>
    </div>
    <div id="detailDiv" >    </div>
</div>

