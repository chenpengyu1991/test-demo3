<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<div class="postcontent">
<fieldset>
<legend></legend>
	<table class="posttable">
		<colgroup>
			<col style="min-width:150px;width:20%;"/>
	        <col/>
			<col style="min-width:150px;width:20%;"/>
	        <col/>
		</colgroup>
		<tr>
			<th>姓名：</th>
			<td style="text-align: left">${result.name}</td>
			<th>性别：</th>
            <td style="text-align: left"><ehr:dic code="${result.gender}" dicmeta="GBT226112003"></ehr:dic></td>
		</tr>
		<tr>
			<th>年龄：</th>
            <td style="text-align: left">${result.age}</td>
			<th>婚姻状况：</th>
            <td style="text-align: left"><ehr:dic code="${result.marriage}" dicmeta="GBT226122003"></ehr:dic></td>
		</tr>
		<tr>
			<th>血袋编号：</th>
			<td style="text-align: left">${result.bloodBagNo}</td>
			<th>活动名称：</th>
            <td style="text-align: left">${result.ehrName}</td>
		</tr>
		<tr>
			<th>输血规格：</th>
			<td style="text-align: left">${result.bloodSpecification}</td>
			<th>输血单位代码：</th>
            <td style="text-align: left">${result.unitCode}</td>
		</tr>
		<tr>
		    <th>输血单位名称：</th>
            <td style="text-align: left">${result.unitName}</td>
            <th>输血数量：</th>
            <td style="text-align: left">${result.bloodQuantity}</td>
		</tr>
        <tr>
            <th>输血品种代码：</th>
            <td style="text-align: left">${result.bloodTypeCode}</td>
            <th>输血品种名称：</th>
            <td style="text-align: left">${result.bloodTypeName}</td>
        </tr>
        <tr>
            <th>ABO血型代码：</th>
            <td style="text-align: left">${result.aboBloodType}</td>
            <th>Rh血型代码：</th>
            <td style="text-align: left">${result.rhBloodType}</td>
        </tr>
        <tr>
            <th>输血原因：</th>
            <td style="text-align: left">${result.bloodReason}</td>
            <th>输血者姓名工号：</th>
            <td style="text-align: left">${result.bloodCode}</td>
        </tr>
         <tr>
            <th>输血者姓名：</th>
            <td style="text-align: left">${result.bloodName}</td>
            <th>输血机构名称：</th>
            <td style="text-align: left">${result.bloodOrganName}</td>
        </tr>
         <tr>
            <th>输血者姓名身份证：</th>
            <td style="text-align: left">${result.bloodIdcard}</td>
            <th>失效日期时间：</th>
            <td style="text-align: left"><fmt:formatDate value="${result.invalidDate}" pattern="yyyy/MM/dd HH:mm:ss"></fmt:formatDate></td>
        </tr>
         <tr>
            <th>输血日期时间：</th>
            <td style="text-align: left"><fmt:formatDate value="${result.bloodDate}" pattern="yyyy/MM/dd HH:mm:ss"></fmt:formatDate></td>
            <th>医疗机构代码：</th>
            <td style="text-align: left">${result.hospitalCode}</td>
        </tr>
        <tr>
			<th>医疗机构名称：</th>
			<td style="text-align: left">${result.hospitalName}</td>
			<th>机构科室代码：</th>
            <td style="text-align: left">${result.deptCode}</td>
		</tr>
		<tr>
			<th>机构科室名称：</th>
            <td style="text-align: left">${result.deptName}</td>
			<th>更新人姓名：</th>
            <td style="text-align: left">${result.updateName}</td>
		</tr>
		<tr>
			<th>更新人身份证号：</th>
			<td style="text-align: left">${result.updateIdcard}</td>
			<th>更新日期和时间：</th>
            <td style="text-align: left"><fmt:formatDate value="${result.updateDate}" pattern="yyyy/MM/dd HH:mm:ss"></fmt:formatDate></td>
		</tr>
		<tr>
			<th>状态：</th>
			<td style="text-align: left">${result.isDelete}</td>
			<th>申请单编号：</th>
            <td style="text-align: left">${result.applyNo}</td>
		</tr>
		<tr>
		    <th>处理状态：</th>
            <td style="text-align: left">${result.processStatus}</td>
            <th>是否限制：</th>
            <td style="text-align: left">${result.isLimit}</td>
		</tr>
	</table>
</fieldset>
</div>