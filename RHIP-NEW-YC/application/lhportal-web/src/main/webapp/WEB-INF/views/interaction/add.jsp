<%@page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/ehr-tag" prefix="ehr" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/views/info/interaction.css"/>
<script src="${pageContext.request.contextPath}/js/views/interaction/common.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/interaction/add.js" type="text/javascript"></script>

<form method="post" id="interactionForm">
    <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
            <td align="right" class="lefttdbg">姓名：</td>
            <td>
                <input class="border-bottom" type="text" name="name" id="name" value="${accountInfo.realName}"/>
                <font color="red"> * </font>
                <span id="nameSpan"></span>
            </td>
        </tr>
        <tr>
            <td align="right" class="lefttdbg">联系电话：</td>
            <td>
                <input class="border-bottom" type="text" name="phoneNumber" id="phoneNumber"
                       value="${accountInfo.telephone}"/>
                <font color="red"> * </font>
                <span id="phoneNumberSpan"></span>
            </td>
        </tr>
        <tr>
            <td align="right" class="lefttdbg">联系邮箱：</td>
            <td>
                <input class="border-bottom" type="text" name="email" id="email" value="${accountInfo.email}"/>
            </td>
        </tr>
        <tr>
            <td align="right" class="lefttdbg">联系地址：</td>
            <td>
                <input class="border-bottom" type="text" name="address" id="address" value="${accountInfo.pastreet}"/>
            </td>
        </tr>
        <tr>
            <td align="right" class="lefttdbg">邮政编码：</td>
            <td>
                <input class="border-bottom" type="text" name="postcode" id="postcode"/>
            </td>
        </tr>
        <tr>
            <td align="right" class="lefttdbg">证件类型：</td>
            <td>
                <ehr:dic-list id="idcardType" dicmeta="PH00034" name="idcardType" reg="{'required':true}" value="0"/>
                <font color="red"> * </font>
                <span id="idcardTypeSpan"></span>
            </td>
        </tr>
        <tr>
            <td align="right" class="lefttdbg">证件号：</td>
            <td>
                <input class="border-bottom" type="text" name="idcard" id="idcard" value="${accountInfo.cardNo}"/>
                <font color="red"> * </font>
                <span id="idcardSpan"></span>
            </td>
        </tr>
        <tr>
            <td align="right" class="lefttdbg">咨询类型：</td>
            <td>
                <ehr:dic-list id="eventType" dicmeta="LH00002" name="eventType" reg="{'required':true}"/>
                <font color="red"> * </font>
                <span id="eventTypeSpan"></span>
            </td>
        </tr>
        <tr>
            <td align="right" class="lefttdbg">咨询对象：</td>
            <td>
                <select id="orgCode" name="orgCode">
                    <option value="" selected="selected">请选择</option>
                    <c:forEach items="${hospitalInfo}" var="unit">
                        <option value="${unit.hospitalNo}">${unit.hospitalName}</option>
                    </c:forEach>
                </select>
                <font color="red"> * </font>
                <span id="orgCodeSpan"></span>
            </td>
        </tr>
        <tr>
            <td align="right" class="lefttdbg">咨询主题：</td>
            <td>
                <input class="border-bottom" type="text" name="title" id="title" style="width:300px;"/>
                <font color="red"> * </font>
                <span id="titleSpan"></span>
            </td>
        </tr>
        <tr>
            <td align="right" class="lefttdbg">咨询内容：</td>
            <td>
                <textarea id="content" style="height:200px; width:550px" cols="20" rows="10" name="content"></textarea>
                <font color="red"> * </font>
                <span id="contentSpan"></span>
            </td>
        </tr>
        <tr>
            <td class="lefttdbg" align="right">&nbsp;</td>
            <td>
                <input id="submitIneractionId" type="button" class="submitInput"/>
                <input id="clearIneractionId" type="button" class="clearInput"/>
            </td>
        </tr>
    </table>
</form>