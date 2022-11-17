<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<style>
    .colorFlag{
        font-size:16px;
        font-family:"微软雅黑";
        font-weight:bold;
        float:right;
        margin-left:20px;
    }
</style>
<script type="text/javascript">
    require(['views/wsMonitor/serviceMonitor/search'],function(serviceMonitorSearch){
        serviceMonitorSearch.load();
    });
</script>

<div class="section"  id="top_all">
    <div class="searchbox">
        <input type="hidden" id="pageIndex" value="${pageIndex}">
        <form id="serviceSearchForm">
            <table id="serviceSearch" >
            <colgroup>
                <col style="min-width:80px; width: 15%;"/>
                <col style="min-width:160px; width: 30%;"/>
                <col style="min-width:80px; width: 15%;"/>
                <col style="min-width:160px; width: 30%;"/>
                <col style="min-width:120px; width: 10%;"/>
            </colgroup>
                <tbody>
                    <tr>
                        <td class="coltext">接口名称</td>
                        <td class="colinput"><input type="text" name="webServiceName" /></td>
                        <td class="coltext">服务器地址</td>
                        <td class="colinput">
                            <input type="text" name="wsdl" />
                        </td>
                        <td align="left" rowspan="2">
                            <input type="button" value="查询" id="montiorSearch" class="search_btn"/>
                        </td>
                    </tr>
                    <tr>
                        <td class="coltext">访问日期</td>
                        <td class="colinput">
                            <tag:dateInput name="beginDate" id="beginDate" maxId="endDate" onlypast="true" date="${currentDate}" style="width: 68px;"/>
                            ~<tag:dateInput name="endDate" id="endDate" minId="beginDate" onlypast="true"  date="${currentDate}" style="width: 68px;"/>
                        </td>
                        <td class="coltext">服务开关</td>
                        <td class="colinput">
                            <ehr:dic-list name="serverStatus" dicmeta="FS990018" value="" width="155px"/>
                        </td>
                    </tr>
                </tbody>
            </table>
            <table>
                <tr>
                    <td colspan="4" class="colbottom">
                          <span onclick="serviceMonitorSearch.toggle(this,'serviceSearch')" class="ico-bottom">&nbsp;</span>
                    </td>
                </tr>
            </table>

         </form>
    </div>
    <div id="serviceResultDiv">
    </div>
</div>
<div id="detailDiv"></div>

