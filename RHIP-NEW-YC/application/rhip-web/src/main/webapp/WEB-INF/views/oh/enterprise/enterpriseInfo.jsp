<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>

<script>
    $(function(){
        enableChangeConfirm();
		var layer = layui.layer;
        <c:if test="${msg == true}">
			layer.alert("保存成功！", {icon:0,title:'提示'});
        </c:if>
        <c:if test="${msg == false}">
			layer.alert("保存成功！", {icon:0,title:'提示'});
    	</c:if>
    })
</script>

<div class="toolbar">
	<a href="javascript:void(0)" onclick="javascript:enterpriseAdd.returnSearch()"><button class="btn-gray layui-btn layui-btn-sm button"><i class="layui-icon">&#xe65c;</i>返回</button></a>
	<a href="javascript:enterpriseAdd.saveEnterpriseInfo()" ><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe605;</i>保存</button></a>
</div>
<div class="postcontent" >
<form id="enterpriseInfoForm">
      		<fieldset class="layui-elem-field">
				<legend>基本信息</legend>
				<input type="hidden" id="msg" name="msg" value="${enterpriseInfo.id}">
				<input type="hidden" id="isDelete" name="isDelete" value="0">
				<input type="hidden" id="enterpriseId" name="id" value="${enterpriseInfo.id}">
				<input type="hidden" id="type" value="${type}">
				<table class="posttable">
					<colgroup>
						<col style="width: 15%;min-width:100px;" />
						<col style="width: 35%;min-width:200px;" />
						<col style="width: 15%;min-width:100px;" />
						<col style="width: 35%;min-width:200px;" />
					</colgroup>
					<tr>
						<th><label <c:if test="${type != 'view'}">class="required" </c:if> >档案号</label></th>
						<td>
							<input class="x-layui-input" type="text" id="fileNo" name="fileNo" value="${enterpriseInfo.fileNo}" reg="{'required':true,'maxlength':20}"
							<c:if test="${type == 'view'}">readonly="readonly"</c:if>
							/>
						<th><label <c:if test="${type != 'view'}">class="required"</c:if> >企业名称</label></th>
						<td><input class="x-layui-input" type="text" id="companyName" name="companyName" value="${enterpriseInfo.companyName}" reg="{'required':true,'maxlength':50}"
							<c:if test="${type == 'view'}">readonly="readonly"</c:if>
							/></td>
					</tr>
					<tr>
						<th><label >组织机构代码</label></th>
						<td>
							<input class="x-layui-input" type="text" id="orgCode" name="orgCode" value="${enterpriseInfo.orgCode}"
								reg="{'maxlength':18}" 
								<c:if test="${type == 'view'}">readonly="readonly"</c:if>
							/></td>
						<th><label >地址</label></th>
						<td><input class="x-layui-input" type="text" id="addr" name="addr" value="${enterpriseInfo.addr}"
							reg="{'maxlength':50}" 
							<c:if test="${type == 'view'}">readonly="readonly"</c:if>
							/></td>
					</tr>
					<tr>
						<th><label >邮编</label></th>
						<td>
							<input class="x-layui-input" type="text" id="postcode" name="postcode" value="${enterpriseInfo.postcode}"
								reg="{'maxlength':50,'regex':'postCode'}" 
								<c:if test="${type == 'view'}">readonly="readonly"</c:if>
							/></td>
						<th><label >经济类型</label></th>
						<td><input class="x-layui-input" type="text" id="economicType" name="economicType" value="${enterpriseInfo.economicType}"
							reg="{'maxlength':20}" 
							<c:if test="${type == 'view'}">readonly="readonly"</c:if>
							/></td>
					</tr>
					<tr>
						<th><label >行业分类</label></th>
						<td>
							<input class="x-layui-input" type="text" id="industryType" name="industryType" value="${enterpriseInfo.industryType}"
							reg="{'maxlength':20}" 
							<c:if test="${type == 'view'}">readonly="readonly"</c:if>
							/></td>
						<th><label>法人代表</label></th>
						<td>
							<input class="x-layui-input" type="text" id="legalRepr" name="legalRepr" value="${enterpriseInfo.legalRepr}"
							reg="{'maxlength':20}" 
							<c:if test="${type == 'view'}">readonly="readonly"</c:if>
							/></td>
					</tr>
					<tr>
						<th><label>联系部门</label></th>
						<td><input class="x-layui-input" type="text" id="contactsDept" name="contactsDept" value="${enterpriseInfo.contactsDept}"
							reg="{'maxlength':20}" 
							<c:if test="${type == 'view'}">readonly="readonly"</c:if>
							/></td>
						<th><label >联系人</label></th>
						<td>
							<input class="x-layui-input" type="text" id="contactsName" name="contactsName" value="${enterpriseInfo.contactsName}"
								reg="{'maxlength':20}" 
								<c:if test="${type == 'view'}">readonly="readonly"</c:if>
							/></td>
					</tr>
					<tr>
						<th><label >职务</label></th>
						<td><input class="x-layui-input" type="text" id="position" name="position" value="${enterpriseInfo.position}"
							reg="{'maxlength':20}" 
							<c:if test="${type == 'view'}">readonly="readonly"</c:if>
							/></td>
						<th><label >固定电话</label></th>
						<td>
							<input class="x-layui-input" type="text" id="phone" name="phone" value="${enterpriseInfo.phone}"
							reg="{'maxlength':20,'regex':'phone'}" 
							<c:if test="${type == 'view'}">readonly="readonly"</c:if>
							/></td>
					</tr>
					<tr>
						<th><label >手机</label></th>
						<td><input class="x-layui-input" type="text" id="mobilephone" name="mobilephone" value="${enterpriseInfo.mobilephone}"
							reg="{'maxlength':20,'regex':'mobile'}" 
							<c:if test="${type == 'view'}">readonly="readonly"</c:if>
							/></td>
						<th><label >创建时间</label></th>
						<td>
							<c:if test="${type == 'view'}">
<%--								<input type="text" id="foundedDate" name="foundedDate" value="<fmt:formatDate value='${enterpriseInfo.foundedDate}' pattern='yyyy/MM/dd' />"--%>
<%--									   readonly="readonly"/>--%>
								<input type="text" class="layui-input x-admin-content-sm-date" reg='{"required":"true"}' name="foundedDate" id="foundedDate" style="width: 100px;padding-left: 0px;"
									   value="<fmt:formatDate value='${enterpriseInfo.foundedDate}' pattern='yyyy/MM/dd'/>" />
							</c:if>
							<c:if test="${type != 'view'}">
<%--								<tag:dateInput nullToToday="true" id="foundedDate" name="foundedDate" date="${enterpriseInfo.foundedDate}"--%>
<%--											   pattern="yyyy/MM/dd"  onlypast="true"  ></tag:dateInput>--%>
								<input type="text" class="layui-input x-admin-content-sm-date" reg='{"required":"true","regex":"date"}'  name="foundedDate" id="foundedDate" style="width: 100px;padding-left: 0px;"
									   value="<fmt:formatDate value='${enterpriseInfo.foundedDate}' pattern='yyyy/MM/dd'/>"/>

							</c:if>
						</td>
					</tr>
				</table>
			</fieldset>
</form>
</div>

<script type="text/javascript">
	layui.use('laydate', function() {
		var laydate = layui.laydate;

		laydate.render({
			elem: '#foundedDate'
			,format:'yyyy/MM/dd'
			,max:0
		});
	});
</script>