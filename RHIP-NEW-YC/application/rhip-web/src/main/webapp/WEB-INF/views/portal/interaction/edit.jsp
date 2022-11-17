<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/ehr-tag" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>


<script src="${pageContext.request.contextPath}/js/ueditor/editor_config.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/ueditor/editor_all.js" type="text/javascript"></script>
<script type="text/javascript">
	 require(['views/portal/interaction/edit'],function(interactionEdit){
		 interactionEdit.load();
	 });
</script>
<form method="post" id="interaction_form">

<!-- 更新时用到 -->
<input type="hidden" name="id" value="${Interaction.id}"/>
<input type="hidden" name="status" value="${Interaction.status}"/>
<input type="hidden" value="${Interaction.operatorType}" name="operatorType" id="operatorType">
<input type="hidden" name="contents"/>

<!-- 互动信息 -->
<div class="postcontent">
	<div class="toolbar">
		<a id="backToSearch"><b class="fanhui">返回</b></a>
		<c:if test="${Interaction.operatorType !='1' }">
	        <a id="updateInteraction"><b class="baocun">保存</b></a>
        </c:if>
    </div>
		
	<div class="postdiv">
	<fieldset>
	<legend>详细信息</legend>
	<table style="width:99%" class="posttable">
        <colgroup >
            <col width="18%" />
            <col width="80%" />
        <colgroup>
		<tbody>
			<tr>
				<th><label>标题：</label></th>
				<td>
					${Interaction.title}
				</td>
			</tr>
			<tr>
				<th><label>内容：</label></th>
				<td>
					${Interaction.content}
				</td>
			</tr>
		</tbody>
	</table>
	</fieldset>
	</div>

     <!-- 处理情况 -->
	<div class="postdiv">
		<fieldset>
		<legend>处理情况</legend>
		<table style="width:99%" class="posttable">
			<tbody>
				<tr>
					<td>
						<c:if test="${Interaction.operatorType =='1' }"> 
								<table style="width:99%" class="posttable">
							        <colgroup >
							            <col width="18%" />
							            <col width="30%" />
										 <col width="18%" />
							            <col width="30%" />
							        <colgroup>
									<tbody>
										<tr>
											<th><label>回复内容：</label></th>
											<td colspan="3">
												${Interaction.replyContent}
											</td>
										</tr>
										<tr>
											<th><label>回复单位：</label></th>
											<td>
												<ehr:org code="${Interaction.unitCode}"></ehr:org>
											</td>
											<th><label>回复人：</label></th>
											<td>
												${Interaction.replyName}
											</td>
										</tr>
										<tr>
											<th><label>回复日期：</label></th>
											<td>
												<fmt:formatDate value='${Interaction.replyDate}' pattern='yyyy/MM/dd'/>
											</td>
											<th><label>处理状态：</label></th>
											<td>
												<ehr:tip><ehr:dic dicmeta="LH00003" code="${Interaction.status}"/></ehr:tip>
											</td>
										</tr>
									</tbody>
							</table>
							</c:if>
							<c:if test="${Interaction.operatorType =='2' }">
								<table style="width:99%" class="posttable">
									<colgroup >
										<col width="18%" />
										<col width="80%" />
									<colgroup>
										<tbody>
										<tr>
											<th><label>回复内容：</label></th>
											<td>
												<textarea rows="4" name="replyContent" id="replyContent" style="width: 100%" reg='{"required":"true"}'>${Interaction.replyContent}</textarea>
											</td>
										</tr>
										</tbody>
								</table>
							</c:if>
					</td>
                </tr>
			</tbody>
		</table>
		</fieldset>
	</div>
</div>
</form>

