<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.founder.rhip.ehr.common.RoleType" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/views/ehr/ehrbrowser/basic/referralSearch.js"/>
<c:set var="ADMIN" value="<%=RoleType.ADMIN.getValue()%>"/>	
<div class="section">
		<c:if test="${'personRecord' eq requestUrlType}">					
		<div class="toolbar">
		<div style="position: relative">
				<%--<a href="javascript:void(0)"><b class="xinz" id="addOutBtn">新增转出单</b></a>
				<a href="javascript:void(0)"><b class="xinz" id="addBackBtn">新增回转单</b></a>--%>
			<a href="javascript:void(0);" id="addOutBtn"><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe608;</i>新增转出单</button></a>
			<a href="javascript:void(0);" id="addBackBtn"><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe608;</i>新增回转单</button></a>
		</div>
		</div>
		</c:if>
<div class="searchbox searchSection x-admin-sm" >
	<form id="searchForm">
	<input type="hidden" name="requestUrlType" value="${requestUrlType}"/>
		<table id="searchTable">
			<colgroup>
				<col style="width: 13%;" />
				<col style="width: 20%;" />
				<col style="width: 10%;" />
				<col style="width: 23%;" />
				<col style="width: 10%;" />
				<col style="width: 23%;" />
			</colgroup>
			<tbody>
			<tr>		
				<td class="coltext">转诊类型</td>
				<td class="colinput"><ehr:dic-list name="dualReferralType" dicmeta="FS10286" width="150px" cssClass="x-layui-input"/></td>
				<td class="coltext">转诊日期</td>
				<td class="colinput">
				<%-- <tag:dateInput name="referralDate" pattern="yyyy/MM/dd" style="width: 150px"/> --%>
				<input type="text" class="layui-input x-admin-sm-date"  name="referralDate" id="referralDate" style="padding-left: 0px;">
				</td>
				<td>
				<!-- <input type="button" id="searchBtn" value="查询" class="search_btn"/> -->
				<button class="layui-btn layui-btn-sm" id="searchBtn"><i class="layui-icon">&#xe615;</i>查询</button>
				</td>
			</tr>
			
			</tbody>
		</table>
	</form>
</div>
<script type="text/javascript">
    layui.use('laydate', function(){
        var laydate = layui.laydate;
        
        //执行一个laydate实例
        laydate.render({
          elem: '#referralDate' 
       	   ,format: 'yyyy/MM/dd'
       	   ,max:0
        });

      });

    </script>
<div id="listDiv"></div>
</div>