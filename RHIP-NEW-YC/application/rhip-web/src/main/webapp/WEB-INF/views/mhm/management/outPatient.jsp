<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<script src="${pageContext.request.contextPath}/js/views/mhm/mhmCommon.js" type="text/javascript"></script>
<%--集成门诊信息页面 --%>
<div class="toolbar" style="margin-top: -8px;">
     <!-- <a href="javascript:void(0)" onclick="javascript:mhmCommon.returnSearch(managementSearch.search)"><b class="fanhui">返回</b></a> -->
     <a href="javascript:void(0)" onclick="javascript:mhmCommon.returnSearch(managementSearch.search)" ><button class="btn-gray layui-btn layui-btn-sm button"><i class="layui-icon">&#xe65c;</i>返回</button></a>
</div>
<div style="margin: 10px 20px;"class="divFixed105">
	<div id="managementResultDiv">
		<div class="repeattable">
			<table class="layui-table x-admin-sm-table-list-middle">
				<colgroup>
					<col style="min-width:30px;width:25%;"/>
			        <col style="min-width:30px;width:25%;"/>
					<%--<col style="min-width:30px;width:20%;"/>--%>
					<col style="min-width:30px;width:25%;"/>
					<col style="min-width:30px;width:25%;"/>
				</colgroup>
				<thead>
					<tr>
						<th>时间</th>
						<th>就诊机构</th>
						<%--<th>门诊号</th>--%>
						<th>诊断结果</th>
						<th>诊断医师</th>
					</tr>
				</thead>
				<tbody>
		        <c:forEach var="outPatientRecord" items="${outPatientRecords}" varStatus="status">
		            <tr>
		                <td class="centertd"><ehr:tip><fmt:formatDate value="${outPatientRecord.outpatientDt}" pattern="yyyy/MM/dd"/></ehr:tip></td>
		                <td><ehr:tip>${outPatientRecord.outpatientOrgan}</ehr:tip></td>
		                <%--<td class="centertd"><ehr:tip>${outPatientRecord.outpatientNo}</ehr:tip></td>--%>
		                <td><ehr:tip>${outPatientRecord.diagnosisResult}</ehr:tip></td>
		                <td class="centertd"><ehr:tip>${outPatientRecord.diagnosisDoctor}</ehr:tip></td>
		            </tr>
		        </c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</div>
