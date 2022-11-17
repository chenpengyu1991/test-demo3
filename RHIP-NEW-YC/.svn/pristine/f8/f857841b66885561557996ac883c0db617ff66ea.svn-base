<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<script src="${pageContext.request.contextPath}/js/views/ehr/person/houseHoldList.js" type="text/javascript"></script>
<div>
    <form id="modifyhouseHoldForm" method="post" action="">
        <table id="houseSearch">
            <colgroup>
                <col style="width: 40%"/>
                <col style="width: 60%"/>
            </colgroup>
            <tbody>
            <td class="houseName">修改小区名称：</td>
            <td><input type="text" name="houseHoldName" id="houseHoldName" style="width: 60%"/></td>
            </tbody>
        </table>
    </form>
    <p style="margin-top: 15px;" align="center">
        <input type="button" id="button_save" name="save" value="保 存" class="btnopr" onclick="houseHoldPagination.modifysave(${itemCode})"/>
        <input type="button" id="cancelButton" name="save" value="关 闭" class="btnopr" onclick="houseHoldPagination.cancelmodify()"/>
    </p>
</div>

