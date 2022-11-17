<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<script src="${pageContext.request.contextPath}/js/views/ihm/cwhTarget/vaccine/search.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/ihm/cwhTarget/vaccine/vaccineCommon.js" type="text/javascript"></script>
<div class="section">
	<div class="searchBox">
		<input type="hidden" id="vaccinePageIndex" value="${pageIndex}">
		<input type="hidden" id="queryPath" value="${queryPath}">
		<form id="vaccineSearchForm">
			<table id="vaccineSearch">
				<colgroup>
                	<col style="width: 10%; min-width: 50px;"/>
                    <col style="width: 20%; min-width: 250px;"/>
					<col style="width: 10%; min-width: 50px;"/>
                    <col style="width: 20%; min-width: 250px;"/>
                    <col style="width: 10%; min-width: 50px;"/>
                    <col style="width: 20%; min-width: 250px;"/>
                    <col/>
				</colgroup>
				<tbody>
					<tr>
                        <td class="col-text">时间</td>
                        <td class="col-input">
                        	<tag:dateInput name="beginDate" pattern="${pattern}" id="beginDate" maxId="endDate" onlypast="true" style="width: 80px;"/>
                          	~<tag:dateInput name="endDate" pattern="${pattern}" id="endDate" minId="beginDate" onlypast="true"  style="width: 80px;"/>
                        </td>
						<td class="col-text">机构</td>
						<td class="col-input">
							<input type="hidden" id="genreCode" name="genreCode"/>
							<tag:autoSelect name="organCode" id="organCode" style="width:180px" ></tag:autoSelect>
						</td>
					    <td class="col-text">姓名</td>
                        <td class="col-input">
                            <input type="text" name="name" style="width:180px"/> 
                        </td>
                    </tr>
					<tr>  
                        <td class="col-text">身份证号</td>
                        <td class="col-input">
                            <input type="text" name="idcard" style="width:180px"/> 
                        </td>
                        <td class="col-text">受接种者编号</td>
                        <td class="col-input">
                            <input type="text" name="vaccinationCode" style="width:180px"/> 
                        </td>
					    <td class="col-text">父亲姓名</td>
                        <td class="col-input">
                            <input type="text" name="fatherName" style="width:180px"/> 
                        </td>
                     </tr>
					<tr>
                        <td class="col-text">父亲身份证号</td>
                        <td class="col-input">
                            <input type="text" name="fatherIdcard" style="width:180px"/> 
                        </td>
                        <td class="col-text">母亲姓名</td>
                        <td class="col-input">
                            <input type="text" name="motherName" style="width:180px"/> 
                        </td>
					    <td class="col-text">母亲身份证号</td>
                        <td class="col-input">
                            <input type="text" name="motherIdcard" style="width:180px"/> 
                        </td>
                        <td style="text-align: left;">
							<input type="button" id="vaccineBtnSearch" value="查询" onclick="" class="search_btn" />
						</td>
					</tr>
				</tbody>
			</table>
			<table>
				<tr>
					<td colspan="4" class="col-bottom"><span
						onclick="toggle(this,'vaccineSearch')"
						class="ico-bottom">&nbsp;</span></td>
				</tr>
			</table>

		</form>
	</div>
	<div id="vaccineDiv">
		<jsp:include page="${listpage}"></jsp:include>
	</div>
</div>