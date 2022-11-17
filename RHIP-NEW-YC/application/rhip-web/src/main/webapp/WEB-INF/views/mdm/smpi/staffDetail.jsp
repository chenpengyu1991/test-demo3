<%@ page language="java" pageEncoding="UTF-8"
         contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="ehr" uri="/ehr-tag" %>
<script type="text/javascript">
	$(function() {
		staffDetail.setStaffCode('${staff.staffCode}');
		staffDetail.atStart();
	});
</script>
<div style="padding: 5px;text-align: left;" >
	<%-- <ul id="tags">
		<li class=selectTag><a id="tab1" href="javascript:void(0)">基本信息</a></li>
		<li><a id="tab2" href="javascript:void(0)">记录跟踪</a></li>
		<!-- <li><a id="tab3" href="javascript:void(0)">科研著作</a></li> -->
        <input type="hidden" id="idCardForSr" value="${idCardForSr}">
        <input type="hidden" id="onlyViewForSr" value="${onlyView}">
	</ul>
	<div class="header" style="background-color: #F6FCFF">
		<div id="tab1" class="tab_t link">基本信息</div>
		<div id="tab2" class="tab_t">记录跟踪</div>
	</div>
	<div id="tagContent">
		<div id="tagContent0" style="display: block">
			<div class="titlebar" style="margin-top: 10px;">
				<div class="title">人员职业信息</div>
				<div class="toobar"></div>
			</div>
			<table class="formtable">
				<tr>
					<th width="150px">人员主索引</th>
					<td>${staff.smpiId}</td>
				</tr>
				<tr>
					<th width="150px">所在机构</th>
					<td>${staff.organCode}</td>
				</tr>
				<tr>
					<th width="150px">所在科室</th>
					<td>${staff.deptCode}</td>
				</tr>
				<tr>
					<th width="150px">系统本地标识</th>
					<td>${staff.localId}</td>
				</tr>
				<tiles:insertAttribute name="staffCareerInfo"/>
			</table>
			<tiles:insertAttribute name="staffBasicInfo"/>
		</div>
		<div id="tagContent1" style="display: none">
			<div id="logListDiv"></div>
		</div>
        <div id="tagContent2" style="display: none">
            <div id="srDiv"></div>
        </div>
	</div> --%>
	
<div class="layui-tab layui-tab-card" lay-filter="staffInfo"  style="height: 550px;overflow: auto;">
  <ul class="layui-tab-title">
    <li class="layui-this">基本信息</li>
    <li>记录跟踪</li>
    <input type="hidden" id="idCardForSr" value="${idCardForSr}">
    <input type="hidden" id="onlyViewForSr" value="${onlyView}">
  </ul>
  <div class="layui-tab-content">
    <div class="layui-tab-item layui-show" >
    	<div class="titlebar" style="margin-top: 10px;">
				<div class="title">人员职业信息</div>
				<div class="toobar"></div>
			</div>
			<table class="formtable">
				<tr>
					<th width="150px">人员主索引</th>
					<td>${staff.smpiId}</td>
				</tr>
				<tr>
					<th width="150px">所在机构</th>
					<td>${staff.organCode}</td>
				</tr>
				<tr>
					<th width="150px">所在科室</th>
					<td>${staff.deptCode}</td>
				</tr>
				<tr>
					<th width="150px">系统本地标识</th>
					<td>${staff.localId}</td>
				</tr>
				<tiles:insertAttribute name="staffCareerInfo"/>
			</table>
			<tiles:insertAttribute name="staffBasicInfo"/>
    </div>
    <div class="layui-tab-item" >
    	<div id="logListDiv"></div>
    </div>
    <!-- <div class="layui-tab-item" >
    	<div id="srDiv"></div>
    </div> -->
  </div>
</div>
</div>