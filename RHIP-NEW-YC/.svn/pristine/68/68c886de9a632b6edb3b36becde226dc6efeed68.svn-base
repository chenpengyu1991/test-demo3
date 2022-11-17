<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>

<div class="repeattable">
    <table class="layui-table x-admin-sm-table-list-middle">
        <colgroup>
            <col style="min-width:60px;width: 20%;"/>
            <col style="min-width:40px;width: 11%;"/>
            <col style="min-width:40px;width: 20%;"/>
            <col style="min-width:40px;width: 20%;"/>
            <col style="min-width:50px;width: 8%;"/>
        </colgroup>
        <thead>
        <tr>
            <th>参数名称</th>
            <th>描述</th>
            <th>值</th>
            <th>状态</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="result" items="${sysConfigList}" varStatus="status">
            <tr>
                <td class="centertd"><ehr:tip>${result.name}</ehr:tip></td>
                <td class="centertd"><ehr:tip>${result.description}</ehr:tip></td>
                <td class="centertd">${result.value}</td>
                <td class="centertd">
                    <c:choose>
                        <c:when test="${result.valid eq '1'}">
                            开启
                        </c:when>
                        <c:otherwise>
                            关闭
                        </c:otherwise>
                    </c:choose>
                </td>
                <td class="centertd">
                    <a href="javascript:void(0)" class="modifyConfigBtn" data-id ="${result.id}">
                        <button class="layui-btn layui-btn-xs"><i class="layui-icon">&#xe642;</i>修改</button>
                    </a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>