<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page import="com.founder.rhip.idm.common.TbStatus" %>
<%@ page import="com.founder.rhip.ehr.common.RoleType" %>
<c:set var="RECOMMENDATION" value="<%=TbStatus.RECOMMENDATION.getValue()%>" />
<c:set var="STOP" value="<%=TbStatus.STOP.getValue()%>"/>
<c:set var="JKJHB" value="<%=RoleType.JKJHB.getValue()%>"/>
<div class="repeattable">
	<input type="hidden" id="currentPageRecommendation" value="${page.currentPage }"/>
	<table class="layui-table x-admin-sm-table-list-middle">
		<colgroup>
			<col style="width:10%;"/>
	        <col style="width:10%;"/>
	        <col style="width:15%;"/>
			<col style="width:10%;"/>
			<col style="width:15%;"/>		
			<col style="width:15%;"/>
			<col style="width:10%;"/>	
			<col style="min-width:120px;width:15%;"/>
		</colgroup>	
		<thead>
			<tr>
				<th>姓名</th>
				<th>性别</th>
				<th>身份证</th>
				<th>常住类型</th>
				<th>现住址</th>
				<th>推荐单位</th>
				<th>推荐时间</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="recommendation" items="${recommendations}" varStatus="status">
				<tr <c:if test="${recommendation.logoff == 1}">class="offedperson"</c:if>>
					<td class="centertd"><ehr:tip>${recommendation.tbDto.name}</ehr:tip></td>
					<td class="centertd"><ehr:tip><ehr:dic code="${recommendation.tbDto.gender}" dicmeta="GBT226112003"/></ehr:tip></td>
					<td class="centertd">
                        <ehr:ehrBrwLink idCard="${recommendation.tbDto.idcard}"><ehr:tip>${recommendation.tbDto.idcard}</ehr:tip></ehr:ehrBrwLink>
                    </td>
					<td><ehr:tip><ehr:dic code="${recommendation.tbDto.floatPopulation}" dicmeta="FS10005"/></ehr:tip></td>
					<td>
						<ehr:tip>${recommendation.tbDto.paAddress} </ehr:tip> 
					</td>
					<td><ehr:tip><ehr:org code="${recommendation.tbDto.modifySurveyOrg}"/></ehr:tip></td>
					<td class="centertd"><ehr:tip><fmt:formatDate value="${recommendation.tbDto.modifySurveyDate}" pattern="yyyy/MM/dd"/></ehr:tip></td>
					<td class="centertd">
						<ehr:authorize ifNotGranted="${JKJHB}">
							<c:choose>
								<c:when test="${recommendation.specialStatus == STOP}">
									<a href="javascript:void(0)" style="color: #FFF;font-size: 12px;"onclick="tbCommon.add('${recommendation.tbDto.singleId}',${RECOMMENDATION},'3','Recommendation')" class="person-link-btn layui-btn layui-btn-normal layui-btn-xs" title="查看" ><i class="layui-icon">&#xe615;</i>查看</a>
									<a class="loadclass layui-btn layui-btn-xs layui-btn-disabled" title="停止治疗"><i class="layui-icon">&#xe651;</i>停止治疗</a>&nbsp;
								</c:when>
								<c:when test="${recommendation.specialStatus != RECOMMENDATION || not empty recommendation.tbDto.diagnosisType}">
									<a href="javascript:void(0)" style="color: #FFF;font-size: 12px;"onclick="tbCommon.add('${recommendation.tbDto.singleId}',${RECOMMENDATION},'3','Recommendation')" class="person-link-btn layui-btn layui-btn-normal layui-btn-xs" title="查看" ><i class="layui-icon">&#xe615;</i>查看</a>
									<a class="loadclass layui-btn layui-btn-xs layui-btn-disabled" title="修改"><i class="layui-icon">&#xe642;</i>修改</a>&nbsp;
								</c:when>
								<c:otherwise>
									<a href="javascript:void(0)" style="color: #FFF;font-size: 12px;"onclick="tbCommon.add('${recommendation.tbDto.singleId}',${RECOMMENDATION},'3','Recommendation')" class="person-link-btn layui-btn layui-btn-normal layui-btn-xs" title="查看" ><i class="layui-icon">&#xe615;</i>查看</a>
									<a href="javascript:void(0)" style="color: #FFF;font-size: 12px;"onclick="tbCommon.add('${recommendation.tbDto.singleId}',${RECOMMENDATION},'2','Recommendation')" class="person-link-btn layui-btn layui-btn-xs" title="修改"><i class="layui-icon">&#xe642;</i>修改</a>
								</c:otherwise>
							</c:choose>
						</ehr:authorize>
						<ehr:authorize ifAnyGranted="${JKJHB}">
							<a href="javascript:void(0)" style="color: #FFF;font-size: 12px;"onclick="tbCommon.add('${recommendation.tbDto.singleId}',${RECOMMENDATION},'3','Recommendation')" class="person-link-btn layui-btn layui-btn-normal layui-btn-xs" title="查看" ><i class="layui-icon">&#xe615;</i>查看</a>
						</ehr:authorize>
					</td>
				</tr>
			</c:forEach>
			<tr>
			<ehr:pagination action="recommendation.search" colspan="8" />
		</tr>
		</tbody>
	</table>
</div>