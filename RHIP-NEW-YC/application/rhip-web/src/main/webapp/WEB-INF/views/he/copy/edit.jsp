<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<link href="${pageContext.request.contextPath}/js/fineuploader/fineuploader-3.4.1.css" rel="stylesheet"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/fineuploader/jquery.fineuploader-3.4.1.js"></script>
<script src="${pageContext.request.contextPath}/js/views/he/copy/edit.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/he/upload/upload.js" type="text/javascript"></script>
<script type="text/javascript">
	$(document).ready(function()
	{
		healthEducationUpload.uploadFile("heCopyFile", "/he/upload/uploadFile/gjtg", "/he/upload/deleteFile/gjtg");
		
		layui.use('laydate', function(){
	        var laydate = layui.laydate;
			//年月日
			laydate.render({
			  elem: '#publishDate'
			  ,format: 'yyyy/MM/dd'
			  ,max:0 //今天之后不可选
			});
		});
	});
</script>
<div class="toolbar">
	 <a href="javascript:void(0);" id="heCopySaveButton"><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe605;</i>保存</button></a>
</div>
<form id="heCopyForm">
	<div class="postcontent">
		<input type="hidden" name="id" value="${heCopy.id}">
		<table class="posttable">
			<colgroup>
				<col style="width: 20%;"/>
				<col style="width: 30%;"/>
				<col style="width: 20%;"/>
				<col style="width: 30%;"/>
			</colgroup>
			<tr>
				<th><label class="required">刊（播）出文章题目</label></th>
				<td>
				 	<input type="text" reg='{"required":"true","maxlength":50}' name="title"value="${heCopy.title}"/>
				</td>
				<th><label class="required">刊（播）日期</label></th>
				<td>
					<input type="text" id="publishDate" name="publishDate" value="<fmt:formatDate value="${heCopy.publishDate}" pattern="yyyy/MM/dd"/>" reg='{"required":"true"}' onlypast="true"/>
				</td>
			</tr>
			<tr>
				<th><label class="required">发表新闻单位</label></th>
				<td>
					<ehr:dic-list name="publishOrgan" dicmeta="HE00012" reg='{"required":"true"}' value="${heCopy.publishOrgan}"></ehr:dic-list>
				</td>
				<th><label class="required">版面</label></th>
				<td><input name="edition" type="text" reg='{"required":"true","maxlength":"50"}' value="${heCopy.edition}"/></td>
			</tr>
			<tr>
				<th><label class="required">类型</label></th>
				<td>
					<ehr:dic-list name="type" dicmeta="HE00013" reg='{"required":"true"}' value="${heCopy.type}"></ehr:dic-list>
				</td>
				<th><label class="required">作者</label></th>
				<td><input name="author" type="text" reg='{"required":"true","maxlength":"20"}' value="${heCopy.author}"/></td>
			</tr>
			<tr>
				<th><label class="required">级别</label></th>
				<td>
					<ehr:dic-list name="pLevel" dicmeta="HE00014" reg='{"required":"true"}' value="${heCopy.pLevel}"></ehr:dic-list>
				</td>
				<th><label class="required">媒体分类</label></th>
				<td>
					<ehr:dic-list name="media" dicmeta="HE00015" reg='{"required":"true"}' value="${heCopy.media}"></ehr:dic-list>
				</td>
			</tr>
			<tr>
				<th><label class="required">信息类别</label></th>
				<td>
					<ehr:dic-list name="category" dicmeta="HE00016" reg='{"required":"true"}' value="${heCopy.category}"></ehr:dic-list>
				</td>
				<th><label>字数</label></th>
				<td><input name="words" type="text" reg='{"digits":"true","max":99999999}' value="${heCopy.words}"/></td>
			</tr>
			<tr>
				<th></th>
				<td colspan="3">
					<div style="width: 690px;">
						<c:forEach var="attche" items="${attches}">
							<div style="width: 150px;float: left;margin-top: 5px;text-align: center;" id="${attche.id}-div">
								<c:if test="${attche.imageFlag eq true}">
									<a target="blank" href="${pageContext.request.contextPath}/he/upload/showAsImage/${attche.id}?type=1">
										<img alt="点击查看大图" title="点击查看大图" src="${pageContext.request.contextPath}/he/upload/showAsImage/${attche.id}?type=2"/></a>
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
			<tr style="padding-top: 10px;">
				<th><label class="required">附件</label></th>
				<td style="width: 120px;"><div id="heCopyFile"></div></td>
				<td colspan="2"><span style="color: blue;">注：单个附件请控制在2M之内(建议图片分辨率为800像素*600像素如果原图片超过2M，建议使用<a href="http://xiuxiu.meitu.com" target="blank"><strong>美图</strong></a>软件修改),附件数量不能超过5个</span>
				</td>
			</tr>
		</table>
	</div>
</form>
