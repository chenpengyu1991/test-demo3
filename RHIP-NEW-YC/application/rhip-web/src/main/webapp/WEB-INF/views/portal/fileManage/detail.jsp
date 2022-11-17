<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="ehr" uri="/ehr-tag" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<script type="text/javascript">
	 require(['views/portal/fileManage/detail'],function(fileView){
		 fileView.load();
	 });
</script>
<div class="toolbar">
    <a id="returnBtn"><b class="fanhui">返回</b></a>
</div>
<div class="postcontent">
	<div class="postdiv" id="organizationLinkInfo">
		<form method="post" name="organizationLinkForm">
			<fieldset>
				<legend>基本信息</legend>
				<table style="width: 100%;" class="posttable">
					<colgroup>
						<col width="15%" />
						<col width="45%" />
						<col width="40%" />
					<colgroup>
					<tr>
						<th><label>文档类型</label></th>
						<td>
						<ehr:tip><ehr:dic code="${fileManager.fileType}" dicmeta="LH00001"/></ehr:tip>
						</td>
					</tr>
					<tr>
						<th><label>标题：</label></th>
						<td>
						${fileManager.title}
						</td>
					</tr>
					<tr>
						<th><label>关键字：</label></th>
						<td>
						${fileManager.keyword}
						</td>
					</tr>
					<ehr:authorize ifAnyGranted="01,39">
						<tr>
							<th>审核状态：</th>
							<td>
							    <ehr:tip><ehr:dic dicmeta="LH00008" code="${fileManager.status}"/></ehr:tip>
							</td>
						</tr>
					</ehr:authorize>
				</table>
	        </fieldset>
	        <fieldset>
	        	<legend>描述：</legend>
	       	 	<table class="posttable">
					<tr>
	                    <td>
	                    	${fileManager.contents}
	                    </td>
					</tr>
				</table>
	        </fieldset>
	  		<fieldset>
	  			<legend>附件：</legend>
	       	 	<table class="posttable">
					<tr>
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
							</div>
						</c:forEach>
					</tr>
				</table>
	        </fieldset>
		</form>
	</div>
</div>



