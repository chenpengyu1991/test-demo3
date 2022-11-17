<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<div class="repeattable">
    <table  class="layui-table x-admin-sm-table-list-middle">
        <colgroup>
            <col style="min-width:150px;width: 20%;"/>
            <col style="min-width:80px;"/>
            <col style="min-width:80px;"/>
            <col style="min-width:80px;"/>
        </colgroup>
        <thead>
        <tr>
            <th>镇</th>
            <th>孕产妇人数</th>
            <th>孕产妇死亡人数</th>
            <th>孕产妇死亡率</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="maternalDeath" items="${maternalDeathList}" varStatus="status">
            <tr>
                <td class="centertd"><ehr:tip><ehr:dic code="${maternalDeath.gb_code}" dicmeta="FS990001"/></ehr:tip></td>
                <td class="centertd"><ehr:tip>${maternalDeath.PREGNANT_TOTAL}</ehr:tip></td>
                <td class="centertd"><ehr:tip>${maternalDeath.DEADPREGNANT_TOTAL}</ehr:tip></td>
               <td class="centertd">
                <ehr:tip>
                <%-- ${empty maternalDeath.AVG ? 0: maternalDeath.AVG} --%>
                <fmt:formatNumber type="percent"  value="${maternalDeath.PCT}" maxFractionDigits="3"/>
                </ehr:tip>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>