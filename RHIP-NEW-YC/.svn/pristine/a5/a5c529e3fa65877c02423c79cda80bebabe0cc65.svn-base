<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<jsp:include page="../layouts/load-js-css-resources.jsp"></jsp:include>


<script src="${pageContext.request.contextPath}/js/views/explorerSet/explorerSet2.js" type="text/javascript"></script>

<!-- <script type="text/javascript">
	require(['views/explorerSet/explorerSet'],function(explorerSet){
		explorerSet.init();
	});
</script> -->
<div class="section">
	<div class="toolbar">
        <!-- <a href="javascript:void(0)" id="btnExplorerSetSave"><b class="baocun">保存</b></a> -->
        <a href="javascript:void(0)" id="btnExplorerSetSave"><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe605;</i>保存</button></a>
    </div>  
	<div class="searchbox searchSection x-admin-sm" style="overflow-x: auto;">
		<form id="explorerSetForm">
			<c:forEach var="item" items="${doctorTypeItems}">
				<div style="margin-top: 10px;margin-right: 10px;margin-bottom: 20px;margin-left: 10px;">
					<fieldset style="margin-right:5px;padding:5px;" class="layui-elem-field">
						<legend>${item.itemName}<input type="checkbox" id="typeInputAll-${item.itemCode}" value="${item.itemCode}" alt="${item.itemName}"/></legend>
						<table style="min-width:150px">
							<colgroup>
								<c:forEach items="${setTypeItems}">
									<col style="width:16%;" />
								</c:forEach>
							</colgroup>
							<tr>
								<c:forEach var="setTypeItem" items="${setTypeItems}">
									<td><input type="checkbox" chkRef="typeInput-${item.itemCode}" name="typeInput-${item.itemCode}" <c:if test="${fn:contains(map[item.itemCode], setTypeItem.itemCode)}">checked="checked"</c:if> value="${setTypeItem.itemCode}">${setTypeItem.itemName}</td>
								</c:forEach>
							</tr>
						</table>
					</fieldset>
					</div>
			</c:forEach>
			
		</form>
	</div>
</div>