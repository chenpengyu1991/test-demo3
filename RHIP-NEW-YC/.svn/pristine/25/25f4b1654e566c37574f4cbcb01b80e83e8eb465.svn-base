<%--
  Created by IntelliJ IDEA.
  User: jingqiu
  Date: 17-3-24
  Time: 上午10:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/views/ehrbrowser/basic/basic.css"/>
<div class="repeattable x-admin-sm">
    <table class="layui-table x-admin-sm-table-list-middle">
        <colgroup>
            <col style="width: 7%;" />
            <col style="width: 26%;" />
            <col style="width: 7%;" />
            <col style="width: 26%;" />
            <col style="width: 7%;" />
            <col style="width: 26%;" />
        </colgroup>
        <tr>
            <th>姓名</th>
            <td><ehr:tip>${exam.name}</ehr:tip></td>
            <th>出生编号</th>
            <td><ehr:tip>${exam.babyCardNo}</ehr:tip></td>
            <th>出生日期</th>
            <td><ehr:tip><fmt:formatDate value="${exam.birthday}" pattern="yyyy/MM/dd" /></ehr:tip></td>
        </tr>
        <tr>
            <th>性别</th>
            <td><ehr:tip><ehr:dic dicmeta="GBT226112003" code="${exam.gender}" /></ehr:tip></td>
            <th>身份证号</th>
            <td><ehr:tip>${exam.idCard}</ehr:tip></td>
            <th>母亲身份证号</th>
            <td><ehr:tip>${exam.motherIdcard}</ehr:tip></td>
        </tr>
        <tr>
            <th>现住地址</th>
            <td colspan="3">
                <ehr:dic code="${exam.pacounty}" dicmeta="FS990001" />
                <ehr:dic code="${exam.patownShip}" dicmeta="FS990001" />
                <ehr:dic code="${exam.pastreet}" dicmeta="FS990001" />
                ${exam.pahouseNumber}
            </td>
            <th>联系电话</th>
            <td><ehr:tip>${exam.telNumber}</ehr:tip></td>
        </tr>
    </table>
</div>