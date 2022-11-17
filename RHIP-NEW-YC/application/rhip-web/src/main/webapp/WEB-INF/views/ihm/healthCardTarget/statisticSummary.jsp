<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<div class="repeattable">
    <table class="layui-table x-admin-sm-table-list-middle">
        <colgroup>
            <col style="min-width:150px;width: 25%;"/>
            <col style="min-width:80px;"/>
            <col style="min-width:80px;"/>
            <col style="min-width:80px;"/>
            <col style="min-width:80px;"/>
        </colgroup>
		<thead>
			<tr>
                <th>机构</th>
                <th>正常数</th>
				<th>挂失数</th>
                <th>换卡数</th>
				<th>补卡数</th>
			</tr>
		</thead>
		<tbody>
            <c:forEach var="statistic" items="${statisticList}" varStatus="status">
                <tr>
                    <td>
                        <c:choose>
                            <c:when test="${statistic.organCode=='合计'}">合计</c:when>
                            <c:otherwise>
                                <c:choose>
                                    <c:when test="${genreCode == '0'}">
                                        <ehr:dic dicmeta="FS990001" code="${statistic.organCode}"/>
                                    </c:when>
                                    <c:otherwise>
                                        <ehr:tip><ehr:org code="${statistic.organCode}"/></ehr:tip>
                                    </c:otherwise>
                                </c:choose>
                            </c:otherwise>
                        </c:choose>
                    </td>
                    <td class="centertd"><ehr:tip>${statistic.countNormal}</ehr:tip></td>
                    <td class="centertd"><ehr:tip>${statistic.countLoss}</ehr:tip></td>
                    <td class="centertd"><ehr:tip>${statistic.countChange}</ehr:tip></td>
                    <td class="centertd"><ehr:tip>${statistic.countReissue}</ehr:tip></td>
                </tr>
            </c:forEach>
		</tbody>
	</table>
</div>