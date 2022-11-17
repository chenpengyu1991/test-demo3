<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<link href="${pageContext.request.contextPath}/css/views/ehrbrowser/familyRecord/family.css" type="text/css"  rel="stylesheet" />
<script src="${pageContext.request.contextPath}/js/views/ehr/family/search.js" type="text/javascript"></script>
<%@ page import="com.founder.rhip.ehr.common.RoleType" %>
<c:set var="ADMIN" value="<%=RoleType.ADMIN.getValue()%>"/>
<c:set var="QWGZX" value="<%=RoleType.QWGZX.getValue()%>"/>
<c:set var="Z_GLY" value="<%=RoleType.Z_GLY.getValue()%>"/>
<c:set var="JKJKDN" value="<%=RoleType.JKJKDN.getValue()%>"/>
<c:set var="JKMBK" value="<%=RoleType.JKMBK.getValue()%>"/>
<c:set var="ZXJKDN" value="<%=RoleType.ZXJKDN.getValue()%>"/>
<c:set var="ZJKDN" value="<%=RoleType.ZJKDN.getValue()%>"/>

<div class="repeattable">
	<table class="layui-table x-admin-sm-table-list-middle">
		<colgroup>
			<col width="9%" />
			<col width="3%" />
			<col width="9%" />
			<col width="9%" />
			<col width="9%" />
			<col width="9%" />
			<col width="9%" />
<%-- 			<col width="10%" /> --%>
<%-- 			<col width="10%" /> --%>
			<col width="9%" />
			<col width="7%" />
			<col width="9%" />
			<ehr:authorize ifAnyGranted="${ADMIN},${JKJKDN},${QWGZX},${ZJKDN},${Z_GLY}">
				<col width="18%" />
			</ehr:authorize>
		</colgroup>
		<thead>
			<tr>
				<th>家庭</th>
				<th>成员数</th>
				<th>户主</th>
				<th>配偶</th>
				<th>子</th>
				<th>女</th>
				<th>孙子女</th>
<!-- 				<th>饮用水类型</th> -->
<!-- 				<th>户厕类型</th> -->
				<th>遗传疾病史</th>
				<th>主要健康问题</th>
				<th>状态</th>
				<ehr:authorize ifAnyGranted="${ADMIN},${JKJKDN},${QWGZX},${ZJKDN},${Z_GLY},${ZXJKDN}">
					<th>操作</th>
				</ehr:authorize>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="familydto" items="${familyRecords}"
				varStatus="status">
				<tr onclick="familySearch.selectFamily(${familydto.familyInfo.id},${familydto.familyInfo.status})"
					id="tr${familydto.familyInfo.id}"
					<c:if test="${familydto.familyInfo.status==1||familydto.familyInfo.status==2}">class="disable"</c:if>>
					<td title="${familydto.familyInfo.householderName}的家庭">${familydto.familyInfo.householderName}的家庭
					</td>
					<td class="righttd"><c:if test="${familydto.familyInfo.familyMemberList.size() ==0}">1</c:if>

					<c:if test="${familydto.familyInfo.familyMemberList.size() >0}">${familydto.familyInfo.familyMemberList.size()}</c:if> </td>
					<td class="centertd" title="${familydto.familyInfo.householderName}">${familydto.familyInfo.householderName}</td>
					<td class="centertd" title="${familydto.mate}">${familydto.mate}</td>
					<td class="centertd" title="${familydto.son}">${familydto.son }</td>
					<td class="centertd" title="${familydto.daughter}">${familydto.daughter }</td>
					<td class="centertd" title="${familydto.grandchildren}">
						${familydto.grandchildren }</td>
<!-- 					<td -->
<%-- 						title=<ehr:dic dicmeta="CV0300115" code="${familydto.familyInfo.water}"/>> --%>
<%-- 						<ehr:dic dicmeta="CV0300115" code="${familydto.familyInfo.water}" /> --%>
<!-- 					</td> -->
<!-- 					<td -->
<%-- 						title=<ehr:dic dicmeta="CV0300304" code="${familydto.familyInfo.hastoilet}"/>> --%>
<%-- 						<ehr:dic dicmeta="CV0300304" --%>
<%-- 							code="${familydto.familyInfo.hastoilet}" /> --%>
<!-- 					</td> -->
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td class="centertd" id="tdStatus${familydto.familyInfo.id}"><input
						type="hidden" id="status${familydto.familyInfo.id}"
						value="${familydto.familyInfo.status}" />
						<p id="pIndex${familydto.familyInfo.id}">
							<c:choose>
								<c:when test="${familydto.familyInfo.status==0}"> 已建档</c:when>
								<%--<c:when test="${familydto.familyInfo.status==1}"> 审核中</c:when>--%>
								<c:when test="${familydto.familyInfo.status==2}"> 已结案</c:when>
								<c:when test="${familydto.familyInfo.status==3}"> 已退回</c:when>
							</c:choose>
						</p>
					</td>
					<ehr:authorize ifAnyGranted="${ADMIN},${JKJKDN},${QWGZX}">
						<td class="centertd">
							<%-- <a class="familyLookUp" href="#">查看</a> --%>
							<a class="familyLookUp layui-btn layui-btn-normal layui-btn-xs" href="#" title="查看" style="color: #FFF;"><i class="layui-icon" >&#xe615;</i>查询</a>
						</td>
					</ehr:authorize>
					<ehr:authorize ifAnyGranted="${ZXJKDN},${Z_GLY},${ZJKDN}">
                        <td class="centertd">
                            <%--<a class="familyLookUp" href="#">查看</a>--%>
                            <%--<a class="familyLookUp layui-btn layui-btn-normal layui-btn-xs" href="#" title="查看" style="color: #FFF;"><i class="layui-icon" >&#xe615;</i></a>--%>
							<button class="familyLookUp layui-btn layui-btn-normal layui-btn-xs"><i class="layui-icon">&#xe615;</i>查询</button>
							<%--<a class="familyUpdate" href="#">修改</a>--%>
                            <%--<a class="familyUpdate layui-btn layui-btn-xs" href="#" title="修改" style="color: #FFF;"><i class="layui-icon" >&#xe642;</i></a>--%>
							<button class="familyUpdate layui-btn layui-btn-xs"><i class="layui-icon">&#xe642;</i>修改</button>
							<c:choose>
                                <c:when test="${familydto.familyInfo.status==1 or familydto.familyInfo.status==3}">
                                	<%--<a class="familyOffBack" href="#">撤销</a>--%>
                                    <%--<a class="familyOffBack layui-btn layui-btn-warm layui-btn-xs" href="#" title="撤销" style="color: #FFF;"><i class="layui-icon">&#xe65c;</i></a>--%>
									<button class="familyUpdate layui-btn layui-btn-warm layui-btn-xs"><i class="layui-icon">&#xe65c;</i>撤销</button>
								</c:when>
                                <c:otherwise>
									<%--<a class="familyOff" href="#">结案</a>--%>
									<%--<a class="familyOff layui-btn layui-btn-danger layui-btn-xs" href="#" title="结案" style="color: #FFF;"><i class="layui-icon">&#x1006;</i></a>--%>
									<button class="familyOff layui-btn layui-btn-danger layui-btn-xs"><i class="layui-icon">&#x1006;</i>结案</button>
								</c:otherwise>
                            </c:choose>
						</td>
					</ehr:authorize>
				</tr>
			</c:forEach>
		</tbody>
		<tr>
			<ehr:pagination action="familySearch.searchOther" colspan="11" />
		</tr>
	</table>
</div>
<%-- <table>
	<tr>
		<ehr:authorize ifAnyGranted="${ADMIN},${ZXJKDN},${JKMBK},${QWGZX}">
			<ehr:pagination action="familySearch.searchOther" colspan="10" />
		</ehr:authorize>
		<ehr:authorize ifAnyGranted="${ZJKDN}">
			<ehr:pagination action="familySearch.searchSQ" colspan="10" />
		</ehr:authorize>
	</tr>
</table> --%>