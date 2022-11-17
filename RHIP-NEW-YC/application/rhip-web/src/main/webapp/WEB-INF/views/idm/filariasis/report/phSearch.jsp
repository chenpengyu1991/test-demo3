<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<%@ page import="com.founder.rhip.ehr.common.RoleType" %>
<c:set var="JKXFK" value="<%=RoleType.JKSCB.getValue()%>"/>
<c:set var="ADMIN" value="<%=RoleType.ADMIN.getValue()%>"/>

<script src="${pageContext.request.contextPath}/js/views/idm/filariasis/filReport.js" type="text/javascript"/>
<%--<script src="${pageContext.request.contextPath}/js/views/idm/filariasis/filStandard.js" type="text/javascript"></script>--%>
<div>
    <input type="hidden" id="scFlag">
    <div id="topAll3">
        <div class="searchbox">
            <form id="followUpSearchForm">
                <table id="followUpSearch" >
                    <colgroup>
                        <col style="min-width:70px; width: 10%;"/>
                        <col style="min-width:100px; width: 23%;"/>
                        <col style="min-width:70px; width: 10%;"/>
                        <col style="min-width:100px; width: 23%;"/>
                        <col style="min-width:70px; width: 10%;"/>
                        <col style="min-width:181px; width: 23%;"/>
                    </colgroup>
                    <tbody>
                    <tr>
                        <input type="hidden" id="pageIndex" value="1"<%--"${pageIndex}"--%>/>
                        <td class="coltext">日期</td>
                        <td class="colinput"><tag:dateInput nullToToday="false" id="ddiaBeginDt" name="ddiaBeginDt" pattern="yyyy/MM/dd"  onlypast="true" style="width: 36%;"></tag:dateInput>
                            ~<tag:dateInput nullToToday="false" id="ddiaEndDt" name="ddiaEndDt" pattern="yyyy/MM/dd"  onlypast="true"  style="width: 36%;"
                                            reg='{"compare":["ddiaBeginDt","ge","结束时间不能早于开始时间"]}'></tag:dateInput></td>
                        <td class="coltext">镇名:</td>
                        <td class="colinput"><ehr:dic-list id="" name="" dicmeta="" code="" /></td>

                    </tr>
                    <tr>
                        <td></td>
                        <td></td>
                        <td>
                        <input type="button" value="查询" onclick="" class="search_btn"/>
                        <input type="button" id="" value="导出" onclick="" class="search_btn"/>
                        </td>

                    </tr>

                    </tbody>
                </table>
                <table>
                    <tr>
                        <td colspan="6" class="colbottom">
                            <span onclick="idmCommon.toggle(this,'followUpSearch')" class="ico-bottom">&nbsp;</span>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
        <div id="ChReportListDiv"></div>
    </div>
    <div id="DetailDiv" ></div>
</div>

