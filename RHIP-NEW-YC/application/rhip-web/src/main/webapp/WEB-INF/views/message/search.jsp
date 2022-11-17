<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<jsp:include page="../layouts/load-js-css-resources.jsp"></jsp:include>

<script src="${pageContext.request.contextPath}/js/views/ihm/message/search.js" type="text/javascript"></script>
<%--<script src="${pageContext.request.contextPath}/js/views/ihm/cwhTarget/cwhCommon.js" type="text/javascript"></script>--%>
<div id="top_all" style="width: 99%;margin: 5px;">
    <div class="toolbar" >
    <c:if test="${personal != '1'}">
        <a href="javascript:messageSearch.addMessage()" id="saveContact"><b class="xinz">发布新消息</b></a>
    </c:if>
    </div>
    <div class="section">
        <div class="searchBox searchSection x-admin-sm">
            <input type="hidden" id="pageIndex" value="${pageIndex}">
            <input type="hidden" id="personal" value="${personal}">
            <form id="searchForm">
                <table id="searchTable">
                    <colgroup>
                        <col style="width: 10%; min-width: 70px;"/>
                        <col style="width: 20%; min-width: 70px;"/>
                        <col style="width: 10%; min-width: 70px;"/>
                        <col style="width: 20%; min-width: 70px;"/>
                        <col style="width: 10%; min-width: 70px;"/>
                        <col style="width: 15%; min-width: 70px;"/>
                        <col/>
                    </colgroup>
                    <tbody>
                    <tr>
                        <td class="col-text">发布日期</td>
                        <td class="col-input" colspan="4">
                            <%-- <tag:dateInput name="dateFrom" onlypast="true"></tag:dateInput> ~
                            <tag:dateInput name="dateTo" onlypast="true"></tag:dateInput> --%>
                            
                            <input type="text" class="layui-input x-admin-sm-date"  name="dateFrom" id="dateFromId" style="padding-left: 0px;width: 40%;" /> ~
                            <input type="text" class="layui-input x-admin-sm-date"  name="dateTo" id="dateToId" style="padding-left: 0px;width: 40%;" />
                        </td>
                        <td style="text-align: right;">
                            <!-- <input type="button" id="btnSearch" value="查询" onclick="" class="search_btn" /> -->
                            <button class="layui-btn layui-btn-sm" id="btnSearch"><i class="layui-icon">&#xe615;</i>查询</button>
                        </td>
                    </tbody>
                </table>
                <table>
                    <tr>
                        <td class="col-bottom"><span onclick="toggle(this,'searchTable')" class="ico-bottom">&nbsp;</span></td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
<div id="resultDiv" style="width: 99%;margin-left: 5px;"></div>
</div>
<div id="detailDiv"></div>

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

