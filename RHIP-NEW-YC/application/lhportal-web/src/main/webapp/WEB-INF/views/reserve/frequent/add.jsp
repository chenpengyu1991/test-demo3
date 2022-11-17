<%@page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<script src="${pageContext.request.contextPath}/js/views/interaction/common.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/reserve/frequent/add.js" type="text/javascript"></script>

<form method="post" id="frequentContactsForm">
    <input type="text" hidden="hidden" name="id" id="frequentId" value="${frequentContacts.id}">
    <table width="713" height="232" border="0" class="contact-panel">
    <tr>
        <td width="150" rowspan="8">
            <div class="contact-bg"></div>
        </td>
        <td colspan="4">
            &nbsp;
        </td>
    </tr>
    <tr>
        <th width="96"  align="right">
            姓名：
        </th>
        <td width="157">
           <input class="underline" type="text" name="frequentName" id="frequentName_id" maxlength="10" value="${frequentContacts.frequentName}"/>
        </td>
        <th width="90" align="right">
            性别：
        </th>
        <td width="161">
            <ehr:dic-radio dicmeta="FS10006" name="gender" reg="{'required':true}" value="${frequentContacts.gender}"/>
        </td>
    </tr>
    <tr>
        <th width="96"  align="right">
        </th>
        <td width="157">
           <span id="frequentNameSpan"><label class="required"></label></span>
        </td>
        <th width="90" align="right">
        </th>
        <td width="161">
            <span id="genderSpan"><label class="required"></label></span>
        </td>
    </tr>
    <tr>
        <th align="right">
            手机号码：
        </th>
        <td>
            <input class="underline" type="text" name="telephone" id="telephone" maxlength="11" value="${frequentContacts.telephone}"/>
        </td>
        <th align="right">
            身份证号码：
        </th>
        <td>
            <input class="underline" type="text" name="cardNo" id="cardNo" maxlength="18" value="${frequentContacts.cardNo}"/>
        </td>
    </tr>
    <tr>
        <th align="right">
        </th>
        <td>
            <span id="telephoneSpan"><label class="required"></label></span>
        </td>
        <th align="right">
        </th>
        <td>
            <span id="cardNoSpan"><label class="required"></label></span>
        </td>
    </tr>
    <tr>
        <th align="right">
            出生日期：
        </th>
        <td colspan="3">
           <tag:dateInput cssClass="underline"  name="birthday" date="${frequentContacts.birthday}" id="birthday" onlypast="true"/>
        </td>
    </tr>
    <tr>
        <th align="right">
        </th>
        <td colspan="3">
           <span id="birthdaySpan"><label class="required"></label></span>
        </td>
    </tr>
    <tr>
        <td colspan="2" style="text-align: right;">
            <input id="submitFrequentContacts" class="save-btn" type="button" value="保存"/>
            <input id="clearFrequentContacts" class="cancel-btn" type="button" value="取消"/>
        </td>
        <td>
            &nbsp;
        </td>
        <td>
            &nbsp;
        </td>
    </tr>
</table>
</form>
