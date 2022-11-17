<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="com.founder.rhip.mdm.common.OrgGenreCode" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>

<div class="repeattable">
    <table class="layui-table x-admin-sm-table-list-middle">
        <colgroup>
        </colgroup>
        <thead>
        <tr>
            <th>机构</th>
            <th>抗菌药物名称</th>
            <th>数量</th>
            <th>查看医生</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="antibacterial" items="${antibacterialList}" varStatus="status">
            <tr>
                <td><ehr:org code="${antibacterial.ORG_CODE}"></ehr:org></td>
                <td>
                        ${antibacterial.DRUG_NAME}
                </td>
                <td>${antibacterial.ALL_NUM}</td>
                <td>
                <a class="basicIndex layui-btn layui-btn-normal layui-btn-xs" onclick="pamOrgSearch.viewDoctorDetail('${antibacterial.ORG_CODE}','${antibacterial.DRUG_CODE}')" href="#" title="查看" data-person-id="2933035" style="color: #FFF;"><i class="layui-icon"></i>查看</a>
                
                
            </tr>

        </c:forEach>
        </tbody>
    </table>
    <table>
        <tr>
            <%--<ehr:pagination action="pamOrgSearch.search" />--%>
        </tr>
    </table>
</div>
