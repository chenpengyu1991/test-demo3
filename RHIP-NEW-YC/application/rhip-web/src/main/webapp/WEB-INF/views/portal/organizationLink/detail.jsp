<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="ehr" uri="/ehr-tag" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<script type="text/javascript">
	 require(['views/portal/organizationLink/detail'],function(detail){
		 detail.load();
	 });
</script>
<div class="toolbar">
    <a id="returnContact"><b class="fanhui">返回</b></a>
</div>
<div class="postcontent">
	<div class="postdiv" id="organizationLinkInfo">
		<form method="post" name="organizationLinkForm">
	<fieldset>
			<legend>机构链接信息</legend>
			<table style="width: 100%;" class="posttable">
				<colgroup>
					<col width="15%" />
					<col width="45%" />
					<col width="40%" />
				<colgroup>
				<tr>
					<th><label>序号</label></th>
					<td>
					${organizationLink.orderNum}
					</td>
				</tr>
				<tr>
					<th><label>机构名称：</label></th>
					<td>
					${organizationLink.orgName}
					</td>
				</tr>
				<tr>
					<th><label>网址：</label></th>
					<td>
					${organizationLink.url}
					</td>
				</tr>
				<ehr:authorize ifAnyGranted="01,39">
					<tr>
						<th>审核状态：</th>
						<td>
						    <ehr:tip><ehr:dic dicmeta="LH00008" code="${organizationLink.status}"/></ehr:tip>
						</td>
					</tr>
				</ehr:authorize>
				<tr>
				<th>附件：</th>
				<td colspan="3">
					<table>
						<tr>
							<c:forEach items="${attches}" var="attche" varStatus="status">
								<td style="padding: 15px;"><c:if test="${status.index % 4 == 0 && status.index != 0}">
										<tr>
										</tr>
										<td style="padding: 15px;">
									</c:if> 
									<c:if test="${attche.imageFlag eq true}">
										<a target="blank" href="${pageContext.request.contextPath}/he/upload/showAsImage/${attche.id}?type=1"><img alt="点击查看大图" title="点击查看大图"
											src="${pageContext.request.contextPath}/he/upload/showAsImage/${attche.id}?type=2"
										/></a>
									</c:if>
									<c:if test="${attche.imageFlag eq false}">
										<a target="blank"  href="${pageContext.request.contextPath}/he/upload/download/${attche.id}" onclick="javascript:void(0)">${attche.originalFileName}</a>
									</c:if>
									</td>
							</c:forEach>
						</tr>
					</table>
				</td>
			</tr>
			</table>
		</fieldset>
		</form>
	</div>
</div>



