<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<script src="${pageContext.request.contextPath}/js/views/idm/tb/sputum.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/idm/tb/contacts.js" type="text/javascript"></script>

<%@ page import="com.founder.rhip.idm.common.TbStatus" %>
<c:set var="DCMR" value="<%=TbStatus.DCMR.getValue()%>"/>
<c:set var="TREATMENT" value="<%=TbStatus.TREATMENT.getValue()%>"/>
<c:set var="ASSIGN" value="<%=TbStatus.ASSIGN.getValue()%>"/>
<c:set var="ACCEPT" value="<%=TbStatus.ACCEPT.getValue()%>"/>
<c:set var="RETURN" value="<%=TbStatus.RETURN.getValue()%>"/>
<c:set var="CANCEL" value="<%=TbStatus.CANCEL.getValue()%>"/>
<c:set var="STOP" value="<%=TbStatus.STOP.getValue()%>"/>
<c:set var="REASSIGN" value="<%=TbStatus.REASSIGN.getValue()%>"/>

<div class="repeattable">
	<input type="hidden" id="currentPageTreatment" value="${page.currentPage }"/>
	<table class="layui-table x-admin-sm-table-list-middle">
		<colgroup>
			<col style="width:10%;"/>
	        <col style="width:5%;"/>
	        <col style="width:15%;"/>
			<col style="width:10%;"/>
			<col style="width:20%;"/>
			<col style="width:10%;"/>
			<col style="width:10%;"/>	
			<col style="width:20%"/>
		</colgroup>	
		<thead>
			<tr>
				<th>姓名</th>
				<th>性别</th>
				<th>身份证</th>
				<th>诊断结果</th>
				<th>高危人群分类</th>
				<%--<th>管理状态</th>--%>
				<th>接纳单位</th>
				<th>治疗分类</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="standardization" items="${standardizations}" varStatus="status">
				<tr <c:if test="${standardization.logoff == 1}">class="offedperson"</c:if>>
					<td class="centertd"><ehr:tip>${standardization.tbDto.name}</ehr:tip></td>
					<td class="centertd"><ehr:tip><ehr:dic code="${standardization.tbDto.gender}" dicmeta="GBT226112003"/></ehr:tip></td>
					<td class="centertd">
                        <ehr:ehrBrwLink idCard="${standardization.tbDto.idcard}"><ehr:tip>${standardization.tbDto.idcard}</ehr:tip></ehr:ehrBrwLink>
                    </td>
					<td>
                        <ehr:tip>
							<ehr:dic code="${standardization.tbDto.diagnosisType}" dicmeta="IDM00224"/><c:if test="${standardization.tbDto.lastDiagnosis!=null && standardization.tbDto.lastDiagnosis!=''}"><ehr:dic code="${standardization.tbDto.lastDiagnosis}" dicmeta="IDM00237"/></c:if>
							<c:if test="${standardization.tbDto.diagnosisAccording!=null && standardization.tbDto.diagnosisAccording!=''}"><c:if test="${standardization.tbDto.diagnosisAccording==1}">结核性胸膜炎Ⅳ型</c:if><c:if test="${standardization.tbDto.diagnosisAccording==2}">其他肺外结核Ⅴ型</c:if></c:if>
							<c:if test="${standardization.tbDto.diagnosisReasonMulti!=null && standardization.tbDto.diagnosisReasonMulti!=''}">【<ehr:dic code="${standardization.tbDto.diagnosisReasonMulti}" dicmeta="IDM00238"/></c:if>&nbsp;${standardization.tbDto.diagnosisOther}<c:if test="${standardization.tbDto.diagnosisReasonMulti!=null && standardization.tbDto.diagnosisReasonMulti!=''}">】</c:if>
                        </ehr:tip>
					</td>
					<%--<td><ehr:tip><ehr:dic code="${standardization.tbDto.manageType}" dicmeta="IDM00243"/></ehr:tip></td>
					<td class="centertd">
						<c:choose>
							<c:when test="${standardization.specialStatus == ASSIGN}">已分派</c:when>
							<c:when test="${standardization.specialStatus == ACCEPT}">已管理</c:when>
							<c:when test="${standardization.specialStatus == RETURN}">已退回</c:when>
							<c:when test="${standardization.specialStatus == CANCEL}">已作废</c:when>
							<c:when test="${standardization.specialStatus == STOP}">停止治疗</c:when>
							<c:otherwise>未管理</c:otherwise>
						</c:choose>
					</td>--%>
					<td class="centertd">
						<c:if test="${standardization.dangerFlag1!=null}">[慢性排菌患者]</c:if>
						<c:if test="${standardization.dangerFlag2!=null}">[耐多药密切接触者]</c:if>
						<c:if test="${standardization.dangerFlag3!=null}">[初治失败]</c:if>
						<c:if test="${standardization.dangerFlag4!=null}">[复发与返回]</c:if>
						<c:if test="${standardization.dangerFlag5!=null}">[治疗3月仍阳]</c:if>
					</td>
					<td>
						<ehr:tip><ehr:org code="${standardization.currentUnit}"/></ehr:tip>
					</td>
					<td class="centertd">
						<c:choose>
							<c:when test="${standardization.tbDto.thisType == '1'}">初治</c:when>
							<c:otherwise>
								复治
							</c:otherwise>
						</c:choose>
					</td>
					<td class="centertd">
						<c:if test="${!('1' eq standardization.ndyFlag)}">
							<%-- <a href="javascript:void(0)" onclick="ndyConfirm.ndyQz('${standardization.id}')" class="person-link-btn">确诊</a> --%>
							<a href="javascript:void(0)" onclick="ndyConfirm.ndyQz('${standardization.id}')" class="person-link-btn layui-btn layui-btn-xs" style="color: #FFF;font-size: 12px;" title="确诊"><i class="layui-icon">&#x1005;</i>确诊</a>
						</c:if>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<table>
		<tr>
			<ehr:pagination action="standardization.search" colspan="9" />
		</tr>
	</table>
</div>