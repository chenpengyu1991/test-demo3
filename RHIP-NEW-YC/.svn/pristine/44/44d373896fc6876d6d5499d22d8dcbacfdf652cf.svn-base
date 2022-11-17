<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="com.founder.rhip.ehr.common.RoleType" %>
<%@ page import="com.founder.rhip.idm.common.ReportStatus" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<script>
    $("#statistics-advanced").treetable({ expandable: true });
</script>
<div class="repeattable" id="exportTable">
	<table id="statistics-advanced">
		<colgroup>
			<col style="min-width:70px;width: 16%;"/>
	        <col style="min-width:50px;width: 12%;"/>
			<col style="min-width:50px;width: 12%;"/>
	        <col style="min-width:90px;width: 12%;"/>
	        <col style="min-width:80px;width: 12%;"/>
			<col style="min-width:100px;width: 12%;"/>
			<col style="min-width:80px;width: 12%;"/>
			<col style="min-width:80px;width: 12%;"/>
		</colgroup>
		<thead>
			<tr data-tt-id="0">
				<th colspan="8">${weekXun}&nbsp;肠道门诊报表</th>
			</tr>
			<tr data-tt-id="0">
				<th rowspan="2">地区(单位)</th>
				<th colspan="3">腹泻病人登记数</th>
				<th colspan="2">检索</th>
                <th colspan="2">检索阳性数</th>
			</tr>
			<tr data-tt-id="0">
				<th>乡级及以上</th>
				<th>村级</th>
				<th>小计</th>
				<th>数</th>
				<th>率%</th>
                <th>O1群霍乱</th>
				<th>O139霍乱</th>	
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${statisticsMaps}" var="statisticsMap" step="1" varStatus="status">
            <!--父机构为-1的不需要统计小结 所以不显示-->
            <c:choose>
                <c:when test="${statisticsMap.parent_code eq '-1'}">
                    <c:if test="${statisticsMap.organ_code ne null}">
                        <tr data-tt-id="${statisticsMap.organ_code}">
                            <td><ehr:org code="${statisticsMap.organ_code}"/></td>
                            <td><tags:numberLabel value="${statisticsMap.TS_DIA_REG_NUM}" defaultValue="0" align="left"/></td>
		                    <td><tags:numberLabel value="${statisticsMap.VI_DIA_REG_NUM}" defaultValue="0" align="left"/></td>
		                    <td><tags:numberLabel value="${statisticsMap.ST_DIA_REG_NUM}" defaultValue="0" align="left"/></td>
		                    <td><tags:numberLabel value="${statisticsMap.RETRIEVAL_NUM}" defaultValue="0" align="left"/></td>
		                    <td><tags:numberLabel value="${statisticsMap.RETRIEVAL_RATE}" defaultValue="0" fractionDigits="2" align="left"/></td>
		                    <td><tags:numberLabel value="${statisticsMap.CHOLERA_POSI_O1}" defaultValue="0" align="left"/></td>
		                    <td><tags:numberLabel value="${statisticsMap.CHOLERA_POSI_O139}" defaultValue="0" align="left"/></td>
                        </tr>
                    </c:if>
                </c:when>
                <c:when test="${statisticsMap.parent_code eq '合计' && statisticsMap.organ_code eq null}">
                    <tr data-tt-id="${statisticsMap.parent_code}">
                        <td>${statisticsMap.parent_code}</td>
	                    <td><tags:numberLabel value="${statisticsMap.TS_DIA_REG_NUM}" defaultValue="0" align="left"/></td>
	                    <td><tags:numberLabel value="${statisticsMap.VI_DIA_REG_NUM}" defaultValue="0" align="left"/></td>
	                    <td><tags:numberLabel value="${statisticsMap.ST_DIA_REG_NUM}" defaultValue="0" align="left"/></td>
	                    <td><tags:numberLabel value="${statisticsMap.RETRIEVAL_NUM}" defaultValue="0" align="left"/></td>
	                    <td><tags:numberLabel value="${statisticsMap.RETRIEVAL_RATE}" defaultValue="0" fractionDigits="2" align="left"/></td>
	                    <td><tags:numberLabel value="${statisticsMap.CHOLERA_POSI_O1}" defaultValue="0" align="left"/></td>
	                    <td><tags:numberLabel value="${statisticsMap.CHOLERA_POSI_O139}" defaultValue="0" align="left"/></td>
                    </tr>
                </c:when>
                <c:when test="${statisticsMap.parent_code ne '-1' && statisticsMap.organ_code eq null}">
                    <tr data-tt-id="${statisticsMap.parent_code}">
                        <td><ehr:org code="${statisticsMap.parent_code}"/></td>
	                    <td><tags:numberLabel value="${statisticsMap.TS_DIA_REG_NUM}" defaultValue="0" align="left"/></td>
	                    <td><tags:numberLabel value="${statisticsMap.VI_DIA_REG_NUM}" defaultValue="0" align="left"/></td>
	                    <td><tags:numberLabel value="${statisticsMap.ST_DIA_REG_NUM}" defaultValue="0" align="left"/></td>
	                    <td><tags:numberLabel value="${statisticsMap.RETRIEVAL_NUM}" defaultValue="0" align="left"/></td>
	                    <td><tags:numberLabel value="${statisticsMap.RETRIEVAL_RATE}" defaultValue="0" fractionDigits="2" align="left"/></td>
	                    <td><tags:numberLabel value="${statisticsMap.CHOLERA_POSI_O1}" defaultValue="0" align="left"/></td>
	                    <td><tags:numberLabel value="${statisticsMap.CHOLERA_POSI_O139}" defaultValue="0" align="left"/></td>
                    </tr>
                </c:when>
                <c:when test="${statisticsMap.parent_code ne '-1' && statisticsMap.parent_code eq statisticsMap.organ_code}">
                    <tr data-tt-id="${status.count}" data-tt-parent-id="${statisticsMap.parent_code}">
                        <td><ehr:org code="${statisticsMap.organ_code}"/></td>
                        <td><tags:numberLabel value="${statisticsMap.TS_DIA_REG_NUM}" defaultValue="0" align="left"/></td>
	                    <td><tags:numberLabel value="${statisticsMap.VI_DIA_REG_NUM}" defaultValue="0" align="left"/></td>
	                    <td><tags:numberLabel value="${statisticsMap.ST_DIA_REG_NUM}" defaultValue="0" align="left"/></td>
	                    <td><tags:numberLabel value="${statisticsMap.RETRIEVAL_NUM}" defaultValue="0" align="left"/></td>
	                    <td><tags:numberLabel value="${statisticsMap.RETRIEVAL_RATE}" defaultValue="0" fractionDigits="2" align="left"/></td>
	                    <td><tags:numberLabel value="${statisticsMap.CHOLERA_POSI_O1}" defaultValue="0" align="left"/></td>
	                    <td><tags:numberLabel value="${statisticsMap.CHOLERA_POSI_O139}" defaultValue="0" align="left"/></td>
                    </tr>
                </c:when>
                <c:when test="${statisticsMap.parent_code ne '-1' && statisticsMap.organ_code ne null}">
                    <tr data-tt-id="${statisticsMap.organ_code}" data-tt-parent-id="${statisticsMap.parent_code}">
                        <td><ehr:org code="${statisticsMap.organ_code}"/></td>
                        <td><tags:numberLabel value="${statisticsMap.TS_DIA_REG_NUM}" defaultValue="0" align="left"/></td>
	                    <td><tags:numberLabel value="${statisticsMap.VI_DIA_REG_NUM}" defaultValue="0" align="left"/></td>
	                    <td><tags:numberLabel value="${statisticsMap.ST_DIA_REG_NUM}" defaultValue="0" align="left"/></td>
	                    <td><tags:numberLabel value="${statisticsMap.RETRIEVAL_NUM}" defaultValue="0" align="left"/></td>
	                    <td><tags:numberLabel value="${statisticsMap.RETRIEVAL_RATE}" defaultValue="0" fractionDigits="2" align="left"/></td>
	                    <td><tags:numberLabel value="${statisticsMap.CHOLERA_POSI_O1}" defaultValue="0" align="left"/></td>
	                    <td><tags:numberLabel value="${statisticsMap.CHOLERA_POSI_O139}" defaultValue="0" align="left"/></td>
                    </tr>
                </c:when>
                <c:otherwise>
                </c:otherwise>
            </c:choose>
        </c:forEach>
	</tbody>
	</table>
</div>