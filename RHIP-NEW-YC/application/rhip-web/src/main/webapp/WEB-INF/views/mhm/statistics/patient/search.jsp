<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<%@ page import="com.founder.rhip.ehr.common.RoleType" %>
<jsp:include page="../../../layouts/load-js-css-resources.jsp"></jsp:include>

<c:set var="ZXJFYS" value="<%=RoleType.ZXJFYS.getValue()%>"/>
<c:set var="JKJFZX" value="<%=RoleType.JKJFZX.getValue()%>"/>

<script src="${pageContext.request.contextPath}/js/views/mhm/statistics/patient/search.js" type="text/javascript"></script>

<div>
    <div class="section" id="management_top_all">
        <div class="toolbar">
            <!-- <a href="javascript:void(0)" id="patientExport"><b class="export">导出</b></a> -->
            <a href="javascript:void(0)" id="patientExport"><button class="layui-btn layui-btn-sm" ><i class="layui-icon">&#xe67d;</i>导出</button></a>
        </div>
        <div class="searchbox searchSection x-admin-sm">
            <input type="hidden" id="pageIndex" value="${pageIndex}">
            <form id="patientSearchForm">
                <table id="patientSearch" >
                    <colgroup>
                        <col style="min-width:50px; width: 8%;"/>
                        <col style="min-width:150px; width: 17%;"/>
                        <col style="min-width:50px; width: 12%;"/>
                        <col style="min-width:150px; width: 25%;"/>
                        <col style="min-width:50px; width: 10%;"/>
                        <col style="min-width:150px; width: 18%;"/>
                        <col style="min-width:90px; width: 15%;"/>
                    </colgroup>
                    <tbody>
                    <tr>
                        <td class="coltext">姓名</td>
                        <td class="colinput">
                            <input type="text" name="name" class="x-layui-input" />
                        </td>
                        <td class="coltext">身份证号</td>
                        <td class="colinput">
                            <input type="text" name="idcard" reg='{"idCard":"true"}' class="x-layui-input" />
                        </td>
                        <td class="coltext">所属乡镇</td>
                        <td class="colinput">
                            <%--<ehr:dic-town-centre-station centreName="centerCode" stationName="" townName="townCode" width="160px;" />--%>
                           <%--<ehr:dic-list name="centerCode" dicmeta="FS990001"/>--%>
                            <ehr:dic-town-village townName="townCode" cssClass="x-layui-input"/>
                        </td>
                    </tr>
                    <tr>
                        <td class="coltext">诊断</td>
                        <td class="colinput">
                            <input type="text" name="diagnosisContent" class="x-layui-input" />
                        </td>
                        <td class="coltext">发药时间</td>
                        <td class="colinput">
                            <%-- <tag:dateInput name="drugDtFrom" onlypast="true" style="width: 40%;"/>
                            至<tag:dateInput name="drugDtTo" onlypast="true"  style="width: 40%;" /> --%>
                            
                            <input type="text" class="layui-input x-admin-sm-date"  name="drugDtFrom" id="drugDtFromId" style="padding-left: 0px;width: 36.5%;" />至
                                <input type="text" class="layui-input x-admin-sm-date"  name="drugDtTo" id="drugDtToId" style="padding-left: 0px;width: 36.5%;" />
                        </td>
                        <td></td>
                        <td></td>
                        <td><!-- <input type="button" value="查询" id="patientBtnSearch" class="search_btn"/> -->
                        <button class="layui-btn layui-btn-sm" id="patientBtnSearch"><i class="layui-icon">&#xe615;</i>查询</button>
                        </td>
                    </tr>
                    </tbody>
                </table>
                <table>
                    <tr>
                        <td colspan="6" class="colbottom">
                            <span onclick="mhmCommon.toggle(this,'patientSearch')" class="ico-bottom">&nbsp;</span>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
        <div id="patientResultDiv">
            <div id="reportList" class="repeattable">
                <table id="reportTable">
                    <colgroup>
                        <col style="min-width: 40px; width:6%;"/>
                        <col style="min-width: 80px; width:10%;"/>
                        <col style="min-width: 40px; width:6%;"/>
                        <col style="min-width: 40px; width:6%;"/>
                        <col style="min-width: 140px; width:15%;"/>
                        <col style="min-width: 100px; width:15%;"/>
                        <col/>
                        <col style="min-width: 130px; width:18%;"/>
                        <col style="min-width: 80px; width:10%;"/>
                    </colgroup>
                    <thead>
                    <tr>
                        <th>编号</th>
                        <th>姓名</th>
                        <th>性别</th>
                        <th>年龄</th>
                        <th>身份证号</th>
                        <th>诊断</th>
                        <th>所属乡镇</th>
                        <th>时间</th>
                        <th>费用</th>
                    </tr>
                    </thead>
                </table>
            </div>
        </div>
    </div>
    <div id="patientDetailDiv" ></div>
</div>

<script type="text/javascript">
    layui.use('laydate', function(){
        var laydate = layui.laydate;
        
        laydate.render({
          elem: '#drugDtFromId' 
        	  ,format: 'yyyy/MM/dd'
       	   ,max:0
        });

        laydate.render({
          elem: '#drugDtToId'
           ,format: 'yyyy/MM/dd'
        	   ,max:0
        });
        
      
      
      });

    </script>