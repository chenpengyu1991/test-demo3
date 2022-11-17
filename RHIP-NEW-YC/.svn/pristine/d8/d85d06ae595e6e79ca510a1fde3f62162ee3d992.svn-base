<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<script src="${pageContext.request.contextPath}/js/views/reserve/search.js" type="text/javascript"></script>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/views/info/interaction.css"/>

<div class="navRight">
	<div class="contentlist">
		  <div class="location">
		  	当前位置:<label>预约挂号</label>&gt;&gt;<label>我的预约</label>
		  </div>
		  <div class="searchInteraction" id="searchInteractionDivId">
		  	<form id="reserveSearch" method="post" style="padding:10px;">
	        <table id="interactionSearch">
	          <tr>
	          	<td class="coltd">就诊时间:</td>
	            <td style="width:280px;">
	            	<tag:dateInput name="requestDateBegin" id="requestDateBegin" style="width:35%;"></tag:dateInput>~
					<tag:dateInput name="requestDateEnd" id="requestDateEnd" style="width:35%;"></tag:dateInput>
	            </td>
	            <td class="coltd">就诊者:</td>
	            <td style="width:150px;">
	                <select name="frequentName" >
					  <option value="">全部</option>
					  <option value="${accountInfo.realName }">${accountInfo.realName }</option>
					  <c:forEach items="${frequentContactsLists }" var="options">
					  		<option value="${options.frequentName }">${options.frequentName }</option>
					  </c:forEach>
					</select>
	            </td>
	            <td class="coltd">状态:</td>
	            <td style="width:160px;">
	                <select name="reserveStauts" >
					  <option value="">全部</option>
					  <option value="01"><tag:reserveStauts stauts="01"></tag:reserveStauts></option>
					  <option value="02"><tag:reserveStauts stauts="02"></tag:reserveStauts></option>
					  <option value="03"><tag:reserveStauts stauts="03"></tag:reserveStauts></option>
					  <option value="04"><tag:reserveStauts stauts="04"></tag:reserveStauts></option>
					  <option value="05"><tag:reserveStauts stauts="05"></tag:reserveStauts></option>
					</select>
	            </td>
	            <td style="width:80px;">
	            	<input id="reserveSearchBtn" class="search_btn" type="button" value="查询"/>
	            </td>
	          </tr>
	        </table>
	        </form>
	    </div>
		<div id="listDiv"></div>
	</div>
</div>
