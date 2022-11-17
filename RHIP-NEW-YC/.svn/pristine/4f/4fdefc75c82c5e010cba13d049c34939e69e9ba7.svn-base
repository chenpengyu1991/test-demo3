<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<script>
    $(function(){
        <c:if test="${msg == true}">
        	contentChanged = false;
    		layer.alert("保存成功！", {icon:0,title:'提示'});
	    </c:if>
	    <c:if test="${msg == false}">
			layer.alert("保存失败！",{icon:0,title:'提示'});
		</c:if>
		<c:if test='${companyOptType != "view"}'>
			occPatientAdd.initAutoSel();
		</c:if>
        enableChangeConfirm();
    });
    

</script>
<input type="hidden" id="companyOptType" value="${companyOptType}">
<div class="toolbar">
	<a href="javascript:void(0)" onclick="javascript:occPatientAdd.returnSearch()"><button class="btn-gray layui-btn layui-btn-sm button"><i class="layui-icon">&#xe65c;</i>返回</button></a>
	<c:if test="${companyOptType == 'add'||companyOptType == 'edit'}">
		<a href="javascript:occPatientAdd.saveCompanyInfo()" ><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe605;</i>保存</button></a>
	</c:if>
</div>
<div class="postcontent" >
<form id="companyInfoForm">
      		<fieldset  class="layui-elem-field">
				<legend>用人单位信息</legend>
				<input type="hidden" id="isDelete" name="isDelete" value="0">
				<input type="hidden" name="id" value="${companyInfo.id}">
				<input type="hidden" name="employeeId" value="${companyInfo.employeeId}">
				<table class="posttable">
					<colgroup>
						<col style="width: 15%;min-width:100px;" />
						<col style="width: 35%;min-width:200px;" />
						<col style="width: 15%;min-width:100px;" />
						<col style="width: 35%;min-width:200px;" />
					</colgroup>
					<tr>
						<th><label 
							<c:if test="${companyOptType != 'view'}">
							class="required"  </c:if>
							>用人单位名称</label></th>
						<td>
							<c:if test="${companyOptType == 'view'}">
								<input type="text" name="companyName" value="${companyInfo.companyName}" 
								readonly="readonly"/>
							</c:if>
							<c:if test="${companyOptType != 'view'}">
								<tag:autoSelect name="companyName" id="companyName" nameValue="${companyInfo.companyName}" codeValue="${companyInfo.companyName}"
								 reg="{'required':'true','maxlength':'50','tip':'请填写单位名称'}"></tag:autoSelect>
							</c:if>
						<th></th>
						<td></td>
					</tr>
					<tr>
						<th><label >组织机构代码</label></th>
						<td>
							<input type="text" class="x-layui-input" name="orgCode" id="orgCode" value="${companyInfo.orgCode}"
								reg="{'maxlength':'18'}"
								<c:if test="${companyOptType == 'view'}">readonly="readonly"</c:if>
							/></td>
						<th><label >通讯地址</label></th>
						<td><input type="text" class="x-layui-input" name="addr" id="addr" value="${companyInfo.addr}"
							reg="{'maxlength':50}"
							<c:if test="${companyOptType == 'view'}">readonly="readonly"</c:if>
							/></td>
					</tr>
					<tr>
						<th><label >经济类型</label></th>
						<td>
							<input type="text" class="x-layui-input" name="economicType" id="economicType" value="${companyInfo.economicType}"
							reg="{'maxlength':20}"
								<c:if test="${companyOptType == 'view'}">readonly="readonly"</c:if>
							/></td>
						<th><label >行业</label></th>
						<td><input type="text" class="x-layui-input" name="industryType" id="industryType" value="${companyInfo.industryType}"
						reg="{'maxlength':20}"
							<c:if test="${companyOptType == 'view'}">readonly="readonly"</c:if>
							/></td>
					</tr>
					<tr>
						<th><label >企业规模</label></th>
						<td>
							<ehr:dic-list name="enterpriseScale" id="enterpriseScale"  dicmeta="OH00002" value="${companyInfo.enterpriseScale}" />
						</td>
						<th></th>
						<td></td>
					</tr>
					<tr>
						<th><label>法定代表人</label></th>
						<td>
							<input type="text" class="x-layui-input" name="legalRepr" id="legalRepr" value="${companyInfo.legalRepr}"
							reg="{'maxlength':20}"
							<c:if test="${companyOptType == 'view'}">readonly="readonly"</c:if>
							/></td>
						<th><label></label></th>
						<td></td>
					</tr>
					<tr>
						<th><label >联系人</label></th>
						<td>
							<input type="text" class="x-layui-input" id="contactsName" name="contactsName" value="${companyInfo.contactsName}"
								reg="{'maxlength':20}"
								<c:if test="${companyOptType == 'view'}">readonly="readonly"</c:if>
							/></td>
						<th><label >联系电话</label></th>
						<td><input type="text" class="x-layui-input" name="phone" id="phone" value="${companyInfo.phone}"
							reg="{'maxlength':20,'regex':'phone'}"
							<c:if test="${companyOptType == 'view'}">readonly="readonly"</c:if>
							/></td>
					</tr>
				</table>
			</fieldset>
</form>
</div>