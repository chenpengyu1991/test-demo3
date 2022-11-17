<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<link href="${pageContext.request.contextPath}/css/views/physicalExam/examSpecial.css" type="text/css"  rel="stylesheet" />
<script src="${pageContext.request.contextPath}/js/views/ehr/physicalExam/search.js" type="text/javascript"></script>
<!--<div id="main-search"> -->
<div class="section">
	<div class="searchbox">
		<form method="post" id="examSpecialSearchForm">
			<table id="reportSearch">
				<colgroup>
					<col style="width: 10%">
					<col style="width: 23%">
					<col style="width: 10%">
					<col style="width: 23%">
					<col style="width: 10%">
					<col style="width: 23%">
				</colgroup>
				<tbody>
					<tr>
						<td class="coltext">姓名</td>
						<td class="colinput">
							<input type="text" id="name" name="name" style="width: 80%;"/>
						</td>
						<td class="coltext">身份证号</td>
						<td class="colinput">
							<input type="text" id="idcard" name="idcard" style="width: 80%;"/>
						</td>
						<td class="coltext"><label class="required">体检时间</label></td>
						<td class="colinput">
							<tag:dateInput id="beginDateId" name="beginDate" onlypast="true" date="${currentBeginDate}" reg="{'required':'true'}" style="width: 40%;"></tag:dateInput>
							~ <tag:dateInput id="endDateId" name="endDate" onlypast="true" date="${currentEndDate}" reg="{'required':'true'}" style="width: 40%;"></tag:dateInput>
						</td>
					</tr>
					<tr>
						<td class="coltext">体检机构</td>
						<td class="colinput">
                            <ehr:authorize ifAnyGranted="03">
                                <c:set var="isCenter" value="true" scope="request" />
                            </ehr:authorize>
                           <c:choose>
                               <c:when test="${isCenter ==true}" >
                                   <ehr:dic-org-list name="phyExamOrg" width="50%;" id="phyExamOrg"></ehr:dic-org-list>
                               </c:when>
                               <c:otherwise>
                                   <tag:autoSelect reg="{'required':true}"  name="phyExamOrg" id="phyExamOrg" ></tag:autoSelect>
                               </c:otherwise>
                           </c:choose>
						</td>
						<td class="coltext">体检类型</td>
						<td class="colinput">
							<ehr:dic-list id="phyType" name="phyType" dicmeta="PH00021" defaultval="32" width="80%"></ehr:dic-list>
						</td>
						<td  class="coltext">
						</td>
						<td class="colinput">
							<input type="button" id="search_btn" class="search_btn" value="查询" />
							<c:if test="${flag eq 'lda'}">
								<input type="button" id="analyze_btn" class="search_btn" value="指标分析" />
							</c:if>
						</td>
					</tr>
				</tbody>
			</table>
			<table>
                <tr>
                    <td colspan="6" class="colbottom">
                          <span onclick="examSpecialJS.toggle(this,'reportSearch')" class="ico-bottom">&nbsp;</span>
                    </td>
                </tr>
			</table>
		</form>
	</div>
<!--</div> -->
<div id="examSearchListDiv"></div>
</div>