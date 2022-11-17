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

<script type="text/javascript">
    layui.use('laydate', function(){
        var laydate = layui.laydate;

        //执行一个laydate实例
        laydate.render({
            elem: '#year'
            ,type: 'year'
        });
    });
</script>
<div>
    <input type="hidden" id="scFlag">
    <div id="topAll3">
        <div class="searchBox searchSection x-admin-sm">
            <form id="followUpSearchForm1">
                <table id="follow" >
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
                        <td class="coltext">年度</td>
                        <td class="colinput">
                            <input type="text" class="layui-input x-admin-sm-date" name="year" id="year" style="padding-left: 0px;width: 38%;" />
                        </td>
                        <td></td>
                        <td>
                            <button class="layui-btn layui-btn-sm" id="ch_search_btn"><i class="layui-icon">&#xe615;</i>查询</button>
                            <button class="layui-btn layui-btn-sm" id="ch_export_btn"><i class="layui-icon">&#xe67d;</i>导出</button>
                        </td>
                    </tr>

                    </tbody>
                </table>
                <table>
                    <tr>
                        <td colspan="6" class="colbottom">
                            <span onclick="idmCommon.toggle(this,'follow')" class="ico-bottom">&nbsp;</span>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
        <div id="ChReportListDiv"></div>
    </div>
    <div id="DetailDiv" ></div>
</div>

