<%@ page import="com.founder.rhip.ehr.common.RoleType" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr" %>
<jsp:include page="../layouts/load-js-css-resources.jsp"></jsp:include>

<c:set var="ADMIN" value="<%=RoleType.ADMIN.getValue()%>"/>
<c:set var="JKJKDN" value="<%=RoleType.JKJKDN.getValue()%>"/>
<c:set var="ZXJKDN" value="<%=RoleType.ZXJKDN.getValue()%>"/>
<c:set var="YY_GLY" value="<%=RoleType.YY_GLY.getValue()%>"/>
<c:set var="ZJKDN" value="<%=RoleType.ZJKDN.getValue()%>"/>
<c:set var="QWGZX" value="<%=RoleType.QWGZX.getValue()%>"/>

<script type="text/javascript" src="${pageContext.request.contextPath}/js/views/ehr/family/search.js"></script>

<div class="section">
    <div>
            <div class="toolbar">
            	<div class="x-nav">
			      	<span class="layui-breadcrumb">
			        <a href="javascript:void(0)">居民健康档案</a>
			        <a>
			          <cite>家庭档案</cite></a>
			      	</span>
		    		</div>
            </div>
        <div class="searchbox searchSection x-admin-sm">
            <form id="searchOtherFamilyRecord">
                <input type="hidden" id="selectFlagInput" name="selectFlagName" value="0"/>
                <table id="reportSearch">
                    <colgroup>
                        <col width="10%;"/>
                        <col width="23%;"/>
                        <col width="10%;"/>
                        <col width="23%;"/>
                        <col width="10%;"/>
                        <col width="24%;"/>
                    </colgroup>
                    <tr>
                        <td class="coltext">户主身份证号</td>
                        <td class="colinput"><input type="text" name="householderIdcard" style="width: 90%"
                                                    class="x-layui-input"/></td>
                        <td class="coltext">成员姓名</td>
                        <td class="colinput"><input type="text" name="memberLink" style="width: 100%"
                                                    class="x-layui-input"/></td>
                        <td class="coltext">家庭住址</td>
                        <td class="colinput"><input type="text" name="address" style="width: 80%"
                                                    class="x-layui-input"/></td>
                    </tr>
                    <tr>
                        <td class="coltext">档案状态</td>
                        <td class="colinput">
                            <select name="status" style="width: 80%;">
                                <option value="-1">请选择</option>
                                <option value="0">已建档</option>
                                <%--<option value="1">审核中</option>--%>
                                <option value="2">已结案</option>
                                <%--<option value="3">已退回</option>--%>
                            </select>
                        </td>
                        <td class="coltext">管理机构</td>
                        <td colspan="3">
                            <ehr:authorize ifAnyGranted="${ZJKDN}">
                                <ehr:dic-org-list name="centerOrgCode" width="19.5%;"/>
                            </ehr:authorize>
                            <ehr:authorize ifAnyGranted="${YY_GLY}">
                                <ehr:dic-org-list name="centerOrgCode" defaultval="N" width="19.5%"
                                                  isShowOneself="true"/>
                            </ehr:authorize>
                            <ehr:authorize ifAnyGranted="${ADMIN},${JKJKDN},${QWGZX}">
                                <ehr:dic-town-centre-station centreName="searchCenter" stationName="searchstation"
                                                             townName="searchTown" width="19.5%;" isShowOneself="true"
                                                             includeTownCodes="${includeTownCodes}"/>
                            </ehr:authorize>
                            <ehr:authorize
                                    ifAnyGranted="${ZXJKDN},0201,0202,0203,0204,0205,0206,0207,0208,0209,0210,0211,0212,0213,0214,0215,0216,0217,0218,0219,0221">
                                <ehr:dic-org-list name="centerOrgCode" width="19.5%;" defaultval="N"
                                                  isShowOneself="true"/>
                            </ehr:authorize>
                        </td>
                    </tr>
                    <tr>
                        <td class="righttd" colspan="6">
                            <button class="layui-btn layui-btn-sm" id="familySearchOtherBtn"><i class="layui-icon">&#xe615;</i>查询</button>
                            <%-- <input type="button" name="button" id="familySearchOtherBtn" value="查询" class="search_btn"/> --%>
                        </td>
                    </tr>
                </table>
                <table>
                    <tr>
                        <td colspan="6" class="colbottom">
                            <span id="familySearchToggle" onclick="familySearch.toggle(this,'reportSearch')"
                                  class="ico-bottom">&nbsp;</span>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
</div>
<!-- <div id="familyResultDiv" > </div> -->
<%-- <div>
    <ul id=tags>
	    <li class=selectTag>
	        <a id="tag1" href="javascript:void(0)">列表显示</a>
	    </li>
	    <li>
	        <a id="tag2" href="javascript:void(0)">卡片显示</a>
	    </li>
	</ul>
	<div id="tagContent" style="width: 99.5%">
	   	<div id=tagContent0 class="selectTag">
	   		<div id="familyRecordListDiv"></div>
	   	</div>
	 	<div id="tagContent1" style="display:none" >
	 		<div id="familyRecordCardDiv"></div>
	 	</div>
	</div>
	<input type="hidden" id="familyId"/>
</div> --%>
<ehr:authorize ifAnyGranted="${ZJKDN},${ZXJKDN}">
    <div class="toolbarSection">
        <a href="javascript:void(0)" id="familyAdd">
            <button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe608;</i>新增</button>
        </a>
    </div>
</ehr:authorize>

<div class="layui-tab layui-tab-card" lay-filter="familyEhr" style="width: 98%;margin-left: 8px;">
    <ul class="layui-tab-title">
        <li class="layui-this">列表显示</li>
        <li>卡片显示</li>
    </ul>
    <div class="layui-tab-content">
        <div class="layui-tab-item layui-show" id="familyRecordListDiv"></div>
        <div class="layui-tab-item" id="familyRecordCardDiv"></div>
    </div>
    <input type="hidden" id="familyId"/>
</div>

<script>
    //注意：选项卡 依赖 element 模块，否则无法进行功能性操作
    layui.use('element', function () {
        var element = layui.element;
//一些事件监听
        element.on('tab(familyEhr)', function (data) {
            if (data.index == 0) {
                familySearch.viewList();
            } else if (data.index == 1) {
                familySearch.viewCard();
            }
        });
    });
</script>