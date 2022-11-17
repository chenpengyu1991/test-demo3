<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<script src="${pageContext.request.contextPath}/js/views/im/monitor/machineMonitor/search.js" type="text/javascript"></script>

<div class="section" id="top_all">
    <div class="searchbox">
        <input type="hidden" id="pageIndex" value="${pageIndex}">
        <form id="machineMonitorForm">
            <table id="machineMonitorTable">
                <colgroup>
                    <col style="width: 10%;"/>
                    <col style="width: 23%;"/>
                    <col style="width: 10%;"/>
                    <col style="width: 23%;"/>
                    <col style="width: 10%;"/>
                    <col style="width: 23%;"/>
                </colgroup>
                <tr>
                    <td class="coltext">服务器地址</td>
                    <td class="colinput">
                        <input type="text" id="ipAddress" name="ipAddress" />
                    </td>
                    <td  class="coltext">监控时间</td>
                    <td class="colinput">
                        <tag:dateInput nullToToday="true" id="createTimeBegin" name="createTimeBegin"
                                       pattern="yyyy/MM/dd" onlypast="true" style="width: 36%;"></tag:dateInput>
                        ~
                        <tag:dateInput nullToToday="true" id="createTimeEnd" name="createTimeEnd" pattern="yyyy/MM/dd"
                                       onlypast="true" style="width: 36%;"></tag:dateInput>
                    </td>
                    <td></td>
                    <td>
                        <input type="button" value="查询" class="search_btn" id="searchMachineMonitorId"/>
                    </td>
                </tr>
            </table>
            <table>
                <tr>
                    <td class="colbottom">
                        <span onclick="machineMonitorSearch.toggle(this,'machineMonitorTable')" class="ico-bottom">&nbsp;</span>
                    </td>
                </tr>
            </table>
        </form>
    </div>
    <div id="machineMonitorList"></div>
</div>
<div id="machineMonitorListDiv"></div>



