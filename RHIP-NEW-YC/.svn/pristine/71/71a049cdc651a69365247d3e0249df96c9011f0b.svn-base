<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib  tagdir="/WEB-INF/tags" prefix="tag"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script src="${pageContext.request.contextPath}/js/fineuploader/jquery.fineuploader-3.4.1.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/ueditor/editor_config.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/ueditor/editor_all.js" type="text/javascript"></script>

<script type="text/javascript">
	 require(['views/portal/doctor/detail'],function(doctorDetail){
		 doctorDetail.load();
	 });
</script>

<div class="toolbar">
    <a id="returnBtn"><b class="fanhui">返回</b></a>
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
					<th align="right"><label>姓名：</label></th>
                    <td>
						${outDoctor.name}
                    </td>
					<th align="right"><label>医生编码(工号)：</label></th>
					<td>
						${outDoctor.doctorSn}
					</td>
				</tr>
				<tr>
					<th align="right">身份证号：</th>
					<td>
						${outDoctor.socialNo}
					</td>
					<th align="right"><label>所属机构：</label></th>
					<td>
						${hospitalName}	
					</td>
				</tr>
				<tr>
					<th align="right"><label>所属科室编码：</label></th>
					<td>
						${outDoctor.deptSn}
					</td>
					<th align="right"><label>所属科室名称：</label></th>
					<td>
						${outDoctor.deptName}
					</td>
				</tr>
				<tr>
					<th align="right">职称代码：</th>
					<td>
						${outDoctor.empTitCode}
					</td>
					<th align="right">职称：</th>
					<td>
						${outDoctor.empTitName}
					</td>
				</tr>
				<tr>
					<th>是否热门：</th>
					<td>
						<ehr:dic code="${outDoctor.isHot}" dicmeta="FS10186"/>
					</td>
					<ehr:authorize ifAnyGranted="01,39">
						<th>审核状态：</th>
						<td><ehr:dic code="${outDoctor.status}" dicmeta="LH00008"/></td>
					</ehr:authorize>
				</tr>
				<tr>
					<th>擅长诊治：</th>
					<td colspan="3">
						${outDoctor.specializes}
					</td>
				</tr>
				<tr>
					<th>工作经历：</th>
					<td colspan="3">
						${outDoctor.workExperience}
					</td>
				</tr>
				<tr id="doctorPictr">
				<tr>
					<th align="right">医生图片：</th>
					<td colspan="2">
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
					</td>
				</tr>

			</table>
		</fieldset>
		</div>
	</div>
</form>