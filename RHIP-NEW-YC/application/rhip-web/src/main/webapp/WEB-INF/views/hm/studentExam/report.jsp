<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<script src="${pageContext.request.contextPath}/js/views/hm/studentExam/report.js" type="text/javascript"></script>
<style type="text/css">
<!--
.hmStudentExamReportout
{  
	border-top:45px #E6F0FF solid;/*上边框宽度等于表格第一行行高*/  
	width:0px;/*让容器宽度为0*/  
	height:0px;/*让容器高度为0*/  
	border-left:198px #D6E3F4 solid;/*左边框宽度等于表格第一行第一格宽度*/  
	position:relative;/*让里面的两个子容器绝对定位*/ 
}
.hmStudentExamReportout span
{
	font-style:normal;
	display:block;  
	position:absolute;
	top:-40px;  
	left:-40px;
	width:35px;
}  
.hmStudentExamReportout em
{
	font-style:normal;
	display:block;  
	position:absolute;
	top:-25px;
	left:-190px;
	width:75px;
}
.hmStudentExamReporttable {
	float: left;
	/*width: auto;*/
}
-->
</style>
<div class="repeattable">
	<table class="hmStudentExamReporttable" id="hm_studentExam_report">
		<colgroup>
			<col style="width: 90px;" />
			<col style="width: 90px;" />
			<col style="width:70px;" />
			<col style="width:70px;" />
			<col style="width:70px;" />
			<c:forEach var="data" items="${reportData.datas}">
				<col style="width:70px;" />
				<col style="width:70px;" />
				<col style="width:70px;" />
			</c:forEach>
			
		</colgroup>
		<caption><b>${examYear}年 市学生健康检查汇总报告</b></caption>
		<thead>
			<tr>
				<th colspan="2" rowspan="2">
				检查项目
				<%--
					<div class="hmStudentExamReportout"> 
						<span></span> 
						<em>检查项目</em> 
					</div> 
				 --%>
				</th>
				<th colspan="3">总计</th>
				<c:forEach var="data" items="${reportData.datas}">
					<th colspan="3"><label class="text_tip_span" name="gradeName" school="${data.school}" grade="${data.grade}"></label></th>
				</c:forEach>
				
			</tr>
			<tr>
				<th>男</th>
				<th>女</th>
				<th>总计</th>
				<c:forEach var="data" items="${reportData.datas}">
					<th>男</th>
					<th>女</th>
					<th>合计</th>
				</c:forEach>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td colspan="2">体检人数</td>
				<td align="right">${reportData.examNumberMale}</td>	
				<td align="right">${reportData.examNumberFeMale}</td>	
				<td align="right">${reportData.examNumber}</td>				
				<c:forEach var="data" items="${reportData.datas}">
					<c:forEach var="item" items="${data.datas}">
						<td align="right">${item.examNumber}</td>
					</c:forEach>
					<td align="right">${data.examNumber}</td>
				</c:forEach>
			</tr>
			<tr>
				<td rowspan="2">正常</td>
				<td>人数</td>
				<td align="right">${reportData.normalNumberMale}</td>
				<td align="right">${reportData.normalNumberFeMale}</td>
				<td align="right">${reportData.normalNumber}</td>				
				<c:forEach var="data" items="${reportData.datas}">
					<c:forEach var="item" items="${data.datas}">
						<td align="right">${item.normalNumber}</td>
					</c:forEach>
					<td align="right">${data.normalNumber}</td>
				</c:forEach>
			</tr>
			<tr>
				<td>率（%）</td>
				<td><tag:numberLabel value="${reportData.normalPercentMale*100}"  fractionDigits="2" /></td>
				<td><tag:numberLabel value="${reportData.normalPercentFeMale*100}"  fractionDigits="2" /></td>
				<td><tag:numberLabel value="${reportData.normalPercent*100}"  fractionDigits="2" /></td>
				<c:forEach var="data" items="${reportData.datas}">
					<c:forEach var="item" items="${data.datas}">
						<td><tag:numberLabel value="${item.normalPercent*100}"  fractionDigits="2" /></td>
					</c:forEach>
					<td><tag:numberLabel value="${data.normalPercent*100}"  fractionDigits="2" /></td>
				</c:forEach>
			</tr>
			<tr>
				<td rowspan="12">营养状况</td>
				<td>超重</td>
				<td align="right">${reportData.overweightNumberMale}</td>
				<td align="right">${reportData.overweightNumberFeMale}</td>
				<td align="right">${reportData.overweightNumber}</td>					
				<c:forEach var="data" items="${reportData.datas}">
					<c:forEach var="item" items="${data.datas}">
						<td align="right">${item.overweightNumber}</td>
					</c:forEach>
					<td align="right">${data.overweightNumber}</td>
				</c:forEach>
				
			</tr>
			<tr>
				<td>率（%）</td>
				<td><tag:numberLabel value="${reportData.overweightPercentMale*100}"  fractionDigits="2" /></td>
				<td><tag:numberLabel value="${reportData.overweightPercentFeMale*100}"  fractionDigits="2" /></td>
				<td><tag:numberLabel value="${reportData.overweightPercent*100}"  fractionDigits="2" /></td>				
				<c:forEach var="data" items="${reportData.datas}">
					<c:forEach var="item" items="${data.datas}">
						<td><tag:numberLabel value="${item.overweightPercent*100}"  fractionDigits="2" /></td>
					</c:forEach>
					<td><tag:numberLabel value="${data.overweightPercent*100}"  fractionDigits="2" /></td>
				</c:forEach>
				
			</tr>
			<tr>
				<td>肥胖</td>
				<td align="right">${reportData.obesityNumberMale}</td>
				<td align="right">${reportData.obesityNumberFeMale}</td>
				<td align="right">${reportData.obesityNumber}</td>
				<c:forEach var="data" items="${reportData.datas}">
					<c:forEach var="item" items="${data.datas}">
						<td align="right">${item.obesityNumber}</td>
					</c:forEach>
					<td align="right">${data.obesityNumber}</td>
				</c:forEach>
			</tr>
			<tr>
				<td>率（%）</td>
				<td><tag:numberLabel value="${reportData.obesityPercentMale*100}"  fractionDigits="2" /></td>
				<td><tag:numberLabel value="${reportData.obesityPercentFeMale*100}"  fractionDigits="2" /></td>
				<td><tag:numberLabel value="${reportData.obesityPercent*100}"  fractionDigits="2" /></td>
				<c:forEach var="data" items="${reportData.datas}">
					<c:forEach var="item" items="${data.datas}">
						<td><tag:numberLabel value="${item.obesityPercent*100}"  fractionDigits="2" /></td>
					</c:forEach>
					<td><tag:numberLabel value="${data.obesityPercent*100}"  fractionDigits="2" /></td>
				</c:forEach>
				
			</tr>
			<tr>
				<td>生长迟缓</td>
				
				<td align="right">${reportData.slowGrowthNumberMale}</td>
				<td align="right">${reportData.slowGrowthNumberFeMale}</td>
				<td align="right">${reportData.slowGrowthNumber}</td>
				<c:forEach var="data" items="${reportData.datas}">
					<c:forEach var="item" items="${data.datas}">
						<td align="right">${item.slowGrowthNumber}</td>
					</c:forEach>
					<td align="right">${data.slowGrowthNumber}</td>
				</c:forEach>
				
			</tr>
			<tr>
				<td>率（%）</td>
				
				<td><tag:numberLabel value="${reportData.slowGrowthPercentMale*100}"  fractionDigits="2" /></td>
				<td><tag:numberLabel value="${reportData.slowGrowthPercentFeMale*100}"  fractionDigits="2" /></td>
				<td><tag:numberLabel value="${reportData.slowGrowthPercent*100}"  fractionDigits="2" /></td>
				<c:forEach var="data" items="${reportData.datas}">
					<c:forEach var="item" items="${data.datas}">
						<td><tag:numberLabel value="${item.slowGrowthPercent*100}"  fractionDigits="2" /></td>
					</c:forEach>
					<td><tag:numberLabel value="${data.slowGrowthPercent*100}"  fractionDigits="2" /></td>
				</c:forEach>
			</tr>
			<tr>
				<td>身材矮小</td>
				
				<td align="right">${reportData.smallNumberMale}</td>
				<td align="right">${reportData.smallNumberFeMale}</td>
				<td align="right">${reportData.smallNumber}</td>
				<c:forEach var="data" items="${reportData.datas}">
					<c:forEach var="item" items="${data.datas}">
						<td align="right">${item.smallNumber}</td>
					</c:forEach>
					<td align="right">${data.smallNumber}</td>
				</c:forEach>
			</tr>
			<tr>
				<td>率（%）</td>
				
				<td><tag:numberLabel value="${reportData.smallPercentMale*100}"  fractionDigits="2" /></td>
				<td><tag:numberLabel value="${reportData.smallPercentFeMale*100}"  fractionDigits="2" /></td>
				<td><tag:numberLabel value="${reportData.smallPercent*100}"  fractionDigits="2" /></td>
				<c:forEach var="data" items="${reportData.datas}">
					<c:forEach var="item" items="${data.datas}">
						<td><tag:numberLabel value="${item.smallPercent*100}"  fractionDigits="2" /></td>
					</c:forEach>
					<td><tag:numberLabel value="${data.smallPercent*100}"  fractionDigits="2" /></td>
				</c:forEach>
			</tr>
			<tr>
				<td>重中度消瘦</td>
				
				<td align="right">${reportData.moderateThinNumberMale}</td>
				<td align="right">${reportData.moderateThinNumberFeMale}</td>
				<td align="right">${reportData.moderateThinNumber}</td>
				<c:forEach var="data" items="${reportData.datas}">
					<c:forEach var="item" items="${data.datas}">
						<td align="right">${item.moderateThinNumber}</td>
					</c:forEach>
					<td align="right">${data.moderateThinNumber}</td>
				</c:forEach>
				
			</tr>
			<tr>
				<td>率（%）</td>
				
				<td><tag:numberLabel value="${reportData.moderateThinPercentMale*100}"  fractionDigits="2" /></td>
				<td><tag:numberLabel value="${reportData.moderateThinPercentFeMale*100}"  fractionDigits="2" /></td>
				<td><tag:numberLabel value="${reportData.moderateThinPercent*100}"  fractionDigits="2" /></td>
				<c:forEach var="data" items="${reportData.datas}">
					<c:forEach var="item" items="${data.datas}">
						<td><tag:numberLabel value="${item.moderateThinPercent*100}"  fractionDigits="2" /></td>
					</c:forEach>
					<td><tag:numberLabel value="${data.moderateThinPercent*100}"  fractionDigits="2" /></td>
				</c:forEach>
				
			</tr>
			<tr>
				<td>轻度消瘦</td>
				
				<td align="right">${reportData.mildThinNumberMale}</td>
				<td align="right">${reportData.mildThinNumberFeMale}</td>
				<td align="right">${reportData.mildThinNumber}</td>
				<c:forEach var="data" items="${reportData.datas}">
					<c:forEach var="item" items="${data.datas}">
						<td align="right">${item.mildThinNumber}</td>
					</c:forEach>
					<td align="right">${data.mildThinNumber}</td>
				</c:forEach>
				
			</tr>
			<tr>
				<td>率（%）</td>
				
				<td><tag:numberLabel value="${reportData.mildThinPercentMale*100}"  fractionDigits="2" /></td>
				<td><tag:numberLabel value="${reportData.mildThinPercentFeMale*100}"  fractionDigits="2" /></td>
				<td><tag:numberLabel value="${reportData.mildThinPercent*100}"  fractionDigits="2" /></td>
				<c:forEach var="data" items="${reportData.datas}">
					<c:forEach var="item" items="${data.datas}">
						<td><tag:numberLabel value="${item.mildThinPercent*100}"  fractionDigits="2" /></td>
					</c:forEach>
					<td><tag:numberLabel value="${data.mildThinPercent*100}"  fractionDigits="2" /></td>
				</c:forEach>
				
			</tr>
			<tr>
				<td rowspan="6">视力不良</td>
				<td>轻4.9</td>
				
				<td align="right">${reportData.mildPoorVisionNumberMale}</td>
				<td align="right">${reportData.mildPoorVisionNumberFeMale}</td>
				<td align="right">${reportData.mildPoorVisionNumber}</td>
				<c:forEach var="data" items="${reportData.datas}">
					<c:forEach var="item" items="${data.datas}">
						<td align="right">${item.mildPoorVisionNumber}</td>
					</c:forEach>
					<td align="right">${data.mildPoorVisionNumber}</td>
				</c:forEach>
				
			</tr>
			<tr>
				<td>率（%）</td>
				
				<td><tag:numberLabel value="${reportData.mildPoorVisionPercentMale*100}"  fractionDigits="2" /></td>
				<td><tag:numberLabel value="${reportData.mildPoorVisionPercentFeMale*100}"  fractionDigits="2" /></td>
				<td><tag:numberLabel value="${reportData.mildPoorVisionPercent*100}"  fractionDigits="2" /></td>
				<c:forEach var="data" items="${reportData.datas}">
					<c:forEach var="item" items="${data.datas}">
						<td><tag:numberLabel value="${item.mildPoorVisionPercent*100}"  fractionDigits="2" /></td>
					</c:forEach>
					<td><tag:numberLabel value="${data.mildPoorVisionPercent*100}"  fractionDigits="2" /></td>
				</c:forEach>
				
			</tr>
			<tr>
				<td>中4.8-4.6</td>
				
				<td align="right">${reportData.moderatePoorVisionNumberMale}</td>
				<td align="right">${reportData.moderatePoorVisionNumberFeMale}</td>
				<td align="right">${reportData.moderatePoorVisionNumber}</td>
				<c:forEach var="data" items="${reportData.datas}">
					<c:forEach var="item" items="${data.datas}">
						<td align="right">${item.moderatePoorVisionNumber}</td>
					</c:forEach>
					<td align="right">${data.moderatePoorVisionNumber}</td>
				</c:forEach>
				
			</tr>
			<tr>
				<td>率（%）</td>
				
				<td><tag:numberLabel value="${reportData.moderatePoorVisionPercentMale*100}"  fractionDigits="2" /></td>
				<td><tag:numberLabel value="${reportData.moderatePoorVisionPercentFeMale*100}"  fractionDigits="2" /></td>
				<td><tag:numberLabel value="${reportData.moderatePoorVisionPercent*100}"  fractionDigits="2" /></td>
				<c:forEach var="data" items="${reportData.datas}">
					<c:forEach var="item" items="${data.datas}">
						<td><tag:numberLabel value="${item.moderatePoorVisionPercent*100}"  fractionDigits="2" /></td>
					</c:forEach>
					<td><tag:numberLabel value="${data.moderatePoorVisionPercent*100}"  fractionDigits="2" /></td>
				</c:forEach>
				
			</tr>
			<tr>
				<td>重4.5以下</td>
				
				<td align="right">${reportData.severePoorVisionNumberMale}</td>
				<td align="right">${reportData.severePoorVisionNumberFeMale}</td>
				<td align="right">${reportData.severePoorVisionNumber}</td>
				<c:forEach var="data" items="${reportData.datas}">
					<c:forEach var="item" items="${data.datas}">
						<td align="right">${item.severePoorVisionNumber}</td>
					</c:forEach>
					<td align="right">${data.severePoorVisionNumber}</td>
				</c:forEach>
				
			</tr>
			<tr>
				<td>率（%）</td>
				
				<td><tag:numberLabel value="${reportData.severePoorVisionPercentMale*100}"  fractionDigits="2" /></td>
				<td><tag:numberLabel value="${reportData.severePoorVisionPercentFeMale*100}"  fractionDigits="2" /></td>
				<td><tag:numberLabel value="${reportData.severePoorVisionPercent*100}"  fractionDigits="2" /></td>
				<c:forEach var="data" items="${reportData.datas}">
					<c:forEach var="item" items="${data.datas}">
						<td><tag:numberLabel value="${item.severePoorVisionPercent*100}"  fractionDigits="2" /></td>
					</c:forEach>
					<td><tag:numberLabel value="${data.severePoorVisionPercent*100}"  fractionDigits="2" /></td>
				</c:forEach>
				
			</tr>
			<tr>
				<td rowspan="3">视力新发</td>
				<td>去年正常数</td>
				
				<td align="right">${reportData.normalVisionLastYearNumberMale}</td>
				<td align="right">${reportData.normalVisionLastYearNumberFeMale}</td>
				<td align="right">${reportData.normalVisionLastYearNumber}</td>
				<c:forEach var="data" items="${reportData.datas}">
					<c:forEach var="item" items="${data.datas}">
						<td align="right">${item.normalVisionLastYearNumber}</td>
					</c:forEach>
					<td align="right">${data.normalVisionLastYearNumber}</td>
				</c:forEach>
				
			</tr>
			<tr>
				<td>今年低下数</td>
				
				<td align="right">${reportData.newPoorVisionNumberMale}</td>
				<td align="right">${reportData.newPoorVisionNumberFeMale}</td>
				<td align="right">${reportData.newPoorVisionNumber}</td>
				<c:forEach var="data" items="${reportData.datas}">
					<c:forEach var="item" items="${data.datas}">
						<td align="right">${item.newPoorVisionNumber}</td>
					</c:forEach>
					<td align="right">${data.newPoorVisionNumber}</td>
				</c:forEach>
				
			</tr>
			<tr>
				<td>新发率（%）</td>
				
				<td><tag:numberLabel value="${reportData.newPoorVisionPercentMale*100}"  fractionDigits="2" /></td>
				<td><tag:numberLabel value="${reportData.newPoorVisionPercentFeMale*100}"  fractionDigits="2" /></td>
				<td><tag:numberLabel value="${reportData.newPoorVisionPercent*100}"  fractionDigits="2" /></td>
				<c:forEach var="data" items="${reportData.datas}">
					<c:forEach var="item" items="${data.datas}">
						<td><tag:numberLabel value="${item.newPoorVisionPercent*100}"  fractionDigits="2" /></td>
					</c:forEach>
					<td><tag:numberLabel value="${data.newPoorVisionPercent*100}"  fractionDigits="2" /></td>
				</c:forEach>
				
			</tr>
			<tr>
				<td rowspan="2">沙眼</td>
				<td>人数</td>
				
				<td align="right">${reportData.trachomaEyeNumberMale}</td>
				<td align="right">${reportData.trachomaEyeNumberFeMale}</td>
				<td align="right">${reportData.trachomaEyeNumber}</td>
				<c:forEach var="data" items="${reportData.datas}">
					<c:forEach var="item" items="${data.datas}">
						<td align="right">${item.trachomaEyeNumber}</td>
					</c:forEach>
					<td align="right">${data.trachomaEyeNumber}</td>
				</c:forEach>
				
			</tr>
			<tr>
				<td>率（%）</td>
				<td><tag:numberLabel value="${reportData.trachomaEyePercentMale*100}"  fractionDigits="2" /></td>
				<td><tag:numberLabel value="${reportData.trachomaEyePercentFeMale*100}"  fractionDigits="2" /></td>
				<td><tag:numberLabel value="${reportData.trachomaEyePercent*100}"  fractionDigits="2" /></td>
				<c:forEach var="data" items="${reportData.datas}">
					<c:forEach var="item" items="${data.datas}">
						<td><tag:numberLabel value="${item.trachomaEyePercent*100}"  fractionDigits="2" /></td>
					</c:forEach>
					<td><tag:numberLabel value="${data.trachomaEyePercent*100}"  fractionDigits="2" /></td>
				</c:forEach>
				
			</tr>
			<tr>
				<td rowspan="6">乳牙龋齿</td>
				<td>总龋齿人数R</td>
				<td align="right">${reportData.babyEurodonticusNumberMale}</td>
				<td align="right">${reportData.babyEurodonticusNumberFeMale}</td>
				<td align="right">${reportData.babyEurodonticusNumber}</td>
				<c:forEach var="data" items="${reportData.datas}">
					<c:forEach var="item" items="${data.datas}">
						<td align="right">${item.babyEurodonticusNumber}</td>
					</c:forEach>
					<td align="right">${data.babyEurodonticusNumber}</td>
				</c:forEach>
				
			</tr>
			<tr>
				<td>龋齿数</td>
				<td align="right">${reportData.babyDentalCariesNumberMale}</td>
				<td align="right">${reportData.babyDentalCariesNumberFeMale}</td>
				<td align="right">${reportData.babyDentalCariesNumber}</td>
				<c:forEach var="data" items="${reportData.datas}">
					<c:forEach var="item" items="${data.datas}">
						<td align="right">${item.babyDentalCariesNumber}</td>
					</c:forEach>
					<td align="right">${data.babyDentalCariesNumber}</td>
				</c:forEach>
				
			</tr>
			<tr>
				<td>龋补数</td>
				<td align="right">${reportData.babyCariesFillingNumberMale}</td>
				<td align="right">${reportData.babyCariesFillingNumberFeMale}</td>
				<td align="right">${reportData.babyCariesFillingNumber}</td>
				<c:forEach var="data" items="${reportData.datas}">
					<c:forEach var="item" items="${data.datas}">
						<td align="right">${item.babyCariesFillingNumber}</td>
					</c:forEach>
					<td align="right">${data.babyCariesFillingNumber}</td>
				</c:forEach>
				
			</tr>
			<tr>
				<td>龋齿率（%）</td>
				<td><tag:numberLabel value="${reportData.babyDentalCariesPercentMale*100}"  fractionDigits="2" /></td>
				<td><tag:numberLabel value="${reportData.babyDentalCariesPercentFeMale*100}"  fractionDigits="2" /></td>
				<td><tag:numberLabel value="${reportData.babyDentalCariesPercent*100}"  fractionDigits="2" /></td>
				<c:forEach var="data" items="${reportData.datas}">
					<c:forEach var="item" items="${data.datas}">
						<td><tag:numberLabel value="${item.babyDentalCariesPercent*100}"  fractionDigits="2" /></td>
					</c:forEach>
					<td><tag:numberLabel value="${data.babyDentalCariesPercent*100}"  fractionDigits="2" /></td>
				</c:forEach>
				
			</tr>
			<tr>
				<td>龋补率（%）</td>
				<td><tag:numberLabel value="${reportData.babyCariesFillingPercentMale*100}"  fractionDigits="2" /></td>
				<td><tag:numberLabel value="${reportData.babyCariesFillingPercentFeMale*100}"  fractionDigits="2" /></td>
				<td><tag:numberLabel value="${reportData.babyCariesFillingPercent*100}"  fractionDigits="2" /></td>
				<c:forEach var="data" items="${reportData.datas}">
					<c:forEach var="item" items="${data.datas}">
						<td><tag:numberLabel value="${item.babyCariesFillingPercent*100}"  fractionDigits="2" /></td>
					</c:forEach>
					<td><tag:numberLabel value="${data.babyCariesFillingPercent*100}"  fractionDigits="2" /></td>
				</c:forEach>
				
			</tr>
			<tr>
				<td>龋均</td>
				<td><tag:numberLabel value="${reportData.babyDentalCariesAverageMale}" /></td>
				<td><tag:numberLabel value="${reportData.babyDentalCariesAverageFeMale}" /></td>
				<td><tag:numberLabel value="${reportData.babyDentalCariesAverage}" /></td>
				<c:forEach var="data" items="${reportData.datas}">
					<c:forEach var="item" items="${data.datas}">
						<td><tag:numberLabel value="${item.babyDentalCariesAverage}" /></td>
					</c:forEach>
					<td><tag:numberLabel value="${data.babyDentalCariesAverage}" /></td>
				</c:forEach>
				
			</tr>
			<tr>
				<td rowspan="6">恒牙龋齿</td>
				<td>总龋齿人数R</td>
				<td align="right">${reportData.permanentEurodonticusNumberMale}</td>
				<td align="right">${reportData.permanentEurodonticusNumberFeMale}</td>
				<td align="right">${reportData.permanentEurodonticusNumber}</td>
				<c:forEach var="data" items="${reportData.datas}">
					<c:forEach var="item" items="${data.datas}">
						<td align="right">${item.permanentEurodonticusNumber}</td>
					</c:forEach>
					<td align="right">${data.permanentEurodonticusNumber}</td>
				</c:forEach>
				
			</tr>
			<tr>
				<td>龋齿数</td>
				<td align="right">${reportData.permanentDentalCariesNumberMale}</td>
				<td align="right">${reportData.permanentDentalCariesNumberFeMale}</td>
				<td align="right">${reportData.permanentDentalCariesNumber}</td>
				<c:forEach var="data" items="${reportData.datas}">
					<c:forEach var="item" items="${data.datas}">
						<td align="right">${item.permanentDentalCariesNumber}</td>
					</c:forEach>
					<td align="right">${data.permanentDentalCariesNumber}</td>
				</c:forEach>
				
			</tr>
			<tr>
				<td>龋补数</td>
				<td align="right">${reportData.permanentCariesFillingNumberMale}</td>
				<td align="right">${reportData.permanentCariesFillingNumberFeMale}</td>
				<td align="right">${reportData.permanentCariesFillingNumber}</td>
				<c:forEach var="data" items="${reportData.datas}">
					<c:forEach var="item" items="${data.datas}">
						<td align="right">${item.permanentCariesFillingNumber}</td>
					</c:forEach>
					<td align="right">${data.permanentCariesFillingNumber}</td>
				</c:forEach>
				
			</tr>
			<tr>
				<td>龋齿率（%）</td>
				<td><tag:numberLabel value="${reportData.permanentDentalCariesPercentMale*100}"  fractionDigits="2" /></td>
				<td><tag:numberLabel value="${reportData.permanentDentalCariesPercentFeMale*100}"  fractionDigits="2" /></td>
				<td><tag:numberLabel value="${reportData.permanentDentalCariesPercent*100}"  fractionDigits="2" /></td>
				<c:forEach var="data" items="${reportData.datas}">
					<c:forEach var="item" items="${data.datas}">
						<td><tag:numberLabel value="${item.permanentDentalCariesPercent*100}"  fractionDigits="2" /></td>
					</c:forEach>
					<td><tag:numberLabel value="${data.permanentDentalCariesPercent*100}"  fractionDigits="2" /></td>
				</c:forEach>
				
			</tr>
			<tr>
				<td>龋补率（%）</td>
				<td><tag:numberLabel value="${reportData.permanentCariesFillingPercentMale*100}"  fractionDigits="2" /></td>
				<td><tag:numberLabel value="${reportData.permanentCariesFillingPercentFeMale*100}"  fractionDigits="2" /></td>
				<td><tag:numberLabel value="${reportData.permanentCariesFillingPercent*100}"  fractionDigits="2" /></td>
				<c:forEach var="data" items="${reportData.datas}">
					<c:forEach var="item" items="${data.datas}">
						<td><tag:numberLabel value="${item.permanentCariesFillingPercent*100}"  fractionDigits="2" /></td>
					</c:forEach>
					<td><tag:numberLabel value="${data.permanentCariesFillingPercent*100}"  fractionDigits="2" /></td>
				</c:forEach>
				
			</tr>
			<tr>
				<td>龋均</td>
				<td><tag:numberLabel value="${reportData.permanentDentalCariesAverageMale}" /></td>
				<td><tag:numberLabel value="${reportData.permanentDentalCariesAverageFeMale}" /></td>
				<td><tag:numberLabel value="${reportData.permanentDentalCariesAverage}" /></td>
				<c:forEach var="data" items="${reportData.datas}">
					<c:forEach var="item" items="${data.datas}">
						<td><tag:numberLabel value="${item.permanentDentalCariesAverage}" /></td>
					</c:forEach>
					<td><tag:numberLabel value="${data.permanentDentalCariesAverage}" /></td>
				</c:forEach>
				
			</tr>
			<tr>
				<td rowspan="6">恒牙龋齿（12岁）</td>
				<td>总龋齿人数R</td>
				<td align="right">${reportData.eurodonticusNumberMale}</td>
				<td align="right">${reportData.eurodonticusNumberFeMale}</td>
				<td align="right">${reportData.eurodonticusNumber}</td>
				<c:forEach var="data" items="${reportData.datas}">
					<c:forEach var="item" items="${data.datas}">
						<td align="right">${item.eurodonticusNumber}</td>
					</c:forEach>
					<td align="right">${data.eurodonticusNumber}</td>
				</c:forEach>
				
			</tr>
			<tr>
				<td>龋齿数</td>
				<td align="right">${reportData.dentalCariesNumberMale}</td>
				<td align="right">${reportData.dentalCariesNumberFeMale}</td>
				<td align="right">${reportData.dentalCariesNumber}</td>
				<c:forEach var="data" items="${reportData.datas}">
					<c:forEach var="item" items="${data.datas}">
						<td align="right">${item.dentalCariesNumber}</td>
					</c:forEach>
					<td align="right">${data.dentalCariesNumber}</td>
				</c:forEach>
				
			</tr>
			<tr>
				<td>龋补数</td>
				<td align="right">${reportData.cariesFillingNumberMale}</td>
				<td align="right">${reportData.cariesFillingNumberFeMale}</td>
				<td align="right">${reportData.cariesFillingNumber}</td>
				<c:forEach var="data" items="${reportData.datas}">
					<c:forEach var="item" items="${data.datas}">
						<td align="right">${item.cariesFillingNumber}</td>
					</c:forEach>
					<td align="right">${data.cariesFillingNumber}</td>
				</c:forEach>
				
			</tr>
			<tr>
				<td>龋齿率（%）</td>
				<td><tag:numberLabel value="${reportData.dentalCariesPercentMale*100}"  fractionDigits="2" /></td>
				<td><tag:numberLabel value="${reportData.dentalCariesPercentFeMale*100}"  fractionDigits="2" /></td>
				<td><tag:numberLabel value="${reportData.dentalCariesPercent*100}"  fractionDigits="2" /></td>
				<c:forEach var="data" items="${reportData.datas}">
					<c:forEach var="item" items="${data.datas}">
						<td><tag:numberLabel value="${item.dentalCariesPercent*100}"  fractionDigits="2" /></td>
					</c:forEach>
					<td><tag:numberLabel value="${data.dentalCariesPercent*100}"  fractionDigits="2" /></td>
				</c:forEach>
				
			</tr>
			<tr>
				<td>龋补率（%）</td>
				<td><tag:numberLabel value="${reportData.cariesFillingPercentMale*100}"  fractionDigits="2" /></td>
				<td><tag:numberLabel value="${reportData.cariesFillingPercentFeMale*100}"  fractionDigits="2" /></td>
				<td><tag:numberLabel value="${reportData.cariesFillingPercent*100}"  fractionDigits="2" /></td>
				<c:forEach var="data" items="${reportData.datas}">
					<c:forEach var="item" items="${data.datas}">
						<td><tag:numberLabel value="${item.cariesFillingPercent*100}"  fractionDigits="2" /></td>
					</c:forEach>
					<td><tag:numberLabel value="${data.cariesFillingPercent*100}"  fractionDigits="2" /></td>
				</c:forEach>
				
			</tr>
			<tr>
				<td>龋均</td>
				<td><tag:numberLabel value="${reportData.dentalCariesAverageMale}" /></td>
				<td><tag:numberLabel value="${reportData.dentalCariesAverageFeMale}" /></td>
				<td><tag:numberLabel value="${reportData.dentalCariesAverage}" /></td>
				<c:forEach var="data" items="${reportData.datas}">
					<c:forEach var="item" items="${data.datas}">
						<td><tag:numberLabel value="${item.dentalCariesAverage}" /></td>
					</c:forEach>
					<td><tag:numberLabel value="${data.dentalCariesAverage}" /></td>
				</c:forEach>
				
			</tr>
			<tr>
				<td rowspan="2">牙周病</td>
				<td>人数</td>
				<td align="right">${reportData.periodontalDiseaseNumberMale}</td>
				<td align="right">${reportData.periodontalDiseaseNumberFeMale}</td>
				<td align="right">${reportData.periodontalDiseaseNumber}</td>
				<c:forEach var="data" items="${reportData.datas}">
					<c:forEach var="item" items="${data.datas}">
						<td align="right">${item.periodontalDiseaseNumber}</td>
					</c:forEach>
					<td align="right">${data.periodontalDiseaseNumber}</td>
				</c:forEach>
				
			</tr>
			<tr>
				<td>率（%）</td>
				<td><tag:numberLabel value="${reportData.periodontalDiseasePercentMale*100}"  fractionDigits="2" /></td>
				<td><tag:numberLabel value="${reportData.periodontalDiseasePercentFeMale*100}"  fractionDigits="2" /></td>
				<td><tag:numberLabel value="${reportData.periodontalDiseasePercent*100}"  fractionDigits="2" /></td>
				<c:forEach var="data" items="${reportData.datas}">
					<c:forEach var="item" items="${data.datas}">
						<td><tag:numberLabel value="${item.periodontalDiseasePercent*100}"  fractionDigits="2" /></td>
					</c:forEach>
					<td><tag:numberLabel value="${data.periodontalDiseasePercent*100}"  fractionDigits="2" /></td>
				</c:forEach>
				
			</tr>
			<tr>
				<td rowspan="2">心杂音、早博</td>
				<td>人数</td>
				<td align="right">${reportData.heartDiseaseNumberMale}</td>
				<td align="right">${reportData.heartDiseaseNumberFeMale}</td>
				<td align="right">${reportData.heartDiseaseNumber}</td>
				<c:forEach var="data" items="${reportData.datas}">
					<c:forEach var="item" items="${data.datas}">
						<td align="right">${item.heartDiseaseNumber}</td>
					</c:forEach>
					<td align="right">${data.heartDiseaseNumber}</td>
				</c:forEach>
				
			</tr>
			<tr>
				<td>率（%）</td>
				<td><tag:numberLabel value="${reportData.heartDiseasePercentMale*100}"  fractionDigits="2" /></td>
				<td><tag:numberLabel value="${reportData.heartDiseasePercentFeMale*100}"  fractionDigits="2" /></td>
				<td><tag:numberLabel value="${reportData.heartDiseasePercent*100}"  fractionDigits="2" /></td>
				<c:forEach var="data" items="${reportData.datas}">
					<c:forEach var="item" items="${data.datas}">
						<td><tag:numberLabel value="${item.heartDiseasePercent*100}"  fractionDigits="2" /></td>
					</c:forEach>
					<td><tag:numberLabel value="${data.heartDiseasePercent*100}"  fractionDigits="2" /></td>
				</c:forEach>
				
			</tr>
			<tr>
				<td rowspan="2">哮鸣音</td>
				<td>人数</td>
				<td align="right">${reportData.lungDiseaseNumberMale}</td>
				<td align="right">${reportData.lungDiseaseNumberFeMale}</td>
				<td align="right">${reportData.lungDiseaseNumber}</td>
				<c:forEach var="data" items="${reportData.datas}">
					<c:forEach var="item" items="${data.datas}">
						<td align="right">${item.lungDiseaseNumber}</td>
					</c:forEach>
					<td align="right">${data.lungDiseaseNumber}</td>
				</c:forEach>
				
			</tr>
			<tr>
				<td>率（%）</td>
				<td><tag:numberLabel value="${reportData.lungDiseasePercentMale*100}"  fractionDigits="2" /></td>
				<td><tag:numberLabel value="${reportData.lungDiseasePercentFeMale*100}"  fractionDigits="2" /></td>
				<td><tag:numberLabel value="${reportData.lungDiseasePercent*100}"  fractionDigits="2" /></td>
				<c:forEach var="data" items="${reportData.datas}">
					<c:forEach var="item" items="${data.datas}">
						<td><tag:numberLabel value="${item.lungDiseasePercent*100}"  fractionDigits="2" /></td>
					</c:forEach>
					<td><tag:numberLabel value="${data.lungDiseasePercent*100}"  fractionDigits="2" /></td>
				</c:forEach>
				
			</tr>
			<tr>
				<td rowspan="2">肝脾肿大</td>
				<td>人数</td>
				<td align="right">${reportData.spleenDiseaseNumberMale}</td>
				<td align="right">${reportData.spleenDiseaseNumberFeMale}</td>
				<td align="right">${reportData.spleenDiseaseNumber}</td>
				<c:forEach var="data" items="${reportData.datas}">
					<c:forEach var="item" items="${data.datas}">
						<td align="right">${item.spleenDiseaseNumber}</td>
					</c:forEach>
					<td align="right">${data.spleenDiseaseNumber}</td>
				</c:forEach>
				
			</tr>
			<tr>
				<td>率（%）</td>
				<td><tag:numberLabel value="${reportData.spleenDiseasePercentMale*100}"  fractionDigits="2" /></td>
				<td><tag:numberLabel value="${reportData.spleenDiseasePercentFeMale*100}"  fractionDigits="2" /></td>
				<td><tag:numberLabel value="${reportData.spleenDiseasePercent*100}"  fractionDigits="2" /></td>
				<c:forEach var="data" items="${reportData.datas}">
					<c:forEach var="item" items="${data.datas}">
						<td><tag:numberLabel value="${item.spleenDiseasePercent*100}"  fractionDigits="2" /></td>
					</c:forEach>
					<td><tag:numberLabel value="${data.spleenDiseasePercent*100}"  fractionDigits="2" /></td>
				</c:forEach>
				
			</tr>
			<tr>
				<td rowspan="2">甲状腺肿大</td>
				<td>人数</td>
				<td align="right">${reportData.neckDiseaseNumberMale}</td>
				<td align="right">${reportData.neckDiseaseNumberFeMale}</td>
				<td align="right">${reportData.neckDiseaseNumber}</td>
				<c:forEach var="data" items="${reportData.datas}">
					<c:forEach var="item" items="${data.datas}">
						<td align="right">${item.neckDiseaseNumber}</td>
					</c:forEach>
					<td align="right">${data.neckDiseaseNumber}</td>
				</c:forEach>
				
			</tr>
			<tr>
				<td>率（%）</td>
				<td><tag:numberLabel value="${reportData.neckDiseasePercentMale*100}"  fractionDigits="2" /></td>
				<td><tag:numberLabel value="${reportData.neckDiseasePercentFeMale*100}"  fractionDigits="2" /></td>
				<td><tag:numberLabel value="${reportData.neckDiseasePercent*100}"  fractionDigits="2" /></td>
				<c:forEach var="data" items="${reportData.datas}">
					<c:forEach var="item" items="${data.datas}">
						<td><tag:numberLabel value="${item.neckDiseasePercent*100}"  fractionDigits="2" /></td>
					</c:forEach>
					<td><tag:numberLabel value="${data.neckDiseasePercent*100}"  fractionDigits="2" /></td>
				</c:forEach>
				
			</tr>
			<tr>
				<td rowspan="2">淋巴结肿大</td>
				<td>人数</td>
				<td align="right">${reportData.limbsDiseaseNumberMale}</td>
				<td align="right">${reportData.limbsDiseaseNumberFeMale}</td>
				<td align="right">${reportData.limbsDiseaseNumber}</td>
				<c:forEach var="data" items="${reportData.datas}">
					<c:forEach var="item" items="${data.datas}">
						<td align="right">${item.limbsDiseaseNumber}</td>
					</c:forEach>
					<td align="right">${data.limbsDiseaseNumber}</td>
				</c:forEach>
				
			</tr>
			<tr>
				<td>率（%）</td>
				<td><tag:numberLabel value="${reportData.limbsDiseasePercentMale*100}"  fractionDigits="2" /></td>
				<td><tag:numberLabel value="${reportData.limbsDiseasePercentFeMale*100}"  fractionDigits="2" /></td>
				<td><tag:numberLabel value="${reportData.limbsDiseasePercent*100}"  fractionDigits="2" /></td>
				<c:forEach var="data" items="${reportData.datas}">
					<c:forEach var="item" items="${data.datas}">
						<td><tag:numberLabel value="${item.limbsDiseasePercent*100}"  fractionDigits="2" /></td>
					</c:forEach>
					<td><tag:numberLabel value="${data.limbsDiseasePercent*100}"  fractionDigits="2" /></td>
				</c:forEach>
				
			</tr>
			<tr>
				<td rowspan="2">脊柱弯曲</td>
				<td>人数</td>
				<td align="right">${reportData.spineDiseaseNumberMale}</td>
				<td align="right">${reportData.spineDiseaseNumberFeMale}</td>
				<td align="right">${reportData.spineDiseaseNumber}</td>
				<c:forEach var="data" items="${reportData.datas}">
					<c:forEach var="item" items="${data.datas}">
						<td align="right">${item.spineDiseaseNumber}</td>
					</c:forEach>
					<td align="right">${data.spineDiseaseNumber}</td>
				</c:forEach>
				
			</tr>
			<tr>
				<td>率（%）</td>
				<td><tag:numberLabel value="${reportData.spineDiseasePercentMale*100}"  fractionDigits="2" /></td>
				<td><tag:numberLabel value="${reportData.spineDiseasePercentFeMale*100}"  fractionDigits="2" /></td>
				<td><tag:numberLabel value="${reportData.spineDiseasePercent*100}"  fractionDigits="2" /></td>
				<c:forEach var="data" items="${reportData.datas}">
					<c:forEach var="item" items="${data.datas}">
						<td><tag:numberLabel value="${item.spineDiseasePercent*100}"  fractionDigits="2" /></td>
					</c:forEach>
					<td><tag:numberLabel value="${data.spineDiseasePercent*100}"  fractionDigits="2" /></td>
				</c:forEach>
				
			</tr>
			<tr>
				<td rowspan="2">皮肤病</td>
				<td>人数</td>
				<td align="right">${reportData.skinDiseaseNumberMale}</td>
				<td align="right">${reportData.skinDiseaseNumberFeMale}</td>
				<td align="right">${reportData.skinDiseaseNumber}</td>
				<c:forEach var="data" items="${reportData.datas}">
					<c:forEach var="item" items="${data.datas}">
						<td align="right">${item.skinDiseaseNumber}</td>
					</c:forEach>
					<td align="right">${data.skinDiseaseNumber}</td>
				</c:forEach>
				
			</tr>
			<tr>
				<td>率（%）</td>
				<td><tag:numberLabel value="${reportData.skinDiseasePercentMale*100}"  fractionDigits="2" /></td>
				<td><tag:numberLabel value="${reportData.skinDiseasePercentFeMale*100}"  fractionDigits="2" /></td>
				<td><tag:numberLabel value="${reportData.skinDiseasePercent*100}"  fractionDigits="2" /></td>
				<c:forEach var="data" items="${reportData.datas}">
					<c:forEach var="item" items="${data.datas}">
						<td><tag:numberLabel value="${item.skinDiseasePercent*100}"  fractionDigits="2" /></td>
					</c:forEach>
					<td><tag:numberLabel value="${data.skinDiseasePercent*100}"  fractionDigits="2" /></td>
				</c:forEach>
				
			</tr>
			<tr>
				<td colspan="2">健康问题及指导意见</td>
				<c:forEach var="data" items="${reportData.datas}" varStatus="status">
					<c:if test="${status.index eq 0}">
						<td colspan="${fn:length(reportData.datas) * 3 + 3}"></td>
					</c:if>
				</c:forEach>
			</tr>
		</tbody>
	</table>
</div>