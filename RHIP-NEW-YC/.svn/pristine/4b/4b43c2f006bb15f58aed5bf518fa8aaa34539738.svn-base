<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="com.founder.rhip.ehr.common.RoleType" %>
<%@ page import="com.founder.rhip.idm.common.ReportStatus" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<c:set var="JKFYK" value="<%=RoleType.JKFYK.getValue()%>" />
<c:set var="YYCRB" value="<%=RoleType.YYCRB.getValue()%>" />
<c:set var="ZXCRB" value="<%=RoleType.ZXCRB.getValue()%>"/>
<c:set var="CANCEL" value="<%=ReportStatus.CANCEL.getValue()%>"/>

<div class="repeattable">
	<table class="layui-table x-admin-sm-table-list-middle">
		<colgroup>
			<col style="min-width:70px;width: 7%;"/>
	        <col style="min-width:50px;width: 5%;"/>
			<col style="min-width:50px;width: 5%;"/>
	        <col style="min-width:90px;width: 7%;"/>
	        <col style="min-width:80px;width: 7%;"/>
			<col style="min-width:100px;width: 9%;"/>
			<col style="min-width:80px;width: 9%;"/>
			<col style="min-width:80px;width: 7%;"/>
            <col style="min-width:60px;width: 8%;"/>
            <col style="min-width:60px;width: 8%;"/>
            <col style="min-width:60px;width: 8%;"/>
            <col style="min-width:60px;width: 6%;"/>
            <ehr:authorize ifAnyGranted="${ZXCRB},${YYCRB},${JKFYK}">
            	<col style="min-width:60px;"/>
				<col style="width:100px;"/>
            </ehr:authorize>
		</colgroup>
		<thead>
			<tr>
				<th>姓名</th>
                <th>性别</th>
				<th>年龄</th>
				<th>疾病名称</th>
				<th>疾病类型</th>
				<th>现住地</th>
                <th>上报单位</th>
				<%--<th>类型</th>--%>
				<th>职业</th>
				<th>发病日期</th>
				<th>诊断时间</th>
                <th>录入时间</th>
                <th>报卡来源</th>
                <ehr:authorize ifAnyGranted="${ZXCRB},${YYCRB},${JKFYK}">
                	<th>审核状态</th>
					<th>操作</th>
				</ehr:authorize>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="report" items="${reports.list}" varStatus="status">
				<tr>
					<td class="centertd" title="${report.name}"><a href="javascript:void(0)" onclick="reportSearch.detail(${report.id})"class="person-link-btn">${report.name}</a></td>
                    <td class="centertd"><ehr:dic dicmeta="GBT226112003" code="${report.gender}" /></td>
					<td title="${report.age}" class="centertd">${report.age}<ehr:dic dicmeta="IDM00003" code="${report.ageUnit}" /></td>
					<td style="text-align: left;" title="${report.infectiousName}">${report.infectiousName}</td>
					<td class="centertd"><ehr:tip><ehr:dic dicmeta="CV0501002" code="${report.caseCategory}"/></ehr:tip></td>
					<td title="${report.paAddress}">${report.paAddress}</td>
                    <td title="${report.fillOrganName}">${report.fillOrganName}</td>
					<%--<td class="centertd"><ehr:dic  dicmeta="FS10063" code="${report.infectiousType}" /></td>--%>
					<td><ehr:dic  dicmeta="GBT6565" code="${report.occupation}" /></td>
					<td class="centertd"><fmt:formatDate value="${report.pathogenesisDate}" pattern="yyyy/MM/dd" /></td>
					<td class="centertd"><ehr:tip><fmt:formatDate value="${report.diagnosisDate}" pattern="yyyy/MM/dd HH:mm:ss" /></ehr:tip></td>
					<td class="centertd"><fmt:formatDate value="${report.fillDate}" pattern="yyyy/MM/dd" /></td>
                    <td class="centertd"><ehr:tip><ehr:dic dicmeta="IDM00408" code="${report.reportSource}"/></ehr:tip></td>
                    <ehr:authorize ifAnyGranted="${ZXCRB},${YYCRB},${JKFYK}">
                    	<td class="centertd" title="<c:if test="${report.deleteContent != 99}"><ehr:dic  dicmeta='IDM00379' code='${report.deleteContent}' /></c:if><c:if test="${report.deleteContent == 99}">${report.deleteContentOther}</c:if>">
                                <ehr:dic code="${report.reportStatus}" dicmeta="PH00006"/>
                    	</td>
						<td class="centertd">
							<c:choose>
								<c:when test="${report.reportStatus == 2 && report.isOperate == 3}">
									<label class="loadclass">专项处置&nbsp;</label>&nbsp;
								</c:when>
								<c:when test="${report.reportStatus ==2 && report.isOperate == 4}">
									<label class="loadclass">&nbsp;</label>&nbsp;
								</c:when>
								<%-- <c:when test="${report.approvalFlg==1}">
									<a href="javascript:void(0)" onclick="reportSearch.edit(${report.id})"class="person-link-btn">报卡审核</a>&nbsp;
								</c:when>	 --%>	
								 <c:when test="${(ROLE==ZXCRB || ROLE== YYCRB) && report.reportStatus==1}">
									<%-- <a href="javascript:void(0)" onclick="reportSearch.edit(${report.id})"class="person-link-btn">报卡审核</a>&nbsp; --%>
									<a href="javascript:void(0)" onclick="reportSearch.edit(${report.id})"class="person-link-btn layui-btn layui-btn-warm layui-btn-xs" style="color: #FFF;font-size: 12px;" title="报卡审核"  ><i class="layui-icon">&#xe672;</i>审核</a>&nbsp;
								</c:when>
								<%--如果报卡已经审核通过，且角色为SQZX,可以修改报卡--%>						
								<c:when test="${(ROLE==ZXCRB || ROLE== YYCRB) && report.reportStatus==2}">
									<%-- <a href="javascript:void(0)" onclick="reportSearch.edit(${report.id})"class="person-link-btn">报卡修改</a> --%>
									<a href="javascript:void(0)" onclick="reportSearch.edit(${report.id})" class="person-link-btn layui-btn layui-btn-xs" style="color: #FFF;font-size: 12px;" title="报卡修改"><i class="layui-icon">&#xe642;</i>修改</a>
									&nbsp;
				 				</c:when>
								<c:when test="${ROLE==JKFYK && report.reportStatus==1}">
									  等待审核&nbsp;
								</c:when>
                                <c:when test="${ROLE==JKFYK && report.reportStatus==2 && report.fillOrganCode==currentOrgCode}">
                                    <%-- <a href="javascript:void(0)" onclick="reportSearch.edit(${report.id})"class="person-link-btn">报卡修改</a> --%>
                                    <a href="javascript:void(0)" onclick="reportSearch.edit(${report.id})" class="person-link-btn layui-btn layui-btn-xs" style="color: #FFF;font-size: 12px;" title="报卡修改"><i class="layui-icon">&#xe642;</i>修改</a>
                                    &nbsp;
                                </c:when>
								<c:when test="${ROLE==JKFYK && report.reportStatus==3}">
                                </c:when>
							</c:choose>
						</td>
					</ehr:authorize>

				</tr>
			</c:forEach>
			<tr>
				<ehr:authorize ifAnyGranted="${ZXCRB},${YYCRB},${JKFYK}">
				<ehr:pagination action="reportSearch.search" colspan="14`"/>
				</ehr:authorize>
				<ehr:authorize ifNotGranted="${ZXCRB},${YYCRB},${JKFYK}">
				<ehr:pagination action="reportSearch.search" colspan="12`"/>
				</ehr:authorize>
			</tr>
		</tbody>
	</table>
	
	<%-- <table>
		<tr>
			<ehr:pagination action="reportSearch.search" />
		</tr>
	</table> --%>
</div>












<!-- 三级审核 -->
<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="com.founder.rhip.ehr.common.RoleType" %>
<%@ page import="com.founder.rhip.idm.common.ReportStatus" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<c:set var="JKFYK" value="<%=RoleType.JKFYK.getValue()%>" />
<c:set var="YYCRB" value="<%=RoleType.YYCRB.getValue()%>" />
<c:set var="ZXCRB" value="<%=RoleType.ZXCRB.getValue()%>"/>
<c:set var="CANCEL" value="<%=ReportStatus.CANCEL.getValue()%>"/>

<script src="${pageContext.request.contextPath}/js/views/idm/report/search.js" type="text/javascript"></script>


<div class="repeattable">
	<table>
		<colgroup>
			<col style="min-width:70px;width: 7%;"/>
	        <col style="min-width:50px;width: 5%;"/>
			<col style="min-width:50px;width: 5%;"/>
	        <col style="min-width:90px;width: 7%;"/>
	        <col style="min-width:80px;width: 7%;"/>
			<col style="min-width:100px;width: 9%;"/>
			<col style="min-width:80px;width: 9%;"/>
			<col style="min-width:80px;width: 7%;"/>
            <col style="min-width:60px;width: 8%;"/>
            <col style="min-width:60px;width: 8%;"/>
            <col style="min-width:60px;width: 8%;"/>
            <col style="min-width:60px;width: 6%;"/>
            <ehr:authorize ifAnyGranted="${ZXCRB},${YYCRB},${JKFYK}">
            	<col style="min-width:60px;"/>
				<col style="min-width:70px;width:70px;"/>
            </ehr:authorize>
		</colgroup>
		<thead>
			<tr>
				<th>姓名</th>
                <th>性别</th>
				<th>年龄</th>
				<th>疾病名称</th>
				<th>疾病类型</th>
				<th>现住地</th>
                <th>上报单位</th>
				<th>类型</th>
				<th>职业</th>
				<th>发病日期</th>
				<th>诊断时间</th>
                <th>录入时间</th>
                <th>报卡来源</th>
                <ehr:authorize ifAnyGranted="${ZXCRB},${YYCRB},${JKFYK}">
                	<th>审核状态</th>
					<th>操作</th>
				</ehr:authorize>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="report" items="${reports.list}" varStatus="status">
				<tr>
					<td title="${report.name}"><a href="javascript:void(0)" onclick="reportSearch.detail(${report.id})"class="person-link-btn">${report.name}</a></td>
                    <td class="centertd"><ehr:dic dicmeta="GBT226112003" code="${report.gender}" /></td>
					<td title="${report.age}" class="centertd">${report.age}<ehr:dic dicmeta="IDM00003" code="${report.ageUnit}" /></td>
					<td title="${report.infectiousName}">${report.infectiousName}</td>
					<td><ehr:tip><ehr:dic dicmeta="CV0501002" code="${report.caseCategory}"/></ehr:tip></td>
					<td title="${report.paAddress}">${report.paAddress}</td>
                    <td title="${report.fillOrganName}">${report.fillOrganName}</td>
					<td class="centertd"><ehr:dic  dicmeta="FS10063" code="${report.infectiousType}" /></td>
					<td class="centertd"><ehr:dic  dicmeta="GBT6565" code="${report.occupation}" /></td>
					<td class="centertd"><fmt:formatDate value="${report.pathogenesisDate}" pattern="yyyy/MM/dd" /></td>
					<td class="centertd"><ehr:tip><fmt:formatDate value="${report.diagnosisDate}" pattern="yyyy/MM/dd HH:mm:ss" /></ehr:tip></td>
					<td class="centertd"><fmt:formatDate value="${report.fillDate}" pattern="yyyy/MM/dd" /></td>
					<td><ehr:tip><ehr:dic dicmeta="IDM00408" code="${report.reportSource}"/></ehr:tip></td>
                    <ehr:authorize ifAnyGranted="${ZXCRB},${YYCRB},${JKFYK}">
                    	<td class="centertd" title="<c:if test="${report.deleteContent != 99}"><ehr:dic  dicmeta='IDM00379' code='${report.deleteContent}' /></c:if><c:if test="${report.deleteContent == 99}">${report.deleteContentOther}</c:if>">
							<c:choose>
								<c:when test="${report.reportStatus == 1}">未审核</c:when>
								<c:otherwise>已审核</c:otherwise>
							</c:choose>                    		
                            <c:if test="${report.reportStatus == CANCEL}">
                                <ehr:dic code="${report.reportStatus}" dicmeta="PH00037"/>
                            </c:if>
                    	</td>
						<td class="centertd">
							<c:choose>													
								<c:when test="${(ROLE==ZXCRB || ROLE== YYCRB) && report.reportStatus==2}">
									<a href="javascript:void(0)" onclick="reportSearch.edit(${report.id})"class="person-link-btn">报卡修改</a>&nbsp;
				 				</c:when>
								<c:when test="${report.approvalFlg==1}">
									<a href="javascript:void(0)" onclick="reportSearch.edit(${report.id})"class="person-link-btn">报卡审核</a>&nbsp;
								</c:when>
								
								<c:when test="${ROLE==JKFYK && report.reportStatus==3}">
                                </c:when>
								<c:when test="${report.reportStatus == 2 && report.isOperate == 3}">
									<label class="loadclass">专项处置&nbsp;</label>&nbsp;
								</c:when>
								<c:when test="${report.reportStatus ==2 && report.isOperate == 4}">
									<label class="loadclass">&nbsp;</label>&nbsp;
								</c:when>
								<c:when test="${report.approvalFlg==1}">
									<a href="javascript:void(0)" onclick="reportSearch.edit(${report.id})"class="person-link-btn">报卡审核</a>&nbsp;
								</c:when>		
								如果报卡已经审核通过，且角色为SQZX,可以修改报卡						
								<c:when test="${(ROLE==ZXCRB || ROLE== YYCRB) && report.isOperate==5}">
									<a href="javascript:void(0)" onclick="reportSearch.edit(${report.id})"class="person-link-btn">报卡修改</a>&nbsp;
				 				</c:when>
								<c:when test="${ROLE==JKFYK && report.reportStatus==1}">
									  等待审核&nbsp;
								</c:when>
                                <c:when test="${ROLE==JKFYK && report.reportStatus==2 && report.fillOrganCode==currentOrgCode}">
                                    <a href="javascript:void(0)" onclick="reportSearch.edit(${report.id})"class="person-link-btn">报卡修改</a>&nbsp;
                                </c:when>
								<c:when test="${ROLE==JKFYK && report.reportStatus==3}">
                                </c:when>
							</c:choose>
						</td>
					</ehr:authorize>

				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<table>
		<tr>
			<ehr:pagination action="reportSearch.search" />
		</tr>
	</table>
</div> --%>