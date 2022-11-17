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
	 require(['views/portal/fileManage/add'],function(fileAdd){
		 fileAdd.load();
	 });
</script>

<div class="toolbar">
    <a id="returnContact"><b class="fanhui">返回</b></a>
    <a id="saveContact"><b class="baocun">保存</b></a>
    <%--<a id="publishContact"><b class="baocun">发布</b></a>--%>
</div>
<form id="fileManagerForm">
	<input type="hidden" name="id" value="${fileManager.id}"/>
	<input type="hidden" name="times" value="${fileManager.times}"/>
	<%--<input type="hidden" name="status" value="${fileManager.status}"/>--%>
	<input type="hidden" name="createOrgCode" value="${fileManager.createOrgCode}"/>
	<input type="hidden" name="createUserCode" value="${fileManager.createUserCode}"/>
	<input type="hidden" name="createDate" value="<fmt:formatDate value='${fileManager.createDate}' pattern='yyyy/MM/dd'/>" />
	<input type="hidden" name="contents"/>
	<div class="postcontent">
		<i class="popno">文档管理</i>
		<div class="postdiv">
		<fieldset>
			<legend>基本信息</legend>
			<table class="posttable">
				<colgroup>
					<col style="width: 20%" />
					<col style="width: 80%" />
				</colgroup>
				<tr>
					<th align="right"><label class="required">文档类型：</label></th>
                    <td>
                    	<ehr:dic-radio name="fileType" dicmeta="LH00001" value="${fileManager.fileType == null ? '01' : fileManager.fileType}" reg='{"required":"true"}'/>
                    </td>
				</tr>
				<tr>
					<th align="right"><label class="required">标题：</label></th>
                    <td>
                        <input type="text" id="titleFileId" name="title" value="${fileManager.title}" reg='{"required":"true","maxlength":"100"}' style="width: 36%"/>
                    </td>
				</tr>
				<tr>
					<th align="right">关键字：</th>
                    <td>
                        <input type="text" id="keyword" name="keyword" value="${fileManager.keyword}" reg='{"maxlength":"100"}' style="width: 36%"/>
                    </td>
				</tr>
				<ehr:authorize ifAnyGranted="01,39">
					<tr>
						<th>审核状态：</th>
						<td nowrap="nowrap">
							<ehr:dic-radio name="status" id="statusId" dicmeta="LH00008" code="0,1" value="${fileManager.status == null ? '0' : fileManager.status}"></ehr:dic-radio>
						</td>
					</tr>
				</ehr:authorize>
			</table>
		</fieldset>
		<fieldset>
			<legend>描述</legend>
			<table class="posttable">
				<tr>
                    <td>
                    	<SCRIPT id=editor type=text/plain > ${fileManager.contents}</SCRIPT>
					</td>
				</tr>
			</table>
		</fieldset>
		<fieldset>
			<legend>附件</legend>
			<table class="posttable">
				<colgroup>
					<col style="width: 20%" />
					<col style="width: 20%" />
					<col style="width: 60%" />
				</colgroup>
				<tr>
					<td></td>
					<td colspan="2">
					<div style="width: 690px;">
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
                    <td><div id="fileMaMaterialFile"></div></td>
					<td>
						<span style="color: blue;">注：提供资料下载的照片样张、文档和软件时，单个附件请控制在10M之内(建议图片分辨率为800像素*600像素如果原图片超过2M，建议使用<a href="http://xiuxiu.meitu.com" target="blank"><strong>美图</strong></a>软件修改)，附件数量不能超过5个</span>
						<span id="activeTips" style="color: blue;"></span>
					</td>
				</tr>
			</table>
		</fieldset>
		</div>
	</div>
</form>