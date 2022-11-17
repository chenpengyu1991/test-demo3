<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<script src="${pageContext.request.contextPath}/js/views/cdm/highRisk/managePlanForm.js" type="text/javascript"></script>

<div id="hideManagePlan">
	<div class="toolbar" align="right" style="margin-top: 8px;">
				<%-- <a id="returnButton"><b class="fanhui">返回</b></a> --%>
				<a id="returnButton" ><button class="btn-gray layui-btn layui-btn-sm button"><i class="layui-icon">&#xe65c;</i>返回</button></a>
		        <%-- <a id="add"><b class="xinz">新增</b></a> --%>
		        <a id="add" ><button class="layui-btn layui-btn-sm button"><i class="layui-icon">&#xe61f;</i>新增</button></a>
		        <%-- <a id="saveManagePlan" ><b class="baocun">保存</b></a> --%>
		        <a id="saveManagePlan" ><button class="layui-btn layui-btn-sm button"><i class="layui-icon">&#xe605;</i>保存</button></a>
	</div>
	<div class="postdiv">
		<fieldset style="margin:5px 15px 5px 10px;with:100%" class="layui-elem-field">
	 			<legend > 基本信息 </legend>	
				<table class="posttable">
					<colgroup>
						<col style="width: 7%; min-width: 100px;" />
						<col style="width: 10%; min-width: 200px;" />
						<col style="width: 5%; min-width: 100px;" />
					</colgroup>
					<tr>
						<td>&nbsp;&nbsp;姓名：<ehr:tip>${personInfo.name}</ehr:tip></td>
						<td>身份证号：<ehr:tip>${personInfo.idcard}</ehr:tip></td>
						<td>出生年月：<ehr:tip><fmt:formatDate value='${personInfo.birthday}' pattern='yyyy/MM/dd'/></ehr:tip></td>						
					</tr>
					<tr>
						<td>&nbsp;&nbsp;性别：<ehr:tip><ehr:dic dicmeta="GBT226112003" code = "${personInfo.gender}"/></ehr:tip></td>					
						<td style="overflow:hidden;text-overflow:ellipsis;white-space:nowrap;">
							<label>现住地址：</label><ehr:tip><ehr:dic dicmeta="FS990001" code="${personInfo.patownShip }"></ehr:dic> <ehr:dic dicmeta="FS990001" code="${personInfo.pastreet }"></ehr:dic> ${personInfo.pahouseNumber }</ehr:tip></td>
						<td><label>联系电话：<ehr:tip>${personInfo.phoneNumber}</ehr:tip></label></td>
					</tr>
				</table>
		</fieldset>
	</div>
	<div id="main-search">		
		<form id="managePlanForm" method="post">
		    <input type="hidden" id="personId" name="personId" value="${personInfo.personId}"/>
		    <input type="hidden" id="idcard" name="idcard" value="${personInfo.idcard}"/>
			<div id="managePlanInfoForm"></div>
		</form>
	</div>
</div>
<div id="loadFollowUp" style="display: none"></div>
