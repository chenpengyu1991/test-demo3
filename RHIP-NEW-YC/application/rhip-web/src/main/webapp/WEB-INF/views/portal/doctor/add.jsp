<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib  tagdir="/WEB-INF/tags" prefix="tag"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<link href="${pageContext.request.contextPath}/js/fineuploader/fineuploader-3.4.1.css" rel="stylesheet"/>
<script src="${pageContext.request.contextPath}/js/fineuploader/jquery.fineuploader-3.4.1.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/he/upload/upload.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/ueditor/editor_config.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/ueditor/editor_all.js" type="text/javascript"></script>

<script type="text/javascript">
	 require(['views/portal/doctor/add'],function(doctorAdd){
		 doctorAdd.load();
	 });
</script>

<div class="toolbar">
    <a id="returnContact"><b class="fanhui">返回</b></a>
	<c:if test="${!ifSee}">
		<a id="saveContact"><b class="baocun">保存</b></a>
	</c:if>

</div>
<form id="outDoctorForm">
	<input type="hidden" name="id" value="${outDoctor.id}"/>
	<input type="hidden" name="isDelete"  value="${outDoctor.isDelete == null ? '0' : outDoctor.isDelete}"/>

	<div class="postcontent">
		<i class="popno">专家管理</i>
		<div class="postdiv">
		<fieldset>
			<legend>基本信息</legend>
			<table class="posttable">
				<colgroup>
					<col style="width: 15%" />
					<col style="width: 35%" />
					<col style="width: 15%" />
					<col style="width: 35%" />
				</colgroup>
				<tr>
					<th align="right"><label class="required">姓名：</label></th>
                    <td>
						<input type="text" id="name" name="name" value="${outDoctor.name}" reg='{"required":"true","maxlength":"30"}' style="width: 60%"/>
                    </td>
					<th align="right"><label class="required">医生编码(工号)：</label></th>
					<td>
						<input type="text" id="doctorSn" name="doctorSn" value="${outDoctor.doctorSn}" reg='{"required":"true","maxlength":"15"}' style="width: 60%"/>
					</td>
				</tr>
				<tr>
					<th align="right">身份证号：</th>
					<td>
						<input type="text" id="socialNo" name="socialNo" value="${outDoctor.socialNo}" reg='{"creditcard":"true"}' style="width: 60%"/>
					</td>
					<th align="right"><label class="required">所属机构：</label></th>
					<td>
						<select name="hospitalCode" reg='{"required":"true"}'>
							<option value="">请选择</option>
							<c:forEach items="${hospitalInfos}" var="hospitalInfo">
								<option value="${hospitalInfo.hospitalNo}" <c:if test="${hospitalInfo.hospitalNo == outDoctor.hospitalCode}">selected</c:if>>${hospitalInfo.hospitalName}</option>
							</c:forEach>
						</select>
					</td>
				</tr>
				<tr>
					<th align="right"><label class="required">所属科室编码：</label></th>
					<td>
						<input type="text" id="deptSn" name="deptSn" value="${outDoctor.deptSn}" reg='{"required":"true", "maxlength":"15"}' style="width: 60%"/>
					</td>
					<th align="right"><label class="required">所属科室名称：</label></th>
					<td>
						<input type="text" id="deptName" name="deptName" value="${outDoctor.deptName}" reg='{"required":"true", "maxlength":"70"}' style="width: 60%"/>
					</td>
				</tr>
				<tr>
					<th align="right">职称代码：</th>
					<td>
						<input type="text" id="empTitCode" name="empTitCode" value="${outDoctor.empTitCode}" reg='{"maxlength":"15"}' style="width: 60%"/>
					</td>
					<th align="right">职称：</th>
					<td>
						<input type="text" id="empTitName" name="empTitName" value="${outDoctor.empTitName}" reg='{"maxlength":"70"}' style="width: 60%"/>
					</td>
				</tr>
				<tr>
					<th>是否热门：</th>
					<td nowrap="nowrap">
						<ehr:dic-radio id="isHotId" dicmeta="FS10186" name="isHot" code="0,1" value="${outDoctor.isHot == null ? '0' : outDoctor.isHot}"/>
					</td>
					<ehr:authorize ifAnyGranted="01,39">
						<th>审核状态：</th>
						<td nowrap="nowrap">
							<ehr:dic-radio name="status" dicmeta="LH00008"  uninclude="2" value="${outDoctor.status == null ? '0' : outDoctor.status}"/>
						</td>
					</ehr:authorize>
				</tr>
				<tr>
					<th>擅长诊治：</th>
					<td colspan="3">
						<textarea name="specializes" rows="5">${outDoctor.specializes}</textarea>
					</td>
				</tr>
				<tr>
					<th>工作经历：</th>
					<td colspan="3">
						<textarea name="workExperience" rows="5">${outDoctor.workExperience}</textarea>
					</td>
				</tr>
				<tr id="doctorPictr">
				<tr>
					<th></th>
					<td colspan="2">
						<c:choose>
							<c:when test="${!ifSee}">
								<div id="editRollPic" style="width: 690px;">
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
							</c:when>
							<c:otherwise>
								<div id="seeRollPic" style="width: 690px;">
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
								</div>
							</c:otherwise>
						</c:choose>
					</td>
				</tr>
					<th align="right">医生图片：</th>
					<td><div id="doctorPictureFile"></div></td>
					<td colspan="2">
						<span style="color: blue;">注：提供医生单张照片，单张照片请控制在2M之内(建议图片分辨率为800像素*600像素如果原图片超过2M，建议使用<a href="http://xiuxiu.meitu.com" target="blank"><strong>美图</strong></a>软件修改)，图片数量只能为1个</span>
						<span id="activeTips" style="color: blue;"></span>
					</td>
				</tr>
			</table>
		</fieldset>
		</div>
	</div>
</form>