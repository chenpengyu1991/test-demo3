<%@ page import="com.founder.rhip.ehr.common.RoleType" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr" %>
<%@ page import="com.founder.rhip.ehr.common.RoleType" %>
<c:set var="JKFYK" value="<%=RoleType.JKFYK.getValue()%>"/>
<c:set var="ZXCRB" value="<%=RoleType.ZXCRB.getValue()%>"/>
<c:set var="YYCRB" value="<%=RoleType.YYCRB.getValue()%>"/>
<c:set var="ZCRB" value="<%=RoleType.ZCRB.getValue()%>"/>

<%--<script src="${pageContext.request.contextPath}/js/views/idm/report/search.js" type="text/javascript"></script>--%>

<div class="repeattable">
    <table>
        <colgroup>
            <col style="min-width:60px;width: 8%;"/>
            <col style="min-width:50px;width: 4%;"/>
            <col style="min-width:50px;width: 5%;"/>
            <col style="min-width:60px;width: 8%;"/>
            <col style="min-width:90px;width: 10%;"/>
            <col style="min-width:130px;width: 15%;"/>
            <col style="min-width:80px;width: 9%;"/>
            <col style="min-width:80px;width: 9%;"/>
            <col style="min-width:100px;width: 12%;"/>
            <col style="width:55px;"/>
            <col style="width:55px;"/>
            <ehr:authorize ifAnyGranted="${ZXCRB},${JKFYK},${YYCRB},${ZCRB}" >
                <col style="width:80px;"/>
            </ehr:authorize>
        </colgroup>
        <thead>
        <tr>
            <th>姓名</th>
            <th>性别</th>
            <th>年龄</th>
            <th>家长姓名</th>
            <th>联系电话</th>
            <th>现住址</th>
            <th>发病日期</th>
            <th>就诊日期</th>
            <th>就诊医院</th>
            <th>是否住院</th>
            <th>状态</th>
            <ehr:authorize ifAnyGranted="${ZXCRB},${JKFYK},${YYCRB},${ZCRB}" >
                <th>操作</th>
            </ehr:authorize>
            <ehr:authorize ifAnyGranted=""><th>操作</th></ehr:authorize>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="report" items="${reports.list}" varStatus="status">
            <c:if test="${'1' == report.logoff}">
                <tr class="offedperson">
            </c:if>
            <c:if test="${'1' != report.logoff}">
                <tr>
            </c:if>
            <td>${empty report.nameF ? report.name : report.nameF}</td>
            <td class="centertd"><ehr:dic dicmeta="GBT226112003" code="${empty report.genderF ? report.gender : report.genderF}"/></td>
            <td>${empty report.ageF ? report.age : report.ageF}</td>
            <td>${empty report.parentsNameF? report.parentsName : report.parentsNameF}</td>
            <td>${empty report.phoneNumberF ? report.phoneNumber : report.phoneNumberF}</td>
            <td title="${empty report.paAddressF ? report.paAddress : report.paAddressF}">${empty report.paAddressF ? report.paAddress : report.paAddressF}</td>
            <td class="centertd"><fmt:formatDate value="${empty report.attackDt ? report.pathogenesisDate : report.attackDt}" pattern="yyyy/MM/dd"/></td>
            <td class="centertd"><fmt:formatDate value="${empty report.treatmentDt ? report.diagnosisDate : report.treatmentDt}" pattern="yyyy/MM/dd"/></td>
            <td title="${empty report.treatmentUnit ? report.fillOrganName : report.treatmentUnit}">${empty report.treatmentUnit ? report.fillOrganName : report.treatmentUnit}</td>
            <td><ehr:dic dicmeta="PH00001" code="${report.inHospital}"/></td>
            <td class="centertd">
                <c:choose>
                    <c:when test="${report.frStatus==1}">
                        未填写&nbsp;
                    </c:when>
                    <c:when test="${report.frStatus==2}">
                        已填写&nbsp;
                    </c:when>
                </c:choose>
            </td>
            <ehr:authorize ifAnyGranted="${ZXCRB},${JKFYK},${YYCRB},${ZCRB}" >
                <td class="centertd">
                    <c:choose>
                        <c:when test="${report.frStatus==1}">
                            <a href="javascript:void(0)" onclick="frSearch.initFr(${report.idmId},'${report.name}', '${report.logoff}')"
                               class="person-link-btn">随访填写</a>
                        </c:when>
                        <c:otherwise>
                            <%--<a href="javascript:void(0)" onclick="frSearch.initFr(${report.id},${report.idmId},'${report.infectiousCode}','${report.name}',2, '${report.logoff}')"--%>
                            <a href="javascript:void(0)" onclick="frSearch.initFr(${report.idmId},'${report.name}', '${report.logoff}')"
                               class="person-link-btn">随访修改</a>
                        </c:otherwise>
                    </c:choose>

                </td>
            </ehr:authorize>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <table>
        <tr>
            <ehr:pagination action="caseSearch.search"/>
        </tr>
    </table>
</div>