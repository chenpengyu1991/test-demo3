<%@ page import="com.founder.rhip.ehr.common.RoleType" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<jsp:include page="../../layouts/load-js-css-resources.jsp"></jsp:include>

<c:set var="ADMIN" value="<%=RoleType.ADMIN.getValue()%>"/>
<c:set var="JKXG" value="<%=RoleType.JKXG.getValue()%>"/>
<c:set var="ZXXG" value="<%=RoleType.ZXXG.getValue()%>"/>
<c:set var="ZXG" value="<%=RoleType.ZXG.getValue()%>"/>
<script src="${pageContext.request.contextPath}/js/views/ncp/follow/search.js" type="text/javascript"></script>
<div id="ncpFollowPat" class="section">
    <div class="section" id="top_all">
        <div class="toolbar">
        </div>
        <div class="searchbox searchSection x-admin-sm">
            <form method="post" id="form_search">
                <table id="ncp-follow-search-table">
                    <colgroup>
                        <col style="min-width: 70px;width:10%">
                        <col style="min-width: 140px;width:23%">
                        <col style="min-width: 70px;width:10%">
                        <col style="min-width: 140px;width:23%">
                        <col style="min-width: 70px;width:10%">
                        <col style="min-width: 140px;width:23%">
                        <%--<col style="width:15%">
                        <col style="width:20%">
                        <col style="width:15%">
                        <col style="width:20%">
                        <col style="width:65%">--%>
                    </colgroup>
                    <tbody>
                    <tr>
                        <td class="coltext">姓名</td>
                        <td class="colinput"><input type="text" name="name" id="personName" class="x-layui-input"/></td>
                        <td class="coltext">身份证号</td>
                        <td class="colinput">
                            <tag:idcardInput name="cardno" style="ime-mode:Disabled;" cssClass="x-layui-input"/>
                        </td>
                        <td class="coltext">性别</td>
                        <td class="colinput"> <ehr:dic-list name="sex" dicmeta="GBT226112003" cssClass="x-layui-input"/></td>
                    </tr>
                    <tr>
                        <td class="coltext">出院日期</td>
                        <td class="colinput">
                           <%--  <tag:dateInput id="dischargeBegin" name="dischargeBegin" pattern="yyyy/MM/dd" date="${dischargeBegin}" onlypast="true"  style="width:40%;"/>
                            ~<tag:dateInput id="dischargeEnd" name="dischargeEnd" pattern="yyyy/MM/dd" date="${dischargeEnd}" onlypast="true"  style="width: 40%;"/> --%>
                            
                            <input type="text" class="layui-input x-admin-sm-date"  name="dischargeBegin" id="dischargeBegin" style="padding-left: 0px;width:40%;" /> ~
                         <input type="text" class="layui-input x-admin-sm-date"  name="dischargeEnd" id="dischargeEnd" style="padding-left: 0px;width:40%;" />
                        </td>
                        <td class="coltext">出院天数</td>
                        <td class="colinput"> <ehr:dic-list name="cyts" dicmeta="NCP00007" cssClass="x-layui-input"/></td>
                        <td class="coltext">人群分类</td>
                        <td class="colinput">
                            <ehr:dic-list width="156px" type="true"  id="groupClassification" name="groupClassification" dicmeta="FDS007" cssClass="x-layui-input"/>
                        </td>
                    </tr>
                    <tr>
                        <td class="coltext">临床分型</td>
                        <td class="colinput"> <ehr:dic-list name="lcfx" dicmeta="NCP00001" cssClass="x-layui-input" /></td>
                        <td class="coltext">健康评价</td>
                        <td class="colinput"> <ehr:dic-list name="jkpj" dicmeta="NCP00004" cssClass="x-layui-input" /></td>
                        <td class="coltext">复查状态</td>
                        <td class="colinput"> <ehr:dic-list name="fczt" dicmeta="NCP00005" cssClass="x-layui-input" /></td>
                    </tr>
                    <tr>
                        <td class="coltext">随访类别</td>
                        <td class="colinput"> <ehr:dic-list name="sflb" dicmeta="NCP00006" width="70px;" cssClass="x-layui-input"/></td>
                        <td class="coltext">随访日期</td>
                        <td class="colinput">
                            <%-- <tag:dateInput id="sfBegin" name="sfBegin" pattern="yyyy/MM/dd" date="${sfBegin}" onlypast="true"  style="width:40%;"/>
                            ~<tag:dateInput id="sfEnd" name="sfEnd" pattern="yyyy/MM/dd" date="${sfEnd}" onlypast="true"  style="width: 40%;"/> --%>
                            <input type="text" class="layui-input x-admin-sm-date"  name="sfBegin" id="sfBegin" style="padding-left: 0px;width:40%;" /> ~
                         <input type="text" class="layui-input x-admin-sm-date"  name="sfEnd" id="sfEnd" style="padding-left: 0px;width:40%;" />
                        </td>
                        <td class="coltext">随访医生</td>
                        <td class="colinput"><input type="text" name="doctor" cssClass="x-layui-input"/></td>
                    </tr>
                    <tr>
                        <td class="coltext">
                            <ehr:authorize ifAnyGranted="${ADMIN},${JKXG},${ZXXG}">管理机构</ehr:authorize>
                        </td>
                        <td class="colinput">
                            <ehr:authorize ifAnyGranted="${ADMIN},${JKXG}">
                                <ehr:dic-town-centre-station centreName="centerOrganCode" stationName="stationOrganCode" townName="gbcode" isShowOneself="true" width="33%" cssClass="x-layui-input"/>
                            </ehr:authorize>
                            <ehr:authorize ifAnyGranted="${ZXXG}">
                                <ehr:dic-org-list id="nowAddressCode" name="stationOrganCode" width="80%;" isShowOneself="true" cssClass="x-layui-input"/>
                            </ehr:authorize>
                        </td>
                        <td class="coltext">
                            病例分类
                        </td>
                        <td colspan="2">
                            <ehr:dic-radio isDefault="Y" id="gender" dicmeta="NCP00003" name="patientType" value="" code="1,3,2" onchange="toggleOther('patientType','sfxwzls','2');"/>
                            <span id ="sfxwzls" style="display: none">（<ehr:dic-radio dicmeta="NCP00011" name="zlType" />）</span>
                        </td>
                        <td class="colinput">
                            <!-- <input type="button" value="查询" id="ncpbtnSearch" class="search_btn"/> -->
                            <button class="layui-btn layui-btn-sm" id="ncpbtnSearch"><i class="layui-icon">&#xe615;</i>查询</button>
                        </td>
                    </tr>
                    </tbody>
                </table>
               <%-- <ehr:authorize ifAnyGranted="${ZXXG},${ZXG}">--%>
                    <table>
                        <colgroup>
                            <col style="min-width: 10px;width:2%">
                            <col style="width:96%">
                            <col style="min-width: 10px;width:2%">

                        </colgroup>
                        <tr>
                            <td></td>
                            <td class="collink">
                                <input id ="quicktype" name="quicktype" type="hidden" />
                                <div id="dm-followup-links">
                                    <a class="to-followup-link" href="javascript:ncpFollowSearch.quickSearch(1)"  >本日待监测(<label  id="today-to-followup">${ncpfollowcnt.td}</label>)</a>
                                    <a  class="to-followup-link"    href="javascript:ncpFollowSearch.quickSearch(2)"  >满2周待复查(<label  id="2week-to-followup">${ncpfollowcnt.sec_week}</label>)</a>
                                    <a  class="to-followup-link"   href="javascript:ncpFollowSearch.quickSearch(3)"   >待追踪随访(<label  id="to-followup">${ncpfollowcnt.follow}</label>)</a>
                                </div>
                            </td>
                            <td></td>

                        </tr>
                    </table>
                <%--</ehr:authorize>--%>
                <table>
                    <tr>
                        <td colspan="6" class="colbottom">
                            <span id="health-card-search-toggle-btn" class="ico-bottom">&nbsp;</span>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
        <div id="ncpList" class="repeattable">
            <jsp:include page="list.jsp"/>
        </div>
    </div>
</div>
<div id="ncpFollowEdit">
</div>
<script type="text/javascript">
    layui.use('laydate', function(){
        var laydate = layui.laydate;
        
        laydate.render({
          elem: '#dischargeBegin' 
       	   ,format: 'yyyy/MM/dd'
       	   ,max:0
        });

        laydate.render({
          elem: '#dischargeEnd'
           ,format: 'yyyy/MM/dd'
        	   ,max:0
        });
        
        laydate.render({
            elem: '#sfBegin' 
         	   ,format: 'yyyy/MM/dd'
         	   ,max:0
          });

          laydate.render({
            elem: '#sfEnd'
             ,format: 'yyyy/MM/dd'
          	   ,max:0
          });
      
      });

    </script>
