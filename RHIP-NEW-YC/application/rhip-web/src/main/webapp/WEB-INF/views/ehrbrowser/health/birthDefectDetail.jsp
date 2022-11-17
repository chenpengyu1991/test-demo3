<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>

<link rel="stylesheet" href="${pageContext.request.contextPath}/css/views/ehrbrowser/basic/basic.css" />

<div style="background-color: white;height: 515px;">
	<ul>
		<li style="text-align: center;font-size: 25px;">出生缺陷儿报告卡</li>
	</ul>
	<div class="table-basic" style="overflow: inherit">
	<table class="layui-table x-admin-sm-table-list-small">
		<colgroup>
			<col style="width: 16%;"/>
            <col style="width: 14%;"/>
            <col style="width: 20%;"/>
            <col style="width: 16%;"/>
            <col style="width: 15%;"/>
            <col style="width: 19%;"/>
		</colgroup>
		<tr>
			<th>填报日期</th>
			<td colspan="2"><fmt:formatDate value="${birthDefectMonitor.fillDate}" pattern="yyyy/MM/dd"></fmt:formatDate></td>
			<th>编号</th>
			<td colspan="2">${birthDefectMonitor.recordNumber}</td>
		</tr>
		<tr>
			<th>缺陷儿性别</th>
			<td><ehr:dic dicmeta="GBT226112003" code="${birthDefectMonitor.neonatalGender}"></ehr:dic></td>
			<th>胎龄</th>
			<td><c:out value="${birthDefectMonitor.gestationalAge}" ></c:out></td>
			<th>出生体重</th>
			<td><c:out value="${birthDefectMonitor.birthWeight}" ></c:out>克</td>
		</tr>
		<tr>
			<th>胎数</th>
			<td><c:out value="${birthDefectMonitor.gestationalNumber}" ></c:out></td>
			<th>多胎类型</th>
			<td><ehr:dic dicmeta="FS10037" code="${birthDefectMonitor.multipleBirthsType}"></ehr:dic></td>
			<th>出生缺陷儿结局</th>
			<td><ehr:dic dicmeta="CV0210004" code="${birthDefectMonitor.birthDefect}"></ehr:dic></td>
		</tr>
		<tr>
			<th>出生缺陷诊断依据</th>
			<td><ehr:dic dicmeta="CV0501014" code="${birthDefectMonitor.diagnosisBasisType}"></ehr:dic></td>
			<th>出生缺陷确诊时间类别</th>
			<td><ehr:dic dicmeta="CV0501015" code="${birthDefectMonitor.definiteTimeType}"></ehr:dic></td>
			<th>出生缺陷类别</th>
			<td><ehr:dic dicmeta="CV0501016" code="${birthDefectMonitor.birthDefectType}"></ehr:dic></td>
		</tr>
		<tr>
			<th>孕早期患病标志</th>
			<td>
				<c:if test='${birthDefectMonitor.trimesterIllnessFlag eq "1"}'>是</c:if>
				<c:if test='${birthDefectMonitor.trimesterIllnessFlag eq "0"}'>否</c:if>
			</td>
			<c:if  test='${birthDefectMonitor.trimesterIllnessFlag eq "1"}'>
				<th>孕早期患病情况</th>
				<td><c:out value="${birthDefectMonitor.trimesterIllnessState}" ></c:out></td>
				<th>孕早期服药类别</th>
				<td><ehr:dic dicmeta="CV0300401" code="${birthDefectMonitor.trimesterMedicationType}"></ehr:dic></td>
			</c:if>
		</tr>
		<c:if  test='${birthDefectMonitor.trimesterIllnessFlag eq "1"}'>
			<tr>
				<th>药物名称</th>
				<td colspan="5"><c:out value="${birthDefectMonitor.drugName}" ></c:out></td>
			</tr>
		</c:if>
		<tr>
			<th>治疗性引产</th>
			<td>
				<c:if test='${birthDefectMonitor.therapeuticAbortionFlag eq "1"}'>是</c:if>
				<c:if test='${birthDefectMonitor.therapeuticAbortionFlag eq "0"}'>否</c:if>
			</td>
			<th>接触有害因素类别</th>
			<td><ehr:dic dicmeta="CV510110" code="${birthDefectMonitor.trimesterHarmFactorType}"></ehr:dic></td>
			<th>接触有害因素情况</th>
			<td><c:out value="${birthDefectMonitor.trimesterHarmFactorState}"></c:out></td>
		</tr>
		<tr>
		</tr>
		<tr></tr>
		<tr style="text-align: center;font-size: 15px;border: 2px;border-color: black;">
			<td colspan="6">产母情况</td>
		</tr>
		<tr>
			<th>住院号</th>
			<td><c:out value="${birthDefectMonitor.admissionNo}" ></c:out></td>
			<th>母亲姓名</th>
			<td><c:out value="${birthDefectMonitor.name}" ></c:out></td>
			<th>身份证号码</th>
			<td><c:out value="${birthDefectMonitor.idCard}" ></c:out></td>
		</tr>
		<tr>
			<th>出生日期</th>
			<td><fmt:formatDate value="${birthDefectMonitor.birthday}" pattern="yyyy/MM/dd"></fmt:formatDate></td>
			<th>民族</th>
			<td><ehr:dic dicmeta="GBT3304" code="${birthDefectMonitor.nation}"></ehr:dic></td>
			<th>电话号码</th>
			<td><c:out value="${birthDefectMonitor.phoneNumber}" ></c:out></td>
		</tr>
		<tr>
			<th>文化程度</th>
			<td>
				<ehr:dic dicmeta="GBT46582006"  code="${birthDefectMonitor.education}"/>
			</td>
			<th>家庭年人均收入</th>
			<td><ehr:dic dicmeta="CV0201203"  code="${birthDefectMonitor.familyPerCapitaIncomeType}"></ehr:dic></td>
			<th>行政区划</th>
			<td><c:out value="${birthDefectMonitor.areaCode}" ></c:out></td>
		</tr>
		<tr>
			<th>户籍地址</th>
			<td colspan="3">
				<c:out value="${birthDefectMonitor.hrprovince }"></c:out>
				<c:out value="${birthDefectMonitor.hrcity }"></c:out>
				<c:out value="${birthDefectMonitor.hrcounty }"></c:out>
				<c:out value="${birthDefectMonitor.hrtownShip }"></c:out>
				<c:out value="${birthDefectMonitor.hrstreet }"></c:out>
				<c:out value="${birthDefectMonitor.hrhouseNumber }"></c:out>
			</td>
			<th>户籍邮政编码</th>
			<td><c:out value="${birthDefectMonitor.hrpostCode}"></c:out></td>
		</tr>
		<tr>
			<th>现住址</th>
			<td colspan="3">
				<c:out value="${birthDefectMonitor.paprovince }"></c:out>
				<c:out value="${birthDefectMonitor.pacity }"></c:out>
				<c:out value="${birthDefectMonitor.pacounty }"></c:out>
				<c:out value="${birthDefectMonitor.patownShip }"></c:out>
				<c:out value="${birthDefectMonitor.pastreet}"></c:out>
				<c:out value="${birthDefectMonitor.pahouseNumber }"></c:out>
			</td>
			<th>现住址邮政编码</th>
			<td><c:out value="${birthDefectMonitor.papostCode}"></c:out></td>
		</tr>
		<tr>
			<th>家族遗传性疾病史</th>
			<td colspan="5">
				<c:out value="${birthDefectMonitor.familyGeneDiseaseHistory}"></c:out>
			</td>
		</tr>
		<tr>
			<th>家族近亲婚配</th>
			<td <c:if test='${birthDefectMonitor.familyKinMarriageFlag ne "1"}'>  colspan="5" </c:if> >
                <c:if test="${!empty birthDefectMonitor.familyKinMarriageFlag}">
				    <c:if test='${birthDefectMonitor.familyKinMarriageFlag eq "1"}'>是</c:if>
                </c:if>
				<%--<c:if test='${birthDefectMonitor.familyKinMarriageFlag ne "1"}'>否</c:if>--%>
			</td>
			<c:if test='${birthDefectMonitor.familyKinMarriageFlag eq "1"}'>
				<th>家族近亲婚配者与本人关系</th>
				<td colspan="3">
					<ehr:dic dicmeta="CV0210001"  code="${birthDefectMonitor.familyKinMarriageRelation}"></ehr:dic>
				</td>
			</c:if>
		</tr>
	</table>
	</div>
</div>