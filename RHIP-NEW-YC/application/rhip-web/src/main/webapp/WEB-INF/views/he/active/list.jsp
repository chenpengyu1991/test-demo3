<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<div class="repeattable">
	<table class="layui-table x-admin-sm-table-list-middle">
		<colgroup>
			<col style="width: 15%;" />
			<col style="width: 13%;" />
			<col style="width: 11%;" />
			<col style="width: 11%;" />
			<col style="width: 15%;" />
			<col style="width: 10%;" />
			<col style="width: 25%;" />
		</colgroup>
		<thead>
			<tr>
				<th>
					${systemType eq '1' ?'组织培训机构':'机构名称' }
				</th>
				<th>${systemType eq '1' ?'培训':'活动' }类型</th>
				<th>活动主题</th>
				<th>活动地点</th>
				<th>	${systemType eq '1' ?'卫生专业':'接受健教人员类别' }
				</th>
				<th>活动时间</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="healthEducationActive" items="${healthEducationActives}">
				<tr>
					<td>
						<%--<c:if test="${empty orgCode && empty centerOrgCode && empty gbcode}">--%>
								<%--<ehr:tip><ehr:dic code="${healthEducationActive.gbcode}" dicmeta="FS990001"  /></ehr:tip>--%>
						<%--</c:if>--%>
						<%--<c:if test="${not empty orgCode || not empty centerOrgCode || not empty gbcode}">--%>
                            <%--<ehr:tip><ehr:org code="${healthEducationActive.orgCode}" /></ehr:tip>--%>
						<%--</c:if>--%>
                        <%--需求修改：不显示镇显示具体机构名称,如果是站则显示中心名称.2014-02-17--%>
                        <%--<c:if test="${healthEducationActive.orgCode eq healthEducationActive.centerOrgCode}">--%>
                            <%--<ehr:tip><ehr:org code="${healthEducationActive.orgCode}" /></ehr:tip>--%>
                        <%--</c:if>--%>
                        <%--<c:if test="${healthEducationActive.orgCode ne healthEducationActive.centerOrgCode}">--%>
                            <%--<ehr:tip><ehr:org code="${healthEducationActive.centerOrgCode}" /></ehr:tip>--%>
                        <%--</c:if>--%>
                        <%--需求修改：不显示镇显示具体机构名称.2014-03-10--%>
                        <ehr:tip><ehr:org code="${healthEducationActive.orgCode}" /></ehr:tip>
                        <c:if test="${healthEducationActive.gbcode eq '_999'}">
							<ehr:tip>健康教育所</ehr:tip>
						</c:if>
					</td>
					<td class="centertd">
						<c:if test="${healthEducationActive.activeType eq '99'}"><ehr:tip>${healthEducationActive.otherActiveType}</ehr:tip></c:if>
						<c:if test="${healthEducationActive.activeType ne '99'}"><ehr:tip> <ehr:dic dicmeta="HE00001" code="${healthEducationActive.activeType}" ></ehr:dic></ehr:tip></c:if>
					</td>
					<td class="centertd">
						<ehr:tip>${healthEducationActive.activeTheme}</ehr:tip>
					</td>
					<td>
						<ehr:tip>${healthEducationActive.activePlace}</ehr:tip>
					</td>
					<td><c:choose>
							<c:when test="${systemType eq '1'}">
								<ehr:tip>
									<ehr:dic dicmeta="HSA00006" code="${healthEducationActive.industryType}"></ehr:dic>
								</ehr:tip>
							</c:when>
							<c:otherwise>
								<c:if test="${healthEducationActive.educationPersonType eq '99'}">${healthEducationActive.otherPersonType}</c:if>
								<c:if test="${healthEducationActive.educationPersonType ne '99'}">
									<ehr:tip>
										<ehr:dic dicmeta="HE00002" code="${healthEducationActive.educationPersonType}"></ehr:dic>
									</ehr:tip>
								</c:if>
							</c:otherwise>
						</c:choose>
					</td>
					<td class="centertd">
						<ehr:tip><fmt:formatDate value="${healthEducationActive.activeTime}" pattern="yyyy/MM/dd"/></ehr:tip>
					</td>
					<td class="centertd">
						<%-- <a href="javascript:void(0);" class="view-link" data-system-type="${systemType}" data-id="${healthEducationActive.id}">查看</a> --%>
						<a href="javascript:void(0);" class="view-link layui-btn layui-btn-normal layui-btn-xs" data-system-type="${systemType}" data-id="${healthEducationActive.id}" title="查看" style="color: #FFF;font-size: 12px;"><i class="layui-icon">&#xe615;</i>查看</a>&nbsp;
						<c:if test="${createrOrg eq healthEducationActive.orgCode || createrOrg eq '_999'}">
							<%-- <a href="javascript:void(0);" class="edit-link" data-system-type="${systemType}"  data-id="${healthEducationActive.id}">修改</a> --%>
							<a href="javascript:void(0);" class="edit-link layui-btn layui-btn-xs" data-system-type="${systemType}"  data-id="${healthEducationActive.id}" title="修改" style="color: #FFF;font-size: 12px;"><i class="layui-icon">&#xe642;</i>修改</a>&nbsp;
							<%-- <a href="javascript:void(0);" class="delete-link" data-system-type="${systemType}"  data-id="${healthEducationActive.id}">删除</a> --%>
							<a href="javascript:void(0);" class="delete-link layui-btn layui-btn-danger layui-btn-xs" data-system-type="${systemType}"  data-id="${healthEducationActive.id}" title="删除" style="color: #FFF;font-size: 12px;"><i class="layui-icon">&#xe640;</i>刪除</a>
						</c:if>
					</td>
				</tr>
			</c:forEach>
		</tbody>
		<tr>
			<ehr:pagination action="healthEducationActiveSearch.search" colspan="7"/>
		</tr>
	</table>
	<%-- <table>
		<tr>
			<ehr:pagination action="healthEducationActiveSearch.search" />
		</tr>
	</table> --%>
</div>