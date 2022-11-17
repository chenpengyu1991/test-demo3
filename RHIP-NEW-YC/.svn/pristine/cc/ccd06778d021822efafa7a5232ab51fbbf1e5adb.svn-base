<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="ehr" uri="/ehr-tag" %>
<script type="text/javascript">
	$(function() {
		personDetail.setPersonId(${person.personId});
		personDetail.atStart();
	});
	//注意：选项卡 依赖 element 模块，否则无法进行功能性操作
	layui.use('element', function(){
	  var element = layui.element;
		//一些事件监听
	  element.on('tab(personBasic)', function(data){
	      if (data.index == 0) {
	    	  $("#person_div").show();
			  $("#log_div").hide();
	      } else if(data.index == 1) {
	    	  $("#person_div").hide();
			  $("#log_div").show();
	      }
	  });
	});
</script>
<div class="layui-tab layui-tab-card" lay-filter="personBasic" id="basic_content_div" style="height: 543px; overflow: auto;">
	<ul class="layui-tab-title">
	    <li class="layui-this">基本信息</li>
	    <li>记录跟踪</li>
	  </ul>
	  <div class="layui-tab-content">
	    <div class="layui-tab-item layui-show" id="person_div"> 
	    	<div class="titlebar" style="margin-top: 10px;">
				<div class="title">个人系统信息</div>
				<div class="toobar"></div>
			</div>
			<table class="formtable">
				<tr>
					<th width="150px">个人主索引</th>
					<td>${person.pmpiId}</td>
				</tr>
				<tr>
					<th width="150px">系统域标识</th>
					<td><ehr:dic dicmeta="GBT226112003" code="${person.domainId}"/>${person.domainId}</td>
				</tr>
				<tr>
					<th width="150px">本地系统标识</th>
					<td>${person.localId}</td>
				</tr>
			</table>
			<tiles:insertAttribute name="personBasicInfo"/>
	    </div>
	    <div class="layui-tab-item" id="log_div" >
	    	<div id="logListDiv"></div>
	    </div>
	  </div>
	<%--
	<div class="header" style="background-color: #F6FCFF">
		<div id="tab1" class="tab_t link">基本信息</div>
		<div id="tab2" class="tab_t">记录跟踪</div>
	</div>
	 --%>
	<%-- <div id="tagContent">
		<div id="tagContent0" style="display: block">
			<div class="titlebar" style="margin-top: 10px;">
				<div class="title">个人系统信息</div>
				<div class="toobar"></div>
			</div>
			<table class="formtable">
				<tr>
					<th width="150px">个人主索引</th>
					<td>${person.pmpiId}</td>
				</tr>
				<tr>
					<th width="150px">系统域标识</th>
					<td><ehr:dic dicmeta="GBT226112003" code="${person.domainId}"/>${person.domainId}</td>
				</tr>
				<tr>
					<th width="150px">本地系统标识</th>
					<td>${person.localId}</td>
				</tr>
			</table>
			<tiles:insertAttribute name="personBasicInfo"/>
		</div>
		<div id="tagContent1" style="display: none">
			<div id="logListDiv"></div>
		</div>
	</div> --%>
</div>
