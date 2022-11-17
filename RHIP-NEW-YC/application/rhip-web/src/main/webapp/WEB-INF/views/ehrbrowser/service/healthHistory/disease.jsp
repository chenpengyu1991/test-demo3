<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!-- 疾病史 -->
<c:choose> <c:when test="${not empty healthHistoryDTO.diseaseHistoryList}">
    <div class="repeattable">
        <table class="layui-table x-admin-sm-table-list-middle" style="margin: 2px 0px;">
            <thead>
            <tr>
                <th style="height: 22px">诊断日期</th>
                <th style="height: 22px">疾病名称</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="diseaseHistory" items="${healthHistoryDTO.diseaseHistoryList}">
                <c:if test="${diseaseHistory.ehrId != '0'}">
                    <tr>
                        <td><fmt:formatDate value="${diseaseHistory.confirmationDate }" pattern="yyyy/MM/dd "/></td>
                        <td>
                            <c:choose>
                                <c:when test="${diseaseHistory.diseaseCode eq '211' }">
                                    <a href="#this" onclick="ehrbrowserServiceIndex.sameDiease('${diseaseHistory.personId}','${diseaseHistory.diseaseCode}','${diseaseHistory.otherDesc}',1)"> ${diseaseHistory.otherDesc}</a>
                                </c:when>
                                <c:otherwise>
                                    <a href="#this" onclick="ehrbrowserServiceIndex.sameDiease('${diseaseHistory.personId}', '${diseaseHistory.diseaseCode}','${diseaseHistory.diseaseName}',1)"> ${diseaseHistory.diseaseName}</a>
                                </c:otherwise>
                            </c:choose>
                        </td>
                    </tr>
                </c:if>
            </c:forEach>
            </tbody>
        </table>
    </div>
</c:when> <c:otherwise>
    <div style="text-align: left;margin-left: 10px;margin-top: 10px;">没有记录</div>
</c:otherwise> </c:choose>
