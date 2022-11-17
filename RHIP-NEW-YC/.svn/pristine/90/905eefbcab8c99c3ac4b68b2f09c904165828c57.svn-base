<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ page import="com.founder.rhip.ehr.common.RoleType" %>
<jsp:include page="../../layouts/load-js-css-resources.jsp"></jsp:include>

<c:set var="ZJSB" value="<%=RoleType.ZJSB.getValue()%>"/>
<c:set var="JFZX" value="<%=RoleType.JKJFZX.getValue()%>"/>
<c:set var="ZXJFYS" value="<%=RoleType.ZXJFYS.getValue()%>"/>

<script src="${pageContext.request.contextPath}/js/views/mhm/mhmCommon.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/mhm/clue/clueSearch.js" type="text/javascript"></script>

<div class="section" id="top_all">
    <div class="toolbar">
        <div class="x-nav">
	      <span class="layui-breadcrumb">
	        <a href="javascript:void(0)">精神障碍患者管理</a>
	        <a href="javascript:void(0)">线索登记</a>
	        <a>
	          <cite>线索浏览审核</cite></a>
	      </span>
        </div>
    </div>
    <div class="searchbox searchSection x-admin-sm">
        <form id="clueSearchForm">
            <table id="clueSearch">
                <colgroup>
                    <col style="width: 10%;"/>
                    <col style="width: 20%;"/>
                    <col style="width: 10%;"/>
                    <col style="width: 20%;"/>
                    <col style="width: 10%;"/>
                    <col style="width: 20%;"/>
                    <col style="width: 10%;"/>
                </colgroup>
                <tbody>
                <tr>
                    <td class="coltext">姓名</td>
                    <td class="colinput">
                        <input type="text" name="name" class="x-layui-input"/>
                    </td>
                    <td class="coltext">身份证号</td>
                    <td class="colinput">
                        <tag:idcardInput name="idcard" cssClass="x-layui-input"></tag:idcardInput>
                    </td>
                    <td class="coltext">登记日期</td>
                    <td class="colinput" colspan="2">
                        <%-- <tag:dateInput nullToToday="true" id="fillBeginDate" name="fillBeginDate" pattern="yyyy/MM/dd"  onlypast="true" style="width: 80px;"></tag:dateInput>
                        ~<tag:dateInput nullToToday="true" id="fillEndDate" name="fillEndDate" pattern="yyyy/MM/dd"  onlypast="true"  style="width: 80px;"></tag:dateInput> --%>
                        <input type="text" class="layui-input x-admin-sm-date" name="fillBeginDate" id="fillBeginDate"
                               style="padding-left: 0px;width: 80px;"/> ~
                        <input type="text" class="layui-input x-admin-sm-date" name="fillEndDate" id="fillEndDate"
                               style="padding-left: 0px;width: 80px;"/>
                    </td>
                </tr>
                <tr>
                    <td class="coltext">状态</td>
                    <td class="colinput">
                        <c:choose>
                            <c:when test='${ROLE==JFZX}'>
                                <ehr:dic-list id="reportStatus" name="reportStatus" dicmeta="MH00048" code="1,2,3,4,6,7"
                                              cssClass="x-layui-input"/>
                            </c:when>
                            <c:otherwise>
                                <ehr:dic-list id="reportStatus" name="reportStatus" dicmeta="MH00048" value=""
                                              cssClass="x-layui-input"/>
                            </c:otherwise>
                        </c:choose>
                    </td>
                    <c:if test="${ROLE == JFZX}">
						<td class="coltext">管理机构</td>
						<td class="colinput" colspan="4">
							<ehr:dic-town-centre-station centreName="belongCenter" stationName="fillOrganCode"
														 townName="belongTownship" width="180px;" cssClass="x-layui-input"/>
						</td>
					</c:if>
					<ehr:authorize ifAnyGranted="${ZXJFYS}">
						<td class="coltext">管理机构</td>
						<td class="colinput" colspan="4">
							<ehr:dic-org-list name="fillOrganCode" width="180px;"
											  cssClass="x-layui-input"></ehr:dic-org-list>
						</td>
					</ehr:authorize>
                </tr>
				<tr>
					<td colspan="6"></td>
					<td class="centertd">
						<!-- <input type="button" id="clueBtnSearch" value="查询" class="search_btn"/> -->
						<button class="layui-btn layui-btn-sm" id="clueBtnSearch"><i class="layui-icon">&#xe615;</i>查询
						</button>
					</td>
				</tr>
                </tbody>
            </table>
            <table>
                <tr>
                    <td colspan="6" class="colbottom">
                        <span onclick="mhmCommon.toggle(this,'clueSearch')" class="ico-bottom">&nbsp;</span>
                    </td>
                </tr>
            </table>

        </form>
    </div>
    <div id="clueResultDiv"></div>
</div>
<div id="clueDetailDiv"></div>

<script type="text/javascript">
    layui.use('laydate', function () {
        var laydate = layui.laydate;

        laydate.render({
            elem: '#fillBeginDate'
            , format: 'yyyy/MM/dd'
            , max: 0
        });

        laydate.render({
            elem: '#fillEndDate'
            , format: 'yyyy/MM/dd'
            , max: 0
        });

    });

</script>