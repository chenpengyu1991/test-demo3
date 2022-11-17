<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>

<%@ page import="com.founder.rhip.ehr.common.RoleType" %>
<c:set var="YYMB" value="<%=RoleType.YYMB.getValue()%>"/>
<c:set var="ZXMB" value="<%=RoleType.ZXMB.getValue()%>"/>
<c:set var="ZMB" value="<%=RoleType.ZMB.getValue()%>"/>

<c:choose>
	<c:when test="${not empty errorStr}">
		${errorStr}
	</c:when>
	<c:otherwise>
		<script src="${pageContext.request.contextPath}/js/views/cdm/standardization/followup/edit.js" type="text/javascript"></script>
		<input type="hidden" id="dm-followup-personid"  value="${personInfo.id}" />
		<input type="hidden" id="dm-followup-diseaseid"  value="${diseaseInfo.id}" />
		<input type="hidden" id="dm-followup-stroke-followup-type"  value="${strokeFollowType}" />
		<input type="hidden" id="dm-followup-coronary-followup-type"  value="${coronaryFollowType}" />
		<div id="dm-followup-main">
			<table>
				<c:if test="${warnStr ne ''}">
					<tr>
						<td style="color: red; text-align: center; font-size: 24px;">${warnStr}</td>
					</tr>
				</c:if>

				<tr>
					<td><jsp:include page="personInfo.jsp"></jsp:include></td>
				</tr>
				<tr>
					<td>
						<div class="layui-tab layui-tab-card" lay-filter="cdmFollowupTab">
							<ul class="layui-tab-title">
								<c:if test="${diseaseInfo.hbpFlag eq '2'}">
									<li class="layui-this"  lay-id="hbp"><a style="color:${diseaseInfo.nextHbpFollowupDate < aWeekLater?'red':'black'}" id="hypertension_btn"  href="javascript:void(0)">高血压</a></li>
								</c:if>
								<c:if test="${diseaseInfo.diFlag eq '2'}">
									<li  lay-id="di" <c:if test="${diseaseInfo.hbpFlag ne '2'}">class="layui-this"</c:if> ><a style="color:${diseaseInfo.nextDiFollowupDate < aWeekLater?'red':'black'}" id="diabetic_btn"  href="javascript:void(0)">糖尿病</a></li>
								</c:if>
								<c:if test="${empty titleFlag}">
									<c:if test="${diseaseInfo.tumorFlag eq '2'}">
										<li  lay-id="tumor" <c:if test="${diseaseInfo.strokeFlag ne '2' && diseaseInfo.coronaryFlag ne '2' && diseaseInfo.diFlag ne '2' && diseaseInfo.hbpFlag ne '2'}">class="layui-this"</c:if> ><a style="color:${diseaseInfo.nextTumorFollowupDate < aWeekLater?'red':'black'}"
																																																									  id="tumor_btn"  href="javascript:void(0)">肿瘤</a></li>
									</c:if>

									<c:if test="${diseaseInfo.strokeFlag eq '2'}">
										<li  lay-id="stroke" <c:if test="${diseaseInfo.coronaryFlag ne '2' && diseaseInfo.diFlag ne '2' && diseaseInfo.hbpFlag ne '2'}">class="layui-this"</c:if> ><a style="color:${diseaseInfo.nextStrokeFollowupDate < aWeekLater?'red':'black'}"
																																																	  id="tumor_btn"  href="javascript:void(0)">脑卒中</a></li>
									</c:if>

									<c:if test="${diseaseInfo.coronaryFlag eq '2'}">
										<li  lay-id="coronary" <c:if test="${diseaseInfo.diFlag ne '2' && diseaseInfo.hbpFlag ne '2'}">class="layui-this"</c:if> ><a style="color:${diseaseInfo.nextCoronaryFollowupDate < aWeekLater?'red':'black'}"
																																									 id="tumor_btn"  href="javascript:void(0)">冠心病</a></li>
									</c:if>

								</c:if>
							</ul>

						<div id="tagContent" class="layui-tab-content">
							<div class="toolbar">
								<c:if test="${empty titleFlag}">
									<a href="javascript:void(0)" id="followup-back-btn"><button class="btn-gray layui-btn layui-btn-sm button"><i class="layui-icon">&#xe65c;</i>返回</button></a>
								</c:if>
								<ehr:authorize ifAnyGranted="${YYMB},${ZXMB},${ZMB}">
									<a href="javascript:void(0);" id="followup-save-btn"><button class="layui-btn layui-btn-sm button"><i class="layui-icon">&#xe605;</i>保存</button></a>
								</ehr:authorize>
							</div>
							<c:if test="${diseaseInfo.hbpFlag eq '2'}">
								<div class="layui-tab-item layui-show" id="hbp-content" ><jsp:include page="hbp/main.jsp"></jsp:include></div>
							</c:if>
							<c:if test="${diseaseInfo.diFlag eq '2'}">
								<div <c:if test="${diseaseInfo.hbpFlag ne '2'}">class="layui-tab-item layui-show"</c:if> <c:if test="${diseaseInfo.hbpFlag eq '2'}">class="layui-tab-item"</c:if>  id="di-content" >
									<jsp:include page="di/main.jsp"></jsp:include>
								</div>
							</c:if>
							<c:if test="${empty titleFlag}">
								<c:if test="${diseaseInfo.tumorFlag eq '2'}">
									<div <c:if test="${diseaseInfo.strokeFlag ne '2' && diseaseInfo.coronaryFlag ne '2' && diseaseInfo.diFlag ne '2' && diseaseInfo.hbpFlag ne '2'}">class="layui-tab-item layui-show"</c:if> <c:if test="${diseaseInfo.strokeFlag eq '2' || diseaseInfo.coronaryFlag eq '2' || diseaseInfo.diFlag eq '2' || diseaseInfo.hbpFlag eq '2'}">class="layui-tab-item"</c:if> id="tumor-content" >
										<table>
											<tr>
												<td style="vertical-align: top; min-width: 100px; width: 30%">
													<div id="tumorMainDiv">
														<jsp:include page="tumor/tumorMain.jsp"></jsp:include>
													</div>
												</td>
											</tr>
										</table>
									</div>
								</c:if>
								<c:if test="${diseaseInfo.strokeFlag eq '2'}">
									<div <c:if test="${diseaseInfo.coronaryFlag ne '2' && diseaseInfo.diFlag ne '2' && diseaseInfo.hbpFlag ne '2'}">class="layui-tab-item layui-show"</c:if> <c:if test="${diseaseInfo.coronaryFlag eq '2' || diseaseInfo.diFlag eq '2' || diseaseInfo.hbpFlag eq '2'}">class="layui-tab-item"</c:if> id="stroke-content" ><jsp:include page="stroke/main.jsp"></jsp:include></div>
								</c:if>
								<c:if test="${diseaseInfo.coronaryFlag eq '2'}">
									<div <c:if test="${diseaseInfo.diFlag ne '2' && diseaseInfo.hbpFlag ne '2'}">class="layui-tab-item layui-show"</c:if> <c:if test="${diseaseInfo.diFlag eq '2' || diseaseInfo.hbpFlag eq '2'}">class="layui-tab-item"</c:if> id="coronary-content" ><jsp:include page="coronary/main.jsp"></jsp:include></div>
								</c:if>
							</c:if>
						</div>
						</div>
					</td>
				</tr>
			</table>
		</div>
	</c:otherwise>
</c:choose>

<script>
    //注意：选项卡 依赖 element 模块，否则无法进行功能性操作
    layui.use('element', function(){
        var element = layui.element;
//一些事件监听
        element.on('tab(cdmFollowupTab)', function(data){
            var layId = this.getAttribute('lay-id');
            if (layId == 'hbp') {
                dmFollowupEdit.loadHbp();
            } else if(layId == 'di') {
                dmFollowupEdit.loadDi();
            }  else if(layId == 'tumor') {
                dmFollowupEdit.loadTumor();
            } else if(layId == 'stroke') {
                dmFollowupEdit.loadStroke();
            } else if(layId == 'coronary') {
                dmFollowupEdit.loadCoronary();
            }
        });
    });
</script>