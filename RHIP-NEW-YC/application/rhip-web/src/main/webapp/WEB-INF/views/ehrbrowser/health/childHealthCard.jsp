<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/views/ehrbrowser/basic/basic.css" />

<div style="background-color: white; height: 515px;">
	<ul>
		<li style="text-align: center; font-size: 25px;">儿童保健卡</li>
	</ul>
	<br />
	<div class="table-basic">
		<table class="layui-table x-admin-sm-table-list-small">
			<colgroup>
				<col style="width: 20%;" />
				<col style="width: 30%;" />
				<col style="width: 20%;" />
				<col style="width: 30%;" />
			</colgroup>
			<tr>
				<th>磁卡号</th>
				<td>${childHealthCard.mageCardNumber}</td>
				<th>医保卡号</th>
				<td>${childHealthCard.idcardHos}</td>
			</tr>
			<tr>
				<th>建卡日期</th>
				<td colspan="3"><fmt:formatDate value="${childHealthCard.buildCardDate}" pattern="yyyy/MM/dd"/></td>
			</tr>
			<tr>
				<th>姓名</th>
				<td>${childHealthCard.name}</td>
				<th>性别</th>
				<td><ehr:dic code="${childHealthCard.sexCode}" dicmeta="GBT226112003"></ehr:dic></td>
			</tr>
			<tr>
				<th>身份证件号码</th>
				<td>${childHealthCard.idcard}</td>
			</tr>
			<tr>
				<th>分娩孕周</th>
				<td colspan="3">${childHealthCard.gestationalWeeksWeek} （周） ${childHealthCard.gestationalWeeksDay} （天）</td>
			</tr>
			<tr>
				<th>出生日期</th>
				<td><fmt:formatDate value="${childHealthCard.birthday}" pattern="yyyy/MM/dd"/></td>
				<th>分娩方式</th>
				<td><ehr:dic code="${childHealthCard.deliveryWay}" dicmeta="CV0210003"></ehr:dic></td>
			</tr>
			<tr>
				<th>出生体重(g)</th>
				<td>${childHealthCard.birthWeight}</td>
				<th>出生身长(cm)</th>
				<td>${childHealthCard.birthStature}</td>
			</tr>
			<tr>
				<th>双多胎标志</th>
				<td>
                    <c:if test="${!empty childHealthCard.polyembryonySign}">
                        <c:out value='${childHealthCard.polyembryonySign eq "1" ? "是" : "否"}' />
                    </c:if>
                </td>
			</tr>
			<tr>
				<th>常住地址户籍标志</th>
				<td><ehr:dic code="${childHealthCard.domicileSign}" dicmeta="FS10003"></ehr:dic></td>
				<th>常住类型</th>
				<td><ehr:dic code="${childHealthCard.householdType}" dicmeta="FS10005"></ehr:dic></td>
			</tr>
			<tr>
				<th>常住类型</th>
				<td><ehr:dic code="${childHealthCard.householdTypeCode}" dicmeta="FS10007"></ehr:dic></td>
				<th>常住地址类别</th>
				<td><ehr:dic code="${childHealthCard.domicileCode}" dicmeta="FS10004"></ehr:dic></td>
			</tr> 
			<tr>
				<th>户籍地址</th>
				<td colspan="3">
					<c:out value="${childHealthCard.hrprovince}"></c:out>
					<c:out value="${childHealthCard.hrcity}"></c:out>
					<c:out value="${childHealthCard.hrcounty}"></c:out>
					<c:out value="${childHealthCard.hrtownShip}"></c:out>
					<c:out value="${childHealthCard.hrstreet}"></c:out>
					<c:out value="${childHealthCard.hrhouseNumber}"></c:out>
				</td>
			</tr>
			<tr>
				<th>户籍地址邮政编码</th>
				<td colspan="3">
					<c:out value="${childHealthCard.hrpostCode}"></c:out>
				</td>
			</tr>
			<tr>
				<th>居住住址</th>
				<td colspan="3">
					<c:out value="${childHealthCard.laprovince}"></c:out>
					<c:out value="${childHealthCard.lacity}"></c:out>
					<c:out value="${childHealthCard.lacounty}"></c:out>
					<c:out value="${childHealthCard.latownShip}"></c:out>
					<c:out value="${childHealthCard.lastreet}"></c:out>
					<c:out value="${childHealthCard.lahouseNumber}"></c:out>
				</td>
			</tr>
			<tr>
				<th>现住址邮政编码</th>
				<td colspan="3">
					<c:out value="${childHealthCard.lapostCode}"></c:out>
				</td>
			</tr>
			<tr>
				<th>母亲姓名</th>
				<td>${childHealthCard.motherName}</td>
				<th>母亲出生日期</th>
				<td><fmt:formatDate value="${childHealthCard.motherBirthday}" pattern="yyyy/MM/dd"/></td>
			</tr>
			<tr>
				<th>母亲民族</th>
				<td><ehr:dic code="${childHealthCard.motherNation}" dicmeta="GBT3304"></ehr:dic></td>
				<th>母亲工作单位名称</th>
				<td>${childHealthCard.motherUnitName}</td>
			</tr>
			<tr>
				<th>母亲身份证号码</th>
				<td colspan="3">${childHealthCard.motherIdcard}</td>
			</tr>
			<tr>
				<th>父亲姓名</th>
				<td>${childHealthCard.fatherName}</td>
				<th>父亲出生日期</th>
				<td><fmt:formatDate value="${childHealthCard.fatherBirthday}" pattern="yyyy/MM/dd"/></td>
			</tr>
			<tr>
				<th>父亲民族</th>
				<td><ehr:dic code="${childHealthCard.fatherNation}" dicmeta="GBT3304"></ehr:dic></td>
				<th>父亲工作单位名称</th>
				<td>${childHealthCard.fatherUnitName}</td>
			</tr>
			<tr>
				<th>父亲身份证号码</th>
				<td colspan="3">${childHealthCard.fatherIdcard}</td>
			</tr>
			<tr>
				<th>监护人姓名</th>
				<td>${childHealthCard.guardian}</td>
				<th>监护人年龄</th>
				<td>${childHealthCard.guardianAge}</td>
			</tr>
			<tr>
				<th>监护人民族</th>
				<td><ehr:dic code="${childHealthCard.guardianNation}" dicmeta="GBT3304"></ehr:dic></td>
				<th>联系电话</th>
				<td>${childHealthCard.phone}</td>
			</tr>
			<tr>
				<th>监护人工作单位名称</th>
				<td colspan="3">${childHealthCard.guardianUnitName}</td>
			</tr>
			<tr>
				<th>高危因素</th>
				<td colspan="3"><ehr:dic code="${childHealthCard.riskFactorsCode}" dicmeta="CV0300402"></ehr:dic></td>
				
			</tr>
			<tr>
				<th>是否参加母婴阳光工程</th>
				<td>
                    <c:if test="${!empty childHealthCard.sunshine}">
                        <c:out value='${childHealthCard.sunshine eq "1" ? "是" : "否"}' />
                    </c:if>
                </td>
				<th>是否开通母婴宝</th>
				<td>
                    <c:if test="${!empty childHealthCard.treasure}">
                        <c:out value='${childHealthCard.treasure eq "1" ? "是" : "否"}' />
                    </c:if>
                </td>
			</tr>
			<tr>
				<th>建档人员姓名</th>
				<td>${childHealthCard.inputName}</td>
				<th>建档日期</th>
				<td><fmt:formatDate value="${childHealthCard.inputDate}" pattern="yyyy/MM/dd"/></td>
			</tr>
			<tr>
				<th>建档机构名称</th>
				<td colspan="3">${childHealthCard.inputOrganName}</td>
			</tr>
		</table>
	</div>
</div>