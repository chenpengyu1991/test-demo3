<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<div class="repeattable">
	<table class="layui-table x-admin-sm-table-list-middle">
		<colgroup>
            <col style="min-width:150px;width: 12%;"/>
            <col style="min-width:80px;width: 18%;"/>
            <col style="min-width:80px;width: 20%;"/>
            <col/>
            <col style="min-width:80px;width: 12%;"/>
            <col style="min-width:80px;width: 10%;"/>
		</colgroup>
		<thead>
			<tr>
				<th>姓名</th>
				<th>身份证号</th>
				<th>检验单标题</th>
				<th>检验机构</th>
				<th>检验日期</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="outpatientInfo" items="${outpatientInfoList}" varStatus="status">
				<tr>
					<td style="text-align: center"><ehr:tip>${outpatientInfo.name}</ehr:tip></td>
					<td style="text-align: center"><ehr:tip>${outpatientInfo.idcard}</ehr:tip></td>
					<td style="text-align: center"><ehr:tip>${outpatientInfo.checkListTitle}</ehr:tip></td>
					<td style="text-align: center"><ehr:tip>${outpatientInfo.hospitalName}</ehr:tip></td>
                    <td style="text-align: center"><fmt:formatDate value="${outpatientInfo.checkDate}" pattern="yyyy/MM/dd"></fmt:formatDate></td>
					<td style="text-align: center">
					    <a href="javascript:void(0)" onclick="emrSearch.examDetail('${outpatientInfo.ehrId}','${outpatientInfo.personId}','${outpatientInfo.examinationNumber}')">查看</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<table>
		<tr>
			<ehr:pagination action="emrSearch.emrSearch"/>
		</tr>
	</table>
</div>