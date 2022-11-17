<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/ehr-tag" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/views/ehr/ehrbrowser/service/outpatient/detailReport.js"></script>

<div class="table-01" style="width: 98%;margin-left:6px;margin-top: 3px;">
	<c:set var="outpatientInfo" value="${outpatientReportDTO.outpatientInfo }"></c:set>
	<c:set var="diseaseDiagnosisInfo" value="${outpatientReportDTO.diseaseDiagnosisInfo }"></c:set>
	<c:set var="expenseInfo" value="${outpatientReportDTO.expenseInfo }"></c:set>
	<input type="hidden" id="drugUsage_ehrId" value="${outpatientInfo.ehrId}" /> 
	<input type="hidden" id="drugUsage_personId" value="${outpatientInfo.personId}" />

	<table>
		<tr>
			<td rowspan="2"><span>患者信息</span>
				<table class="formtable">
					<tr>
						<th style="width: 130px">姓名</th>
						<td style="width: 170px"><c:out value="${outpatientInfo.clinicPeopleName }"></c:out></td>
						<th style="width: 145px">性别</th>
						<td style="width: 155px"><ehr:dic dicmeta="GBT226112003" code="${outpatientInfo.gender}" /></td>
					</tr>
					<tr>
						<th>年龄</th>
						<td colspan="3"><c:out value="${outpatientInfo.age }"></c:out></td>
					</tr>
				</table> <span>就诊信息</span>
				<table class="formtable">
					<tr>
						<th style="width: 130px">日期：</th>
						<td style="width: 170px"><fmt:formatDate value="${outpatientInfo.clinicDate }" pattern="yyyy/MM/dd" /></td>
						<th style="width: 145px">总费用：</th>
						<td style="width: 155px"><fmt:formatNumber value="${outpatientInfo.outpatientCostSum}" type="currency"/></td>
					</tr>
					<tr>
						<th>机构：</th>
						<td><c:out value="${outpatientInfo.clinicOrganName }"></c:out></td>
						<th>自费：</th>
						<td><fmt:formatNumber value="${outpatientInfo.personalExpenses}" type="currency"/></td>
					</tr>
					<tr>
						<%--<th>医生：</th>
						<td><c:out value="${outpatientInfo.manaDoctorName}"></c:out></td>--%>
						<th>报销：</th>
						<td><fmt:formatNumber value="${outpatientInfo.medicalInsuranceCostSum}" type="currency"/></td>
					</tr>
					<tr>
						<th>科室:</th>
						<td><c:out value="${outpatientInfo.medicalRoomName }"></c:out></td>
						<th>其他：</th>
						<td><fmt:formatNumber value="${outpatientInfo.otherSubsidiesCostSum}" type="currency"/></td>
					</tr>
					<tr>
						<th>门诊号:</th>
						<td><c:out value="${outpatientInfo.outpatientNo }"></c:out></td>
						<th>保险类型：</th>
						<td><ehr:dic dicmeta="CV0710003" code="${outpatientInfo.medicalCostPayWay}" /></td>
					</tr>
				</table> <span>诊断状况</span>
				<table class="formtable">
					<tr>
						<th style="width: 90px">描述：</th>
						<td style="height: 80px;"><c:out value="${diseaseDiagnosisInfo.diagnosisDesc }"></c:out></td>
					</tr>
					<tr>
						<th style="width: 90px">结果：</th>
						<td><c:out value="${diseaseDiagnosisInfo.healthAssessment }"></c:out></td>
					</tr>
				</table></td>
			<td style="vertical-align: top" class="smalltab" >
				<div class="layui-tab layui-tab-card" lay-filter="outpatientExam" style="height: 250px;
				    overflow: auto;">
				  <ul class="layui-tab-title">
				    <li class="layui-this">检验</li>
				    <li>检查</li>
				  </ul>
				  <div class="layui-tab-content" style="margin-top: -5px;">
				    <div class="layui-tab-item layui-show"><jsp:include page="../exam/eventDetaillist.jsp"></jsp:include></div>
				    <div class="layui-tab-item" style="width: 375px; height: 180px; overflow: auto;">
				    <table  class="repeattable layui-table x-admin-sm-table-list-small" style="width: 100%;margin: 0px;">
							<thead>
								<tr>
									<th>申请日期</th>
									<th>检查单号</th>
									<th>检查类型</th>
									<th>结论</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${outpatientReportDTO.studyEventList}" var="studyEvent">
									<tr>
										<td><fmt:formatDate value="${studyEvent.checkDate}" pattern="yyyy/MM/dd " /></td>
										<td><c:out value="${studyEvent.recordNumber}"></c:out></td>
										<td>
												<ehr:dic dicmeta="FS10249" code="${studyEvent.inspectionType}"/>
										</td>
										<td><tags:textWithTip value="${studyEvent.conclusionDesc}"></tags:textWithTip></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				  </div>
				</div>
				<%-- <ul id=tags>
					<li class=selectTag><a id="summary_exam_btn" href="javascript:void(0)">检验</a></li>
					<li><a id="summary_study_btn" href="javascript:void(0)">检查</a></li>
				</ul>

				<div id="tagContent" style="width: 400px; height: 250px; overflow: auto">
					<div id="tagContent0" class="selectTag">
						<jsp:include page="../exam/eventDetaillist.jsp"></jsp:include>
					</div>
					<div id="tagContent1" style="display: none;">
						<table  class="repeattable layui-table x-admin-sm-table-list-small">
							<thead>
								<tr>
									<th>申请日期</th>
									<th>检查单号</th>
									<th>检查类型</th>
									<th>结论</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${outpatientReportDTO.studyEventList}" var="studyEvent">
									<tr>
										<td><fmt:formatDate value="${studyEvent.checkDate}" pattern="yyyy/MM/dd " /></td>
										<td><c:out value="${studyEvent.recordNumber}"></c:out></td>
										<td>
												<ehr:dic dicmeta="FS10249" code="${studyEvent.inspectionType}"/>
										</td>
										<td><tags:textWithTip value="${studyEvent.conclusionDesc}"></tags:textWithTip></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div> --%>
			</td>
		</tr>
		<tr>
			<td valign="top" style="vertical-align: top" >
                <div style="width: 400px; height: 180px; overflow: auto">
                处方
				<table class="layui-table x-admin-sm-table-list-small">
					<thead>
						<tr>
							<th>药品名称</th>
							<th>规格</th>
							<th>单位</th>
							<th>数量</th>
							<th>单价</th>
							<th>小计</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${drugUsages}" var="drugUsage">
							<tr>
								<td><tags:textWithTip value="${drugUsage.drugGenericName }"></tags:textWithTip></td>
								<td><c:out value="${drugUsage.drugSpecifications }"></c:out></td>
                                <td><c:out value="${drugUsage.quantityUnit }"></c:out></td>
                                <td><c:out value="${drugUsage.quantity }"></c:out></td>
								<td><c:out value="${drugUsage.unitPrice }"></c:out></td>
								<td><fmt:formatNumber value="${drugUsage.subtotal }" type="currency" pattern="￥0.00"/></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
                </div>
			</td>
		</tr>
	</table>
</div>
<script>
//注意：选项卡 依赖 element 模块，否则无法进行功能性操作
layui.use('element', function(){
  var element = layui.element;
//一些事件监听
  element.on('tab(outpatientExam)', function(data){
 
  });
});
</script>