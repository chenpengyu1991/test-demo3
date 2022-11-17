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
		<li style="text-align: center; font-size: 25px;">孕产妇登记</li>
	</ul>
	<br />
		<div class="table-basic" style="overflow: inherit">
			<table class="layui-table x-admin-sm-table-list-small">
				<colgroup>
					<col style="width: 15%;" />
					<col style="width: 35%;" />
					<col style="width: 15%;" />
					<col style="width: 35%;" />
				</colgroup>
				<tr>
					<th>姓名</th>
					<td><c:out value="${maternalRegistration.name}"/></td>
					<th>出生日期</th>
					<td><fmt:formatDate value="${maternalRegistration.birthday}" pattern="yyyy/MM/dd"/></td>
				</tr>
				<tr>
					<th>健康档案编号</th>
					<td><c:out value="${maternalRegistration.healthFileNo}"/></td>
					<th>孕产妇编号</th>
					<td><c:out value="${maternalRegistration.recordNumber}"/></td>
				</tr>
				<tr>
					<th>年龄</th>
					<td><c:out value="${maternalRegistration.age}"/> 岁</td>
					<th>常住类型</th>
					<td><c:out value="${maternalRegistration.householdName}"/></td>
				</tr>
				<tr>
					<th>身份证件类别</th>
					<td><c:out value="${maternalRegistration.idcardTypeName}"/></td>
					<th>身份证件号码</th>
					<td><c:out value="${maternalRegistration.idCard}"/></td>
				</tr>
				<tr>
					<th>户籍地址</th>
					<td colspan="3"><c:out value="${maternalRegistration.hrAddressName}"/></td>
				</tr>
				<tr>
					<th>户籍地址邮政编码</th>
					<td colspan="3"><c:out value="${maternalRegistration.hrAddressCode}"/></td>
				</tr>
				<tr>
					<th>现住址</th>
					<td colspan="3"><c:out value="${maternalRegistration.paAddressName}"/></td>
				</tr>
				<tr>
					<th>现住址邮政编码</th>
					<td colspan="3"><c:out value="${maternalRegistration.paAddressCode}"/></td>
				</tr>
				<tr>
					<th>填表孕周</th>
					<td colspan="3"><c:out value="${maternalRegistration.deliveryWeek}"/> 周</td>
				</tr>
				<tr>
					<th>孕次</th>
					<td colspan="3"><c:out value="${maternalRegistration.gravidityTimes}"/> 次</td>
				</tr>
				<tr>
					<th>丈夫姓名</th>
					<td><c:out value="${maternalRegistration.husbandName}"/></td>
					<th>丈夫出生日期</th>
					<td><fmt:formatDate value="${maternalRegistration.husbandBirthday}" pattern="yyyy/MM/dd"/></td>
				</tr>
				<tr>
					<th>丈夫单位</th>
					<td colspan="3"><c:out value="${maternalRegistration.husbandUnit}"/></td>
				</tr>
				<tr>
					<th>丈夫联系电话</th>
					<td colspan="3"><c:out value="${maternalRegistration.husbandPhone}"/></td>
				</tr>
				<tr>
					<th>丈夫年龄</th>
					<td><c:out value="${maternalRegistration.husbandAge}"/> 岁</td>
					<th>身高</th>
					<td><c:out value="${maternalRegistration.height}"/> cm</td>
				</tr>
				<tr>
					<th>体重</th>
					<td><c:out value="${maternalRegistration.bodyWeight}"/> kg</td>
					<th>体质指数</th>
					<td><c:out value="${maternalRegistration.bmi}"/> kg/㎡</td>
				</tr>
				<tr>
					<th>ABO血型</th>
					<td><c:out value="${maternalRegistration.aboName}"/></td>
					<th>是否高危</th>
					<td><c:out value="${maternalRegistration.riskFactorFlagName}"/></td>
				</tr>
				<tr>
					<th>孕产期高危因素</th>
					<td colspan="3"><c:out value="${maternalRegistration.riskFactorName}"/></td>
				</tr>
				<tr>
					<th>孕产期其他高危因素</th>
					<td><c:out value="${maternalRegistration.riskFactorDesc}"/></td>
					<th>高危评定</th>
					<td><c:out value="${maternalRegistration.riskLevelName}"/></td>
				</tr>
				<tr>
					<th>高危评分</th>
					<td colspan="3"><c:out value="${maternalRegistration.riskScoreValue}"/></td>
				</tr>
				<tr>
					<th>是否转诊</th>
					<c:if test='${maternalRegistration.referralFlag ne "2"}'>
						<td colspan="3"><span>否</span></td>
					</c:if>
					<c:if test='${maternalRegistration.referralFlag eq "2"}'>
						<td><span class="label label-danger">是</span></td>
						<th>转诊原因</th>
						<td>${maternalRegistration.referralReason}</td>
					</c:if>
				</tr>
				<c:if test='${maternalRegistration.referralFlag eq "2"}'>
					<tr>
						<th>转诊机构</th>
						<td>${maternalRegistration.referralHospitalName}</td>
						<th>转诊机构科室</th>
						<td>${maternalRegistration.referralDeptName}</td>
					</tr>
				</c:if>
				<tr>
					<th>下次随访日期</th>
					<td><fmt:formatDate value="${maternalRegistration.nextVisitDate}" pattern="yyyy/MM/dd"/></td>
					<th>随访机构</th>
					<td><c:out value="${maternalRegistration.visitOrgName}"/></td>
				</tr>
				<tr>
					<th>随访医生姓名</th>
					<td><c:out value="${maternalRegistration.visitDoctorName}"/></td>
					<th>结案标志</th>
					<td><c:out value="${maternalRegistration.finalMarkName}"/></td>
				</tr>
				<tr>
					<th>建档机构</th>
					<td colspan="3">${maternalRegistration.inputOrgName}</td>
				</tr>
				<tr>
					<th>建档人</th>
					<td>${maternalRegistration.inputDoctorName}</td>
					<th>建档人联系电话号码</th>
					<td>${maternalRegistration.inputDoctorPhone}</td>
				</tr>
				<tr>
					<th>管档机构</th>
					<td>${maternalRegistration.manageOrgName}</td>
					<th>建档日期</th>
					<td><fmt:formatDate value="${maternalRegistration.inputDate}" pattern="yyyy/MM/dd" /></td>
				</tr>
				<tr>
					<th>就诊机构</th>
					<td colspan="3">${maternalRegistration.clinicOrganName}</td>
				</tr>
			</table>
		</div>

</div>