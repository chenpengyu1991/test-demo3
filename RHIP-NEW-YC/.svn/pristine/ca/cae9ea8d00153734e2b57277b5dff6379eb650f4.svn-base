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
			<col style="min-width:70px;width:10%;"/>
			<col style="min-width:60px;width:6%;"/>
			<col style="min-width:130px;width:16%;"/>
			<col style="min-width:80px;width:12%;"/>
			<col style="min-width:80px;width:10%;"/>
			<col style="min-width:70px;width:10%;"/>
            <col style="min-width:80px;width:10%;"/>
            <col style="min-width:70px;width:8%;"/>
            <col style="min-width:80px;width:8%;"/>
        </colgroup>
		<thead>
			<tr>
				<th>姓名</th>
				<th>性别</th>
				<th>家庭地址</th>
				<th>监护人电话</th>
				<th>法定监护人</th>
                <th>登记日期</th>
                <th>患者来源</th>
                <th>状态</th>
                <th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="clue" items="${mhmClues}" varStatus="status">
				<tr <c:if test="${clue.logoff == 1}">class="offedperson"</c:if>>
                    <td class="centertd"><ehr:tip>${clue.name}</ehr:tip></td>
                    <td class="centertd"><ehr:tip><ehr:dic dicmeta="GBT226112003" code="${clue.gender}" /></ehr:tip></td>
                    <td><ehr:tip>${clue.paAddress}</ehr:tip></td>
                    <td class="centertd"><ehr:tip>${clue.guarderPhone}</ehr:tip></td>
					<td class="centertd"><ehr:tip>${clue.parentsName}</ehr:tip></td>
                    <td class="centertd"><fmt:formatDate value="${clue.fillDate}" pattern="yyyy/MM/dd" /></td>
                    <td class="centertd"><ehr:tip><ehr:dic dicmeta="MH00004" code="${clue.patientResource}"/></ehr:tip></td>
                    <td class="centertd"><ehr:tip>${clue.status == '4'?'已管理':(clue.status == '9'?'死亡':'未管理')}</ehr:tip></td>
                    <td class="centertd">
						<c:choose>
	                        <c:when test='${clue.status !="4" && clue.status != "9" && clue.logoff != 1}'>
	                            <%-- <a href="javascript:void(0)" onclick="intoPatient.into(${clue.statusId}, ${clue.eventId}, ${clue.logoff})" class="person-link-btn">基本档案</a> --%>
	                            <%-- <a href="javascript:void(0)" onclick="intoPatient.into(${clue.statusId}, ${clue.eventId}, ${clue.logoff})" class="person-link-btn" title="基本档案" ><i class="layui-icon">&#xe615;</i></a> --%>
	                        	<a class="basicIndex layui-btn layui-btn-normal layui-btn-xs" href="#" title="基本档案" onclick="intoPatient.into(${clue.statusId}, ${clue.eventId}, ${clue.logoff})" style="color: #FFF;"><i class="layui-icon">&#xe615;</i>基本档案</a>
	                        
	                        </c:when>	
	                        <c:otherwise>
	                            <ehr:tip><%--已管理--%></ehr:tip>
	                        </c:otherwise>	                        						
						</c:choose>                    	
                    </td>
				</tr>
			</c:forEach>
			<tr>
			<ehr:pagination action="intoPatient.search" colspan="9"/>
		</tr>		
		</tbody>
	</table>
	
	<%-- <table>
		<tr>
			<ehr:pagination action="intoPatient.search" />
		</tr>
	</table> --%>
</div>