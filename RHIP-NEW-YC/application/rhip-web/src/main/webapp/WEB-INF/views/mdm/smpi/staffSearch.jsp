<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<jsp:include page="../../layouts/load-js-css-resources.jsp"></jsp:include>

<script src="${pageContext.request.contextPath}/js/views/mdm/smpi/mdmStaff.js" type="text/javascript"></script>
<script type="text/javascript">
    $(function () {
        staffSearch.atStart();
    });
</script>

<%@ page import="com.founder.rhip.ehr.common.RoleType" %>
<c:set var="ADMIN" value="<%=RoleType.ADMIN.getValue()%>"/>
<c:set var="YY_GLY" value="<%=RoleType.YY_GLY.getValue()%>"/>
<c:set var="ZX_GLY" value="<%=RoleType.ZX_GLY.getValue()%>"/>
<c:set var="Z_GLY" value="<%=RoleType.Z_GLY.getValue()%>"/>

<div class="section" id="staffSearchDiv">
	<div id="search">
		<div class="toolbar">
			<div class="x-nav">
		      <span class="layui-breadcrumb">
		        <a href="javascript:void(0)">系统管理</a>
		        <a href="javascript:void(0)">卫生资源</a>
		        <a>
		          <cite>医务人员</cite></a>
		      </span>
		</div>
		</div>
		<div class="searchbox searchSection x-admin-sm">
			<form:form method="post" modelAttribute="condition" action="${ctx}/staff/getStaffMain" id="searchCondition" name="searchCondition">
				<table id="searchTable">
					<colgroup>
						<col style="width: 10%;"/>
						<col style="width: 17%;"/>
						<col style="width: 10%;"/>
						<col style="width: 17%;"/>
						<col style="width: 10%;"/>
						<col />
						<col style="width: 12%;"/>
					</colgroup>
					<tbody>
					<tr>
						<td class="coltext">姓名</td>
						<td class="colinput"><form:input path="name" type="text" cssClass="x-layui-input"/>
								<%--<form:input path="useCpy" type="checkbox" value="cpy"/>拟音&nbsp;
                                <form:input path="useLike" type="checkbox" value="like"/>模糊--%>
						</td>
						<td class="coltext">性别</td>
						<td class="colinput">
							<form:select path="gender" class="select" cssClass="x-layui-input">
								<form:option value="">请选择</form:option>
								<ehr:dicItems dicmeta="GBT226112003"/>
							</form:select>
						</td>
						<td class="coltext">出生日期</td>
						<td class="col-input">
							<%-- <tag:dateInput nullToToday="true" id="beginDate" name="beginDate" pattern="yyyy/MM/dd"  onlypast="true" style="width: 75px;"></tag:dateInput>
							~<tag:dateInput nullToToday="true" id="endDate" name="endDate" pattern="yyyy/MM/dd"  onlypast="true"  style="width: 75px;"></tag:dateInput> --%>
							<input type="text" class="layui-input x-admin-sm-date"  name="beginDate" id="beginDate" style="padding-left: 0px;width: 75px;;" /> ~
                            <input type="text" class="layui-input x-admin-sm-date"  name="endDate" id="endDate" style="padding-left: 0px;width: 75px;;" />
						</td>
					</tr>
					<tr>

						<td class="coltext">身份证号</td>
						<td class="colinput"><input name="idCard" type="text" value="${staff.idCard}" class="x-layui-input"/></td>

							<%--  <td class="coltext">本人电话</td>
                            <td class="colinput"><input type="text" name="mobile" value="${staff.mobile}"/></td> --%>
						<td class="coltext">职称</td>
						<td class="colinput"><ehr:dic-list name="technical" dicmeta="FS10011" value="${staff.technical}" cssClass="x-layui-input"/></td>
						<td class="coltext">年龄段</td>
						<td class="colinput"><input type="text" name="ageFrom" style="width: 75px;" class="x-layui-input"> ~ <input type="text" name="ageTo" style="width: 75px;" class="x-layui-input"></td>

					</tr>
					<tr>
						<td class="coltext">所在机构</td>
						<td class="colinput" colspan="5">
							<ehr:authorize ifAnyGranted="${ADMIN}">
								<ehr:medical-organ centreName="village" stationName="station" townName="town"
															  townId="searchTown" centreId="searchCenter" stationId="searchStation" width="150px"
															 isShowHealthOversight="true" cssClass="x-layui-input" isShow="true" isShowOther="true" isShowJk="true" shoQwjw="true" isShowOneself="true"/>
								<form:input id="searchTownCode" path="townCode" type="hidden"/>
								<form:input id="searchStationCode" path="stationCode" type="hidden"/>
								<form:input id="searchOrganCode" path="organCode" type="hidden"/>
							</ehr:authorize>
							<ehr:authorize ifAnyGranted="${YY_GLY}">
								<ehr:org-type-list name="stationCode" type="hospital" width="30%;" cssClass="x-layui-input"/>
							</ehr:authorize>

							<ehr:authorize ifAnyGranted="${ZX_GLY}">
								<ehr:org-type-list name="stationCode" parentCode="${currentLoginInfo.organization.organCode}"
												   includeParent="true" width="30%;" cssClass="x-layui-input"/>
							</ehr:authorize>

							<ehr:authorize ifAnyGranted="${Z_GLY}">
							<select name="stationCode" style="width: 30%;">
								<option value="${currentLoginInfo.organization.organCode}">
									<ehr:org code="${currentLoginInfo.organization.organCode}"/>

								</option>
							</select>
							</ehr:authorize>

						<td><!-- <input id="searchButton" type="button" value="查询" onclick="" class="search_btn"/> -->
						<button class="layui-btn layui-btn-sm" id="searchButton"><i class="layui-icon">&#xe615;</i>查询</button>
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
			</form:form>
		</div>
	</div>
	<div class="toolbarSection">
		<!-- <a href="#" id="addBtn"><b class="xinz">新增</b></a> -->
		<a href="#" id="addBtn"><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe608;</i>新增</button></a>
	</div>
	<div id="staffList" class="listDiv">
		<div id="resultDiv"></div>
	</div>
</div>
<div id="staffCreateDiv"></div>
<script type="text/javascript">
    layui.use('laydate', function(){
        var laydate = layui.laydate;
        
        laydate.render({
          elem: '#beginDate' 
       	   ,format: 'yyyy/MM/dd'
       	   ,max:0
        });

        laydate.render({
          elem: '#endDate'
           ,format: 'yyyy/MM/dd'
        	   ,max:0
        });
        
        
      });
    

    </script>
