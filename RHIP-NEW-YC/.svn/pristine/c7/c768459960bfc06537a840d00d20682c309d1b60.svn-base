<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>

<script src="${pageContext.request.contextPath}/js/views/user/add.js" type="text/javascript"></script>

<div class="msgError" id="msgErrorAdd" style="display: none;"></div>
<div class="msgOK" id="msgOKAdd" style="display: none;"></div>

<input id="changeStaff" type="hidden" value="${changeStaff}"/>
<input id="selectRoleCode" type="hidden" value="${roleCode}"/>

<div class="postcontent">
	<form id="userFormAddId" name="userForm" action="" method="post">
		<input name="orgId" id="selectOrg" type="hidden"/>
		<input name="id" id="id" type="hidden" value="${user.id}"/>
		<input name="userCode" id="userCode" type="hidden" value="${userCode}"/>
		<input type="hidden" id="add_index">
		<div class="postdiv">
			<fieldset class="layui-elem-field">
				<legend>选择机构用户</legend>
				<table style="width:99%" class="posttable">
					<c:if test="${empty user.userCode}">
						<tr>
							<td></td>
							<td colspan="5">
								<a href="javascript:void(0)" id="selectStaffUser"><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe608;</i>选择人员</button></a>
							</td>
						</tr>
					</c:if>
					<tr>
						<th>
							<label class="required">身份证号</label>
	                   	</th>
						<td>
		                     <input type="text" 
		                     	 name="identityCard" value="${user.identityCard}"
		                     	 style="width: 200px;"
		                     	 id="idCardTxt" readonly="readonly"  reg='{"required":"true"}'/>
	                    </td>
						<th>
							<label class="required">姓名</label>
		                </th>
						<td>	
							 <input type="hidden" id="staffCode" name="staffCode" value="${user.staffCode}"/>
		                    <input type="text" id="name" name="name" reg='{"required":"true","maxlength":"23"}' readonly="readonly" value="${user.name}"/>
						</td>
						<th>性别</th>				
						<td>
							<ehr:dic-list id="gender" dicmeta="GBT226112003" name="gender" value="${user.gender}"/>
						</td>
					</tr>
				</table>
			</fieldset>
		</div>
		
		<div class="postdiv">
			<fieldset id="infoFieldset" class="layui-elem-field">
				<legend>基础信息</legend>
				<table style="width:99%" class="posttable">
					<tr>
						<th style="width: 10%;">
		                       <label class="required">用户名</label>
		                   </th>
						<td>
		                       <input type="text" id="userName" name="userName" reg='{"required":"true","maxlength":"23","regex":"^[A-Za-z0-9_.]+$"}'
		                              tip="用户名只能是英文大、小写、下划线或者数字的组合" value="${user.userName}"/>
							<span id="checkName">	</span>
						</td>
						<th>是否可用</th>				
						<td>
							<input type="radio" name="status" value="1" <c:if test="${user.status!=0}"> checked="checked" </c:if> style="width: 20px;" />是
							<input type="radio" name="status" value="0" <c:if test="${user.status==0}"> checked="checked" </c:if> style="width: 20px;" />否
						</td>
						<th>电子邮件</th>
						<td>
	                        <input type="text" id="email" name="email" value="${user.email}"/>
	                    </td>
					</tr>
					<tr>
						<th>固定电话</th>				
						<td>
		                	<input type="text" id="telephone" name="telephone" reg='{"maxlength":"18"}' value="${user.telephone}"/>&nbsp;
						</td>
						<th>手机</th>				
						<td>
		                	<input type="text" id="mobile" name="mobile" reg='{"maxlength":"18","regex":"phone"}' style="width: 200px;" value="${user.mobile}"/>
						</td>
						<%--<th>健康档案查阅</th>--%>
						<%--<td>--%>
							<%--<ehr:dic-list id="cicPermission" dicmeta="EHR00002" name="cicPermission" value="${user.cicPermission}"/>--%>
						<%--</td>--%>
					</tr>
				</table>
			</fieldset>
		</div>
		
		<div class="postdiv" id="orgListDiv">
		</div>
		<p align="center">
			<button class="layui-btn layui-btn-sm" id="saveUserButtonId"><i class="layui-icon"></i>保存</button>
			<br>
		</p>
		<input type="hidden" id="password" name="password"/>
	</form>
</div>
