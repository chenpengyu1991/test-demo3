<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<script src="${pageContext.request.contextPath}/js/views/hm/fissureSealant/report.js" type="text/javascript"></script> 
<div class="repeattable">
	<table id="hm_fissureSealant_report">
		<colgroup>
			<col style="width: 150px;" />
			<col style="width: 40px;" />
			
			<col style="width: 40px;" />
			<col style="width: 40px;" />
			<col style="width: 40px;" />
			
			<col style="width: 70px;" />
			
			<col style="width: 40px;" />
			<col style="width: 40px;" />
			<col style="width: 40px;" />
			
			<col style="width: 40px;" />
			<col style="width: 40px;" />
			<col style="width: 40px;" />
			
			<col style="width: 70px;" />
			<col style="width: 70px;" />
			<col style="width: 70px;" />
			
			<col style="width: 40px;" />
			<col style="width: 40px;" />
			<col style="width: 40px;" />

			<col style="width: 40px;" />
			<col style="width: 40px;" />
			<col style="width: 40px;" />
			
			<col style="width: 70px;" />
			<col style="width: 70px;" />
			<col style="width: 70px;" />
		</colgroup>
		<caption><b>市学生窝沟封闭情况汇总</b></caption>
		<thead>
			<tr>
				<th rowspan="2">学校</th>
				<th rowspan="2">学生数</th>
				<th colspan="3">检查人数</th>
				<th rowspan="2">检查率（%）</th>
				<th colspan="3">检查牙数</th>
				<th colspan="3">龋患人数</th>
				<th colspan="3">龋患率（%）</th>
				<th colspan="3">龋齿数</th>
				<th colspan="3">封闭牙数</th>
				<th colspan="3">封闭率（%）</th>
			</tr>
			<tr>
				<th>男</th>
				<th>女</th>
				<th>合计</th>
				<th>男</th>
				<th>女</th>
				<th>合计</th>
				<th>男</th>
				<th>女</th>
				<th>合计</th>
				<th>男</th>
				<th>女</th>
				<th>合计</th>
				<th>男</th>
				<th>女</th>
				<th>合计</th>
				<th>男</th>
				<th>女</th>
				<th>合计</th>
				<th>男</th>
				<th>女</th>
				<th>合计</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="school" items="${reportData.lines}" >
			  <c:forEach var="line" items="${school.lines}" varStatus="status">
				<tr>
					<c:if test="${status.index eq 0}">
						<td rowspan="2"><label class="text_tip_span" name="schoolName" school="${school.schoolName}"></label></td>
					</c:if>
					<td><ehr:tip>${line.nativeStudent}</ehr:tip></td>
					<td><ehr:tip>${line.checkMnum}</ehr:tip></td>
					<td><ehr:tip>${line.checkFnum}</ehr:tip></td>
					<td><ehr:tip>${line.checkTnum}</ehr:tip></td>
					<c:if test="${status.index eq 0}">
						<td rowspan="2"  type="percent" /></td>
					</c:if>
					<td><ehr:tip>${line.teethMnum}</ehr:tip></td>
					<td><ehr:tip>${line.teethFnum}</ehr:tip></td>
					<td><ehr:tip>${line.teethTnum}</ehr:tip></td>
					
					<td><ehr:tip>${line.eurodonticusMnum}</ehr:tip></td>
					<td><ehr:tip>${line.eurodonticusFnum}</ehr:tip></td>
					<td><ehr:tip>${line.eurodonticusTnum}</ehr:tip></td>
					
					<td><tag:numberLabel value="${line.checkMnum==0?0:(line.eurodonticusMnum / line.checkMnum)}"  type="percent" fractionDigits="2" /></td>
					<td><tag:numberLabel value="${line.checkFnum==0?0:(line.eurodonticusFnum / line.checkFnum)}"  type="percent" fractionDigits="2" /></td>
					<td><tag:numberLabel value="${line.checkTnum==0?0:(line.eurodonticusTnum / line.checkTnum)}"  type="percent" fractionDigits="2" /></td>
					
					<td><ehr:tip>${line.dentalCariesMnum}</ehr:tip></td>
					<td><ehr:tip>${line.dentalCariesFnum}</ehr:tip></td>
					<td><ehr:tip>${line.dentalCariesTnum}</ehr:tip></td>
					
					<td><ehr:tip>${line.closedMnum}</ehr:tip></td>
					<td><ehr:tip>${line.closedFnum}</ehr:tip></td>
					<td><ehr:tip>${line.closedTnum}</ehr:tip></td>
					
					<td><tag:numberLabel value="${line.teethMnum==0?0:(line.closedMnum / line.teethMnum)}"  type="percent" fractionDigits="2" /></td>
					<td><tag:numberLabel value="${line.teethFnum==0?0:(line.closedFnum / line.teethFnum)}"  type="percent" fractionDigits="2" /></td>
					<td><tag:numberLabel value="${line.teethTnum==0?0:(line.closedTnum / line.teethTnum)}"  type="percent" fractionDigits="2" /></td>
				</tr>
			  </c:forEach>
				<tr>
					<td><ehr:tip>合计</ehr:tip></td>
					<td><ehr:tip>${school.totleNumber}</ehr:tip></td>
					
					<td><ehr:tip>${school.checkMnum}</ehr:tip></td>
					<td><ehr:tip>${school.checkFnum}</ehr:tip></td>
					<td><ehr:tip>${school.checkTnum}</ehr:tip></td>
					
					<td><tag:numberLabel value="${school.totleNumber==0?0:(school.checkTnum / school.totleNumber)}"  type="percent" fractionDigits="2" /></td>
					
					<td><ehr:tip>${school.teethMnum}</ehr:tip></td>
					<td><ehr:tip>${school.teethFnum}</ehr:tip></td>
					<td><ehr:tip>${school.teethTnum}</ehr:tip></td>
					
					<td><ehr:tip>${school.eurodonticusMnum}</ehr:tip></td>
					<td><ehr:tip>${school.eurodonticusFnum}</ehr:tip></td>
					<td><ehr:tip>${school.eurodonticusTnum}</ehr:tip></td>
					
					<td><tag:numberLabel value="${school.checkMnum==0?0:(school.eurodonticusMnum / school.checkMnum)}"  type="percent" fractionDigits="2" /></td>
					<td><tag:numberLabel value="${school.checkFnum==0?0:(school.eurodonticusFnum / school.checkFnum)}"  type="percent" fractionDigits="2" /></td>
					<td><tag:numberLabel value="${school.checkTnum==0?0:(school.eurodonticusTnum / school.checkTnum)}"  type="percent" fractionDigits="2" /></td>
					
					<td><ehr:tip>${school.dentalCariesMnum}</ehr:tip></td>
					<td><ehr:tip>${school.dentalCariesFnum}</ehr:tip></td>
					<td><ehr:tip>${school.dentalCariesTnum}</ehr:tip></td>
					
					<td><ehr:tip>${school.closedMnum}</ehr:tip></td>
					<td><ehr:tip>${school.closedFnum}</ehr:tip></td>
					<td><ehr:tip>${school.closedTnum}</ehr:tip></td>
					
					<td><tag:numberLabel value="${school.teethMnum==0?0:(school.closedMnum / school.teethMnum)}"  type="percent" fractionDigits="2" /></td>
					<td><tag:numberLabel value="${school.teethFnum==0?0:(school.closedFnum / school.teethFnum)}"  type="percent" fractionDigits="2" /></td>
					<td><tag:numberLabel value="${school.teethTnum==0?0:(school.closedTnum / school.teethTnum)}"  type="percent" fractionDigits="2" /></td>
				</tr>
			</c:forEach>
			<tr>
				<td><ehr:tip>总计</ehr:tip></td>
				<td><ehr:tip>${reportData.totleNumber}</ehr:tip></td>
				
				<td><ehr:tip>${reportData.checkMnum}</ehr:tip></td>
				<td><ehr:tip>${reportData.checkFnum}</ehr:tip></td>
				<td><ehr:tip>${reportData.checkTnum}</ehr:tip></td>
				
				<td><tag:numberLabel value="${reportData.totleNumber==0?0:(reportData.checkTnum / reportData.totleNumber)}"  type="percent" fractionDigits="2" /></td>
				
				<td><ehr:tip>${reportData.teethMnum}</ehr:tip></td>
				<td><ehr:tip>${reportData.teethFnum}</ehr:tip></td>
				<td><ehr:tip>${reportData.teethTnum}</ehr:tip></td>
				
				<td><ehr:tip>${reportData.eurodonticusMnum}</ehr:tip></td>
				<td><ehr:tip>${reportData.eurodonticusFnum}</ehr:tip></td>
				<td><ehr:tip>${reportData.eurodonticusTnum}</ehr:tip></td>
				
				<td><tag:numberLabel value="${reportData.checkMnum==0?0:(reportData.eurodonticusMnum / reportData.checkMnum)}"  type="percent" fractionDigits="2" /></td>
				<td><tag:numberLabel value="${reportData.checkFnum==0?0:(reportData.eurodonticusFnum / reportData.checkFnum)}"  type="percent" fractionDigits="2" /></td>
				<td><tag:numberLabel value="${reportData.checkTnum==0?0:(reportData.eurodonticusTnum / reportData.checkTnum)}"  type="percent" fractionDigits="2" /></td>
				
				<td><ehr:tip>${reportData.dentalCariesMnum}</ehr:tip></td>
				<td><ehr:tip>${reportData.dentalCariesFnum}</ehr:tip></td>
				<td><ehr:tip>${reportData.dentalCariesTnum}</ehr:tip></td>
				
				<td><ehr:tip>${reportData.closedMnum}</ehr:tip></td>
				<td><ehr:tip>${reportData.closedFnum}</ehr:tip></td>
				<td><ehr:tip>${reportData.closedTnum}</ehr:tip></td>
				
				<td><tag:numberLabel value="${reportData.teethMnum==0?0:(reportData.closedMnum / reportData.teethMnum)}"  type="percent" fractionDigits="2" /></td>
				<td><tag:numberLabel value="${reportData.teethFnum==0?0:(reportData.closedFnum / reportData.teethFnum)}"  type="percent" fractionDigits="2" /></td>
				<td><tag:numberLabel value="${reportData.teethTnum==0?0:(reportData.closedTnum / reportData.teethTnum)}"  type="percent" fractionDigits="2" /></td>
			</tr>
		</tbody>
	</table>
</div>