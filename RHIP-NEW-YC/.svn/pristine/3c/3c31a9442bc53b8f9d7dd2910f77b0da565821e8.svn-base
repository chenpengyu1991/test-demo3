﻿﻿<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<div id="main">
	<div id="colLeft">
		<div style="height:224px">
			<div class="content_right">
			<div class="txt-bg"></div>
			<div class="bd">
				<ul>
					<c:forEach items="${rollPicList}" var="rollPic">
					<li>
						<c:forEach items="${rollPicattches}" var="attche" varStatus="status">
							<c:if test="${attche.resourceId eq rollPic.id}">
							<a target="_blank" id="detail${rollPic.id}" data-id="${rollPic.id}">
								<img width="291" height="219" border="0" src="${pageContext.request.contextPath}/home/showAsImage/${attche.id}?type=1" />
							</a>
							</c:if>
						</c:forEach>
					</li>
					</c:forEach>
				</ul>
			</div>
			<div class="hd">
				<ul>
					<c:forEach items="${rollPicList}" var="rollPic" varStatus="status">
						<li>${status.count }</li>
					</c:forEach>
				</ul>
			</div>
			<div class="txt">
				<ul>
					<c:forEach items="${rollPicList}" var="rollPic">
						<li>
							<c:choose>
								<c:when test="${fn:length(rollPic.rollPictureInfo) > 14}">
									<a title="${rollPic.rollPictureInfo}" target="_blank" id="detail${rollPic.id}" data-id="${rollPic.id}">
									${fn:substring(rollPic.rollPictureInfo, 0, 14)}...</a>
								</c:when>
								<c:otherwise>
									<a title="${rollPic.rollPictureInfo}" target="_blank" id="detail${rollPic.id}" data-id="${rollPic.id}">
									${rollPic.rollPictureInfo}</a>
								</c:otherwise>
							</c:choose>
						</li>
					</c:forEach>
				</ul>
			</div>
			</div>
		</div>

		<div class=rmyy>
			<div class="divTitleBg">					
				<div class="divTitle">热门专家</div>
				<a class="divMore" id="moreRmzj">更多&gt;&gt;</a>
			</div>
			<div class="roll_doctors">
				<div class="rmyyList">
					<ul>
						<c:forEach items="${rollDoctors}" var="rmzj" varStatus="status">
							<li class="pic-${status.index }">
								<a href="${pageContext.request.contextPath }/userSpace/hotExpert/search?hospitalCode=${rmzj.hospitalCode}&deptSn=${rmzj.deptSn}&doctorSn=${rmzj.doctorSn}" target="_blank">
									<c:choose>
		                                <c:when test="${empty rmzj.uploadFileId}">
		                                    <img src="${pageContext.request.contextPath}/images/doctor/doctor_default_img.jpg"/>
		                                </c:when>
		                                <c:otherwise>
		                                	<img src="${pageContext.request.contextPath}/home/showAsImage/${rmzj.uploadFileId}?type=1"/>
		                                </c:otherwise>
		                            </c:choose>				
                        		</a>
                        		<p>${rmzj.name}<c:if test="${not empty rmzj.empTitName}"><span>${rmzj.empTitName}</span></c:if></p>
                        		<p>
                        			<c:choose>
								 		<c:when test="${fn:length(rmzj.deptName) > 7}">
								 			 <label title="${rmzj.deptName}">${fn:substring(rmzj.deptName, 0, 7)}...</label>
								 		</c:when>
								 		<c:otherwise>
											 <label title="${rmzj.deptName}">${rmzj.deptName}</label>
								 		</c:otherwise>
								 	</c:choose>
                        		</p>
                        		<p>
                        			<c:choose>
								 		<c:when test="${fn:length(rmzj.hospitalName) > 6}">
								 			 <label title="${rmzj.hospitalName}">${fn:substring(rmzj.hospitalName, 0, 6)}...</label>
								 		</c:when>
								 		<c:otherwise>
											 <label title="${rmzj.hospitalName}">${rmzj.hospitalName}</label>
								 		</c:otherwise>
								 	</c:choose>
								</p>
							</li>
						</c:forEach>
					</ul>
				</div>
			</div>
		</div>
		<div class="ggtz">
			<div class="divTitleBg">
				<div class="divTitle">公告通知</div>
				<a class="divMore" id="moreSub${advNoteMore}" data-code="${advNoteMore}">更多&gt;&gt;</a>
			</div>
			<div class="ggtzList">
				<ul>
					<c:forEach items="${advNote}" var="ggtz">
						<li>
							<c:choose>
								<c:when test="${fn:length(ggtz.title) > 16}">
									<a title="${ggtz.title}" target="_blank" id="detail${ggtz.id}" data-id="${ggtz.id}">
									${fn:substring(ggtz.title, 0, 16)}...</a>
								</c:when>
								<c:otherwise>
									<a title="${ggtz.title}" target="_blank" id="detail${ggtz.id}" data-id="${ggtz.id}">
									${ggtz.title}</a>
								</c:otherwise>
							</c:choose>
							<span><fmt:formatDate value="${ggtz.creatTime}" pattern="yyyy/MM/dd"/></span>
						</li>
					</c:forEach>
				</ul>
			</div>
		</div>
	</div>
	<div id="colCenter">
		<div class="xwzx">
			<div class="divTitleBg">
				<%-- <img style="height:23px;float:left" src="${pageContext.request.contextPath}/images/xwzx.png"> --%>
				<i class="icon-xwzx"></i>
				<div class="divXwzxTitle">
				新闻动态
				</div>
				<a class="divMore" id="moreSub${newNoteMore}" data-code="${newNoteMore}">更多&gt;&gt;</a>
			</div>
			<div class="roll_news">
				<div class="xwzxList">
					<ul>
						<c:forEach items="${newNote}" var="xwdt">
							<li>
								<c:choose>
									<c:when test="${fn:length(xwdt.title) > 24}">
										<a title="${xwdt.title}" target="_blank" id="detail${xwdt.id}" data-id="${xwdt.id}">
										${fn:substring(xwdt.title, 0, 24)}...</a>
									</c:when>
									<c:otherwise>
										<a title="${xwdt.title}" target="_blank" id="detail${xwdt.id}" data-id="${xwdt.id}">
										${xwdt.title}</a>
									</c:otherwise>
								</c:choose>
								<span><fmt:formatDate value="${xwdt.creatTime}" pattern="yyyy/MM/dd"/></span>
							</li>
						</c:forEach>
					</ul>
				</div>
			</div>
		</div>
		<div class="yyjt">
			<div class="divTitleBg">
				<div class="divTitle">医疗机构</div>
			</div>
			<div class="yyjtList-yc">
                <ul>
					<c:forEach items="${yljg}" var="yljg">
						<li style="list-style: none; width:190px; margin-bottom:5px">
							<c:choose>
								<c:when test="${fn:length(yljg.hospitalName) > 16}">
									<a title="${yljg.hospitalName}" target="_blank" id="yljgDetail${yljg.id}" data-id="${yljg.id}" data-grade="${yljg.hospitalLevel }">
									${fn:substring(yljg.hospitalName, 0, 16)}...</a>
								</c:when>
								<c:otherwise>
									<a title="${yljg.hospitalName}" target="_blank" id="yljgDetail${yljg.id}" data-id="${yljg.id}" data-grade="${yljg.hospitalLevel }">
									${yljg.hospitalName}</a>
								</c:otherwise>
							</c:choose>
						</li>
					</c:forEach>
				</ul>
       		</div>
		</div>
		<div class="jkxj">
			<div class="divTitleBg">
				<div class="divTitle">资料下载</div>
				<a class="divMore" id="moreZlxz">更多&gt;&gt;</a>
			</div>
			<div class="jkxjList">
				<ul>
					<c:forEach items="${zlxz}" var="zlxz">
						<li>
							<c:choose>
								<c:when test="${fn:length(zlxz.title) > 24}">
									<a title="${zlxz.title}" target="_blank" id="zlxzDetail${zlxz.id}" data-id="${zlxz.id}" data-type="${zlxz.fileType}">
									${fn:substring(zlxz.title, 0, 24)}...</a>
								</c:when>
								<c:otherwise>
									<a title="${zlxz.title}" target="_blank" id="zlxzDetail${zlxz.id}" data-id="${zlxz.id}" data-type="${zlxz.fileType}">
									${zlxz.title}</a>
								</c:otherwise>
							</c:choose>
							<span><fmt:formatDate value="${zlxz.createDate}" pattern="yyyy/MM/dd"/></span>
						</li>
					</c:forEach>
				</ul>
			</div>
		</div>
	</div>
	<div id="colRight">
		<%-- <div class="jkdaBg">
			<div style="padding-top:75px;"></div>
			<div class="jkdaSub">
				<div class="jbxx"><a class="jkda_a" href="${pageContext.request.contextPath}/userSpace/ehr/basic">基 本 信 息</a></div>
				<div class="ylhd"><a class="jkda_a" href="${pageContext.request.contextPath}/userSpace/service/result">医 疗 活 动</a></div>
				<div class="fnbj"><a class="jkda_a" href="${pageContext.request.contextPath}/womenHealthCare/prenatalFollowupList">妇 女 保 健</a></div>
				<div class="etbj"><a class="jkda_a" href="${pageContext.request.contextPath}/childrenHealthCare/childHealthCard">儿 童 保 健</a></div>
				<div class="jbgl"><a class="jkda_a" href="${pageContext.request.contextPath}/CDmanage/manageIndex">疾 病 管 理</a></div>
			</div>
		</div> --%>
		<div class="zcBg_Title">
			<div class="yygh"><a class="jkda_a" href="${pageContext.request.contextPath}/userSpace/reserve/search">预约挂号</a><i class="yygh_bg"></i></div>
			<div class="xxcx"><a class="jkda_a" href="${pageContext.request.contextPath}/infoShow/infoList?code=1&indexPage=1">信息查询</a><i class="xxcx_bg"></i></div>
			<div class="tzzc"><a class="jkda_a" href="javascript:void(0);" id="bmiBtnId">体重自测</a><i class="tzzc_bg"></i></div>
			<div class="klljs"><a class="jkda_a" target="_blank" href="http://www.boohee.com/assessment/calory/#">卡路里计算</a><i class="klljs_bg"></i></div>
			<div class="tnbysjs"><a class="jkda_a" target="_blank" href="http://med.39.net/tools/tnbys.html">糖尿病饮食计算</a></div>
		</div>
		<%--<div class="app-download">
		  <div id="androidAppDownload"  class="android-app">
		 	 <div class="android-app-icon">
		 	 </div>
		 	 <div class="app-title">
		 	 点击下载安卓版
		 	 </div>
		  </div>
		   <div id="iphoneAppDownload"  class="iphone-app">
		     <div class="iphone-app-icon">
		 	 </div>
		 	 <div class="app-title">
		 	 点击下载苹果版
		 	 </div>
		   </div>
		</div>--%>
		<%-- <div class="wjdc">
			<div class="divTitleBg">
				<div class="divTitle">调查问卷</div>
				<a class="divMore" id="moreDcwj">更多&gt;&gt;</a>
			</div>
			<div class="wjdcList">
				<ul>
					<c:forEach items="${surveyList}" var="dcwj">
						<li>
							<c:choose>
								<c:when test="${fn:length(dcwj.title) > 9}">
									<a title="${dcwj.title}" target="_blank" id="dcwjDetail${dcwj.id}" data-id="${dcwj.id}">
									${fn:substring(dcwj.title, 0, 9)}...</a>
								</c:when>
								<c:otherwise>
									<a title="${dcwj.title}" target="_blank" id="dcwjDetail${dcwj.id}" data-id="${dcwj.id}">
									${dcwj.title}</a>
								</c:otherwise>
							</c:choose>
							<span><fmt:formatDate value="${dcwj.submitTime}" pattern="yyyy/MM/dd"/></span>
						</li>
					</c:forEach>
				</ul>
			</div>
		</div> --%>
	</div>
	<div class="links">
		<div class="yqlj">
			<div class="divTitleBg">
				<div class="divTitle">友情链接</div>
				<%-- <a class="divMore" href=""></a> --%>
			</div>
			<div class="yqljList">
				<ul>
					<c:forEach items="${organizationLink}" var="yqlj">
						<li>
							<c:forEach items="${attches}" var="attche" varStatus="status">
								<c:if test="${attche.resourceId eq yqlj.id}">
									<a target="blank" href="${yqlj.url}">
										<img width="27" height="26" border="0" src="${pageContext.request.contextPath}/home/showAsImage/${attche.id}?type=1" />
									</a>
								</c:if>
							</c:forEach>
							<c:choose>
								<c:when test="${fn:length(yqlj.orgName) > 14}">
									<a style="margin-left:5px" title="${yqlj.orgName}" target="_blank" href="${yqlj.url}">
									${fn:substring(yqlj.orgName, 0, 14)}...</a>
								</c:when>
								<c:otherwise>
									<a style="margin-left:5px" title="${yqlj.orgName}" target="_blank" href="${yqlj.url}">${yqlj.orgName}</a>
								</c:otherwise>
							</c:choose>
						</li>
					</c:forEach>
				</ul>
			</div>
		</div>
	</div>
</div>
