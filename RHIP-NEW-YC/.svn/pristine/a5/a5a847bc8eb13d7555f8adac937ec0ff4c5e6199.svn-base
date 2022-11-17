<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/views/ehrbrowser/basic/basic.css" />
<div  class="table-basic">
	<table>
		<tr>
			<th>新生儿姓名</th>
			<td><c:out value="${chBirthCertificate.neonatalName}"/></td>
			<th>新生儿性别</th>
			<td><ehr:dic code="${chBirthCertificate.neonatalGender}" dicmeta="GBT226112003"></ehr:dic></td>
			<th>出生孕周</th>
			<td><c:out value="${chBirthCertificate.gestationalWeek}"/>周</td>
		</tr>
		<tr>
			<th>出生日期时间</th>
			<td colspan="5"><fmt:formatDate value="${chBirthCertificate.neonatalBirthday}" pattern="yyyy年MM月dd日 HH时mm分"></fmt:formatDate></td>
		</tr>
		<tr>
			<th>健康状况</th>
			<td><ehr:dic code="${chBirthCertificate.neonatalHealth}" dicmeta="FS10024"></ehr:dic></td>
			<th>体重</th>
			<td><c:out value="${chBirthCertificate.birthWeight}"></c:out>克</td>
			<th>身长</th>
			<td><c:out value="${chBirthCertificate.birthStature}"></c:out>公分</td>
		</tr>
		<tr>
			<th>母亲姓名</th>
			<td><c:out value="${chBirthCertificate.motherName}"></c:out></td>
			<th>年龄</th>
			<td><c:out value="${chBirthCertificate.motherAge}"></c:out></td>
			<th>民族</th>
			<td><ehr:dic code="${chBirthCertificate.motherNation}" dicmeta="GBT3304"></ehr:dic></td>
		</tr>
		<tr>
			<th>身份证号码</th>
			<td colspan="5"><c:out value="${chBirthCertificate.motherIdcard}"></c:out></td>
		</tr>
		<tr>
			<th>父亲姓名</th>
			<td><c:out value="${chBirthCertificate.fatherName}"></c:out></td>
			<th>年龄</th>
			<td><c:out value="${chBirthCertificate.fatherAge}"></c:out></td>
			<th>民族</th>
			<td><ehr:dic code="${chBirthCertificate.fatherNation}" dicmeta="GBT3304"></ehr:dic></td>
		</tr>
		<tr>
			<th>身份证号码</th>
			<td colspan="5"><c:out value="${chBirthCertificate.faterIdcard}"></c:out></td>
		</tr>
		<tr>
			<th>出生地点分类</th>
			<td><ehr:dic code="${chBirthCertificate.birthPlaceType}" dicmeta="CV300001"></ehr:dic></td>
			<th>接生机构名称</th>
			<td colspan="3"><c:out value="${chBirthCertificate.midwiferyOrganName}"></c:out></td>
		</tr>
		<tr>
			<th>出生编号</th>
			<td><c:out value="${chBirthCertificate.birthCertificateNo}"></c:out></td>
			<th>签发日期</th>
			<td><fmt:formatDate value="${chBirthCertificate.issuedDate}" pattern="yyyy年MM月dd日"></fmt:formatDate></td>
			<th>签证机构</th>
			<td><c:out value="${chBirthCertificate.visaOrganName}"></c:out></td>
		</tr>
	</table>
</div>