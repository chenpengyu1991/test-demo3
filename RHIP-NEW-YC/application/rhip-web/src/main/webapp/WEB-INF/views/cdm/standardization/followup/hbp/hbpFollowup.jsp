<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<table class="layui-table x-admin-sm-table-list-small">
	<colgroup>
		<c:if test="${'1' eq standCfg.valid}"><col style="width:30px;" /></c:if>
		<col style="width:100px;" />
		<col style="width:100px;" />
	</colgroup>
	<thead>
		<tr>
			<c:if test="${'1' eq standCfg.valid}"><th>操作</th></c:if>
			<th>计划随访时间</th>
			<th>实际随访时间</th>
		</tr>
	</thead>
	<tbody class="tbody">
		<c:forEach var="plan" items="${plans}">
			<tr class="plan-tr ${ empty plan.followupId ? 'to-follow-tr':'followed-tr' } ${plan.type=='1' and empty plan.followupId? 'add-plan' :''}" >
				<c:if test="${'1' eq standCfg.valid}">
					<td style="text-align: center;position:relative;padding-left: 0px;">
						<!-- 计划日期或者随访日期为空-->
						<c:if test="${empty plan.planDate || empty plan.followupDate}">
							<!-- 计划外-->
							<c:if test="${'3' eq plan.planType}">
								<a href="javascript:void(0)" data-planid="${plan.id}" title="删除" class="deletePlan">
									<i class="layui-icon">&#xe640;</i>
								</a>
							</c:if>
							<!-- 计划内-->
							<c:if test="${plan.planType=='1' && plan.repeatDateFlag}">
								<a href="javascript:void(0)" data-planid="${plan.id}" title="删除" class="deletePlan">
									<i class="layui-icon">&#xe640;</i>
								</a>
							</c:if>
						</c:if>

					</td>
				</c:if>
				<td style="text-align: center;position:relative;padding-left: 0px;">
					<span class="plan-date">
						<fmt:formatDate value='${plan.planDate}' pattern='yyyy/MM/dd' />
						<c:if test="${plan.pastVistFlag&&empty plan.followupId}">
<%--							<div style="color: red;position:absolute;right:5px;top:-1px;" title="逾期30天未做的随访">&nbsp;逾</div>--%>
							<span style="color: red;" title="逾期30天未做的随访">逾</span>
						</c:if>
					</span>
					<input class="plan-id" type="hidden" value="${plan.id}" />
				</td>
				<td style="text-align: center;position:relative;padding-left: 0px;">
					<c:if test="${empty plan.followupId}">
						<%--<c:if test="${plan.type !='1' }">--%>
							<%--<c:if test="${empty isNotTheFirst}">--%>
								<c:set var="isNotTheFirst" value="${true}" scope="request"></c:set>
								<c:if test="${plan.beForeOrAfteAMonth||plan.id eq lastPlan.id}"><%--非第四季度逾期后不允许随访BUG0179071--%>
									<c:if test="${fn:contains(userRoles, '0407') or fn:contains(userRoles, '0207')}">
										<span  title="点击新建随访记录" style="cursor: pointer;" data-planid="${plan.id}" data-reasonfollowid="${plan.reasonFollowId}" 
											   data-followupid="${plan.followupId}" data-followupflag="${plan.followupFlag}" data-planType="${plan.planType}" class="deal-plan" >
											填写随访
										</span>
									</c:if>
								</c:if>
								<span style="color: red;position:absolute;right:5px;top:-1px;" data-planType="${plan.planType}" title="因随访不满意新增的随访">${plan.planType eq "2"?"追":""}${plan.planType eq "3"?"外":""}</span>

							<%--</c:if>--%>
						<%--</c:if>--%>
						<%--<c:if test="${plan.type =='1' }">
                            <c:if test="${fn:contains(userRoles, '0407') or fn:contains(userRoles, '0207')}">
                                <span  title="点击新建随访记录" style="cursor: pointer;" data-planid="${plan.id}"  data-reasonfollowid="${plan.reasonFollowId}"
                                       data-followupid="${plan.followupId}" data-followupflag="${plan.followupFlag}" class="deal-plan" >
                                    填写随访
                                </span>
                            </c:if>
						</c:if>--%>
					</c:if>
					<c:if test="${not empty  plan.followupId }">
						<span title="点击修改随访记录" style="cursor: pointer;" data-planid="${plan.id}"  data-reasonfollowid="${plan.reasonFollowId}"
							  data-followupid="${plan.followupId}" data-followupflag="${plan.followupFlag}" data-plantype="${plan.planType}" class="deal-plan" >
							<fmt:formatDate value='${plan.followupDate}' pattern='yyyy/MM/dd' />
							<span style="color: red;" title="因随访不满意新增的随访">${plan.planType eq "2"?"追":""}${plan.planType eq "3"?"外":""}</span>
						</span>
					</c:if>

					<input class="followup-id"  type="hidden" value="${plan.followupId}" />

					<input class="followup-flag"  type="hidden" value="${plan.followupFlag}" />
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
