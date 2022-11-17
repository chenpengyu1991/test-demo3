<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<script src="${pageContext.request.contextPath}/js/views/ehr/person/reception.js" type="text/javascript"></script>
<input type="hidden" value="${fn:length(outpatientInfos) }" id="outpatientInfos" />
<div style="float: right; width: 83%;overflow:auto;margin-top: 10px;">
    <div id="receptionViewDiv" style="position: relative;"></div>
</div>
<div style="float:left;width: 16%;margin-top: -9px;">
    <c:choose>
        <c:when test="${not empty outpatientInfos}">
            <table class="repeattable layui-table x-admin-sm-table-list-small">
                <thead>
                <tr>
                    <th>接诊日期</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${outpatientInfos}" var="outpatientInfo">
                    <tr>
                        <td align="center">
                            <a href="#this" onclick="getReception.viewReception('${outpatientInfo.personId}', '${outpatientInfo.ehrId}')">
                                <input type="hidden" value="${outpatientInfo.personId}" class="personId" />
                                <input type="hidden" value="${outpatientInfo.ehrId}" class="ehrId" />
                                <fmt:formatDate value="${outpatientInfo.clinicDate}" pattern="yyyy/MM/dd "/>
                            </a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </c:when>
        <c:otherwise>
            <div style="text-align: left;margin-left: 10px;margin-top: 10px;">没有记录</div>
        </c:otherwise>
    </c:choose>

</div>
