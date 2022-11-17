<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page import="com.founder.rhip.idm.common.TbStatus" %>
<%@ page import="com.founder.rhip.ehr.common.RoleType" %>
<c:set var="RECOMMENDATION" value="<%=TbStatus.RECOMMENDATION.getValue()%>"/>
<c:set var="REGISTER" value="<%=TbStatus.REGISTER.getValue()%>"/>
<c:set var="STOP" value="<%=TbStatus.STOP.getValue()%>"/>
<c:set var="JKJHB" value="<%=RoleType.JKJHB.getValue()%>"/>

<div class="repeattable">
	<input type="hidden" id="currentPageRegister" value="${page.currentPage }"/>
	<table class="layui-table x-admin-sm-table-list-middle" >
		<colgroup>
			<col style="width:10%;"/>
	        <col style="width:5%;"/>
	        <col style="width:15%;"/>
	        <%--<col style="width:10%;"/>--%>
			<col style="width:10%;"/>
			<col style="width:10%;"/>		
			<col style="width:10%;"/>	
			<col style="width:15%;"/>
			<col style="width:25%;"/>
		</colgroup>	
		<thead>
			<tr>
				<th>姓名</th>
				<th>性别</th>
				<th>身份证</th>
				<%--<th>可疑症状</th>--%>
				<th>初步诊断</th>
				<th>病人来源</th>
				<th>是否登记</th>
				<th>推荐单位</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="register" items="${registers}" varStatus="status">
				<tr <c:if test="${register.logoff == 1}">class="offedperson"</c:if>>
					<td class="centertd">${register.tbDto.name}</td>
					<td class="centertd"><ehr:dic code="${register.tbDto.gender}" dicmeta="GBT226112003"/></td>
					<td class="centertd">
                        <ehr:ehrBrwLink idCard="${register.tbDto.idcard}"><ehr:tip>${register.tbDto.idcard}</ehr:tip></ehr:ehrBrwLink>
                    </td>
					<%--<td><ehr:tip><ehr:dic code="${register.tbDto.originalSymptom}" dicmeta="IDM00213"/></ehr:tip></td>--%>
					<td>
                        <c:if test="${register.tbDto.tentativeDiagnosis!='99'}">
                            <ehr:tip><ehr:dic code="${register.tbDto.tentativeDiagnosis}" dicmeta="IDM00216"/></ehr:tip>
                        </c:if>
                        <c:if test="${register.tbDto.tentativeDiagnosis=='99'}">
                            <ehr:tip>${register.tbDto.other}</ehr:tip>
                        </c:if>
                    </td>
					<td><ehr:tip><ehr:dic code="${register.tbDto.caseSource}" dicmeta="IDM00214"/></ehr:tip></td>
					<td class="centertd">
						<c:choose>
							<c:when test="${register.specialStatus == RECOMMENDATION}"><ehr:tip>未登记筛查</ehr:tip></c:when>
							<c:otherwise><ehr:tip>已登记筛查</ehr:tip></c:otherwise>
						</c:choose>
					</td>
					<td><ehr:tip><ehr:org code="${register.tbDto.modifySurveyOrg}"/></ehr:tip></td>
					<td class="centertd">
						<c:choose>
							<c:when test="${register.specialStatus == STOP}">
								<%--<label class="loadclass">停止治疗&nbsp;</label>--%>
								<span class="loadclass" title="停止治疗"><i class="layui-icon">&#xe651;</i></span>&nbsp;
								<ehr:authorize ifNotGranted="${JKJHB}">
									<%-- <a href="javascript:void(0)" onclick="tbCommon.add('${register.tbDto.singleId}',${REGISTER},'3','Register')" class="person-link-btn">查看</a> --%>
									<a href="javascript:void(0)" onclick="tbCommon.add('${register.tbDto.singleId}',${REGISTER},'3','Register')" class="person-link-btn layui-btn layui-btn-normal layui-btn-xs" style="color: #FFF;font-size: 12px;" title="查看" ><i class="layui-icon">&#xe615;</i>查看</a>
									&nbsp;
								</ehr:authorize>
							</c:when>
							<c:when test="${register.specialStatus == RECOMMENDATION}">
								<ehr:authorize ifNotGranted="${JKJHB}">
									<%-- <a href="javascript:void(0)" onclick="tbCommon.add('${register.tbDto.singleId}',${REGISTER},'1','Register')" class="person-link-btn">新建</a> --%>
									<a href="javascript:void(0)" onclick="tbCommon.add('${register.tbDto.singleId}',${REGISTER},'1','Register')" class="person-link-btn layui-btn layui-btn-xs" style="color: #FFF;font-size: 12px;" title="新建"><i class="layui-icon">&#xe608;</i>新建</a>
									&nbsp;
								</ehr:authorize>
								<%--<label class="loadclass">查看&nbsp;</label>--%>
								<span class="loadclass layui-btn layui-btn-normal layui-btn-xs" title="查看"><i class="layui-icon">&#xe615;</i>查看</span>&nbsp;
								<%--<label class="loadclass">删除&nbsp;</label>--%>
							</c:when>
							<c:when test="${register.specialStatus == REGISTER}">
								<ehr:authorize ifNotGranted="${JKJHB}">
									<%-- <a href="javascript:void(0)" onclick="tbCommon.add('${register.tbDto.singleId}',${REGISTER},'2','Register')"class="person-link-btn">修改</a> --%>
									<a href="javascript:void(0)" onclick="tbCommon.add('${register.tbDto.singleId}',${REGISTER},'2','Register')" class="person-link-btn layui-btn layui-btn-xs" style="color: #FFF;font-size: 12px;" title="修改"><i class="layui-icon">&#xe642;</i>修改</a>
									&nbsp;
								</ehr:authorize>
								<%-- <a href="javascript:void(0)" onclick="tbCommon.add('${register.tbDto.singleId}',${REGISTER},'3','Register')" class="person-link-btn">查看</a> --%>
								<a href="javascript:void(0)" onclick="tbCommon.add('${register.tbDto.singleId}',${REGISTER},'3','Register')" class="person-link-btn layui-btn layui-btn-normal layui-btn-xs" style="color: #FFF;font-size: 12px;" title="查看" ><i class="layui-icon">&#xe615;</i>查看</a>
								&nbsp;
								<%--<a href="javascript:void(0)" onclick="tbCommon.deleteTb('${register.tbDto.singleId}','${register.id}','register.search')"class="person-link-btn">删除</a>&nbsp;--%>
							</c:when>
							<c:otherwise>
								<ehr:authorize ifNotGranted="${JKJHB}">
									<%--<label class="loadclass">修改&nbsp;</label>--%>
									<span class="loadclass layui-btn layui-btn-xs" style="color: #FFF;font-size: 12px;" title="修改"><i class="layui-icon">&#xe642;</i>修改</span>&nbsp;
								</ehr:authorize>
								<%-- <a href="javascript:void(0)" onclick="tbCommon.add('${register.tbDto.singleId}',${REGISTER},'3','Register')" class="person-link-btn">查看</a> --%>
								<a href="javascript:void(0)" onclick="tbCommon.add('${register.tbDto.singleId}',${REGISTER},'3','Register')" class="person-link-btn layui-btn layui-btn-normal layui-btn-xs" style="color: #FFF;font-size: 12px;" title="查看" ><i class="layui-icon">&#xe615;</i>查看</a>
								&nbsp;
								<%--<label class="loadclass">删除&nbsp;</label>--%>
							</c:otherwise>
						</c:choose>
					</td>
				</tr>
			</c:forEach>
			<tr>
				<ehr:pagination action="register.search" colspan="8" />
		    </tr>
		</tbody>
	</table>
	<%-- <table>
		<tr>
			<ehr:pagination action="register.search" colspan="9" />
		</tr>
	</table> --%>
</div>