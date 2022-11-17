<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<script src="${pageContext.request.contextPath}/js/views/ihm/cwhTarget/woman/search.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/ihm/cwhTarget/cwhCommon.js" type="text/javascript"></script>
<div class="section">
	<div class="searchBox">
		<input type="hidden" id="pageIndex" value="${pageIndex}">
		<input type="hidden" id="searchType" value="${searchType}">
		<form id="searchForm">
            <table id="searchTable">
                <colgroup>
                    <col style="width: 10%; min-width: 70px;"/>
                    <col style="width: 25%; min-width: 70px;"/>
                    <col style="width: 10%; min-width: 70px;"/>
                    <col style="width: 15%; min-width: 70px;"/>
                    <col style="width: 10%; min-width: 70px;"/>
                    <col style="width: 15%; min-width: 70px;"/>
                    <col/>
                </colgroup>
                <tbody>
                <tr>
                    <td class="col-text">新生儿姓名</td>
                    <td class="col-input">
                        <input type="text" name="name" >
                    </td>
                    <td class="col-text">新生儿性别</td>
                    <td class="col-input">
                        <ehr:dic-list name="gender" dicmeta="GBT226112003"></ehr:dic-list>
                    </td>
                    <td class="col-text">出生日期</td>
                    <td class="col-input">
                        <tag:dateInput name="birthday" onlypast="true"></tag:dateInput>
                    </td>
                    <td></td>
                </tr>
                <tr>
                    <td class="col-text">签证机构</td>
                    <td class="col-input">
                        <input type="hidden" id="genreCode" name="genreCode"/>
                        <tag:autoSelect name="organCode" id="organCode" style="width:180px" ></tag:autoSelect>
                    </td>
                    <td class="col-text">签证日期</td>
                    <td class="col-input">
                        <tag:dateInput name="createDate" onlypast="true"></tag:dateInput>
                    </td>
                    <td></td>
                    <td></td>
                    <td style="text-align: right;">
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
	<div id="womanListDiv">
		<%--<jsp:include page="${listpath}"></jsp:include>--%>
	</div>
</div>