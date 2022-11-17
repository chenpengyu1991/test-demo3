<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>


<div class="postcontent">
	<table class="posttable">
		<colgroup>
			<col style="width: 15%;"/>
			<col style="width: 35%;"/>
			<col style="width: 15%;"/>
			<col style="width: 35%;"/>
		</colgroup>
		<tbody>
		<c:if test="${type eq '1'}">
			<tr>
				<th>时间</th>
				<td><fmt:formatDate value="${healthEducationResource.resourceRecordTime}" pattern="yyyy/MM/dd"/></td>
				<th>器材名称</th>
				<td>
					<c:if test="${healthEducationResource.deviceName ne '99'}">
					<ehr:tip><ehr:dic dicmeta="HE00006" code="${healthEducationResource.deviceName}"></ehr:dic></ehr:tip>
					</c:if>
					<c:if test="${healthEducationResource.deviceName eq '99'}"><ehr:tip>${healthEducationResource.otherDeviceName}</ehr:tip></c:if>
			</tr>
			<tr>
				<th>数量</th>
				<td>${healthEducationResource.resourcelQuantity}</td>
				<th>规格型号</th>
				<td>${healthEducationResource.specification}</td>
			</tr>
			<tr>
				<th>价值</th>
				<td>${healthEducationResource.deviceCost}</td>
				<th>保管部门</th>
				<td>${healthEducationResource.custodyDept}</td>
			</tr>
			<tr>
				<th>备注</th>
				<td colspan="3">${healthEducationResource.resourceRemark}</td>
			</tr>
		</c:if>
		<c:if test="${type eq '2'}">
			<tr>
				<th>年度</th>
				<td>
					<fmt:formatDate value="${healthEducationResource.resourceRecordTime}" pattern="yyyy"/>
				</td>
				<th>宣传栏个数</th>
				<td>${healthEducationResource.galleryQuantity}</td>
			</tr>
			<tr>
				<th>黑板块数</th>
				<td>${healthEducationResource.blackboardQuantity}</td>
				<th>LED显示屏数</th>
				<td>${healthEducationResource.ledQuantity}</td>
			</tr>
			<tr>
				<th>阅报栏数</th>
				<td>${healthEducationResource.boardQuantity}</td>
                <th>资料架数</th>
                <td>${healthEducationResource.displayStandQuantity}</td>
            </tr>
			<tr>
				<th>备注</th>
				<td colspan="3">${healthEducationResource.resourceRemark}</td>
			</tr>
		</c:if>
		<c:if test="${type eq '3'}">
			<tr>
				<th>宣传材料类型</th>
				<td>
					<c:if test="${healthEducationResource.materialType ne '99'}">
						<ehr:tip><ehr:dic dicmeta="HE00007" code="${healthEducationResource.materialType}"></ehr:dic></ehr:tip>
					</c:if>
					<c:if test="${healthEducationResource.materialType eq '99'}"><ehr:tip>${healthEducationResource.otherMaterialName}</ehr:tip></c:if>
				</td>
				<th>时间</th>
				<td>
					<fmt:formatDate value="${healthEducationResource.resourceRecordTime}" pattern="yyyy/MM/dd"/>
				</td>
			</tr>
			<tr>
				<th>材料名称</th>
				<td>${healthEducationResource.materialName}</td>
				<th>材料数量</th>
				<td>${healthEducationResource.resourcelQuantity}</td>
			</tr>
				<tr>
				<th>附件</th>
				<td colspan="3">
					<div style="width: 960px;">
						<c:forEach items="${attches}" var="attche" >
							<div style="width: 180px;float: left;margin-top: 5px;margin-left:5px;margin-right:10px;text-align: center;" id="${attche.id}-div">
								<c:if test="${attche.imageFlag eq true}">
									<a target="blank" href="${pageContext.request.contextPath}/he/upload/showAsImage/${attche.id}"><img alt="点击查看大图" title="点击查看大图"
																																			   src="${pageContext.request.contextPath}/he/upload/showSmallImage/${attche.id}"
									/></a>
								</c:if>
								<c:if test="${attche.imageFlag eq false}">
									<a target="blank"  href="${pageContext.request.contextPath}/he/upload/download/${attche.id}" onclick="javascript:void(0)">${attche.originalFileName}</a>
								</c:if>
								<br />
							</div>
						</c:forEach>
					</div>
				</td>
			</tr>
		</c:if>
		</tbody>
	</table>
</div>