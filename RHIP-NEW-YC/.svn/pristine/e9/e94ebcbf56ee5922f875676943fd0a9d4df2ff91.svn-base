<%@ page import="com.founder.rhip.ehr.common.RoleType" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<jsp:include page="../../layouts/load-js-css-resources.jsp"></jsp:include>

<c:set var="ADMIN" value="<%=RoleType.ADMIN.getValue()%>"/>
<c:set var="QWGZX" value="<%=RoleType.QWGZX.getValue()%>"/>
<c:set var="JKJKJY" value="<%=RoleType.JKJKJY.getValue()%>"/>
<c:set var="ZXJKJY" value="<%=RoleType.ZXJKJY.getValue()%>"/>
<c:set var="ZJKJY" value="<%=RoleType.ZJKJY.getValue()%>"/>

<script src="${pageContext.request.contextPath}/js/views/he/individual/search.js" type="text/javascript"></script>
<div class="section">
	<ehr:authorize ifNotGranted="${QWGZX},${ADMIN }">
	<div class="toolbar">
		<!-- <a id="individualAdd" href="javascript:void(0)"><b id="btnReflashLabel" class="xinz">新增</b></a> -->
		<a id="individualAdd" href="javascript:void(0)"><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe608;</i>新增</button></a>
	</div>
	</ehr:authorize>
	<div class="searchBox searchSection x-admin-sm">
		<form id="heIndividualSearchForm">
			<table id="healthEducationSearch">
				<colgroup>
					<col style="min-width: 70px; width: 11%;" />
					<col style="min-width: 140px; width: 21%;" />
					<col style="min-width: 70px; width: 11%;" />
					<col style="min-width: 100px; width: 18%;" />
					<col style="min-width: 70px; width: 10%;" />
					<col style="min-width: 160px; width: 26%;" />
					<col style="width: 100px;" />
				</colgroup>
				<tbody>
							<tr>
								<td class="col-text">时间</td>
								<td colspan="2" class="col-input"><%-- <tag:dateInput name="createBeginTime" id="createBeginTime" date="${currentYearStartDate}"  style="width:35%;" /> ~ <tag:dateInput name="createEndTime" id="createEndTime"
										style="width:35%;" /> --%>
									<input type="text" class="layui-input x-admin-sm-date"  name="createBeginTime" id="createBeginTime" style="padding-left: 0px;width:35%;" value="<fmt:formatDate value='${currentYearStartDate}' pattern='yyyy/MM/dd'/>" /> ~
                            <input type="text" class="layui-input x-admin-sm-date"  name="createEndDate" id="createEndDate" style="padding-left: 0px;width:35%;" />	
										</td>
										
							<td class="col-text">身份证号</td>
                        	<td class="col-input" colspan="2">
                        		<tag:idcardInput name="idcard" id="idCard" style="width: 60%" cssClass="x-layui-input"></tag:idcardInput>
                        	</td>
							</tr>
							
							<tr>
								<td class="col-text">
									<ehr:authorize ifAnyGranted="${ZJKJY},${ZXJKJY},${ADMIN},${JKJKJY},${QWGZX}">
									机构
								</ehr:authorize>
								</td>
								<td colspan="3" class="col-input">
                                    <ehr:authorize ifAnyGranted="${ZJKJY},${ZXJKJY}">
										<ehr:dic-org-list name="orgCode" width="130px" isShowOneself="true" cssClass="x-layui-input"/>
									</ehr:authorize>
                                    <ehr:authorize ifAnyGranted="${ADMIN},${JKJKJY}">
										<input type="hidden" id="isADMIN" value="01"/>
                                            <ehr:dic-town-centre-station centreName="centerOrgCode" stationName="orgCode" townName="gbcode" width="130px;" isShowOther="true" isShowOneself="true" cssClass="x-layui-input"/>
                                    </ehr:authorize>
									<ehr:authorize ifAnyGranted="${QWGZX}">
											<ehr:dic-town-centre-station centreName="centerOrgCode" stationName="orgCode" townName="gbcode" width="130px;"  isShowOneself="true" includeTownCodes="${currentLoginInfo.organization.gbCode}" cssClass="x-layui-input"/>
									</ehr:authorize>
                                </td>
                                <td>
                                <td rowspan="1"><!-- <input type="button" id="heIndividualBtnSearch" value="查询" class="search_btn" /> -->
                                <button class="layui-btn layui-btn-sm" id="heIndividualBtnSearch"><i class="layui-icon">&#xe615;</i>查询</button>
                                </td>
                                </td>
							</tr>
							<tr>
								
							</tr>
				</tbody>
			</table>
		</form>
	</div>
	<div id="heIndividualResultDiv"></div>
</div>

<script type="text/javascript">
layui.use('laydate', function(){
    var laydate = layui.laydate;
    
    laydate.render({
      elem: '#createBeginTime' 
   	   ,format: 'yyyy/MM/dd'
   	   ,max:0
    });
    
    laydate.render({
        elem: '#createEndDate' 
     	   ,format: 'yyyy/MM/dd'
     	   ,max:0
      });
    
  });
</script>