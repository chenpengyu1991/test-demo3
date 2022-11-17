<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>

<link href="${pageContext.request.contextPath}/js/fineuploader/fineuploader-3.4.1.css" rel="stylesheet"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/fineuploader/jquery.fineuploader-3.4.1.js"></script>
<script src="${pageContext.request.contextPath}/js/views/he/record/edit.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/he/upload/upload.js" type="text/javascript"></script>

<script type="text/javascript">
	$(document).ready(function() {
		healthEducationUpload.uploadFile("heRecordFile","/he/upload/uploadFile/jjdj","/he/upload/deleteFile/jjdj");
		//healthEducationUpload.viewAttchement(${healthEducationResourceRecord.id}, "healthEducationRecordAttchementDiv", ${healthEducationResourceRecord.orgCode}, "2"); // 2为健教记录
	});
</script>
<div class="toolbar">
	<!-- <a href="javascript:void(0)" id="healthEducationResourceRecordSaveButton" ><b class="baocun">保存</b></a> -->
	<a href="javascript:void(0)"
	   id="healthEducationResourceRecordSaveButton"><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe605;</i>保存</button></a>
</div>
<div class="divAbsolute55">
	<form id="healthEducationResourceRecordForm">
		<div class="postcontent">
			<input type="hidden" name="id" value="${healthEducationResourceRecord.id}">
			<input type="hidden" name="resourceType" value="${type}">

			<c:if test="${type eq '1'}">
				<table class="posttable">
					<colgroup>
						<col style="width: 15%;"/>
						<col style="width: 35%;"/>
						<col style="width: 15%;"/>
						<col style="width: 35%;"/>
					</colgroup>
					<tr>
						<th><label class="required">出刊时间</label></th>
						<td>
								<%-- <tag:dateInput reg='{"required":"true"}' name="useTime" id="useTime" date="${healthEducationResourceRecord.useTime}" /> --%>
							<input type="text" reg='{"required":"true"}'  class="layui-input x-admin-content-sm-date"  name="useTime" id="useTime" value="<fmt:formatDate value='${healthEducationResourceRecord.useTime}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;margin-bottom: 2px;" />
						</td>
						<th><label class="required">阵地类型</label></th>
						<td>
							<ehr:dic-list name="positionType" dicmeta="HE00008" width="99px" id="positionType" reg='{"required":"true"}' value="${healthEducationResourceRecord.positionType}"></ehr:dic-list>
						</td>
					</tr>
					<tr>
						<th><label class="required">宣传内容</label></th>
						<td>
							<ehr:dic-list name="contentType" dicmeta="HE00005" width="150px" id="contentType" type="true" reg='{"required":"true"}' value="${healthEducationResourceRecord.contentType}" onchange="healthEducationResourceRecordEdit.addOtherContentType()" cssClass="x-layui-input"></ehr:dic-list>
							<input type="text" style="width: 100px;" class="${fn:contains(healthEducationResourceRecord.contentType,'99') ?'':'hide'}"
								   reg='{"required":"true","maxlength":100}' name="otherContentType" id="otherContentType" value="${healthEducationResourceRecord.otherContentType}"/>
						</td>
						<th>版面数量</th>
						<td><input type="text" name="pageQuantity"  reg='{"digits":"true","max":"99999"}' value="${healthEducationResourceRecord.pageQuantity}"/></td>
					</tr>
					<tr>
						<th><label class="required">地点</label></th>
						<td colspan="3">
							<input type="text" name="place"  reg='{"required":"true","maxlength":"100"}' value="${healthEducationResourceRecord.place}"/>
						</td>
					</tr>
					<tr>
						<th>主要内容</th>
						<td colspan="3"><textarea name="content" reg='{"maxlength":"1600"}' style="height: 80px;width:590px;">${healthEducationResourceRecord.content}</textarea></td>
					</tr>
					<tr>
						<th></th>
						<td colspan="3">
							<div style="width: 690px;">
								<c:forEach items="${attches}" var="attche" >
									<div style="width: 180px;float: left;margin-top: 5px;margin-left:5px;margin-right:10px;text-align: center;" id="${attche.id}-div">
										<c:if test="${attche.fileType eq 'image'}">
											<a target="blank" href="${pageContext.request.contextPath}/he/upload/showAsImage/${attche.id}?type=1"><img alt="点击查看大图" title="点击查看大图"
																																					   src="${pageContext.request.contextPath}/he/upload/showSmallImage/${attche.id}"
											/></a>
										</c:if>
										<c:if test="${attche.fileType eq 'image'}">
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
						<th><label class="required">附件</label></th>
						<td colspan="3">
							<div id="healthEducationRecordAttchementDiv"></div>
							<table style="width: 100%">
								<tr>
									<td style="width: 120px;"><div id="heRecordFile"></div></td>
									<td ><span style="color: blue;">注：提供阵地更新后照片，单个附件请控制在2M之内(建议图片分辨率为800像素*600像素如果原图片超过2M，建议使用<a href="http://xiuxiu.meitu.com" target="blank"><strong>美图</strong></a>软件修改)，附件数量不能超过5个</span></td>
								</tr>
							</table>
						</td>
					</tr>
				</table>
			</c:if>
			<c:if test="${type eq '2'}">
				<table class="formtable">
					<colgroup>
						<col style="width: 15%;"/>
						<col style="width: 35%;"/>
						<col style="width: 15%;"/>
						<col style="width: 35%;"/>
					</colgroup>
					<tr>
						<th><label class="required">时间</label></th>
						<td>
								<%-- <tag:dateInput reg='{"required":"true"}' name="issueTime" id="issueTime" date="${healthEducationResourceRecord.issueTime}" onlypast="true" style="100px;"/> --%>
							<input type="text" reg='{"required":"true"}'  class="layui-input x-admin-content-sm-date"  name="issueTime" id="issueTime" value="<fmt:formatDate value='${healthEducationResourceRecord.issueTime}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;" />
						</td>
						<th>
							<label class="required">材料类型</label>
						</th>
						<td>
							<ehr:dic-list name="materialType" dicmeta="HE00007" width="80px" id="materialType" reg='{"required":"true"}' value="${healthEducationResourceRecord.materialType}" onchange="healthEducationResourceRecordEdit.addOtherMaterialType()"></ehr:dic-list>
							<input type="text" style="width:120px;" reg='{"required":"true"}' class="${healthEducationResourceRecord.materialType eq '99' ? '':'hide'}" name="otherMaterialType" id="otherMaterialType" value="${healthEducationResourceRecord.otherMaterialType}"/>
						</td>
					</tr>
					<tr>
						<th><label class="required">资料名称</label></th>
						<td><input type="text" name="materialName"  reg='{"required":"true","maxlength":"100"}' value="${healthEducationResourceRecord.materialName}"/></td>
						<th><label class="required">发放数量</label></th>
						<td><input type="text" name="issueQuantity"  reg='{"required":"true","digits":"true","max":"99999"}' value="${healthEducationResourceRecord.issueQuantity}"/></td>
					</tr>
					<tr>
						<th>发放人</th>
						<td><input type="text" name="issuer"  reg='{"maxlength":"20"}' value="${healthEducationResourceRecord.issuer}"/></td>
						<th>领取人</th>
						<td><input type="text" name="receiver"  reg='{"maxlength":"20"}' value="${healthEducationResourceRecord.receiver}"/></td>
					</tr>
					<tr>
						<th></th>
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
										<a href="javascript:void(0);" onclick="healthEducationUpload.deleteFile('${attche.id}')">删除</a>
									</div>
								</c:forEach>
							</div>
						</td>
					</tr>
					<tr>
						<th><label class="required">附件</label></th>
						<td colspan="3">
							<div id="healthEducationRecordAttchementDiv"></div>
							<table style="width: 100%">
								<tr>
									<td style="width: 120px;"><div id="heRecordFile"></div></td>
									<td colspan="2"><span style="color: blue;">注：提供资料的照片等，单个附件请控制在2M之内(建议图片分辨率为800像素*600像素如果原图片超过2M，建议使用<a href="http://xiuxiu.meitu.com" target="blank"><strong>美图</strong></a>软件修改)，附件数量不能超过5个</span></td>
								</tr>
							</table>
						</td>
					</tr>
				</table>
			</c:if>
		</div>
	</form>
</div>

<script type="text/javascript">
	layui.use('laydate', function(){
		var laydate = layui.laydate;

		laydate.render({
			elem: '#useTime'
			,format: 'yyyy/MM/dd'
			,max:0
			,done:function (value) {
				if(!$.isEmpty(value)){
					$("#useTime").removeClass("lose");
				}else{
					$("#useTime").addClass("lose");
				}
			}
		});

		laydate.render({
			elem: '#issueTime'
			,format: 'yyyy/MM/dd'
			,max:0
			,done:function (value) {
				if(!$.isEmpty(value)){
					$("#issueTime").removeClass("lose");
				}else{
					$("#issueTime").addClass("lose");
				}
			}
		});

	});
</script>