<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ page import="com.founder.rhip.idm.common.SchDiagnosis" %>
<c:set var="ACUTE" value="<%=SchDiagnosis.ACUTE.getValue()%>" />
<c:set var="CHRONIC" value="<%=SchDiagnosis.CHRONIC.getValue()%>" />
<c:set var="EXPANDED_TREAT" value="<%=SchDiagnosis.EXPANDED_TREAT.getValue()%>" />
<c:set var="LATER"  value="<%=SchDiagnosis.LATER.getValue()%>" />
<c:set var="ELIMINATION"  value="<%=SchDiagnosis.ELIMINATION.getValue()%>" />
<div class="repeattable">
	<table class="layui-table x-admin-sm-table-list-middle">
		<colgroup>
			<col style="width:10%;"/>
	        <col style="width:10%;"/>
			<col style="width:10%;"/>
			<col style="width:25%;"/>
			<col style="width:25%;"/>
            <col style="width:20%;"/>
		</colgroup>	
		<thead>
			<tr>
				<th>姓名</th>
				<th>性别</th>
				<th>年龄</th>
				<th>户口所在地</th>
				<th>现住址</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="schCase" items="${statusInfo}" varStatus="status">
				<tr <c:if test="${schCase.schDto.logoff == 1}">class="offedperson"</c:if>>
					<td class="centertd"><ehr:tip>${schCase.schDto.name}</ehr:tip></td>
					<td class="centertd"><ehr:tip><ehr:dic dicmeta="GBT226112003" code="${schCase.schDto.gender}" /></ehr:tip></td>
					<td class="centertd"><ehr:tip>${schCase.schDto.age}</ehr:tip></td>
					<td>
						<ehr:tip>${schCase.schDto.hrAddress}</ehr:tip>
					</td>					
					<td>
						<ehr:tip>${schCase.schDto.paAddress}</ehr:tip>
					</td>
					<td class="centertd">
						<c:choose>
	                    	<c:when test="${schCase.schDto.idmType == '4'}">
								<%-- <a href="javascript:void(0)" onclick='javascript:schCasesSearch.viewRegister(${schCase.schDto.idmId},"view")' class="person-link-btn">监测登记&nbsp;</a> --%>     
								<a href="javascript:void(0)" onclick='javascript:schCasesSearch.viewRegister(${schCase.schDto.idmId},"view")' class="person-link-btn layui-btn layui-btn-normal layui-btn-xs" style="color: #FFF;font-size: 12px;" title="监测登记"><i class="layui-icon">&#xe63c;</i>查看</a>&nbsp;&nbsp;
							</c:when>	
							<c:otherwise>
							</c:otherwise>												
						</c:choose>	
                       <c:choose>
                             <c:when test="${schCase.schDto.treatment == ACUTE || schCase.schDto.treatment == CHRONIC  || schCase.schDto.treatment == EXPANDED_TREAT }">
								<a href="javascript:void(0)" onclick="schCasesSearch.editCase(${schCase.schDto.idmId},${schCase.schDto.logoff})" class="person-link-btn layui-btn layui-btn-xs" style="color: #FFF;font-size: 12px;" <c:if test="${not empty schCase.schDto.caseId}">title="个案修改"</c:if> <c:if test="${empty schCase.schDto.caseId}">title="个案新增"</c:if> >
				                <c:choose>
		                 			<c:when test="${not empty schCase.schDto.caseId}"><i class="layui-icon">&#xe642;</i>修改</c:when>
		                 			<c:otherwise><i class="layui-icon">&#xe608;</i>修改</c:otherwise>
	                 			</c:choose>					
								&nbsp;</a>
								<a href="javascript:void(0)" onclick="schCasesSearch.initTreatment(${schCase.schDto.idmId},${schCase.schDto.logoff})" class="person-link-btn layui-btn layui-btn-xs" style="color: #FFF;font-size: 12px;" title="治疗记录"><i class="layui-icon">&#xe60e;</i>记录</a>&nbsp;&nbsp;
                            </c:when>
							<c:otherwise>
								<a href="javascript:void(0)" onclick="schCasesSearch.editCase(${schCase.schDto.idmId},${schCase.schDto.logoff})" class="person-link-btn layui-btn layui-btn-xs" style="color: #FFF;font-size: 12px;" <c:if test="${not empty schCase.schDto.caseId}">title="个案修改"</c:if> <c:if test="${empty schCase.schDto.caseId}">title="个案新增"</c:if>>
							    <c:choose>
		                 			<c:when test="${not empty schCase.schDto.caseId}"><i class="layui-icon">&#xe642;</i>修改</c:when>
		                 			<c:otherwise><i class="layui-icon">&#xe608;</i>修改</c:otherwise>
	                 			</c:choose>						
								&nbsp;</a>
							</c:otherwise>
                        </c:choose>	
                        				
					</td>
				</tr>
			</c:forEach>
			<tr>
			<ehr:pagination action="schCasesSearch.caseSearch" colspan="6"/>
		</tr>
		</tbody>
	</table>
	
	<%-- <table>
		<tr>
			<ehr:pagination action="schCasesSearch.caseSearch" />
		</tr>
	</table> --%>
</div>