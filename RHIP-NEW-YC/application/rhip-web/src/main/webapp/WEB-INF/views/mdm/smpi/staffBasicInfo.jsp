<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="ehr" uri="/ehr-tag" %>
<div class="titlebar" style="margin-top: 10px;">
	<div class="title">人员基本信息</div>
	<div class="toobar"></div>
</div>
<table class="formtable">
	<tr>
		<th width="12%">姓名</th>
		<td width="21%">${staff.name}</td>
		<th width="12%">拼音</th>
		<td width="21%">${staff.cpy}</td>
		<th width="12%">身份证号</th>
		<td width="21%">${staff.idCard}</td>
	</tr>
	<tr>
		<th width="12%">性别</th>
		<td width="21%"><ehr:dic dicmeta="GBT226112003" code="${staff.gender}"/></td>
		<th width="12%">出生日期</th>
		<td width="21%"><fmt:formatDate value="${staff.birthday}"
		                                pattern="yyyy/MM/dd"/></td>
		<th width="12%">民族</th>
		<td width="21%"><ehr:dic dicmeta="GBT3304" code="${staff.nation}"/></td>
	</tr>
	<tr>
		<th width="12%">婚姻状况</th>
		<td width="21%"><ehr:dic dicmeta="GBT226122003" code="${staff.marriage}"/></td>
		<th width="12%">学历</th>
		<td width="21%"><ehr:dic dicmeta="GBT46582006" code="${staff.education}"/></td>
		<th width="12%">党派</th>
		<td width="21%"><ehr:dic dicmeta="GBT47631984" code="${staff.party}"/></td>
	</tr>
</table>
<div class="titlebar" style="margin-top: 10px;">
    <div class="title">个人荣誉</div>
    <div class="toobar"></div>
</div>
<table class="formtable">
    <c:forEach var="honor" items="${staff.staffHonors}" varStatus="status">
        <tr>
            <th width="12%">个人荣誉</th>
            <td><input type="text" name="honorContent" value="${honor.honorContent}" reg='{"maxlength":"20"}' style="width:90%"/></td>
            <th>授予时间</th>
            <td><input type="text" name="honorDate" value="${honor.honorDate}" reg='{"maxlength":"20"}' style="width:90%"/></td>
            <th>授予单位</th>
            <td><input type="text" name="honorUnit" value="${honor.honorUnit}" reg='{"maxlength":"20"}' style="width:90%"/></td>
            <th>执业地点</th>
            <td><input type="text" name="honorAddr" value="${honor.honorAddr}" reg='{"maxlength":"20"}' style="width:90%"/></td>
        </tr>
    </c:forEach>
</table>
<div class="titlebar" style="margin-top: 10px;">
	<div class="title">人员其他信息</div>
	<div class="toobar"></div>
</div>
<table class="formtable">
	<tr>
		<th width="12%">住宅电话</th>
		<td width="21%">${staff.homeTel}</td>
		<th width="12%">手机</th>
		<td width="21%">${staff.mobile}</td>
		<th width="12%">电子邮箱</th>
		<td width="21%">${staff.mail}</td>
	</tr>
	<tr>
		<th width="12%">毕业学校</th>
		<td width="21%">${staff.university}</td>
		<th width="12%">所学专业</th>
		<td width="21%">${staff.speciality}</td>
		<th width="12%">最高学位</th>
		<td width="21%"><ehr:dic dicmeta="GBT6864" code="${staff.degree}"/></td>
	</tr>
</table>
<div class="titlebar" style="margin-top: 10px;">
	<div class="title">人员联系地址</div>
	<div class="toobar"></div>
</div>
<table class="formtable">
	<tr>
		<th width="80px" rowspan="3">家庭住址</th>
		<td>行政区划代码&nbsp;
			<input type="text" readonly="readonly" style="width: 53%;border: 1px solid #D7D7D7;"
			       value="${staff.gbCode}"/>
		</td>
	</tr>
	<tr>
		<td>完整地址&nbsp;
			<input type="text" readonly="readonly" style="width: 60%;border: 1px solid #D7D7D7;"
			       value="${staff.paProvince}${staff.paCity}${staff.paCounty}${staff.paTownship}${staff.paStreet}${staff.paHouseNumber}"/>
		</td>
	</tr>
	<tr>
		<td>邮政编码&nbsp;
			<input type="text" readonly="readonly" style="width: 60%;border: 1px solid #D7D7D7;" value="${staff.paPostcode}"/>
		</td>
	</tr>
</table>
