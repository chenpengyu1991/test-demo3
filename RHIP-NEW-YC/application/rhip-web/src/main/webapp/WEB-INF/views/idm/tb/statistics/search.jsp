<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<%@ page import="com.founder.rhip.ehr.common.RoleType" %>
<%@ page import="com.founder.rhip.ehr.common.EHRConstants" %>
<c:set var="JK_CODE" value="<%=EHRConstants.JK_CODE%>"/>
<c:set var="JKJHB" value="<%=RoleType.JKJHB.getValue()%>"/>
<c:set var="YYJHB" value="<%=RoleType.YYJHB.getValue()%>"/>
<c:set var="DDCRBYY" value="<%=RoleType.DDCRBYY.getValue()%>"/>
<c:set var="ZXJHB" value="<%=RoleType.ZXJHB.getValue()%>"/>

<script src="${pageContext.request.contextPath}/js/views/idm/idmCommon.js" type="text/javascript"></script>
<div>
    <div id="fillSelfTopAll">

        <div class="searchbox searchSection x-admin-sm">
            <input type="hidden" id="pageIndex" value="${pageIndex}">
            <form id="statisticsSearchForm">
                <table id="statisticsSearch" >
                    <colgroup>
                        <col style="min-width:70px; width: 10%;"/>
                        <col style="min-width:100px; width: 23%;"/>
                        <col style="min-width:70px; width: 10%;"/>
                        <col style="min-width:100px; width: 38%;"/>
                        <col style="min-width:100px; width: 18%;"/>
                    </colgroup>
                    <tbody>
                    <tr>
                        <td class="coltext">日期</td>
                        <td class="colinput">
                            <%-- <tag:dateInput id="dateFromId" name="dateFrom" pattern="yyyy/MM/dd"  onlypast="true" style="width:38%;"/>
                            ~<tag:dateInput id="dateToId" name="dateTo" pattern="yyyy/MM/dd"  onlypast="true"  style="width:38%;"/> --%>
                            
                            <input type="text" class="layui-input x-admin-sm-date"  name="dateFrom" id="dateFromId" style="padding-left: 0px;width:38%;" /> ~
                            <input type="text" class="layui-input x-admin-sm-date"  name="dateTo" id="dateToId" style="padding-left: 0px;width:38%;" />
                        </td>

                        <td class="coltext"><label id="title1" hidden="hidden">所属单位</label><label id="title2" hidden="hidden">接触者填写单位</label></td>
                        <%--<td class="colinput">--%>
                            <%--<ehr:org-type-list name="orgCode" type="hospital,centre" value="${orgCode}" code="${orgCode}"/>--%>
                        <%--</td>--%>
                        <td class="colinput">
                            <ehr:authorize ifAnyGranted="${YYJHB}">
                                <input type="hidden" name="orgCode" value="${currentOrg}">
                                <ehr:org code="${currentOrg}"/>
                            </ehr:authorize>
                            <ehr:authorize ifAnyGranted="${ZXJHB}">
                                <select id="patownShip" name="orgCode" style="width: 150px;" class="x-layui-input">
                                    <%-- <option value="${JK_CODE}" id="title3" hidden="hidden">疾病防治中心</option>--%>
                                    <c:forEach var="org" items="${orgList}">
                                        <option value="${org.organCode}">${org.organName}</option>
                                    </c:forEach>
                                </select>
                            </ehr:authorize>
                            <ehr:authorize ifAnyGranted="${DDCRBYY},${JKJHB}">
                                <ehr:org-type-list name="orgCode" type="hospital,centre,other" id="title4" width="190px" cssClass="x-layui-input"/>
                                <label id="title5" hidden="hidden">
                                	<ehr:dic-town-centre-station centreName="village" stationName="station" townName="town" isAuthorize="false" isShow="true" isShowOneself="true"
                                                                townId="searchTown" centreId="searchCenter" stationId="searchStation" style="width: 150px;" cssClass="x-layui-input"/>
                                </label>
                                <input id="searchOrganCode" name="organCode" type="hidden"/>

                            </ehr:authorize>
                            <input type="hidden" id="SQZXOrgCode" value="${sqzx.organCode}">
                            <input type="hidden" id="SQZXOrgName" value="${sqzx.organName}">
                        </td>
                        <td>
                            <%-- <input type="button" value="查询" onclick="statistics.search(1)" class="search_btn"/> --%>
                            <button class="layui-btn layui-btn-sm" id="tbStatisticsId"><i class="layui-icon">&#xe615;</i>查询</button>
                        </td>
                    </tr>
                    </tbody>
                </table>
                <table>
                    <tr>
                        <td colspan="6" class="colbottom">
                            <span onclick="idmCommon.toggle(this,'statisticsSearch')" class="ico-bottom">&nbsp;</span>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
        <div class="toolbarSection">
            <!-- <a href="javascript:void(0)" onclick="statistics.downLoad()"><b class="export">导出</b></a> -->
            <a href="javascript:void(0)" onclick="statistics.downLoad()"><button class="layui-btn layui-btn-sm" ><i class="layui-icon">&#xe67d;</i>导出</button></a>
        </div>
        <div id="resultListDiv" style="min-width: 750px;overflow: auto;"></div>
    </div>
    <div id="fillSelfdetailDiv" ></div>
</div>

<script type="text/javascript">
    layui.use('laydate', function(){
        var laydate = layui.laydate;
        
        laydate.render({
          elem: '#dateFromId' 
       	   ,format: 'yyyy/MM/dd'
       	   ,max:0
        });

        laydate.render({
          elem: '#dateToId'
           ,format: 'yyyy/MM/dd'
        	   ,max:0
        });
        
      });

    </script>
