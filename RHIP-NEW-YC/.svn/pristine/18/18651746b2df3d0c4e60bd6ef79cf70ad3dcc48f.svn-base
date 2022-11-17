<%@ page contentType="text/html;charset=UTF-8" language="java"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/views/hm/manage/tableSearch.js"></script>
<%--<script src="${pageContext.request.contextPath}/js/views/hm/verify/search.js" type="text/javascript"></script>--%>
	<div class="section"  id="hm-manage-list-box">
		<div class="toolbar">
			<%-- <ehr:authorize ifAnyGranted="02,03"><!-- 站、中心 -->
			<a href="javascript:void(0)" id="btnReflash"><b class="gengxin" id="btnReflashLabel">更新名单</b></a>
			</ehr:authorize>--%>
			<a href="javascript:void(0)" id="ehr-person-export-btn"><b class="export">导出</b></a> 
		</div>
	<div id="search">
		<%--<div class="toolbar"><b></b></div>--%>
		<div class="searchbox">
			<form id="searchForm">
				<table id="searchTable">
					<colgroup>
                        <col style="width: 8%; min-width: 70px;"/>
                        <col style="width: 16%; min-width: 180px;"/>
                        <col style="width: 8%; min-width: 70px;"/>
                        <col style="width: 20%; min-width: 140px;"/>
						<col style="width: 8%; min-width: 70px;"/>
						<col style="width: 22%; min-width: 200px;"/>
                        <col style="width: 10%"/>
					</colgroup>
					<tr>
						
						<td class="coltext">年&nbsp;&nbsp;&nbsp;&nbsp;份</td>
						<td class="colinput">
							<tag:dateInput id="inputExamYear" name="examYear" date="${currentYear}" pattern="yyyy"/>
						</td>
						<td class="coltext">体检日期</td>
                            <td class="colinput">
                                <tag:dateInput name="examinationDateStart" onlypast="true" style="width:35%;"/> ~
                                <tag:dateInput name="examinationDateEnd" onlypast="true" style="width:35%;"/>
                            </td>
						<%-- <td class="coltext">性&nbsp;&nbsp;&nbsp;&nbsp;别</td>
						<td class="colinput"><ehr:dic-list name="gender" dicmeta="GBT226112003" code="1,2"  /></td> --%>
						<td class="coltext">身份证号</td>
						<td class="colinput"><tag:idcardInput name="idcard" value="" /></td>
					</tr>
					<%-- <tr>
						<td class="coltext">体检编号</td>
						<td class="colinput"><input type="text" name="examNumber" /></td>
						<td class="coltext">身份证号</td>
						<td class="colinput"><tag:idcardInput name="idcard" value="" /></td>
						<td class="coltext">是否结案</td>
						<td class="colinput">
							<select name="logoff" >
								<option value="">请选择</option>
								<option value="0">否</option>
								<option value="1">是</option>
							</select>
						</td>
					</tr> --%>
					<!-- <tr>
						<td class="coltext">体检状态</td>
						<td class="colinput">
							<select name="examStatus" >
								<option value="">请选择</option>
								<option value="0">否</option>
								<option value="1">是</option>
							</select>
						</td>
						<td class="coltext">是否评估</td>
						<td class="colinput">
							<select name="estimateStatus" >
								<option value="">请选择</option>
								<option value="0">否</option>
								<option value="1">是</option>
							</select>
						</td>
						<td class="coltext">是否中医指导</td>
						<td class="colinput">
							<select name="healthGuideStatus" >
								<option value="">请选择</option>
								<option value="0">否</option>
								<option value="1">是</option>
							</select>
						</td>
					</tr> -->
					<tr>
						<!-- <td class="coltext">是否规范年检</td>
						<td class="colinput">
							<select name="criterionExamination" onchange="hmManageSearch.showStatus(this.value);">
								<option value="">请选择</option>
								<option value="0">否</option>
								<option value="1">是</option>
							</select>
						</td> -->
						
					</tr>
					<tr>
						<td class="coltext">姓&nbsp;&nbsp;&nbsp;&nbsp;名</td>
						<td class="colinput"><input type="text" name="name" value="" /></td>
						<td class="coltext">社&nbsp;&nbsp;&nbsp;&nbsp;区</td>
						<td class="colinput" colspan="4">
							<ehr:authorize ifAnyGranted="03">
								<ehr:dic-org-list name="inputOrganCode" isShowOneself="true" width="28.5%;"/>
							</ehr:authorize>
							<ehr:authorize ifAnyGranted="02">
								<ehr:dic-org-list id="inputOrganCode" name="inputOrganCode" width="28.5%;"/>
							</ehr:authorize>
							<ehr:authorize ifAnyGranted="01,11">
								<input type="hidden" id="selectCodeType" name="selectCodeType"/>
								<%--<tag:autoSelect name="organCode" id="organCode" style="width:170px" ></tag:autoSelect>--%>
								<ehr:dic-town-centre-station centreName="centerCode" stationName="stationCode"  townName="townCode" width="28.5%;" isShowOneself="true"/>
							</ehr:authorize>
							<ehr:authorize ifAnyGranted="04">
								<input type="hidden" id="selectCodeType" name="selectCodeType"/>
								<%--<tag:autoSelect name="organCode" id="organCode" style="width:170px" ></tag:autoSelect>--%>
								<ehr:dic-town-centre-station centreName="centerCode" stationName="stationCode"  townName="townCode" width="28.5%;" isShowOneself="true" includeTownCodes="${currentLoginInfo.organization.gbCode}"/>
							</ehr:authorize>
						</td>
						<%--<td colspan="2"></td>--%>
                        <td class="centertd">
							<input id="searchButton" type="button" name="" value="查询" class="search_btn"/>
						</td>
					</tr>
				</table>
				<table>
					<tr>
						<td class="colbottom">
							<span id="btnSearch" class="ico-bottom" onclick="hmManageSearch.toggle(this, 'searchTable')">&nbsp;</span>
						</td>
					</tr>
				</table>
			</form>
		</div>
	</div>
	<div id="reportListDiv"></div>
</div>
<div id="hm-manage-input-box"></div>