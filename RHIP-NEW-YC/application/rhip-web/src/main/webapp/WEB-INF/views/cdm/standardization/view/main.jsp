<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="com.founder.rhip.ehr.common.RoleType" %>
<c:set var="ZMB" value="<%=RoleType.ZMB.getValue()%>"/>
<c:set var="ZXMB" value="<%=RoleType.ZXMB.getValue()%>"/>
<script src="${pageContext.request.contextPath}/js/views/cdm/standardization/input/view.js" type="text/javascript"></script>
<div class="toolbar" style="margin-top: 8px;">
    <%-- <a href="javascript:void(0)" id="health-card-back-btn"><b class="fanhui">返回</b></a> --%>
    <a href="javascript:void(0)" id="health-card-back-btn" ><button class="btn-gray layui-btn layui-btn-sm button"><i class="layui-icon">&#xe65c;</i>返回</button></a>
    <ehr:authorize ifAnyGranted="${ZMB},${ZXMB}">
        <%--非删除和非注销状态的报卡才可以修改,js通过此增加只读属性 --%>
        <%--非删除和非注销状态的报卡才可以修改,js通过此增加只读属性 --%>
        <c:if test="${diseaseInfo.status eq '1' and (isShow eq '1' || isShow eq null)}">
           <%--  <a href="javascript:void(0);" id="health-card-save-btn"><b class="baocun">保存</b></a> --%>
            <a href="javascript:void(0);" id="health-card-save-btn" ><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe605;</i>保存</button></a>
        </c:if>
    </ehr:authorize>
</div>
<div id="health-card-main" class="contentfixed32">
    <form id="health-card-form">
        <input type="hidden" id="disPersonId" name="personId" value="${diseaseInfo.personInfo.id}">
        <input type="hidden" id="disid" name="id" value="${diseaseInfo.id}">
        <input type="hidden" id="hbpHaveAttempHid"  value="${diseaseInfo.hbpFlag}">
        <input type="hidden" id="diHaveAttempHid"  value="${diseaseInfo.diFlag}">

        <div class="postcontent">
            <i class="popno">慢病管理</i>

            <div class="postdiv">
                <div id="person-info">
                    <jsp:include page="../input/personInfo.jsp"></jsp:include>
                </div>
                <div id="con">
                    <c:choose>
                        <c:when test="${isShow eq '0'}">
                            <%-- <ul id="tags">
                                <c:if test="${diseaseInfo.hbpFlag eq '1'}">
                                    <li><a data-target="hbp-content">高血压</a></li>
                                </c:if> <c:if test="${diseaseInfo.diFlag eq '1'}">
                                <li><a data-target="di-content">糖尿病</a></li>
                            </c:if> <c:if test="${diseaseInfo.coronaryFlag eq '1'}">
                                <li><a data-target="coronary-content">冠心病</a></li>
                            </c:if> <c:if test="${diseaseInfo.strokeFlag eq '1'}">
                                <li><a data-target="stroke-content">脑卒中</a></li>
                            </c:if> <c:if test="${diseaseInfo.tumorFlag eq '1'}">
                                <li><a data-target="tumor-content">肿瘤</a></li>
                            </c:if>
                            </ul>
                            <div id="tagContent">
                                <c:if test="${diseaseInfo.hbpFlag eq '1'}">
                                    <div id="hbp-content">
                                            								<input type="hidden" class="distype" name="hbpFlag"  value="${diseaseInfo.hbpFlag}"  />
                                        <jsp:include page="../input/hbp.jsp"></jsp:include>
                                            0147119: 高血压慢病卡的个人史，药物过敏史，家族史，生活情况去掉，不显示
                                            <jsp:include page="basic_info.jsp"></jsp:include>
                                    </div>
                                </c:if> <c:if test="${diseaseInfo.diFlag eq '1'}">
                                <div id="di-content">
                                        							<input type="hidden"  class="distype"  name="diFlag"    value="${diseaseInfo.diFlag}" />
                                    <jsp:include page="../input/di.jsp"></jsp:include>
                                    <jsp:include page="latestPhysicalExamination.jsp"></jsp:include>
                                </div>
                            </c:if> <c:if test="${diseaseInfo.coronaryFlag eq '1'}">
                                <div id="coronary-content">
                                        							<input type="hidden" class="distype"  name="coronaryFlag"   value="${diseaseInfo.coronaryFlag}" />
                                    <jsp:include page="../input/coronary.jsp"></jsp:include>
                                </div>
                            </c:if> <c:if test="${diseaseInfo.strokeFlag eq '1'}">
                                <div id="stroke-content">
                                        							<input type="hidden"  class="distype"   name="strokeFlag"   value="${diseaseInfo.strokeFlag}"  />
                                    <jsp:include page="../input/stroke.jsp"></jsp:include>
                                </div>
                            </c:if> <c:if test="${diseaseInfo.tumorFlag eq '1'}">
                                <div id="tumor-content">
                                        							<input type="hidden" class="distype"  name="tumorFlag"   value="${diseaseInfo.tumorFlag}" />
                                    <jsp:include page="../input/tumor-flag.jsp"></jsp:include>
                                    <jsp:include page="../input/tumor.jsp"></jsp:include>
                                    <c:if test="${fn:length(diseaseInfo.tumorReports)<1}">
                                        <jsp:include page="../input/tumor-input.jsp"></jsp:include>
                                    </c:if>
                                </div>
                            </c:if>
                            </div> --%>
                            
                            <div class="layui-tab layui-tab-card" lay-filter="cdmFollowUp">
			  <ul class="layui-tab-title">
			   <c:if test="${diseaseInfo.hbpFlag eq '1'}">
			    <li class="layui-this">高血压</li>
			  </c:if>
			  <c:if test="${diseaseInfo.diFlag eq '1'}">
			    <li <c:if test="${diseaseInfo.hbpFlag ne '1'}">class="layui-this"</c:if> >糖尿病</li>
			   </c:if>
			     <c:if test="${diseaseInfo.coronaryFlag eq '1'}">
			    <li <c:if test="${diseaseInfo.diFlag ne '1' && diseaseInfo.hbpFlag ne '1'}">class="layui-this"</c:if> >冠心病</li>
			   </c:if>
			     <c:if test="${diseaseInfo.strokeFlag eq '1'}">
			    <li <c:if test="${diseaseInfo.coronaryFlag ne '1' && diseaseInfo.diFlag ne '1' && diseaseInfo.hbpFlag ne '1'}">class="layui-this"</c:if> >脑卒中</li>
			   </c:if>
			     <c:if test="${diseaseInfo.tumorFlag eq '1'}">
			    <li <c:if test="${diseaseInfo.strokeFlag ne '1' && diseaseInfo.coronaryFlag ne '1' && diseaseInfo.diFlag ne '1' && diseaseInfo.hbpFlag ne '1'}">class="layui-this"</c:if> >肿瘤</li>
			   </c:if>
			  </ul>
			  <div class="layui-tab-content">
			  <c:if test="${diseaseInfo.hbpFlag eq '1'}">
			    <div class="layui-tab-item layui-show" id="hbp-content" ><jsp:include page="../input/hbp.jsp"></jsp:include></div>
			  </c:if>
			  <c:if test="${diseaseInfo.diFlag eq '1'}">
    			<div <c:if test="${diseaseInfo.hbpFlag ne '1'}">class="layui-tab-item layui-show"</c:if> <c:if test="${diseaseInfo.hbpFlag eq '1'}">class="layui-tab-item"</c:if>  id="di-content" >
    			<jsp:include page="../input/di.jsp"></jsp:include>
                <jsp:include page="latestPhysicalExamination.jsp"></jsp:include>
             	</div>
             </c:if>
              <c:if test="${diseaseInfo.coronaryFlag eq '1'}">
    			<div <c:if test="${diseaseInfo.diFlag ne '1' && diseaseInfo.hbpFlag ne '1'}">class="layui-tab-item layui-show"</c:if> <c:if test="${diseaseInfo.diFlag eq '1' || diseaseInfo.hbpFlag eq '1'}">class="layui-tab-item"</c:if> id="coronary-content" ><jsp:include page="../input/coronary.jsp"></jsp:include></div>
    		 </c:if>
    		 <c:if test="${diseaseInfo.strokeFlag eq '1'}">
    			<div <c:if test="${diseaseInfo.coronaryFlag ne '1' && diseaseInfo.diFlag ne '1' && diseaseInfo.hbpFlag ne '1'}">class="layui-tab-item layui-show"</c:if> <c:if test="${diseaseInfo.coronaryFlag eq '1' || diseaseInfo.diFlag eq '1' || diseaseInfo.hbpFlag eq '1'}">class="layui-tab-item"</c:if> id="stroke-content" ><jsp:include page="../input/stroke.jsp"></jsp:include></div>
    		</c:if>
    		<c:if test="${diseaseInfo.tumorFlag eq '1'}">
    		<div <c:if test="${diseaseInfo.strokeFlag ne '1' && diseaseInfo.coronaryFlag ne '1' && diseaseInfo.diFlag ne '1' && diseaseInfo.hbpFlag ne '1'}">class="layui-tab-item layui-show"</c:if> <c:if test="${diseaseInfo.strokeFlag eq '1' || diseaseInfo.coronaryFlag eq '1' || diseaseInfo.diFlag eq '1' || diseaseInfo.hbpFlag eq '1'}">class="layui-tab-item"</c:if> id="tumor-content" >
    				<jsp:include page="../input/tumor-flag.jsp"></jsp:include>
                     <jsp:include page="../input/tumor.jsp"></jsp:include>
                       <c:if test="${fn:length(diseaseInfo.tumorReports)<1}">
                              <jsp:include page="../input/tumor-input.jsp"></jsp:include>
                        </c:if>
    		</div>
    		</c:if>
			  </div>
		</div>
                            
                            <div style="height: 20px;" />
                        </c:when>
                        <c:otherwise>
                           <%--  <ul id="tags">
                                <c:if test="${diseaseInfo.hbpFlag eq '2'}">
                                    <li><a data-target="hbp-content">高血压</a></li>
                                </c:if> <c:if test="${diseaseInfo.diFlag eq '2'}">
                                <li><a data-target="di-content">糖尿病</a></li>
                            </c:if> <c:if test="${diseaseInfo.coronaryFlag eq '2'}">
                                <li><a data-target="coronary-content">冠心病</a></li>
                            </c:if> <c:if test="${diseaseInfo.strokeFlag eq '2'}">
                                <li><a data-target="stroke-content">脑卒中</a></li>
                            </c:if> <c:if test="${diseaseInfo.tumorFlag eq '2'}">
                                <li><a data-target="tumor-content">肿瘤</a></li>
                            </c:if>
                            </ul>
                            <div id="tagContent">
                                <c:if test="${diseaseInfo.hbpFlag eq '2'}">
                                    <div id="hbp-content">
                                            								<input type="hidden" class="distype" name="hbpFlag"  value="${diseaseInfo.hbpFlag}"  />
                                        <jsp:include page="../input/hbp.jsp"></jsp:include>
                                            0147119: 高血压慢病卡的个人史，药物过敏史，家族史，生活情况去掉，不显示
                                            <jsp:include page="basic_info.jsp"></jsp:include>
                                    </div>
                                </c:if> <c:if test="${diseaseInfo.diFlag eq '2'}">
                                <div id="di-content">
                                        							<input type="hidden"  class="distype"  name="diFlag"    value="${diseaseInfo.diFlag}" />
                                    <jsp:include page="../input/di.jsp"></jsp:include>
                                    <jsp:include page="latestPhysicalExamination.jsp"></jsp:include>
                                </div>
                            </c:if> <c:if test="${diseaseInfo.coronaryFlag eq '2'}">
                                <div id="coronary-content">
                                        							<input type="hidden" class="distype"  name="coronaryFlag"   value="${diseaseInfo.coronaryFlag}" />
                                    <jsp:include page="../input/coronary.jsp"></jsp:include>
                                </div>
                            </c:if> <c:if test="${diseaseInfo.strokeFlag eq '2'}">
                                <div id="stroke-content">
                                        							<input type="hidden"  class="distype"   name="strokeFlag"   value="${diseaseInfo.strokeFlag}"  />
                                    <jsp:include page="../input/stroke.jsp"></jsp:include>
                                </div>
                            </c:if> <c:if test="${diseaseInfo.tumorFlag eq '2'}">
                                <div id="tumor-content">
                                        							<input type="hidden" class="distype"  name="tumorFlag"   value="${diseaseInfo.tumorFlag}" />
                                    <jsp:include page="../input/tumor-flag.jsp"></jsp:include>
                                    <jsp:include page="../input/tumor.jsp"></jsp:include>
                                    <c:if test="${fn:length(diseaseInfo.tumorReports)<1}">
                                        <jsp:include page="../input/tumor-input.jsp"></jsp:include>
                                    </c:if>
                                </div>
                            </c:if>
                            </div> --%>
                            
       <div class="layui-tab layui-tab-card" lay-filter="cdmFollowUp">
			  <ul class="layui-tab-title">
			   <c:if test="${diseaseInfo.hbpFlag eq '2'}">
			    <li class="layui-this">高血压</li>
			  </c:if>
			  <c:if test="${diseaseInfo.diFlag eq '2'}">
			    <li <c:if test="${diseaseInfo.hbpFlag ne '2'}">class="layui-this"</c:if> >糖尿病</li>
			   </c:if>
			     <c:if test="${diseaseInfo.coronaryFlag eq '2'}">
			    <li <c:if test="${diseaseInfo.diFlag ne '2' && diseaseInfo.hbpFlag ne '2'}">class="layui-this"</c:if> >冠心病</li>
			   </c:if>
			     <c:if test="${diseaseInfo.strokeFlag eq '2'}">
			    <li <c:if test="${diseaseInfo.coronaryFlag ne '2' && diseaseInfo.diFlag ne '2' && diseaseInfo.hbpFlag ne '2'}">class="layui-this"</c:if> >脑卒中</li>
			   </c:if>
			     <c:if test="${diseaseInfo.tumorFlag eq '2'}">
			    <li <c:if test="${diseaseInfo.strokeFlag ne '2' && diseaseInfo.coronaryFlag ne '2' && diseaseInfo.diFlag ne '2' && diseaseInfo.hbpFlag ne '2'}">class="layui-this"</c:if> >肿瘤</li>
			   </c:if>
			  </ul>
			  <div class="layui-tab-content">
			  <c:if test="${diseaseInfo.hbpFlag eq '2'}">
			    <div class="layui-tab-item layui-show" id="hbp-content" ><jsp:include page="../input/hbp.jsp"></jsp:include></div>
			  </c:if>
			  <c:if test="${diseaseInfo.diFlag eq '2'}">
    			<div <c:if test="${diseaseInfo.hbpFlag ne '2'}">class="layui-tab-item layui-show"</c:if> <c:if test="${diseaseInfo.hbpFlag eq '2'}">class="layui-tab-item"</c:if>  id="di-content" >
    			<jsp:include page="../input/di.jsp"></jsp:include>
                <jsp:include page="latestPhysicalExamination.jsp"></jsp:include>
             	</div>
             </c:if>
              <c:if test="${diseaseInfo.coronaryFlag eq '2'}">
    			<div <c:if test="${diseaseInfo.diFlag ne '2' && diseaseInfo.hbpFlag ne '2'}">class="layui-tab-item layui-show"</c:if> <c:if test="${diseaseInfo.diFlag eq '2' || diseaseInfo.hbpFlag eq '2'}">class="layui-tab-item"</c:if> id="coronary-content" ><jsp:include page="../input/coronary.jsp"></jsp:include></div>
    		 </c:if>
    		 <c:if test="${diseaseInfo.strokeFlag eq '2'}">
    			<div <c:if test="${diseaseInfo.coronaryFlag ne '2' && diseaseInfo.diFlag ne '2' && diseaseInfo.hbpFlag ne '2'}">class="layui-tab-item layui-show"</c:if> <c:if test="${diseaseInfo.coronaryFlag eq '2' || diseaseInfo.diFlag eq '2' || diseaseInfo.hbpFlag eq '2'}">class="layui-tab-item"</c:if> id="stroke-content" ><jsp:include page="../input/stroke.jsp"></jsp:include></div>
    		</c:if>
    		<c:if test="${diseaseInfo.tumorFlag eq '2'}">
    		<div <c:if test="${diseaseInfo.strokeFlag ne '2' && diseaseInfo.coronaryFlag ne '2' && diseaseInfo.diFlag ne '2' && diseaseInfo.hbpFlag ne '2'}">class="layui-tab-item layui-show"</c:if> <c:if test="${diseaseInfo.strokeFlag eq '2' || diseaseInfo.coronaryFlag eq '2' || diseaseInfo.diFlag eq '2' || diseaseInfo.hbpFlag eq '2'}">class="layui-tab-item"</c:if> id="tumor-content" >
    				<jsp:include page="../input/tumor-flag.jsp"></jsp:include>
                     <jsp:include page="../input/tumor.jsp"></jsp:include>
                       <c:if test="${fn:length(diseaseInfo.tumorReports)<1}">
                              <jsp:include page="../input/tumor-input.jsp"></jsp:include>
                        </c:if>
    		</div>
    		</c:if>
			  </div>
		</div>
                            <div style="height: 20px;" />
                        </c:otherwise>
                    </c:choose>
                </div>
            </div>

        </div>
    </form>
</div>
