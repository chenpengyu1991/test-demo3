<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<link rel="stylesheet"
	  href="${pageContext.request.contextPath}/css/views/ehrbrowser/basic/basic.css" />

<div style="background-color: white; height: 515px;">
	<ul>
		<li style="text-align: center; font-size: 25px;">第2-5次产前随访</li>
	</ul>
	<br />
	<div class="table-basic" style="overflow: inherit">
		<table class="layui-table x-admin-sm-table-list-small">
			<colgroup>
				<col style="width: 5%;min-width: 120px;" />
				<col style="width: 15%;" />
				<col style="width: 20%;" />
				<col style="width: 20%;" />
				<col style="width: 20%;" />
				<col style="width: 20%;" />
			</colgroup>
			<tr>
				<th  colspan="2">项&emsp;&emsp;目</th>
				<th >第2次</th>
				<th >第3次</th>
				<th >第4次</th>
				<th >第5次</th>
			</tr>
			<tr>
				<th  colspan="2">(随访/督促)日期</th>
				<td><fmt:formatDate value="${whYcfbjCqsf.inputDateTwo}" pattern="yyyy/MM/dd"/></td>
				<td><fmt:formatDate value="${whYcfbjCqsf.inputDateThree}" pattern="yyyy/MM/dd"/></td>
				<td><fmt:formatDate value="${whYcfbjCqsf.inputDateFour}" pattern="yyyy/MM/dd"/></td>
				<td><fmt:formatDate value="${whYcfbjCqsf.inputDateFive}" pattern="yyyy/MM/dd"/></td>
			</tr>
			<tr>
				<th  colspan="2">孕&emsp;&emsp;周</th>
				<td>${whYcfbjCqsf.gestationalWeeksTwo}周</td>
				<td>${whYcfbjCqsf.gestationalWeeksThree}周</td>
				<td>${whYcfbjCqsf.gestationalWeeksFour}周</td>
				<td>${whYcfbjCqsf.gestationalWeeksFive}周</td>
			</tr>
			<tr>
				<th  colspan="2">主&emsp;&emsp;诉</th>
				<td>${whYcfbjCqsf.chiefComplaintTwo}</td>
				<td>${whYcfbjCqsf.chiefComplaintThree}</td>
				<td>${whYcfbjCqsf.chiefComplaintFour}</td>
				<td>${whYcfbjCqsf.chiefComplaintFive}</td>
			</tr>
			<tr>
				<th  colspan="2">体重（kg）</th>
				<td>${whYcfbjCqsf.bodyWeightTwo}</td>
				<td>${whYcfbjCqsf.bodyWeightThree}</td>
				<td>${whYcfbjCqsf.bodyWeightFour}</td>
				<td>${whYcfbjCqsf.bodyWeightFive}</td>
			</tr>
			<tr>
				<th  style="vertical-align: middle;"  rowspan="4">产<br>科<br>检<br>查</th>
				<th >宫底高度（cm）</th>
				<td>${whYcfbjCqsf.uterineBottomHeightTwo}</td>
				<td>${whYcfbjCqsf.uterineBottomHeightThree}</td>
				<td>${whYcfbjCqsf.uterineBottomHeightFour}</td>
				<td>${whYcfbjCqsf.uterineBottomHeightFive}</td>
			</tr>
			<tr>
				<th >腹&emsp;&emsp;围（cm）</th>
				<td>${whYcfbjCqsf.abdominalGirthTwo}</td>
				<td>${whYcfbjCqsf.abdominalGirthThree}</td>
				<td>${whYcfbjCqsf.abdominalGirthFour}</td>
				<td>${whYcfbjCqsf.abdominalGirthFive}</td>
			</tr>
			<tr>
				<th  style="vertical-align: middle;" >胎&emsp;&emsp;位&emsp;&emsp;&emsp;</th>
				<td></td>
				<td></td>
				<td>
					<ehr:dic code="${whYcfbjCqsf.fetalPositionFour}" dicmeta="CV0501007"/>&emsp;&emsp;
					<ehr:dic code="${whYcfbjCqsf.fetalPositionFourSec}" dicmeta="CV0501007"/><br>
					<ehr:dic code="${whYcfbjCqsf.fetalPositionFourThi}" dicmeta="CV0501007"/>&emsp;&emsp;
					<ehr:dic code="${whYcfbjCqsf.fetalPositionFourFou}" dicmeta="CV0501007"/>
				</td>
				<td>
					<ehr:dic code="${whYcfbjCqsf.fetalPositionFive}" dicmeta="CV0501007"/>&emsp;&emsp;
					<ehr:dic code="${whYcfbjCqsf.fetalPositionFiveSec}" dicmeta="CV0501007"/><br>
					<ehr:dic code="${whYcfbjCqsf.fetalPositionFiveThi}" dicmeta="CV0501007"/>&emsp;
					<ehr:dic code="${whYcfbjCqsf.fetalPositionFiveFou}" dicmeta="CV0501007"/>
				</td>
			</tr>
			<tr>
				<th  style="vertical-align: middle;" >胎心率（次/分钟）</th>
				<td>
					${whYcfbjCqsf.fetalHeartRateTwo}&emsp;&emsp;${whYcfbjCqsf.fetalHeartRateTwoSec}<br>
					${whYcfbjCqsf.fetalHeartRateTwoThi}&emsp;&emsp;${whYcfbjCqsf.fetalHeartRateTwoFou}
				</td>
				<td>
					${whYcfbjCqsf.fetalHeartRateThree}&emsp;&emsp;${whYcfbjCqsf.fetalHeartRateThreeSec}<br>
					${whYcfbjCqsf.fetalHeartRateThreeThi}&emsp;&emsp;${whYcfbjCqsf.fetalHeartRateThreeFou}
				</td>
				<td>
					${whYcfbjCqsf.fetalHeartRateFour}&emsp;&emsp;${whYcfbjCqsf.fetalHeartRateFourSec}<br>
					${whYcfbjCqsf.fetalHeartRateFourThi}&emsp;&emsp;${whYcfbjCqsf.fetalHeartRateFourFou}
				</td>
				<td>
					${whYcfbjCqsf.fetalHeartRateFive}&emsp;&emsp;${whYcfbjCqsf.fetalHeartRateFiveSec}<br>
					${whYcfbjCqsf.fetalHeartRateFiveThi}&emsp;&emsp;${whYcfbjCqsf.fetalHeartRateFiveFou}
				</td>
			</tr>
			<tr>
				<th  colspan="2">血压（mmHg）</th>
				<td>${whYcfbjCqsf.sbpTwo}&nbsp;/&nbsp;${whYcfbjCqsf.dbpTwo}</td>
				<td>${whYcfbjCqsf.sbpThree}&nbsp;/&nbsp;${whYcfbjCqsf.dbpThree}</td>
				<td>${whYcfbjCqsf.sbpFour}&nbsp;/&nbsp;${whYcfbjCqsf.dbpFour}</td>
				<td>${whYcfbjCqsf.sbpFive}&nbsp;/&nbsp;${whYcfbjCqsf.dbpFive}</td>
			</tr>
			<tr>
				<th  colspan="2">血红蛋白（g/L）</th>
				<td>${whYcfbjCqsf.hemoglobinValueTwo}</td>
				<td>${whYcfbjCqsf.hemoglobinValueThree}</td>
				<td>${whYcfbjCqsf.hemoglobinValueFour}</td>
				<td>${whYcfbjCqsf.hemoglobinValueFive}</td>
			</tr>
			<tr>
				<th  colspan="2">尿&emsp;蛋&emsp;白</th>
				<td><ehr:dic code="${whYcfbjCqsf.urineProQuantitativeTwo}" dicmeta="CV0450015"/></td>
				<td><ehr:dic code="${whYcfbjCqsf.urineProQuantitativeThree}" dicmeta="CV0450015"/></td>
				<td><ehr:dic code="${whYcfbjCqsf.urineProQuantitativeFour}" dicmeta="CV0450015"/></td>
				<td><ehr:dic code="${whYcfbjCqsf.urineProQuantitativeFive}" dicmeta="CV0450015"/></td>
			</tr>
			<tr>
				<th  colspan="2">其他辅助检查</th>
				<td>
					<ehr:dic code="${whYcfbjCqsf.otherExamTwoSign}" dicmeta="FS10111"/>
					<c:if test="${whYcfbjCqsf.otherExamTwoSign eq '2'}">
						${whYcfbjCqsf.otherExamTwo}
					</c:if>
				</td>
				<td>
					<ehr:dic code="${whYcfbjCqsf.otherExamThreeSign}" dicmeta="FS10111"/>
					<c:if test="${whYcfbjCqsf.otherExamThreeSign eq '2'}">
						${whYcfbjCqsf.otherExamThree}
					</c:if>
				</td>
				<td>
					<ehr:dic code="${whYcfbjCqsf.otherExamFourSign}" dicmeta="FS10111"/>
					<c:if test="${whYcfbjCqsf.otherExamFourSign eq '2'}">
						${whYcfbjCqsf.otherExamFour}
					</c:if>
				</td>
				<td>
					<ehr:dic code="${whYcfbjCqsf.otherExamFiveSign}" dicmeta="FS10111"/>
					<c:if test="${whYcfbjCqsf.otherExamFiveSign eq '2'}">
						${whYcfbjCqsf.otherExamFive}
					</c:if>
				</td>
			</tr>
			<tr>
				<th  colspan="2">分&emsp;&emsp;类</th>
				<td>
					<c:if test="${!empty whYcfbjCqsf.classifySignTwo}">
						<c:choose>
							<c:when test="${whYcfbjCqsf.classifySignTwo eq '1'}"><span class="label label-success">未见异常</span></c:when>
							<c:otherwise><span >异常</span> ${whYcfbjCqsf.classifyDescTwo}</c:otherwise>
						</c:choose>
					</c:if>
				</td>
				<td>
					<c:if test="${!empty whYcfbjCqsf.classifySignThree}">
						<c:choose>
							<c:when test="${whYcfbjCqsf.classifySignThree eq '1'}"><span class="label label-success">未见异常</span></c:when>
							<c:otherwise><span >异常</span> ${whYcfbjCqsf.classifyDescThree}</c:otherwise>
						</c:choose>
					</c:if>
				</td>
				<td>
					<c:if test="${!empty whYcfbjCqsf.classifySignFour}">
						<c:choose>
							<c:when test="${whYcfbjCqsf.classifySignFour eq '1'}"><span class="label label-success">未见异常</span></c:when>
							<c:otherwise><span >异常</span> ${whYcfbjCqsf.classifyDescFour}</c:otherwise>
						</c:choose>
					</c:if>
				</td>
				<td>
					<c:if test="${!empty whYcfbjCqsf.classifySignFive}">
						<c:choose>
							<c:when test="${whYcfbjCqsf.classifySignFive eq '1'}"><span class="label label-success">未见异常</span></c:when>
							<c:otherwise><span >异常</span> ${whYcfbjCqsf.classifyDescFive}</c:otherwise>
						</c:choose>
					</c:if>
				</td>
			</tr>
			<tr>
				<th  style="vertical-align: middle;" colspan="2">指&emsp;&emsp;导</th>
				<td>
					<ehr:dic code="${whYcfbjCqsf.healthGuidanceClassTwo}" dicmeta="CV0600219"/>
					<c:if test="${fn:contains(whYcfbjCqsf.healthGuidanceClassTwo,'99')}">
						${whYcfbjCqsf.healthGuidanceClassDescTwo}
					</c:if>
				</td>
				<td>
					<ehr:dic code="${whYcfbjCqsf.healthGuidanceClassThree}" dicmeta="CV0600219"/>
					<c:if test="${fn:contains(whYcfbjCqsf.healthGuidanceClassThree,'99')}">
						${whYcfbjCqsf.healthGuiClassDescThree}
					</c:if>
				</td>
				<td>
					<ehr:dic code="${whYcfbjCqsf.healthGuidanceClassFour}" dicmeta="CV0600219"/>
					<c:if test="${fn:contains(whYcfbjCqsf.healthGuidanceClassFour,'99')}">
						${whYcfbjCqsf.healthGuiClassDescFour}
					</c:if>
				</td>
				<td>
					<ehr:dic code="${whYcfbjCqsf.healthGuidanceClassFive}" dicmeta="CV0600219"/>
					<c:if test="${fn:contains(whYcfbjCqsf.healthGuidanceClassFive,'99')}">
						${whYcfbjCqsf.healthGuiClassDescFive}
					</c:if>
				</td>
			</tr>
			<tr>
				<th  colspan="2">转&emsp;&emsp;诊</th>
				<td>
					<c:if test="${!empty whYcfbjCqsf.referralFlagTwo}">
					<c:choose>
					<c:when test="${whYcfbjCqsf.referralFlagTwo eq '2'}"><span >有</span></c:when>
					<c:otherwise><span class="label label-success">无</c:otherwise>
                       </c:choose>
                    </c:if>
					<c:if test="${whYcfbjCqsf.referralFlagTwo eq '2'}">
						<br/>
						原因:${whYcfbjCqsf.referralReasonTwo}
						<br/>
						机构:${whYcfbjCqsf.referralHospitalNameTwo}
						<br/>
						科室:${whYcfbjCqsf.referralDeptNameTwo}
					</c:if>
				</td>
				<td>
					<c:if test="${!empty whYcfbjCqsf.referralFlagThree}">
					<c:choose>
					<c:when test="${whYcfbjCqsf.referralFlagThree eq '2'}"><span >有</span></c:when>
					<c:otherwise><span class="label label-success">无</c:otherwise>
                       </c:choose>
                    </c:if>
					<c:if test="${whYcfbjCqsf.referralFlagThree eq '2'}">
						<br/>
						原因:${whYcfbjCqsf.referralReasonThree}
						<br/>
						机构:${whYcfbjCqsf.referralHospitalNameThree}
						<br/>
						科室:${whYcfbjCqsf.referralDeptNameThree}
					</c:if>
				</td>
				<td>
					<c:if test="${!empty whYcfbjCqsf.referralFlagFour}">
					<c:choose>
					<c:when test="${whYcfbjCqsf.referralFlagFour eq '2'}"><span >有</span></c:when>
					<c:otherwise><span class="label label-success">无</c:otherwise>
                       </c:choose>
                    </c:if>
					<c:if test="${whYcfbjCqsf.referralFlagFour eq '2'}">
						<br/>
						原因:${whYcfbjCqsf.referralReasonFour}
						<br/>
						机构:${whYcfbjCqsf.referralHospitalNameFour}
						<br/>
						科室:${whYcfbjCqsf.referralDeptNameFour}
					</c:if>
				</td>
				<td>
					<c:if test="${!empty whYcfbjCqsf.referralFlagFive}">
					<c:choose>
					<c:when test="${whYcfbjCqsf.referralFlagFive eq '2'}"><span >有</span></c:when>
					<c:otherwise><span class="label label-success">无</c:otherwise>
                       </c:choose>
                    </c:if>
					<c:if test="${whYcfbjCqsf.referralFlagFive eq '2'}">
						<br/>
						原因:${whYcfbjCqsf.referralReasonFive}
						<br/>
						机构:${whYcfbjCqsf.referralHospitalNameFive}
						<br/>
						科室:${whYcfbjCqsf.referralDeptNameFive}
					</c:if>
				</td>
			</tr>
			<tr>
				<th  colspan="2">下次随访日期</th>
				<td><fmt:formatDate value="${whYcfbjCqsf.nextSupervisionDateTwo}" pattern="yyyy/MM/dd"/></td>
				<td><fmt:formatDate value="${whYcfbjCqsf.nextSupervisionDateThree}" pattern="yyyy/MM/dd"/></td>
				<td><fmt:formatDate value="${whYcfbjCqsf.nextSupervisionDateFour}" pattern="yyyy/MM/dd"/></td>
				<td><fmt:formatDate value="${whYcfbjCqsf.nextSupervisionDateFive}" pattern="yyyy/MM/dd"/></td>
			</tr>
			<tr>
				<th  colspan="2">随访医生签名</th>
				<td><ehr:staff-name staffCode="${whYcfbjCqsf.supervisionDoctorTwo}"/></td>
				<td><ehr:staff-name staffCode="${whYcfbjCqsf.supervisionDoctorThree}"/></td>
				<td><ehr:staff-name staffCode="${whYcfbjCqsf.supervisionDoctorFour}"/></td>
				<td><ehr:staff-name staffCode="${whYcfbjCqsf.supervisionDoctorFive}"/></td>
			</tr>
			<tr>
				<th  colspan="2">随访机构</th>
				<td><c:out value="${whYcfbjCqsf.createOrganNameTwo}"/></td>
				<td><c:out value="${whYcfbjCqsf.createOrganNameThree}"/></td>
				<td><c:out value="${whYcfbjCqsf.createOrganNameFour}"/></td>
				<td><c:out value="${whYcfbjCqsf.createOrganNameFive}"/></td>
			</tr>
		</table>
	</div>
</div>