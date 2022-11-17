<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>

<script src="${pageContext.request.contextPath}/js/views/he/record/detail.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/he/record/edit.js" type="text/javascript"></script>

<div class="repeattable">
	<c:if test="${type eq '1'}">
	<table class="layui-table x-admin-sm-table-list-middle">
		<colgroup>
			<col style="width: 20%;" />
			<col style="width: 10%;" />
			<col style="width: 10%;" />
			<col style="width: 15%;" />
			<col style="width: 15%;" />
			<col style="width: 10%;" />
			<col style="width: 20%;" />
		</colgroup>
		<thead>
			<tr>
				<th>机构名称</th>
				<th>阵地类型</th>
				<th>版面数量</th>
				<th>地点</th>
				<th>宣传内容</th>
				<th>使用时间</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="healthEducationResourceRecord" items="${healthEducationResourceRecords}">
				<tr>
					<td>
						<%--<c:if test="${empty orgCode && empty centerOrgCode && empty gbcode}">--%>
								<%--<ehr:tip><ehr:dic code="${healthEducationResourceRecord.gbcode}" dicmeta="FS990001"  /></ehr:tip>--%>
						<%--</c:if>--%>
						<%--<c:if test="${not empty orgCode || not empty centerOrgCode || not empty gbcode}">--%>
								<%--<ehr:tip><ehr:org code="${healthEducationResourceRecord.orgCode}" /></ehr:tip>--%>
                        <%--</c:if>--%>
                            <%--<c:if test="${healthEducationResourceRecord.orgCode eq healthEducationResourceRecord.centerOrgCode}">--%>
                                <%--<ehr:tip><ehr:org code="${healthEducationResourceRecord.orgCode}" /></ehr:tip>--%>
                            <%--</c:if>--%>
                            <%--<c:if test="${healthEducationResourceRecord.orgCode ne healthEducationResourceRecord.centerOrgCode}">--%>
                                <%--<ehr:tip><ehr:org code="${healthEducationResourceRecord.centerOrgCode}" /></ehr:tip>--%>
                            <%--</c:if>--%>
                        <%--需求修改：不显示镇显示具体机构名称.2014-03-10--%>
                        <ehr:tip><ehr:org code="${healthEducationResourceRecord.orgCode}" /></ehr:tip>
                        <c:if test="${healthEducationResourceRecord.gbcode eq '_999'}"><ehr:tip>健康教育所</ehr:tip></c:if>
					</td>
					<td><ehr:tip><ehr:dic dicmeta="HE00008" code="${healthEducationResourceRecord.positionType}"></ehr:dic></ehr:tip></td>
					<td class="righttd">${healthEducationResourceRecord.pageQuantity}</td>
					<td><ehr:tip>${healthEducationResourceRecord.place}</ehr:tip></td>
					<td>
						<c:if test="${healthEducationResourceRecord.contentType eq '99'}"><ehr:tip>${healthEducationResourceRecord.otherMaterialType}</ehr:tip></c:if>
						<c:if test="${healthEducationResourceRecord.contentType ne '99'}"><ehr:tip><ehr:dic dicmeta="HE00005" code="${healthEducationResourceRecord.contentType}"></ehr:dic></ehr:tip></c:if>
					</td>
					<td class="centertd"><fmt:formatDate value="${healthEducationResourceRecord.useTime}" pattern="yyyy-MM-dd"/></td>
					<td>
						<%-- <a href="javascript:void(0);"  onclick="healthEducationResourceRecordDetail.viewHealthEducationResourceRecord(${healthEducationResourceRecord.id})">查看</a> --%>
						<a href="javascript:void(0);"  onclick="healthEducationResourceRecordDetail.viewHealthEducationResourceRecord(${healthEducationResourceRecord.id})" title="查看" class="layui-btn layui-btn-normal layui-btn-xs" style="color: #FFF;font-size: 12px;"><i class="layui-icon">&#xe615;</i>查看</a>&nbsp;
						<c:if test="${createrOrg eq healthEducationResourceRecord.orgCode || createrOrg eq '_999'}">
						<%-- <a href="javascript:void(0);"  onclick="healthEducationResourceRecordEdit.editHealthEducationResourceRecord(${healthEducationResourceRecord.id})">修改</a> --%>
						<a href="javascript:void(0);"  onclick="healthEducationResourceRecordEdit.editHealthEducationResourceRecord(${healthEducationResourceRecord.id})" title="修改" class="layui-btn layui-btn-xs" style="color: #FFF;font-size: 12px;"><i class="layui-icon">&#xe642;</i>修改</a>
						<%-- <a href="javascript:void(0);"  onclick="healthEducationResourceRecordEdit.deletehealthEducationResourceRecord(${healthEducationResourceRecord.id})">删除</a> --%>
						<a href="javascript:void(0);"  onclick="healthEducationResourceRecordEdit.deletehealthEducationResourceRecord(${healthEducationResourceRecord.id})" title="删除" class="layui-btn layui-btn-danger layui-btn-xs" style="color: #FFF;font-size: 12px;"><i class="layui-icon">&#xe640;</i>删除</a>
						</c:if>
					</td>
				</tr>
			</c:forEach>
			<tr>
			<ehr:pagination action="healthEducationResourceRecordSearch.search" colspan="7"/>
			</tr>
		</tbody>
	</table>
	</c:if>
	<c:if test="${type eq '2'}">
		<table class="layui-table x-admin-sm-table-list-middle">
		<colgroup>
			<col style="width: 15%;" />
			<col style="width: 10%;" />
			<col style="width: 15%;" />
			<col style="width: 10%;" />
			<col style="width: 10%;" />
			<col style="width: 10%;" />
			<col style="width: 10%;" />
			<col style="width: 20%;" />
		</colgroup>
		<thead>
			<tr>
				<th>机构名称</th>
				<th>资料类型</th>
				<th>资料名称</th>
				<th>资料数量</th>
				<th>发放人</th>
				<th>领取人</th>
				<th>时间</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="healthEducationResourceRecord" items="${healthEducationResourceRecords}">
				<tr>
					<td>
						<%--<c:if test="${empty orgCode && empty centerOrgCode && empty gbcode}">--%>
								<%--<ehr:tip><ehr:dic code="${healthEducationResourceRecord.gbcode}" dicmeta="FS990001"  /></ehr:tip>--%>
						<%--</c:if>--%>
						<%--<c:if test="${not empty orgCode || not empty centerOrgCode || not empty gbcode}">--%>
								<%--<ehr:tip><ehr:org code="${healthEducationResourceRecord.orgCode}" /></ehr:tip>--%>
						<%--</c:if>--%>
                                <%--需求修改：不显示镇显示具体机构名称,如果是站则显示中心名称.2014-02-17--%>
                            <%--<c:if test="${healthEducationResourceRecord.orgCode eq healthEducationResourceRecord.centerOrgCode}">--%>
                                <%--<ehr:tip><ehr:org code="${healthEducationResourceRecord.orgCode}" /></ehr:tip>--%>
                            <%--</c:if>--%>
                            <%--<c:if test="${healthEducationResourceRecord.orgCode ne healthEducationResourceRecord.centerOrgCode}">--%>
                                <%--<ehr:tip><ehr:org code="${healthEducationResourceRecord.centerOrgCode}" /></ehr:tip>--%>
                            <%--</c:if>--%>
                            <%--需求修改：不显示镇显示具体机构名称.2014-03-10--%>
                            <ehr:tip><ehr:org code="${healthEducationResourceRecord.orgCode}" /></ehr:tip>
                            <c:if test="${healthEducationResourceRecord.gbcode eq '_999'}"><ehr:tip>健康教育所</ehr:tip></c:if>
					</td>
					<td>
						<c:if test="${healthEducationResourceRecord.materialType eq '99'}"><ehr:tip>${healthEducationResourceRecord.otherMaterialType}</ehr:tip></c:if>
						<c:if test="${healthEducationResourceRecord.materialType ne '99'}"><ehr:tip><ehr:dic dicmeta="HE00007" code="${healthEducationResourceRecord.materialType}"></ehr:dic></ehr:tip></c:if>
					</td>
					<td>${healthEducationResourceRecord.materialName}</td>
					<td class="righttd">${healthEducationResourceRecord.issueQuantity}</td>
					<td class="centertd">${healthEducationResourceRecord.issuer}</td>
					<td class="centertd">${healthEducationResourceRecord.receiver}</td>
					<td class="centertd"><fmt:formatDate value="${healthEducationResourceRecord.issueTime}" pattern="yyyy-MM-dd"/></td>
					<td>
						<%-- <a href="javascript:void(0);"  onclick="healthEducationResourceRecordDetail.viewHealthEducationResourceRecord(${healthEducationResourceRecord.id})">查看</a> --%>
						<a href="javascript:void(0);"  onclick="healthEducationResourceRecordDetail.viewHealthEducationResourceRecord(${healthEducationResourceRecord.id})" title="查看" class="layui-btn layui-btn-normal layui-btn-xs" style="color: #FFF;font-size: 12px;"><i class="layui-icon">&#xe615;</i>查看</a>&nbsp;
						<c:if test="${createrOrg eq healthEducationResourceRecord.orgCode  || createrOrg eq '_999'}">
						<%-- <a href="javascript:void(0);"  onclick="healthEducationResourceRecordEdit.editHealthEducationResourceRecord(${healthEducationResourceRecord.id})">修改</a> --%>
						<a href="javascript:void(0);"  onclick="healthEducationResourceRecordEdit.editHealthEducationResourceRecord(${healthEducationResourceRecord.id})" title="修改" class="layui-btn layui-btn-xs" style="color: #FFF;font-size: 12px;"><i class="layui-icon">&#xe642;</i>修改</a>
						<%-- <a href="javascript:void(0);"  onclick="healthEducationResourceRecordEdit.deletehealthEducationResourceRecord(${healthEducationResourceRecord.id})">删除</a> --%>
						<a href="javascript:void(0);"  onclick="healthEducationResourceRecordEdit.deletehealthEducationResourceRecord(${healthEducationResourceRecord.id})" title="删除" class="layui-btn layui-btn-danger layui-btn-xs" style="color: #FFF;font-size: 12px;"><i class="layui-icon">&#xe640;</i>删除</a>
						</c:if>
					</td>
				</tr>
			</c:forEach>
			<tr>
			<ehr:pagination action="healthEducationResourceRecordSearch.search" colspan="8"/>
			</tr>
		</tbody>
	</table>
	</c:if>
	<%-- <table>
		<tr>
			<ehr:pagination action="healthEducationResourceRecordSearch.search" />
		</tr>
	</table> --%>
</div>