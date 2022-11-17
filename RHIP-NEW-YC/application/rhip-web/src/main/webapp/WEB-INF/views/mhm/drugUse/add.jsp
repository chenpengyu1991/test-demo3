<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>

<script src="${pageContext.request.contextPath}/js/views/mhm/drugUse/drugUseEdit.js" type="text/javascript"></script>
<div class="toolbar">
	<!-- <a href="javascript:void(0)" id="returnSearch"><b class="fanhui">返回</b></a> -->
	<a href="javascript:void(0)" id="returnSearch" ><button class="btn-gray layui-btn layui-btn-sm button"><i class="layui-icon">&#xe65c;</i>返回</button></a>
</div>
<div class="section divFixed105" style="top: 55px;">
	<div class="postcontent postdiv" id="detailDiv">
		<input type="hidden" id="drugUsePageIndex" value="${pageIndex}">
        <form id="drugListForm"></form>
		<form id="drugUseForm">
			<input type="hidden" name="statusId" id="statusId" value="${mhmUseDrugDto.statusId}">
			<fieldset style="margin-top: 10px" class="layui-elem-field">
			<legend>基本信息</legend>
			<table class="posttable">
			    <colgroup>
		           <col style="min-width: 120px; width: 20%;"/>
		           <col style="min-width: 180px; width: 30%;"/>
		           <col style="min-width: 80px; width: 20%;"/>
		           <col style="min-width: 250px; width: 30%;"/>
			    </colgroup>
			    <tr>
			        <th>姓名：</th>
			        <td>${mhmUseDrugDto.mhmBasicsInfo.name}</td>			    
			        <th>性别：</th>
			        <td><ehr:dic dicmeta="GBT226112003" code="${mhmUseDrugDto.mhmBasicsInfo.gender}"/></td>
			    </tr>
			    <tr>
			        <th>文化程度：</th>
			        <td><ehr:dic dicmeta="GBT46582006" code="${mhmUseDrugDto.mhmBasicsInfo.education}"/></td>
			        <th>现住址详细：</th>
			        <td>${mhmUseDrugDto.mhmBasicsInfo.paAddress}</td>
			    </tr>
			    <tr>
			        <th>身份证号码：</th>
			        <td>${mhmUseDrugDto.mhmBasicsInfo.idcard}</td>			    
			        <th>工作单位：</th>
			        <td>${mhmUseDrugDto.mhmBasicsInfo.unitName}</td>
			    </tr>			    			    
			    </table>
			</fieldset>
			<fieldset style="margin-top: 10px" class="layui-elem-field">
			    <legend>发药登记</legend>
			    <table class="posttable">
			        <colgroup>
			           <col style="min-width: 120px; width: 20%;"/>
			           <col style="min-width: 180px; width: 30%;"/>
			           <col style="min-width: 80px; width: 20%;"/>
			           <col style="min-width: 250px; width: 30%;"/>
			        </colgroup>
			        <tr>
			            <td colspan="4">
			            	<a href="javascript:void(0)" id="popuDrugUse" ><button class="layui-btn layui-btn-sm button"><i class="layui-icon"></i>添加</button></a>
			            </td>
			        </tr>
			        <tr>
			            <td colspan="4">
			                <div id="drugList">
			                </div>
			            </td>
			        </tr>
			    </table>
			</fieldset>
		</form>
	</div>
</div>