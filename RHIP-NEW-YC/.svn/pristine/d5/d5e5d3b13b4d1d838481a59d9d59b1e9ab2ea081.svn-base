<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<script src="${pageContext.request.contextPath}/js/views/ehr/region/list.js" type="text/javascript"></script>

	<input type="hidden" id="personId" value=""/>
<div class="repeattable">
	<table id="person_record_table" class="layui-table x-admin-sm-table-list-middle">
		<colgroup>
			<col style="width:6%;"/>
			<col style="width:13%;"/>
			<%--<col style="width:12%;"/>--%>
			<col style="width:8%;"/>
			<col style="width:8%;"/>
			<%--<col style="width:3%;"/>--%>
			<col style="width:5%;"/>
			<col style="width:8%;"/>
			<col style="width:8%;"/>
			<col style="width:6%;"/>
			<col style="width:13%;"/>
			<col style="width:5%;"/>
			<%--<col style="width:5%;"/>--%>
			<col style="width:7%;"/>
			<col style="width:20%;"/>
		</colgroup>
		<thead>
			<tr>
				<th>姓名</th>
				<th>证件号</th>
				<%--<th>档案编号</th>--%>
				<th>电话</th>
				<%--<th>常住类型</th>--%>
				<th>常住类型</th>
				<th>性别</th> 
				<th>出生日期</th>
				<th>更新时间</th>
				<th>星级</th>
				<th>管理机构</th>
				<th>状态</th>
				<%--<th>备注</th>--%>
				<th>签约情况</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody> 
			<c:forEach items="${personRecordList}" var="fi">				
				<tr id="tr${fi.id}"  <c:if test="${9==fi.filingFlag||2==fi.filingFlag}">class="offedperson"</c:if>>
					<td title="${fi.name}" style="text-align: center">
                        <input class="selected_value" type="hidden" value='<c:out value="${fi.id}"></c:out>' />
							<a href="<c:url value="/ehrbrowser/index/${fi.id}" /> " class="person-link-btn">
								<c:choose>
                                    <c:when test="${not empty brwAnonymousSetStr}">
                                        <ehr:authorize ifAnyGranted="${brwAnonymousSetStr}">
                                            <c:out value="${fn:substring(fi.name, 0, 1)}" />
                                            <c:choose>
                                                <c:when test="${fn:length(fi.name) ==2}">${ANONYMOUS_X}</c:when>
                                                <c:when test="${fn:length(fi.name) ==3}">${ANONYMOUS_2X}</c:when>
                                                <c:otherwise>${ANONYMOUS_3X}</c:otherwise>
                                            </c:choose>
                                        </ehr:authorize>
                                        <ehr:authorize ifNotGranted="${brwAnonymousSetStr}">
                                            ${fi.name}
                                        </ehr:authorize>
                                    </c:when>
                                    <c:otherwise>${fi.name}</c:otherwise>
                                </c:choose>
							</a>
                    </td>
						<td title="${fi.idcard}" style="text-align: center">
							<c:choose>
								<c:when test="${not empty fi.idcard}">
									<c:if test="${not empty brwAnonymousSetStr}">
										<ehr:authorize ifAnyGranted="${brwAnonymousSetStr}">
											${fn:replace(fi.idcard,fn:substring(fi.idcard,6,14), ANONYMOUS_XS)}
										</ehr:authorize>
										<ehr:authorize ifNotGranted="${brwAnonymousSetStr}">
											${fi.idcard}
										</ehr:authorize>
									</c:if>
									<c:if test="${empty brwAnonymousSetStr}">
										${fi.idcard}
									</c:if>
									<input class="person-idcard" type="hidden" value="${fi.idcard}" />
								</c:when>
								<c:when test="${'9' eq fi.otherIdcardType}">
									<c:if test="${not empty brwAnonymousSetStr}">
										<ehr:authorize ifAnyGranted="${brwAnonymousSetStr}">
											${fn:replace(fi.babyCardNo,fn:substring(fi.babyCardNo,2,5), ANONYMOUS_XS)}
										</ehr:authorize>
										<ehr:authorize ifNotGranted="${brwAnonymousSetStr}">
											${fi.babyCardNo}
										</ehr:authorize>
									</c:if>
									<c:if test="${empty brwAnonymousSetStr}">
										${fi.babyCardNo}
									</c:if>
									<input class="person-idcard" type="hidden" value="${fi.babyCardNo}" />
								</c:when>
								<c:otherwise>
									<c:if test="${not empty brwAnonymousSetStr}">
										<ehr:authorize ifAnyGranted="${brwAnonymousSetStr}">
											${fn:replace(fi.otherIdcard,fn:substring(fi.otherIdcard,2,5), ANONYMOUS_XS)}
										</ehr:authorize>
										<ehr:authorize ifNotGranted="${brwAnonymousSetStr}">
											${fi.otherIdcard}
										</ehr:authorize>
									</c:if>
									<c:if test="${empty brwAnonymousSetStr}">
										${fi.otherIdcard}
									</c:if>
									<input class="person-idcard" type="hidden" value="${fi.otherIdcard}" />
								</c:otherwise>
							</c:choose>
							<%--<c:choose>
                                <c:when test="${not empty brwAnonymousSetStr}">
                                    <ehr:authorize ifAnyGranted="${brwAnonymousSetStr}">
                                        <c:out value="${fn:replace(fi.idcard,fn:substring(fi.idcard,6,14), ANONYMOUS_XS)}" />
                                    </ehr:authorize>
                                    <ehr:authorize ifNotGranted="${brwAnonymousSetStr}">
                                        ${fi.idcard}
                                    </ehr:authorize>
                                </c:when>
                                <c:otherwise>${fi.idcard}</c:otherwise>
                            </c:choose>--%>
						</td>
					<%--<td title="${fi.healthFileNo}" style="text-align: center">--%>
						<%--<c:out value="${fi.healthFileNo}"></c:out>--%>
					<%--</td>--%>
					<td title="${fi.phoneNumber}" style="text-align: center">
						<c:if test="${not empty brwAnonymousSetStr}">
							<ehr:authorize ifAnyGranted="${brwAnonymousSetStr}">
								${fn:substring(fi.phoneNumber,0,3)}${ANONYMOUS_XS}
							</ehr:authorize>
							<ehr:authorize ifNotGranted="${brwAnonymousSetStr}">
								${fi.phoneNumber}
							</ehr:authorize>
						</c:if>
						<c:if test="${empty brwAnonymousSetStr}">
							<c:out value="${fi.phoneNumber}"></c:out>
						</c:if>
					</td>
					<td class="centertd" title="<ehr:dic dicmeta="FS10005" code="${fi.householdType}"/>"><ehr:dic dicmeta="FS10005" code="${fi.householdType}"/></td>
						<%--<td title="<ehr:dic dicmeta="FS10005" code="${fi.livingType}"/>"><ehr:dic dicmeta="FS10005" code="${fi.livingType}"/></td>--%>
						<td class="centertd" title="<ehr:dic dicmeta="GBT226112003" code="${fi.gender}"/>">
							<ehr:dic dicmeta="GBT226112003" code="${fi.gender}"/>
						</td>
						<td style="text-align: center" title=<fmt:formatDate value="${fi.birthday}" pattern="yyyy/MM/dd"/>>
							<c:if test="${not empty brwAnonymousSetStr}">
								<ehr:authorize ifAnyGranted="${brwAnonymousSetStr}">
									YYYY/MM/DD
								</ehr:authorize>
								<ehr:authorize ifNotGranted="${brwAnonymousSetStr}">
									<fmt:formatDate value="${fi.birthday}" pattern="yyyy/MM/dd"/>
								</ehr:authorize>
							</c:if>
							<c:if test="${empty brwAnonymousSetStr}">
								<fmt:formatDate value="${fi.birthday}" pattern="yyyy/MM/dd"/>
							</c:if>
						</td>
						<td style="text-align: center" title=<fmt:formatDate value="${fi.updateDate}" pattern="yyyy/MM/dd"/>><fmt:formatDate value="${fi.updateDate}" pattern="yyyy/MM/dd"/></td>
						<td class="centertd">
							<c:if test="${fi.star==0 || fi.star==null}"><i class="layui-icon" style="color: #FF5722;">&#xe600;</i><i class="layui-icon" style="color: #FF5722;">&#xe600;</i><i class="layui-icon" style="color: #FF5722;">&#xe600;</i></c:if>
							<c:if test="${fi.star==1}"><i class="layui-icon" style="color: #FF5722;">&#xe658;</i><i class="layui-icon" style="color: #FF5722;">&#xe600;</i><i class="layui-icon" style="color: #FF5722;">&#xe600;</i></c:if>
							<c:if test="${fi.star==2}"><i class="layui-icon" style="color: #FF5722;">&#xe658;</i><i class="layui-icon" style="color: #FF5722;">&#xe658;</i><i class="layui-icon" style="color: #FF5722;">&#xe600;</i></c:if>
							<c:if test="${fi.star==3}"><i class="layui-icon" style="color: #FF5722;">&#xe658;</i><i class="layui-icon" style="color: #FF5722;">&#xe658;</i><i class="layui-icon" style="color: #FF5722;">&#xe658;</i></c:if>
						</td>
						<td <ehr:org code="${fi.inputOrganCode}"></ehr:org> >
							<ehr:tip><ehr:org code="${fi.inputOrganCode}"></ehr:org></ehr:tip>
						</td>
						<td class="centertd" id="tdStatus${fi.id}">
							<input class="selected_value_off" id="status${fi.id}" type="hidden" value='<c:out value="${fi.filingFlag}"></c:out>' /> 
							<p id="pIndex${fi.id}" >
								<c:choose> 
									<c:when test="${0 == fi.filingFlag}"> 未建档</c:when> 
									<c:when test="${1 == fi.filingFlag}"> 已建档</c:when>
									<%--<c:when test="${2 == fi.filingFlag}"> 审核中</c:when> --%>
									<c:when test="${5 == fi.filingFlag}"> 待迁入</c:when>
									<c:when test="${3 == fi.filingFlag}"> 已退回</c:when>
									<c:when test="${4 == fi.filingFlag}"> 无身份证</c:when>
									<c:when test="${9 == fi.filingFlag}"> 已结案</c:when>
								</c:choose>  
							</p>
						</td>
					    <%--<td title="${fi.remarks}">${fi.remarks}</td>--%>
					<td class="centertd">
							<%--FS10399--%>
						<c:choose>
							<c:when test="${0 == fi.signFlag || empty fi.signFlag}"> 未签约</c:when>
							<c:when test="${1 == fi.signFlag}"> 已签约</c:when>
							<c:when test="${2 == fi.signFlag}"> 待付款</c:when>
						</c:choose>
					</td>
						<td>
							<%--<a class="readRecord" href="#">调阅记录</a>--%>
							<a class="readRecord layui-btn layui-btn-warm layui-btn-xs" href="#" title="调阅记录" style="color: #FFF;"><i class="layui-icon">&#xe60e;</i>调阅记录</a>
							<%--<a class="basicIndex" data-person-id="${fi.id}" href="#">查看</a>--%>
							<a class="basicIndex layui-btn layui-btn-normal layui-btn-xs" href="#" title="查看" data-person-id="${fi.id}" style="color: #FFF;"><i class="layui-icon">&#xe615;</i>查看</a>
							<ehr:authorize ifAnyGranted="04">
								<c:if test="${1 == fi.filingFlag}">
							<%--<a class="personModify" href="#">修改</a>--%>
							<a class="personModify layui-btn layui-btn-normal layui-btn-xs" href="#" title="修改" style="color: #FFF;"><i class="layui-icon">&#xe642;</i>修改</a>&nbsp;
								</c:if>
							</ehr:authorize>
							<%--区卫生局痕迹浏览，查看，激活--%>
							<ehr:authorize ifAnyGranted="01,0101">
								<c:if test="${4 != fi.filingFlag}">
									<%--<a class="viewModifyTrace" href="#">痕迹浏览</a>--%>
									<a class="viewModifyTrace layui-btn layui-btn-xs" href="#" title="痕迹浏览" style="color: #FFF;"><i class="layui-icon">&#xe66e;</i>痕迹浏览</a>&nbsp;
								</c:if>
								<c:if test="${9 == fi.filingFlag}">
									<%--<a class="personOffActive" href="#">激活</a>--%>
									<a class="personOffActive layui-btn layui-btn-warm layui-btn-xs" href="#" title="激活"><i class="layui-icon" style="color: #FF5722;">&#xe601;</i>激活</a>
								</c:if>
							</ehr:authorize>
						</td>
					</tr>
			</c:forEach>
		</tbody> 
		<tr>
			<ehr:pagination action="personRecordPagination.pagination" colspan="12"/>
		</tr>
	</table>
	<%-- <table>
		<tr>
			<ehr:pagination action="personRecordPagination.pagination" colspan="12"/>
		</tr>
	</table> --%>
</div>

