<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="com.founder.rhip.mdm.common.OrgGenreCode" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<c:set var="HOSPITAL" value="<%=OrgGenreCode.HOSPITAL.getValue()%>" />
<c:set var="CENTRE" value="<%=OrgGenreCode.CENTRE.getValue()%>" />
<c:set var="STATION" value="<%=OrgGenreCode.STATION.getValue()%>" />
<div class="repeattable" style="overflow-x: auto; overflow-y: auto; min-width: 800px; width: 100%; height: 450px;">
	<table>
  		<colgroup>
			<c:choose>
              	<c:when test="${genreCode == '0' }">
              		<col style="min-width:150px;width: 30%;"/>
              	</c:when>
              	<c:when test="${genreCode == HOSPITAL || genreCode == CENTRE}">
              		<col style="min-width:150px;width: 15%;"/>
              		<col style="min-width:150px;width: 15%;"/>
              	</c:when>
                <c:when test="${genreCode == STATION}">
                  	<col style="min-width:150px;width: 10%;"/>
              		<col style="min-width:150px;width: 10%;"/>
              		<col style="min-width:150px;width: 10%;"/>
                </c:when>
                <c:otherwise>
                	<col style="min-width:150px;width: 30%;"/>
                </c:otherwise>
             </c:choose>		
			<%--<col style="min-width:70px;width: 9%;"/>--%>
			<c:choose>
				<c:when test="${type eq 'consumable'}">
					<col style="min-width:70px;width: 17%;"/>
					<col style="min-width:70px;width: 17%;"/>
					<col style="min-width:70px;width: 17%;"/>
					<col style="min-width:70px;width: 19%;"/>
				</c:when>
				<c:otherwise>
					<col style="min-width:70px;width: 23%;"/>
					<col style="min-width:70px;width: 23%;"/>
					<col style="min-width:70px;width: 24%;"/>
				</c:otherwise>
			</c:choose>


		</colgroup>
		<thead>
			<tr>
				<c:choose>
                	<c:when test="${genreCode == '0' }">
                		<th rowspan="2">镇</th>
                	</c:when>
                	<c:when test="${genreCode == HOSPITAL || genreCode == CENTRE}">
                		<th colspan="2">医疗机构</th>
                	</c:when>
                    <c:when test="${genreCode == STATION}">
                    	<th colspan="3">医疗机构</th>
                    </c:when>
                    <c:otherwise>
                    	<th>医疗机构</th>
                    </c:otherwise>
                </c:choose>
				<c:choose>
					<c:when test="${type eq 'consumable'}">
						<th rowspan="2">药品总费用</th>
						<th rowspan="2">耗材总费用</th>
						<th rowspan="2">总费用</th>
						<th rowspan="2">耗材占比</th>
					</c:when>
					<c:otherwise>
						<th rowspan="2">药品总费用</th>
						<th rowspan="2">
							<c:if test="${type eq 'outpatient'}">门诊总费用</c:if>
							<c:if test="${type eq 'inpatient'}">住院总费用</c:if>
							<c:if test="${type eq 'hosipital'}">总费用</c:if>
						</th>
						<th rowspan="2">药占比</th>
					</c:otherwise>
				</c:choose>
			</tr>
			<tr>
				<c:choose>
                	<c:when test="${genreCode == '0' }">
                	</c:when>
                	<c:when test="${genreCode == HOSPITAL}">
                		<th>镇</th>
                		<th>医院</th>
                	</c:when>
					<c:when test="${genreCode == CENTRE}">
                		<th>镇</th>
                		<th>卫生院</th>
                	</c:when>                	
                    <c:when test="${genreCode == STATION}">
                    	<th>镇</th>
                		<th>中心</th>
                		<th>站</th>
                    </c:when>
                    <c:otherwise>
                    </c:otherwise>
                </c:choose>			
			</tr>
		</thead>
		<tbody>
			<c:forEach var="report" items="${reports}" varStatus="status">
				<tr>
					<c:choose>
	              	<c:when test="${genreCode == '0' }">
              			<td>
              				<ehr:tip><ehr:dic code="${report.gb_code}" dicmeta="FS990001"/></ehr:tip>
              				<c:if test="${report.gb_code == '合计' || report.organ_code == '合计'}"> <b>合计</b> </c:if>
              			</td> 
	              	</c:when>
	              	<c:when test="${genreCode == HOSPITAL || genreCode == CENTRE}">
	              		<c:choose>
	              			<c:when test="${report.gb_code == '合计' || report.organ_code == '合计'}">
	              				<td colspan="2" class="centertd"><b>合计</b></td>
	              			</c:when>
	              			<c:when test="${report.gb_code == '小计' || report.organ_code == '小计'}">
	              				<td><ehr:tip><ehr:dic code="${report.gb_code}" dicmeta="FS990001"/></ehr:tip> </td>
	              				<td><b>小计</b></td>
	              			</c:when>
	              			<c:otherwise>
	              				 <td><ehr:tip><ehr:dic code="${report.gb_code}" dicmeta="FS990001"/></ehr:tip> </td>
	              				 <td><ehr:tip><ehr:org code="${report.organ_code}"/></ehr:tip></td>
	              			</c:otherwise>
	              		</c:choose>
	              	</c:when>
	                  <c:when test="${genreCode == STATION}">
	                  	<c:choose>
	              			<c:when test="${report.gb_code == '合计' || report.organ_code == '合计'}">
	              				<td colspan="3" class="centertd"><b>合计</b></td> 
	              			</c:when>
	              			<c:when test="${report.gb_code == '小计' || report.organ_code == '小计'}">
	              				<td><ehr:tip><ehr:dic code="${report.gb_code}" dicmeta="FS990001"/></ehr:tip> </td>
			              		<td><ehr:tip><ehr:org code="${report.center_code}"/></ehr:tip></td>
			                  	<td><b>小计</b></td>
	              			</c:when>
	              			<c:otherwise>
	              				<td><ehr:tip><ehr:dic code="${report.gb_code}" dicmeta="FS990001"/></ehr:tip> </td>
			              		<td><ehr:tip><ehr:org code="${report.center_code}"/></ehr:tip></td>
			                  	<td><ehr:tip><ehr:org code="${report.organ_code}"/></ehr:tip></td>
	              			</c:otherwise>
	              		</c:choose>
	              		
	                  </c:when>
              </c:choose>
                    <td><tags:numberLabel value="${report.drug_fee}" defaultValue="0" /></td>
                     <c:if test="${type eq 'consumable'}">
                		<td><tags:numberLabel value="${report.consumables_fee}" defaultValue="0" />比</td>
                	</c:if>
                    <td><tags:numberLabel value="${report.fee_total}" defaultValue="0" /></td>
                    <td><tags:numberLabel value="${report.drug_rate}" defaultValue="0" fractionDigits="2" /></td>
                    <c:if test="${type eq 'consumable'}">
                		<td><tags:numberLabel value="${report.consumable_rate}" defaultValue="0" fractionDigits="2" />比</td>
                	</c:if>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>