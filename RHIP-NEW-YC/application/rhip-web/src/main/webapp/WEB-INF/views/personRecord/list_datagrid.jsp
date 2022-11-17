<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!-- 	<input type="hidden" id="personId" value=""/> -->
<div class="repeattable x-admin-sm">
	<table id="person_record_table" class="layui-table x-admin-sm-table-list-middle">
		<colgroup>
			<c:choose>
				<c:when test="${not empty urlFromPhysicalExam}">
					<col style="width:7%;"/>
					<col style="width:16%;"/>
					<col style="width:5%;"/>
					<col style="width:13%;"/>
					<col style="width:13%;"/>
					<col style="width:10%;"/>
					<col style="width:11%;"/>
					<col style="width:8%;"/>
					<col style="width:18%;"/>
				</c:when>
				<c:otherwise>
					<col style="width:7%;"/>
					<col style="width:14%;"/>
					<col style="width:5%;"/>
					<col style="width:8%;"/>
					<col style="width:8%;"/>
					<col style="width:5%;"/>
					<col style="width:11%;"/>
					<col style="width:5%;"/>
					<col style="width:38%;"/>
				</c:otherwise>
			</c:choose>
		</colgroup>
		<thead> 
			<tr>
				<th>姓名</th>
				<th>证件号</th>
				<%--<th>档案编号</th>--%>
				<%--<th>电话</th>--%>
				<%--<th>常住类型</th>--%>
				<!-- <th>常住类型</th> -->
				<th>性别</th> 
				<th>出生日期</th>
				<c:choose>
					<c:when test="${not empty urlFromPhysicalExam}"><th>管理时间</th></c:when>
					<c:otherwise><th>更新时间</th></c:otherwise>
				</c:choose>
				<th>星级</th>
				<th>管理机构</th>
				<th>状态</th>
				<%--<th>备注</th>--%>
                <!-- <th>签约情况</th> -->
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
						</td>
					    <%--<td title="${fi.healthFileNo}" style="text-align: center">--%>
							<%--<c:out value="${fi.healthFileNo}"></c:out>--%>
						<%--</td>--%>
					    <%--<td title="${fi.phoneNumber}" style="text-align: center"><c:out value="${fi.phoneNumber}"></c:out></td>--%>
					    <%-- <td class="centertd" title="<ehr:dic dicmeta="FS10005" code="${fi.householdType}"/>"><ehr:dic dicmeta="FS10005" code="${fi.householdType}"/></td> --%>
					    <%--<td title="<ehr:dic dicmeta="FS10005" code="${fi.livingType}"/>"><ehr:dic dicmeta="FS10005" code="${fi.livingType}"/></td>--%>
						<td class="centertd" title="<ehr:dic dicmeta="GBT226112003" code="${fi.gender}"/>">
							<ehr:dic dicmeta="GBT226112003" code="${fi.gender}"/>
						</td>
						<td style="text-align: center">
							<c:if test="${not empty brwAnonymousSetStr}">
								<ehr:authorize ifAnyGranted="${brwAnonymousSetStr}">
									YYYY/MM/DD
								</ehr:authorize>
								<ehr:authorize ifNotGranted="${brwAnonymousSetStr}">
									${fi.birthday}
								</ehr:authorize>
							</c:if>
							<c:if test="${empty brwAnonymousSetStr}">
								<fmt:formatDate value="${fi.birthday}" pattern="yyyy/MM/dd"/>
							</c:if>
                        </td>
						<td style="text-align: center">
							<c:choose>
								<c:when test="${not empty urlFromPhysicalExam}"><fmt:formatDate value="${fi.inputDate}" pattern="yyyy/MM/dd"/></c:when>
								<c:otherwise><fmt:formatDate value="${fi.updateDate}" pattern="yyyy/MM/dd"/></c:otherwise>
							</c:choose>
                        </td>
						<td class="centertd">
							<c:if test="${fi.star==0 || fi.star==null}"><i class="layui-icon" style="color: #FF5722;">&#xe600;</i><i class="layui-icon" style="color: #FF5722;">&#xe600;</i><i class="layui-icon" style="color: #FF5722;">&#xe600;</i></c:if>
							<c:if test="${fi.star==1}"><i class="layui-icon" style="color: #FF5722;">&#xe658;</i><i class="layui-icon" style="color: #FF5722;">&#xe600;</i><i class="layui-icon" style="color: #FF5722;">&#xe600;</i></c:if>
							<c:if test="${fi.star==2}"><i class="layui-icon" style="color: #FF5722;">&#xe658;</i><i class="layui-icon" style="color: #FF5722;">&#xe658;</i><i class="layui-icon" style="color: #FF5722;">&#xe600;</i></c:if>
							<c:if test="${fi.star==3}"><i class="layui-icon" style="color: #FF5722;">&#xe658;</i><i class="layui-icon" style="color: #FF5722;">&#xe658;</i><i class="layui-icon" style="color: #FF5722;">&#xe658;</i></c:if>
						</td>
						<td <ehr:org code="${fi.inputOrganCode}"></ehr:org> >
							<ehr:org code="${fi.inputOrganCode}"></ehr:org>
						</td>
						<td class="centertd" id="tdStatus${fi.id}">
							<input class="selected_value_off" id="status${fi.id}" type="hidden" value='<c:out value="${fi.filingFlag}"></c:out>' /> 
							<p id="pIndex${fi.id}" >
								<c:choose> 
									<c:when test="${0 == fi.filingFlag}"> 未建档</c:when> 
									<c:when test="${1 == fi.filingFlag}"> 已建档</c:when>
									<c:when test="${2 == fi.filingFlag}"> 审核中</c:when>
									<c:when test="${3 == fi.filingFlag}"> 已退回</c:when>
									<c:when test="${4 == fi.filingFlag}"> 无身份证</c:when>
									<c:when test="${5 == fi.filingFlag}"> 待迁入</c:when>
									<c:when test="${9 == fi.filingFlag}"> 已结案</c:when>
								</c:choose>  
							</p>
						</td>
					    <%--<td title="${fi.remarks}">${fi.remarks}</td>--%>
						<%-- <td class="centertd">
								FS10399
							<c:choose>
								<c:when test="${0 == fi.signFlag || empty fi.signFlag}"> 未签约</c:when>
								<c:when test="${1 == fi.signFlag}"> 已签约</c:when>
								<c:when test="${2 == fi.signFlag}"> 待付款</c:when>
							</c:choose>
						</td> --%>
					<c:choose>
						<c:when test="${not empty urlFromPhysicalExam}">
							<td id="operate" style="text-align: center;">
								<a class="personPhysicalExam layui-btn layui-btn-xs" href="#" title="体检" style="color: #FFF;font-size: 12px;"><i class="layui-icon">&#xe642;</i>体检</a>
								<a class="printPhysicalExamNum layui-btn layui-btn-xs" href="#" title="身份证条码" style="color: #FFF;font-size: 12px;"><i class="layui-icon">&#xe66d;</i>身份证条码</a>
							</td>
						</c:when>
						<c:otherwise>
							<td id="operate" style="text-align: center;">
								<c:if test="${5 ne fi.filingFlag}">
									<c:choose>
										<c:when test="${0 == fi.filingFlag}">
											<%--<a class="personModify" href="#">建档</a>--%>
											<a class="personModify layui-btn layui-btn-xs" href="#" title="建档" style="color: #FFF;font-size: 12px;"><i class="layui-icon">&#xe608;</i>建档</a>
										</c:when>
										<c:otherwise>
											<c:if test="${4 != fi.filingFlag && 9 != fi.filingFlag}">
												<%-- <a class="personModify" href="#">修改</a> --%>
												<a class="personModify layui-btn layui-btn-xs" href="#" title="修改" style="color: #FFF;font-size: 12px;"><i class="layui-icon">&#xe642;</i>修改</a>
											</c:if>
											<c:if test="${1 == fi.filingFlag}">
												<%-- <a class="personMoveOut" href="#">迁出</a>--%>
												<a class="personMoveOut layui-btn layui-btn-warm layui-btn-xs" href="#" title="迁出" style="color: #FFF;font-size: 12px;"><i class="layui-icon">&#xe62f;</i>迁出</a>
											</c:if>
											<c:choose>
												<c:when test="${2 == fi.filingFlag or 3 == fi.filingFlag}">
													<%-- <a class="personOffBack" href="#">撤销</a>--%>
													<a class="personOffBack layui-btn layui-btn-danger layui-btn-xs" href="#" title="撤销" style="color: #FFF;font-size: 12px;"><i class="layui-icon">&#xe65c;</i>撤销</a>
												</c:when>
												<%--0162312 中心和站的权限只要结案不要激活的功能,卫计局的权限有痕迹浏览，查看，激活等功能--%>
												<c:when test="${9 == fi.filingFlag}">
                                                    <a class="personOffActive layui-btn layui-btn-warm layui-btn-xs" href="#" title="激活"><i class="layui-icon" style="color: #FF5722;">&#xe601;</i>激活</a>
                                                </c:when>
												<c:otherwise>
													<c:if test="${4 != fi.filingFlag && 9 != fi.filingFlag}">
														<%--<a class="personOff" href="#">结案</a>--%>
														<a class="personOff layui-btn layui-btn-danger layui-btn-xs" href="#" title="结案" style="color: #FFF;font-size: 12px;"><i class="layui-icon">&#x1006;</i>结案</a>
													</c:if>
												</c:otherwise>
											</c:choose>
											<c:if test="${4 != fi.filingFlag}">
												<%--<a class="viewModifyTrace" href="#">痕迹浏览</a>--%>
												<a class="viewModifyTrace layui-btn layui-btn-normal layui-btn-xs" href="#" title="痕迹浏览" style="color: #FFF;font-size: 12px;"><i class="layui-icon">&#xe66e;</i>痕迹浏览</a>
											</c:if>
										</c:otherwise>
									</c:choose>
								</c:if>

									<%--<a class="basicIndex" data-person-id="${fi.id}" href="#">查看</a>--%>
								<a class="basicIndex layui-btn layui-btn-normal layui-btn-xs" href="#" title="查看" data-person-id="${fi.id}" style="color: #FFF;"><i class="layui-icon">&#xe615;</i>查看</a>

									<%--<a class="readRecord" href="#">调阅记录</a>--%>
								<a class="readRecord layui-btn layui-btn-normal layui-btn-xs" href="#" title="调阅记录" style="color: #FFF;"><i class="layui-icon">&#xe60e;</i>调阅记录</a>
							</td>
						</c:otherwise>
					</c:choose>

					</tr>
			</c:forEach>
		</tbody>
		<tr>
			<ehr:pagination action="personRecordPagination.pagination" colspan="11"/>
		</tr>
	</table>
	<table>
		<%--<tr>
			<ehr:pagination action="personRecordPagination.pagination" colspan="13"/>
		</tr>--%>
	</table>
</div>



