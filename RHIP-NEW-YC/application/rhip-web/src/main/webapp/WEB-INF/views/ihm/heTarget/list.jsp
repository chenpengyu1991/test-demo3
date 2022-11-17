<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>

<script src="${pageContext.request.contextPath}/js/views/ihm/heTarget/list.js" type="text/javascript"></script>


<div class="repeattable">
	<table>
		<thead>
			<tr>
				<th>机构</th>
				<th>发放健康教育印刷资料种类</th>
				<th>发放健康教育印刷资料数量</th>
				<th>播放音像数量数</th>
				<th>设置宣传栏数</th>
				<th>宣传栏更新次数</th>
				<th>开展公众健康咨询次数</th>
				<th>开展公众健康咨询参加人数</th>
				<th>举办健康知识讲座次数</th>
				<th>举办健康知识讲座参加人数</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="target" items="${targetList}">
				<tr>
					<td>
						<c:choose>
							<c:when test="${target.type eq 1}">
								<ehr:tip><ehr:dic code="${target.code}" dicmeta="FS990001"/></ehr:tip>
							</c:when>
							<c:otherwise>
								<ehr:org code="${target.code}"></ehr:org>
							</c:otherwise>
						</c:choose>
					</td>
					<c:forEach var="targetCode" items="${target.targetCodes}">
					<td>
						<input type="hidden" name="targetHidden" value="${target.code},${target.type},${targetCode}"/>
					</td>
					</c:forEach>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>