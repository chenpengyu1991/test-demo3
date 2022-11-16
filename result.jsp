<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/views/ech/manage/report.js"></script>
<div>
	<c:if test="${fromType ne 'calc'}">
		<div class="toolbar">
				<a href="javascript:void(0)" id="ech-phyexam-res-back-btn"><b class="fanhui">返回</b></a>
		</div>
	</c:if>
	<div class="postcontent">
		<i class="popno">测评结果</i>	
		<table class="posttable">
			<colgroup>
			     <col style="min-width: 120px; width: 25%;"/>
			     <col style="min-width: 400px; width: 75%;"/>
			</colgroup>
			<tbody>
		     	<tr>
		     		<th class="rightth"><b>您的体质主要是:</b></th>
		     		<td class="lefttd">
		     			<c:if test="${report.qiFlag == '1'}"> <a href="javascript:void(0)" onclick="javascript:echReport.printHealthEducation(2)"><b>气虚质</b></a></c:if>
		     			<c:if test="${report.yangFlag=='1'}"> <a href="javascript:void(0)" onclick="javascript:echReport.printHealthEducation(3)"><b>阳虚质</b></a></c:if>
		     			<c:if test="${report.yinDeficiencyFlag =='1'}"> <a href="javascript:void(0)" onclick="javascript:echReport.printHealthEducation(4)"><b>阴虚质</b></a></c:if>
		     			<c:if test="${report.phlegmWetnessFlag=='1'}"> <a href="javascript:void(0)" onclick="javascript:echReport.printHealthEducation(5)"><b>痰湿质</b></a></c:if>
		     			<c:if test="${report.heatMediumFlag=='1'}"> <a href="javascript:void(0)" onclick="javascript:echReport.printHealthEducation(6)"><b>湿热质</b></a></c:if>
		     			<c:if test="${report.bloodFlag=='1'}"> <a href="javascript:void(0)" onclick="javascript:echReport.printHealthEducation(7)"><b>血瘀质</b></a></c:if>
		     			<c:if test="${report.qiStagnationFlag=='1'}"> <a href="javascript:void(0)" onclick="javascript:echReport.printHealthEducation(8)"><b>气郁质</b></a></c:if>
		     			<c:if test="${report.specialFlag=='1'}"> <a href="javascript:void(0)" onclick="javascript:echReport.printHealthEducation(9)"><b>特禀质</b></a></c:if>
		     			<c:if test="${report.peacefulFlag=='1'}"> <a href="javascript:void(0)" onclick="javascript:echReport.printHealthEducation(1)"><b>平和质</b></a></c:if>
		     		</td>
		        </tr>
		     	<tr>
		     		<th class="rightth"><b>您的体质倾向是:</b></th>
		     		<td class="lefttd">
		     			<c:if test="${report.qiFlag == '3'}"> <a href="javascript:void(0)" onclick="javascript:echReport.printHealthEducation(2)"><b>气虚质</b></a></c:if>
		     			<c:if test="${report.yangFlag == '3'}"> <a href="javascript:void(0)" onclick="javascript:echReport.printHealthEducation(3)"><b>阳虚质</b></a></c:if>
		     			<c:if test="${report.yinDeficiencyFlag == '3'}"> <a href="javascript:void(0)" onclick="javascript:echReport.printHealthEducation(4)"><b>阴虚质</b></a></c:if>
		     			<c:if test="${report.phlegmWetnessFlag == '3'}"> <a href="javascript:void(0)" onclick="javascript:echReport.printHealthEducation(5)"><b>痰湿质</b></a></c:if>
		     			<c:if test="${report.heatMediumFlag == '3'}"> <a href="javascript:void(0)" onclick="javascript:echReport.printHealthEducation(6)"><b>湿热质</b></a></c:if>
		     			<c:if test="${report.bloodFlag == '3'}"> <a href="javascript:void(0)" onclick="javascript:echReport.printHealthEducation(7)"><b>血瘀质</b></a></c:if>
		     			<c:if test="${report.qiStagnationFlag == '3'}"> <a href="javascript:void(0)" onclick="javascript:echReport.printHealthEducation(8)"><b>气郁质</b></a></c:if>
		     			<c:if test="${report.specialFlag == '3'}"> <a href="javascript:void(0)" onclick="javascript:echReport.printHealthEducation(9)"><b>特禀质</b></a></c:if>
		     		</td>
		        </tr>
		     	<tr>
		     		<th class="rightth"><b>您的体质基本是:</b></th>
		     		<td class="lefttd">
		     			<c:if test="${report.peacefulFlag == '2'}"> <a href="javascript:void(0)" onclick="javascript:echReport.printHealthEducation(1)"><b>平和质</b></a></c:if>
		     		</td>
		        </tr>
			</tbody>
		</table>						
	</div>
</div>

