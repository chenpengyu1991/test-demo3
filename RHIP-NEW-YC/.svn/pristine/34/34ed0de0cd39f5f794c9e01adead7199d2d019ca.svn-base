<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<script src="${pageContext.request.contextPath}/js/views/ehr/person/houseHoldList.js" type="text/javascript"></script>
<div>
    <br/>
    <br/>
    <form id="AddhouseHoldForm" method="post" action="">
        <table id="houseSearch">
            <colgroup>
                <col style="width: 50%"/>
                <col style="width: 50%"/>
            </colgroup>
            <tbody>
            <tr>
                <td align="center"><b>居委会名称：</b></td>
                <td align="left">
                    <select id="vaillagecode" style="width: 80%" name="vaillagecode">
                        <c:forEach items="${dicItems}" var="houseHoldLists">
                            <option value="${houseHoldLists.itemCode}">${houseHoldLists.itemName}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td class="houseName" align="center"><b>小区名称：</b></td>
                <td align="left"><input type="text" name="houseHoldName" id="houseHoldName" style="width: 80%"/></td>
            </tr>
            </tbody>
            <input class="hide" />
        </table>
    </form>
    <p style="margin-top: 15px;" align="center">
        <input type="button" id="button_save" name="save" value="保 存" class="btnopr" onclick="houseHoldPagination.saveCover()"/>
        <input type="button" id="cancelButton" name="save" value="关 闭" class="btnopr" onclick="houseHoldPagination.cancelCover()"/>
    </p>
</div>

