<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<script src="${pageContext.request.contextPath}/js/views/ihm/cwhTarget/child/search.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/ehr/child/familyVisit/familyVisit.js" type="text/javascript"></script>
<div class="section" id="child-exam-list-box">
    <div class="searchBox">
    	<div class="toolbar">
				          <a href="javascript:void(0)" id="followup-add-btn"><b class="xinz">新增</b></a>
    </div>
        <input type="hidden" id="pageIndex" value="${pageIndex}">
        <input type="hidden" id="searchType" value="${searchType}">
        <form id="searchForm">
            <table id="searchTable">
                <colgroup>
                    <col style="width: 10%; min-width: 70px;"/>
                    <col style="width: 25%; min-width: 70px;"/>
                    <col style="width: 10%; min-width: 70px;"/>
                    <col style="width: 15%; min-width: 70px;"/>
                    <col style="width: 5%; min-width: 70px;"/>
                    <col style="width: 20%; min-width: 70px;"/>
                    <col/>
                </colgroup>
                <tbody>
                <tr>
                    <td class="col-text">新生儿姓名</td>
                    <td class="col-input">
                        <input type="text" name="name" style="width: 76%">
                    </td>
                    
                    <td class="col-text">出生日期</td>
                    <td class="col-input" colspan="2">
                        <tag:dateInput name="birthday" onlypast="true" style="width:37%;"></tag:dateInput>
                        ~
                        <tag:dateInput name="birthdayEnd" id="birthday" style="width:37%;" onlypast="true"/>
                    </td>
                    <td class="col-text">新生儿性别</td>
                    <td class="col-input">
                        <ehr:dic-list name="gender" dicmeta="GBT226112003"></ehr:dic-list>
                    </td>
                </tr>
                <tr>
                    <td class="col-text">访视机构</td>
                    <td class="col-input">
                        <input type="hidden" id="genreCode" name="genreCode"/>
                        <tag:autoSelect name="organCode" id="organCode" style="width:180px" ></tag:autoSelect>
                    </td>
                    <td class="col-text">访视日期</td>
                    <td class="col-input" colspan="2">
                    	<tag:dateInput name="createDate" id="createDate" style="width:37%;" />
                    	~
                        <tag:dateInput name="createDateEnd" id="createDate" style="width:37%;" />
                    </td>
                    <td style="text-align: center;" colspan="2">
                        <input type="button" id="btnSearch" value="查询" onclick="" class="search_btn" />
                    </td>
                </tr>
                </tbody>
            </table>
            <table>
                <tr>
                    <td colspan="4" class="col-bottom"><span onclick="toggle(this,'searchTable')" class="ico-bottom">&nbsp;</span></td>
                </tr>
            </table>
        </form>
    </div>
    <div id="childListDiv">
        <%--<jsp:include page="${listpath}"></jsp:include>--%>
    </div>
</div>
<div id="child-exam-input-box"></div>