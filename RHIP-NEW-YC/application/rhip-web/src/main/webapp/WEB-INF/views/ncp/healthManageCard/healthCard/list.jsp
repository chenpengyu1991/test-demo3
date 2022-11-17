<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ page import="com.founder.rhip.ehr.common.RoleType" %>
<jsp:include page="../../../layouts/load-js-css-resources.jsp"></jsp:include>

<c:set var="ADMIN" value="<%=RoleType.ADMIN.getValue()%>"/>
<c:set var="JKXG" value="<%=RoleType.JKXG.getValue()%>"/>
<c:set var="ZXXG" value="<%=RoleType.ZXXG.getValue()%>"/>
<c:set var="ZXG" value="<%=RoleType.ZXG.getValue()%>"/>

<script src="${pageContext.request.contextPath}/js/views/ncp/healthManageCard/healthCard/list.js" type="text/javascript"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/views/ZKTfinger/js/readcard/baseISSObject.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/views/ZKTfinger/js/readcard/baseISSOnline.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/views/ZKTfinger/js/readcard/common.js"></script>
<div class="section" id="ncp-manage-list-box">
     
        <div class="toolbar">
        <ehr:authorize ifAnyGranted="${ZXXG},${ZXG},${JKXG}">
           <!-- <a href="javascript:void(0)" id="ncp-manage-input-btn"><b class="xinz">新增</b></a> -->
           <a href="javascript:void(0)" id="ncp-manage-input-btn"><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe608;</i>新增</button></a>
           </ehr:authorize> 
           <!-- <a href="javascript:void(0)" id="ncp-manage-export-btn"><b class="export">导出</b></a> -->
           <a href="javascript:void(0)" id="ncp-manage-export-btn"><button class="layui-btn layui-btn-sm" ><i class="layui-icon">&#xe67d;</i>导出</button></a>
        </div>
    
    <p id="cert_message" class="msgError" style="display: none;"></p>
    <p id="cert_message_type" style="display: none;"></p>
    <div class="searchbox searchSection x-admin-sm">
        <form method="post" id="form_search">
            <table id="health-card-search-table">
                <colgroup>
                    <col style="min-width: 70px;width:10%">
                    <col style="min-width: 140px;width:23%">
                    <col style="min-width: 70px;width:10%">
                    <col style="min-width: 140px;width:25%">
                    <col style="min-width: 70px;width:10%">
                    <col style="min-width: 140px;width:21%">
                </colgroup>
                <tbody>
                <tr>
                    <td class="coltext">姓名</td>
                    <td class="colinput"><input type="text" name="name" id="personName" class="x-layui-input"/></td>
                    <td class="coltext">身份证号</td>
                    <td class="colinput">
                        <tag:idcardInput name="idcard" style="ime-mode:Disabled;" id="text_idcard" cssClass="x-layui-input"></tag:idcardInput>
                        <input type="button" value="读卡" id="button_read" onclick="new Device().startFun()" style="width: 40px;">
                    </td>
                    <td class="coltext">性别</td>
                    <td class="colinput">
                        <ehr:dic-list dicmeta="GBT226112003" name="gender" id="genderCode" cssClass="x-layui-input"/>
                    </td>
                </tr>
                <tr>
                    <td class="coltext">年龄段</td>
                    <td class="colinput">
                        <tag:numberInput maxlength="3" name="startAge" id="startAge" style="width:35%"></tag:numberInput> ~
                        <tag:numberInput maxlength="3" name="endAge" id="endAge" style="width:35%"></tag:numberInput>岁
                    </td>
					<td class="coltext">临床分型</td>
                    <td class="colinput">
                        <ehr:dic-list width="156px" id="clinicalClass" name="clinicalClass" dicmeta="NCP00001" cssClass="x-layui-input" />
                    </td>
                    <td class="coltext">出院日期</td>
                    <td class="colinput">
                        <%-- <tag:dateInput name="managedDateStart" onlypast="true" style="width:35%;"/> ~
                        <tag:dateInput name="managedDateEnd" onlypast="true" style="width:35%;"/> --%>
                        
                        <input type="text" class="layui-input x-admin-sm-date"  name="managedDateStart" id="managedDateStart" style="padding-left: 0px;width:35%;" /> ~
                         <input type="text" class="layui-input x-admin-sm-date"  name="managedDateEnd" id="managedDateEnd" style="padding-left: 0px;width:35%;" />
                    </td>
                </tr>

                <tr>
                    
                    <td class="coltext">人群分类</td>
                    <td class="colinput">
                    <ehr:dic-list width="156px" type="true"  id="groupClassification" name="groupClassification" dicmeta="FDS007" cssClass="x-layui-input" />
                    </td>
                    <td class="coltext">管理状态</td>
                    <td class="colinput">
                        <ehr:dic-list dicmeta="NCP00002" width="156px" name="status" cssClass="x-layui-input"/>
                    </td>
                    <td class="coltext">签约状态</td>
                    <td class="colinput">
                    <ehr:dic-list width="156px" dicmeta="FS10399" name="signFlag" cssClass="x-layui-input"/>
                    
                    </td>

                    <%--<td align="left">
                        <input type="button" id="per_search_btn" value="查询" onclick="" class="search_btn"/>
                    </td>
                    </td>--%>
                </tr>
                <tr>
                     <td class="coltext">
                        <ehr:authorize ifAnyGranted="${ADMIN},${JKXG},${ZXXG}">管理机构</ehr:authorize>
                    </td>
                    <td>
                        <ehr:authorize ifAnyGranted="${ADMIN},${JKXG}">
                            <ehr:dic-town-centre-station centreName="centerOrganCode" stationName="stationOrganCode" townName="gbcode" isShowOneself="true" width="33%" cssClass="x-layui-input"/>
                        </ehr:authorize>
                        <ehr:authorize ifAnyGranted="${ZXXG}">
                            <ehr:dic-org-list id="nowAddressCode" name="stationOrganCode" width="50%;" isShowOneself="true" cssClass="x-layui-input"/>
                         </ehr:authorize>
                    </td>
                    <td class="coltext">病例分类</td>
                    <td colspan="2">
                        <ehr:dic-radio isDefault="Y" id="gender" dicmeta="NCP00003" name="patientType" value="" code="1,3,2" onchange="toggleOther('patientType','xwzls','2');"/>
                        <span id ="xwzls" style="display: none">（<ehr:dic-radio dicmeta="NCP00011" name="zlType" />）</span>
                    </td>
                    <td align="left">
                        <!-- <input type="button" id="per_search_btn" value="查询" onclick="" class="search_btn"/> -->
                        <button class="layui-btn layui-btn-sm" id="per_search_btn"><i class="layui-icon">&#xe615;</i>查询</button>
                    </td>
                </tr>

                </tbody>
            </table>
            <table>
                <tr>
                    <td colspan="6" class="colbottom">
                        <span id="health-card-search-toggle-btn" class="ico-bottom">&nbsp;</span>
                    </td>
                </tr>
            </table>
        </form>
    </div>
    <div id="diseaseInfo" class="repeattable"></div>
</div>
<div id="ncp-manage-input-box"></div>

<script type="text/javascript">
    layui.use('laydate', function(){
        var laydate = layui.laydate;
        
        laydate.render({
          elem: '#managedDateStart' 
       	   ,format: 'yyyy/MM/dd'
       	   ,max:0
        });

        laydate.render({
          elem: '#managedDateEnd'
           ,format: 'yyyy/MM/dd'
        	   ,max:0
        });
      
      });

    </script>
