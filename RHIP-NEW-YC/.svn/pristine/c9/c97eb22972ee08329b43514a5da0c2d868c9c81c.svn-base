<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="ehr" uri="/ehr-tag" %>
<div class="titlebar" style="margin-top: 10px;">
	<div class="title">个人基本信息</div>
	<div class="toobar"></div>
</div>
<table class="formtable">
	<tr>
		<th width="12%">姓名</th>
		<td width="21%">${person.name}</td>
		<th width="12%">拼音</th>
		<td width="21%">${person.cpy}</td>
		<th width="12%">身份证号</th>
		<td width="21%">${person.idCard}</td>
	</tr>
	<tr>
		<th width="12%">性别</th>
		<td width="21%"><ehr:dic dicmeta="GBT226112003" code="${person.gender}"/></td>
		<th width="12%">其他证件类型</th>
		<td width="21%"><ehr:dic dicmeta="CV0201101" code="${person.otherCardType}"/></td>
		<th width="12%">其他证件号码</th>
		<td width="21%">${person.otherCardNo}</td>
	</tr>
	<tr>
		<th width="12%">出生日期</th>
		<td width="21%"><fmt:formatDate value="${person.birthday}"
		                                pattern="yyyy/MM/dd" /></td>
		<th width="12%">国家</th>
		<td width="21%"><ehr:dic dicmeta="GBT26592000" code="${person.nation}"/></td>
		<th width="12%">民族</th>
		<td width="21%"><ehr:dic dicmeta="GBT3304" code="${person.nation}"/></td>
	</tr>
	<tr>
		<th width="12%">婚姻状况</th>
		<td width="21%"><ehr:dic dicmeta="GBT226122003" code="${person.marriage}"/></td>
		<th width="12%">学历</th>
		<td width="21%"><ehr:dic dicmeta="GBT46582006" code="${person.education}"/></td>
		<th width="12%">&nbsp;</th>
		<td width="21%">&nbsp;</td>
	</tr>
</table>
<div class="titlebar" style="margin-top: 10px;">
	<div class="title">个人其他信息</div>
	<div class="toobar"></div>
</div>
<table class="formtable">
	<tr>
		<th width="12%">本人电话</th>
		<td width="21%">${person.phoneNumber}</td>
		<th width="12%">家庭电话</th>
		<td width="21%">${person.homePhone}</td>
		<th width="12%">电子邮箱</th>
		<td width="21%">${person.email}</td>
	</tr>
	<tr>
		<th width="12%">单位/学校名称</th>
		<td width="21%">${person.unitName}</td>
		<th width="12%">单位/学校电话</th>
		<td width="21%">${person.unitPhone}</td>
		<th width="12%">职业类别</th>
		<td width="21%"><ehr:dic dicmeta="GBT6565" code="${person.occupation}"/></td>
	</tr>
</table>
<div class="titlebar" style="margin-top: 10px;">
	<div class="title">个人联系地址</div>
	<div class="toobar"></div>
</div>
<table class="formtable">
	<tr>
		<th width="80px" rowspan="3">现住址</th>
		<%-- <td>现住地行政区划代码&nbsp;
			<input type="text" readonly="readonly" style="width: 53%;border: 1px solid #D7D7D7;"
			       value="${person.gbCode}"/>
		</td> --%>
	</tr>
	<tr>
		<td>完整地址&nbsp;
			<input type="text" readonly="readonly" style="width: 60%;border: 1px solid #D7D7D7;"
			       value='${person.paProvince}${person.paCity}${person.paCounty}<ehr:dic dicmeta="FS990001" code="${person.paTownship}"/><ehr:dic dicmeta="FS990001" code="${person.paStreet}"/>${person.paHouseNumber}'/>
		</td>
	</tr>
	<tr>
		<td>邮政编码&nbsp;
			<input type="text" readonly="readonly" style="width: 60%;border: 1px solid #D7D7D7;" value="${person.paPostcode}"/>
		</td>
	</tr>
	<tr>
		<th width="80px" rowspan="2">户籍地址</th>
		<td>完整地址&nbsp;
			<input type="text" readonly="readonly" style="width: 60%;border: 1px solid #D7D7D7;"
			       value='${person.hrProvince}${person.hrCity}${person.hrCounty}<ehr:dic dicmeta="FS990001" code="${person.hrTownship}"/><ehr:dic dicmeta="FS990001" code="${person.hrStreet}"/>${person.hrHouseNumber}'/>
		</td>
	</tr>
	<tr>
		<td>邮政编码&nbsp;
			<input type="text" readonly="readonly" style="width: 60%;border: 1px solid #D7D7D7;" value="${person.hrPostcode}"/>
		</td>
	</tr>
</table>
