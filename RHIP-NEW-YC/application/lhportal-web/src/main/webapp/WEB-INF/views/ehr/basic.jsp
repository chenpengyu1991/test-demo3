<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="ehr" uri="/ehr-tag" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>

<link rel="stylesheet" href="${pageContext.request.contextPath}/css/views/ehrbrowser/basic/basic.css" />
<script src="${pageContext.request.contextPath}/js/views/ehr/ehrbrowser/basic/basic.js" type="text/javascript"></script>

<div id="beforeSaveDiv" class="rightnav">
	<table>
	<tr>
      		<td class="dingwei"><div id="location">当前位置:&gt;&gt;基本信息&gt;&gt;个人信息</div>
		</td>
	  </tr>
	 </table>
	<p align="right" style="height: 28px;">
	<input type="button" onclick="$('#basicInfoShow').hide();$('#basicInfoEdit').show();$('#save_btn').show();$('#edit_btn').hide();baseLayoutLoad.outResize();" value="编辑" style="height: 25px;cursor:pointer" id="edit_btn"/>
	<input type="button" onclick="basic.toSave();$('#save_btn').hide();$('#edit_btn').show();baseLayoutLoad.outResize();" value="保存"  style="height: 25px;display: none;" id="save_btn"/>
	</p>
<div class="table-basic" id="basicInfoShow">
<table>
	<colgroup>
	<col style="width:20%;"></col>
	<col style="width:30%;"></col>
	<col style="width:20%;"></col>
	<col style="width:30%;"></col>
	</colgroup>
	<tr>
	    <th >性别</th>
	    <td >
	        <ehr:dic dicmeta="GBT226112003" code="${personBasicInfoDto.personInfo.gender}"/>
	    </td>
	    <th >出生日期</th>
	    <td >
	        <fmt:formatDate value='${personBasicInfoDto.personInfo.birthday}' pattern='yyyy/MM/dd'/>
	    </td>
	</tr>
	<tr>
	    <th >身份证号</th>
	    <td >${personBasicInfoDto.personInfo.idcard }</td>
	    <th >工作单位</th>
	    <td >${personBasicInfoDto.personInfo.unitName }</td>
	</tr>
	<tr>
	    <th >本人电话</th>
	    <td colspan="5">
	    	${personBasicInfoDto.personInfo.phoneNumber}
	    </td>
	</tr>
	<tr>
		<th >监护人姓名</th>
	    <td >
	        ${personBasicInfoDto.personInfo.firstGuardian }
	    </td>
	    <th >监护人联系电话</th>
	    <td >${personBasicInfoDto.personInfo.guardianPhoneOne }</td>
	</tr>
	<tr>
	    <th >常住类型</th>
	    <td >
	        <ehr:dic dicmeta="FS10005" code="${personBasicInfoDto.personInfo.householdType}"/>
	    </td>
	    <th >民族</th>
	    <td >
	        <ehr:dic dicmeta="GBT3304" code="${personBasicInfoDto.personInfo.nation}"/>
	    </td>
	</tr>
	<tr>
	    <th >血型</th>
	    <td >
	        <ehr:dic dicmeta="CV0450005" code="${personBasicInfoDto.personInfo.aboBloodType}"/> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	    </td>
	    <th >RH阴性:</th>
	    <td >
	            <ehr:dic dicmeta="FS10010" code="${personBasicInfoDto.personInfo.rhBloodType}"/>
	    </td>
	</tr>
	<tr>
	    <th >文化程度</th>
	    <td colspan="5">
	        <ehr:dic dicmeta="GBT46582006" code="${personBasicInfoDto.personInfo.education}"/>
	    </td>
	</tr>
	<tr>
	    <th >职业</th>
	    <td colspan="5">
	        <ehr:dic dicmeta="GBT6565" code="${personBasicInfoDto.personInfo.occupation}"/>
	    </td>
	</tr>
	<tr>
	    <th>婚姻状况</th>
	    <td colspan="5">
	        <ehr:dic dicmeta="GBT226122003" code="${personBasicInfoDto.personInfo.marriage}"/>
	    </td>
	</tr>
	<tr>
	    <th>医疗费用支付方式</th>
	    <td colspan="5">
	        <ehr:dic dicmeta="CV0710003" code="${personBasicInfoDto.expenseInfoStr}"/>
	    </td>
	</tr>
	<tr>
	    <th>生活环境</th>
	    <td style="width: 100px;">厨房排风设施</td>
	    <td colspan="4">
	        <ehr:dic dicmeta="CV0300302" code="${personBasicInfoDto.personInfo.outWindType}"/>
	    </td>
	</tr>
	<tr>
	    <th>燃料类型</th>
	    <td colspan="5">
	        <ehr:dic dicmeta="CV0300303" code="${personBasicInfoDto.personInfo.fuel}"/>
	    </td>
	</tr>
	<tr>
	    <th>饮水</th>
	    <td colspan="5">
	        <ehr:dic dicmeta="CV0300115" code="${personBasicInfoDto.personInfo.water}"/>
	    </td>
	</tr>
	<tr>
	    <th>厕所</th>
	    <td colspan="5">
	        <ehr:dic dicmeta="CV0300304" code="${personBasicInfoDto.personInfo.hastoilet}"/>
	    </td>
	</tr>
	<tr>
	    <th>禽畜栏</th>
	    <td colspan="5">
	        <ehr:dic dicmeta="FS10015" code="${personBasicInfoDto.personInfo.fowlType}"/>
	    </td>
	</tr>
</table>
</div>

<div  class="table-basic" id="basicInfoEdit" style="display: none;">
<form action="" id="basicInfoForm">
	<input type="hidden" name="PersonalBasicInfoDTO.personInfoTemp.name" id="name" value="${personBasicInfoDto.personInfo.name}"/>
	<input type="hidden" name="PersonalBasicInfoDTO.personInfoTemp.personInfoId" value="${personBasicInfoDto.personInfo.id}">
	<table>
	<tr>
	    <th ><table style="width: 100px;"><tr><td style="text-align: center;border: 0px;">性别</td></tr></table></th>
	    <td colspan="3">
	        <ehr:dic-radio dicmeta="GBT226112003" name="PersonalBasicInfoDTO.personInfoTemp.gender" value="${personBasicInfoDto.personInfo.gender}"/>
	    </td>
	    <th width="16%">出生日期</th>
	    <td >
	        <tag:dateInput name="PersonalBasicInfoDTO.personInfoTemp.birthday" reg='{"required":true}' id="birthday" onlypast="true" date="${personBasicInfoDto.personInfo.birthday}"/>
	    </td>
	</tr>
	<tr>
	    <th >身份证号</th>
	    <td colspan="3">${personBasicInfoDto.personInfo.idcard }
	    <input type="hidden" name="PersonalBasicInfoDTO.personInfoTemp.idcard" id="idcard" value="${personBasicInfoDto.personInfo.idcard}"/></td>
	    <th>工作单位</th>
	    <td >
	    	<input type="text" name="PersonalBasicInfoDTO.personInfoTemp.unitName" id="unitName" value="${personBasicInfoDto.personInfo.unitName}"/>
	    </td>
	</tr>
	<tr>
	    <th >本人电话</th>
	    <td colspan="5">
	       <input type="text" name="PersonalBasicInfoDTO.personInfoTemp.phoneNumber" id="phoneNumber" value="${personBasicInfoDto.personInfo.phoneNumber}" />
	    </td>
	</tr>
	<tr>
		<th >监护人姓名</th>
	    <td colspan="3">
	    	<input type="text" name="PersonalBasicInfoDTO.personInfoTemp.firstGuardian" id="firstGuardian" value="${personBasicInfoDto.personInfo.firstGuardian}" />
	    </td>
	    <th >监护人联系电话</th>
	    <td >
	    	<input type="text" name="PersonalBasicInfoDTO.personInfoTemp.guardianPhoneOne" id="guardianPhone1" value="${personBasicInfoDto.personInfo.guardianPhoneOne}"/>
	    </td>
	</tr>
	<tr>
	    <th >常住类型</th>
	    <td colspan="3">
	       <ehr:dic-radio dicmeta="FS10005" name="PersonalBasicInfoDTO.personInfoTemp.householdType" value='${"2"!=personBasicInfoDto.personInfo.householdType?"1":"2"}'/>
	    </td>
	    <th>民族</th>
	    <td >
	       <ehr:dic-list dicmeta="GBT3304" name="PersonalBasicInfoDTO.personInfoTemp.nation" value="${personBasicInfoDto.personInfo.nation}"/>
	    </td>
	</tr>
	<tr>
	    <th >血型</th>
	    <td colspan="3">
	       <ehr:dic-radio dicmeta="CV0450005" name="PersonalBasicInfoDTO.personInfoTemp.aboBloodType" value="${personBasicInfoDto.personInfo.aboBloodType}"/> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	    </td>
	    <th>RH阴性:</th>
	    <td >
	       <ehr:dic-radio dicmeta="FS10010" name="PersonalBasicInfoDTO.personInfoTemp.rhBloodType" value="${personBasicInfoDto.personInfo.rhBloodType}"/>
	    </td>
	</tr>
	<tr>
	    <th >文化程度</th>
	    <td colspan="5">
			<ehr:dic-list dicmeta="GBT46582006" name="PersonalBasicInfoDTO.personInfoTemp.education" value="${personBasicInfoDto.personInfo.education}" code="IDM11,IDM12,IDM04,IDM13,IDM03,IDM02,IDM07,90"/>
	    </td>
	</tr>
	<tr>
	    <th >职业</th>
	    <td colspan="5">
	       <ehr:dic-list dicmeta="GBT6565" 
	       							code="CV020120201,CV020120202,CV020120203,CV020120204,CV020120205,CV020120206,CV020120207,CV020120224,CV020120209,CV020120210,CV020120211,CV020120212,CV020120213,CV020120214,CV020120215,CV020120216,CV020120217,CV020120299" 
	       							name="PersonalBasicInfoDTO.personInfoTemp.occupation" 
									width="200px" value="${personBasicInfoDto.personInfo.occupation}" 
									onchange="toggleOtherSC('PersonalBasicInfoDTO.personInfoTemp.occupation','occupation_other',90);"/>
	    </td>
	</tr>
	<tr>
	    <th >婚姻状况</th>
	    <td colspan="5">
	        <ehr:dic-radio dicmeta="GBT226122003" name="PersonalBasicInfoDTO.personInfoTemp.marriage" value="${personBasicInfoDto.personInfo.marriage}"  code="10,20,30,40,90"/>
	    </td>
	</tr>
	<tr>
	    <th >医疗费用支付方式</th>
	    <td colspan="5">
	        <ehr:dic-checkbox dicmeta="CV0710003" name="PersonalBasicInfoDTO.personInfoTemp.expenseInfoStr" value="${personBasicInfoDto.expenseInfoStr}"/>
	    </td>
	</tr>
	<tr>
	    <th >生活环境</th>
	    <td style="width: 100px;">厨房排风设施</td>
	    <td colspan="5">
	        <ehr:dic-radio dicmeta="CV0300302" name="PersonalBasicInfoDTO.personInfoTemp.outWindType" value="${personBasicInfoDto.personInfo.outWindType}"/>
	    </td>
	</tr>
	<tr>
	    <th>燃料类型</th>
	    <td colspan="5">
	       <ehr:dic-radio dicmeta="CV0300303" name="PersonalBasicInfoDTO.personInfoTemp.fuel" value="${personBasicInfoDto.personInfo.fuel}"/>
	    </td>
	</tr>
	<tr>
	    <th>饮水</th>
	    <td colspan="5">
	        <ehr:dic-radio dicmeta="CV0300115" name="PersonalBasicInfoDTO.personInfoTemp.water" value="${personBasicInfoDto.personInfo.water}"/>
	    </td>
	</tr>
	<tr>
	    <th>厕所</th>
	    <td colspan="5">
	        <ehr:dic-radio dicmeta="CV0300304" name="PersonalBasicInfoDTO.personInfoTemp.hastoilet" value="${personBasicInfoDto.personInfo.hastoilet}"/>
	    </td>
	</tr>
	<tr>
	    <th>禽畜栏</th>
	    <td colspan="5">
	        <ehr:dic-radio dicmeta="FS10015" name="PersonalBasicInfoDTO.personInfoTemp.fowlType" value="${personBasicInfoDto.personInfo.fowlType}"/>
	    </td>
	</tr>
	</table>
</form>
</div>
</div>