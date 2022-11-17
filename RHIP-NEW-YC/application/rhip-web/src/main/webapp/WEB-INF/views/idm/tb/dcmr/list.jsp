<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="com.founder.rhip.idm.common.TbStatus" %>

<c:set var="RECOMMENDATION" value="<%=TbStatus.RECOMMENDATION.getValue()%>" />
<c:set var="TRANSFERTREAT" value="<%=TbStatus.TRANSFERTREAT.getValue()%>" />
<c:set var="DCMR" value="<%=TbStatus.DCMR.getValue()%>" />
<c:set var="ACCEPT" value="<%=TbStatus.ACCEPT.getValue()%>"/>
<c:set var="STOP" value="<%=TbStatus.STOP.getValue()%>"/>
<c:set var="REASSIGN" value="<%=TbStatus.REASSIGN.getValue()%>"/>
<c:set var="ASSIGN" value="<%=TbStatus.ASSIGN.getValue()%>"/>

<div class="repeattable">
	<input type="hidden" id="currentPageDcmr" value="${page.currentPage }"/>
	<table class="layui-table x-admin-sm-table-list-middle">
		<colgroup>
			<col style="width:15%;"/>
	        <col style="width:5%;"/>
	        <col style="width:15%;"/>
			<col style="width:15%;"/>
			<col style="width:15%;"/>		
			<col style="width:10%;"/>	
			<col style="width:10%;"/>	
			<col style="min-width:80px;width:15%;"/>
		</colgroup>	
		<thead>
			<tr>
				<th>姓名</th>
				<th>性别</th>
				<th>身份证号</th>
				<th>诊断结果</th>
				<th>实际管理方式</th>
				<th>管理状态</th>
				<th>治疗分类</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="statusInfo" items="${dcmrs}" varStatus="status">
				<tr <c:if test="${statusInfo.logoff == 1}">class="offedperson"</c:if>>
					<td class="centertd"><ehr:tip>${statusInfo.tbDto.name}</ehr:tip></td>
					<td class="centertd"><ehr:tip><ehr:dic code="${statusInfo.tbDto.gender}" dicmeta="GBT226112003"/></ehr:tip></td>
					<td class="centertd">
                        <ehr:ehrBrwLink idCard="${statusInfo.tbDto.idcard}"><ehr:tip>${statusInfo.tbDto.idcard}</ehr:tip></ehr:ehrBrwLink>
                    </td>
					<td>
                        <ehr:tip>
							<ehr:dic code="${statusInfo.tbDto.diagnosisType}" dicmeta="IDM00224"/><c:if test="${statusInfo.tbDto.lastDiagnosis!=null && statusInfo.tbDto.lastDiagnosis!=''}"><ehr:dic code="${statusInfo.tbDto.lastDiagnosis}" dicmeta="IDM00237"/></c:if>
							<c:if test="${statusInfo.tbDto.diagnosisAccording!=null && statusInfo.tbDto.diagnosisAccording!=''}"><c:if test="${statusInfo.tbDto.diagnosisAccording==1}">结核性胸膜炎Ⅳ型</c:if><c:if test="${statusInfo.tbDto.diagnosisAccording==2}">其他肺外结核Ⅴ型</c:if></c:if>
							<c:if test="${statusInfo.tbDto.diagnosisReasonMulti!=null && statusInfo.tbDto.diagnosisReasonMulti!=''}">【<ehr:dic code="${statusInfo.tbDto.diagnosisReasonMulti}" dicmeta="IDM00238"/></c:if>&nbsp;${statusInfo.tbDto.diagnosisOther}<c:if test="${statusInfo.tbDto.diagnosisReasonMulti!=null && statusInfo.tbDto.diagnosisReasonMulti!=''}">】</c:if>
                        </ehr:tip>
                    </td>
					<td><ehr:tip><ehr:dic code="${statusInfo.tbDto.manageType}" dicmeta="IDM00243"/></ehr:tip></td>
					<td class="centertd">
						<c:choose>
							<c:when test="${statusInfo.specialStatus == ACCEPT}"><ehr:tip>已管理</ehr:tip></c:when>
							<c:otherwise><ehr:tip>未管理</ehr:tip></c:otherwise>
						</c:choose>
					</td>
					<td><ehr:tip><ehr:dic code="${statusInfo.tbDto.thisType}" dicmeta="IDM00215"/></ehr:tip></td>
					<td class="centertd">
						<c:choose>
							<c:when test="${statusInfo.specialStatus == STOP}">
								<a href="javascript:void(0)" onclick="tbCommon.add('${statusInfo.tbDto.singleId}',${DCMR},'3','Dcmr')"class="person-link-btn layui-btn layui-btn-normal layui-btn-xs" style="color: #FFF;" title="查看" ><i class="layui-icon">&#xe615;</i>查看</a>
								<a class="loadclass layui-btn layui-btn-xs layui-btn-disabled" title="停止治疗"><i class="layui-icon">&#xe651;</i>停止治疗</a>
							</c:when>
							<c:when test="${statusInfo.specialStatus == TRANSFERTREAT || statusInfo.specialStatus == RECOMMENDATION }">
								<a class="loadclass layui-btn layui-btn-xs layui-btn-disabled" title="查看"><i class="layui-icon">&#xe615;</i>查看</a>
								<c:choose>
									<c:when test="${statusInfo.logoff == 1}">
										<a class="loadclass layui-btn layui-btn-xs layui-btn-disabled" title="新建"><i class="layui-icon">&#xe608;</i>新建</a>
									</c:when>
									<c:otherwise>
										<a href="javascript:void(0)" onclick="tbCommon.add('${statusInfo.tbDto.singleId}',${DCMR},'1','Dcmr')"class="person-link-btn layui-btn  layui-btn-xs" style="color: #FFF;" title="新建" ><i class="layui-icon">&#xe608;</i>新建</a>
									</c:otherwise>
								</c:choose>
							</c:when>
							<c:when test="${statusInfo.specialStatus == REASSIGN || statusInfo.specialStatus == ASSIGN}">
								<a href="javascript:void(0)" onclick="tbCommon.add('${statusInfo.tbDto.singleId}',${DCMR},'3','Dcmr')" class="person-link-btn layui-btn layui-btn-normal layui-btn-xs" style="color: #FFF;" title="查看" ><i class="layui-icon">&#xe615;</i>查看</a>
								<a class="loadclass layui-btn layui-btn-xs layui-btn-disabled" title="修改"><i class="layui-icon">&#xe642;</i>修改</a>
							</c:when>
							<c:otherwise>
								<a href="javascript:void(0)" onclick="tbCommon.add('${statusInfo.tbDto.singleId}',${DCMR},'3','Dcmr')" class="person-link-btn layui-btn layui-btn-normal layui-btn-xs" style="color: #FFF;" title="查看" ><i class="layui-icon">&#xe615;</i>查看</a>
								<c:choose>
									<c:when test="${statusInfo.logoff == 1}">
										<a class="loadclass layui-btn layui-btn-xs layui-btn-disabled" title="修改"><i class="layui-icon">&#xe642;</i>修改</a>
									</c:when>
									<c:otherwise>
										<a href="javascript:void(0)" onclick="tbCommon.add('${statusInfo.tbDto.singleId}',${DCMR},'2','Dcmr')"class="person-link-btn layui-btn layui-btn-xs" style="color: #FFF;" title="修改"><i class="layui-icon">&#xe642;</i>修改</a>
									</c:otherwise>
								</c:choose>
							</c:otherwise>
						</c:choose>
					</td>
				</tr>
			</c:forEach>
			<tr>
				<ehr:pagination action="dcmr.search" colspan="9" />
			</tr>
		</tbody>
	</table>
</div>