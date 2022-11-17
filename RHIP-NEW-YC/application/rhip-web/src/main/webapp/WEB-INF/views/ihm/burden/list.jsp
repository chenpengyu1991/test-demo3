<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<%@ page import="com.founder.rhip.mdm.common.OrgGenreCode" %>

<c:set var="HOSPITAL" value="<%=OrgGenreCode.HOSPITAL.getValue()%>" />
<c:set var="CENTRE" value="<%=OrgGenreCode.CENTRE.getValue()%>" />
<c:set var="STATION" value="<%=OrgGenreCode.STATION.getValue()%>" />

<div style="height: 400px;">
<div class="repeattable">
<div style="min-width: 1000px; width: 100%">
<div id="examlisttableTopDiv">
    <table>
        <colgroup>
            <c:choose>
                <c:when test="${genreCode == '0' }">
                    <col style="width: 130px;"/>
                </c:when>
                <c:when test="${genreCode == HOSPITAL || genreCode == CENTRE}">
                    <col style="width: 130px;"/>
                    <col style="width: 150px;"/>
                </c:when>
                <c:when test="${genreCode == STATION}">
                    <col style="width: 130px;"/>
                    <col style="width: 150px;"/>
                    <col style="width: 150px;"/>
                </c:when>
            </c:choose>
            <col style="min-width:70px;"/>
            <col style="min-width:70px;"/>
            <col style="min-width:70px;"/>
            <col style="min-width:70px;"/>
        </colgroup>
        <thead>
        <tr>
            <c:choose>
                <c:when test="${genreCode == HOSPITAL || genreCode == CENTRE}">
                    <th colspan="2">医疗机构</th>
                </c:when>
                <c:when test="${genreCode == STATION}">
                    <th colspan="3">医疗机构</th>
                </c:when>
                <c:otherwise>
                     <th>镇</th>
                </c:otherwise>
            </c:choose>
             <c:choose>
		             <c:when test="${genreCode == '0' }">
	                    <th>门诊人均药品费用</th>
			            <th>门诊人均费用</th>
			            <th>住院人均药品费用</th>
			            <th>住院人均费用</th>
	                </c:when>
	                <c:otherwise>
	                 	<th rowspan="2">门诊人均药品费用</th>
			            <th rowspan="2">门诊人均费用</th>
			            <th rowspan="2">住院人均药品费用</th>
			            <th rowspan="2">住院人均费用</th>
	                </c:otherwise>
                </c:choose>
        </tr>
        	<tr>
	            <c:choose>
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
	            </c:choose>
	          </tr>
        </thead>
    </table>
</div>
<div id="examlisttableDiv" <c:if test="${genreCode != '0' }">class="contentfixed144"</c:if> style="min-width: 1000px; width: 100%;overflow-x: auto; margin-left: 0px;">
    <table style="width: 100%;">
        <colgroup>
            <c:choose>
                <c:when test="${genreCode == '0' }">
                    <col style="width: 130px;"/>
                </c:when>
                <c:when test="${genreCode == HOSPITAL || genreCode == CENTRE}">
                    <col style="width: 130px;"/>
                    <col style="width: 150px;"/>
                </c:when>
                <c:when test="${genreCode == STATION}">
                    <col style="width: 130px;"/>
                    <col style="width: 150px;"/>
                    <col style="width: 150px;"/>
                </c:when>
                <c:otherwise>
                    <col style="width: 130px;"/>
                </c:otherwise>
            </c:choose>
             <col style="min-width:70px;"/>
            <col style="min-width:70px;"/>
            <col style="min-width:70px;"/>
            <col style="min-width:70px;"/>
        </colgroup>
        <tbody>
        <c:forEach var="report" items="${results}" varStatus="status">
            <tr>
                <c:choose>
	              	<c:when test="${genreCode == '0' }">
              			<td><ehr:tip><ehr:dic code="${report.gb_code}" dicmeta="FS990001"/></ehr:tip>
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
                <td class="centertd"><tags:numberLabel value="${report.out_medical_fee}" defaultValue="0" align="center"/></td>
                <td class="centertd"><tags:numberLabel value="${report.out_fee_total}" defaultValue="0" align="center"/></td>
                <td class="centertd"><tags:numberLabel value="${report.inp_medical_fee}" defaultValue="0" align="center"/></td>
                <td class="centertd"><tags:numberLabel value="${report.inp_fee_total}" defaultValue="0" align="center"/></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</div>
</div>
</div>