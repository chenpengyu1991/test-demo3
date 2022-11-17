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
            <th>机构名称</th>
            <th>检查方法</th>
            <th>检查人数</th>
            <th>阳性人数</th>
            <th>管理人数</th>
        </tr>
        </thead>
        <c:forEach var="list" items="${list}" varStatus="status">
            <tr >
                <%--<td class="centertd"><ehr:dic dicmeta="FS990001" code="${list.T1}" /></td>
                <td class="centertd">血检</td>
                <td class="centertd">${list.NN}</td>
                <td class="centertd">${list.NN1}</td>
                <td class="centertd">${list.NN1}</td>--%>
                <td class="centertd">${list.ORGAN_NAME}</td>
                <td>血检</td>
                <td class="righttd">${list.cn1}</td>
                <td class="righttd">${list.cn2}</td>
                <td class="righttd">${list.cn3}</td>
            </tr>
        </c:forEach>
       <c:forEach var="list1" items="${list1}" varStatus="status">
       <tr >
            <td class="centertd">合计</td>
            <td></td>
            <td class="righttd">${list1.cn1}</td>
            <td class="righttd">${list1.cn2}</td>
            <td class="righttd">${list1.cn3}</td>
        </tr>
        </c:forEach>
    </table>


    <table>
        <tr>

        </tr>
    </table>
</div>