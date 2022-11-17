<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<c:choose>
    <c:when test="${not empty errorStr}">
        ${errorStr}
    </c:when>
    <c:otherwise>
        <div id="toolbar" class="toolbar">
            <script src="${pageContext.request.contextPath}/js/views/cdm/standardization/his/add.js"
                    type="text/javascript"></script>
            <a href="javascript:void(0);" id="health-card-save-btn-external"><b class="tijiao">提交</b></a>

            <div id="health-card-main">
                <form id="health-card-form">
                    <input type="hidden" id="dis-personid" name="personId" value="${diseaseInfo.personInfo.id}">
                    <input type="hidden" id="disid" name="id" value="${diseaseInfo.id}">
                    <input type="hidden" name="orgCode" id="orgCode" value="${orgCode}">
                    <input type="hidden" name="userIdCard" value="${userIdCard}">
                    <input type="hidden" id="exFlag" value="${titleFlag}"/>

                    <div class="postcontent">
                        <i class="popno">慢病管理</i>

                        <div class="postdiv">
                            <div id="person-info">
                                <jsp:include page="personInfo.jsp"></jsp:include>
                            </div>
                            <div id="dis-select-box">
                                <fieldset>
                                    <legend>慢病</legend>
                                    <input type="checkbox" value="2"
                                           name="hbpFlag" ${diseaseInfo.hbpFlag eq '2' ?'checked=true':''}><label>高血压 </label>
                                    <input type="checkbox" value="2"
                                           name="diFlag" ${diseaseInfo.diFlag eq '2' ?'checked=true':''} >糖尿病
                                    <span style="color: #999;font-style: italic;">(不可选择项为已经管理的疾病)</span>
                                </fieldset>
                            </div>
                            <div id="dis-info">
                                <div id="hbpFlag-box" class="${diseaseInfo.hbpFlag eq '2'?'show':'hide'}">
                                    <fieldset>
                                        <legend>高血压信息</legend>
                                        <jsp:include page="../input/hbp.jsp"></jsp:include>
                                    </fieldset>
                                </div>
                                <div id="diFlag-box" class="${diseaseInfo.diFlag eq '2'?'show':'hide'}">
                                    <fieldset>
                                        <legend>糖尿病信息</legend>
                                        <jsp:include page="../input/di.jsp"></jsp:include>
                                    </fieldset>
                                </div>
                                <div id="coronaryFlag-box" class="${diseaseInfo.coronaryFlag eq '2'?'show':'hide'}">
                                    <fieldset>
                                        <legend>冠心病信息</legend>
                                        <jsp:include page="../input/coronary.jsp"></jsp:include>
                                    </fieldset>
                                </div>
                                <div id="strokeFlag-box" class="${diseaseInfo.strokeFlag eq '2'?'show':'hide'}">
                                    <fieldset>
                                        <legend>脑卒中信息</legend>
                                        <jsp:include page="../input/stroke.jsp"></jsp:include>
                                    </fieldset>
                                </div>
                                <div id="tumorFlag-box" class="${diseaseInfo.tumorFlag eq '2'?'show':'hide'}">
                                    <fieldset>
                                        <legend>肿瘤信息</legend>
                                        <jsp:include page="../input/tumor-flag.jsp"></jsp:include>
                                        <jsp:include page="../input/tumor-input.jsp"></jsp:include>
                                    </fieldset>
                                </div>
                            </div>
                            <div id="phyexam-info"></div>
                            <div id="input-info"></div>
                            <div style="height: 20px;"/>
                        </div>
                    </div>
                </form>
            </div>

        </div>
    </c:otherwise>
</c:choose>
