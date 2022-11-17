<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<jsp:include page="../layouts/load-js-css-resources.jsp"></jsp:include>

<script type="text/javascript"  src="${pageContext.request.contextPath}/js/views/finance/search.js"></script>


<div class="section">
    <div  id="top_all">
        <div class="toolbar">
            <div class="x-nav">
		      <span class="layui-breadcrumb">
		        <a href="javascript:void(0)">综合管理</a>
		        <a href="javascript:void(0)">运营监管</a>
		        <a>
		        <c:if test="${type eq 'PubFinanceInfo'}">
		          <cite>公立医院收支情况</cite></a>
		        </c:if>
		         <c:if test="${type eq 'PubFinanceDetails'}">
		          <cite>公立医院收支明细</cite></a>
		        </c:if>
		      </span>
		</div>
        </div>
        <div class="searchbox searchSection x-admin-sm">
            <input type="hidden" id="searchUrl" value="${searchUrl}">
            <input type="hidden" id="type" value="${type}">
            <form id="searchForm">
                <table id="searchTable">
                    <colgroup>
                        <col style="width:10%;"/>
                        <col style="width:30%;"/>
                        <col style="width:60%;"/>
                    </colgroup>
                    <tbody>
                        <tr>
                            <td class="coltext">年月</td>
                            <td class="colinput">
                                <%-- <tag:dateInput name="yearMonth" pattern="yyyy/MM" reg="{'required':'true'}"></tag:dateInput> --%>
                                <input type="text" class="layui-input x-admin-sm-date" name="yearMonth" id="yearMonth" reg="{'required':'true'}"
                               style="width: 150px;padding-left: 0px;">
                            </td>
                            <td>
                            <!-- <input type="button" id="searchBtn" value="查询" class="search_btn"/> -->
                            <button class="layui-btn layui-btn-sm" id="searchBtn"><i class="layui-icon">&#xe615;</i>查询</button>
                            </td>
                        </tr>
                    </tbody>
                </table>
                <table>
                    <tr>
                        <td class="colbottom">
                            <span class="ico-bottom" onclick="toggle(this,'searchTable')">&nbsp;</span>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
        <div class="toolbarSection x-admin-sm">
				<a id="addBtn"><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe608;</i>新增</button></a>
		</div>
        <div id="listDiv" style="overflow: auto;">
            <jsp:include page="${listpath}" ></jsp:include>
        </div>
    </div>
    <div id="detailDiv"></div>
</div>

<script type="text/javascript">
    layui.use('laydate', function () {
        var laydate = layui.laydate;

        laydate.render({
            elem: '#yearMonth'
            ,type:'month'
            , format: 'yyyy/MM'
            , max: 0
            , trigger: 'click' 
        });
        


    });

</script>