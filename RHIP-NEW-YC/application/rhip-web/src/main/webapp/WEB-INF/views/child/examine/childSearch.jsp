<%--
  Created by IntelliJ IDEA.
  User: jingqiu
  Date: 17-3-23
  Time: 下午2:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<jsp:include page="../../layouts/load-js-css-resources.jsp"></jsp:include>
<script src="${pageContext.request.contextPath}/js/views/ehr/child/examine/organSelect.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/ehr/child/examine/childSearch.js" type="text/javascript"></script>
<div class="section" id="child-exam-list-box">
    <div class="toolbar">
		<div class="x-nav">
		      <span class="layui-breadcrumb">
		        <a href="javascript:void(0)">儿童健康管理</a>
		        <a>
		          <cite>${navigation}</cite></a>
		      </span>
		</div>
    </div>
    <div class="searchbox searchSection x-admin-sm">
        <form method="post" id="childSearchForm">
            <input type="hidden" id="examineAgeGroup" value="${examineAgeGroup}">
            <input type="hidden" name="orgCode" value="${orgCode}">
            <table id="child-health-exam-search-table">
                <colgroup>
                    <col style="min-width: 100px; width: 10%">
                    <col style="min-width: 170px; width: 23%">
                    <col style="min-width: 100px; width: 10%">
                    <col style="min-width: 170px; width: 23%">
                    <col style="min-width: 70px; width: 10%">
                    <col style="min-width: 50px; width: 23%">
                </colgroup>
                <tbody>
                <tr>
                    <td class="coltext">姓名</td>
                    <td class="colinput"><input type="text" name="name" class="x-layui-input"></td>
                    <td class="coltext">出生编号</td>
                    <td class="colinput"><input type="text" name="babyCardNo" class="x-layui-input"></td>
                    <td class="coltext">身份证号</td>
                    <td class="colinput"><input type="text" name="motherIdCard" class="x-layui-input"></td>
                </tr>
                <tr>
                    <td class="coltext">性别</td>
                    <td class="colinput"><ehr:dic-list dicmeta="GBT226112003" name="gender" id="genderCode" width="" cssClass="x-layui-input"/></td>
                    <td class="coltext">体检机构</td>
                    <td class="colinput" colspan="3">
                        <ehr:authorize ifNotGranted="04">
                            <tag:autoSelect name="checkOrganCode" id="organCode" style="width:180px" />
                        </ehr:authorize>
                        <ehr:authorize ifAnyGranted="04">
                            <ehr:dic-town-centre-station cssClass="x-layui-input" centreName="searchCenter" stationName="searchStation" townName="searchTown" width="180px;" isShowOneself="true" includeTownCodes="${currentLoginInfo.organization.gbCode}"/>
                        </ehr:authorize>
                    </td>
                </tr>
                <tr>
                    <td colspan="5"></td>
                    <td>
                        <button class="layui-btn layui-btn-sm" id="child_search_btn"><i class="layui-icon">&#xe615;</i>查询</button>
                    </td>
                    <td></td>
                </tr>
                </tbody>
            </table>
            <table>
                <tr>
                    <td colspan="6" class="colbottom"><span id="child-exam-search-toggle-btn" class="ico-bottom">&nbsp;</span></td>
                </tr>
            </table>
        </form>
    </div>
    <div class="toolbarSection">
        <ehr:authorize ifAnyGranted="0204,0304,0404">
            <a href="javascript:void(0)" id="newChildExamBtn">
                <button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe608;</i>新增</button>
            </a>
        </ehr:authorize>
    </div>
    <div id="childListDiv" class="repeattable"></div>
</div>
<div class="section" id="child-exam-input-box"></div>