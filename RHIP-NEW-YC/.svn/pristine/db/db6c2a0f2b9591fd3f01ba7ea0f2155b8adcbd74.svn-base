<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<script src="${pageContext.request.contextPath}/js/views/dmbc/vertor/mosquitoesMonitorAdd.js" type="text/javascript"></script>
<script>
    $(function(){
    	
    	 <c:if test="${msg == true}">
    	 	layer.alert("保存成功！", {icon:0,title:'提示'});
 	    </c:if>
 	    <c:if test="${msg == false}">
 	   		layer.alert("保存失败！", {icon:0,title:'提示'});
 		</c:if>
		//validate = $("#mouseMonitorForm").easyValidate();
        enableChangeConfirm();
    });
</script>
<div class="toolbar">
    <a href="javascript:void(0)" onclick="javascript:mosquitoesMonitorAdd.returnSearch()"><b class="fanhui">返回</b></a>
    <c:if test="${type == 'add'||type == 'edit'}">
            <a href="javascript:mosquitoesMonitorAdd.saveMosquitoesMonitor()"><b class="baocun">保存</b></a>
    </c:if>
</div>
<div class="postcontent" >
<form id="mosquitoesMonitorForm">
<input type="hidden" name="type" id="type" value="${type}" />
<input type="hidden" name="createBy" value="${createBy}" />
<input type="hidden" name="createTime" value="${createTime}" />
      		<fieldset>
				<legend>成蚊人工小时法(12小时)监测记录</legend>
				<input type="hidden" id="isDelete" name="isDelete" value="0">
				<input type="hidden" id="monitorId" name="id" value="${mosquitoesMonitor.id}">
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
							>监测时间</label>
						</th>
						<td>
							<c:if test="${type == 'view'}">
								<input type="text" name="monitorDate" value="<fmt:formatDate value='${mosquitoesMonitor.monitorDate}' pattern='yyyy/MM/dd' />" 
								readonly="readonly"/>
							</c:if>
							<c:if test="${type != 'view'}">
								<tag:dateInput nullToToday="true" name="monitorDate" date="${mosquitoesMonitor.monitorDate}"
								 pattern="yyyy/MM/dd"  onlypast="true"  reg="{'required':'true','tip':'请填写监测时间'}"></tag:dateInput>
							</c:if>
						</td>
						<th>
							<label 
							<c:if test="${type != 'view'}">
							class="required"  </c:if>
							>监测乡镇</label></th>
						</th>
						<td>
							<ehr:dic-town-village townId="townShip"
									townName="townShip"
									townValue="${mosquitoesMonitor.townShip}" width="150px;"
									reg="{'required':'true','tip':'请选择监测乡镇'}"/>
						</td>
						<th><label <c:if test="${type != 'view'}">
							class="required"  </c:if>>环境类型</label></th>
						<td>
							<ehr:dic-list name="environment" dicmeta="DMBC00012" width="150px;" value="${mosquitoesMonitor.environment}"
							reg="{'required':'true','tip':'请选择环境类型'}"/> 
						</td>
					</tr>
					<tr>
						<th><label<c:if test="${type != 'view'}">
							class="required"  </c:if> >气温</label></th>
						<td><input type="text" name="temp" id="temp" value="${mosquitoesMonitor.temp}" width="50px"
							reg="{'required':'true','maxlength':3,'digits':'true'}"
							<c:if test="${type == 'view'}">readonly="readonly"</c:if>
							/>
							<label >℃</label>
						</td>
						<th><label <c:if test="${type != 'view'}">
							class="required"  </c:if>>风力</label></th>
						<td>
							<input type="text" name="windScale" id="windScale" value="${mosquitoesMonitor.windScale}" 
							reg="{'required':'true','maxlength':3,'digits':'true'}"
								<c:if test="${type == 'view'}">readonly="readonly"</c:if>
							/><label >级</label>
						</td>
						<th><label class="required">天气</label></th>
						<td>
							<ehr:dic-list name="weather" dicmeta="DMBC00004" width="150px;" value="${mosquitoesMonitor.weather}"
							reg="{'required':'true'}"/> 
						</td>
					</tr>
					
				</table>
			</fieldset>
</form>
<br/>
<c:if test="${type == 'edit'}">
<div id="" class="toolbar">
				<a href="#this" onclick="javascript:mosquitoesMonitorAdd.initMosquitoesAdd()"><b
						class="xinz">新增</b></a>
				</div>
</c:if>
<div id="mosquitoesList">
	<jsp:include page="mosquitoesList.jsp"></jsp:include>
</div>
</div>