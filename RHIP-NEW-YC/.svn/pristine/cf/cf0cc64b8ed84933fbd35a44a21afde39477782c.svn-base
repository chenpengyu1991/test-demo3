<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%--<script src="${pageContext.request.contextPath}/js/views/he/upload/upload.js" type="text/javascript"></script>--%>
<script src="${pageContext.request.contextPath}/js/views/he/healtheducationresource/mediaEdit.js" type="text/javascript"></script>

<div>
	<form id="healthEducationResourceMediaForm">
		<div class="postcontent">
			<input type="hidden" name="id" value="${media.id}">
			<table class="posttable">
				<colgroup>
					<col style="width: 15%;"/>
					<col style="width: 35%;"/>
					<col style="width: 15%;"/>
					<col style="width: 35%;"/>
				</colgroup>

				<tr>
					<th><label class="required">视频主题</label></th>
					<td>${media.theme}</td>
					<th><label class="required">开始播放日期</label></th>
					<td>
						<fmt:formatDate value="${media.playDate}" pattern="yyyy-MM-dd"/>
					</td>
				</tr>
				<tr>
					<th><label class="required">播放天数(天)</label></th>
					<td>${media.times}</td>
					<th><label class="required">每日播放时长(分钟)</label></th>
					<td>${media.period}</td>
				</tr>
				<tr>
					<th>提供播放影像的照片</th>
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
									<%--<a href="javascript:void(0);" onclick="healthEducationUpload.deleteFile('${attche.id}')">删除</a>--%>
								</div>
							</c:forEach>
						</div>
					</td>
				</tr>
			</table>
		</div>
	</form>
</div>