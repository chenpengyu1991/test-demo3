<%@ page import="com.founder.rhip.ehr.common.RoleType" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tag"%>
<c:set var="JKWJ" value="<%=RoleType.JKWJ.getValue()%>"/>
<script src="${pageContext.request.contextPath}/js/views/hsa/inspRecord/list/locationList.js" type="text/javascript"></script>
<input type="hidden" id="hsa-insp-record-type" value="${type}">

<div class="section" id="hsa-record-locationList-box">
	<div class="toolbar">
		<ehr:authorize ifAnyGranted="0222,28">
			<a href="javascript:void(0)" id="hsa-inspRecord-addLocation-btn"><b class="xinz">新增地点</b></a>
		 </ehr:authorize>	
	</div>
	<div class="searchbox">
		<form method="post" id="form_search">
			<table id="hsa-recordLocation-recordSearchBox">
				<colgroup>
					<col style="min-width: 70px; width: 10%;" />
					<col style="min-width: 100px; width: 15%;" />
					<col style="min-width: 70px; width: 10%;" />
					<col style="min-width: 100px; width: 15%;" />
					<col style="min-width: 70px; width: 10%;" />
					<col style="min-width: 100px; width: 15%;" />
				</colgroup>
				<tbody>
					<tr >
						<td class="coltext">单位名称</td>
						<td class="colinput">
							 <input type="text" name="unitName">
						</td>
						<td class="coltext">联系人</td>
						<td class="colinput">
							 <input type="text" name="contact">
						</td>
						<td class="coltext">联系电话</td>
						<td class="colinput">
							 <input type="text" name="contactPhone">
						</td>
					</tr>
					<tr >
						<td class="coltext">身份证号</td>
						<td class="colinput">
							 <input type="text" name="idcard">
						</td>
						<td class="coltext">乡镇地段</td>
						<td><ehr:dic-list  name="townshipLotCode" dicmeta="HSA00005"  /> 
							<%-- <c:choose>
                                    <c:when test='${ROLE==JKWJ}'>
                                        <ehr:dic-town-village  townName="townshipLotCode"/>
                                    </c:when>
                                    <c:otherwise>
                                        <select  title="<ehr:dic dicmeta="FS990001" code="${townValue}"/>" name="townshipLotCode">
                                            <option title="<ehr:dic dicmeta="FS990001" code="${townValue}"/>" value="${townValue}"><ehr:dic dicmeta="FS990001" code="${townValue}"/></option>
                                        </select>
                                    </c:otherwise>
                                </c:choose> --%>
						
						</td>
						<td colspan="1">
						</td>
						<td align="left"><input type="button" id="hsa-inspRecord-locationList-search_btn" value="查询" class="search_btn" width="80"></td>
					</tr>
				</tbody>
			</table>
			<table>
				<tr>
					<td colspan="6" class="colbottom"><span onclick="hsaInspRecordLocationList.toggle(this,'hsa-recordLocation-recordSearchBox')" class="ico-bottom">&nbsp;</span>
					</td>
				</tr>
			</table>
		</form>
	</div>
	<div id="hsa-record-result-locationList" class="repeattable"></div>
</div>
<div id="hsa-record-location-input-add" class="postdiv"></div>
