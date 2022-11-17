<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="com.founder.rhip.mdm.common.OrgGenreCode" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>

<div class="repeattable">
    <table>
        <colgroup>
        </colgroup>
        <thead>
        <tr>
        	<c:if test="${not empty genreCode}">
        		<th>镇</th>
        	</c:if>
        	<c:if test="${empty genreCode}">
        		<th>机构</th>
        	</c:if>
        	<c:if test="${genreCode eq 'A1'}"><th>市级医院</th></c:if>
        	<c:if test="${genreCode eq 'B1' || genreCode eq 'B2'}">
        	<th>卫生院</th>
        	</c:if>
    	    <c:if test="${genreCode eq 'B2'}">
        	<th>卫生服务站</th>
        	</c:if>
            <th>药物名称</th>
            <th>数量</th>
            <th>查看医生</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="drugUsage" items="${drugUsageList}" varStatus="status">
            <tr>
                <td><ehr:dic dicmeta="FS990001" code="${drugUsage.GB_CODE}"/></td>
                <c:if test="${genreCode eq 'B2'}">
	                <td><ehr:org code="${drugUsage.CENTER_CODE}"/></td>
                </c:if>
                <td>
                    <ehr:org code="${drugUsage.ORGAN_CODE}"/>
                </td>
                <td>
                    ${drugUsage.DRUGNAME}
                </td>
                <td>${drugUsage.DRUGNUM}</td>
                <td><a href="javascript:void(0);" onclick="ldaAntibacterialsSearch.viewDoctorDetail('${drugUsage.ORGAN_CODE}','${drugUsage.drug_medicare_code}')">查看</a></td>
            </tr>

        </c:forEach>
        </tbody>
    </table>
   	<table>
		<tr>
			<ehr:pagination action="ldaAntibacterialsSearch.search" />
		</tr>
	</table>
</div>
