<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<%@ page import="com.founder.rhip.ehr.common.RoleType" %>
<c:set var="ADMIN" value="<%=RoleType.ADMIN.getValue()%>"/>
<jsp:include page="../../layouts/load-js-css-resources.jsp"></jsp:include>
<script src="${pageContext.request.contextPath}/js/views/oh/occPatient/reportSearch.js" type="text/javascript"></script>
<div class="section" id="mainSearchDiv">
	<div id="top_all">
		<div class="toolbar">
			<ehr:authorize ifNotGranted="${ADMIN}">
				<a id="initAddReport"><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe608;</i>新增</button></a>
			</ehr:authorize>
		</div>
		<div class="searchbox searchSection x-admin-sm">
			<form id="occPatientSearchForm">				
                <table id="occPatientSearch" >
				<colgroup>
					<col style="min-width:70px; width: 10%;"/>
					<col style="min-width:160px; width: 20%;"/>
                    <col style="min-width:80px; width: 10%;"/>
					<col style="min-width: 210px;width: 20%; "/>
                    <col style="min-width:60px; width: 10%;"/>
					<col style="min-width:160px; width: 20%;"/>
				</colgroup>		
					<tbody>
						<tr>
							<td class="coltext">姓名</td>
                            <td class="colinput">
                                <input type="text" id="name" name="name" />
                            </td>
							<td class="coltext">身份证号</td>
							<td class="col-input" >
								<tag:idcardInput id="idcard" name="idcard"  style="ime-mode:Disabled;" ></tag:idcardInput>
							</td>
							<td class="coltext">性别</td>
		                    <td >
		                    	<ehr:dic-list name="gender" dicmeta="FS10006"/>
		                    </td>
						</tr>
						<tr>
							 <td class="coltext">上报日期</td>
							<td class="col-input" >
								<input type="text" class="layui-input x-admin-sm-date"  name="reportDateFrom" id="reportDateFrom" style="padding-left: 0px;width: 36%;"/> ~<input type="text" class="layui-input x-admin-sm-date"  name="reportDateTo" id="reportDateTo" style="padding-left: 0px;width: 36%;" />
							</td>
							<td ></td>
							<td ></td>
							<td ></td>
							<td align="left">
								<button class="layui-btn layui-btn-sm" id="odReportSearchBtn"><i class="layui-icon">&#xe615;</i>查询</button>
							</td>
						</tr>
					</tbody>
				</table>
                <table>
	                <tr>
	                    <td colspan="6" class="colbottom">
	                          <span onclick="occPatientReportSearch.toggle(this,'occPatientSearch')" class="ico-bottom">&nbsp;</span>
	                    </td>
	                </tr>
				</table>

			 </form>
		</div>
		<div id="resultDiv">
        </div>
	</div>
	<div id="detailDiv" ></div>
</div>
<div id="operationDiv" style="padding-top:15px"></div>
<script type="text/javascript">
    layui.use('laydate', function(){
        var laydate = layui.laydate;

        laydate.render({
            elem: '#reportDateFrom'
            ,format: 'yyyy/MM/dd'
            ,max:0
        });

        laydate.render({
            elem: '#reportDateTo'
            ,format: 'yyyy/MM/dd'
            ,max:0
        });
    });
</script>