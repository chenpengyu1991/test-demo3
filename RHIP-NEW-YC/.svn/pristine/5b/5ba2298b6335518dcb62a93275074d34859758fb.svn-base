<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ page import="com.founder.rhip.idm.common.MalariaStatus" %>
<c:set var="VERIFY" value="<%=MalariaStatus.VERIFY.getValue()%>" />
<c:set var="WRITE" value="<%=MalariaStatus.WRITE.getValue()%>" />

<div class="postcontent" style="height: 25px;">
    <i class="popno">
        ${rootDicItem.itemName}${time}月户籍人口血吸虫病监测月报
    </i>
</div>
<div class="repeattable">
    <table align="center" class="layui-table x-admin-sm-table-list-middle">
        <thead>
        <tr>
            <th rowspan="3" class="centertd">镇</th>
            <th rowspan="3">村</th>
            <%--<th rowspan="3">查病村（单位）数</th>--%>
            <th rowspan="3">期内检查人数</th>
            <th colspan="3">其中</th>
            <th colspan="4">检查结果</th>
    </tr>
        <tr>
            <th rowspan="2">DDIA检查人数</th>
            <th rowspan="2">COPT检查人数</th>
            <th rowspan="2">粪检人数</th>
            <th rowspan="2">DDIA阳性人数</th>
            <th colspan="2">环卵试验（个）</th>
            <th rowspan="2">粪检阳性人数</th>
        </tr>
        <tr>
            <%-- <th>1%</th>
            <th>2%</th>--%>
            <th>≥3%</th>
            <th>阴性</th>
        </tr>
        </thead>
        <tbody>
<c:forEach var="list" items="${list}" varStatus="status">
        <tr>
            <td class="centertd"><ehr:dic dicmeta="FS990001" code="${list.PATOWN_SHIP}" /></td>
            <td class="centertd"><ehr:dic dicmeta="FS990001" code="${list.PASTREET}" /></td>
            <td class="righttd">${list.ddia_all}</td>
            <td class="righttd">${list.ddia_all}</td>
            <td class="righttd">${list.COPT_DT}</td>
            <td class="righttd">${list.STOOL_DT}</td>
            <td class="righttd">${list.DDIA}</td>
            <td class="righttd">${list.COPT1}</td>
            <td class="righttd">${list.COPT2}</td>
            <td class="righttd">${list.STOOL}</td>
        </tr>
</c:forEach>
<c:forEach var="list2" items="${list2}" varStatus="status">
    <tr>
        <td class="centertd" colspan="2">合计</td>
        <td class="righttd">${list2.ddia_all}</td>
        <td class="righttd">${list2.ddia_all}</td>
        <td class="righttd">${list2.COPT_DT}</td>
        <td class="righttd">${list2.STOOL_DT}</td>
        <td class="righttd">${list2.DDIA}</td>
        <td class="righttd"> ${list2.COPT1}</td>
        <td class="righttd">${list2.COPT2}</td>
        <td class="righttd">${list2.STOOL}</td>
    </tr>

</c:forEach>

        </tbody>


    </table>
</div>

