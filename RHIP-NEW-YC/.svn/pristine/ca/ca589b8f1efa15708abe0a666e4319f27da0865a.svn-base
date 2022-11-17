<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="ehr" uri="/ehr-tag" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/views/ehrbrowser/basic/basic.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/views/ehrbrowser/basic/informBook.css" />
<script src="${pageContext.request.contextPath}/js/views/ehr/ehrbrowser/basic/dsdialog.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/ehr/ehrbrowser/basic/basic.js" type="text/javascript"></script>

<c:if test="${isOpen ne 0 and isRead ne 1}">
	<input type="hidden" id="informBook_time" value="${infromBook.time}"/>
	<div id="informBook_contents"  style='display:none;'>${infromBook.contents}</div>
</c:if>
<input type="hidden" id="informBook_isOpen" value="${isOpen}"/>
<input type="hidden" id="informBook_isRead" value="${isRead}"/>
<div id="beforeSaveDiv"  class="rightnav">
	<table>
	<tr>
      		<td class="crumbs"><div id="location" parentMenu="basic-info" childMenu="basic">当前位置:&gt;&gt;基本信息&gt;&gt;个人信息</div>
		</td>
	  </tr>
	 </table>
	<p align="right" style="height: 28px;">
	<input type="button" onclick="basic.toEdit()" value="编辑" style="height: 25px;cursor:pointer" id="edit_btn"/>
	<input type="button" onclick="basic.toSave()" value="保存"  style="height: 25px;display: none;cursor:pointer" id="save_btn"/>
	</p>
<div id="basicInfoShow" class="table-basic" >
<table>
		   <tr>
				<th colspan="2">
					真实姓名：
				</th>
				<td colspan="2">
						<input id="realName" name="realName" maxlength="20" type="hidden" value="${ACCOUNT_INFO_IN_SESSION.realName}">
						${ACCOUNT_INFO_IN_SESSION.realName}
			    </td>
			</tr>
			<tr>
				<th colspan="2">
					身份证号码：
				</th>
			  	<td colspan="2">
			  			<input id="cardNo" name="cardNo" maxlength="20" type="hidden" value="${ACCOUNT_INFO_IN_SESSION.cardNo}">
			  			${ACCOUNT_INFO_IN_SESSION.cardNo}
				</td>
			</tr>
			<tr>
				<th colspan="2">
					邮箱地址：
			  	</th>
				<td colspan="2">
					${ACCOUNT_INFO_IN_SESSION.email}
		      	</td>
			</tr>
			<tr>
				<th colspan="2">
					手机号码
			  	</th>
				<td colspan="2">
					${ACCOUNT_INFO_IN_SESSION.telephone}
		      	</td>
			</tr>
			<tr>
				<th colspan="2">
					现住址：
				</th>
				<td colspan="2">
					<ehr:dic-town-village villageId="village_address" townValue="${ACCOUNT_INFO_IN_SESSION.patownShip}" villageValue="${ACCOUNT_INFO_IN_SESSION.pastreet}"
						townId="town_address" villageName="pastreet"
						townName="patownShip" width="190px;" reg="{'required':true}" /><%--callback="regeditPage.displayPaAddress"--%>
                </td>
			</tr>
			<tr>
				<th colspan="2">住址详细地址： </th>
				<td colspan="2">
					<span id="cccc"></span>
					${ACCOUNT_INFO_IN_SESSION.pahouseNumber}
				</td>
			</tr>
</table>
</div>
<div  class="table-basic" id="basicInfoEdit" style="display: none;">
<form action="" id="basicInfoForm">
<table>
 <tr>
				<th colspan="2">
					真实姓名<span class="red"></span>：
				</th>
				<td colspan="2">
						<input id="realName" name="realName" maxlength="20" type="hidden" value="${ACCOUNT_INFO_IN_SESSION.realName}">
						${ACCOUNT_INFO_IN_SESSION.realName}
			    </td>
			</tr>
			<tr>
				<th colspan="2">
					身份证号码<span class="red"></span>：
				</th>
			  	<td colspan="2">
			  			<input id="cardNo" name="cardNo" maxlength="20" type="hidden" value="${ACCOUNT_INFO_IN_SESSION.cardNo}">
			  			${ACCOUNT_INFO_IN_SESSION.cardNo}
				</td>
			</tr>
			<tr>
				<th colspan="2">
					邮箱地址<span class="red">*</span>：
			  	</th>
				<td colspan="2">
					<input id="email" name="email" type="text"  class="regeditIput" maxlength="50" value="${ACCOUNT_INFO_IN_SESSION.email}">
		      		<span id="emailSpan">请输入您常用的邮箱，以便日后找回密码或接收数字账单用于核对</span>
		      	</td>
			</tr>
			<tr>
				<th colspan="2">
					手机号码<span class="red">*</span>：
			  	</th>
				<td colspan="2">
					<input id="telephone" name="telephone" maxlength="11" type="text"  class="regeditIput" value="${ACCOUNT_INFO_IN_SESSION.telephone}">
		      		<span id="telephoneSpan">请正确填写您的手机号码，用来接收注册验证码及市民通知</span>
		      	</td>
			</tr>
			<tr>
				<th colspan="2">
					现住址：
				</th>
				<td colspan="2">
					<ehr:dic-town-village villageId="village_address" townValue="${ACCOUNT_INFO_IN_SESSION.patownShip}" villageValue="${ACCOUNT_INFO_IN_SESSION.pastreet}"
						townId="town_address" villageName="pastreet"
						townName="patownShip" width="190px;" reg="{'required':true}" callback="regeditPage.displayPaAddress"/>
				</td>
			</tr>
			<tr>
				<th colspan="2">住址详细地址： </th>
				<td colspan="2">
					<span id="cccc"></span>
					<input type="text" id="text_pahouseNumber" name="pahouseNumber"  style="width: 400px;" maxlength="25" value="${ACCOUNT_INFO_IN_SESSION.pahouseNumber}"/>
				</td>
			</tr>
	<tr>
		<th colspan="2">
			设置健康档案查看密码
		</th>
		<td colspan="2">
			<input type="password" id="decryptionPassword" name="decryptionPassword"  style="width: 400px;" maxlength="50"/>
		</td>
	</tr>
</table>
</form>
</div>
</div>