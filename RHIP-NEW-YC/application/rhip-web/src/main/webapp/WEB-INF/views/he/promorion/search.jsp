<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>

<%@ page import="com.founder.rhip.ehr.common.RoleType" %>
<c:set var="ADMIN" value="<%=RoleType.ADMIN.getValue()%>" />

<script src="${pageContext.request.contextPath}/js/views/he/promorion/search.js" type="text/javascript"></script>
<%--<script src="${pageContext.request.contextPath}/js/views/he/promorion/hpAdd.js" type="text/javascript"></script>--%>

<div class="section" id="mainSearchDiv">
    <div class="toolbar">
        <a id="activeAdd" href="javascript:void(0)"><b id="btnReflashLabel" class="xinz">新增</b></a>
    </div>
    <div class="searchBox">
        <form id="form_search">
            <table id="healthPromorionSearch">
                <colgroup>
                    <col style="width: 15%;" />
                    <col style="width: 25%;" />
                    <col style="width: 15%;"/>
                    <col style="width: 25%;" />
                    <col style="width: 10%;"/>
                </colgroup>
                <tbody>
                <tr>
                    <td class="col-text">宣传标题</td>
                    <td class="col-input"><input type="text" name="promorionTitle" id="promorionTitleId" /></td>
                    <td class="col-text">创建时间</td>
                    <td class="col-input">
                        <tag:dateInput name="createBeginTime" id="createBeginTime"  style="width: 100px;"/>~<tag:dateInput name="createEndTime" id="createEndTime"  style="width: 100px;"/>
                    </td>
                    <td></td>
                </tr>
                <tr>
                    <td class="col-text">发布状态</td>
                    <td class="colinput">
                        <ehr:dic-list id="status" dicmeta="LH00007" name="status" reg="{'required':true}" width="45%"/>
                    </td>
                    <c:choose>
                        <c:when test="${ROLE==ADMIN}">
                            <td class="col-text">机构</td>
                            <td class="colinput">
                                <tag:autoSelect name="organCode" id="organCode" codeValue="${organCode}"
                                                style="width:200px;"></tag:autoSelect>
                            </td>
                        </c:when>
                        <c:otherwise>
                            <td colspan="2"></td>
                        </c:otherwise>
                    </c:choose>
                    <td>
                        <input type="button" id="healthPromorionSearchId" value="查询" class="search_btn" />
                    </td>
                </tr>
                </tbody>
            </table>
            <table>
                <tr>
                    <td colspan="4" class="col-bottom">
                        <span onclick="util.toggle(this,'healthPromorionSearch')" class="ico-bottom">&nbsp;</span></td>
                </tr>
            </table>
        </form>
    </div>

    <div id="listDiv"></div>
</div>
<div id="operationDiv"></div>