<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="ehr" uri="/ehr-tag" %>
<%-- <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> --%>



<div style="overflow:auto">
    <div class="repeattable" style="width: 99.8%">
        <table class="layui-table x-admin-sm-table-list-middle">
            <thead>
            <tr>
                <th  rowspan="2">机构</th>
                <th  colspan="2">慢病</th>
                <th  colspan="4">传染病</th>
                <th  colspan="2">食源性疾病</th>
            </tr>
            <tr>
                <th>未上报</th>
                <th>已上报</th>

                <th>初诊未上报</th>
                <th>初诊已上报</th>
                <th>错误诊断</th>
                <th>补卡已上报</th>

                <th>未上报</th>
                <th>已上报</th>
            </tr>
            </thead>
        <tbody class="tbody">
        <c:forEach items="${reportRecordList}" var="reportRecord" varStatus="status">
            <tr>
                 <td>
                     <c:choose>
                         <c:when test="${genreCode == '0'}">
                             ${reportRecord.organName}
                         </c:when>
                         <c:otherwise>
                             <ehr:org code="${reportRecord.organCode}"/>
                             <c:if test="${reportRecord.organCode=='grouping'}">
                                 合计
                             </c:if>
                         </c:otherwise>
                     </c:choose>
                 </td>
               <%-- <td>  ${reportRecord.COUNTSa}</td>--%>
                <td>  ${reportRecord.countNuma1}</td>
                <td>  ${reportRecord.countNuma2}</td>

               <%-- <td>  ${reportRecord.COUNTSB}</td>--%>
                <td>  ${reportRecord.countNumb1}</td>
                <td>  ${reportRecord.countNumb2}</td>
                <td>  ${reportRecord.countNumb3}</td>
                <td>  ${reportRecord.countNumb9}</td>

               <%-- <td>  ${reportRecord.COUNTSC}</td>--%>
                <td>  ${reportRecord.countNumc1}</td>
                <td>  ${reportRecord.countNumc2}</td>
               <%-- <td>
                    <ehr:dic dicmeta="PH00028" code="${reportRecord.type}"/>
                </td>
                <td>
                    <c:if test="${reportRecord.type==1 || reportRecord.type==3}">
                        <ehr:dic dicmeta="DMD00064" code="${reportRecord.status}"/>
                    </c:if>
                    <c:if test="${reportRecord.type==2}">
                        <ehr:dic dicmeta="IDM00336" code="${reportRecord.status}"/>
                    </c:if>
                </td>--%>
            <%--    <td>
                   ${reportRecord.count}
                </td>--%>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</div>
    </div>
