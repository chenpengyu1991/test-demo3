<%--
  Created by IntelliJ IDEA.
  User: chen.q
  Date: 15-6-19
  Time: 下午4:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>

<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery/jquery.PrintArea.js"></script>

<script type="text/javascript">
    <!--
    function printPrescription() {
        $("#printPrescription").printArea();
    }
    //-->
</script>

<div class="postcontent">
    <div class="postdiv">
        <fieldset style="height: 350px">
            <legend>详细信息</legend>
        <table class="posttable">
            <colgroup>
                <col style="width: 15%;"/>
                <col style="width: 35%;"/>
                <col style="width: 15%;"/>
                <col style="width: 35%;"/>
            </colgroup>
            <tr>
                <%-- <th>处方类别</th>
                <td style="vertical-align: top;">
                    ${healthPrescription.type}
                </td> --%>
                <th>处方名称</th>
                <td>
                    ${healthPrescription.name}
                </td>
                <th>创建时间</th>
                <td><fmt:formatDate value="${healthPrescription.createTime}" pattern="yyyy/MM/dd"/></td>
            </tr>
            <tr>
                <th>标题</th>
                <td>${healthPrescription.title}</td>
                <th></th>
                <td></td>
            </tr>
            <tr>
                <th>内容摘要</th>
                <td colspan="3">${healthPrescription.content}</td>
            </tr>
        </table>
        </fieldset>
    </div>
    <div id="printPrescription" style="display: none;">
        <div style="text-align: center;"><h3>${healthPrescription.title}</h3></div>
        <div style="padding: 15px;margin-top: 10px;">
            ${healthPrescription.content}
        </div>
    </div>
</div>
