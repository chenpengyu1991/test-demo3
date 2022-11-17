<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<script src="${pageContext.request.contextPath}/js/views/vaccine/numSet/appointmentNumInfo.js" type="text/javascript"></script>
<div id="list_view">
	<div class="section">
		<div class="toolbar" align="right">		     
	        <span id="modifyCommunityIdSpan" style="padding-left: 25px;">
	           		<a href="javascript:void(0)" id="modifyCommunityId" ><b class="xiug">修改</b></a>
	       	</span>
	       	<span id="cancelCommunityIdSpan" style="padding-left: 25px;">
	          		<a href="javascript:void(0)" id="cancelCommunityId" ><b class="zhux">取消</b></a>&nbsp;&nbsp;&nbsp;
	           		<a href="javascript:void(0)" id="saveCommunityId" ><b class="baocun">保存</b></a>
	      	</span>
		</div>
		<div class="searchbox">	
			<form id="InoculationAppointmentParamSearchForm" name="" action="" method="post">
				<table id="reportSearch">
					<colgroup>
							<col style="width: 5%" />
							<col style="width: 25%" />
							<col style="width: 25%" />
							<col style="width: 45%" />
					</colgroup>
					<tr>
						<td></td>
						<td class="colinput">选择年份：
							<input id="countYear" name="countYear" type="text" onfocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy'})"
							 maxlength="10" style="width:150px" value="${defaultYear}"/>年
						</td>
						<td class="col-input" >预约机构：
							<ehr:org-type-list  name="orgCode" type="centre,hospital"   width="150px"/>
						</td>
						<td><input type="button" id="numSetSearch" value="查询" class="search_btn" ></td>
					</tr>
				</table>
			
				<table>
					<tr>
						<td colspan="4" class="colbottom"><span
								onclick="appointmentNumSetUp.toggle(this,'reportSearch')"
								class="ico-bottom">&nbsp;</span></td>
					</tr>
				</table>
			</form>
		</div>
		<div id="appointmentNum_result"></div>
	</div>
</div>

