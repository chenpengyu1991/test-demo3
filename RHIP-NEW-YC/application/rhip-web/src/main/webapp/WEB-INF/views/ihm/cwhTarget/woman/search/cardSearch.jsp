<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<jsp:include page="../../../../layouts/load-js-css-resources.jsp"></jsp:include>
<script src="${pageContext.request.contextPath}/js/views/ihm/cwhTarget/woman/search.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/ihm/cwhTarget/cwhCommon.js" type="text/javascript"></script>
<div class="section">
    <div class="toolbar">
        <div class="x-nav">
       <span class="layui-breadcrumb">
           <a href="javascript:void(0)">综合管理</a>
           <a href="javascript:void(0)">妇幼保健</a>
           <a><cite>孕产妇登记信息</cite></a>
        </span>
        </div>
    </div>
    <div class="searchbox searchSection x-admin-sm">
		<input type="hidden" id="pageIndex" value="${pageIndex}">
		<input type="hidden" id="searchType" value="${searchType}">
		<form id="searchForm">
            <table id="searchTable">
                <colgroup>
                    <col style="width: 10%; min-width: 70px;"/>
                    <col style="width: 20%; min-width: 70px;"/>
                    <col style="width: 10%; min-width: 70px;"/>
                    <col style="width: 20%; min-width: 70px;"/>
                    <col style="width: 10%; min-width: 70px;"/>
                    <col style="width: 20%; min-width: 70px;"/>
                </colgroup>
                <tbody>
                <tr>
                    <td class="col-text">姓名</td>
                    <td class="col-input">
                        <input type="text" name="name" >
                    </td>
                    <td class="col-text">身份证号</td>
                    <td class="col-input">
                        <input type="text" name="idCard" >
                    </td>
                    <td class="col-text">出生日期</td>
                    <td class="col-input">
                        <input type="text" class="layui-input x-admin-sm-date"  name="birthday" id="birthday" />
                    </td>
                </tr>
                <tr>
                    <td class="righttd" colspan="6">
                        <button class="layui-btn layui-btn-sm" id="btnSearch"><i class="layui-icon">&#xe615;</i>查询</button>
                    </td>
                </tr>
                </tbody>
            </table>
			<table>
				<tr>
					<td colspan="4" class="col-bottom"><span onclick="toggle(this,'searchTable')" class="ico-bottom">&nbsp;</span></td>
				</tr>
			</table>
		</form>
	</div>
	<div id="womanListDiv">
		<%--<jsp:include page="${listpath}"></jsp:include>--%>
	</div>
</div>
<script type="text/javascript">
    layui.use('laydate', function(){
        var laydate = layui.laydate;

        laydate.render({
            elem: '#birthday'
            ,format: 'yyyy/MM/dd'
            ,max:0
        });
    });
</script>