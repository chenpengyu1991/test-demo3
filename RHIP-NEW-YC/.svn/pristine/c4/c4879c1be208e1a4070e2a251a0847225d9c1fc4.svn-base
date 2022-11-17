<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<script src="${pageContext.request.contextPath}/js/views/dmbc/vertor/roachMonitorAdd.js" type="text/javascript"></script>
<script>
    $(function(){
    	
    	 <c:if test="${msg == true}">
    	 	layer.alert("保存成功！", {icon:0,title:'提示'});
 	    </c:if>
 	    <c:if test="${msg == false}">
 	   		layer.alert("保存失败！", {icon:0,title:'提示'});
 		</c:if>
		//validate = $("#roachMonitorForm").easyValidate();
        enableChangeConfirm();
    });
</script>
<div class="toolbar">
    <a href="javascript:void(0)" onclick="javascript:roachMonitorAdd.returnSearch()"><b class="fanhui">返回</b></a>
    <c:if test="${type == 'add'||type == 'edit'}">
            <a href="javascript:roachMonitorAdd.saveRoachMonitor()"><b class="baocun">保存</b></a>
    </c:if>
</div>
<div class="postcontent" >
<form id="roachMonitorForm">
<input type="hidden" name="type" id="type" value="${type}" />
<input type="hidden" name="createBy" value="${createBy}" />
<input type="hidden" name="createTime" value="${createTime}" />
      		<fieldset>
				<legend>蟑螂监测记录</legend>
				<input type="hidden" id="isDelete" name="isDelete" value="0">
				<input type="hidden" id="monitorId" name="id" value="${roachMonitor.id}">
				<table class="posttable">
					<colgroup>
						<col style="width: 15%;min-width:100px;" />
						<col style="width: 15%;min-width:200px;" />
						<col style="width: 15%;min-width:100px;" />
						<col style="width: 15%;min-width:200px;" />
						<col style="width: 15%;min-width:100px;" />
						<col style="width: 15%;min-width:200px;" />
					</colgroup>
					<tr>
						<th><label 
							<c:if test="${type != 'view'}">
							class="required"  </c:if>
							>监测时间</label></th>
						<td>
							<c:if test="${type == 'view'}">
								<input type="text" name="monitorDate" value="<fmt:formatDate value='${roachMonitor.monitorDate}' pattern='yyyy/MM/dd' />" 
								readonly="readonly"/>
							</c:if>
							<c:if test="${type != 'view'}">
								<tag:dateInput nullToToday="true" name="monitorDate" date="${roachMonitor.monitorDate}"
								 pattern="yyyy/MM/dd"  onlypast="true"  reg="{'required':'true','tip':'请填写监测时间'}"></tag:dateInput>
							</c:if>
						<th>
							<label 
							<c:if test="${type != 'view'}">
							class="required"  </c:if>
							>监测乡镇</label></th>
						</th>
						<td>
							<ehr:dic-town-village townId="townShip"
									townName="townShip"
									townValue="${roachMonitor.townShip}" width="150px;"
									reg="{'required':'true','tip':'请选择监测乡镇'}"/>
						</td>
						<th>
							<label 
							<c:if test="${type != 'view'}">
							class="required"  </c:if>
							>环境类型</label>
						</th>
						<td>
							<ehr:dic-list name="environment" dicmeta="DMBC00007" value="${roachMonitor.environment}" width="150px;" reg="{'required':'true'}"/>
						</td>
					</tr>
					<tr>
						<th><label<c:if test="${type != 'view'}">
							class="required"  </c:if> >单位名称</label></th>
						<td><input type="text" name="orgName" id="orgName" value="${roachMonitor.orgName}" width="50px"
							reg="{'required':'true','maxlength':20}"
							<c:if test="${type == 'view'}">readonly="readonly"</c:if>
							/>
						</td>
						<th><label <c:if test="${type != 'view'}">
							class="required"  </c:if>>温度</label></th>
						<td>
							<input type="text" name="temp" id="temp" value="${roachMonitor.temp}" 
							reg="{'required':'true','maxlength':3,'digits':'true'}"
								<c:if test="${type == 'view'}">readonly="readonly"</c:if>
							/>
							<label >℃</label>
						</td>
						<th><label <c:if test="${type != 'view'}">
							class="required"  </c:if>>回收张数</label></th>
						<td>
							<input type="text" name="recycleCnt" id="recycleCnt" value="${roachMonitor.recycleCnt}" 
							reg="{'required':'true','maxlength':3,'digits':'true'}"
								<c:if test="${type == 'view'}">readonly="readonly"</c:if>
							/>   
						</td>
					</tr>
					<tr>
						<th><label <c:if test="${type != 'view'}">
							class="required"  </c:if>>阳性张数</label></th>
						<td>
							<input type="text" name="positiveCnt" id="positiveCnt" value="${roachMonitor.positiveCnt}"
							       reg="{'required':'true','maxlength':3,'digits':'true'}"
							       <c:if test="${type == 'view'}">readonly="readonly"</c:if>
									/>
						</td>
					</tr>
				</table>
			</fieldset>
</form>
<br/>
<c:if test="${type == 'edit'}">
<div id="" class="toolbar">
				<a href="#this" onclick="javascript:roachMonitorAdd.initRoachAdd()"><b
						class="xinz">新增</b></a>
				</div>
</c:if>
<div id="roachList">
	<jsp:include page="roachList.jsp"></jsp:include>
</div>
</div>