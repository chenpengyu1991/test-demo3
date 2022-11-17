<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<div class="postcontent">
	<table class="posttable">
		<colgroup>
			<col style="min-width:150px;width:20%;"/>
	        <col/>
			<col style="min-width:150px;width:20%;"/>
	        <col/>
		</colgroup>
		<tr>
			<th>献血码：</th>
			<td style="text-align: left">${result.donid}</td>
			<th>血液产品码：</th>
            <td style="text-align: left">${result.procid}</td>
		</tr>
		<tr>
			<th>ABO血型：</th>
            <td style="text-align: left">${result.abotype}</td>
			<th>RH血型：</th>
            <td style="text-align: left">
                <c:choose>
                    <c:when test="${empty result.rhtype}">
                    </c:when>
                    <c:when test="${result.rhtype eq '**D**'}">
                        阳性
                    </c:when>
                    <c:when test="${result.rhtype eq '不详'}">
                        不详
                    </c:when>
                    <c:when test="${result.rhtype eq '未查'}">
                        未查
                    </c:when>
                    <c:otherwise>
                        阴性
                    </c:otherwise>
                </c:choose>
            </td>
		</tr>
		<tr>
			<th>采血日期：</th>
			<td style="text-align: left"><fmt:formatDate value="${result.dontime}" pattern="yyyy/MM/dd"></fmt:formatDate></td>
			<th>制备日期：</th>
            <td style="text-align: left"><fmt:formatDate value="${result.proctime}" pattern="yyyy/MM/dd"></fmt:formatDate></td>
		</tr>
		<tr>
			<th>失效日期：</th>
			<td style="text-align: left"><fmt:formatDate value="${result.exptime}" pattern="yyyy/MM/dd"></fmt:formatDate></td>
			<th>区域：</th>
            <td style="text-align: left">${result.branch}</td>
		</tr>
		<tr>
		    <th>更新时间：</th>
            <td style="text-align: left"><fmt:formatDate value="${result.maketime}" pattern="yyyy/MM/dd HH:mm:ss"></fmt:formatDate></td>
            <th></th>
            <td style="text-align: left"></td>
		</tr>
	</table>
</div>