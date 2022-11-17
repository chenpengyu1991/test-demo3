<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ page import="com.founder.rhip.idm.common.SchDiagnosis" %>
<%@ page import="com.founder.rhip.idm.common.SchStatus" %>
<c:set var="LATER"  value="<%=SchDiagnosis.LATER.getValue()%>" />
<c:set var="CURE" value="<%=SchStatus.CURE.getValue()%>" />
<div class="repeattable">
	<table class="layui-table x-admin-sm-table-list-middle">
		<colgroup>
			<col style="width:6%;"/>
	        <col style="width:5%;"/>
			<col style="width:5%;"/>
			<col style="width:21%;"/>
			<col style="width:22%;"/>
			<col style="width:6%;"/>
            <col style="width:35%;"/>
		</colgroup>	
		<thead>
			<tr>
				<th>姓名</th>
				<th>性别</th>
				<th>年龄</th>
				<th>户口所在地</th>
				<th>现住址</th>
				<th>状态</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="advanced" items="${advancedlist}" varStatus="status">
				<tr <c:if test="${0 != advanced.schDto.logoff}">class="offedperson"</c:if>>
					<td class="centertd"><ehr:tip>${advanced.schDto.name}</ehr:tip></td>
					<td class="centertd"><ehr:tip><ehr:dic dicmeta="GBT226112003" code="${advanced.schDto.gender}" /></ehr:tip></td>
					<td class="centertd"><ehr:tip>${advanced.schDto.age}</ehr:tip></td>
					<td>
                        <ehr:tip>${advanced.schDto.hrAddress}</ehr:tip>
					</td>					
					<td>
                        <ehr:tip>${advanced.schDto.paAddress}</ehr:tip>
					</td>
					<td class="centertd">
						<c:choose>
							<c:when test="${advanced.schDto.specialStatus == CURE}">
								<label class="loadclass">已治愈&nbsp;</label>
							</c:when>
							<c:otherwise>
								<label class="loadclass">管理中&nbsp;</label>
							</c:otherwise>
						</c:choose>					
					</td>
					<td class="centertd">
						<a href="javascript:void(0)" onclick="advancedSearch.initSurvey(${advanced.schDto.idmId},${advanced.schDto.logoff})" class="person-link-btn layui-btn layui-btn-xs" style="color: #FFF;font-size: 12px;" title="调查表"><i class="layui-icon">&#xe6b2;</i>调查表</a>&nbsp;&nbsp;
						<%--<c:choose>
							 <c:when test="${advanced.schDto.sid != '0'}"> --%>
								<a href="javascript:void(0)" onclick="advancedSearch.editCard(${advanced.schDto.idmId},${advanced.schDto.logoff})" class="person-link-btn layui-btn layui-btn-xs" style="color: #FFF;font-size: 12px;" title="管理卡"><i class="layui-icon">&#xe62a;</i>管理卡</a>&nbsp;&nbsp;
							<%-- </c:when>
							<c:otherwise>
								<label class="loadclass">管理卡</label>&nbsp;&nbsp;
							</c:otherwise> 
						</c:choose>
						<c:choose>--%>
							<%-- <c:when test="${advanced.schDto.cid != '0'}"> --%>
								<a href="javascript:void(0)" onclick="advancedSearch.initReexamine(${advanced.schDto.idmId},${advanced.schDto.logoff})" class="person-link-btn layui-btn layui-btn-xs" style="color: #FFF;font-size: 12px;" title="登记表"><i class="layui-icon">&#xe63c;</i>登记表</a>&nbsp;&nbsp;
							<%-- </c:when>
							<c:otherwise>
								<label class="loadclass">登记表</label>&nbsp;&nbsp;
							</c:otherwise>		 			
						</c:choose>	--%>		
						<a href="javascript:void(0)" onclick="advancedSearch.initMedical(${advanced.schDto.idmId},${advanced.schDto.logoff})" class="person-link-btn layui-btn layui-btn-xs" style="color: #FFF;font-size: 12px;" title="体检表"><i class="layui-icon">&#xe621;</i>体检表</a>&nbsp;&nbsp;
					</td>
				</tr>
			</c:forEach>
			<tr>
			<ehr:pagination action="advancedSearch.advancedSearch" colspan="7"/>
		</tr>
		</tbody>
	</table>
	
	<%-- <table>
		<tr>
			<ehr:pagination action="advancedSearch.advancedSearch" />
		</tr>
	</table> --%>
</div>