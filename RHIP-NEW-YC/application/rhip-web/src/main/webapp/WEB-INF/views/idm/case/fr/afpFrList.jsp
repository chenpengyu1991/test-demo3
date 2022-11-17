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
<div class="repeattable">
    <table class="layui-table x-admin-sm-table-list-middle">
        <colgroup>
            <col style="min-width:60px;width: 8%;"/>
            <col style="min-width:40px;width: 7%;"/>
            <col style="min-width:80px;width: 10%;"/>
            <col style="min-width:120px;width: 18%;"/>
             <col style="min-width:90px;width: 13%;"/>
            <col style="min-width:110px;width: 25%;"/>
            <col style="min-width:80px;width: 15%;"/>
            <col style="width:80px;"/>
            <ehr:authorize ifAnyGranted="${ZXCRB},${JKFYK},${YYCRB},${ZCRB}" >
                <col style="width:100px;"/>
            </ehr:authorize>
        </colgroup>
        <thead>
        <tr>
            <th>姓名</th>
            <th>性别</th>
			<th>出生日期</th>
			<th>身份证号</th>
            <th>联系电话</th>
            <th>现住址</th>
        	<th>填写单位</th>
            <th>状态</th>
            <ehr:authorize ifAnyGranted="${ZXCRB},${JKFYK},${YYCRB},${ZCRB}" >
                <th>操作</th>
            </ehr:authorize>
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
            <td class="centertd">${empty report.nameF ? report.name : report.nameF}</td>
            <td class="centertd"><ehr:dic dicmeta="GBT226112003" code="${empty report.genderF ? report.gender : report.genderF}"/></td>
            <td class="centertd"><fmt:formatDate value="${report.birthday}" pattern="yyyy/MM/dd"/></td>
            <td class="centertd">${report.idcard}</td>
            <td class="centertd">${empty report.phoneNumberF ? report.phoneNumber : report.phoneNumberF}</td>
            <td title="${empty report.paAddressF ? report.paAddress : report.paAddressF}">${empty report.paAddressF ? report.paAddress : report.paAddressF}</td>
            <td><ehr:org code="${report.visitInst}"/></td> 
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
                            <%-- <a href="javascript:void(0)" onclick="frSearch.initFr(${report.idmId},'${report.name}', '${report.logoff}')"
                               class="person-link-btn">随访填写</a> --%>
                               <a href="javascript:void(0)" onclick="frSearch.initFr(${report.idmId},'${report.name}', '${report.logoff}')"
                               class="person-link-btn layui-btn layui-btn-xs" style="color: #FFF;font-size: 12px;" title="随访填写"><i class="layui-icon">&#xe642;</i>填写</a>
                        </c:when>
                        <c:otherwise>
                            <%--<a href="javascript:void(0)" onclick="frSearch.initFr(${report.id},${report.idmId},'${report.infectiousCode}','${report.name}',2, '${report.logoff}')"--%>
                            <%-- <a href="javascript:void(0)" onclick="frSearch.initFr(${report.idmId},'${report.name}', '${report.logoff}')"
                               class="person-link-btn">随访修改</a> --%>
                               
                               <a href="javascript:void(0)" onclick="frSearch.initFr(${report.idmId},'${report.name}', '${report.logoff}')"
                               class="person-link-btn layui-btn layui-btn-xs" style="color: #FFF;font-size: 12px;" title="随访修改"><i class="layui-icon">&#xe642;</i>修改</a>
                        </c:otherwise>
                    </c:choose>

                </td>
            </ehr:authorize>
            </tr>
        </c:forEach>
        <tr>
        	<ehr:authorize ifAnyGranted="${ZXCRB},${JKFYK},${YYCRB},${ZCRB}" >
	            <ehr:pagination action="caseSearch.search" colspan="9"/>
            </ehr:authorize>
            <ehr:authorize ifNotGranted="${ZXCRB},${JKFYK},${YYCRB},${ZCRB}" >
	            <ehr:pagination action="caseSearch.search" colspan="8"/>
            </ehr:authorize>
        </tr>
        </tbody>
    </table>

    <%-- <table>
        <tr>
            <ehr:pagination action="caseSearch.search"/>
        </tr>
    </table> --%>
</div>