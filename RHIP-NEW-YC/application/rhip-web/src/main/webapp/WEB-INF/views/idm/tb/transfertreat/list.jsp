<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page import="com.founder.rhip.idm.common.TbStatus" %>
<c:set var="TRANSFERTREAT" value="<%=TbStatus.TRANSFERTREAT.getValue()%>"/>
<c:set var="REGISTER" value="<%=TbStatus.REGISTER.getValue()%>"/>
<c:set var="STOP" value="<%=TbStatus.STOP.getValue()%>"/>

<div class="repeattable">
	<input type="hidden" id="currentPageTransfertreat" value="${page.currentPage }"/>
	<table class="layui-table x-admin-sm-table-list-middle">
		<colgroup>
			<col style="width:10%;"/>
	        <col style="width:5%;"/>
	        <col style="width:15%;"/>
	        <col style="width:10%;"/>
			<col style="width:10%;"/>
			<col style="width:15%;"/>		
			<col style="width:10%;"/>
			<col style="width:25%;"/>
		</colgroup>	
		<thead>
			<tr>
				<th>姓名</th>
				<th>性别</th>
				<th>身份证</th>
				<th>到位状态</th>
				<th>转诊时间</th>
				<th>转诊原因</th>
				<th>诊断结果</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="transfertreat" items="${transfertreats}" varStatus="status">
				<tr <c:if test="${transfertreat.logoff == 1}">class="offedperson"</c:if>>
					<td class="centertd"><ehr:tip>${transfertreat.tbDto.name}</ehr:tip></td>
					<td class="centertd"><ehr:tip><ehr:dic code="${transfertreat.tbDto.gender}" dicmeta="GBT226112003"/></ehr:tip></td>
					<td class="centertd">
                        <ehr:ehrBrwLink idCard="${transfertreat.tbDto.idcard}"><ehr:tip>${transfertreat.tbDto.idcard}</ehr:tip></ehr:ehrBrwLink>
                    </td>
					<td class="centertd">
						<c:choose>
					 		<c:when test="${transfertreat.placeStatus == null}"><ehr:tip>未到位</ehr:tip></c:when>
					 		<c:otherwise><ehr:tip><ehr:dic code="${transfertreat.placeStatus}" dicmeta="IDM00255"/></ehr:tip></c:otherwise>
					 	</c:choose>
					</td>
					<td class="centertd"><ehr:tip><fmt:formatDate value="${transfertreat.tbDto.transferTreatmentDt}" pattern="yyyy/MM/dd"/></ehr:tip></td>
					<td><ehr:tip><ehr:dic code="${transfertreat.tbDto.diagnosisReason}" dicmeta="IDM00218"/></ehr:tip></td>
					<td>
						<c:choose>
					 		<c:when test="${transfertreat.tbDto.diagnosisType == null}"><ehr:tip>未诊断</ehr:tip></c:when>
					 		<c:otherwise><ehr:tip><ehr:dic code="${transfertreat.tbDto.diagnosisType}" dicmeta="IDM00224"/></ehr:tip></c:otherwise>
					 	</c:choose>
					</td>
					<td class="centertd">
						<c:choose>
							<c:when test="${transfertreat.specialStatus == STOP}">
								<%--<label class="loadclass">停止治疗&nbsp;</label>--%>
								<span class="loadclass" title="停止治疗"><i class="layui-icon">&#xe651;</i></span>&nbsp;
								<%-- <a href="javascript:void(0)" onclick="tbCommon.add('${transfertreat.tbDto.singleId}',${TRANSFERTREAT},'3','Transfertreat')" class="person-link-btn">查看</a> --%>
								<a href="javascript:void(0)" onclick="tbCommon.add('${transfertreat.tbDto.singleId}',${TRANSFERTREAT},'3','Transfertreat')" class="person-link-btn layui-btn layui-btn-normal layui-btn-xs" style="color: #FFF;font-size: 12px;" title="查看" ><i class="layui-icon">&#xe615;</i>查看</a>
								&nbsp;
							</c:when>
							<c:when test="${transfertreat.specialStatus == REGISTER}">
								<%-- <a href="javascript:void(0)" onclick="tbCommon.add('${transfertreat.tbDto.singleId}',${TRANSFERTREAT},'1','Transfertreat')" class="person-link-btn">新建</a> --%>
								<a href="javascript:void(0)" onclick="tbCommon.add('${transfertreat.tbDto.singleId}',${TRANSFERTREAT},'1','Transfertreat')" class="person-link-btn layui-btn layui-btn-xs" style="color: #FFF;font-size: 12px;" title="新建"><i class="layui-icon">&#xe608;</i>新建</a>
								&nbsp;
								<%--<label class="loadclass">查看&nbsp;</label>--%>
								<%--<label class="loadclass">打印&nbsp;</label>--%>
								<span class="loadclass layui-btn layui-btn-normal layui-btn-xs" style="color: #FFF;font-size: 12px;" title="查看"><i class="layui-icon">&#xe615;</i>查看</span>&nbsp;
								<span class="loadclass layui-btn layui-btn-warm layui-btn-xs" style="color: #FFF;font-size: 12px;" title="打印"><i class="layui-icon">&#xe66d;</i>打印</span>&nbsp;
								<%--<label class="loadclass">删除&nbsp;</label>--%>
							</c:when>
							<c:when test="${transfertreat.specialStatus == TRANSFERTREAT && transfertreat.tbDto.diagnosisType == null}">
								<%-- <a href="javascript:void(0)" onclick="tbCommon.add('${transfertreat.tbDto.singleId}',${TRANSFERTREAT},'2','Transfertreat')" class="person-link-btn">修改</a> --%>
								<a href="javascript:void(0)" onclick="tbCommon.add('${transfertreat.tbDto.singleId}',${TRANSFERTREAT},'2','Transfertreat')" class="person-link-btn layui-btn layui-btn-xs" style="color: #FFF;font-size: 12px;" title="修改"><i class="layui-icon">&#xe642;</i>修改</a>
								&nbsp;
								<%-- <a href="javascript:void(0)" onclick="tbCommon.add('${transfertreat.tbDto.singleId}',${TRANSFERTREAT},'3','Transfertreat')" class="person-link-btn">查看</a> --%>
								<a href="javascript:void(0)" onclick="tbCommon.add('${transfertreat.tbDto.singleId}',${TRANSFERTREAT},'3','Transfertreat')" class="person-link-btn layui-btn layui-btn-normal layui-btn-xs" style="color: #FFF;font-size: 12px;" title="查看" ><i class="layui-icon">&#xe615;</i>查看</a>
								&nbsp;
								<%-- <a href="javascript:void(0)" onclick="transfertreat.initPrint('${transfertreat.tbDto.singleId}')" class="person-link-btn">打印</a> --%>
								<a href="javascript:void(0)" onclick="transfertreat.initPrint('${transfertreat.tbDto.singleId}')" class="person-link-btn layui-btn layui-btn-warm layui-btn-xs" style="color: #FFF;font-size: 12px;" title="打印" ><i class="layui-icon">&#xe66d;</i>打印</a>
								&nbsp;
								<!--<a href="javascript:void(0)" onclick="tbCommon.deleteTb('${transfertreat.tbDto.singleId}','${transfertreat.id}','transfertreat.search')" class="person-link-btn">删除</a>&nbsp;-->
							</c:when>
							<c:otherwise>
								<%--<label class="loadclass">修改&nbsp;</label>--%>
                                  <span class="loadclass layui-btn layui-btn-xs" style="color: #FFF;font-size: 12px;" title="修改"><i class="layui-icon">&#xe642;</i>修改</span>&nbsp;
								<%-- <a href="javascript:void(0)" onclick="tbCommon.add('${transfertreat.tbDto.singleId}',${TRANSFERTREAT},'3','Transfertreat')" class="person-link-btn">查看</a> --%>
								<a href="javascript:void(0)" onclick="tbCommon.add('${transfertreat.tbDto.singleId}',${TRANSFERTREAT},'3','Transfertreat')" class="person-link-btn layui-btn layui-btn-normal layui-btn-xs" style="color: #FFF;font-size: 12px;" title="查看" ><i class="layui-icon">&#xe615;</i>查看</a>
								&nbsp;
								<%--<a href="javascript:void(0)" onclick="transfertreat.initPrint('${transfertreat.tbDto.singleId}')" class="person-link-btn">打印</a>&nbsp;--%>
                                <a href="javascript:void(0)" onclick="transfertreat.initPrint('${transfertreat.tbDto.singleId}')" class="person-link-btn layui-btn layui-btn-warm layui-btn-xs" style="color: #FFF;font-size: 12px;" title="打印" ><i class="layui-icon">&#xe66d;</i>打印</a>
                                &nbsp;
								<%--<label class="loadclass">删除&nbsp;</label>--%>
							</c:otherwise>
						</c:choose>
					</td>
				</tr>
			</c:forEach>
			<tr>
				<ehr:pagination action="transfertreat.search" colspan="8" />
			</tr>
		</tbody>
	</table>
	<%-- <table>
		<tr>
			<ehr:pagination action="transfertreat.search" colspan="8" />
		</tr>
	</table> --%>
</div>