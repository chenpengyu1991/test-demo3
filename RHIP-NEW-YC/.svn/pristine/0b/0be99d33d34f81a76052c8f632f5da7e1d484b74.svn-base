<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<script src="${pageContext.request.contextPath}/js/views/dmbc/vertor/mouseMonitorAdd.js" type="text/javascript"></script>
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
    <a href="javascript:void(0)" onclick="javascript:mouseMonitorAdd.returnSearch()"><b class="fanhui">返回</b></a>
    <c:if test="${type == 'add'||type == 'edit'}">
            <a href="javascript:mouseMonitorAdd.saveMouseMonitor()"><b class="baocun">保存</b></a>
    </c:if>
</div>
<div class="postcontent" >
<form id="mouseMonitorForm">
<input type="hidden" name="type" id="type" value="${type}" />
<input type="hidden" name="createBy" value="${createBy}" />
<input type="hidden" name="createTime" value="${createTime}" />
      		<fieldset>
				<legend>鼠密度监测记录</legend>
				<input type="hidden" id="isDelete" name="isDelete" value="0">
				<input type="hidden" id="monitorId" name="id" value="${mouseMonitor.id}">
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
								<input type="text" name="monitorDate" value="<fmt:formatDate value='${mouseMonitor.monitorDate}' pattern='yyyy/MM/dd' />" 
								readonly="readonly"/>
							</c:if>
							<c:if test="${type != 'view'}">
								<tag:dateInput nullToToday="true" name="monitorDate" date="${mouseMonitor.monitorDate}"
								 pattern="yyyy/MM/dd"  onlypast="true"  reg="{'required':'true','tip':'请填写监测时间'}"></tag:dateInput>
							</c:if>
						</td>
						<th>
							<label 
							<c:if test="${type != 'view'}">
							class="required"  </c:if>
							>监测乡镇</label>
						</th>
						<td>
							<ehr:dic-town-village townId="townShip"
									townName="townShip"
									townValue="${mouseMonitor.townShip}" width="150px;"
									reg="{'required':'true','tip':'请选择监测乡镇'}"/>
						</td>
						<th><label <c:if test="${type != 'view'}">
							class="required"  </c:if>>布夹环境</label></th>
						<td>
							<ehr:dic-list name="environment" dicmeta="DMBC00001" width="150px;" value="${mouseMonitor.environment}"
							reg="{'required':'true','tip':'请选择布夹环境'}"/> 
						</td>
					</tr>
					<tr>
						<th><label<c:if test="${type != 'view'}">
							class="required"  </c:if> >气温</label></th>
						<td><input type="text" name="temp" id="temp" value="${mouseMonitor.temp}" width="50px"
							reg="{'required':'true','maxlength':3,'digits':'true'}"
							<c:if test="${type == 'view'}">readonly="readonly"</c:if>
							/>
							<label >℃</label>
						</td>
						<th><label <c:if test="${type != 'view'}">
							class="required"  </c:if>>布夹总数</label></th>
						<td>
							<input type="text" name="total" id="total" value="${mouseMonitor.total}" 
							reg="{'required':'true','maxlength':3,'digits':'true'}"
								<c:if test="${type == 'view'}">readonly="readonly"</c:if>
							/></td>
						<th><label <c:if test="${type != 'view'}">
							class="required"  </c:if>>回收总数</label></th>
						<td><input type="text" name="recoveryCount" id="recoveryCount" value="${mouseMonitor.recoveryCount}" 
						reg="{'required':'true','maxlength':3,'digits':'true'}"
							<c:if test="${type == 'view'}">readonly="readonly"</c:if>
							/></td>
					</tr>
					<tr>
						
					</tr>
					<tr>
						<th><label <c:if test="${type != 'view'}">
							class="required"  </c:if>>无效夹总数</label></th>
						<td>
							<input type="text" name="invalidCount" id="invalidCount" value="${mouseMonitor.invalidCount}" 
						reg="{'required':'true','maxlength':3,'digits':'true'}"
							<c:if test="${type == 'view'}">readonly="readonly"</c:if>
							/>
						</td>
						<th><label>室内布夹数</label></th>
						<td>
							<input type="text" name="indoorCount" id="indoorCount" value="${mouseMonitor.indoorCount}" 
							reg="{'maxlength':3,'digits':'true'}"
							<c:if test="${type == 'view'}">readonly="readonly"</c:if>
							/></td>
						<th><label >室外布夹数</label></th>
						<td>
							<input type="text" id="outdoorCount" name="outdoorCount" value="${mouseMonitor.outdoorCount}" 
								reg="{'maxlength':3,'digits':'true'}"
								<c:if test="${type == 'view'}">readonly="readonly"</c:if>
							/></td>
					</tr>
					<tr>
						<th><label >布夹地点</label></th>
						<td><input type="text" name="place" id="place" value="${mouseMonitor.place}" 
							reg="{'maxlength':20}"
							<c:if test="${type == 'view'}">readonly="readonly"</c:if>
							/></td>
						<th><label >鼠密度</label></th>
						<td><input type="text" name="density" id="density" value="${mouseMonitor.density}"
							reg="{'maxlength':2,'digits':'true'}" style="width: 50px"
							<c:if test="${type == 'view'}">readonly="readonly"</c:if> /> %
						</td>
					</tr>
				</table>
			</fieldset>
</form>
<br/>
<c:if test="${type == 'edit'}">
<div id="" class="toolbar">
				<a href="#this" onclick="javascript:mouseMonitorAdd.initMouseAdd()"><b
						class="xinz">新增</b></a>
				</div>
</c:if>
<div id="mouseList">
	<jsp:include page="mouseList.jsp"></jsp:include>
</div>
</div>