<%@ page import="com.founder.rhip.ehr.common.RoleType" %>
<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/ehr-tag" prefix="ehr"%>
<jsp:include page="./load-js-css-resources.jsp"></jsp:include>
<c:set var="SQZX" value="<%=RoleType.ZX_GLY.getValue()%>"/>
<c:set var="SQZ" value="<%=RoleType.Z_GLY.getValue()%>"/>
	
	
<link href="${pageContext.request.contextPath}/css/index/index.css" rel="stylesheet" type="text/css" />

<script src="${pageContext.request.contextPath}/js/views/layouts/homepage.js" type="text/javascript"></script>

<div class="main_PS x-admin-sm" id="homeDiv" style="width: 99%;">
    <div id="mainContent" style="width:99%;">
        <div style="width: 99%; margin-left: 16.5px;margin-top: 15px;">
            <table>
                <tr>
                    <td width="60%">
                        <%--<ehr:authorize ifAnyGranted="02,03,10,19">--%>
                        <div id="inquiry" style="height:250px;width: 100%">
                            <b class="jiandang">待办事项</b>
                            <div class="contantborder">
                                <div class="ggcontent" style="width: 40%; float: left;">
                                    <ehr:authorize ifAnyGranted="03,10,19">
                                        <ul>
                                            <li>传染病报卡待审核数：&nbsp;&nbsp;&nbsp;&nbsp;<a href="javascript:void(0)" <%--onclick="homepageInit.showBulletin(${bulletin.id})"--%>>${todoMap.idmCount}</a></li>
                                            <li>食源性疾病报卡待审核数：&nbsp;&nbsp;&nbsp;&nbsp;<a href="javascript:void(0)" <%--onclick="homepageInit.showBulletin(${bulletin.id})"--%>>${todoMap.fdmCount}</a></li>
                                        </ul>
                                    </ehr:authorize>
                                    <ehr:authorize ifAnyGranted="02">
                                        <ul><li>健康档案未建档数：&nbsp;&nbsp;&nbsp;&nbsp;<a href="javascript:void(0)" <%--onclick="homepageInit.showBulletin(${bulletin.id})"--%>>${todoMap.personNofileCount}</a></li></ul>
                                    </ehr:authorize>
                                    <ehr:authorize ifAnyGranted="02,03">
                                        <ul><li>老年人待体检数：&nbsp;&nbsp;&nbsp;&nbsp;<a href="javascript:void(0)" <%--onclick="homepageInit.showBulletin(3)"--%>>${todoMap.physicalExamCount}</a></li></ul>
                                    </ehr:authorize>
                                    <ehr:authorize ifAnyGranted="03,11,19">
                                        <ul><li>慢病报卡待审核数：&nbsp;&nbsp;&nbsp;&nbsp;<a href="javascript:void(0)" <%--onclick="homepageInit.showBulletin(${bulletin.id})"--%>>${todoMap.cdmCount}</a></li></ul>
                                    </ehr:authorize>
                                    <%--<ehr:authorize ifAnyGranted="02">
                                        <ul><li>围产保健预约数：&nbsp;&nbsp;&nbsp;&nbsp;<a href="javascript:void(0)" &lt;%&ndash;onclick="homepageInit.reserveList(2)"&ndash;%&gt;>${todoMap.maternalCount}</a></li></ul>
                                    </ehr:authorize>
                                        <ehr:authorize ifAnyGranted="02,03">
                                        <ul><li>儿童一周内体检预约数：&nbsp;&nbsp;&nbsp;&nbsp;<a href="javascript:void(0)" &lt;%&ndash;onclick="homepageInit.reserveList(1)"&ndash;%&gt;>${todoMap.childCount}</a></li></ul>
                                        </ehr:authorize>
                                    <ehr:authorize ifAnyGranted="02">
                                    <ul><li>计划免疫预约数：&nbsp;&nbsp;&nbsp;&nbsp;<a href="javascript:void(0)" &lt;%&ndash;onclick="homepageInit.reserveList(3)"&ndash;%&gt;>${todoMap.vaccinationCount}</a></li></ul>
                                    </ehr:authorize>--%>
                                </div>
                                <div class="ggcontent" style="width: 40%; float: right;">
                                    <ehr:authorize ifAnyGranted="02">
                                        <ul><li>慢病过期待访数：&nbsp;&nbsp;&nbsp;&nbsp;<a href="javascript:void(0)" <%--onclick="homepageInit.showBulletin(${bulletin.id})"--%>>${todoMap.expireCount}</a></li></ul>
                                        <ul><li>慢病本日待访数：&nbsp;&nbsp;&nbsp;&nbsp;<a href="javascript:void(0)" <%--onclick="homepageInit.showBulletin(${bulletin.id})"--%>>${todoMap.todayCount}</a></li></ul>
                                        <ul><li>慢病7天内待访数：&nbsp;&nbsp;&nbsp;&nbsp;<a href="javascript:void(0)" <%--onclick="homepageInit.showBulletin(${bulletin.id})"--%>>${todoMap.thisWeekCount}</a></li></ul>
                                        <ul><li>慢病30天内待访数：&nbsp;&nbsp;&nbsp;&nbsp;<a href="javascript:void(0)" <%--onclick="homepageInit.showBulletin(${bulletin.id})"--%>>${todoMap.thisMonthCount}</a></li></ul>
                                    </ehr:authorize>
                                </div>
                                <c:if test="${! empty emergencyList}">
                                    <div class="ggcontent" style="width: 40%; float: right;">
                                        <c:forEach items="${emergencyList}" var="emergency">
                                            <li>
                                                    ${emergency.content}
                                            </li>
                                        </c:forEach>
                                    </div>
                                </c:if>

                            </div>
                        </div>
                        <%--</ehr:authorize>--%>
                    </td>
                    <td width="40%">
                        <div id="inquiry" style="height:250px;width: 98%">
                            <b class="jiandang">公告通知
                                <ehr:authorize ifNotGranted="01">
                                    <a class="view" href="javascript:void(0)" onclick="homepageInit.moreBulletin()" ><b class="fenbu">更多</b></a>
                                </ehr:authorize>
                                <ehr:authorize ifAnyGranted="01">
                                    <a class="view" href="javascript:void(0)" onclick="homepageInit.moreBulletin()"><b class="fenbu">管理</b></a>
                                </ehr:authorize>
                            </b>
                            <div class="contantborder">
                                <div class="ggcontent">
                                    <ul>
                                        <c:forEach items="${bulletins}" var="bulletin">
                                            <li>
                                                <a href="javascript:void(0)" onclick="homepageInit.showBulletin(${bulletin.id})">${bulletin.title}</a>
                                            </li>
                                        </c:forEach>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </td>
                </tr>
            </table>
        </div>
        <div id="inquiry" style="height:325px;width: 99%;">
            <b class="jiandang">
                <p style="float: left; width: 55px;">问题解答</p>
                <p style="float: right;"><a class="view" href="javascript:void(0)" onclick="homepageInit.moreQuestion(0)" ><b class="fenbu">更多</b></a></p>
                <p style="float: left; width: 120px;">
                    <ehr:authorize ifNotGranted="01">
                        <a class="view" href="javascript:void(0)" onclick="homepageInit.addQuestion(0)"><b class="fenbu">☞提问</b></a>
                    </ehr:authorize>
                </p>
            </b>
            <div class="contantborder">
                <div class="qacontent">
                    <c:forEach items="${questions}" var="question">
                        <div class="qacontentli">
                            <div class="questionlibg">
                                <div class="questionlileft">
                                    [ <ehr:user userCode="${question.submitor}"/> - <ehr:user userCode="${question.submitor}"/> ]
                                </div>
                                <div class="questionliright" >
                                    <ehr:authorize ifNotGranted="01">
                                        <c:if test="${empty question.answer}">
                                        <c:if test="${submitor eq question.submitor  || createrOrg eq '_999'}">
                                            <a href="javascript:void(0)" onclick="homepageInit.addQuestion(${question.id})">［修改］ </a>
                                            <a href="javascript:void(0)" onclick="homepageInit.deleteQuestion(${question.id})" >［删除］ </a>
                                       	</c:if>
                                        </c:if>
                                       <%--  <c:if test="${not empty question.answer}"> --%>
                                            <a href="javascript:void(0)" onclick="homepageInit.viewQuestion(${question.id})">［查看］ </a>
                                       <%--  </c:if> --%>
                                    </ehr:authorize>

                                    <ehr:authorize ifAnyGranted="01">
                                        <a href="javascript:void(0)" onclick="homepageInit.answerQuestion(${question.id})" >［解答］ </a>
                                    </ehr:authorize>
                                </div>
                            </div>
                            <div class="answerlibg">
                                <div class="answerli">
                                    <c:if test="${not empty question.answer}">
                                        ${question.answerContent}
                                    </c:if>
                                    <c:if test="${empty question.answer}">
                                        尚未解答
                                    </c:if>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </div>
    </div>
</div>

<div id="moreDiv">

</div>