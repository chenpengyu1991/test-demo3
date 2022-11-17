<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div class="repeattable">
		<input type="hidden" id="weight" value="${weight}"/>
		<input type="hidden" id="hepatitisB" value="${hepatitisB}"/>	
		<input type="hidden" id="bloodfat" value="${bloodfat}"/>		
<table id="person_record_table">
    <colgroup>
        <col style="width:15%;"/>
        <col style="width:15%;"/>
        <col style="width:15%;"/>
        <col style="width:20%;"/>
        <col style="width:35%;"/>
    <colgroup>
		<thead> 
			<tr>
				<th>姓名</th>
				<th>年龄</th>
				<th>体检时间</th>
				<th>体检类型</th>
				<th>体检机构</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${healthExaminationList}" var="healthExam">
				<tr>
					<td style="text-align: center">
						<c:choose>
							<c:when test="${healthExam.physicalExamType == '33'}"><%--学生体检--%>
								<a href="#" onclick="examSpecialJS.viewExam('${healthExam.personId}', '${healthExam.ehrId}')">${healthExam.name}</a>
							</c:when>
							<c:when test="${healthExam.physicalExamType == '39'}">
								<a class="cd-view-link" href="javascript:void(0);" data-ehrid="${healthExam.ehrId}" data-personid="${healthExam.personId}">${healthExam.name}</a>
							</c:when>
                            <c:when test="${healthExam.physicalExamType == '31'}"><%--老年人体检--%>
                                <a class="hm-view-link" href="javascript:void(0);" data-person-id="${healthExam.personId}" data-physicalexamcode="${healthExam.physicalExamCode}" >${healthExam.name}</a>
                            </c:when>
							<c:otherwise>
								<a href="${pageContext.request.contextPath}/physicalExam/index/${healthExam.personId}/${healthExam.ehrId}" class="examLinkClass">${healthExam.name}</a>
							</c:otherwise>
						</c:choose>
					</td>
					<td style="text-align: center" >
                        <c:choose>
                            <c:when test="${healthExam.physicalExamType == '33'}">
                                <c:if test="${healthExam.age ne '0天'}">
                                    ${healthExam.age}
                                </c:if>
                            </c:when>
                            <c:otherwise>
                                ${healthExam.age}
                            </c:otherwise>
                        </c:choose>
					</td>
					<td style="text-align: center">
						<fmt:formatDate value="${healthExam.examinationDate}" pattern="yyyy/MM/dd"/>
					</td>
					<td style="text-align: center">
						<ehr:dic code="${healthExam.physicalExamType}" dicmeta="PH00021"/>
					</td>
					<td style="text-align: center">
						<c:choose>
						<c:when test="${healthExam.hospitalName !=null}">${healthExam.hospitalName}</c:when>
						<c:otherwise><ehr:org code="${healthExam.hospitalCode}"></ehr:org></c:otherwise>
						</c:choose>
						
					</td>
				</tr>
			</c:forEach>
		</tbody> 
		<tr>
            <%--1体检专项查询，2指标分析查询--%>
            <c:if test="${flag eq 1}">
			    <ehr:pagination action="examSpecialJS.searcjExamSpecial" colspan="5"/>
            </c:if>
            <c:if test="${flag eq 2}">
                <td style="display: none">
                    <form method="post" id="analyzeSearchFormSearchBar">
                    <input type="text" value="${weight}" name="weight" />
                    <input type="text" value="${hepatitisB}" name="hepatitisB" />
                    <input type="text" value="${bloodfat}" name="bloodfat" />
                    </form>
                </td>
                <ehr:pagination action="examSpecialJS.examAnalyze" colspan="5"/>
            </c:if>
        </tr>
	</table>
</div>