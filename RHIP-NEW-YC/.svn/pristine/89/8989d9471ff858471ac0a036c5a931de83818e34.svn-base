<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<jsp:include page="../../layouts/load-js-css-resources.jsp"></jsp:include>

<%-- <script src="${pageContext.request.contextPath}/js/views/wsMonitor/serviceRegister/search2.js" type="text/javascript"></script> --%>
<!-- <script type="text/javascript">
	require(['views/wsMonitor/serviceRegister/search'],function(serviceRegisterSearch){
		serviceRegisterSearch.load();
	});
</script> -->

<div class="section">
	<div class="toolbar">
		<!-- <a href="javascript:void(0)" id="serviceInfoAddBut"><b class="xinz">新增</b></a> -->
		<a ihref="javascript:void(0)" id="serviceInfoAddBut"><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe608;</i>新增</button></a>
		<a href="javascript:void(0)" id="serviceInfoBackBut" style="display: none;"><b class="fanhui">返回</b></a>
		<a href="javascript:void(0)" id="serviceInfoSaveBut" style="display: none;"><b class="baocun">保存</b></a>
	</div>
	<div id="searchDiv" class="searchbox">
		<form id="serviceInfoForm" name="serviceInfoForm" action="" method="post">
			<table id="serviceInfoSearch">
				<colgroup>
                    <col style="width: 10%"/>
                    <col style="width: 20%"/>
                    <col style="width: 10%"/>
                    <col style="width: 30%"/>
                    <col style="width: 10%"/>
					<col style="width: 10%"/>
					<col style="width: 10%"/>
				</colgroup>
     			<tbody>
				<tr>
					<td class="coltext">接口名称(KEY)</td>
					<td class="colinput">
                         <input type="text" id="webServiceName" name="webServiceName" />
                    </td>
                    <td class="coltext">服务器地址</td>
                    <td class="colinput">
						<input type="text" id="wsdl" name="wsdl" />
					</td>
					<td class="coltext">服务器开关</td>
					<td class="colinput">
						<ehr:dic-list name="serverStatus" dicmeta="FS990018" width="100px;" />
					</td>
					<td class="colinput">
						<input type="button" id="serviceInfoSearchBut" value="查询" class="search_btn" />
					</td>
				</tr>
				<%--<tr>--%>
					<%--<td class="coltext">服务器状态</td>--%>
					<%--<td class="colinput">--%>
						<%--<ehr:dic-list name="serverFlag" dicmeta="FS990018" width="100px;" />--%>
					<%--</td>--%>
				<%--</tr>--%>
				</tbody>
			</table>
         	<table>
				<tr>
					<td colspan="4" class="colbottom">
						<span onclick="serviceRegisterSearch.toggle(this,'serviceInfoSearch')" class="ico-bottom">&nbsp;</span>
					</td>
				</tr>
         	</table>
		</form>
 	</div>
	<div id="listDiv"></div>
	<div id="detailDiv"></div>
</div>