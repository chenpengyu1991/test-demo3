<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<script src="${pageContext.request.contextPath}/js/util/role.js" type="text/javascript"></script> 
 

<script type="text/javascript">
	var arry = "<%=request.getAttribute("data")%>";
	var manager = null;
	var menuData = eval("(" + arry + ")");

	$(function() {
		getRoleTree();
	});
	
</script>

<div class="msgError" id="msgError" style="display: none;"></div>
<div class="section">
	<div class="titlebar">
		<div class="title">
   			角色管理
   		</div>
   		<div class="toobar">
			<span onclick="javascript:history.go(-1);"><img src="${pageContext.request.contextPath}/images/btn/back.png" />&nbsp;返回</span>
		</div>
	</div>
	<form id="roleFormId" name="roleForm" action="" method="post">
		<table class="formtable">
			<tr>
				<th style="width:10%;"><label class="required">角色名称</label></th>
				<td style="width:40%;"><input type="text" id="nameId" name="name" /></td>
				<th style="width:10%;">是否可用</th>
				<td style="width:40%;"><input type="radio" name="status" value="1" checked="checked" style="width: 20px;" />是 <input type="radio" name="status" value="0" style="width: 20px;" />否</td>
			</tr>
			<tr>
				<th>角色描述</th>
				<td colspan="3"><textarea rows="5" id="descriptionId" name="description"></textarea></td>
			</tr>
			<tr>
				<th><label class="required">权限设置</label></th> 
				<td style="vertical-align: top; text-align:left;" colspan="3" > 
			    <input type="button"  style="width:50px;" value="折叠" onclick='collapseAll()'/>
			    <input type="button"  style="width:50px;" value="展开" onclick='expandAll()'/>
                <ul id="tree1">
                </ul> 
				</td>
			</tr>
		</table>
		<div align="center">
			<input type="button" id="saveButtonId" name="save" value="保 存" onclick="saveRole()" class="btnopr" />
		</div> 
	</form>
</div>
