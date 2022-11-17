<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<script src="${pageContext.request.contextPath}/js/views/cdm/highRisk135/question/otherQuestions.js" type="text/javascript"></script>
<%--<div class="toolbar" align="right">
	<a href="javascript:void(0)" id="backToSearchBtn"><b class="fanhui">返回</b></a>
	<a href="javascript:void(0)"  onclick="otherQuestions.editNewQuestion('${question.idNo}')" id="newQuestionBtn"><b class="xinz">新建问卷调查</b></a>
	<a href="javascript:void(0)" id="saveQuestionBtn"><b class="baocun">保存</b></a>
</div>--%>
<div style="float: left; width: 17%;" class="repeattable">
	<input type="hidden" id="qest1" />
	<table>
		<div class="toolbar" align="right">
			<a href="javascript:void(0)" onclick="otherquestion.editNewQuestion('${meNumber}')" ><b class="xinz"></b></a>
		</div>

		</thead>
		<thead>
			<tr>
				<th>调查日期</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${questions}" var="questions">
				<tr onclick="otherquestion.getPreFollowUpDetail('${questions.id}')" style="cursor: pointer;">
					<td>
						<input type="hidden" value="${questions.id}" class="otherQuestions" />
						<fmt:formatDate value="${questions.surveyDt}" pattern="yyyy/MM/dd"/>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
<div style="float: right; width: 82%">
	<div id="otherQuestionsDiv" style="position: relative;"></div>
</div>