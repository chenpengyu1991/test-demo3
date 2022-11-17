<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>

<script src="${pageContext.request.contextPath}/js/views/ehr/family/search.js" type="text/javascript"></script>

<c:forEach var="familydto" items="${familyRecords}" varStatus="status">
	<div class="sm_cnt " id="div${familydto.familyInfo.id}"
		<c:if test="${familydto.familyInfo.status==1||familydto.familyInfo.status==2}">class="disable"</c:if>>
		<%--   <div class="sm_cnt" onclick="familyList.selectFamily(${family.id})" id="sm_cnt${family.id}"> --%>
		<table width="100%" border="0"
			onclick="familySearch.selectFamily(${familydto.familyInfo.id})"
			name="cardTable" id="sm_cnt${familydto.familyInfo.id}">
			<tr>
				<td class="xh">${familydto.familyInfo.householderName}的家庭</td>
			</tr>
			<tr>
				<td
					<c:if test="${familydto.familyInfo.status==1||familydto.familyInfo.status==2}">class="disable"</c:if>>
					<fieldset class="layui-elem-field">
						<legend>家庭详细信息</legend>
						<table border="0" class="no-border">
							<tr
								<c:if test="${familydto.familyInfo.status==1||familydto.familyInfo.status==2}">class="disable"</c:if>>
								<th>户主：</th>
								<td title="${familydto.familyInfo.householderName}">${familydto.familyInfo.householderName}</td>
								<th>配偶：</th>
								<td>
									<div
										style="width: 50px; overflow: hidden; text-overflow: ellipsis; white-space: nowrap;"
										title="${familydto.mate}">${familydto.mate}</div>
								</td>
							</tr>
							<tr
								<c:if test="${familydto.familyInfo.status==1||familydto.familyInfo.status==2}">class="disable"</c:if>>
								<th>子：</th>
								<td>
									<div
										style="width: 50px; overflow: hidden; text-overflow: ellipsis; white-space: nowrap;"
										title="${familydto.son}">${familydto.son }</div>
								</td>
								<th>女：</th>
								<td>
									<div
										style="width: 50px; overflow: hidden; text-overflow: ellipsis; white-space: nowrap;"
										title="${familydto.daughter}">${familydto.daughter }</div>
								</td>
							</tr>
							<tr
								<c:if test="${familydto.familyInfo.status==1||familydto.familyInfo.status==2}">class="disable"</c:if>>
								<th>孙子女：</th>
								<td>
									<div
										style="width: 50px; overflow: hidden; text-overflow: ellipsis; white-space: nowrap;"
										title="${familydto.grandchildren}">
										${familydto.grandchildren }</div>
								</td>
								<th>&nbsp;</th>
								<td>&nbsp;</td>
							</tr>
						</table>
					</fieldset>
				</td>
			</tr>
			<tr>
				<td
					<c:if test="${familydto.familyInfo.status==1||familydto.familyInfo.status==2}">class="disable"</c:if>><fieldset class="layui-elem-field">
						<legend>家庭基本信息</legend>
						<table border="0" class="no-border">
							<tr
								<c:if test="${familydto.familyInfo.status==1||familydto.familyInfo.status==2}">class="disable"</c:if>>
								<th>饮用水：</th>
								<td>
									<div
										style="width: 60px; overflow: hidden; text-overflow: ellipsis; white-space: nowrap;"
										title=<ehr:dic dicmeta="CV0300115" code="${familydto.familyInfo.water}"/>>
										<ehr:dic dicmeta="CV0300115"
											code="${familydto.familyInfo.water}" />
									</div>

								</td>
								<th>户厕：</th>
								<td>
									<div
										style="width: 60px; overflow: hidden; text-overflow: ellipsis; white-space: nowrap;"
										title=<ehr:dic dicmeta="CV0300304" code="${familydto.familyInfo.hastoilet}"/>>
										<ehr:dic dicmeta="CV0300304"
											code="${familydto.familyInfo.hastoilet}" />
									</div>

								</td>
							</tr>
							<tr
								<c:if test="${familydto.familyInfo.status==1||familydto.familyInfo.status==2}">class="disable"</c:if>>
								<th>遗传病史：</th>
								<td></td>
								<th></th>
								<td></td>
							</tr>
						</table>
					</fieldset></td>
			</tr>
			<tr>
				<td
					<c:if test="${familydto.familyInfo.status==1||familydto.familyInfo.status==2}">class="disable"</c:if>><fieldset class="layui-elem-field">
						<legend>家庭慢病信息</legend>
						<table border="0" class="no-border">
							<tr
								<c:if test="${familydto.familyInfo.status==1||familydto.familyInfo.status==2}">class="disable"</c:if>>
								<th></th>
								<td></td>
								<th></th>
								<td></td>
							</tr>
						</table>
					</fieldset></td>
			</tr>
		</table>
	</div>
</c:forEach>
<table>
	<tr>
		<ehr:authorize ifAnyGranted="01,03,11">
			<ehr:pagination action="familySearch.searchOther" colspan="10" />
		</ehr:authorize>
		<ehr:authorize ifAnyGranted="02">
			<ehr:pagination action="familySearch.searchSQ" colspan="10" />
		</ehr:authorize>
	</tr>
</table>