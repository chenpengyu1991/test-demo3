<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<%@ page import="com.founder.rhip.ehr.common.RoleType" %>
<%@ page import="com.founder.rhip.mhm.common.MhmStatus" %>
<c:set var="SQZ" value="<%=RoleType.Z_GLY.getValue()%>"/>
<c:set var="JFYS" value="<%=RoleType.ZXJFYS.getValue()%>"/>
<c:set var="JFZX" value="<%=RoleType.JKJFZX.getValue()%>"/>
<c:set var="SUBMIT" value="<%=MhmStatus.SUBMIT.getValue()%>"/>
<c:set var="VERIFY_SQZX" value="<%=MhmStatus.VERIFY_SQZX.getValue()%>"/>
<c:set var="VERIFY_DIAGNOSIS" value="<%=MhmStatus.VERIFY_DIAGNOSIS.getValue()%>"/>
<c:set var="VERIFY_CHECK" value="<%=MhmStatus.VERIFY_CHECK.getValue()%>"/>
<c:set var="ELIMINATION" value="<%=MhmStatus.ELIMINATION.getValue()%>"/>
<c:set var="ELIMINATION_CHECK" value="<%=MhmStatus.ELIMINATION_CHECK.getValue()%>"/>
<c:set var="ELIMINATION_DIAGNOSIS" value="<%=MhmStatus.ELIMINATION_DIAGNOSIS.getValue()%>"/>
<c:set var="MANAGEMENT" value="<%=MhmStatus.MANAGEMENT.getValue()%>"/>
<div class="repeattable">
	<table class="layui-table x-admin-sm-table-list-middle">
		<colgroup>
			<col style="width: 5%;"/>
	        <col style="width: 10%;"/>
			<col style="width: 8%;"/>
	        <col style="width: 10%;"/>
			<col style="width: 10%;"/>
			<col style="width: 15%;"/>
           	<col style="width: 15%;"/>
			<col style="width: 10%;"/>
			<col style="width: 10%;"/>
		    <col style="width: 10%;"/>
		</colgroup>
		<thead>
			<tr>
                <th>编号</th>
				<th>姓名</th>
                <th>性别</th>
                <th>年龄</th>
				<th>职业</th>
                <th>身份证号</th>
               	<th>上报机构</th>
                <th>登记日期</th>
                <th>状态</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="clue" items="${mhmClues}" varStatus="status">
				<tr <c:if test="${clue.logoff == 1}">class="offedperson"</c:if>>
                    <td class="centertd">${status.count}</td>
                    <td class="centertd"><ehr:tip>${clue.name}</ehr:tip></td>
                    <td class="centertd"><ehr:tip><ehr:dic dicmeta="GBT226112003" code="${clue.gender}" /></ehr:tip></td>
                    <td class="centertd"><tags:numberLabel value="${clue.age}" align="center"/></td>
                    <td><ehr:tip><ehr:dic dicmeta="GBT6565" code="${clue.occupation}" /></ehr:tip></td>
                    <td class="centertd"><ehr:tip>${clue.idcard}</ehr:tip></td>
           			<td>
           				<ehr:tip><ehr:org code="${clue.fillOrganCode}"></ehr:org></ehr:tip>
           			</td>
                    <td class="centertd"><fmt:formatDate value="${clue.fillDate}" pattern="yyyy/MM/dd" /></td>
                    <td class="centertd">
						<c:choose>
	                        <c:when test='${clue.status == VERIFY_CHECK}'>
	                            <font color="blue"><ehr:tip><ehr:dic dicmeta="MH00048" code="${clue.status}" /></ehr:tip></font>
	                        </c:when>	
	                        <c:when test='${(clue.status == ELIMINATION_CHECK)||(clue.status == ELIMINATION_DIAGNOSIS)||(clue.status == ELIMINATION)}'>
	                            <font color="red"><ehr:tip><ehr:dic dicmeta="MH00048" code="${clue.status}" /></ehr:tip></font>
	                        </c:when>
	                        <c:when test='${clue.status == MANAGEMENT}'>
	                            <ehr:tip><ehr:dic dicmeta="MH00048" code="${clue.status}" /></ehr:tip>
	                        </c:when>
	                        <c:otherwise>
	                            <font color="green"><ehr:tip><ehr:dic dicmeta="MH00048" code="${clue.status}" /></ehr:tip></font>
	                        </c:otherwise>	                        						
						</c:choose>                    	
                    </td>
					<td class="centertd">
						<c:choose>
	                        <c:when test='${ROLE==JFYS && clue.status == SUBMIT}'>
	                            <%-- <a href="javascript:void(0)" onclick="clueSearch.add('edit',${clue.statusId},${clue.logoff})" class="person-link-btn">审核</a> --%>
	                            <a href="javascript:void(0)" onclick="clueSearch.add('edit',${clue.statusId},${clue.logoff})" class="person-link-btn layui-btn layui-btn-warm layui-btn-xs" style="color: #FFF;font-size: 12px;" title="审核"><i class="layui-icon">&#xe672;</i>审核</a>
	                        </c:when>	
	                        <c:when test='${ROLE==JFZX && clue.status == VERIFY_SQZX}'>
	                            <%-- <a href="javascript:void(0)" onclick="clueSearch.add('edit',${clue.statusId},${clue.logoff})" class="person-link-btn">诊断</a> --%>
	                            <a href="javascript:void(0)" onclick="clueSearch.add('edit',${clue.statusId},${clue.logoff})" class="person-link-btn layui-btn layui-btn-xs" style="color: #FFF;font-size: 12px;" title="诊断"><i class="layui-icon">&#xe679;</i>诊断</a>
	                        </c:when>
	                        <c:when test='${ROLE==JFZX && clue.status == VERIFY_DIAGNOSIS}'>
	                            <%-- <a href="javascript:void(0)" onclick="clueSearch.add('edit',${clue.statusId},${clue.logoff})" class="person-link-btn">复核</a> --%>
	                            <a href="javascript:void(0)" onclick="clueSearch.add('edit',${clue.statusId},${clue.logoff})" class="person-link-btn layui-btn layui-btn-warm layui-btn-xs" style="color: #FFF;font-size: 12px;" title="复核"><i class="layui-icon">&#xe672;</i>复核</a>
	                        </c:when>
	                        <c:otherwise>
	                            <%-- <a href="javascript:void(0)" onclick="clueSearch.add('view',${clue.statusId},${clue.logoff})" class="person-link-btn">查看</a> --%>
	                            <a href="javascript:void(0)" onclick="clueSearch.add('view',${clue.statusId},${clue.logoff})" class="person-link-btn layui-btn layui-btn-normal layui-btn-xs" style="color: #FFF;font-size: 12px;" title="查看" ><i class="layui-icon">&#xe615;</i>查看</a>
	                        </c:otherwise>	                        						
						</c:choose>
					</td>
				</tr>
			</c:forEach>
			<tr>
			<ehr:pagination action="clueSearch.search" colspan="10"/>
			</tr>
		</tbody>
	</table>
	
	<%-- <table>
		<tr>
			<ehr:pagination action="clueSearch.search" />
		</tr>
	</table> --%>
</div>