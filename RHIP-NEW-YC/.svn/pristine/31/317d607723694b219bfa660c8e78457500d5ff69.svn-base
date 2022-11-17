<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<script src="${pageContext.request.contextPath}/js/views/cdm/populaceSet/populaceInfo.js" type="text/javascript"></script>

<div id="list_view">
	<div class="section">
		<div class="toolbar" align="right">		     
	        <span id="modifyCommunityIdSpan" style="padding-left: 25px;">
	           	<%-- <a href="javascript:void(0)" id="modifyCommunityId" ><b class="xiug">修改</b></a> --%>
	           	<a href="javascript:void(0)" id="modifyCommunityId" title="修改"><button class="layui-btn layui-btn-sm button"><i class="layui-icon">&#xe642;</i>修改</button></a>
	       	</span>
	       	<span id="cancelCommunityIdSpan" style="padding-left: 25px;">
	          	<%-- <a href="javascript:void(0)" id="cancelCommunityId" ><b class="zhux">取消</b></a> --%>
	          	<a href="javascript:void(0)" id="cancelCommunityId" title="取消"><button class="layui-btn layui-btn-sm button"><i class="layui-icon">&#xe65c;</i>取消</button></a>
	          	&nbsp;&nbsp;&nbsp;
	           	<%-- <a href="javascript:void(0)" id="saveCommunityId" ><b class="baocun">保存</b></a> --%>
	           	<a href="javascript:void(0)" id="saveCommunityId"  ><button class="layui-btn layui-btn-sm button"><i class="layui-icon">&#xe605;</i>保存</button></a>
	      	</span>
		</div>
		<div class="searchbox">	
			<form id="popularForm" name="" action="" method="post">
				<table id="reportSearch">
					<colgroup>
							<col style="width: 5%" />
							<col style="width: 25%" />
							<col style="width: 70%" />
					</colgroup>
					<tr>
						<td></td>
						<td class="colinput">选择年份：
							<input id="countYear" name="countYear" type="text" onfocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy'})"
							 maxlength="10" readonly="true" style="width:178px" value="${defaultYear}"/>年
						</td>
						<td><input type="button" id="popularSetSearch" value="查询" class="search_btn" ></td>
					</tr>
				</table>
				<table>
		               <tr>
		                   <td colspan="6" class="colbottom">
		                         <span id ="populationSetupResult" class="ico-bottom">&nbsp;</span>
		                   </td>
		               </tr>
				</table>
			</form>
		</div>
		<div id="population_result"></div>
	</div>
</div>

