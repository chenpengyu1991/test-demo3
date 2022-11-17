<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tag"%>
<script src="${pageContext.request.contextPath}/js/views/hsa/family/list/list.js" type="text/javascript"></script>
<input type="hidden" id="hsa-insp-record-type" value="${type}">
<div class="section" id="hsa-record-familyList-box">
	<div class="toolbar">
		<a href="javascript:void(0)" id="hsa-inspRecord-family-add-btn"><b class="xinz">新增</b></a>
	</div>
	<div class="searchbox">
		<form method="post" id="hsa-record-familyList-form">
			<input type="hidden" id="selectFlagInput" name="selectFlagName" value="0" />
			<table id="reportSearch">
				<colgroup>
					<col width="10%;" />
					<col width="23%;" />
					<col width="10%;" />
					<col width="23%;" />
					<col width="10%;" />
					<col width="23%;" />
				</colgroup>
				<tr>
					<td class="coltext">户主姓名</td>
					<td class="colinput"><input type="text" name="householderName" style="width: 80%" /></td>
					<td class="coltext">家庭住址</td>
					<td class="colinput"><input type="text" name="familyAddress" style="width: 80%" /></td>
                    <td class="coltext">巡查日期</td>
                    <td class="colinput"><tag:dateInput nullToToday="true" name="startDate" pattern="yyyy/MM/dd" date="${currentYearStartDate}" onlypast="true" style="width: 36%;" id="hsa-startDate"></tag:dateInput> ~<tag:dateInput
                            nullToToday="true" name="endDate" pattern="yyyy/MM/dd" onlypast="true" style="width: 36%;" id="hsa-endDate"></tag:dateInput></td>


       		</tr>
                <tr>
				<ehr:authorize ifAnyGranted="01,28,32">
                    <c:set var ="isShowOrg" value="true" />
                </ehr:authorize>
						<td class="coltext">
                            <c:if test="${true==isShowOrg}">
                                巡查机构
                            </c:if>
							<ehr:authorize ifAnyGranted="04">
								巡查机构
							</ehr:authorize>
                        </td>
						<td colspan="3">
                            <c:if test="${true==isShowOrg}">
                                <ehr:dic-town-centre-station centreName="centerOrganCode" isShowOther="true" townName="gbcode" width="27.5%;" />
                            </c:if>
							<ehr:authorize ifAnyGranted="04">
								<ehr:dic-town-centre-station centreName="centerOrganCode" townName="gbcode" width="27.5%;" includeTownCodes="${currentLoginInfo.organization.gbCode}"/>
							</ehr:authorize>
                        </td>
                <td class="coltext"></td>
                <td class="colinput"><input type="button" id="hsa-inspRecord-familyList-search_btn" value="查询" class="search_btn" /></td>
                </tr>
            </table>
			<table>
				<tr>
					<td colspan="6" class="colbottom"><span onclick="hsaFamilyList.toggle(this,'reportSearch')" class="ico-bottom">&nbsp;</span></td>
				</tr>
			</table>
		</form>
	</div>
	<div id="hsa-record-family-result" class="repeattable"></div>
</div>
<div id="hsa-record-family-view-box" class="postdiv"></div>
