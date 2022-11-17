<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="ehr" uri="/ehr-tag" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>

<link href="${pageContext.request.contextPath}/js/fineuploader/fineuploader-3.4.1.css" rel="stylesheet"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/fineuploader/jquery.fineuploader-3.4.1.js"></script>
<script src="${pageContext.request.contextPath}/js/views/he/upload/upload.js" type="text/javascript"></script>

<script type="text/javascript">
	 require(['views/portal/organizationLink/add'],function(addSearch){
		 addSearch.load();
	 });
</script>
<div class="toolbar">
    <a id="returnContact"><b class="fanhui">返回</b></a>
    <a id="saveContact"><b class="baocun">保存</b></a>
</div>
<div class="postcontent">
	<div class="postdiv" id="organizationLinkInfo">
		<form method="post" name="organizationLinkFormId" id="organizationLinkFormId">
			<input type="hidden" id="id" name="id" value="${organizationLink.id}"/>
			<fieldset>
					<legend>机构链接信息</legend>
					<table style="width: 100%;" class="posttable">
						<colgroup>
							<col width="15%" />
							<col width="45%" />
							<col width="40%" />
						<colgroup>
						<tr>
							<th><label class="required">序号</label></th>
							<td>
								<tag:numberInput id="orderNum" name="orderNum" value="${organizationLink.orderNum}" cssClass="width30" reg='{"required":"true"}'/>
							</td>
						</tr>
						<tr>
							<th><label class="required">机构名称：</label></th>
							<td>
								<input type="text" id="orgName" name="orgName" value="${organizationLink.orgName}" reg='{"required":"true","maxlength":"100"}' style="width: 100%"/>
							</td>
						</tr>
						<tr>
							<th><label class="required">网址：</label></th>
							<td>
								<input type="text" id="url" name="url" value="${organizationLink.url}" reg='{"required":"true","maxlength":"100"}' style="width: 100%"/>
							</td>
						</tr>
						<ehr:authorize ifAnyGranted="01,39">
							<tr>
								<th>审核状态：</th>
								<td nowrap="nowrap">
									<ehr:dic-radio name="status" dicmeta="LH00008" id="statusId" code="0,1" value="${organizationLink.status == null ? '0' : organizationLink.status}"/>
								</td>
							</tr>
						</ehr:authorize>
						<tr>
							<th></th>
							<td colspan="3">
								<div style="width: 960px;">
									<c:forEach items="${attches}" var="attche" >
										<div style="width: 150px;float: left;margin-top: 5px;text-align: center;" id="${attche.id}-div">
											<c:if test="${attche.imageFlag eq true}">
													<a target="blank" href="${pageContext.request.contextPath}/he/upload/showAsImage/${attche.id}?type=1"><img alt="点击查看大图" title="点击查看大图"
														src="${pageContext.request.contextPath}/he/upload/showAsImage/${attche.id}?type=2"
													/></a>
												</c:if>
												<c:if test="${attche.imageFlag eq false}">
													<a target="blank"  href="${pageContext.request.contextPath}/he/upload/download/${attche.id}" onclick="javascript:void(0)">${attche.originalFileName}</a>
												</c:if>
												<br />
												<a href="javascript:void(0);" onclick="healthEducationUpload.deleteFile('${attche.id}')">删除</a>
										</div>
									</c:forEach>
								</div>
							</td>
						</tr>
						<tr>
							<th align="right">附件：</th>
							<td><div id="linkMaMaterialFile"></div></td>
							<td>
								<span style="color: blue;">注：提供机构样张照片，单张照片请控制在2M之内(建议图片分辨率为800像素*600像素如果原图片超过2M，建议使用<a href="http://xiuxiu.meitu.com" target="blank"><strong>美图</strong></a>软件修改)，图片数量不能超过1个</span>
								<span id="activeTips" style="color: blue;"></span>
							</td>
						</tr>
					</table>
				</fieldset>
		</form>
	</div>
</div>



