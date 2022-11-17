<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/views/ehrbrowser/index/main.css"/>
<script>
	$(function() {
		$("#backTabBtn").click(function() {
			layer.confirm("确认离开？",function(index){
				layer.close(index);
				var url;
				var param = {};
				if($("#requestUrlType").val() ==""){
					var personIdVal = $("#ehrbrowser_person_id_input").val()
					url = contextPath + "/ehrbrowser/basic/referralInfo";
					param = {personId:personIdVal};
				}else {
					url = contextPath + "/personRecord/referralList";
				}
				$.loadHtmlByUrl({
					url : url,
					insertDiv :"referral_info",
					param :param
				});
			});
		});

	});
</script>
<div class="toolbar">
	<a href="javascript:void(0)" id="backTabBtn"><button class=" btn-gray layui-btn layui-btn-sm"><i class="layui-icon">&#xe65c;</i>返回</button></a>
</div>
<div class="report_box">
	<input type="hidden" id="requestUrlType" value="${requestUrlType}"/>
		<h1 align="center">
			<span class="line_with_border" style="font-size: 24px;">双向转诊单</span>
		</h1>
		<h2 align="center">
			<span style="font-size: 18px;">存  根</span>
		</h2>
	
		<table class="layout_table">
			<tr><td></td></tr>
			<tr>
				<td colspan ="8">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				患者姓名<span class="line_with_border" >&nbsp;&nbsp; <c:out value="${referral.name}"></c:out>&nbsp;&nbsp; </span>
				      性别<span class="line_with_border">&nbsp;&nbsp; <ehr:dic dicmeta="GBT226112003" code="${referral.gender}"/>&nbsp;&nbsp; </span>         
				     年龄（岁）<span class="line_with_border">&nbsp;&nbsp; <c:out value="${referral.age}"></c:out>&nbsp;&nbsp; </span>
				 <c:if test="${referral.dualReferralType eq 1}">
				   档案编号<span class="line_with_border">&nbsp;&nbsp; <c:out value="${referral.healthFileNo}"></c:out>&nbsp;&nbsp; </span>
				 </c:if>
				 <c:if test="${referral.dualReferralType eq 2}">
				   病案号<span class="line_with_border">&nbsp;&nbsp; <c:out value="${referral.medicalRecordNo}"></c:out>&nbsp;&nbsp; </span>
				 </c:if>
				</td>
			</tr>
			<tr>
				<td colspan ="8">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				家庭住址<span class="line_with_border"  style="width: 8%">&nbsp;&nbsp; 
						<ehr:dic dicmeta="FS990001" code="${referral.fatownShip}"></ehr:dic>
                		<ehr:dic dicmeta="FS990001" code="${referral.fastreet}"></ehr:dic>
                		<ehr:dic dicmeta="FS990001" code="${referral.faGroup}"></ehr:dic>${referral.fahouseNumber }&nbsp;&nbsp;</span>
	                                     联系电话<span class="line_with_border"  style="width: 8%">&nbsp;&nbsp; <c:out value="${referral.patientPhone}"></c:out>&nbsp;&nbsp; </span></td>
			</tr>
			<c:if test="${referral.dualReferralType eq 1}">
				<tr>
					<td colspan ="8">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					于<span class="line_with_border" >&nbsp;&nbsp; <fmt:formatDate value="${referral.referralDate}" pattern="yyyyMMdd"/>&nbsp;&nbsp; </span>
					      因病情需要，转入<span class="line_with_border">&nbsp;&nbsp; <c:out value="${referral.referralHospitalName}"></c:out>&nbsp;&nbsp; </span>         
					    单位<span class="line_with_border">&nbsp;&nbsp; <c:out value="${referral.referralDeptName}"></c:out>&nbsp;&nbsp; </span>
					   科室<span class="line_with_border">&nbsp;&nbsp; <c:out value="${referral.receptionDoctorName}"></c:out>&nbsp;&nbsp; </span>
					   接诊医生。
					</td>
				</tr>
			</c:if>
			<c:if test="${referral.dualReferralType eq 2}">
				<tr>
					<td colspan ="8">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					于<span class="line_with_border" >&nbsp;&nbsp; <fmt:formatDate value="${referral.referralDate}" pattern="yyyyMMdd"/>&nbsp;&nbsp; </span>
					      因病情需要，转回<span class="line_with_border">&nbsp;&nbsp; <c:out value="${referral.referralHospitalName}"></c:out>&nbsp;&nbsp; </span>         
					    单位<span class="line_with_border">&nbsp;&nbsp; <c:out value="${referral.receptionDoctorName}"></c:out>&nbsp;&nbsp;</span>
					   接诊医生。
					</td>
				</tr>
			</c:if>
			
			<tr>
				<td colspan="2" align="right">转诊医生（签字）：<c:out value="${referral.referralDoctorName}"></c:out>&nbsp;&nbsp;</td>
			</tr>
			<tr>
				<td colspan="2" align="right">
				<fmt:formatDate value="${referral.referralDate}" pattern="yyyyMMdd"/>&nbsp;&nbsp;
				</td>
			</tr>
		</table>
		<c:if test="${referral.dualReferralType eq 1}">
		<h1 align="center">
			<span style="font-size: 24px;">双向转诊（转出）单</span>
		</h1>
	 
		<table class="layout_table">
			<tr>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="line_with_border"><c:out value="${referral.referralHospitalName}"></c:out></span>：</td>
			</tr>
			<tr>
				<td colspan ="8">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					现有患者<span class="line_with_border">&nbsp;&nbsp;<c:out value="${referral.name}"></c:out>&nbsp;&nbsp;</span>
					性别<span class="line_with_border">&nbsp;&nbsp;<ehr:dic dicmeta="GBT226112003" code="${referral.gender}"/>&nbsp;&nbsp;</span>
				           年龄（岁）<span class="line_with_border">&nbsp;&nbsp;<c:out value="${referral.age}"></c:out>&nbsp;&nbsp;</span>
				          因病情需要，需转入贵单位，请予以接诊。
				</td>
			</tr>
			<tr>
				<td colspan ="8">
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					初步印象： &nbsp;&nbsp;<c:out value="${referral.primaryDiagnosis}"></c:out>&nbsp;&nbsp;</td>
			</tr>
			<tr>
				<td colspan ="8">
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					主要现病史（转出原因）： &nbsp;&nbsp;<c:out value="${referral.referralReason}"></c:out>&nbsp;&nbsp;</td>	
			</tr>
			<tr>
				<td colspan ="8">
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					主要既往史 ：&nbsp;&nbsp;<c:out value="${referral.medicalHistory}"></c:out>&nbsp;&nbsp;</td>
			</tr>
			<tr>
				<td colspan ="8">
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					治疗经过：&nbsp;&nbsp;<c:out value="${referral.treatment}"></c:out>&nbsp;&nbsp;</td>
			</tr>
			
			<tr>
				<td colspan="2" align="right">转诊医生（签字）：<c:out value="${referral.referralDoctorName }"></c:out>&nbsp;&nbsp;</td>
			</tr>
			<tr>
				<td colspan="2" align="right">联系电话：<c:out value="${referral.referralDoctorPhone}"></c:out>&nbsp;&nbsp;</td>
			</tr>
			<tr>
				<td colspan="2" align="right"><c:out value="${referral.destDeptName }"></c:out>&nbsp;&nbsp;</td>
			</tr>
			<tr>
				<td colspan="2" align="right">
				<fmt:formatDate type="date" dateStyle="long" value="${referral.referralDate}" />&nbsp;&nbsp;
				</td>
			</tr>
		</table>
</c:if>

<c:if test="${referral.dualReferralType eq 2}">
		<h1 align="center">
			<span style="font-size: 24px;">双向转诊（回转）单</span>
		</h1>
		<table class="layout_table">
			<tr>
				<td colspan ="8">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ${referral.referralHospitalName}：
				</td>
			</tr>
			<tr>
				<td colspan ="8">
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					现有患者<span class="line_with_border">&nbsp;&nbsp;<c:out value="${referral.name}"></c:out>&nbsp;&nbsp;</span>
					因病情需要，现转回贵单位，请予以接诊。</td>
			</tr>
			<tr>
				<td colspan ="8">
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					诊断结果<span class="line_with_border" > &nbsp;&nbsp;<c:out value="${referral.diagnosis}"></c:out>&nbsp;&nbsp;</span>
					住院病案号<span class="line_with_border" > &nbsp;&nbsp;<c:out value="${referral.medicalRecordNo}"></c:out>&nbsp;&nbsp;</span>
				</td>
			</tr>
			<tr>
				<td colspan ="8">
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					主要检查结果： &nbsp;&nbsp;<c:out value="${referral.checkResult}"></c:out>&nbsp;&nbsp;</td>	
			</tr>
			<tr>
				<td colspan ="8">
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					治疗经过、下一步治疗方案及康复建议：&nbsp;&nbsp;<c:out value="${referral.treatment}"></c:out>&nbsp;&nbsp;
					<c:out value="${referral.treatmentPlan}"></c:out>&nbsp;&nbsp;
					<c:out value="${referral.rehabilitationGuide}"></c:out>&nbsp;&nbsp;
				</td>
			</tr>
			<tr>
				<td colspan="2" align="right">转诊医生（签字）：<c:out value="${referral.referralDoctorName }"></c:out>&nbsp;&nbsp;</td>
			</tr>
			<tr>
				<td colspan="2" align="right">联系电话：<c:out value="${referral.referralDoctorPhone}"></c:out>&nbsp;&nbsp;</td>
			</tr>
			<tr>
				<td colspan="2" align="right"><c:out value="${referral.destDeptName }"></c:out>&nbsp;&nbsp;</td>
			</tr>
			<tr>
				<td colspan="2" align="right">
				<fmt:formatDate type="date" dateStyle="long" value="${referral.referralDate}" />&nbsp;&nbsp;
				</td>
			</tr>
		</table>
</c:if>
</div>

