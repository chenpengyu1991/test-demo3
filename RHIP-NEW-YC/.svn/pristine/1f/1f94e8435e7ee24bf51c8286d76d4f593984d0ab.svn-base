<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<table class="posttable">
    <colgroup>
        <col style="width: 15%;min-width:100px;"/>
        <col style="width: 35%;min-width:200px;"/>
        <col style="width: 15%;min-width:100px;"/>
        <col style="width: 35%;min-width:200px;"/>
    </colgroup>
    <tr>
        <th><label>是否管理</label></th>
        <td>
            <ehr:dic-radio dicmeta="FS10246" name="tumorManagedFlag" value="${diseaseInfo.tumorManagedFlag}"/>
        </td>
        <c:if test="${diseaseInfo.tumorManagedDate != null}">
	        <th><label>管理卡创建时间</label></th>
	        <td>
	        	<fmt:formatDate value="${diseaseInfo.tumorManagedDate}" pattern="yyyy/MM/dd" />
	        </td>
   		</c:if>
    </tr>
</table>
