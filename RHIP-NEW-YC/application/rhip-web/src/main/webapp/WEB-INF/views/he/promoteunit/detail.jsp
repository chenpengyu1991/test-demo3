<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>

<script src="${pageContext.request.contextPath}/js/views/he/promoteunit/detail.js" type="text/javascript"></script>

<div class="postcontent">
		<div class="postdiv">
			<table class="posttable">
				<colgroup>
					<col style="width: 30%;"/>
					<col style="width: 70%;"/>
				</colgroup>
				<tr>
					<th>授予时间</th>
					<td>
						<fmt:formatDate value="${healthPromoteUnit.grantTime}" pattern="yyyy/MM/dd"/>
					</td>
				</tr>
				<tr>
					<th>单位名称</th>
					<td>
						${healthPromoteUnit.name}
					</td>
				</tr>
				<tr>
					<th>创建类别</th>
					<td>
						<c:if test="${healthPromoteUnit.type ne '99'}">
							<ehr:tip><ehr:dic dicmeta="HE00009" code="${healthPromoteUnit.type}"></ehr:dic></ehr:tip>
						</c:if>
						<c:if test="${healthPromoteUnit.type eq '99'}"><ehr:tip>${healthPromoteUnit.otherType}</ehr:tip></c:if>
					</td>
				</tr>
				<tr>
					<th>创建级别</th>
					<td>
						<c:if test="${healthPromoteUnit.unitLevel ne '99'}">
							<ehr:tip><ehr:dic dicmeta="HE00010" code="${healthPromoteUnit.unitLevel}"></ehr:dic></ehr:tip>
						</c:if>
						<c:if test="${healthPromoteUnit.unitLevel eq '99'}"><ehr:tip>${healthPromoteUnit.otherUnitLevel}</ehr:tip></c:if>
					</td>
				</tr>
			</table>
		</div>
</div>