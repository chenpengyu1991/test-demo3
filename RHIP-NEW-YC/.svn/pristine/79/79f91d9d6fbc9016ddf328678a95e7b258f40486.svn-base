<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<script type="text/javascript">
    require(['views/wsMonitor/log/search'],function(logSearch){
        logSearch.load();
    });
</script>

<div class="section"  id="top_all">
    <div class="searchbox">
        <input type="hidden" id="pageIndex" value="${pageIndex}">
        <form id="logSearchForm">
            <table id="logSearch" >
            <colgroup>
                <col style="min-width:80px; width: 15%;"/>
                <col style="min-width:250px; width: 30%;"/>
                <col style="min-width:80px; width: 15%;"/>
                <col style="min-width:120px; width: 20%;"/>
                <col style="min-width:100px; width: 20%;"/>
            </colgroup>
                <tbody>
                    <tr>
                        <td class="coltext">IP地址</td>
                        <td class="colinput">
                            <input type="text" name="userIp" />
                        </td>
                        <td class="coltext">成功标志</td>
                        <td class="colinput">
                            <ehr:dic-list name="isSuccess" dicmeta="FS990021" value="" width="155px"/>
                        </td>
                    </tr>
                    <tr>
                        <td class="coltext">请求时间</td>
                        <td class="colinput" colspan="2">
                            <tag:dateInput name="beginDate" id="beginDate" maxId="endDate" onlypast="true" style="width: 68px;"/>
                            ~<tag:dateInput name="endDate" id="endDate" minId="beginDate" onlypast="true"  style="width: 68px;"/>
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
                          <span onclick="logSearch.toggle(this,'logSearch')" class="ico-bottom">&nbsp;</span>
                    </td>
                </tr>
            </table>

         </form>
    </div>
    <div id="logResultDiv">
    </div>
</div>
<div id="detailDiv"></div>

