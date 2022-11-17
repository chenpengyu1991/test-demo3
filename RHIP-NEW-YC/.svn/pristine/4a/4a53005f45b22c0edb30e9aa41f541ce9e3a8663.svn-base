<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<link href="${pageContext.request.contextPath}/css/physicalExam/examSpecial.css" type="text/css"  rel="stylesheet" />
<style  type="text/css">
	.dt {
		background:#eeeeee;
	    color:#4a4a4a;
	    font-size: 14px;
	    font-weight:bold;
	    width:80px;
		padding-left:5px;
		padding-right:5px;
		border-bottom: 1px solid #666;
	}
	.dd{
		margin:5px 0;
	    padding:5px 0;
	    border-bottom: 1px solid #666;
		}
</style>
<script src="${pageContext.request.contextPath}/js/views/ehr/physicalExam/report.js" type="text/javascript"></script>
<div id="reportDialog">
	<input type="hidden" id="ehr_id" value="${healthExamination.ehrId}"/>
	<input type="hidden" id="person_id" value="${healthExamination.personId}"/>
	<table>
		<tr>
<!-- 			<td style="text-align: center;"><input class="search_btn" type="button" id="preBtn" value="上一页"/></td> -->
			<td>
				<table style="width:85%;">
				  <tr>
				  	<td colspan="2" style="text-align: center;"><h1>体检报告</h1><br/><br/><br/><br/></td>
				  </tr>
				  <tr>
				    <td class="dt">编&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号：</td>
				    <td class="dd">${healthExamination.physicalExamCode}</td>
				  </tr>
				  <tr>
				    <td height="2" colspan="2"></td>
				  </tr>
				  <tr>
				    <td class="dt">体检机构：</td>
				    <td class="dd">${healthExamination.hospitalName}</td>
				  </tr>
				    <tr>
				    <td height="2" colspan="2"></td>
				  </tr>
				  <tr>
				    <td class="dt">姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名：</td>
				    <td class="dd">${healthExamination.name}</td>
				  </tr>
				    <tr>
				    <td height="2" colspan="2"></td>
				  </tr>
				  <tr>
				    <td class="dt">性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别：</td>
				    <td class="dd"><ehr:dic dicmeta="GBT226112003" code="${healthExamination.gender}"/></td>
				  </tr>
				    <tr>
				    <td height="2" colspan="2"></td>
				  </tr>
				  <tr>
				    <td class="dt">年&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;龄：</td>
				    <td class="dd">${healthExamination.age}</td>
				  </tr>
				</table><br/><br/>
				<c:if test="${not empty observationInfos}">
					<div style="width: 100%;text-align: left;">
						<div class="repeattable">
							<div style="text-align:left;width:85%;font-size: 15px;height:100%;margin: 0 auto;">
							一般观察
							</div>
							<div style="width:85%;height:100%;margin: 0 auto;">
							<table>
								<thead>
									<tr>
										<th>项目名称</th>
										<th>观察结果</th>
										<th>观察结果单位</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${observationInfos}" var="ob">
										<tr>
											<td>${ob.observationItemName}</td>
											<td>${ob.observationResult}</td>
											<td>${ob.observationUnitName}</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
							</div>
						</div>
						<br/><br/>
					</div>
				</c:if>
                <c:if test="${not empty examEvents}">
                    <c:forEach items="${examEvents}" var="exam">
                        <div style="width: 100%;text-align: left;">
                            <div class="repeattable">
                                <c:set value="${exam.examDetails}" var="examDetails"></c:set>
                                <c:if test="${not empty examDetails}">
                                    <div style="text-align:left;width:85%;font-size: 15px;height:100%;margin: 0 auto;">
                                            ${exam.CHECK_LIST_TITLE}
                                    </div>
                                    <div style="width:85%;height:100%;margin: 0 auto;">
                                        <table>
                                            <thead>
                                            <tr>
                                                <th>检验项目</th>
                                                <th>结果</th>
                                                <th>参考范围</th>
                                                <th>单位</th>
                                                <th>提示</th>
                                            </tr>
                                            </thead>
                                            <tbody>
                                            <c:forEach items="${examDetails}" var="detail">
                                                <tr>
                                                    <td><ehr:tip>${detail.inspectionItemName}</ehr:tip></td>
                                                    <td>${detail.inspectionResult}</td>
                                                    <td>${detail.referenceRange}</td>
                                                    <td>${detail.inspectionUnit}</td>
                                                    <td>
                                                        <c:choose>
                                                            <c:when test="${detail.prompt eq '0'}">
                                                            </c:when>
                                                            <c:otherwise>
                                                                <c:out value="${detail.prompt}"></c:out>
                                                            </c:otherwise>
                                                        </c:choose>
                                                    </td>
                                                </tr>
                                            </c:forEach>
                                            </tbody>
                                        </table>
                                    </div>
                                </c:if>
                            </div>
                            <c:if test="${not empty examDetails}">
                                <div style="width:85%;height:100%;margin: 0 auto;">
                                    <table>
                                        <tr style="text-align: right;">
                                            <td>检验医生：<c:out value="${exam.CHECK_PEOPLE_NAME}"/></td>
                                            <td>检验日期：<fmt:formatDate value="${exam.CHECK_DATE}"
                                                                     pattern="yyyy/MM/dd"/></td>
                                        </tr>
                                    </table>
                                </div>
                            </c:if>
                        </div>
                        <br/><br/>
                    </c:forEach>
                </c:if>
				<c:if test="${not empty studyEvents}">
					<c:forEach items="${studyEvents}" var="study">
						<div style="width: 100%;text-align: left;">
							<div style="text-align:left;width:85%;font-size: 15px;height:100%;margin: 0 auto;">
							${study.inspectionItemName}
							</div>
							<div style="width:85%;height:100%;border:1px solid #000000;margin: 0 auto;">
								<table>
									<tr>
										<td style="width: 20%;">检查所见：</td>
										<td style="width: 80%"><textarea readonly="readonly" style="height: 80px;width: 100%;">${study.findings}</textarea></td>
									</tr>
									<tr>
										<td style="width: 20%">所得结论：</td>
										<td style="width: 80%"><textarea readonly="readonly" style="height: 80px;width: 100%;">${study.conclusionDesc}</textarea></td>
									</tr>
									<tr>
										<td style="width: 20%">医生建议：</td>
										<td style="width: 80%"><textarea readonly="readonly" style="height: 80px;width: 100%;">${study.suggestion}</textarea></td>
									</tr>
								</table>
								<div style="width:75%;height:100%;margin: 0 auto;">
									<table>
										<tr style="text-align: right;">
											<td>检查医生：<c:out value="${study.checkPeopleName}" /></td>
											<td>审核医生：<c:out value="${study.auditName}" /></td>
											<td>审核日期：<fmt:formatDate value="${study.auditDate}" pattern="yyyy/MM/dd"/></td>
										</tr>
									</table>
								</div>
							</div>
							<br/><br/>
						</div>
					</c:forEach>
				</c:if>
				<div style="width: 100%;text-align: left;">
					<div style="text-align:left;width:85%;font-size: 15px;height:100%;margin: 0 auto;">
					体检结果
					</div>
					<div style="width:85%;height:100%;border:1px solid #000000;margin: 0 auto;">
						<table>
							<tr>
								<td style="width: 20%">结论：</td>
								<td style="width: 80%"><textarea readonly="readonly" style="height: 100px;width: 100%;">${healthExamination.examinationResult}</textarea></td>
							</tr>
							<tr>
								<td style="width: 20%">建议：</td>
								<td style="width: 80%"><textarea readonly="readonly" style="height: 100px;width: 100%;">${healthExamination.suggestion}</textarea></td>
							</tr>
						</table>
						<table>
							<tr style="text-align: right;">
								<td>总检医生：<c:out value="${healthExamination.manaDoctorName}"/></td>
								<td>体检日期：<fmt:formatDate value="${healthExamination.examinationDate}" pattern="yyyy/MM/dd"/></td>
							</tr>
						</table>
					</div>
				</div>
			</td>
<!-- 			<td style="text-align: center;"><input class="search_btn" type="button" id="nextBtn" value="下一页"/></td> -->
		</tr>
	</table>
</div>