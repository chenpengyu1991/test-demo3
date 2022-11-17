<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<fieldset class="layui-elem-field" style="margin-top: 10px;">
	<legend style="color: black;">&nbsp;基本信息&nbsp; </legend>
	<input type="hidden" name="personInfo.id" value="${personInfo.id}">
	<input type="hidden" name="personInfo.birthday" value="<fmt:formatDate value='${personInfo.birthday}' pattern='yyyy/MM/dd' />">
	<table class="posttable">
		<colgroup>
			<col style="width: 7%; min-width: 100px;" />
			<col style="width: 10%; min-width: 200px;" />
			<col style="width: 5%; min-width: 100px;" />
		</colgroup>
		<tr>
			<td > &nbsp; &nbsp; <label>姓名：<ehr:tip>${personInfo.name}</ehr:tip></label></td>
			<td><label>身份证号：<a href="javascript:void(0);" onclick="viewEhr(${personInfo.id})"><ehr:tip>${personInfo.idcard}</ehr:tip></a></label></td>
			<td><label>出生日期：<ehr:tip><fmt:formatDate value="${personInfo.birthday}" pattern="yyyy/MM/dd" /></ehr:tip></label></td>
		</tr>
		<tr>
			<td> &nbsp; &nbsp; <label>性别：</label><ehr:tip><ehr:dic dicmeta="GBT226112003" code="${personInfo.gender}" /></ehr:tip></td>
			<td><label>现住地址：</label><ehr:tip><ehr:dic dicmeta="FS990001" code="${personInfo.patownShip }"></ehr:dic> <ehr:dic dicmeta="FS990001" code="${personInfo.pastreet }"></ehr:dic> ${personInfo.pahouseNumber }</ehr:tip></td>
			<td><label>联系电话：<ehr:tip>${personInfo.phoneNumber}</ehr:tip></label></td>
		</tr>
	</table>
</fieldset>

<script type="text/javascript">
function viewEhr(id) {
	 $("#dm-followup-main").hide();
		$.loadHtmlByUrl({
			url : "/ehrbrowser/index/"+id,
			param: {cdm : 1,
				    region:1
				    },
			insertDiv :"ehrDetailDiv",
	        wait : true
	    });
		$("#ehrDetailDiv").show();
}
    </script>