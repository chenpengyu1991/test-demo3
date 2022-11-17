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
<link rel="stylesheet" href="${pageContext.request.contextPath}/js/views/ZKTfinger/css/box.css" type="text/css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/views/ZKTfinger/js/main.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/views/ZKTfinger/js/fingerprint.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/views/ZKTfinger/js/baseMoth.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/views/ZKTfinger/js/dhtmlxCommon.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery/jquery.jqprint.js"></script>
<div id="msgError" class="msgError" style="display: none;"></div>
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
		<div id="dm-followup-main" style="margin-top: 10px;">
			<table>
				<tr>
					<td><jsp:include page="personInfo.jsp"></jsp:include></td>
				</tr>
				<tr>
					<td>
						<%-- <ul id=tags>
							<c:if test="${diseaseInfo.hbpFlag eq '2'}">
								<li><a style="color:${diseaseInfo.nextHbpFollowupDate < aWeekLater?'red':'black'}" id="hypertension_btn" data-target="tagContent0" href="javascript:void(0)">高血压</a>
								</li>
							</c:if>
							<c:if test="${diseaseInfo.diFlag eq '2'}">
								<li><a style="color:${diseaseInfo.nextDiFollowupDate < aWeekLater?'red':'black'}" id="diabetic_btn" data-target="tagContent1" href="javascript:void(0)">糖尿病</a>
								</li>
							</c:if>
							<c:if test="${empty titleFlag}">

								<c:if test="${ diseaseInfo.tumorFlag eq '2'}">
									<li><a style="color:${diseaseInfo.nextTumorFollowupDate < aWeekLater?'red':'black'}"
										   id="tumor_btn" data-target="tagContent2" href="javascript:void(0)">肿瘤</a>
									</li>
								</c:if>
								<c:if test="${ diseaseInfo.strokeFlag eq '2'}">
									<li><a style="color:${diseaseInfo.nextStrokeFollowupDate < aWeekLater?'red':'black'}"
										   id="tumor_btn" data-target="tagContent3" href="javascript:void(0)">脑卒中</a>
									</li>
								</c:if>
								<c:if test="${diseaseInfo.coronaryFlag eq '2'}">
									<li><a style="color:${diseaseInfo.nextCoronaryFollowupDate < aWeekLater?'red':'black'}"
										   id="tumor_btn" data-target="tagContent4" href="javascript:void(0)">冠心病</a></li>
								</c:if>
							</c:if>
						</ul> --%>
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
			    	<li  lay-id="tumor" <c:if test="${diseaseInfo.diFlag ne '2' && diseaseInfo.hbpFlag ne '2'}">class="layui-this"</c:if> ><a style="color:${diseaseInfo.nextTumorFollowupDate < aWeekLater?'red':'black'}"
										   id="tumor_btn"  href="javascript:void(0)">肿瘤</a></li>
			   	</c:if>
			   
			     <c:if test="${diseaseInfo.strokeFlag eq '2'}">
			        <li  lay-id="stroke" <c:if test="${diseaseInfo.diFlag ne '2' && diseaseInfo.hbpFlag ne '2' && diseaseInfo.tumorFlag ne '2'}">class="layui-this"</c:if> ><a style="color:${diseaseInfo.nextStrokeFollowupDate < aWeekLater?'red':'black'}"
										   id="tumor_btn"  href="javascript:void(0)">脑卒中</a></li>
			     </c:if>
			   
			     <c:if test="${diseaseInfo.coronaryFlag eq '2'}">
			    	<li  lay-id="coronary" <c:if test="${diseaseInfo.diFlag ne '2' && diseaseInfo.hbpFlag ne '2' && diseaseInfo.strokeFlag ne '2' && diseaseInfo.tumorFlag ne '2' }">class="layui-this"</c:if> ><a style="color:${diseaseInfo.nextCoronaryFollowupDate < aWeekLater?'red':'black'}"
										   id="tumor_btn"  href="javascript:void(0)">冠心病</a></li>
			   	 </c:if>
			   
			   </c:if>
			  </ul>
			  <div class="layui-tab-content">
			  	<div class="toolbar" style="margin-top: -10px;margin-left: -10px;margin-right: -10px;">
					<c:if test="${fingerInfo != null}">
					<div id="comparison" style="display: inline"
						 onclick='fpVerification("指纹比对","请安装指纹驱动或启动服务",true,globalContext)' class="finger">指纹比对</div>
					</c:if>
					<c:if test="${empty titleFlag}">
						<%-- <a href="javascript:void(0)" id="followup-back-btn"><b class="fanhui">返回</b></a> --%>
						<a href="javascript:void(0)" id="followup-back-btn"><button class="btn-gray layui-btn layui-btn-sm button"><i class="layui-icon">&#xe65c;</i>返回</button></a>
					</c:if>
					<ehr:authorize ifAnyGranted="${YYMB},${ZXMB},${ZMB}">
						<%-- <a href="javascript:void(0);" id="yitiji"><b class="search">一体机</b></a> --%>
<%--						<a href="javascript:void(0);" id="yitiji"><button class="layui-btn layui-btn-xs"><i class="layui-icon">&#xe615;</i>一体机</button></a>--%>
						<%-- <a href="javascript:void(0);" id="followup-print-btn" style="display: none"><b class="dayin">打印</b></a> --%>
						<a href="javascript:void(0);" id="followup-print-btn" style="display: none"><button class="layui-btn layui-btn-sm button"><i class="layui-icon">&#xe66d;</i>打印</button></a>
						<%-- <a href="javascript:void(0);" id="followup-save-btn"><b class="baocun">保存</b></a> --%>
						<a href="javascript:void(0);" id="followup-save-btn"><button class="layui-btn layui-btn-sm button"><i class="layui-icon">&#xe605;</i>保存</button></a>
					</ehr:authorize>
				</div>
			  <c:if test="${diseaseInfo.hbpFlag eq '2'}">
			    <div class="layui-tab-item layui-show divFixed125"style="top: 200px;" id="hbp-content" ><jsp:include page="hbp/main.jsp"></jsp:include></div>
			  </c:if>
			  <c:if test="${diseaseInfo.diFlag eq '2'}">
    			<div style="top: 200px;"<c:if test="${diseaseInfo.hbpFlag ne '2'}">class="layui-tab-item layui-show divFixed125"</c:if> <c:if test="${diseaseInfo.hbpFlag eq '2'}">class="layui-tab-item divFixed125"</c:if>  id="di-content" >
    			<jsp:include page="di/main.jsp"></jsp:include>
             	</div>
             </c:if>
             <c:if test="${empty titleFlag}">
	    		<c:if test="${diseaseInfo.tumorFlag eq '2'}">
	    		<div style="top: 200px;"<c:if test="${diseaseInfo.diFlag ne '2' && diseaseInfo.hbpFlag ne '2'}">class="layui-tab-item layui-show divFixed125"</c:if> <c:if test="${diseaseInfo.diFlag eq '2' || diseaseInfo.hbpFlag eq '2'}">class="layui-tab-item divFixed125"</c:if> id="tumor-content" >
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
	    			<div style="top: 200px;"<c:if test="${diseaseInfo.diFlag ne '2' && diseaseInfo.hbpFlag ne '2' && diseaseInfo.tumorFlag ne '2'}">class="layui-tab-item layui-show divFixed125"</c:if> <c:if test="${diseaseInfo.tumorFlag eq '2' || diseaseInfo.diFlag eq '2' || diseaseInfo.hbpFlag eq '2'}">class="layui-tab-item divFixed125"</c:if> id="stroke-content" ><jsp:include page="stroke/main.jsp"></jsp:include></div>
	    		</c:if>
	              <c:if test="${diseaseInfo.coronaryFlag eq '2'}">
	    			<div style="top: 200px;"<c:if test="${diseaseInfo.diFlag ne '2' && diseaseInfo.hbpFlag ne '2' && diseaseInfo.strokeFlag ne '2' && diseaseInfo.tumorFlag ne '2' }">class="layui-tab-item layui-show divFixed125"</c:if> <c:if test="${diseaseInfo.diFlag eq '2' || diseaseInfo.hbpFlag eq '2' || diseaseInfo.tumorFlag eq '2' || diseaseInfo.strokeFlag eq '2'}">class="layui-tab-item divFixed125"</c:if> id="coronary-content" ><jsp:include page="coronary/main.jsp"></jsp:include></div>
	    		 </c:if>
             </c:if>
			  </div>
			</div>
                    <form id="fingerVerifyForm" name="fingerVerifyForm" method="post">
                        <input type="hidden" id="idcard" name="idcard" value="${personInfo.idcard}"/>
                        <input type="hidden" id="person_name" name="name" value="${personInfo.name}"/>
                        <input type="hidden" name="exeCode" value="1"/>
                        <input type="hidden" name="exeDes" value="随访"/>
                        <input type="hidden" id="verifyResult" name="result" />
                        <input type="hidden" name="createUser" value="${currentLoginInfo.user.userName}"/>
                        <input type="hidden" name="createName" value="${currentLoginInfo.user.name}"/>
                    </form>
							<%--验证模式--%>
						<input type="hidden"  id="verifyModel" name="verifyModel" />
							<%--验证指纹--%>
						<input type="hidden" id="verifyTemplate" name="verifyTemplate" />
							<%--指纹模板--%>
						<input type="hidden"  id="fingerTemplate10" name="fingerTemplate" value="${fingerInfo!=null?fingerInfo.fingerTemplate:''}${fingerInfo!=null?fingerInfo.fingerTemplateSec:''}"/>
						<div id="bg" style="display: none;"></div>
						<div id="comparisonDiv" class="box" style="display: none">
							<h2>指纹比对</h2>
							<div class="list">
								<canvas id="canvasComp" width="430" height="320"
										style="background: url('../js/views/ZKTfinger/image/base_fpVerify.jpg') rgb(243, 245, 240);"></canvas>
								<input type="button" value="关闭" onclick='closeCompa()' />
							</div>
						</div>
						<%-- <div id="tagContent" style="width: 99.5%; height: 490px;">
							<div class="toolbar">
								<c:if test="${fingerInfo != null}">
								<div id="comparison" style="display: inline"
									 onclick='fpVerification("指纹比对","请安装指纹驱动或启动服务",true,globalContext)' class="finger">指纹比对</div>
								</c:if>
								<c:if test="${empty titleFlag}">
									<a href="javascript:void(0)" id="followup-back-btn"><b class="fanhui">返回</b></a>
								</c:if>
								<ehr:authorize ifAnyGranted="${YYMB},${ZXMB},${ZMB}">
									<a href="javascript:void(0);" id="yitiji"><b class="search">一体机</b></a>
									<a href="javascript:void(0);" id="followup-print-btn" style="display: none"><b class="dayin">打印</b></a>
									<a href="javascript:void(0);" id="followup-save-btn"><b class="baocun">保存</b></a>
								</ehr:authorize>
							</div>
							<div class="tab-content" id="tagContent0">
								<jsp:include page="hbp/main.jsp"></jsp:include>
							</div>
							<div class="tab-content"  id="tagContent1" style="display: none;">
								<jsp:include page="di/main.jsp"></jsp:include>
							</div>
							<c:if test="${empty titleFlag}">
								<div class="tab-content" id="tagContent2" style="display: none;">
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
								<div class="tab-content" id="tagContent3" style="display: none;">
									<div id="tumorMainDiv">
										<jsp:include page="stroke/main.jsp"></jsp:include>
									</div>
								</div>
								<div class="tab-content" id="tagContent4" style="display: none;">
									<div id="coronaryMainDiv">
										<jsp:include page="coronary/main.jsp"></jsp:include>
									</div>
								</div>
							</c:if>
						</div> --%>
					</td>
				</tr>
			</table>
		</div>
	</c:otherwise>
</c:choose>
<div id="ehrDetailDiv"></div>
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