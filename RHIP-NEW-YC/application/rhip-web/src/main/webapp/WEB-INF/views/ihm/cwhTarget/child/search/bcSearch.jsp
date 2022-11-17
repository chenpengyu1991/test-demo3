<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<jsp:include page="../../../../layouts/load-js-css-resources.jsp"></jsp:include>
<script src="${pageContext.request.contextPath}/js/views/ihm/cwhTarget/child/search.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/ihm/cwhTarget/cwhCommon.js" type="text/javascript"></script>
<div class="section">
    <div class="toolbar">
        <div class="x-nav">
	       <span class="layui-breadcrumb">
	        <a href="javascript:void(0)">综合管理</a>
               <a href="javascript:void(0)">妇幼保健</a>
	        <a><cite>出生医学证明</cite></a>
      	</span>
        </div>
    </div>
    <div class="searchbox searchSection x-admin-sm">
		<input type="hidden" id="pageIndex" value="${pageIndex}">
		<input type="hidden" id="searchType" value="${searchType}">
		<form id="searchForm">
            <table id="searchTable">
                <colgroup>
                    <col style="width: 10%;"/>
                    <col style="width: 20%;"/>
                    <col style="width: 10%;"/>
                    <col style="width: 20%;"/>
                    <col style="width: 10%;"/>
                    <col style="width: 20%;"/>
                </colgroup>
                <tbody>
                <tr>
                    <td class="col-text">新生儿姓名</td>
                    <td class="col-input">
                        <input type="text" name="name" >
                    </td>
                    <td class="col-text">新生儿性别</td>
                    <td class="colinput">
                        <div class="layui-form"><ehr:dic-list name="gender" dicmeta="GBT226112003" cssClass="x-layui-input"/></div>
                    </td>
                    <td class="col-text">出生日期</td>
                    <td class="col-input">
                        <input type="text" class="layui-input x-admin-sm-date"  name="birthday" id="birthday" />
                    </td>
                </tr>
                <tr>
                    <td class="col-text">出生证条形码</td>
                    <td class="col-input">
                        <input type="text" name="birthCertificateNo" >
                    </td>
                    <td class="col-text">状态</td>
                    <td class="col-input">
                        <input type="radio" name="bcStatus" value="0" checked="checked">正常
                        <input type="radio" name="bcStatus" value="1">作废
                    </td>
                    <td class="col-text">签证日期</td>
                    <td class="col-input">
                        <input type="text" class="layui-input x-admin-sm-date"  name="createDate" id="createDate" />
                    </td>
                </tr>
                <tr class="advanceSearchSection" style="display: none;">
                    <td class="col-text">签证机构</td>
                    <td class="col-input">
                        <input type="hidden" id="genreCode" name="genreCode"/>
                        <tag:autoSelect name="organCode" id="organCode"></tag:autoSelect>
                    </td>
                </tr>
                <tr>
                    <td class="righttd" colspan="6">
                        <button class="layui-btn layui-btn-sm" id="btnSearch"><i class="layui-icon">&#xe615;</i>查询</button>
                        <button class="layui-btn layui-btn-sm" id="advanceSearchConditionBtn"  ><i class="iconfont">&#x60010;</i>高级</button>
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
	<div id="childListDiv"></div>
</div>
<script type="text/javascript">
    layui.use('laydate', function(){
        var laydate = layui.laydate;

        laydate.render({
            elem: '#birthday'
            ,format: 'yyyy/MM/dd'
            ,max:0
        });
        laydate.render({
            elem: '#createDate'
            ,format: 'yyyy/MM/dd'
            ,max:0
        });
    });
</script>