<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<script src="${pageContext.request.contextPath}/js/views/idm/idmCommon.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/idm/leprosy/statisticsIndex.js" type="text/javascript"></script>

<div>
    <div id="fillSelfTopAll">

        <div class="toolbar">
            <a href="javascript:void(0)" onclick="statistics.downLoad()"><b class="export">导出</b></a>
        </div>
        <div class="searchbox">
            <input type="hidden" id="pageIndex" value="${pageIndex}">
            <form id="statisticsSearchForm">
                <table id="statisticsSearch" >
                    <colgroup>
                        <col style="min-width:70px; width: 10%;"/>
                        <col style="min-width:100px; width: 23%;"/>
                        <col style="min-width:70px; width: 10%;"/>
                        <col style="min-width:100px; width: 23%;"/>
                        <col style="min-width:70px; width: 10%;"/>
                        <col style="min-width:100px; width: 23%;"/>
                    </colgroup>
                    <tbody>
                    <tr>
                        <td class="coltext">上报日期</td>
                        <td class="colinput">
                            <tag:dateInput id="dateFromId" name="dateFrom" pattern="yyyy/MM/dd"  onlypast="true" style="width:38%;"/>
                            ~<tag:dateInput id="dateToId" name="dateTo" pattern="yyyy/MM/dd"  onlypast="true"  style="width:38%;"/>
                        </td>
                        <td class="coltext">所属单位</td>
                        <td class="colinput">
                            <ehr:org-type-list name="orgCode" type="other,centre" codeOther="46714114-9"/>
                            <input type="hidden" id="SQZXOrgCode" value="${sqzx.organCode}">
                            <input type="hidden" id="SQZXOrgName" value="${sqzx.organName}">
                        </td>
                        <td></td>
                        <td>
                            <input type="button" value="查询" onclick="statistics.search(1)" id="statisticsBtn" class="search_btn"/>
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
        <div id="resultListDivPage" style="overflow: auto;"></div>
    </div>
    <div id="fillSelfdetailDiv" ></div>
</div>

