<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>

<script src="${pageContext.request.contextPath}/js/views/he/promoteunit/edit.js" type="text/javascript"></script>

<div class="toolbar">
	 <!-- <a href="javascript:void(0)" id="healthPromoteUnitSaveButton"><b class="baocun">保存</b></a> -->
	 <a href="javascript:void(0)" id="healthPromoteUnitSaveButton"><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe605;</i>保存</button></a>
</div>
<div>
	<form id="healthPromoteUnitForm">
		<div class="postcontent">
			<input type="hidden" name="id" value="${healthPromoteUnit.id}">
			<table class="posttable">
				<colgroup>
					<col style="width: 30%;"/>
					<col style="width: 70%;"/>
				</colgroup>
				<tr>
					<th><label class="required">授予时间</label></th>
					<td>
						<%-- <tag:dateInput reg='{"required":"true"}' name="grantTime" id="grantTime" date="${healthPromoteUnit.grantTime}" onlypast="true"/> --%>
						<input type="text" reg='{"required":"true"}'  class="layui-input x-admin-content-sm-date"  name="grantTime" id="grantTime" value="<fmt:formatDate value='${healthPromoteUnit.grantTime}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;" />
					</td>
				</tr>
				<tr>
					<th><label class="required">单位名称</label></th>
					<td>
						<input name="name" type="text"  reg='{"required":"true","maxlength":"20"}' value="${healthPromoteUnit.name}" class="x-layui-input"/>
					</td>
				</tr>
				<tr>
					<th><label class="required">创建类别</label></th>
					<td>
						<ehr:dic-list name="type" value="${healthPromoteUnit.type}" dicmeta="HE00009" width="150px" id="type" reg='{"required":"true"}' onchange="healthPromoteUnitEdit.addOtherUnitType()" cssClass="x-layui-input"></ehr:dic-list> 
						<input type="text" style="width: 125px;" class="${healthPromoteUnit.type eq '99' ?'':'hide'}" reg='{"required":"true","maxlength":50}' name="otherType" id="otherType" value="${healthPromoteUnit.otherType}" class="x-layui-input"/>
					</td>
				</tr>
				<tr>
					<th><label class="required">创建级别</label></th>
					<td>
						<ehr:dic-list name="unitLevel" value="${healthPromoteUnit.unitLevel}" dicmeta="HE00010" width="150px" id="unitLevel" reg='{"required":"true"}' onchange="healthPromoteUnitEdit.addOtherUnitLevel()" cssClass="x-layui-input"></ehr:dic-list> 
						<input type="text" style="width: 125px;" class="${healthPromoteUnit.unitLevel eq '99' ?'':'hide'}" reg='{"required":"true","maxlength":50}' name="otherUnitLevel" id="otherUnitLevel" value="${healthPromoteUnit.otherUnitLevel}" class="x-layui-input"/>
					</td>
				</tr>
			</table>
		</div>
	</form>
</div>

<script type="text/javascript">
layui.use('laydate', function(){
    var laydate = layui.laydate;
    
    laydate.render({
      elem: '#grantTime' 
   	   ,format: 'yyyy/MM/dd'
   	   ,max:0
    });
    
    
    
  });
</script>