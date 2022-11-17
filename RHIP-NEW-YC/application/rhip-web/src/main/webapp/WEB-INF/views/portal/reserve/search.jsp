<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>

<script src="${pageContext.request.contextPath}/js/views/portal/reserve/search.js" type="text/javascript"></script>
<div class="section" id="mainSearchDiv">
	<div class="toolbar">
		<ehr:authorize ifAnyGranted="17,27">
			<a id="add" onclick="reserveSearch.add()"><b class="xinz">预约</b></a>
		</ehr:authorize>
	</div>
	<div class="searchbox">
		<form method="post" id="reserveSearch">
			<div class="searchbox" id="searchTable">
				<table>
					<colgroup>
						<col style="width: 10%;" />
						<col style="width: 23%;" />
						<col style="width: 10%;" />
						<col style="width: 23%;" />
						<col style="width: 10%;" />
						<col style="width: 23%;" />
					</colgroup>
					<tbody>
						<tr>
							<td class="coltext">姓名:</td>
							<td class="colinput"><input type="text" name="name"/></td>
							<td class="coltext">身份证:</td>
							<td class="colinput">
								<tag:idcardInput name="idcard" style="width:80%"></tag:idcardInput>
							</td>
							<td class="coltext">操作日期:</td>
							<td class="colinput">
								<tag:dateInput name="submitDateBegin" id="submitDateBegin" style="width:35%;" ></tag:dateInput>~
								<tag:dateInput name="submitDateEnd" id="submitDateEnd"  style="width:35%;"></tag:dateInput>
							</td>
						</tr>
						<tr>
							<td class="coltext">医生:</td>
							<td class="colinput"><input type="text" name="doctorName"/></td>
							<td class="coltext">时间:</td>
							<td class="colinput">
								<ehr:dic-list name="ampm" dicmeta="PORTAl_002"></ehr:dic-list>
							</td>
							<td class="coltext">状态:</td>
							<td class="colinput">
								<ehr:dic-list name="reserveStauts" dicmeta="PORTAl_001"></ehr:dic-list>
							</td>
						</tr>
						<tr>
							<td class="coltext">预约日期:</td>
							<td class="colinput">
								<tag:dateInput name="requestDateBegin" id="requestDateBegin" style="width:35%;"></tag:dateInput>~
								<tag:dateInput name="requestDateEnd" id="requestDateEnd" style="width:35%;"></tag:dateInput>
							</td>
							
							<ehr:authorize ifAnyGranted="01">
								<td class="coltext">医院:</td>
								<td class="colinput">
									<select name="hospital" id="hospitalSelect">
										<option value="">请选择</option>
										<c:forEach var="hospital" items="${organizationList}">
											<option value="${hospital.hospitalNo}">${hospital.hospitalName}</option>
										</c:forEach>
									</select>
								</td>
								<td class="coltext">
									挂号来源：
								</td>
								<td class="colinput">
									<ehr:dic-list name="regFrom" dicmeta="FS990005" width="100px;"></ehr:dic-list>
									<input id="reserveSearchBtn" class="search_btn" type="button" value="查询"/>
								</td>
							</ehr:authorize>
							
							<ehr:authorize ifAnyGranted="17,27,39">
								<td class="coltext">挂号来源：</td>
								<td class="colinput">
									<ehr:dic-list name="regFrom" dicmeta="FS990005"></ehr:dic-list>
									<input type="hidden" name="hospital" value="${currentLoginInfo.organization.organCode}"></input>
								</td>
								
								<td class="coltext">
								</td>
								<td class="colinput">
									<input id="reserveSearchBtn" class="search_btn" type="button" value="查询"/>
								</td>
							</ehr:authorize>
						</tr>
					</tbody>
				</table>
			</div>
			<table>
				<tr>
					<td colspan="6" class="colbottom"><span id="searchSpanId" class="ico-bottom">&nbsp;</span></td>
				</tr>
			</table>
		</form>
	</div>
	<div id="listDiv"></div>
</div>
<div id="addDiv"></div>


