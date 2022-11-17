<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ page import="com.founder.rhip.ehr.common.RoleType" %>
<jsp:include page="../../layouts/load-js-css-resources.jsp"></jsp:include>

<script src="${pageContext.request.contextPath}/js/views/mhm/mhmCommon.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/mhm/drugUse/search.js" type="text/javascript"></script>
<script type="text/javascript">
    $(function () {
        // 高级查询条件显示控制
        $("#perAdvanceSearchConditionBtn").click(function (e) {
            e.preventDefault();
            controlAdvanceSearchSection($(this));
        });
    });
</script>
<div>
    <div class="section" id="drugUse_top_all">
        <div class="toolbar">
            <div class="x-nav">
	      <span class="layui-breadcrumb">
	        <a href="javascript:void(0)">精神障碍患者管理</a>
	        <a href="javascript:void(0)">免费发药管理</a>
	        <a>
	          <cite>免费发药登记</cite></a>
	      </span>
            </div>
        </div>
        <div class="searchbox searchSection x-admin-sm">
            <input type="hidden" id="pageIndex" value="${pageIndex}">
            <form id="drugUseSearchForm">
                <table id="drugUseSearch">
                    <colgroup>
                        <col style="min-width:70px; width: 13%;"/>
                        <col style="min-width:160px; width: 20%;"/>
                        <col style="min-width:70px; width: 13%;"/>
                        <col style="min-width:160px; width: 20%;"/>
                        <col style="min-width:90px; width: 14%;"/>
                        <col style="min-width:140px; width: 20%;"/>
                    </colgroup>
                    <tbody>
                    <tr>
                        <td class="coltext">姓名</td>
                        <td class="colinput"><input type="text" name="name" class="x-layui-input"/></td>
                        <td class="coltext">身份证号</td>
                        <td class="colinput"><input type="text" name="idcard" class="x-layui-input"/></td>
                        <td class="coltext">所属机构</td>
                        <td class="colinput">
                            <ehr:dic-org-list name="managementStation" value="${stationCode}" width="160px;"
                                              cssClass="x-layui-input"></ehr:dic-org-list>
                        </td>
                    </tr>
                    <tr>
                        <td class="coltext">病人类型</td>
                        <td class="colinput">
                            <ehr:dic-list name="patientType" dicmeta="MH00003" code="1,2" cssClass="x-layui-input"/>
                        </td>
                        <td class="coltext">管理方式</td>
                        <td class="colinput">
                            <ehr:dic-list name="mgntType" dicmeta="MH00006" code="1,2" cssClass="x-layui-input"/>
                        </td>
                        <td class="coltext">病人来源</td>
                        <td class="colinput">
                            <ehr:dic-list name="patientSource" dicmeta="MH00004" code="1,2,3" width="160px;"
                                          cssClass="x-layui-input"/>
                        </td>
                    </tr>
                    <tr class="advanceSearchSection" style="display: none;">
                        <td class="coltext">登记时间</td>
                        <td class="colinput" colspan="4">
                            <%-- <tag:dateInput nullToToday="true" name="regBeginDate" onlypast="true" style="width: 120px;"/>
                                至<tag:dateInput nullToToday="true" name="regEndDate" onlypast="true"  style="width: 120px;"/> --%>

                            <input type="text" class="layui-input x-admin-sm-date" name="regBeginDate"
                                   id="regBeginDateId" style="padding-left: 0px;width: 120px;"/> 至
                            <input type="text" class="layui-input x-admin-sm-date" name="regEndDate" id="regEndDateId"
                                   style="padding-left: 0px;width: 120px;"/>
                        </td>
                    </tr>
                    <tr>
                        <td class="righttd" colspan="6">
                            <button class="layui-btn layui-btn-sm" id="drugUseBtnSearch"><i
                                    class="layui-icon">&#xe615;</i>查询
                            </button>
                            <button class="layui-btn layui-btn-sm" id="perAdvanceSearchConditionBtn"><i
                                    class="iconfont">&#x60010;</i>高级
                            </button>
                        </td>
                    </tr>
                    <tr>

                    </tr>
                    </tbody>
                </table>
                <table>
                    <tr>
                        <td colspan="6" class="colbottom">
                            <span onclick="mhmCommon.toggle(this,'drugUseSearch')" class="ico-bottom">&nbsp;</span>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
        <div id="drugUseResultDiv"></div>
    </div>
    <div id="drugUseDetailDiv"></div>
</div>

<script type="text/javascript">
    layui.use('laydate', function () {
        var laydate = layui.laydate;

        laydate.render({
            elem: '#regBeginDateId'
            , format: 'yyyy/MM/dd'
            , max: 0
        });

        laydate.render({
            elem: '#regEndDateId'
            , format: 'yyyy/MM/dd'
            , max: 0
        });


    });

</script>