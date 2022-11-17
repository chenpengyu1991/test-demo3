<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>

<link href="${pageContext.request.contextPath}/js/fineuploader/fineuploader-3.4.1.css" rel="stylesheet"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/fineuploader/jquery.fineuploader-3.4.1.js"></script>

<script src="${pageContext.request.contextPath}/js/views/he/upload/upload.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/he/supervisor/edit.js" type="text/javascript"></script>
<script type="text/javascript">
	$(document).ready(function() {
		healthEducationUpload.uploadFile("heSupervisorFile","/he/upload/uploadFile/jjdc","/he/upload/deleteFile/jjdc");
	});
</script>

<div class="toolbar">
	 <a href="javascript:void(0)" id="healthEducationSupervisorSaveButton"><b class="baocun">保存</b></a>
</div>
<div>
	<form id="healthEducationSupervisorForm">
		<div class="postcontent">
			<input type="hidden" name="id" value="${healthSupervisor.id}">
			
			<table class="posttable">
				<colgroup>
					<col style="width: 15%;"/>
					<col style="width: 35%;"/>
					<col style="width: 15%;"/>
					<col style="width: 35%;"/>
				</colgroup>
				<tr>
					<th><label class="required">督查时间</label></th>
					<td>
						<tag:dateInput reg='{"required":"true"}' name="overseeTime" id="overseeTime" date="${healthSupervisor.overseeTime}" onlypast="true"/>
					</td>
					<th><label class="required">参加人员</label></th>
					<td>
						<input name="participants" type="text"  reg='{"required":"true","maxlength":"20"}' value="${healthSupervisor.participants}"/>
					</td>
				</tr>
				<tr>
					<th><label class="required">督查对象</label></th>
					<td>
						<input name="overseePerson" type="text"  reg='{"required":"true","maxlength":"20"}' value="${healthSupervisor.overseePerson}"/>
					</td>
					<th></th>
					<td></td>
				</tr>
				<tr>
					<th><label>内容摘要</label></th>
					<td colspan="3"><textarea name="content" reg='{"maxlength":"600"}' style="height: 150px;width:600px;">${healthSupervisor.content}</textarea></td>
				</tr>
					<tr>
						<th></th>
						<td colspan="3">
							<div style="width: 690px;">
								<c:forEach items="${attches}" var="attche" >
									<div style="width: 150px;float: left;margin-top: 5px;text-align: center;" id="${attche.id}-div">
										<c:if test="${attche.imageFlag eq true}">
												<a target="blank" href="${pageContext.request.contextPath}/he/upload/showAsImage/${attche.id}?type=1"><img alt="点击查看大图" title="点击查看大图"
													src="${pageContext.request.contextPath}/he/upload/showAsImage/${attche.id}?type=2"
												/></a>
											</c:if>
											<c:if test="${attche.imageFlag eq false}">
												<a target="blank"  href="${pageContext.request.contextPath}/he/upload/download/${attche.id}" onclick="javascript:void(0)">${attche.fileName}</a>
											</c:if>
											<br />
											<a href="javascript:void(0);" onclick="healthEducationUpload.deleteFile('${attche.id}')">删除</a>
									</div>
								</c:forEach>
							</div>
						</td>
					</tr>
				<tr>
					<th><label class="required">附件</label></th>
					<td style="width: 120px;"><div id="heSupervisorFile"></div></td>
					<td colspan="2"><span style="color: blue;">注：提供督查照片、督查情况记录表等，单个附件请控制在2M之内(建议图片分辨率为800像素*600像素如果原图片超过2M，建议使用<a href="http://xiuxiu.meitu.com" target="blank"><strong>美图</strong></a>软件修改)，附件数量不能超过5个</span></td>
				</tr>
			</table>
		</div>
	</form>
</div>