<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<link href="${pageContext.request.contextPath}/js/fineuploader/fineuploader-3.4.1.css" rel="stylesheet"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/fineuploader/jquery.fineuploader-3.4.1.js"></script>
<script src="${pageContext.request.contextPath}/js/views/he/upload/upload.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/he/healtheducationresource/mediaEdit.js" type="text/javascript"></script>
<script type="text/javascript">
    $(document).ready(function() {
        healthEducationUpload.uploadFile("heRecordFile","/he/upload/uploadFile/jjdj","/he/upload/deleteFile/jjdj");
    });
</script>
<div class="toolbar">
	<!-- <a href="javascript:void(0)"
       id="healthEducationResourceMediaSaveButton"
   ><b class="baocun">保存</b></a> -->
	<a href="javascript:void(0)"
	   id="healthEducationResourceMediaSaveButton"><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe605;</i>保存</button></a>
</div>
<div class="divAbsolute55">
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
					<td><input type="text" name="theme" reg='{"required":"true"}' value="${media.theme}"/></td>
					<th><label class="required">开始播放日期</label></th>
					<td>
						<c:if test="${empty media.id}">
							<%--<tag:dateInput reg='{"required":"true"}' name="playDates" id="playDate" date="${media.playDate}" pattern="yyyy-MM-dd" onlypast="false"/>--%>
							<input type="text" reg='{"required":true}' class="layui-input x-admin-content-sm-date" name="playDates" id="playDate" value="<fmt:formatDate value='${media.playDate}' pattern='yyyy-MM-dd'/>" style="padding-left: 0px;width: 177px;" />
						</c:if>
						<c:if test="${not empty media.id}">
							<fmt:formatDate value="${media.playDate}" pattern="yyyy-MM-dd"/>
							<tag:dateInput style="display: none" reg='{"required":"true"}' name="playDates" id="playDate" date="${media.playDate}" pattern="yyyy-MM-dd" onlypast="false"/>
                        </c:if>
					</td>
				</tr>
				<tr>
					<th><label class="required">播放天数(天)</label></th>
					<td><input type="text" name="times" reg='{"required":"true","digits":"true","max":"99999"}' value="${media.times}"/></td>
					<th><label class="required">每日播放时长(分钟)</label></th>
					<td><input type="text" name="period" reg='{"required":"true","digits":"true","max":"99999"}' value="${media.period}"/></td>
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
					<th><label class="required">提供播放影像的照片</label></th>
					<td colspan="3">
						<div id="healthEducationRecordAttchementDiv"></div>
						<table style="width: 100%">
							<tr>
								<td style="width: 120px;"><div id="heRecordFile"></div></td>
								<td ><span style="color: blue;">注：提供播放影像的照片，单个附件请控制在2M之内(建议图片分辨率为800像素*600像素如果原图片超过2M，建议使用<a href="http://xiuxiu.meitu.com" target="blank"><strong>美图</strong></a>软件修改)，附件数量不能超过5个</span></td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</div>
	</form>
</div>

<script type="text/javascript">
    layui.use('laydate', function(){
        var laydate = layui.laydate;

        laydate.render({
            elem: '#playDate'
            ,format: 'yyyy-MM-dd'
            ,max:0
            , trigger: 'click'
			,done:function(value) {
				if(!$.isEmpty(value)){
					$("#playDate").removeClass("lose");
				}else{
					$("#playDate").addClass("lose");
				}
			}
        });
    });


</script>