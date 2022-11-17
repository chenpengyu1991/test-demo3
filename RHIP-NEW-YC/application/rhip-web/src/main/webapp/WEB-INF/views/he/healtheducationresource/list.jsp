<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>

<script src="${pageContext.request.contextPath}/js/views/he/healtheducationresource/detail.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/he/healtheducationresource/edit.js" type="text/javascript"></script>

<div class="repeattable">
	<c:if test="${type eq '1'}">
	<table class="layui-table x-admin-sm-table-list-middle">
		<colgroup>
			<col style="width: 20%;" />
			<col style="width: 15%;" />
			<col style="width: 10%;" />
			<col style="width: 10%;" />
			<col style="width: 10%;" />
			<col style="width: 15%;" />
			<col style="width: 20%;" />
		</colgroup>
		<thead>
			<tr>
				<th>机构名称</th>
				<th>器材名称</th>
				<th>数量</th>
				<th>规格型号</th>
				<th>价值</th>
				<th>时间</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="healthEducationResource" items="${healthEducationResources}">
				<tr>
					<td>
						<ehr:tip><ehr:org code="${healthEducationResource.orgCode}" /></ehr:tip>
						<%--<c:if test="${empty orgCode && empty centerOrgCode && empty gbcode}">
								<ehr:tip><ehr:dic code="${healthEducationResource.gbcode}" dicmeta="FS990001"  /></ehr:tip>
						</c:if>--%>
						<%--<c:if test="${not empty orgCode || not empty centerOrgCode || not empty gbcode}">
								<ehr:tip><ehr:org code="${healthEducationResource.orgCode}" /></ehr:tip>&lt;%&ndash;&lt;%&ndash;需求修改：不显示镇显示具体机构名称.2014-02-17&ndash;%&gt;&ndash;%&gt;
						</c:if>--%>
                                <%--需求修改：不显示镇显示具体机构名称,如果是站则显示中心名称.2014-02-17--%>
                            <%--<c:if test="${healthEducationResource.orgCode eq healthEducationResource.centerOrgCode}">
                                <ehr:tip><ehr:org code="${healthEducationResource.orgCode}" /></ehr:tip>
                            </c:if>
                            <c:if test="${healthEducationResource.orgCode ne healthEducationResource.centerOrgCode}">
                                <ehr:tip><ehr:org code="${healthEducationResource.centerOrgCode}" /></ehr:tip>
                            </c:if>
						<c:if test="${healthEducationResource.gbcode eq '_999'}"><ehr:tip>健康教育所</ehr:tip></c:if>--%>
					</td>
					<td>
						<c:if test="${healthEducationResource.deviceName ne '99'}">
						<ehr:tip><ehr:dic dicmeta="HE00006" code="${healthEducationResource.deviceName}"></ehr:dic></ehr:tip>
						</c:if>
						<c:if test="${healthEducationResource.deviceName eq '99'}"><ehr:tip>${healthEducationResource.otherDeviceName}</ehr:tip></c:if>
					</td>
					<td class="righttd">${healthEducationResource.resourcelQuantity}</td>
					<td>${healthEducationResource.specification}</td>
					<td class="righttd">${healthEducationResource.deviceCost}</td>
					<td class="centertd"><fmt:formatDate value="${healthEducationResource.resourceRecordTime}" pattern="yyyy-MM-dd"/></td>
					<td>
						<%-- <a href="javascript:void(0);"  onclick="healthEducationResourceDetail.viewHealthEducationResource(${healthEducationResource.id})">查看</a> --%>
						<a href="javascript:void(0);"  onclick="healthEducationResourceDetail.viewHealthEducationResource(${healthEducationResource.id})" title="查看" class="layui-btn layui-btn-normal layui-btn-xs" style="color: #FFF;font-size: 12px;" ><i class="layui-icon">&#xe615;</i>查看</a>
						<c:if test="${createrOrg eq healthEducationResource.orgCode  || createrOrg eq '_999'}">
						<%-- <a href="javascript:void(0);"  onclick="healthEducationResourceEdit.editHealthEducationResource(${healthEducationResource.id})">修改</a> --%>
						<a href="javascript:void(0);"  onclick="healthEducationResourceSearch.editHealthEducationResource(${healthEducationResource.id})" title="修改" class="layui-btn layui-btn-xs" style="color: #FFF;font-size: 12px;"><i class="layui-icon">&#xe642;</i>修改</a>
						<%-- <a href="javascript:void(0);"  onclick="healthEducationResourceEdit.deleteHealthEducationResource(${healthEducationResource.id})">删除</a> --%>
						<a href="javascript:void(0);"  onclick="healthEducationResourceSearch.deleteHealthEducationResource(${healthEducationResource.id})" title="删除" class="layui-btn layui-btn-danger layui-btn-xs" style="color: #FFF;font-size: 12px;"><i class="layui-icon">&#xe640;</i>删除</a>
						</c:if>
					</td>
				</tr>
			</c:forEach>
			<tr>
			 <ehr:pagination action="healthEducationResourceSearch.search" colspan="7"/>
		    </tr>
		</tbody>
	</table>
	</c:if>
	<c:if test="${type eq '2'}">
		<table class="layui-table x-admin-sm-table-list-middle">
		<colgroup>
			<col style="width: 20%;" />
			<col style="width: 10%;" />
			<col style="width: 10%;" />
			<col style="width: 10%;" />
			<col style="width: 10%;" />
			<col style="width: 10%;" />
			<col style="width: 10%;" />
            <col style="width: 20%;" />
		</colgroup>
		<thead>
			<tr>
				<th>机构名称</th>
				<th>宣传栏数</th>
				<th>黑板块数</th>
				<th>LED显示屏数</th>
				<th>阅报栏数</th>
				<th>资料架数</th>
                <th>年度</th>
                <th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="healthEducationResource" items="${healthEducationResources}">
				<tr>
					<td>
						<ehr:tip><ehr:org code="${healthEducationResource.orgCode}" /></ehr:tip>
						<%--<c:if test="${empty orgCode && empty centerOrgCode && empty gbcode}">
								<ehr:tip><ehr:dic code="${healthEducationResource.gbcode}" dicmeta="FS990001"  /></ehr:tip>
						</c:if>
						<c:if test="${not empty orgCode || not empty centerOrgCode || not empty gbcode}">
					    <ehr:tip><ehr:org code="${healthEducationResource.orgCode}" /></ehr:tip>&lt;%&ndash;&lt;%&ndash;需求修改：不显示镇显示具体机构名称.2014-02-17&ndash;%&gt;&ndash;%&gt;
                        </c:if>--%>
                                <%--需求修改：不显示镇显示具体机构名称,如果是站则显示中心名称.2014-02-17--%>
                            <%--<c:if test="${healthEducationResource.orgCode eq healthEducationResource.centerOrgCode}">
                                <ehr:tip><ehr:org code="${healthEducationResource.orgCode}" /></ehr:tip>
                            </c:if>
                            <c:if test="${healthEducationResource.orgCode ne healthEducationResource.centerOrgCode}">
                                <ehr:tip><ehr:org code="${healthEducationResource.centerOrgCode}" /></ehr:tip>
                            </c:if>
						<c:if test="${healthEducationResource.gbcode eq '_999'}"><ehr:tip>健康教育所</ehr:tip></c:if>--%>
					</td>
					<td class="righttd">${healthEducationResource.galleryQuantity}</td>
					<td class="righttd">${healthEducationResource.blackboardQuantity}</td>
					<td class="righttd">${healthEducationResource.ledQuantity}</td>
					<td class="righttd">${healthEducationResource.boardQuantity}</td>
                    <td class="righttd">${healthEducationResource.displayStandQuantity}</td>
                    <td class="centertd"><fmt:formatDate value="${healthEducationResource.resourceRecordTime}" pattern="yyyy"/></td>
					<td>
						<%-- <a href="javascript:void(0);"  onclick="healthEducationResourceDetail.viewHealthEducationResource(${healthEducationResource.id})">查看</a> --%>
						<a href="javascript:void(0);"  onclick="healthEducationResourceDetail.viewHealthEducationResource(${healthEducationResource.id})" title="查看" class="layui-btn layui-btn-normal layui-btn-xs" style="color: #FFF;font-size: 12px;"><i class="layui-icon">&#xe615;</i>查看</a>
						<c:if test="${createrOrg eq healthEducationResource.orgCode || createrOrg eq '_999'}">
						<%-- <a href="javascript:void(0);"  onclick="healthEducationResourceEdit.editHealthEducationResource(${healthEducationResource.id})">修改</a> --%>
						<a href="javascript:void(0);"  onclick="healthEducationResourceSearch.editHealthEducationResource(${healthEducationResource.id})" title="修改" class="layui-btn layui-btn-xs" style="color: #FFF;font-size: 12px;"><i class="layui-icon">&#xe642;</i>修改</a>
						<%-- <a href="javascript:void(0);"  onclick="healthEducationResourceEdit.deleteHealthEducationResource(${healthEducationResource.id})">删除</a> --%>
						<a href="javascript:void(0);"  onclick="healthEducationResourceSearch.deleteHealthEducationResource(${healthEducationResource.id})" title="删除" class="layui-btn layui-btn-danger layui-btn-xs" style="color: #FFF;font-size: 12px;"><i class="layui-icon">&#xe640;</i>删除</a>
						</c:if>
					</td>
				</tr>
			</c:forEach>
			<tr>
			 <ehr:pagination action="healthEducationResourceSearch.search" colspan="8"/>
		    </tr>
		</tbody>
	</table>
	</c:if>
	<c:if test="${type eq '3'}">
		<table class="layui-table x-admin-sm-table-list-middle">
		<colgroup>
			<col style="width: 20%;" />
			<col style="width: 15%;" />
			<col style="width: 15%;" />
			<col style="width: 15%;" />
			<col style="width: 15%;" />
			<col style="width: 20%;" />
		</colgroup>
		<thead>
			<tr>
				<th>机构名称</th>
				<th>宣传材料类型</th>
				<th>资料名称</th>
				<th>资料数量</th>
				<th>时间</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="healthEducationResource" items="${healthEducationResources}">
				<tr>
					<td>
						<ehr:tip><ehr:org code="${healthEducationResource.orgCode}" /></ehr:tip>
						<%--<c:if test="${empty orgCode && empty centerOrgCode && empty gbcode}">
								<ehr:tip><ehr:dic code="${healthEducationResource.gbcode}" dicmeta="FS990001"  /></ehr:tip>
						</c:if>--%>
						<%--<c:if test="${not empty orgCode || not empty centerOrgCode || not empty gbcode}">
								<ehr:tip><ehr:org code="${healthEducationResource.orgCode}" /></ehr:tip>&lt;%&ndash;&lt;%&ndash;需求修改：不显示镇显示具体机构名称.2014-02-17&ndash;%&gt;&ndash;%&gt;
						</c:if>--%>
                                <%--需求修改：不显示镇显示具体机构名称,如果是站则显示中心名称.2014-02-17--%>
                            <%--<c:if test="${healthEducationResource.orgCode eq healthEducationResource.centerOrgCode}">
                                <ehr:tip><ehr:org code="${healthEducationResource.orgCode}" /></ehr:tip>
                            </c:if>
                            <c:if test="${healthEducationResource.orgCode ne healthEducationResource.centerOrgCode}">
                                <ehr:tip><ehr:org code="${healthEducationResource.centerOrgCode}" /></ehr:tip>
                            </c:if>
						<c:if test="${healthEducationResource.gbcode eq '_999'}"><ehr:tip>健康教育所</ehr:tip></c:if>--%>
					</td>
					<td>
					<c:if test="${healthEducationResource.materialType eq '99'}"><ehr:tip>${healthEducationResource.otherMaterialName}</ehr:tip></c:if>
						<c:if test="${healthEducationResource.materialType ne '99'}"><ehr:tip> <ehr:dic dicmeta="HE00007" code="${healthEducationResource.materialType}" ></ehr:dic></ehr:tip></c:if>
					</td>
					<td>${healthEducationResource.materialName}</td>
					<td class="righttd">${healthEducationResource.resourcelQuantity}</td>
					<td class="centertd"><fmt:formatDate value="${healthEducationResource.resourceRecordTime}" pattern="yyyy-MM-dd"/></td>
					<td>
						<%-- <a href="javascript:void(0);"  onclick="healthEducationResourceDetail.viewHealthEducationResource(${healthEducationResource.id})">查看</a> --%>
						<a href="javascript:void(0);"  onclick="healthEducationResourceDetail.viewHealthEducationResource(${healthEducationResource.id})" title="查看" class="layui-btn layui-btn-normal layui-btn-xs" style="color: #FFF;font-size: 12px;"><i class="layui-icon">&#xe615;</i>查看</a>
						<c:if test="${createrOrg eq healthEducationResource.orgCode  || createrOrg eq '_999'}">
						<%-- <a href="javascript:void(0);"  onclick="healthEducationResourceEdit.editHealthEducationResource(${healthEducationResource.id})">修改</a> --%>
						<a href="javascript:void(0);"  onclick="healthEducationResourceSearch.editHealthEducationResource(${healthEducationResource.id})" title="修改" class="layui-btn layui-btn-xs" style="color: #FFF;font-size: 12px;"><i class="layui-icon">&#xe642;</i>修改</a>
						<%-- <a href="javascript:void(0);"  onclick="healthEducationResourceEdit.deleteHealthEducationResource(${healthEducationResource.id})">删除</a> --%>
						<a href="javascript:void(0);"  onclick="healthEducationResourceSearch.deleteHealthEducationResource(${healthEducationResource.id})" title="删除" class="layui-btn layui-btn-danger layui-btn-xs" style="color: #FFF;font-size: 12px;"><i class="layui-icon">&#xe640;</i>删除</a>
						</c:if>
					</td>
				</tr>
			</c:forEach>
			<tr>
			 <ehr:pagination action="healthEducationResourceSearch.search" colspan="6"/>
		    </tr>
		</tbody>
	</table>
	</c:if>
	<%-- <table>
		<tr>
			<ehr:pagination action="healthEducationResourceSearch.search" />
		</tr>
	</table> --%>
	<input type="hidden" id="actType" value="" />
</div>