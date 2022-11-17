<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/views/sr/staffSearch.js"/>
<script type="text/javascript">
	$(function () {
		staffSearch1.atStart();
	});
</script>
<div class="section">
	<div id="search">
		<div class="searchbox">
			<form id="searchCondition">
				<table id="searchTable">
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
						<td class="coltext" style="width:100px">姓名</td>
						<td class="colinput"><input name="name" type="text" cssStyle="width: 150px"/>
						</td>
                        <td class="coltext" style="width:100px">身份证号</td>
                        <td class="colinput"><tag:idcardInput name="idCard" /></td>
						<td class="coltext" style="width:80px">性别</td>
						<td class="colinput">
                            <ehr:dic-list name="gender" dicmeta="GBT226112003" width="70px;"></ehr:dic-list>
							<%--<select path="gender" class="select" style="width:150">--%>
								<%--<option value="">请选择</option>--%>
								<%--<ehr:dicItems dicmeta="GBT226112003"/>--%>
							<%--</select>--%>
						</td>
					</tr>
					<tr>
						<td class="coltext" style="width:100px"><label class="required">所在机构</label> </td>
						<td class="colinput" colspan="4">
							<ehr:authorize ifAnyGranted="01">
								<ehr:dic-town-centre-station isShow="true" centreName="village" stationName="station" townName="town" isShowOther="true"  isShowInfirmary="true" 
								                             isShowHealthOversight="true"  townId="searchTown" centreId="searchCenter" stationId="searchStation" width="130px"/>
								<input id="searchOrganCode" name="organCode" type="hidden"/>
							</ehr:authorize>
							<ehr:authorize ifAnyGranted="03">
								<select id="searchOrganCode" name="organCode" style="width: 140px;">
									<option value="">请选择</option>
									<c:forEach var="org" items="${orgList}">
										<option value="${org.organCode}">${org.organName}</option>
									</c:forEach>
								</select>
							</ehr:authorize>
						</td>
						<td><input id="searchButton" type="button" value="查询" onclick="" class="search_btn"/></td>
					</tr>
					</tbody>
				</table>
			</form>
		</div>
	</div>
	<div id="staffList" class="listDiv">
		<div id="resultDiv"></div>
	</div>

    已选择
    <div class="repeattable" id="selectedStaff">
        <input type="hidden" id="html" value='${html}'>
        <table id="selectedStaffTable">
            <thead>
            <tr>
                <th width="30%" style="text-align: center">姓名</th>
                <th width="40%" style="text-align: center">身份证号码</th>
                <th width="30%" style="text-align: center">操作</th>
            </tr>
            </thead>
        </table>
        <table>
            <tr>
                <td style="text-align: center"><input type="button" value="确定" onclick="srEdit.selectStaffs()" class="search_btn"></td>
            </tr>
        </table>
    </div>
</div>