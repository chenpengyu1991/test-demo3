<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<table class="layui-table x-admin-sm-table-list-middle">
	<colgroup>
		<col style="width:10%"/>
		<col style="width:8%;"/>
		<col style="width:5%"/>
		<col/>
		<col style="width:10%"/>
		<col style="width:12%"/>

		<col style="width:10%"/>
		<col style="width:14%"/>
		<col style="width:250px;"/>
	</colgroup>
	</colgroup>
	<thead>
	<tr>
		<th>样本编号</th>
		<th>姓名</th>
		<th>性别</th>
		<th>身份证号</th>
		<th>出生日期</th>
		<th>上报机构</th>
		<th>上报时间</th>
		<th>报卡状态</th>
		<th>操作</th>
	</tr>
	</thead>
	<tbody>
	<c:forEach var="record" items="${records}" varStatus="status">
		<tr>
			<td>${record.no1}${record.year}${record.no2}</td>
			<td class="centertd"><ehr:tip>${record.name}</ehr:tip></td>
			<td class="centertd"><ehr:tip>
				<ehr:dic dicmeta="GBT226112003" code="${record.gender}" />
			</ehr:tip></td>
			<td class="centertd"><ehr:tip>${record.idcard}</ehr:tip></td>
			<td class="centertd"><ehr:tip>
				<fmt:formatDate value='${record.birthday}' pattern='yyyy/MM/dd' />
			</ehr:tip></td>
				<%-- <td><ehr:tip trim="true">
						<c:if test="${not empty record.reportDoctorId }">
							<ehr:user userId="${record.reportDoctorId}"></ehr:user>
						</c:if>
						<c:if test="${ empty record.reportDoctorId }">
                             						${record.reportDoctorName}
                         </c:if>
					</ehr:tip></td> --%>
			<td><ehr:tip trim="true">
				<ehr:org code="${record.fillOrganCode}"></ehr:org>
			</ehr:tip></td>
			<td class="centertd"><ehr:tip trim="true">
				<fmt:formatDate value='${record.fillDate}' pattern='yyyy/MM/dd' />
			</ehr:tip></td>
			<td class="centertd"><ehr:tip trim="true">
				<c:if test="${record.status ne '3'}">
					<ehr:dic dicmeta="DMD00085" code="${record.status}"></ehr:dic>
				</c:if>
			</ehr:tip></td>
			<td class="centertd">
					<%--<ehr:authorize ifNotGranted="83">--%>
				<%-- <a href='#' data-id='${record.id}' class='view'>查看报卡</a> --%>
				<a href='#' data-id='${record.id}' class='view layui-btn layui-btn-normal layui-btn-xs' style="color: #FFF;font-size: 12px;" title="查看报卡" ><i class="layui-icon">&#xe615;</i>查看</a>&nbsp;
					<%--<c:if test="${record.status ne '1' && record.status ne '5' && record.status ne '9'}">
						<c:if test="${record.jyResult eq '1'}">
							<ehr:authorize ifAnyGranted="44">
								<a href='#' data-id='${record.id}' class='testResult'>修改检验结果</a>
							</ehr:authorize>
							<ehr:authorize ifNotGranted="44">
								<a href='#' data-id='${record.id}' class='testResult'>修改检验结果</a>
							</ehr:authorize>
						</c:if>
						<c:if test="${record.jyResult ne '1' && record.status eq '4'}">
							<ehr:authorize ifAnyGranted="44">
								<a href='#' data-id='${record.id}' class='testResult'>修改检验结果</a>
							</ehr:authorize>
						</c:if>

						&lt;%&ndash; <a href='#' data-id='${record.id}' class='testResult'>检验结果</a> &ndash;%&gt;
					</c:if>
					&lt;%&ndash; 检验结果审核 &ndash;%&gt;
					<c:if test="${record.status eq '3'}">
						<ehr:authorize ifAnyGranted="44">
							<a href='#' data-id='${record.id}' class='testResult' data-type='audit' >审核</a>
						</ehr:authorize>
					</c:if>
					<c:if test="${record.status eq '9'}">
						<a href='#' data-id='${record.id}' class='testResult'>查看检验结果</a>
					</c:if>--%>
					<%--防保科--%> <%--中心-传染病,医院-传染病--%>
				<ehr:authorize ifAnyGranted='0211,0311'>
					<c:if test="${record.status eq '1'}">
						<%-- <a href='#' data-id='${record.id}' class='edit'>审核</a> --%>
						<a href='#' data-id='${record.id}' class='edit layui-btn layui-btn-warm layui-btn-xs' style="color: #FFF;font-size: 12px;" title="审核"><i class="layui-icon">&#xe672;</i>审核</a>&nbsp;
					</c:if>
					<c:if test="${record.status eq '6' || record.status eq '7'}">
						<%-- <a href="#" data-id='${record.id}' class='edit'>修改</a> --%>
						<a href="#" data-id='${record.id}' class='edit layui-btn layui-btn-xs' style="color: #FFF;font-size: 12px;" title="修改"><i class="layui-icon">&#xe642;</i>修改</a>&nbsp;
					</c:if>
				</ehr:authorize>
					<%--疾控-传染病--%>
				<ehr:authorize ifAnyGranted="0111">
					<c:if test="${record.status eq '7' || record.status eq '2'}">
						<%-- <a href='#' data-id='${record.id}' class='lastAuth'>审核</a> --%>
						<a href='#' data-id='${record.id}' class='lastAuth layui-btn layui-btn-warm layui-btn-xs' style="color: #FFF;font-size: 12px;" title="审核"><i class="layui-icon">&#xe672;</i>审核</a>&nbsp;
					</c:if>
					<c:if test="${record.status eq '4' || record.status eq '9'}">
						<%-- <a href="#" data-id='${record.id}' class='edit'></a> --%>
						<a href="#" data-id='${record.id}' class='edit layui-btn layui-btn-xs' style="color: #FFF;font-size: 12px;" title="修改"><i class="layui-icon">&#xe642;</i>修改</a>&nbsp;
					</c:if>
				</ehr:authorize>
					<%--</ehr:authorize>--%>
				<%-- <a href="javascript:void(0)" onclick="fdReportCardSearch.print('${record.id}', 'print')">打印</a> --%>
				<a href="javascript:void(0)" onclick="fdReportCardSearch.print('${record.id}', 'print')" class="layui-btn layui-btn-warm layui-btn-xs" style="color: #FFF;font-size: 12px;" title="打印"><i class="layui-icon">&#xe66d;</i>打印</a>
					<%--<ehr:authorize ifAnyGranted="83">
                        <c:if test="${record.status eq '1'}">
                            <a href='#' data-id='${record.id}' class='edit'>审核</a>
                        </c:if>
                    </ehr:authorize>--%>
			</td>
		</tr>
	</c:forEach>
	<tr>
		<td colspan="9">
			<ehr:paging action="fdReportCardSearch.search" />
		</td>
	</tr>
	</tbody>
</table>
<%-- <ehr:paging action="fdReportCardSearch.search" /> --%>