<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<script src="${pageContext.request.contextPath}/js/views/dmbc/medicalInst/disinfectionMonitorAdd.js" type="text/javascript"></script>
<script>
    $(function(){
    	
    	 <c:if test="${msg == true}">
    	 	layer.alert("保存成功！", {icon:0,title:'提示'});
 	    </c:if>
 	    <c:if test="${msg == false}">
 	   		layer.alert("保存失败！", {icon:0,title:'提示'});
 		</c:if>
		//validate = $("#disinfectionMonitorForm").easyValidate();
        enableChangeConfirm();
    });
</script>
<div class="toolbar">
    <a href="javascript:void(0)" onclick="javascript:disinfectionMonitorAdd.returnSearch()"><b class="fanhui">返回</b></a>
    <c:if test="${type == 'add'||type == 'edit'}">
            <a href="javascript:disinfectionMonitorAdd.saveDisinfectionMonitor()"><b class="baocun">保存</b></a>
    </c:if>
</div>
<div class="postcontent" >
<form id="disinfectionMonitorForm">
<input type="hidden" name="type" id="type" value="${type}" />
<input type="hidden" name="createBy" value="${disinfectionMonitor.createBy}" />
<tag:dateInput id="createTime" name="createTime" date="${disinfectionMonitor.createTime}" style="display:none"/>
      		<fieldset>
				<legend>消毒质量监测</legend>
				<input type="hidden" id="isDelete" name="isDelete" value="0">
				<input type="hidden" id="monitorId" name="id" value="${disinfectionMonitor.id}">
				<table class="posttable">
					<colgroup>
						<col style="width: 25%;min-width:80px;" />
						<col style="width: 25%;min-width:260px;" />
						<col style="width: 25%;min-width:100px;" />
						<col style="width: 25%;min-width:200px;" />
					</colgroup>
					<tr>
						<th><label 
							<c:if test="${type != 'view'}">
							class="required"  </c:if>
							>机构名称</label></th>
						<td>
							${currentOrg.organName}
							<input type="hidden" name="orgName" value="${currentOrg.organCode}"/>
						</td>
						<th><label 
							<c:if test="${type != 'view'}">
							class="required"  </c:if>
							>监测时间</label></th>
						<td>
							<c:if test="${type == 'view'}">
								<input type="text" name="monitorDate" value="<fmt:formatDate value='${disinfectionMonitor.monitorDate}' pattern='yyyy/MM/dd' />" 
								readonly="readonly"/>
							</c:if>
							<c:if test="${type != 'view'}">
								<tag:dateInput nullToToday="true" name="monitorDate" date="${disinfectionMonitor.monitorDate}"
								 pattern="yyyy/MM/dd"  onlypast="true"  reg="{'required':'true','tip':'请填写监测时间'}"></tag:dateInput>
							</c:if>
						</td>
					</tr>
					
				</table>
			</fieldset>
</form>
<br/>
<c:if test="${type == 'edit'}">
<div id="" class="toolbar">
				<a href="#this" onclick="javascript:disinfectionMonitorAdd.initDisinfectionRsAdd()"><b
						class="xinz">新增</b></a>
				</div>
</c:if>
<div id="disinfectionRsList">
	<jsp:include page="disinfectionRsList.jsp"></jsp:include>
</div>
</div>