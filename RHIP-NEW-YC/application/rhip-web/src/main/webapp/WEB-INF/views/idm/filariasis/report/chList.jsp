<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ page import="com.founder.rhip.idm.common.MalariaStatus" %>
<c:set var="VERIFY" value="<%=MalariaStatus.VERIFY.getValue()%>" />
<c:set var="WRITE" value="<%=MalariaStatus.WRITE.getValue()%>" />
<div class="repeattable">
    <table class="layui-table x-admin-sm-table-list-middle" align="center">
        <thead>
        <tr>
        <th rowspan="3">市(县、乡、村)</th>
        <th colspan="5">新建档慢性丝虫病患者人数</th>
        <th colspan="5">累计建档慢性丝虫病患者人数</th>
    </tr>
        <tr>
            <th rowspan="2">患者人数</th>
            <th colspan="4">其中</th>
            <th rowspan="2">患者人数</th>
            <th colspan="4">其中</th>
        </tr>
        <tr>
            <th>象皮肿</th>
            <th>乳糜尿</th>
            <th>鞘膜积液</th>
            <th>淋巴管(结)炎</th>
            <th>象皮肿</th>
            <th>乳糜尿</th>
            <th>鞘膜积液</th>
            <th>淋巴管(结)炎</th>
        </tr>
        </thead>

          <c:forEach var="list" items="${list}" varStatus="status">
        <tr>


        <td class="centertd"><ehr:dic dicmeta="FS990001" code="${list.town}" /></td>
        <td class="righttd">${list.t1}</td>
        <td class="righttd">${list.t2}</td>
        <td class="righttd">${list.t3}</td>
        <td class="righttd">${list.t4}</td>
        <td class="righttd">${list.t5}</td>
        <td class="righttd">${list.s1}</td>
        <td class="righttd">${list.s2}</td>
        <td class="righttd">${list.s3}</td>
        <td class="righttd">${list.s4}</td>
        <td class="righttd">${list.s5}</td>
        </tr>
        </c:forEach>
        <c:forEach var="list2" items="${list2}" varStatus="status">
        <tr>
            <th class="centertd">合计</th>
            <td class="righttd">${list2.t1}</td>
            <td class="righttd">${list2.t2}</td>
            <td class="righttd">${list2.t3}</td>
            <td class="righttd">${list2.t4}</td>
            <td class="righttd">${list2.t5}</td>
            <td class="righttd">${list2.s1}</td>
            <td class="righttd">${list2.s2}</td>
            <td class="righttd">${list2.s3}</td>
            <td class="righttd">${list2.s4}</td>
            <td class="righttd">${list2.s5}</td>




        </tr>
        </c:forEach>
    </table>

    <table>
        <tr>
           <%--<ehr:pagination action="filStandard.searchFollowup" />--%>
        </tr>
    </table>
</div>