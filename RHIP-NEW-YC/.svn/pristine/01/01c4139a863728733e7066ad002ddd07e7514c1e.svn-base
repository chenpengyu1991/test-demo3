<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<jsp:include page="../../layouts/load-js-css-resources.jsp"></jsp:include>

<script src="${pageContext.request.contextPath}/js/views/cdm/highRisk/highRiskPersonInfo.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/cdm/highRisk/preventiveManage.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/cdm/highRisk135/question/search.js" type="text/javascript"></script>

<div id="list_view">
	<div class="section">
		<div class="toolbar" align="right">
			<div class="x-nav">
		      <span class="layui-breadcrumb">
		        <a href="javascript:void(0)">慢病健康管理</a>
		        <a href="javascript:void(0)">危险因素</a>
		        <a>
		          <cite>管理首页</cite></a>
		      </span>
		</div>
		</div>
		<div class="searchbox searchSection x-admin-sm">	
			<form id="searchHighRiskInfo" name="" action="" method="post">
				<table id="highRiskSearch">
					<colgroup>
						<col style="min-width:70px; width: 10%;"/>
						<col style="min-width:150px; width: 20%;"/>
	                    <col style="min-width:70px; width: 10%;"/>
						<col style="min-width:150px; width: 20%;"/>
	                    <col style="min-width:70px; width: 10%;"/>
						<col style="min-width:150px; width: 20%;"/>
				    </colgroup>		
					<tbody>				
					   <tr>
							<td class="coltext">姓名
							</td>
							<td class="colinput">
								<input type="text" id="name" name="name" class="x-layui-input" style="width: 80%;"/>
							</td>
							<td class="coltext">身份证号</td>		
							<td class="colinput">
								<input type="text" id="idcard" name="idcard" class="x-layui-input" style="width: 80%;">
								<input type="button" id="check-submit-btn" value="读卡" style="width: 40px;">
							 </td>		
							<td class="coltext">性别</td>
								<td class="colinput">
								<ehr:dic-list dicmeta="GBT226112003" name="gender"/>
							</td>
						</tr>	
						<tr>
							<td class="coltext">年龄段</td>
							<td class="colinput">
								<tag:numberInput name="beginAge" id="beginAge" style="width: 37%;" cssClass="x-layui-input"/> ~ 
								<tag:numberInput name="endAge" id="endAge" style="width: 37%;" cssClass="x-layui-input"/>
							</td>
							<td class="coltext">危险等级</td>
							<td class="colinput">
								<ehr:dic-list dicmeta="DMD00011" name="searchRiskLevel" id="searchRiskLevel" cssClass="x-layui-input"/>											
							</td>
							<td></td>														
							<td class="colinput">
								<%-- <input type="button" id="searchHighRiskPersonInfo" value="查询" class="search_btn" > --%>
								<button class="layui-btn layui-btn-sm" id="searchHighRiskPersonInfo"><i class="layui-icon">&#xe615;</i>查询</button>
							</td>
						</tr>
					</tbody>
				</table>
				<table>
	                <tr>
	                    <td colspan="6" class="colbottom">
	                          <span id ="highRiskPersonInfo"  class="ico-bottom">&nbsp;</span>
	                    </td>
	                </tr>
				</table>
			</form>
		</div>
		<div id="HighRiskInfo_view"></div>
	</div>
</div>
<div id="factorsInfo_view" style="display: none">
</div>