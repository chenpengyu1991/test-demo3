<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>

<link rel="stylesheet" href="${pageContext.request.contextPath}/css/views/ehrbrowser/basic/basic.css" />
<script src="${pageContext.request.contextPath}/js/views/woman/prenatalFollowupOther/view.js" type="text/javascript"></script>

<%--<div class="toolbar">
	<c:if test="${isShowBackBtn}">
		<a href="javascript:void(0)" id="pFOBackViewId"><b class="fanhui">返回</b></a>
	</c:if>
</div>--%>
<div style="background-color: white; height: 850px;">
	<ul>
		<li style="text-align: center; font-size: 25px;">第2-5次产前随访服务记录表</li>
	</ul>
	<br/>
	<form id="pFOAddFromId">
		<div class="table-basic">
			<table>
				<colgroup>
					<col style="width: 15%;"/>
					<col style="width: 21%;"/>
					<col style="width: 21%;"/>
					<col style="width: 21%;"/>
					<col style="width: 22%;"/>
				</colgroup>
				<tr>
					<th colspan="4" align="right">健康档案编号</th>
					<td>
						<c:out value="${prenatalFollowupOther.healthFileNo}"/>
					</td>
				</tr>
				<tr>
					<th>身份证号</th>
					<td>${prenatalFollowupOther.idCard}</td>
					<td>孕妇姓名:${prenatalFollowupOther.name}</td>
					<th>预产期</th>
					<td><fmt:formatDate value="${prenatalFollowupOther.estimatedDueDates}" pattern="yyyy/MM/dd"/></td>
				</tr>
				<tr>
					<th>项目</th>
					<td style="text-align: center">第2次</td>
					<td style="text-align: center">第3次</td>
					<td style="text-align: center">第4次*</td>
					<td style="text-align: center">第5次*</td>
				</tr>
				<tr>
					<th>随访日期</th>
					<td><fmt:formatDate value="${prenatalFollowupOther.inputDateTwo}" pattern="yyyy/MM/dd"/></td>

					<td><fmt:formatDate value="${prenatalFollowupOther.inputDateThree}" pattern="yyyy/MM/dd"/></td>

					<td><fmt:formatDate value="${prenatalFollowupOther.inputDateFour}" pattern="yyyy/MM/dd"/></td>

					<td><fmt:formatDate value="${prenatalFollowupOther.inputDateFive}" pattern="yyyy/MM/dd"/></td>
				</tr>
				<tr>
					<th>孕周</th>
					<td>${prenatalFollowupOther.gestationalWeeksTwo}周</td>
					<td>${prenatalFollowupOther.gestationalWeeksThree}周</td>
					<td>${prenatalFollowupOther.gestationalWeeksFour}周</td>
					<td>${prenatalFollowupOther.gestationalWeeksFive}周</td>
				</tr>
				<tr>
					<th>主诉</th>
					<td>${prenatalFollowupOther.chiefComplaintTwo}</td>
					<td>${prenatalFollowupOther.chiefComplaintThree}</td>
					<td>${prenatalFollowupOther.chiefComplaintFour}</td>
					<td>${prenatalFollowupOther.chiefComplaintFive}</td>
				</tr>
				<tr>
					<th>体重</th>
					<td>${prenatalFollowupOther.bodyWeightTwo}kg</td>
					<td>${prenatalFollowupOther.bodyWeightThree}kg</td>
					<td>${prenatalFollowupOther.bodyWeightFour}kg</td>
					<td>${prenatalFollowupOther.bodyWeightFive}kg</td>
				</tr>
				<tr>
					<th>宫底高度</th>
					<td>${prenatalFollowupOther.uterineBottomHeightTwo}cm</td>
					<td>${prenatalFollowupOther.uterineBottomHeightThree}cm</td>
					<td>${prenatalFollowupOther.uterineBottomHeightFour}cm</td>
					<td>${prenatalFollowupOther.uterineBottomHeightFive}cm</td>
				</tr>
				<tr>
					<th>腹围</th>
					<td>${prenatalFollowupOther.abdominalGirthTwo}cm</td>
					<td>${prenatalFollowupOther.abdominalGirthThree}cm</td>
					<td>${prenatalFollowupOther.abdominalGirthFour}cm</td>
					<td>${prenatalFollowupOther.abdominalGirthFive}cm</td>
				</tr>
				<tr>
					<th>胎位</th>
					<td>
					</td>
					<td>
					</td>
					<td>
						<ehr:dic code="${prenatalFollowupOther.fetalPositionFour}" dicmeta="CV0501007"/>
						<ehr:dic code="${prenatalFollowupOther.fetalPositionFourSec}" dicmeta="CV0501007"/>
					</td>
					<td>
						<ehr:dic code="${prenatalFollowupOther.fetalPositionFive}" dicmeta="CV0501007"/>
						<ehr:dic code="${prenatalFollowupOther.fetalPositionFiveSec}" dicmeta="CV0501007"/>
					</td>
				</tr>
				<tr>
					<th></th>
					<td>
					</td>
					<td>
					</td>
					<td>
						<ehr:dic code="${prenatalFollowupOther.fetalPositionFourThi}" dicmeta="CV0501007"/>
						<ehr:dic code="${prenatalFollowupOther.fetalPositionFourFou}" dicmeta="CV0501007"/>
					</td>
					<td>
						<ehr:dic code="${prenatalFollowupOther.fetalPositionFiveThi}" dicmeta="CV0501007"/>
						<ehr:dic code="${prenatalFollowupOther.fetalPositionFiveFou}" dicmeta="CV0501007"/>
					</td>
				</tr>
				<tr>
					<th>胎心率</th>
					<td>
						${prenatalFollowupOther.fetalHeartRateTwo}
						&nbsp;&nbsp;
						${prenatalFollowupOther.fetalHeartRateTwoSec}
					</td>
					<td>
						${prenatalFollowupOther.fetalHeartRateThree}
						&nbsp;&nbsp;
						${prenatalFollowupOther.fetalHeartRateThreeSec}
					</td>
					<td>
						${prenatalFollowupOther.fetalHeartRateFour}
						&nbsp;&nbsp;
						${prenatalFollowupOther.fetalHeartRateFourSec}
					</td>
					<td>
						${prenatalFollowupOther.fetalHeartRateFive}
						&nbsp;&nbsp;
						${prenatalFollowupOther.fetalHeartRateFiveSec}
					</td>
				</tr>
				<tr>
					<th></th>
					<td>
						${prenatalFollowupOther.fetalHeartRateTwoThi}
						&nbsp;&nbsp;
						${prenatalFollowupOther.fetalHeartRateTwoFou}
					</td>
					<td>
						${prenatalFollowupOther.fetalHeartRateThreeThi}
						&nbsp;&nbsp;
						${prenatalFollowupOther.fetalHeartRateThreeFou}
					</td>
					<td>
						${prenatalFollowupOther.fetalHeartRateFourThi}
						&nbsp;&nbsp;
						${prenatalFollowupOther.fetalHeartRateFourFou}
					</td>
					<td>
						${prenatalFollowupOther.fetalHeartRateFiveThi}
						&nbsp;&nbsp;
						${prenatalFollowupOther.fetalHeartRateFiveFou}
					</td>
				</tr>
				<tr>
					<th>血压(mmHg)</th>
					<td>
						${prenatalFollowupOther.sbpTwo}/
						${prenatalFollowupOther.dbpTwo}mmHg
					</td>
					<td>
						${prenatalFollowupOther.sbpThree}/
						${prenatalFollowupOther.dbpThree}mmHg
					</td>
					<td>
						${prenatalFollowupOther.sbpFour}/
						${prenatalFollowupOther.dbpFour}mmHg
					</td>
					<td>
						${prenatalFollowupOther.sbpFive}/
						${prenatalFollowupOther.dbpFive}mmHg
					</td>
				</tr>
				<tr>
					<th>血红蛋白</th>
					<td>
						${prenatalFollowupOther.hemoglobinValueTwo}g/L
					</td>
					<td>
						${prenatalFollowupOther.hemoglobinValueThree}g/L
					</td>
					<td>
						${prenatalFollowupOther.hemoglobinValueFour}g/L
					</td>
					<td>
						${prenatalFollowupOther.hemoglobinValueFive}g/L
					</td>
				</tr>
				<tr>
					<th>尿蛋白</th>
					<td>
						<ehr:dic code="${prenatalFollowupOther.urineProQuantitativeTwo}" dicmeta="CV0450015"/>
					</td>
					<td>
						<ehr:dic code="${prenatalFollowupOther.urineProQuantitativeThree}" dicmeta="CV0450015"/>
					</td>
					<td>
						<ehr:dic code="${prenatalFollowupOther.urineProQuantitativeFour}" dicmeta="CV0450015"/>
					</td>
					<td>
						<ehr:dic code="${prenatalFollowupOther.urineProQuantitativeFive}" dicmeta="CV0450015"/>
					</td>
				</tr>
				<tr>
					<th>产前筛查</th>
					<td>
						<ehr:dic code="${prenatalFollowupOther.screeningTwo}" dicmeta="FS10281"/>
						高危<ehr:dic code="${prenatalFollowupOther.screeningIsHighTwo}" dicmeta="FS10281"/>
					</td>
					<td>
						<ehr:dic code="${prenatalFollowupOther.screeningThree}" dicmeta="FS10281"/>
						高危<ehr:dic code="${prenatalFollowupOther.screeningIsHighThree}" dicmeta="FS10281"/>
					</td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<th>产前诊断</th>
					<td>
						<ehr:dic code="${prenatalFollowupOther.diagnosisTwo}" dicmeta="FS10281"/>
						确诊<ehr:dic code="${prenatalFollowupOther.diagnosisIsConfirmedTwo}" dicmeta="FS10281"/>
					</td>
					<td>
						<ehr:dic code="${prenatalFollowupOther.diagnosisThree}" dicmeta="FS10281"/>
						确诊<ehr:dic code="${prenatalFollowupOther.diagnosisIsConfirmedThree}" dicmeta="FS10281"/>
					</td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<th>其他辅助检查</th>
					<td>
						<ehr:dic code="${prenatalFollowupOther.otherExamTwoSign}" dicmeta="FS10111"/>
						<c:if test="${prenatalFollowupOther.otherExamTwoSign eq '2'}">
							${prenatalFollowupOther.otherExamTwo}
						</c:if>
					</td>
					<td>
						<ehr:dic code="${prenatalFollowupOther.otherExamThreeSign}" dicmeta="FS10111"/>
						<c:if test="${prenatalFollowupOther.otherExamThreeSign eq '2'}">
							${prenatalFollowupOther.otherExamThree}
						</c:if>
					</td>
					<td>
						<ehr:dic code="${prenatalFollowupOther.otherExamFourSign}" dicmeta="FS10111"/>
						<c:if test="${prenatalFollowupOther.otherExamFourSign eq '2'}">
							${prenatalFollowupOther.otherExamFour}
						</c:if>
					</td>
					<td>
						<ehr:dic code="${prenatalFollowupOther.otherExamFiveSign}" dicmeta="FS10111"/>
						<c:if test="${prenatalFollowupOther.otherExamFiveSign eq '2'}">
							${prenatalFollowupOther.otherExamFive}
						</c:if>
					</td>
				</tr>
				<tr>
					<th>分类</th>
					<td>
						<ehr:dic code="${prenatalFollowupOther.classifySignTwo}" dicmeta="FS10046"/>
						<c:if test="${prenatalFollowupOther.classifySignTwo eq '2'}">
							${prenatalFollowupOther.classifyDescTwo}
						</c:if>
					</td>
					<td>
						<ehr:dic code="${prenatalFollowupOther.classifySignThree}" dicmeta="FS10046"/>
						<c:if test="${prenatalFollowupOther.classifySignThree eq '2'}">
							${prenatalFollowupOther.classifyDescThree}
						</c:if>
					</td>
					<td>
						<ehr:dic code="${prenatalFollowupOther.classifySignFour}" dicmeta="FS10046"/>
						<c:if test="${prenatalFollowupOther.classifySignFour eq '2'}">
							${prenatalFollowupOther.classifyDescFour}
						</c:if>
					</td>
					<td>
						<ehr:dic code="${prenatalFollowupOther.classifySignFive}" dicmeta="FS10046"/>
						<c:if test="${prenatalFollowupOther.classifySignFive eq '2'}">
							${prenatalFollowupOther.classifyDescFive}
						</c:if>
					</td>
				</tr>
				<tr>
					<th>指导</th>
					<td style="valign:top">
						<ehr:dic code="${prenatalFollowupOther.healthGuidanceClassTwo}" dicmeta="CV0600219"/>
						<c:if test="${fn:contains(prenatalFollowupOther.healthGuidanceClassTwo,'99')}">
							${prenatalFollowupOther.healthGuidanceClassDescTwo}
						</c:if>
					</td>
					<td>
						<ehr:dic code="${prenatalFollowupOther.healthGuidanceClassThree}" dicmeta="CV0600219"/>
						<c:if test="${fn:contains(prenatalFollowupOther.healthGuidanceClassThree,'99')}">
							${prenatalFollowupOther.healthGuiClassDescThree}
						</c:if>
					</td>
					<td>
						<ehr:dic code="${prenatalFollowupOther.healthGuidanceClassFour}" dicmeta="CV0600219"/>
						<c:if test="${fn:contains(prenatalFollowupOther.healthGuidanceClassFour,'99')}">
							${prenatalFollowupOther.healthGuiClassDescFour}
						</c:if>
					</td>
					<td>
						<ehr:dic code="${prenatalFollowupOther.healthGuidanceClassFive}" dicmeta="CV0600219"/>
						<c:if test="${fn:contains(prenatalFollowupOther.healthGuidanceClassFive,'99')}">
							${prenatalFollowupOther.healthGuiClassDescFive}
						</c:if>
					</td>
				</tr>

				<tr>
					<th>转诊</th>
					<td>
						<ehr:dic code="${prenatalFollowupOther.referralFlagTwo}" dicmeta="FS10111"/>
						<c:if test="${prenatalFollowupOther.referralFlagTwo eq '2'}">
							<br/>
							原因:${prenatalFollowupOther.referralReasonTwo}
							<br/>
							机构:${prenatalFollowupOther.referralHospitalNameTwo}
							<br/>
							科室:${prenatalFollowupOther.referralDeptNameTwo}
						</c:if>
					</td>
					<td>
						<ehr:dic code="${prenatalFollowupOther.referralFlagThree}" dicmeta="FS10111"/>
						<c:if test="${prenatalFollowupOther.referralFlagThree eq '2'}">
							<br/>
							原因:${prenatalFollowupOther.referralReasonThree}
							<br/>
							机构:${prenatalFollowupOther.referralHospitalNameThree}
							<br/>
							科室:${prenatalFollowupOther.referralDeptNameThree}
						</c:if>
					</td>
					<td>
						<ehr:dic code="${prenatalFollowupOther.referralFlagFour}" dicmeta="FS10111"/>
						<c:if test="${prenatalFollowupOther.referralFlagFour eq '2'}">
							<br/>
							原因:${prenatalFollowupOther.referralReasonFour}
							<br/>
							机构:${prenatalFollowupOther.referralHospitalNameFour}
							<br/>
							科室:${prenatalFollowupOther.referralDeptNameFour}
						</c:if>
					</td>
					<td>
						<ehr:dic code="${prenatalFollowupOther.referralFlagFive}" dicmeta="FS10111"/>
						<c:if test="${prenatalFollowupOther.referralFlagFive eq '2'}">
							<br/>
							原因:${prenatalFollowupOther.referralReasonFive}
							<br/>
							机构:${prenatalFollowupOther.referralHospitalNameFive}
							<br/>
							科室:${prenatalFollowupOther.referralDeptNameFive}
						</c:if>
					</td>
				</tr>
				<tr>
					<th>中医药健康管理服务</th>
					<td>
						<ehr:dic code="${prenatalFollowupOther.tcmHealthSignTwo}" dicmeta="FS10307"/>
						<c:if test="${fn:contains(prenatalFollowupOther.tcmHealthSignTwo,'99')}">
							${prenatalFollowupOther.tcmHealthSignDescTwo}
						</c:if>
					</td>
					<td>
						<ehr:dic code="${prenatalFollowupOther.tcmHealthSignThree}" dicmeta="FS10307"/>
						<c:if test="${fn:contains(prenatalFollowupOther.tcmHealthSignThree,'99')}">
							${prenatalFollowupOther.tcmHealthSignDescThree}
						</c:if>
					</td>
					<td>
						<ehr:dic code="${prenatalFollowupOther.tcmHealthSignFour}" dicmeta="FS10307"/>
						<c:if test="${fn:contains(prenatalFollowupOther.tcmHealthSignFour,'99')}">
							${prenatalFollowupOther.tcmHealthSignDescFour}
						</c:if>
					</td>
					<td>
						<ehr:dic code="${prenatalFollowupOther.tcmHealthSignFive}" dicmeta="FS10307"/>
						<c:if test="${fn:contains(prenatalFollowupOther.tcmHealthSignFive,'99')}">
							${prenatalFollowupOther.tcmHealthSignDescFive}
						</c:if>
					</td>
				</tr>

				<tr>
					<th>下次访视日期</th>
					<td><fmt:formatDate value="${prenatalFollowupOther.nextSupervisionDateTwo}" pattern="yyyy/MM/dd"/></td>
					<td><fmt:formatDate value="${prenatalFollowupOther.nextSupervisionDateThree}" pattern="yyyy/MM/dd"/></td>
					<td><fmt:formatDate value="${prenatalFollowupOther.nextSupervisionDateFour}" pattern="yyyy/MM/dd"/></td>
					<td><fmt:formatDate value="${prenatalFollowupOther.nextSupervisionDateFive}" pattern="yyyy/MM/dd"/></td>
				</tr>
				<tr>
					<th>随访医生签名</th>
					<td>
						<ehr:staff-name staffCode="${prenatalFollowupOther.supervisionDoctorTwo}"/>
					</td>
					<td>
						<ehr:staff-name staffCode="${prenatalFollowupOther.supervisionDoctorThree}"/>
					</td>
					<td>
						<ehr:staff-name staffCode="${prenatalFollowupOther.supervisionDoctorFour}"/>
					</td>
					<td>
						<ehr:staff-name staffCode="${prenatalFollowupOther.supervisionDoctorFive}"/>
					</td>
				</tr>
			</table>
		</div>
	</form>
</div>