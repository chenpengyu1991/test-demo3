<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="ehr" uri="/ehr-tag" %>
<script src="${pageContext.request.contextPath}/js/views/vaccine/hospital/details.js" type="text/javascript"></script>
<%@ page import="com.founder.rhip.ehr.common.RoleType" %>
<c:set var="ADMIN" value="<%=RoleType.ADMIN.getValue()%>"/>
<c:set var="JKYFJZ" value="<%=RoleType.JKYFJZ.getValue()%>"/>
<c:set var="ZXYFJZ" value="<%=RoleType.ZXYFJZ.getValue()%>"/>
<c:set var="JKAZB" value="<%=RoleType.JKAZB.getValue()%>"/>
<c:set var="YYFJZ" value="<%=RoleType.YYFJZ.getValue()%>"/>

<!-- CDC 主页面查询结果 -->
<div class="repeattable">
	<table class="layui-table x-admin-sm-table-list-middle" id="person_record_table">
        <colgroup>
			<col style="width:10%;"/>
            <col style="width:10%;"/>
            <col style="width:8%;"/>
            <col style="width:4%;"/>
            <col style="width:4%;"/>
            <col style="width:10%;"/>
            <col style="width:10%;"/>
            <col style="width:10%;"/>
            <col style="width:6%;"/>
            <col style="width:35%;"/>
        </colgroup>
			<thead>
				<tr>
					<th>接诊单位</th>
					<th>联系电话</th>
					<th>姓名</th>
					<th>性别</th> 
					<th>年龄</th>
					<th>身份证号</th>
					<th>现住址</th>					
					<th>疫苗类型</th>
					<th>登记日期</th>
                   	<th>操作</th>
				</tr>
			</thead>
			<!-- 遍历接种记录 -->
			<tbody class="tbody"> 
				<c:forEach items="${vaccinationRecords}" var="record">
					<tr>
						<td><ehr:tip><ehr:org code="${record.createOrg}"/></ehr:tip></td>
						<td class="centertd"><ehr:tip>${record.phoneNumber}</ehr:tip></td>
						<td class="centertd"><ehr:tip>${record.name}</ehr:tip></td>
						<td class="centertd"><ehr:tip><ehr:dic dicmeta="GBT226112003" code="${record.gender}"/></ehr:tip></td>
						<td class="centertd"><ehr:tip>${record.age}</ehr:tip></td>
						<td class="centertd"><ehr:tip>${record.idcard}</ehr:tip></td>
					    <td>
					    	<ehr:tip><ehr:dic dicmeta="FS990001" code="${record.patownShip}"></ehr:dic><ehr:dic dicmeta="FS990001" code="${record.pastreet}"></ehr:dic>${record.pahouseNumber}</ehr:tip>
						</td>
						<td>
							<c:choose>
								<c:when test="${record.immuType == 1}">
								<ehr:tip>狂犬疫苗(${record.biteLevel}级暴露)
								<c:if test="${record.rabiesType eq 51 || record.rabiesType eq 41}">(临时接种)</c:if>
								<c:if test="${record.rabiesType eq 9}">(暴露前免疫)</c:if>
								</ehr:tip>
								</c:when>
								<c:when test="${record.immuType == 2}"><ehr:tip>乙肝疫苗</ehr:tip></c:when>
								<c:when test="${record.immuType == 3}"><ehr:tip>流感疫苗</ehr:tip></c:when>
								<c:when test="${record.immuType == 4}"><ehr:tip>23价肺炎疫苗</ehr:tip></c:when>
							</c:choose>
						<td class="centertd">
							<ehr:tip><fmt:formatDate value="${record.createDate}" pattern="yyyy/MM/dd"/></ehr:tip>
                        </td>

							<td>
								<a href="javascript:void(0)" onclick="vaccineDetialH.doVaccine('${record.ehrId}','${record.immuType}','1')"
								   class="person-link-btn layui-btn layui-btn-normal layui-btn-xs" style="color: #FFF;font-size: 12px;" title="查看"><i class="layui-icon">&#xe615;</i>查看</a>&nbsp;
								<ehr:authorize ifAnyGranted="${JKYFJZ},${ZXYFJZ},${JKAZB},${YYFJZ}">
									<c:if test="${currentLoginInfo.organization.organCode eq record.createOrg}">
										<a href="javascript:void(0)" onclick="vaccineDetialH.modifyVaccine('${record.ehrId}','${record.immuType}')"
										   class="person-link-btn layui-btn layui-btn-xs" style="color: #FFF;font-size: 12px;" title="修改"><i class="layui-icon">&#xe642;</i>修改</a>&nbsp;
										<a href="javascript:void(0)" onclick="vaccineDetialH.deleteVaccine('${record.ehrId}','${record.immuType}')"
										   class="person-link-btn layui-btn layui-btn-danger layui-btn-xs" style="color: #FFF;font-size: 12px;" title="删除"><i class="layui-icon">&#xe640;</i>删除</a>&nbsp;
									</c:if>
									<c:choose>
										<c:when test="${record.pneumoniaVaccFlag ne '1'}">
											<a href="javascript:void(0)" onclick="vaccineDetialH.doVaccine('${record.ehrId}','${record.immuType}','2')"
											   class="person-link-btn layui-btn layui-btn-xs" style="color: #FFF;font-size: 12px;" title="注射"><i class="layui-icon">&#xe608;</i>注射</a>&nbsp;
										</c:when>
									</c:choose>

									<c:if test="${record.rabiesType ne 51 && record.rabiesType ne 41}">
										<a href="javascript:void(0)" onclick="vaccineDetialH.VaccinePrint('${record.ehrId}','${record.immuType}','${record.flag}')"
										   class="person-link-btn layui-btn layui-btn-warm layui-btn-xs" style="color: #FFF;font-size: 12px;" title="打印"><i class="layui-icon">&#xe66d;</i>打印</a>&nbsp;
									</c:if>
								</ehr:authorize>
							</td>
					</tr>
				</c:forEach>
				<tr>
					<ehr:pagination action="mainPageH.search" colspan="10"/>
				</tr>
			</tbody>
	</table>
	<%-- <table>
		<tr>
			<ehr:pagination action="mainPageH.search"/>
		</tr>
	</table> --%>	
</div>
