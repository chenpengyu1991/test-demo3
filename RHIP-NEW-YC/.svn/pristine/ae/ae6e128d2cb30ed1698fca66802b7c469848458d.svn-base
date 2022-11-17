<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<jsp:include page="../../layouts/load-js-css-resources.jsp"></jsp:include>
<script src="${pageContext.request.contextPath}/js/views/ehr/child/familyVisit/search.js" type="text/javascript"></script>

<script type="text/javascript">
    layui.use('laydate', function(){
        var laydate = layui.laydate;

        //执行一个laydate实例
        laydate.render({
            elem: '#birthday'
            ,format: 'yyyy/MM/dd'
            ,max:0
        });

        //执行一个laydate实例
        laydate.render({
            elem: '#birthdayEnd'
            ,format: 'yyyy/MM/dd'
            ,max:0
        });

        //执行一个laydate实例
        laydate.render({
            elem: '#createDate'
            ,format: 'yyyy/MM/dd'
            ,max:0
        });

        //执行一个laydate实例
        laydate.render({
            elem: '#createDateEnd'
            ,format: 'yyyy/MM/dd'
            ,max:0
        });
    });
</script>

<div class="section" id="child-exam-list-box">
    
        <div class="toolbar">
			 <div class="x-nav">
		      <span class="layui-breadcrumb">
		        <a href="javascript:void(0)">儿童健康管理</a>
		        <a>
		          <cite>新生儿家庭访视管理</cite></a>
		      </span>
		</div>
        </div>
    <div class="searchBox searchSection x-admin-sm">
        <input type="hidden" id="pageIndex" value="${pageIndex}">
        <input type="hidden" id="searchType" value="${searchType}">
        <form id="searchForm">
            <table id="searchTable">
                <colgroup>
                    <col style="width: 10%; min-width: 70px;"/>
                    <col style="width: 25%; min-width: 70px;"/>
                    <col style="width: 10%; min-width: 70px;"/>
                    <col style="width: 25%; min-width: 70px;"/>
                    <col style="width: 10%; min-width: 70px;"/>
                    <col style="width: 20%; min-width: 70px;"/>
                </colgroup>
                <tbody>
                <tr>
                    <td class="col-text">新生儿姓名</td>
                    <td class="col-input">
                        <input type="text" name="name" style="width: 82%" class="x-layui-input"/>
                    </td>

                    <td class="col-text">出生日期</td>
                    <td class="col-input">
                        <input type="text" class="layui-input x-admin-sm-date" name="birthday" id="birthday" style="padding-left: 0px;width: 38%;" />
                        ~
                        <input type="text" class="layui-input x-admin-sm-date" name="birthdayEnd" id="birthdayEnd" style="padding-left: 0px;width: 38%;" />
                    </td>
                    <td class="col-text">新生儿性别</td>
                    <td class="col-input">
                        <ehr:dic-list name="gender" dicmeta="GBT226112003" cssClass="x-layui-input"></ehr:dic-list>
                    </td>
                </tr>
                <tr>
                    <td class="col-text">访视日期</td>
                    <td class="col-input">
                        <input type="text" class="layui-input x-admin-sm-date" name="createDate" id="createDate" style="padding-left: 0px;width: 38%;" />
                        ~
                        <input type="text" class="layui-input x-admin-sm-date" name="createDateEnd" id="createDateEnd" style="padding-left: 0px;width: 38%;" />
                    </td>
                    <td class="col-text">访视机构</td>
                    <td class="col-input" colspan="2">
                        <ehr:authorize ifAnyGranted="03">
                            <ehr:dic-org-list name="orgCode" isShowOneself="true" cssClass="x-layui-input"/>
                        </ehr:authorize>
                        <ehr:authorize ifAnyGranted="02,0204">
                            <ehr:dic-town-centre-station centreName="searchCenter" stationName="searchStation"
                                                         townName="searchTown" width="180px;" isShowOneself="true" cssClass="x-layui-input"/>
                        </ehr:authorize>
                        <ehr:authorize ifAnyGranted="01,11,62,63,0104">
                            <ehr:dic-town-centre-station centreName="searchCenter" stationName="searchStation"
                                                         townName="searchTown" width="180px;" isShowOneself="true" cssClass="x-layui-input"/>
                        </ehr:authorize>
                        <ehr:authorize ifAnyGranted="04,0404">
                            <ehr:dic-town-centre-station centreName="searchCenter" stationName="searchStation"
                                                         townName="searchTown" width="180px;" isShowOneself="true"
                                                         includeTownCodes="${currentLoginInfo.organization.gbCode}" cssClass="x-layui-input"/>
                        </ehr:authorize>
                    </td>
                </tr>
                <tr>
                    <td colspan="5"></td>
                    <td>
                        <button class="layui-btn layui-btn-sm" id="btnSearch"><i class="layui-icon">&#xe615;</i>查询</button>
                    </td>
                </tr>
                </tbody>
            </table>
            <table>
                <tr>
                    <td colspan="4" class="colbottom"><span onclick="toggle(this,'searchTable')" class="ico-bottom">&nbsp;</span>
                    </td>
                </tr>
            </table>
        </form>
    </div>
    <ehr:authorize ifAnyGranted="0204,0304,0404">
    <div class="toolbarSection">
        <a id="followup-add-btn">
            <button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe608;</i>新增</button>
        </a>
    </div>
    </ehr:authorize>
    <div id="childListDiv">
        <%--<jsp:include page="${listpath}"></jsp:include>--%>
    </div>
</div>
<div class="section" id="child-exam-input-box"></div>