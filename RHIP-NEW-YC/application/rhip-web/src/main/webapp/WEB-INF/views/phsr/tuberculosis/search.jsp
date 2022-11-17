<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>

<script src="${pageContext.request.contextPath}/js/views/phsr/tuberculosis/search.js" type="text/javascript"></script>

<div class="section">
		<ehr:authorize ifAnyGranted="02,03">
		<div class="toolbar">
       <span id="modifyCommunityIdSpan">
            <a href="javascript:void(0)" id="modifyCommunityId" ><b class="xiug">修改</b></a>
        </span>
        <span id="cancelCommunityIdSpan">
            <a href="javascript:void(0)" id="cancelCommunityId" ><b class="quxiao">取消</b></a>
            <a href="javascript:void(0)" id="saveCommunityId" ><b class="baocun">保存</b></a>
        </span>
    </div></ehr:authorize>
		<div class="searchBox">
			<input type="hidden" name="timeFlag" value="1"/>
			<form id="tuberculosisSearchForm">
				<table id="tuberculosisSearch">
					<colgroup>
						<col style="width: 50px;" />
						<col style="width: 80px;" />
						<col style="width: 50px;" />
						<col style="width: 60px;" />
						<col style="width: 50px;" />
						<col style="width: 200px;" />
					</colgroup>
					<tbody>
						<tr>
							<td class="col-text"><label>时间范围</label></td>
							<td class="col-input" colspan="3">
								<input type="radio" id="mhmReprtYearId" name="countType"  class="radioGroup" value="1" checked="checked" onclick="tuberculosisSearch.changeReportType()"/><label for="mhmReprtYearId">按年</label>
                       		 	<input type="radio" id="mhmReprtQuarterId" name="countType"  class="radioGroup" value="2" onclick="tuberculosisSearch.changeReportType()"/><label for="mhmReprtQuarterId">按季度</label>
								<tag:dateInput name="year" id="year"  onlypast="true" style="width:120px;"  date="${currentYear}"  pattern="yyyy" reg='{"required":"true"}'/>
								<select name="month" id="month" style="width:120px;display: none;">
									<option value="">请选择</option>
									<option value="01"  >第一季度</option>
									<option value="02"  >第二季度</option>
									<option value="03"  >第三季度</option>
									<option value="04" >第四季度</option>
								</select>						
							</td>
							</tr>
							<tr>
                             <td class="col-text">机构</td>
							<td class="col-input" colspan="4"> 
								<ehr:authorize ifAnyGranted="01,12">
									<ehr:dic-town-centre-station centreName="centerOrgCode" stationName="orgCode" townName="gbcode" width="130px;" isShowOneself="true" />
								</ehr:authorize>
								<ehr:authorize ifAnyGranted="04">
									<ehr:dic-town-centre-station centreName="centerOrgCode" stationName="orgCode" townName="gbcode" width="130px;" isShowOneself="true" includeTownCodes="${currentLoginInfo.organization.gbCode}"/>
								</ehr:authorize>
								<ehr:authorize ifAnyGranted="02,03">
								<ehr:dic-org-list name="orgCode" width="150px" isShowOneself="true"/>
								</ehr:authorize>
							</td>
							
                            <td style="text-align: right;"><input type="button" id="tuberculosisBtnSearch" value="查询"
								 class="search_btn" /></td>
						</tr>
					</tbody>
				</table>
				<table>
					<tr>
						<td colspan="4" class="col-bottom"><span
							onclick="tuberculosisSearch.toggle(this,'tuberculosisSearch')"
							class="ico-bottom">&nbsp;</span></td>
					</tr>
				</table>
			</form>
		</div>
		<form   id="communityInfoForm">
		<div id="tuberculosisResultDiv">
		<jsp:include page="list.jsp"/>
		</div></form>
</div>