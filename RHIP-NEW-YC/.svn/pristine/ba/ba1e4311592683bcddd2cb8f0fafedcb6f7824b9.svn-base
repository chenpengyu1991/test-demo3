<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>

<script src="${pageContext.request.contextPath}/js/views/he/record/edit.js" type="text/javascript"></script>

<div class="postcontent">
	<div class="postdiv">
		<table class="posttable">
			<colgroup>
				<col style="width: 15%;"/>
				<col style="width: 35%;"/>
				<col style="width: 15%;"/>
				<col style="width: 35%;"/>
			</colgroup>
			<c:if test="${type eq '1'}">
				<tr>
					<th>出刊时间</th>
					<td>
						<fmt:formatDate value="${healthEducationResourceRecord.useTime}" pattern="yyyy/MM/dd"/>
					</td>
					<th>阵地类型</th>
					<td style="vertical-align: top;">
						<ehr:tip><ehr:dic dicmeta="HE00008" code="${healthEducationResourceRecord.positionType}"></ehr:dic></ehr:tip>
					</td>
				</tr>
				<tr>
					<th>地点</th>
					<td>
							${healthEducationResourceRecord.place}
					</td>
					<th>版面数量</th>
					<td>${healthEducationResourceRecord.pageQuantity}</td>
				</tr>
				<tr>
					<th>宣传内容</th>
					<td colspan="3">
						<c:if test="${healthEducationResourceRecord.contentType eq '99'}"><ehr:tip>${healthEducationResourceRecord.otherContentType}</ehr:tip></c:if>
						<c:if test="${healthEducationResourceRecord.contentType ne '99'}"><ehr:tip> <ehr:dic dicmeta="HE00005" code="${healthEducationResourceRecord.contentType}" ></ehr:dic></ehr:tip></c:if>
					</td>
				</tr>
				<tr>
					<th>主要内容</th>
					<td colspan="3">${healthEducationResourceRecord.content}</td>
				</tr>
				<tr>
					<th>附件</th>
					<td colspan="3">
						<div style="width: 690px;">
							<c:forEach items="${attches}" var="attche" >
								<div style="width: 180px;float: left;margin-top: 5px;margin-left:5px;margin-right:10px;text-align: center;" id="${attche.id}-div">
									<c:if test="${attche.fileType eq 'image'}">
										<a target="blank" href="${pageContext.request.contextPath}/he/upload/showAsImage/${attche.id}?type=1"><img alt="点击查看大图" title="点击查看大图"
																																				   src="${pageContext.request.contextPath}/he/upload/showSmallImage/${attche.id}"
										/>${attche.originalFileName}</a>
									</c:if>
									<c:if test="${attche.fileType ne 'image'}">
										<a target="blank"  href="${pageContext.request.contextPath}/he/upload/download/${attche.id}" onclick="javascript:void(0)">${attche.originalFileName}</a>
									</c:if>
								</div>
							</c:forEach>
						</div>
					</td>
				</tr>
			</c:if>
			<c:if test="${type eq '2'}">
				<tr>
					<th>时间</th>
					<td>
						<fmt:formatDate value="${healthEducationResourceRecord.issueTime}" pattern="yyyy/MM/dd"/>
					</td>
					<th>
						宣传材料类型
					</th>
					<td>
						<c:if test="${healthEducationResourceRecord.materialType eq '99'}"><ehr:tip>${healthEducationResourceRecord.otherMaterialType}</ehr:tip></c:if>
						<c:if test="${healthEducationResourceRecord.materialType ne '99'}"><ehr:tip><ehr:dic dicmeta="HE00007" code="${healthEducationResourceRecord.materialType}"></ehr:dic></ehr:tip></c:if>
					</td>
				</tr>
				<tr>
					<th>材料名称</th>
					<td>${healthEducationResourceRecord.materialName}</td>
					<th>发放数量</th>
					<td style="vertical-align: top;">${healthEducationResourceRecord.issueQuantity}</td>
				</tr>
				<tr>
					<th>发放人</th>
					<td>${healthEducationResourceRecord.issuer}</td>
					<th>领取人</th>
					<td>${healthEducationResourceRecord.receiver}</td>
				</tr>
				<tr>
					<th>附件</th>
					<td colspan="3">
						<div style="width: 690px;">
							<c:forEach items="${attches}" var="attche" >
								<div style="width: 180px;float: left;margin-top: 5px;margin-left:5px;margin-right:10px;text-align: center;" id="${attche.id}-div">
									<c:if test="${attche.fileType eq 'image'}">
										<a target="blank" href="${pageContext.request.contextPath}/he/upload/showAsImage/${attche.id}?type=1"><img alt="点击查看大图" title="点击查看大图"
																																				   src="${pageContext.request.contextPath}/he/upload/showSmallImage/${attche.id}"
										/>${attche.originalFileName}</a>
									</c:if>
									<c:if test="${attche.fileType ne 'image'}">
										<a target="blank"  href="${pageContext.request.contextPath}/he/upload/download/${attche.id}" onclick="javascript:void(0)">${attche.originalFileName}</a>
									</c:if>
									<br />
								</div>
							</c:forEach>
						</div>
					</td>
				</tr>
			</c:if>
		</table>
	</div>
</div>