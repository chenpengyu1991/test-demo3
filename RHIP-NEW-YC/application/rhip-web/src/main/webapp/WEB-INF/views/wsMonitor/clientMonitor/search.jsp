<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<script type="text/javascript">
    require(['views/wsMonitor/clientMonitor/search'],function(clientMonitorSearch){
        clientMonitorSearch.load();
    });
</script>

<div class="section"  id="top_all">
    <div class="searchbox">
        <input type="hidden" id="pageIndex" value="${pageIndex}">
        <form id="clientSearchForm">
            <table id="clientSearch" >
            <colgroup>
                <col style="min-width:80px; width: 15%;"/>
                <col style="min-width:250px; width: 30%;"/>
                <col style="min-width:80px; width: 15%;"/>
                <col style="min-width:120px; width: 20%;"/>
                <col style="min-width:100px; width: 20%;"/>
            </colgroup>
                <tbody>
                    <tr>
                        <td class="coltext">机构名称</td>
                        <td class="colinput">
                            <tag:autoSelect name="orgCode" id="orgCode" style="width:180px;" ></tag:autoSelect>
                        </td>
                        <td class="coltext">禁用标志</td>
                        <td class="colinput">
                            <ehr:dic-list name="isOff" dicmeta="FS990020" value="" width="155px"/>
                        </td>
                    </tr>
                    <tr>
                        <td class="coltext">访问日期</td>
                        <td class="colinput" colspan="2">
                            <tag:dateInput name="beginDate" id="beginDate" maxId="endDate" onlypast="true" date="${currentDate}" style="width: 68px;"/>
                            ~<tag:dateInput name="endDate" id="endDate" minId="beginDate" onlypast="true"  date="${currentDate}" style="width: 68px;"/>
                        </td>
                        <td align="left">
                            <input type="button" value="查询" id="montiorSearch" class="search_btn"/>
                        </td>
                    </tr>
                </tbody>
            </table>
            <table>
                <tr>
                    <td colspan="5" class="colbottom">
                          <span onclick="clientMonitorSearch.toggle(this,'clientSearch')" class="ico-bottom">&nbsp;</span>
                    </td>
                </tr>
            </table>

         </form>
    </div>
    <div id="clientResultDiv">
    </div>
</div>
<div id="detailDiv"></div>

