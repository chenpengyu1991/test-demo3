<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/ehr-tag" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<script src="${pageContext.request.contextPath}/js/views/cdm/highRisk/followUp_main.js" type="text/javascript"></script>

<div id="followManageMain" style="margin-top: 10px;">
	<div class="postdiv">
		<fieldset style="margin:5px;with:98%;height: 67px;" class="layui-elem-field">
	 			<legend > 基本信息 </legend>	
				<table class="posttable">
					<colgroup>
						<col style="width: 7%; min-width: 100px;" />
						<col style="width: 10%; min-width: 200px;" />
						<col style="width: 5%; min-width: 100px;" />
					</colgroup>
					<tr>
						<td>&nbsp;&nbsp;姓名：<ehr:tip>${personIdAndIdcard.name}</ehr:tip></td>
						<td>身份证号：<ehr:tip>${personIdAndIdcard.idcard}</ehr:tip></td>
						<td>出生年月：<ehr:tip><fmt:formatDate value='${personIdAndIdcard.birthday}' pattern='yyyy/MM/dd'/></ehr:tip></td>
					</tr>
					<tr>
						<td>&nbsp;&nbsp;性别：<ehr:tip><ehr:dic dicmeta="GBT226112003" code = "${personIdAndIdcard.gender}"/></ehr:tip></td>					
						<td style="overflow:hidden;text-overflow:ellipsis;white-space:nowrap;">
							<label>现住地址：</label><ehr:tip><ehr:dic dicmeta="FS990001" code="${personIdAndIdcard.patownShip }"></ehr:dic> <ehr:dic dicmeta="FS990001" code="${personIdAndIdcard.pastreet }"></ehr:dic> ${personIdAndIdcard.pahouseNumber}</ehr:tip>
						</td>
						<td><label>联系电话：<ehr:tip>${personIdAndIdcard.phoneNumber}</ehr:tip></label></td>
					</tr>
				</table>
		</fieldset>
	</div>
	<%-- <ul id="tags">
		<li class=selectTag>
			<a id="followUp_btn" href="javascript:void(0)">随访记录</a>
		</li>
		<li><a id="conclusion_btn" href="javascript:void(0)">管理评定</a></li>
	</ul>
	<div id="tagContent" style="width: 99.5%; height: 372px; ">
		<div id="tagContent0" class="selectTag" >
			<div class="toolbar">
				 <a id="returnButton"><b class="fanhui">返回</b></a>
			     <a id="followUpSave" ><b class="baocun">保存</b></a>
		    </div>
			<form id="followUpPlanForm" method="post">
				<input type="hidden" id="personId" name="personId" value="${personIdAndIdcard.personId}"/>
			    <input type="hidden" id="idcard" name="idcard" value="${personIdAndIdcard.idcard}"/>
			    <input type="hidden" id="followupId" value="">
			    <div id="followUpPlanSearch"></div>
			</form>
		</div>
		<div id="tagContent1" style="display: none;">
			<div class="toolbar">
				 <a id="returnToList"><b class="fanhui">返回</b></a>
			     <a id="conclusionAdd"><b class="xinz">新增</b></a>
			     <a id="conclusionSave" ><b class="baocun">保存</b></a>
		    </div>	    
		    <form id="followUpConclusionForm" method="post">
		    	 <input type="hidden" id="personId" name="personId" value="${personIdAndIdcard.personId}"/>
			     <input type="hidden" id="idcard" name="idcard" value="${personIdAndIdcard.idcard}"/>
				 <div id="followUpConclusionSearch"></div>
			</form>
		</div>
	</div> --%>
	
<div class="layui-tab layui-tab-card" lay-filter="cdmFollowUp" style="width: 98%;margin-left: 8px;">
  <ul class="layui-tab-title">
    <li class="layui-this">随访记录</li>
    <li>管理评定</li>
  </ul>
  <div class="layui-tab-content">
    <div class="layui-tab-item layui-show"  style="height: 372px;">
    	<div class="toolbar" style="margin-top: -10px;">
				 <%-- <a id="returnButton"><b class="fanhui">返回</b></a> --%>
				 <a id="returnButton" ><button class="btn-gray layui-btn layui-btn-sm button"><i class="layui-icon">&#xe65c;</i>返回</button></a>
			    <%--  <a id="followUpSave" ><b class="baocun">保存</b></a> --%>
			     <a id="followUpSave" ><button class="layui-btn layui-btn-sm button"><i class="layui-icon">&#xe605;</i>保存</button></a>
		    </div>
			<form id="followUpPlanForm" method="post">
				<input type="hidden" id="personId" name="personId" value="${personIdAndIdcard.personId}"/>
			    <input type="hidden" id="idcard" name="idcard" value="${personIdAndIdcard.idcard}"/>
			    <input type="hidden" id="followupId" value="">
			    <div id="followUpPlanSearch"></div>
			</form>
    </div>
    <div class="layui-tab-item" style="height: 372px;">
    	<div class="toolbar" style="margin-top: -10px;">
				 <%-- <a id="returnToList"><b class="fanhui">返回</b></a> --%>
				 <a id="returnToList" ><button class="btn-gray layui-btn layui-btn-sm button"><i class="layui-icon">&#xe65c;</i>返回</button></a>
			     <%-- <a id="conclusionAdd"><b class="xinz">新增</b></a> --%>
			     <a id="conclusionAdd"><button class="layui-btn layui-btn-sm button"><i class="layui-icon">&#xe608;</i>新增</button></a>
			    <%--  <a id="conclusionSave" ><b class="baocun">保存</b></a> --%>
			     <a id="conclusionSave" ><button class="layui-btn layui-btn-sm button"><i class="layui-icon">&#xe605;</i>保存</button></a>
		    </div>	    
		    <form id="followUpConclusionForm" method="post">
		    	 <input type="hidden" id="personId" name="personId" value="${personIdAndIdcard.personId}"/>
			     <input type="hidden" id="idcard" name="idcard" value="${personIdAndIdcard.idcard}"/>
				 <div id="followUpConclusionSearch"></div>
			</form>
    </div>
  </div>
</div>

</div>
<div id="loadManagePlan" style="display: none"></div>
<script>
//注意：选项卡 依赖 element 模块，否则无法进行功能性操作
layui.use('element', function(){
  var element = layui.element;

});
</script>