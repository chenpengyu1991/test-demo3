<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr" %>

<link href="${pageContext.request.contextPath}/js/fineuploader/fineuploader-3.4.1.css" rel="stylesheet"/>
<script src="${pageContext.request.contextPath}/js/fineuploader/jquery.fineuploader-3.4.1.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/he/upload/upload.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/ueditor/editor_config.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/ueditor/editor_all.js" type="text/javascript"></script>

<script type="text/javascript">
	require(['views/portal/serviceInfo/edit'],function(serviceInfo){
		serviceInfo.load();
	});
</script>

<form method="post" id="serviceInfoFrom">

	<input name="id" type="hidden" value="${serviceInfo.id}">
	<input id="role" name="role" type="hidden" value="${role}">
	<input type="hidden" value="${serviceInfo.operatorType}" name="operatorType" id="operatorType">
	<input type="hidden" value="${serviceInfo.detailType}" id="detailTypeValue">
	<input type="hidden" value="${serviceInfo.times}" name="times" id="times">
	<input type="hidden" value="${serviceInfo.isRollPicture }" id="isRollPicVal">
	<div class="postcontent">
		<div class="toolbar">
			<a href="javascript:void(0)" id="back-btn"><b class="fanhui">返回</b></a>
			<a href="javascript:void(0);" id="save-btn"><b class="baocun" >保存</b></a>
		</div>
		<div class="postdiv">
			<fieldset>
				<legend>服务信息</legend>
				<table style="width:99%" class="posttable" id="field">
					<colgroup>
						<col width="18%" />
						<col width="30%" />
						<col width="18%" />
						<col width="30%" />
					<colgroup>
						<tbody>
						<tr>
							<th class="required">标题：</th>
							<td colspan="3">
								<input id="edittitle" name="title" reg='{"maxlength":"100","required":"true"}' type="text" type="text" value="${serviceInfo.title }">
							</td>
						</tr>
						<tr>
							<th>来源：</th>
							<td colspan="3">
								<input name="source" id="editsource" reg='{"maxlength":"30"}'  type="text" value="${serviceInfo.source }">
							</td>
						</tr>
						<tr>
							<th class="required">类别：</th>
							<td>
								<select id="editinfoType" name="infoType" style="width:80px;" reg='{"required":"true"}'>
									<option value="">请选择类别</option>
									<c:forEach items="${infoTypeParentList}" var="infoType">
										<c:choose>
											<c:when test="${infoType.id == serviceInfo.infoType}">
												<option value="${infoType.id}" selected="selected">${infoType.name}</option>
											</c:when>
											<c:otherwise>
												<option value="${infoType.id}">${infoType.name}</option>
											</c:otherwise>
										</c:choose>
									</c:forEach>
								</select>
								<select id="editdetailType" name="detailType" style="width:80px;">
									<option value="">请选择子类别</option>
								</select>
							</td>
							<%-- <ehr:authorize ifAnyGranted="17,27">
							<c:if test="${reserveRegister.reserverStauts == '01'}">
								<a href="javascript:void(0)" onclick="reserveList.cancel('${reserveRegister.id}')">取消</a>
							</c:if>
							</ehr:authorize>
							 --%>
								<ehr:authorize ifAnyGranted="01,39">
									<th>审核状态：</th>
									<td nowrap="nowrap">
										<div id="statu">
											<ehr:dic-radio id="statusId" dicmeta="LH00008" name="status" code="0,1" value="${serviceInfo.status == null ? '0' : serviceInfo.status}"/>
										</div>
									</td>
								</ehr:authorize>
						</tr>
						<tr>
							<%-- <th>是否推荐：</th>
							<td nowrap="nowrap">
								<ehr:dic-radio id="editisRecommend" dicmeta="FS10186" name="isRecommend" code="0,1" value="${serviceInfo.isRecommend == null ? '0' : serviceInfo.isRecommend}"/>
							</td> --%>
							<th>是否为滚动信息：</th>
							<td nowrap="nowrap">
								<div id="roll">
									<ehr:dic-radio id="rollPictureId" dicmeta="FS10186" name="isRollPicture" code="0,1" value="${serviceInfo.isRollPicture == null ? '0' : serviceInfo.isRollPicture}"/>
								</div>
							</td>
							<th>作者：</th>
							<td>
								<input name="author" readonly id="editauthor" reg='{"maxlength":"30"}' type="text" value="${serviceInfo.author }">
							</td>
						</tr>
						<tr>
							<th>创建时间：</th>
							<td>
								<input type="text" readonly="readonly" name="creatTime" reg='{"required":"true"}'
									   value="<fmt:formatDate value='${serviceInfo.creatTime}' pattern='yyyy/MM/dd'/>" />
							</td>
						</tr>
						</tbody>
				</table>
			</fieldset>
		</div>
		<div class="postdiv">
			<fieldset>
				<legend>服务信息内容</legend>
				<table style="width: 99%" class="posttable">
					<tbody>
					<tr>
						<td>
							<c:choose>
								<c:when test="${serviceInfo.operatorType=='1'}">
									<div>${serviceInfo.contents}</div>
								</c:when>
								<c:otherwise>
									<SCRIPT id="editor" type=text/plain>${serviceInfo.contents} </SCRIPT>
								</c:otherwise>
							</c:choose>
						</td>
					</tr>
					</tbody>
				</table>
			</fieldset>
		</div>
		<div id="rollPictureDiv" class="postdiv">
			<fieldset>
				<legend>滚动图片信息</legend>
				<table class="posttable">
					<colgroup>
						<col style="width: 20%" />
						<col style="width: 20%" />
						<col style="width: 60%" />
					</colgroup>
					<tr>
						<td></td>
						<td colspan="2">
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
					<tr>
						<th align="right" class="required">图片描述：</th>
						<td colspan="2">
							<input id="rollPictureInfo" name="rollPictureInfo" reg='{"maxlength":"100","required":"true"}' type="text" value="${serviceInfo.rollPictureInfo }">
						</td>
					</tr>
					<tr id="rollPictr">
						<th align="right" class="required">图片：</th>
						<td><div id="serviceInfoMaMaterialFile"></div></td>
						<td>
							<span style="color: blue;">注：提供滚动样张照片，单张照片请控制在2M之内(建议图片分辨率为800像素*600像素如果原图片超过2M，建议使用<a href="http://xiuxiu.meitu.com" target="blank"><strong>美图</strong></a>软件修改)，图片数量只能为1个</span>
							<span id="activeTips" style="color: blue;"></span>
						</td>
					</tr>
				</table>
			</fieldset>
		</div>
	</div>
</form>
